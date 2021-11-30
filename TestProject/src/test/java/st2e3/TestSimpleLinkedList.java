package st2e3;

import org.junit.jupiter.api.Test;

import java.util.Collection;

import static org.assertj.core.api.Assertions.*;

public class TestSimpleLinkedList {

    private static Collection<Integer> emptyList = new SimpleLinkedList<Integer>();
    private static Collection<Integer> list1 = new SimpleLinkedList<Integer>();

    @Test
    public void testEmptyListSize(){
        assertThat(emptyList.size()).isEqualTo(0);
    }

    @Test
    public void testAddFunction(){
        assertThat(list1.add(1)).isTrue();
        assertThat(list1.add(2)).isTrue();
    }

}
