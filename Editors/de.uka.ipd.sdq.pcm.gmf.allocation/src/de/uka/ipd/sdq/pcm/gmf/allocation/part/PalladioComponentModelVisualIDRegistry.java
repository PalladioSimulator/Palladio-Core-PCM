	/*
 * Copyright 2007, SDQ, IPD, U KA
 */
package de.uka.ipd.sdq.pcm.gmf.allocation.part;

	/**
 * This registry is used to determine which type of visual object should be
 * created for the corresponding Diagram, Node, ChildNode or Link represented
 * by a domain model object.
 * 
 * @generated
 */
public class PalladioComponentModelVisualIDRegistry {

		/**
 * @generated
 */
	private static final String DEBUG_KEY = "de.uka.ipd.sdq.pcm.gmf.allocation/debug/visualID";  //$NON-NLS-1$

		/**
 * @generated
 */
public static int getVisualID(org.eclipse.gmf.runtime.notation.View view) {
	if (view instanceof org.eclipse.gmf.runtime.notation.Diagram) {
		if (de.uka.ipd.sdq.pcm.gmf.allocation.edit.parts.AllocationEditPart.MODEL_ID.equals(view.getType())) {
			return de.uka.ipd.sdq.pcm.gmf.allocation.edit.parts.AllocationEditPart.VISUAL_ID;
		} else {
			return -1;
		}
	}
	return de.uka.ipd.sdq.pcm.gmf.allocation.part.PalladioComponentModelVisualIDRegistry.getVisualID(view.getType());
}
	
		/**
 * @generated
 */
public static String getModelID(org.eclipse.gmf.runtime.notation.View view) {
	org.eclipse.gmf.runtime.notation.View diagram = view.getDiagram();
	while (view != diagram) {
		org.eclipse.emf.ecore.EAnnotation annotation = view.getEAnnotation("Shortcut");  //$NON-NLS-1$
		if (annotation != null) {
			return (String) annotation.getDetails().get("modelID");  //$NON-NLS-1$
		}
		view = (org.eclipse.gmf.runtime.notation.View) view.eContainer();
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
		if (Boolean.TRUE.toString().equalsIgnoreCase(org.eclipse.core.runtime.Platform.getDebugOption(DEBUG_KEY))) {
			de.uka.ipd.sdq.pcm.gmf.allocation.part.PalladioComponentModelAllocationDiagramEditorPlugin.getInstance().logError("Unable to parse view type as a visualID number: " + type);
		}
	}
	return -1;
}

	/**
 * @generated
 */
public static String getType(int visualID) {
	return Integer.toString(visualID);
}
	
		/**
 * @generated
 */
public static int getDiagramVisualID(org.eclipse.emf.ecore.EObject domainElement) {
	if (domainElement == null) {
		return -1;
	}
	if (org.palladiosimulator.pcm.allocation.AllocationPackage.eINSTANCE.getAllocation().isSuperTypeOf(domainElement.eClass()) && isDiagram((org.palladiosimulator.pcm.allocation.Allocation) domainElement)) {
	return de.uka.ipd.sdq.pcm.gmf.allocation.edit.parts.AllocationEditPart.VISUAL_ID;
}
	return -1;
}
	
		/**
 * @generated
 */
public static int getNodeVisualID(org.eclipse.gmf.runtime.notation.View containerView, org.eclipse.emf.ecore.EObject domainElement) {
	if (domainElement == null) {
		return -1;
	}
	String containerModelID = de.uka.ipd.sdq.pcm.gmf.allocation.part.PalladioComponentModelVisualIDRegistry.getModelID(containerView);
	if (!de.uka.ipd.sdq.pcm.gmf.allocation.edit.parts.AllocationEditPart.MODEL_ID.equals(containerModelID)) { 
		return -1;
	}
	int containerVisualID;
	if (de.uka.ipd.sdq.pcm.gmf.allocation.edit.parts.AllocationEditPart.MODEL_ID.equals(containerModelID)) {
		containerVisualID = de.uka.ipd.sdq.pcm.gmf.allocation.part.PalladioComponentModelVisualIDRegistry.getVisualID(containerView);
	} else {
		if (containerView instanceof org.eclipse.gmf.runtime.notation.Diagram) {
			containerVisualID = de.uka.ipd.sdq.pcm.gmf.allocation.edit.parts.AllocationEditPart.VISUAL_ID;		
		} else {
			return -1;
		}
	}
	switch (containerVisualID) {
			case de.uka.ipd.sdq.pcm.gmf.allocation.edit.parts.AllocationEditPart.VISUAL_ID:
	if (org.palladiosimulator.pcm.resourceenvironment.ResourceenvironmentPackage.eINSTANCE.getResourceContainer().isSuperTypeOf(domainElement.eClass())) {
	return de.uka.ipd.sdq.pcm.gmf.allocation.edit.parts.ResourceContainerEditPart.VISUAL_ID;
}
	break;
				case de.uka.ipd.sdq.pcm.gmf.allocation.edit.parts.ResourceContainerAllocationCompartmentEditPart.VISUAL_ID:
	if (org.palladiosimulator.pcm.allocation.AllocationPackage.eINSTANCE.getAllocationContext().isSuperTypeOf(domainElement.eClass())) {
	return de.uka.ipd.sdq.pcm.gmf.allocation.edit.parts.AllocationContextEditPart.VISUAL_ID;
}
	break;
		}
	return -1;
}
	
		/**
 * @generated
 */
public static boolean canCreateNode(org.eclipse.gmf.runtime.notation.View containerView, int nodeVisualID) {
	String containerModelID = de.uka.ipd.sdq.pcm.gmf.allocation.part.PalladioComponentModelVisualIDRegistry.getModelID(containerView);
	if (!de.uka.ipd.sdq.pcm.gmf.allocation.edit.parts.AllocationEditPart.MODEL_ID.equals(containerModelID)) { 
		return false;
	}
	int containerVisualID;
	if (de.uka.ipd.sdq.pcm.gmf.allocation.edit.parts.AllocationEditPart.MODEL_ID.equals(containerModelID)) {
		containerVisualID = de.uka.ipd.sdq.pcm.gmf.allocation.part.PalladioComponentModelVisualIDRegistry.getVisualID(containerView);
	} else {
		if (containerView instanceof org.eclipse.gmf.runtime.notation.Diagram) {
			containerVisualID = de.uka.ipd.sdq.pcm.gmf.allocation.edit.parts.AllocationEditPart.VISUAL_ID;		
		} else {
			return false;
		}
	}
	switch (containerVisualID) {
		case de.uka.ipd.sdq.pcm.gmf.allocation.edit.parts.AllocationEditPart.VISUAL_ID:
	if (de.uka.ipd.sdq.pcm.gmf.allocation.edit.parts.ResourceContainerEditPart.VISUAL_ID == nodeVisualID) {
	return true;
}
	break;
case de.uka.ipd.sdq.pcm.gmf.allocation.edit.parts.ResourceContainerEditPart.VISUAL_ID:
	if (de.uka.ipd.sdq.pcm.gmf.allocation.edit.parts.ResourceContainerEntityNameEditPart.VISUAL_ID == nodeVisualID) {
	return true;
}
if (de.uka.ipd.sdq.pcm.gmf.allocation.edit.parts.ResourceContainerAllocationCompartmentEditPart.VISUAL_ID == nodeVisualID) {
	return true;
}
	break;
case de.uka.ipd.sdq.pcm.gmf.allocation.edit.parts.AllocationContextEditPart.VISUAL_ID:
	if (de.uka.ipd.sdq.pcm.gmf.allocation.edit.parts.AllocationContextEntityNameEditPart.VISUAL_ID == nodeVisualID) {
	return true;
}
if (de.uka.ipd.sdq.pcm.gmf.allocation.edit.parts.AllocationComponentLabelEditPart.VISUAL_ID == nodeVisualID) {
	return true;
}
	break;
case de.uka.ipd.sdq.pcm.gmf.allocation.edit.parts.ResourceContainerAllocationCompartmentEditPart.VISUAL_ID:
	if (de.uka.ipd.sdq.pcm.gmf.allocation.edit.parts.AllocationContextEditPart.VISUAL_ID == nodeVisualID) {
	return true;
}
	break;
			}
	return false;
}
	
		/**
 * @generated
 */
public static int getLinkWithClassVisualID(org.eclipse.emf.ecore.EObject domainElement) {
	if (domainElement == null) {
		return -1;
	}
		return -1;
}
	
				/**
 * User can change implementation of this method to handle some specific
 * situations not covered by default logic.
 * 
 * @generated
 */
private static boolean isDiagram(org.palladiosimulator.pcm.allocation.Allocation element) {
	return true;
}
	
		
	
	/**
 * @generated
 */
	public static boolean checkNodeVisualID(org.eclipse.gmf.runtime.notation.View containerView, org.eclipse.emf.ecore.EObject domainElement, int candidate) {
		if (candidate == -1){
			//unrecognized id is always bad
			return false;
		}
				int basic = getNodeVisualID(containerView, domainElement);
		return basic == candidate;
	}

		/**
 * @generated
 */
	public static boolean isCompartmentVisualID(int visualID) {
					switch (visualID) {
				case de.uka.ipd.sdq.pcm.gmf.allocation.edit.parts.ResourceContainerAllocationCompartmentEditPart.VISUAL_ID:
					return true;
				default:
					break;
			}
				return false;
	}

		/**
 * @generated
 */
	public static boolean isSemanticLeafVisualID(int visualID) {
		switch (visualID) {
						case de.uka.ipd.sdq.pcm.gmf.allocation.edit.parts.AllocationEditPart.VISUAL_ID:
				return false;
																								case de.uka.ipd.sdq.pcm.gmf.allocation.edit.parts.AllocationContextEditPart.VISUAL_ID:
													return true;
			default:
				break;
		}
		return false;
	}

		/**
 * @generated
 */
	public static final org.eclipse.gmf.tooling.runtime.structure.DiagramStructure TYPED_INSTANCE = new org.eclipse.gmf.tooling.runtime.structure.DiagramStructure() {
		/**
 * @generated
 */
		@Override

		public int getVisualID(org.eclipse.gmf.runtime.notation.View view) {
			return de.uka.ipd.sdq.pcm.gmf.allocation.part.PalladioComponentModelVisualIDRegistry.getVisualID(view);
		}
		
		/**
 * @generated
 */
		@Override

		public String getModelID(org.eclipse.gmf.runtime.notation.View view) {
			return de.uka.ipd.sdq.pcm.gmf.allocation.part.PalladioComponentModelVisualIDRegistry.getModelID(view);
		}
		
		/**
 * @generated
 */
		@Override

		public int getNodeVisualID(org.eclipse.gmf.runtime.notation.View containerView, org.eclipse.emf.ecore.EObject domainElement) {
			return de.uka.ipd.sdq.pcm.gmf.allocation.part.PalladioComponentModelVisualIDRegistry.getNodeVisualID(containerView, domainElement);
		}
		
		/**
 * @generated
 */
		@Override

		public boolean checkNodeVisualID(org.eclipse.gmf.runtime.notation.View containerView, org.eclipse.emf.ecore.EObject domainElement, int candidate) {
			return de.uka.ipd.sdq.pcm.gmf.allocation.part.PalladioComponentModelVisualIDRegistry.checkNodeVisualID(containerView, domainElement, candidate);
		}

		/**
 * @generated
 */
		@Override

		public boolean isCompartmentVisualID(int visualID) {
			return de.uka.ipd.sdq.pcm.gmf.allocation.part.PalladioComponentModelVisualIDRegistry.isCompartmentVisualID(visualID);
		}

		/**
 * @generated
 */
		@Override

		public boolean isSemanticLeafVisualID(int visualID) {
			return de.uka.ipd.sdq.pcm.gmf.allocation.part.PalladioComponentModelVisualIDRegistry.isSemanticLeafVisualID(visualID);
		}
	};

	}
