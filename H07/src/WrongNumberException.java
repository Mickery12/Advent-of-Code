/**
 * Wird geworfen, wenn eine falsche Nummer abgefragt wird.
 */
public class WrongNumberException extends RuntimeException{
    
    public WrongNumberException(String s){
        super(s);
    }
}
