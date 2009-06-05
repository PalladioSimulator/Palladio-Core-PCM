/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.probfunction;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Unit</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.probfunction.Unit#getUnitName <em>Unit Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.probfunction.ProbfunctionPackage#getUnit()
 * @model
 * @generated
 */
public interface Unit extends EObject {
	/**
	 * Returns the value of the '<em><b>Unit Name</b></em>' attribute.
	 * The default value is <code>""</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Unit Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Unit Name</em>' attribute.
	 * @see #setUnitName(String)
	 * @see de.uka.ipd.sdq.probfunction.ProbfunctionPackage#getUnit_UnitName()
	 * @model default="" unique="false" required="true"
	 * @generated
	 */
	String getUnitName();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.probfunction.Unit#getUnitName <em>Unit Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unit Name</em>' attribute.
	 * @see #getUnitName()
	 * @generated
	 */
	void setUnitName(String value);

} // Unit