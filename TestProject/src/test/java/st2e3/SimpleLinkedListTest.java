package st2e3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Nested;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

class SimpleLinkedListTest {

    int[] values = {
            2, 3, 3, 34, 5,
            62, 9, 25, 26,
            2346, 5, 0, 3,
            276, 942, 4, 10
    };

    private SimpleLinkedList<Integer> testList;
    private SimpleLinkedList<Integer> emptyList;

    @BeforeEach
    void init() {
        testList = new SimpleLinkedList<>();
        emptyList = new SimpleLinkedList<>();
    }

    @Test
    void addTest() {
        assertEquals(0, testList.size(), "incorrect initial size");
        assertTrue(testList.add(values[0]), "first add failed");
        assertEquals(1, testList.size(), "incorrect size");
        for (int i = 1; i < values.length; i++){
            assertTrue(testList.add(values[i]), "add failed");
        }
        assertEquals(values.length, testList.size(), "incorrect size");
    }

    @Nested
    class IteratorTests {
        Iterator<Integer> iter;
        @BeforeEach
        void init(){
            for (int value : values) {
                testList.add(value);
            }
            iter = testList.iterator();
        }


        @Test
        void iteratorTest() {
            assertNotNull(testList.iterator(), "does not return iterator");
        }

        @Test
        void removeTest() {
            assertThrows(UnsupportedOperationException.class, () -> iter.remove(),
                    "UnsupportedOperationException expected");
        }

        @Test
        void hasNext() {
            assertFalse(emptyList.iterator().hasNext(), "returns true while empty");
            assertTrue(testList.iterator().hasNext(), "returns false while filled");
        }

        @Test
        void nextTest() {
            int i = 0;
            while(iter.hasNext()){
                assertTrue(i < values.length, "list contains additional elements");
                assertEquals(values[i], iter.next(), "wrong element at position " + i);
                i++;
            }
            assertEquals(values.length, i, "missing elements");
            assertThrows(NullPointerException.class, () -> iter.next(),
                    "still contains elements after full iteration");

        }

        @Test
        void nextOnEmptyListTest() {
            assertThrows(NullPointerException.class, () -> emptyList.iterator().next());
        }

        @Test
        void hasNextIdempotenceTest() {
            SimpleLinkedList<Integer> oneElementList = new SimpleLinkedList<>();
            oneElementList.add(1);
            Iterator<Integer> OELIter = oneElementList.iterator();
            for(int i = 0; i < 4; i++) {
                assertTrue(OELIter.hasNext(), "hasNext() is not idempotent");
            }
        }
    }
}