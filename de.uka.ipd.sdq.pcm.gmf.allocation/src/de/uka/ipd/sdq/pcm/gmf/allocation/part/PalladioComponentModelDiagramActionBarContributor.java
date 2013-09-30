/*
 * Copyright 2007, SDQ, IPD, U KA
 */
package de.uka.ipd.sdq.pcm.gmf.allocation.part;

/**
 * @generated
 */
public class PalladioComponentModelDiagramActionBarContributor extends org.eclipse.gmf.runtime.diagram.ui.parts.DiagramActionBarContributor {

	/**
 * @generated
 */
	protected Class getEditorClass() {
		return de.uka.ipd.sdq.pcm.gmf.allocation.part.PalladioComponentModelAllocationDiagramEditor.class;
	}

	/**
 * @generated
 */
	protected String getEditorId() {
		return de.uka.ipd.sdq.pcm.gmf.allocation.part.PalladioComponentModelAllocationDiagramEditor.ID;
	}
	
	/**
 * @generated
 */
	public void init(org.eclipse.ui.IActionBars bars, org.eclipse.ui.IWorkbenchPage page) {
		super.init(bars, page);
		// print preview
		org.eclipse.jface.action.IMenuManager fileMenu = bars.getMenuManager().findMenuUsingPath(org.eclipse.ui.IWorkbenchActionConstants.M_FILE);
		assert fileMenu != null;
		org.eclipse.jface.action.IAction printPreviewAction = new org.eclipse.gmf.runtime.diagram.ui.printing.render.actions.RenderedPrintPreviewAction(new org.eclipse.gmf.runtime.diagram.ui.printing.render.actions.EnhancedPrintActionHelper());
		fileMenu.insertBefore("print", printPreviewAction); //$NON-NLS-1$
	}
	}
