package edu.kit.ipd.sdq.completionfeaturemodel.ui.wizard.featureconfig;

import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.osgi.util.NLS;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.dialogs.WizardNewFileCreationPage;

/**
 * The "New" wizard page allows setting the container for the new file as well
 * as the file name. The page will only accept file name without the extension
 * OR with the extension that matches the expected one (featureconfig).
 */

public class FeatureConfigModelCreationWizardPage extends WizardNewFileCreationPage {
	
	private final String fileExtension;
	/**
	 * Constructor for SampleNewWizardPage.
	 * 
	 * @param pageName
	 */
	public FeatureConfigModelCreationWizardPage(String pageName, IStructuredSelection selection, String fileExtension) {
		super(pageName,selection);
		//setTitle("Multi-page Editor File");
		//setDescription("This wizard creates a new file with *.featureconfig extension that can be opened by a multi-page editor.");
		this.fileExtension = fileExtension;
	}

	/**
	 * @see IDialogPage#createControl(Composite)
	 */
	public void createControl(Composite parent) {
		super.createControl(parent);
		setFileName(getUniqueFileName(
				getContainerFullPath(), getFileName(), getExtension()));
		//setFileName("new_featureconfig.featureconfig");
		setPageComplete(validatePage());
	}

	public URI getURI() {
		return URI.createPlatformResourceURI(getFilePath().toString(), false);
	}

	
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
	
	protected boolean validatePage() {
		if (!super.validatePage()) {
			return false;
		}
		String extension = getExtension();
		if (extension != null
				&& !getFilePath().toString().endsWith("." + extension)) {
			setErrorMessage(NLS
					.bind(
							"Error",
							extension));
			return false;
		}
		return true;
	}

	private String getExtension() {
		return fileExtension;
	}
	
	public static String getUniqueFileName(IPath containerFullPath,
			String fileName, String extension) {
		if (containerFullPath == null) {
			containerFullPath = new Path(""); //$NON-NLS-1$
		}
		if (fileName == null || fileName.trim().length() == 0) {
			fileName = "default"; //$NON-NLS-1$
		}
		IPath filePath = containerFullPath.append(fileName);
		if (extension != null && !extension.equals(filePath.getFileExtension())) {
			filePath = filePath.addFileExtension(extension);
		}
		extension = filePath.getFileExtension();
		fileName = filePath.removeFileExtension().lastSegment();
		int i = 1;
		while (ResourcesPlugin.getWorkspace().getRoot().exists(filePath)) {
			i++;
			filePath = containerFullPath.append(fileName + i);
			if (extension != null) {
				filePath = filePath.addFileExtension(extension);
			}
		}
		return filePath.lastSegment();
	}
}