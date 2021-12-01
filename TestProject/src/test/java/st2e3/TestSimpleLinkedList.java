package st2e3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.Iterator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class TestSimpleLinkedList {

    int[] values = {
        2, 3, 3, 34, 5,
        62, 9, 25, 26,
        2346, 5, 0, 3,
        276, 942, 4, 10,
        -1, -10, -5700
    };

    private Collection<Integer> emptyList;
    private Collection<Integer> list1;

    @BeforeEach
    void init() {
        emptyList = new SimpleLinkedList<>();
        list1 = new SimpleLinkedList<>();
    }

    @Test
    public void testEmptyListSize(){
        assertThat(emptyList.size()).isEqualTo(0);
    }

    @Test
    public void testAddFunction(){

        // checking first add
        assertThat(list1.add(values[0])).isTrue();

        // correct size after first insertion
        assertThat(list1.size()).isEqualTo(1);

        for (int i = 1; i < values.length; i++){

            // checking return value for every value
            assertThat(list1.add(values[i])).isTrue();
        }

        // check size after adding every value
        assertThat(values.length).isEqualTo(list1.size());
    }

    @Nested
    class IteratorTests {
        Iterator<Integer> iter;

        @BeforeEach
        void init(){
            // test with full linkedList
            for (int value : values) {
                list1.add(value);
            }
            iter = list1.iterator();
        }


        @Test
        void iteratorTest() {
            // should return iterator
            assertThat(list1.iterator()).isNotNull();
        }

        @Test
        void removeTest() {
            assertThrows(UnsupportedOperationException.class, () -> iter.remove(),
                    "UnsupportedOperationException expected");
        }

        @Test
        void hasNext() {
            assertThat(emptyList.iterator().hasNext()).isFalse();
            assertThat(list1.iterator().hasNext()).isTrue();
        }

        @Test
        void nextTest() {
            int i = 0;
            while(iter.hasNext()){
                assertThat(i < values.length).isTrue();
                assertThat(iter.next()).isEqualTo(values[i]);
                i++;
            }
            assertThat(values.length).isEqualTo(i);
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
                assertThat(OELIter.hasNext()).isTrue();
            }
        }
    }
}
