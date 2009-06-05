package de.uka.ipd.sdq.bysuite.bybench.integrity.tests;

import java.io.File;
import java.util.ArrayList;
import java.util.Set;

import org.apache.log4j.Logger;
import org.jgrapht.generate.RandomGraphGenerator;
import org.jgrapht.graph.DefaultDirectedWeightedGraph;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.junit.Test;

import de.uka.ipd.sdq.bysuite.bybench.integrity.GraphIntegrityChecker;
import de.uka.ipd.sdq.bysuite.bybench.integrity.graph.ByBenchVertexRemovalStrategy;
import de.uka.ipd.sdq.bysuite.bybench.integrity.graph.IntegerVertexFactory;
import de.uka.ipd.sdq.bysuite.bybench.integrity.graph.Vertex;
import de.uka.ipd.sdq.bysuite.bybench.integrity.graph.VertexRemovalStrategy;
import junit.framework.Assert;


public class TestCycleDetection {
	private static final Logger log = Logger.getLogger(TestCycleDetection.class);
	private static final VertexRemovalStrategy<Integer, DefaultWeightedEdge> removalStrategy = 
		new ByBenchVertexRemovalStrategy<Integer, DefaultWeightedEdge>();
	
	@Test
	public void testCycleDetection() {

		DefaultDirectedWeightedGraph<Vertex<Integer>, DefaultWeightedEdge> g = 
        	new DefaultDirectedWeightedGraph<Vertex<Integer>, DefaultWeightedEdge>(DefaultWeightedEdge.class);

        // create the following graph
        // 0 -> 1 -> 2 -> 3 -> 4 -~-> 0
        
        ArrayList<Vertex<Integer>> v = new ArrayList<Vertex<Integer>>();
        for(int i = 0; i < 5; i++) {
            v.add(new Vertex<Integer>(i));
            g.addVertex(v.get(i));
        }
        g.addEdge(v.get(0), v.get(1));
        g.addEdge(v.get(1), v.get(2));
        g.addEdge(v.get(2), v.get(3));
        g.addEdge(v.get(3), v.get(4));
        g.addEdge(v.get(4), v.get(0));

        // test for cycles
		GraphIntegrityChecker<Integer> checker = 
			new GraphIntegrityChecker<Integer>(g);
		Set<Vertex<Integer>> cycleVerts = checker.detectCycles();
		
		Assert.assertEquals("Wrong number of cycle vertices detected.", 
				5, 
				cycleVerts.size());
		
		Assert.assertEquals("Unexpected number of removed vertices.", 
				1, 
				checker.cycleReduction(removalStrategy).size());
		log.info("New graph([Vertices][Edges]): " + checker.getGraph());
		
	}
	
	@Test
	public void testMultiCycleDetection() {

        DefaultDirectedWeightedGraph<Vertex<Integer>, DefaultWeightedEdge> g = 
        	new DefaultDirectedWeightedGraph<Vertex<Integer>, DefaultWeightedEdge>(DefaultWeightedEdge.class);

        // create the following graph
        //  -> 2->   <- 4
        // 0       3    ^
        //  <- 1<-   -> 5
        
        ArrayList<Vertex<Integer>> v = new ArrayList<Vertex<Integer>>();
        for(int i = 0; i < 6; i++) {
            v.add(new Vertex<Integer>(i));
            g.addVertex(v.get(i));
        }
        g.addEdge(v.get(0), v.get(2));
        g.addEdge(v.get(1), v.get(0));
        g.addEdge(v.get(2), v.get(3));
        g.addEdge(v.get(3), v.get(1));
        g.addEdge(v.get(3), v.get(5));
        g.addEdge(v.get(4), v.get(3));
        g.addEdge(v.get(5), v.get(4));
        
        // export original
        GraphIntegrityChecker.exportGraphAsDOT(g, "graphs" + File.separator + "original.dot");
        GraphIntegrityChecker.exportGraphAsPNG(g, "graphs" + File.separator + "original.png");

        // test for cycles
		GraphIntegrityChecker<Integer> checker = 
			new GraphIntegrityChecker<Integer>(g);
		Set<Vertex<Integer>> cycleVerts = checker.detectCycles();
		
		Assert.assertEquals("Wrong number of cycle vertices detected.", 6, cycleVerts.size());
		
		Assert.assertEquals("Unexpected number of removed vertices.", 1, checker.cycleReduction(removalStrategy).size());
		log.info("New graph([Vertices][Edges]): " + checker.getGraph());
			
		// export the new graph
		GraphIntegrityChecker.exportGraphAsDOT(checker.getGraph(), "graphs" + File.separator + "reduced.dot");
        GraphIntegrityChecker.exportGraphAsPNG(checker.getGraph(), "graphs" + File.separator + "reduced.png");
	}


	@Test
	public void testRandomGraph() {
		int numOfVertexes = 10;
		int numOfEdges = 15;
		RandomGraphGenerator<Vertex<Integer>, DefaultWeightedEdge> gen = 
			new RandomGraphGenerator<Vertex<Integer>, DefaultWeightedEdge>(numOfVertexes, numOfEdges);
		
		DefaultDirectedWeightedGraph<Vertex<Integer>, DefaultWeightedEdge> graph = 
			new DefaultDirectedWeightedGraph<Vertex<Integer>, DefaultWeightedEdge>(DefaultWeightedEdge.class);
		gen.generateGraph(graph, new IntegerVertexFactory(), null);
		// remove reflexive edges
		int i = 0;
		for(Vertex<Integer> v : graph.vertexSet()) {
			graph.removeAllEdges(v, v);
			i++;
		}
		log.info("Removed " + i + " reflexive edges from random graph.");

		long time = System.currentTimeMillis();
//		GraphIntegrityChecker.exportGraphAsDOT(graph, "graphs" + File.separator + time + "_randomGraph_original.dot");
		GraphIntegrityChecker.exportGraphAsPNG(graph, "graphs" + File.separator + time + "_randomGraph_original.png");
		
        // test for cycles
		GraphIntegrityChecker<Integer> checker = 
			new GraphIntegrityChecker<Integer>(graph);
		i = checker.cycleReduction(removalStrategy).size();
		log.info("Removed " + i + " vertices from the graph");

//		GraphIntegrityChecker.exportGraphAsDOT(graph, "graphs" + File.separator + time + "_randomGraph_reduced.dot");
		GraphIntegrityChecker.exportGraphAsPNG(graph, "graphs" + File.separator + time + "_randomGraph_reduced.png");
	}
}
	

