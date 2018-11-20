package com.globallogic.procamp.lesson8.optional;

import java.util.Optional;

import com.globallogic.procamp.lesson8.entity.Tutorial;

/*
 chain of call to get NAME value or set name as parameter
 */
public enum StrictCheck {
    CHAIN{
        // using optional in method signature is bad practice, don't do that!!! 
        @Override public String getName(Optional<Tutorial> tutorial) {
 
            if (tutorial.isPresent()) {
                return tutorial.get().getName();
            }
            throw new IllegalStateException("Tutorial not found");
        }

        @Override public void decorate(Optional<Tutorial> tutorial) {
  
            if(tutorial.isPresent()) {
                if (Optional.ofNullable(tutorial.get()).isPresent()) {
                    print(tutorial.get().getName());    
                }            
            }
        }
    },
    REFERENCE {
        @Override public String getName(Optional<Tutorial> tutorial) {

            return tutorial
                .orElseThrow(() -> new IllegalStateException("Tutorial not found"))
                .getName();
        }

        @Override public void decorate(Optional<Tutorial> tutorial) {

            tutorial
                .map(Tutorial::getName)
                .ifPresent(StrictCheck::print);
        }
    },
    ;

    public abstract String getName(Optional<Tutorial> tutorial);

    // delete 
    public abstract void decorate(Optional<Tutorial> tutorial);
    
    private static void print(String name) {
        System.out.println(name.toUpperCase());
    }
}
