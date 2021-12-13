package dev.buhe.ast;

import java.util.List;

/**
 * For expression node for abstract node
 */
public class ForStmnt extends ASTList {
    public ForStmnt(List<ASTree> children) {
        super(children);
    }

    public ASTree initial() {
        return child(0).child(0);
    }

    public ASTree condition() {
        return child(0).child(1);
    }

    public ASTree step() {
        return child(0).child(2);
    }

    public ASTree body() {
        return child(1);
    }

    @Override
    public String toString() {
        return "(for " + initial() + " " + condition() + " " + step() + " " + body() + ")";
    }
}