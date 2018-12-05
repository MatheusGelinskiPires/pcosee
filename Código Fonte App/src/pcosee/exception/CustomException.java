package pcosee.exception;

public class CustomException extends Exception {

    private static final long serialVersionUID = 1149241039409861914L;
    private String origem;

    public CustomException(String msg) {
        super(msg);
    }

    public CustomException(String msg, Throwable causa) {
        super(msg, causa);
    }

    public CustomException(Throwable causa) {
        super(causa);
    }

    public String getOrigem() {
        return origem;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }
    
}
