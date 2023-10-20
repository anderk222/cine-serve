package anderk222.cine.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;

import anderk222.cine.dto.Response;
import anderk222.cine.dto.ResponseEnum;

@ControllerAdvice
public class ExceptionsHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Response> handleResourceNotFound(ResourceNotFoundException ex) {

        ex.printStackTrace();

        return ResponseEntity.ok(Response.resEnum(ResponseEnum.NOT_FOUND));

    }

    @ExceptionHandler(NoHandlerFoundException.class)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public ResponseEntity<Response> handleNoHandlerFoundException(NoHandlerFoundException ex) {

        ex.printStackTrace();

        return ResponseEntity.ok(Response.resEnum(ResponseEnum.NOT_FOUND));

    }

    @ExceptionHandler(JsonSchemaValidationException.class)
    public ResponseEntity<Response> handleJsonSchemaValidationException(JsonSchemaValidationException ex) {

        Response response = Response.resEnum(ResponseEnum.BAD_REQUEST).msgUsuario(ex.getReason());

        ex.printStackTrace();

        return ResponseEntity.ok(response);

    }

    @ExceptionHandler(ActivedSessionsExcededException.class)
    public ResponseEntity<Response> handleActivedSessionsExceded(ActivedSessionsExcededException ex) {

        ex.printStackTrace();

        return ResponseEntity.ok(Response.resEnum(ResponseEnum.SESSIONS_EXCEDED));

    }

    @ExceptionHandler(InvalidCredentialsException.class)
    public ResponseEntity<Response> handleInvalidCredentials(InvalidCredentialsException ex) {

        ex.printStackTrace();

        return ResponseEntity.ok(Response.resEnum(ResponseEnum.ERROR_LOGIN));

    }

    @ExceptionHandler(NoAuthorizedException.class)
    public ResponseEntity<Response> handleNoAuthorizedException(NoAuthorizedException ex) {

        ex.printStackTrace();

        return ResponseEntity.ok(Response.resEnum(ResponseEnum.NO_AUTHORIZED));

    }

    @ExceptionHandler(AuthAttempsExceededException.class)
    public ResponseEntity<Response> handleAttempsExceeded(AuthAttempsExceededException ex) {

        ex.printStackTrace();

        return ResponseEntity.ok(Response.resEnum(ResponseEnum.ACCOUNT_BLOCKED));

    }

    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(code = HttpStatus.OK)
    public ResponseEntity<Response> handleRuntimeException(RuntimeException ex) {

        ex.printStackTrace();

        return ResponseEntity.ok(Response.resEnum(ResponseEnum.INTERNAL_ERROR));

    }

}