/*
 *by SDQ, IPD, U Karlrsuhe (TH), 2006
 */
package de.uka.ipd.sdq.pcm.gmf.system.edit.policies;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.CanonicalEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest.ViewDescriptor;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;

import de.uka.ipd.sdq.pcm.gmf.system.part.PcmVisualIDRegistry;
import de.uka.ipd.sdq.pcm.repository.RequiredRole;

/**
 * @generated
 */
public class SystemNodeCanonicalEditPolicy extends CanonicalEditPolicy {

	/**
	 * @generated NOT
	 */
	protected List getSemanticChildrenList() {
		List result = new LinkedList();
		EObject modelObject = ((View) getHost().getModel()).getElement();
		View viewObject = (View) getHost().getModel();
		EObject nextValue;
		int nodeVID;
		for (Iterator values = ((de.uka.ipd.sdq.pcm.system.System) modelObject)
				.getProvidedRoles_InterfaceProvidingEntity().iterator(); values.hasNext();) {
			nextValue = (EObject) values.next();
			result.add(nextValue);
		}
		for (Iterator values = ((de.uka.ipd.sdq.pcm.system.System) modelObject)
				.getRequiredRoles_InterfaceRequiringEntity().iterator(); values.hasNext();) {
			nextValue = (EObject) values.next();
			result.add(nextValue);
		}
//		for (Iterator values = ((ComposedStructure) modelObject)
//				.getChildComponentContexts_ComposedStructure().iterator(); values
//				.hasNext();) {
//			nextValue = (EObject) values.next();
//			nodeVID = PcmVisualIDRegistry
//					.getNodeVisualID(viewObject, nextValue);
//			if (AssemblyContextEditPart.VISUAL_ID == nodeVID) {
//				result.add(nextValue);
//			}
//		}		
		return result;
	}

	/**
	 * @generated
	 */
	protected boolean shouldDeleteView(View view) {
		return view.isSetElement() && view.getElement() != null
				&& view.getElement().eIsProxy();
	}

	/**
	 * @generated
	 */
	protected String getDefaultFactoryHint() {
		return null;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.gmf.runtime.diagram.ui.editpolicies.CanonicalEditPolicy#getViewDescriptor(org.eclipse.core.runtime.IAdaptable, java.lang.Class, java.lang.String, int)
	 */
	@Override
	protected ViewDescriptor getViewDescriptor(EObject element) {
		//
		// create the view descritor
		String factoryHint = getDefaultFactoryHint();
		IAdaptable elementAdapter = new CanonicalElementAdapter(element,
				factoryHint);

		int pos = getViewIndexFor(element);
		String sh = getFactoryHint(elementAdapter, factoryHint);
		if (element instanceof RequiredRole)
			sh = PcmVisualIDRegistry
					.getType(de.uka.ipd.sdq.pcm.gmf.system.edit.parts.SystemRequiredRoleEditPart.VISUAL_ID);
		CreateViewRequest.ViewDescriptor descriptor = getViewDescriptor(
				elementAdapter, Node.class, sh, pos);
		return descriptor;
	}
}
