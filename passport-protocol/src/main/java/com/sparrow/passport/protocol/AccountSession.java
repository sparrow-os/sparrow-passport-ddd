package com.sparrow.passport.protocol;

import java.util.HashMap;
import java.util.Map;

public class AccountSession {
    public final static String TERIMINAL="teriminal";
    private final Map<String, Object> attributes = new HashMap<>();

    public void setAttribute(String key, Object value) {
        this.attributes.put(key, value);
    }

    public Object setAttribute(String key) {
        return this.attributes.get(key);
    }

    public Boolean containsKey(String key) {
        return this.attributes.containsKey(key);
    }
}
