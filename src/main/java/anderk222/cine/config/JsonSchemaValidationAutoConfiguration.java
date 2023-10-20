package anderk222.cine.config;

import com.fasterxml.jackson.databind.ObjectMapper;

import anderk222.cine.validation.advice.JsonValidationRequestBodyControllerAdvice;
import anderk222.cine.validation.provider.DefaultJsonSchemaProvider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JsonSchemaValidationAutoConfiguration {

    @Autowired
    private DefaultJsonSchemaProvider jsonSchemaProvider;

    @Bean
    @ConditionalOnMissingBean
    public JsonValidationRequestBodyControllerAdvice jsonValidationRequestBodyControllerAdvice(ObjectMapper objectMapper) {
        return new JsonValidationRequestBodyControllerAdvice(objectMapper, jsonSchemaProvider);
    }

}