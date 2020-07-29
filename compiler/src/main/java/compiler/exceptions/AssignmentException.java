package compiler.exceptions;

import org.antlr.v4.runtime.Token;

public class AssignmentException extends UnderlineCompileException {
    static final long serialVersionUID = 3;
    private String leftType;
    private String rightType;

    public AssignmentException(String leftType, String righType, Token token) {
        super(token);
        this.leftType = leftType;
        this.rightType = righType;
    }

    @Override
    public String getMessage() {
        String errMessage = stdMsg(String
                .format("Tried to assign %s to %s", leftType, rightType));
        return errMessage + 
            getUnderlineMessage();
    }
}
