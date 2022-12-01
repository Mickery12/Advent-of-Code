/**
 * Exception, die fuer den Fall einer nicht erlaubten Position genutzt wird.
 */
public class WrongPositionException extends RuntimeException {

    public WrongPositionException(String msg) {
        super(msg);
    }

}
