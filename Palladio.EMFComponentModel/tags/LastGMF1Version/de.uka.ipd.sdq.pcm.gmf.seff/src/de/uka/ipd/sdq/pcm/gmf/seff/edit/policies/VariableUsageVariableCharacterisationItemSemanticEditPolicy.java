/*
 *Copyright 2006 SDQ Research Group, University of Karlsruhe (TH)
 */
package de.uka.ipd.sdq.pcm.gmf.seff.edit.policies;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.commands.CreateElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.notation.View;

import de.uka.ipd.sdq.pcm.gmf.seff.providers.PcmElementTypes;
import de.uka.ipd.sdq.pcm.parameter.ParameterPackage;

/**
 * @generated
 */
public class VariableUsageVariableCharacterisationItemSemanticEditPolicy extends
		PcmBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	protected Command getCreateCommand(CreateElementRequest req) {
		if (PcmElementTypes.VariableCharacterisation_2002 == req
				.getElementType()) {
			if (req.getContainmentFeature() == null) {
				req
						.setContainmentFeature(ParameterPackage.eINSTANCE
								.getVariableUsage_VariableCharacterisation_VariableUsage());
			}
			return getMSLWrapper(new CreateVariableCharacterisation_2002Command(
					req));
		}
		return super.getCreateCommand(req);
	}

	/**
	 * @generated
	 */
	private static class CreateVariableCharacterisation_2002Command extends
			CreateElementCommand {

		/**
		 * @generated
		 */
		public CreateVariableCharacterisation_2002Command(
				CreateElementRequest req) {
			super(req);
		}

		/**
		 * @generated
		 */
		protected EClass getEClassToEdit() {
			return ParameterPackage.eINSTANCE.getVariableUsage();
		};

		/**
		 * @generated
		 */
		protected EObject getElementToEdit() {
			EObject container = ((CreateElementRequest) getRequest())
					.getContainer();
			if (container instanceof View) {
				container = ((View) container).getElement();
			}
			return container;
		}
	}

}
