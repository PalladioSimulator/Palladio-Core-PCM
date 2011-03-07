package de.uka.ipd.sdq.tcfmoop.outputtree;

/**
 * Represents a Tree data structure.
 * @author Atanas Dimitrov
 */
public class Tree extends Node{

	/**
	 * Creates a new tree
	 * @param rootElementValue information stored in the root Node
	 * @param type type of the root Node.
	 */
	public Tree(String rootElementValue, NodeType type){
		super(null, rootElementValue, type);
	}
	
}