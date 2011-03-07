package de.uka.ipd.sdq.tcfmoop.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import de.uka.ipd.sdq.tcfmoop.outputtree.Node;
import de.uka.ipd.sdq.tcfmoop.outputtree.Tree;
import de.uka.ipd.sdq.tcfmoop.outputtree.Node.NodeType;

/**
 * @author Atanas Dimitrov
 *
 */
public class OutputTests {
	Tree outputTree;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		outputTree = new Tree("Root", NodeType.NON_SPECIFIC);
	}


	@Test
	public void testParentAndChildren() {
		assertFalse(outputTree.hasChildren());
		
		assertNull(outputTree.getParent());
		
		Node child1 = outputTree.addChild("Child 1", NodeType.NON_SPECIFIC);
		
		assertNotNull(child1);
		
		assertTrue(outputTree.hasChildren());
		
		assertTrue(outputTree.getChildren().size() == 1);
		
		assertTrue(child1.getParent() == outputTree);
		
		outputTree.clearChildren();
		
		assertFalse(outputTree.hasChildren());
	}

	@Test
	public void testUpdateValue() {	
		
		assertTrue(outputTree.getValue().equals("Root"));
		
		outputTree.updateValue("UpdatedRoot");
		
		assertTrue(outputTree.getValue().equals("UpdatedRoot"));
		
	}
	
	@Test
	public void testIsRoot() {	
		
		assertTrue(outputTree.isRoot());
		
		Node child1 = outputTree.addChild("Child 1", NodeType.NON_SPECIFIC);
		
		assertFalse(child1.isRoot());
		
	}

}
