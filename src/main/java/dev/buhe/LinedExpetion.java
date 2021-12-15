package dev.buhe;

import dev.buhe.ast.ASTree;

public class LinedExpetion extends RuntimeException{
    public LinedExpetion(String message) {
        super(message);
    }

    public LinedExpetion(String message, ASTree tree) {
        super(message + " " + tree.location());
    }
}
