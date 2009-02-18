package de.uka.ipd.sdq.featureinstance;



import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.dialogs.WizardNewFileCreationPage;

class FeatureConfigCreationWizardPage extends WizardNewFileCreationPage {

	@Override
	protected void createAdvancedControls(Composite parent) {
		Label label = new Label(parent, SWT.BORDER);
		label.setText("No *.featureconfig-file present. A new featureconfig needs to be created.");
		super.createAdvancedControls(parent);
	}

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
	public FeatureConfigCreationWizardPage(String pageName, IStructuredSelection selection, String fileExtension, String fileName) {
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

public class FeatureConfigCreationWizard extends Wizard implements INewWizard {
	
	protected URI resourceURI;
	protected IWorkbench workbench;
	protected IStructuredSelection selection;
	protected FeatureConfigCreationWizardPage page;
	protected String fileName;

	@Override
	public void addPages() {
		page = new FeatureConfigCreationWizardPage("Resource selection page", selection, "", fileName);
		addPage(page);
		super.addPages();
	}
	
	public URI getNewResource () {
		return resourceURI;
	}

	@Override
	public boolean performFinish() {
		try {
			resourceURI = page.getURI();
		}
		catch (Exception e) {
			return false;
		}
		return true;
	}
	
	public FeatureConfigCreationWizard (String fileName) {
		this.fileName = fileName;
	}

	@Override
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		this.workbench = workbench;
		this.selection = selection;
		setWindowTitle("FeatureConfig creation wizard");		
	}
	
}