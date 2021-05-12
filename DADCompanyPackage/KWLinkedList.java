package DADCompanyPackage;

import java.util.*;

public class KWLinkedList<E> {
    private Node<E> head = null;
    private Node<E> tail = null;
    private int size = 0;

    public void add(int index, E obj) {
        ListIterator<E> iter = listIterator(index);
        iter.add(obj);
    }
    public void addFirst(E obj) { add(0, obj);  }
    public void addLast(E obj) { add(size, obj);  }

    public E get(int index) {
        ListIterator<E> iter = listIterator(index);
        return iter.next();
    }
    public E getFirst() { return head.data;  }
    public E getLast() { return tail.data;  }

    public int size() {  return size;  }

    public E remove(int index) {     E returnValue = null;
        ListIterator<E> iter = listIterator(index);
        if (iter.hasNext()) {
            returnValue = iter.next();
            iter.remove();
        }
        else {   throw new IndexOutOfBoundsException();  }
        return returnValue;
    }

    public Iterator iterator() { return new KWListIter(0);  }

    public ListIterator listIterator() { return new KWListIter(0);  }

    public ListIterator listIterator(int index){return new KWListIter(index);}

    public ListIterator listIterator(ListIterator iter) {
        return new KWListIter( (KWListIter) iter);
    }


    private static class Node<E> {     private E data;
        private Node<E> next = null;
        private Node<E> prev = null;

        private Node(E dataItem){
            data = dataItem;
        }
    }

    public class KWListIter implements ListIterator<E> {
        private Node<E> nextItem;
        private Node<E> lastItemReturned;
        private int index = 0;

        public KWListIter(int i){
            if (i < 0 || i > size) {
                throw new IndexOutOfBoundsException("Invalid index " + i);
            }
            lastItemReturned = null;

            if (i == size){
                index = size;
                nextItem = null;
            }
            else{
                nextItem = head;
                for (index = 0; index < i; index++)
                    nextItem = nextItem.next;
            }
        }

        public KWListIter(KWListIter other){
            nextItem = other.nextItem;
            index = other.index;
        }

        public boolean hasNext() {
            return nextItem != null;
        }

        public boolean hasPrevious(){
            return (nextItem == null && size != 0) || nextItem.prev != null;
        }

        public int previousIndex() {
            return index - 1;
        }

        public int nextIndex() {
            return index;
        }

        public void set(E o) {}

        public void remove(){}

        public E next(){
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            lastItemReturned = nextItem;
            nextItem = nextItem.next;
            index++;
            return lastItemReturned.data;
        }

        public E previous(){
            if (!hasPrevious()) {
                throw new NoSuchElementException();
            }
            if (nextItem == null) {
                nextItem = tail;
            }
            else {
                nextItem = nextItem.prev;
            }
            lastItemReturned = nextItem;
            index--;
            return lastItemReturned.data;
        }

        public int indexOf(Object o) {
            int index = 0;
            if (o == null) {
                for (Node<E> x = head; x != null; x = x.next) {
                    if (x.data == null)
                        return index;
                    index++;
                }
            } else {
                for (Node<E> x = head; x != null; x = x.next) {
                    if (o.equals(x.data))
                        return index;
                    index++;
                }
            }
            return -1;
        }

        public void add(E obj){
            if (head == null) {
                head = new Node(obj);
                tail = head;
        }
        else if (nextItem == head) {
            Node newNode = new Node(obj);
            newNode.next = nextItem;
            nextItem.prev = newNode;
            head = newNode;
        }
        else if (nextItem == null) {
            Node newNode = new Node(obj);
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        else {
            Node newNode = new Node(obj);
            newNode.prev = nextItem.prev;
            nextItem.prev.next = newNode;
            newNode.next = nextItem;
            nextItem.prev = newNode;
        }
            size++;
            index++;
        }

    }
}
