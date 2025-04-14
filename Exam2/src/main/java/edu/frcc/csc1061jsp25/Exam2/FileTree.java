package edu.frcc.csc1061jsp25.Exam2;

import java.io.File;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;

public class FileTree implements Iterable <FileNode> {

	private FileNode root;
	
	public FileTree(String path) {
		root = new FileNode(path);
		buildTree(root);
	}

	/**
	 * Return a depth first post-order traversal iterator 
	 */
	@Override
	public Iterator<FileNode> iterator() {

		return new DepthFirstIterator();
	}
	
	/**
	 * 	TODO for Exam 2
	 *  Use recursion to build the tree from the directory structure.
	 *  For each of node starting from the root node use listFiles() from File to get 
	 *  the list of files in that directory/folder.
	 *  Create a node for each of the files and add it to a list of child nodes for the node
	 *  Do this recursively for all the nodes.  
	 * 
	 * @param fileNode
	 */
	private void buildTree(FileNode fileNode) {
		File[] files = fileNode.getFile().listFiles(); // Will turn elements into FileNodes
		if (files == null) { // Check for child Files; base case 
			return; 
		}
		else {
			ArrayList<FileNode> temp = fileNode.getChildNodes(); // 
			for (int i = 0; i < files.length; i++) {
				FileNode newNode = new FileNode(files[i]);
				buildTree(newNode); // Recursive call with new Node 
				temp.add(newNode);  // Adds the node to the ArrayList after the recursive method returns 
			}
			fileNode.setChildNodes(temp); // Updates the childNodes ArrayList 
		}
	}
	
	/**
	 * TODO for Exam 2
	 * Iterator that does a post order traversal of the tree.
	 * For post-order traversal use the 2 stack approach outlined here: 
	 * https://www.geeksforgeeks.org/iterative-postorder-traversal/
	 * 
	 * @return 
	 */
	private class DepthFirstIterator implements Iterator<FileNode> {
		Deque<FileNode> queue = new ArrayDeque<>();
		
		public DepthFirstIterator() {
			postOrder(root); 
		}

		private void postOrder(FileNode node) {
			for(FileNode child : node.getChildNodes()) {
				postOrder(child); // Recursive call
			}
			queue.addLast(node); // Adds element after the recursive methods return
		}
		
		@Override
		public boolean hasNext() {
			return !queue.isEmpty();
		}
		
		@Override
		public FileNode next() {
			return queue.removeFirst();
		}
	}
	
	/**
	 *  Returns an iterator that does a breadth first traversal of the tree using a queue.
	 * 
	 * @return
	 */
	public Iterator<FileNode> breadthFirstIterator() {
		
		return new BreadthFirstIterator();

	}	
	
	/** 
	 * TODO for Exam 2
	 * Iterator that does a breadth first traversal of the tree using a queue.
	 * 
	 */
	private class BreadthFirstIterator implements Iterator<FileNode> {
		Deque<FileNode> queue = new ArrayDeque<>(); // For creating the breadth first sequence
		Deque<FileNode> queue2 = new ArrayDeque<>(); // The queue in which the iterator will traverse
		
		public BreadthFirstIterator() {
			queue.add(root);  // Instantiating the first element
			queue2.add(root); // Copies all queue.add() methods 
			
			while (!queue.isEmpty()) { // Will run until the queue is empty (all elements traversed)
				ArrayList<FileNode> array = queue.element().getChildNodes(); 
				
				for (int i = 0; i < array.size(); i++) {
					queue.add(array.get(i)); // Adds each child node to the queue in the "correct order" (breadth first)
				}
				
				queue2.add(queue.peekFirst()); // Adds elements breadth first 
				queue.removeFirst(); // Removes first element and restarts the loop
			}
			
		}
		
		@Override
		public boolean hasNext() {
			return !queue2.isEmpty();
		}

		@Override
		public FileNode next() {
			return queue2.remove();
		}
	}
}
