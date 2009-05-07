package de.uka.ipd.sdq.bysuite.bybench.integrity.graph;

public class IntegerVertexFactory extends VertexFactory<Integer> {
	
	private int counter;

	public IntegerVertexFactory() {
		this.counter = 0;
	}

	@Override
	public Vertex<Integer> createVertex() {
		return new Vertex<Integer>(counter++);
	}


}
