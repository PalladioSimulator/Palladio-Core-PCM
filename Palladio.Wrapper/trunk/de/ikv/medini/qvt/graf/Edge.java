/* 
 * Copyright (c) 2009 ikv++ technologies ag
 * All rights reserved.
 */
package de.ikv.medini.qvt.graf;

/**
 * The edge of the graph model
 */
public class Edge {

	private final Vertex start;

	private final Vertex stop;

	/**
	 * The constructor
	 * 
	 * @param start
	 * @param stop
	 */
	public Edge(Vertex start, Vertex stop) {
		this.start = start;
		this.stop = stop;
	}

	/**
	 * Equality based on {@link #start} and {@link #stop}
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((this.start == null) ? 0 : this.start.hashCode());
		result = prime * result + ((this.stop == null) ? 0 : this.stop.hashCode());
		return result;
	}

	/**
	 * Equality based on {@link #start} and {@link #stop}
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
		Edge other = (Edge) obj;
		if (this.start == null) {
			if (other.start != null) {
				return false;
			}
		} else if (!this.start.equals(other.start)) {
			return false;
		}
		if (this.stop == null) {
			if (other.stop != null) {
				return false;
			}
		} else if (!this.stop.equals(other.stop)) {
			return false;
		}
		return true;
	}

	/**
	 * @return the start
	 */
	public Vertex getStart() {
		return this.start;
	}

	/**
	 * @return the stop
	 */
	public Vertex getStop() {
		return this.stop;
	}

}
