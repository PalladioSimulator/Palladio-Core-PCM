/*
 * Copyright 2007, SDQ, IPD, Uni Karlsruhe (TH)
 */
package de.uka.ipd.sdq.pcm.gmf.composite.navigator;

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

import de.uka.ipd.sdq.pcm.core.composition.AssemblyConnector;
import de.uka.ipd.sdq.pcm.core.composition.AssemblyEventConnector;
import de.uka.ipd.sdq.pcm.core.composition.AssemblyInfrastructureConnector;
import de.uka.ipd.sdq.pcm.core.composition.EventChannelSinkConnector;
import de.uka.ipd.sdq.pcm.core.composition.EventChannelSourceConnector;
import de.uka.ipd.sdq.pcm.core.composition.ProvidedDelegationConnector;
import de.uka.ipd.sdq.pcm.core.composition.RequiredDelegationConnector;
import de.uka.ipd.sdq.pcm.core.entity.ComposedProvidingRequiringEntity;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.parts.AssemblyConnectorEditPart;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.parts.AssemblyContextEditPart;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.parts.AssemblyContextEntityNameEditPart;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.parts.AssemblyEventConnectorEditPart;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.parts.AssemblyInfrastructureConnectorEditPart;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.parts.ComposedProvidingRequiringEntity2EditPart;
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
import de.uka.ipd.sdq.pcm.gmf.composite.part.PalladioComponentModelComposedStructureDiagramEditorPlugin;
import de.uka.ipd.sdq.pcm.gmf.composite.part.PalladioComponentModelVisualIDRegistry;
import de.uka.ipd.sdq.pcm.gmf.composite.providers.PalladioComponentModelElementTypes;
import de.uka.ipd.sdq.pcm.gmf.composite.providers.PalladioComponentModelParserProvider;

/**
 * @generated
 */
public class PalladioComponentModelNavigatorLabelProvider extends LabelProvider implements ICommonLabelProvider,
        ITreePathLabelProvider {

    /**
     * @generated
     */
    static {
        PalladioComponentModelComposedStructureDiagramEditorPlugin.getInstance().getImageRegistry()
                .put("Navigator?UnknownElement", ImageDescriptor.getMissingImageDescriptor()); //$NON-NLS-1$
        PalladioComponentModelComposedStructureDiagramEditorPlugin.getInstance().getImageRegistry()
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
            return PalladioComponentModelComposedStructureDiagramEditorPlugin.getInstance().getBundledImage(
                    group.getIcon());
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
        case AssemblyInfrastructureConnectorEditPart.VISUAL_ID:
            return getImage(
                    "Navigator?Link?http://sdq.ipd.uka.de/PalladioComponentModel/Core/Composition/5.0?AssemblyInfrastructureConnector", PalladioComponentModelElementTypes.AssemblyInfrastructureConnector_4008); //$NON-NLS-1$
        case EventChannelSinkConnectorEditPart.VISUAL_ID:
            return getImage(
                    "Navigator?Link?http://sdq.ipd.uka.de/PalladioComponentModel/Core/Composition/5.0?EventChannelSinkConnector", PalladioComponentModelElementTypes.EventChannelSinkConnector_4010); //$NON-NLS-1$
        case AssemblyEventConnectorEditPart.VISUAL_ID:
            return getImage(
                    "Navigator?Link?http://sdq.ipd.uka.de/PalladioComponentModel/Core/Composition/5.0?AssemblyEventConnector", PalladioComponentModelElementTypes.AssemblyEventConnector_4007); //$NON-NLS-1$
        case ProvidedDelegationConnectorEditPart.VISUAL_ID:
            return getImage(
                    "Navigator?Link?http://sdq.ipd.uka.de/PalladioComponentModel/Core/Composition/5.0?ProvidedDelegationConnector", PalladioComponentModelElementTypes.ProvidedDelegationConnector_4006); //$NON-NLS-1$
        case EventChannelEditPart.VISUAL_ID:
            return getImage(
                    "Navigator?Node?http://sdq.ipd.uka.de/PalladioComponentModel/Core/Composition/5.0?EventChannel", PalladioComponentModelElementTypes.EventChannel_3017); //$NON-NLS-1$
        case OperationRequiredRoleEditPart.VISUAL_ID:
            return getImage(
                    "Navigator?Node?http://sdq.ipd.uka.de/PalladioComponentModel/Repository/5.0?OperationRequiredRole", PalladioComponentModelElementTypes.OperationRequiredRole_3008); //$NON-NLS-1$
        case SourceRoleEditPart.VISUAL_ID:
            return getImage(
                    "Navigator?Node?http://sdq.ipd.uka.de/PalladioComponentModel/Repository/5.0?SourceRole", PalladioComponentModelElementTypes.SourceRole_3013); //$NON-NLS-1$
        case RequiredDelegationConnectorEditPart.VISUAL_ID:
            return getImage(
                    "Navigator?Link?http://sdq.ipd.uka.de/PalladioComponentModel/Core/Composition/5.0?RequiredDelegationConnector", PalladioComponentModelElementTypes.RequiredDelegationConnector_4005); //$NON-NLS-1$
        case ComposedProvidingRequiringEntityEditPart.VISUAL_ID:
            return getImage(
                    "Navigator?Diagram?http://sdq.ipd.uka.de/PalladioComponentModel/Core/Entity/5.0?ComposedProvidingRequiringEntity", PalladioComponentModelElementTypes.ComposedProvidingRequiringEntity_1000); //$NON-NLS-1$
        case SinkRoleEditPart.VISUAL_ID:
            return getImage(
                    "Navigator?Node?http://sdq.ipd.uka.de/PalladioComponentModel/Repository/5.0?SinkRole", PalladioComponentModelElementTypes.SinkRole_3014); //$NON-NLS-1$
        case InfrastructureRequiredRoleEditPart.VISUAL_ID:
            return getImage(
                    "Navigator?Node?http://sdq.ipd.uka.de/PalladioComponentModel/Repository/5.0?InfrastructureRequiredRole", PalladioComponentModelElementTypes.InfrastructureRequiredRole_3016); //$NON-NLS-1$
        case AssemblyContextEditPart.VISUAL_ID:
            return getImage(
                    "Navigator?Node?http://sdq.ipd.uka.de/PalladioComponentModel/Core/Composition/5.0?AssemblyContext", PalladioComponentModelElementTypes.AssemblyContext_3006); //$NON-NLS-1$
        case EventChannelSourceConnectorEditPart.VISUAL_ID:
            return getImage(
                    "Navigator?Link?http://sdq.ipd.uka.de/PalladioComponentModel/Core/Composition/5.0?EventChannelSourceConnector", PalladioComponentModelElementTypes.EventChannelSourceConnector_4009); //$NON-NLS-1$
        case OperationProvidedRoleEditPart.VISUAL_ID:
            return getImage(
                    "Navigator?Node?http://sdq.ipd.uka.de/PalladioComponentModel/Repository/5.0?OperationProvidedRole", PalladioComponentModelElementTypes.OperationProvidedRole_3007); //$NON-NLS-1$
        case OperationProvidedRole2EditPart.VISUAL_ID:
            return getImage(
                    "Navigator?Node?http://sdq.ipd.uka.de/PalladioComponentModel/Repository/5.0?OperationProvidedRole", PalladioComponentModelElementTypes.OperationProvidedRole_3011); //$NON-NLS-1$
        case ComposedProvidingRequiringEntity2EditPart.VISUAL_ID:
            return getImage(
                    "Navigator?TopLevelNode?http://sdq.ipd.uka.de/PalladioComponentModel/Core/Entity/5.0?ComposedProvidingRequiringEntity", PalladioComponentModelElementTypes.ComposedProvidingRequiringEntity_2002); //$NON-NLS-1$
        case AssemblyConnectorEditPart.VISUAL_ID:
            return getImage(
                    "Navigator?Link?http://sdq.ipd.uka.de/PalladioComponentModel/Core/Composition/5.0?AssemblyConnector", PalladioComponentModelElementTypes.AssemblyConnector_4004); //$NON-NLS-1$
        case OperationRequiredRole2EditPart.VISUAL_ID:
            return getImage(
                    "Navigator?Node?http://sdq.ipd.uka.de/PalladioComponentModel/Repository/5.0?OperationRequiredRole", PalladioComponentModelElementTypes.OperationRequiredRole_3012); //$NON-NLS-1$
        case InfrastructureProvidedRoleEditPart.VISUAL_ID:
            return getImage(
                    "Navigator?Node?http://sdq.ipd.uka.de/PalladioComponentModel/Repository/5.0?InfrastructureProvidedRole", PalladioComponentModelElementTypes.InfrastructureProvidedRole_3015); //$NON-NLS-1$
        }
        return getImage("Navigator?UnknownElement", null); //$NON-NLS-1$
    }

    /**
     * @generated
     */
    private Image getImage(String key, IElementType elementType) {
        ImageRegistry imageRegistry = PalladioComponentModelComposedStructureDiagramEditorPlugin.getInstance()
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
        case AssemblyInfrastructureConnectorEditPart.VISUAL_ID:
            return getAssemblyInfrastructureConnector_4008Text(view);
        case EventChannelSinkConnectorEditPart.VISUAL_ID:
            return getEventChannelSinkConnector_4010Text(view);
        case AssemblyEventConnectorEditPart.VISUAL_ID:
            return getAssemblyEventConnector_4007Text(view);
        case ProvidedDelegationConnectorEditPart.VISUAL_ID:
            return getProvidedDelegationConnector_4006Text(view);
        case EventChannelEditPart.VISUAL_ID:
            return getEventChannel_3017Text(view);
        case OperationRequiredRoleEditPart.VISUAL_ID:
            return getOperationRequiredRole_3008Text(view);
        case SourceRoleEditPart.VISUAL_ID:
            return getSourceRole_3013Text(view);
        case RequiredDelegationConnectorEditPart.VISUAL_ID:
            return getRequiredDelegationConnector_4005Text(view);
        case ComposedProvidingRequiringEntityEditPart.VISUAL_ID:
            return getComposedProvidingRequiringEntity_1000Text(view);
        case SinkRoleEditPart.VISUAL_ID:
            return getSinkRole_3014Text(view);
        case InfrastructureRequiredRoleEditPart.VISUAL_ID:
            return getInfrastructureRequiredRole_3016Text(view);
        case AssemblyContextEditPart.VISUAL_ID:
            return getAssemblyContext_3006Text(view);
        case EventChannelSourceConnectorEditPart.VISUAL_ID:
            return getEventChannelSourceConnector_4009Text(view);
        case OperationProvidedRoleEditPart.VISUAL_ID:
            return getOperationProvidedRole_3007Text(view);
        case OperationProvidedRole2EditPart.VISUAL_ID:
            return getOperationProvidedRole_3011Text(view);
        case ComposedProvidingRequiringEntity2EditPart.VISUAL_ID:
            return getComposedProvidingRequiringEntity_2002Text(view);
        case AssemblyConnectorEditPart.VISUAL_ID:
            return getAssemblyConnector_4004Text(view);
        case OperationRequiredRole2EditPart.VISUAL_ID:
            return getOperationRequiredRole_3012Text(view);
        case InfrastructureProvidedRoleEditPart.VISUAL_ID:
            return getInfrastructureProvidedRole_3015Text(view);
        }
        return getUnknownElementText(view);
    }

    /**
     * @generated
     */
    private String getAssemblyInfrastructureConnector_4008Text(View view) {
        AssemblyInfrastructureConnector domainModelElement = (AssemblyInfrastructureConnector) view.getElement();
        if (domainModelElement != null) {
            return domainModelElement.getId();
        } else {
            PalladioComponentModelComposedStructureDiagramEditorPlugin.getInstance().logError(
                    "No domain element for view with visualID = " + 4008); //$NON-NLS-1$
            return ""; //$NON-NLS-1$
        }
    }

    /**
     * @generated
     */
    private String getEventChannel_3017Text(View view) {
        IParser parser = PalladioComponentModelParserProvider.getParser(
                PalladioComponentModelElementTypes.EventChannel_3017, view.getElement() != null ? view.getElement()
                        : view, PalladioComponentModelVisualIDRegistry
                        .getType(EventChannelEntityNameEditPart.VISUAL_ID));
        if (parser != null) {
            return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
                    ParserOptions.NONE.intValue());
        } else {
            PalladioComponentModelComposedStructureDiagramEditorPlugin.getInstance().logError(
                    "Parser was not found for label " + 5019); //$NON-NLS-1$
            return ""; //$NON-NLS-1$
        }
    }

    /**
     * @generated
     */
    private String getOperationProvidedRole_3007Text(View view) {
        IParser parser = PalladioComponentModelParserProvider.getParser(
                PalladioComponentModelElementTypes.OperationProvidedRole_3007,
                view.getElement() != null ? view.getElement() : view,
                PalladioComponentModelVisualIDRegistry.getType(OperationProvidedRoleEntityNameEditPart.VISUAL_ID));
        if (parser != null) {
            return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
                    ParserOptions.NONE.intValue());
        } else {
            PalladioComponentModelComposedStructureDiagramEditorPlugin.getInstance().logError(
                    "Parser was not found for label " + 5007); //$NON-NLS-1$
            return ""; //$NON-NLS-1$
        }
    }

    /**
     * @generated
     */
    private String getRequiredDelegationConnector_4005Text(View view) {
        RequiredDelegationConnector domainModelElement = (RequiredDelegationConnector) view.getElement();
        if (domainModelElement != null) {
            return domainModelElement.getId();
        } else {
            PalladioComponentModelComposedStructureDiagramEditorPlugin.getInstance().logError(
                    "No domain element for view with visualID = " + 4005); //$NON-NLS-1$
            return ""; //$NON-NLS-1$
        }
    }

    /**
     * @generated
     */
    private String getProvidedDelegationConnector_4006Text(View view) {
        ProvidedDelegationConnector domainModelElement = (ProvidedDelegationConnector) view.getElement();
        if (domainModelElement != null) {
            return domainModelElement.getId();
        } else {
            PalladioComponentModelComposedStructureDiagramEditorPlugin.getInstance().logError(
                    "No domain element for view with visualID = " + 4006); //$NON-NLS-1$
            return ""; //$NON-NLS-1$
        }
    }

    /**
     * @generated
     */
    private String getAssemblyContext_3006Text(View view) {
        IParser parser = PalladioComponentModelParserProvider.getParser(
                PalladioComponentModelElementTypes.AssemblyContext_3006, view.getElement() != null ? view.getElement()
                        : view, PalladioComponentModelVisualIDRegistry
                        .getType(AssemblyContextEntityNameEditPart.VISUAL_ID));
        if (parser != null) {
            return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
                    ParserOptions.NONE.intValue());
        } else {
            PalladioComponentModelComposedStructureDiagramEditorPlugin.getInstance().logError(
                    "Parser was not found for label " + 5009); //$NON-NLS-1$
            return ""; //$NON-NLS-1$
        }
    }

    /**
     * @generated
     */
    private String getAssemblyEventConnector_4007Text(View view) {
        AssemblyEventConnector domainModelElement = (AssemblyEventConnector) view.getElement();
        if (domainModelElement != null) {
            return domainModelElement.getId();
        } else {
            PalladioComponentModelComposedStructureDiagramEditorPlugin.getInstance().logError(
                    "No domain element for view with visualID = " + 4007); //$NON-NLS-1$
            return ""; //$NON-NLS-1$
        }
    }

    /**
     * @generated
     */
    private String getSinkRole_3014Text(View view) {
        IParser parser = PalladioComponentModelParserProvider.getParser(
                PalladioComponentModelElementTypes.SinkRole_3014, view.getElement() != null ? view.getElement() : view,
                PalladioComponentModelVisualIDRegistry.getType(SinkRoleEntityNameEditPart.VISUAL_ID));
        if (parser != null) {
            return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
                    ParserOptions.NONE.intValue());
        } else {
            PalladioComponentModelComposedStructureDiagramEditorPlugin.getInstance().logError(
                    "Parser was not found for label " + 5016); //$NON-NLS-1$
            return ""; //$NON-NLS-1$
        }
    }

    /**
     * @generated
     */
    private String getComposedProvidingRequiringEntity_2002Text(View view) {
        IParser parser = PalladioComponentModelParserProvider.getParser(
                PalladioComponentModelElementTypes.ComposedProvidingRequiringEntity_2002,
                view.getElement() != null ? view.getElement() : view, PalladioComponentModelVisualIDRegistry
                        .getType(ComposedProvidingRequiringEntityEntityNameEditPart.VISUAL_ID));
        if (parser != null) {
            return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
                    ParserOptions.NONE.intValue());
        } else {
            PalladioComponentModelComposedStructureDiagramEditorPlugin.getInstance().logError(
                    "Parser was not found for label " + 5012); //$NON-NLS-1$
            return ""; //$NON-NLS-1$
        }
    }

    /**
     * @generated
     */
    private String getSourceRole_3013Text(View view) {
        IParser parser = PalladioComponentModelParserProvider.getParser(
                PalladioComponentModelElementTypes.SourceRole_3013, view.getElement() != null ? view.getElement()
                        : view, PalladioComponentModelVisualIDRegistry.getType(SourceRoleEntityNameEditPart.VISUAL_ID));
        if (parser != null) {
            return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
                    ParserOptions.NONE.intValue());
        } else {
            PalladioComponentModelComposedStructureDiagramEditorPlugin.getInstance().logError(
                    "Parser was not found for label " + 5015); //$NON-NLS-1$
            return ""; //$NON-NLS-1$
        }
    }

    /**
     * @generated
     */
    private String getInfrastructureProvidedRole_3015Text(View view) {
        IParser parser = PalladioComponentModelParserProvider.getParser(
                PalladioComponentModelElementTypes.InfrastructureProvidedRole_3015,
                view.getElement() != null ? view.getElement() : view,
                PalladioComponentModelVisualIDRegistry.getType(InfrastructureProvidedRoleEntityNameEditPart.VISUAL_ID));
        if (parser != null) {
            return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
                    ParserOptions.NONE.intValue());
        } else {
            PalladioComponentModelComposedStructureDiagramEditorPlugin.getInstance().logError(
                    "Parser was not found for label " + 5017); //$NON-NLS-1$
            return ""; //$NON-NLS-1$
        }
    }

    /**
     * @generated
     */
    private String getOperationRequiredRole_3008Text(View view) {
        IParser parser = PalladioComponentModelParserProvider.getParser(
                PalladioComponentModelElementTypes.OperationRequiredRole_3008,
                view.getElement() != null ? view.getElement() : view,
                PalladioComponentModelVisualIDRegistry.getType(OperationRequiredRoleEntityNameEditPart.VISUAL_ID));
        if (parser != null) {
            return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
                    ParserOptions.NONE.intValue());
        } else {
            PalladioComponentModelComposedStructureDiagramEditorPlugin.getInstance().logError(
                    "Parser was not found for label " + 5008); //$NON-NLS-1$
            return ""; //$NON-NLS-1$
        }
    }

    /**
     * @generated
     */
    private String getOperationProvidedRole_3011Text(View view) {
        IParser parser = PalladioComponentModelParserProvider.getParser(
                PalladioComponentModelElementTypes.OperationProvidedRole_3011,
                view.getElement() != null ? view.getElement() : view,
                PalladioComponentModelVisualIDRegistry.getType(OperationProvidedRoleEntityName2EditPart.VISUAL_ID));
        if (parser != null) {
            return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
                    ParserOptions.NONE.intValue());
        } else {
            PalladioComponentModelComposedStructureDiagramEditorPlugin.getInstance().logError(
                    "Parser was not found for label " + 5013); //$NON-NLS-1$
            return ""; //$NON-NLS-1$
        }
    }

    /**
     * @generated
     */
    private String getComposedProvidingRequiringEntity_1000Text(View view) {
        ComposedProvidingRequiringEntity domainModelElement = (ComposedProvidingRequiringEntity) view.getElement();
        if (domainModelElement != null) {
            return domainModelElement.getId();
        } else {
            PalladioComponentModelComposedStructureDiagramEditorPlugin.getInstance().logError(
                    "No domain element for view with visualID = " + 1000); //$NON-NLS-1$
            return ""; //$NON-NLS-1$
        }
    }

    /**
     * @generated
     */
    private String getEventChannelSourceConnector_4009Text(View view) {
        EventChannelSourceConnector domainModelElement = (EventChannelSourceConnector) view.getElement();
        if (domainModelElement != null) {
            return domainModelElement.getId();
        } else {
            PalladioComponentModelComposedStructureDiagramEditorPlugin.getInstance().logError(
                    "No domain element for view with visualID = " + 4009); //$NON-NLS-1$
            return ""; //$NON-NLS-1$
        }
    }

    /**
     * @generated
     */
    private String getOperationRequiredRole_3012Text(View view) {
        IParser parser = PalladioComponentModelParserProvider.getParser(
                PalladioComponentModelElementTypes.OperationRequiredRole_3012,
                view.getElement() != null ? view.getElement() : view,
                PalladioComponentModelVisualIDRegistry.getType(OperationRequiredRoleEntityName2EditPart.VISUAL_ID));
        if (parser != null) {
            return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
                    ParserOptions.NONE.intValue());
        } else {
            PalladioComponentModelComposedStructureDiagramEditorPlugin.getInstance().logError(
                    "Parser was not found for label " + 5014); //$NON-NLS-1$
            return ""; //$NON-NLS-1$
        }
    }

    /**
     * @generated
     */
    private String getInfrastructureRequiredRole_3016Text(View view) {
        IParser parser = PalladioComponentModelParserProvider.getParser(
                PalladioComponentModelElementTypes.InfrastructureRequiredRole_3016,
                view.getElement() != null ? view.getElement() : view,
                PalladioComponentModelVisualIDRegistry.getType(InfrastructureRequiredRoleEntityNameEditPart.VISUAL_ID));
        if (parser != null) {
            return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
                    ParserOptions.NONE.intValue());
        } else {
            PalladioComponentModelComposedStructureDiagramEditorPlugin.getInstance().logError(
                    "Parser was not found for label " + 5018); //$NON-NLS-1$
            return ""; //$NON-NLS-1$
        }
    }

    /**
     * @generated
     */
    private String getAssemblyConnector_4004Text(View view) {
        AssemblyConnector domainModelElement = (AssemblyConnector) view.getElement();
        if (domainModelElement != null) {
            return domainModelElement.getId();
        } else {
            PalladioComponentModelComposedStructureDiagramEditorPlugin.getInstance().logError(
                    "No domain element for view with visualID = " + 4004); //$NON-NLS-1$
            return ""; //$NON-NLS-1$
        }
    }

    /**
     * @generated
     */
    private String getEventChannelSinkConnector_4010Text(View view) {
        EventChannelSinkConnector domainModelElement = (EventChannelSinkConnector) view.getElement();
        if (domainModelElement != null) {
            return domainModelElement.getId();
        } else {
            PalladioComponentModelComposedStructureDiagramEditorPlugin.getInstance().logError(
                    "No domain element for view with visualID = " + 4010); //$NON-NLS-1$
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
        return ComposedProvidingRequiringEntityEditPart.MODEL_ID.equals(PalladioComponentModelVisualIDRegistry
                .getModelID(view));
    }

}
