package compiler.exceptions;

import org.antlr.v4.runtime.Token;

public class ValueIsNoArrayException extends UnderlineCompileException {
    static final long serialVersionUID = 11;
    private String varName;

    public ValueIsNoArrayException(Token token) {
        super(token);
        this.varName = token.getText();
    }

    @Override
    public String getMessage() {
        String errMessage = stdMsg(String.
                format("Value is not an array <%s>", varName));
        return errMessage + 
            getUnderlineMessage();
    }
}
