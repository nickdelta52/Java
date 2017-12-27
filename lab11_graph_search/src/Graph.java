import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/* Generic vertex class */
class Vertex<T> {
	public T data;
	public boolean visited;
	public int a;
	public Vertex() {
		data = null; visited = false; a = -1;
	}
	public Vertex(T _data) {
		data = _data; visited = false; a = -1;
	}
	public String toString() {
		return data.toString();
	}
	
	/* Declare any additional vertex attribute you may need */
}

public class Graph<T> {
	// array of vertices
	protected ArrayList<Vertex<T>> verts;
	

	/* 2D array representing adjacency matrix of an unweighted graph.
	 * If adjMat[i][j] is true, there is an edge from vertex i to j;
	 * otherwise the element adjMat[i][j] is false.
	 */
	protected boolean[][] adjMat;
	
	public Graph(ArrayList<Vertex<T>> _verts, boolean[][] _mat) {
		/* check the validity of input parameters */
		int nverts = _verts.size();
		// adjacency matrix must be square matrix of NxN
		if(_mat.length != nverts) return;
		for(int i=0;i<nverts;i++) {
			if(_mat[i].length != nverts) return;
		}
		verts = _verts;
		adjMat = _mat;
	}
	
	public int numVerts() { return verts.size(); }

	// Return the next unvisited neighbor of a given vertex
	protected int getNextUnvisitedNeighbor (int vid) {
		for (int j=0; j<numVerts(); j++) {
			if(adjMat[vid][j] && verts.get(j).visited == false)  return j;
		}
	    return -1;    // return index -1 if none found
	}
	
	// Print out the graph, including vertex list and adjacency matrix
	public void print() {
		int nverts = numVerts();
		System.out.println("Vertex List:");
		for(int i=0;i<nverts;i++) {
			System.out.println(i+": "+verts.get(i)+" (valence: "+valence(i)+")");
		}
		System.out.println("Adjacency Matrix:");
		for(int i=0;i<nverts;i++) {
			for(int j=0;j<nverts;j++) {
				System.out.print(adjMat[i][j]?"1 ":"0 ");
			}
			System.out.println("");
		}
	}
	
	/* TODO: Make this a complete graph. All you need to do is to
	 * modify the adjMat according to the definition of a complete
	 * graph, that is, there is an edge between every two vertices,
	 * but there is no self-loop (no vertex is connected to itself).
	 */
	public void completeGraph() {
		for(int i=0;i<numVerts();i++) {
			for(int j=0;j<numVerts();j++) {
				if (i!=j) { adjMat[i][j] = true; }
			}
		}

		
	}
	
	/* TODO: Return the number of neighbors (i.e. valence) of a given vertex */
	public int valence(int vid) {
		int count = 0;
		for (int i = 0; i < numVerts(); i++) {
			if (adjMat[vid][i] == true) count++;
		}
		return count;

		
	}
	
	/* TODO: Perform DFS from start vertex, and print out all vertices visited.
	 * When printing vertices, use System.out.print(verts.get(index).data+" ");
	 * to create a space between every two vertices.
	 */
	public void DFS(int start) {
		for(int i=0;i<numVerts();i++) verts.get(i).visited=false;	// clears flags
		Stack<Integer> stack = new Stack<Integer>();	// create stack
		stack.push(start);
		while(!stack.isEmpty()) {
			int index = stack.pop();
			if (verts.get(index).visited==true) continue;
			System.out.print(verts.get(index).data + " ");
			verts.get(index).visited=true;
			for (int i = numVerts()-1; i >= 0; i--) {
				if (adjMat[index][i] == true && verts.get(i).visited==false) {
					stack.push(i);
				}
			}
		}

	}
	
	/* TODO: find the path from start vertex to end vertex using BFS.
	 * If the path exists, return the path in an Arraylist, where the
	 * first element must be start, and the last element must be end,
	 * and the intermediate vertices must be the indices of vertices
	 * that are on the path from start to end.
	 * If the path doesn't exist, return null.
	 */
	public ArrayList<Integer> findPathBFS(int start, int end) {
		for(int i=0;i<numVerts();i++) verts.get(i).visited=false;	// clear flags
		Queue<Integer> queue = new LinkedList<Integer>();	// create queue
		queue.add(start);
		verts.get(start).visited=true;
		boolean found = false;
		while(!queue.isEmpty()) {
			int index = queue.remove();
			if (index == end) {
				found = true;
				break;
			}
			for (int i = numVerts()-1; i >= 0; i--) {
				if (adjMat[index][i] == true && verts.get(i).visited==false) {
					queue.add(i);
					verts.get(i).visited=true;
					verts.get(i).a = index;
				}
			}
		}
		if (found == false) return null;
		ArrayList<Integer> pathBack = new ArrayList<Integer>();
		pathBack.add(end);
		while(verts.get(end).a != -1) {
			pathBack.add(verts.get(end).a);
			end = verts.get(end).a;
		}
		ArrayList<Integer> path = new ArrayList<Integer>();
		for(int i = pathBack.size()-1; i >= 0; i--) {
			path.add(pathBack.get(i));
		}
		return path;
	}

}
