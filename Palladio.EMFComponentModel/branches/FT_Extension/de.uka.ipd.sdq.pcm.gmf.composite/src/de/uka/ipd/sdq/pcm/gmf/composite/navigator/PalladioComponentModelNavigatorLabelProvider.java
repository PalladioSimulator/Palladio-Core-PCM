/*
 *Copyright 2007, SDQ, IPD, Uni Karlsruhe (TH)
 */
package de.uka.ipd.sdq.pcm.gmf.composite.navigator;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;
import org.eclipse.gmf.runtime.common.ui.services.parser.ParserOptions;
import org.eclipse.gmf.runtime.common.ui.services.parser.ParserService;
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

import de.uka.ipd.sdq.identifier.Identifier;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.parts.AssemblyConnectorEditPart;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.parts.AssemblyContextEditPart;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.parts.AssemblyContextEntityNameEditPart;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.parts.ComposedProvidingRequiringEntity2EditPart;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.parts.ComposedProvidingRequiringEntityEditPart;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.parts.ComposedProvidingRequiringEntityEntityNameEditPart;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.parts.ProvidedDelegationConnectorEditPart;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.parts.ProvidedRole2EditPart;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.parts.ProvidedRoleEditPart;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.parts.ProvidedRoleEntityName2EditPart;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.parts.ProvidedRoleEntityNameEditPart;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.parts.RequiredDelegationConnectorEditPart;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.parts.RequiredRole2EditPart;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.parts.RequiredRoleEditPart;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.parts.RequiredRoleEntityName2EditPart;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.parts.RequiredRoleEntityNameEditPart;
import de.uka.ipd.sdq.pcm.gmf.composite.part.PalladioComponentModelComposedStructureDiagramEditorPlugin;
import de.uka.ipd.sdq.pcm.gmf.composite.part.PalladioComponentModelVisualIDRegistry;
import de.uka.ipd.sdq.pcm.gmf.composite.providers.PalladioComponentModelElementTypes;

/**
 * @generated
 */
public class PalladioComponentModelNavigatorLabelProvider extends LabelProvider
		implements ICommonLabelProvider, ITreePathLabelProvider {

	/**
	 * @generated
	 */
	static {
		PalladioComponentModelComposedStructureDiagramEditorPlugin
				.getInstance().getImageRegistry().put(
						"Navigator?InvalidElement",
						ImageDescriptor.getMissingImageDescriptor());
		PalladioComponentModelComposedStructureDiagramEditorPlugin
				.getInstance().getImageRegistry().put(
						"Navigator?UnknownElement",
						ImageDescriptor.getMissingImageDescriptor());
		PalladioComponentModelComposedStructureDiagramEditorPlugin
				.getInstance().getImageRegistry().put(
						"Navigator?ImageNotFound",
						ImageDescriptor.getMissingImageDescriptor());
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
			return PalladioComponentModelComposedStructureDiagramEditorPlugin
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
		case ComposedProvidingRequiringEntity2EditPart.VISUAL_ID:
			return getImage(
					"Navigator?TopLevelNode?http://sdq.ipd.uka.de/PalladioComponentModel/Core/Entity/1.0?ComposedProvidingRequiringEntity",
					PalladioComponentModelElementTypes.ComposedProvidingRequiringEntity_2001);
		case AssemblyContextEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http://sdq.ipd.uka.de/PalladioComponentModel/Composition/1.0?AssemblyContext",
					PalladioComponentModelElementTypes.AssemblyContext_3002);
		case ProvidedRoleEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http://sdq.ipd.uka.de/PalladioComponentModel/Repository/1.0?ProvidedRole",
					PalladioComponentModelElementTypes.ProvidedRole_3001);
		case RequiredRoleEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http://sdq.ipd.uka.de/PalladioComponentModel/Repository/1.0?RequiredRole",
					PalladioComponentModelElementTypes.RequiredRole_3004);
		case ProvidedRole2EditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http://sdq.ipd.uka.de/PalladioComponentModel/Repository/1.0?ProvidedRole",
					PalladioComponentModelElementTypes.ProvidedRole_3003);
		case RequiredRole2EditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http://sdq.ipd.uka.de/PalladioComponentModel/Repository/1.0?RequiredRole",
					PalladioComponentModelElementTypes.RequiredRole_3005);
		case ComposedProvidingRequiringEntityEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Diagram?http://sdq.ipd.uka.de/PalladioComponentModel/Core/Entity/1.0?ComposedProvidingRequiringEntity",
					PalladioComponentModelElementTypes.ComposedProvidingRequiringEntity_1000);
		case AssemblyConnectorEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Link?http://sdq.ipd.uka.de/PalladioComponentModel/Composition/1.0?AssemblyConnector",
					PalladioComponentModelElementTypes.AssemblyConnector_4001);
		case RequiredDelegationConnectorEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Link?http://sdq.ipd.uka.de/PalladioComponentModel/Composition/1.0?RequiredDelegationConnector",
					PalladioComponentModelElementTypes.RequiredDelegationConnector_4002);
		case ProvidedDelegationConnectorEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Link?http://sdq.ipd.uka.de/PalladioComponentModel/Composition/1.0?ProvidedDelegationConnector",
					PalladioComponentModelElementTypes.ProvidedDelegationConnector_4003);
		default:
			return getImage("Navigator?UnknownElement", null);
		}
	}

	/**
	 * @generated
	 */
	private Image getImage(String key, IElementType elementType) {
		ImageRegistry imageRegistry = PalladioComponentModelComposedStructureDiagramEditorPlugin
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
			image = imageRegistry.get("Navigator?ImageNotFound");
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
		case ComposedProvidingRequiringEntity2EditPart.VISUAL_ID:
			return getComposedProvidingRequiringEntity_2001Text(view);
		case AssemblyContextEditPart.VISUAL_ID:
			return getAssemblyContext_3002Text(view);
		case ProvidedRoleEditPart.VISUAL_ID:
			return getProvidedRole_3001Text(view);
		case RequiredRoleEditPart.VISUAL_ID:
			return getRequiredRole_3004Text(view);
		case ProvidedRole2EditPart.VISUAL_ID:
			return getProvidedRole_3003Text(view);
		case RequiredRole2EditPart.VISUAL_ID:
			return getRequiredRole_3005Text(view);
		case ComposedProvidingRequiringEntityEditPart.VISUAL_ID:
			return getComposedProvidingRequiringEntity_1000Text(view);
		case AssemblyConnectorEditPart.VISUAL_ID:
			return getAssemblyConnector_4001Text(view);
		case RequiredDelegationConnectorEditPart.VISUAL_ID:
			return getRequiredDelegationConnector_4002Text(view);
		case ProvidedDelegationConnectorEditPart.VISUAL_ID:
			return getProvidedDelegationConnector_4003Text(view);
		default:
			return getUnknownElementText(view);
		}
	}

	/**
	 * @generated
	 */
	private String getComposedProvidingRequiringEntity_2001Text(View view) {
		IParser parser = ParserService.getInstance().getParser(
				new IAdaptable() {
					public Object getAdapter(Class adapter) {
						if (String.class.equals(adapter)) {
							return PalladioComponentModelVisualIDRegistry
									.getType(ComposedProvidingRequiringEntityEntityNameEditPart.VISUAL_ID);
						}
						if (IElementType.class.equals(adapter)) {
							return PalladioComponentModelElementTypes.ComposedProvidingRequiringEntity_2001;
						}
						return null;
					}
				});
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			PalladioComponentModelComposedStructureDiagramEditorPlugin
					.getInstance().logError(
							"Parser was not found for label " + 5002);
			return "";
		}
	}

	/**
	 * @generated
	 */
	private String getAssemblyContext_3002Text(View view) {
		IParser parser = ParserService.getInstance().getParser(
				new IAdaptable() {
					public Object getAdapter(Class adapter) {
						if (String.class.equals(adapter)) {
							return PalladioComponentModelVisualIDRegistry
									.getType(AssemblyContextEntityNameEditPart.VISUAL_ID);
						}
						if (IElementType.class.equals(adapter)) {
							return PalladioComponentModelElementTypes.AssemblyContext_3002;
						}
						return null;
					}
				});
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			PalladioComponentModelComposedStructureDiagramEditorPlugin
					.getInstance().logError(
							"Parser was not found for label " + 5004);
			return "";
		}
	}

	/**
	 * @generated
	 */
	private String getProvidedRole_3001Text(View view) {
		IParser parser = ParserService.getInstance().getParser(
				new IAdaptable() {
					public Object getAdapter(Class adapter) {
						if (String.class.equals(adapter)) {
							return PalladioComponentModelVisualIDRegistry
									.getType(ProvidedRoleEntityNameEditPart.VISUAL_ID);
						}
						if (IElementType.class.equals(adapter)) {
							return PalladioComponentModelElementTypes.ProvidedRole_3001;
						}
						return null;
					}
				});
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			PalladioComponentModelComposedStructureDiagramEditorPlugin
					.getInstance().logError(
							"Parser was not found for label " + 5001);
			return "";
		}
	}

	/**
	 * @generated
	 */
	private String getProvidedRole_3003Text(View view) {
		IParser parser = ParserService.getInstance().getParser(
				new IAdaptable() {
					public Object getAdapter(Class adapter) {
						if (String.class.equals(adapter)) {
							return PalladioComponentModelVisualIDRegistry
									.getType(ProvidedRoleEntityName2EditPart.VISUAL_ID);
						}
						if (IElementType.class.equals(adapter)) {
							return PalladioComponentModelElementTypes.ProvidedRole_3003;
						}
						return null;
					}
				});
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			PalladioComponentModelComposedStructureDiagramEditorPlugin
					.getInstance().logError(
							"Parser was not found for label " + 5003);
			return "";
		}
	}

	/**
	 * @generated
	 */
	private String getRequiredRole_3005Text(View view) {
		IParser parser = ParserService.getInstance().getParser(
				new IAdaptable() {
					public Object getAdapter(Class adapter) {
						if (String.class.equals(adapter)) {
							return PalladioComponentModelVisualIDRegistry
									.getType(RequiredRoleEntityName2EditPart.VISUAL_ID);
						}
						if (IElementType.class.equals(adapter)) {
							return PalladioComponentModelElementTypes.RequiredRole_3005;
						}
						return null;
					}
				});
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			PalladioComponentModelComposedStructureDiagramEditorPlugin
					.getInstance().logError(
							"Parser was not found for label " + 5006);
			return "";
		}
	}

	/**
	 * @generated
	 */
	private String getRequiredRole_3004Text(View view) {
		IParser parser = ParserService.getInstance().getParser(
				new IAdaptable() {
					public Object getAdapter(Class adapter) {
						if (String.class.equals(adapter)) {
							return PalladioComponentModelVisualIDRegistry
									.getType(RequiredRoleEntityNameEditPart.VISUAL_ID);
						}
						if (IElementType.class.equals(adapter)) {
							return PalladioComponentModelElementTypes.RequiredRole_3004;
						}
						return null;
					}
				});
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			PalladioComponentModelComposedStructureDiagramEditorPlugin
					.getInstance().logError(
							"Parser was not found for label " + 5005);
			return "";
		}
	}

	/**
	 * @generated
	 */
	private String getComposedProvidingRequiringEntity_1000Text(View view) {
		EObject domainModelElement = view.getElement();
		if (domainModelElement != null) {
			return ((Identifier) domainModelElement).getId();
		} else {
			PalladioComponentModelComposedStructureDiagramEditorPlugin
					.getInstance()
					.logError(
							"No domain element for view with visualID = " + 1000);
			return "";
		}
	}

	/**
	 * @generated
	 */
	private String getAssemblyConnector_4001Text(View view) {
		EObject domainModelElement = view.getElement();
		if (domainModelElement != null) {
			return ((Identifier) domainModelElement).getId();
		} else {
			PalladioComponentModelComposedStructureDiagramEditorPlugin
					.getInstance()
					.logError(
							"No domain element for view with visualID = " + 4001);
			return "";
		}
	}

	/**
	 * @generated
	 */
	private String getRequiredDelegationConnector_4002Text(View view) {
		EObject domainModelElement = view.getElement();
		if (domainModelElement != null) {
			return ((Identifier) domainModelElement).getId();
		} else {
			PalladioComponentModelComposedStructureDiagramEditorPlugin
					.getInstance()
					.logError(
							"No domain element for view with visualID = " + 4002);
			return "";
		}
	}

	/**
	 * @generated
	 */
	private String getProvidedDelegationConnector_4003Text(View view) {
		EObject domainModelElement = view.getElement();
		if (domainModelElement != null) {
			return ((Identifier) domainModelElement).getId();
		} else {
			PalladioComponentModelComposedStructureDiagramEditorPlugin
					.getInstance()
					.logError(
							"No domain element for view with visualID = " + 4003);
			return "";
		}
	}

	/**
	 * @generated
	 */
	private String getUnknownElementText(View view) {
		return "<UnknownElement Visual_ID = " + view.getType() + ">";
	}

	/**
	 * @generated
	 */
	private String getUnresolvedDomainElementProxyText(View view) {
		return "<Unresolved domain element Visual_ID = " + view.getType() + ">";
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
		return ComposedProvidingRequiringEntityEditPart.MODEL_ID
				.equals(PalladioComponentModelVisualIDRegistry.getModelID(view));
	}

}
