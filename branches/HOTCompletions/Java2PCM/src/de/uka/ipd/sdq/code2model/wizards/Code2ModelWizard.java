package de.uka.ipd.sdq.code2model.wizards;

import java.lang.reflect.InvocationTargetException;

import org.apache.log4j.Logger;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.wizard.IWizard;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IWorkbench;

import de.uka.ipd.sdq.code2model.Activator;
import de.uka.ipd.sdq.code2model.analysis.RDSEFFBuildingAnalysisDirector;
import de.uka.ipd.sdq.code2model.analysis.UserSelection;
import de.uka.ipd.sdq.code2model.preferences.Code2ModelPreferences;
import de.uka.ipd.sdq.code2model.ui.UserMessage;

/**
 * Lets the user choose which packages are to be considered "external", then
 * starts the code analysis.
 * 
 * @author thomas
 */
public class Code2ModelWizard extends Wizard implements IWizard {
	private UserSelection userSelection;
	private IWorkbench workbench;
	
	public WizardPage modePage;
	public WizardPage pkgsPage;
	
	public static final String modeChoicePageName = "modeChoicePage";
	public static final String extPkgsChoicePageName = "extPkgsChoicePage";
	
	protected Logger logger;

	/* (non-Javadoc)
	 * @see org.eclipse.jface.wizard.Wizard#canFinish()
	 */
	@Override
	public boolean canFinish() {
		IPreferenceStore prefs = Activator.getDefault().getPreferenceStore();
		int mode = prefs
				.getInt(Code2ModelPreferences.externalClassificationMode);
		if (mode == Code2ModelPreferences.EXT_CLASSIFICATION_USER) {
			if (this.getContainer().getCurrentPage().equals(pkgsPage)) {
				return true;
			}
			return false;
		}
		return true;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.wizard.Wizard#performFinish()
	 */
	@Override
	public boolean performFinish() {
		logger = Logger.getLogger(this.getClass());
		
		Shell shell = workbench.getActiveWorkbenchWindow().getShell();
		try {
			IRunnableWithProgress op = new RDSEFFBuildingAnalysisDirector(userSelection);
			new ProgressMonitorDialog(shell).run(true /* Separate thread */,
					true /* Cancellable */, op);
			String savedRepoLocation = ((RDSEFFBuildingAnalysisDirector) op)
					.getSavedRepositoryLocation();
			MessageDialog.openInformation(shell, "Finished",
					"Repository saved to " + savedRepoLocation);
		} catch (InvocationTargetException e) {
			UserMessage.displayException(e.getTargetException());
		} catch (InterruptedException e) {
			// do nothing
		} catch (Exception e) {
			UserMessage.displayException(e);
		}

		return true;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.ui.IWorkbenchWizard#init(org.eclipse.ui.IWorkbench,
	 *      org.eclipse.jface.viewers.IStructuredSelection)
	 */
	public void init(IWorkbench workbench, UserSelection selection) {
		this.workbench = workbench;
		this.userSelection = selection;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.wizard.Wizard#addPages()
	 */
	@Override
	public void addPages() {
		modePage = new ExternalModeChoicePage(); 
		addPage(modePage);
		pkgsPage = new ExternalPackageChoicePage(this.userSelection); 
		addPage(pkgsPage);
	}

}
