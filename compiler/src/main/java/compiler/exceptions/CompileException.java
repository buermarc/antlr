package compiler.exceptions;

import org.antlr.v4.runtime.Token;

public class CompileException extends RuntimeException {
    static final long serialVersionUID = 0;

    protected int line;
    protected int column;

    public CompileException(Token token) {
        line = token.getLine();
        column = token.getCharPositionInLine();
    }
}
