/*
 *Copyright 2006 SDQ Research Group, University of Karlsruhe (TH)
 */
package de.uka.ipd.sdq.pcm.gmf.seff.providers;

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

import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.*;
import de.uka.ipd.sdq.pcm.gmf.seff.part.PalladioComponentModelVisualIDRegistry;

/**
 * @generated
 */
public class PalladioComponentModelViewProvider extends AbstractProvider implements IViewProvider {

    /**
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
     * @generated
     */
    protected boolean provides(CreateViewForKindOperation op) {
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
    protected boolean provides(CreateDiagramViewOperation op) {
        return ResourceDemandingSEFFEditPart.MODEL_ID.equals(op.getSemanticHint())
                && PalladioComponentModelVisualIDRegistry
                        .getDiagramVisualID(getSemanticElement(op.getSemanticAdapter())) != -1;
    }

    /**
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
                    return false; // if semantic hint is specified it should be the same as in element type
                }
                if (domainElement != null
                        && visualID != PalladioComponentModelVisualIDRegistry.getNodeVisualID(op.getContainerView(),
                                domainElement)) {
                    return false; // visual id for node EClass should match visual id from element type
                }
            } else {
                if (!ResourceDemandingSEFFEditPart.MODEL_ID.equals(PalladioComponentModelVisualIDRegistry.getModelID(op
                        .getContainerView()))) {
                    return false; // foreign diagram
                }
                switch (visualID) {
                case StartActionEditPart.VISUAL_ID:
                case StopActionEditPart.VISUAL_ID:
                case ExternalCallActionEditPart.VISUAL_ID:
                case EmitEventActionEditPart.VISUAL_ID:
                case LoopActionEditPart.VISUAL_ID:
                case VariableUsageEditPart.VISUAL_ID:
                case VariableCharacterisationEditPart.VISUAL_ID:
                case ResourceDemandingBehaviourEditPart.VISUAL_ID:
                case InternalAction2EditPart.VISUAL_ID:
                case ParametricResourceDemandEditPart.VISUAL_ID:
                case InternalFailureOccurrenceDescriptionEditPart.VISUAL_ID:
                case InfrastructureCallEditPart.VISUAL_ID:
                case BranchAction2EditPart.VISUAL_ID:
                case ProbabilisticBranchTransitionEditPart.VISUAL_ID:
                case AcquireAction2EditPart.VISUAL_ID:
                case ReleaseAction2EditPart.VISUAL_ID:
                case ForkAction2EditPart.VISUAL_ID:
                case ForkedBehaviourEditPart.VISUAL_ID:
                case CollectionIteratorAction2EditPart.VISUAL_ID:
                case RecoveryAction2EditPart.VISUAL_ID:
                case RecoveryActionBehaviourEditPart.VISUAL_ID:
                case SetVariableAction2EditPart.VISUAL_ID:
                case SynchronisationPointEditPart.VISUAL_ID:
                case GuardedBranchTransitionEditPart.VISUAL_ID:
                case BranchActionEditPart.VISUAL_ID:
                case InternalActionEditPart.VISUAL_ID:
                case CollectionIteratorActionEditPart.VISUAL_ID:
                case SetVariableActionEditPart.VISUAL_ID:
                case AcquireActionEditPart.VISUAL_ID:
                case ReleaseActionEditPart.VISUAL_ID:
                case ForkActionEditPart.VISUAL_ID:
                case RecoveryActionEditPart.VISUAL_ID:
                case VariableUsage2EditPart.VISUAL_ID:
                case VariableCharacterisation2EditPart.VISUAL_ID:
                case VariableUsage4EditPart.VISUAL_ID:
                case VariableCharacterisation3EditPart.VISUAL_ID:
                case StartAction2EditPart.VISUAL_ID:
                case StopAction2EditPart.VISUAL_ID:
                case LoopAction2EditPart.VISUAL_ID:
                case VariableUsage5EditPart.VISUAL_ID:
                case VariableCharacterisation4EditPart.VISUAL_ID:
                case ResourceDemandingBehaviour2EditPart.VISUAL_ID:
                case ExternalCallAction2EditPart.VISUAL_ID:
                case EmitEventAction2EditPart.VISUAL_ID:
                case ResourceDemandingBehaviour3EditPart.VISUAL_ID:
                case VariableUsage3EditPart.VISUAL_ID:
                case VariableCharacterisation5EditPart.VISUAL_ID:
                case ForkedBehaviour2EditPart.VISUAL_ID:
                case ResourceDemandingBehaviour4EditPart.VISUAL_ID:
                    if (domainElement == null
                            || visualID != PalladioComponentModelVisualIDRegistry.getNodeVisualID(
                                    op.getContainerView(), domainElement)) {
                        return false; // visual id in semantic hint should match visual id for domain element
                    }
                    break;
                default:
                    return false;
                }
            }
        }
        return StartActionEditPart.VISUAL_ID == visualID || StopActionEditPart.VISUAL_ID == visualID
                || ExternalCallActionEditPart.VISUAL_ID == visualID || EmitEventActionEditPart.VISUAL_ID == visualID
                || LoopActionEditPart.VISUAL_ID == visualID || BranchActionEditPart.VISUAL_ID == visualID
                || InternalActionEditPart.VISUAL_ID == visualID
                || CollectionIteratorActionEditPart.VISUAL_ID == visualID
                || SetVariableActionEditPart.VISUAL_ID == visualID || AcquireActionEditPart.VISUAL_ID == visualID
                || ReleaseActionEditPart.VISUAL_ID == visualID || ForkActionEditPart.VISUAL_ID == visualID
                || RecoveryActionEditPart.VISUAL_ID == visualID || VariableUsageEditPart.VISUAL_ID == visualID
                || VariableCharacterisationEditPart.VISUAL_ID == visualID
                || VariableUsage2EditPart.VISUAL_ID == visualID
                || VariableCharacterisation2EditPart.VISUAL_ID == visualID
                || VariableUsage4EditPart.VISUAL_ID == visualID
                || VariableCharacterisation3EditPart.VISUAL_ID == visualID
                || ResourceDemandingBehaviourEditPart.VISUAL_ID == visualID
                || StartAction2EditPart.VISUAL_ID == visualID || StopAction2EditPart.VISUAL_ID == visualID
                || LoopAction2EditPart.VISUAL_ID == visualID || InternalAction2EditPart.VISUAL_ID == visualID
                || ParametricResourceDemandEditPart.VISUAL_ID == visualID
                || InternalFailureOccurrenceDescriptionEditPart.VISUAL_ID == visualID
                || InfrastructureCallEditPart.VISUAL_ID == visualID || VariableUsage5EditPart.VISUAL_ID == visualID
                || VariableCharacterisation4EditPart.VISUAL_ID == visualID
                || BranchAction2EditPart.VISUAL_ID == visualID
                || ProbabilisticBranchTransitionEditPart.VISUAL_ID == visualID
                || ResourceDemandingBehaviour2EditPart.VISUAL_ID == visualID
                || ExternalCallAction2EditPart.VISUAL_ID == visualID || EmitEventAction2EditPart.VISUAL_ID == visualID
                || AcquireAction2EditPart.VISUAL_ID == visualID || ReleaseAction2EditPart.VISUAL_ID == visualID
                || ForkAction2EditPart.VISUAL_ID == visualID || ForkedBehaviourEditPart.VISUAL_ID == visualID
                || CollectionIteratorAction2EditPart.VISUAL_ID == visualID
                || ResourceDemandingBehaviour3EditPart.VISUAL_ID == visualID
                || RecoveryAction2EditPart.VISUAL_ID == visualID
                || RecoveryActionBehaviourEditPart.VISUAL_ID == visualID
                || SetVariableAction2EditPart.VISUAL_ID == visualID || VariableUsage3EditPart.VISUAL_ID == visualID
                || VariableCharacterisation5EditPart.VISUAL_ID == visualID
                || SynchronisationPointEditPart.VISUAL_ID == visualID || ForkedBehaviour2EditPart.VISUAL_ID == visualID
                || GuardedBranchTransitionEditPart.VISUAL_ID == visualID
                || ResourceDemandingBehaviour4EditPart.VISUAL_ID == visualID;
    }

    /**
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
            return false; // our hint is visual id and must be specified, and it should be the same as in element type
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
     * @generated
     */
    public Diagram createDiagram(IAdaptable semanticAdapter, String diagramKind, PreferencesHint preferencesHint) {
        Diagram diagram = NotationFactory.eINSTANCE.createDiagram();
        diagram.getStyles().add(NotationFactory.eINSTANCE.createDiagramStyle());
        diagram.setType(ResourceDemandingSEFFEditPart.MODEL_ID);
        diagram.setElement(getSemanticElement(semanticAdapter));
        diagram.setMeasurementUnit(MeasurementUnit.PIXEL_LITERAL);
        return diagram;
    }

    /**
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
        case StartActionEditPart.VISUAL_ID:
            return createStartAction_2001(domainElement, containerView, index, persisted, preferencesHint);
        case StopActionEditPart.VISUAL_ID:
            return createStopAction_2002(domainElement, containerView, index, persisted, preferencesHint);
        case ExternalCallActionEditPart.VISUAL_ID:
            return createExternalCallAction_2003(domainElement, containerView, index, persisted, preferencesHint);
        case EmitEventActionEditPart.VISUAL_ID:
            return createEmitEventAction_2013(domainElement, containerView, index, persisted, preferencesHint);
        case LoopActionEditPart.VISUAL_ID:
            return createLoopAction_2004(domainElement, containerView, index, persisted, preferencesHint);
        case BranchActionEditPart.VISUAL_ID:
            return createBranchAction_2005(domainElement, containerView, index, persisted, preferencesHint);
        case InternalActionEditPart.VISUAL_ID:
            return createInternalAction_2006(domainElement, containerView, index, persisted, preferencesHint);
        case CollectionIteratorActionEditPart.VISUAL_ID:
            return createCollectionIteratorAction_2007(domainElement, containerView, index, persisted, preferencesHint);
        case SetVariableActionEditPart.VISUAL_ID:
            return createSetVariableAction_2008(domainElement, containerView, index, persisted, preferencesHint);
        case AcquireActionEditPart.VISUAL_ID:
            return createAcquireAction_2012(domainElement, containerView, index, persisted, preferencesHint);
        case ReleaseActionEditPart.VISUAL_ID:
            return createReleaseAction_2010(domainElement, containerView, index, persisted, preferencesHint);
        case ForkActionEditPart.VISUAL_ID:
            return createForkAction_2011(domainElement, containerView, index, persisted, preferencesHint);
        case RecoveryActionEditPart.VISUAL_ID:
            return createRecoveryAction_2017(domainElement, containerView, index, persisted, preferencesHint);
        case VariableUsageEditPart.VISUAL_ID:
            return createVariableUsage_3042(domainElement, containerView, index, persisted, preferencesHint);
        case VariableCharacterisationEditPart.VISUAL_ID:
            return createVariableCharacterisation_3033(domainElement, containerView, index, persisted, preferencesHint);
        case VariableUsage2EditPart.VISUAL_ID:
            return createVariableUsage_3049(domainElement, containerView, index, persisted, preferencesHint);
        case VariableCharacterisation2EditPart.VISUAL_ID:
            return createVariableCharacterisation_3035(domainElement, containerView, index, persisted, preferencesHint);
        case VariableUsage4EditPart.VISUAL_ID:
            return createVariableUsage_3047(domainElement, containerView, index, persisted, preferencesHint);
        case VariableCharacterisation3EditPart.VISUAL_ID:
            return createVariableCharacterisation_3037(domainElement, containerView, index, persisted, preferencesHint);
        case ResourceDemandingBehaviourEditPart.VISUAL_ID:
            return createResourceDemandingBehaviour_3003(domainElement, containerView, index, persisted,
                    preferencesHint);
        case StartAction2EditPart.VISUAL_ID:
            return createStartAction_3004(domainElement, containerView, index, persisted, preferencesHint);
        case StopAction2EditPart.VISUAL_ID:
            return createStopAction_3005(domainElement, containerView, index, persisted, preferencesHint);
        case LoopAction2EditPart.VISUAL_ID:
            return createLoopAction_3006(domainElement, containerView, index, persisted, preferencesHint);
        case InternalAction2EditPart.VISUAL_ID:
            return createInternalAction_3007(domainElement, containerView, index, persisted, preferencesHint);
        case ParametricResourceDemandEditPart.VISUAL_ID:
            return createParametricResourceDemand_3051(domainElement, containerView, index, persisted, preferencesHint);
        case InternalFailureOccurrenceDescriptionEditPart.VISUAL_ID:
            return createInternalFailureOccurrenceDescription_3050(domainElement, containerView, index, persisted,
                    preferencesHint);
        case InfrastructureCallEditPart.VISUAL_ID:
            return createInfrastructureCall_3053(domainElement, containerView, index, persisted, preferencesHint);
        case VariableUsage5EditPart.VISUAL_ID:
            return createVariableUsage_3054(domainElement, containerView, index, persisted, preferencesHint);
        case VariableCharacterisation4EditPart.VISUAL_ID:
            return createVariableCharacterisation_3048(domainElement, containerView, index, persisted, preferencesHint);
        case BranchAction2EditPart.VISUAL_ID:
            return createBranchAction_3009(domainElement, containerView, index, persisted, preferencesHint);
        case ProbabilisticBranchTransitionEditPart.VISUAL_ID:
            return createProbabilisticBranchTransition_3010(domainElement, containerView, index, persisted,
                    preferencesHint);
        case ResourceDemandingBehaviour2EditPart.VISUAL_ID:
            return createResourceDemandingBehaviour_3011(domainElement, containerView, index, persisted,
                    preferencesHint);
        case ExternalCallAction2EditPart.VISUAL_ID:
            return createExternalCallAction_3012(domainElement, containerView, index, persisted, preferencesHint);
        case EmitEventAction2EditPart.VISUAL_ID:
            return createEmitEventAction_3046(domainElement, containerView, index, persisted, preferencesHint);
        case AcquireAction2EditPart.VISUAL_ID:
            return createAcquireAction_3026(domainElement, containerView, index, persisted, preferencesHint);
        case ReleaseAction2EditPart.VISUAL_ID:
            return createReleaseAction_3020(domainElement, containerView, index, persisted, preferencesHint);
        case ForkAction2EditPart.VISUAL_ID:
            return createForkAction_3023(domainElement, containerView, index, persisted, preferencesHint);
        case ForkedBehaviourEditPart.VISUAL_ID:
            return createForkedBehaviour_3027(domainElement, containerView, index, persisted, preferencesHint);
        case CollectionIteratorAction2EditPart.VISUAL_ID:
            return createCollectionIteratorAction_3013(domainElement, containerView, index, persisted, preferencesHint);
        case ResourceDemandingBehaviour3EditPart.VISUAL_ID:
            return createResourceDemandingBehaviour_3014(domainElement, containerView, index, persisted,
                    preferencesHint);
        case RecoveryAction2EditPart.VISUAL_ID:
            return createRecoveryAction_3061(domainElement, containerView, index, persisted, preferencesHint);
        case RecoveryActionBehaviourEditPart.VISUAL_ID:
            return createRecoveryActionBehaviour_3062(domainElement, containerView, index, persisted, preferencesHint);
        case SetVariableAction2EditPart.VISUAL_ID:
            return createSetVariableAction_3024(domainElement, containerView, index, persisted, preferencesHint);
        case VariableUsage3EditPart.VISUAL_ID:
            return createVariableUsage_3036(domainElement, containerView, index, persisted, preferencesHint);
        case VariableCharacterisation5EditPart.VISUAL_ID:
            return createVariableCharacterisation_3055(domainElement, containerView, index, persisted, preferencesHint);
        case SynchronisationPointEditPart.VISUAL_ID:
            return createSynchronisationPoint_3038(domainElement, containerView, index, persisted, preferencesHint);
        case ForkedBehaviour2EditPart.VISUAL_ID:
            return createForkedBehaviour_3039(domainElement, containerView, index, persisted, preferencesHint);
        case GuardedBranchTransitionEditPart.VISUAL_ID:
            return createGuardedBranchTransition_3017(domainElement, containerView, index, persisted, preferencesHint);
        case ResourceDemandingBehaviour4EditPart.VISUAL_ID:
            return createResourceDemandingBehaviour_3018(domainElement, containerView, index, persisted,
                    preferencesHint);
        }
        // can't happen, provided #provides(CreateNodeViewOperation) is correct
        return null;
    }

    /**
     * @generated
     */
    public Edge createEdge(IAdaptable semanticAdapter, View containerView, String semanticHint, int index,
            boolean persisted, PreferencesHint preferencesHint) {
        IElementType elementType = getSemanticElementType(semanticAdapter);
        String elementTypeHint = ((IHintedType) elementType).getSemanticHint();
        switch (PalladioComponentModelVisualIDRegistry.getVisualID(elementTypeHint)) {
        case AbstractActionSuccessor_AbstractActionEditPart.VISUAL_ID:
            return createAbstractActionSuccessor_AbstractAction_4001(containerView, index, persisted, preferencesHint);
        case RecoveryActionBehaviourFailureHandlingAlternatives__RecoveryActionBehaviourEditPart.VISUAL_ID:
            return createRecoveryActionBehaviourFailureHandlingAlternatives__RecoveryActionBehaviour_4004(
                    containerView, index, persisted, preferencesHint);
        }
        // can never happen, provided #provides(CreateEdgeViewOperation) is correct
        return null;
    }

    /**
     * @generated
     */
    public Node createStartAction_2001(EObject domainElement, View containerView, int index, boolean persisted,
            PreferencesHint preferencesHint) {
        Node node = NotationFactory.eINSTANCE.createNode();
        node.getStyles().add(NotationFactory.eINSTANCE.createDescriptionStyle());
        node.getStyles().add(NotationFactory.eINSTANCE.createFontStyle());
        node.getStyles().add(NotationFactory.eINSTANCE.createLineStyle());
        node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
        node.setType(PalladioComponentModelVisualIDRegistry.getType(StartActionEditPart.VISUAL_ID));
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
        return node;
    }

    /**
     * @generated
     */
    public Node createStopAction_2002(EObject domainElement, View containerView, int index, boolean persisted,
            PreferencesHint preferencesHint) {
        Shape node = NotationFactory.eINSTANCE.createShape();
        node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
        node.setType(PalladioComponentModelVisualIDRegistry.getType(StopActionEditPart.VISUAL_ID));
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
        return node;
    }

    /**
     * @generated
     */
    public Node createExternalCallAction_2003(EObject domainElement, View containerView, int index, boolean persisted,
            PreferencesHint preferencesHint) {
        Shape node = NotationFactory.eINSTANCE.createShape();
        node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
        node.setType(PalladioComponentModelVisualIDRegistry.getType(ExternalCallActionEditPart.VISUAL_ID));
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
        Node label5002 = createLabel(node,
                PalladioComponentModelVisualIDRegistry.getType(ExternalCallActionEntityNameEditPart.VISUAL_ID));
        createCompartment(node,
                PalladioComponentModelVisualIDRegistry.getType(ExternalCallActionInputVariableUsageEditPart.VISUAL_ID),
                true, true, true, true);
        createCompartment(
                node,
                PalladioComponentModelVisualIDRegistry.getType(ExternalCallActionOutputVariableUsageEditPart.VISUAL_ID),
                true, true, true, true);
        return node;
    }

    /**
     * @generated
     */
    public Node createEmitEventAction_2013(EObject domainElement, View containerView, int index, boolean persisted,
            PreferencesHint preferencesHint) {
        Shape node = NotationFactory.eINSTANCE.createShape();
        node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
        node.setType(PalladioComponentModelVisualIDRegistry.getType(EmitEventActionEditPart.VISUAL_ID));
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
        Node label5046 = createLabel(node,
                PalladioComponentModelVisualIDRegistry.getType(EmitEventActionEntityNameEditPart.VISUAL_ID));
        createCompartment(node,
                PalladioComponentModelVisualIDRegistry
                        .getType(EmitEventActionInputVariableUsageEventEditPart.VISUAL_ID), true, true, true, true);
        return node;
    }

    /**
     * @generated
     */
    public Node createLoopAction_2004(EObject domainElement, View containerView, int index, boolean persisted,
            PreferencesHint preferencesHint) {
        Shape node = NotationFactory.eINSTANCE.createShape();
        node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
        node.setType(PalladioComponentModelVisualIDRegistry.getType(LoopActionEditPart.VISUAL_ID));
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
        Node label5009 = createLabel(node,
                PalladioComponentModelVisualIDRegistry.getType(LoopActionEntityNameEditPart.VISUAL_ID));
        Node label5010 = createLabel(node,
                PalladioComponentModelVisualIDRegistry.getType(LoopIterationsLabelEditPart.VISUAL_ID));
        return node;
    }

    /**
     * @generated
     */
    public Node createBranchAction_2005(EObject domainElement, View containerView, int index, boolean persisted,
            PreferencesHint preferencesHint) {
        Shape node = NotationFactory.eINSTANCE.createShape();
        node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
        node.setType(PalladioComponentModelVisualIDRegistry.getType(BranchActionEditPart.VISUAL_ID));
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
        Node label5011 = createLabel(node,
                PalladioComponentModelVisualIDRegistry.getType(BranchActionEntityNameEditPart.VISUAL_ID));
        createCompartment(node,
                PalladioComponentModelVisualIDRegistry
                        .getType(BranchActionBranchTransitionCompartment2EditPart.VISUAL_ID), false, false, false,
                false);
        return node;
    }

    /**
     * @generated
     */
    public Node createInternalAction_2006(EObject domainElement, View containerView, int index, boolean persisted,
            PreferencesHint preferencesHint) {
        Shape node = NotationFactory.eINSTANCE.createShape();
        node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
        node.setType(PalladioComponentModelVisualIDRegistry.getType(InternalActionEditPart.VISUAL_ID));
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
                PalladioComponentModelVisualIDRegistry.getType(InternalActionEntityNameEditPart.VISUAL_ID));
        createCompartment(node,
                PalladioComponentModelVisualIDRegistry.getType(InternalActionResourceDemand2EditPart.VISUAL_ID), true,
                true, true, true);
        createCompartment(node,
                PalladioComponentModelVisualIDRegistry
                        .getType(InternalActionFailureOccurrenceDescriptions2EditPart.VISUAL_ID), true, true, true,
                true);
        createCompartment(node,
                PalladioComponentModelVisualIDRegistry
                        .getType(InternalActionInfrastructureCallsCompartment2EditPart.VISUAL_ID), true, true, true,
                true);
        return node;
    }

    /**
     * @generated
     */
    public Node createCollectionIteratorAction_2007(EObject domainElement, View containerView, int index,
            boolean persisted, PreferencesHint preferencesHint) {
        Shape node = NotationFactory.eINSTANCE.createShape();
        node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
        node.setType(PalladioComponentModelVisualIDRegistry.getType(CollectionIteratorActionEditPart.VISUAL_ID));
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
        Node label5015 = createLabel(node,
                PalladioComponentModelVisualIDRegistry.getType(CollectionIteratorActionEntityNameEditPart.VISUAL_ID));
        Node label5016 = createLabel(node,
                PalladioComponentModelVisualIDRegistry.getType(CollectionIteratorParameterLabel2EditPart.VISUAL_ID));
        return node;
    }

    /**
     * @generated
     */
    public Node createSetVariableAction_2008(EObject domainElement, View containerView, int index, boolean persisted,
            PreferencesHint preferencesHint) {
        Shape node = NotationFactory.eINSTANCE.createShape();
        node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
        node.setType(PalladioComponentModelVisualIDRegistry.getType(SetVariableActionEditPart.VISUAL_ID));
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
        Node label5023 = createLabel(node,
                PalladioComponentModelVisualIDRegistry.getType(SetVariableActionEntityNameEditPart.VISUAL_ID));
        createCompartment(node,
                PalladioComponentModelVisualIDRegistry.getType(SetVariableActionVariableSetter2EditPart.VISUAL_ID),
                true, true, true, true);
        return node;
    }

    /**
     * @generated
     */
    public Node createAcquireAction_2012(EObject domainElement, View containerView, int index, boolean persisted,
            PreferencesHint preferencesHint) {
        Shape node = NotationFactory.eINSTANCE.createShape();
        node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
        node.setType(PalladioComponentModelVisualIDRegistry.getType(AcquireActionEditPart.VISUAL_ID));
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
        Node label5029 = createLabel(node,
                PalladioComponentModelVisualIDRegistry.getType(AcquireActionEntityNameEditPart.VISUAL_ID));
        return node;
    }

    /**
     * @generated
     */
    public Node createReleaseAction_2010(EObject domainElement, View containerView, int index, boolean persisted,
            PreferencesHint preferencesHint) {
        Shape node = NotationFactory.eINSTANCE.createShape();
        node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
        node.setType(PalladioComponentModelVisualIDRegistry.getType(ReleaseActionEditPart.VISUAL_ID));
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
        Node label5022 = createLabel(node,
                PalladioComponentModelVisualIDRegistry.getType(ReleaseActionEntityNameEditPart.VISUAL_ID));
        return node;
    }

    /**
     * @generated
     */
    public Node createForkAction_2011(EObject domainElement, View containerView, int index, boolean persisted,
            PreferencesHint preferencesHint) {
        Shape node = NotationFactory.eINSTANCE.createShape();
        node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
        node.setType(PalladioComponentModelVisualIDRegistry.getType(ForkActionEditPart.VISUAL_ID));
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
        Node label5024 = createLabel(node,
                PalladioComponentModelVisualIDRegistry.getType(ForkActionEntityNameEditPart.VISUAL_ID));
        createCompartment(node,
                PalladioComponentModelVisualIDRegistry.getType(ForkActionForkedBehaviours2EditPart.VISUAL_ID), false,
                true, false, false);
        return node;
    }

    /**
     * @generated
     */
    public Node createRecoveryAction_2017(EObject domainElement, View containerView, int index, boolean persisted,
            PreferencesHint preferencesHint) {
        Shape node = NotationFactory.eINSTANCE.createShape();
        node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
        node.setType(PalladioComponentModelVisualIDRegistry.getType(RecoveryActionEditPart.VISUAL_ID));
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
        Node label5061 = createLabel(node,
                PalladioComponentModelVisualIDRegistry.getType(RecoveryActionEntityNameEditPart.VISUAL_ID));
        createCompartment(node,
                PalladioComponentModelVisualIDRegistry
                        .getType(RecoveryActionRecoveryBlockCompartment2EditPart.VISUAL_ID), false, false, false, false);
        return node;
    }

    /**
     * @generated
     */
    public Node createVariableUsage_3042(EObject domainElement, View containerView, int index, boolean persisted,
            PreferencesHint preferencesHint) {
        Node node = NotationFactory.eINSTANCE.createNode();
        node.getStyles().add(NotationFactory.eINSTANCE.createDescriptionStyle());
        node.getStyles().add(NotationFactory.eINSTANCE.createFontStyle());
        node.getStyles().add(NotationFactory.eINSTANCE.createLineStyle());
        node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
        node.setType(PalladioComponentModelVisualIDRegistry.getType(VariableUsageEditPart.VISUAL_ID));
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
        Node label5040 = createLabel(node,
                PalladioComponentModelVisualIDRegistry.getType(VariableUsageLabelEditPart.VISUAL_ID));
        createCompartment(
                node,
                PalladioComponentModelVisualIDRegistry.getType(VariableUsageVariableCharacterisationEditPart.VISUAL_ID),
                true, true, true, true);
        return node;
    }

    /**
     * @generated
     */
    public Node createVariableCharacterisation_3033(EObject domainElement, View containerView, int index,
            boolean persisted, PreferencesHint preferencesHint) {
        Node node = NotationFactory.eINSTANCE.createNode();
        node.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
        node.setType(PalladioComponentModelVisualIDRegistry.getType(VariableCharacterisationEditPart.VISUAL_ID));
        ViewUtil.insertChildView(containerView, node, index, persisted);
        node.setElement(domainElement);
        return node;
    }

    /**
     * @generated
     */
    public Node createVariableUsage_3049(EObject domainElement, View containerView, int index, boolean persisted,
            PreferencesHint preferencesHint) {
        Node node = NotationFactory.eINSTANCE.createNode();
        node.getStyles().add(NotationFactory.eINSTANCE.createDescriptionStyle());
        node.getStyles().add(NotationFactory.eINSTANCE.createFontStyle());
        node.getStyles().add(NotationFactory.eINSTANCE.createLineStyle());
        node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
        node.setType(PalladioComponentModelVisualIDRegistry.getType(VariableUsage2EditPart.VISUAL_ID));
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
        Node label5047 = createLabel(node,
                PalladioComponentModelVisualIDRegistry.getType(WrappingLabelEditPart.VISUAL_ID));
        createCompartment(node,
                PalladioComponentModelVisualIDRegistry
                        .getType(VariableUsageVariableCharacterisation2EditPart.VISUAL_ID), true, true, true, true);
        return node;
    }

    /**
     * @generated
     */
    public Node createVariableCharacterisation_3035(EObject domainElement, View containerView, int index,
            boolean persisted, PreferencesHint preferencesHint) {
        Node node = NotationFactory.eINSTANCE.createNode();
        node.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
        node.setType(PalladioComponentModelVisualIDRegistry.getType(VariableCharacterisation2EditPart.VISUAL_ID));
        ViewUtil.insertChildView(containerView, node, index, persisted);
        node.setElement(domainElement);
        return node;
    }

    /**
     * @generated
     */
    public Node createVariableUsage_3047(EObject domainElement, View containerView, int index, boolean persisted,
            PreferencesHint preferencesHint) {
        Node node = NotationFactory.eINSTANCE.createNode();
        node.getStyles().add(NotationFactory.eINSTANCE.createDescriptionStyle());
        node.getStyles().add(NotationFactory.eINSTANCE.createFontStyle());
        node.getStyles().add(NotationFactory.eINSTANCE.createLineStyle());
        node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
        node.setType(PalladioComponentModelVisualIDRegistry.getType(VariableUsage4EditPart.VISUAL_ID));
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
        Node label5045 = createLabel(node,
                PalladioComponentModelVisualIDRegistry.getType(VariableUsage4LabelEditPart.VISUAL_ID));
        createCompartment(node,
                PalladioComponentModelVisualIDRegistry
                        .getType(VariableUsageVariableCharacterisation4EditPart.VISUAL_ID), true, true, true, true);
        return node;
    }

    /**
     * @generated
     */
    public Node createResourceDemandingBehaviour_3003(EObject domainElement, View containerView, int index,
            boolean persisted, PreferencesHint preferencesHint) {
        Shape node = NotationFactory.eINSTANCE.createShape();
        node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
        node.setType(PalladioComponentModelVisualIDRegistry.getType(ResourceDemandingBehaviourEditPart.VISUAL_ID));
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
        createCompartment(node,
                PalladioComponentModelVisualIDRegistry
                        .getType(ResourceDemandingBehaviourBehaviourCompartmentEditPart.VISUAL_ID), false, false,
                false, false);
        return node;
    }

    /**
     * @generated
     */
    public Node createStartAction_3004(EObject domainElement, View containerView, int index, boolean persisted,
            PreferencesHint preferencesHint) {
        Node node = NotationFactory.eINSTANCE.createNode();
        node.getStyles().add(NotationFactory.eINSTANCE.createDescriptionStyle());
        node.getStyles().add(NotationFactory.eINSTANCE.createFontStyle());
        node.getStyles().add(NotationFactory.eINSTANCE.createLineStyle());
        node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
        node.setType(PalladioComponentModelVisualIDRegistry.getType(StartAction2EditPart.VISUAL_ID));
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
        return node;
    }

    /**
     * @generated
     */
    public Node createStopAction_3005(EObject domainElement, View containerView, int index, boolean persisted,
            PreferencesHint preferencesHint) {
        Shape node = NotationFactory.eINSTANCE.createShape();
        node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
        node.setType(PalladioComponentModelVisualIDRegistry.getType(StopAction2EditPart.VISUAL_ID));
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
        return node;
    }

    /**
     * @generated
     */
    public Node createLoopAction_3006(EObject domainElement, View containerView, int index, boolean persisted,
            PreferencesHint preferencesHint) {
        Shape node = NotationFactory.eINSTANCE.createShape();
        node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
        node.setType(PalladioComponentModelVisualIDRegistry.getType(LoopAction2EditPart.VISUAL_ID));
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
        Node label5003 = createLabel(node,
                PalladioComponentModelVisualIDRegistry.getType(LoopActionEntityName2EditPart.VISUAL_ID));
        Node label5004 = createLabel(node,
                PalladioComponentModelVisualIDRegistry.getType(Loop2IterationsLabelEditPart.VISUAL_ID));
        return node;
    }

    /**
     * @generated
     */
    public Node createInternalAction_3007(EObject domainElement, View containerView, int index, boolean persisted,
            PreferencesHint preferencesHint) {
        Shape node = NotationFactory.eINSTANCE.createShape();
        node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
        node.setType(PalladioComponentModelVisualIDRegistry.getType(InternalAction2EditPart.VISUAL_ID));
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
        Node label5005 = createLabel(node,
                PalladioComponentModelVisualIDRegistry.getType(InternalActionEntityName2EditPart.VISUAL_ID));
        createCompartment(node,
                PalladioComponentModelVisualIDRegistry.getType(InternalActionResourceDemandEditPart.VISUAL_ID), true,
                true, true, true);
        createCompartment(node,
                PalladioComponentModelVisualIDRegistry
                        .getType(InternalActionFailureOccurrenceDescriptionsEditPart.VISUAL_ID), true, true, true, true);
        createCompartment(node,
                PalladioComponentModelVisualIDRegistry
                        .getType(InternalActionInfrastructureCallsCompartmentEditPart.VISUAL_ID), true, false, true,
                true);
        return node;
    }

    /**
     * @generated
     */
    public Node createParametricResourceDemand_3051(EObject domainElement, View containerView, int index,
            boolean persisted, PreferencesHint preferencesHint) {
        Node node = NotationFactory.eINSTANCE.createNode();
        node.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
        node.setType(PalladioComponentModelVisualIDRegistry.getType(ParametricResourceDemandEditPart.VISUAL_ID));
        ViewUtil.insertChildView(containerView, node, index, persisted);
        node.setElement(domainElement);
        return node;
    }

    /**
     * @generated
     */
    public Node createInternalFailureOccurrenceDescription_3050(EObject domainElement, View containerView, int index,
            boolean persisted, PreferencesHint preferencesHint) {
        Node node = NotationFactory.eINSTANCE.createNode();
        node.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
        node.setType(PalladioComponentModelVisualIDRegistry
                .getType(InternalFailureOccurrenceDescriptionEditPart.VISUAL_ID));
        ViewUtil.insertChildView(containerView, node, index, persisted);
        node.setElement(domainElement);
        return node;
    }

    /**
     * @generated
     */
    public Node createInfrastructureCall_3053(EObject domainElement, View containerView, int index, boolean persisted,
            PreferencesHint preferencesHint) {
        Shape node = NotationFactory.eINSTANCE.createShape();
        node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
        node.setType(PalladioComponentModelVisualIDRegistry.getType(InfrastructureCallEditPart.VISUAL_ID));
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
        Node label5057 = createLabel(node,
                PalladioComponentModelVisualIDRegistry.getType(WrappingLabel2EditPart.VISUAL_ID));
        Node label5058 = createLabel(node,
                PalladioComponentModelVisualIDRegistry.getType(WrappingLabel3EditPart.VISUAL_ID));
        createCompartment(node,
                PalladioComponentModelVisualIDRegistry
                        .getType(InfrastructureCallInfrastructureCallInputVariableUsagesEditPart.VISUAL_ID), true,
                false, false, false);
        return node;
    }

    /**
     * @generated
     */
    public Node createVariableUsage_3054(EObject domainElement, View containerView, int index, boolean persisted,
            PreferencesHint preferencesHint) {
        Node node = NotationFactory.eINSTANCE.createNode();
        node.getStyles().add(NotationFactory.eINSTANCE.createDescriptionStyle());
        node.getStyles().add(NotationFactory.eINSTANCE.createFontStyle());
        node.getStyles().add(NotationFactory.eINSTANCE.createLineStyle());
        node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
        node.setType(PalladioComponentModelVisualIDRegistry.getType(VariableUsage5EditPart.VISUAL_ID));
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
        Node label5050 = createLabel(node,
                PalladioComponentModelVisualIDRegistry.getType(VariableUsage5LabelEditPart.VISUAL_ID));
        createCompartment(node,
                PalladioComponentModelVisualIDRegistry
                        .getType(VariableUsageVariableCharacterisation5EditPart.VISUAL_ID), true, true, true, true);
        return node;
    }

    /**
     * @generated
     */
    public Node createBranchAction_3009(EObject domainElement, View containerView, int index, boolean persisted,
            PreferencesHint preferencesHint) {
        Shape node = NotationFactory.eINSTANCE.createShape();
        node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
        node.setType(PalladioComponentModelVisualIDRegistry.getType(BranchAction2EditPart.VISUAL_ID));
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
                PalladioComponentModelVisualIDRegistry.getType(BranchActionEntityName2EditPart.VISUAL_ID));
        createCompartment(node,
                PalladioComponentModelVisualIDRegistry
                        .getType(BranchActionBranchTransitionCompartmentEditPart.VISUAL_ID), false, false, false, false);
        return node;
    }

    /**
     * @generated
     */
    public Node createProbabilisticBranchTransition_3010(EObject domainElement, View containerView, int index,
            boolean persisted, PreferencesHint preferencesHint) {
        Shape node = NotationFactory.eINSTANCE.createShape();
        node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
        node.setType(PalladioComponentModelVisualIDRegistry.getType(ProbabilisticBranchTransitionEditPart.VISUAL_ID));
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
                PalladioComponentModelVisualIDRegistry
                        .getType(ProbabilisticBranchTransitionEntityNameEditPart.VISUAL_ID));
        Node label5037 = createLabel(node,
                PalladioComponentModelVisualIDRegistry
                        .getType(ProbabilisticBranchTransitionBranchProbabilityEditPart.VISUAL_ID));
        return node;
    }

    /**
     * @generated
     */
    public Node createResourceDemandingBehaviour_3011(EObject domainElement, View containerView, int index,
            boolean persisted, PreferencesHint preferencesHint) {
        Shape node = NotationFactory.eINSTANCE.createShape();
        node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
        node.setType(PalladioComponentModelVisualIDRegistry.getType(ResourceDemandingBehaviour2EditPart.VISUAL_ID));
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
        createCompartment(node,
                PalladioComponentModelVisualIDRegistry
                        .getType(ResourceDemandingBehaviourBehaviourCompartment2EditPart.VISUAL_ID), false, false,
                false, false);
        return node;
    }

    /**
     * @generated
     */
    public Node createExternalCallAction_3012(EObject domainElement, View containerView, int index, boolean persisted,
            PreferencesHint preferencesHint) {
        Shape node = NotationFactory.eINSTANCE.createShape();
        node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
        node.setType(PalladioComponentModelVisualIDRegistry.getType(ExternalCallAction2EditPart.VISUAL_ID));
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
        Node label5006 = createLabel(node,
                PalladioComponentModelVisualIDRegistry.getType(ExternalCallActionEntityName2EditPart.VISUAL_ID));
        createCompartment(
                node,
                PalladioComponentModelVisualIDRegistry.getType(ExternalCallActionInputVariableUsage2EditPart.VISUAL_ID),
                true, true, true, true);
        createCompartment(node,
                PalladioComponentModelVisualIDRegistry
                        .getType(ExternalCallActionOutputVariableUsage2EditPart.VISUAL_ID), true, true, true, true);
        return node;
    }

    /**
     * @generated
     */
    public Node createEmitEventAction_3046(EObject domainElement, View containerView, int index, boolean persisted,
            PreferencesHint preferencesHint) {
        Shape node = NotationFactory.eINSTANCE.createShape();
        node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
        node.setType(PalladioComponentModelVisualIDRegistry.getType(EmitEventAction2EditPart.VISUAL_ID));
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
        Node label5044 = createLabel(node,
                PalladioComponentModelVisualIDRegistry.getType(EmitEventActionEntityName2EditPart.VISUAL_ID));
        createCompartment(node,
                PalladioComponentModelVisualIDRegistry
                        .getType(EmitEventActionInputVariableUsageEvent2EditPart.VISUAL_ID), true, true, true, true);
        return node;
    }

    /**
     * @generated
     */
    public Node createAcquireAction_3026(EObject domainElement, View containerView, int index, boolean persisted,
            PreferencesHint preferencesHint) {
        Shape node = NotationFactory.eINSTANCE.createShape();
        node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
        node.setType(PalladioComponentModelVisualIDRegistry.getType(AcquireAction2EditPart.VISUAL_ID));
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
        Node label5028 = createLabel(node,
                PalladioComponentModelVisualIDRegistry.getType(AcquireActionEntityName2EditPart.VISUAL_ID));
        return node;
    }

    /**
     * @generated
     */
    public Node createReleaseAction_3020(EObject domainElement, View containerView, int index, boolean persisted,
            PreferencesHint preferencesHint) {
        Shape node = NotationFactory.eINSTANCE.createShape();
        node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
        node.setType(PalladioComponentModelVisualIDRegistry.getType(ReleaseAction2EditPart.VISUAL_ID));
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
        Node label5020 = createLabel(node,
                PalladioComponentModelVisualIDRegistry.getType(ReleaseActionEntityName2EditPart.VISUAL_ID));
        return node;
    }

    /**
     * @generated
     */
    public Node createForkAction_3023(EObject domainElement, View containerView, int index, boolean persisted,
            PreferencesHint preferencesHint) {
        Shape node = NotationFactory.eINSTANCE.createShape();
        node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
        node.setType(PalladioComponentModelVisualIDRegistry.getType(ForkAction2EditPart.VISUAL_ID));
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
        Node label5026 = createLabel(node,
                PalladioComponentModelVisualIDRegistry.getType(ForkActionEntityName2EditPart.VISUAL_ID));
        createCompartment(node,
                PalladioComponentModelVisualIDRegistry.getType(ForkActionForkedBehavioursEditPart.VISUAL_ID), false,
                true, false, false);
        return node;
    }

    /**
     * @generated
     */
    public Node createForkedBehaviour_3027(EObject domainElement, View containerView, int index, boolean persisted,
            PreferencesHint preferencesHint) {
        Shape node = NotationFactory.eINSTANCE.createShape();
        node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
        node.setType(PalladioComponentModelVisualIDRegistry.getType(ForkedBehaviourEditPart.VISUAL_ID));
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
        createCompartment(node,
                PalladioComponentModelVisualIDRegistry.getType(ForkedBehaviourBehaviourCompartmentEditPart.VISUAL_ID),
                false, false, false, false);
        return node;
    }

    /**
     * @generated
     */
    public Node createCollectionIteratorAction_3013(EObject domainElement, View containerView, int index,
            boolean persisted, PreferencesHint preferencesHint) {
        Shape node = NotationFactory.eINSTANCE.createShape();
        node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
        node.setType(PalladioComponentModelVisualIDRegistry.getType(CollectionIteratorAction2EditPart.VISUAL_ID));
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
                PalladioComponentModelVisualIDRegistry.getType(CollectionIteratorActionEntityName2EditPart.VISUAL_ID));
        Node label5014 = createLabel(node,
                PalladioComponentModelVisualIDRegistry.getType(CollectionIteratorParameterLabelEditPart.VISUAL_ID));
        return node;
    }

    /**
     * @generated
     */
    public Node createResourceDemandingBehaviour_3014(EObject domainElement, View containerView, int index,
            boolean persisted, PreferencesHint preferencesHint) {
        Shape node = NotationFactory.eINSTANCE.createShape();
        node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
        node.setType(PalladioComponentModelVisualIDRegistry.getType(ResourceDemandingBehaviour3EditPart.VISUAL_ID));
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
        createCompartment(node,
                PalladioComponentModelVisualIDRegistry
                        .getType(ResourceDemandingBehaviourBehaviourCompartment3EditPart.VISUAL_ID), false, false,
                false, false);
        return node;
    }

    /**
     * @generated
     */
    public Node createRecoveryAction_3061(EObject domainElement, View containerView, int index, boolean persisted,
            PreferencesHint preferencesHint) {
        Shape node = NotationFactory.eINSTANCE.createShape();
        node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
        node.setType(PalladioComponentModelVisualIDRegistry.getType(RecoveryAction2EditPart.VISUAL_ID));
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
        Node label5060 = createLabel(node,
                PalladioComponentModelVisualIDRegistry.getType(RecoveryActionEntityName2EditPart.VISUAL_ID));
        createCompartment(node,
                PalladioComponentModelVisualIDRegistry
                        .getType(RecoveryActionRecoveryBlockCompartmentEditPart.VISUAL_ID), false, false, false, false);
        return node;
    }

    /**
     * @generated
     */
    public Node createRecoveryActionBehaviour_3062(EObject domainElement, View containerView, int index,
            boolean persisted, PreferencesHint preferencesHint) {
        Shape node = NotationFactory.eINSTANCE.createShape();
        node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
        node.setType(PalladioComponentModelVisualIDRegistry.getType(RecoveryActionBehaviourEditPart.VISUAL_ID));
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
        Node label5059 = createLabel(node,
                PalladioComponentModelVisualIDRegistry.getType(RecoveryActionBehaviourEntityNameEditPart.VISUAL_ID));
        createCompartment(node,
                PalladioComponentModelVisualIDRegistry
                        .getType(RecoveryActionBehaviourAlternativeBehaviourCompartmentEditPart.VISUAL_ID), false,
                false, false, false);
        return node;
    }

    /**
     * @generated
     */
    public Node createSynchronisationPoint_3038(EObject domainElement, View containerView, int index,
            boolean persisted, PreferencesHint preferencesHint) {
        Shape node = NotationFactory.eINSTANCE.createShape();
        node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
        node.setType(PalladioComponentModelVisualIDRegistry.getType(SynchronisationPointEditPart.VISUAL_ID));
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
        createCompartment(node,
                PalladioComponentModelVisualIDRegistry
                        .getType(SynchronisationPointSynchronisationPointEditPart.VISUAL_ID), false, false, false,
                false);
        return node;
    }

    /**
     * @generated
     */
    public Node createForkedBehaviour_3039(EObject domainElement, View containerView, int index, boolean persisted,
            PreferencesHint preferencesHint) {
        Shape node = NotationFactory.eINSTANCE.createShape();
        node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
        node.setType(PalladioComponentModelVisualIDRegistry.getType(ForkedBehaviour2EditPart.VISUAL_ID));
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
        createCompartment(node,
                PalladioComponentModelVisualIDRegistry
                        .getType(ForkedBehaviourSynchronisationPointForkedBehavioursEditPart.VISUAL_ID), false, false,
                false, false);
        return node;
    }

    /**
     * @generated
     */
    public Node createSetVariableAction_3024(EObject domainElement, View containerView, int index, boolean persisted,
            PreferencesHint preferencesHint) {
        Shape node = NotationFactory.eINSTANCE.createShape();
        node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
        node.setType(PalladioComponentModelVisualIDRegistry.getType(SetVariableAction2EditPart.VISUAL_ID));
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
        Node label5027 = createLabel(node,
                PalladioComponentModelVisualIDRegistry.getType(SetVariableActionEntityName2EditPart.VISUAL_ID));
        createCompartment(node,
                PalladioComponentModelVisualIDRegistry.getType(SetVariableActionVariableSetterEditPart.VISUAL_ID),
                true, true, true, true);
        return node;
    }

    /**
     * @generated
     */
    public Node createVariableUsage_3036(EObject domainElement, View containerView, int index, boolean persisted,
            PreferencesHint preferencesHint) {
        Node node = NotationFactory.eINSTANCE.createNode();
        node.getStyles().add(NotationFactory.eINSTANCE.createDescriptionStyle());
        node.getStyles().add(NotationFactory.eINSTANCE.createFontStyle());
        node.getStyles().add(NotationFactory.eINSTANCE.createLineStyle());
        node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
        node.setType(PalladioComponentModelVisualIDRegistry.getType(VariableUsage3EditPart.VISUAL_ID));
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
        Node label5035 = createLabel(node,
                PalladioComponentModelVisualIDRegistry.getType(VariableUsage3LabelEditPart.VISUAL_ID));
        createCompartment(node,
                PalladioComponentModelVisualIDRegistry
                        .getType(VariableUsageVariableCharacterisation3EditPart.VISUAL_ID), true, true, true, true);
        return node;
    }

    /**
     * @generated
     */
    public Node createVariableCharacterisation_3055(EObject domainElement, View containerView, int index,
            boolean persisted, PreferencesHint preferencesHint) {
        Node node = NotationFactory.eINSTANCE.createNode();
        node.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
        node.setType(PalladioComponentModelVisualIDRegistry.getType(VariableCharacterisation5EditPart.VISUAL_ID));
        ViewUtil.insertChildView(containerView, node, index, persisted);
        node.setElement(domainElement);
        return node;
    }

    /**
     * @generated
     */
    public Node createVariableCharacterisation_3048(EObject domainElement, View containerView, int index,
            boolean persisted, PreferencesHint preferencesHint) {
        Node node = NotationFactory.eINSTANCE.createNode();
        node.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
        node.setType(PalladioComponentModelVisualIDRegistry.getType(VariableCharacterisation4EditPart.VISUAL_ID));
        ViewUtil.insertChildView(containerView, node, index, persisted);
        node.setElement(domainElement);
        return node;
    }

    /**
     * @generated
     */
    public Node createVariableCharacterisation_3037(EObject domainElement, View containerView, int index,
            boolean persisted, PreferencesHint preferencesHint) {
        Node node = NotationFactory.eINSTANCE.createNode();
        node.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
        node.setType(PalladioComponentModelVisualIDRegistry.getType(VariableCharacterisation3EditPart.VISUAL_ID));
        ViewUtil.insertChildView(containerView, node, index, persisted);
        node.setElement(domainElement);
        return node;
    }

    /**
     * @generated
     */
    public Node createGuardedBranchTransition_3017(EObject domainElement, View containerView, int index,
            boolean persisted, PreferencesHint preferencesHint) {
        Shape node = NotationFactory.eINSTANCE.createShape();
        node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
        node.setType(PalladioComponentModelVisualIDRegistry.getType(GuardedBranchTransitionEditPart.VISUAL_ID));
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
                PalladioComponentModelVisualIDRegistry.getType(GuardedBranchTransitionEntityNameEditPart.VISUAL_ID));
        Node label5036 = createLabel(node,
                PalladioComponentModelVisualIDRegistry.getType(GuardedBranchTransitionIdEditPart.VISUAL_ID));
        return node;
    }

    /**
     * @generated
     */
    public Node createResourceDemandingBehaviour_3018(EObject domainElement, View containerView, int index,
            boolean persisted, PreferencesHint preferencesHint) {
        Shape node = NotationFactory.eINSTANCE.createShape();
        node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
        node.setType(PalladioComponentModelVisualIDRegistry.getType(ResourceDemandingBehaviour4EditPart.VISUAL_ID));
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
        createCompartment(node,
                PalladioComponentModelVisualIDRegistry
                        .getType(ResourceDemandingBehaviourBehaviourCompartment4EditPart.VISUAL_ID), false, false,
                false, false);
        return node;
    }

    /**
     * @generated
     */
    public Edge createAbstractActionSuccessor_AbstractAction_4001(View containerView, int index, boolean persisted,
            PreferencesHint preferencesHint) {
        Connector edge = NotationFactory.eINSTANCE.createConnector();
        edge.getStyles().add(NotationFactory.eINSTANCE.createFontStyle());
        RelativeBendpoints bendpoints = NotationFactory.eINSTANCE.createRelativeBendpoints();
        ArrayList<RelativeBendpoint> points = new ArrayList<RelativeBendpoint>(2);
        points.add(new RelativeBendpoint());
        points.add(new RelativeBendpoint());
        bendpoints.setPoints(points);
        edge.setBendpoints(bendpoints);
        ViewUtil.insertChildView(containerView, edge, index, persisted);
        edge.setType(PalladioComponentModelVisualIDRegistry
                .getType(AbstractActionSuccessor_AbstractActionEditPart.VISUAL_ID));
        edge.setElement(null);
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
    public Edge createRecoveryActionBehaviourFailureHandlingAlternatives__RecoveryActionBehaviour_4004(
            View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
        Connector edge = NotationFactory.eINSTANCE.createConnector();
        edge.getStyles().add(NotationFactory.eINSTANCE.createFontStyle());
        RelativeBendpoints bendpoints = NotationFactory.eINSTANCE.createRelativeBendpoints();
        ArrayList<RelativeBendpoint> points = new ArrayList<RelativeBendpoint>(2);
        points.add(new RelativeBendpoint());
        points.add(new RelativeBendpoint());
        bendpoints.setPoints(points);
        edge.setBendpoints(bendpoints);
        ViewUtil.insertChildView(containerView, edge, index, persisted);
        edge.setType(PalladioComponentModelVisualIDRegistry
                .getType(RecoveryActionBehaviourFailureHandlingAlternatives__RecoveryActionBehaviourEditPart.VISUAL_ID));
        edge.setElement(null);
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
    private void stampShortcut(View containerView, Node target) {
        if (!ResourceDemandingSEFFEditPart.MODEL_ID.equals(PalladioComponentModelVisualIDRegistry
                .getModelID(containerView))) {
            EAnnotation shortcutAnnotation = EcoreFactory.eINSTANCE.createEAnnotation();
            shortcutAnnotation.setSource("Shortcut"); //$NON-NLS-1$
            shortcutAnnotation.getDetails().put("modelID", ResourceDemandingSEFFEditPart.MODEL_ID); //$NON-NLS-1$
            target.getEAnnotations().add(shortcutAnnotation);
        }
    }

    /**
     * @generated
     */
    private Node createLabel(View owner, String hint) {
        DecorationNode rv = NotationFactory.eINSTANCE.createDecorationNode();
        rv.setType(hint);
        ViewUtil.insertChildView(owner, rv, ViewUtil.APPEND, true);
        return rv;
    }

    /**
     * @generated
     */
    private Node createCompartment(View owner, String hint, boolean canCollapse, boolean hasTitle, boolean canSort,
            boolean canFilter) {
        //SemanticListCompartment rv = NotationFactory.eINSTANCE.createSemanticListCompartment();
        //rv.setShowTitle(showTitle);
        //rv.setCollapsed(isCollapsed);
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
     * @generated
     */
    private IElementType getSemanticElementType(IAdaptable semanticAdapter) {
        if (semanticAdapter == null) {
            return null;
        }
        return (IElementType) semanticAdapter.getAdapter(IElementType.class);
    }

}
