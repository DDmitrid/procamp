package com.globallogic.procamp.lesson8.stream;

import java.util.List;
import java.util.stream.Collectors;

import com.globallogic.procamp.lesson8.entity.Tutorial;
import com.google.common.base.Supplier;

public class StreamMayBeConvertedToArray {
    class ConvertToArrayViaList {
        public String[] getTutorialNames(List<Tutorial> tutorials) {
            List<String> names = tutorials.stream()
                    .map(Tutorial::getName)
                    .collect(Collectors.toList());
            
            return names.toArray(new String[names.size()]);
        }
    }

    class ConvertToArrayDirectly {
        public String[] getTutorialNames(List<Tutorial> users) {
            return users.stream()
                    .map(Tutorial::getName)
                    .toArray(String[]::new);

        }
    }
}
