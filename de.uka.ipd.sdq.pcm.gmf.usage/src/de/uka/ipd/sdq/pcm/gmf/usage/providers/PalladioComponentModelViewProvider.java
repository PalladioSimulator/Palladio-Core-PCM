/*
 *Copyright 2007, SDQ, IPD, University of Karlsruhe
 */
package de.uka.ipd.sdq.pcm.gmf.usage.providers;

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

import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.AbstractUserActionSuccessorEditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.BranchEditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.BranchTransitionBranchProbabilityEditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.BranchTransitionEditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.BranchUsageBranchTransitionsCompartmentEditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.ClosedWorkloadEditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.ClosedWorkloadPopulationEditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.ClosedWorkloadThinkTimeLabelEditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.ClosedWorkloadTitleLabelEditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.ComponentExternalCallNameLabelEditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.DelayEditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.DelayEntityNameEditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.DelayLabelSpecEditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.EntryLevelSystemCallEditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.EntryLevelSystemCallParameterUsageEditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.LoopEditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.OpenWorkloadEditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.OpenWorkloadSpecLabelEditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.ScenarioBehaviour2EditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.ScenarioBehaviour3EditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.ScenarioBehaviourEditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.ScenarioBehaviourScenarioBehaviourStepsCompartment2EditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.ScenarioBehaviourScenarioBehaviourStepsCompartment3EditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.ScenarioBehaviourScenarioBehaviourStepsCompartmentEditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.StartEditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.StopEditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.UsageLoopIterationsLabelEditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.UsageScenario2EditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.UsageScenarioEditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.UsageScenarioLabelEditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.UsageScenarioUsageScenarioCompartmentEditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.VariableCharacterisationEditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.VariableUsageEditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.VariableUsageVariableCharacterisationEditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.WrappingLabelEditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.part.PalladioComponentModelVisualIDRegistry;

/**
 * The Class PalladioComponentModelViewProvider.
 *
 * @generated
 */
public class PalladioComponentModelViewProvider extends AbstractProvider implements IViewProvider {

    /**
     * Provides.
     *
     * @param operation the operation
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
     * @param op the op
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
     * @param op the op
     * @return true, if successful
     * @generated
     */
    protected boolean provides(CreateDiagramViewOperation op) {
        return UsageScenarioEditPart.MODEL_ID.equals(op.getSemanticHint())
                && PalladioComponentModelVisualIDRegistry
                        .getDiagramVisualID(getSemanticElement(op.getSemanticAdapter())) != -1;
    }

    /**
     * Provides.
     *
     * @param op the op
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
                if (!UsageScenarioEditPart.MODEL_ID.equals(PalladioComponentModelVisualIDRegistry.getModelID(op
                        .getContainerView()))) {
                    return false; // foreign diagram
                }
                switch (visualID) {
                case UsageScenario2EditPart.VISUAL_ID:
                case ScenarioBehaviourEditPart.VISUAL_ID:
                case StartEditPart.VISUAL_ID:
                case StopEditPart.VISUAL_ID:
                case EntryLevelSystemCallEditPart.VISUAL_ID:
                case VariableUsageEditPart.VISUAL_ID:
                case VariableCharacterisationEditPart.VISUAL_ID:
                case LoopEditPart.VISUAL_ID:
                case BranchEditPart.VISUAL_ID:
                case BranchTransitionEditPart.VISUAL_ID:
                case DelayEditPart.VISUAL_ID:
                case ClosedWorkloadEditPart.VISUAL_ID:
                case OpenWorkloadEditPart.VISUAL_ID:
                case ScenarioBehaviour2EditPart.VISUAL_ID:
                case ScenarioBehaviour3EditPart.VISUAL_ID:
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
        return UsageScenario2EditPart.VISUAL_ID == visualID || ScenarioBehaviourEditPart.VISUAL_ID == visualID
                || StartEditPart.VISUAL_ID == visualID || StopEditPart.VISUAL_ID == visualID
                || EntryLevelSystemCallEditPart.VISUAL_ID == visualID || VariableUsageEditPart.VISUAL_ID == visualID
                || VariableCharacterisationEditPart.VISUAL_ID == visualID || LoopEditPart.VISUAL_ID == visualID
                || ScenarioBehaviour2EditPart.VISUAL_ID == visualID || BranchEditPart.VISUAL_ID == visualID
                || BranchTransitionEditPart.VISUAL_ID == visualID || ScenarioBehaviour3EditPart.VISUAL_ID == visualID
                || DelayEditPart.VISUAL_ID == visualID || ClosedWorkloadEditPart.VISUAL_ID == visualID
                || OpenWorkloadEditPart.VISUAL_ID == visualID;
    }

    /**
     * Provides.
     *
     * @param op the op
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
     * @param semanticAdapter the semantic adapter
     * @param diagramKind the diagram kind
     * @param preferencesHint the preferences hint
     * @return the diagram
     * @generated
     */
    public Diagram createDiagram(IAdaptable semanticAdapter, String diagramKind, PreferencesHint preferencesHint) {
        Diagram diagram = NotationFactory.eINSTANCE.createDiagram();
        diagram.getStyles().add(NotationFactory.eINSTANCE.createDiagramStyle());
        diagram.setType(UsageScenarioEditPart.MODEL_ID);
        diagram.setElement(getSemanticElement(semanticAdapter));
        diagram.setMeasurementUnit(MeasurementUnit.PIXEL_LITERAL);
        return diagram;
    }

    /**
     * Creates the node.
     *
     * @param semanticAdapter the semantic adapter
     * @param containerView the container view
     * @param semanticHint the semantic hint
     * @param index the index
     * @param persisted the persisted
     * @param preferencesHint the preferences hint
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
        case UsageScenario2EditPart.VISUAL_ID:
            return createUsageScenario_2004(domainElement, containerView, index, persisted, preferencesHint);
        case ScenarioBehaviourEditPart.VISUAL_ID:
            return createScenarioBehaviour_3014(domainElement, containerView, index, persisted, preferencesHint);
        case StartEditPart.VISUAL_ID:
            return createStart_3001(domainElement, containerView, index, persisted, preferencesHint);
        case StopEditPart.VISUAL_ID:
            return createStop_3002(domainElement, containerView, index, persisted, preferencesHint);
        case EntryLevelSystemCallEditPart.VISUAL_ID:
            return createEntryLevelSystemCall_3003(domainElement, containerView, index, persisted, preferencesHint);
        case VariableUsageEditPart.VISUAL_ID:
            return createVariableUsage_3012(domainElement, containerView, index, persisted, preferencesHint);
        case VariableCharacterisationEditPart.VISUAL_ID:
            return createVariableCharacterisation_3013(domainElement, containerView, index, persisted, preferencesHint);
        case LoopEditPart.VISUAL_ID:
            return createLoop_3005(domainElement, containerView, index, persisted, preferencesHint);
        case ScenarioBehaviour2EditPart.VISUAL_ID:
            return createScenarioBehaviour_3007(domainElement, containerView, index, persisted, preferencesHint);
        case BranchEditPart.VISUAL_ID:
            return createBranch_3008(domainElement, containerView, index, persisted, preferencesHint);
        case BranchTransitionEditPart.VISUAL_ID:
            return createBranchTransition_3009(domainElement, containerView, index, persisted, preferencesHint);
        case ScenarioBehaviour3EditPart.VISUAL_ID:
            return createScenarioBehaviour_3010(domainElement, containerView, index, persisted, preferencesHint);
        case DelayEditPart.VISUAL_ID:
            return createDelay_3017(domainElement, containerView, index, persisted, preferencesHint);
        case ClosedWorkloadEditPart.VISUAL_ID:
            return createClosedWorkload_3015(domainElement, containerView, index, persisted, preferencesHint);
        case OpenWorkloadEditPart.VISUAL_ID:
            return createOpenWorkload_3016(domainElement, containerView, index, persisted, preferencesHint);
        }
        // can't happen, provided #provides(CreateNodeViewOperation) is correct
        return null;
    }

    /**
     * Creates the edge.
     *
     * @param semanticAdapter the semantic adapter
     * @param containerView the container view
     * @param semanticHint the semantic hint
     * @param index the index
     * @param persisted the persisted
     * @param preferencesHint the preferences hint
     * @return the edge
     * @generated
     */
    public Edge createEdge(IAdaptable semanticAdapter, View containerView, String semanticHint, int index,
            boolean persisted, PreferencesHint preferencesHint) {
        IElementType elementType = getSemanticElementType(semanticAdapter);
        String elementTypeHint = ((IHintedType) elementType).getSemanticHint();
        switch (PalladioComponentModelVisualIDRegistry.getVisualID(elementTypeHint)) {
        case AbstractUserActionSuccessorEditPart.VISUAL_ID:
            return createAbstractUserActionSuccessor_4002(containerView, index, persisted, preferencesHint);
        }
        // can never happen, provided #provides(CreateEdgeViewOperation) is correct
        return null;
    }

    /**
     * Creates the usage scenario_2004.
     *
     * @param domainElement the domain element
     * @param containerView the container view
     * @param index the index
     * @param persisted the persisted
     * @param preferencesHint the preferences hint
     * @return the node
     * @generated
     */
    public Node createUsageScenario_2004(EObject domainElement, View containerView, int index, boolean persisted,
            PreferencesHint preferencesHint) {
        Node node = NotationFactory.eINSTANCE.createNode();
        node.getStyles().add(NotationFactory.eINSTANCE.createDescriptionStyle());
        node.getStyles().add(NotationFactory.eINSTANCE.createFontStyle());
        node.getStyles().add(NotationFactory.eINSTANCE.createFillStyle());
        node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
        node.setType(PalladioComponentModelVisualIDRegistry.getType(UsageScenario2EditPart.VISUAL_ID));
        ViewUtil.insertChildView(containerView, node, index, persisted);
        node.setElement(domainElement);
        stampShortcut(containerView, node);
        // initializeFromPreferences
        final IPreferenceStore prefStore = (IPreferenceStore) preferencesHint.getPreferenceStore();
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
                PalladioComponentModelVisualIDRegistry.getType(UsageScenarioLabelEditPart.VISUAL_ID));
        createCompartment(
                node,
                PalladioComponentModelVisualIDRegistry.getType(UsageScenarioUsageScenarioCompartmentEditPart.VISUAL_ID),
                false, false, false, false);
        return node;
    }

    /**
     * Creates the scenario behaviour_3014.
     *
     * @param domainElement the domain element
     * @param containerView the container view
     * @param index the index
     * @param persisted the persisted
     * @param preferencesHint the preferences hint
     * @return the node
     * @generated
     */
    public Node createScenarioBehaviour_3014(EObject domainElement, View containerView, int index, boolean persisted,
            PreferencesHint preferencesHint) {
        Shape node = NotationFactory.eINSTANCE.createShape();
        node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
        node.setType(PalladioComponentModelVisualIDRegistry.getType(ScenarioBehaviourEditPart.VISUAL_ID));
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
                        .getType(ScenarioBehaviourScenarioBehaviourStepsCompartmentEditPart.VISUAL_ID), false, false,
                false, false);
        return node;
    }

    /**
     * Creates the start_3001.
     *
     * @param domainElement the domain element
     * @param containerView the container view
     * @param index the index
     * @param persisted the persisted
     * @param preferencesHint the preferences hint
     * @return the node
     * @generated
     */
    public Node createStart_3001(EObject domainElement, View containerView, int index, boolean persisted,
            PreferencesHint preferencesHint) {
        Node node = NotationFactory.eINSTANCE.createNode();
        node.getStyles().add(NotationFactory.eINSTANCE.createDescriptionStyle());
        node.getStyles().add(NotationFactory.eINSTANCE.createFontStyle());
        node.getStyles().add(NotationFactory.eINSTANCE.createLineStyle());
        node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
        node.setType(PalladioComponentModelVisualIDRegistry.getType(StartEditPart.VISUAL_ID));
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
     * Creates the stop_3002.
     *
     * @param domainElement the domain element
     * @param containerView the container view
     * @param index the index
     * @param persisted the persisted
     * @param preferencesHint the preferences hint
     * @return the node
     * @generated
     */
    public Node createStop_3002(EObject domainElement, View containerView, int index, boolean persisted,
            PreferencesHint preferencesHint) {
        Shape node = NotationFactory.eINSTANCE.createShape();
        node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
        node.setType(PalladioComponentModelVisualIDRegistry.getType(StopEditPart.VISUAL_ID));
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
     * Creates the entry level system call_3003.
     *
     * @param domainElement the domain element
     * @param containerView the container view
     * @param index the index
     * @param persisted the persisted
     * @param preferencesHint the preferences hint
     * @return the node
     * @generated
     */
    public Node createEntryLevelSystemCall_3003(EObject domainElement, View containerView, int index,
            boolean persisted, PreferencesHint preferencesHint) {
        Shape node = NotationFactory.eINSTANCE.createShape();
        node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
        node.setType(PalladioComponentModelVisualIDRegistry.getType(EntryLevelSystemCallEditPart.VISUAL_ID));
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
        Node label5004 = createLabel(node,
                PalladioComponentModelVisualIDRegistry.getType(ComponentExternalCallNameLabelEditPart.VISUAL_ID));
        createCompartment(node,
                PalladioComponentModelVisualIDRegistry.getType(EntryLevelSystemCallParameterUsageEditPart.VISUAL_ID),
                false, false, true, true);
        return node;
    }

    /**
     * Creates the variable usage_3012.
     *
     * @param domainElement the domain element
     * @param containerView the container view
     * @param index the index
     * @param persisted the persisted
     * @param preferencesHint the preferences hint
     * @return the node
     * @generated
     */
    public Node createVariableUsage_3012(EObject domainElement, View containerView, int index, boolean persisted,
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
        Node label5012 = createLabel(node,
                PalladioComponentModelVisualIDRegistry.getType(WrappingLabelEditPart.VISUAL_ID));
        createCompartment(
                node,
                PalladioComponentModelVisualIDRegistry.getType(VariableUsageVariableCharacterisationEditPart.VISUAL_ID),
                true, true, true, true);
        return node;
    }

    /**
     * Creates the variable characterisation_3013.
     *
     * @param domainElement the domain element
     * @param containerView the container view
     * @param index the index
     * @param persisted the persisted
     * @param preferencesHint the preferences hint
     * @return the node
     * @generated
     */
    public Node createVariableCharacterisation_3013(EObject domainElement, View containerView, int index,
            boolean persisted, PreferencesHint preferencesHint) {
        Node node = NotationFactory.eINSTANCE.createNode();
        node.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
        node.setType(PalladioComponentModelVisualIDRegistry.getType(VariableCharacterisationEditPart.VISUAL_ID));
        ViewUtil.insertChildView(containerView, node, index, persisted);
        node.setElement(domainElement);
        return node;
    }

    /**
     * Creates the loop_3005.
     *
     * @param domainElement the domain element
     * @param containerView the container view
     * @param index the index
     * @param persisted the persisted
     * @param preferencesHint the preferences hint
     * @return the node
     * @generated
     */
    public Node createLoop_3005(EObject domainElement, View containerView, int index, boolean persisted,
            PreferencesHint preferencesHint) {
        Shape node = NotationFactory.eINSTANCE.createShape();
        node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
        node.setType(PalladioComponentModelVisualIDRegistry.getType(LoopEditPart.VISUAL_ID));
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
                PalladioComponentModelVisualIDRegistry.getType(UsageLoopIterationsLabelEditPart.VISUAL_ID));
        return node;
    }

    /**
     * Creates the scenario behaviour_3007.
     *
     * @param domainElement the domain element
     * @param containerView the container view
     * @param index the index
     * @param persisted the persisted
     * @param preferencesHint the preferences hint
     * @return the node
     * @generated
     */
    public Node createScenarioBehaviour_3007(EObject domainElement, View containerView, int index, boolean persisted,
            PreferencesHint preferencesHint) {
        Shape node = NotationFactory.eINSTANCE.createShape();
        node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
        node.setType(PalladioComponentModelVisualIDRegistry.getType(ScenarioBehaviour2EditPart.VISUAL_ID));
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
                        .getType(ScenarioBehaviourScenarioBehaviourStepsCompartment2EditPart.VISUAL_ID), false, false,
                false, false);
        return node;
    }

    /**
     * Creates the branch_3008.
     *
     * @param domainElement the domain element
     * @param containerView the container view
     * @param index the index
     * @param persisted the persisted
     * @param preferencesHint the preferences hint
     * @return the node
     * @generated
     */
    public Node createBranch_3008(EObject domainElement, View containerView, int index, boolean persisted,
            PreferencesHint preferencesHint) {
        Shape node = NotationFactory.eINSTANCE.createShape();
        node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
        node.setType(PalladioComponentModelVisualIDRegistry.getType(BranchEditPart.VISUAL_ID));
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
                        .getType(BranchUsageBranchTransitionsCompartmentEditPart.VISUAL_ID), false, false, false, false);
        return node;
    }

    /**
     * Creates the branch transition_3009.
     *
     * @param domainElement the domain element
     * @param containerView the container view
     * @param index the index
     * @param persisted the persisted
     * @param preferencesHint the preferences hint
     * @return the node
     * @generated
     */
    public Node createBranchTransition_3009(EObject domainElement, View containerView, int index, boolean persisted,
            PreferencesHint preferencesHint) {
        Shape node = NotationFactory.eINSTANCE.createShape();
        node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
        node.setType(PalladioComponentModelVisualIDRegistry.getType(BranchTransitionEditPart.VISUAL_ID));
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
                PalladioComponentModelVisualIDRegistry.getType(BranchTransitionBranchProbabilityEditPart.VISUAL_ID));
        return node;
    }

    /**
     * Creates the scenario behaviour_3010.
     *
     * @param domainElement the domain element
     * @param containerView the container view
     * @param index the index
     * @param persisted the persisted
     * @param preferencesHint the preferences hint
     * @return the node
     * @generated
     */
    public Node createScenarioBehaviour_3010(EObject domainElement, View containerView, int index, boolean persisted,
            PreferencesHint preferencesHint) {
        Shape node = NotationFactory.eINSTANCE.createShape();
        node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
        node.setType(PalladioComponentModelVisualIDRegistry.getType(ScenarioBehaviour3EditPart.VISUAL_ID));
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
                        .getType(ScenarioBehaviourScenarioBehaviourStepsCompartment3EditPart.VISUAL_ID), false, false,
                false, false);
        return node;
    }

    /**
     * Creates the delay_3017.
     *
     * @param domainElement the domain element
     * @param containerView the container view
     * @param index the index
     * @param persisted the persisted
     * @param preferencesHint the preferences hint
     * @return the node
     * @generated
     */
    public Node createDelay_3017(EObject domainElement, View containerView, int index, boolean persisted,
            PreferencesHint preferencesHint) {
        Shape node = NotationFactory.eINSTANCE.createShape();
        node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
        node.setType(PalladioComponentModelVisualIDRegistry.getType(DelayEditPart.VISUAL_ID));
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
                PalladioComponentModelVisualIDRegistry.getType(DelayEntityNameEditPart.VISUAL_ID));
        Node label5019 = createLabel(node,
                PalladioComponentModelVisualIDRegistry.getType(DelayLabelSpecEditPart.VISUAL_ID));
        return node;
    }

    /**
     * Creates the closed workload_3015.
     *
     * @param domainElement the domain element
     * @param containerView the container view
     * @param index the index
     * @param persisted the persisted
     * @param preferencesHint the preferences hint
     * @return the node
     * @generated
     */
    public Node createClosedWorkload_3015(EObject domainElement, View containerView, int index, boolean persisted,
            PreferencesHint preferencesHint) {
        Node node = NotationFactory.eINSTANCE.createNode();
        node.getStyles().add(NotationFactory.eINSTANCE.createDescriptionStyle());
        node.getStyles().add(NotationFactory.eINSTANCE.createFontStyle());
        node.getStyles().add(NotationFactory.eINSTANCE.createLineStyle());
        node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
        node.setType(PalladioComponentModelVisualIDRegistry.getType(ClosedWorkloadEditPart.VISUAL_ID));
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
        Node label5013 = createLabel(node,
                PalladioComponentModelVisualIDRegistry.getType(ClosedWorkloadPopulationEditPart.VISUAL_ID));
        Node label5014 = createLabel(node,
                PalladioComponentModelVisualIDRegistry.getType(ClosedWorkloadTitleLabelEditPart.VISUAL_ID));
        Node label5015 = createLabel(node,
                PalladioComponentModelVisualIDRegistry.getType(ClosedWorkloadThinkTimeLabelEditPart.VISUAL_ID));
        return node;
    }

    /**
     * Creates the open workload_3016.
     *
     * @param domainElement the domain element
     * @param containerView the container view
     * @param index the index
     * @param persisted the persisted
     * @param preferencesHint the preferences hint
     * @return the node
     * @generated
     */
    public Node createOpenWorkload_3016(EObject domainElement, View containerView, int index, boolean persisted,
            PreferencesHint preferencesHint) {
        Node node = NotationFactory.eINSTANCE.createNode();
        node.getStyles().add(NotationFactory.eINSTANCE.createDescriptionStyle());
        node.getStyles().add(NotationFactory.eINSTANCE.createFontStyle());
        node.getStyles().add(NotationFactory.eINSTANCE.createLineStyle());
        node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
        node.setType(PalladioComponentModelVisualIDRegistry.getType(OpenWorkloadEditPart.VISUAL_ID));
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
        Node label5016 = createLabel(node,
                PalladioComponentModelVisualIDRegistry.getType(OpenWorkloadSpecLabelEditPart.VISUAL_ID));
        return node;
    }

    /**
     * Creates the abstract user action successor_4002.
     *
     * @param containerView the container view
     * @param index the index
     * @param persisted the persisted
     * @param preferencesHint the preferences hint
     * @return the edge
     * @generated
     */
    public Edge createAbstractUserActionSuccessor_4002(View containerView, int index, boolean persisted,
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
        edge.setType(PalladioComponentModelVisualIDRegistry.getType(AbstractUserActionSuccessorEditPart.VISUAL_ID));
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
     * Stamp shortcut.
     *
     * @param containerView the container view
     * @param target the target
     * @generated
     */
    private void stampShortcut(View containerView, Node target) {
        if (!UsageScenarioEditPart.MODEL_ID.equals(PalladioComponentModelVisualIDRegistry.getModelID(containerView))) {
            EAnnotation shortcutAnnotation = EcoreFactory.eINSTANCE.createEAnnotation();
            shortcutAnnotation.setSource("Shortcut"); //$NON-NLS-1$
            shortcutAnnotation.getDetails().put("modelID", UsageScenarioEditPart.MODEL_ID); //$NON-NLS-1$
            target.getEAnnotations().add(shortcutAnnotation);
        }
    }

    /**
     * Creates the label.
     *
     * @param owner the owner
     * @param hint the hint
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
     * @param owner the owner
     * @param hint the hint
     * @param canCollapse the can collapse
     * @param hasTitle the has title
     * @param canSort the can sort
     * @param canFilter the can filter
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
     * @param semanticAdapter the semantic adapter
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
     * @param semanticAdapter the semantic adapter
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
