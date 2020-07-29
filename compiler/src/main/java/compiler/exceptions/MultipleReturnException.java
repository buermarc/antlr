package compiler.exceptions;

import org.antlr.v4.runtime.Token;

public class MultipleReturnException extends UnderlineCompileException {
    static final long serialVersionUID = 9;

    public MultipleReturnException(Token token) {
        super(token);
    }

    @Override
    public String getMessage() {
        String errMessage = stdMsg("Multiple return statements");
        return errMessage + 
            getUnderlineMessage();
    }
}
