package com.b0noi.algorithms.graph.unions;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class QuickFindTest {

    @Test
    public void testQuickFind() throws Exception {
        // input arguments
        final Integer element1 = 1;
        final Integer element2 = 2;
        final Integer element3 = 3;
        final Integer element4 = 4;
        final Integer element5 = 5;

        // mocks

        // expected results

        // creating test instance
        final IUnionFind<Integer> testInstance = new QuickFind<>();

        // execution test
        testInstance.add(element1);
        testInstance.add(element2);
        testInstance.add(element3);
        testInstance.add(element4);
        testInstance.add(element5);

        // result assert
        assertEquals(testInstance.count(), 5);

        assertFalse(testInstance.connect(element1, element2));
        assertNotEquals(testInstance.find(element1), testInstance.find(element2));
        testInstance.union(element1, element2);
        assertTrue(testInstance.connect(element1, element2));
        assertEquals(testInstance.find(element1), testInstance.find(element2));

        assertEquals(testInstance.count(), 4);

        assertFalse(testInstance.connect(element1, element3));
        assertNotEquals(testInstance.find(element1), testInstance.find(element3));
        testInstance.union(element2, element3);
        assertTrue(testInstance.connect(element1, element2));
        assertTrue(testInstance.connect(element1, element3));
        assertTrue(testInstance.connect(element2, element3));
        assertEquals(testInstance.find(element1), testInstance.find(element2));
        assertEquals(testInstance.find(element1), testInstance.find(element3));
        assertEquals(testInstance.find(element2), testInstance.find(element3));

        assertEquals(testInstance.count(), 3);

        // mocks verify
    }

}