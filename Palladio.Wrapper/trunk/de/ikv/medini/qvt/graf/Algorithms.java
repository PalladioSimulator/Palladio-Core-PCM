/* 
 * Copyright (c) 2009 ikv++ technologies ag
 * All rights reserved.
 */
package de.ikv.medini.qvt.graf;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Different algorithms on graphs
 */
public class Algorithms {

	/**
	 * Find shortest directed path between s and t
	 * 
	 * @param s
	 * @param t
	 * @param edges
	 * @return the shortest path or <code>null</code> if no path exists
	 */
	public static List<Edge> findShortestPath(Vertex s, Vertex t, Set<Edge> edges) {
		Map<Vertex, Set<Edge>> out = Algorithms.getOutgoingEdges(edges);
		// aborescence, storing the incoming edge for a given vertex
		Map<Vertex, Edge> aborescence = new HashMap<Vertex, Edge>();
		Set<Vertex> visited = new HashSet<Vertex>();
		Set<Vertex> newVisited = new HashSet<Vertex>();
		visited.add(s);
		newVisited.add(s);
		while (!newVisited.isEmpty()) {
			Set<Vertex> newVisited2 = new HashSet<Vertex>();
			for (Vertex start : newVisited) {
				Set<Edge> outgoing = out.get(start);
				if (outgoing != null) {
					for (Edge edge : outgoing) {
						Vertex stop = edge.getStop();
						if (t.equals(stop)) {
							List<Edge> result = new ArrayList<Edge>();
							do {
								result.add(0, edge);
								edge = aborescence.get(edge.getStart());
							} while (edge != null);
							return result;
						}
						if (visited.add(stop)) {
							newVisited2.add(stop);
							aborescence.put(stop, edge);
						}
					}
				}
			}
			newVisited = newVisited2;
		}
		return null;
	}

	/**
	 * Calculates the outgoing edges
	 * 
	 * @param edges
	 * @return mapping from a node to its outgoing edges
	 */
	public static Map<Vertex, Set<Edge>> getOutgoingEdges(Set<Edge> edges) {
		Map<Vertex, Set<Edge>> result = new HashMap<Vertex, Set<Edge>>();
		for (Edge edge : edges) {
			Vertex start = edge.getStart();
			Set<Edge> stops = result.get(start);
			if (stops == null) {
				stops = new HashSet<Edge>();
				result.put(start, stops);
			}
			stops.add(edge);
		}
		return result;
	}

	/**
	 * @param edges
	 * @return the vertexes of the given edges
	 */
	public static Set<Vertex> getVertexes(Set<Edge> edges) {
		Set<Vertex> result = new HashSet<Vertex>();
		for (Edge edge : edges) {
			result.add(edge.getStart());
			result.add(edge.getStop());
		}
		return result;
	}

}
