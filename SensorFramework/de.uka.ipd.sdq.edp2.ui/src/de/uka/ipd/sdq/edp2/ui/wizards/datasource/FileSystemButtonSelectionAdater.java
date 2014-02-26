/**
 * 
 */
package de.uka.ipd.sdq.edp2.ui.wizards.datasource;

import org.eclipse.emf.common.util.URI;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.DirectoryDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

/**Opens a directory selection dialog for file system resources.
 * The URI of the selected directory is stored in a provided text field.
 * @author groenda
 *
 */
public class FileSystemButtonSelectionAdater extends SelectionAdapter implements
		SelectionListener {
	Text text;
	Shell shell;

	public FileSystemButtonSelectionAdater(Shell shell, Text text) {
		this.text = text;
		this.shell = shell;
	}
	
	@Override
	public void widgetSelected(SelectionEvent e) {
        DirectoryDialog directoryDialog = new DirectoryDialog(shell, SWT.OPEN | SWT.SINGLE);
        directoryDialog.open();

		String filterPath = directoryDialog.getFilterPath();
		if (filterPath != null) {
			text.setText(URI.createFileURI(filterPath).toString());
		  }
	}
}
