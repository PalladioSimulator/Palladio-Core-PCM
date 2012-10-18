/*
 *Copyright 2007, SDQ, IPD, Uni Karlsruhe (TH)
 */
package de.uka.ipd.sdq.pcm.gmf.composite.edit.policies;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.CanonicalEditPolicy;
import org.eclipse.gmf.runtime.notation.View;

import de.uka.ipd.sdq.pcm.core.composition.AssemblyContext;
import de.uka.ipd.sdq.pcm.core.entity.EntityPackage;
import de.uka.ipd.sdq.pcm.core.entity.InterfaceProvidingEntity;
import de.uka.ipd.sdq.pcm.core.entity.InterfaceRequiringEntity;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.parts.InfrastructureProvidedRoleEditPart;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.parts.InfrastructureRequiredRoleEditPart;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.parts.OperationProvidedRoleEditPart;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.parts.OperationRequiredRoleEditPart;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.parts.SinkRoleEditPart;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.parts.SourceRoleEditPart;
import de.uka.ipd.sdq.pcm.gmf.composite.part.PalladioComponentModelVisualIDRegistry;

/**
 * The Class AssemblyContextCanonicalEditPolicy.
 *
 * @generated
 */
public class AssemblyContextCanonicalEditPolicy extends CanonicalEditPolicy {

	/** The my features to synchronize. @generated */
	Set myFeaturesToSynchronize;

	/**
	 * Get the semantic children of an assembly context.
	 * 
	 * This has been adopted manually for the composite editor diagram. The direct semantic child of
	 * an assembly context is the encapsulated component. In case of the composite diagram we
	 * present the provided and required roles of the component to the user instead. For this, the
	 * getSemanticChildrenList method collects all roles from the encapsulated component.
	 * 
	 * @return The list of prov. and req. roles of the encapsulated component
	 * 
	 * @generated not
	 */
	protected List getSemanticChildrenList() {
		List result = new LinkedList();
		EObject modelObject = ((View) getHost().getModel()).getElement();
		AssemblyContext ctx = (AssemblyContext) modelObject;
		modelObject = ctx.getEncapsulatedComponent__AssemblyContext();
		View viewObject = (View) getHost().getModel();
		EObject nextValue;
		int nodeVID;
		if (modelObject != null) {
			for (Iterator values = ((InterfaceProvidingEntity) modelObject)
					.getProvidedRoles_InterfaceProvidingEntity().iterator(); values
					.hasNext();) {
				nextValue = (EObject) values.next();
				nodeVID = PalladioComponentModelVisualIDRegistry
						.getNodeVisualID(viewObject, nextValue);
				// if (OperationProvidedRoleEditPart.VISUAL_ID == nodeVID) {
				result.add(nextValue);
				// }
			}
			for (Iterator values = ((InterfaceRequiringEntity) modelObject)
					.getRequiredRoles_InterfaceRequiringEntity().iterator(); values
					.hasNext();) {
				nextValue = (EObject) values.next();
				nodeVID = PalladioComponentModelVisualIDRegistry
						.getNodeVisualID(viewObject, nextValue);
				// if (OperationRequiredRoleEditPart.VISUAL_ID == nodeVID) {
				result.add(nextValue);
				// }
			}
		}
		return result;
	}

	/**
	 * Checks if is orphaned.
	 *
	 * @param semanticChildren the semantic children
	 * @param view the view
	 * @return true, if is orphaned
	 * @generated
	 */
	protected boolean isOrphaned(Collection semanticChildren, final View view) {
		int visualID = PalladioComponentModelVisualIDRegistry.getVisualID(view);
		switch (visualID) {
		case OperationProvidedRoleEditPart.VISUAL_ID:
		case OperationRequiredRoleEditPart.VISUAL_ID:
		case SourceRoleEditPart.VISUAL_ID:
		case SinkRoleEditPart.VISUAL_ID:
		case InfrastructureProvidedRoleEditPart.VISUAL_ID:
		case InfrastructureRequiredRoleEditPart.VISUAL_ID:
			if (!semanticChildren.contains(view.getElement())) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Gets the default factory hint.
	 *
	 * @return the default factory hint
	 * @generated
	 */
	protected String getDefaultFactoryHint() {
		return null;
	}

	/**
	 * Gets the features to synchronize.
	 *
	 * @return the features to synchronize
	 * @generated
	 */
	protected Set getFeaturesToSynchronize() {
		if (myFeaturesToSynchronize == null) {
			myFeaturesToSynchronize = new HashSet();
			myFeaturesToSynchronize
					.add(EntityPackage.eINSTANCE
							.getInterfaceProvidingEntity_ProvidedRoles_InterfaceProvidingEntity());
			myFeaturesToSynchronize
					.add(EntityPackage.eINSTANCE
							.getInterfaceRequiringEntity_RequiredRoles_InterfaceRequiringEntity());
		}
		return myFeaturesToSynchronize;
	}

}
