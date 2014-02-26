/**
 * 
 */
package de.uka.ipd.sdq.edp2.ui.wizards.datasource;

import org.eclipse.core.resources.IContainer;
import org.eclipse.emf.common.ui.dialogs.WorkspaceResourceDialog;
import org.eclipse.emf.common.util.URI;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

/**Opens a directory selection dialog for workspace resources.
 * The resulting URI of the selected directory is stored in a provided text field.
 * @author groenda
 *
 */
public class WorkspaceButtonSelectionAdapter extends SelectionAdapter implements
		SelectionListener {
	
	private Shell shell;
	private Text text;

	public WorkspaceButtonSelectionAdapter(Shell shell, Text text) {
		this.shell = shell;
		this.text = text;
	}

	@Override
	public void widgetSelected(SelectionEvent e) {
		IContainer directory = null;

		IContainer[] directories = WorkspaceResourceDialog.openFolderSelection(shell, null, null, false, null, null);
		if (directories.length != 0) {
			directory = directories[0];
		}

		if (directory != null) {
			text.setText(URI.createPlatformResourceURI(
					directory.getFullPath().toString(), true).toString());
		}
	}
}
