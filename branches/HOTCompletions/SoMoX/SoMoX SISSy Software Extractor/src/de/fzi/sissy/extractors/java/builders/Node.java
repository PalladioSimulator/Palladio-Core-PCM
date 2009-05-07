/**
 * Copyright (c) 2004-2006 FZI Forschungszentrum Informatik, 
 * 10-14 Haid-und-Neu Street, 76131 Karlsruhe, Germany
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA  02110-1301  USA
 */
package de.fzi.sissy.extractors.java.builders;
import java.util.Iterator;
import java.util.Vector;

/**
 * @author haller
 *
 */
public class Node {

	private Vector edges;
	
	public String toString() {
		//adjacency list
		//collect all nodes
		StringBuffer buf = new StringBuffer();
		Vector nodes = new Vector();
		nodes.addElement(this);
		
		Vector newNodes = new Vector();
		
		//here I forgot to clone() edges --> first Node had no edges!!
		Vector newEdges = (Vector) edges.clone();
		
		while (newEdges.size() != 0) {
			Iterator iter = newEdges.iterator();
			while (iter.hasNext()) {
				Edge e = (Edge) iter.next();
				if (!nodes.contains(e.getTargetNode())) newNodes.addElement(e.getTargetNode());
			}
			newEdges.clear();
			Iterator nodeIter = newNodes.iterator();
			while (nodeIter.hasNext()) {
				newEdges.addAll(((Node) nodeIter.next()).getEdges());
			}
			
			nodes.addAll(newNodes);
			newNodes.clear();
		}
		
		Iterator iter = nodes.iterator();
		while (iter.hasNext()) {
			Node n = (Node) iter.next();
			buf.append("[" + n.getExpr() + "/" + n.getEdges().size() + "] -> ");
			Iterator i = n.getEdges().iterator();
			while (i.hasNext()) {
				buf.append("[" + ((Edge) i.next()).getTargetNode().getExpr() + "], ");
			}
			buf.append("\n");
		}
		
		return buf.toString();
	}
	
	private String expr = "";
	
	public Node (String expr) {
		this.expr = expr;
		edges = new Vector ();	
	}

	public Node() {
		edges = new Vector ();
	}

	public String getExpr() {
		return expr;	
	}
	
	public void addEdge (Edge e) {
		edges.addElement (e);
	}
	
	public Vector getEdges () {
		return edges;
	}
	
	public int countNodes () {
		//BAD: infinite loop if backward edges exist (in every while loop in CFG!)
		/*for (int i = 0; i < edges.size(); i++) {
			sum += ((Edge) edges.elementAt(i)).getTargetNode ().countNodes ();
		}*/
		
		//now iterative...
		Vector nodes = new Vector();
		nodes.addElement(this);
		Vector newNodes = new Vector();
		//we don't want to remove edges from this thru newEdges.clear()!
		Vector newEdges = (Vector) edges.clone();
		
		while (newEdges.size() > 0) {
			Iterator iter = newEdges.iterator();
			while (iter.hasNext()) {
				Edge e = (Edge) iter.next();
				if (!nodes.contains(e.getTargetNode()))
					newNodes.addElement(e.getTargetNode());				
			}
			newEdges.clear();
			Iterator nodeIter = newNodes.iterator();
			while (nodeIter.hasNext()) {
				newEdges.addAll(((Node) nodeIter.next()).getEdges());
			}
			
			nodes.addAll(newNodes);
			newNodes.clear();
		}

		return nodes.size();
	}
	
	public int countEdges () {
		//BAD recursive form (backward edges!)
		/*int sum = 0;
		Vector targetNodes = new Vector ();
		
		for (int i = 0; i < edges.size (); i++) {
			sum++;
			targetNodes.addElement(((Edge) edges.elementAt (i)).getTargetNode());
		}
		
		for (int i = 0; i < targetNodes.size (); i++) {
			sum += ((Node) targetNodes.elementAt (i)).countEdges();	
		}
		
		return sum;*/
		
		//now iterative...

		//first: collect all nodes
		Vector nodes = new Vector();
		nodes.addElement(this);
		Vector newNodes = new Vector();
		//we don't want to remove edges from this thru newEdges.clear()!
		Vector newEdges = (Vector) edges.clone();
		
		while (newEdges.size() > 0) {
			Iterator iter = newEdges.iterator();
			while (iter.hasNext()) {
				Edge e = (Edge) iter.next();
				if (!nodes.contains(e.getTargetNode()))
					newNodes.addElement(e.getTargetNode());				
			}
			newEdges.clear();
			Iterator nodeIter = newNodes.iterator();
			while (nodeIter.hasNext()) {
				newEdges.addAll(((Node) nodeIter.next()).getEdges());
			}
			
			nodes.addAll(newNodes);
			newNodes.clear();
		}

		int sum = 0;
		Iterator iter = nodes.iterator();
		while (iter.hasNext()) {
			sum += ((Node) iter.next()).getEdges().size();
		}
		return sum;
	} 
}
