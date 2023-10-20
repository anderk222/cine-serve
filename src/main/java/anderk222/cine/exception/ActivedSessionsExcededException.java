package anderk222.cine.exception;


public class ActivedSessionsExcededException extends RuntimeException {
    
    public ActivedSessionsExcededException(long userId){
        super("user with id "+userId+" ha excedido el numero de sessiones permitidas");
    }

}