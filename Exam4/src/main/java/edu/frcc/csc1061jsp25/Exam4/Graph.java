package edu.frcc.csc1061jsp25.Exam4;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.List;


public class Graph<E> {
	public List<Vertex> vertices = new ArrayList<>();
	
	class Vertex {
		private E elem;
		public List<Edge> neighbors = new ArrayList<>();
		
		public Vertex (E elem) {
			this.elem = elem;
		}

		public E getKey() {
			return elem;
		}
		
		public List<Edge> getNeighbors(){
			return neighbors;  
		}
		
		@Override
		public boolean equals(Object other) {
			if (!(other instanceof Graph.Vertex))
				return false;
			
			if (elem.equals(((Vertex)other).elem)) {
				return true;
			}
			return false;		
		}
		
		@Override 
		public String toString() {
			return elem.toString();
		}
	}

	
	private class Edge implements Comparable<Edge> {
		private Vertex s;
		private Vertex d;
		private int weight;

		public Edge(Vertex s, Vertex d, int weight) {
			this.s = s;
			this.d = d;
			this.weight = weight;
		}

		public boolean equals(Object edge) {
			return s.equals(((Edge) edge).s) && d.equals(((Edge) edge).d);
		}

		@Override
		public int compareTo(Graph<E>.Edge o) {
			return (int) (weight - o.weight);
		}
	}

	public Graph(List<Vertex> vertices) {
		for (Vertex vertex : vertices) {
			addVertex(new Vertex(vertex.getKey()));
		}
	}
	
	public Graph(List<E> vertices, E[][] edges) {
		for (E ver : vertices) {
			addVertex(new Vertex(ver));
		}
		createAdjacencyLists(edges);
	}

	public boolean addVertex(Vertex vertex) {
		if (!vertices.contains(vertex)) {
			vertices.add(vertex);
			return true;
		} else {
			return false;
		}

	}

	public boolean addEdge(Edge edge) {
		
		List<Edge> neighbors = edge.s.neighbors;
		if (!neighbors.contains(edge)) {
			neighbors.add(edge);
			return true;
		} else {
			return false;
		}
	}

	private Vertex findVertex(E key) {
		for(Vertex v : vertices) {
			if (v.elem.equals(key)) {
				return v;
			}
		}
		return null;
	}
	private void createAdjacencyLists(E[][] edges) {
		for (int i = 0; i < edges.length; i++) {
			addEdge(new Edge(findVertex(edges[i][0]), findVertex(edges[i][1]), (int)edges[i][2]));
		}
	}

	public void printEdges() {
		for (int i = 0; i < vertices.size(); i++) {
			System.out.print("Vertex: " + vertices.get(i).toString() + ":");
			List<Edge> neighbors = vertices.get(i).neighbors;
			for (Edge edge : neighbors) {
				System.out.print("(" + edge.s + ", " + edge.d + ", " + edge.weight + ")");
			}
			System.out.println();
		}
	}

	public List<Vertex> getChildNodes(Vertex vertex) {
		List<Vertex> childNodes = new ArrayList<>();
		List<Edge> neighbors = vertex.neighbors;
		for (Edge edge : neighbors) {
			childNodes.add(edge.d);
		}
		return childNodes;
	}
	
	/* TODO: Implement the DFS algorithm for a graph either recursively
	** or iteratively using a stack. It should return a list of all the 
	** vertices in the pre-order depth-first traversal.
	*/
	public List<Vertex> dfs(Vertex root) {
		// Keeps track of what nodes need to be explored next
		ArrayDeque<Vertex> stack = new ArrayDeque<>();
		// List of vertices that have been visited; in dfs order
		List<Vertex> list = new ArrayList<>(); 
		
		// Arbitrary root starts the queue
		stack.push(root); 
		
		// Only exits loop when all connected vertices are visited 
		while (!stack.isEmpty()) {
			// Removes the current vertex
			Vertex currV = stack.pop();
			// Skips if vertex has been visited
			if (!list.contains(currV)) {
				list.add(currV); 
				// Adds children of current vertex to queue  
				for (Edge child: currV.neighbors) {
					stack.push(child.d);
				}
			}
		}
		// List is in dfs order
		return list; 
	}

	/* TODO: Implement the BFS algorithm for a graph. It should return a list 
	** of all the vertices in the breadth-first traversal.
	*/
	public List<Vertex> bfs(Vertex root) {
		// Holds the vertices yet to be visited
		ArrayDeque<Vertex> queue = new ArrayDeque<>();
		// Holds visited vertices in bfs 
		List<Vertex> list = new ArrayList<>(); 
		
		// Starts with arbitrary root 
		queue.push(root); 
		
		// Only exits once all connected vertices 
		// have been explored 
		while (!queue.isEmpty()) {
			// List acts as a queue 
			Vertex currV = queue.poll();
			// Skips if vertex has been visited 
			if (!list.contains(currV)) {
				list.add(currV); 
				// Adds children to be explored 
				for (Edge child: currV.neighbors) {
					if (!list.contains(child.d)) {
						queue.add(child.d);
					}
				}
			}
		}
		// List is is bfs order 
		return list;
	}
	

	/* TODO: Create a spanning tree using Kruskal's Algorithm and return it. 
	** The spanning tree will be a new graph
	*/
	public Graph<E> findMinimumSpanningTree() {
	
		List<Vertex> minSpan = new ArrayList<>(); 
		List<Edge> edgeList = new ArrayList<>(); 
		List<Edge> minEdge = new ArrayList<>(); 
		List<Vertex> vertexCop = new ArrayList();
		
		for (Vertex vertex: vertices) {
			Vertex v = new Vertex(vertex.elem);
			vertexCop.add(v); 
		}
		
		for (int i = 0; i < vertexCop.size(); i++) {
			for (int j = 0; j < vertices.get(i).neighbors.size(); j++) {
				Edge e = new Edge(vertexCop.get((int) vertices.get(i).neighbors.get(j).s.elem), vertexCop.get((int) vertices.get(i).neighbors.get(j).d.elem), vertices.get(i).neighbors.get(j).weight);
				edgeList.add(e); 
			}
		}
		
		// Now we have a list of all edges 
		
		// Assort list from least to greatest in relation to weight
		Collections.sort(edgeList);
		
		// Assign the shortest edges first until vertices.size()-1 edges are added, 
		for (int i = 0; i < edgeList.size(); i++) {
			// if the minSpan doesnt already have the location in it 
			if (i == 0) {
				minSpan.add(edgeList.get(0).s);
			}
			// check if the minSpan already has the vertex to prevent loops
			if (!minSpan.contains(edgeList.get(i).d)) {
				minSpan.add(edgeList.get(i).d); 
				minEdge.add(edgeList.get(i)); 
			}
		}
		
		Graph<E> minGraph = new Graph<E>(vertexCop);
		
		for (int i = 0; i < minEdge.size(); i++) {
			minGraph.addEdge(minEdge.get(i));
		}
		
		for (Edge e: minEdge) {
			for (Vertex v: vertexCop) {
				if (e.s.equals(v)) {
					v.neighbors = e.s.neighbors;
				}
				else if (e.d.equals(v)) {
					v.neighbors = e.d.neighbors;
				}
			}
		}
		
		// These Sysout lines show that the MST has some data but not all data such as neighbors for 0, 4, 5
		System.out.println(vertexCop.get(1).neighbors.get(0).s + ", " + vertexCop.get(1).neighbors.get(0).d +
				", " + vertexCop.get(1).neighbors.get(0).weight);
		System.out.println(vertexCop.get(2).neighbors.get(0).s + ", " + vertexCop.get(2).neighbors.get(0).d +
				", " + vertexCop.get(2).neighbors.get(0).weight);
		System.out.println(vertexCop.get(3).neighbors.get(0).s + ", " + vertexCop.get(3).neighbors.get(0).d +
				", " + vertexCop.get(3).neighbors.get(0).weight); 
		
		
		Graph<E> finGraph = new Graph<E>(vertexCop);
		
		return finGraph;
	}
	
	private boolean addNeighbor(Edge edge) {
		edge.s.neighbors.add(edge); 
		edge.d.neighbors.add(edge); 
		return true; 
	}
}
