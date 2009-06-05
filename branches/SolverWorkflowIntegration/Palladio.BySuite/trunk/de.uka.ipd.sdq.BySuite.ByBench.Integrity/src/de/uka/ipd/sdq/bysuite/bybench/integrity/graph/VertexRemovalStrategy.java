package de.uka.ipd.sdq.bysuite.bybench.integrity.graph;

import java.util.Comparator;

import org.jgrapht.DirectedGraph;

/**
 * A {@link VertexRemovalStrategy} provides a {@link Comparator} for the given 
 * graph to help decide which vertex to remove.
 *
 * @param <V> The type of the data associated to vertices.
 */
public interface VertexRemovalStrategy<V, E> {
	
	/**
	 * This is called before all other methods are used and allows implementing 
	 * classes to save graph information.
	 * @param <E> Edge type of the graph.
	 * @param g The graph that is being operated on.
	 */
	public void initialize(final DirectedGraph<Vertex<V>, E> g);
	
	/**
	 * This method allows the strategy to veto a vertex removal.
	 * @param v Vertex to rate.
	 * @return True, if the vertex can be removed. False, if the vertex is 
	 * not to be removed under any circumstances.
	 */
	public boolean isVertexRemovable(Vertex<V> v);
	/**
	 * Implement a sorting of the vertices.
	 * @return A {@link Comparator} that allows for vertex sorting.
	 */
	public Comparator<Vertex<V>> getComparator();
	
	/**
	 * This is called when v is about to be removed from the graph.
	 * @param v The vertex that is to be removed.
	 */
	public void onRemove(Vertex<V> v);
}
