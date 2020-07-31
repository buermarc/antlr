package compiler.exceptions;

import org.antlr.v4.runtime.Token;

public class ArrayOutOfBoundsException extends UnderlineCompileException {
    static final long serialVersionUID = 11;
    private String varName;

    public ArrayOutOfBoundsException(Token token) {
        super(token);
        this.varName = token.getText();
    }

    @Override
    public String getMessage() {
        String errMessage = stdMsg(String.
                format("Array index is out of bounds <%s>", varName));
        return errMessage + 
            getUnderlineMessage();
    }
}
