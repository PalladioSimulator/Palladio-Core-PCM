package edu.kit.ipd.sdq.completionfeaturemodel.ui.wizard;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.dialogs.WizardNewFileCreationPage;

public class ModelFileCreationPage extends WizardNewFileCreationPage {

	public ModelFileCreationPage(String pageName, IStructuredSelection selection) {
		super(pageName, selection);
	}
	
	public IFile getModelFile() {
		return ResourcesPlugin.getWorkspace().getRoot().getFile(getContainerFullPath().append(getFileName()));
	}

}
