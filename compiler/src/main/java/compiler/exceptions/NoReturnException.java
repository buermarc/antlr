package compiler.exceptions;

import org.antlr.v4.runtime.Token;

public class NoReturnException extends UnderlineCompileException {
    static final long serialVersionUID = 7;
    private String functionName;

    public NoReturnException(Token token) {
        super(token);
        this.functionName = token.getText();
    }

    @Override
    public String getMessage() {
        String errMessage = stdMsg(String.
                format("No return statement in function <%s>", functionName));
        return errMessage + 
            getUnderlineMessage();
    }
}
