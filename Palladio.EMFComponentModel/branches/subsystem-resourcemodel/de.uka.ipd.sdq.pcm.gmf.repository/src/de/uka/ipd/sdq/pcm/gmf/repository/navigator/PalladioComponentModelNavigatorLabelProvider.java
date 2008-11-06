/*
 * Copyright 2007, IPD, SDQ, University of Karlsruhe
 */
package de.uka.ipd.sdq.pcm.gmf.repository.navigator;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.gmf.runtime.common.ui.services.parser.CommonParserHint;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;
import org.eclipse.gmf.runtime.common.ui.services.parser.ParserOptions;
import org.eclipse.gmf.runtime.common.ui.services.parser.ParserService;
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
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.ImplementationComponentTypeParentCompleteComponentTypesEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.InterfaceEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.InterfaceEntityNameEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.PassiveResourceEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.ProvidedRoleEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.ProvidesComponentTypeEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.ProvidesComponentTypeEntityNameEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.RepositoryEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.RequiredRoleEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.ResourceDemandingSEFFEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.ResourceRequiredRoleEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.SignatureEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.VariableCharacterisationEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.VariableUsageEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.WrapLabelEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.part.PalladioComponentModelRepositoryDiagramEditorPlugin;
import de.uka.ipd.sdq.pcm.gmf.repository.part.PalladioComponentModelVisualIDRegistry;
import de.uka.ipd.sdq.pcm.gmf.repository.providers.PalladioComponentModelElementTypes;
import de.uka.ipd.sdq.pcm.gmf.repository.providers.PalladioComponentModelParserProvider;
import de.uka.ipd.sdq.pcm.repository.Repository;
import de.uka.ipd.sdq.pcm.repository.ResourceRequiredRole;

/**
 * @generated
 */
public class PalladioComponentModelNavigatorLabelProvider extends LabelProvider
		implements ICommonLabelProvider, ITreePathLabelProvider {

	/**
	 * @generated
	 */
	static {
		PalladioComponentModelRepositoryDiagramEditorPlugin
				.getInstance()
				.getImageRegistry()
				.put(
						"Navigator?UnknownElement", ImageDescriptor.getMissingImageDescriptor()); //$NON-NLS-1$
		PalladioComponentModelRepositoryDiagramEditorPlugin
				.getInstance()
				.getImageRegistry()
				.put(
						"Navigator?ImageNotFound", ImageDescriptor.getMissingImageDescriptor()); //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	public void updateLabel(ViewerLabel label, TreePath elementPath) {
		Object element = elementPath.getLastSegment();
		if (element instanceof PalladioComponentModelNavigatorItem
				&& !isOwnView(((PalladioComponentModelNavigatorItem) element)
						.getView())) {
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
			return PalladioComponentModelRepositoryDiagramEditorPlugin
					.getInstance().getBundledImage(group.getIcon());
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
		case RepositoryEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Diagram?http://sdq.ipd.uka.de/PalladioComponentModel/Repository/1.0?Repository", PalladioComponentModelElementTypes.Repository_1000); //$NON-NLS-1$
		case InterfaceEditPart.VISUAL_ID:
			return getImage(
					"Navigator?TopLevelNode?http://sdq.ipd.uka.de/PalladioComponentModel/Repository/1.0?Interface", PalladioComponentModelElementTypes.Interface_2101); //$NON-NLS-1$
		case BasicComponentEditPart.VISUAL_ID:
			return getImage(
					"Navigator?TopLevelNode?http://sdq.ipd.uka.de/PalladioComponentModel/Repository/1.0?BasicComponent", PalladioComponentModelElementTypes.BasicComponent_2102); //$NON-NLS-1$
		case CompositeComponentEditPart.VISUAL_ID:
			return getImage(
					"Navigator?TopLevelNode?http://sdq.ipd.uka.de/PalladioComponentModel/Repository/1.0?CompositeComponent", PalladioComponentModelElementTypes.CompositeComponent_2105); //$NON-NLS-1$
		case CompleteComponentTypeEditPart.VISUAL_ID:
			return getImage(
					"Navigator?TopLevelNode?http://sdq.ipd.uka.de/PalladioComponentModel/Repository/1.0?CompleteComponentType", PalladioComponentModelElementTypes.CompleteComponentType_2103); //$NON-NLS-1$
		case ProvidesComponentTypeEditPart.VISUAL_ID:
			return getImage(
					"Navigator?TopLevelNode?http://sdq.ipd.uka.de/PalladioComponentModel/Repository/1.0?ProvidesComponentType", PalladioComponentModelElementTypes.ProvidesComponentType_2104); //$NON-NLS-1$
		case SignatureEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http://sdq.ipd.uka.de/PalladioComponentModel/Repository/1.0?Signature", PalladioComponentModelElementTypes.Signature_3101); //$NON-NLS-1$
		case ResourceDemandingSEFFEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http://sdq.ipd.uka.de/PalladioComponentModel/SEFF/1.0?ResourceDemandingSEFF", PalladioComponentModelElementTypes.ResourceDemandingSEFF_3102); //$NON-NLS-1$
		case PassiveResourceEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http://sdq.ipd.uka.de/PalladioComponentModel/Repository/1.0?PassiveResource", PalladioComponentModelElementTypes.PassiveResource_3103); //$NON-NLS-1$
		case VariableUsageEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http://sdq.ipd.uka.de/PalladioComponentModel/Parameter/1.0?VariableUsage", PalladioComponentModelElementTypes.VariableUsage_3104); //$NON-NLS-1$
		case VariableCharacterisationEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http://sdq.ipd.uka.de/PalladioComponentModel/Parameter/1.0?VariableCharacterisation", PalladioComponentModelElementTypes.VariableCharacterisation_3105); //$NON-NLS-1$
		case ProvidedRoleEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Link?http://sdq.ipd.uka.de/PalladioComponentModel/Repository/1.0?ProvidedRole", PalladioComponentModelElementTypes.ProvidedRole_4101); //$NON-NLS-1$
		case RequiredRoleEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Link?http://sdq.ipd.uka.de/PalladioComponentModel/Repository/1.0?RequiredRole", PalladioComponentModelElementTypes.RequiredRole_4102); //$NON-NLS-1$
		case ImplementationComponentTypeParentCompleteComponentTypesEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Link?http://sdq.ipd.uka.de/PalladioComponentModel/Repository/1.0?ImplementationComponentType?parentCompleteComponentTypes", PalladioComponentModelElementTypes.ImplementationComponentTypeParentCompleteComponentTypes_4103); //$NON-NLS-1$
		case CompleteComponentTypeParentProvidesComponentTypesEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Link?http://sdq.ipd.uka.de/PalladioComponentModel/Repository/1.0?CompleteComponentType?parentProvidesComponentTypes", PalladioComponentModelElementTypes.CompleteComponentTypeParentProvidesComponentTypes_4104); //$NON-NLS-1$
		case ResourceRequiredRoleEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Link?http://sdq.ipd.uka.de/PalladioComponentModel/Repository/1.0?ResourceRequiredRole", PalladioComponentModelElementTypes.ResourceRequiredRole_4105); //$NON-NLS-1$
		}
		return getImage("Navigator?UnknownElement", null); //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private Image getImage(String key, IElementType elementType) {
		ImageRegistry imageRegistry = PalladioComponentModelRepositoryDiagramEditorPlugin
				.getInstance().getImageRegistry();
		Image image = imageRegistry.get(key);
		if (image == null
				&& elementType != null
				&& PalladioComponentModelElementTypes
						.isKnownElementType(elementType)) {
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
		case RepositoryEditPart.VISUAL_ID:
			return getRepository_1000Text(view);
		case InterfaceEditPart.VISUAL_ID:
			return getInterface_2101Text(view);
		case BasicComponentEditPart.VISUAL_ID:
			return getBasicComponent_2102Text(view);
		case CompositeComponentEditPart.VISUAL_ID:
			return getCompositeComponent_2105Text(view);
		case CompleteComponentTypeEditPart.VISUAL_ID:
			return getCompleteComponentType_2103Text(view);
		case ProvidesComponentTypeEditPart.VISUAL_ID:
			return getProvidesComponentType_2104Text(view);
		case SignatureEditPart.VISUAL_ID:
			return getSignature_3101Text(view);
		case ResourceDemandingSEFFEditPart.VISUAL_ID:
			return getResourceDemandingSEFF_3102Text(view);
		case PassiveResourceEditPart.VISUAL_ID:
			return getPassiveResource_3103Text(view);
		case VariableUsageEditPart.VISUAL_ID:
			return getVariableUsage_3104Text(view);
		case VariableCharacterisationEditPart.VISUAL_ID:
			return getVariableCharacterisation_3105Text(view);
		case ProvidedRoleEditPart.VISUAL_ID:
			return getProvidedRole_4101Text(view);
		case RequiredRoleEditPart.VISUAL_ID:
			return getRequiredRole_4102Text(view);
		case ImplementationComponentTypeParentCompleteComponentTypesEditPart.VISUAL_ID:
			return getImplementationComponentTypeParentCompleteComponentTypes_4103Text(view);
		case CompleteComponentTypeParentProvidesComponentTypesEditPart.VISUAL_ID:
			return getCompleteComponentTypeParentProvidesComponentTypes_4104Text(view);
		case ResourceRequiredRoleEditPart.VISUAL_ID:
			return getResourceRequiredRole_4105Text(view);
		}
		return getUnknownElementText(view);
	}

	/**
	 * @generated
	 */
	private String getRepository_1000Text(View view) {
		Repository domainModelElement = (Repository) view.getElement();
		if (domainModelElement != null) {
			return domainModelElement.getId();
		} else {
			PalladioComponentModelRepositoryDiagramEditorPlugin
					.getInstance()
					.logError(
							"No domain element for view with visualID = " + 1000); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getInterface_2101Text(View view) {
		IAdaptable hintAdapter = new PalladioComponentModelParserProvider.HintAdapter(
				PalladioComponentModelElementTypes.Interface_2101, (view
						.getElement() != null ? view.getElement() : view),
				PalladioComponentModelVisualIDRegistry
						.getType(InterfaceEntityNameEditPart.VISUAL_ID));
		IParser parser = ParserService.getInstance().getParser(hintAdapter);

		if (parser != null) {
			return parser.getPrintString(hintAdapter, ParserOptions.NONE
					.intValue());
		} else {
			PalladioComponentModelRepositoryDiagramEditorPlugin.getInstance()
					.logError("Parser was not found for label " + 5101); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}

	}

	/**
	 * @generated
	 */
	private String getBasicComponent_2102Text(View view) {
		IAdaptable hintAdapter = new PalladioComponentModelParserProvider.HintAdapter(
				PalladioComponentModelElementTypes.BasicComponent_2102, (view
						.getElement() != null ? view.getElement() : view),
				PalladioComponentModelVisualIDRegistry
						.getType(BasicComponentEntityNameEditPart.VISUAL_ID));
		IParser parser = ParserService.getInstance().getParser(hintAdapter);

		if (parser != null) {
			return parser.getPrintString(hintAdapter, ParserOptions.NONE
					.intValue());
		} else {
			PalladioComponentModelRepositoryDiagramEditorPlugin.getInstance()
					.logError("Parser was not found for label " + 5102); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}

	}

	/**
	 * @generated
	 */
	private String getCompleteComponentType_2103Text(View view) {
		IAdaptable hintAdapter = new PalladioComponentModelParserProvider.HintAdapter(
				PalladioComponentModelElementTypes.CompleteComponentType_2103,
				(view.getElement() != null ? view.getElement() : view),
				PalladioComponentModelVisualIDRegistry
						.getType(CompleteComponentTypeEntityNameEditPart.VISUAL_ID));
		IParser parser = ParserService.getInstance().getParser(hintAdapter);

		if (parser != null) {
			return parser.getPrintString(hintAdapter, ParserOptions.NONE
					.intValue());
		} else {
			PalladioComponentModelRepositoryDiagramEditorPlugin.getInstance()
					.logError("Parser was not found for label " + 5103); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}

	}

	/**
	 * @generated
	 */
	private String getProvidesComponentType_2104Text(View view) {
		IAdaptable hintAdapter = new PalladioComponentModelParserProvider.HintAdapter(
				PalladioComponentModelElementTypes.ProvidesComponentType_2104,
				(view.getElement() != null ? view.getElement() : view),
				PalladioComponentModelVisualIDRegistry
						.getType(ProvidesComponentTypeEntityNameEditPart.VISUAL_ID));
		IParser parser = ParserService.getInstance().getParser(hintAdapter);

		if (parser != null) {
			return parser.getPrintString(hintAdapter, ParserOptions.NONE
					.intValue());
		} else {
			PalladioComponentModelRepositoryDiagramEditorPlugin.getInstance()
					.logError("Parser was not found for label " + 5104); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}

	}

	/**
	 * @generated
	 */
	private String getCompositeComponent_2105Text(View view) {
		IAdaptable hintAdapter = new PalladioComponentModelParserProvider.HintAdapter(
				PalladioComponentModelElementTypes.CompositeComponent_2105,
				(view.getElement() != null ? view.getElement() : view),
				PalladioComponentModelVisualIDRegistry
						.getType(CompositeComponentEntityNameEditPart.VISUAL_ID));
		IParser parser = ParserService.getInstance().getParser(hintAdapter);

		if (parser != null) {
			return parser.getPrintString(hintAdapter, ParserOptions.NONE
					.intValue());
		} else {
			PalladioComponentModelRepositoryDiagramEditorPlugin.getInstance()
					.logError("Parser was not found for label " + 5105); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}

	}

	/**
	 * @generated
	 */
	private String getSignature_3101Text(View view) {
		IAdaptable hintAdapter = new PalladioComponentModelParserProvider.HintAdapter(
				PalladioComponentModelElementTypes.Signature_3101, (view
						.getElement() != null ? view.getElement() : view),
				PalladioComponentModelVisualIDRegistry
						.getType(SignatureEditPart.VISUAL_ID));
		IParser parser = ParserService.getInstance().getParser(hintAdapter);

		if (parser != null) {
			return parser.getPrintString(hintAdapter, ParserOptions.NONE
					.intValue());
		} else {
			PalladioComponentModelRepositoryDiagramEditorPlugin.getInstance()
					.logError("Parser was not found for label " + 3101); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getResourceDemandingSEFF_3102Text(View view) {
		IAdaptable hintAdapter = new PalladioComponentModelParserProvider.HintAdapter(
				PalladioComponentModelElementTypes.ResourceDemandingSEFF_3102,
				(view.getElement() != null ? view.getElement() : view),
				PalladioComponentModelVisualIDRegistry
						.getType(ResourceDemandingSEFFEditPart.VISUAL_ID));
		IParser parser = ParserService.getInstance().getParser(hintAdapter);

		if (parser != null) {
			return parser.getPrintString(hintAdapter, ParserOptions.NONE
					.intValue());
		} else {
			PalladioComponentModelRepositoryDiagramEditorPlugin.getInstance()
					.logError("Parser was not found for label " + 3102); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getPassiveResource_3103Text(View view) {
		IAdaptable hintAdapter = new PalladioComponentModelParserProvider.HintAdapter(
				PalladioComponentModelElementTypes.PassiveResource_3103, (view
						.getElement() != null ? view.getElement() : view),
				PalladioComponentModelVisualIDRegistry
						.getType(PassiveResourceEditPart.VISUAL_ID));
		IParser parser = ParserService.getInstance().getParser(hintAdapter);

		if (parser != null) {
			return parser.getPrintString(hintAdapter, ParserOptions.NONE
					.intValue());
		} else {
			PalladioComponentModelRepositoryDiagramEditorPlugin.getInstance()
					.logError("Parser was not found for label " + 3103); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getVariableUsage_3104Text(View view) {

		IAdaptable hintAdapter = new PalladioComponentModelParserProvider.HintAdapter(
				PalladioComponentModelElementTypes.VariableUsage_3104, (view
						.getElement() != null ? view.getElement() : view),
				PalladioComponentModelVisualIDRegistry
						.getType(WrapLabelEditPart.VISUAL_ID));
		IParser parser = ParserService.getInstance().getParser(hintAdapter);
		if (parser != null) {
			return parser.getPrintString(hintAdapter, ParserOptions.NONE
					.intValue());
		} else {
			return ""; //$NON-NLS-1$
		}

	}

	/**
	 * @generated
	 */
	private String getVariableCharacterisation_3105Text(View view) {
		IAdaptable hintAdapter = new PalladioComponentModelParserProvider.HintAdapter(
				PalladioComponentModelElementTypes.VariableCharacterisation_3105,
				(view.getElement() != null ? view.getElement() : view),
				PalladioComponentModelVisualIDRegistry
						.getType(VariableCharacterisationEditPart.VISUAL_ID));
		IParser parser = ParserService.getInstance().getParser(hintAdapter);

		if (parser != null) {
			return parser.getPrintString(hintAdapter, ParserOptions.NONE
					.intValue());
		} else {
			PalladioComponentModelRepositoryDiagramEditorPlugin.getInstance()
					.logError("Parser was not found for label " + 3105); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getProvidedRole_4101Text(View view) {
		IAdaptable hintAdapter = new PalladioComponentModelParserProvider.HintAdapter(
				PalladioComponentModelElementTypes.ProvidedRole_4101, (view
						.getElement() != null ? view.getElement() : view),
				CommonParserHint.DESCRIPTION);
		IParser parser = ParserService.getInstance().getParser(hintAdapter);

		if (parser != null) {
			return parser.getPrintString(hintAdapter, ParserOptions.NONE
					.intValue());
		} else {
			PalladioComponentModelRepositoryDiagramEditorPlugin.getInstance()
					.logError("Parser was not found for label " + 6101); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}

	}

	/**
	 * @generated
	 */
	private String getRequiredRole_4102Text(View view) {
		IAdaptable hintAdapter = new PalladioComponentModelParserProvider.HintAdapter(
				PalladioComponentModelElementTypes.RequiredRole_4102, (view
						.getElement() != null ? view.getElement() : view),
				CommonParserHint.DESCRIPTION);
		IParser parser = ParserService.getInstance().getParser(hintAdapter);

		if (parser != null) {
			return parser.getPrintString(hintAdapter, ParserOptions.NONE
					.intValue());
		} else {
			PalladioComponentModelRepositoryDiagramEditorPlugin.getInstance()
					.logError("Parser was not found for label " + 6102); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}

	}

	/**
	 * @generated
	 */
	private String getImplementationComponentTypeParentCompleteComponentTypes_4103Text(
			View view) {
		IAdaptable hintAdapter = new PalladioComponentModelParserProvider.HintAdapter(
				PalladioComponentModelElementTypes.ImplementationComponentTypeParentCompleteComponentTypes_4103,
				(view.getElement() != null ? view.getElement() : view),
				CommonParserHint.DESCRIPTION);
		IParser parser = ParserService.getInstance().getParser(hintAdapter);

		if (parser != null) {
			return parser.getPrintString(hintAdapter, ParserOptions.NONE
					.intValue());
		} else {
			PalladioComponentModelRepositoryDiagramEditorPlugin.getInstance()
					.logError("Parser was not found for label " + 6103); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}

	}

	/**
	 * @generated
	 */
	private String getCompleteComponentTypeParentProvidesComponentTypes_4104Text(
			View view) {
		IAdaptable hintAdapter = new PalladioComponentModelParserProvider.HintAdapter(
				PalladioComponentModelElementTypes.CompleteComponentTypeParentProvidesComponentTypes_4104,
				(view.getElement() != null ? view.getElement() : view),
				CommonParserHint.DESCRIPTION);
		IParser parser = ParserService.getInstance().getParser(hintAdapter);

		if (parser != null) {
			return parser.getPrintString(hintAdapter, ParserOptions.NONE
					.intValue());
		} else {
			PalladioComponentModelRepositoryDiagramEditorPlugin.getInstance()
					.logError("Parser was not found for label " + 6104); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}

	}

	/**
	 * @generated
	 */
	private String getResourceRequiredRole_4105Text(View view) {
		IAdaptable hintAdapter = new PalladioComponentModelParserProvider.HintAdapter(
				PalladioComponentModelElementTypes.ResourceRequiredRole_4105,
				(view.getElement() != null ? view.getElement() : view),
				CommonParserHint.DESCRIPTION);
		IParser parser = ParserService.getInstance().getParser(hintAdapter);

		if (parser != null) {
			return parser.getPrintString(hintAdapter, ParserOptions.NONE
					.intValue());
		} else {
			PalladioComponentModelRepositoryDiagramEditorPlugin.getInstance()
					.logError("Parser was not found for label " + 6105); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}

	}

	/**
	 * @generated
	 */
	private String getUnknownElementText(View view) {
		return "<UnknownElement Visual_ID = " + view.getType() + ">"; //$NON-NLS-1$ //$NON-NLS-2$
	}

	/**
	 * @generated
	 */
	private String getUnresolvedDomainElementProxyText(View view) {
		return "<Unresolved domain element Visual_ID = " + view.getType() + ">"; //$NON-NLS-1$ //$NON-NLS-2$
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
		return RepositoryEditPart.MODEL_ID
				.equals(PalladioComponentModelVisualIDRegistry.getModelID(view));
	}

}
