package de.uka.ipd.sdq.bysuite.bybench.integrity.graph;

import java.util.Comparator;
import java.util.Set;

import org.jgrapht.DirectedGraph;
import org.jgrapht.alg.CycleDetector;
import org.jgrapht.graph.DefaultDirectedGraph;
import org.jgrapht.graph.DefaultDirectedWeightedGraph;
import org.jgrapht.graph.DefaultWeightedEdge;

/**
 * {@link VertexRemovalStrategy} for the purposes of ByBench.
 * ByBench specific logic should be implemented here.
 */
public class ByBenchVertexRemovalStrategy<V, E> implements VertexRemovalStrategy<V, E> {
	/**
	 * Default value for maxEdgeWeightForEdgeRemoval
	 */
	private static final int DEFAULT_EDGE_REMOVAL_THRESHOLD = 10;
	/**
	 * If an edge has more than this weight, it will not be removed by the 
	 * cycle removal algorithm.
	 */
	private int maxEdgeWeightForEdgeRemoval = DEFAULT_EDGE_REMOVAL_THRESHOLD;
	private DirectedGraph<Vertex<V>, E> graph;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void initialize(DirectedGraph<Vertex<V>, E> g) {
		this.graph = g;		
	}


	/**
	 * {@inheritDoc}
	 */
	@Override
	public Comparator<Vertex<V>> getComparator() {
		// A Comparator based on the sum of increase in vertex weights.
		final Comparator<Vertex<V>> vertexWeightComparator = new Comparator<Vertex<V>>() {
			@Override
			public int compare(Vertex<V> v1, Vertex<V> v2) {
				int c1 = getVertexWeightIncreaseWithoutVertex(v1);
				int c2 = getVertexWeightIncreaseWithoutVertex(v2);
				//log.debug(v1 + ": " + c1 + ", " + v2 + ": " + c2);
				if(c1 == c2) {
					return 0;
				} else if (c1 < c2) {
					return -1;
				} else if (c1 > c2) {
					return 1;
				}
				// this can never happen but the compiler complains otherwise.
				return 0;
			}
		};
		
		// A Comparator based on the number of cycles that can be resolved 
		// by removing a specific vertex.
		final Comparator<Vertex<V>> cycleInvolvementComparator = new Comparator<Vertex<V>>() {
			@Override
			public int compare(Vertex<V> v1, Vertex<V> v2) {
				int c1 = getNumberOfCycleVerticesWithoutVertex(v1);
				int c2 = getNumberOfCycleVerticesWithoutVertex(v2);
				//log.debug(v1 + ": " + c1 + ", " + v2 + ": " + c2);
				if(c1 == c2) {
					// now let the vertexWeightComparator decide
					return vertexWeightComparator.compare(v1,v2);
				} else if (c1 < c2) {
					return -1;
				} else if (c1 > c2) {
					return 1;
				}
				// this can never happen but the compiler complains otherwise.
				return 0;
			}
		};
		return cycleInvolvementComparator;
	}


	/**
	 * 
	 * @param v The vertex in the graph.
	 * @return The sum of the edge weights of all incoming edges of v.
	 */
	protected int getVertexWeightIncreaseWithoutVertex(Vertex<V> v) {
		Set<E> incomingEdges = this.graph.incomingEdgesOf(v);
		int sum = 0;
		for(E edge : incomingEdges) {
			//Vertex<V> source = this.graph.getEdgeSource(edge);
			sum += this.graph.getEdgeWeight(edge);
			
		}
		
		return sum;
	}


	@SuppressWarnings("unchecked")
	/**
	 * @param v A vertex in the graph.
	 * @return The number of cycles left, when v is removed from the graph.
	 * A low return value means the vertex is a good choice for cycle removal.
	 */
	protected int getNumberOfCycleVerticesWithoutVertex(Vertex<V> v) {
		// Make a copy of the graph and remove v.
		// this asks for trouble :)
		DefaultDirectedWeightedGraph<Vertex<V>, DefaultWeightedEdge> g = 
			(DefaultDirectedWeightedGraph<Vertex<V>, DefaultWeightedEdge>)
			((DefaultDirectedGraph) this.graph).clone();
		g.removeVertex(v);
		// Now return the number of cycles in the reduced graph.
		CycleDetector<Vertex<V>, DefaultWeightedEdge> d = 
			new CycleDetector<Vertex<V>, DefaultWeightedEdge>(g);
		return d.findCycles().size();
	}


	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isVertexRemovable(Vertex<V> v) {
		// don't remove vertices where a incoming edge has more weight than
		// the threshold (i.e. maxEdgeWeightForEdgeRemoval) allows.
		for(E e : this.graph.incomingEdgesOf(v)) {
			if(this.graph.getEdgeWeight(e) > this.maxEdgeWeightForEdgeRemoval) {
				return false;
			}
		}
		return true;
	}


	@Override
	public void onRemove(Vertex<V> v) {
		Set<E> incomingEdges = this.graph.incomingEdgesOf(v);
		for(E edge : incomingEdges) {
			Vertex<V> source = this.graph.getEdgeSource(edge);
			// increase the vertex weight
			source.setWeight(source.getWeight() + graph.getEdgeWeight(edge));
		}
	}

}
