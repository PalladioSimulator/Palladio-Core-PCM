package de.uka.ipd.sdq.bysuite.bybench.integrity.graph;

/**
 * Generic vertex class.
 *
 * @param <T> The type of the data you want to associate with the vertex.
 */
public class Vertex<T> {
	
	private T data;
	private double weight;

	public Vertex() {
		this(null);
	}
	
	/**
	 * 
	 * @param data Custom vertex data.
	 */
	public Vertex(T data) {
		this.setData(data);
		this.setWeight(1.0);
	}

	/**
	 * 
	 * @param data Custom vertex data.
	 */
	public void setData(T data) {
		this.data = data;
	}

	/**
	 * @return Custom vertex data.
	 */
	public T getData() {
		return data;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		return "Vertex(" + this.data + ")";
	}

	/**
	 * 
	 * @param weight Weight of the vertex. Default is 1.0.
	 */
	public void setWeight(double weight) {
		this.weight = weight;
	}

	/**
	 * 
	 * @return Weight of the vertex. Default is 1.0.
	 */
	public double getWeight() {
		return weight;
	}
}
