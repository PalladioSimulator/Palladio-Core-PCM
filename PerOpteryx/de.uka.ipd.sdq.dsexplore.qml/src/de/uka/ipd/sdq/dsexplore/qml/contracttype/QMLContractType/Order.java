/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.dsexplore.qml.contracttype.QMLContractType;

import de.uka.ipd.sdq.identifier.Identifier;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Order</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Orders&nbsp;two&nbsp;elements&nbsp;directly&nbsp;by&nbsp;specifying one&nbsp;bigger&nbsp;than&nbsp;the&nbsp;other.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.dsexplore.qml.contracttype.QMLContractType.Order#getBiggerElement <em>Bigger Element</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.dsexplore.qml.contracttype.QMLContractType.Order#getSmallerElement <em>Smaller Element</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.dsexplore.qml.contracttype.QMLContractType.QMLContractTypePackage#getOrder()
 * @model
 * @generated
 */
public interface Order extends Identifier {
	/**
	 * Returns the value of the '<em><b>Bigger Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Bigger Element</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Bigger Element</em>' reference.
	 * @see #setBiggerElement(Element)
	 * @see de.uka.ipd.sdq.dsexplore.qml.contracttype.QMLContractType.QMLContractTypePackage#getOrder_BiggerElement()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	Element getBiggerElement();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.dsexplore.qml.contracttype.QMLContractType.Order#getBiggerElement <em>Bigger Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Bigger Element</em>' reference.
	 * @see #getBiggerElement()
	 * @generated
	 */
	void setBiggerElement(Element value);

	/**
	 * Returns the value of the '<em><b>Smaller Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Smaller Element</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Smaller Element</em>' reference.
	 * @see #setSmallerElement(Element)
	 * @see de.uka.ipd.sdq.dsexplore.qml.contracttype.QMLContractType.QMLContractTypePackage#getOrder_SmallerElement()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	Element getSmallerElement();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.dsexplore.qml.contracttype.QMLContractType.Order#getSmallerElement <em>Smaller Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Smaller Element</em>' reference.
	 * @see #getSmallerElement()
	 * @generated
	 */
	void setSmallerElement(Element value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * self.biggerElement<>self.smallerElement
	 * @param diagnostics The chain of diagnostics to which problems are to be appended.
	 * @param context The cache of context-specific information.
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/uml2/1.1.0/GenModel body='self.biggerElement<>self.smallerElement'"
	 * @generated
	 */
	boolean BIGGERELEMENT_must_not_be_SMALLELEMENT(DiagnosticChain diagnostics, Map<Object, Object> context);

} // Order
