package com.b0noi.algorithms.sort;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.*;

import static org.testng.Assert.*;

public class ISortTest {

    @DataProvider(name = "isort_implementation_provider")
    private static Object[][] isortImplementationProvider() {
        return new Object[][]{
                {new SelectionSort(), 10_000},
                {new InsertionSort(), 10_000},
                {new ShellSort(),     30_000},
                {new MergeSort(),     30_000},
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

    public static void main(String[] args) throws InterruptedException {
        final Object[][] testInstances = ISortTest.isortImplementationProvider();
        final List<Thread> threads = new ArrayList<>(testInstances.length);
        for (Object[] test : testInstances) {
            final Thread testThread = new TestSort((ISort)test[0]);
            threads.add(testThread);
            testThread.start();
        }
        do {
            threads.forEach(System.out::println);
            System.out.println("~~~~~~~~~~~~~~~~~~~~");
            Thread.sleep(1000);
        } while (threads.stream().filter(Thread::isAlive).count() > 0);
    }

}

class TestSort extends Thread {

    private final Map<Test, Long> testResult = new HashMap<>();

    private final ISort testSortInstance;

    TestSort(final ISort testSortInstance) {
        this.testSortInstance = testSortInstance;
    }

    @Override
    public void run() {
        final Random random = new Random();
        for (Test test : Test.values()) {
            final List<Integer> inputList = new ArrayList<>(test.getTestListSize());
            random.ints(test.getTestListSize()).forEach(inputList::add);
            final long beforeTest = System.nanoTime();
            testSortInstance.sort(inputList);
            final long afterTest = System.nanoTime();
            testResult.put(test, (afterTest - beforeTest) / 1000_000_000);
        }
    }

    @Override
    public String toString() {
        final StringBuilder result = new StringBuilder();
        result.append(String.format("Test results for: %s \n", testSortInstance.getClass()));
        for (Test test : Test.values()) {
            if (testResult.containsKey(test)) {
                result.append(String.format("Result for test: %s => %d \n", test, testResult.get(test)));
            } else {
                result.append(String.format("Result for test: %s => STILL IN PROGRESS \n", test));
            }
        }
        return result.toString();
    }

    private enum Test {
        EASY(10_000),
        MEDIUM(100_000),
        HARD(1_000_000);

        private final int testListSize;

        Test(int testListSize) {
            this.testListSize = testListSize;
        }

        public int getTestListSize() {
            return testListSize;
        }

    }

}