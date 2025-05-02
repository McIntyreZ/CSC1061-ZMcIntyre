package edu.frcc.csc1061jsp25.MinHeap;

import java.util.Collections;
import java.util.PriorityQueue;

public class MinHeapTest {

	public static void main(String[] args) {
		
		int[] nodes = {88, 85, 83, 72, 73, 42, 57, 6, 48, 60}; 
		
		// For Min Heap
		MinHeap<Integer> minHeap = new MinHeap<>(); 
		
		for (int node: nodes) {
			minHeap.add(node); 
		}
		
		System.out.println("MinHeap Removal"); 
		while(!minHeap.isEmpty()) {
			System.out.print(minHeap.remove() + " ");
		}
		System.out.println(); 

		// For Priority Queue
		PriorityQueue<Integer> qheap = new PriorityQueue<>(); 
		for (int node: nodes) {
			qheap.add(node); 
		}
		
		System.out.println("PQ Removal: "); 
		while (!qheap.isEmpty()) {
			System.out.print(qheap.remove() + " "); 
		}
		System.out.println();
		
		// For Max Heap
		PriorityQueue<Integer> maxheap = new PriorityQueue<>(Collections.reverseOrder()); 
		for (int node: nodes) {
			maxheap.add(node); 
		}
		
		System.out.println("MPQ Removal: "); 
		while (!maxheap.isEmpty()) {
			System.out.print(maxheap.remove() + " "); 
		}
		System.out.println();
		
	}

}
