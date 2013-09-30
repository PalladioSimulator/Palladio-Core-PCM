/*
 * Copyright 2007, SDQ, IPD, U KA
 */
package de.uka.ipd.sdq.pcm.gmf.allocation.providers;

/**
 * @generated
 */
public class PalladioComponentModelViewProvider extends org.eclipse.gmf.runtime.common.core.service.AbstractProvider implements org.eclipse.gmf.runtime.diagram.core.providers.IViewProvider {

	/**
 * @generated
 */
	public final boolean provides(org.eclipse.gmf.runtime.common.core.service.IOperation operation) {
		if (operation instanceof org.eclipse.gmf.runtime.diagram.core.services.view.CreateViewForKindOperation) {
			return provides((org.eclipse.gmf.runtime.diagram.core.services.view.CreateViewForKindOperation) operation);
		}
		assert operation instanceof org.eclipse.gmf.runtime.diagram.core.services.view.CreateViewOperation;
		if (operation instanceof org.eclipse.gmf.runtime.diagram.core.services.view.CreateDiagramViewOperation) {
			return provides((org.eclipse.gmf.runtime.diagram.core.services.view.CreateDiagramViewOperation) operation);
		} else if (operation instanceof org.eclipse.gmf.runtime.diagram.core.services.view.CreateEdgeViewOperation) {
			return provides((org.eclipse.gmf.runtime.diagram.core.services.view.CreateEdgeViewOperation) operation);
		} else if (operation instanceof org.eclipse.gmf.runtime.diagram.core.services.view.CreateNodeViewOperation) {
			return provides((org.eclipse.gmf.runtime.diagram.core.services.view.CreateNodeViewOperation) operation);
		}
		return false;
	}

	/**
 * @generated
 */
	protected boolean provides(org.eclipse.gmf.runtime.diagram.core.services.view.CreateViewForKindOperation op) {
/*
		if (op.getViewKind() == Node.class)
			return getNodeViewClass(op.getSemanticAdapter(), op.getContainerView(), op.getSemanticHint()) != null;
		if (op.getViewKind() == Edge.class)
			return getEdgeViewClass(op.getSemanticAdapter(), op.getContainerView(), op.getSemanticHint()) != null;
*/
		return true;
	}

	/**
 * @generated
 */
	protected boolean provides(org.eclipse.gmf.runtime.diagram.core.services.view.CreateDiagramViewOperation op) {
		return de.uka.ipd.sdq.pcm.gmf.allocation.edit.parts.AllocationEditPart.MODEL_ID.equals(op.getSemanticHint()) && de.uka.ipd.sdq.pcm.gmf.allocation.part.PalladioComponentModelVisualIDRegistry.getDiagramVisualID(getSemanticElement(op.getSemanticAdapter())) != -1;
	}

	/**
 * @generated
 */
	protected boolean provides(org.eclipse.gmf.runtime.diagram.core.services.view.CreateNodeViewOperation op) {
		if (op.getContainerView() == null) {
			return false;
		}
		org.eclipse.gmf.runtime.emf.type.core.IElementType elementType = getSemanticElementType(op.getSemanticAdapter());
		org.eclipse.emf.ecore.EObject domainElement = getSemanticElement(op.getSemanticAdapter());
		int visualID;
		if (op.getSemanticHint() == null) {
			// Semantic hint is not specified. Can be a result of call from CanonicalEditPolicy.
			// In this situation there should be NO elementType, visualID will be determined
			// by VisualIDRegistry.getNodeVisualID() for domainElement.
			if (elementType != null || domainElement == null) {
				return false;
			}
			visualID = de.uka.ipd.sdq.pcm.gmf.allocation.part.PalladioComponentModelVisualIDRegistry.getNodeVisualID(op.getContainerView(), domainElement);
		} else {
			visualID = de.uka.ipd.sdq.pcm.gmf.allocation.part.PalladioComponentModelVisualIDRegistry.getVisualID(op.getSemanticHint());
			if (elementType != null) {
				if (!de.uka.ipd.sdq.pcm.gmf.allocation.providers.PalladioComponentModelElementTypes.isKnownElementType(elementType) || (!(elementType instanceof org.eclipse.gmf.runtime.emf.type.core.IHintedType))) {
					return false; // foreign element type
				}
				String elementTypeHint = ((org.eclipse.gmf.runtime.emf.type.core.IHintedType) elementType).getSemanticHint();
				if (!op.getSemanticHint().equals(elementTypeHint)) {
					return false; // if semantic hint is specified it should be the same as in element type
				}
				if (domainElement != null && visualID != de.uka.ipd.sdq.pcm.gmf.allocation.part.PalladioComponentModelVisualIDRegistry.getNodeVisualID(op.getContainerView(), domainElement)) {
					return false; // visual id for node EClass should match visual id from element type
				}
			} else {
				if (!de.uka.ipd.sdq.pcm.gmf.allocation.edit.parts.AllocationEditPart.MODEL_ID.equals(de.uka.ipd.sdq.pcm.gmf.allocation.part.PalladioComponentModelVisualIDRegistry.getModelID(op.getContainerView()))) {
					return false; // foreign diagram
				}
				switch (visualID) {
						case de.uka.ipd.sdq.pcm.gmf.allocation.edit.parts.ResourceContainerEditPart.VISUAL_ID:case de.uka.ipd.sdq.pcm.gmf.allocation.edit.parts.AllocationContextEditPart.VISUAL_ID:									if (domainElement == null || visualID != de.uka.ipd.sdq.pcm.gmf.allocation.part.PalladioComponentModelVisualIDRegistry.getNodeVisualID(op.getContainerView(), domainElement)) {
						return false; // visual id in semantic hint should match visual id for domain element
					}
					break;
					default:
					return false;
				}
			}
		}
		return de.uka.ipd.sdq.pcm.gmf.allocation.edit.parts.ResourceContainerEditPart.VISUAL_ID == visualID||de.uka.ipd.sdq.pcm.gmf.allocation.edit.parts.AllocationContextEditPart.VISUAL_ID == visualID;
	}

	/**
 * @generated
 */
	protected boolean provides(org.eclipse.gmf.runtime.diagram.core.services.view.CreateEdgeViewOperation op) {
		org.eclipse.gmf.runtime.emf.type.core.IElementType elementType = getSemanticElementType(op.getSemanticAdapter());
		if (!de.uka.ipd.sdq.pcm.gmf.allocation.providers.PalladioComponentModelElementTypes.isKnownElementType(elementType) || (!(elementType instanceof org.eclipse.gmf.runtime.emf.type.core.IHintedType))) {
			return false; // foreign element type
		}
		String elementTypeHint = ((org.eclipse.gmf.runtime.emf.type.core.IHintedType) elementType).getSemanticHint();
		if (elementTypeHint == null || (op.getSemanticHint() != null && !elementTypeHint.equals(op.getSemanticHint()))) {
			return false; // our hint is visual id and must be specified, and it should be the same as in element type
		}
		int visualID = de.uka.ipd.sdq.pcm.gmf.allocation.part.PalladioComponentModelVisualIDRegistry.getVisualID(elementTypeHint);
		org.eclipse.emf.ecore.EObject domainElement = getSemanticElement(op.getSemanticAdapter());
		if (domainElement != null && visualID != de.uka.ipd.sdq.pcm.gmf.allocation.part.PalladioComponentModelVisualIDRegistry.getLinkWithClassVisualID(domainElement)) {
			return false; // visual id for link EClass should match visual id from element type
		}
		return true; 
	}

	/**
 * @generated
 */
	public org.eclipse.gmf.runtime.notation.Diagram createDiagram(org.eclipse.core.runtime.IAdaptable semanticAdapter, String diagramKind, org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint preferencesHint) {
		org.eclipse.gmf.runtime.notation.Diagram diagram = org.eclipse.gmf.runtime.notation.NotationFactory.eINSTANCE.createDiagram();
		diagram.getStyles().add(org.eclipse.gmf.runtime.notation.NotationFactory.eINSTANCE.createDiagramStyle());
				diagram.setType(de.uka.ipd.sdq.pcm.gmf.allocation.edit.parts.AllocationEditPart.MODEL_ID);
		diagram.setElement(getSemanticElement(semanticAdapter));
		diagram.setMeasurementUnit(org.eclipse.gmf.runtime.notation.MeasurementUnit.PIXEL_LITERAL);
		return diagram;
	}

	/**
 * @generated
 */
	public org.eclipse.gmf.runtime.notation.Node createNode(org.eclipse.core.runtime.IAdaptable semanticAdapter, org.eclipse.gmf.runtime.notation.View containerView, String semanticHint, int index, boolean persisted, org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint preferencesHint) {
		final org.eclipse.emf.ecore.EObject domainElement = getSemanticElement(semanticAdapter);
		final int visualID;
		if (semanticHint == null) {
			visualID = de.uka.ipd.sdq.pcm.gmf.allocation.part.PalladioComponentModelVisualIDRegistry.getNodeVisualID(containerView, domainElement);
		} else {
			visualID = de.uka.ipd.sdq.pcm.gmf.allocation.part.PalladioComponentModelVisualIDRegistry.getVisualID(semanticHint);
		}
		switch(visualID) {
				case de.uka.ipd.sdq.pcm.gmf.allocation.edit.parts.ResourceContainerEditPart.VISUAL_ID: return createResourceContainer_2003(domainElement, containerView, index, persisted, preferencesHint);
				case de.uka.ipd.sdq.pcm.gmf.allocation.edit.parts.AllocationContextEditPart.VISUAL_ID: return createAllocationContext_3002(domainElement, containerView, index, persisted, preferencesHint);
				}
		// can't happen, provided #provides(CreateNodeViewOperation) is correct
		return null;
	}

	/**
 * @generated
 */
	public org.eclipse.gmf.runtime.notation.Edge createEdge(org.eclipse.core.runtime.IAdaptable semanticAdapter, org.eclipse.gmf.runtime.notation.View containerView, String semanticHint, int index, boolean persisted, org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint preferencesHint) {
		org.eclipse.gmf.runtime.emf.type.core.IElementType elementType = getSemanticElementType(semanticAdapter);
		String elementTypeHint = ((org.eclipse.gmf.runtime.emf.type.core.IHintedType) elementType).getSemanticHint();
		switch (de.uka.ipd.sdq.pcm.gmf.allocation.part.PalladioComponentModelVisualIDRegistry.getVisualID(elementTypeHint)) {
				}
		// can never happen, provided #provides(CreateEdgeViewOperation) is correct
		return null;
	}

	/**
 * @generated
 */
	public org.eclipse.gmf.runtime.notation.Node createResourceContainer_2003(org.eclipse.emf.ecore.EObject domainElement, org.eclipse.gmf.runtime.notation.View containerView, int index, boolean persisted, org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint preferencesHint) {
		org.eclipse.gmf.runtime.notation.Shape node = org.eclipse.gmf.runtime.notation.NotationFactory.eINSTANCE.createShape();
						node.setLayoutConstraint(org.eclipse.gmf.runtime.notation.NotationFactory.eINSTANCE.createBounds());
		node.setType(de.uka.ipd.sdq.pcm.gmf.allocation.part.PalladioComponentModelVisualIDRegistry.getType(de.uka.ipd.sdq.pcm.gmf.allocation.edit.parts.ResourceContainerEditPart.VISUAL_ID));
		org.eclipse.gmf.runtime.diagram.core.util.ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		stampShortcut(containerView, node);
		// initializeFromPreferences 
		final org.eclipse.jface.preference.IPreferenceStore prefStore = (org.eclipse.jface.preference.IPreferenceStore) preferencesHint.getPreferenceStore();
			
				org.eclipse.swt.graphics.RGB lineRGB = org.eclipse.jface.preference.PreferenceConverter.getColor(prefStore, org.eclipse.gmf.runtime.diagram.ui.preferences.IPreferenceConstants.PREF_LINE_COLOR);
	org.eclipse.gmf.runtime.diagram.core.util.ViewUtil.setStructuralFeatureValue(node, org.eclipse.gmf.runtime.notation.NotationPackage.eINSTANCE.getLineStyle_LineColor(), org.eclipse.gmf.runtime.draw2d.ui.figures.FigureUtilities.RGBToInteger(lineRGB));
				org.eclipse.gmf.runtime.notation.FontStyle nodeFontStyle = (org.eclipse.gmf.runtime.notation.FontStyle) node.getStyle(org.eclipse.gmf.runtime.notation.NotationPackage.Literals.FONT_STYLE);
	if (nodeFontStyle != null) {
		org.eclipse.swt.graphics.FontData fontData = org.eclipse.jface.preference.PreferenceConverter.getFontData(prefStore, org.eclipse.gmf.runtime.diagram.ui.preferences.IPreferenceConstants.PREF_DEFAULT_FONT);
		nodeFontStyle.setFontName(fontData.getName());
		nodeFontStyle.setFontHeight(fontData.getHeight());
		nodeFontStyle.setBold((fontData.getStyle() & org.eclipse.swt.SWT.BOLD) != 0);
		nodeFontStyle.setItalic((fontData.getStyle() & org.eclipse.swt.SWT.ITALIC) != 0);
		org.eclipse.swt.graphics.RGB fontRGB = org.eclipse.jface.preference.PreferenceConverter.getColor(prefStore, org.eclipse.gmf.runtime.diagram.ui.preferences.IPreferenceConstants.PREF_FONT_COLOR);
		nodeFontStyle.setFontColor(org.eclipse.gmf.runtime.draw2d.ui.figures.FigureUtilities.RGBToInteger(fontRGB).intValue());
	}
				org.eclipse.swt.graphics.RGB fillRGB = org.eclipse.jface.preference.PreferenceConverter.getColor(prefStore, org.eclipse.gmf.runtime.diagram.ui.preferences.IPreferenceConstants.PREF_FILL_COLOR);
	org.eclipse.gmf.runtime.diagram.core.util.ViewUtil.setStructuralFeatureValue(node, org.eclipse.gmf.runtime.notation.NotationPackage.eINSTANCE.getFillStyle_FillColor(), org.eclipse.gmf.runtime.draw2d.ui.figures.FigureUtilities.RGBToInteger(fillRGB));
					org.eclipse.gmf.runtime.notation.Node label5008 = createLabel(node, de.uka.ipd.sdq.pcm.gmf.allocation.part.PalladioComponentModelVisualIDRegistry.getType(de.uka.ipd.sdq.pcm.gmf.allocation.edit.parts.ResourceContainerEntityNameEditPart.VISUAL_ID));
										createCompartment(node, de.uka.ipd.sdq.pcm.gmf.allocation.part.PalladioComponentModelVisualIDRegistry.getType(de.uka.ipd.sdq.pcm.gmf.allocation.edit.parts.ResourceContainerAllocationCompartmentEditPart.VISUAL_ID), false, false, false, false);
						return node;
	}
	/**
 * @generated
 */
	public org.eclipse.gmf.runtime.notation.Node createAllocationContext_3002(org.eclipse.emf.ecore.EObject domainElement, org.eclipse.gmf.runtime.notation.View containerView, int index, boolean persisted, org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint preferencesHint) {
		org.eclipse.gmf.runtime.notation.Shape node = org.eclipse.gmf.runtime.notation.NotationFactory.eINSTANCE.createShape();
						node.setLayoutConstraint(org.eclipse.gmf.runtime.notation.NotationFactory.eINSTANCE.createBounds());
		node.setType(de.uka.ipd.sdq.pcm.gmf.allocation.part.PalladioComponentModelVisualIDRegistry.getType(de.uka.ipd.sdq.pcm.gmf.allocation.edit.parts.AllocationContextEditPart.VISUAL_ID));
		org.eclipse.gmf.runtime.diagram.core.util.ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		// initializeFromPreferences 
		final org.eclipse.jface.preference.IPreferenceStore prefStore = (org.eclipse.jface.preference.IPreferenceStore) preferencesHint.getPreferenceStore();
			
				org.eclipse.swt.graphics.RGB lineRGB = org.eclipse.jface.preference.PreferenceConverter.getColor(prefStore, org.eclipse.gmf.runtime.diagram.ui.preferences.IPreferenceConstants.PREF_LINE_COLOR);
	org.eclipse.gmf.runtime.diagram.core.util.ViewUtil.setStructuralFeatureValue(node, org.eclipse.gmf.runtime.notation.NotationPackage.eINSTANCE.getLineStyle_LineColor(), org.eclipse.gmf.runtime.draw2d.ui.figures.FigureUtilities.RGBToInteger(lineRGB));
				org.eclipse.gmf.runtime.notation.FontStyle nodeFontStyle = (org.eclipse.gmf.runtime.notation.FontStyle) node.getStyle(org.eclipse.gmf.runtime.notation.NotationPackage.Literals.FONT_STYLE);
	if (nodeFontStyle != null) {
		org.eclipse.swt.graphics.FontData fontData = org.eclipse.jface.preference.PreferenceConverter.getFontData(prefStore, org.eclipse.gmf.runtime.diagram.ui.preferences.IPreferenceConstants.PREF_DEFAULT_FONT);
		nodeFontStyle.setFontName(fontData.getName());
		nodeFontStyle.setFontHeight(fontData.getHeight());
		nodeFontStyle.setBold((fontData.getStyle() & org.eclipse.swt.SWT.BOLD) != 0);
		nodeFontStyle.setItalic((fontData.getStyle() & org.eclipse.swt.SWT.ITALIC) != 0);
		org.eclipse.swt.graphics.RGB fontRGB = org.eclipse.jface.preference.PreferenceConverter.getColor(prefStore, org.eclipse.gmf.runtime.diagram.ui.preferences.IPreferenceConstants.PREF_FONT_COLOR);
		nodeFontStyle.setFontColor(org.eclipse.gmf.runtime.draw2d.ui.figures.FigureUtilities.RGBToInteger(fontRGB).intValue());
	}
				org.eclipse.swt.graphics.RGB fillRGB = org.eclipse.jface.preference.PreferenceConverter.getColor(prefStore, org.eclipse.gmf.runtime.diagram.ui.preferences.IPreferenceConstants.PREF_FILL_COLOR);
	org.eclipse.gmf.runtime.diagram.core.util.ViewUtil.setStructuralFeatureValue(node, org.eclipse.gmf.runtime.notation.NotationPackage.eINSTANCE.getFillStyle_FillColor(), org.eclipse.gmf.runtime.draw2d.ui.figures.FigureUtilities.RGBToInteger(fillRGB));
					org.eclipse.gmf.runtime.notation.Node label5006 = createLabel(node, de.uka.ipd.sdq.pcm.gmf.allocation.part.PalladioComponentModelVisualIDRegistry.getType(de.uka.ipd.sdq.pcm.gmf.allocation.edit.parts.AllocationContextEntityNameEditPart.VISUAL_ID));
								org.eclipse.gmf.runtime.notation.Node label5007 = createLabel(node, de.uka.ipd.sdq.pcm.gmf.allocation.part.PalladioComponentModelVisualIDRegistry.getType(de.uka.ipd.sdq.pcm.gmf.allocation.edit.parts.AllocationComponentLabelEditPart.VISUAL_ID));
										return node;
	}




	/**
 * @generated
 */
	private void stampShortcut(org.eclipse.gmf.runtime.notation.View containerView, org.eclipse.gmf.runtime.notation.Node target) {
		if (!de.uka.ipd.sdq.pcm.gmf.allocation.edit.parts.AllocationEditPart.MODEL_ID.equals(de.uka.ipd.sdq.pcm.gmf.allocation.part.PalladioComponentModelVisualIDRegistry.getModelID(containerView))) {
				org.eclipse.emf.ecore.EAnnotation shortcutAnnotation = org.eclipse.emf.ecore.EcoreFactory.eINSTANCE.createEAnnotation();
	shortcutAnnotation.setSource("Shortcut"); //$NON-NLS-1$
	shortcutAnnotation.getDetails().put("modelID", de.uka.ipd.sdq.pcm.gmf.allocation.edit.parts.AllocationEditPart.MODEL_ID); //$NON-NLS-1$
	target.getEAnnotations().add(shortcutAnnotation);
		}
	}


	/**
 * @generated
 */
	private org.eclipse.gmf.runtime.notation.Node createLabel(org.eclipse.gmf.runtime.notation.View owner, String hint) {
		org.eclipse.gmf.runtime.notation.DecorationNode rv = org.eclipse.gmf.runtime.notation.NotationFactory.eINSTANCE.createDecorationNode();
		rv.setType(hint);
		org.eclipse.gmf.runtime.diagram.core.util.ViewUtil.insertChildView(owner, rv, org.eclipse.gmf.runtime.diagram.core.util.ViewUtil.APPEND, true);
		return rv;
	}


	/**
 * @generated
 */
	private org.eclipse.gmf.runtime.notation.Node createCompartment(org.eclipse.gmf.runtime.notation.View owner, String hint, boolean canCollapse, boolean hasTitle, boolean canSort, boolean canFilter) {
		//SemanticListCompartment rv = NotationFactory.eINSTANCE.createSemanticListCompartment();
		//rv.setShowTitle(showTitle);
		//rv.setCollapsed(isCollapsed);
		org.eclipse.gmf.runtime.notation.Node rv;
		if (canCollapse) {
			rv = org.eclipse.gmf.runtime.notation.NotationFactory.eINSTANCE.createBasicCompartment();
		} else {
			rv = org.eclipse.gmf.runtime.notation.NotationFactory.eINSTANCE.createDecorationNode();
		}
		if (hasTitle) {
			org.eclipse.gmf.runtime.notation.TitleStyle ts = org.eclipse.gmf.runtime.notation.NotationFactory.eINSTANCE.createTitleStyle();
			ts.setShowTitle(true);
			rv.getStyles().add(ts);
		}
		if (canSort) {
			rv.getStyles().add(org.eclipse.gmf.runtime.notation.NotationFactory.eINSTANCE.createSortingStyle());
		}
		if (canFilter) {
			rv.getStyles().add(org.eclipse.gmf.runtime.notation.NotationFactory.eINSTANCE.createFilteringStyle());
		}
		rv.setType(hint);
		org.eclipse.gmf.runtime.diagram.core.util.ViewUtil.insertChildView(owner, rv, org.eclipse.gmf.runtime.diagram.core.util.ViewUtil.APPEND, true);
		return rv;
	}
	
	/**
 * @generated
 */
	private org.eclipse.emf.ecore.EObject getSemanticElement(org.eclipse.core.runtime.IAdaptable semanticAdapter) {
		if (semanticAdapter == null) {
			return null;
		}
		org.eclipse.emf.ecore.EObject eObject = (org.eclipse.emf.ecore.EObject) semanticAdapter.getAdapter(org.eclipse.emf.ecore.EObject.class);
		if (eObject != null) {
			return org.eclipse.gmf.runtime.emf.core.util.EMFCoreUtil.resolve(org.eclipse.emf.transaction.util.TransactionUtil.getEditingDomain(eObject), eObject);
		}
		return null;
	}

	
/**
 * @generated
 */
private org.eclipse.gmf.runtime.emf.type.core.IElementType getSemanticElementType(org.eclipse.core.runtime.IAdaptable semanticAdapter) {
	if (semanticAdapter == null) {
		return null;
	}
	return (org.eclipse.gmf.runtime.emf.type.core.IElementType) semanticAdapter.getAdapter(org.eclipse.gmf.runtime.emf.type.core.IElementType.class);
}
	}
