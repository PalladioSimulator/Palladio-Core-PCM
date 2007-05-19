/*
 *Copyright 2007, SDQ, IPD, Uni Karlsruhe (TH)
 */
package de.uka.ipd.sdq.pcm.gmf.composite.providers;

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
import de.uka.ipd.sdq.pcm.gmf.composite.edit.parts.AssemblyContextEditPart;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.parts.ComposedProvidingRequiringEntity2EditPart;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.parts.ComposedProvidingRequiringEntityCompositeStructureInnerCompartmentEditPart;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.parts.ComposedProvidingRequiringEntityEditPart;

import de.uka.ipd.sdq.pcm.gmf.composite.edit.parts.ProvidedRole2EditPart;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.parts.ProvidedRoleEditPart;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.parts.RequiredRole2EditPart;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.parts.RequiredRoleEditPart;
import de.uka.ipd.sdq.pcm.gmf.composite.part.PalladioComponentModelComposedStructureDiagramEditorPlugin;

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
		if (editPart instanceof ComposedProvidingRequiringEntity2EditPart) {
			List types = new ArrayList();
			types.add(PalladioComponentModelElementTypes.ProvidedRole_3003);
			types.add(PalladioComponentModelElementTypes.RequiredRole_3005);
			return types;
		}
		if (editPart instanceof AssemblyContextEditPart) {
			List types = new ArrayList();
			types.add(PalladioComponentModelElementTypes.ProvidedRole_3001);
			types.add(PalladioComponentModelElementTypes.RequiredRole_3004);
			return types;
		}
		if (editPart instanceof ComposedProvidingRequiringEntityCompositeStructureInnerCompartmentEditPart) {
			List types = new ArrayList();
			types.add(PalladioComponentModelElementTypes.AssemblyContext_3002);
			return types;
		}
		if (editPart instanceof ComposedProvidingRequiringEntityEditPart) {
			List types = new ArrayList();
			types
					.add(PalladioComponentModelElementTypes.ComposedProvidingRequiringEntity_2001);
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
		if (sourceEditPart instanceof RequiredRoleEditPart) {
			List types = new ArrayList();
			types
					.add(PalladioComponentModelElementTypes.AssemblyConnector_4001);
			types
					.add(PalladioComponentModelElementTypes.RequiredDelegationConnector_4002);
			return types;
		}
		if (sourceEditPart instanceof RequiredRole2EditPart) {
			List types = new ArrayList();
			types
					.add(PalladioComponentModelElementTypes.AssemblyConnector_4001);
			types
					.add(PalladioComponentModelElementTypes.RequiredDelegationConnector_4002);
			return types;
		}
		if (sourceEditPart instanceof ProvidedRoleEditPart) {
			List types = new ArrayList();
			types
					.add(PalladioComponentModelElementTypes.ProvidedDelegationConnector_4003);
			return types;
		}
		if (sourceEditPart instanceof ProvidedRole2EditPart) {
			List types = new ArrayList();
			types
					.add(PalladioComponentModelElementTypes.ProvidedDelegationConnector_4003);
			return types;
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public List getRelTypesOnTarget(IAdaptable target) {
		IGraphicalEditPart targetEditPart = (IGraphicalEditPart) target
				.getAdapter(IGraphicalEditPart.class);
		if (targetEditPart instanceof ProvidedRoleEditPart) {
			List types = new ArrayList();
			types
					.add(PalladioComponentModelElementTypes.AssemblyConnector_4001);
			types
					.add(PalladioComponentModelElementTypes.ProvidedDelegationConnector_4003);
			return types;
		}
		if (targetEditPart instanceof ProvidedRole2EditPart) {
			List types = new ArrayList();
			types
					.add(PalladioComponentModelElementTypes.AssemblyConnector_4001);
			types
					.add(PalladioComponentModelElementTypes.ProvidedDelegationConnector_4003);
			return types;
		}
		if (targetEditPart instanceof RequiredRoleEditPart) {
			List types = new ArrayList();
			types
					.add(PalladioComponentModelElementTypes.RequiredDelegationConnector_4002);
			return types;
		}
		if (targetEditPart instanceof RequiredRole2EditPart) {
			List types = new ArrayList();
			types
					.add(PalladioComponentModelElementTypes.RequiredDelegationConnector_4002);
			return types;
		}
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
		if (sourceEditPart instanceof RequiredRoleEditPart) {
			List types = new ArrayList();
			if (targetEditPart instanceof ProvidedRoleEditPart) {
				types
						.add(PalladioComponentModelElementTypes.AssemblyConnector_4001);
			}
			if (targetEditPart instanceof ProvidedRole2EditPart) {
				types
						.add(PalladioComponentModelElementTypes.AssemblyConnector_4001);
			}
			if (targetEditPart instanceof RequiredRoleEditPart) {
				types
						.add(PalladioComponentModelElementTypes.RequiredDelegationConnector_4002);
			}
			if (targetEditPart instanceof RequiredRole2EditPart) {
				types
						.add(PalladioComponentModelElementTypes.RequiredDelegationConnector_4002);
			}
			return types;
		}
		if (sourceEditPart instanceof RequiredRole2EditPart) {
			List types = new ArrayList();
			if (targetEditPart instanceof ProvidedRoleEditPart) {
				types
						.add(PalladioComponentModelElementTypes.AssemblyConnector_4001);
			}
			if (targetEditPart instanceof ProvidedRole2EditPart) {
				types
						.add(PalladioComponentModelElementTypes.AssemblyConnector_4001);
			}
			if (targetEditPart instanceof RequiredRoleEditPart) {
				types
						.add(PalladioComponentModelElementTypes.RequiredDelegationConnector_4002);
			}
			if (targetEditPart instanceof RequiredRole2EditPart) {
				types
						.add(PalladioComponentModelElementTypes.RequiredDelegationConnector_4002);
			}
			return types;
		}
		if (sourceEditPart instanceof ProvidedRoleEditPart) {
			List types = new ArrayList();
			if (targetEditPart instanceof ProvidedRoleEditPart) {
				types
						.add(PalladioComponentModelElementTypes.ProvidedDelegationConnector_4003);
			}
			if (targetEditPart instanceof ProvidedRole2EditPart) {
				types
						.add(PalladioComponentModelElementTypes.ProvidedDelegationConnector_4003);
			}
			return types;
		}
		if (sourceEditPart instanceof ProvidedRole2EditPart) {
			List types = new ArrayList();
			if (targetEditPart instanceof ProvidedRoleEditPart) {
				types
						.add(PalladioComponentModelElementTypes.ProvidedDelegationConnector_4003);
			}
			if (targetEditPart instanceof ProvidedRole2EditPart) {
				types
						.add(PalladioComponentModelElementTypes.ProvidedDelegationConnector_4003);
			}
			return types;
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public List getTypesForSource(IAdaptable target,
			IElementType relationshipType) {
		IGraphicalEditPart targetEditPart = (IGraphicalEditPart) target
				.getAdapter(IGraphicalEditPart.class);
		if (targetEditPart instanceof ProvidedRoleEditPart) {
			List types = new ArrayList();
			if (relationshipType == PalladioComponentModelElementTypes.AssemblyConnector_4001) {
				types.add(PalladioComponentModelElementTypes.RequiredRole_3004);
			}
			if (relationshipType == PalladioComponentModelElementTypes.AssemblyConnector_4001) {
				types.add(PalladioComponentModelElementTypes.RequiredRole_3005);
			}
			if (relationshipType == PalladioComponentModelElementTypes.ProvidedDelegationConnector_4003) {
				types.add(PalladioComponentModelElementTypes.ProvidedRole_3001);
			}
			if (relationshipType == PalladioComponentModelElementTypes.ProvidedDelegationConnector_4003) {
				types.add(PalladioComponentModelElementTypes.ProvidedRole_3003);
			}
			return types;
		}
		if (targetEditPart instanceof ProvidedRole2EditPart) {
			List types = new ArrayList();
			if (relationshipType == PalladioComponentModelElementTypes.AssemblyConnector_4001) {
				types.add(PalladioComponentModelElementTypes.RequiredRole_3004);
			}
			if (relationshipType == PalladioComponentModelElementTypes.AssemblyConnector_4001) {
				types.add(PalladioComponentModelElementTypes.RequiredRole_3005);
			}
			if (relationshipType == PalladioComponentModelElementTypes.ProvidedDelegationConnector_4003) {
				types.add(PalladioComponentModelElementTypes.ProvidedRole_3001);
			}
			if (relationshipType == PalladioComponentModelElementTypes.ProvidedDelegationConnector_4003) {
				types.add(PalladioComponentModelElementTypes.ProvidedRole_3003);
			}
			return types;
		}
		if (targetEditPart instanceof RequiredRoleEditPart) {
			List types = new ArrayList();
			if (relationshipType == PalladioComponentModelElementTypes.RequiredDelegationConnector_4002) {
				types.add(PalladioComponentModelElementTypes.RequiredRole_3004);
			}
			if (relationshipType == PalladioComponentModelElementTypes.RequiredDelegationConnector_4002) {
				types.add(PalladioComponentModelElementTypes.RequiredRole_3005);
			}
			return types;
		}
		if (targetEditPart instanceof RequiredRole2EditPart) {
			List types = new ArrayList();
			if (relationshipType == PalladioComponentModelElementTypes.RequiredDelegationConnector_4002) {
				types.add(PalladioComponentModelElementTypes.RequiredRole_3004);
			}
			if (relationshipType == PalladioComponentModelElementTypes.RequiredDelegationConnector_4002) {
				types.add(PalladioComponentModelElementTypes.RequiredRole_3005);
			}
			return types;
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public List getTypesForTarget(IAdaptable source,
			IElementType relationshipType) {
		IGraphicalEditPart sourceEditPart = (IGraphicalEditPart) source
				.getAdapter(IGraphicalEditPart.class);
		if (sourceEditPart instanceof RequiredRoleEditPart) {
			List types = new ArrayList();
			if (relationshipType == PalladioComponentModelElementTypes.AssemblyConnector_4001) {
				types.add(PalladioComponentModelElementTypes.ProvidedRole_3001);
			}
			if (relationshipType == PalladioComponentModelElementTypes.AssemblyConnector_4001) {
				types.add(PalladioComponentModelElementTypes.ProvidedRole_3003);
			}
			if (relationshipType == PalladioComponentModelElementTypes.RequiredDelegationConnector_4002) {
				types.add(PalladioComponentModelElementTypes.RequiredRole_3004);
			}
			if (relationshipType == PalladioComponentModelElementTypes.RequiredDelegationConnector_4002) {
				types.add(PalladioComponentModelElementTypes.RequiredRole_3005);
			}
			return types;
		}
		if (sourceEditPart instanceof RequiredRole2EditPart) {
			List types = new ArrayList();
			if (relationshipType == PalladioComponentModelElementTypes.AssemblyConnector_4001) {
				types.add(PalladioComponentModelElementTypes.ProvidedRole_3001);
			}
			if (relationshipType == PalladioComponentModelElementTypes.AssemblyConnector_4001) {
				types.add(PalladioComponentModelElementTypes.ProvidedRole_3003);
			}
			if (relationshipType == PalladioComponentModelElementTypes.RequiredDelegationConnector_4002) {
				types.add(PalladioComponentModelElementTypes.RequiredRole_3004);
			}
			if (relationshipType == PalladioComponentModelElementTypes.RequiredDelegationConnector_4002) {
				types.add(PalladioComponentModelElementTypes.RequiredRole_3005);
			}
			return types;
		}
		if (sourceEditPart instanceof ProvidedRoleEditPart) {
			List types = new ArrayList();
			if (relationshipType == PalladioComponentModelElementTypes.ProvidedDelegationConnector_4003) {
				types.add(PalladioComponentModelElementTypes.ProvidedRole_3001);
			}
			if (relationshipType == PalladioComponentModelElementTypes.ProvidedDelegationConnector_4003) {
				types.add(PalladioComponentModelElementTypes.ProvidedRole_3003);
			}
			return types;
		}
		if (sourceEditPart instanceof ProvidedRole2EditPart) {
			List types = new ArrayList();
			if (relationshipType == PalladioComponentModelElementTypes.ProvidedDelegationConnector_4003) {
				types.add(PalladioComponentModelElementTypes.ProvidedRole_3001);
			}
			if (relationshipType == PalladioComponentModelElementTypes.ProvidedDelegationConnector_4003) {
				types.add(PalladioComponentModelElementTypes.ProvidedRole_3003);
			}
			return types;
		}
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
				PalladioComponentModelComposedStructureDiagramEditorPlugin
						.getInstance().getItemProvidersAdapterFactory());
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
