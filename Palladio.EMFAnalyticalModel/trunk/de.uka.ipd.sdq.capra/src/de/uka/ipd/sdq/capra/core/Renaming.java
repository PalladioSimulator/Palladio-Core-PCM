/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.capra.core;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Renaming</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.capra.core.Renaming#getRenamedProcess <em>Renamed Process</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.capra.core.Renaming#getMapping <em>Mapping</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.capra.core.CorePackage#getRenaming()
 * @model
 * @generated
 */
public interface Renaming extends Operator {
	/**
	 * Returns the value of the '<em><b>Renamed Process</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Renamed Process</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Renamed Process</em>' containment reference.
	 * @see #setRenamedProcess(CapraExpression)
	 * @see de.uka.ipd.sdq.capra.core.CorePackage#getRenaming_RenamedProcess()
	 * @model containment="true" required="true" ordered="false"
	 * @generated
	 */
	CapraExpression getRenamedProcess();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.capra.core.Renaming#getRenamedProcess <em>Renamed Process</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Renamed Process</em>' containment reference.
	 * @see #getRenamedProcess()
	 * @generated
	 */
	void setRenamedProcess(CapraExpression value);

	/**
	 * Returns the value of the '<em><b>Mapping</b></em>' containment reference list.
	 * The list contents are of type {@link de.uka.ipd.sdq.capra.core.Mapping}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mapping</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mapping</em>' containment reference list.
	 * @see de.uka.ipd.sdq.capra.core.CorePackage#getRenaming_Mapping()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<Mapping> getMapping();

} // Renaming
