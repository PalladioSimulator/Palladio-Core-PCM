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

import de.fzi.sissy.metamod.*;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.*;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.tree.DefaultMutableTreeNode;

/**
 * @author Johannes Stammel
 *
 * 
 **/
public class StatementViewer {

    public static void main(String[] args) {
        
        StatementViewer sv = new StatementViewer();
        
    }
    
    private DefaultListModel listModel;
    private JList list;
	private JFrame frame;
	private JFrame treeframe;
	
    public StatementViewer() {
	    frame = new JFrame();

        JPanel contp = new JPanel();

        
        contp.setLayout(new BorderLayout());
        contp.setPreferredSize(new Dimension(300,200));

        listModel = new DefaultListModel();
        
        list = new JList(listModel);
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane listScrollPane = new JScrollPane(list);
        
        JLabel label = new JLabel("METHODS");
        label.setFont(new Font("SansSerif", Font.BOLD, 14));
        label.setHorizontalAlignment(JLabel.CENTER);
        contp.add(label, BorderLayout.NORTH);

        JButton button = new JButton("Show Tree");
        button.addActionListener(new buttonListener());
        contp.add(button, BorderLayout.SOUTH);
        
	    contp.add(listScrollPane, BorderLayout.CENTER);
	    
	    frame.setTitle("Statement-Tree Viewer");
	    frame.setContentPane(contp);
	    frame.pack();
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setVisible(true);
	    
    }
    
    private class buttonListener implements ActionListener {

        /* (non-Javadoc)
         * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
         */
        public void actionPerformed(ActionEvent e) {
            StatementViewer.this.startView();
        }
        
    }
    
    public void startView() {
        if (list.getSelectedIndex() >= 0) {
	        //Function function = (Function)list.getSelectedValue();
	        Function function = (Function) function_vector.get(list.getSelectedIndex());
	        System.out.println(function.getSimpleName() + " Index:" + list.getSelectedIndex());
	        BlockStatement body = (BlockStatement) function.getBody();
	        if (body == null)
	        	System.out.println("body of Function is null");
	        generateTreeView(body, function.getSimpleName());
        }
//        System.out.println("was gschafft");
        
    }
	
	private Vector function_vector;

    public void showMethodSelection(Vector functions) {
        Iterator itr = functions.iterator();
        
        while(itr.hasNext())  {
            Function function = (Function) itr.next();
            listModel.addElement(function.getSimpleName() + " LOCM: "+ function.getLinesOfComments());
        }
        function_vector = functions;
    }
    
    public void generateTreeView(BlockStatement root, String func_name) {
        
	    treeframe = new JFrame();

        JPanel contp = new JPanel();
        
        contp.setLayout(new BorderLayout());
        contp.setPreferredSize(new Dimension(500,600));

        DefaultMutableTreeNode root_node = generateNode(root);
        
        if (root_node != null) {
	        JTree tree = new JTree(root_node);
	        JScrollPane treeScrollPane = new JScrollPane(tree);
	        
		    contp.add(treeScrollPane, BorderLayout.CENTER);
		    
			treeframe.setTitle(func_name);
			treeframe.setContentPane(contp);
			treeframe.pack();
			treeframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			treeframe.setVisible(true);
        } else {
        	System.out.println("Tree was null");
        }
    }
    
    private DefaultMutableTreeNode createDefaultMutableTreeNode(String text) {
		String farbe = "<html><font color=#00aa00>"; 
		String farbeB = "</font> ";
		
    	return new DefaultMutableTreeNode(farbe+text+farbeB);
    	
    }
    
    
    public DefaultMutableTreeNode generateNode(Statement statement) {
        
        if (statement instanceof SimpleStatement) {
			DefaultMutableTreeNode node = createDefaultMutableTreeNode("SimpleStatement");
			node = addAccesses(node, statement);
			return node;
        } else if (statement instanceof JumpStatement) {
			String typ = "";
			if (((JumpStatement)statement).isJump())
				typ = "jump";
			if (((JumpStatement)statement).isThrow())
				typ = "throw";
			if (((JumpStatement)statement).isReturn())
				typ = "return";

			DefaultMutableTreeNode node = createDefaultMutableTreeNode("JumpStatement ("+ typ +")");
            
			node = addAccesses(node, statement);
			return node;
        } else if (statement instanceof LoopStatement) {
            DefaultMutableTreeNode node = createDefaultMutableTreeNode("LoopStatement");
            
            if (((LoopStatement)statement).getBody() != null) {
                DefaultMutableTreeNode body_node = generateNode(((LoopStatement)statement).getBody());
                node.add(body_node);
            }
            
			node = addAccesses(node, statement);
            return node;
        } else if (statement instanceof BranchStatement) {
            DefaultMutableTreeNode node = createDefaultMutableTreeNode("BranchStatement");
            
            Iterator itr = ((BranchStatement)statement).getBranches().iterator();
            
            while(itr.hasNext()) {
                DefaultMutableTreeNode branch_node = generateNode(((Statement)itr.next()));
                node.add(branch_node);
            }
            
			node = addAccesses(node, statement);
            return node;
        } else if (statement instanceof ExceptionHandler) {
            DefaultMutableTreeNode node = createDefaultMutableTreeNode("ExceptionHandler");
            
            if (((ExceptionHandler)statement).getGuardedBlock() != null) {
                DefaultMutableTreeNode guarded_node = generateNode(((ExceptionHandler)statement).getGuardedBlock());
                node.add(guarded_node);
            }

			node = addAccesses(node, statement);
            Iterator itr = ((ExceptionHandler)statement).getCatchBlocks().iterator();

            while(itr.hasNext()) {
                DefaultMutableTreeNode catchblock_node = generateNode(((CatchBlock)itr.next()));
                node.add(catchblock_node);
            }

            if (((ExceptionHandler)statement).getFinallyBlock() != null) {
                DefaultMutableTreeNode finally_node = generateNode(((ExceptionHandler)statement).getFinallyBlock());
                node.add(finally_node);
            }

			node = addAccesses(node, statement);
            return node;
        } else if (statement instanceof CatchBlock) {
            DefaultMutableTreeNode node = createDefaultMutableTreeNode("CatchBlock");
            
            Iterator itr = ((CatchBlock)statement).getStatements().iterator();

            while(itr.hasNext()) {
                DefaultMutableTreeNode statement_node = generateNode(((Statement)itr.next()));
                node.add(statement_node);
            }

			node = addAccesses(node, statement);
            return node;
        } else if (statement instanceof BlockStatement) {
            DefaultMutableTreeNode node = createDefaultMutableTreeNode("BlockStatement");
            
            Iterator itr = ((BlockStatement)statement).getStatements().iterator();

            while(itr.hasNext()) {
                DefaultMutableTreeNode statement_node = generateNode(((Statement)itr.next()));
                node.add(statement_node);
            }
            
            node = addAccesses(node, statement);

            return node;
        } else {
            if (statement == null) {
                return null;
            }
        	System.out.println(statement.getClass().getName());
        	return null;
        }
    }
    
    private DefaultMutableTreeNode addAccesses(DefaultMutableTreeNode node, Statement statement) {

        DefaultMutableTreeNode access_medi_node = buildAccessNodeTree(statement.getAccesses());
    	
    	if (!access_medi_node.isLeaf())
    	node.add(access_medi_node);

		node = addInformation(node, statement);
    	
    	return node;
    }
    
    private DefaultMutableTreeNode buildAccessNodeTree(ModelElementList access_list) {
        
        DefaultMutableTreeNode access_medi_node 
        = new DefaultMutableTreeNode("<html><font color=#ff0000>ACCESSES</font> ");
        
        Iterator access_iterator = access_list.iterator();
        while(access_iterator.hasNext()) {
            Access access = (Access) access_iterator.next();
            String text = "";
            text = access.getClass().getName();
            if (access.getAccessedTarget()!=null)
                text = text + " (Target: " + access.getAccessedTarget().getSimpleName();
            if (access instanceof VariableAccess) {
                text = text + ", Write: "+ (((VariableAccess)access).isWriteAccess() ? "w" : "r") + ")";
            } else {
                text = text + ")";
            }

            DefaultMutableTreeNode access_node 
            = new DefaultMutableTreeNode("<html><font color=#ff0000>" + text+ "</font> ");

            if (access instanceof CompositeAccess) {
                CompositeAccess caccess = (CompositeAccess)access;
                DefaultMutableTreeNode subnode = buildAccessNodeTree(caccess.getAccesses());
                if (!subnode.isLeaf())
                access_node.add(subnode);
            }
            
            access_medi_node.add(access_node);
        }
        
        return access_medi_node;
        
    }
    
	private DefaultMutableTreeNode addInformation(DefaultMutableTreeNode node, Statement statement) {
    	
		DefaultMutableTreeNode info_medi_node 
		= new DefaultMutableTreeNode("<html><font color=#ff9900>INFORMATION</font> ");
    	
		DefaultMutableTreeNode info_node = null;
		String text = null;
		
		text =        "LOCD: "  + statement.getLinesOfCode();
		text = text + " NOS: " + statement.getNumberOfStatements(); 
		info_node = new DefaultMutableTreeNode("<html><font color=#ff9900>" + text+ "</font> ");
		info_medi_node.add(info_node);

		text =        " MNL: " + statement.getMaximumNestingLevel(); 
		text = text + " #Edges: " + statement.getNumberOfEdgesInCFG(); 
		text = text + " #Nodes: " + statement.getNumberOfNodesInCFG(); 
		info_node = new DefaultMutableTreeNode("<html><font color=#ff9900>" + text+ "</font> ");
		info_medi_node.add(info_node);
    	
		if (!info_medi_node.isLeaf())
		node.add(info_medi_node);
    	
		return node;
	}
}


