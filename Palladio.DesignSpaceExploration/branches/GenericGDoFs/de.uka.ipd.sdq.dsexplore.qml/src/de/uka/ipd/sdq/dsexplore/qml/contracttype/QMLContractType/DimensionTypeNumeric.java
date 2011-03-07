/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.dsexplore.qml.contracttype.QMLContractType;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Dimension Type Numeric</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.dsexplore.qml.contracttype.QMLContractType.DimensionTypeNumeric#getRange <em>Range</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.dsexplore.qml.contracttype.QMLContractType.DimensionTypeNumeric#getDomain <em>Domain</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.dsexplore.qml.contracttype.QMLContractType.QMLContractTypePackage#getDimensionTypeNumeric()
 * @model
 * @generated
 */
public interface DimensionTypeNumeric extends DimensionType {
	/**
	 * Returns the value of the '<em><b>Range</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Range</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Range</em>' containment reference.
	 * @see #setRange(NumericRange)
	 * @see de.uka.ipd.sdq.dsexplore.qml.contracttype.QMLContractType.QMLContractTypePackage#getDimensionTypeNumeric_Range()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	NumericRange getRange();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.dsexplore.qml.contracttype.QMLContractType.DimensionTypeNumeric#getRange <em>Range</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Range</em>' containment reference.
	 * @see #getRange()
	 * @generated
	 */
	void setRange(NumericRange value);

	/**
	 * Returns the value of the '<em><b>Domain</b></em>' attribute.
	 * The literals are from the enumeration {@link de.uka.ipd.sdq.dsexplore.qml.contracttype.QMLContractType.EnumNumericDomain}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Domain</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Domain</em>' attribute.
	 * @see de.uka.ipd.sdq.dsexplore.qml.contracttype.QMLContractType.EnumNumericDomain
	 * @see #setDomain(EnumNumericDomain)
	 * @see de.uka.ipd.sdq.dsexplore.qml.contracttype.QMLContractType.QMLContractTypePackage#getDimensionTypeNumeric_Domain()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	EnumNumericDomain getDomain();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.dsexplore.qml.contracttype.QMLContractType.DimensionTypeNumeric#getDomain <em>Domain</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Domain</em>' attribute.
	 * @see de.uka.ipd.sdq.dsexplore.qml.contracttype.QMLContractType.EnumNumericDomain
	 * @see #getDomain()
	 * @generated
	 */
	void setDomain(EnumNumericDomain value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * self.relationSemantics <> null
	 * @param diagnostics The chain of diagnostics to which problems are to be appended.
	 * @param context The cache of context-specific information.
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/uml2/1.1.0/GenModel body='self.relationSemantics <> null'"
	 * @generated
	 */
	boolean NUMERICDIMENSIONTYPE_must_have_RELATIONSEMANTICS(DiagnosticChain diagnostics, Map<Object, Object> context);

} // DimensionTypeNumeric
