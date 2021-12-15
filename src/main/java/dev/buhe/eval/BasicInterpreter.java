package dev.buhe.eval;

import dev.buhe.CodeDialog;
import dev.buhe.ast.ASTree;
import dev.buhe.ast.NullStmnt;
import dev.buhe.lex.Lexer;
import dev.buhe.lex.Token;
import dev.buhe.parse.BasicParser;
import dev.buhe.parse.ParseException;

public class BasicInterpreter {
    public static void main(String[] args) throws ParseException {
        run(new BasicParser(), new BasicEnv());
    }

    public static void run(BasicParser basicParser, Environment environment) throws ParseException {
        Lexer lexer = new Lexer(new CodeDialog());
        while (lexer.peek(0) != Token.EOF) {
            ASTree asTree = basicParser.parse(lexer);
            if (!(asTree instanceof NullStmnt)) {
                Object r = ((BasicEvaluator.ASTreeEx) asTree).eval(environment);
                System.out.println("=> " + r);
            }
        }
    }
}
