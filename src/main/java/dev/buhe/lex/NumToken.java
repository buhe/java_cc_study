package dev.buhe.lex;

/**
 * @desc 数值 token
 **/
public class NumToken extends Token {
    private int value;

    protected NumToken(int line, int v) {
        super(line);
        value = v;
    }

    public boolean isNumber() {
        return true;
    }

    public String getText() {
        return Integer.toString(value);
    }

    public int getNumber() {
        return value;
    }
}
