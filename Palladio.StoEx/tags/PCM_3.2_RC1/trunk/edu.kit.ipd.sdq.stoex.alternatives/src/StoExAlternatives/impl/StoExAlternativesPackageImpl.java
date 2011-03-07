/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package StoExAlternatives.impl;

import StoExAlternatives.ExpressionProxy;
import StoExAlternatives.ProxyRepository;
import StoExAlternatives.StoExAlternativesFactory;
import StoExAlternatives.StoExAlternativesPackage;
import StoExAlternatives.StoExPart;

import de.uka.ipd.sdq.stoex.StoexPackage;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class StoExAlternativesPackageImpl extends EPackageImpl implements StoExAlternativesPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass expressionProxyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass stoExPartEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass proxyRepositoryEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see StoExAlternatives.StoExAlternativesPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private StoExAlternativesPackageImpl() {
		super(eNS_URI, StoExAlternativesFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link StoExAlternativesPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static StoExAlternativesPackage init() {
		if (isInited) return (StoExAlternativesPackage)EPackage.Registry.INSTANCE.getEPackage(StoExAlternativesPackage.eNS_URI);

		// Obtain or create and register package
		StoExAlternativesPackageImpl theStoExAlternativesPackage = (StoExAlternativesPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof StoExAlternativesPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new StoExAlternativesPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		StoexPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theStoExAlternativesPackage.createPackageContents();

		// Initialize created meta-data
		theStoExAlternativesPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theStoExAlternativesPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(StoExAlternativesPackage.eNS_URI, theStoExAlternativesPackage);
		return theStoExAlternativesPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getExpressionProxy() {
		return expressionProxyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getExpressionProxy_Alternatives() {
		return (EReference)expressionProxyEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getExpressionProxy_Expression() {
		return (EReference)expressionProxyEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStoExPart() {
		return stoExPartEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getStoExPart_SubExpression() {
		return (EReference)stoExPartEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getStoExPart_ExpressionProxy() {
		return (EReference)stoExPartEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getProxyRepository() {
		return proxyRepositoryEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProxyRepository_ExpressionProxy() {
		return (EReference)proxyRepositoryEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProxyRepository_StoExPart() {
		return (EReference)proxyRepositoryEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StoExAlternativesFactory getStoExAlternativesFactory() {
		return (StoExAlternativesFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		expressionProxyEClass = createEClass(EXPRESSION_PROXY);
		createEReference(expressionProxyEClass, EXPRESSION_PROXY__ALTERNATIVES);
		createEReference(expressionProxyEClass, EXPRESSION_PROXY__EXPRESSION);

		stoExPartEClass = createEClass(STO_EX_PART);
		createEReference(stoExPartEClass, STO_EX_PART__SUB_EXPRESSION);
		createEReference(stoExPartEClass, STO_EX_PART__EXPRESSION_PROXY);

		proxyRepositoryEClass = createEClass(PROXY_REPOSITORY);
		createEReference(proxyRepositoryEClass, PROXY_REPOSITORY__EXPRESSION_PROXY);
		createEReference(proxyRepositoryEClass, PROXY_REPOSITORY__STO_EX_PART);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		StoexPackage theStoexPackage = (StoexPackage)EPackage.Registry.INSTANCE.getEPackage(StoexPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		expressionProxyEClass.getESuperTypes().add(theStoexPackage.getExpression());

		// Initialize classes and features; add operations and parameters
		initEClass(expressionProxyEClass, ExpressionProxy.class, "ExpressionProxy", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getExpressionProxy_Alternatives(), this.getStoExPart(), this.getStoExPart_ExpressionProxy(), "alternatives", null, 0, -1, ExpressionProxy.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getExpressionProxy_Expression(), theStoexPackage.getExpression(), null, "expression", null, 1, 1, ExpressionProxy.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(stoExPartEClass, StoExPart.class, "StoExPart", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getStoExPart_SubExpression(), theStoexPackage.getExpression(), null, "subExpression", null, 1, 1, StoExPart.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getStoExPart_ExpressionProxy(), this.getExpressionProxy(), this.getExpressionProxy_Alternatives(), "expressionProxy", null, 1, 1, StoExPart.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(proxyRepositoryEClass, ProxyRepository.class, "ProxyRepository", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getProxyRepository_ExpressionProxy(), this.getExpressionProxy(), null, "expressionProxy", null, 0, -1, ProxyRepository.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getProxyRepository_StoExPart(), this.getStoExPart(), null, "stoExPart", null, 0, -1, ProxyRepository.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //StoExAlternativesPackageImpl
