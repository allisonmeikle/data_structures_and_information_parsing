package assignment2;

public class MyStack<E> {
    private MyDoublyLinkedList<E> elements;

    public MyStack(){
        this.elements = new MyDoublyLinkedList<E>();
    }

    public void push (E e){
        this.elements.addLast(e);
    }
    public E pop(){
        return this.elements.removeLast();
    }
    public E peek(){
        return this.elements.peekLast();
    }
    public boolean isEmpty(){
        return this.elements.isEmpty();
    }
    public void clear(){
        this.elements.clear();
    }
    public int getSize(){
        return this.elements.size;
    }
}
