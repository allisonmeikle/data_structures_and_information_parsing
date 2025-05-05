package assignment2;

public interface MyList<E> extends Iterable<E>{
    int getSize();
    boolean isEmpty();
    void add(E e);
    void clear();
    E remove();
}
