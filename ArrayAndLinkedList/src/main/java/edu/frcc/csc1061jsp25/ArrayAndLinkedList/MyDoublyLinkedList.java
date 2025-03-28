package edu.frcc.csc1061jsp25.ArrayAndLinkedList;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import edu.frcc.csc1061jsp25.ArrayAndLinkedList.MyLinkedList.MyIterator;
import edu.frcc.csc1061jsp25.ArrayAndLinkedList.MyLinkedList.Node;

public class MyDoublyLinkedList<E> implements List<E>{

	private Node head; 
	private Node tail; 
	private int size;
	
	private class Node{
		E data;
		Node next; 
		Node prev;
		
		public Node(E data) {
			this.data = data;
			next = null; 
			prev = null;
		}

		public Node getNext() {
			return next;
		}
	}
	
	public MyDoublyLinkedList() {
		head = null; 
		tail = null; 
		size = 0;
	}

	@Override
	public int size() {
		return size;
		/* If we did not have a count (of the list size) already 
		 * int count = 0; for (Node node = head; node != null; node = node.next) { 
		 * count++; 
		 * } return count;
		 */
	}

	@Override
	public boolean isEmpty() {
		return size == 0; // Shorthand for if (head == null){...return true}
		// Could also use: return size == 0; 
	}

	@Override
	public boolean contains(Object o) {
		if (indexOf(o) != -1) {
			return true; 
		}
		return false;
	}

	@Override
	public Iterator<E> iterator() { 
		return new MyIterator();
	}
	
	private class MyIterator implements Iterator<E> {
		Node currNode = head; 
		@Override
		public boolean hasNext() {
			if (!(currNode == null)) {
				return true; 
			}
			return false;
		}

		@Override
		public E next() {
			if (currNode.next != null) {
				E element = currNode.data;
				currNode = currNode.next; 
				return element;
			}
			throw new NullPointerException(); 
		}
		
	}

	@Override
	public Object[] toArray() {
		Object[] array = new Object[size]; 
		int i = 0; 
		for (Node node = head; node != null; node = node.next) {
			array[i++] = node.data; 
		}
		return array;
	}

	@Override
	public <T> T[] toArray(T[] a) {
		
		return null;
	}

	@Override
	public boolean add(E e) {
		Node newNode = new Node(e); 
		
		if (head == null) {
			head = newNode; 
			tail = newNode; 
		}
		else {
			tail.next = newNode;
			newNode.prev = tail; 
		}
		tail = newNode; 
		size++;
		return false; 
	}

	@Override
	public boolean remove(Object o) {
		int index = indexOf(o);
		if (index == -1) {
			return false; 
		}
		remove(index);
		return true; 
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addAll(Collection<? extends E> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addAll(int index, Collection<? extends E> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() {
		head = null;
		tail = null; 
		size = 0; 
	}

	@Override
	public E get(int index) {
		Node node = getNode(index);
		return node.data; 
	}

	@Override
	public E set(int index, E element) {
		Node node = getNode(index); 
		
		E old = node.data;
		node.data = element;
		return old; 		
	}
	
	private Node getNode(int index) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException(); 
		}
		
		Node node = head;
		for (int i = 0; i < index; i++) {
			node = node.next;
		}
		return node; 
	}

	@Override
	public void add(int index, E element) {
		Node newNode = new Node(element);
		if (index == 0) {
			newNode.next = head;
			head = newNode;
		}
		else {
			Node prevNode = getNode(index - 1); // This will return the object right before the index we want to insert at
		
			newNode.next = prevNode.next; 
			prevNode.next = newNode; 
		}
		size++;
	}

	@Override
	public E remove(int index) {
		Node prevNode = getNode(index -1);
		E data = prevNode.next.data;
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException();
		}
		else if (index == 0) {
			head = head.next; 
		}
		else { 
			prevNode.next = prevNode.next.next; 
		}
		return data; 
	}

	@Override
	public int indexOf(Object o) {
		int index = 0;
		for (Node node = head; node != null; node = node.next, index++) {  // Cool shortcut meaning there are multiple changers 
			if (o.equals(node.data)) {
				return index;
			}
		}
		return -1;
	}

	@Override
	public int lastIndexOf(Object o) {
		int index = size - 1;
		int foundIndex = -1; 
		for (Node node = tail; node != null; node = node.prev, index--) {  // Cool shortcut meaning there are multiple changers 
			if (o.equals(node.data)) {
				foundIndex = index; 
				break; 
			}
		}
		return foundIndex;
	}

	@Override
	public ListIterator<E> listIterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ListIterator<E> listIterator(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<E> subList(int fromIndex, int toIndex) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
}
