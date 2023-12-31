package anderk222.cine.exception;

import com.networknt.schema.ValidationMessage;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collection;
import java.util.stream.Collectors;

public class JsonSchemaValidationException extends ResponseStatusException {

    private final Collection<ValidationMessage> validationMessages;

    public JsonSchemaValidationException(Collection<ValidationMessage> validationMessages) {
        super(HttpStatus.BAD_REQUEST, buildMessage(validationMessages));
        this.validationMessages = validationMessages;
    }

    public static String buildMessage(Collection<ValidationMessage> validationMessages) {
        final String prefix = "";
        return prefix + validationMessages
                .stream()
                .map(ValidationMessage::toString)
                .collect(Collectors.joining(", "));
    }

    public Collection<ValidationMessage> getValidationMessages() {
        return this.validationMessages;
    }

    @Override
    public String toString() {
        return "JsonSchemaValidationException{" +
                "validationMessages=" + validationMessages +
                '}';
    }
}