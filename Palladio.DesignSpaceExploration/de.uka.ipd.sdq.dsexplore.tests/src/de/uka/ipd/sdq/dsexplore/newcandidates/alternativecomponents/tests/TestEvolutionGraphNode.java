package de.uka.ipd.sdq.dsexplore.newcandidates.alternativecomponents.tests;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.Vector;

import org.junit.BeforeClass;
import org.junit.Test;

import de.uka.ipd.sdq.dsexplore.PCMInstance;
import de.uka.ipd.sdq.dsexplore.newcandidates.alternativecomponents.EvolutionGraphNode;

public class TestEvolutionGraphNode {
	
	private static PCMInstance pcm1;
	private static EvolutionGraphNode node;
	private static PCMInstance pcm2;
	private static EvolutionGraphNode node2;
	private static PCMInstance pcm3;
	private static EvolutionGraphNode node3;
	private static PCMInstance pcm4;
	private static EvolutionGraphNode node4;
	private static PCMInstance pcm5;

	/**
	 * {@inheritDoc}
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		/** for testing descendants */
		pcm1 =  new PCMInstance();
		pcm1.setName("pcm1");
		node = new EvolutionGraphNode(pcm1);
		
		pcm2 =  new PCMInstance();
		pcm2.setName("pcm2");
		node2 = new EvolutionGraphNode(pcm2);
		
		pcm3 =  new PCMInstance();
		pcm3.setName("pcm3");
		node3 = new EvolutionGraphNode(pcm3);
		
		pcm4 =  new PCMInstance();
		pcm4.setName("pcm4");
		node4 = new EvolutionGraphNode(pcm4);
		
		pcm5 = new PCMInstance();
		pcm5.setName("pcm5");
		
		//put 4 in 3
		node3.addChild(node4);
		
		//put 2 and 3 in 1 
		Vector<EvolutionGraphNode> vector = new Vector<EvolutionGraphNode>();
		vector.add(node2);
		vector.add(node3);		
		node.addChildren(vector);
	}

	@Test
	public void testAddChild() {
		EvolutionGraphNode node = new EvolutionGraphNode(new PCMInstance());
		EvolutionGraphNode node2 = new EvolutionGraphNode(new PCMInstance());
		
		node.addChild(node2);
		
		assertNotNull(node.getChildren());
		assertEquals(1, node.getChildren().size());
		assertSame(node2, node.getChildren().get(0));
	}

	@Test
	public void testAddChildren() {
		EvolutionGraphNode node = new EvolutionGraphNode(new PCMInstance());
		EvolutionGraphNode node2 = new EvolutionGraphNode(new PCMInstance());
		EvolutionGraphNode node3 = new EvolutionGraphNode(new PCMInstance());
		
		Vector<EvolutionGraphNode> vector = new Vector<EvolutionGraphNode>();
		vector.add(node2);
		vector.add(node3);
		
		node.addChildren(vector);
		
		assertNotNull(node.getChildren());
		assertEquals(2, node.getChildren().size());
		assertSame(node2, node.getChildren().get(0));
		assertSame(node3, node.getChildren().get(1));
	}



	@Test
	public void testGetChildrenOf() {
	
		List<PCMInstance>  list = node.getChildrenOf(pcm1);
		assertNotNull(list);
		assertEquals(2, list.size());
		assertTrue(list.get(0) == pcm2 || list.get(1) == pcm2);
		assertTrue(list.get(0) == pcm3 || list.get(1) == pcm3);
		
		list = node.getChildrenOf(pcm3);
		assertNotNull(list);
		assertEquals(1, list.size());
		assertSame(pcm4, list.get(0));
		
		list = node.getChildrenOf(pcm5);
		assertNull(list);
		

	}

	@Test
	public void testHasDescendant() {
		assertTrue(node.hasDescendant(pcm2));
		assertTrue(node.hasDescendant(pcm3));
		assertTrue(node.hasDescendant(pcm4));
		assertFalse(node.hasDescendant(pcm5)); 
	}

	@Test
	public void testToString() {
		assertEquals(" pcm1\n"+
				"  pcm2\n"+
				"  pcm3\n"+
				"   pcm4\n", node.toString());
	}

}
