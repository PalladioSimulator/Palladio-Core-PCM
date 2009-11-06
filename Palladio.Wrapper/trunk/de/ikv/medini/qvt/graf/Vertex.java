/* 
 * Copyright (c) 2009 ikv++ technologies ag
 * All rights reserved.
 */
package de.ikv.medini.qvt.graf;

/**
 * The vertex of the graph model
 */
public class Vertex {

	/**
	 * Two vertexes are considered equal if their IDs are equal
	 */
	private final Object id;

	/**
	 * The constructor
	 * 
	 * @param id
	 */
	public Vertex(Object id) {
		this.id = id;
	}

	/**
	 * Equality based on {@link #id}
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((this.id == null) ? 0 : this.id.hashCode());
		return result;
	}

	/**
	 * Equality based on {@link #id}
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (this.getClass() != obj.getClass()) {
			return false;
		}
		Vertex other = (Vertex) obj;
		if (this.id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!this.id.equals(other.id)) {
			return false;
		}
		return true;
	}

	/**
	 * @return the id
	 */
	public Object getId() {
		return this.id;
	}

}
