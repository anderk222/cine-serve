package anderk222.cine.exception;

public class NoAuthorizedException extends RuntimeException {
    
    public NoAuthorizedException(){

        super("token invalido");

    }

}
