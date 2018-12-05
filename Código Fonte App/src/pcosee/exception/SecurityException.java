package pcosee.exception;

public class SecurityException extends Exception {

    private static final long serialVersionUID = 1149241039409861914L;

    public SecurityException(String msg) {
        super(msg);
    }

    public SecurityException(String msg, Throwable causa) {
        super(msg, causa);
    }

    public SecurityException(Throwable causa) {
        super(causa);
    }

}
