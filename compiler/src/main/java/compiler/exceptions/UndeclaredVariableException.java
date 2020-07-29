package compiler.exceptions;

import org.antlr.v4.runtime.Token;

public class UndeclaredVariableException extends UnderlineCompileException {
    static final long serialVersionUID = 1;
    private String varName;

    public UndeclaredVariableException(Token varToken) {
        super(varToken);
        this.varName = varToken.getText();
    }

    @Override
    public String getMessage() {
        String errMessage = stdMsg("undeclared variable <" + varName + ">:");

        return errMessage + 
            getUnderlineMessage();

    }

}
