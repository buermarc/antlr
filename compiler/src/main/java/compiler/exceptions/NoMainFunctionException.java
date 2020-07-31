package compiler.exceptions;

import org.antlr.v4.runtime.Token;

public class NoMainFunctionException extends RuntimeException {
    static final long serialVersionUID = 20;

    @Override 
    public String getMessage() {
        return "Given programm file appears to have no main function";
    }
}
