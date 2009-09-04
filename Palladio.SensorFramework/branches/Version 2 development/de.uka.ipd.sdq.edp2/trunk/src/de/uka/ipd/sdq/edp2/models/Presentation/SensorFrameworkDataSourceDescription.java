/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.edp2.models.Presentation;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Sensor Framework Data Source Description</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.Presentation.SensorFrameworkDataSourceDescription#getSam <em>Sam</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.edp2.models.Presentation.PresentationPackage#getSensorFrameworkDataSourceDescription()
 * @model
 * @generated
 */
public interface SensorFrameworkDataSourceDescription extends EObject {
	/**
	 * Returns the value of the '<em><b>Sam</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sam</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sam</em>' attribute.
	 * @see #setSam(String)
	 * @see de.uka.ipd.sdq.edp2.models.Presentation.PresentationPackage#getSensorFrameworkDataSourceDescription_Sam()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	String getSam();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.edp2.models.Presentation.SensorFrameworkDataSourceDescription#getSam <em>Sam</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sam</em>' attribute.
	 * @see #getSam()
	 * @generated
	 */
	void setSam(String value);

} // SensorFrameworkDataSourceDescription
