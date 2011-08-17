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
 * A representation of the model object '<em><b>Dimension Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A dimension type specifies the type of the elements in the dimension.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.dsexplore.qml.contracttype.QMLContractType.DimensionType#getRelationSemantics <em>Relation Semantics</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.dsexplore.qml.contracttype.QMLContractType.QMLContractTypePackage#getDimensionType()
 * @model abstract="true"
 * @generated
 */
public interface DimensionType extends Identifier {
	/**
	 * Returns the value of the '<em><b>Relation Semantics</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Relation Semantics</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Relation Semantics</em>' containment reference.
	 * @see #setRelationSemantics(RelationSemantics)
	 * @see de.uka.ipd.sdq.dsexplore.qml.contracttype.QMLContractType.QMLContractTypePackage#getDimensionType_RelationSemantics()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	RelationSemantics getRelationSemantics();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.dsexplore.qml.contracttype.QMLContractType.DimensionType#getRelationSemantics <em>Relation Semantics</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Relation Semantics</em>' containment reference.
	 * @see #getRelationSemantics()
	 * @generated
	 */
	void setRelationSemantics(RelationSemantics value);

} // DimensionType
