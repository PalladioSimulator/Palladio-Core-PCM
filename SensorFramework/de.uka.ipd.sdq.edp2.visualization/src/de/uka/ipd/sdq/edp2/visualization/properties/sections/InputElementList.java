package de.uka.ipd.sdq.edp2.visualization.properties.sections;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.jface.viewers.ListViewer;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;
import org.eclipse.jface.viewers.ViewerSorter;

import de.uka.ipd.sdq.edp2.visualization.IDataSink;
import de.uka.ipd.sdq.edp2.visualization.IVisualizationInput;
import de.uka.ipd.sdq.edp2.visualization.IVisualizationInputHandle;

public class InputElementList extends Composite {

	private ListViewer listViewer;

	/**
	 * @return the treeViewer
	 */
	public ListViewer getListViewer() {
		return listViewer;
	}

	private static class ViewerLabelProvider extends LabelProvider {
		public Image getImage(Object element) {
			return super.getImage(element);
		}

		public String getText(Object element) {
			if (element instanceof IVisualizationInput)
				return ((IVisualizationInput) element).getName();
			return super.getText(element);
		}
	}

	/**
	 * Create the composite.
	 * 
	 * @param parent
	 * @param style
	 */
	public InputElementList(Composite parent, int style,
			IVisualizationInputHandle inputHandler) {
		super(parent, SWT.EMBEDDED);
		setLayout(new GridLayout(1, false));

		Label lblCurrentEditorInputs = new Label(this, SWT.NONE);
		lblCurrentEditorInputs.setText("Current Editor Inputs:");

		listViewer = new ListViewer(this, SWT.BORDER);
		List list = listViewer.getList();
		GridData gd_list = new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1);
		gd_list.heightHint = 168;
		gd_list.widthHint = 200;
		list.setLayoutData(gd_list);
		listViewer.setLabelProvider(new ViewerLabelProvider());
		listViewer.setContentProvider(new InputElementContentProvider());
		listViewer.setInput(inputHandler);
	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}

}
