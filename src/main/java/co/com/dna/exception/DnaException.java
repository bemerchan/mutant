package co.com.dna.exception;

public class DnaException extends Exception {

    private static final long serialVersionUID = 7718828512143293558L;

    private final String exceptionMessage;

    public DnaException(String exceptionMessage) {
        super(exceptionMessage);
        this.exceptionMessage = exceptionMessage;
    }
}
