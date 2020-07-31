package compiler.exceptions;

import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenSource;

public class UnderlineCompileException extends CompileException {
    static final long serialVersionUID = 2;
    private int startIndex;
    private int stopIndex;
    private int charPositionInLine;
    private TokenSource tokens;

    public UnderlineCompileException(Token varToken) {
        super(varToken);
        this.startIndex = varToken.getStartIndex();
        this.stopIndex = varToken.getStopIndex();
        this.charPositionInLine = varToken.getCharPositionInLine();
        this.tokens = varToken.getTokenSource();
    } 

    public String stdMsg(String msg) {
        return "\n" + line + ":" + column + " " + msg + "\n";
    }

    public String getUnderlineMessage() {
        String errMessage = "";

        String input = tokens.getInputStream().toString(); 
        String[] lines = input.split("\n");
        String errorLine = ">"+lines[line - 1];
        errMessage += errorLine+"\n";
        
        String underline = "";
        for (int i = 0; i <= charPositionInLine; ++i)
            underline += " ";

        if (startIndex >= 0 && stopIndex >= 0) {
            for (int i = startIndex; i <= stopIndex; ++i)
                underline += "^";
        }

        errMessage += underline;
    return errMessage;
    }
}
