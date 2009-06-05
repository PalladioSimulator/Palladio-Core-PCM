package de.uka.ipd.sdq.pcm.gmf.allocation.part;

import de.uka.ipd.sdq.pcm.allocation.Allocation;
import de.uka.ipd.sdq.pcm.allocation.AllocationContext;
import de.uka.ipd.sdq.pcm.allocation.AllocationPackage;

import de.uka.ipd.sdq.pcm.gmf.allocation.edit.parts.AllocationContext2EditPart;
import de.uka.ipd.sdq.pcm.gmf.allocation.edit.parts.AllocationContextEditPart;
import de.uka.ipd.sdq.pcm.gmf.allocation.edit.parts.AllocationContextEntityName2EditPart;
import de.uka.ipd.sdq.pcm.gmf.allocation.edit.parts.AllocationContextEntityNameEditPart;
import de.uka.ipd.sdq.pcm.gmf.allocation.edit.parts.AllocationEditPart;
import de.uka.ipd.sdq.pcm.gmf.allocation.edit.parts.ResourceContainerAllocationCompartmentEditPart;
import de.uka.ipd.sdq.pcm.gmf.allocation.edit.parts.ResourceContainerEditPart;

import de.uka.ipd.sdq.pcm.gmf.allocation.edit.parts.ResourceContainerEntityNameEditPart;

import de.uka.ipd.sdq.pcm.resourceenvironment.ResourceContainer;
import de.uka.ipd.sdq.pcm.resourceenvironment.ResourceenvironmentPackage;

import org.eclipse.core.runtime.Platform;

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;

/**
 * This registry is used to determine which type of visual object should be
 * created for the corresponding Diagram, Node, ChildNode or Link represented 
 * by a domain model object.
 *
 * @generated
 */
public class PcmVisualIDRegistry {

	/**
	 * @generated
	 */
	private static final String DEBUG_KEY = PcmDiagramEditorPlugin
			.getInstance().getBundle().getSymbolicName()
			+ "/debug/visualID"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static int getVisualID(View view) {
		if (view instanceof Diagram) {
			if (AllocationEditPart.MODEL_ID.equals(view.getType())) {
				return AllocationEditPart.VISUAL_ID;
			} else {
				return -1;
			}
		}
		return getVisualID(view.getType());
	}

	/**
	 * @generated
	 */
	public static String getModelID(View view) {
		View diagram = view.getDiagram();
		while (view != diagram) {
			EAnnotation annotation = view.getEAnnotation("Shortcut"); //$NON-NLS-1$
			if (annotation != null) {
				return (String) annotation.getDetails().get("modelID"); //$NON-NLS-1$
			}
			view = (View) view.eContainer();
		}
		return diagram != null ? diagram.getType() : null;
	}

	/**
	 * @generated
	 */
	public static int getVisualID(String type) {
		try {
			return Integer.parseInt(type);
		} catch (NumberFormatException e) {
			if (Boolean.TRUE.toString().equalsIgnoreCase(
					Platform.getDebugOption(DEBUG_KEY))) {
				PcmDiagramEditorPlugin.getInstance().logError(
						"Unable to parse view type as a visualID number: "
								+ type);
			}
		}
		return -1;
	}

	/**
	 * @generated
	 */
	public static String getType(int visualID) {
		return String.valueOf(visualID);
	}

	/**
	 * @generated
	 */
	public static int getDiagramVisualID(EObject domainElement) {
		if (domainElement == null) {
			return -1;
		}
		EClass domainElementMetaclass = domainElement.eClass();
		return getDiagramVisualID(domainElement, domainElementMetaclass);
	}

	/**
	 * @generated
	 */
	private static int getDiagramVisualID(EObject domainElement,
			EClass domainElementMetaclass) {
		if (AllocationPackage.eINSTANCE.getAllocation().isSuperTypeOf(
				domainElementMetaclass)
				&& isDiagramAllocation_79((Allocation) domainElement)) {
			return AllocationEditPart.VISUAL_ID;
		}
		return getUnrecognizedDiagramID(domainElement);
	}

	/**
	 * @generated
	 */
	public static int getNodeVisualID(View containerView, EObject domainElement) {
		if (domainElement == null) {
			return -1;
		}
		EClass domainElementMetaclass = domainElement.eClass();
		return getNodeVisualID(containerView, domainElement,
				domainElementMetaclass, null);
	}

	/**
	 * @generated
	 */
	public static int getNodeVisualID(View containerView,
			EObject domainElement, EClass domainElementMetaclass,
			String semanticHint) {
		String containerModelID = getModelID(containerView);
		if (!AllocationEditPart.MODEL_ID.equals(containerModelID)) {
			return -1;
		}
		int containerVisualID;
		if (AllocationEditPart.MODEL_ID.equals(containerModelID)) {
			containerVisualID = getVisualID(containerView);
		} else {
			if (containerView instanceof Diagram) {
				containerVisualID = AllocationEditPart.VISUAL_ID;
			} else {
				return -1;
			}
		}
		int nodeVisualID = semanticHint != null ? getVisualID(semanticHint)
				: -1;
		switch (containerVisualID) {
		case ResourceContainerEditPart.VISUAL_ID:
			if (ResourceContainerEntityNameEditPart.VISUAL_ID == nodeVisualID) {
				return ResourceContainerEntityNameEditPart.VISUAL_ID;
			}
			if (ResourceContainerAllocationCompartmentEditPart.VISUAL_ID == nodeVisualID) {
				return ResourceContainerAllocationCompartmentEditPart.VISUAL_ID;
			}
			return getUnrecognizedResourceContainer_1001ChildNodeID(
					domainElement, semanticHint);
		case AllocationContext2EditPart.VISUAL_ID:
			if (AllocationContextEntityName2EditPart.VISUAL_ID == nodeVisualID) {
				return AllocationContextEntityName2EditPart.VISUAL_ID;
			}
			return getUnrecognizedAllocationContext_1002ChildNodeID(
					domainElement, semanticHint);
		case AllocationContextEditPart.VISUAL_ID:
			if (AllocationContextEntityNameEditPart.VISUAL_ID == nodeVisualID) {
				return AllocationContextEntityNameEditPart.VISUAL_ID;
			}
			return getUnrecognizedAllocationContext_2001ChildNodeID(
					domainElement, semanticHint);
		case ResourceContainerAllocationCompartmentEditPart.VISUAL_ID:
			if ((semanticHint == null || AllocationContextEditPart.VISUAL_ID == nodeVisualID)
					&& AllocationPackage.eINSTANCE.getAllocationContext()
							.isSuperTypeOf(domainElementMetaclass)
					&& (domainElement == null || isNodeAllocationContext_2001((AllocationContext) domainElement))) {
				return AllocationContextEditPart.VISUAL_ID;
			}
			return getUnrecognizedResourceContainerAllocationCompartment_5001ChildNodeID(
					domainElement, semanticHint);
		case AllocationEditPart.VISUAL_ID:
			if ((semanticHint == null || ResourceContainerEditPart.VISUAL_ID == nodeVisualID)
					&& ResourceenvironmentPackage.eINSTANCE
							.getResourceContainer().isSuperTypeOf(
									domainElementMetaclass)
					&& (domainElement == null || isNodeResourceContainer_1001((ResourceContainer) domainElement))) {
				return ResourceContainerEditPart.VISUAL_ID;
			}
			if ((semanticHint == null || AllocationContext2EditPart.VISUAL_ID == nodeVisualID)
					&& AllocationPackage.eINSTANCE.getAllocationContext()
							.isSuperTypeOf(domainElementMetaclass)
					&& (domainElement == null || isNodeAllocationContext_1002((AllocationContext) domainElement))) {
				return AllocationContext2EditPart.VISUAL_ID;
			}
			return getUnrecognizedAllocation_79ChildNodeID(domainElement,
					semanticHint);
		}
		return -1;
	}

	/**
	 * @generated
	 */
	public static int getLinkWithClassVisualID(EObject domainElement) {
		if (domainElement == null) {
			return -1;
		}
		EClass domainElementMetaclass = domainElement.eClass();
		return getLinkWithClassVisualID(domainElement, domainElementMetaclass);
	}

	/**
	 * @generated
	 */
	public static int getLinkWithClassVisualID(EObject domainElement,
			EClass domainElementMetaclass) {
		{
			return getUnrecognizedLinkWithClassID(domainElement);
		}
	}

	/**
	 * User can change implementation of this method to check some additional 
	 * conditions here.
	 *
	 * @generated
	 */
	private static boolean isDiagramAllocation_79(Allocation element) {
		return true;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 *
	 * @generated
	 */
	private static int getUnrecognizedDiagramID(EObject domainElement) {
		return -1;
	}

	/**
	 * User can change implementation of this method to check some additional 
	 * conditions here.
	 *
	 * @generated
	 */
	private static boolean isNodeResourceContainer_1001(
			ResourceContainer element) {
		return true;
	}

	/**
	 * User can change implementation of this method to check some additional 
	 * conditions here.
	 *
	 * @generated
	 */
	private static boolean isNodeAllocationContext_1002(
			AllocationContext element) {
		return true;
	}

	/**
	 * User can change implementation of this method to check some additional 
	 * conditions here.
	 *
	 * @generated
	 */
	private static boolean isNodeAllocationContext_2001(
			AllocationContext element) {
		return true;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 *
	 * @generated
	 */
	private static int getUnrecognizedResourceContainer_1001ChildNodeID(
			EObject domainElement, String semanticHint) {
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 *
	 * @generated
	 */
	private static int getUnrecognizedAllocationContext_1002ChildNodeID(
			EObject domainElement, String semanticHint) {
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 *
	 * @generated
	 */
	private static int getUnrecognizedAllocationContext_2001ChildNodeID(
			EObject domainElement, String semanticHint) {
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 *
	 * @generated
	 */
	private static int getUnrecognizedResourceContainerAllocationCompartment_5001ChildNodeID(
			EObject domainElement, String semanticHint) {
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 *
	 * @generated
	 */
	private static int getUnrecognizedAllocation_79ChildNodeID(
			EObject domainElement, String semanticHint) {
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 *
	 * @generated
	 */
	private static int getUnrecognizedLinkWithClassID(EObject domainElement) {
		return -1;
	}
}
