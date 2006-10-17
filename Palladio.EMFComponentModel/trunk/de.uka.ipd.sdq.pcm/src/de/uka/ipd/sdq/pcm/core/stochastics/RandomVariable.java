
/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.core.stochastics;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Random Variable</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.core.stochastics.RandomVariable#getSpecification <em>Specification</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.core.stochastics.RandomVariable#getSpecification_RandomVariable <em>Specification Random Variable</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.pcm.core.stochastics.StochasticsPackage#getRandomVariable()
 * @model
 * @generated
 */
public interface RandomVariable extends EObject {
	/**
	 * Returns the value of the '<em><b>Specification</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Specification</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Specification</em>' attribute.
	 * @see #setSpecification(String)
	 * @see de.uka.ipd.sdq.pcm.core.stochastics.StochasticsPackage#getRandomVariable_Specification()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	String getSpecification();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.core.stochastics.RandomVariable#getSpecification <em>Specification</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Specification</em>' attribute.
	 * @see #getSpecification()
	 * @generated
	 */
	void setSpecification(String value);

	/**
	 * Returns the value of the '<em><b>Specification Random Variable</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Specification Random Variable</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Specification Random Variable</em>' containment reference.
	 * @see #setSpecification_RandomVariable(Expression)
	 * @see de.uka.ipd.sdq.pcm.core.stochastics.StochasticsPackage#getRandomVariable_Specification_RandomVariable()
	 * @model containment="true" required="true" ordered="false"
	 * @generated
	 */
	Expression getSpecification_RandomVariable();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.core.stochastics.RandomVariable#getSpecification_RandomVariable <em>Specification Random Variable</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Specification Random Variable</em>' containment reference.
	 * @see #getSpecification_RandomVariable()
	 * @generated
	 */
	void setSpecification_RandomVariable(Expression value);

} // RandomVariable