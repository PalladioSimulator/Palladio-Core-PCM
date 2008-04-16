package de.uka.ipd.sdq.sensorframework.visualisation.rvisualisation;

import org.apache.log4j.Logger;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.IWorkbenchWindowActionDelegate;
import org.eclipse.ui.PartInitException;
import org.eclipse.jface.dialogs.MessageDialog;

import de.uka.ipd.sdq.sensorframework.visualisation.editor.ConfigEditorInput;
import de.uka.ipd.sdq.sensorframework.visualisation.rvisualisation.utils.RConnection;
import de.uka.ipd.sdq.sensorframework.visualisation.rvisualisation.views.TimeSeriesHtmlReportView;

/**
 * Our sample action implements workbench action delegate.
 * The action proxy will be created by the workbench and
 * shown in the UI. When the user tries to use the action,
 * this delegate will be created and execution will be 
 * delegated to it.
 * @see IWorkbenchWindowActionDelegate
 */
public class OpenRReportAction implements IWorkbenchWindowActionDelegate {
	/** The logger used by this class. */
	private static Logger logger = 
		Logger.getLogger(RConnection.class.getName());
	
	/** The parent window. Used to display message boxes. */
	private IWorkbenchWindow parentWorkbenchWindow;
	
	/** Identifier of the factory responsible for creating data adapters. */
	private String adapterFactoryID;

	/**Initializes a new report.
	 * @param adapterFactoryID The identifier for the factory that is 
	 *        responsible for creating data adapters.
	 */
	public OpenRReportAction(final String adapterFactoryID) {
		this.adapterFactoryID = adapterFactoryID;
	}

	/** {@inheritDoc}
	 */
	public void run(final IAction action) {
		/*
		 * The action has been activated. The argument of the
		 * method represents the 'real' action sitting
		 * in the workbench UI.
		 * @see IWorkbenchWindowActionDelegate#run
		 */
		IWorkbenchPage page = RVisualisationPlugin.getDefault().getWorkbench()
		.getActiveWorkbenchWindow().getActivePage();
		
		try {
			page.openEditor(new ConfigEditorInput(adapterFactoryID), 
					TimeSeriesHtmlReportView.RREPORTVIEW_ID);
		} catch (PartInitException e) {
			logger.error("Could not generate R report for the ID " 
					+ TimeSeriesHtmlReportView.RREPORTVIEW_ID + " and data "
					+ "adapter factory "
					+ "with ID " + adapterFactoryID + ".", e);
			MessageDialog.openError(parentWorkbenchWindow.getShell(), "Could "
					+ "not generate R report", 
					"The R report for the ID " 
					+ TimeSeriesHtmlReportView.RREPORTVIEW_ID 
					+ " and data adapter factory " + "with ID " 
					+ adapterFactoryID + "could not be generated. Details were"
					+ " written to the logfile.");
		}
	}

	/** {@inheritDoc}
	 */
	public void selectionChanged(final IAction action, 
			final ISelection selection) {
		/*
		 * Selection in the workbench has been changed. We 
		 * can change the state of the 'real' action here
		 * if we want, but this can only happen after 
		 * the delegate has been created.
		 * @see IWorkbenchWindowActionDelegate#selectionChanged
		 */

		// Nothing to do
	}

	/**
	 * We can use this method to dispose of any system
	 * resources we previously allocated.
	 * @see IWorkbenchWindowActionDelegate#dispose
	 * {@inheritDoc}
	 */
	public void dispose() {
	}

	/** {@inheritDoc}
	 */
	public void init(final IWorkbenchWindow parentWindow) {
		/*
		 * We will cache window object in order to
		 * be able to provide parent shell for the message dialog.
		 * @see IWorkbenchWindowActionDelegate#init
		 */
		parentWorkbenchWindow = parentWindow;
	}
}
