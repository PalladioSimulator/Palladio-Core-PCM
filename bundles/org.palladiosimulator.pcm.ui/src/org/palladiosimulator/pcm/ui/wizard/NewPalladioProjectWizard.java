package org.palladiosimulator.pcm.ui.wizard;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.SubProgressMonitor;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.actions.WorkspaceModifyOperation;
import org.eclipse.ui.dialogs.WizardNewProjectCreationPage;
import org.eclipse.ui.wizards.newresource.BasicNewProjectResourceWizard;

/**
 * A wizard to create a new palladio model according to a chosen template.
 */
public class NewPalladioProjectWizard extends Wizard implements INewWizard {

	private WizardNewProjectCreationPage projectInfoPage;
	private NewPalladioTemplateWizardPage palladioTemplatePage;
	private IProject project;
	private IConfigurationElement config;
	private IWorkbench workbench;

	/**
	 * Constructor for NewPCMWizard.
	 */
	public NewPalladioProjectWizard() {
		super();
		setNeedsProgressMonitor(true);
	}

	/**
	 * Adding the page to the wizard.
	 */

	public void addPages() {

		// set the basic project page
		projectInfoPage = new WizardNewProjectCreationPage("NewPalladioProject");
		projectInfoPage.setDescription("Create a new Palladio project with a basic set of models.");
		projectInfoPage.setTitle("New Palladio Project");
		addPage(projectInfoPage);

		Set<PalladioTemplate> availableTemplates = getAvailableTemplates();
		palladioTemplatePage = new NewPalladioTemplateWizardPage(availableTemplates);
		addPage(palladioTemplatePage);
	}

	@Override
	public boolean performFinish() {

		if (project != null) {
			return true;
		}

		final IProject projectHandle = projectInfoPage.getProjectHandle();

		URI projectURI = (!projectInfoPage.useDefaults()) ? projectInfoPage
				.getLocationURI() : null;

		IWorkspace workspace = ResourcesPlugin.getWorkspace();

		final IProjectDescription desc = workspace
				.newProjectDescription(projectHandle.getName());

		desc.setLocationURI(projectURI);

		/*
		 * Creating the project encapsulated in a workspace operation
		 */
		WorkspaceModifyOperation op = new WorkspaceModifyOperation() {
			protected void execute(IProgressMonitor monitor)
					throws CoreException {
				createProject(desc, projectHandle, monitor);
			}
		};

		/*
		 * This isn't as robust as the code in the BasicNewProjectResourceWizard
		 * class. Consider beefing this up to improve error handling.
		 */
		try {
			getContainer().run(true, true, op);
		} catch (Exception e) {
			MessageDialog.openError(getShell(), "Error",
					e.getMessage());
			return false;
		}

		project = projectHandle;

		if (project == null) {
			return false;
		}

		BasicNewProjectResourceWizard.updatePerspective(config);
		BasicNewProjectResourceWizard.selectAndReveal(project,
				workbench.getActiveWorkbenchWindow());

		return true;
	}

	/**
	 * This creates the project in the workspace.
	 * 
	 * @param description
	 *            The description to set for the project.
	 * @param projectHandle
	 * @param monitor
	 * @throws CoreException
	 * @throws OperationCanceledException
	 */
	void createProject(IProjectDescription description, IProject proj,
			IProgressMonitor monitor) throws CoreException,
			OperationCanceledException {
		try {

			monitor.beginTask("", 2000);
			proj.create(description, new SubProgressMonitor(monitor, 1000));

			if (monitor.isCanceled()) {
				throw new OperationCanceledException();
			}

			proj.open(IResource.BACKGROUND_REFRESH, new SubProgressMonitor(
					monitor, 1000));

			IContainer container = (IContainer) proj;
			
			// check if a template was selected and produce the model files
			PalladioTemplate selectedTemplate = palladioTemplatePage.getSelectedTemplate();
			if(selectedTemplate != null){
				Map<String,String> uriMap = selectedTemplate.getModelFiles();
				for (String uri : uriMap.keySet()) {
					String targetFileName = uriMap.get(uri);
					addModelFile(uri, targetFileName, container, monitor);
				}
			}

		} finally {
			monitor.done();
		}
	}
	


	/**
	 * Get the set of registered model templates.
	 * @return
	 */
	private Set<PalladioTemplate> getAvailableTemplates() {
		ExtensionHelper helper = new ExtensionHelper();
		return helper.getPalladioModelTemplates();
	}

	/**
	 * Create a file in the project.
	 * 
	 * @param sourceFile The URI path to the source file to add (e.g. plattform://pluginid/...")
	 * @param targetFileName The filename of the target file to write.
	 * @param container The container to place the target file in.
	 * @param monitor The monitor to track the progress.
	 * @throws CoreException Identifying that the file could not be written.
	 */
	private void addModelFile(String sourceFileURI, String targetFileName,
			IContainer container, IProgressMonitor monitor)
			throws CoreException {
		InputStream resourceStream = null;;
		try {

			URL url = new URL(sourceFileURI);
			resourceStream = url.openConnection().getInputStream();
			if(resourceStream != null){
				addFileToProject(container, new Path(targetFileName), resourceStream,
						monitor);
			}
		} catch (IOException ioe) {
			throwCoreException(ioe.getLocalizedMessage());
		} finally {
			if(resourceStream != null){
				try {
					resourceStream.close();
				} catch (IOException e) {
					throwCoreException(e.getLocalizedMessage());
				}
			}
		}
	}

	/**
	 * Adds a new file to the project.
	 * 
	 * @param container
	 * @param path
	 * @param contentStream
	 * @param monitor
	 * @throws CoreException
	 */
	private void addFileToProject(IContainer container, Path path,
			InputStream contentStream, IProgressMonitor monitor)
			throws CoreException {
		final IFile file = container.getFile(path);
		if (file.exists()) {
			file.setContents(contentStream, true, true, monitor);
		} else {
			file.create(contentStream, true, monitor);
		}
	}

	/**
	 * Throw a core exception based on a given error message.
	 * @param message The message to present.
	 * @throws CoreException The exception to throw.
	 */
	private void throwCoreException(String message) throws CoreException {
		IStatus status = new Status(IStatus.ERROR,
				"org.palladiosimulator.pcm.ui", IStatus.OK, message, null);
		throw new CoreException(status);
	}

	@Override
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		//this.selection = selection;
		this.workbench = workbench;
	}
}