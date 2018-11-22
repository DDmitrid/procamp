package com.globallogic.procamp.lesson8.lambda;

import static java.util.Comparator.comparingInt;

import java.util.List;

import com.globallogic.procamp.lesson8.entity.Tutorial;

public class TrueFunctionalApproach {
    
    class BeforeJava8 {
        public Tutorial findTutorialsWithMostGenre(List<Tutorial> tutorialList) {
            if (tutorialList.isEmpty()) {
                return null;
            }
            Tutorial mostPowerful = tutorialList.iterator().next();
            for (Tutorial tutorial : tutorialList) {
                if (tutorial.getGenres().size() > mostPowerful.getGenres().size()) {
                    mostPowerful = tutorial;
                }
            }
            return mostPowerful;
        }
    }

    class NaiveStreamsApproach {
        public Tutorial findTutorialsWithMostGenre(List<Tutorial> tutorilaList) {
            return tutorilaList.stream()
                    .sorted(comparingInt(u -> u.getGenres().size()))
                    .findFirst()
                    .orElse(null);
        }
    }

    class StreamsWithReduction {
        public Tutorial findTutorialsWithMostGenre(List<Tutorial> tutorilaList) {
            return tutorilaList.stream()
                    .reduce((u1, u2) ->
                            u1.getGenres().size() > u2.getGenres().size() ? u1 : u2)
                    .orElse(null);
        }
    }

    class MaxWithComparator {
        public Tutorial findTutorialsWithMostGenre(List<Tutorial> tutorilaList) {
            return tutorilaList.stream()
                    .max(comparingInt(u -> u.getGenres().size()))
                    .orElse(null);
        }
    }
}
