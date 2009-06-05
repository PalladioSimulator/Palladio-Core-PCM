package de.uka.ipd.sdq.bysuite.bybench.integrity.graph;

import org.jgrapht.DirectedGraph;
import org.jgrapht.graph.DefaultDirectedGraph;
import org.jgrapht.graph.DefaultEdge;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 * Class to help graph generation from different representations.
 *
 */
public class GraphFactory {
	/**
	 * Construct a graph from an matrix (i.e. an adjacency matrix).
	 * @param <V> The type of the data associated with the vertices.
	 * @param m A matrix where, based on entry m[i][j], the function decides 
	 * whether there is an edge between vertex i and vertex j.
	 * @return The constructed graph.
	 */
	public static<V> DirectedGraph<Vertex<V>, DefaultEdge> constructFromMatrix(int[][] m) {
		for(int i = 0; i < m.length; i++) {
			for(int j = 0; j < m[i].length; j++) {
				if(m[i][j] > 0) {
//					g.addEdge(new DefaultEdge(v1, v2));
				}
			}
		}
		throw new NotImplementedException();
	}
	
	/**
	 * Construct a graph from a list of edges.
	 * @param <V> The type of the data associated with vertices.
	 * @param edgeList A list of edges in the format edgeList[n][2], so that each
	 * of the n entries is an entry of type V and dimension 2.
	 * @return The constructed graph.
	 */
	public static<V> DirectedGraph<Vertex<V>, DefaultEdge> constructFromEdgeList(V[][] edgeList) {
		assert edgeList != null : "edgeList must not be null";
		assert edgeList[0].length == 2 : "edgeList must be of the format edgeList[n][2]";
		DirectedGraph<Vertex<V>, DefaultEdge> result = new DefaultDirectedGraph<Vertex<V>, DefaultEdge>(DefaultEdge.class);
		// add all vertices and edges to the graph
		for(V[] e : edgeList) {
			Vertex<V> v1 = new Vertex<V>(e[0]);
			Vertex<V> v2 = new Vertex<V>(e[1]);
			// addVertex with an already existing vertex returns false and does nothing
			result.addVertex(v1);
			result.addVertex(v2);
			result.addEdge(v1, v2);
		}
		return result;
	}
}

