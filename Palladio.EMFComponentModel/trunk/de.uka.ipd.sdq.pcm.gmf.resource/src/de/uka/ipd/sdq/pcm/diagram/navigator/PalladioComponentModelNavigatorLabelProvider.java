package de.uka.ipd.sdq.pcm.diagram.navigator;

import org.eclipse.core.runtime.IAdaptable;
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

import de.uka.ipd.sdq.pcm.diagram.edit.parts.CommunicationLinkResourceSpecificationEditPart;
import de.uka.ipd.sdq.pcm.diagram.edit.parts.LinkingResourceEditPart;
import de.uka.ipd.sdq.pcm.diagram.edit.parts.ProcessingResourceSpecificationEditPart;
import de.uka.ipd.sdq.pcm.diagram.edit.parts.ProcessingResourceSpecificationMTTFEditPart;
import de.uka.ipd.sdq.pcm.diagram.edit.parts.ResourceContainerEditPart;
import de.uka.ipd.sdq.pcm.diagram.edit.parts.ResourceContainerEntityNameEditPart;
import de.uka.ipd.sdq.pcm.diagram.edit.parts.ResourceEnvironmentEditPart;
import de.uka.ipd.sdq.pcm.diagram.part.PalladioComponentModelDiagramEditorPlugin;
import de.uka.ipd.sdq.pcm.diagram.part.PalladioComponentModelVisualIDRegistry;
import de.uka.ipd.sdq.pcm.diagram.providers.PalladioComponentModelElementTypes;
import de.uka.ipd.sdq.pcm.diagram.providers.PalladioComponentModelParserProvider;
import de.uka.ipd.sdq.pcm.resourceenvironment.CommunicationLinkResourceSpecification;
import de.uka.ipd.sdq.pcm.resourceenvironment.LinkingResource;

/**
 * @generated
 */
public class PalladioComponentModelNavigatorLabelProvider extends LabelProvider
		implements ICommonLabelProvider, ITreePathLabelProvider {

	/**
	 * @generated
	 */
	static {
		PalladioComponentModelDiagramEditorPlugin
				.getInstance()
				.getImageRegistry()
				.put(
						"Navigator?UnknownElement", ImageDescriptor.getMissingImageDescriptor()); //$NON-NLS-1$
		PalladioComponentModelDiagramEditorPlugin
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
			return PalladioComponentModelDiagramEditorPlugin.getInstance()
					.getBundledImage(group.getIcon());
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
		case ResourceEnvironmentEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Diagram?http://sdq.ipd.uka.de/PalladioComponentModel/ResourceEnvironment/4.0?ResourceEnvironment", PalladioComponentModelElementTypes.ResourceEnvironment_1000); //$NON-NLS-1$
		case ResourceContainerEditPart.VISUAL_ID:
			return getImage(
					"Navigator?TopLevelNode?http://sdq.ipd.uka.de/PalladioComponentModel/ResourceEnvironment/4.0?ResourceContainer", PalladioComponentModelElementTypes.ResourceContainer_2001); //$NON-NLS-1$
		case CommunicationLinkResourceSpecificationEditPart.VISUAL_ID:
			return getImage(
					"Navigator?TopLevelNode?http://sdq.ipd.uka.de/PalladioComponentModel/ResourceEnvironment/4.0?CommunicationLinkResourceSpecification", PalladioComponentModelElementTypes.CommunicationLinkResourceSpecification_2002); //$NON-NLS-1$
		case ProcessingResourceSpecificationEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http://sdq.ipd.uka.de/PalladioComponentModel/ResourceEnvironment/4.0?ProcessingResourceSpecification", PalladioComponentModelElementTypes.ProcessingResourceSpecification_3001); //$NON-NLS-1$
		case LinkingResourceEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Link?http://sdq.ipd.uka.de/PalladioComponentModel/ResourceEnvironment/4.0?LinkingResource", PalladioComponentModelElementTypes.LinkingResource_4001); //$NON-NLS-1$
		}
		return getImage("Navigator?UnknownElement", null); //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private Image getImage(String key, IElementType elementType) {
		ImageRegistry imageRegistry = PalladioComponentModelDiagramEditorPlugin
				.getInstance().getImageRegistry();
		Image image = imageRegistry.get(key);
		if (image == null && elementType != null
				&& PalladioComponentModelElementTypes.isKnownElementType(elementType)) {
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
		case ResourceEnvironmentEditPart.VISUAL_ID:
			return getResourceEnvironment_1000Text(view);
		case ResourceContainerEditPart.VISUAL_ID:
			return getResourceContainer_2001Text(view);
		case CommunicationLinkResourceSpecificationEditPart.VISUAL_ID:
			return getCommunicationLinkResourceSpecification_2002Text(view);
		case ProcessingResourceSpecificationEditPart.VISUAL_ID:
			return getProcessingResourceSpecification_3001Text(view);
		case LinkingResourceEditPart.VISUAL_ID:
			return getLinkingResource_4001Text(view);
		}
		return getUnknownElementText(view);
	}

	/**
	 * @generated
	 */
	private String getResourceEnvironment_1000Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getResourceContainer_2001Text(View view) {
		IAdaptable hintAdapter = new PalladioComponentModelParserProvider.HintAdapter(
				PalladioComponentModelElementTypes.ResourceContainer_2001, (view
						.getElement() != null ? view.getElement() : view),
				PalladioComponentModelVisualIDRegistry
						.getType(ResourceContainerEntityNameEditPart.VISUAL_ID));
		IParser parser = ParserService.getInstance().getParser(hintAdapter);

		if (parser != null) {
			return parser.getPrintString(hintAdapter, ParserOptions.NONE.intValue());
		} else {
			PalladioComponentModelDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5001); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}

	}

	/**
	 * @generated
	 */
	private String getCommunicationLinkResourceSpecification_2002Text(View view) {
		CommunicationLinkResourceSpecification domainModelElement = (CommunicationLinkResourceSpecification) view
				.getElement();
		if (domainModelElement != null) {
			return String.valueOf(domainModelElement.getFailureProbability());
		} else {
			PalladioComponentModelDiagramEditorPlugin.getInstance().logError(
					"No domain element for view with visualID = " + 2002); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getProcessingResourceSpecification_3001Text(View view) {
		IAdaptable hintAdapter = new PalladioComponentModelParserProvider.HintAdapter(
				PalladioComponentModelElementTypes.ProcessingResourceSpecification_3001,
				(view.getElement() != null ? view.getElement() : view),
				PalladioComponentModelVisualIDRegistry
						.getType(ProcessingResourceSpecificationMTTFEditPart.VISUAL_ID));
		IParser parser = ParserService.getInstance().getParser(hintAdapter);

		if (parser != null) {
			return parser.getPrintString(hintAdapter, ParserOptions.NONE.intValue());
		} else {
			PalladioComponentModelDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5002); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}

	}

	/**
	 * @generated
	 */
	private String getLinkingResource_4001Text(View view) {
		LinkingResource domainModelElement = (LinkingResource) view.getElement();
		if (domainModelElement != null) {
			return domainModelElement.getId();
		} else {
			PalladioComponentModelDiagramEditorPlugin.getInstance().logError(
					"No domain element for view with visualID = " + 4001); //$NON-NLS-1$
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
		return ResourceEnvironmentEditPart.MODEL_ID
				.equals(PalladioComponentModelVisualIDRegistry.getModelID(view));
	}

}
