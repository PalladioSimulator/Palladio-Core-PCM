/*
 *Copyright 2006 SDQ Research Group, University of Karlsruhe (TH)
 */
package de.uka.ipd.sdq.pcm.gmf.seff.providers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
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

import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.BranchActionBranchTransitionCompartment2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.BranchActionBranchTransitionCompartmentEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.CollectionIteratorAction2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.CollectionIteratorActionEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ExternalCallActionInputVariableUsage2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ExternalCallActionInputVariableUsageEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ExternalCallActionOutputVariableUsage2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ExternalCallActionOutputVariableUsageEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ForkActionForkedBehaviours2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ForkActionForkedBehavioursEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ForkedBehaviourBehaviourCompartmentEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.GuardedBranchTransitionEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.InternalAction2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.InternalActionEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.LoopAction2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.LoopActionEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ProbabilisticBranchTransitionEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ResourceDemandingBehaviourBranchCompartment2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ResourceDemandingBehaviourBranchCompartmentEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ResourceDemandingBehaviourLoopCompartment2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ResourceDemandingBehaviourLoopCompartmentEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ResourceDemandingSEFFEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.SetVariableActionVariableSetter2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.SetVariableActionVariableSetterEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.VariableUsage2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.VariableUsage3EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.VariableUsageEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.part.Messages;
import de.uka.ipd.sdq.pcm.gmf.seff.part.PalladioComponentModelSeffDiagramEditorPlugin;

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
		if (editPart instanceof LoopActionEditPart) {
			List types = new ArrayList();
			types
					.add(PalladioComponentModelElementTypes.ResourceDemandingBehaviour_3003);
			return types;
		}
		if (editPart instanceof InternalAction2EditPart) {
			List types = new ArrayList();
			types
					.add(PalladioComponentModelElementTypes.ParametricResourceDemand_3031);
			return types;
		}
		if (editPart instanceof CollectionIteratorAction2EditPart) {
			List types = new ArrayList();
			types
					.add(PalladioComponentModelElementTypes.ResourceDemandingBehaviour_3014);
			return types;
		}
		if (editPart instanceof VariableUsageEditPart) {
			List types = new ArrayList();
			types
					.add(PalladioComponentModelElementTypes.VariableCharacterisation_3033);
			return types;
		}
		if (editPart instanceof VariableUsage2EditPart) {
			List types = new ArrayList();
			types
					.add(PalladioComponentModelElementTypes.VariableCharacterisation_3035);
			return types;
		}
		if (editPart instanceof LoopAction2EditPart) {
			List types = new ArrayList();
			types
					.add(PalladioComponentModelElementTypes.ResourceDemandingBehaviour_3003);
			return types;
		}
		if (editPart instanceof InternalActionEditPart) {
			List types = new ArrayList();
			types
					.add(PalladioComponentModelElementTypes.ParametricResourceDemand_3031);
			return types;
		}
		if (editPart instanceof ProbabilisticBranchTransitionEditPart) {
			List types = new ArrayList();
			types
					.add(PalladioComponentModelElementTypes.ResourceDemandingBehaviour_3011);
			return types;
		}
		if (editPart instanceof CollectionIteratorActionEditPart) {
			List types = new ArrayList();
			types
					.add(PalladioComponentModelElementTypes.ResourceDemandingBehaviour_3014);
			return types;
		}
		if (editPart instanceof VariableUsage3EditPart) {
			List types = new ArrayList();
			types
					.add(PalladioComponentModelElementTypes.VariableCharacterisation_3037);
			return types;
		}
		if (editPart instanceof GuardedBranchTransitionEditPart) {
			List types = new ArrayList();
			types
					.add(PalladioComponentModelElementTypes.ResourceDemandingBehaviour_3018);
			return types;
		}
		if (editPart instanceof ExternalCallActionInputVariableUsageEditPart) {
			List types = new ArrayList();
			types.add(PalladioComponentModelElementTypes.VariableUsage_3032);
			return types;
		}
		if (editPart instanceof ExternalCallActionOutputVariableUsageEditPart) {
			List types = new ArrayList();
			types.add(PalladioComponentModelElementTypes.VariableUsage_3034);
			return types;
		}
		if (editPart instanceof ResourceDemandingBehaviourLoopCompartmentEditPart) {
			List types = new ArrayList();
			types.add(PalladioComponentModelElementTypes.StartAction_3004);
			types.add(PalladioComponentModelElementTypes.StopAction_3005);
			types.add(PalladioComponentModelElementTypes.LoopAction_3006);
			types.add(PalladioComponentModelElementTypes.InternalAction_3007);
			types.add(PalladioComponentModelElementTypes.BranchAction_3009);
			types
					.add(PalladioComponentModelElementTypes.ExternalCallAction_3012);
			types
					.add(PalladioComponentModelElementTypes.CollectionIteratorAction_3013);
			types.add(PalladioComponentModelElementTypes.AcquireAction_3026);
			types.add(PalladioComponentModelElementTypes.ReleaseAction_3020);
			types.add(PalladioComponentModelElementTypes.ForkAction_3023);
			types
					.add(PalladioComponentModelElementTypes.SetVariableAction_3024);
			return types;
		}
		if (editPart instanceof BranchActionBranchTransitionCompartmentEditPart) {
			List types = new ArrayList();
			types
					.add(PalladioComponentModelElementTypes.ProbabilisticBranchTransition_3010);
			types
					.add(PalladioComponentModelElementTypes.GuardedBranchTransition_3017);
			return types;
		}
		if (editPart instanceof ResourceDemandingBehaviourBranchCompartmentEditPart) {
			List types = new ArrayList();
			types.add(PalladioComponentModelElementTypes.StartAction_3004);
			types.add(PalladioComponentModelElementTypes.StopAction_3005);
			types.add(PalladioComponentModelElementTypes.LoopAction_3006);
			types.add(PalladioComponentModelElementTypes.InternalAction_3007);
			types.add(PalladioComponentModelElementTypes.BranchAction_3009);
			types
					.add(PalladioComponentModelElementTypes.ExternalCallAction_3012);
			types.add(PalladioComponentModelElementTypes.AcquireAction_3026);
			types.add(PalladioComponentModelElementTypes.ReleaseAction_3020);
			types.add(PalladioComponentModelElementTypes.ForkAction_3023);
			types
					.add(PalladioComponentModelElementTypes.CollectionIteratorAction_3013);
			types
					.add(PalladioComponentModelElementTypes.SetVariableAction_3024);
			return types;
		}
		if (editPart instanceof ExternalCallActionInputVariableUsage2EditPart) {
			List types = new ArrayList();
			types.add(PalladioComponentModelElementTypes.VariableUsage_3032);
			return types;
		}
		if (editPart instanceof ExternalCallActionOutputVariableUsage2EditPart) {
			List types = new ArrayList();
			types.add(PalladioComponentModelElementTypes.VariableUsage_3034);
			return types;
		}
		if (editPart instanceof ForkActionForkedBehavioursEditPart) {
			List types = new ArrayList();
			types.add(PalladioComponentModelElementTypes.ForkedBehaviour_3027);
			return types;
		}
		if (editPart instanceof ForkedBehaviourBehaviourCompartmentEditPart) {
			List types = new ArrayList();
			types.add(PalladioComponentModelElementTypes.StartAction_3004);
			types.add(PalladioComponentModelElementTypes.StopAction_3005);
			types.add(PalladioComponentModelElementTypes.LoopAction_3006);
			types.add(PalladioComponentModelElementTypes.InternalAction_3007);
			types.add(PalladioComponentModelElementTypes.BranchAction_3009);
			types
					.add(PalladioComponentModelElementTypes.ExternalCallAction_3012);
			types
					.add(PalladioComponentModelElementTypes.CollectionIteratorAction_3013);
			types.add(PalladioComponentModelElementTypes.AcquireAction_3026);
			types.add(PalladioComponentModelElementTypes.ReleaseAction_3020);
			types.add(PalladioComponentModelElementTypes.ForkAction_3023);
			return types;
		}
		if (editPart instanceof ResourceDemandingBehaviourLoopCompartment2EditPart) {
			List types = new ArrayList();
			types.add(PalladioComponentModelElementTypes.StartAction_3004);
			types.add(PalladioComponentModelElementTypes.StopAction_3005);
			types.add(PalladioComponentModelElementTypes.LoopAction_3006);
			types.add(PalladioComponentModelElementTypes.InternalAction_3007);
			types.add(PalladioComponentModelElementTypes.BranchAction_3009);
			types
					.add(PalladioComponentModelElementTypes.ExternalCallAction_3012);
			types
					.add(PalladioComponentModelElementTypes.CollectionIteratorAction_3013);
			types.add(PalladioComponentModelElementTypes.AcquireAction_3026);
			types.add(PalladioComponentModelElementTypes.ReleaseAction_3020);
			types.add(PalladioComponentModelElementTypes.ForkAction_3023);
			return types;
		}
		if (editPart instanceof SetVariableActionVariableSetterEditPart) {
			List types = new ArrayList();
			types.add(PalladioComponentModelElementTypes.VariableUsage_3036);
			return types;
		}
		if (editPart instanceof ResourceDemandingBehaviourBranchCompartment2EditPart) {
			List types = new ArrayList();
			types.add(PalladioComponentModelElementTypes.StartAction_3004);
			types.add(PalladioComponentModelElementTypes.StopAction_3005);
			types.add(PalladioComponentModelElementTypes.LoopAction_3006);
			types.add(PalladioComponentModelElementTypes.InternalAction_3007);
			types.add(PalladioComponentModelElementTypes.BranchAction_3009);
			types
					.add(PalladioComponentModelElementTypes.ExternalCallAction_3012);
			types.add(PalladioComponentModelElementTypes.AcquireAction_3026);
			types.add(PalladioComponentModelElementTypes.ReleaseAction_3020);
			types.add(PalladioComponentModelElementTypes.ForkAction_3023);
			types
					.add(PalladioComponentModelElementTypes.CollectionIteratorAction_3013);
			types
					.add(PalladioComponentModelElementTypes.SetVariableAction_3024);
			return types;
		}
		if (editPart instanceof BranchActionBranchTransitionCompartment2EditPart) {
			List types = new ArrayList();
			types
					.add(PalladioComponentModelElementTypes.ProbabilisticBranchTransition_3010);
			types
					.add(PalladioComponentModelElementTypes.GuardedBranchTransition_3017);
			return types;
		}
		if (editPart instanceof SetVariableActionVariableSetter2EditPart) {
			List types = new ArrayList();
			types.add(PalladioComponentModelElementTypes.VariableUsage_3036);
			return types;
		}
		if (editPart instanceof ForkActionForkedBehaviours2EditPart) {
			List types = new ArrayList();
			types.add(PalladioComponentModelElementTypes.ForkedBehaviour_3027);
			return types;
		}
		if (editPart instanceof ResourceDemandingSEFFEditPart) {
			List types = new ArrayList();
			types.add(PalladioComponentModelElementTypes.StartAction_2001);
			types.add(PalladioComponentModelElementTypes.StopAction_2002);
			types
					.add(PalladioComponentModelElementTypes.ExternalCallAction_2003);
			types.add(PalladioComponentModelElementTypes.LoopAction_2004);
			types.add(PalladioComponentModelElementTypes.BranchAction_2005);
			types.add(PalladioComponentModelElementTypes.InternalAction_2006);
			types
					.add(PalladioComponentModelElementTypes.CollectionIteratorAction_2007);
			types
					.add(PalladioComponentModelElementTypes.SetVariableAction_2008);
			types.add(PalladioComponentModelElementTypes.AcquireAction_2012);
			types.add(PalladioComponentModelElementTypes.ReleaseAction_2010);
			types.add(PalladioComponentModelElementTypes.ForkAction_2011);
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
				PalladioComponentModelSeffDiagramEditorPlugin.getInstance()
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
