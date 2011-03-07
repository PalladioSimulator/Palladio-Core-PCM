package de.uka.ipd.sdq.tcfmoop.outputtree;

import java.util.ArrayList;
import java.util.List;

/**
 * Defines a Node of a tree.
 * @author Atanas Dimitrov
 */
public class Node{
	
	public enum NodeType{NON_SPECIFIC, MANAGER, TERMINATION_CRITERIA, PARAMETER, PARAMETER_GROUP, EXPRESSION, WARNING};
	
	private List<Node> children = new ArrayList<Node>();
	protected Node parent;
	private String value;
	public NodeType type; 
	
	/**
	 * Creates a new node
	 * @param parent The parent of the current node.
	 * @param value The information that should be saved in the current node
	 * @param type the type of the node. Can later be used by the representation in the GUI
	 */
	protected Node(Node parent, String value, NodeType type){
		this.parent = parent;
		this.value = value;
		this.type = type;
	}
	
	/**
	 * Returns whether the current node has any children nodes
	 * @return true if the node has children, false otherwise
	 */
	public boolean hasChildren(){
		return !children.isEmpty();
	}
	
	/**
	 * Returns a list with the children of the node. The list might be empty if
	 * the node does not have any children.
	 * @return a list with all children.
	 */
	public List<Node> getChildren(){
		return this.children;
	}
	
	/**
	 * Returns whether the current node is a root of a tree.
	 * @return true if the node is root, false otherwise.
	 */
	public boolean isRoot(){
		return parent == null;
	}
	
	/**
	 * Returns the parent node of the current node.
	 * Null might be returned if the node is a root node
	 * @return the parent of the current node or null
	 */
	public Node getParent(){
		return this.parent;
	}
	
	/**
	 * Returns the information saved in the current node.
	 * @return the information saved in the current string
	 */
	public String getValue(){
		return this.value;
	}
	
	/**
	 * Add a children node to the current node.
	 * @param value the information that will be stored in the child node
	 * @param type the type of the child node
	 * @return the child node
	 */
	public Node addChild(String value, NodeType type){
		Node newNode = new Node(this, value, type);
		children.add(newNode);
		return newNode;
	}
	
	/**
	 * Clear the list of child nodes of the current node.
	 */
	public void clearChildren(){
		this.children.clear();
	}
	
	/**
	 * Attach a sub tree to the current node
	 * @param tree the sub tree to be attached
	 */
	public void attachSubtree(Tree tree){
		this.children.add(tree);
		tree.parent = this;
	}
	
	/**
	 * Update the information saved in the current node
	 * @param newValue the new information to be saved in the node
	 */
	public void updateValue(String newValue){
		this.value = newValue;
	}
	
	/**
	 * Returns the type of the node
	 * @return the type of the node
	 */
	public NodeType getType(){
		return this.type;
	}
	
	/**]
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		return value;
	}
	
	/**
	 * Builds a tree like String representation of the current node and its
	 * entire subtree by using a tree prefix to simulate tree levels 
	 * @param treePrefix the prefix to use
	 * @param prefixOccurance occurrence of the prefix on level 0 (root level). Usually 0
	 * @return the tree like String representation of the node and its subtree
	 */
	public String subTreeToString(String treePrefix, int prefixOccurance){
		
		StringBuilder prefix = new StringBuilder();
		for(int i = 0; i < prefixOccurance; i++){
			prefix.append(treePrefix);
		}
		
		String eol = System.getProperty( "line.separator" );
		
		if(this.hasChildren()){
			StringBuilder sb = new StringBuilder(prefix.toString() + this.toString() + eol);
			for(Node n : this.getChildren()){
				sb.append(n.subTreeToString(treePrefix, prefixOccurance + 1));
			}
			return sb.toString();
		}else{
			return prefix.toString() + this.toString() + eol;
		}
	}
	
}
