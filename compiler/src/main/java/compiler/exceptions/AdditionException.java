package compiler.exceptions;

import org.antlr.v4.runtime.Token;

public class AdditionException extends UnderlineCompileException {
    static final long serialVersionUID = 3;
    private String leftType;
    private String rightType;

    public AdditionException(String leftType, String righType, Token token) {
        super(token);
        this.leftType = leftType;
        this.rightType = righType;
    }

    @Override
    public String getMessage() {
        String errMessage = stdMsg(String
                .format("Tried to add %s to %s",
                    rightType, leftType));
        return errMessage + 
            getUnderlineMessage();
    }
}
