package compiler.exceptions;

public class ParserException extends RuntimeException {
    static final long serialVersionUID = 5;

    public ParserException(String msg) {
        super(msg);
    }
}
