package st2e3;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.Iterator;

import static org.assertj.core.api.Assertions.*;

public class TestSimpleLinkedList {

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
        assertThat(list1.add(1)).isTrue();
        assertThat(list1.add(2)).isTrue();
        assertThat(list1.size()).isEqualTo(2);
    }

    @Test
    public void testIterator() {
        list1.add(2);
        list1.add(3);
        list1.add(4);
        Iterator<Integer> iter1 =emptyList.iterator();
        Iterator<Integer> iter2 = list1.iterator();

        assertThat(iter1.hasNext()).isFalse();
        assertThat(iter2.hasNext()).isTrue();

        /*
         * start testIterator manually and you get 2
         * start with MAVEN TEST you get 1
         */
        assertThat(iter2.next()).isEqualTo(2);
    }
}
