package anderk222.cine.exception;

public class InvalidCredentialsException extends RuntimeException {
 
    
    public InvalidCredentialsException(){

        super("username or password are incorrect");
    }

}