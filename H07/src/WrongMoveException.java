/**
 * Wird geworfen, wenn ein ungueltiger Zug ausgefuehrt wird.
 */
public class WrongMoveException extends RuntimeException{

    public WrongMoveException(String s){
        super(s);
    }
}


