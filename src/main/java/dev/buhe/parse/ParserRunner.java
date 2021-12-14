package dev.buhe.parse;

import dev.buhe.CodeDialog;
import dev.buhe.ast.ASTree;
import dev.buhe.lex.Lexer;
import dev.buhe.lex.Token;

/**
 * Created by yangruihan on 2016/11/23.
 */
public class ParserRunner {

    public static void main(String[] args) throws ParseException {
        Lexer l = new Lexer(new CodeDialog());
        BasicParser basicParser = new BasicParser();
        while (l.peek(0) != Token.EOF) {
            ASTree ast = basicParser.parse(l);
            System.out.println("=> " + ast.toString());
        }
    }
}
