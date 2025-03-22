
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;

/**
 * @author downey
 * @param <E>
 *
 */
public class MyDoubleLinkedList<E> implements List<E> {

	/**
	 * Node is identical to ListNode from the example, but parameterized with T
	 *
	 * @author downey
	 *
	 */
	private class Node {
		public E data;
		public Node next;
		public Node prev;      // Doubly

		public Node(E data) {
			this.data = data;
			this.next = null;
			this.prev = null;     // Doubly
		}
		@SuppressWarnings("unused")
		public Node(E data, Node next) {
			this.data = data;
			this.next = next;
			next.prev = this;    // Doubly
		}
		public String toString() {
			return data.toString();
		}
	}

	private int size;            // keeps track of the number of elements
	private Node head;           // reference to the first node
	private Node tail;            // Doubly reference to the last node
	/**
	 *
	 */
	public MyDoubleLinkedList() {
		head = null;
		tail = null;        // Doubly
		size = 0;
	}

	// IMPLEMENT
	@Override
	public boolean add(E element) {
		Node newNode = new Node(element);
		if (head == null) {
			head = newNode;
		} else {
			tail.next = newNode;
			newNode.prev = tail;
			tail = newNode;
			
//			Node node = head;
//			// loop until the last node
//			for ( ; node.next != null; node = node.next) {}
//			node.next = new Node(element);
		}
		tail = newNode;    // Doubly
		size++;
		return true;
	}

	// IMPLEMENT
	@Override
	public void add(int index, E element) {   
		Node newNode = new Node(element);
		if (index == 0) {
			newNode.next = head;
			head.prev = newNode;
			head = newNode;
		} else {
			Node node = getNode(index - 1);
			if (tail == node) {
				tail = newNode;
			}
			newNode.next = node.next;
			newNode.prev = node;
			if (node.next != null) {
				node.next.prev = newNode;
			}
			node.next = newNode;
		}
		size++;
	}

	@Override
	public boolean addAll(Collection<? extends E> collection) {
		boolean flag = true;
		for (E element: collection) {
			flag &= add(element);
		}
		return flag;
	}

	@Override
	public void clear() {
		head = null;
		tail = null;
		size = 0;
	}

	@Override
	public boolean contains(Object obj) {
		return indexOf(obj) != -1;
	}

	@Override
	public boolean containsAll(Collection<?> collection) {
		for (Object obj: collection) {
			if (!contains(obj)) {
				return false;
			}
		}
		return true;
	}

	@Override
	public E get(int index) {
		Node node = getNode(index);
		return node.data;
	}

	/** Returns the node at the given index.
	 * @param index
	 * @return
	 */
	private Node getNode(int index) {
		if (index < 0 || index >= size) {
			return null; 
		}
		Node node = head;
		for (int i=0; i<index; i++) {
			node = node.next;
		}
		return node;
	}

	@Override
	public int indexOf(Object target) {
		// TODO: FILL THIS IN!
		Node node = head;
		for (int i = 0; i < size; i++) {
			if (equals(target, node.data)) {
				return i;
			}
			node = node.next;
		}
		return -1;
	}

	/** Checks whether an element of the array is the target.
	 *
	 * Handles the special case that the target is null.
	 *
	 * @param target
	 * @param object
	 */
	private boolean equals(Object target, Object element) {
		if (target == null) {
			return element == null;
		} else {
			return target.equals(element);
		}
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public Iterator<E> iterator() {
		return null; 
	}

	@Override
	public int lastIndexOf(Object target) {
		Node node = head;
		int index = -1;
		for (int i=0; i<size; i++) {
			if (equals(target, node.data)) {
				index = i;
			}
			node = node.next;
		}
		return index;
	}

	@Override
	public ListIterator<E> listIterator() {
		return null;
	}

	@Override
	public ListIterator<E> listIterator(int index) {
		return null;
	}

	// IMPLEMENT
	@Override
	public boolean remove(Object obj) {
		Node node = head;
		for (int i = 0; i < size; i++) {
			if (equals(obj, node.data)) {
				break;
			}
			node = node.next;
		}
		if (node == null) {
			return false;
		}
		if (head == node) {
			if (tail == head) {
				tail = null;
			}
			head = head.next;
			head.prev = null;
		}
		else {
			if (node == tail) {
				tail = node.prev;
			}
			node.prev.next = node.next;
			if (node.next != null) {
				node.next.prev = node.prev;
			}
		}
		size--;
		return true;
	}

	//IMPLEMENT
	@Override
	public E remove(int index) {
		//TODO: FILL THIS IN!
		E element = get(index);
		if (index == 0) {
			if (tail == head) {
				tail = null;
			}
			head = head.next;
			head.prev = null;
		} else {
			Node node = getNode(index - 1);
			if (node.next == tail) {
				tail = node;
			}
			node.next = node.next.next;
			if (node.next != null) {
				node.next.prev = node;
			}
		}
		size--;
		return element;
		
		//return null;
	}

	@Override
	public boolean removeAll(Collection<?> collection) {
		boolean flag = true;
		for (Object obj: collection) {
			flag &= remove(obj);
		}
		return flag;
	}

	@Override
	public E set(int index, E element) {
		Node node = getNode(index);
		E old = node.data;
		node.data = element;
		return old;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public List<E> subList(int fromIndex, int toIndex) {
		if (fromIndex < 0 || toIndex >= size || fromIndex > toIndex) {
			return null; 
		}
		// TODO: classify this and improve it.
		int i = 0;
		LinkedList<E> list = new LinkedList<E>();
		for (Node node=head; node != null; node = node.next) {
			if (i >= fromIndex && i <= toIndex) {
				list.add(node.data);
			}
			i++;
		}
		return list;
	}

	@Override
	public Object[] toArray() {
		Object[] array = new Object[size];
		int i = 0;
		for (Node node=head; node != null; node = node.next) {
			// System.out.println(node);
			array[i] = node.data;
			i++;
		}
		return array;
	}

	public void printList() {
		if (head != null) {
			Node currNode = head; 
			while (currNode != null) {
				System.out.println(currNode); 
				currNode = currNode.next; 
			}
		}
		else {
			System.out.println("List is empty"); 
		}
	}

	public MyDoubleLinkedList<E> reverse(){
		MyDoubleLinkedList<E> newList = new MyDoubleLinkedList<E>();
		
		Node currNode = this.tail; 
		while (currNode != null) {
			newList.add(currNode.data);
			currNode = currNode.prev; 
		}
	
		return newList; 
	}

	@Override
	public <T> T[] toArray(T[] a) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addAll(int index, Collection<? extends E> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}
	
	
	// Other Methods 
	// Prints all songs in the playlist to the file 
	public void printToFile() {
		File myFile = new File("Playlist.txt");
		// Checks to see if the file is available/exists 
		if (!myFile.exists()) {
			try {
				myFile.createNewFile();
			}
			catch (IOException e){
				System.out.println(e.getMessage());
				System.exit(-1);
			}
		}
		
		PrintWriter pWriter = null; 
		// Changes the file to accomodate the user's actions 
		try {
			pWriter = new PrintWriter(new FileOutputStream(myFile, false)); 
		}
		catch (IOException e){
			System.out.println(e.getMessage());
		}
		
		Node currNode = head; 
		while (currNode != null) {
			pWriter.println(currNode); 
			currNode = currNode.next; 
			pWriter.flush();
		}
		
		pWriter.close();
	}
	
	// Randomly places all songs in the playlist to form a new order, returns 
	// reordered list 
	public MyDoubleLinkedList<E> shuffle(){
		MyDoubleLinkedList<E> newList = new MyDoubleLinkedList<E>();
		int[] index = getOrder(); // Stores the new order of songs without duplicates 
		int i = 0; 
		
		// Assigning the new order to the new list 
		Node currNode = this.head; 
		while (currNode != null) {
			Node temp = currNode; 
			currNode = this.getNode(index[i]); // Each element in the list is assigned 
			newList.add(currNode.data);        // a new index in a list
			currNode = temp.next; 
			i++; 
		}
	
		return newList; 
	} 
	
	// Returns an array with the new order of songs, the int[] array stores indices 
	// of songs 
	private int[] getOrder() {
		Random random = new Random(); 
		int[] array = new int[size]; 
		int count = 0; 
		
		for (int i = 0; i < size; i++, count++) {
			array[i] = random.nextInt(size); 
			array[i] = checkDup(array, array[i], count);
		}
		
		return array; 
	}
	
	// Recursive method that returns an int/index that has not already been used already 
	private int checkDup(int[] array, int latest, int soFar) {
		if (soFar == 0) {  // No need to check first time through because there can't be 
						   // a duplicate already in the array
		}
		else {
			for (int i = 0; i < soFar; i++) { // Do not need to check elements after the 
				if (array[i] == latest) { 	  // current index 
					Random random = new Random();
					latest = random.nextInt(size); 
					return checkDup(array, latest, soFar); 
				}
			}
		}
		return latest;
	}
}
