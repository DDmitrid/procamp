package com.globallogic.procamp.lesson8.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;

import com.globallogic.procamp.lesson8.entity.Genre;
import com.globallogic.procamp.lesson8.entity.Tutorial;

public class RemoveElementWithIterator {
    
    private final Set<Tutorial> tutorials = new HashSet<>();

    class ManuallyRemoveElementWithIteratorRemove {
        
        public void removeList(Genre genre) {
            // what happen here 
            List<String> list = getListFromAPI();
            list.remove("c");
        }
        
        public void removeTutorialsWithGenres(Genre genre) {
            
            Iterator<Tutorial> iterator = tutorials.iterator();
            
            while (iterator.hasNext()) {
                Tutorial book = iterator.next();
                if (book.getGenres().stream()
                        .anyMatch(g -> g == genre)) {
                    iterator.remove();
                }
            }
        }
        
        private List<String> getListFromAPI() {
            return Arrays.asList("A", "B", "c", "D", "E");
        }
        
    }

    class RemoveWithPredicate {
        public void removeTutorialsWithGenres(Genre genre) {
            tutorials.removeIf(getTutorialPredicate(genre));
        }

        private Predicate<Tutorial> getTutorialPredicate(Genre genre) {
            return book -> book.getGenres().stream()
                    .anyMatch(g -> g  == genre);
        }
    }
}