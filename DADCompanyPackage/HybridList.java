package DADCompanyPackage;

public class HybridList<E> {
    KWLinkedList<KWArrayList<E>> list;
    private int size = 0;
    private int Listcount = 0;
    private static final int max = 10;

    public HybridList() {
        list = new KWLinkedList<KWArrayList<E>>();
        KWArrayList<E> temp = new KWArrayList<E>();
        list.add(list.size(), temp);
        Listcount = 1;

    }

    public E set(int index, E e) {
        int cursor = index % max;
        int list_cursor = index / max;

        return list.get(list_cursor).set(cursor,e);
    }

    public E get(int index) {
        int cursor = index % max;
        int list_cursor = (index) / max;

        return list.get(list_cursor).get(cursor);
    }

    public boolean add(E e) {

        if((size) / Listcount >=  max) {
            KWArrayList<E> temp = new KWArrayList<E>();
            list.add(list.size(), temp);
            Listcount++;
        }

        list.get(Listcount-1).add(e);

        size++;

        return true;
    }

    public E removeLast() {
        return remove(size-1);
    }

    public E remove(int index) {
        int cursor = index % max;
        int list_cursor = index / max;
        size--;
        E willreturn = list.get(list_cursor).remove(cursor);

        E shift_removed;

        if(list.get(list_cursor).size() <10 && list_cursor<Listcount) {
            for(int i = list_cursor+1; i < Listcount ; i++) {
                if (list.get(i).size()>0) {

                    shift_removed =  list.get(i).remove(0);
                    list.get(i-1).add(9,shift_removed);
                }
            }
        }
        if(size / max < Listcount-1) {
            Listcount--;
            list.remove(Listcount);
        }
        return willreturn;
    }

    public boolean contains(Object o) {
        return indexOf(o) >= 0;
    }

    public long indexOf(Object o) {
        int control = 0;
        for (int i = 0; i < Listcount; i++) {
            control = list.get(i).indexOf(o);
            if( control != -1)
                return i*max + control;
        }

        return -1;
    }

    public long size() {
        return size ;
    }

}

