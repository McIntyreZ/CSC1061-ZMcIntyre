package edu.frcc.csc1061jsp25.ArrayAndLinkedList;

import java.util.List;

public class MyLinkedListTest {

	public static void main(String[] args) {
		List<Integer> ml = new MyLinkedList<>();
		
		ml.add(1);
		ml.add(2);
		ml.add(3);
		ml.add(4);
		ml.add(5);
		ml.add(6);
		
		for (int i = 0; i < ml.size(); i++) {
			int num = ml.get(i);
			System.out.print(num + " ");
		}
		System.out.println();
		
		ml.remove(3);
		
		for (int i = 0; i < ml.size(); i++) {
			int num = ml.get(i);
			System.out.print(num + " ");
		}
		System.out.println();

	}

}
