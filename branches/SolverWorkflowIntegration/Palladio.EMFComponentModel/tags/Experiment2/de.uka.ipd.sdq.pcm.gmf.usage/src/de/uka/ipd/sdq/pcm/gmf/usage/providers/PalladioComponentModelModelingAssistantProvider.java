/*
 *Copyright 2007, SDQ, IPD, University of Karlsruhe
 */
package de.uka.ipd.sdq.pcm.gmf.usage.providers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.emf.type.core.ElementTypeRegistry;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.ui.services.modelingassistant.ModelingAssistantProvider;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.dialogs.ElementListSelectionDialog;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.BranchEditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.BranchTransitionEditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.BranchUsageBranchTransitionsCompartmentEditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.EntryLevelSystemCallEditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.EntryLevelSystemCallParameterUsageEditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.LoopEditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.ScenarioBehaviourEditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.ScenarioBehaviourScenarioBehaviourStepsCompartment2EditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.ScenarioBehaviourScenarioBehaviourStepsCompartment3EditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.ScenarioBehaviourScenarioBehaviourStepsCompartmentEditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.UsageScenarioEditPart;

import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.VariableUsageEditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.part.Messages;
import de.uka.ipd.sdq.pcm.gmf.usage.part.PalladioComponentModelUsageDiagramEditorPlugin;

/**
 * @generated
 */
public class PalladioComponentModelModelingAssistantProvider extends
		ModelingAssistantProvider {

	/**
	 * @generated
	 */
	public List getTypesForPopupBar(IAdaptable host) {
		IGraphicalEditPart editPart = (IGraphicalEditPart) host
				.getAdapter(IGraphicalEditPart.class);
		if (editPart instanceof EntryLevelSystemCallEditPart) {
			List types = new ArrayList();
			types.add(PalladioComponentModelElementTypes.VariableUsage_3004);
			return types;
		}
		if (editPart instanceof VariableUsageEditPart) {
			List types = new ArrayList();
			types
					.add(PalladioComponentModelElementTypes.VariableCharacterisation_3006);
			return types;
		}
		if (editPart instanceof LoopEditPart) {
			List types = new ArrayList();
			types
					.add(PalladioComponentModelElementTypes.ScenarioBehaviour_3007);
			return types;
		}
		if (editPart instanceof BranchTransitionEditPart) {
			List types = new ArrayList();
			types
					.add(PalladioComponentModelElementTypes.ScenarioBehaviour_3010);
			return types;
		}
		if (editPart instanceof ScenarioBehaviourScenarioBehaviourStepsCompartmentEditPart) {
			List types = new ArrayList();
			types.add(PalladioComponentModelElementTypes.Start_3001);
			types.add(PalladioComponentModelElementTypes.Stop_3002);
			types
					.add(PalladioComponentModelElementTypes.EntryLevelSystemCall_3003);
			types.add(PalladioComponentModelElementTypes.Loop_3005);
			types.add(PalladioComponentModelElementTypes.Branch_3008);
			return types;
		}
		if (editPart instanceof ScenarioBehaviourScenarioBehaviourStepsCompartment2EditPart) {
			List types = new ArrayList();
			types.add(PalladioComponentModelElementTypes.Start_3001);
			types.add(PalladioComponentModelElementTypes.Stop_3002);
			types
					.add(PalladioComponentModelElementTypes.EntryLevelSystemCall_3003);
			types.add(PalladioComponentModelElementTypes.Loop_3005);
			types.add(PalladioComponentModelElementTypes.Branch_3008);
			return types;
		}
		if (editPart instanceof BranchUsageBranchTransitionsCompartmentEditPart) {
			List types = new ArrayList();
			types.add(PalladioComponentModelElementTypes.BranchTransition_3009);
			return types;
		}
		if (editPart instanceof ScenarioBehaviourScenarioBehaviourStepsCompartment3EditPart) {
			List types = new ArrayList();
			types.add(PalladioComponentModelElementTypes.Start_3001);
			types.add(PalladioComponentModelElementTypes.Stop_3002);
			types
					.add(PalladioComponentModelElementTypes.EntryLevelSystemCall_3003);
			types.add(PalladioComponentModelElementTypes.Loop_3005);
			types.add(PalladioComponentModelElementTypes.Branch_3008);
			return types;
		}
		if (editPart instanceof UsageScenarioEditPart) {
			List types = new ArrayList();
			types
					.add(PalladioComponentModelElementTypes.ScenarioBehaviour_2001);
			types.add(PalladioComponentModelElementTypes.ClosedWorkload_2002);
			types.add(PalladioComponentModelElementTypes.OpenWorkload_2003);
			return types;
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public List getRelTypesOnSource(IAdaptable source) {
		IGraphicalEditPart sourceEditPart = (IGraphicalEditPart) source
				.getAdapter(IGraphicalEditPart.class);
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public List getRelTypesOnTarget(IAdaptable target) {
		IGraphicalEditPart targetEditPart = (IGraphicalEditPart) target
				.getAdapter(IGraphicalEditPart.class);
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public List getRelTypesOnSourceAndTarget(IAdaptable source,
			IAdaptable target) {
		IGraphicalEditPart sourceEditPart = (IGraphicalEditPart) source
				.getAdapter(IGraphicalEditPart.class);
		IGraphicalEditPart targetEditPart = (IGraphicalEditPart) target
				.getAdapter(IGraphicalEditPart.class);
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public List getTypesForSource(IAdaptable target,
			IElementType relationshipType) {
		IGraphicalEditPart targetEditPart = (IGraphicalEditPart) target
				.getAdapter(IGraphicalEditPart.class);
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public List getTypesForTarget(IAdaptable source,
			IElementType relationshipType) {
		IGraphicalEditPart sourceEditPart = (IGraphicalEditPart) source
				.getAdapter(IGraphicalEditPart.class);
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public EObject selectExistingElementForSource(IAdaptable target,
			IElementType relationshipType) {
		return selectExistingElement(target, getTypesForSource(target,
				relationshipType));
	}

	/**
	 * @generated
	 */
	public EObject selectExistingElementForTarget(IAdaptable source,
			IElementType relationshipType) {
		return selectExistingElement(source, getTypesForTarget(source,
				relationshipType));
	}

	/**
	 * @generated
	 */
	protected EObject selectExistingElement(IAdaptable host, Collection types) {
		if (types.isEmpty()) {
			return null;
		}
		IGraphicalEditPart editPart = (IGraphicalEditPart) host
				.getAdapter(IGraphicalEditPart.class);
		if (editPart == null) {
			return null;
		}
		Diagram diagram = (Diagram) editPart.getRoot().getContents().getModel();
		Collection elements = new HashSet();
		for (Iterator it = diagram.getElement().eAllContents(); it.hasNext();) {
			EObject element = (EObject) it.next();
			if (isApplicableElement(element, types)) {
				elements.add(element);
			}
		}
		if (elements.isEmpty()) {
			return null;
		}
		return selectElement((EObject[]) elements.toArray(new EObject[elements
				.size()]));
	}

	/**
	 * @generated
	 */
	protected boolean isApplicableElement(EObject element, Collection types) {
		IElementType type = ElementTypeRegistry.getInstance().getElementType(
				element);
		return types.contains(type);
	}

	/**
	 * @generated
	 */
	protected EObject selectElement(EObject[] elements) {
		Shell shell = Display.getCurrent().getActiveShell();
		ILabelProvider labelProvider = new AdapterFactoryLabelProvider(
				PalladioComponentModelUsageDiagramEditorPlugin.getInstance()
						.getItemProvidersAdapterFactory());
		ElementListSelectionDialog dialog = new ElementListSelectionDialog(
				shell, labelProvider);
		dialog
				.setMessage(Messages.PalladioComponentModelModelingAssistantProviderMessage);
		dialog
				.setTitle(Messages.PalladioComponentModelModelingAssistantProviderTitle);
		dialog.setMultipleSelection(false);
		dialog.setElements(elements);
		EObject selected = null;
		if (dialog.open() == Window.OK) {
			selected = (EObject) dialog.getFirstResult();
		}
		return selected;
	}
}
