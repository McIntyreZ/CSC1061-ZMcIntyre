package edu.frcc.csc1061jsp25.MinHeap;

import java.util.ArrayList;
import java.util.List;

public class MinHeap<E extends Comparable<E>> {
	private List<E> heapArr;
	
	public MinHeap() {
		heapArr = new ArrayList<>(); 
	}
	
	public boolean isEmpty() {
		return heapArr.size() == 0; 
	}
	
	public int size() {
		return heapArr.size();
	}
	
	public List<E> getHeap(){
		return heapArr;
	}
	
	private int leftChild(int pos) {
		int child = (2 * pos) + 1; 
		if (child >= heapArr.size() || child < 0) {
			return child; 
		}
		return -1;
	}
	
	private int rightChild(int pos) {
		int child = (2 * pos) + 2; 
		if (child >= heapArr.size() || child < 0) {
			return child; 
		}
		return -1; 
		// other way to write code
		// int ans = child >= heapArr.size() ? -1 : child; 
		// return ans; 
	}
	
	private int parent(int pos) {
		if (pos <= 0) {
			return -1; 
		}
		return (pos - 1) / 2; 
	}
	
	public void add(E entry) {
		heapArr.add(entry); 
		swimUp(heapArr.size() - 1); 
	}
	
	private void swimUp(int current) {
		int parent = parent(current); 
		while (current != 0) {
			if (current < parent && heapArr.get(current).compareTo(heapArr.get(parent)) < 0) {
				swap(current, parent); 
			}
			current = parent; 
			parent = parent(current); 
		}
	}
	
	private void swap(int pos1, int pos2) {
		E temp = heapArr.get(pos1);
		heapArr.set(pos1, heapArr.get(pos2)); 
		heapArr.set(pos2, temp);
	}
	
	public E remove() {
		return remove(0); 
	}
	
	public E remove(int pos) {
		swap(pos, heapArr.size() -1);
		E removedEntry = heapArr.remove(heapArr.size() - 1); 
		if (heapArr.size() > 0) {
			siftDown(pos); 
		}
		return removedEntry; 
	}
	
	private boolean isLeafNode(int pos) {
		return (pos >= heapArr.size() / 2) && (pos < heapArr.size());
	}
	private void siftDown(int current) {
		while (!isLeafNode(current)) {
			int lchild = leftChild(current);
			int rchild = rightChild(current); 
			
			E lchildEntry = heapArr.get(lchild); 
			E childEntry = lchildEntry;
			int child = lchild; 
			if (rchild > -1) {
				E rchildEntry = heapArr.get(rchild); 
				if (rchildEntry.compareTo(lchildEntry) < 0) {
					childEntry = rchildEntry; 
					child = rchild; 
				}
			}
			
			if (heapArr.get(current).compareTo(childEntry) > 0) {
				swap(current, child); 
				current = child; 
			}
			else {
				break;
			}
		}
	}
	
	P
}
