package de.uka.ipd.sdq.dsexplore.newcandidates.alternativecomponents;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import org.apache.log4j.Logger;

import de.uka.ipd.sdq.dsexplore.PCMInstance;
import de.uka.ipd.sdq.pcm.core.composition.AssemblyContext;
import de.uka.ipd.sdq.pcm.repository.BasicComponent;

/**
 * A trace tree of which candidate was derived from which other one. 
 * @author Anne
 *
 */
public class EvolutionGraphNode {
	
	private static Logger logger = Logger.getLogger("de.uka.ipd.sdq.dsexplore");
	
	private PCMInstance node;
	private Map.Entry<AssemblyContext, Map<BasicComponent, ProvidedAndRequiredRoleMapping>> appliedRule;
	
	private EvolutionGraphNode parent;
	private Vector<EvolutionGraphNode> children;
	
	public EvolutionGraphNode(PCMInstance node){
		super();
		this.node = node;
		this.children = new Vector<EvolutionGraphNode>();
	}
	
	public EvolutionGraphNode(PCMInstance node, Map.Entry<AssemblyContext, Map<BasicComponent, ProvidedAndRequiredRoleMapping>> rule){
		super();
		this.node = node;
		this.children = new Vector<EvolutionGraphNode>();
		this.appliedRule = rule;
	}
	
	public EvolutionGraphNode(PCMInstance node, EvolutionGraphNode parent,
			Vector<EvolutionGraphNode> children) {
		super();
		this.node = node;
		this.parent = parent;
		this.children = children;
	}
	
	public void addChild(EvolutionGraphNode child){
		this.children.add(child);
		child.setParent(this);
	}
	
	public void addChildren(Collection<EvolutionGraphNode> children2){
		this.children.addAll(children2);
		for (EvolutionGraphNode evolutionGraphNode : children2) {
			evolutionGraphNode.setParent(this);
		}
	}
	
	public PCMInstance getNode() {
		return node;
	}
	
	public void setNode(PCMInstance node) {
		this.node = node;
	}
	
	public EvolutionGraphNode getParent() {
		return parent;
	}
	
	public void setParent(EvolutionGraphNode parent) {
		this.parent = parent;
	}
	
	public Vector<EvolutionGraphNode> getChildren() {
		return children;
	}
	
	public void setChildren(Vector<EvolutionGraphNode> children) {
		this.children = children;
	}

	/**
	 * Test this {@link EvolutionGraphNode} and recursively all its children
	 * whether one has the passed {@link PCMInstance} as a node. If on matching
	 * child is found, it returns the child {@link PCMInstance}s (no guarantee
	 * on the order if there are multiple matching ones!). If not, an empty list is returned.
	 * 
	 * @param currentSolution
	 * @return A list of children of the passed {@link PCMInstance}, which might be empty if no matching node was found. 
	 */
	public List<PCMInstance> getChildrenOf(PCMInstance currentSolution) {
		logger.debug("Retrieving alternative component candidates for PCM instance "+currentSolution.getName());
		EvolutionGraphNode node = this.getMatchingNode(currentSolution);
		List<PCMInstance> result = new ArrayList<PCMInstance>();
		if (node == null)
			return result;
		//If there is a node in the tree with this PCM instance, return all its children. 
		Vector<EvolutionGraphNode> children = node.getChildren();
		for (Iterator<EvolutionGraphNode> iterator = children.iterator(); iterator
				.hasNext();) {
			EvolutionGraphNode child = iterator.next();
			result.add(child.getNode());
			logger.debug("Found alternative candidate "+child.getNode().getName());
		}
		return result;
	}
	
	public boolean hasMatchingNode(PCMInstance instance){
		return this.getMatchingNode(instance)!= null;
	}
	
	/**
	 * Checks the evolution graph for the descendant. Two {@link PCMInstance}s are considered equal here if they have the same system (i.e. with the same URI).
	 * XXX: if I want to include changes of the resource environment etc, here, I need to update this.  
	 * @param instance
	 * @return
	 */
	private EvolutionGraphNode getMatchingNode(PCMInstance instance){
		//FIXME: This can throw a NullPointerException. 
		if (this.node.getSystemFileName().equals(instance.getSystemFileName())){
			return this;
		} else {
			//recursively test all children
			for (Iterator<EvolutionGraphNode> iterator = children.iterator(); iterator
					.hasNext();) {
				EvolutionGraphNode child = iterator.next();
				EvolutionGraphNode result = child.getMatchingNode(instance);
				if (result != null){
					return result;
				}
			}
		}
		return null;
	}

	@Override
	public String toString() {
		String string = "";
		int countDepth = 1;
		return this.nodeToString(string, countDepth);
	}

	private String nodeToString(String string, int countDepth) {
		for (int i = 0; i < countDepth; i++ ){
			string += " ";
		}
		string += node.getName()+"\n";
		countDepth++;
		for (Iterator<EvolutionGraphNode> iterator = this.children.iterator(); iterator.hasNext();) {
			EvolutionGraphNode child = iterator.next();
			string = child.nodeToString(string, countDepth);
		}
		return string;
	}
	
	

}
