package dev.buhe.eval;

import java.util.HashMap;

/**
 * Basic environment for program
 */
public class BasicEnv implements Environment {
    protected HashMap<String, Object> values;

    public BasicEnv() {
        values = new HashMap<>();
    }

    @Override
    public void put(String name, Object value) {
        values.put(name, value);
    }

    @Override
    public Object get(String name) {
        return values.get(name);
    }
}
