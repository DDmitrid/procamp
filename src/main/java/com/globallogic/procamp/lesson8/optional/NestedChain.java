package com.globallogic.procamp.lesson8.optional;

import static java.util.Optional.empty;
import static java.util.Optional.ofNullable;

import java.util.Optional;

/*
    chain of call in nested objects
    1) show object 
 */
public enum NestedChain {
    
    IS_PRESENT {
        @Override
        public String getAuthorName(Publishing publishing) {
        
            String name = "Unknown";
            
            if (ofNullable(publishing).isPresent()) {
                if (publishing.getBook().isPresent()) {
                    if (publishing.getBook().get().getAuthor().isPresent()) {
                        name = publishing.getBook().get().getAuthor().get().getName();
                    }
                }
            }
            
            return name;
        }
    },
    IF_PRESENT {
        @Override
        public String getAuthorName(Publishing publishing) {
        
            final StringBuilder builder = new StringBuilder();
//            String n[] = new String[1];
            ofNullable(publishing).ifPresent(
                p -> p.getBook().ifPresent(
                    c -> c.getAuthor().ifPresent(
//                        i -> n[0] = i.getName())
                        i -> builder.append(i.getName())
                    )
                )
            );
            
            return builder.toString();
        }
    },
    MAP {
        @Override
        public String getAuthorName(Publishing publishing) {
        
            return ofNullable(publishing)
                        .map(Publishing::getBook)
                        .map(b -> b.get().getAuthor())
                        .map(a -> a.get().getName())
                        .orElse("Unknown");
        }
    },
    FLAT_MAP {
        @Override
        public String getAuthorName(Publishing publishing) {
            
            return ofNullable(publishing)
                    .flatMap(Publishing::getBook)
                    .flatMap(BestSeller::getAuthor)
                    .map(Author::getName)
                    .orElse("Unknown");
        }
    };
    
    public abstract String getAuthorName(Publishing publishing);
}

class Publishing {
    Optional<BestSeller> getBook() {
        return empty();
    }
}

class BestSeller {
    Optional<Author> getAuthor() {
        return empty();
    }
}

class Author {
    String getName() {
        return "";
    }
}