/*
 *by SDQ, IPD, U Karlrsuhe (TH), 2006
 */
package de.uka.ipd.sdq.pcm.gmf.system.edit.policies;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.CanonicalEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest.ViewDescriptor;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;

import de.uka.ipd.sdq.pcm.core.composition.AssemblyContext;
import de.uka.ipd.sdq.pcm.gmf.system.part.PcmVisualIDRegistry;
import de.uka.ipd.sdq.pcm.repository.ProvidedRole;
import de.uka.ipd.sdq.pcm.repository.ProvidesComponentType;
import de.uka.ipd.sdq.pcm.repository.RequiredRole;

/**
 * @generated
 */
public class AssemblyContextCanonicalEditPolicy extends CanonicalEditPolicy {

	/**
	 * @generated NOT
	 */
	protected List getSemanticChildrenList() {
		List result = new LinkedList();
		EObject modelObject = ((View) getHost().getModel()).getElement();
		View viewObject = (View) getHost().getModel();
		AssemblyContext ctx = (AssemblyContext) modelObject;
		ProvidesComponentType component = ctx
				.getEncapsulatedComponent_ChildComponentContext();
		for (ProvidedRole r : (List<ProvidedRole>) component
				.getProvidedRoles_InterfaceProvidingEntity()) {
			result.add(r);
		}
		for (RequiredRole r : (List<RequiredRole>) component
				.getRequiredRoles_InterfaceRequiringEntity()) {
			result.add(r);
		}
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
					.getType(de.uka.ipd.sdq.pcm.gmf.system.edit.parts.ReqRoleEditPart.VISUAL_ID);
		CreateViewRequest.ViewDescriptor descriptor = getViewDescriptor(
				elementAdapter, Node.class, sh, pos);
		return descriptor;
	}

}
