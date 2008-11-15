package de.uka.ipd.sdq.featureinstance;

import java.util.HashMap;

import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.dialogs.WizardNewFileCreationPage;

class ResourceWizardPage extends WizardNewFileCreationPage {

	/**
	 * Override to create files with this extension.
	 * 
	 * @generated
	 */
	protected String getExtension() {
		return fileExtension;
	}

	/**
	 * @generated
	 */
	public URI getURI() {
		return URI.createPlatformResourceURI(getFilePath().toString(), false);
	}

	/**
	 * @generated
	 */
	private final String fileExtension;
	protected String fileName;

	/**
	 * @generated
	 */
	public ResourceWizardPage(String pageName, IStructuredSelection selection, String fileExtension, String fileName) {
		super(pageName, selection);
		this.fileExtension = fileExtension;
		this.fileName = fileName;
	}

	/**
	 * @generated
	 */
	protected IPath getFilePath() {
		IPath path = getContainerFullPath();
		if (path == null) {
			path = new Path(""); //$NON-NLS-1$
		}
		String fileName = getFileName();
		if (fileName != null) {
			path = path.append(fileName);
		}
		return path;
	}

	/**
	 * @generated
	 */
	public void createControl(Composite parent) {
		super.createControl(parent);
		setFileName(fileName + ".featureconfig");
		setPageComplete(true);
	}
}

public class ResourceWizard extends Wizard implements INewWizard {
	
	protected IWorkbench workbench;
	protected IStructuredSelection selection;
	protected EObject diagram;
	protected Resource resource;
	protected ResourceWizardPage page;
	protected String fileName;

	@Override
	public void addPages() {
		page = new ResourceWizardPage("Resource selection page", selection, "", fileName);
		addPage(page);
		super.addPages();
	}

	@Override
	public boolean performFinish() {
		try {
			resource.setURI(page.getURI());
			resource.save(new HashMap<String, String>());
		}
		catch (Exception e) {
			return false;
		}
		return true;
	}
	
	public ResourceWizard (EObject diagram, String fileName, Resource resource) {
		this.diagram = diagram;
		this.fileName = fileName;
		this.resource = resource;
	}

	@Override
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		this.workbench = workbench;
		this.selection = selection;
		setWindowTitle("ResourceWizard");		
	}
	
}