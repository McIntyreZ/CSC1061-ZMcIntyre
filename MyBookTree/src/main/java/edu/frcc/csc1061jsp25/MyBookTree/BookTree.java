package edu.frcc.csc1061jsp25.MyBookTree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;

public class BookTree implements Iterable<BookNode>{
	private BookNode root; 
	
	public BookTree(String title) {
		root = new BookNode(title, 0, 0, 0); 
	}

	public BookNode getBook() {
		return root;
	}
	
	public boolean addBookNode(String title, int cNum, int sNum, int ssNum) {
		BookNode node = new BookNode(title, cNum, sNum, ssNum); 
		
		// Is this a chapter?
		if (sNum == 0) {
			root.getChildNodes().add(node); 
			Collections.sort(root.getChildNodes());
			return true; 
		}
		
		// Is this a section?
		if (ssNum == 0) {
			for (BookNode cNode : root.getChildNodes()) {
				if (cNode.getChapNum() == cNum) {
					cNode.getChildNodes().add(node); 
					Collections.sort(cNode.getChildNodes());
					return true;
				}
			}
		}
		
		for (BookNode cNode: root.getChildNodes()) {
			if (cNode.getChapNum() == cNum) {
				for (BookNode sNode : cNode.getChildNodes()) {
					if (sNode.getSecNum() == sNum) {
						sNode.getChildNodes().add(node);
						Collections.sort(sNode.getChildNodes());
						return true; 
					}
				}
				return true; 
			}
		}
		
		return false; 
	}

	@Override
	public Iterator<BookNode> iterator() {
		return new RecursiveIterator(root);
	}
	
	// Pre order traversal of the tree 
	private class RecursiveIterator implements Iterator<BookNode> {
		Deque<BookNode> queue = new ArrayDeque<>(); 
		
		public RecursiveIterator(BookNode node) {
			preorder(node); 
		}
		
		private void preorder(BookNode node) {
			
			queue.addLast(node);
//			if (node.getChildNodes() == null || node.getChildNodes().isEmpty()) { // Failsafe base case if for each loop doesn't behave as intended
//				
//				return; 
//			}
			for(BookNode child : node.getChildNodes()) {
				preorder(child); 
			}
		}
		
		// Post order traversal of the tree
//		private void postorder(BookNode node) {
//			
//			// Preorder traversal has queue.addLast(node) here 
//			// if (node.getChildNodes() == null || node.getChildNodes().isEmpty()) { // Failsafe base case if for each loop doesn't behave as intended
//				
//				// return; 
//			// }
//			for(BookNode child : node.getChildNodes()) {
//				postorder(child); 
//			}
//			queue.addLast(node); // Only difference is this line is at end instead of beginning of method
//		}
		
		@Override
		public boolean hasNext() {
			return !queue.isEmpty(); 
		}

		@Override
		public BookNode next() {
			return queue.removeFirst(); 
		}
		
	}

	private class BookNodeIterator implements Iterator<BookNode> {
		Deque<BookNode> stack;
	
		public BookNodeIterator(BookNode node) {
			stack = new ArrayDeque<>(); 
			stack.push(node); 
		}

		@Override
		public boolean hasNext() {
			return !stack.isEmpty();
		}

		@Override
		public BookNode next() {
			BookNode node = stack.pop(); 
			
			List<BookNode> children = node.getChildNodes();
			List<BookNode> listCopy = new ArrayList<>(children); 
			Collections.reverse(listCopy); 
			
			for (BookNode child: listCopy) {
				stack.push(child);
			}
			
			return node; 
		}
		
		
		
	}
	
}
