/*
 * (c) 2013-2021  Heinrich Hussmann und Uwe Aßmann, TU Dresden
 */
package st2e3;

import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import static java.util.Collections.emptyIterator;

/**
 * Achtung! Einige der Methoden sind fehlerhaft und müssen repariert werden.
 */
public class SimpleLinkedList<E> extends AbstractCollection<E> implements Collection<E> {
    private class Elem {
        private E elem;
        private Elem next;

        public Elem(E elem, Elem next) {
            this.elem = elem;
            this.next = next;
        }
    }

    private Elem start = null;
    private Elem end = null;
    private int size = 0;

    @Override
    public boolean add(E o) {
        if (o == null){
            return false;
        }

        Elem e = new Elem(o, null);
        if (start == null) {
            start = e;
        }

        if (end != null) {
            end.next = e;
        }
        end = e;
        size++;
        return true;
    }

    @Override
    public int size() {
        return size;
    }

    private class Iter implements Iterator<E> {
        private Elem current;

        public Iter() {
            current = start;
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public E next() {
            E currentElement = current.elem;
            if (!hasNext()){
                throw new NoSuchElementException();
            }
            current = current.next;
            return currentElement;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    @Override
    public Iterator<E> iterator() {

        // returns emptyIterator static object when list is empty
        return this.size() == 0 ? emptyIterator(): new Iter();
    }
}
