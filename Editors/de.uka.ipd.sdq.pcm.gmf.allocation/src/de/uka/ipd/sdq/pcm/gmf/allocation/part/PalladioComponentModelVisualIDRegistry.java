/*
 *Copyright 2007, SDQ, IPD, U KA
 */
package de.uka.ipd.sdq.pcm.gmf.allocation.part;

import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;

import de.uka.ipd.sdq.pcm.allocation.Allocation;
import de.uka.ipd.sdq.pcm.allocation.AllocationPackage;
import de.uka.ipd.sdq.pcm.gmf.allocation.edit.parts.AllocationComponentLabelEditPart;
import de.uka.ipd.sdq.pcm.gmf.allocation.edit.parts.AllocationContextEditPart;
import de.uka.ipd.sdq.pcm.gmf.allocation.edit.parts.AllocationContextEntityNameEditPart;
import de.uka.ipd.sdq.pcm.gmf.allocation.edit.parts.AllocationEditPart;
import de.uka.ipd.sdq.pcm.gmf.allocation.edit.parts.ResourceContainerAllocationCompartmentEditPart;
import de.uka.ipd.sdq.pcm.gmf.allocation.edit.parts.ResourceContainerEditPart;
import de.uka.ipd.sdq.pcm.gmf.allocation.edit.parts.ResourceContainerEntityNameEditPart;
import de.uka.ipd.sdq.pcm.resourceenvironment.ResourceenvironmentPackage;

/**
 * @generated
 */
public class PalladioComponentModelVisualIDRegistry {

    /**
     * @generated
     */
    private static final String DEBUG_KEY = "de.uka.ipd.sdq.pcm.gmf.allocation/debug/visualID"; //$NON-NLS-1$

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
        return de.uka.ipd.sdq.pcm.gmf.allocation.part.PalladioComponentModelVisualIDRegistry
                .getVisualID(view.getType());
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
            if (Boolean.TRUE.toString().equalsIgnoreCase(Platform.getDebugOption(DEBUG_KEY))) {
                PalladioComponentModelAllocationDiagramEditorPlugin.getInstance().logError(
                        "Unable to parse view type as a visualID number: " + type);
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
        if (AllocationPackage.eINSTANCE.getAllocation().isSuperTypeOf(domainElement.eClass())
                && isDiagram((Allocation) domainElement)) {
            return AllocationEditPart.VISUAL_ID;
        }
        return -1;
    }

    /**
     * @generated
     */
    public static int getNodeVisualID(View containerView, EObject domainElement) {
        if (domainElement == null) {
            return -1;
        }
        String containerModelID = de.uka.ipd.sdq.pcm.gmf.allocation.part.PalladioComponentModelVisualIDRegistry
                .getModelID(containerView);
        if (!AllocationEditPart.MODEL_ID.equals(containerModelID)) {
            return -1;
        }
        int containerVisualID;
        if (AllocationEditPart.MODEL_ID.equals(containerModelID)) {
            containerVisualID = de.uka.ipd.sdq.pcm.gmf.allocation.part.PalladioComponentModelVisualIDRegistry
                    .getVisualID(containerView);
        } else {
            if (containerView instanceof Diagram) {
                containerVisualID = AllocationEditPart.VISUAL_ID;
            } else {
                return -1;
            }
        }
        switch (containerVisualID) {
        case ResourceContainerAllocationCompartmentEditPart.VISUAL_ID:
            if (AllocationPackage.eINSTANCE.getAllocationContext().isSuperTypeOf(domainElement.eClass())) {
                return AllocationContextEditPart.VISUAL_ID;
            }
            break;
        case AllocationEditPart.VISUAL_ID:
            if (ResourceenvironmentPackage.eINSTANCE.getResourceContainer().isSuperTypeOf(domainElement.eClass())) {
                return ResourceContainerEditPart.VISUAL_ID;
            }
            break;
        }
        return -1;
    }

    /**
     * @generated
     */
    public static boolean canCreateNode(View containerView, int nodeVisualID) {
        String containerModelID = de.uka.ipd.sdq.pcm.gmf.allocation.part.PalladioComponentModelVisualIDRegistry
                .getModelID(containerView);
        if (!AllocationEditPart.MODEL_ID.equals(containerModelID)) {
            return false;
        }
        int containerVisualID;
        if (AllocationEditPart.MODEL_ID.equals(containerModelID)) {
            containerVisualID = de.uka.ipd.sdq.pcm.gmf.allocation.part.PalladioComponentModelVisualIDRegistry
                    .getVisualID(containerView);
        } else {
            if (containerView instanceof Diagram) {
                containerVisualID = AllocationEditPart.VISUAL_ID;
            } else {
                return false;
            }
        }
        switch (containerVisualID) {
        case ResourceContainerEditPart.VISUAL_ID:
            if (ResourceContainerEntityNameEditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            if (ResourceContainerAllocationCompartmentEditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            break;
        case AllocationContextEditPart.VISUAL_ID:
            if (AllocationContextEntityNameEditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            if (AllocationComponentLabelEditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            break;
        case ResourceContainerAllocationCompartmentEditPart.VISUAL_ID:
            if (AllocationContextEditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            break;
        case AllocationEditPart.VISUAL_ID:
            if (ResourceContainerEditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            break;
        }
        return false;
    }

    /**
     * @generated
     */
    public static int getLinkWithClassVisualID(EObject domainElement) {
        if (domainElement == null) {
            return -1;
        }
        return -1;
    }

    /**
     * @generated
     */
    private static boolean isDiagram(Allocation element) {
        return true;
    }
}
