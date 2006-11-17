/*
 *Copyright 2006 SDQ Research Group, University of Karlsruhe (TH)
 */
package de.uka.ipd.sdq.pcm.gmf.seff.part;

import org.eclipse.core.resources.IFile;
import org.eclipse.draw2d.DelegatingLayout;
import org.eclipse.draw2d.FreeformLayer;
import org.eclipse.draw2d.LayeredPane;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.LayerConstants;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramRootEditPart;
import org.eclipse.gmf.runtime.diagram.ui.resources.editor.ide.document.StorageDiagramDocumentProvider;
import org.eclipse.gmf.runtime.diagram.ui.resources.editor.ide.editor.FileDiagramEditor;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.ide.IGotoMarker;

import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.PcmEditPartFactory;

/**
 * @generated
 */
public class SeffDiagramEditor extends FileDiagramEditor implements IGotoMarker {

	/**
	 * @generated
	 */
	public static final String ID = "de.uka.ipd.sdq.pcm.gmf.seff.part.SeffDiagramEditorID"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	public SeffDiagramEditor() {
		super(true);
	}

	/**
	 * @generated
	 */
	protected String getEditingDomainID() {
		return "de.uka.ipd.sdq.pcm.gmf.seff.EditingDomain"; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	protected TransactionalEditingDomain createEditingDomain() {
		TransactionalEditingDomain domain = super.createEditingDomain();
		domain.setID(getEditingDomainID());
		return domain;
	}

	/**
	 * @generated
	 */
	protected void setDocumentProvider(IEditorInput input) {
		if (input.getAdapter(IFile.class) != null) {
			setDocumentProvider(new PcmDocumentProvider());
		} else {
			setDocumentProvider(new StorageDiagramDocumentProvider());
		}
	}

	/**
	 * @generated
	 */
	protected void configureGraphicalViewer() {
		super.configureGraphicalViewer();
		DiagramRootEditPart root = (DiagramRootEditPart) getDiagramGraphicalViewer()
				.getRootEditPart();
		LayeredPane printableLayers = (LayeredPane) root
				.getLayer(LayerConstants.PRINTABLE_LAYERS);
		FreeformLayer extLabelsLayer = new FreeformLayer();
		extLabelsLayer.setLayoutManager(new DelegatingLayout());
		printableLayers.addLayerAfter(extLabelsLayer,
				PcmEditPartFactory.EXTERNAL_NODE_LABELS_LAYER,
				LayerConstants.PRIMARY_LAYER);
		LayeredPane scalableLayers = (LayeredPane) root
				.getLayer(LayerConstants.SCALABLE_LAYERS);
		FreeformLayer scaledFeedbackLayer = new FreeformLayer();
		scaledFeedbackLayer.setEnabled(false);
		scalableLayers.addLayerAfter(scaledFeedbackLayer,
				LayerConstants.SCALED_FEEDBACK_LAYER,
				DiagramRootEditPart.DECORATION_UNPRINTABLE_LAYER);
	}
}
