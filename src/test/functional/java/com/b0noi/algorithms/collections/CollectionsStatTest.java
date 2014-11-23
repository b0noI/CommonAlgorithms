package com.b0noi.algorithms.collections;

import org.testng.annotations.Test;

import java.util.*;

import static org.testng.Assert.*;

public class CollectionsStatTest {

    @Test
    public void testCartesianProduct() throws Exception {
        // input arguments
        final List<Set<Integer>> inputValue = new ArrayList<Set<Integer>>() {
            {
                add(new HashSet<Integer>(){{addAll(Arrays.asList(new Integer[]{1, 2, 3}));}});
                add(new HashSet<Integer>(){{addAll(Arrays.asList(new Integer[]{1, 2, 3}));}});
                add(new HashSet<Integer>(){{addAll(Arrays.asList(new Integer[]{1, 2, 3}));}});
            }
        };

        // mocks

        // expected results

        // creating test instance
        final CollectionsStat collectionsStat = new CollectionsStat();

        // execution test
        final List<List<Integer>> actualResult = collectionsStat.cartesianProduct(inputValue);

        // result assert
        System.out.println(actualResult);

        // mocks verify

    }

}