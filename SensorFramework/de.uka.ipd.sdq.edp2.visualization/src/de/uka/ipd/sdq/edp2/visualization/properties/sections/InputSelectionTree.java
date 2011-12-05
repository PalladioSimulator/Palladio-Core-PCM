package de.uka.ipd.sdq.edp2.visualization.properties.sections;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;
import org.eclipse.jface.viewers.ViewerSorter;

import de.uka.ipd.sdq.edp2.visualization.IDataSink;
import de.uka.ipd.sdq.edp2.visualization.IVisualizationInputHandle;
import de.uka.ipd.sdq.edp2.visualization.editors.EditorInputContentProvider;

public class InputSelectionTree extends Composite {

	private TreeViewer treeViewer;
	
	/**
	 * @return the treeViewer
	 */
	public TreeViewer getTreeViewer() {
		return treeViewer;
	}


	private static class ViewerLabelProvider extends LabelProvider {
		public Image getImage(Object element) {
			return super.getImage(element);
		}

		public String getText(Object element) {
			if (element instanceof IDataSink)
				return ((IDataSink) element).getName();
			return super.getText(element);
		}
	}

	/**
	 * Create the composite.
	 * 
	 * @param parent
	 * @param style
	 */
	public InputSelectionTree(Composite parent, int style,
			IVisualizationInputHandle inputHandler) {
		super(parent, SWT.BORDER);
		setLayout(new GridLayout(1, false));
		
		Label lblCurrentEditorInputs = new Label(this, SWT.NONE);
		lblCurrentEditorInputs.setText("Current Editor Inputs:");

		treeViewer = new TreeViewer(this, SWT.BORDER);
		Tree tree = treeViewer.getTree();
		GridData gd_tree = new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1);
		gd_tree.heightHint = 168;
		gd_tree.widthHint = 257;
		tree.setLayoutData(gd_tree);
		treeViewer.setLabelProvider(new ViewerLabelProvider());
		treeViewer.setContentProvider(new EditorInputContentProvider());
		treeViewer.setInput(inputHandler);
	}
	

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}

}
