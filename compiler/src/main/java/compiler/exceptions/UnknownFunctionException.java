package compiler.exceptions;

import org.antlr.v4.runtime.Token;

public class UnknownFunctionException extends UnderlineCompileException {
    static final long serialVersionUID = 3;
    private String functionName;

    public UnknownFunctionException(Token token) {
        super(token);
        this.functionName = token.getText();
    }

    @Override
    public String getMessage() {
        String errMessage = stdMsg(String
                .format("Unknown Function %s called", functionName));
        return errMessage + 
            getUnderlineMessage();
    }
}
