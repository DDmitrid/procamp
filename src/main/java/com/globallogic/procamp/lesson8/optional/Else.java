package com.globallogic.procamp.lesson8.optional;

import java.util.Optional;

/*
    show difference between orElse & orElseGet
    @see https://stackoverflow.com/questions/33170109/difference-between-optional-orelse-and-optional-orelseget

    +-———————————————————————————————————————————————+—————————————————————+
    |             Optional.isPresent()               |    true   |  false  |
    +————————————————————————————————————————————————+—————————————————————+
    |               .orElse                          |     X     |    X    |
    +————————————————————————————————————————————————+—————————————————————+
    |               .orElseGet()                     |           |    X    |
    +————————————————————————————————————————————————+—————————————————————+
    
 */

public enum Else {
    // show TESTS !!
    OR_ELSE {
        @Override 
        public String getName(Optional<String> value) {
            return value.orElse(defaultValue());
        }
    },
    OR_ELSE_GET {
        @Override 
        public String getName(Optional<String> value) {
            return value.orElseGet(() -> defaultValue());
        }
    };
    
    String defaultValue() {
        System.out.println("EXECUTING_OF_DEFAULT_VALUE");
        return "default value";
    }

    public abstract String getName(Optional<String> value);

}
