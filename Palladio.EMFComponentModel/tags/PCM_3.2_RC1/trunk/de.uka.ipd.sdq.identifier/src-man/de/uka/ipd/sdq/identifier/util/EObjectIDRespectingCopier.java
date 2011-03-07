package de.uka.ipd.sdq.identifier.util;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.EcoreUtil.Copier;

import de.uka.ipd.sdq.identifier.Identifier;
import de.uka.ipd.sdq.identifier.IdentifierPackage;

public class EObjectIDRespectingCopier extends Copier {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5643746361216087434L;

	@Override
	protected void copyAttribute(EAttribute attribute, EObject object,
			EObject copyEObject) {
		if (attribute == IdentifierPackage.eINSTANCE.getIdentifier_Id()) {
			((Identifier) copyEObject).setId(EcoreUtil.generateUUID());
		} else {
			super.copyAttribute(attribute, object, copyEObject);
		}
	}

}
