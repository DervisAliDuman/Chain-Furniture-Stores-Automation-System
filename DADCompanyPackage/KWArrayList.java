package DADCompanyPackage;

import java.util.Arrays;

public class KWArrayList<E> {
    private E []theData;
    private int capacity;
    private int size;
    private static final int INITIAL_CAPACITY=10;

    KWArrayList(){
        capacity=INITIAL_CAPACITY;
        theData=(E[]) new Object[capacity];
    }
    public boolean add(E anEntry) {
        if(size==capacity)
            reallocate();

        theData[size++]=anEntry;
        return true;
    }

    public int size() {
        return size;
    }

    public void add(int index, E anEntry) {
        if(index<0 || index>size)
            throw new ArrayIndexOutOfBoundsException(index);
        if(size==capacity)
            reallocate();
        for(int i=size;i>index;i--)
            theData[i]=theData[i-1];
        theData[index]=anEntry;
        size++;
    }

    public int indexOf(Object o) {
        if (o == null) {
            for (int i = 0; i < size; i++)
                if (theData[i]==null)
                    return i;
        } else {
            for (int i = 0; i < size; i++)
                if (o.equals(theData[i]))
                    return i;
        }
        return -1;
    }
    public E get(int index) {
        if(index<0 || index>=size)
            throw new ArrayIndexOutOfBoundsException(index);
        return theData[index];
    }
    public E set(int index, E newValue) {
        if(index<0 || index>=size)
            throw new ArrayIndexOutOfBoundsException(index);
        E oldValue=theData[index];
        theData[index]=newValue;
        return oldValue;
    }
    public E remove(int index) {
        if(index<0 || index>=size)
            throw new ArrayIndexOutOfBoundsException(index);
        E returnValue=theData[index];
        for(int i=index+1;i<size;i++)
            theData[i-1]=theData[i];
        size--;
        return returnValue;

    }
    private void reallocate() {
        capacity*=2;
        theData= Arrays.copyOf(theData, capacity);
    }

}