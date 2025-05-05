package assignment2;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyDoublyLinkedList<E> extends MyLinkedList<E>{
	private DNode head;
	private DNode tail;

	public void addFirst (E e){
		DNode newNode = new DNode();
		newNode.element = e;
		if (this.size == 0){
			this.head = newNode;
			this.tail = newNode;
			newNode.next = null;
			newNode.prev = null;
		} else {
			newNode.next = this.head;
			this.head.prev = newNode;
			this.head = newNode;
		}
		this.size += 1;
	}
	public void addLast (E e){
		DNode newNode = new DNode();
		newNode.element = e;
		if (this.size == 0){
			this.head = newNode;
			this.tail = newNode;
			newNode.next = null;
			newNode.prev = null;
		}else{
			newNode.prev = this.tail;
			this.tail.next = newNode;
			this.tail = newNode;
		}
		this.size += 1;
	}
	public void add(E e) {
		this.addLast(e);
	}

	public E remove(){
		if (this.size == 0){
			throw new NoSuchElementException("This list is empty, nothing can be removed.");
		}
		else if (this.size == 1){
			DNode removed = this.tail;
			this.tail = null;
			this.head = null;
			this.size -= 1;
			return removed.element;
		}
		DNode temp = this.tail.prev;
		DNode removed = this.tail;
		this.tail = temp;
		this.tail.next = null;
		this.size -= 1;
		return removed.element;
	}

	public E removeFirst(){
		if (this.size == 0){
			throw new NoSuchElementException("This list is empty, nothing can be removed.");
		} else if (this.size == 1){
			DNode removed = this.head;
			this.head = null;
			this.tail = null;
			this.size -= 1;
			return removed.element;
		}
		DNode temp = this.head.next;
		DNode removed = this.head;
		this.head = temp;
		this.head.prev = null;
		this.size -= 1;
		return removed.element;
	}
	public E removeLast(){
		return this.remove();
	}
	public void clear(){
		while (this.size != 0){
			this.remove();
		}
	}

	public E peekFirst(){
		if (this.head != null){
			return this.head.element;
		}
		throw new NoSuchElementException("The list is empty, there is no first element");
	}

	public E peekLast(){
		if (this.tail != null){
			return this.tail.element;
		}
		throw new NoSuchElementException("The list is empty, there is no first element");
	}

	public boolean equals(Object obj){
		if (obj instanceof MyDoublyLinkedList){
			if (this.size == ((MyDoublyLinkedList)obj).size){
				DNode cur1 = this.head;
				DNode cur2 = ((MyDoublyLinkedList)obj).head;
				for (int i = 0; i<this.size;i++){
					if (!cur1.element.equals(cur2.element)){
						return false;
					}
					cur1 = cur1.next;
					cur2 = cur2.next;
				}
				return true;
			}
		}
		return false;
	}

	public Iterator<E> iterator() {
		return new DLLIterator();
	}

	private class DNode {
		private E element;
		private DNode next;
		private DNode prev;
	}

	private class DLLIterator implements Iterator<E> {
		DNode curr;

		public DLLIterator() {
			this.curr = head;
		}

		public boolean hasNext() {
			return this.curr != null;
		}

		public E next() {
			if (!this.hasNext())
				throw new NoSuchElementException();

			E element = this.curr.element;
			this.curr = this.curr.next;
			return element;
		}
	}
}
