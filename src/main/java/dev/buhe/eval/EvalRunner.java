package dev.buhe.eval;

import javassist.gluonj.util.Loader;

public class EvalRunner {
    public static void main(String[] args) throws Throwable {
        Loader.run(BasicInterpreter.class, args, BasicEvaluator.class);
    }
}
