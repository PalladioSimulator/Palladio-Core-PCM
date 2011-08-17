/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package StoExAlternatives;

import de.uka.ipd.sdq.stoex.StoexPackage;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see StoExAlternatives.StoExAlternativesFactory
 * @model kind="package"
 * @generated
 */
public interface StoExAlternativesPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "StoExAlternatives";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http:///StoExAlternatives.ecore";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "StoExAlternatives";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	StoExAlternativesPackage eINSTANCE = StoExAlternatives.impl.StoExAlternativesPackageImpl.init();

	/**
	 * The meta object id for the '{@link StoExAlternatives.impl.ExpressionProxyImpl <em>Expression Proxy</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see StoExAlternatives.impl.ExpressionProxyImpl
	 * @see StoExAlternatives.impl.StoExAlternativesPackageImpl#getExpressionProxy()
	 * @generated
	 */
	int EXPRESSION_PROXY = 0;

	/**
	 * The feature id for the '<em><b>Alternatives</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION_PROXY__ALTERNATIVES = StoexPackage.EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Expression</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION_PROXY__EXPRESSION = StoexPackage.EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Expression Proxy</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION_PROXY_FEATURE_COUNT = StoexPackage.EXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link StoExAlternatives.impl.StoExPartImpl <em>Sto Ex Part</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see StoExAlternatives.impl.StoExPartImpl
	 * @see StoExAlternatives.impl.StoExAlternativesPackageImpl#getStoExPart()
	 * @generated
	 */
	int STO_EX_PART = 1;

	/**
	 * The feature id for the '<em><b>Sub Expression</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STO_EX_PART__SUB_EXPRESSION = 0;

	/**
	 * The feature id for the '<em><b>Expression Proxy</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STO_EX_PART__EXPRESSION_PROXY = 1;

	/**
	 * The number of structural features of the '<em>Sto Ex Part</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STO_EX_PART_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link StoExAlternatives.impl.ProxyRepositoryImpl <em>Proxy Repository</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see StoExAlternatives.impl.ProxyRepositoryImpl
	 * @see StoExAlternatives.impl.StoExAlternativesPackageImpl#getProxyRepository()
	 * @generated
	 */
	int PROXY_REPOSITORY = 2;

	/**
	 * The feature id for the '<em><b>Expression Proxy</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROXY_REPOSITORY__EXPRESSION_PROXY = 0;

	/**
	 * The feature id for the '<em><b>Sto Ex Part</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROXY_REPOSITORY__STO_EX_PART = 1;

	/**
	 * The number of structural features of the '<em>Proxy Repository</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROXY_REPOSITORY_FEATURE_COUNT = 2;


	/**
	 * Returns the meta object for class '{@link StoExAlternatives.ExpressionProxy <em>Expression Proxy</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Expression Proxy</em>'.
	 * @see StoExAlternatives.ExpressionProxy
	 * @generated
	 */
	EClass getExpressionProxy();

	/**
	 * Returns the meta object for the reference list '{@link StoExAlternatives.ExpressionProxy#getAlternatives <em>Alternatives</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Alternatives</em>'.
	 * @see StoExAlternatives.ExpressionProxy#getAlternatives()
	 * @see #getExpressionProxy()
	 * @generated
	 */
	EReference getExpressionProxy_Alternatives();

	/**
	 * Returns the meta object for the reference '{@link StoExAlternatives.ExpressionProxy#getExpression <em>Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Expression</em>'.
	 * @see StoExAlternatives.ExpressionProxy#getExpression()
	 * @see #getExpressionProxy()
	 * @generated
	 */
	EReference getExpressionProxy_Expression();

	/**
	 * Returns the meta object for class '{@link StoExAlternatives.StoExPart <em>Sto Ex Part</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sto Ex Part</em>'.
	 * @see StoExAlternatives.StoExPart
	 * @generated
	 */
	EClass getStoExPart();

	/**
	 * Returns the meta object for the reference '{@link StoExAlternatives.StoExPart#getSubExpression <em>Sub Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Sub Expression</em>'.
	 * @see StoExAlternatives.StoExPart#getSubExpression()
	 * @see #getStoExPart()
	 * @generated
	 */
	EReference getStoExPart_SubExpression();

	/**
	 * Returns the meta object for the reference '{@link StoExAlternatives.StoExPart#getExpressionProxy <em>Expression Proxy</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Expression Proxy</em>'.
	 * @see StoExAlternatives.StoExPart#getExpressionProxy()
	 * @see #getStoExPart()
	 * @generated
	 */
	EReference getStoExPart_ExpressionProxy();

	/**
	 * Returns the meta object for class '{@link StoExAlternatives.ProxyRepository <em>Proxy Repository</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Proxy Repository</em>'.
	 * @see StoExAlternatives.ProxyRepository
	 * @generated
	 */
	EClass getProxyRepository();

	/**
	 * Returns the meta object for the containment reference list '{@link StoExAlternatives.ProxyRepository#getExpressionProxy <em>Expression Proxy</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Expression Proxy</em>'.
	 * @see StoExAlternatives.ProxyRepository#getExpressionProxy()
	 * @see #getProxyRepository()
	 * @generated
	 */
	EReference getProxyRepository_ExpressionProxy();

	/**
	 * Returns the meta object for the containment reference list '{@link StoExAlternatives.ProxyRepository#getStoExPart <em>Sto Ex Part</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Sto Ex Part</em>'.
	 * @see StoExAlternatives.ProxyRepository#getStoExPart()
	 * @see #getProxyRepository()
	 * @generated
	 */
	EReference getProxyRepository_StoExPart();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	StoExAlternativesFactory getStoExAlternativesFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link StoExAlternatives.impl.ExpressionProxyImpl <em>Expression Proxy</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see StoExAlternatives.impl.ExpressionProxyImpl
		 * @see StoExAlternatives.impl.StoExAlternativesPackageImpl#getExpressionProxy()
		 * @generated
		 */
		EClass EXPRESSION_PROXY = eINSTANCE.getExpressionProxy();

		/**
		 * The meta object literal for the '<em><b>Alternatives</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXPRESSION_PROXY__ALTERNATIVES = eINSTANCE.getExpressionProxy_Alternatives();

		/**
		 * The meta object literal for the '<em><b>Expression</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXPRESSION_PROXY__EXPRESSION = eINSTANCE.getExpressionProxy_Expression();

		/**
		 * The meta object literal for the '{@link StoExAlternatives.impl.StoExPartImpl <em>Sto Ex Part</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see StoExAlternatives.impl.StoExPartImpl
		 * @see StoExAlternatives.impl.StoExAlternativesPackageImpl#getStoExPart()
		 * @generated
		 */
		EClass STO_EX_PART = eINSTANCE.getStoExPart();

		/**
		 * The meta object literal for the '<em><b>Sub Expression</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STO_EX_PART__SUB_EXPRESSION = eINSTANCE.getStoExPart_SubExpression();

		/**
		 * The meta object literal for the '<em><b>Expression Proxy</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STO_EX_PART__EXPRESSION_PROXY = eINSTANCE.getStoExPart_ExpressionProxy();

		/**
		 * The meta object literal for the '{@link StoExAlternatives.impl.ProxyRepositoryImpl <em>Proxy Repository</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see StoExAlternatives.impl.ProxyRepositoryImpl
		 * @see StoExAlternatives.impl.StoExAlternativesPackageImpl#getProxyRepository()
		 * @generated
		 */
		EClass PROXY_REPOSITORY = eINSTANCE.getProxyRepository();

		/**
		 * The meta object literal for the '<em><b>Expression Proxy</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROXY_REPOSITORY__EXPRESSION_PROXY = eINSTANCE.getProxyRepository_ExpressionProxy();

		/**
		 * The meta object literal for the '<em><b>Sto Ex Part</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROXY_REPOSITORY__STO_EX_PART = eINSTANCE.getProxyRepository_StoExPart();

	}

} //StoExAlternativesPackage
