package de.uka.ipd.sdq.code2model.popup.actions;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.expressions.IEvaluationContext;
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.IMethod;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.ISources;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchWindow;

import de.uka.ipd.sdq.code2model.LoggingManager;
import de.uka.ipd.sdq.code2model.analysis.AnalysisState;
import de.uka.ipd.sdq.code2model.analysis.UserSelection;
import de.uka.ipd.sdq.code2model.astvisitors.MethodDeclarationCollectingASTVisitor;
import de.uka.ipd.sdq.code2model.ui.UserMessage;
import de.uka.ipd.sdq.code2model.wizards.Code2ModelWizard;

/**
 * The handler as defined by {@link AbstractHandler} by Eclipse. Mainly starts
 * the wizard guiding the user through the analysis.
 * 
 * @author thomas
 */
public class GenerateRDSEFFHandler extends AbstractHandler {
	
	/* (non-Javadoc)
	 * @see org.eclipse.core.commands.AbstractHandler#execute(org.eclipse.core.commands.ExecutionEvent)
	 */
	@Override
	public Object execute(ExecutionEvent arg0) throws ExecutionException {
		Object contextObj = arg0.getApplicationContext();
		if ((contextObj == null) || (!(contextObj instanceof IEvaluationContext))) {
			UserMessage.displayErrorMessage("Error: execute() " +
					"received an invalid context object.  Aborting.");
			return null;
		}
		IEvaluationContext context = (IEvaluationContext) contextObj;

		TreeSelection selection;
		try {
			selection = (TreeSelection) context
			.getVariable(ISources.ACTIVE_CURRENT_SELECTION_NAME);
		} catch (ClassCastException e) {
			UserMessage.displayErrorMessage("There is a problem with the selection, " +
					"aborting.  Please select method and Java files only.");
			return null;
		}

		initializeLogging(selection);

		UserSelection userSelection;
		try {
			userSelection = new UserSelection(selection);
		} catch (InvocationTargetException e1) {
			UserMessage.displayException(e1);
			return null;
		}

		try {
			updateStateWithMethodBodies(userSelection);
		} catch (InvocationTargetException e) {
			UserMessage.displayException(e);
			return null;
		}

		Shell shell = (Shell) context.getVariable(ISources.ACTIVE_SHELL_NAME);
		startWizard(shell, context, userSelection);

		// As of 2007-05-06, this is mandatory
		return null;
	}

	/**
	 * Initializes the logging system of the plug-in. Must be called before any
	 * logging call is done!
	 * <p>
	 * It takes the user selection as parameter to find out the project name, in
	 * order to place the log file into the project directory.
	 * </p>
	 * 
	 * @param selection the user selection
	 */
	private void initializeLogging(TreeSelection selection) {
		// Get the project name to write the log file into the project directory.
		String project = null;
		Object obj = selection.getFirstElement();
		if (obj instanceof IMethod) {
			IMethod imethod = (IMethod) obj;
			project = imethod.getJavaProject().getElementName();
		} else if (obj instanceof ICompilationUnit) {
			ICompilationUnit icompUnit = (ICompilationUnit) obj;
			project = icompUnit.getJavaProject().getElementName();
		}
		if (project == null) {
			LoggingManager.initializeLogging();
		} else {
			LoggingManager.initializeLogging(project);
		}
	}

	/**
	 * Iterates through everything the user selected and collects all method
	 * declarations, storing them in the {@link AnalysisState}.
	 * 
	 * @param userSelection the user's selection
	 * @throws InvocationTargetException
	 */
	private void updateStateWithMethodBodies(UserSelection userSelection)
			throws InvocationTargetException {
		AnalysisState.reset();
		for (CompilationUnit unit : userSelection) {
			try {
				MethodDeclarationCollectingASTVisitor collector = 
						new MethodDeclarationCollectingASTVisitor();
				unit.accept(collector);
			} catch (Exception e) {
				e.printStackTrace();
				throw (new InvocationTargetException(e));
			}
		}
	}

	/**
	 * Start the wizard allowing the user to classify methods as external.
	 *
	 * @param shell the Shell to display he wizard in
	 * @param context the {@link IEvaluationContext} we are in
	 * @param selection the user's selection
	 */
	private void startWizard(Shell shell, IEvaluationContext context,
			UserSelection selection) {
		// We need the workbench, the SWT shell, and the user selection.
		IWorkbenchWindow window = (IWorkbenchWindow) context
				.getVariable(ISources.ACTIVE_WORKBENCH_WINDOW_NAME);
		IWorkbench workbench = window.getWorkbench();

		// Start the wizard.
		Code2ModelWizard wizard = new Code2ModelWizard();
		wizard.init(workbench, selection);
		WizardDialog dialog = new WizardDialog(shell, wizard);
		dialog.create();
		dialog.open();
	}

}
