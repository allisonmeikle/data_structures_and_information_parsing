package assignment2;

public class MyQueue<E> {
    private MyDoublyLinkedList<E> elements;

    public MyQueue(){
        this.elements = new MyDoublyLinkedList<E>();
    }
    public void enqueue(E e){
        this.elements.addLast(e);
    }
    public E dequeue(){
        return this.elements.removeFirst();
    }
    public boolean isEmpty(){
        return this.elements.isEmpty();
    }
    public void clear(){
        this.elements.clear();
    }

    public boolean equals(Object obj){
        if (obj instanceof MyQueue){
            return this.elements.equals(((MyQueue)obj).elements);
        }
        return false;
    }

    public int getSize(){
        return this.elements.size;
    }
}
