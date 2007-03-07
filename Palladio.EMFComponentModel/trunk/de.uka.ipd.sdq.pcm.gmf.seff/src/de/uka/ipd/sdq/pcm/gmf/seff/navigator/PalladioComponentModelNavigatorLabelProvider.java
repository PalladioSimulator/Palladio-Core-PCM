/*
 *Copyright 2006 SDQ Research Group, University of Karlsruhe (TH)
 */
package de.uka.ipd.sdq.pcm.gmf.seff.navigator;

import de.uka.ipd.sdq.identifier.Identifier;

import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.AbstractActionSuccessor_AbstractActionEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.BranchAction2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.BranchActionEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.BranchActionEntityName2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.BranchActionEntityNameEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ExternalCallAction2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ExternalCallActionEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ExternalCallActionEntityName2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ExternalCallActionEntityNameEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.InternalAction2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.InternalActionEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.InternalActionEntityName2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.InternalActionEntityNameEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.LoopAction2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.LoopActionEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.LoopActionEntityName2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.LoopActionEntityNameEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ParametricResourceDemandEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ProbabilisticBranchTransitionBranchProbabilityEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ProbabilisticBranchTransitionEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ResourceDemandingBehaviour2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ResourceDemandingBehaviourEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ResourceDemandingSEFFEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.StartAction2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.StartActionEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.StopAction2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.StopActionEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.VariableCharacterisationEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.VariableUsageEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.VariableUsageReferenceLabelEditPart;

import de.uka.ipd.sdq.pcm.gmf.seff.part.PalladioComponentModelSeffDiagramEditorPlugin;
import de.uka.ipd.sdq.pcm.gmf.seff.part.PalladioComponentModelVisualIDRegistry;

import de.uka.ipd.sdq.pcm.gmf.seff.providers.PalladioComponentModelElementTypes;

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

/**
 * @generated
 */
public class PalladioComponentModelNavigatorLabelProvider extends LabelProvider
		implements ICommonLabelProvider, ITreePathLabelProvider {

	/**
	 * @generated
	 */
	static {
		PalladioComponentModelSeffDiagramEditorPlugin.getInstance()
				.getImageRegistry().put("Navigator?InvalidElement",
						ImageDescriptor.getMissingImageDescriptor());
		PalladioComponentModelSeffDiagramEditorPlugin.getInstance()
				.getImageRegistry().put("Navigator?UnknownElement",
						ImageDescriptor.getMissingImageDescriptor());
		PalladioComponentModelSeffDiagramEditorPlugin.getInstance()
				.getImageRegistry().put("Navigator?ImageNotFound",
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
			return PalladioComponentModelSeffDiagramEditorPlugin.getInstance()
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
		case StartActionEditPart.VISUAL_ID:
			return getImage(
					"Navigator?TopLevelNode?http://sdq.ipd.uka.de/PalladioComponentModel/SEFF/1.0?StartAction",
					PalladioComponentModelElementTypes.StartAction_2001);
		case StopActionEditPart.VISUAL_ID:
			return getImage(
					"Navigator?TopLevelNode?http://sdq.ipd.uka.de/PalladioComponentModel/SEFF/1.0?StopAction",
					PalladioComponentModelElementTypes.StopAction_2002);
		case ExternalCallActionEditPart.VISUAL_ID:
			return getImage(
					"Navigator?TopLevelNode?http://sdq.ipd.uka.de/PalladioComponentModel/SEFF/1.0?ExternalCallAction",
					PalladioComponentModelElementTypes.ExternalCallAction_2003);
		case LoopActionEditPart.VISUAL_ID:
			return getImage(
					"Navigator?TopLevelNode?http://sdq.ipd.uka.de/PalladioComponentModel/SEFF/1.0?LoopAction",
					PalladioComponentModelElementTypes.LoopAction_2004);
		case BranchAction2EditPart.VISUAL_ID:
			return getImage(
					"Navigator?TopLevelNode?http://sdq.ipd.uka.de/PalladioComponentModel/SEFF/1.0?BranchAction",
					PalladioComponentModelElementTypes.BranchAction_2005);
		case InternalAction2EditPart.VISUAL_ID:
			return getImage(
					"Navigator?TopLevelNode?http://sdq.ipd.uka.de/PalladioComponentModel/SEFF/1.0?InternalAction",
					PalladioComponentModelElementTypes.InternalAction_2006);
		case VariableUsageEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http://sdq.ipd.uka.de/PalladioComponentModel/Parameter/1.0?VariableUsage",
					PalladioComponentModelElementTypes.VariableUsage_3001);
		case VariableCharacterisationEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http://sdq.ipd.uka.de/PalladioComponentModel/Parameter/1.0?VariableCharacterisation",
					PalladioComponentModelElementTypes.VariableCharacterisation_3002);
		case ResourceDemandingBehaviourEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http://sdq.ipd.uka.de/PalladioComponentModel/SEFF/1.0?ResourceDemandingBehaviour",
					PalladioComponentModelElementTypes.ResourceDemandingBehaviour_3003);
		case StartAction2EditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http://sdq.ipd.uka.de/PalladioComponentModel/SEFF/1.0?StartAction",
					PalladioComponentModelElementTypes.StartAction_3004);
		case StopAction2EditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http://sdq.ipd.uka.de/PalladioComponentModel/SEFF/1.0?StopAction",
					PalladioComponentModelElementTypes.StopAction_3005);
		case LoopAction2EditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http://sdq.ipd.uka.de/PalladioComponentModel/SEFF/1.0?LoopAction",
					PalladioComponentModelElementTypes.LoopAction_3006);
		case InternalActionEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http://sdq.ipd.uka.de/PalladioComponentModel/SEFF/1.0?InternalAction",
					PalladioComponentModelElementTypes.InternalAction_3007);
		case ParametricResourceDemandEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http://sdq.ipd.uka.de/PalladioComponentModel/SEFF/1.0?ParametricResourceDemand",
					PalladioComponentModelElementTypes.ParametricResourceDemand_3008);
		case BranchActionEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http://sdq.ipd.uka.de/PalladioComponentModel/SEFF/1.0?BranchAction",
					PalladioComponentModelElementTypes.BranchAction_3009);
		case ProbabilisticBranchTransitionEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http://sdq.ipd.uka.de/PalladioComponentModel/SEFF/1.0?ProbabilisticBranchTransition",
					PalladioComponentModelElementTypes.ProbabilisticBranchTransition_3010);
		case ResourceDemandingBehaviour2EditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http://sdq.ipd.uka.de/PalladioComponentModel/SEFF/1.0?ResourceDemandingBehaviour",
					PalladioComponentModelElementTypes.ResourceDemandingBehaviour_3011);
		case ExternalCallAction2EditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http://sdq.ipd.uka.de/PalladioComponentModel/SEFF/1.0?ExternalCallAction",
					PalladioComponentModelElementTypes.ExternalCallAction_3012);
		case ResourceDemandingSEFFEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Diagram?http://sdq.ipd.uka.de/PalladioComponentModel/SEFF/1.0?ResourceDemandingSEFF",
					PalladioComponentModelElementTypes.ResourceDemandingSEFF_1000);
		case AbstractActionSuccessor_AbstractActionEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Link?http://sdq.ipd.uka.de/PalladioComponentModel/SEFF/1.0?AbstractAction?successor_AbstractAction",
					PalladioComponentModelElementTypes.AbstractActionSuccessor_AbstractAction_4001);
		default:
			return getImage("Navigator?UnknownElement", null);
		}
	}

	/**
	 * @generated
	 */
	private Image getImage(String key, IElementType elementType) {
		ImageRegistry imageRegistry = PalladioComponentModelSeffDiagramEditorPlugin
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
		switch (PalladioComponentModelVisualIDRegistry.getVisualID(view)) {
		case StartActionEditPart.VISUAL_ID:
			return getStartAction_2001Text(view);
		case StopActionEditPart.VISUAL_ID:
			return getStopAction_2002Text(view);
		case ExternalCallActionEditPart.VISUAL_ID:
			return getExternalCallAction_2003Text(view);
		case LoopActionEditPart.VISUAL_ID:
			return getLoopAction_2004Text(view);
		case BranchAction2EditPart.VISUAL_ID:
			return getBranchAction_2005Text(view);
		case InternalAction2EditPart.VISUAL_ID:
			return getInternalAction_2006Text(view);
		case VariableUsageEditPart.VISUAL_ID:
			return getVariableUsage_3001Text(view);
		case VariableCharacterisationEditPart.VISUAL_ID:
			return getVariableCharacterisation_3002Text(view);
		case ResourceDemandingBehaviourEditPart.VISUAL_ID:
			return getResourceDemandingBehaviour_3003Text(view);
		case StartAction2EditPart.VISUAL_ID:
			return getStartAction_3004Text(view);
		case StopAction2EditPart.VISUAL_ID:
			return getStopAction_3005Text(view);
		case LoopAction2EditPart.VISUAL_ID:
			return getLoopAction_3006Text(view);
		case InternalActionEditPart.VISUAL_ID:
			return getInternalAction_3007Text(view);
		case ParametricResourceDemandEditPart.VISUAL_ID:
			return getParametricResourceDemand_3008Text(view);
		case BranchActionEditPart.VISUAL_ID:
			return getBranchAction_3009Text(view);
		case ProbabilisticBranchTransitionEditPart.VISUAL_ID:
			return getProbabilisticBranchTransition_3010Text(view);
		case ResourceDemandingBehaviour2EditPart.VISUAL_ID:
			return getResourceDemandingBehaviour_3011Text(view);
		case ExternalCallAction2EditPart.VISUAL_ID:
			return getExternalCallAction_3012Text(view);
		case ResourceDemandingSEFFEditPart.VISUAL_ID:
			return getResourceDemandingSEFF_1000Text(view);
		case AbstractActionSuccessor_AbstractActionEditPart.VISUAL_ID:
			return getAbstractActionSuccessor_AbstractAction_4001Text(view);
		default:
			return getUnknownElementText(view);
		}
	}

	/**
	 * @generated
	 */
	private String getStartAction_2001Text(View view) {
		EObject domainModelElement = view.getElement();
		if (domainModelElement != null) {
			return ((Identifier) domainModelElement).getId();
		} else {
			PalladioComponentModelSeffDiagramEditorPlugin
					.getInstance()
					.logError(
							"No domain element for view with visualID = " + 2001);
			return "";
		}
	}

	/**
	 * @generated
	 */
	private String getStopAction_2002Text(View view) {
		EObject domainModelElement = view.getElement();
		if (domainModelElement != null) {
			return ((Identifier) domainModelElement).getId();
		} else {
			PalladioComponentModelSeffDiagramEditorPlugin
					.getInstance()
					.logError(
							"No domain element for view with visualID = " + 2002);
			return "";
		}
	}

	/**
	 * @generated
	 */
	private String getExternalCallAction_2003Text(View view) {
		IParser parser = ParserService.getInstance().getParser(
				new IAdaptable() {
					public Object getAdapter(Class adapter) {
						if (String.class.equals(adapter)) {
							return PalladioComponentModelVisualIDRegistry
									.getType(ExternalCallActionEntityNameEditPart.VISUAL_ID);
						}
						if (IElementType.class.equals(adapter)) {
							return PalladioComponentModelElementTypes.ExternalCallAction_2003;
						}
						return null;
					}
				});
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			PalladioComponentModelSeffDiagramEditorPlugin.getInstance()
					.logError("Parser was not found for label " + 5002);
			return "";
		}
	}

	/**
	 * @generated
	 */
	private String getLoopAction_2004Text(View view) {
		IParser parser = ParserService.getInstance().getParser(
				new IAdaptable() {
					public Object getAdapter(Class adapter) {
						if (String.class.equals(adapter)) {
							return PalladioComponentModelVisualIDRegistry
									.getType(LoopActionEntityName2EditPart.VISUAL_ID);
						}
						if (IElementType.class.equals(adapter)) {
							return PalladioComponentModelElementTypes.LoopAction_2004;
						}
						return null;
					}
				});
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			PalladioComponentModelSeffDiagramEditorPlugin.getInstance()
					.logError("Parser was not found for label " + 5009);
			return "";
		}
	}

	/**
	 * @generated
	 */
	private String getBranchAction_2005Text(View view) {
		IParser parser = ParserService.getInstance().getParser(
				new IAdaptable() {
					public Object getAdapter(Class adapter) {
						if (String.class.equals(adapter)) {
							return PalladioComponentModelVisualIDRegistry
									.getType(BranchActionEntityName2EditPart.VISUAL_ID);
						}
						if (IElementType.class.equals(adapter)) {
							return PalladioComponentModelElementTypes.BranchAction_2005;
						}
						return null;
					}
				});
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			PalladioComponentModelSeffDiagramEditorPlugin.getInstance()
					.logError("Parser was not found for label " + 5011);
			return "";
		}
	}

	/**
	 * @generated
	 */
	private String getInternalAction_2006Text(View view) {
		IParser parser = ParserService.getInstance().getParser(
				new IAdaptable() {
					public Object getAdapter(Class adapter) {
						if (String.class.equals(adapter)) {
							return PalladioComponentModelVisualIDRegistry
									.getType(InternalActionEntityName2EditPart.VISUAL_ID);
						}
						if (IElementType.class.equals(adapter)) {
							return PalladioComponentModelElementTypes.InternalAction_2006;
						}
						return null;
					}
				});
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			PalladioComponentModelSeffDiagramEditorPlugin.getInstance()
					.logError("Parser was not found for label " + 5012);
			return "";
		}
	}

	/**
	 * @generated
	 */
	private String getVariableUsage_3001Text(View view) {
		IParser parser = ParserService.getInstance().getParser(
				new IAdaptable() {
					public Object getAdapter(Class adapter) {
						if (String.class.equals(adapter)) {
							return PalladioComponentModelVisualIDRegistry
									.getType(VariableUsageReferenceLabelEditPart.VISUAL_ID);
						}
						if (IElementType.class.equals(adapter)) {
							return PalladioComponentModelElementTypes.VariableUsage_3001;
						}
						return null;
					}
				});
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			PalladioComponentModelSeffDiagramEditorPlugin.getInstance()
					.logError("Parser was not found for label " + 5001);
			return "";
		}
	}

	/**
	 * @generated
	 */
	private String getVariableCharacterisation_3002Text(View view) {
		IParser parser = ParserService.getInstance().getParser(
				new IAdaptable() {
					public Object getAdapter(Class adapter) {
						if (String.class.equals(adapter)) {
							return PalladioComponentModelVisualIDRegistry
									.getType(VariableCharacterisationEditPart.VISUAL_ID);
						}
						if (IElementType.class.equals(adapter)) {
							return PalladioComponentModelElementTypes.VariableCharacterisation_3002;
						}
						return null;
					}
				});
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			PalladioComponentModelSeffDiagramEditorPlugin.getInstance()
					.logError("Parser was not found for label " + 3002);
			return "";
		}
	}

	/**
	 * @generated
	 */
	private String getResourceDemandingBehaviour_3003Text(View view) {
		return "";
	}

	/**
	 * @generated
	 */
	private String getStartAction_3004Text(View view) {
		EObject domainModelElement = view.getElement();
		if (domainModelElement != null) {
			return ((Identifier) domainModelElement).getId();
		} else {
			PalladioComponentModelSeffDiagramEditorPlugin
					.getInstance()
					.logError(
							"No domain element for view with visualID = " + 3004);
			return "";
		}
	}

	/**
	 * @generated
	 */
	private String getStopAction_3005Text(View view) {
		EObject domainModelElement = view.getElement();
		if (domainModelElement != null) {
			return ((Identifier) domainModelElement).getId();
		} else {
			PalladioComponentModelSeffDiagramEditorPlugin
					.getInstance()
					.logError(
							"No domain element for view with visualID = " + 3005);
			return "";
		}
	}

	/**
	 * @generated
	 */
	private String getLoopAction_3006Text(View view) {
		IParser parser = ParserService.getInstance().getParser(
				new IAdaptable() {
					public Object getAdapter(Class adapter) {
						if (String.class.equals(adapter)) {
							return PalladioComponentModelVisualIDRegistry
									.getType(LoopActionEntityNameEditPart.VISUAL_ID);
						}
						if (IElementType.class.equals(adapter)) {
							return PalladioComponentModelElementTypes.LoopAction_3006;
						}
						return null;
					}
				});
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			PalladioComponentModelSeffDiagramEditorPlugin.getInstance()
					.logError("Parser was not found for label " + 5003);
			return "";
		}
	}

	/**
	 * @generated
	 */
	private String getInternalAction_3007Text(View view) {
		IParser parser = ParserService.getInstance().getParser(
				new IAdaptable() {
					public Object getAdapter(Class adapter) {
						if (String.class.equals(adapter)) {
							return PalladioComponentModelVisualIDRegistry
									.getType(InternalActionEntityNameEditPart.VISUAL_ID);
						}
						if (IElementType.class.equals(adapter)) {
							return PalladioComponentModelElementTypes.InternalAction_3007;
						}
						return null;
					}
				});
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			PalladioComponentModelSeffDiagramEditorPlugin.getInstance()
					.logError("Parser was not found for label " + 5005);
			return "";
		}
	}

	/**
	 * @generated
	 */
	private String getParametricResourceDemand_3008Text(View view) {
		IParser parser = ParserService.getInstance().getParser(
				new IAdaptable() {
					public Object getAdapter(Class adapter) {
						if (String.class.equals(adapter)) {
							return PalladioComponentModelVisualIDRegistry
									.getType(ParametricResourceDemandEditPart.VISUAL_ID);
						}
						if (IElementType.class.equals(adapter)) {
							return PalladioComponentModelElementTypes.ParametricResourceDemand_3008;
						}
						return null;
					}
				});
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			PalladioComponentModelSeffDiagramEditorPlugin.getInstance()
					.logError("Parser was not found for label " + 3008);
			return "";
		}
	}

	/**
	 * @generated
	 */
	private String getBranchAction_3009Text(View view) {
		IParser parser = ParserService.getInstance().getParser(
				new IAdaptable() {
					public Object getAdapter(Class adapter) {
						if (String.class.equals(adapter)) {
							return PalladioComponentModelVisualIDRegistry
									.getType(BranchActionEntityNameEditPart.VISUAL_ID);
						}
						if (IElementType.class.equals(adapter)) {
							return PalladioComponentModelElementTypes.BranchAction_3009;
						}
						return null;
					}
				});
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			PalladioComponentModelSeffDiagramEditorPlugin.getInstance()
					.logError("Parser was not found for label " + 5008);
			return "";
		}
	}

	/**
	 * @generated
	 */
	private String getProbabilisticBranchTransition_3010Text(View view) {
		IParser parser = ParserService.getInstance().getParser(
				new IAdaptable() {
					public Object getAdapter(Class adapter) {
						if (String.class.equals(adapter)) {
							return PalladioComponentModelVisualIDRegistry
									.getType(ProbabilisticBranchTransitionBranchProbabilityEditPart.VISUAL_ID);
						}
						if (IElementType.class.equals(adapter)) {
							return PalladioComponentModelElementTypes.ProbabilisticBranchTransition_3010;
						}
						return null;
					}
				});
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			PalladioComponentModelSeffDiagramEditorPlugin.getInstance()
					.logError("Parser was not found for label " + 5007);
			return "";
		}
	}

	/**
	 * @generated
	 */
	private String getResourceDemandingBehaviour_3011Text(View view) {
		return "";
	}

	/**
	 * @generated
	 */
	private String getExternalCallAction_3012Text(View view) {
		IParser parser = ParserService.getInstance().getParser(
				new IAdaptable() {
					public Object getAdapter(Class adapter) {
						if (String.class.equals(adapter)) {
							return PalladioComponentModelVisualIDRegistry
									.getType(ExternalCallActionEntityName2EditPart.VISUAL_ID);
						}
						if (IElementType.class.equals(adapter)) {
							return PalladioComponentModelElementTypes.ExternalCallAction_3012;
						}
						return null;
					}
				});
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			PalladioComponentModelSeffDiagramEditorPlugin.getInstance()
					.logError("Parser was not found for label " + 5006);
			return "";
		}
	}

	/**
	 * @generated
	 */
	private String getResourceDemandingSEFF_1000Text(View view) {
		EObject domainModelElement = view.getElement();
		if (domainModelElement != null) {
			return ((Identifier) domainModelElement).getId();
		} else {
			PalladioComponentModelSeffDiagramEditorPlugin
					.getInstance()
					.logError(
							"No domain element for view with visualID = " + 1000);
			return "";
		}
	}

	/**
	 * @generated
	 */
	private String getAbstractActionSuccessor_AbstractAction_4001Text(View view) {
		return "";
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
		return ResourceDemandingSEFFEditPart.MODEL_ID
				.equals(PalladioComponentModelVisualIDRegistry.getModelID(view));
	}

}
