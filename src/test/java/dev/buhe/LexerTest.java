package dev.buhe;

import static org.junit.Assert.assertEquals;

import java.io.StringReader;

import org.junit.Test;

public class LexerTest {

    @Test
    public void testLex() throws ParseException {
        Lexer l = new Lexer(new StringReader("a = 11"));
        Token t = l.read();
        assertEquals("a", t.getText());
    }
}
