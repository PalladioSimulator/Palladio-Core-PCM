package de.uka.ipd.sdq.reliability.solver.popup.actions;

import org.eclipse.core.resources.IFile;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IActionDelegate;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;

import de.uka.ipd.sdq.reliability.solver.compare.MarkovComparator;
import de.uka.ipd.sdq.reliability.solver.helper.LoggingHelper;

public class CompareAction implements IObjectActionDelegate {

    /**
     * Supports logging functionality.
     */
    private LoggingHelper loggingHelper = LoggingHelper.getSingletonInstance();

    /**
     * The user's selection.
     */
    private ISelection selection;

    /**
     * Constructor for CompareAction.
     */
    public CompareAction() {
        super();
    }

    /**
     * @see IActionDelegate#run(IAction)
     */
    public void run(IAction action) {

        // Setup logging:
        loggingHelper.initializeLogging();

        // We assume exactly two *.markov files to be selected:
        Object[] selectedObjects = ((IStructuredSelection) selection).toArray();
        new MarkovComparator().compare(((IFile) selectedObjects[0]).getLocation().toString(), // first
                                                                                              // file
                ((IFile) selectedObjects[1]).getLocation().toString()); // second
        // file
    }

    /**
     * @see IActionDelegate#selectionChanged(IAction, ISelection)
     */
    public void selectionChanged(IAction action, ISelection selection) {
        this.selection = selection;
    }

    /**
     * @see IObjectActionDelegate#setActivePart(IAction, IWorkbenchPart)
     */
    public void setActivePart(IAction action, IWorkbenchPart targetPart) {

    }
}
