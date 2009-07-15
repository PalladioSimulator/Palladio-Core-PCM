/**
 * Opt4J is free software: you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the
 * Free Software Foundation, either version 3 of the License, or (at your
 * option) any later version.
 * 
 * Opt4J is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public
 * License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public
 * License along with Opt4J. If not, see http://www.gnu.org/licenses/. 
 */

package org.opt4j.config.visualization;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Point;
import java.awt.datatransfer.Transferable;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DragGestureEvent;
import java.awt.dnd.DragGestureListener;
import java.awt.dnd.DragSource;
import java.awt.dnd.DragSourceAdapter;
import java.awt.dnd.DragSourceListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.RejectedExecutionException;

import javax.swing.ImageIcon;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingUtilities;
import javax.swing.ToolTipManager;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.DefaultTreeSelectionModel;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreeSelectionModel;

import org.opt4j.config.Icons;
import org.opt4j.config.ModuleRegister;
import org.opt4j.config.PropertyModule;
import org.opt4j.config.annotations.Annotations;
import org.opt4j.config.annotations.Category;
import org.opt4j.config.annotations.Parent;
import org.opt4j.config.annotations.Annotations.Info;

import com.google.inject.Inject;
import com.google.inject.Module;

/**
 * The {@code DefaultModulesPanel}. This implementation is a tree of all
 * available modules.
 * 
 * @author lukasiewycz
 * 
 */
@SuppressWarnings("serial")
public class DefaultModulesPanel extends ModulesPanel {

	protected final Format format;

	protected final ModuleRegister allModules;

	protected final SelectedModules selectedModules;

	protected final RootTreeNode root = new RootTreeNode(true);

	protected JTree tree = null;

	protected final JPopupMenu moduleMenu = new JPopupMenu();

	/**
	 * The {@code UserNode} is a basic node of the tree.
	 */
	protected abstract class UserNode extends DefaultMutableTreeNode {

		public UserNode(Object object) {
			super(object);
		}

		@Override
		public String toString() {
			return format.getName(getType());
		}

		public ImageIcon getIcon() {
			return format.getIcon(getType());
		}

		public String getTooltip() {
			return format.getTooltip(getType());
		}

		public abstract Class<?> getType();
	}

	/**
	 * The {@code RootTreeNode} is the root node of the tree.
	 */
	protected class RootTreeNode extends UserNode {

		public RootTreeNode(boolean b) {
			super(b);
		}

		public void setLoading(boolean b) {
			userObject = b;
		}

		public boolean isLoading() {
			return (Boolean) userObject;
		}

		@Override
		public ImageIcon getIcon() {
			if (isLoading()) {
				ImageIcon icon = Icons.getIcon(Icons.LOADING);
				icon.setImageObserver(tree);
				return icon;
			}
			return format.asFolder(null);
		}

		@Override
		public String toString() {
			if (isLoading()) {
				return "Loading";
			}
			return "Modules";
		}

		@Override
		public String getTooltip() {
			return null;
		}

		@Override
		public Class<?> getType() {
			return null;
		}
	}

	/**
	 * The {@code ModuleTreeNode} is used for nodes that represent modules.
	 */
	@SuppressWarnings("unchecked")
	protected class ModuleTreeNode extends UserNode {
		public ModuleTreeNode(Class<? extends Module> module) {
			super(module);
		}

		public PropertyModule getModule() {
			return allModules.get((Class<? extends Module>) userObject);
		}

		@Override
		public Class<?> getType() {
			return (Class<?>) userObject;
		}
	}

	/**
	 * The {@code CategoryTreeNode} is used for nodes that represent categories.
	 */
	protected class CategoryTreeNode extends UserNode {

		public CategoryTreeNode(Class<?> clazz) {
			super(clazz);
		}

		@Override
		public Class<?> getType() {
			return (Class<?>) userObject;
		}

		@Override
		public String toString() {
			return format.getName(getType());
		}

		@Override
		public ImageIcon getIcon() {
			return format.asFolder(super.getIcon());
		}
	}

	/**
	 * The {@code Default} category interface.
	 * 
	 * @author lukasiewycz
	 * 
	 */
	@Category("Default")
	public interface Default {

	}

	/**
	 * The {@code TreeCellRenderer} for the modules tree.
	 * 
	 */
	protected class TreeCellRenderer extends DefaultTreeCellRenderer {
		@Override
		public Component getTreeCellRendererComponent(JTree tree, Object value,
				boolean sel, boolean expanded, boolean leaf, int row,
				boolean hasFocus) {
			Component comp = super.getTreeCellRendererComponent(tree, value,
					sel, expanded, leaf, row, hasFocus);

			ImageIcon icon = null;
			String tooltip = null;

			if (value instanceof UserNode) {
				UserNode userNode = (UserNode) value;
				icon = userNode.getIcon();
				tooltip = userNode.getTooltip();
			}
			if (icon == null) {
				icon = Icons.getDefault();
			}

			setIcon(icon);
			setToolTipText(tooltip);

			return comp;
		}
	}

	/**
	 * The {@code MyTree} that extends a {@code JTree} by a drag method.
	 * 
	 */
	protected class MyTree extends JTree implements DragGestureListener {

		DragSource dragSource = null;

		public MyTree(TreeNode root) {
			super(root);

			dragSource = new DragSource();
			dragSource.createDefaultDragGestureRecognizer(this,
					DnDConstants.ACTION_MOVE, this);
		}

		protected DragSourceListener dragSourceListener = new DragSourceAdapter() {
		};

		public void dragGestureRecognized(DragGestureEvent dge) {
			TreeNode node = (TreeNode) this.getLastSelectedPathComponent();

			if (node instanceof ModuleTreeNode) {
				ModuleTreeNode moduleNode = (ModuleTreeNode) node;
				PropertyModule module = moduleNode.getModule();

				Transferable transferable = new ModuleTransferable(module);

				dragSource.startDrag(dge, DragSource.DefaultMoveDrop,
						transferable, dragSourceListener);
			}
		}

	}

	/**
	 * Constructs a {@code DefaultModulesPanel}.
	 * 
	 * @param format
	 *            the format
	 * @param allModules
	 *            the set of all modules
	 * @param selectedModules
	 *            the set of selected modules
	 */
	@Inject
	public DefaultModulesPanel(Format format, ModuleRegister allModules,
			SelectedModules selectedModules) {
		super();
		this.format = format;
		this.allModules = allModules;
		this.selectedModules = selectedModules;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.opt4j.conf.gui.Startupable#startup()
	 */
	public void startup() {

		tree = new MyTree(root);
		tree.setToggleClickCount(1000); // don't expand on double click hack
		tree.addMouseListener(mouseListener);
		tree.setCellRenderer(new TreeCellRenderer());
		tree.setSelectionModel(null);

		ToolTipManager.sharedInstance().registerComponent(tree);

		JScrollPane scroll = new JScrollPane(tree,
				ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);

		setLayout(new BorderLayout());
		add(scroll, BorderLayout.CENTER);

		Thread thread = new Thread() {
			@Override
			public void run() {
				try {
					populateTree();
				} catch (RejectedExecutionException e) {
				}
			}
		};
		thread.setPriority(Thread.MIN_PRIORITY);
		thread.start();
	}

	/**
	 * Build and order the tree
	 */
	protected void populateTree() {
		// get all relevant categories

		Map<Class<?>, Info> map = new HashMap<Class<?>, Info>();
		for (Class<? extends Module> clazz : allModules) {
			Map<Class<? extends Annotation>, Info> annotations = Annotations
					.getUniques(clazz);

			if (annotations.containsKey(Category.class)) {
				Info info = annotations.get(Category.class);
				map.put(info.getClazz(), info);
			}
		}

		int size;
		do {
			size = map.size();
			for (Info info : map.values()) {
				Class<?> clazz = info.getClazz();
				Map<Class<? extends Annotation>, Info> annotations = Annotations
						.getUniques(clazz, false);

				if (annotations.containsKey(Category.class)) {
					Info i = annotations.get(Category.class);
					map.put(i.getClazz(), i);
				}
			}
		} while (map.size() != size);

		// create all nodes
		Map<Class<?>, CategoryTreeNode> ctn = new HashMap<Class<?>, CategoryTreeNode>();
		Map<Class<?>, ModuleTreeNode> mtn = new HashMap<Class<?>, ModuleTreeNode>();
		Map<Class<?>, DefaultMutableTreeNode> atn = new HashMap<Class<?>, DefaultMutableTreeNode>();

		for (Entry<Class<?>, Info> entry : map.entrySet()) {
			Class<?> clazz = entry.getKey();
			Info info = entry.getValue();

			CategoryTreeNode node = new CategoryTreeNode(info.getClazz());
			ctn.put(clazz, node);
			atn.put(clazz, node);
		}
		for (Class<? extends Module> clazz : allModules) {
			ModuleTreeNode node = new ModuleTreeNode(clazz);
			mtn.put(clazz, node);
			atn.put(clazz, node);
		}

		// create hierarchy by parent annotation
		for (Entry<Class<?>, DefaultMutableTreeNode> entry : atn.entrySet()) {
			Class<?> clazz = entry.getKey();
			DefaultMutableTreeNode node = entry.getValue();

			Parent parent = clazz.getAnnotation(Parent.class);

			if (parent != null) {
				if (parent.value() == null) {
					root.add(node);
				} else {
					DefaultMutableTreeNode n = atn.get(parent.value());
					if (n != null && n != node) {
						n.add(node);
					}
				}
			}
		}

		// create category hierarchy
		for (CategoryTreeNode node : ctn.values()) {
			if (node.getParent() == null) {
				Class<?> clazz = node.getType();
				Info info = Annotations.getUniques(clazz, false).get(
						Category.class);

				if (info != null) {
					// this category has a super category
					CategoryTreeNode parent = ctn.get(info.getClazz());
					parent.add(node);
				} else {
					root.add(node);
				}
			}
		}

		CategoryTreeNode def = new CategoryTreeNode(Default.class);
		root.add(def);

		for (ModuleTreeNode node : mtn.values()) {
			if (node.getParent() == null) {
				Class<?> clazz = node.getModule().getModule().getClass();

				Info info = Annotations.getUniques(clazz, false).get(
						Category.class);

				if (info != null) {
					CategoryTreeNode p = ctn.get(info.getClazz());
					p.add(node);
				} else {
					def.add(node);
				}
			}

		}

		// clean empty categories
		boolean removed;
		do {
			removed = removeEmptyCategories(root);
		} while (removed);

		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				tree.setSelectionModel(new DefaultTreeSelectionModel());
				tree.getSelectionModel().setSelectionMode(
						TreeSelectionModel.SINGLE_TREE_SELECTION);
				root.setLoading(false);
				sort(tree);
				tree.expandRow(0);
			}
		});
		revalidate();
		repaint();
	}

	/**
	 * Removes empty categories. This method can create some new empty
	 * categories!
	 * 
	 * @param current
	 *            the current node
	 * @return true if an empty category was removed
	 */
	private boolean removeEmptyCategories(DefaultMutableTreeNode current) {
		if (!current.children().hasMoreElements()) {
			return false;
		}

		TreeNode node = current.getFirstChild();
		boolean removed = false;
		while (node != null) {
			DefaultMutableTreeNode n = (DefaultMutableTreeNode) node;
			node = current.getChildAfter(n);

			if (n.isLeaf()) {
				if (n instanceof CategoryTreeNode && n.getChildCount() == 0) {
					DefaultMutableTreeNode parent = (DefaultMutableTreeNode) n
							.getParent();
					parent.remove(n);
					removed = true;
				}
			} else {
				removed = removed || removeEmptyCategories(n);
			}
		}
		return removed;
	}

	protected MouseListener mouseListener = new MouseAdapter() {

		@Override
		public void mousePressed(MouseEvent e) {
			if (e.isPopupTrigger()) {
				displayMenu(e);
			}
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			int count = e.getClickCount();

			if (e.isPopupTrigger()) {
				displayMenu(e);
			} else if (count > 1) {
				Object object = tree.getLastSelectedPathComponent();
				if (object instanceof ModuleTreeNode) {
					ModuleTreeNode node = (ModuleTreeNode) object;
					if (selectedModules.contains(node.getModule())) {
						selectedModules.remove(node.getModule());
					} else {
						selectedModules.add(node.getModule());
					}
				}
			}
		}
	};

	/**
	 * Displays a popup menu for the tree elements.
	 * 
	 * @param e
	 *            the mouse event
	 */
	protected void displayMenu(MouseEvent e) {
		if (e.isPopupTrigger()) {
			Point pt = e.getPoint();
			tree.setSelectionPath(tree.getPathForLocation(pt.x, pt.y));

			Object object = tree.getLastSelectedPathComponent();
			if (object instanceof ModuleTreeNode) {

				ModuleTreeNode node = (ModuleTreeNode) object;
				final PropertyModule module = node.getModule();

				moduleMenu.removeAll();

				JMenuItem add = new JMenuItem("Add Module", Icons
						.getIcon(Icons.ADD));
				add.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						selectedModules.add(module);
					}
				});

				JMenuItem remove = new JMenuItem("Remove Module", Icons
						.getIcon(Icons.DELETE));
				remove.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						selectedModules.remove(module);
					}
				});

				if (selectedModules.contains(module)) {
					add.setEnabled(false);
				} else {
					remove.setEnabled(false);
				}

				moduleMenu.add(add);
				moduleMenu.add(remove);
				moduleMenu.show(e.getComponent(), e.getX(), e.getY());

			}

		}
	}

	/**
	 * Sorts the tree alphabetically.
	 * 
	 * @param tree
	 *            the tree to be sorted
	 */
	protected void sort(JTree tree) {
		DefaultMutableTreeNode root = (DefaultMutableTreeNode) tree.getModel()
				.getRoot();
		sort(root);

	}

	/**
	 * Sorts the child elements of one tree node alphabetically.
	 * 
	 * @param node
	 *            the node which children are sorted
	 */
	protected void sort(DefaultMutableTreeNode node) {
		if (!node.children().hasMoreElements()) {
			return;
		}

		List<UserNode> nodes = new ArrayList<UserNode>();

		Enumeration<?> children = node.children();

		while (children.hasMoreElements()) {
			UserNode n = (UserNode) children.nextElement();
			nodes.add(n);
		}

		Collections.sort(nodes, new Comparator<UserNode>() {
			public int compare(UserNode o1, UserNode o2) {
				boolean cat1 = o1 instanceof CategoryTreeNode;
				boolean cat2 = o2 instanceof CategoryTreeNode;

				if (cat1 && !cat2) {
					return -1;
				} else if (!cat1 && cat2) {
					return 1;
				} else {
					return o1.toString().compareTo(o2.toString());
				}
			}
		});

		node.removeAllChildren();

		for (UserNode n : nodes) {
			node.add(n);
			sort(n);
		}
	}

}
