/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package StoExAlternatives;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Proxy Repository</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link StoExAlternatives.ProxyRepository#getExpressionProxy <em>Expression Proxy</em>}</li>
 *   <li>{@link StoExAlternatives.ProxyRepository#getStoExPart <em>Sto Ex Part</em>}</li>
 * </ul>
 * </p>
 *
 * @see StoExAlternatives.StoExAlternativesPackage#getProxyRepository()
 * @model
 * @generated
 */
public interface ProxyRepository extends EObject {
	/**
	 * Returns the value of the '<em><b>Expression Proxy</b></em>' containment reference list.
	 * The list contents are of type {@link StoExAlternatives.ExpressionProxy}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Expression Proxy</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Expression Proxy</em>' containment reference list.
	 * @see StoExAlternatives.StoExAlternativesPackage#getProxyRepository_ExpressionProxy()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<ExpressionProxy> getExpressionProxy();

	/**
	 * Returns the value of the '<em><b>Sto Ex Part</b></em>' containment reference list.
	 * The list contents are of type {@link StoExAlternatives.StoExPart}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sto Ex Part</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sto Ex Part</em>' containment reference list.
	 * @see StoExAlternatives.StoExAlternativesPackage#getProxyRepository_StoExPart()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<StoExPart> getStoExPart();

} // ProxyRepository
