package dev.buhe;

import static org.junit.Assert.assertEquals;

import java.io.StringReader;

import org.junit.Test;

import dev.buhe.lex.Lexer;
import dev.buhe.lex.Token;
import dev.buhe.parse.ParseException;

public class LexerTest {

    @Test
    public void testLex() throws ParseException {
        Lexer l = new Lexer(new StringReader("a = 11"));
        Token t = l.read();
        assertEquals("a", t.getText());
    }
}
