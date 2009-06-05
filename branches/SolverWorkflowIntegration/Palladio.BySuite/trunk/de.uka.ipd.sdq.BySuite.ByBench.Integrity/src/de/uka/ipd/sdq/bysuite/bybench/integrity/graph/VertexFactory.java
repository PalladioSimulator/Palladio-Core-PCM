/**
 * 
 */
package de.uka.ipd.sdq.bysuite.bybench.integrity.graph;

/**
 * {@link org.jgrapht.VertexFactory} implementation for {@link Vertex}.
 *
 */
public class VertexFactory<V> implements org.jgrapht.VertexFactory<Vertex<V>> {

	@Override
	public Vertex<V> createVertex() {
		return new Vertex<V>();
	}

}
