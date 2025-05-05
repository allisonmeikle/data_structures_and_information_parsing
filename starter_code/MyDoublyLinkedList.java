package assignment2;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyDoublyLinkedList<E> {
	private DNode head;
	private DNode tail;
	
	
	/*
	 * ADD YOUR CODE HERE
	 */

	
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
