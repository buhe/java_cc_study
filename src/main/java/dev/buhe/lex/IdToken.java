package dev.buhe.lex;

/**
 * @desc 标识符 token
 **/
public class IdToken extends Token {
    private String text;

    protected IdToken(int line, String id) {
        super(line);
        text = id;
    }

    public boolean isIdentifier() {
        return true;
    }

    public String getText() {
        return text;
    }
}
