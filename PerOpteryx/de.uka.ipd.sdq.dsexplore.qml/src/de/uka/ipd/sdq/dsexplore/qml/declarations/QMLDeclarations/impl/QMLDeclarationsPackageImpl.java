/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.dsexplore.qml.declarations.QMLDeclarations.impl;

import de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.QMLContractPackage;

import de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.impl.QMLContractPackageImpl;

import de.uka.ipd.sdq.dsexplore.qml.contracttype.QMLContractType.QMLContractTypePackage;

import de.uka.ipd.sdq.dsexplore.qml.contracttype.QMLContractType.impl.QMLContractTypePackageImpl;

import de.uka.ipd.sdq.dsexplore.qml.declarations.QMLDeclarations.QMLDeclaration;
import de.uka.ipd.sdq.dsexplore.qml.declarations.QMLDeclarations.QMLDeclarations;
import de.uka.ipd.sdq.dsexplore.qml.declarations.QMLDeclarations.QMLDeclarationsFactory;
import de.uka.ipd.sdq.dsexplore.qml.declarations.QMLDeclarations.QMLDeclarationsPackage;

import de.uka.ipd.sdq.dsexplore.qml.profile.QMLProfile.QMLProfilePackage;

import de.uka.ipd.sdq.dsexplore.qml.profile.QMLProfile.impl.QMLProfilePackageImpl;

import de.uka.ipd.sdq.identifier.IdentifierPackage;

import de.uka.ipd.sdq.pcm.allocation.AllocationPackage;

import de.uka.ipd.sdq.pcm.core.CorePackage;

import de.uka.ipd.sdq.pcm.core.entity.EntityPackage;

import de.uka.ipd.sdq.pcm.parameter.ParameterPackage;

import de.uka.ipd.sdq.pcm.protocol.ProtocolPackage;

import de.uka.ipd.sdq.pcm.qosannotations.QosannotationsPackage;

import de.uka.ipd.sdq.pcm.repository.RepositoryPackage;

import de.uka.ipd.sdq.pcm.resourceenvironment.ResourceenvironmentPackage;

import de.uka.ipd.sdq.pcm.resourcetype.ResourcetypePackage;

import de.uka.ipd.sdq.pcm.seff.SeffPackage;

import de.uka.ipd.sdq.pcm.subsystem.SubsystemPackage;

import de.uka.ipd.sdq.pcm.system.SystemPackage;

import de.uka.ipd.sdq.pcm.usagemodel.UsagemodelPackage;

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
public class QMLDeclarationsPackageImpl extends EPackageImpl implements QMLDeclarationsPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass qmlDeclarationsEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass qmlDeclarationEClass = null;

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
	 * @see de.uka.ipd.sdq.dsexplore.qml.declarations.QMLDeclarations.QMLDeclarationsPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private QMLDeclarationsPackageImpl() {
		super(eNS_URI, QMLDeclarationsFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link QMLDeclarationsPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static QMLDeclarationsPackage init() {
		if (isInited) return (QMLDeclarationsPackage)EPackage.Registry.INSTANCE.getEPackage(QMLDeclarationsPackage.eNS_URI);

		// Obtain or create and register package
		QMLDeclarationsPackageImpl theQMLDeclarationsPackage = (QMLDeclarationsPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof QMLDeclarationsPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new QMLDeclarationsPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		CorePackage.eINSTANCE.eClass();
		UsagemodelPackage.eINSTANCE.eClass();
		RepositoryPackage.eINSTANCE.eClass();
		ProtocolPackage.eINSTANCE.eClass();
		ParameterPackage.eINSTANCE.eClass();
		SeffPackage.eINSTANCE.eClass();
		ResourcetypePackage.eINSTANCE.eClass();
		QosannotationsPackage.eINSTANCE.eClass();
		SystemPackage.eINSTANCE.eClass();
		ResourceenvironmentPackage.eINSTANCE.eClass();
		AllocationPackage.eINSTANCE.eClass();
		SubsystemPackage.eINSTANCE.eClass();

		// Obtain or create and register interdependencies
		QMLProfilePackageImpl theQMLProfilePackage = (QMLProfilePackageImpl)(EPackage.Registry.INSTANCE.getEPackage(QMLProfilePackage.eNS_URI) instanceof QMLProfilePackageImpl ? EPackage.Registry.INSTANCE.getEPackage(QMLProfilePackage.eNS_URI) : QMLProfilePackage.eINSTANCE);
		QMLContractPackageImpl theQMLContractPackage = (QMLContractPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(QMLContractPackage.eNS_URI) instanceof QMLContractPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(QMLContractPackage.eNS_URI) : QMLContractPackage.eINSTANCE);
		QMLContractTypePackageImpl theQMLContractTypePackage = (QMLContractTypePackageImpl)(EPackage.Registry.INSTANCE.getEPackage(QMLContractTypePackage.eNS_URI) instanceof QMLContractTypePackageImpl ? EPackage.Registry.INSTANCE.getEPackage(QMLContractTypePackage.eNS_URI) : QMLContractTypePackage.eINSTANCE);

		// Create package meta-data objects
		theQMLDeclarationsPackage.createPackageContents();
		theQMLProfilePackage.createPackageContents();
		theQMLContractPackage.createPackageContents();
		theQMLContractTypePackage.createPackageContents();

		// Initialize created meta-data
		theQMLDeclarationsPackage.initializePackageContents();
		theQMLProfilePackage.initializePackageContents();
		theQMLContractPackage.initializePackageContents();
		theQMLContractTypePackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theQMLDeclarationsPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(QMLDeclarationsPackage.eNS_URI, theQMLDeclarationsPackage);
		return theQMLDeclarationsPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getQMLDeclarations() {
		return qmlDeclarationsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getQMLDeclarations_QmlDeclarations() {
		return (EReference)qmlDeclarationsEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getQMLDeclaration() {
		return qmlDeclarationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public QMLDeclarationsFactory getQMLDeclarationsFactory() {
		return (QMLDeclarationsFactory)getEFactoryInstance();
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
		qmlDeclarationsEClass = createEClass(QML_DECLARATIONS);
		createEReference(qmlDeclarationsEClass, QML_DECLARATIONS__QML_DECLARATIONS);

		qmlDeclarationEClass = createEClass(QML_DECLARATION);
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
		IdentifierPackage theIdentifierPackage = (IdentifierPackage)EPackage.Registry.INSTANCE.getEPackage(IdentifierPackage.eNS_URI);
		EntityPackage theEntityPackage = (EntityPackage)EPackage.Registry.INSTANCE.getEPackage(EntityPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		qmlDeclarationsEClass.getESuperTypes().add(theIdentifierPackage.getIdentifier());
		qmlDeclarationEClass.getESuperTypes().add(theEntityPackage.getEntity());

		// Initialize classes and features; add operations and parameters
		initEClass(qmlDeclarationsEClass, QMLDeclarations.class, "QMLDeclarations", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getQMLDeclarations_QmlDeclarations(), this.getQMLDeclaration(), null, "qmlDeclarations", null, 0, -1, QMLDeclarations.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(qmlDeclarationEClass, QMLDeclaration.class, "QMLDeclaration", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);
	}

} //QMLDeclarationsPackageImpl
