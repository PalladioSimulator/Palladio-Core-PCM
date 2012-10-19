/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.fzi.se.quality.parameters.pcm.impl;

import de.fzi.se.quality.QualityPackage;

import de.fzi.se.quality.impl.QualityPackageImpl;

import de.fzi.se.quality.parameters.ParametersPackage;

import de.fzi.se.quality.parameters.impl.ParametersPackageImpl;

import de.fzi.se.quality.parameters.pcm.PCMBusinessOperationReference;
import de.fzi.se.quality.parameters.pcm.PCMComponentParameterReference;
import de.fzi.se.quality.parameters.pcm.PCMComponentReference;
import de.fzi.se.quality.parameters.pcm.PCMFactory;
import de.fzi.se.quality.parameters.pcm.PCMInfrastructureOperationReference;
import de.fzi.se.quality.parameters.pcm.PCMOperationParameterReference;
import de.fzi.se.quality.parameters.pcm.PCMPackage;
import de.fzi.se.quality.parameters.pcm.PCMParameterReference;
import de.fzi.se.quality.parameters.pcm.PCMParameterValue;
import de.fzi.se.quality.parameters.pcm.PCMRequiredBusinessOperationReturnParameterReference;

import de.fzi.se.quality.qualityannotation.QualityAnnotationPackage;

import de.fzi.se.quality.qualityannotation.impl.QualityAnnotationPackageImpl;

import de.uka.ipd.sdq.identifier.IdentifierPackage;

import de.uka.ipd.sdq.pcm.PcmPackage;

import de.uka.ipd.sdq.pcm.core.entity.EntityPackage;

import de.uka.ipd.sdq.pcm.parameter.ParameterPackage;

import de.uka.ipd.sdq.pcm.repository.RepositoryPackage;

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
public class PCMPackageImpl extends EPackageImpl implements PCMPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass pcmParameterReferenceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass pcmParameterValueEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass pcmInfrastructureOperationReferenceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass pcmBusinessOperationReferenceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass pcmComponentReferenceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass pcmComponentParameterReferenceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass pcmOperationParameterReferenceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass pcmRequiredBusinessOperationReturnParameterReferenceEClass = null;

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
	 * @see de.fzi.se.quality.parameters.pcm.PCMPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private PCMPackageImpl() {
		super(eNS_URI, PCMFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link PCMPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static PCMPackage init() {
		if (isInited) return (PCMPackage)EPackage.Registry.INSTANCE.getEPackage(PCMPackage.eNS_URI);

		// Obtain or create and register package
		PCMPackageImpl thePCMPackage = (PCMPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof PCMPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new PCMPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		PcmPackage.eINSTANCE.eClass();

		// Obtain or create and register interdependencies
		QualityPackageImpl theQualityPackage = (QualityPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(QualityPackage.eNS_URI) instanceof QualityPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(QualityPackage.eNS_URI) : QualityPackage.eINSTANCE);
		QualityAnnotationPackageImpl theQualityAnnotationPackage = (QualityAnnotationPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(QualityAnnotationPackage.eNS_URI) instanceof QualityAnnotationPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(QualityAnnotationPackage.eNS_URI) : QualityAnnotationPackage.eINSTANCE);
		ParametersPackageImpl theParametersPackage = (ParametersPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ParametersPackage.eNS_URI) instanceof ParametersPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ParametersPackage.eNS_URI) : ParametersPackage.eINSTANCE);
		TypesPackageImpl theTypesPackage = (TypesPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(TypesPackage.eNS_URI) instanceof TypesPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(TypesPackage.eNS_URI) : TypesPackage.eINSTANCE);
		ProbfunctionPackageImpl theProbfunctionPackage = (ProbfunctionPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ProbfunctionPackage.eNS_URI) instanceof ProbfunctionPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ProbfunctionPackage.eNS_URI) : ProbfunctionPackage.eINSTANCE);

		// Create package meta-data objects
		thePCMPackage.createPackageContents();
		theQualityPackage.createPackageContents();
		theQualityAnnotationPackage.createPackageContents();
		theParametersPackage.createPackageContents();
		theTypesPackage.createPackageContents();
		theProbfunctionPackage.createPackageContents();

		// Initialize created meta-data
		thePCMPackage.initializePackageContents();
		theQualityPackage.initializePackageContents();
		theQualityAnnotationPackage.initializePackageContents();
		theParametersPackage.initializePackageContents();
		theTypesPackage.initializePackageContents();
		theProbfunctionPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		thePCMPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(PCMPackage.eNS_URI, thePCMPackage);
		return thePCMPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPCMParameterReference() {
		return pcmParameterReferenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPCMParameterReference_ParameterPartition() {
		return (EReference)pcmParameterReferenceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPCMParameterValue() {
		return pcmParameterValueEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPCMParameterValue_VariableCharacterisation() {
		return (EReference)pcmParameterValueEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPCMInfrastructureOperationReference() {
		return pcmInfrastructureOperationReferenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPCMInfrastructureOperationReference_ResourceRequiredRole() {
		return (EReference)pcmInfrastructureOperationReferenceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPCMInfrastructureOperationReference_Signature() {
		return (EReference)pcmInfrastructureOperationReferenceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPCMBusinessOperationReference() {
		return pcmBusinessOperationReferenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPCMBusinessOperationReference_RequiredRole() {
		return (EReference)pcmBusinessOperationReferenceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPCMBusinessOperationReference_Signature() {
		return (EReference)pcmBusinessOperationReferenceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPCMComponentReference() {
		return pcmComponentReferenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPCMComponentReference_BasicComponent() {
		return (EReference)pcmComponentReferenceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPCMComponentParameterReference() {
		return pcmComponentParameterReferenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPCMComponentParameterReference_ImplementationComponentType() {
		return (EReference)pcmComponentParameterReferenceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPCMComponentParameterReference_VariableUsage() {
		return (EReference)pcmComponentParameterReferenceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPCMOperationParameterReference() {
		return pcmOperationParameterReferenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPCMOperationParameterReference_Parameter() {
		return (EReference)pcmOperationParameterReferenceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPCMRequiredBusinessOperationReturnParameterReference() {
		return pcmRequiredBusinessOperationReturnParameterReferenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPCMRequiredBusinessOperationReturnParameterReference_RequiredRole() {
		return (EReference)pcmRequiredBusinessOperationReturnParameterReferenceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPCMRequiredBusinessOperationReturnParameterReference_Signature() {
		return (EReference)pcmRequiredBusinessOperationReturnParameterReferenceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PCMFactory getPCMFactory() {
		return (PCMFactory)getEFactoryInstance();
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
		pcmParameterReferenceEClass = createEClass(PCM_PARAMETER_REFERENCE);
		createEReference(pcmParameterReferenceEClass, PCM_PARAMETER_REFERENCE__PARAMETER_PARTITION);

		pcmParameterValueEClass = createEClass(PCM_PARAMETER_VALUE);
		createEReference(pcmParameterValueEClass, PCM_PARAMETER_VALUE__VARIABLE_CHARACTERISATION);

		pcmInfrastructureOperationReferenceEClass = createEClass(PCM_INFRASTRUCTURE_OPERATION_REFERENCE);
		createEReference(pcmInfrastructureOperationReferenceEClass, PCM_INFRASTRUCTURE_OPERATION_REFERENCE__RESOURCE_REQUIRED_ROLE);
		createEReference(pcmInfrastructureOperationReferenceEClass, PCM_INFRASTRUCTURE_OPERATION_REFERENCE__SIGNATURE);

		pcmBusinessOperationReferenceEClass = createEClass(PCM_BUSINESS_OPERATION_REFERENCE);
		createEReference(pcmBusinessOperationReferenceEClass, PCM_BUSINESS_OPERATION_REFERENCE__REQUIRED_ROLE);
		createEReference(pcmBusinessOperationReferenceEClass, PCM_BUSINESS_OPERATION_REFERENCE__SIGNATURE);

		pcmComponentReferenceEClass = createEClass(PCM_COMPONENT_REFERENCE);
		createEReference(pcmComponentReferenceEClass, PCM_COMPONENT_REFERENCE__BASIC_COMPONENT);

		pcmComponentParameterReferenceEClass = createEClass(PCM_COMPONENT_PARAMETER_REFERENCE);
		createEReference(pcmComponentParameterReferenceEClass, PCM_COMPONENT_PARAMETER_REFERENCE__IMPLEMENTATION_COMPONENT_TYPE);
		createEReference(pcmComponentParameterReferenceEClass, PCM_COMPONENT_PARAMETER_REFERENCE__VARIABLE_USAGE);

		pcmOperationParameterReferenceEClass = createEClass(PCM_OPERATION_PARAMETER_REFERENCE);
		createEReference(pcmOperationParameterReferenceEClass, PCM_OPERATION_PARAMETER_REFERENCE__PARAMETER);

		pcmRequiredBusinessOperationReturnParameterReferenceEClass = createEClass(PCM_REQUIRED_BUSINESS_OPERATION_RETURN_PARAMETER_REFERENCE);
		createEReference(pcmRequiredBusinessOperationReturnParameterReferenceEClass, PCM_REQUIRED_BUSINESS_OPERATION_RETURN_PARAMETER_REFERENCE__REQUIRED_ROLE);
		createEReference(pcmRequiredBusinessOperationReturnParameterReferenceEClass, PCM_REQUIRED_BUSINESS_OPERATION_RETURN_PARAMETER_REFERENCE__SIGNATURE);
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
		ParametersPackage theParametersPackage = (ParametersPackage)EPackage.Registry.INSTANCE.getEPackage(ParametersPackage.eNS_URI);
		IdentifierPackage theIdentifierPackage = (IdentifierPackage)EPackage.Registry.INSTANCE.getEPackage(IdentifierPackage.eNS_URI);
		QualityAnnotationPackage theQualityAnnotationPackage = (QualityAnnotationPackage)EPackage.Registry.INSTANCE.getEPackage(QualityAnnotationPackage.eNS_URI);
		ParameterPackage theParameterPackage = (ParameterPackage)EPackage.Registry.INSTANCE.getEPackage(ParameterPackage.eNS_URI);
		EntityPackage theEntityPackage = (EntityPackage)EPackage.Registry.INSTANCE.getEPackage(EntityPackage.eNS_URI);
		RepositoryPackage theRepositoryPackage = (RepositoryPackage)EPackage.Registry.INSTANCE.getEPackage(RepositoryPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		pcmParameterReferenceEClass.getESuperTypes().add(theParametersPackage.getParameterReference());
		pcmParameterReferenceEClass.getESuperTypes().add(theIdentifierPackage.getIdentifier());
		pcmParameterValueEClass.getESuperTypes().add(theParametersPackage.getParameterValue());
		pcmInfrastructureOperationReferenceEClass.getESuperTypes().add(theParametersPackage.getInfrastructureOperationReference());
		pcmBusinessOperationReferenceEClass.getESuperTypes().add(theParametersPackage.getBusinessOperationReference());
		pcmComponentReferenceEClass.getESuperTypes().add(theParametersPackage.getComponentReference());
		pcmComponentParameterReferenceEClass.getESuperTypes().add(this.getPCMParameterReference());
		pcmOperationParameterReferenceEClass.getESuperTypes().add(this.getPCMParameterReference());
		pcmRequiredBusinessOperationReturnParameterReferenceEClass.getESuperTypes().add(this.getPCMParameterReference());

		// Initialize classes and features; add operations and parameters
		initEClass(pcmParameterReferenceEClass, PCMParameterReference.class, "PCMParameterReference", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPCMParameterReference_ParameterPartition(), theQualityAnnotationPackage.getPCMParameterPartition(), theQualityAnnotationPackage.getPCMParameterPartition_ParameterReference(), "parameterPartition", null, 0, 1, PCMParameterReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(pcmParameterValueEClass, PCMParameterValue.class, "PCMParameterValue", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPCMParameterValue_VariableCharacterisation(), theParameterPackage.getVariableCharacterisation(), null, "variableCharacterisation", null, 0, -1, PCMParameterValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(pcmInfrastructureOperationReferenceEClass, PCMInfrastructureOperationReference.class, "PCMInfrastructureOperationReference", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPCMInfrastructureOperationReference_ResourceRequiredRole(), theEntityPackage.getResourceRequiredRole(), null, "resourceRequiredRole", null, 1, 1, PCMInfrastructureOperationReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getPCMInfrastructureOperationReference_Signature(), theRepositoryPackage.getSignature(), null, "signature", null, 1, 1, PCMInfrastructureOperationReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(pcmBusinessOperationReferenceEClass, PCMBusinessOperationReference.class, "PCMBusinessOperationReference", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPCMBusinessOperationReference_RequiredRole(), theRepositoryPackage.getRequiredRole(), null, "requiredRole", null, 1, 1, PCMBusinessOperationReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getPCMBusinessOperationReference_Signature(), theRepositoryPackage.getSignature(), null, "signature", null, 1, 1, PCMBusinessOperationReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(pcmComponentReferenceEClass, PCMComponentReference.class, "PCMComponentReference", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPCMComponentReference_BasicComponent(), theRepositoryPackage.getBasicComponent(), null, "basicComponent", null, 1, 1, PCMComponentReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(pcmComponentParameterReferenceEClass, PCMComponentParameterReference.class, "PCMComponentParameterReference", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPCMComponentParameterReference_ImplementationComponentType(), theRepositoryPackage.getImplementationComponentType(), null, "implementationComponentType", null, 1, 1, PCMComponentParameterReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getPCMComponentParameterReference_VariableUsage(), theParameterPackage.getVariableUsage(), null, "variableUsage", null, 1, 1, PCMComponentParameterReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(pcmOperationParameterReferenceEClass, PCMOperationParameterReference.class, "PCMOperationParameterReference", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPCMOperationParameterReference_Parameter(), theRepositoryPackage.getParameter(), null, "parameter", null, 1, 1, PCMOperationParameterReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(pcmRequiredBusinessOperationReturnParameterReferenceEClass, PCMRequiredBusinessOperationReturnParameterReference.class, "PCMRequiredBusinessOperationReturnParameterReference", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPCMRequiredBusinessOperationReturnParameterReference_RequiredRole(), theRepositoryPackage.getRequiredRole(), null, "requiredRole", null, 1, 1, PCMRequiredBusinessOperationReturnParameterReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getPCMRequiredBusinessOperationReturnParameterReference_Signature(), theRepositoryPackage.getSignature(), null, "signature", null, 1, 1, PCMRequiredBusinessOperationReturnParameterReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
	}

} //PCMPackageImpl
