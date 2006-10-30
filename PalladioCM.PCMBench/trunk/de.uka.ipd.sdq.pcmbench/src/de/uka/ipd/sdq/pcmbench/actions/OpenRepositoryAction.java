package de.uka.ipd.sdq.pcmbench.actions;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.IWorkbenchWindowActionDelegate;

import de.uka.ipd.sdq.pcmbench.EditingDomainFactory;

public class OpenRepositoryAction extends Action implements IWorkbenchWindowActionDelegate {

	public final static String ID = "de.uka.ipd.sdq.pcmbench.actions.OpenRepositoryAction";
	private IWorkbenchWindow window = null;
	private Shell shell = null;
	
	public void dispose() {
	}
	
	public void init(IWorkbenchWindow window) {
		this.window = window;
		setId(ID);
		setText("&Open Repository...");
		setToolTipText("Opens a new repository containing components and interfaces");
		shell = window.getShell();
	}

	public void run(IAction action) {
		final TransactionalEditingDomain domain = 
			TransactionalEditingDomain.Registry.INSTANCE.getEditingDomain(EditingDomainFactory.EDITING_DOMAIN_ID);

		FileDialog selectRepositoryDialog = new FileDialog(shell);
		selectRepositoryDialog.setFilterExtensions(new String[]{"*.repository"});
		selectRepositoryDialog.setFilterNames(new String[]{"PCM Repositories (*.repository)"});
		selectRepositoryDialog.setText("Select a PCM repository to open...");
		selectRepositoryDialog.setFileName("C:/Dokumente und Einstellungen/Snowball/PCM/ModelExample.QoSA06/My.repository");
		String filename = selectRepositoryDialog.open();
		if (filename != null)
		{
			URI model = URI.createFileURI(filename);
			ResourceSet resourceSet = domain.getResourceSet();
			try
			{
				resourceSet.getResource(model, true);
			}
			catch (Throwable t)
			{
				MessageDialog.openInformation(shell, "Resource Loader Error",
						t.getMessage());
			}
		}
	}

	public void selectionChanged(IAction action, ISelection selection) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.action.Action#run()
	 */
	@Override
	public void run() {
		run(this);
	}

}
