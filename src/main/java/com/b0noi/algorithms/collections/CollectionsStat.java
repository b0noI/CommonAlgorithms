package com.b0noi.algorithms.collections;


import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class CollectionsStat {

    public List<List<Integer>> cartesianProduct(final List<Set<Integer>> inputelements) {
        final Set<Integer> firstSet = inputelements.get(0);
        if (inputelements.size() == 1) {
            return firstSet
                    .stream()
                    .map(i -> new ArrayList<Integer>(){{add(i);}})
                    .collect(Collectors.toList());
        }

        final List<List<Integer>> tempResult = cartesianProduct(inputelements.subList(1, inputelements.size()));
        return firstSet
                .stream()
                .flatMap(i -> tempResult.stream().map(list -> new ArrayList<Integer>(){{add(i);addAll(list);}}))
                .collect(Collectors.toList());
    }

}
