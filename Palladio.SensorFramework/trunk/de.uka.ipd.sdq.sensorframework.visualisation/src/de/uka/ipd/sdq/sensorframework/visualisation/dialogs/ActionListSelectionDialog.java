/**
 * 
 */
package de.uka.ipd.sdq.sensorframework.visualisation.dialogs;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.dialogs.ElementListSelectionDialog;

/**
 * @author roman Dialog possible make selection from actions in
 *         Menu/Visualasetions are contained
 */
public class ActionListSelectionDialog extends ElementListSelectionDialog {


	/**
	 * @param parent
	 * @param renderer
	 */
	public ActionListSelectionDialog(Shell parent) {
		super(parent, new DialogLabelProvider());
		super.setShellStyle(SWT.NONE);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.ui.dialogs.SelectionStatusDialog#createButtonBar(org.eclipse.swt.widgets.Composite)
	 */
	@Override
	protected Control createButtonBar(Composite parent) {
		// Delete OK and CANCEL butons
		return null;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.dialogs.TitleAreaDialog#getInitialSize()
	 */
	@Override
	protected Point getInitialSize() {
		return new Point(400, 300);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.ui.dialogs.SelectionStatusDialog#getFirstResult()
	 */
	@Override
	public Object getFirstResult() {
		// TODO Auto-generated method stub
		return super.getFirstResult();
	}
}

/** LabelProvider for ActionListSelectionDialog */
class DialogLabelProvider extends LabelProvider {

	/* (non-Javadoc)
	 * @see org.eclipse.jface.viewers.LabelProvider#getText(java.lang.Object)
	 */
	@Override
	public String getText(Object element) {
		if (element instanceof ViewAndAdapterFactory) {
			ViewAndAdapterFactory viewAndAdapter = (ViewAndAdapterFactory) element;
			String displayName = viewAndAdapter.getView().getAttribute("displayName");
			return displayName.replace("{0}",viewAndAdapter.getFactory() == null ? "" : viewAndAdapter.getFactory().getMetricLabel());
		}
		return super.getText(element);
	}
}