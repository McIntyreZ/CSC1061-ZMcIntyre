package edu.frcc.csc1061jsp25.ArrayAndLinkedList;

import com.sun.tools.javac.util.List;

public class MyDoublyLinkedListTest {

	public static void main(String[] args) {
		List<Integer> ml = new MyDoublyLinkedList<>();
		
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
		
		for (Integer num: ml) {
			System.out.print(num + " "); 
		}
		System.out.println();
		
		
	}

}
