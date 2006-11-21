/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.qnm;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Logical Demand</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.qnm.LogicalDemand#getLogicalserver <em>Logicalserver</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.qnm.LogicalDemand#getDemands <em>Demands</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.qnm.QnmPackage#getLogicalDemand()
 * @model abstract="true"
 * @generated
 */
public interface LogicalDemand extends Demand {
	/**
	 * Returns the value of the '<em><b>Logicalserver</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Logicalserver</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Logicalserver</em>' reference.
	 * @see #setLogicalserver(LogicalServer)
	 * @see de.uka.ipd.sdq.qnm.QnmPackage#getLogicalDemand_Logicalserver()
	 * @model required="true"
	 * @generated
	 */
	LogicalServer getLogicalserver();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.qnm.LogicalDemand#getLogicalserver <em>Logicalserver</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Logicalserver</em>' reference.
	 * @see #getLogicalserver()
	 * @generated
	 */
	void setLogicalserver(LogicalServer value);

	/**
	 * Returns the value of the '<em><b>Demands</b></em>' containment reference list.
	 * The list contents are of type {@link de.uka.ipd.sdq.qnm.Demand}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Demands</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Demands</em>' containment reference list.
	 * @see de.uka.ipd.sdq.qnm.QnmPackage#getLogicalDemand_Demands()
	 * @model type="de.uka.ipd.sdq.qnm.Demand" containment="true"
	 * @generated
	 */
	EList getDemands();

} // LogicalDemand