package de.uka.ipd.sdq.pcmbench.wizards;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.jface.dialogs.IMessageProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.dialogs.WizardNewProjectCreationPage;

import de.uka.ipd.sdq.pcmbench.PCMBenchActivator;

/**
 * @author steffen, johann
 *
 */
public class RepositoryProjectWizard extends Wizard implements INewWizard {

	private IWorkbench workbench;
	private IStructuredSelection selection;
	private WizardNewProjectCreationPage page;
	private IWorkspace workspace;
	/**
	 * 
	 */
	public RepositoryProjectWizard() {
		workspace = ResourcesPlugin.getWorkspace();
	}

	@Override
	public boolean performFinish() {
		IProject newProject = workspace.getRoot().getProject(page.getProjectName());
		try {
			if (!newProject.exists())
				newProject.create(null);
			newProject.open(null);
			IProjectDescription description = newProject.getDescription();
			String[] natures = description.getNatureIds();
			String[] newNatures = new String[natures.length + 1];
			System.arraycopy(natures, 0, newNatures, 0, natures.length);
			newNatures[natures.length] = "de.uka.ipd.sdq.pcmbench.nature";
			IStatus status = workspace.validateNatureSet(natures);

			// check the status and decide what to do
			if (status.getCode() == IStatus.OK) {
				description.setNatureIds(newNatures);
				newProject.setDescription(description, null);
			} else {
				// raise a user error
			}
		} catch (CoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public void init(IWorkbench workbench, IStructuredSelection selection) {
		this.workbench = workbench;
		this.selection = selection;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.wizard.Wizard#addPages()
	 */
	@Override
	public void addPages() {
		page = new WizardNewProjectCreationPage("Create New Palladio Component Repository Project");
		page.setDescription("Create a new Palladio Component Repository Modelling Project. "+
				"This type of project is used to specify component repositories.");
		page.setMessage(page.getDescription(),IMessageProvider.INFORMATION);
		page.setImageDescriptor(PCMBenchActivator.imageDescriptorFromPlugin(
					PCMBenchActivator.PLUGIN_ID,
					"icons/palladio-logo.gif"));
		page.setTitle("Create a PCM Component Repository Modelling Project");
		this.addPage(page);
	}

}
