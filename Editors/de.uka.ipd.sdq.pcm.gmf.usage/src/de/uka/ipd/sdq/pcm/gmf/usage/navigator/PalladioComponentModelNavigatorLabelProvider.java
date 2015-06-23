/*
 * Copyright 2007, SDQ, IPD, University of Karlsruhe
 */
package de.uka.ipd.sdq.pcm.gmf.usage.navigator;

import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;
import org.eclipse.gmf.runtime.common.ui.services.parser.ParserOptions;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.jface.viewers.ITreePathLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.TreePath;
import org.eclipse.jface.viewers.ViewerLabel;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.navigator.ICommonContentExtensionSite;
import org.eclipse.ui.navigator.ICommonLabelProvider;

import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.AbstractUserActionSuccessorEditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.BranchEditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.BranchTransitionBranchProbabilityEditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.BranchTransitionEditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.ClosedWorkloadEditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.ClosedWorkloadPopulationEditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.ComponentExternalCallNameLabelEditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.DelayEditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.DelayEntityNameEditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.EntryLevelSystemCallEditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.LoopEditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.OpenWorkloadEditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.OpenWorkloadSpecLabelEditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.ScenarioBehaviour2EditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.ScenarioBehaviour3EditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.ScenarioBehaviourEditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.StartEditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.StopEditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.UsageLoopIterationsLabelEditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.UsageScenario2EditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.UsageScenarioEditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.UsageScenarioLabelEditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.VariableCharacterisationEditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.VariableUsageEditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.WrappingLabelEditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.part.PalladioComponentModelUsageDiagramEditorPlugin;
import de.uka.ipd.sdq.pcm.gmf.usage.part.PalladioComponentModelVisualIDRegistry;
import de.uka.ipd.sdq.pcm.gmf.usage.providers.PalladioComponentModelElementTypes;
import de.uka.ipd.sdq.pcm.gmf.usage.providers.PalladioComponentModelParserProvider;
import org.palladiosimulator.pcm.usagemodel.Branch;
import org.palladiosimulator.pcm.usagemodel.ScenarioBehaviour;
import org.palladiosimulator.pcm.usagemodel.Start;
import org.palladiosimulator.pcm.usagemodel.Stop;

/**
 * @generated
 */
public class PalladioComponentModelNavigatorLabelProvider extends LabelProvider implements ICommonLabelProvider,
        ITreePathLabelProvider {

    /**
     * @generated
     */
    static {
        PalladioComponentModelUsageDiagramEditorPlugin.getInstance().getImageRegistry()
                .put("Navigator?UnknownElement", ImageDescriptor.getMissingImageDescriptor()); //$NON-NLS-1$
        PalladioComponentModelUsageDiagramEditorPlugin.getInstance().getImageRegistry()
                .put("Navigator?ImageNotFound", ImageDescriptor.getMissingImageDescriptor()); //$NON-NLS-1$
    }

    /**
     * @generated
     */
    public void updateLabel(ViewerLabel label, TreePath elementPath) {
        Object element = elementPath.getLastSegment();
        if (element instanceof PalladioComponentModelNavigatorItem
                && !isOwnView(((PalladioComponentModelNavigatorItem) element).getView())) {
            return;
        }
        label.setText(getText(element));
        label.setImage(getImage(element));
    }

    /**
     * @generated
     */
    public Image getImage(Object element) {
        if (element instanceof PalladioComponentModelNavigatorGroup) {
            PalladioComponentModelNavigatorGroup group = (PalladioComponentModelNavigatorGroup) element;
            return PalladioComponentModelUsageDiagramEditorPlugin.getInstance().getBundledImage(group.getIcon());
        }

        if (element instanceof PalladioComponentModelNavigatorItem) {
            PalladioComponentModelNavigatorItem navigatorItem = (PalladioComponentModelNavigatorItem) element;
            if (!isOwnView(navigatorItem.getView())) {
                return super.getImage(element);
            }
            return getImage(navigatorItem.getView());
        }

        return super.getImage(element);
    }

    /**
     * @generated
     */
    public Image getImage(View view) {
        switch (PalladioComponentModelVisualIDRegistry.getVisualID(view)) {
        case DelayEditPart.VISUAL_ID:
            return getImage(
                    "Navigator?Node?http://sdq.ipd.uka.de/PalladioComponentModel/UsageModel/5.0?Delay", PalladioComponentModelElementTypes.Delay_3017); //$NON-NLS-1$
        case VariableUsageEditPart.VISUAL_ID:
            return getImage(
                    "Navigator?Node?http://sdq.ipd.uka.de/PalladioComponentModel/Parameter/5.0?VariableUsage", PalladioComponentModelElementTypes.VariableUsage_3012); //$NON-NLS-1$
        case StopEditPart.VISUAL_ID:
            return getImage(
                    "Navigator?Node?http://sdq.ipd.uka.de/PalladioComponentModel/UsageModel/5.0?Stop", PalladioComponentModelElementTypes.Stop_3002); //$NON-NLS-1$
        case BranchTransitionEditPart.VISUAL_ID:
            return getImage(
                    "Navigator?Node?http://sdq.ipd.uka.de/PalladioComponentModel/UsageModel/5.0?BranchTransition", PalladioComponentModelElementTypes.BranchTransition_3009); //$NON-NLS-1$
        case StartEditPart.VISUAL_ID:
            return getImage(
                    "Navigator?Node?http://sdq.ipd.uka.de/PalladioComponentModel/UsageModel/5.0?Start", PalladioComponentModelElementTypes.Start_3001); //$NON-NLS-1$
        case OpenWorkloadEditPart.VISUAL_ID:
            return getImage(
                    "Navigator?Node?http://sdq.ipd.uka.de/PalladioComponentModel/UsageModel/5.0?OpenWorkload", PalladioComponentModelElementTypes.OpenWorkload_3016); //$NON-NLS-1$
        case VariableCharacterisationEditPart.VISUAL_ID:
            return getImage(
                    "Navigator?Node?http://sdq.ipd.uka.de/PalladioComponentModel/Parameter/5.0?VariableCharacterisation", PalladioComponentModelElementTypes.VariableCharacterisation_3013); //$NON-NLS-1$
        case ScenarioBehaviour2EditPart.VISUAL_ID:
            return getImage(
                    "Navigator?Node?http://sdq.ipd.uka.de/PalladioComponentModel/UsageModel/5.0?ScenarioBehaviour", PalladioComponentModelElementTypes.ScenarioBehaviour_3007); //$NON-NLS-1$
        case LoopEditPart.VISUAL_ID:
            return getImage(
                    "Navigator?Node?http://sdq.ipd.uka.de/PalladioComponentModel/UsageModel/5.0?Loop", PalladioComponentModelElementTypes.Loop_3005); //$NON-NLS-1$
        case EntryLevelSystemCallEditPart.VISUAL_ID:
            return getImage(
                    "Navigator?Node?http://sdq.ipd.uka.de/PalladioComponentModel/UsageModel/5.0?EntryLevelSystemCall", PalladioComponentModelElementTypes.EntryLevelSystemCall_3003); //$NON-NLS-1$
        case ScenarioBehaviour3EditPart.VISUAL_ID:
            return getImage(
                    "Navigator?Node?http://sdq.ipd.uka.de/PalladioComponentModel/UsageModel/5.0?ScenarioBehaviour", PalladioComponentModelElementTypes.ScenarioBehaviour_3010); //$NON-NLS-1$
        case AbstractUserActionSuccessorEditPart.VISUAL_ID:
            return getImage(
                    "Navigator?Link?http://sdq.ipd.uka.de/PalladioComponentModel/UsageModel/5.0?AbstractUserAction?successor", PalladioComponentModelElementTypes.AbstractUserActionSuccessor_4002); //$NON-NLS-1$
        case UsageScenarioEditPart.VISUAL_ID:
            return getImage(
                    "Navigator?Diagram?http://sdq.ipd.uka.de/PalladioComponentModel/UsageModel/5.0?UsageModel", PalladioComponentModelElementTypes.UsageModel_1000); //$NON-NLS-1$
        case BranchEditPart.VISUAL_ID:
            return getImage(
                    "Navigator?Node?http://sdq.ipd.uka.de/PalladioComponentModel/UsageModel/5.0?Branch", PalladioComponentModelElementTypes.Branch_3008); //$NON-NLS-1$
        case ScenarioBehaviourEditPart.VISUAL_ID:
            return getImage(
                    "Navigator?Node?http://sdq.ipd.uka.de/PalladioComponentModel/UsageModel/5.0?ScenarioBehaviour", PalladioComponentModelElementTypes.ScenarioBehaviour_3014); //$NON-NLS-1$
        case UsageScenario2EditPart.VISUAL_ID:
            return getImage(
                    "Navigator?TopLevelNode?http://sdq.ipd.uka.de/PalladioComponentModel/UsageModel/5.0?UsageScenario", PalladioComponentModelElementTypes.UsageScenario_2004); //$NON-NLS-1$
        case ClosedWorkloadEditPart.VISUAL_ID:
            return getImage(
                    "Navigator?Node?http://sdq.ipd.uka.de/PalladioComponentModel/UsageModel/5.0?ClosedWorkload", PalladioComponentModelElementTypes.ClosedWorkload_3015); //$NON-NLS-1$
        }
        return getImage("Navigator?UnknownElement", null); //$NON-NLS-1$
    }

    /**
     * @generated
     */
    private Image getImage(String key, IElementType elementType) {
        ImageRegistry imageRegistry = PalladioComponentModelUsageDiagramEditorPlugin.getInstance().getImageRegistry();
        Image image = imageRegistry.get(key);
        if (image == null && elementType != null && PalladioComponentModelElementTypes.isKnownElementType(elementType)) {
            image = PalladioComponentModelElementTypes.getImage(elementType);
            imageRegistry.put(key, image);
        }

        if (image == null) {
            image = imageRegistry.get("Navigator?ImageNotFound"); //$NON-NLS-1$
            imageRegistry.put(key, image);
        }
        return image;
    }

    /**
     * @generated
     */
    public String getText(Object element) {
        if (element instanceof PalladioComponentModelNavigatorGroup) {
            PalladioComponentModelNavigatorGroup group = (PalladioComponentModelNavigatorGroup) element;
            return group.getGroupName();
        }

        if (element instanceof PalladioComponentModelNavigatorItem) {
            PalladioComponentModelNavigatorItem navigatorItem = (PalladioComponentModelNavigatorItem) element;
            if (!isOwnView(navigatorItem.getView())) {
                return null;
            }
            return getText(navigatorItem.getView());
        }

        return super.getText(element);
    }

    /**
     * @generated
     */
    public String getText(View view) {
        if (view.getElement() != null && view.getElement().eIsProxy()) {
            return getUnresolvedDomainElementProxyText(view);
        }
        switch (PalladioComponentModelVisualIDRegistry.getVisualID(view)) {
        case DelayEditPart.VISUAL_ID:
            return getDelay_3017Text(view);
        case VariableUsageEditPart.VISUAL_ID:
            return getVariableUsage_3012Text(view);
        case StopEditPart.VISUAL_ID:
            return getStop_3002Text(view);
        case BranchTransitionEditPart.VISUAL_ID:
            return getBranchTransition_3009Text(view);
        case StartEditPart.VISUAL_ID:
            return getStart_3001Text(view);
        case OpenWorkloadEditPart.VISUAL_ID:
            return getOpenWorkload_3016Text(view);
        case VariableCharacterisationEditPart.VISUAL_ID:
            return getVariableCharacterisation_3013Text(view);
        case ScenarioBehaviour2EditPart.VISUAL_ID:
            return getScenarioBehaviour_3007Text(view);
        case LoopEditPart.VISUAL_ID:
            return getLoop_3005Text(view);
        case EntryLevelSystemCallEditPart.VISUAL_ID:
            return getEntryLevelSystemCall_3003Text(view);
        case ScenarioBehaviour3EditPart.VISUAL_ID:
            return getScenarioBehaviour_3010Text(view);
        case AbstractUserActionSuccessorEditPart.VISUAL_ID:
            return getAbstractUserActionSuccessor_4002Text(view);
        case UsageScenarioEditPart.VISUAL_ID:
            return getUsageModel_1000Text(view);
        case BranchEditPart.VISUAL_ID:
            return getBranch_3008Text(view);
        case ScenarioBehaviourEditPart.VISUAL_ID:
            return getScenarioBehaviour_3014Text(view);
        case UsageScenario2EditPart.VISUAL_ID:
            return getUsageScenario_2004Text(view);
        case ClosedWorkloadEditPart.VISUAL_ID:
            return getClosedWorkload_3015Text(view);
        }
        return getUnknownElementText(view);
    }

    /**
     * @generated
     */
    private String getUsageModel_1000Text(View view) {
        return ""; //$NON-NLS-1$
    }

    /**
     * @generated
     */
    private String getUsageScenario_2004Text(View view) {
        IParser parser = PalladioComponentModelParserProvider.getParser(
                PalladioComponentModelElementTypes.UsageScenario_2004, view.getElement() != null ? view.getElement()
                        : view, PalladioComponentModelVisualIDRegistry.getType(UsageScenarioLabelEditPart.VISUAL_ID));
        if (parser != null) {
            return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
                    ParserOptions.NONE.intValue());
        } else {
            PalladioComponentModelUsageDiagramEditorPlugin.getInstance().logError(
                    "Parser was not found for label " + 5017); //$NON-NLS-1$
            return ""; //$NON-NLS-1$
        }
    }

    /**
     * @generated
     */
    private String getScenarioBehaviour_3014Text(View view) {
        ScenarioBehaviour domainModelElement = (ScenarioBehaviour) view.getElement();
        if (domainModelElement != null) {
            return domainModelElement.getId();
        } else {
            PalladioComponentModelUsageDiagramEditorPlugin.getInstance().logError(
                    "No domain element for view with visualID = " + 3014); //$NON-NLS-1$
            return ""; //$NON-NLS-1$
        }
    }

    /**
     * @generated
     */
    private String getStart_3001Text(View view) {
        Start domainModelElement = (Start) view.getElement();
        if (domainModelElement != null) {
            return domainModelElement.getId();
        } else {
            PalladioComponentModelUsageDiagramEditorPlugin.getInstance().logError(
                    "No domain element for view with visualID = " + 3001); //$NON-NLS-1$
            return ""; //$NON-NLS-1$
        }
    }

    /**
     * @generated
     */
    private String getStop_3002Text(View view) {
        Stop domainModelElement = (Stop) view.getElement();
        if (domainModelElement != null) {
            return domainModelElement.getId();
        } else {
            PalladioComponentModelUsageDiagramEditorPlugin.getInstance().logError(
                    "No domain element for view with visualID = " + 3002); //$NON-NLS-1$
            return ""; //$NON-NLS-1$
        }
    }

    /**
     * @generated
     */
    private String getEntryLevelSystemCall_3003Text(View view) {
        IParser parser = PalladioComponentModelParserProvider.getParser(
                PalladioComponentModelElementTypes.EntryLevelSystemCall_3003,
                view.getElement() != null ? view.getElement() : view,
                PalladioComponentModelVisualIDRegistry.getType(ComponentExternalCallNameLabelEditPart.VISUAL_ID));
        if (parser != null) {
            return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
                    ParserOptions.NONE.intValue());
        } else {
            PalladioComponentModelUsageDiagramEditorPlugin.getInstance().logError(
                    "Parser was not found for label " + 5004); //$NON-NLS-1$
            return ""; //$NON-NLS-1$
        }
    }

    /**
     * @generated
     */
    private String getVariableUsage_3012Text(View view) {
        IParser parser = PalladioComponentModelParserProvider.getParser(
                PalladioComponentModelElementTypes.VariableUsage_3012, view.getElement() != null ? view.getElement()
                        : view, PalladioComponentModelVisualIDRegistry.getType(WrappingLabelEditPart.VISUAL_ID));
        if (parser != null) {
            return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
                    ParserOptions.NONE.intValue());
        } else {
            PalladioComponentModelUsageDiagramEditorPlugin.getInstance().logError(
                    "Parser was not found for label " + 5012); //$NON-NLS-1$
            return ""; //$NON-NLS-1$
        }
    }

    /**
     * @generated
     */
    private String getVariableCharacterisation_3013Text(View view) {
        IParser parser = PalladioComponentModelParserProvider.getParser(
                PalladioComponentModelElementTypes.VariableCharacterisation_3013,
                view.getElement() != null ? view.getElement() : view,
                PalladioComponentModelVisualIDRegistry.getType(VariableCharacterisationEditPart.VISUAL_ID));
        if (parser != null) {
            return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
                    ParserOptions.NONE.intValue());
        } else {
            PalladioComponentModelUsageDiagramEditorPlugin.getInstance().logError(
                    "Parser was not found for label " + 3013); //$NON-NLS-1$
            return ""; //$NON-NLS-1$
        }
    }

    /**
     * @generated
     */
    private String getLoop_3005Text(View view) {
        IParser parser = PalladioComponentModelParserProvider.getParser(PalladioComponentModelElementTypes.Loop_3005,
                view.getElement() != null ? view.getElement() : view,
                PalladioComponentModelVisualIDRegistry.getType(UsageLoopIterationsLabelEditPart.VISUAL_ID));
        if (parser != null) {
            return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
                    ParserOptions.NONE.intValue());
        } else {
            PalladioComponentModelUsageDiagramEditorPlugin.getInstance().logError(
                    "Parser was not found for label " + 5005); //$NON-NLS-1$
            return ""; //$NON-NLS-1$
        }
    }

    /**
     * @generated
     */
    private String getScenarioBehaviour_3007Text(View view) {
        ScenarioBehaviour domainModelElement = (ScenarioBehaviour) view.getElement();
        if (domainModelElement != null) {
            return domainModelElement.getId();
        } else {
            PalladioComponentModelUsageDiagramEditorPlugin.getInstance().logError(
                    "No domain element for view with visualID = " + 3007); //$NON-NLS-1$
            return ""; //$NON-NLS-1$
        }
    }

    /**
     * @generated
     */
    private String getBranch_3008Text(View view) {
        Branch domainModelElement = (Branch) view.getElement();
        if (domainModelElement != null) {
            return domainModelElement.getId();
        } else {
            PalladioComponentModelUsageDiagramEditorPlugin.getInstance().logError(
                    "No domain element for view with visualID = " + 3008); //$NON-NLS-1$
            return ""; //$NON-NLS-1$
        }
    }

    /**
     * @generated
     */
    private String getBranchTransition_3009Text(View view) {
        IParser parser = PalladioComponentModelParserProvider.getParser(
                PalladioComponentModelElementTypes.BranchTransition_3009, view.getElement() != null ? view.getElement()
                        : view, PalladioComponentModelVisualIDRegistry
                        .getType(BranchTransitionBranchProbabilityEditPart.VISUAL_ID));
        if (parser != null) {
            return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
                    ParserOptions.NONE.intValue());
        } else {
            PalladioComponentModelUsageDiagramEditorPlugin.getInstance().logError(
                    "Parser was not found for label " + 5007); //$NON-NLS-1$
            return ""; //$NON-NLS-1$
        }
    }

    /**
     * @generated
     */
    private String getScenarioBehaviour_3010Text(View view) {
        ScenarioBehaviour domainModelElement = (ScenarioBehaviour) view.getElement();
        if (domainModelElement != null) {
            return domainModelElement.getId();
        } else {
            PalladioComponentModelUsageDiagramEditorPlugin.getInstance().logError(
                    "No domain element for view with visualID = " + 3010); //$NON-NLS-1$
            return ""; //$NON-NLS-1$
        }
    }

    /**
     * @generated
     */
    private String getDelay_3017Text(View view) {
        IParser parser = PalladioComponentModelParserProvider.getParser(PalladioComponentModelElementTypes.Delay_3017,
                view.getElement() != null ? view.getElement() : view,
                PalladioComponentModelVisualIDRegistry.getType(DelayEntityNameEditPart.VISUAL_ID));
        if (parser != null) {
            return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
                    ParserOptions.NONE.intValue());
        } else {
            PalladioComponentModelUsageDiagramEditorPlugin.getInstance().logError(
                    "Parser was not found for label " + 5018); //$NON-NLS-1$
            return ""; //$NON-NLS-1$
        }
    }

    /**
     * @generated
     */
    private String getClosedWorkload_3015Text(View view) {
        IParser parser = PalladioComponentModelParserProvider.getParser(
                PalladioComponentModelElementTypes.ClosedWorkload_3015, view.getElement() != null ? view.getElement()
                        : view, PalladioComponentModelVisualIDRegistry
                        .getType(ClosedWorkloadPopulationEditPart.VISUAL_ID));
        if (parser != null) {
            return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
                    ParserOptions.NONE.intValue());
        } else {
            PalladioComponentModelUsageDiagramEditorPlugin.getInstance().logError(
                    "Parser was not found for label " + 5013); //$NON-NLS-1$
            return ""; //$NON-NLS-1$
        }
    }

    /**
     * @generated
     */
    private String getOpenWorkload_3016Text(View view) {
        IParser parser = PalladioComponentModelParserProvider
                .getParser(PalladioComponentModelElementTypes.OpenWorkload_3016,
                        view.getElement() != null ? view.getElement() : view,
                        PalladioComponentModelVisualIDRegistry.getType(OpenWorkloadSpecLabelEditPart.VISUAL_ID));
        if (parser != null) {
            return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
                    ParserOptions.NONE.intValue());
        } else {
            PalladioComponentModelUsageDiagramEditorPlugin.getInstance().logError(
                    "Parser was not found for label " + 5016); //$NON-NLS-1$
            return ""; //$NON-NLS-1$
        }
    }

    /**
     * @generated
     */
    private String getAbstractUserActionSuccessor_4002Text(View view) {
        return ""; //$NON-NLS-1$
    }

    /**
     * @generated
     */
    private String getUnknownElementText(View view) {
        return "<UnknownElement Visual_ID = " + view.getType() + ">"; //$NON-NLS-1$  //$NON-NLS-2$
    }

    /**
     * @generated
     */
    private String getUnresolvedDomainElementProxyText(View view) {
        return "<Unresolved domain element Visual_ID = " + view.getType() + ">"; //$NON-NLS-1$  //$NON-NLS-2$
    }

    /**
     * @generated
     */
    public void init(ICommonContentExtensionSite aConfig) {
    }

    /**
     * @generated
     */
    public void restoreState(IMemento aMemento) {
    }

    /**
     * @generated
     */
    public void saveState(IMemento aMemento) {
    }

    /**
     * @generated
     */
    public String getDescription(Object anElement) {
        return null;
    }

    /**
     * @generated
     */
    private boolean isOwnView(View view) {
        return UsageScenarioEditPart.MODEL_ID.equals(PalladioComponentModelVisualIDRegistry.getModelID(view));
    }

}
