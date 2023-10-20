package anderk222.cine.validation.provider;

import com.networknt.schema.JsonSchema;
import com.networknt.schema.ValidationMessage;

import java.util.Collection;

public interface JsonSchemaProvider {

    JsonSchema loadSchema(String url);

    void handleValidationMessages(Collection<ValidationMessage> validationMessages);

}
