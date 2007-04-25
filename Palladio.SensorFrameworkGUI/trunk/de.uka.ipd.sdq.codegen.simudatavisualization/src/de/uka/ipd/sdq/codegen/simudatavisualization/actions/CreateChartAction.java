/**
 * 
 */
package de.uka.ipd.sdq.codegen.simudatavisualization.actions;


import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.IWorkbenchWindowActionDelegate;
import org.eclipse.ui.PartInitException;

import de.uka.ipd.sdq.codegen.simudatavisualization.SimuPlugin;
import de.uka.ipd.sdq.codegen.simudatavisualization.editor.AbstractReportView;
import de.uka.ipd.sdq.codegen.simudatavisualization.editor.ConfigEditorInput;
import de.uka.ipd.sdq.codegen.simudatavisualization.jfreechart.JFreeChartPieViewer;
import de.uka.ipd.sdq.codegen.simudatavisualization.views.JFreeChartPieReport;
import de.uka.ipd.sdq.codegen.simudatavisualization.views.ReportView;

/**
 * @author admin
 * 
 */
public class CreateChartAction implements IWorkbenchWindowActionDelegate {

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.IWorkbenchWindowActionDelegate#dispose()
	 */
	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.IWorkbenchWindowActionDelegate#init(org.eclipse.ui.IWorkbenchWindow)
	 */
	@Override
	public void init(IWorkbenchWindow window) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.IActionDelegate#run(org.eclipse.jface.action.IAction)
	 */
	@Override
	public void run(IAction action) {
		
		IWorkbenchPage page = SimuPlugin.getDefault().getWorkbench()
		.getActiveWorkbenchWindow().getActivePage();
		
		try {
			page.openEditor(new ConfigEditorInput(), JFreeChartPieReport.JFREECHART_PIE_EDITOR_ID);
		} catch (PartInitException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.IActionDelegate#selectionChanged(org.eclipse.jface.action.IAction,
	 *      org.eclipse.jface.viewers.ISelection)
	 */
	@Override
	public void selectionChanged(IAction action, ISelection selection) {
		// TODO Auto-generated method stub

	}

}
