/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.fzi.se.quality.impl;

import de.fzi.se.quality.QualityFactory;
import de.fzi.se.quality.QualityPackage;
import de.fzi.se.quality.QualityRepository;
import de.fzi.se.quality.QualityStatement;

import de.fzi.se.quality.parameters.ParametersPackage;

import de.fzi.se.quality.parameters.impl.ParametersPackageImpl;

import de.fzi.se.quality.parameters.pcm.PCMPackage;

import de.fzi.se.quality.parameters.pcm.impl.PCMPackageImpl;

import de.fzi.se.quality.qualityannotation.QualityAnnotationPackage;

import de.fzi.se.quality.qualityannotation.impl.QualityAnnotationPackageImpl;

import de.uka.ipd.sdq.identifier.IdentifierPackage;

import de.uka.ipd.sdq.pcm.PcmPackage;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;
import probfunction.ProbfunctionPackage;
import probfunction.impl.ProbfunctionPackageImpl;
import types.TypesPackage;
import types.impl.TypesPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class QualityPackageImpl extends EPackageImpl implements QualityPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass qualityRepositoryEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass qualityStatementEClass = null;

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
	 * @see de.fzi.se.quality.QualityPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private QualityPackageImpl() {
		super(eNS_URI, QualityFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link QualityPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static QualityPackage init() {
		if (isInited) return (QualityPackage)EPackage.Registry.INSTANCE.getEPackage(QualityPackage.eNS_URI);

		// Obtain or create and register package
		QualityPackageImpl theQualityPackage = (QualityPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof QualityPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new QualityPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		PcmPackage.eINSTANCE.eClass();

		// Obtain or create and register interdependencies
		QualityAnnotationPackageImpl theQualityAnnotationPackage = (QualityAnnotationPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(QualityAnnotationPackage.eNS_URI) instanceof QualityAnnotationPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(QualityAnnotationPackage.eNS_URI) : QualityAnnotationPackage.eINSTANCE);
		ParametersPackageImpl theParametersPackage = (ParametersPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ParametersPackage.eNS_URI) instanceof ParametersPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ParametersPackage.eNS_URI) : ParametersPackage.eINSTANCE);
		PCMPackageImpl thePCMPackage = (PCMPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(PCMPackage.eNS_URI) instanceof PCMPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(PCMPackage.eNS_URI) : PCMPackage.eINSTANCE);
		TypesPackageImpl theTypesPackage = (TypesPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(TypesPackage.eNS_URI) instanceof TypesPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(TypesPackage.eNS_URI) : TypesPackage.eINSTANCE);
		ProbfunctionPackageImpl theProbfunctionPackage = (ProbfunctionPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ProbfunctionPackage.eNS_URI) instanceof ProbfunctionPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ProbfunctionPackage.eNS_URI) : ProbfunctionPackage.eINSTANCE);

		// Create package meta-data objects
		theQualityPackage.createPackageContents();
		theQualityAnnotationPackage.createPackageContents();
		theParametersPackage.createPackageContents();
		thePCMPackage.createPackageContents();
		theTypesPackage.createPackageContents();
		theProbfunctionPackage.createPackageContents();

		// Initialize created meta-data
		theQualityPackage.initializePackageContents();
		theQualityAnnotationPackage.initializePackageContents();
		theParametersPackage.initializePackageContents();
		thePCMPackage.initializePackageContents();
		theTypesPackage.initializePackageContents();
		theProbfunctionPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theQualityPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(QualityPackage.eNS_URI, theQualityPackage);
		return theQualityPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getQualityRepository() {
		return qualityRepositoryEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getQualityRepository_QualityStatements() {
		return (EReference)qualityRepositoryEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getQualityStatement() {
		return qualityStatementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getQualityStatement_QualityRepository() {
		return (EReference)qualityStatementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public QualityFactory getQualityFactory() {
		return (QualityFactory)getEFactoryInstance();
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
		qualityRepositoryEClass = createEClass(QUALITY_REPOSITORY);
		createEReference(qualityRepositoryEClass, QUALITY_REPOSITORY__QUALITY_STATEMENTS);

		qualityStatementEClass = createEClass(QUALITY_STATEMENT);
		createEReference(qualityStatementEClass, QUALITY_STATEMENT__QUALITY_REPOSITORY);
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
		QualityAnnotationPackage theQualityAnnotationPackage = (QualityAnnotationPackage)EPackage.Registry.INSTANCE.getEPackage(QualityAnnotationPackage.eNS_URI);
		ParametersPackage theParametersPackage = (ParametersPackage)EPackage.Registry.INSTANCE.getEPackage(ParametersPackage.eNS_URI);
		IdentifierPackage theIdentifierPackage = (IdentifierPackage)EPackage.Registry.INSTANCE.getEPackage(IdentifierPackage.eNS_URI);

		// Add subpackages
		getESubpackages().add(theQualityAnnotationPackage);
		getESubpackages().add(theParametersPackage);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		qualityRepositoryEClass.getESuperTypes().add(theIdentifierPackage.getIdentifier());
		qualityStatementEClass.getESuperTypes().add(theIdentifierPackage.getIdentifier());

		// Initialize classes and features; add operations and parameters
		initEClass(qualityRepositoryEClass, QualityRepository.class, "QualityRepository", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getQualityRepository_QualityStatements(), this.getQualityStatement(), this.getQualityStatement_QualityRepository(), "qualityStatements", null, 0, -1, QualityRepository.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(qualityStatementEClass, QualityStatement.class, "QualityStatement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getQualityStatement_QualityRepository(), this.getQualityRepository(), this.getQualityRepository_QualityStatements(), "qualityRepository", null, 1, 1, QualityStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //QualityPackageImpl
