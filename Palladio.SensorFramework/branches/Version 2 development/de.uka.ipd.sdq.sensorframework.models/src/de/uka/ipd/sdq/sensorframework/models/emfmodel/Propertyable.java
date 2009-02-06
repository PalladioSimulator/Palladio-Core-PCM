/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.sensorframework.models.emfmodel;

import org.eclipse.emf.common.util.EMap;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Propertyable</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.sensorframework.models.emfmodel.Propertyable#getAdditionalInformation <em>Additional Information</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.sensorframework.models.emfmodel.emfmodelPackage#getPropertyable()
 * @model abstract="true"
 * @generated
 */
public interface Propertyable extends EObject {
	/**
	 * Returns the value of the '<em><b>Additional Information</b></em>' map.
	 * The key is of type {@link java.lang.String},
	 * and the value is of type {@link java.lang.Object},
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Additional Information</em>' map isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Additional Information</em>' map.
	 * @see de.uka.ipd.sdq.sensorframework.models.emfmodel.emfmodelPackage#getPropertyable_AdditionalInformation()
	 * @model mapType="de.uka.ipd.sdq.sensorframework.models.emfmodel.EStringtoEObjectMapEntry<org.eclipse.emf.ecore.EString, org.eclipse.emf.ecore.EJavaObject>" ordered="false"
	 * @generated
	 */
	EMap<String, Object> getAdditionalInformation();

} // Propertyable
