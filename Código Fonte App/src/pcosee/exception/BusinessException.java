package pcosee.exception;

public class BusinessException extends Exception {

    private static final long serialVersionUID = 1149241039409861914L;
    private String origem;

    public BusinessException(String msg) {
        super(msg);
    }

    public BusinessException(String msg, Throwable causa) {
        super(msg, causa);
    }

    public BusinessException(Throwable causa) {
        super(causa);
    }

    public String getOrigem() {
        return origem;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }
    
}
