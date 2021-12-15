package dev.buhe.eval;

/**
 * An environment for program
 */
public interface Environment {
    void put(String name, Object value);

    Object get(String name);
}
