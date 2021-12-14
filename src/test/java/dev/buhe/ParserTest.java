package dev.buhe;

import java.io.StringReader;

import org.junit.Test;

import dev.buhe.ast.ASTree;
import dev.buhe.lex.Lexer;
import dev.buhe.lex.Token;
import dev.buhe.parse.BasicParser;
import dev.buhe.parse.ParseException;

public class ParserTest {

    @Test
    public void testParser() throws ParseException {
        Lexer l = new Lexer(new StringReader("s = 22 + 33\na = 55"));
        BasicParser basicParser = new BasicParser();
        while (l.peek(0) != Token.EOF) {
            ASTree ast = basicParser.parse(l);
            System.out.println("=> " + ast.toString());
        }
    }
}
