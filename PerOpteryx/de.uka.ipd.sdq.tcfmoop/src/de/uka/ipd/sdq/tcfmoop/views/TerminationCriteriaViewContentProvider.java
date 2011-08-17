package de.uka.ipd.sdq.tcfmoop.views;

import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;

import de.uka.ipd.sdq.tcfmoop.outputtree.Node;
import de.uka.ipd.sdq.tcfmoop.outputtree.Tree;
import de.uka.ipd.sdq.tcfmoop.outputtree.Node.NodeType;

public class TerminationCriteriaViewContentProvider implements ITreeContentProvider {

	private Tree invisibleRoot = new Tree("Termination Criteria Manager Output", NodeType.NON_SPECIFIC);

	TerminationCriteriaView viewer;

	public TerminationCriteriaViewContentProvider(TerminationCriteriaView viewer) {
		this.viewer = viewer;
	}
	
	@Override
	public void inputChanged(Viewer v, Object oldInput, Object newInput) {
	}
	
	@Override
	public void dispose() {
	}

	@Override
	public Object[] getElements(Object parent) {
		if (parent.equals(viewer.getViewSite())) {
			
			updateContent();
			
			return getChildren(invisibleRoot);
		}
		return getChildren(parent);
	}

	@Override
	public Object getParent(Object child) {
		if (child instanceof Node) {
			return ((Node) child).getParent();
		}
		return null;
	}

	@Override
	public Object[] getChildren(Object parent) {
		if (parent instanceof Node) {
			return ((Node) parent).getChildren().toArray();
		}
		return new Object[0];
	}

	@Override
	public boolean hasChildren(Object parent) {
		if (parent instanceof Node) {
			return ((Node) parent).hasChildren();
		}
		return false;
	}

	private void updateContent() {
		invisibleRoot.clearChildren();
		
		if (viewer.terminationCriteriaManagerOutput != null) {

			this.invisibleRoot.attachSubtree(viewer.terminationCriteriaManagerOutput);

		}

	}
}
