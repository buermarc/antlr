package compiler.exceptions;

import org.antlr.v4.runtime.Token;

public class NotMutableException extends UnderlineCompileException {
    static final long serialVersionUID = 12;
    private String varName;

    public NotMutableException(Token token) {
        super(token);
        this.varName = token.getText();
    }

    @Override
    public String getMessage() {
        String errMessage = stdMsg(String.
                format("Variable is not mutable <%s>", varName));
        return errMessage + 
            getUnderlineMessage();
    }
}
