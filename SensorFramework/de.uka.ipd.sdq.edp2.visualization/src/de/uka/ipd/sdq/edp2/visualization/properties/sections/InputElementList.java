package de.uka.ipd.sdq.edp2.visualization.properties.sections;

import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.ListViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.List;

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
				return ((IVisualizationInput) element).getInputName();
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
			IVisualizationInputHandle inputHandle) {
		super(parent, SWT.EMBEDDED);
		setLayout(new GridLayout(1, false));

		listViewer = new ListViewer(this, SWT.BORDER);
		List list = listViewer.getList();
		GridData gd_list = new GridData(SWT.FILL, SWT.FILL, true, true, 1, 2);
		gd_list.heightHint = 180;
		gd_list.widthHint = 200;
		list.setLayoutData(gd_list);
		listViewer.setLabelProvider(new ViewerLabelProvider());
		listViewer.setContentProvider(new InputElementContentProvider());
		listViewer.setInput(inputHandle);
	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}

}
