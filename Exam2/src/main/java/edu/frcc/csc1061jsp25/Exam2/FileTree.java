package edu.frcc.csc1061jsp25.Exam2;

import java.io.File;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.Queue;

import edu.frcc.csc1061jsp25.MyBookTree.BookNode;



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
		if (fileNode.getFile().listFiles()[0] == null) {
			return; 
		}
		else {
			ArrayList<FileNode> temp = fileNode.getChildNodes();
			for (int i = 0; i < fileNode.getFile().listFiles().length; i++) {
				FileNode newNode = new FileNode(fileNode.getFile().listFiles()[i]);
				buildTree(newNode);   
				temp.add(newNode); 
			}
			fileNode.setChildNodes(temp);
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
				postOrder(child); 
			}
			queue.addLast(node); 
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
		FileNode parentNode = null; 
		
		public BreadthFirstIterator() {
			System.out.println(root); 
			breadthFirst(root, 1); 
		}
		
		private void breadthFirst(FileNode node, int count){
			
			for (int k = 0; k < count; k++){
				for (int i = 0; i < node.getChildNodes().size(); i++) {
					System.out.println(node.getChildNodes().get(i)); 
				}
			}
			
			
			
			
			
			
			
			if (node.getChildNodes().size() != 0) {
				for (FileNode child : node.getChildNodes()) {
					System.out.println(child); 
				}
				for (FileNode child : node.getChildNodes()) {
					breadthFirst(child); 
				}
			}
			
			parentNode = node; 
		}
		
		@Override
		public boolean hasNext() {
			return true;
		}

		@Override
		public FileNode next() {
			return null;
		}
		
	}
}
