package com.b0noi.algorithms.sort;

import com.b0noi.algorithms.graph.unions.QuickFind;
import com.b0noi.algorithms.graph.unions.QuickUnion;
import com.b0noi.algorithms.graph.unions.WeightedQuickUnion;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import static org.testng.Assert.*;

public class ISortTest {

    @DataProvider(name = "isort_implementation_provider")
    private static Object[][] isortImplementationProvider() {
        return new Object[][]{
                {new BubbleSort(), 10_000},
        } ;
    }

    @Test(dataProvider = "isort_implementation_provider")
    public void testSort(final ISort testInstance, final int inputListSize) throws Exception {
        // input arguments
        final Random random = new Random();
        final List<Integer> inputList = new ArrayList<>(inputListSize);
        final List<Integer> expectedResult = new ArrayList<>(inputListSize);
        random.ints(inputListSize).forEach(i -> {
            inputList.add(i);
            expectedResult.add(i);
        });

        // mocks

        // expected results
        Collections.sort(expectedResult);

        // creating test instance

        // execution test
        testInstance.sort(inputList);

        // result assert
        assertEquals(inputList, expectedResult);

        // mocks verify
    }

}