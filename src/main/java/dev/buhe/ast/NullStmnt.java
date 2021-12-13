package dev.buhe.ast;

import java.util.List;

/**
 * Null expression node for abstract syntax tree
 */
public class NullStmnt extends ASTList {
    public NullStmnt(List<ASTree> children) {
        super(children);
    }
}
