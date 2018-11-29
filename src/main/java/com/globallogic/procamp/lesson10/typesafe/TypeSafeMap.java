package com.globallogic.procamp.lesson10.typesafe;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

// Typesafe heterogeneous container pattern - implementation

public class TypeSafeMap {
    private Map<Class<?>, Object> favorites = new HashMap<>();

    public <T> void put(Class<T> type, T instance) {
        favorites.put(Objects.requireNonNull(type), instance);
    }

    public <T> T get(Class<T> type) {
        return type.cast(favorites.get(type));
    }
}
