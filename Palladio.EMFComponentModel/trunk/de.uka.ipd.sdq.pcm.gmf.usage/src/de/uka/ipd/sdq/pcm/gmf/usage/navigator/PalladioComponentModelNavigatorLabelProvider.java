/*
 *Copyright 2007, SDQ, IPD, University of Karlsruhe
 */
package de.uka.ipd.sdq.pcm.gmf.usage.navigator;

import de.uka.ipd.sdq.identifier.Identifier;

import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.AbstractUserActionEditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.AbstractUserActionSuccessorEditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.BranchEditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.BranchTransitionBranchProbabilityEditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.BranchTransitionEditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.ClosedWorkloadEditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.ClosedWorkloadPopulationEditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.ClosedWorkloadTitleLabelEditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.ComponentExternalCallNameLabelEditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.EntryLevelSystemCallEditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.LoopEditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.OpenWorkloadEditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.ScenarioBehaviour2EditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.ScenarioBehaviour3EditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.ScenarioBehaviourEditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.ScenarioBehaviourId2EditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.ScenarioBehaviourId3EditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.ScenarioBehaviourIdEditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.StartEditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.StopEditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.UsageLoopIterationsLabelEditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.UsageScenarioEditPart;

import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.VariableCharacterisationEditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.VariableUsageEditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.VariableUsageReferenceLabelEditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.part.PalladioComponentModelUsageDiagramEditorPlugin;
import de.uka.ipd.sdq.pcm.gmf.usage.part.PalladioComponentModelVisualIDRegistry;

import de.uka.ipd.sdq.pcm.gmf.usage.providers.PalladioComponentModelElementTypes;

import de.uka.ipd.sdq.pcm.usagemodel.BranchTransition;
import de.uka.ipd.sdq.stoex.RandomVariable;
import org.eclipse.core.runtime.IAdaptable;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.gmf.runtime.common.ui.services.parser.CommonParserHint;
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
		PalladioComponentModelUsageDiagramEditorPlugin.getInstance()
				.getImageRegistry().put("Navigator?InvalidElement",
						ImageDescriptor.getMissingImageDescriptor());
		PalladioComponentModelUsageDiagramEditorPlugin.getInstance()
				.getImageRegistry().put("Navigator?UnknownElement",
						ImageDescriptor.getMissingImageDescriptor());
		PalladioComponentModelUsageDiagramEditorPlugin.getInstance()
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
			return PalladioComponentModelUsageDiagramEditorPlugin.getInstance()
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
		case ScenarioBehaviourEditPart.VISUAL_ID:
			return getImage(
					"Navigator?TopLevelNode?http://sdq.ipd.uka.de/PalladioComponentModel/UsageModel/1.0?ScenarioBehaviour",
					PalladioComponentModelElementTypes.ScenarioBehaviour_2001);
		case ClosedWorkloadEditPart.VISUAL_ID:
			return getImage(
					"Navigator?TopLevelNode?http://sdq.ipd.uka.de/PalladioComponentModel/UsageModel/1.0?ClosedWorkload",
					PalladioComponentModelElementTypes.ClosedWorkload_2002);
		case OpenWorkloadEditPart.VISUAL_ID:
			return getImage(
					"Navigator?TopLevelNode?http://sdq.ipd.uka.de/PalladioComponentModel/UsageModel/1.0?OpenWorkload",
					PalladioComponentModelElementTypes.OpenWorkload_2003);
		case StartEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http://sdq.ipd.uka.de/PalladioComponentModel/UsageModel/1.0?Start",
					PalladioComponentModelElementTypes.Start_3001);
		case StopEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http://sdq.ipd.uka.de/PalladioComponentModel/UsageModel/1.0?Stop",
					PalladioComponentModelElementTypes.Stop_3002);
		case EntryLevelSystemCallEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http://sdq.ipd.uka.de/PalladioComponentModel/UsageModel/1.0?EntryLevelSystemCall",
					PalladioComponentModelElementTypes.EntryLevelSystemCall_3003);
		case VariableUsageEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http://sdq.ipd.uka.de/PalladioComponentModel/Parameter/1.0?VariableUsage",
					PalladioComponentModelElementTypes.VariableUsage_3004);
		case VariableCharacterisationEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http://sdq.ipd.uka.de/PalladioComponentModel/Parameter/1.0?VariableCharacterisation",
					PalladioComponentModelElementTypes.VariableCharacterisation_3006);
		case LoopEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http://sdq.ipd.uka.de/PalladioComponentModel/UsageModel/1.0?Loop",
					PalladioComponentModelElementTypes.Loop_3005);
		case ScenarioBehaviour2EditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http://sdq.ipd.uka.de/PalladioComponentModel/UsageModel/1.0?ScenarioBehaviour",
					PalladioComponentModelElementTypes.ScenarioBehaviour_3007);
		case BranchEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http://sdq.ipd.uka.de/PalladioComponentModel/UsageModel/1.0?Branch",
					PalladioComponentModelElementTypes.Branch_3008);
		case BranchTransitionEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http://sdq.ipd.uka.de/PalladioComponentModel/UsageModel/1.0?BranchTransition",
					PalladioComponentModelElementTypes.BranchTransition_3009);
		case ScenarioBehaviour3EditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http://sdq.ipd.uka.de/PalladioComponentModel/UsageModel/1.0?ScenarioBehaviour",
					PalladioComponentModelElementTypes.ScenarioBehaviour_3010);
		case UsageScenarioEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Diagram?http://sdq.ipd.uka.de/PalladioComponentModel/UsageModel/1.0?UsageScenario",
					PalladioComponentModelElementTypes.UsageScenario_1000);
		case AbstractUserActionSuccessorEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Link?http://sdq.ipd.uka.de/PalladioComponentModel/UsageModel/1.0?AbstractUserAction?successor",
					PalladioComponentModelElementTypes.AbstractUserActionSuccessor_4002);
		default:
			return getImage("Navigator?UnknownElement", null);
		}
	}

	/**
	 * @generated
	 */
	private Image getImage(String key, IElementType elementType) {
		ImageRegistry imageRegistry = PalladioComponentModelUsageDiagramEditorPlugin
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
		case ScenarioBehaviourEditPart.VISUAL_ID:
			return getScenarioBehaviour_2001Text(view);
		case ClosedWorkloadEditPart.VISUAL_ID:
			return getClosedWorkload_2002Text(view);
		case OpenWorkloadEditPart.VISUAL_ID:
			return getOpenWorkload_2003Text(view);
		case StartEditPart.VISUAL_ID:
			return getStart_3001Text(view);
		case StopEditPart.VISUAL_ID:
			return getStop_3002Text(view);
		case EntryLevelSystemCallEditPart.VISUAL_ID:
			return getEntryLevelSystemCall_3003Text(view);
		case VariableUsageEditPart.VISUAL_ID:
			return getVariableUsage_3004Text(view);
		case VariableCharacterisationEditPart.VISUAL_ID:
			return getVariableCharacterisation_3006Text(view);
		case LoopEditPart.VISUAL_ID:
			return getLoop_3005Text(view);
		case ScenarioBehaviour2EditPart.VISUAL_ID:
			return getScenarioBehaviour_3007Text(view);
		case BranchEditPart.VISUAL_ID:
			return getBranch_3008Text(view);
		case BranchTransitionEditPart.VISUAL_ID:
			return getBranchTransition_3009Text(view);
		case ScenarioBehaviour3EditPart.VISUAL_ID:
			return getScenarioBehaviour_3010Text(view);
		case UsageScenarioEditPart.VISUAL_ID:
			return getUsageScenario_1000Text(view);
		case AbstractUserActionSuccessorEditPart.VISUAL_ID:
			return getAbstractUserActionSuccessor_4002Text(view);
		default:
			return getUnknownElementText(view);
		}
	}

	/**
	 * @generated
	 */
	private String getScenarioBehaviour_2001Text(View view) {
		EObject domainModelElement = view.getElement();
		if (domainModelElement != null) {
			return ((Identifier) domainModelElement).getId();
		} else {
			PalladioComponentModelUsageDiagramEditorPlugin
					.getInstance()
					.logError(
							"No domain element for view with visualID = " + 2001);
			return "";
		}
	}

	/**
	 * @generated
	 */
	private String getClosedWorkload_2002Text(View view) {
		IParser parser = ParserService.getInstance().getParser(
				new IAdaptable() {
					public Object getAdapter(Class adapter) {
						if (String.class.equals(adapter)) {
							return PalladioComponentModelVisualIDRegistry
									.getType(ClosedWorkloadTitleLabelEditPart.VISUAL_ID);
						}
						if (IElementType.class.equals(adapter)) {
							return PalladioComponentModelElementTypes.ClosedWorkload_2002;
						}
						return null;
					}
				});
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			PalladioComponentModelUsageDiagramEditorPlugin.getInstance()
					.logError("Parser was not found for label " + 5002);
			return "";
		}
	}

	/**
	 * @generated
	 */
	private String getOpenWorkload_2003Text(View view) {
		return "";
	}

	/**
	 * @generated
	 */
	private String getStart_3001Text(View view) {
		return "";
	}

	/**
	 * @generated
	 */
	private String getStop_3002Text(View view) {
		return "";
	}

	/**
	 * @generated
	 */
	private String getEntryLevelSystemCall_3003Text(View view) {
		IParser parser = ParserService.getInstance().getParser(
				new IAdaptable() {
					public Object getAdapter(Class adapter) {
						if (String.class.equals(adapter)) {
							return PalladioComponentModelVisualIDRegistry
									.getType(ComponentExternalCallNameLabelEditPart.VISUAL_ID);
						}
						if (IElementType.class.equals(adapter)) {
							return PalladioComponentModelElementTypes.EntryLevelSystemCall_3003;
						}
						return null;
					}
				});
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			PalladioComponentModelUsageDiagramEditorPlugin.getInstance()
					.logError("Parser was not found for label " + 5004);
			return "";
		}
	}

	/**
	 * @generated
	 */
	private String getVariableUsage_3004Text(View view) {
		IParser parser = ParserService.getInstance().getParser(
				new IAdaptable() {
					public Object getAdapter(Class adapter) {
						if (String.class.equals(adapter)) {
							return PalladioComponentModelVisualIDRegistry
									.getType(VariableUsageReferenceLabelEditPart.VISUAL_ID);
						}
						if (IElementType.class.equals(adapter)) {
							return PalladioComponentModelElementTypes.VariableUsage_3004;
						}
						return null;
					}
				});
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			PalladioComponentModelUsageDiagramEditorPlugin.getInstance()
					.logError("Parser was not found for label " + 5006);
			return "";
		}
	}

	/**
	 * @generated
	 */
	private String getVariableCharacterisation_3006Text(View view) {
		IParser parser = ParserService.getInstance().getParser(
				new IAdaptable() {
					public Object getAdapter(Class adapter) {
						if (String.class.equals(adapter)) {
							return PalladioComponentModelVisualIDRegistry
									.getType(VariableCharacterisationEditPart.VISUAL_ID);
						}
						if (IElementType.class.equals(adapter)) {
							return PalladioComponentModelElementTypes.VariableCharacterisation_3006;
						}
						return null;
					}
				});
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			PalladioComponentModelUsageDiagramEditorPlugin.getInstance()
					.logError("Parser was not found for label " + 3006);
			return "";
		}
	}

	/**
	 * @generated
	 */
	private String getLoop_3005Text(View view) {
		IParser parser = ParserService.getInstance().getParser(
				new IAdaptable() {
					public Object getAdapter(Class adapter) {
						if (String.class.equals(adapter)) {
							return PalladioComponentModelVisualIDRegistry
									.getType(UsageLoopIterationsLabelEditPart.VISUAL_ID);
						}
						if (IElementType.class.equals(adapter)) {
							return PalladioComponentModelElementTypes.Loop_3005;
						}
						return null;
					}
				});
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			PalladioComponentModelUsageDiagramEditorPlugin.getInstance()
					.logError("Parser was not found for label " + 5005);
			return "";
		}
	}

	/**
	 * @generated
	 */
	private String getScenarioBehaviour_3007Text(View view) {
		EObject domainModelElement = view.getElement();
		if (domainModelElement != null) {
			return ((Identifier) domainModelElement).getId();
		} else {
			PalladioComponentModelUsageDiagramEditorPlugin
					.getInstance()
					.logError(
							"No domain element for view with visualID = " + 3007);
			return "";
		}
	}

	/**
	 * @generated
	 */
	private String getBranch_3008Text(View view) {
		IParser parser = ParserService.getInstance().getParser(
				new IAdaptable() {
					public Object getAdapter(Class adapter) {
						if (String.class.equals(adapter)) {
							return CommonParserHint.DESCRIPTION;
						}
						if (IElementType.class.equals(adapter)) {
							return PalladioComponentModelElementTypes.Branch_3008;
						}
						return null;
					}
				});
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			PalladioComponentModelUsageDiagramEditorPlugin.getInstance()
					.logError("Parser was not found for label " + 5008);
			return "";
		}
	}

	/**
	 * @generated
	 */
	private String getBranchTransition_3009Text(View view) {
		IParser parser = ParserService.getInstance().getParser(
				new IAdaptable() {
					public Object getAdapter(Class adapter) {
						if (String.class.equals(adapter)) {
							return PalladioComponentModelVisualIDRegistry
									.getType(BranchTransitionBranchProbabilityEditPart.VISUAL_ID);
						}
						if (IElementType.class.equals(adapter)) {
							return PalladioComponentModelElementTypes.BranchTransition_3009;
						}
						return null;
					}
				});
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			PalladioComponentModelUsageDiagramEditorPlugin.getInstance()
					.logError("Parser was not found for label " + 5007);
			return "";
		}
	}

	/**
	 * @generated
	 */
	private String getScenarioBehaviour_3010Text(View view) {
		EObject domainModelElement = view.getElement();
		if (domainModelElement != null) {
			return ((Identifier) domainModelElement).getId();
		} else {
			PalladioComponentModelUsageDiagramEditorPlugin
					.getInstance()
					.logError(
							"No domain element for view with visualID = " + 3010);
			return "";
		}
	}

	/**
	 * @generated
	 */
	private String getUsageScenario_1000Text(View view) {
		EObject domainModelElement = view.getElement();
		if (domainModelElement != null) {
			return ((Identifier) domainModelElement).getId();
		} else {
			PalladioComponentModelUsageDiagramEditorPlugin
					.getInstance()
					.logError(
							"No domain element for view with visualID = " + 1000);
			return "";
		}
	}

	/**
	 * @generated
	 */
	private String getAbstractUserActionSuccessor_4002Text(View view) {
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
		return UsageScenarioEditPart.MODEL_ID
				.equals(PalladioComponentModelVisualIDRegistry.getModelID(view));
	}

}
