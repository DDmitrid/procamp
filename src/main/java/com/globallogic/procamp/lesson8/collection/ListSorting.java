package com.globallogic.procamp.lesson8.collection;

import static java.util.Comparator.comparing;
import static java.util.Comparator.comparingLong;

import java.util.List;

import com.globallogic.procamp.lesson8.entity.Tutorial;

public class ListSorting {
    class UsingCustomComparator {
        public void sortUsersById(List<Tutorial> users) {
            users.sort((x, y) -> Long.compare(x.getId(), y.getId()));
        }
    }

    class UsingExistingPredefinedComparator {
        public void sortUsersById(List<Tutorial> users) {
            users.sort(comparing(Tutorial::getName));
        }
    }
}
