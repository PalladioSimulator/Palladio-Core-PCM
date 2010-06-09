/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package StoExAlternatives.impl;

import StoExAlternatives.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class StoExAlternativesFactoryImpl extends EFactoryImpl implements StoExAlternativesFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static StoExAlternativesFactory init() {
		try {
			StoExAlternativesFactory theStoExAlternativesFactory = (StoExAlternativesFactory)EPackage.Registry.INSTANCE.getEFactory("http:///StoExAlternatives.ecore"); 
			if (theStoExAlternativesFactory != null) {
				return theStoExAlternativesFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new StoExAlternativesFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StoExAlternativesFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case StoExAlternativesPackage.EXPRESSION_PROXY: return createExpressionProxy();
			case StoExAlternativesPackage.STO_EX_PART: return createStoExPart();
			case StoExAlternativesPackage.PROXY_REPOSITORY: return createProxyRepository();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExpressionProxy createExpressionProxy() {
		ExpressionProxyImpl expressionProxy = new ExpressionProxyImpl();
		return expressionProxy;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StoExPart createStoExPart() {
		StoExPartImpl stoExPart = new StoExPartImpl();
		return stoExPart;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProxyRepository createProxyRepository() {
		ProxyRepositoryImpl proxyRepository = new ProxyRepositoryImpl();
		return proxyRepository;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StoExAlternativesPackage getStoExAlternativesPackage() {
		return (StoExAlternativesPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static StoExAlternativesPackage getPackage() {
		return StoExAlternativesPackage.eINSTANCE;
	}

} //StoExAlternativesFactoryImpl
