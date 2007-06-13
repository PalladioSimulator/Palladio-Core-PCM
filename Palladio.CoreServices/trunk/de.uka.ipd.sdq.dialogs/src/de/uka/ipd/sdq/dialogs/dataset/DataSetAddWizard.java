package de.uka.ipd.sdq.dialogs.dataset;

import java.io.File;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.WizardNewFileCreationPage;
import org.eclipse.ui.internal.ide.IDEWorkbenchMessages;
import org.eclipse.ui.internal.ide.IIDEHelpContextIds;
import org.eclipse.ui.internal.ide.misc.ResourceAndContainerGroup;

public class DataSetAddWizard extends Wizard {

	private WizardNewFileCreationPage newDBpage;
	private String result;

	
	
	public DataSetAddWizard() {
		super();
		this.setWindowTitle("Select/create a new result storage for the sensor framework");
	}

	@Override
	public void addPages() {
		super.addPages();
		newDBpage = new WizardNewFileCreationPage("Create new database", new TreeSelection());
		this.addPage(newDBpage);
	}

	public boolean performFinish() {
		IPath rootPath = ResourcesPlugin.getWorkspace().getRoot().getLocation();
		IPath path = newDBpage.getContainerFullPath();
		File f = path.makeAbsolute().toFile();
		result = rootPath.toOSString() + path.toOSString() + File.separatorChar + 
			newDBpage.getFileName();
		return true;
	}

	public String getResult() {
		return result;
	}
}
