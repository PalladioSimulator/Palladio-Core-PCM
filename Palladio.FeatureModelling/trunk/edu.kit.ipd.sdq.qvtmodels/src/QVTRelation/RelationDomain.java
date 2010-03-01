/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package QVTRelation;

import EssentialOCL.Variable;

import QVTBase.Domain;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Relation Domain</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link QVTRelation.RelationDomain#getDefaultAssignment <em>Default Assignment</em>}</li>
 *   <li>{@link QVTRelation.RelationDomain#getPattern <em>Pattern</em>}</li>
 *   <li>{@link QVTRelation.RelationDomain#getRootVariable <em>Root Variable</em>}</li>
 * </ul>
 * </p>
 *
 * @see QVTRelation.QVTRelationPackage#getRelationDomain()
 * @model
 * @generated
 */
public interface RelationDomain extends Domain {
	/**
	 * Returns the value of the '<em><b>Default Assignment</b></em>' containment reference list.
	 * The list contents are of type {@link QVTRelation.RelationDomainAssignment}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Default Assignment</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Default Assignment</em>' containment reference list.
	 * @see QVTRelation.QVTRelationPackage#getRelationDomain_DefaultAssignment()
	 * @model containment="true" ordered="false"
	 *        annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml#Property.oppositeRoleName body='owner'"
	 * @generated
	 */
	EList<RelationDomainAssignment> getDefaultAssignment();

	/**
	 * Returns the value of the '<em><b>Pattern</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Pattern</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Pattern</em>' containment reference.
	 * @see #setPattern(DomainPattern)
	 * @see QVTRelation.QVTRelationPackage#getRelationDomain_Pattern()
	 * @model containment="true"
	 * @generated
	 */
	DomainPattern getPattern();

	/**
	 * Sets the value of the '{@link QVTRelation.RelationDomain#getPattern <em>Pattern</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Pattern</em>' containment reference.
	 * @see #getPattern()
	 * @generated
	 */
	void setPattern(DomainPattern value);

	/**
	 * Returns the value of the '<em><b>Root Variable</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Root Variable</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Root Variable</em>' reference.
	 * @see #setRootVariable(Variable)
	 * @see QVTRelation.QVTRelationPackage#getRelationDomain_RootVariable()
	 * @model required="true"
	 * @generated
	 */
	Variable getRootVariable();

	/**
	 * Sets the value of the '{@link QVTRelation.RelationDomain#getRootVariable <em>Root Variable</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Root Variable</em>' reference.
	 * @see #getRootVariable()
	 * @generated
	 */
	void setRootVariable(Variable value);

} // RelationDomain
