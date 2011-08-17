/**
 * 
 */
package de.fzi.se.quality.util;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.EcoreUtil.Copier;

/**Copies an EObject but replaced old Ids with new ones.
 * @author groenda
 *
 */
public class EcoreCopierCreatingNewIds extends Copier {
	  
	/**
	 */
	private static final long serialVersionUID = 8417471343199324464L;

	@Override
	protected void copyAttribute(EAttribute eAttribute, EObject eObject,
			EObject copyEObject) {
		if (eAttribute.isID() && !eAttribute.isMany() && eAttribute.isRequired()) {
			// if the value is not automatically created upon object creation for identifier based classes
			EcoreUtil.setID(copyEObject, EcoreUtil.generateUUID());
		} else {
			super.copyAttribute(eAttribute, eObject, copyEObject);
		}
	}
}
