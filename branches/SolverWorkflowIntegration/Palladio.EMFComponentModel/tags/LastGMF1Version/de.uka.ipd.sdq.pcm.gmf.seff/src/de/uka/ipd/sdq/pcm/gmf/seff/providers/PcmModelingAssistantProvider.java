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
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ExternalCallActionParameterUsage2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ExternalCallActionParameterUsageEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.InternalAction2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.InternalActionEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.LoopActionBehaviourCompartment2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.LoopActionBehaviourCompartmentEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ProbabilisticBranchTransitionBehaviourCompartmentEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ResourceDemandingBehaviourBranchCompartmentEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ResourceDemandingBehaviourLoopCompartmentEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ResourceDemandingSEFFEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.VariableUsageEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.part.PcmDiagramEditorPlugin;

/**
 * @generated
 */
public class PcmModelingAssistantProvider extends ModelingAssistantProvider {

	/**
	 * @generated
	 */
	public List getTypesForPopupBar(IAdaptable host) {
		IGraphicalEditPart editPart = (IGraphicalEditPart) host
				.getAdapter(IGraphicalEditPart.class);
		if (editPart instanceof InternalAction2EditPart) {
			List types = new ArrayList();
			types.add(PcmElementTypes.ParametricResourceDemand_2008);
			return types;
		}
		if (editPart instanceof VariableUsageEditPart) {
			List types = new ArrayList();
			types.add(PcmElementTypes.VariableCharacterisation_2002);
			return types;
		}
		if (editPart instanceof InternalActionEditPart) {
			List types = new ArrayList();
			types.add(PcmElementTypes.ParametricResourceDemand_2008);
			return types;
		}
		if (editPart instanceof ExternalCallActionParameterUsageEditPart) {
			List types = new ArrayList();
			types.add(PcmElementTypes.VariableUsage_2001);
			return types;
		}
		if (editPart instanceof LoopActionBehaviourCompartmentEditPart) {
			List types = new ArrayList();
			types.add(PcmElementTypes.ResourceDemandingBehaviour_2003);
			return types;
		}
		if (editPart instanceof ResourceDemandingBehaviourLoopCompartmentEditPart) {
			List types = new ArrayList();
			types.add(PcmElementTypes.StartAction_2004);
			types.add(PcmElementTypes.StopAction_2005);
			types.add(PcmElementTypes.LoopAction_2006);
			types.add(PcmElementTypes.InternalAction_2007);
			types.add(PcmElementTypes.BranchAction_2009);
			types.add(PcmElementTypes.ExternalCallAction_2012);
			return types;
		}
		if (editPart instanceof LoopActionBehaviourCompartment2EditPart) {
			List types = new ArrayList();
			types.add(PcmElementTypes.ResourceDemandingBehaviour_2003);
			return types;
		}
		if (editPart instanceof BranchActionBranchTransitionCompartmentEditPart) {
			List types = new ArrayList();
			types.add(PcmElementTypes.ProbabilisticBranchTransition_2010);
			return types;
		}
		if (editPart instanceof ProbabilisticBranchTransitionBehaviourCompartmentEditPart) {
			List types = new ArrayList();
			types.add(PcmElementTypes.ResourceDemandingBehaviour_2011);
			return types;
		}
		if (editPart instanceof ResourceDemandingBehaviourBranchCompartmentEditPart) {
			List types = new ArrayList();
			types.add(PcmElementTypes.StartAction_2004);
			types.add(PcmElementTypes.StopAction_2005);
			types.add(PcmElementTypes.LoopAction_2006);
			types.add(PcmElementTypes.InternalAction_2007);
			types.add(PcmElementTypes.BranchAction_2009);
			types.add(PcmElementTypes.ExternalCallAction_2012);
			return types;
		}
		if (editPart instanceof ExternalCallActionParameterUsage2EditPart) {
			List types = new ArrayList();
			types.add(PcmElementTypes.VariableUsage_2001);
			return types;
		}
		if (editPart instanceof BranchActionBranchTransitionCompartment2EditPart) {
			List types = new ArrayList();
			types.add(PcmElementTypes.ProbabilisticBranchTransition_2010);
			return types;
		}
		if (editPart instanceof ResourceDemandingSEFFEditPart) {
			List types = new ArrayList();
			types.add(PcmElementTypes.StartAction_1001);
			types.add(PcmElementTypes.StopAction_1002);
			types.add(PcmElementTypes.ExternalCallAction_1003);
			types.add(PcmElementTypes.LoopAction_1004);
			types.add(PcmElementTypes.BranchAction_1005);
			types.add(PcmElementTypes.InternalAction_1006);
			return types;
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public List getRelTypesOnSource(IAdaptable source) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public List getRelTypesOnTarget(IAdaptable target) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public List getRelTypesOnSourceAndTarget(IAdaptable source,
			IAdaptable target) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public List getTypesForSource(IAdaptable target,
			IElementType relationshipType) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public List getTypesForTarget(IAdaptable source,
			IElementType relationshipType) {
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
				PcmDiagramEditorPlugin.getInstance()
						.getItemProvidersAdapterFactory());
		ElementListSelectionDialog dialog = new ElementListSelectionDialog(
				shell, labelProvider);
		dialog.setMessage("Available domain model elements:");
		dialog.setTitle("Select domain model element");
		dialog.setMultipleSelection(false);
		dialog.setElements(elements);
		EObject selected = null;
		if (dialog.open() == Window.OK) {
			selected = (EObject) dialog.getFirstResult();
		}
		return selected;
	}
}
