package dev.buhe.lex;

import dev.buhe.CodeDialog;
import dev.buhe.parse.ParseException;

/**
 * @desc 测试词法分析器
 **/
public class LexRunner {
    public static void main(String[] args) throws ParseException {
        Lexer lexer = new Lexer(new CodeDialog());
        for (Token t; (t = lexer.read()) != Token.EOF;) {
            System.out.println("=>" + t.getText());
        }
    }
}
