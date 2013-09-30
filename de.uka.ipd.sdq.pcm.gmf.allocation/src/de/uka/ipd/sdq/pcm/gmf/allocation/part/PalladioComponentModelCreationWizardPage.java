/*
 * Copyright 2007, SDQ, IPD, U KA
 */
package de.uka.ipd.sdq.pcm.gmf.allocation.part;

/**
 * @generated
 */
public class PalladioComponentModelCreationWizardPage extends
			org.eclipse.ui.dialogs.WizardNewFileCreationPage
			{

	/**
 * @generated
 */
	private final String fileExtension;

	/**
 * @generated
 */
	public PalladioComponentModelCreationWizardPage(String pageName,
			org.eclipse.jface.viewers.IStructuredSelection selection, String fileExtension) {
		super(pageName, selection);
		this.fileExtension = fileExtension;
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
	public org.eclipse.emf.common.util.URI getURI() {
			return org.eclipse.emf.common.util.URI.createPlatformResourceURI(getFilePath().toString(), false);
		}
	
	/**
 * @generated
 */
	protected org.eclipse.core.runtime.IPath getFilePath() {
		org.eclipse.core.runtime.IPath path = getContainerFullPath();
		if (path == null) {
			path = new org.eclipse.core.runtime.Path(""); //$NON-NLS-1$
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
	public void createControl(org.eclipse.swt.widgets.Composite parent) {
		super.createControl(parent);
		setFileName(de.uka.ipd.sdq.pcm.gmf.allocation.part.PalladioComponentModelDiagramEditorUtil.getUniqueFileName(
				getContainerFullPath(), getFileName(), getExtension()));
		setPageComplete(validatePage());
	}

	/**
 * @generated
 */
	protected boolean validatePage() {
		if (!super.validatePage()) {
			return false;
		}
		String extension = getExtension();
		if (extension != null && !getFilePath().toString().endsWith("." + extension)) {
			setErrorMessage(org.eclipse.osgi.util.NLS.bind(
					de.uka.ipd.sdq.pcm.gmf.allocation.part.Messages.PalladioComponentModelCreationWizardPageExtensionError, extension));
			return false;
		}
		return true;
	}
	}
