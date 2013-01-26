/*
 *Copyright 2007, SDQ, IPD, Uni Karlsruhe (TH)
 */
package de.uka.ipd.sdq.pcm.gmf.composite.providers;

import java.util.ArrayList;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gmf.runtime.common.core.service.AbstractProvider;
import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint;
import org.eclipse.gmf.runtime.diagram.core.providers.IViewProvider;
import org.eclipse.gmf.runtime.diagram.core.services.view.CreateDiagramViewOperation;
import org.eclipse.gmf.runtime.diagram.core.services.view.CreateEdgeViewOperation;
import org.eclipse.gmf.runtime.diagram.core.services.view.CreateNodeViewOperation;
import org.eclipse.gmf.runtime.diagram.core.services.view.CreateViewForKindOperation;
import org.eclipse.gmf.runtime.diagram.core.services.view.CreateViewOperation;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.diagram.ui.preferences.IPreferenceConstants;
import org.eclipse.gmf.runtime.draw2d.ui.figures.FigureUtilities;
import org.eclipse.gmf.runtime.emf.core.util.EMFCoreUtil;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.IHintedType;
import org.eclipse.gmf.runtime.notation.Connector;
import org.eclipse.gmf.runtime.notation.DecorationNode;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.FontStyle;
import org.eclipse.gmf.runtime.notation.Location;
import org.eclipse.gmf.runtime.notation.MeasurementUnit;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.NotationFactory;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.RelativeBendpoints;
import org.eclipse.gmf.runtime.notation.Routing;
import org.eclipse.gmf.runtime.notation.Shape;
import org.eclipse.gmf.runtime.notation.TitleStyle;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.runtime.notation.datatype.RelativeBendpoint;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.preference.PreferenceConverter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.FontData;

import de.uka.ipd.sdq.pcm.gmf.composite.edit.parts.AssemblyConnectorEditPart;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.parts.AssemblyContextEditPart;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.parts.AssemblyContextEntityNameEditPart;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.parts.AssemblyEventConnectorEditPart;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.parts.AssemblyInfrastructureConnectorEditPart;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.parts.ComposedProvidingRequiringEntity2EditPart;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.parts.ComposedProvidingRequiringEntityCompositeStructureInnerCompartmentEditPart;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.parts.ComposedProvidingRequiringEntityEditPart;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.parts.ComposedProvidingRequiringEntityEntityNameEditPart;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.parts.EventChannelEditPart;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.parts.EventChannelEntityNameEditPart;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.parts.EventChannelSinkConnectorEditPart;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.parts.EventChannelSourceConnectorEditPart;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.parts.InfrastructureProvidedRoleEditPart;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.parts.InfrastructureProvidedRoleEntityNameEditPart;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.parts.InfrastructureRequiredRoleEditPart;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.parts.InfrastructureRequiredRoleEntityNameEditPart;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.parts.OperationProvidedRole2EditPart;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.parts.OperationProvidedRoleEditPart;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.parts.OperationProvidedRoleEntityName2EditPart;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.parts.OperationProvidedRoleEntityNameEditPart;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.parts.OperationRequiredRole2EditPart;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.parts.OperationRequiredRoleEditPart;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.parts.OperationRequiredRoleEntityName2EditPart;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.parts.OperationRequiredRoleEntityNameEditPart;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.parts.ProvidedDelegationConnectorEditPart;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.parts.RequiredDelegationConnectorEditPart;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.parts.SinkRoleEditPart;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.parts.SinkRoleEntityNameEditPart;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.parts.SourceRoleEditPart;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.parts.SourceRoleEntityNameEditPart;
import de.uka.ipd.sdq.pcm.gmf.composite.part.PalladioComponentModelVisualIDRegistry;

/**
 * The Class PalladioComponentModelViewProvider.
 * 
 * @generated
 */
public class PalladioComponentModelViewProvider extends AbstractProvider implements IViewProvider {

    /**
     * Provides.
     * 
     * @param operation
     *            the operation
     * @return true, if successful
     * @generated
     */
    public final boolean provides(IOperation operation) {
        if (operation instanceof CreateViewForKindOperation) {
            return provides((CreateViewForKindOperation) operation);
        }
        assert operation instanceof CreateViewOperation;
        if (operation instanceof CreateDiagramViewOperation) {
            return provides((CreateDiagramViewOperation) operation);
        } else if (operation instanceof CreateEdgeViewOperation) {
            return provides((CreateEdgeViewOperation) operation);
        } else if (operation instanceof CreateNodeViewOperation) {
            return provides((CreateNodeViewOperation) operation);
        }
        return false;
    }

    /**
     * Provides.
     * 
     * @param op
     *            the op
     * @return true, if successful
     * @generated
     */
    protected boolean provides(CreateViewForKindOperation op) {
        /*
         * if (op.getViewKind() == Node.class) return getNodeViewClass(op.getSemanticAdapter(),
         * op.getContainerView(), op.getSemanticHint()) != null; if (op.getViewKind() == Edge.class)
         * return getEdgeViewClass(op.getSemanticAdapter(), op.getContainerView(),
         * op.getSemanticHint()) != null;
         */
        return true;
    }

    /**
     * Provides.
     * 
     * @param op
     *            the op
     * @return true, if successful
     * @generated
     */
    protected boolean provides(CreateDiagramViewOperation op) {
        return ComposedProvidingRequiringEntityEditPart.MODEL_ID.equals(op.getSemanticHint())
                && PalladioComponentModelVisualIDRegistry
                        .getDiagramVisualID(getSemanticElement(op.getSemanticAdapter())) != -1;
    }

    /**
     * Provides.
     * 
     * @param op
     *            the op
     * @return true, if successful
     * @generated
     */
    protected boolean provides(CreateNodeViewOperation op) {
        if (op.getContainerView() == null) {
            return false;
        }
        IElementType elementType = getSemanticElementType(op.getSemanticAdapter());
        EObject domainElement = getSemanticElement(op.getSemanticAdapter());
        int visualID;
        if (op.getSemanticHint() == null) {
            // Semantic hint is not specified. Can be a result of call from CanonicalEditPolicy.
            // In this situation there should be NO elementType, visualID will be determined
            // by VisualIDRegistry.getNodeVisualID() for domainElement.
            if (elementType != null || domainElement == null) {
                return false;
            }
            visualID = PalladioComponentModelVisualIDRegistry.getNodeVisualID(op.getContainerView(), domainElement);
        } else {
            visualID = PalladioComponentModelVisualIDRegistry.getVisualID(op.getSemanticHint());
            if (elementType != null) {
                if (!PalladioComponentModelElementTypes.isKnownElementType(elementType)
                        || (!(elementType instanceof IHintedType))) {
                    return false; // foreign element type
                }
                String elementTypeHint = ((IHintedType) elementType).getSemanticHint();
                if (!op.getSemanticHint().equals(elementTypeHint)) {
                    return false; // if semantic hint is specified it should be the same as in
                                  // element type
                }
                if (domainElement != null
                        && visualID != PalladioComponentModelVisualIDRegistry.getNodeVisualID(op.getContainerView(),
                                domainElement)) {
                    return false; // visual id for node EClass should match visual id from element
                                  // type
                }
            } else {
                if (!ComposedProvidingRequiringEntityEditPart.MODEL_ID.equals(PalladioComponentModelVisualIDRegistry
                        .getModelID(op.getContainerView()))) {
                    return false; // foreign diagram
                }
                switch (visualID) {
                case AssemblyContextEditPart.VISUAL_ID:
                case OperationProvidedRoleEditPart.VISUAL_ID:
                case OperationRequiredRoleEditPart.VISUAL_ID:
                case SourceRoleEditPart.VISUAL_ID:
                case SinkRoleEditPart.VISUAL_ID:
                case InfrastructureProvidedRoleEditPart.VISUAL_ID:
                case InfrastructureRequiredRoleEditPart.VISUAL_ID:
                case EventChannelEditPart.VISUAL_ID:
                case ComposedProvidingRequiringEntity2EditPart.VISUAL_ID:
                case OperationProvidedRole2EditPart.VISUAL_ID:
                case OperationRequiredRole2EditPart.VISUAL_ID:
                    if (domainElement == null
                            || visualID != PalladioComponentModelVisualIDRegistry.getNodeVisualID(
                                    op.getContainerView(), domainElement)) {
                        return false; // visual id in semantic hint should match visual id for
                                      // domain element
                    }
                    break;
                default:
                    return false;
                }
            }
        }
        return ComposedProvidingRequiringEntity2EditPart.VISUAL_ID == visualID
                || AssemblyContextEditPart.VISUAL_ID == visualID || OperationProvidedRoleEditPart.VISUAL_ID == visualID
                || OperationRequiredRoleEditPart.VISUAL_ID == visualID || SourceRoleEditPart.VISUAL_ID == visualID
                || SinkRoleEditPart.VISUAL_ID == visualID || InfrastructureProvidedRoleEditPart.VISUAL_ID == visualID
                || InfrastructureRequiredRoleEditPart.VISUAL_ID == visualID
                || OperationProvidedRole2EditPart.VISUAL_ID == visualID
                || OperationRequiredRole2EditPart.VISUAL_ID == visualID || EventChannelEditPart.VISUAL_ID == visualID;
    }

    /**
     * Provides.
     * 
     * @param op
     *            the op
     * @return true, if successful
     * @generated
     */
    protected boolean provides(CreateEdgeViewOperation op) {
        IElementType elementType = getSemanticElementType(op.getSemanticAdapter());
        if (!PalladioComponentModelElementTypes.isKnownElementType(elementType)
                || (!(elementType instanceof IHintedType))) {
            return false; // foreign element type
        }
        String elementTypeHint = ((IHintedType) elementType).getSemanticHint();
        if (elementTypeHint == null || (op.getSemanticHint() != null && !elementTypeHint.equals(op.getSemanticHint()))) {
            return false; // our hint is visual id and must be specified, and it should be the same
                          // as in element type
        }
        int visualID = PalladioComponentModelVisualIDRegistry.getVisualID(elementTypeHint);
        EObject domainElement = getSemanticElement(op.getSemanticAdapter());
        if (domainElement != null
                && visualID != PalladioComponentModelVisualIDRegistry.getLinkWithClassVisualID(domainElement)) {
            return false; // visual id for link EClass should match visual id from element type
        }
        return true;
    }

    /**
     * Creates the diagram.
     * 
     * @param semanticAdapter
     *            the semantic adapter
     * @param diagramKind
     *            the diagram kind
     * @param preferencesHint
     *            the preferences hint
     * @return the diagram
     * @generated
     */
    public Diagram createDiagram(IAdaptable semanticAdapter, String diagramKind, PreferencesHint preferencesHint) {
        Diagram diagram = NotationFactory.eINSTANCE.createDiagram();
        diagram.getStyles().add(NotationFactory.eINSTANCE.createDiagramStyle());
        diagram.setType(ComposedProvidingRequiringEntityEditPart.MODEL_ID);
        diagram.setElement(getSemanticElement(semanticAdapter));
        diagram.setMeasurementUnit(MeasurementUnit.PIXEL_LITERAL);
        return diagram;
    }

    /**
     * Creates the node.
     * 
     * @param semanticAdapter
     *            the semantic adapter
     * @param containerView
     *            the container view
     * @param semanticHint
     *            the semantic hint
     * @param index
     *            the index
     * @param persisted
     *            the persisted
     * @param preferencesHint
     *            the preferences hint
     * @return the node
     * @generated
     */
    public Node createNode(IAdaptable semanticAdapter, View containerView, String semanticHint, int index,
            boolean persisted, PreferencesHint preferencesHint) {
        final EObject domainElement = getSemanticElement(semanticAdapter);
        final int visualID;
        if (semanticHint == null) {
            visualID = PalladioComponentModelVisualIDRegistry.getNodeVisualID(containerView, domainElement);
        } else {
            visualID = PalladioComponentModelVisualIDRegistry.getVisualID(semanticHint);
        }
        switch (visualID) {
        case ComposedProvidingRequiringEntity2EditPart.VISUAL_ID:
            return createComposedProvidingRequiringEntity_2002(domainElement, containerView, index, persisted,
                    preferencesHint);
        case AssemblyContextEditPart.VISUAL_ID:
            return createAssemblyContext_3006(domainElement, containerView, index, persisted, preferencesHint);
        case OperationProvidedRoleEditPart.VISUAL_ID:
            return createOperationProvidedRole_3007(domainElement, containerView, index, persisted, preferencesHint);
        case OperationRequiredRoleEditPart.VISUAL_ID:
            return createOperationRequiredRole_3008(domainElement, containerView, index, persisted, preferencesHint);
        case SourceRoleEditPart.VISUAL_ID:
            return createSourceRole_3013(domainElement, containerView, index, persisted, preferencesHint);
        case SinkRoleEditPart.VISUAL_ID:
            return createSinkRole_3014(domainElement, containerView, index, persisted, preferencesHint);
        case InfrastructureProvidedRoleEditPart.VISUAL_ID:
            return createInfrastructureProvidedRole_3015(domainElement, containerView, index, persisted,
                    preferencesHint);
        case InfrastructureRequiredRoleEditPart.VISUAL_ID:
            return createInfrastructureRequiredRole_3016(domainElement, containerView, index, persisted,
                    preferencesHint);
        case OperationProvidedRole2EditPart.VISUAL_ID:
            return createOperationProvidedRole_3011(domainElement, containerView, index, persisted, preferencesHint);
        case OperationRequiredRole2EditPart.VISUAL_ID:
            return createOperationRequiredRole_3012(domainElement, containerView, index, persisted, preferencesHint);
        case EventChannelEditPart.VISUAL_ID:
            return createEventChannel_3017(domainElement, containerView, index, persisted, preferencesHint);
        }
        // can't happen, provided #provides(CreateNodeViewOperation) is correct
        return null;
    }

    /**
     * Creates the edge.
     * 
     * @param semanticAdapter
     *            the semantic adapter
     * @param containerView
     *            the container view
     * @param semanticHint
     *            the semantic hint
     * @param index
     *            the index
     * @param persisted
     *            the persisted
     * @param preferencesHint
     *            the preferences hint
     * @return the edge
     * @generated
     */
    public Edge createEdge(IAdaptable semanticAdapter, View containerView, String semanticHint, int index,
            boolean persisted, PreferencesHint preferencesHint) {
        IElementType elementType = getSemanticElementType(semanticAdapter);
        String elementTypeHint = ((IHintedType) elementType).getSemanticHint();
        switch (PalladioComponentModelVisualIDRegistry.getVisualID(elementTypeHint)) {
        case EventChannelSinkConnectorEditPart.VISUAL_ID:
            return createEventChannelSinkConnector_4010(getSemanticElement(semanticAdapter), containerView, index,
                    persisted, preferencesHint);
        case EventChannelSourceConnectorEditPart.VISUAL_ID:
            return createEventChannelSourceConnector_4009(getSemanticElement(semanticAdapter), containerView, index,
                    persisted, preferencesHint);
        case AssemblyConnectorEditPart.VISUAL_ID:
            return createAssemblyConnector_4004(getSemanticElement(semanticAdapter), containerView, index, persisted,
                    preferencesHint);
        case AssemblyEventConnectorEditPart.VISUAL_ID:
            return createAssemblyEventConnector_4007(getSemanticElement(semanticAdapter), containerView, index,
                    persisted, preferencesHint);
        case RequiredDelegationConnectorEditPart.VISUAL_ID:
            return createRequiredDelegationConnector_4005(getSemanticElement(semanticAdapter), containerView, index,
                    persisted, preferencesHint);
        case ProvidedDelegationConnectorEditPart.VISUAL_ID:
            return createProvidedDelegationConnector_4006(getSemanticElement(semanticAdapter), containerView, index,
                    persisted, preferencesHint);
        case AssemblyInfrastructureConnectorEditPart.VISUAL_ID:
            return createAssemblyInfrastructureConnector_4008(getSemanticElement(semanticAdapter), containerView,
                    index, persisted, preferencesHint);
        }
        // can never happen, provided #provides(CreateEdgeViewOperation) is correct
        return null;
    }

    /**
     * Creates the composed providing requiring entity_2002.
     * 
     * @param domainElement
     *            the domain element
     * @param containerView
     *            the container view
     * @param index
     *            the index
     * @param persisted
     *            the persisted
     * @param preferencesHint
     *            the preferences hint
     * @return the node
     * @generated
     */
    public Node createComposedProvidingRequiringEntity_2002(EObject domainElement, View containerView, int index,
            boolean persisted, PreferencesHint preferencesHint) {
        Shape node = NotationFactory.eINSTANCE.createShape();
        node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
        node.setType(PalladioComponentModelVisualIDRegistry
                .getType(ComposedProvidingRequiringEntity2EditPart.VISUAL_ID));
        ViewUtil.insertChildView(containerView, node, index, persisted);
        node.setElement(domainElement);
        stampShortcut(containerView, node);
        // initializeFromPreferences
        final IPreferenceStore prefStore = (IPreferenceStore) preferencesHint.getPreferenceStore();

        org.eclipse.swt.graphics.RGB lineRGB = PreferenceConverter.getColor(prefStore,
                IPreferenceConstants.PREF_LINE_COLOR);
        ViewUtil.setStructuralFeatureValue(node, NotationPackage.eINSTANCE.getLineStyle_LineColor(),
                FigureUtilities.RGBToInteger(lineRGB));
        FontStyle nodeFontStyle = (FontStyle) node.getStyle(NotationPackage.Literals.FONT_STYLE);
        if (nodeFontStyle != null) {
            FontData fontData = PreferenceConverter.getFontData(prefStore, IPreferenceConstants.PREF_DEFAULT_FONT);
            nodeFontStyle.setFontName(fontData.getName());
            nodeFontStyle.setFontHeight(fontData.getHeight());
            nodeFontStyle.setBold((fontData.getStyle() & SWT.BOLD) != 0);
            nodeFontStyle.setItalic((fontData.getStyle() & SWT.ITALIC) != 0);
            org.eclipse.swt.graphics.RGB fontRGB = PreferenceConverter.getColor(prefStore,
                    IPreferenceConstants.PREF_FONT_COLOR);
            nodeFontStyle.setFontColor(FigureUtilities.RGBToInteger(fontRGB).intValue());
        }
        org.eclipse.swt.graphics.RGB fillRGB = PreferenceConverter.getColor(prefStore,
                IPreferenceConstants.PREF_FILL_COLOR);
        ViewUtil.setStructuralFeatureValue(node, NotationPackage.eINSTANCE.getFillStyle_FillColor(),
                FigureUtilities.RGBToInteger(fillRGB));
        Node label5012 = createLabel(node,
                PalladioComponentModelVisualIDRegistry
                        .getType(ComposedProvidingRequiringEntityEntityNameEditPart.VISUAL_ID));
        createCompartment(node,
                PalladioComponentModelVisualIDRegistry
                        .getType(ComposedProvidingRequiringEntityCompositeStructureInnerCompartmentEditPart.VISUAL_ID),
                false, false, false, false);
        return node;
    }

    /**
     * Creates the assembly context_3006.
     * 
     * @param domainElement
     *            the domain element
     * @param containerView
     *            the container view
     * @param index
     *            the index
     * @param persisted
     *            the persisted
     * @param preferencesHint
     *            the preferences hint
     * @return the node
     * @generated
     */
    public Node createAssemblyContext_3006(EObject domainElement, View containerView, int index, boolean persisted,
            PreferencesHint preferencesHint) {
        Shape node = NotationFactory.eINSTANCE.createShape();
        node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
        node.setType(PalladioComponentModelVisualIDRegistry.getType(AssemblyContextEditPart.VISUAL_ID));
        ViewUtil.insertChildView(containerView, node, index, persisted);
        node.setElement(domainElement);
        // initializeFromPreferences
        final IPreferenceStore prefStore = (IPreferenceStore) preferencesHint.getPreferenceStore();

        org.eclipse.swt.graphics.RGB lineRGB = PreferenceConverter.getColor(prefStore,
                IPreferenceConstants.PREF_LINE_COLOR);
        ViewUtil.setStructuralFeatureValue(node, NotationPackage.eINSTANCE.getLineStyle_LineColor(),
                FigureUtilities.RGBToInteger(lineRGB));
        FontStyle nodeFontStyle = (FontStyle) node.getStyle(NotationPackage.Literals.FONT_STYLE);
        if (nodeFontStyle != null) {
            FontData fontData = PreferenceConverter.getFontData(prefStore, IPreferenceConstants.PREF_DEFAULT_FONT);
            nodeFontStyle.setFontName(fontData.getName());
            nodeFontStyle.setFontHeight(fontData.getHeight());
            nodeFontStyle.setBold((fontData.getStyle() & SWT.BOLD) != 0);
            nodeFontStyle.setItalic((fontData.getStyle() & SWT.ITALIC) != 0);
            org.eclipse.swt.graphics.RGB fontRGB = PreferenceConverter.getColor(prefStore,
                    IPreferenceConstants.PREF_FONT_COLOR);
            nodeFontStyle.setFontColor(FigureUtilities.RGBToInteger(fontRGB).intValue());
        }
        org.eclipse.swt.graphics.RGB fillRGB = PreferenceConverter.getColor(prefStore,
                IPreferenceConstants.PREF_FILL_COLOR);
        ViewUtil.setStructuralFeatureValue(node, NotationPackage.eINSTANCE.getFillStyle_FillColor(),
                FigureUtilities.RGBToInteger(fillRGB));
        Node label5009 = createLabel(node,
                PalladioComponentModelVisualIDRegistry.getType(AssemblyContextEntityNameEditPart.VISUAL_ID));
        return node;
    }

    /**
     * Creates the operation provided role_3007.
     * 
     * @param domainElement
     *            the domain element
     * @param containerView
     *            the container view
     * @param index
     *            the index
     * @param persisted
     *            the persisted
     * @param preferencesHint
     *            the preferences hint
     * @return the node
     * @generated
     */
    public Node createOperationProvidedRole_3007(EObject domainElement, View containerView, int index,
            boolean persisted, PreferencesHint preferencesHint) {
        Shape node = NotationFactory.eINSTANCE.createShape();
        node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
        node.setType(PalladioComponentModelVisualIDRegistry.getType(OperationProvidedRoleEditPart.VISUAL_ID));
        ViewUtil.insertChildView(containerView, node, index, persisted);
        node.setElement(domainElement);
        // initializeFromPreferences
        final IPreferenceStore prefStore = (IPreferenceStore) preferencesHint.getPreferenceStore();

        org.eclipse.swt.graphics.RGB lineRGB = PreferenceConverter.getColor(prefStore,
                IPreferenceConstants.PREF_LINE_COLOR);
        ViewUtil.setStructuralFeatureValue(node, NotationPackage.eINSTANCE.getLineStyle_LineColor(),
                FigureUtilities.RGBToInteger(lineRGB));
        FontStyle nodeFontStyle = (FontStyle) node.getStyle(NotationPackage.Literals.FONT_STYLE);
        if (nodeFontStyle != null) {
            FontData fontData = PreferenceConverter.getFontData(prefStore, IPreferenceConstants.PREF_DEFAULT_FONT);
            nodeFontStyle.setFontName(fontData.getName());
            nodeFontStyle.setFontHeight(fontData.getHeight());
            nodeFontStyle.setBold((fontData.getStyle() & SWT.BOLD) != 0);
            nodeFontStyle.setItalic((fontData.getStyle() & SWT.ITALIC) != 0);
            org.eclipse.swt.graphics.RGB fontRGB = PreferenceConverter.getColor(prefStore,
                    IPreferenceConstants.PREF_FONT_COLOR);
            nodeFontStyle.setFontColor(FigureUtilities.RGBToInteger(fontRGB).intValue());
        }
        org.eclipse.swt.graphics.RGB fillRGB = PreferenceConverter.getColor(prefStore,
                IPreferenceConstants.PREF_FILL_COLOR);
        ViewUtil.setStructuralFeatureValue(node, NotationPackage.eINSTANCE.getFillStyle_FillColor(),
                FigureUtilities.RGBToInteger(fillRGB));
        Node label5007 = createLabel(node,
                PalladioComponentModelVisualIDRegistry.getType(OperationProvidedRoleEntityNameEditPart.VISUAL_ID));
        label5007.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
        Location location5007 = (Location) label5007.getLayoutConstraint();
        location5007.setX(0);
        location5007.setY(5);
        return node;
    }

    /**
     * Creates the operation required role_3008.
     * 
     * @param domainElement
     *            the domain element
     * @param containerView
     *            the container view
     * @param index
     *            the index
     * @param persisted
     *            the persisted
     * @param preferencesHint
     *            the preferences hint
     * @return the node
     * @generated
     */
    public Node createOperationRequiredRole_3008(EObject domainElement, View containerView, int index,
            boolean persisted, PreferencesHint preferencesHint) {
        Shape node = NotationFactory.eINSTANCE.createShape();
        node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
        node.setType(PalladioComponentModelVisualIDRegistry.getType(OperationRequiredRoleEditPart.VISUAL_ID));
        ViewUtil.insertChildView(containerView, node, index, persisted);
        node.setElement(domainElement);
        // initializeFromPreferences
        final IPreferenceStore prefStore = (IPreferenceStore) preferencesHint.getPreferenceStore();

        org.eclipse.swt.graphics.RGB lineRGB = PreferenceConverter.getColor(prefStore,
                IPreferenceConstants.PREF_LINE_COLOR);
        ViewUtil.setStructuralFeatureValue(node, NotationPackage.eINSTANCE.getLineStyle_LineColor(),
                FigureUtilities.RGBToInteger(lineRGB));
        FontStyle nodeFontStyle = (FontStyle) node.getStyle(NotationPackage.Literals.FONT_STYLE);
        if (nodeFontStyle != null) {
            FontData fontData = PreferenceConverter.getFontData(prefStore, IPreferenceConstants.PREF_DEFAULT_FONT);
            nodeFontStyle.setFontName(fontData.getName());
            nodeFontStyle.setFontHeight(fontData.getHeight());
            nodeFontStyle.setBold((fontData.getStyle() & SWT.BOLD) != 0);
            nodeFontStyle.setItalic((fontData.getStyle() & SWT.ITALIC) != 0);
            org.eclipse.swt.graphics.RGB fontRGB = PreferenceConverter.getColor(prefStore,
                    IPreferenceConstants.PREF_FONT_COLOR);
            nodeFontStyle.setFontColor(FigureUtilities.RGBToInteger(fontRGB).intValue());
        }
        org.eclipse.swt.graphics.RGB fillRGB = PreferenceConverter.getColor(prefStore,
                IPreferenceConstants.PREF_FILL_COLOR);
        ViewUtil.setStructuralFeatureValue(node, NotationPackage.eINSTANCE.getFillStyle_FillColor(),
                FigureUtilities.RGBToInteger(fillRGB));
        Node label5008 = createLabel(node,
                PalladioComponentModelVisualIDRegistry.getType(OperationRequiredRoleEntityNameEditPart.VISUAL_ID));
        label5008.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
        Location location5008 = (Location) label5008.getLayoutConstraint();
        location5008.setX(0);
        location5008.setY(5);
        return node;
    }

    /**
     * Creates the source role_3013.
     * 
     * @param domainElement
     *            the domain element
     * @param containerView
     *            the container view
     * @param index
     *            the index
     * @param persisted
     *            the persisted
     * @param preferencesHint
     *            the preferences hint
     * @return the node
     * @generated
     */
    public Node createSourceRole_3013(EObject domainElement, View containerView, int index, boolean persisted,
            PreferencesHint preferencesHint) {
        Shape node = NotationFactory.eINSTANCE.createShape();
        node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
        node.setType(PalladioComponentModelVisualIDRegistry.getType(SourceRoleEditPart.VISUAL_ID));
        ViewUtil.insertChildView(containerView, node, index, persisted);
        node.setElement(domainElement);
        // initializeFromPreferences
        final IPreferenceStore prefStore = (IPreferenceStore) preferencesHint.getPreferenceStore();

        org.eclipse.swt.graphics.RGB lineRGB = PreferenceConverter.getColor(prefStore,
                IPreferenceConstants.PREF_LINE_COLOR);
        ViewUtil.setStructuralFeatureValue(node, NotationPackage.eINSTANCE.getLineStyle_LineColor(),
                FigureUtilities.RGBToInteger(lineRGB));
        FontStyle nodeFontStyle = (FontStyle) node.getStyle(NotationPackage.Literals.FONT_STYLE);
        if (nodeFontStyle != null) {
            FontData fontData = PreferenceConverter.getFontData(prefStore, IPreferenceConstants.PREF_DEFAULT_FONT);
            nodeFontStyle.setFontName(fontData.getName());
            nodeFontStyle.setFontHeight(fontData.getHeight());
            nodeFontStyle.setBold((fontData.getStyle() & SWT.BOLD) != 0);
            nodeFontStyle.setItalic((fontData.getStyle() & SWT.ITALIC) != 0);
            org.eclipse.swt.graphics.RGB fontRGB = PreferenceConverter.getColor(prefStore,
                    IPreferenceConstants.PREF_FONT_COLOR);
            nodeFontStyle.setFontColor(FigureUtilities.RGBToInteger(fontRGB).intValue());
        }
        org.eclipse.swt.graphics.RGB fillRGB = PreferenceConverter.getColor(prefStore,
                IPreferenceConstants.PREF_FILL_COLOR);
        ViewUtil.setStructuralFeatureValue(node, NotationPackage.eINSTANCE.getFillStyle_FillColor(),
                FigureUtilities.RGBToInteger(fillRGB));
        Node label5015 = createLabel(node,
                PalladioComponentModelVisualIDRegistry.getType(SourceRoleEntityNameEditPart.VISUAL_ID));
        label5015.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
        Location location5015 = (Location) label5015.getLayoutConstraint();
        location5015.setX(0);
        location5015.setY(5);
        return node;
    }

    /**
     * Creates the sink role_3014.
     * 
     * @param domainElement
     *            the domain element
     * @param containerView
     *            the container view
     * @param index
     *            the index
     * @param persisted
     *            the persisted
     * @param preferencesHint
     *            the preferences hint
     * @return the node
     * @generated
     */
    public Node createSinkRole_3014(EObject domainElement, View containerView, int index, boolean persisted,
            PreferencesHint preferencesHint) {
        Shape node = NotationFactory.eINSTANCE.createShape();
        node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
        node.setType(PalladioComponentModelVisualIDRegistry.getType(SinkRoleEditPart.VISUAL_ID));
        ViewUtil.insertChildView(containerView, node, index, persisted);
        node.setElement(domainElement);
        // initializeFromPreferences
        final IPreferenceStore prefStore = (IPreferenceStore) preferencesHint.getPreferenceStore();

        org.eclipse.swt.graphics.RGB lineRGB = PreferenceConverter.getColor(prefStore,
                IPreferenceConstants.PREF_LINE_COLOR);
        ViewUtil.setStructuralFeatureValue(node, NotationPackage.eINSTANCE.getLineStyle_LineColor(),
                FigureUtilities.RGBToInteger(lineRGB));
        FontStyle nodeFontStyle = (FontStyle) node.getStyle(NotationPackage.Literals.FONT_STYLE);
        if (nodeFontStyle != null) {
            FontData fontData = PreferenceConverter.getFontData(prefStore, IPreferenceConstants.PREF_DEFAULT_FONT);
            nodeFontStyle.setFontName(fontData.getName());
            nodeFontStyle.setFontHeight(fontData.getHeight());
            nodeFontStyle.setBold((fontData.getStyle() & SWT.BOLD) != 0);
            nodeFontStyle.setItalic((fontData.getStyle() & SWT.ITALIC) != 0);
            org.eclipse.swt.graphics.RGB fontRGB = PreferenceConverter.getColor(prefStore,
                    IPreferenceConstants.PREF_FONT_COLOR);
            nodeFontStyle.setFontColor(FigureUtilities.RGBToInteger(fontRGB).intValue());
        }
        org.eclipse.swt.graphics.RGB fillRGB = PreferenceConverter.getColor(prefStore,
                IPreferenceConstants.PREF_FILL_COLOR);
        ViewUtil.setStructuralFeatureValue(node, NotationPackage.eINSTANCE.getFillStyle_FillColor(),
                FigureUtilities.RGBToInteger(fillRGB));
        Node label5016 = createLabel(node,
                PalladioComponentModelVisualIDRegistry.getType(SinkRoleEntityNameEditPart.VISUAL_ID));
        label5016.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
        Location location5016 = (Location) label5016.getLayoutConstraint();
        location5016.setX(0);
        location5016.setY(5);
        return node;
    }

    /**
     * Creates the infrastructure provided role_3015.
     * 
     * @param domainElement
     *            the domain element
     * @param containerView
     *            the container view
     * @param index
     *            the index
     * @param persisted
     *            the persisted
     * @param preferencesHint
     *            the preferences hint
     * @return the node
     * @generated
     */
    public Node createInfrastructureProvidedRole_3015(EObject domainElement, View containerView, int index,
            boolean persisted, PreferencesHint preferencesHint) {
        Shape node = NotationFactory.eINSTANCE.createShape();
        node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
        node.setType(PalladioComponentModelVisualIDRegistry.getType(InfrastructureProvidedRoleEditPart.VISUAL_ID));
        ViewUtil.insertChildView(containerView, node, index, persisted);
        node.setElement(domainElement);
        // initializeFromPreferences
        final IPreferenceStore prefStore = (IPreferenceStore) preferencesHint.getPreferenceStore();

        org.eclipse.swt.graphics.RGB lineRGB = PreferenceConverter.getColor(prefStore,
                IPreferenceConstants.PREF_LINE_COLOR);
        ViewUtil.setStructuralFeatureValue(node, NotationPackage.eINSTANCE.getLineStyle_LineColor(),
                FigureUtilities.RGBToInteger(lineRGB));
        FontStyle nodeFontStyle = (FontStyle) node.getStyle(NotationPackage.Literals.FONT_STYLE);
        if (nodeFontStyle != null) {
            FontData fontData = PreferenceConverter.getFontData(prefStore, IPreferenceConstants.PREF_DEFAULT_FONT);
            nodeFontStyle.setFontName(fontData.getName());
            nodeFontStyle.setFontHeight(fontData.getHeight());
            nodeFontStyle.setBold((fontData.getStyle() & SWT.BOLD) != 0);
            nodeFontStyle.setItalic((fontData.getStyle() & SWT.ITALIC) != 0);
            org.eclipse.swt.graphics.RGB fontRGB = PreferenceConverter.getColor(prefStore,
                    IPreferenceConstants.PREF_FONT_COLOR);
            nodeFontStyle.setFontColor(FigureUtilities.RGBToInteger(fontRGB).intValue());
        }
        org.eclipse.swt.graphics.RGB fillRGB = PreferenceConverter.getColor(prefStore,
                IPreferenceConstants.PREF_FILL_COLOR);
        ViewUtil.setStructuralFeatureValue(node, NotationPackage.eINSTANCE.getFillStyle_FillColor(),
                FigureUtilities.RGBToInteger(fillRGB));
        Node label5017 = createLabel(node,
                PalladioComponentModelVisualIDRegistry.getType(InfrastructureProvidedRoleEntityNameEditPart.VISUAL_ID));
        label5017.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
        Location location5017 = (Location) label5017.getLayoutConstraint();
        location5017.setX(0);
        location5017.setY(5);
        return node;
    }

    /**
     * Creates the infrastructure required role_3016.
     * 
     * @param domainElement
     *            the domain element
     * @param containerView
     *            the container view
     * @param index
     *            the index
     * @param persisted
     *            the persisted
     * @param preferencesHint
     *            the preferences hint
     * @return the node
     * @generated
     */
    public Node createInfrastructureRequiredRole_3016(EObject domainElement, View containerView, int index,
            boolean persisted, PreferencesHint preferencesHint) {
        Shape node = NotationFactory.eINSTANCE.createShape();
        node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
        node.setType(PalladioComponentModelVisualIDRegistry.getType(InfrastructureRequiredRoleEditPart.VISUAL_ID));
        ViewUtil.insertChildView(containerView, node, index, persisted);
        node.setElement(domainElement);
        // initializeFromPreferences
        final IPreferenceStore prefStore = (IPreferenceStore) preferencesHint.getPreferenceStore();

        org.eclipse.swt.graphics.RGB lineRGB = PreferenceConverter.getColor(prefStore,
                IPreferenceConstants.PREF_LINE_COLOR);
        ViewUtil.setStructuralFeatureValue(node, NotationPackage.eINSTANCE.getLineStyle_LineColor(),
                FigureUtilities.RGBToInteger(lineRGB));
        FontStyle nodeFontStyle = (FontStyle) node.getStyle(NotationPackage.Literals.FONT_STYLE);
        if (nodeFontStyle != null) {
            FontData fontData = PreferenceConverter.getFontData(prefStore, IPreferenceConstants.PREF_DEFAULT_FONT);
            nodeFontStyle.setFontName(fontData.getName());
            nodeFontStyle.setFontHeight(fontData.getHeight());
            nodeFontStyle.setBold((fontData.getStyle() & SWT.BOLD) != 0);
            nodeFontStyle.setItalic((fontData.getStyle() & SWT.ITALIC) != 0);
            org.eclipse.swt.graphics.RGB fontRGB = PreferenceConverter.getColor(prefStore,
                    IPreferenceConstants.PREF_FONT_COLOR);
            nodeFontStyle.setFontColor(FigureUtilities.RGBToInteger(fontRGB).intValue());
        }
        org.eclipse.swt.graphics.RGB fillRGB = PreferenceConverter.getColor(prefStore,
                IPreferenceConstants.PREF_FILL_COLOR);
        ViewUtil.setStructuralFeatureValue(node, NotationPackage.eINSTANCE.getFillStyle_FillColor(),
                FigureUtilities.RGBToInteger(fillRGB));
        Node label5018 = createLabel(node,
                PalladioComponentModelVisualIDRegistry.getType(InfrastructureRequiredRoleEntityNameEditPart.VISUAL_ID));
        label5018.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
        Location location5018 = (Location) label5018.getLayoutConstraint();
        location5018.setX(0);
        location5018.setY(5);
        return node;
    }

    /**
     * Creates the operation provided role_3011.
     * 
     * @param domainElement
     *            the domain element
     * @param containerView
     *            the container view
     * @param index
     *            the index
     * @param persisted
     *            the persisted
     * @param preferencesHint
     *            the preferences hint
     * @return the node
     * @generated
     */
    public Node createOperationProvidedRole_3011(EObject domainElement, View containerView, int index,
            boolean persisted, PreferencesHint preferencesHint) {
        Shape node = NotationFactory.eINSTANCE.createShape();
        node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
        node.setType(PalladioComponentModelVisualIDRegistry.getType(OperationProvidedRole2EditPart.VISUAL_ID));
        ViewUtil.insertChildView(containerView, node, index, persisted);
        node.setElement(domainElement);
        // initializeFromPreferences
        final IPreferenceStore prefStore = (IPreferenceStore) preferencesHint.getPreferenceStore();

        org.eclipse.swt.graphics.RGB lineRGB = PreferenceConverter.getColor(prefStore,
                IPreferenceConstants.PREF_LINE_COLOR);
        ViewUtil.setStructuralFeatureValue(node, NotationPackage.eINSTANCE.getLineStyle_LineColor(),
                FigureUtilities.RGBToInteger(lineRGB));
        FontStyle nodeFontStyle = (FontStyle) node.getStyle(NotationPackage.Literals.FONT_STYLE);
        if (nodeFontStyle != null) {
            FontData fontData = PreferenceConverter.getFontData(prefStore, IPreferenceConstants.PREF_DEFAULT_FONT);
            nodeFontStyle.setFontName(fontData.getName());
            nodeFontStyle.setFontHeight(fontData.getHeight());
            nodeFontStyle.setBold((fontData.getStyle() & SWT.BOLD) != 0);
            nodeFontStyle.setItalic((fontData.getStyle() & SWT.ITALIC) != 0);
            org.eclipse.swt.graphics.RGB fontRGB = PreferenceConverter.getColor(prefStore,
                    IPreferenceConstants.PREF_FONT_COLOR);
            nodeFontStyle.setFontColor(FigureUtilities.RGBToInteger(fontRGB).intValue());
        }
        org.eclipse.swt.graphics.RGB fillRGB = PreferenceConverter.getColor(prefStore,
                IPreferenceConstants.PREF_FILL_COLOR);
        ViewUtil.setStructuralFeatureValue(node, NotationPackage.eINSTANCE.getFillStyle_FillColor(),
                FigureUtilities.RGBToInteger(fillRGB));
        Node label5013 = createLabel(node,
                PalladioComponentModelVisualIDRegistry.getType(OperationProvidedRoleEntityName2EditPart.VISUAL_ID));
        label5013.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
        Location location5013 = (Location) label5013.getLayoutConstraint();
        location5013.setX(0);
        location5013.setY(5);
        return node;
    }

    /**
     * Creates the operation required role_3012.
     * 
     * @param domainElement
     *            the domain element
     * @param containerView
     *            the container view
     * @param index
     *            the index
     * @param persisted
     *            the persisted
     * @param preferencesHint
     *            the preferences hint
     * @return the node
     * @generated
     */
    public Node createOperationRequiredRole_3012(EObject domainElement, View containerView, int index,
            boolean persisted, PreferencesHint preferencesHint) {
        Shape node = NotationFactory.eINSTANCE.createShape();
        node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
        node.setType(PalladioComponentModelVisualIDRegistry.getType(OperationRequiredRole2EditPart.VISUAL_ID));
        ViewUtil.insertChildView(containerView, node, index, persisted);
        node.setElement(domainElement);
        // initializeFromPreferences
        final IPreferenceStore prefStore = (IPreferenceStore) preferencesHint.getPreferenceStore();

        org.eclipse.swt.graphics.RGB lineRGB = PreferenceConverter.getColor(prefStore,
                IPreferenceConstants.PREF_LINE_COLOR);
        ViewUtil.setStructuralFeatureValue(node, NotationPackage.eINSTANCE.getLineStyle_LineColor(),
                FigureUtilities.RGBToInteger(lineRGB));
        FontStyle nodeFontStyle = (FontStyle) node.getStyle(NotationPackage.Literals.FONT_STYLE);
        if (nodeFontStyle != null) {
            FontData fontData = PreferenceConverter.getFontData(prefStore, IPreferenceConstants.PREF_DEFAULT_FONT);
            nodeFontStyle.setFontName(fontData.getName());
            nodeFontStyle.setFontHeight(fontData.getHeight());
            nodeFontStyle.setBold((fontData.getStyle() & SWT.BOLD) != 0);
            nodeFontStyle.setItalic((fontData.getStyle() & SWT.ITALIC) != 0);
            org.eclipse.swt.graphics.RGB fontRGB = PreferenceConverter.getColor(prefStore,
                    IPreferenceConstants.PREF_FONT_COLOR);
            nodeFontStyle.setFontColor(FigureUtilities.RGBToInteger(fontRGB).intValue());
        }
        org.eclipse.swt.graphics.RGB fillRGB = PreferenceConverter.getColor(prefStore,
                IPreferenceConstants.PREF_FILL_COLOR);
        ViewUtil.setStructuralFeatureValue(node, NotationPackage.eINSTANCE.getFillStyle_FillColor(),
                FigureUtilities.RGBToInteger(fillRGB));
        Node label5014 = createLabel(node,
                PalladioComponentModelVisualIDRegistry.getType(OperationRequiredRoleEntityName2EditPart.VISUAL_ID));
        label5014.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
        Location location5014 = (Location) label5014.getLayoutConstraint();
        location5014.setX(0);
        location5014.setY(5);
        return node;
    }

    /**
     * Creates the assembly connector_4004.
     * 
     * @param domainElement
     *            the domain element
     * @param containerView
     *            the container view
     * @param index
     *            the index
     * @param persisted
     *            the persisted
     * @param preferencesHint
     *            the preferences hint
     * @return the edge
     * @generated
     */
    public Node createEventChannel_3017(EObject domainElement, View containerView, int index, boolean persisted,
            PreferencesHint preferencesHint) {
        Shape node = NotationFactory.eINSTANCE.createShape();
        node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
        node.setType(PalladioComponentModelVisualIDRegistry.getType(EventChannelEditPart.VISUAL_ID));
        ViewUtil.insertChildView(containerView, node, index, persisted);
        node.setElement(domainElement);
        // initializeFromPreferences
        final IPreferenceStore prefStore = (IPreferenceStore) preferencesHint.getPreferenceStore();

        org.eclipse.swt.graphics.RGB lineRGB = PreferenceConverter.getColor(prefStore,
                IPreferenceConstants.PREF_LINE_COLOR);
        ViewUtil.setStructuralFeatureValue(node, NotationPackage.eINSTANCE.getLineStyle_LineColor(),
                FigureUtilities.RGBToInteger(lineRGB));
        FontStyle nodeFontStyle = (FontStyle) node.getStyle(NotationPackage.Literals.FONT_STYLE);
        if (nodeFontStyle != null) {
            FontData fontData = PreferenceConverter.getFontData(prefStore, IPreferenceConstants.PREF_DEFAULT_FONT);
            nodeFontStyle.setFontName(fontData.getName());
            nodeFontStyle.setFontHeight(fontData.getHeight());
            nodeFontStyle.setBold((fontData.getStyle() & SWT.BOLD) != 0);
            nodeFontStyle.setItalic((fontData.getStyle() & SWT.ITALIC) != 0);
            org.eclipse.swt.graphics.RGB fontRGB = PreferenceConverter.getColor(prefStore,
                    IPreferenceConstants.PREF_FONT_COLOR);
            nodeFontStyle.setFontColor(FigureUtilities.RGBToInteger(fontRGB).intValue());
        }
        org.eclipse.swt.graphics.RGB fillRGB = PreferenceConverter.getColor(prefStore,
                IPreferenceConstants.PREF_FILL_COLOR);
        ViewUtil.setStructuralFeatureValue(node, NotationPackage.eINSTANCE.getFillStyle_FillColor(),
                FigureUtilities.RGBToInteger(fillRGB));
        Node label5019 = createLabel(node,
                PalladioComponentModelVisualIDRegistry.getType(EventChannelEntityNameEditPart.VISUAL_ID));
        return node;
    }

    /**
     * @generated
     */
    public Edge createEventChannelSinkConnector_4010(EObject domainElement, View containerView, int index,
            boolean persisted, PreferencesHint preferencesHint) {
        Connector edge = NotationFactory.eINSTANCE.createConnector();
        edge.getStyles().add(NotationFactory.eINSTANCE.createFontStyle());
        RelativeBendpoints bendpoints = NotationFactory.eINSTANCE.createRelativeBendpoints();
        ArrayList points = new ArrayList(2);
        points.add(new RelativeBendpoint());
        points.add(new RelativeBendpoint());
        bendpoints.setPoints(points);
        edge.setBendpoints(bendpoints);
        ViewUtil.insertChildView(containerView, edge, index, persisted);
        edge.setType(PalladioComponentModelVisualIDRegistry.getType(EventChannelSinkConnectorEditPart.VISUAL_ID));
        edge.setElement(domainElement);
        // initializePreferences
        final IPreferenceStore prefStore = (IPreferenceStore) preferencesHint.getPreferenceStore();

        org.eclipse.swt.graphics.RGB lineRGB = PreferenceConverter.getColor(prefStore,
                IPreferenceConstants.PREF_LINE_COLOR);
        ViewUtil.setStructuralFeatureValue(edge, NotationPackage.eINSTANCE.getLineStyle_LineColor(),
                FigureUtilities.RGBToInteger(lineRGB));
        FontStyle edgeFontStyle = (FontStyle) edge.getStyle(NotationPackage.Literals.FONT_STYLE);
        if (edgeFontStyle != null) {
            FontData fontData = PreferenceConverter.getFontData(prefStore, IPreferenceConstants.PREF_DEFAULT_FONT);
            edgeFontStyle.setFontName(fontData.getName());
            edgeFontStyle.setFontHeight(fontData.getHeight());
            edgeFontStyle.setBold((fontData.getStyle() & SWT.BOLD) != 0);
            edgeFontStyle.setItalic((fontData.getStyle() & SWT.ITALIC) != 0);
            org.eclipse.swt.graphics.RGB fontRGB = PreferenceConverter.getColor(prefStore,
                    IPreferenceConstants.PREF_FONT_COLOR);
            edgeFontStyle.setFontColor(FigureUtilities.RGBToInteger(fontRGB).intValue());
        }
        Routing routing = Routing.get(prefStore.getInt(IPreferenceConstants.PREF_LINE_STYLE));
        if (routing != null) {
            ViewUtil.setStructuralFeatureValue(edge, NotationPackage.eINSTANCE.getRoutingStyle_Routing(), routing);
        }
        return edge;
    }

    /**
     * @generated
     */
    public Edge createEventChannelSourceConnector_4009(EObject domainElement, View containerView, int index,
            boolean persisted, PreferencesHint preferencesHint) {
        Connector edge = NotationFactory.eINSTANCE.createConnector();
        edge.getStyles().add(NotationFactory.eINSTANCE.createFontStyle());
        RelativeBendpoints bendpoints = NotationFactory.eINSTANCE.createRelativeBendpoints();
        ArrayList points = new ArrayList(2);
        points.add(new RelativeBendpoint());
        points.add(new RelativeBendpoint());
        bendpoints.setPoints(points);
        edge.setBendpoints(bendpoints);
        ViewUtil.insertChildView(containerView, edge, index, persisted);
        edge.setType(PalladioComponentModelVisualIDRegistry.getType(EventChannelSourceConnectorEditPart.VISUAL_ID));
        edge.setElement(domainElement);
        // initializePreferences
        final IPreferenceStore prefStore = (IPreferenceStore) preferencesHint.getPreferenceStore();

        org.eclipse.swt.graphics.RGB lineRGB = PreferenceConverter.getColor(prefStore,
                IPreferenceConstants.PREF_LINE_COLOR);
        ViewUtil.setStructuralFeatureValue(edge, NotationPackage.eINSTANCE.getLineStyle_LineColor(),
                FigureUtilities.RGBToInteger(lineRGB));
        FontStyle edgeFontStyle = (FontStyle) edge.getStyle(NotationPackage.Literals.FONT_STYLE);
        if (edgeFontStyle != null) {
            FontData fontData = PreferenceConverter.getFontData(prefStore, IPreferenceConstants.PREF_DEFAULT_FONT);
            edgeFontStyle.setFontName(fontData.getName());
            edgeFontStyle.setFontHeight(fontData.getHeight());
            edgeFontStyle.setBold((fontData.getStyle() & SWT.BOLD) != 0);
            edgeFontStyle.setItalic((fontData.getStyle() & SWT.ITALIC) != 0);
            org.eclipse.swt.graphics.RGB fontRGB = PreferenceConverter.getColor(prefStore,
                    IPreferenceConstants.PREF_FONT_COLOR);
            edgeFontStyle.setFontColor(FigureUtilities.RGBToInteger(fontRGB).intValue());
        }
        Routing routing = Routing.get(prefStore.getInt(IPreferenceConstants.PREF_LINE_STYLE));
        if (routing != null) {
            ViewUtil.setStructuralFeatureValue(edge, NotationPackage.eINSTANCE.getRoutingStyle_Routing(), routing);
        }
        return edge;
    }

    /**
     * @generated
     */
    public Edge createAssemblyConnector_4004(EObject domainElement, View containerView, int index, boolean persisted,
            PreferencesHint preferencesHint) {
        Connector edge = NotationFactory.eINSTANCE.createConnector();
        edge.getStyles().add(NotationFactory.eINSTANCE.createFontStyle());
        RelativeBendpoints bendpoints = NotationFactory.eINSTANCE.createRelativeBendpoints();
        ArrayList points = new ArrayList(2);
        points.add(new RelativeBendpoint());
        points.add(new RelativeBendpoint());
        bendpoints.setPoints(points);
        edge.setBendpoints(bendpoints);
        ViewUtil.insertChildView(containerView, edge, index, persisted);
        edge.setType(PalladioComponentModelVisualIDRegistry.getType(AssemblyConnectorEditPart.VISUAL_ID));
        edge.setElement(domainElement);
        // initializePreferences
        final IPreferenceStore prefStore = (IPreferenceStore) preferencesHint.getPreferenceStore();

        org.eclipse.swt.graphics.RGB lineRGB = PreferenceConverter.getColor(prefStore,
                IPreferenceConstants.PREF_LINE_COLOR);
        ViewUtil.setStructuralFeatureValue(edge, NotationPackage.eINSTANCE.getLineStyle_LineColor(),
                FigureUtilities.RGBToInteger(lineRGB));
        FontStyle edgeFontStyle = (FontStyle) edge.getStyle(NotationPackage.Literals.FONT_STYLE);
        if (edgeFontStyle != null) {
            FontData fontData = PreferenceConverter.getFontData(prefStore, IPreferenceConstants.PREF_DEFAULT_FONT);
            edgeFontStyle.setFontName(fontData.getName());
            edgeFontStyle.setFontHeight(fontData.getHeight());
            edgeFontStyle.setBold((fontData.getStyle() & SWT.BOLD) != 0);
            edgeFontStyle.setItalic((fontData.getStyle() & SWT.ITALIC) != 0);
            org.eclipse.swt.graphics.RGB fontRGB = PreferenceConverter.getColor(prefStore,
                    IPreferenceConstants.PREF_FONT_COLOR);
            edgeFontStyle.setFontColor(FigureUtilities.RGBToInteger(fontRGB).intValue());
        }
        Routing routing = Routing.get(prefStore.getInt(IPreferenceConstants.PREF_LINE_STYLE));
        if (routing != null) {
            ViewUtil.setStructuralFeatureValue(edge, NotationPackage.eINSTANCE.getRoutingStyle_Routing(), routing);
        }
        return edge;
    }

    /**
     * Creates the assembly event connector_4007.
     * 
     * @param domainElement
     *            the domain element
     * @param containerView
     *            the container view
     * @param index
     *            the index
     * @param persisted
     *            the persisted
     * @param preferencesHint
     *            the preferences hint
     * @return the edge
     * @generated
     */
    public Edge createAssemblyEventConnector_4007(EObject domainElement, View containerView, int index,
            boolean persisted, PreferencesHint preferencesHint) {
        Connector edge = NotationFactory.eINSTANCE.createConnector();
        edge.getStyles().add(NotationFactory.eINSTANCE.createFontStyle());
        RelativeBendpoints bendpoints = NotationFactory.eINSTANCE.createRelativeBendpoints();
        ArrayList points = new ArrayList(2);
        points.add(new RelativeBendpoint());
        points.add(new RelativeBendpoint());
        bendpoints.setPoints(points);
        edge.setBendpoints(bendpoints);
        ViewUtil.insertChildView(containerView, edge, index, persisted);
        edge.setType(PalladioComponentModelVisualIDRegistry.getType(AssemblyEventConnectorEditPart.VISUAL_ID));
        edge.setElement(domainElement);
        // initializePreferences
        final IPreferenceStore prefStore = (IPreferenceStore) preferencesHint.getPreferenceStore();

        org.eclipse.swt.graphics.RGB lineRGB = PreferenceConverter.getColor(prefStore,
                IPreferenceConstants.PREF_LINE_COLOR);
        ViewUtil.setStructuralFeatureValue(edge, NotationPackage.eINSTANCE.getLineStyle_LineColor(),
                FigureUtilities.RGBToInteger(lineRGB));
        FontStyle edgeFontStyle = (FontStyle) edge.getStyle(NotationPackage.Literals.FONT_STYLE);
        if (edgeFontStyle != null) {
            FontData fontData = PreferenceConverter.getFontData(prefStore, IPreferenceConstants.PREF_DEFAULT_FONT);
            edgeFontStyle.setFontName(fontData.getName());
            edgeFontStyle.setFontHeight(fontData.getHeight());
            edgeFontStyle.setBold((fontData.getStyle() & SWT.BOLD) != 0);
            edgeFontStyle.setItalic((fontData.getStyle() & SWT.ITALIC) != 0);
            org.eclipse.swt.graphics.RGB fontRGB = PreferenceConverter.getColor(prefStore,
                    IPreferenceConstants.PREF_FONT_COLOR);
            edgeFontStyle.setFontColor(FigureUtilities.RGBToInteger(fontRGB).intValue());
        }
        Routing routing = Routing.get(prefStore.getInt(IPreferenceConstants.PREF_LINE_STYLE));
        if (routing != null) {
            ViewUtil.setStructuralFeatureValue(edge, NotationPackage.eINSTANCE.getRoutingStyle_Routing(), routing);
        }
        return edge;
    }

    /**
     * Creates the required delegation connector_4005.
     * 
     * @param domainElement
     *            the domain element
     * @param containerView
     *            the container view
     * @param index
     *            the index
     * @param persisted
     *            the persisted
     * @param preferencesHint
     *            the preferences hint
     * @return the edge
     * @generated
     */
    public Edge createRequiredDelegationConnector_4005(EObject domainElement, View containerView, int index,
            boolean persisted, PreferencesHint preferencesHint) {
        Connector edge = NotationFactory.eINSTANCE.createConnector();
        edge.getStyles().add(NotationFactory.eINSTANCE.createFontStyle());
        RelativeBendpoints bendpoints = NotationFactory.eINSTANCE.createRelativeBendpoints();
        ArrayList points = new ArrayList(2);
        points.add(new RelativeBendpoint());
        points.add(new RelativeBendpoint());
        bendpoints.setPoints(points);
        edge.setBendpoints(bendpoints);
        ViewUtil.insertChildView(containerView, edge, index, persisted);
        edge.setType(PalladioComponentModelVisualIDRegistry.getType(RequiredDelegationConnectorEditPart.VISUAL_ID));
        edge.setElement(domainElement);
        // initializePreferences
        final IPreferenceStore prefStore = (IPreferenceStore) preferencesHint.getPreferenceStore();

        org.eclipse.swt.graphics.RGB lineRGB = PreferenceConverter.getColor(prefStore,
                IPreferenceConstants.PREF_LINE_COLOR);
        ViewUtil.setStructuralFeatureValue(edge, NotationPackage.eINSTANCE.getLineStyle_LineColor(),
                FigureUtilities.RGBToInteger(lineRGB));
        FontStyle edgeFontStyle = (FontStyle) edge.getStyle(NotationPackage.Literals.FONT_STYLE);
        if (edgeFontStyle != null) {
            FontData fontData = PreferenceConverter.getFontData(prefStore, IPreferenceConstants.PREF_DEFAULT_FONT);
            edgeFontStyle.setFontName(fontData.getName());
            edgeFontStyle.setFontHeight(fontData.getHeight());
            edgeFontStyle.setBold((fontData.getStyle() & SWT.BOLD) != 0);
            edgeFontStyle.setItalic((fontData.getStyle() & SWT.ITALIC) != 0);
            org.eclipse.swt.graphics.RGB fontRGB = PreferenceConverter.getColor(prefStore,
                    IPreferenceConstants.PREF_FONT_COLOR);
            edgeFontStyle.setFontColor(FigureUtilities.RGBToInteger(fontRGB).intValue());
        }
        Routing routing = Routing.get(prefStore.getInt(IPreferenceConstants.PREF_LINE_STYLE));
        if (routing != null) {
            ViewUtil.setStructuralFeatureValue(edge, NotationPackage.eINSTANCE.getRoutingStyle_Routing(), routing);
        }
        return edge;
    }

    /**
     * Creates the provided delegation connector_4006.
     * 
     * @param domainElement
     *            the domain element
     * @param containerView
     *            the container view
     * @param index
     *            the index
     * @param persisted
     *            the persisted
     * @param preferencesHint
     *            the preferences hint
     * @return the edge
     * @generated
     */
    public Edge createProvidedDelegationConnector_4006(EObject domainElement, View containerView, int index,
            boolean persisted, PreferencesHint preferencesHint) {
        Connector edge = NotationFactory.eINSTANCE.createConnector();
        edge.getStyles().add(NotationFactory.eINSTANCE.createFontStyle());
        RelativeBendpoints bendpoints = NotationFactory.eINSTANCE.createRelativeBendpoints();
        ArrayList points = new ArrayList(2);
        points.add(new RelativeBendpoint());
        points.add(new RelativeBendpoint());
        bendpoints.setPoints(points);
        edge.setBendpoints(bendpoints);
        ViewUtil.insertChildView(containerView, edge, index, persisted);
        edge.setType(PalladioComponentModelVisualIDRegistry.getType(ProvidedDelegationConnectorEditPart.VISUAL_ID));
        edge.setElement(domainElement);
        // initializePreferences
        final IPreferenceStore prefStore = (IPreferenceStore) preferencesHint.getPreferenceStore();

        org.eclipse.swt.graphics.RGB lineRGB = PreferenceConverter.getColor(prefStore,
                IPreferenceConstants.PREF_LINE_COLOR);
        ViewUtil.setStructuralFeatureValue(edge, NotationPackage.eINSTANCE.getLineStyle_LineColor(),
                FigureUtilities.RGBToInteger(lineRGB));
        FontStyle edgeFontStyle = (FontStyle) edge.getStyle(NotationPackage.Literals.FONT_STYLE);
        if (edgeFontStyle != null) {
            FontData fontData = PreferenceConverter.getFontData(prefStore, IPreferenceConstants.PREF_DEFAULT_FONT);
            edgeFontStyle.setFontName(fontData.getName());
            edgeFontStyle.setFontHeight(fontData.getHeight());
            edgeFontStyle.setBold((fontData.getStyle() & SWT.BOLD) != 0);
            edgeFontStyle.setItalic((fontData.getStyle() & SWT.ITALIC) != 0);
            org.eclipse.swt.graphics.RGB fontRGB = PreferenceConverter.getColor(prefStore,
                    IPreferenceConstants.PREF_FONT_COLOR);
            edgeFontStyle.setFontColor(FigureUtilities.RGBToInteger(fontRGB).intValue());
        }
        Routing routing = Routing.get(prefStore.getInt(IPreferenceConstants.PREF_LINE_STYLE));
        if (routing != null) {
            ViewUtil.setStructuralFeatureValue(edge, NotationPackage.eINSTANCE.getRoutingStyle_Routing(), routing);
        }
        return edge;
    }

    /**
     * Creates the assembly infrastructure connector_4008.
     * 
     * @param domainElement
     *            the domain element
     * @param containerView
     *            the container view
     * @param index
     *            the index
     * @param persisted
     *            the persisted
     * @param preferencesHint
     *            the preferences hint
     * @return the edge
     * @generated
     */
    public Edge createAssemblyInfrastructureConnector_4008(EObject domainElement, View containerView, int index,
            boolean persisted, PreferencesHint preferencesHint) {
        Connector edge = NotationFactory.eINSTANCE.createConnector();
        edge.getStyles().add(NotationFactory.eINSTANCE.createFontStyle());
        RelativeBendpoints bendpoints = NotationFactory.eINSTANCE.createRelativeBendpoints();
        ArrayList points = new ArrayList(2);
        points.add(new RelativeBendpoint());
        points.add(new RelativeBendpoint());
        bendpoints.setPoints(points);
        edge.setBendpoints(bendpoints);
        ViewUtil.insertChildView(containerView, edge, index, persisted);
        edge.setType(PalladioComponentModelVisualIDRegistry.getType(AssemblyInfrastructureConnectorEditPart.VISUAL_ID));
        edge.setElement(domainElement);
        // initializePreferences
        final IPreferenceStore prefStore = (IPreferenceStore) preferencesHint.getPreferenceStore();

        org.eclipse.swt.graphics.RGB lineRGB = PreferenceConverter.getColor(prefStore,
                IPreferenceConstants.PREF_LINE_COLOR);
        ViewUtil.setStructuralFeatureValue(edge, NotationPackage.eINSTANCE.getLineStyle_LineColor(),
                FigureUtilities.RGBToInteger(lineRGB));
        FontStyle edgeFontStyle = (FontStyle) edge.getStyle(NotationPackage.Literals.FONT_STYLE);
        if (edgeFontStyle != null) {
            FontData fontData = PreferenceConverter.getFontData(prefStore, IPreferenceConstants.PREF_DEFAULT_FONT);
            edgeFontStyle.setFontName(fontData.getName());
            edgeFontStyle.setFontHeight(fontData.getHeight());
            edgeFontStyle.setBold((fontData.getStyle() & SWT.BOLD) != 0);
            edgeFontStyle.setItalic((fontData.getStyle() & SWT.ITALIC) != 0);
            org.eclipse.swt.graphics.RGB fontRGB = PreferenceConverter.getColor(prefStore,
                    IPreferenceConstants.PREF_FONT_COLOR);
            edgeFontStyle.setFontColor(FigureUtilities.RGBToInteger(fontRGB).intValue());
        }
        Routing routing = Routing.get(prefStore.getInt(IPreferenceConstants.PREF_LINE_STYLE));
        if (routing != null) {
            ViewUtil.setStructuralFeatureValue(edge, NotationPackage.eINSTANCE.getRoutingStyle_Routing(), routing);
        }
        return edge;
    }

    /**
     * Stamp shortcut.
     * 
     * @param containerView
     *            the container view
     * @param target
     *            the target
     * @generated
     */
    private void stampShortcut(View containerView, Node target) {
        if (!ComposedProvidingRequiringEntityEditPart.MODEL_ID.equals(PalladioComponentModelVisualIDRegistry
                .getModelID(containerView))) {
            EAnnotation shortcutAnnotation = EcoreFactory.eINSTANCE.createEAnnotation();
            shortcutAnnotation.setSource("Shortcut"); //$NON-NLS-1$
            shortcutAnnotation.getDetails().put("modelID", ComposedProvidingRequiringEntityEditPart.MODEL_ID); //$NON-NLS-1$
            target.getEAnnotations().add(shortcutAnnotation);
        }
    }

    /**
     * Creates the label.
     * 
     * @param owner
     *            the owner
     * @param hint
     *            the hint
     * @return the node
     * @generated
     */
    private Node createLabel(View owner, String hint) {
        DecorationNode rv = NotationFactory.eINSTANCE.createDecorationNode();
        rv.setType(hint);
        ViewUtil.insertChildView(owner, rv, ViewUtil.APPEND, true);
        return rv;
    }

    /**
     * Creates the compartment.
     * 
     * @param owner
     *            the owner
     * @param hint
     *            the hint
     * @param canCollapse
     *            the can collapse
     * @param hasTitle
     *            the has title
     * @param canSort
     *            the can sort
     * @param canFilter
     *            the can filter
     * @return the node
     * @generated
     */
    private Node createCompartment(View owner, String hint, boolean canCollapse, boolean hasTitle, boolean canSort,
            boolean canFilter) {
        // SemanticListCompartment rv = NotationFactory.eINSTANCE.createSemanticListCompartment();
        // rv.setShowTitle(showTitle);
        // rv.setCollapsed(isCollapsed);
        Node rv;
        if (canCollapse) {
            rv = NotationFactory.eINSTANCE.createBasicCompartment();
        } else {
            rv = NotationFactory.eINSTANCE.createDecorationNode();
        }
        if (hasTitle) {
            TitleStyle ts = NotationFactory.eINSTANCE.createTitleStyle();
            ts.setShowTitle(true);
            rv.getStyles().add(ts);
        }
        if (canSort) {
            rv.getStyles().add(NotationFactory.eINSTANCE.createSortingStyle());
        }
        if (canFilter) {
            rv.getStyles().add(NotationFactory.eINSTANCE.createFilteringStyle());
        }
        rv.setType(hint);
        ViewUtil.insertChildView(owner, rv, ViewUtil.APPEND, true);
        return rv;
    }

    /**
     * Gets the semantic element.
     * 
     * @param semanticAdapter
     *            the semantic adapter
     * @return the semantic element
     * @generated
     */
    private EObject getSemanticElement(IAdaptable semanticAdapter) {
        if (semanticAdapter == null) {
            return null;
        }
        EObject eObject = (EObject) semanticAdapter.getAdapter(EObject.class);
        if (eObject != null) {
            return EMFCoreUtil.resolve(TransactionUtil.getEditingDomain(eObject), eObject);
        }
        return null;
    }

    /**
     * Gets the semantic element type.
     * 
     * @param semanticAdapter
     *            the semantic adapter
     * @return the semantic element type
     * @generated
     */
    private IElementType getSemanticElementType(IAdaptable semanticAdapter) {
        if (semanticAdapter == null) {
            return null;
        }
        return (IElementType) semanticAdapter.getAdapter(IElementType.class);
    }

}
