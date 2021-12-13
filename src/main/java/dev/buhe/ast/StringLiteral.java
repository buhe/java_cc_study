package dev.buhe.ast;

import dev.buhe.lex.Token;

/**
 * String literal node for abstract syntax tree
 */
public class StringLiteral extends ASTLeaf {
    public StringLiteral(Token token) {
        super(token);
    }

    public String value() {
        return token().getText();
    }
}