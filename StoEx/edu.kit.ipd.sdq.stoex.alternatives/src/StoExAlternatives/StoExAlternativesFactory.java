/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package StoExAlternatives;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see StoExAlternatives.StoExAlternativesPackage
 * @generated
 */
public interface StoExAlternativesFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	StoExAlternativesFactory eINSTANCE = StoExAlternatives.impl.StoExAlternativesFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Expression Proxy</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Expression Proxy</em>'.
	 * @generated
	 */
	ExpressionProxy createExpressionProxy();

	/**
	 * Returns a new object of class '<em>Sto Ex Part</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Sto Ex Part</em>'.
	 * @generated
	 */
	StoExPart createStoExPart();

	/**
	 * Returns a new object of class '<em>Proxy Repository</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Proxy Repository</em>'.
	 * @generated
	 */
	ProxyRepository createProxyRepository();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	StoExAlternativesPackage getStoExAlternativesPackage();

} //StoExAlternativesFactory
