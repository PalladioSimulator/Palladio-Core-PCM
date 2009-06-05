/**
 * 
 */
package de.uka.ipd.sdq.bysuite.bybench.integrity;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.jgrapht.WeightedGraph;
import org.jgrapht.alg.CycleDetector;
import org.jgrapht.ext.DOTExporter;
import org.jgrapht.ext.EdgeNameProvider;
import org.jgrapht.ext.VertexNameProvider;
import org.jgrapht.graph.DefaultDirectedWeightedGraph;
import org.jgrapht.graph.DefaultWeightedEdge;

import de.uka.ipd.sdq.bysuite.bybench.integrity.graph.Vertex;
import de.uka.ipd.sdq.bysuite.bybench.integrity.graph.VertexRemovalStrategy;

/**
 * Main class for running the integrity checks.
 *
 */
public class GraphIntegrityChecker<V> {
	
	/**
	 * Log4j logger.
	 */
	private static final Logger log = Logger.getLogger(GraphIntegrityChecker.class);
	
	/**
	 * Static log4j configuration.
	 */
	@SuppressWarnings("unused")
	private static final Object requireLog4j = configureLog4j();	// make sure that log4j is configured

	/**
	 * The {@link CycleDetector} instance used for cycle removal.
	 */
	private CycleDetector<Vertex<V>, DefaultWeightedEdge> detector;

	/**
	 * The graph that all methods operate on.
	 */
	private DefaultDirectedWeightedGraph<Vertex<V>, DefaultWeightedEdge> graph;
	
	/**
	 * Set up log4j using the property file.
	 */
	private static Object configureLog4j() {
		// setup log4j
		PropertyConfigurator.configure("log4j.properties");
		return null;
	}
	
	public GraphIntegrityChecker(
			DefaultDirectedWeightedGraph<Vertex<V>, 
			DefaultWeightedEdge> graph) {
		this.graph = graph;
		this.detector = new CycleDetector<Vertex<V>, DefaultWeightedEdge>(this.graph);
	}
	
	public Set<Vertex<V>> detectCycles() {
		Set<Vertex<V>> cycleVertices = detector.findCycles();
		return cycleVertices;
	}
	
	/**
	 * Remove vertices from the graph to remove all cycles. The order in which 
	 * the vertices are removed is determined by the removalStrategy.
	 * @param removalStrategy This {@link VertexRemovalStrategy} is used to 
	 * determine which vertex is the next to be removed by the algorithm, 
	 * i.e. the minimum vertex according to this removalStrategy.
	 * @return All vertices that have been removed from the graph to reduce 
	 * the number of cycles.
	 */
	public Set<Vertex<V>> cycleReduction(
			VertexRemovalStrategy<V, 
			DefaultWeightedEdge> removalStrategy) {
		// initialize the strategy
		removalStrategy.initialize(this.graph);
		Comparator<Vertex<V>> removalComparator = removalStrategy.getComparator();
		
		// now remove vertices if necessary
		Set<Vertex<V>> removedVertices = new HashSet<Vertex<V>>();
		boolean hasCyclesToRemove = true;
		while(hasCyclesToRemove) {
			ArrayList<Vertex<V>> cycleVertices = 
				new ArrayList<Vertex<V>>(detector.findCycles());
			if(cycleVertices.size() == 0) {
				hasCyclesToRemove = false;
				log.info("No more cycles exist. Done.");
				break;
			}
			if(log.getEffectiveLevel().isGreaterOrEqual(Level.DEBUG)) {
				Collections.sort(cycleVertices, removalComparator);
				log.debug("Sorted vertices: " + cycleVertices);
			}
			
			// get the minimum and remove it
			// we cannot use Collections.min(), because we have elements
			// that must not be returned (not removable).
			Vertex<V> minElem = getMinimumRemovableVertex(removalStrategy,
					cycleVertices);
			if(minElem != null) {
				removalStrategy.onRemove(minElem);
				this.graph.removeVertex(minElem);
				removedVertices.add(minElem);
				log.info("Removing " + minElem);
			} else {
				log.error("Cannot remove any more vertices, because no vertices are removable.");
			}
		}
		return removedVertices;
	}

	/**
	 * Select the minimum vertex.
	 * @param removalStrategy The {@link VertexRemovalStrategy} that determines,
	 * how vertices are removed.
	 * @param vertices The vertices from which the minimum is selected.
	 * @return The minimum {@link Vertex} that can be removed from the graph. 
	 * Null if no such vertex exists in vertice.
	 */
	private Vertex<V> getMinimumRemovableVertex(
			VertexRemovalStrategy<V, DefaultWeightedEdge> removalStrategy,
			List<Vertex<V>> vertices) {
		// get a removable vertex to compare against
		Vertex<V> minElem = null;
		for(Vertex<V> v : vertices) {
			if(removalStrategy.isVertexRemovable(v)) {
				minElem = v;
				break;
			}
		}

		if(minElem == null) {
			// we could not even find a vertex; return null
			return null;
		} else {
			// get the minimum removable element by comparing the 
			// current minimum to all other vertices.
			for(Vertex<V> v : vertices) {
				if(removalStrategy.isVertexRemovable(v) &&
						removalStrategy.getComparator().compare(minElem, v) == 1) {
					minElem = v;
				}
			}
		}
		return minElem;
	}
		
	/**
	 * @return The graph that is used for this {@link GraphIntegrityChecker}.
	 */
	public DefaultDirectedWeightedGraph<Vertex<V>, DefaultWeightedEdge> getGraph() {
		return graph;
	}

	/**
	 * @param graph The graph to check.
	 */
	public void setGraph(DefaultDirectedWeightedGraph<Vertex<V>, DefaultWeightedEdge> graph) {
		this.graph = graph;
	}
	
	/**
	 * Export the graph as a .dot file.
	 * @param g Graph to export.
	 * @param filename Filename of the output graph.
	 */
	public static<V,E> void exportGraphAsDOT(final WeightedGraph<Vertex<V>, E> g, String filename) {
		DOTExporter<Vertex<V>, E> exp = new DOTExporter<Vertex<V>, E>(
				new VertexNameProvider<Vertex<V>>() {
					@Override
					// Vertex ids:
					public String getVertexName(Vertex<V> v) {
						return v.getData().toString();
					}
				}, new VertexNameProvider<Vertex<V>>() {
					@Override
					// Vertex labels:
					public String getVertexName(Vertex<V> v) {
						return v.getData().toString() + " [" + v.getWeight() + "]";
					}			
				}, new EdgeNameProvider<E>() {
					@Override
					// Edge labels:
					public String getEdgeName(E edge) {
						return "" + g.getEdgeWeight(edge);
					}
				});
		try {
			exp.export(new FileWriter(filename), g);
		} catch (IOException e) {
			log.error("Could not export graph to DOT.");
			e.printStackTrace();
		}
	}

	/**
	 * Export graph to a png file. This requires the 'dot' tool from the 
	 * graphviz package to be available!
	 * @param graph Graph to export.
	 * @param filename Filename of the .png file.
	 */
	public static void exportGraphAsPNG(
			DefaultDirectedWeightedGraph<Vertex<Integer>, DefaultWeightedEdge> graph,
			String filename) {
		File tmpDot = null;
		try {
			// write the .dot file to a temporary file
			tmpDot = File.createTempFile("graphintegrity_", ".dot.tmp");
			exportGraphAsDOT(graph, tmpDot.getCanonicalPath());
			tmpDot.deleteOnExit();
		} catch (IOException e) {
			log.error("Could not create temporary file for .png export.");
			e.printStackTrace();
		}
		if(tmpDot != null) {
			try {
				// run dot to convert the .dot file to a .png
				String cmd = "dot -Tpng -o" + filename + " " 
				+ tmpDot.getCanonicalPath();
				log.debug(cmd);
				Runtime.getRuntime().exec(cmd);
			} catch (IOException e) {
				log.error("Could not convert .dot file to .png");
				log.error("Please make sure that the 'dot' tool from graphviz is available.");
				e.printStackTrace();
			}			
		}
	}
}
