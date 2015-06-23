/*
 * Copyright 2007, IPD, SDQ, University of Karlsruhe
 */
package de.uka.ipd.sdq.pcm.gmf.repository.navigator;

import org.eclipse.gmf.runtime.common.ui.services.parser.CommonParserHint;
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

import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.BasicComponentEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.BasicComponentEntityNameEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.CompleteComponentTypeEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.CompleteComponentTypeEntityNameEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.CompleteComponentTypeParentProvidesComponentTypesEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.CompositeComponentEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.CompositeComponentEntityNameEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.EventGroupEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.EventGroupEntityNameEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.EventTypeEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.ImplementationComponentTypeParentCompleteComponentTypesEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.InfrastructureInterfaceEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.InfrastructureInterfaceEntityNameEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.InfrastructureProvidedRoleEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.InfrastructureRequiredRoleEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.InfrastructureSignatureEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.InterfaceParentInterfaces__InterfaceEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.OperationInterfaceEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.OperationInterfaceEntityNameEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.OperationProvidedRoleEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.OperationRequiredRoleEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.OperationSignatureEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.PassiveResourceEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.ProvidesComponentTypeEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.ProvidesComponentTypeEntityNameEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.RepositoryEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.ResourceDemandingSEFFEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.SinkRoleEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.SourceRoleEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.SubSystemEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.SubSystemEntityNameEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.VariableCharacterisationEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.VariableUsageEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.VariableUsageLabelEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.part.PalladioComponentModelRepositoryDiagramEditorPlugin;
import de.uka.ipd.sdq.pcm.gmf.repository.part.PalladioComponentModelVisualIDRegistry;
import de.uka.ipd.sdq.pcm.gmf.repository.providers.PalladioComponentModelElementTypes;
import de.uka.ipd.sdq.pcm.gmf.repository.providers.PalladioComponentModelParserProvider;
import org.palladiosimulator.pcm.repository.Repository;

/**
 * @generated
 */
public class PalladioComponentModelNavigatorLabelProvider extends LabelProvider implements ICommonLabelProvider,
        ITreePathLabelProvider {

    /**
     * @generated
     */
    static {
        PalladioComponentModelRepositoryDiagramEditorPlugin.getInstance().getImageRegistry()
                .put("Navigator?UnknownElement", ImageDescriptor.getMissingImageDescriptor()); //$NON-NLS-1$
        PalladioComponentModelRepositoryDiagramEditorPlugin.getInstance().getImageRegistry()
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
            return PalladioComponentModelRepositoryDiagramEditorPlugin.getInstance().getBundledImage(group.getIcon());
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
        case InterfaceParentInterfaces__InterfaceEditPart.VISUAL_ID:
            return getImage(
                    "Navigator?Link?http://palladiosimulator.org/PalladioComponentModel/Repository/5.0?Interface?parentInterfaces__Interface", PalladioComponentModelElementTypes.InterfaceParentInterfaces__Interface_4113); //$NON-NLS-1$
        case OperationRequiredRoleEditPart.VISUAL_ID:
            return getImage(
                    "Navigator?Link?http://palladiosimulator.org/PalladioComponentModel/Repository/5.0?OperationRequiredRole", PalladioComponentModelElementTypes.OperationRequiredRole_4106); //$NON-NLS-1$
        case CompleteComponentTypeEditPart.VISUAL_ID:
            return getImage(
                    "Navigator?TopLevelNode?http://palladiosimulator.org/PalladioComponentModel/Repository/5.0?CompleteComponentType", PalladioComponentModelElementTypes.CompleteComponentType_2104); //$NON-NLS-1$
        case ImplementationComponentTypeParentCompleteComponentTypesEditPart.VISUAL_ID:
            return getImage(
                    "Navigator?Link?http://palladiosimulator.org/PalladioComponentModel/Repository/5.0?ImplementationComponentType?parentCompleteComponentTypes", PalladioComponentModelElementTypes.ImplementationComponentTypeParentCompleteComponentTypes_4103); //$NON-NLS-1$
        case VariableUsageEditPart.VISUAL_ID:
            return getImage(
                    "Navigator?Node?http://palladiosimulator.org/PalladioComponentModel/Parameter/5.0?VariableUsage", PalladioComponentModelElementTypes.VariableUsage_3104); //$NON-NLS-1$
        case VariableCharacterisationEditPart.VISUAL_ID:
            return getImage(
                    "Navigator?Node?http://palladiosimulator.org/PalladioComponentModel/Parameter/5.0?VariableCharacterisation", PalladioComponentModelElementTypes.VariableCharacterisation_3105); //$NON-NLS-1$
        case InfrastructureInterfaceEditPart.VISUAL_ID:
            return getImage(
                    "Navigator?TopLevelNode?http://palladiosimulator.org/PalladioComponentModel/Repository/5.0?InfrastructureInterface", PalladioComponentModelElementTypes.InfrastructureInterface_2109); //$NON-NLS-1$
        case RepositoryEditPart.VISUAL_ID:
            return getImage(
                    "Navigator?Diagram?http://palladiosimulator.org/PalladioComponentModel/Repository/5.0?Repository", PalladioComponentModelElementTypes.Repository_1000); //$NON-NLS-1$
        case SinkRoleEditPart.VISUAL_ID:
            return getImage(
                    "Navigator?Link?http://palladiosimulator.org/PalladioComponentModel/Repository/5.0?SinkRole", PalladioComponentModelElementTypes.SinkRole_4109); //$NON-NLS-1$
        case SubSystemEditPart.VISUAL_ID:
            return getImage(
                    "Navigator?TopLevelNode?http://palladiosimulator.org/PalladioComponentModel/SubSystem/5.0?SubSystem", PalladioComponentModelElementTypes.SubSystem_2106); //$NON-NLS-1$
        case PassiveResourceEditPart.VISUAL_ID:
            return getImage(
                    "Navigator?Node?http://palladiosimulator.org/PalladioComponentModel/Repository/5.0?PassiveResource", PalladioComponentModelElementTypes.PassiveResource_3103); //$NON-NLS-1$
        case InfrastructureRequiredRoleEditPart.VISUAL_ID:
            return getImage(
                    "Navigator?Link?http://palladiosimulator.org/PalladioComponentModel/Repository/5.0?InfrastructureRequiredRole", PalladioComponentModelElementTypes.InfrastructureRequiredRole_4112); //$NON-NLS-1$
        case OperationProvidedRoleEditPart.VISUAL_ID:
            return getImage(
                    "Navigator?Link?http://palladiosimulator.org/PalladioComponentModel/Repository/5.0?OperationProvidedRole", PalladioComponentModelElementTypes.OperationProvidedRole_4105); //$NON-NLS-1$
        case CompositeComponentEditPart.VISUAL_ID:
            return getImage(
                    "Navigator?TopLevelNode?http://palladiosimulator.org/PalladioComponentModel/Repository/5.0?CompositeComponent", PalladioComponentModelElementTypes.CompositeComponent_2103); //$NON-NLS-1$
        case OperationSignatureEditPart.VISUAL_ID:
            return getImage(
                    "Navigator?Node?http://palladiosimulator.org/PalladioComponentModel/Repository/5.0?OperationSignature", PalladioComponentModelElementTypes.OperationSignature_3106); //$NON-NLS-1$
        case BasicComponentEditPart.VISUAL_ID:
            return getImage(
                    "Navigator?TopLevelNode?http://palladiosimulator.org/PalladioComponentModel/Repository/5.0?BasicComponent", PalladioComponentModelElementTypes.BasicComponent_2102); //$NON-NLS-1$
        case InfrastructureProvidedRoleEditPart.VISUAL_ID:
            return getImage(
                    "Navigator?Link?http://palladiosimulator.org/PalladioComponentModel/Repository/5.0?InfrastructureProvidedRole", PalladioComponentModelElementTypes.InfrastructureProvidedRole_4111); //$NON-NLS-1$
        case CompleteComponentTypeParentProvidesComponentTypesEditPart.VISUAL_ID:
            return getImage(
                    "Navigator?Link?http://palladiosimulator.org/PalladioComponentModel/Repository/5.0?CompleteComponentType?parentProvidesComponentTypes", PalladioComponentModelElementTypes.CompleteComponentTypeParentProvidesComponentTypes_4104); //$NON-NLS-1$
        case OperationInterfaceEditPart.VISUAL_ID:
            return getImage(
                    "Navigator?TopLevelNode?http://palladiosimulator.org/PalladioComponentModel/Repository/5.0?OperationInterface", PalladioComponentModelElementTypes.OperationInterface_2107); //$NON-NLS-1$
        case ProvidesComponentTypeEditPart.VISUAL_ID:
            return getImage(
                    "Navigator?TopLevelNode?http://palladiosimulator.org/PalladioComponentModel/Repository/5.0?ProvidesComponentType", PalladioComponentModelElementTypes.ProvidesComponentType_2105); //$NON-NLS-1$
        case SourceRoleEditPart.VISUAL_ID:
            return getImage(
                    "Navigator?Link?http://palladiosimulator.org/PalladioComponentModel/Repository/5.0?SourceRole", PalladioComponentModelElementTypes.SourceRole_4110); //$NON-NLS-1$
        case EventTypeEditPart.VISUAL_ID:
            return getImage(
                    "Navigator?Node?http://palladiosimulator.org/PalladioComponentModel/Repository/5.0?EventType", PalladioComponentModelElementTypes.EventType_3107); //$NON-NLS-1$
        case ResourceDemandingSEFFEditPart.VISUAL_ID:
            return getImage(
                    "Navigator?Node?http://palladiosimulator.org/PalladioComponentModel/SEFF/5.0?ResourceDemandingSEFF", PalladioComponentModelElementTypes.ResourceDemandingSEFF_3102); //$NON-NLS-1$
        case InfrastructureSignatureEditPart.VISUAL_ID:
            return getImage(
                    "Navigator?Node?http://palladiosimulator.org/PalladioComponentModel/Repository/5.0?InfrastructureSignature", PalladioComponentModelElementTypes.InfrastructureSignature_3108); //$NON-NLS-1$
        case EventGroupEditPart.VISUAL_ID:
            return getImage(
                    "Navigator?TopLevelNode?http://palladiosimulator.org/PalladioComponentModel/Repository/5.0?EventGroup", PalladioComponentModelElementTypes.EventGroup_2108); //$NON-NLS-1$
        }
        return getImage("Navigator?UnknownElement", null); //$NON-NLS-1$
    }

    /**
     * @generated
     */
    private Image getImage(String key, IElementType elementType) {
        ImageRegistry imageRegistry = PalladioComponentModelRepositoryDiagramEditorPlugin.getInstance()
                .getImageRegistry();
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
        case InterfaceParentInterfaces__InterfaceEditPart.VISUAL_ID:
            return getInterfaceParentInterfaces__Interface_4113Text(view);
        case OperationRequiredRoleEditPart.VISUAL_ID:
            return getOperationRequiredRole_4106Text(view);
        case CompleteComponentTypeEditPart.VISUAL_ID:
            return getCompleteComponentType_2104Text(view);
        case ImplementationComponentTypeParentCompleteComponentTypesEditPart.VISUAL_ID:
            return getImplementationComponentTypeParentCompleteComponentTypes_4103Text(view);
        case VariableUsageEditPart.VISUAL_ID:
            return getVariableUsage_3104Text(view);
        case VariableCharacterisationEditPart.VISUAL_ID:
            return getVariableCharacterisation_3105Text(view);
        case InfrastructureInterfaceEditPart.VISUAL_ID:
            return getInfrastructureInterface_2109Text(view);
        case RepositoryEditPart.VISUAL_ID:
            return getRepository_1000Text(view);
        case SinkRoleEditPart.VISUAL_ID:
            return getSinkRole_4109Text(view);
        case SubSystemEditPart.VISUAL_ID:
            return getSubSystem_2106Text(view);
        case PassiveResourceEditPart.VISUAL_ID:
            return getPassiveResource_3103Text(view);
        case InfrastructureRequiredRoleEditPart.VISUAL_ID:
            return getInfrastructureRequiredRole_4112Text(view);
        case OperationProvidedRoleEditPart.VISUAL_ID:
            return getOperationProvidedRole_4105Text(view);
        case CompositeComponentEditPart.VISUAL_ID:
            return getCompositeComponent_2103Text(view);
        case OperationSignatureEditPart.VISUAL_ID:
            return getOperationSignature_3106Text(view);
        case BasicComponentEditPart.VISUAL_ID:
            return getBasicComponent_2102Text(view);
        case InfrastructureProvidedRoleEditPart.VISUAL_ID:
            return getInfrastructureProvidedRole_4111Text(view);
        case CompleteComponentTypeParentProvidesComponentTypesEditPart.VISUAL_ID:
            return getCompleteComponentTypeParentProvidesComponentTypes_4104Text(view);
        case OperationInterfaceEditPart.VISUAL_ID:
            return getOperationInterface_2107Text(view);
        case ProvidesComponentTypeEditPart.VISUAL_ID:
            return getProvidesComponentType_2105Text(view);
        case SourceRoleEditPart.VISUAL_ID:
            return getSourceRole_4110Text(view);
        case EventTypeEditPart.VISUAL_ID:
            return getEventType_3107Text(view);
        case ResourceDemandingSEFFEditPart.VISUAL_ID:
            return getResourceDemandingSEFF_3102Text(view);
        case InfrastructureSignatureEditPart.VISUAL_ID:
            return getInfrastructureSignature_3108Text(view);
        case EventGroupEditPart.VISUAL_ID:
            return getEventGroup_2108Text(view);
        }
        return getUnknownElementText(view);
    }

    /**
     * @generated
     */
    private String getInterfaceParentInterfaces__Interface_4113Text(View view) {
        IParser parser = PalladioComponentModelParserProvider.getParser(
                PalladioComponentModelElementTypes.InterfaceParentInterfaces__Interface_4113,
                view.getElement() != null ? view.getElement() : view, CommonParserHint.DESCRIPTION);
        if (parser != null) {
            return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
                    ParserOptions.NONE.intValue());
        } else {
            PalladioComponentModelRepositoryDiagramEditorPlugin.getInstance().logError(
                    "Parser was not found for label " + 6113); //$NON-NLS-1$
            return ""; //$NON-NLS-1$
        }
    }

    /**
     * @generated
     */
    private String getRepository_1000Text(View view) {
        Repository domainModelElement = (Repository) view.getElement();
        if (domainModelElement != null) {
            return domainModelElement.getId();
        } else {
            PalladioComponentModelRepositoryDiagramEditorPlugin.getInstance().logError(
                    "No domain element for view with visualID = " + 1000); //$NON-NLS-1$
            return ""; //$NON-NLS-1$
        }
    }

    /**
     * @generated
     */
    private String getOperationInterface_2107Text(View view) {
        IParser parser = PalladioComponentModelParserProvider.getParser(
                PalladioComponentModelElementTypes.OperationInterface_2107,
                view.getElement() != null ? view.getElement() : view,
                PalladioComponentModelVisualIDRegistry.getType(OperationInterfaceEntityNameEditPart.VISUAL_ID));
        if (parser != null) {
            return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
                    ParserOptions.NONE.intValue());
        } else {
            PalladioComponentModelRepositoryDiagramEditorPlugin.getInstance().logError(
                    "Parser was not found for label " + 5108); //$NON-NLS-1$
            return ""; //$NON-NLS-1$
        }
    }

    /**
     * @generated
     */
    private String getEventGroup_2108Text(View view) {
        IParser parser = PalladioComponentModelParserProvider.getParser(
                PalladioComponentModelElementTypes.EventGroup_2108, view.getElement() != null ? view.getElement()
                        : view, PalladioComponentModelVisualIDRegistry.getType(EventGroupEntityNameEditPart.VISUAL_ID));
        if (parser != null) {
            return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
                    ParserOptions.NONE.intValue());
        } else {
            PalladioComponentModelRepositoryDiagramEditorPlugin.getInstance().logError(
                    "Parser was not found for label " + 5109); //$NON-NLS-1$
            return ""; //$NON-NLS-1$
        }
    }

    /**
     * @generated
     */
    private String getBasicComponent_2102Text(View view) {
        IParser parser = PalladioComponentModelParserProvider.getParser(
                PalladioComponentModelElementTypes.BasicComponent_2102, view.getElement() != null ? view.getElement()
                        : view, PalladioComponentModelVisualIDRegistry
                        .getType(BasicComponentEntityNameEditPart.VISUAL_ID));
        if (parser != null) {
            return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
                    ParserOptions.NONE.intValue());
        } else {
            PalladioComponentModelRepositoryDiagramEditorPlugin.getInstance().logError(
                    "Parser was not found for label " + 5102); //$NON-NLS-1$
            return ""; //$NON-NLS-1$
        }
    }

    /**
     * @generated
     */
    private String getCompositeComponent_2103Text(View view) {
        IParser parser = PalladioComponentModelParserProvider.getParser(
                PalladioComponentModelElementTypes.CompositeComponent_2103,
                view.getElement() != null ? view.getElement() : view,
                PalladioComponentModelVisualIDRegistry.getType(CompositeComponentEntityNameEditPart.VISUAL_ID));
        if (parser != null) {
            return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
                    ParserOptions.NONE.intValue());
        } else {
            PalladioComponentModelRepositoryDiagramEditorPlugin.getInstance().logError(
                    "Parser was not found for label " + 5103); //$NON-NLS-1$
            return ""; //$NON-NLS-1$
        }
    }

    /**
     * @generated
     */
    private String getCompleteComponentType_2104Text(View view) {
        IParser parser = PalladioComponentModelParserProvider.getParser(
                PalladioComponentModelElementTypes.CompleteComponentType_2104,
                view.getElement() != null ? view.getElement() : view,
                PalladioComponentModelVisualIDRegistry.getType(CompleteComponentTypeEntityNameEditPart.VISUAL_ID));
        if (parser != null) {
            return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
                    ParserOptions.NONE.intValue());
        } else {
            PalladioComponentModelRepositoryDiagramEditorPlugin.getInstance().logError(
                    "Parser was not found for label " + 5104); //$NON-NLS-1$
            return ""; //$NON-NLS-1$
        }
    }

    /**
     * @generated
     */
    private String getProvidesComponentType_2105Text(View view) {
        IParser parser = PalladioComponentModelParserProvider.getParser(
                PalladioComponentModelElementTypes.ProvidesComponentType_2105,
                view.getElement() != null ? view.getElement() : view,
                PalladioComponentModelVisualIDRegistry.getType(ProvidesComponentTypeEntityNameEditPart.VISUAL_ID));
        if (parser != null) {
            return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
                    ParserOptions.NONE.intValue());
        } else {
            PalladioComponentModelRepositoryDiagramEditorPlugin.getInstance().logError(
                    "Parser was not found for label " + 5105); //$NON-NLS-1$
            return ""; //$NON-NLS-1$
        }
    }

    /**
     * @generated
     */
    private String getSubSystem_2106Text(View view) {
        IParser parser = PalladioComponentModelParserProvider.getParser(
                PalladioComponentModelElementTypes.SubSystem_2106,
                view.getElement() != null ? view.getElement() : view,
                PalladioComponentModelVisualIDRegistry.getType(SubSystemEntityNameEditPart.VISUAL_ID));
        if (parser != null) {
            return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
                    ParserOptions.NONE.intValue());
        } else {
            PalladioComponentModelRepositoryDiagramEditorPlugin.getInstance().logError(
                    "Parser was not found for label " + 5107); //$NON-NLS-1$
            return ""; //$NON-NLS-1$
        }
    }

    /**
     * @generated
     */
    private String getInfrastructureInterface_2109Text(View view) {
        IParser parser = PalladioComponentModelParserProvider.getParser(
                PalladioComponentModelElementTypes.InfrastructureInterface_2109,
                view.getElement() != null ? view.getElement() : view,
                PalladioComponentModelVisualIDRegistry.getType(InfrastructureInterfaceEntityNameEditPart.VISUAL_ID));
        if (parser != null) {
            return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
                    ParserOptions.NONE.intValue());
        } else {
            PalladioComponentModelRepositoryDiagramEditorPlugin.getInstance().logError(
                    "Parser was not found for label " + 5110); //$NON-NLS-1$
            return ""; //$NON-NLS-1$
        }
    }

    /**
     * @generated
     */
    private String getOperationSignature_3106Text(View view) {
        IParser parser = PalladioComponentModelParserProvider.getParser(
                PalladioComponentModelElementTypes.OperationSignature_3106,
                view.getElement() != null ? view.getElement() : view,
                PalladioComponentModelVisualIDRegistry.getType(OperationSignatureEditPart.VISUAL_ID));
        if (parser != null) {
            return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
                    ParserOptions.NONE.intValue());
        } else {
            PalladioComponentModelRepositoryDiagramEditorPlugin.getInstance().logError(
                    "Parser was not found for label " + 3106); //$NON-NLS-1$
            return ""; //$NON-NLS-1$
        }
    }

    /**
     * @generated
     */
    private String getEventType_3107Text(View view) {
        IParser parser = PalladioComponentModelParserProvider.getParser(
                PalladioComponentModelElementTypes.EventType_3107,
                view.getElement() != null ? view.getElement() : view,
                PalladioComponentModelVisualIDRegistry.getType(EventTypeEditPart.VISUAL_ID));
        if (parser != null) {
            return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
                    ParserOptions.NONE.intValue());
        } else {
            PalladioComponentModelRepositoryDiagramEditorPlugin.getInstance().logError(
                    "Parser was not found for label " + 3107); //$NON-NLS-1$
            return ""; //$NON-NLS-1$
        }
    }

    /**
     * @generated
     */
    private String getResourceDemandingSEFF_3102Text(View view) {
        IParser parser = PalladioComponentModelParserProvider.getParser(
                PalladioComponentModelElementTypes.ResourceDemandingSEFF_3102,
                view.getElement() != null ? view.getElement() : view,
                PalladioComponentModelVisualIDRegistry.getType(ResourceDemandingSEFFEditPart.VISUAL_ID));
        if (parser != null) {
            return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
                    ParserOptions.NONE.intValue());
        } else {
            PalladioComponentModelRepositoryDiagramEditorPlugin.getInstance().logError(
                    "Parser was not found for label " + 3102); //$NON-NLS-1$
            return ""; //$NON-NLS-1$
        }
    }

    /**
     * @generated
     */
    private String getPassiveResource_3103Text(View view) {
        IParser parser = PalladioComponentModelParserProvider.getParser(
                PalladioComponentModelElementTypes.PassiveResource_3103, view.getElement() != null ? view.getElement()
                        : view, PalladioComponentModelVisualIDRegistry.getType(PassiveResourceEditPart.VISUAL_ID));
        if (parser != null) {
            return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
                    ParserOptions.NONE.intValue());
        } else {
            PalladioComponentModelRepositoryDiagramEditorPlugin.getInstance().logError(
                    "Parser was not found for label " + 3103); //$NON-NLS-1$
            return ""; //$NON-NLS-1$
        }
    }

    /**
     * @generated
     */
    private String getVariableUsage_3104Text(View view) {
        IParser parser = PalladioComponentModelParserProvider.getParser(
                PalladioComponentModelElementTypes.VariableUsage_3104, view.getElement() != null ? view.getElement()
                        : view, PalladioComponentModelVisualIDRegistry.getType(VariableUsageLabelEditPart.VISUAL_ID));
        if (parser != null) {
            return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
                    ParserOptions.NONE.intValue());
        } else {
            PalladioComponentModelRepositoryDiagramEditorPlugin.getInstance().logError(
                    "Parser was not found for label " + 5106); //$NON-NLS-1$
            return ""; //$NON-NLS-1$
        }
    }

    /**
     * @generated
     */
    private String getVariableCharacterisation_3105Text(View view) {
        IParser parser = PalladioComponentModelParserProvider.getParser(
                PalladioComponentModelElementTypes.VariableCharacterisation_3105,
                view.getElement() != null ? view.getElement() : view,
                PalladioComponentModelVisualIDRegistry.getType(VariableCharacterisationEditPart.VISUAL_ID));
        if (parser != null) {
            return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
                    ParserOptions.NONE.intValue());
        } else {
            PalladioComponentModelRepositoryDiagramEditorPlugin.getInstance().logError(
                    "Parser was not found for label " + 3105); //$NON-NLS-1$
            return ""; //$NON-NLS-1$
        }
    }

    /**
     * @generated
     */
    private String getInfrastructureSignature_3108Text(View view) {
        IParser parser = PalladioComponentModelParserProvider.getParser(
                PalladioComponentModelElementTypes.InfrastructureSignature_3108,
                view.getElement() != null ? view.getElement() : view,
                PalladioComponentModelVisualIDRegistry.getType(InfrastructureSignatureEditPart.VISUAL_ID));
        if (parser != null) {
            return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
                    ParserOptions.NONE.intValue());
        } else {
            PalladioComponentModelRepositoryDiagramEditorPlugin.getInstance().logError(
                    "Parser was not found for label " + 3108); //$NON-NLS-1$
            return ""; //$NON-NLS-1$
        }
    }

    /**
     * @generated
     */
    private String getOperationProvidedRole_4105Text(View view) {
        IParser parser = PalladioComponentModelParserProvider.getParser(
                PalladioComponentModelElementTypes.OperationProvidedRole_4105,
                view.getElement() != null ? view.getElement() : view, CommonParserHint.DESCRIPTION);
        if (parser != null) {
            return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
                    ParserOptions.NONE.intValue());
        } else {
            PalladioComponentModelRepositoryDiagramEditorPlugin.getInstance().logError(
                    "Parser was not found for label " + 6105); //$NON-NLS-1$
            return ""; //$NON-NLS-1$
        }
    }

    /**
     * @generated
     */
    private String getInfrastructureProvidedRole_4111Text(View view) {
        IParser parser = PalladioComponentModelParserProvider.getParser(
                PalladioComponentModelElementTypes.InfrastructureProvidedRole_4111,
                view.getElement() != null ? view.getElement() : view, CommonParserHint.DESCRIPTION);
        if (parser != null) {
            return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
                    ParserOptions.NONE.intValue());
        } else {
            PalladioComponentModelRepositoryDiagramEditorPlugin.getInstance().logError(
                    "Parser was not found for label " + 6111); //$NON-NLS-1$
            return ""; //$NON-NLS-1$
        }
    }

    /**
     * @generated
     */
    private String getInfrastructureRequiredRole_4112Text(View view) {
        IParser parser = PalladioComponentModelParserProvider.getParser(
                PalladioComponentModelElementTypes.InfrastructureRequiredRole_4112,
                view.getElement() != null ? view.getElement() : view, CommonParserHint.DESCRIPTION);
        if (parser != null) {
            return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
                    ParserOptions.NONE.intValue());
        } else {
            PalladioComponentModelRepositoryDiagramEditorPlugin.getInstance().logError(
                    "Parser was not found for label " + 6112); //$NON-NLS-1$
            return ""; //$NON-NLS-1$
        }
    }

    /**
     * @generated
     */
    private String getSinkRole_4109Text(View view) {
        IParser parser = PalladioComponentModelParserProvider.getParser(
                PalladioComponentModelElementTypes.SinkRole_4109, view.getElement() != null ? view.getElement() : view,
                CommonParserHint.DESCRIPTION);
        if (parser != null) {
            return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
                    ParserOptions.NONE.intValue());
        } else {
            PalladioComponentModelRepositoryDiagramEditorPlugin.getInstance().logError(
                    "Parser was not found for label " + 6109); //$NON-NLS-1$
            return ""; //$NON-NLS-1$
        }
    }

    /**
     * @generated
     */
    private String getOperationRequiredRole_4106Text(View view) {
        IParser parser = PalladioComponentModelParserProvider.getParser(
                PalladioComponentModelElementTypes.OperationRequiredRole_4106,
                view.getElement() != null ? view.getElement() : view, CommonParserHint.DESCRIPTION);
        if (parser != null) {
            return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
                    ParserOptions.NONE.intValue());
        } else {
            PalladioComponentModelRepositoryDiagramEditorPlugin.getInstance().logError(
                    "Parser was not found for label " + 6106); //$NON-NLS-1$
            return ""; //$NON-NLS-1$
        }
    }

    /**
     * @generated
     */
    private String getImplementationComponentTypeParentCompleteComponentTypes_4103Text(View view) {
        IParser parser = PalladioComponentModelParserProvider.getParser(
                PalladioComponentModelElementTypes.ImplementationComponentTypeParentCompleteComponentTypes_4103,
                view.getElement() != null ? view.getElement() : view, CommonParserHint.DESCRIPTION);
        if (parser != null) {
            return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
                    ParserOptions.NONE.intValue());
        } else {
            PalladioComponentModelRepositoryDiagramEditorPlugin.getInstance().logError(
                    "Parser was not found for label " + 6103); //$NON-NLS-1$
            return ""; //$NON-NLS-1$
        }
    }

    /**
     * @generated
     */
    private String getCompleteComponentTypeParentProvidesComponentTypes_4104Text(View view) {
        IParser parser = PalladioComponentModelParserProvider.getParser(
                PalladioComponentModelElementTypes.CompleteComponentTypeParentProvidesComponentTypes_4104,
                view.getElement() != null ? view.getElement() : view, CommonParserHint.DESCRIPTION);
        if (parser != null) {
            return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
                    ParserOptions.NONE.intValue());
        } else {
            PalladioComponentModelRepositoryDiagramEditorPlugin.getInstance().logError(
                    "Parser was not found for label " + 6104); //$NON-NLS-1$
            return ""; //$NON-NLS-1$
        }
    }

    /**
     * @generated
     */
    private String getSourceRole_4110Text(View view) {
        IParser parser = PalladioComponentModelParserProvider.getParser(
                PalladioComponentModelElementTypes.SourceRole_4110, view.getElement() != null ? view.getElement()
                        : view, CommonParserHint.DESCRIPTION);
        if (parser != null) {
            return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
                    ParserOptions.NONE.intValue());
        } else {
            PalladioComponentModelRepositoryDiagramEditorPlugin.getInstance().logError(
                    "Parser was not found for label " + 6110); //$NON-NLS-1$
            return ""; //$NON-NLS-1$
        }
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
        return RepositoryEditPart.MODEL_ID.equals(PalladioComponentModelVisualIDRegistry.getModelID(view));
    }

}
