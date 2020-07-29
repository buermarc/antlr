package compiler;

import java.util.List;
import java.util.Collections;

import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;
import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.Token;

import compiler.exceptions.ParserException;

public class VerboseListener extends BaseErrorListener {

    @Override
    public void syntaxError(Recognizer<?, ?> recognizer,
                            Object offendingSymbol,
                            int line, int charPositionInLine,
                            String msg,
                            RecognitionException e)
    {
        List<String> stack = ((Parser)recognizer).getRuleInvocationStack();
        Collections.reverse(stack);
        String errMessage = stack.toString()+"\n";
        errMessage += line+":"+charPositionInLine+" "+msg+"\n";
        errMessage += underlineError(recognizer, (Token)offendingSymbol,
                       line, charPositionInLine);

        throw new ParserException(errMessage);
    }
    protected String underlineError(Recognizer<?, ?> recognizer,
                                  Token offendingToken, int line,
                                  int charPositionInLine) {

        CommonTokenStream tokens =
            (CommonTokenStream)recognizer.getInputStream();
        String input = tokens.getTokenSource().getInputStream().toString();
        String[] lines = input.split("\n");
        String errorLine = lines[line - 1];
        String errString = errorLine+"\n";
        for (int i=0; i<charPositionInLine; i++) 
            errString += " ";
        int start = offendingToken.getStartIndex();
        int stop = offendingToken.getStopIndex();
        if ( start>=0 && stop>=0 ) {
            for (int i=start; i<=stop; i++)
                errString += "^";
        }
        return errString+"\n";
    }
}
