package com.globallogic.procamp.lesson8.stream;

import java.util.List;
import java.util.stream.Collectors;

public class UntypedStreamsCouldBeConverted {
    
    class ProcessOnlyValuesOfSpecialType {
        public int countDoubleNaNs(List numbers) {
            int count = 0;
            
            for (Object e : numbers) {
                if (e instanceof Double) {
                    Double d = (Double) e;
                    if (d.isNaN()) {
                        count++;
                    }
                }
            }
            return count;
        }
    }

    class TypeOfStreamCouldBeChanged {
        public int countDoubleNaNs(List numbers) {
            return (int) numbers.stream()
                    .filter(Double.class::isInstance)
                    .mapToDouble(Double.class::cast)
                    .filter(Double::isNaN)
                    .count();
//            .collect(Collectors.counting());
//            .collect(Collectors.reducing(0, e -> 1, Integer::sum));
        }
    }
}