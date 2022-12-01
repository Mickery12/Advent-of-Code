/**
 * Exception, die fuer den Fall eines nicht erlaubten Zuges genutzt wird.
 */
public class WrongMoveException extends RuntimeException {

    public WrongMoveException(String msg) {
        super(msg);
    }

}
