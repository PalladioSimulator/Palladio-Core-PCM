/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.dsexplore.qml.contracttype.QMLContractType;

import de.uka.ipd.sdq.identifier.Identifier;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Relation Semantics</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * The relation semantic of a domain is either increasing or decreasing.
 * A&nbsp;domain&nbsp;is&nbsp;increasing,&nbsp;if&nbsp;bigger&nbsp;elements&nbsp;are&nbsp;better;&nbsp;a&nbsp;domain&nbsp;is&nbsp;decreasing,&nbsp;if&nbsp;smaller&nbsp;elements&nbsp;are&nbsp;better.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.dsexplore.qml.contracttype.QMLContractType.RelationSemantics#getRelSem <em>Rel Sem</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.dsexplore.qml.contracttype.QMLContractType.QMLContractTypePackage#getRelationSemantics()
 * @model
 * @generated
 */
public interface RelationSemantics extends Identifier {
	/**
	 * Returns the value of the '<em><b>Rel Sem</b></em>' attribute.
	 * The literals are from the enumeration {@link de.uka.ipd.sdq.dsexplore.qml.contracttype.QMLContractType.EnumRelationSemantics}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Rel Sem</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rel Sem</em>' attribute.
	 * @see de.uka.ipd.sdq.dsexplore.qml.contracttype.QMLContractType.EnumRelationSemantics
	 * @see #setRelSem(EnumRelationSemantics)
	 * @see de.uka.ipd.sdq.dsexplore.qml.contracttype.QMLContractType.QMLContractTypePackage#getRelationSemantics_RelSem()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	EnumRelationSemantics getRelSem();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.dsexplore.qml.contracttype.QMLContractType.RelationSemantics#getRelSem <em>Rel Sem</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Rel Sem</em>' attribute.
	 * @see de.uka.ipd.sdq.dsexplore.qml.contracttype.QMLContractType.EnumRelationSemantics
	 * @see #getRelSem()
	 * @generated
	 */
	void setRelSem(EnumRelationSemantics value);

} // RelationSemantics
