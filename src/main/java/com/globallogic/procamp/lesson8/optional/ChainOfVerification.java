package com.globallogic.procamp.lesson8.optional;

import static java.util.Optional.ofNullable;

import java.util.Optional;

import com.globallogic.procamp.lesson8.entity.Tutorial;


/*
        Getting default value if NAME was missing
 */
public enum ChainOfVerification {
    
    BEFORE_OPTIONAL {
        // ?: 
        @Override 
        public String getName(Tutorial tutorial) {
            return (tutorial != null && tutorial.getName() != null) 
                            ? tutorial.getName() 
                            : "Effective Java";
        }
    },
    IS_PRESENT {
        @Override 
        public String getName(Tutorial tutorial) {

            if (ofNullable(tutorial).isPresent()) {
                if (ofNullable(tutorial.getName()).isPresent()) {
                    return tutorial.getName();
                }
            }
            return "Effective Java";
        }
    },
    OR_ELSE {
        @Override
        public String getName(Tutorial tutorial) {
            
            return ofNullable(tutorial)
                            .map(Tutorial::getName)
                            .orElse("Effective Java");
        }
    };

    public abstract String getName(Tutorial tutorial);
}
