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

import recoder.java.Statement;
import recoder.java.StatementBlock;
import recoder.java.StatementContainer;
import recoder.java.declaration.MethodDeclaration;
import recoder.java.statement.Branch;
import recoder.java.statement.For;
import recoder.java.statement.If;
import recoder.java.statement.LoopStatement;
import recoder.java.statement.Switch;
import recoder.java.statement.While;

/**
 * @author haller
 */
public class CFGBuilder {

	public Node buildCFG(MethodDeclaration methodDecl) {
		StatementBlock block = methodDecl.getBody();
		if (block != null) {
			Statement[] stmts = block.getBody().toArray(new Statement[0]);
			Node n = buildSubNode(stmts);
			Vector beforeEndNodes = getNodesBeforeEndNode(n);
			removeEdgesToEndNode(beforeEndNodes);
			return n;
		}
		else {
			return new Node();
		}
	}
	
	//completely new Version of CFG calculation
	//Works for if, for, while, switch.
	public Node buildSubNode(Statement[] stmts) {
		Vector oldNodes = new Vector();
		Node startNode = new Node();
		oldNodes.addElement(startNode);
		
		int i = 0;
		while (i < stmts.length) {
			//always append new nodes to oldNodes
			if (stmts[i] instanceof If) {
				If ifStatement = (If) stmts[i];
				Node exprNode = new Node(ifStatement.getExpression().toSource());
				Node thenNode = null;

				//new code (thanks to Volker :-))
				Statement thenStatement = ifStatement.getThen().getBody();
				if (thenStatement != null) {
					StatementContainer thenContainer =
						thenStatement.getStatementContainer();
					if (thenContainer.getStatementCount() > 0) {
						thenStatement =
							thenContainer.getStatementAt(
								thenContainer.getStatementCount() - 1);
						if (thenStatement instanceof StatementBlock) {
							StatementBlock thenBlock =
								(StatementBlock) thenStatement;

							thenNode = buildSubNode(thenBlock.getBody().toArray(new Statement[0]));
						}
						else {
							//single statement
							thenNode = new Node(thenStatement.toSource());
							//append end node
							Node endNode = new Node("[end]");
							thenNode.addEdge(new Edge(endNode));
						}
					}
				}
				
				//connect thenNode to exprNode
				exprNode.addEdge(new Edge(thenNode));

				//connect exprNode to oldNodes
				Iterator iter = oldNodes.iterator();
				while (iter.hasNext()) {
					Node oldNode = (Node) iter.next();
					oldNode.addEdge(new Edge(exprNode));
				}

				//BUG: if then node is simple then it won't get an end node! [FIXED]
				
				//we have several oldNodes (expr + last Nodes of thenNode)
				oldNodes.clear();
				oldNodes.addElement(exprNode);
				
				Vector beforeEndNodes = getNodesBeforeEndNode(thenNode);
				removeEdgesToEndNode(beforeEndNodes);
				
				oldNodes.addAll(beforeEndNodes);
			}
			else if ((stmts[i] instanceof For) || (stmts[i] instanceof While)) {
				LoopStatement loop = (LoopStatement) stmts[i];
					Node guardNode = new Node((loop.getGuard() != null) ? loop.getGuard().toSource() : "loop guard");
				
				//body
				Node bodyNode = null;
				Statement loopStatement = loop.getBody();
				
				if (loopStatement != null) {
					StatementContainer loopContainer =
						loopStatement.getStatementContainer();
					if (loopContainer.getStatementCount() > 0) {
						loopStatement =
							loopContainer.getStatementAt(
								loopContainer.getStatementCount() - 1);
						if (loopStatement instanceof StatementBlock) {
							StatementBlock loopBlock =
								(StatementBlock) loopStatement;

							bodyNode = buildSubNode(loopBlock.getBody().toArray(new Statement[0]));
						}
						else {
							//single statement
							bodyNode = new Node(loopStatement.toSource());
							//append end node
							Node endNode = new Node("[end]");
							bodyNode.addEdge(new Edge(endNode));
						}
					}
				}
				
				//connect bodyNode to guardNode
				guardNode.addEdge(new Edge(bodyNode));

				//connect Nodes before end Node of bodyNode to guardNode
				Vector beforeEndNodes = getNodesBeforeEndNode(bodyNode);
				removeEdgesToEndNode(beforeEndNodes);
				Iterator iter = beforeEndNodes.iterator();
				while (iter.hasNext()) {
					Node n = (Node) iter.next();
					n.addEdge(new Edge(guardNode));
				}

				//connect guardNode to oldNodes
				iter = oldNodes.iterator();
				while (iter.hasNext()) {
					Node oldNode = (Node) iter.next();
					oldNode.addEdge(new Edge(guardNode));
				}

				oldNodes.clear();
				oldNodes.addElement(guardNode);
			}
			else if (stmts[i] instanceof Switch) {
				Switch switchStatement = (Switch) stmts[i];
				Node exprNode = new Node(switchStatement.getExpression().toSource());
				Branch[] branches = switchStatement.getBranchList().toArray(new Branch[0]);

				//iterate over all branches and build branchNodes
				Vector branchNodes = new Vector();
				for (int k = 0; k < branches.length; k++) {
					//create Statement array
					int stmtCount = branches[k].getStatementCount();
					if (stmtCount == 1) {
						//single statement
						Node n = new Node(branches[k].getStatementAt(0).toSource());
						//append end node
						Node endNode = new Node("[end]");
						n.addEdge(new Edge(endNode));
						branchNodes.addElement(n);
					}
					else {
						Statement[] subStmts = new Statement[stmtCount];
						for (int j = 0; j < branches[k].getStatementCount(); j++) {
							subStmts[j] = branches[k].getStatementAt(j);
						}
						Node n = buildSubNode(subStmts);
						branchNodes.addElement(n);
					}
				}
				
				//connect branchNodes to exprNode
				Iterator iter = branchNodes.iterator();
				Node branchNode = null;
				while (iter.hasNext()) {
					branchNode = (Node) iter.next();
					exprNode.addEdge(new Edge(branchNode));					
				}

				//connect exprNode to oldNodes
				iter = oldNodes.iterator();
				while (iter.hasNext()) {
					Node oldNode = (Node) iter.next();
					oldNode.addEdge(new Edge(exprNode));
				}

				//we have several oldNodes (expr + last Nodes of branch Nodes)
				oldNodes.clear();
				oldNodes.addElement(exprNode);
				
				Vector totalBeforeEndNodes = new Vector();
				Vector beforeEndNodes = null;
				iter = branchNodes.iterator();
				while (iter.hasNext()) {
					branchNode = (Node) iter.next();
					beforeEndNodes = getNodesBeforeEndNode(branchNode);
					removeEdgesToEndNode(beforeEndNodes);
					totalBeforeEndNodes.addAll(beforeEndNodes);
				}
				
				oldNodes.addAll(totalBeforeEndNodes);
			}
			else {
				//simple statement
				Node n = new Node(stmts[i].toSource());

				//connect n to oldNodes
				Iterator iter = oldNodes.iterator();
				Node oldNode = null;
				while (iter.hasNext()) {
					oldNode = (Node) iter.next();
					oldNode.addEdge(new Edge(n));
				}

				oldNodes.clear();
				oldNodes.addElement(n);
			}
			
			i++;
		}

		//append end node
		Node endNode = new Node("[end]");
		//connect endNode to oldNodes
		Iterator iter = oldNodes.iterator();
		Node oldNode = null;
		while (iter.hasNext()) {
			oldNode = (Node) iter.next();
			oldNode.addEdge(new Edge(endNode));
		}

		if (startNode.getEdges().size() > 0)
			return ((Edge) startNode.getEdges().elementAt(0)).getTargetNode();
		else
			return new Node();
	}
	
	public int countNodes(Node node) {
		return node.countNodes();
	}
	
	public int countEdges(Node node) {
		return node.countEdges();
	}

	private void removeEdgesToEndNode(Node node) {
		//remove all edges to end node
		Iterator edgeIter = node.getEdges().iterator();
		while (edgeIter.hasNext()) {
			Edge e = (Edge) edgeIter.next();
			if (e.getTargetNode().getExpr().equals("[end]"))
				edgeIter.remove();
		}
	}
	
	private void removeEdgesToEndNode(Vector nodes) {
		Iterator iter = nodes.iterator();
		while (iter.hasNext()) {
			Node n = (Node) iter.next();
			removeEdgesToEndNode(n);
		}
	}
	
	private Vector getNodesBeforeEndNode(Node node) {
		//collect all nodes
		Vector nodes = new Vector();
		nodes.addElement(node);
		
		Vector newNodes = new Vector();
		//here I forgot to clone() edges --> first Node had no edges!!
		Vector newEdges = (Vector) node.getEdges().clone();
		
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

		Vector beforeEndNodes = new Vector();
				
		Iterator iter = nodes.iterator();
		while (iter.hasNext()) {
			Node n = (Node) iter.next();
			Iterator edgeIter = n.getEdges().iterator();

			while (edgeIter.hasNext()) {
				Edge e = (Edge) edgeIter.next();
				if (e.getTargetNode().getExpr().equals("[end]"))
					beforeEndNodes.addElement(n);
			}
		}
		return beforeEndNodes;
	}

}
