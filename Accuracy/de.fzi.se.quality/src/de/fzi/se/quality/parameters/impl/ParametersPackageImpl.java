/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.fzi.se.quality.parameters.impl;

import de.fzi.se.quality.QualityPackage;

import de.fzi.se.quality.impl.QualityPackageImpl;

import de.fzi.se.quality.parameters.BusinessOperationReference;
import de.fzi.se.quality.parameters.CallInstance;
import de.fzi.se.quality.parameters.ComponentInstance;
import de.fzi.se.quality.parameters.ComponentReference;
import de.fzi.se.quality.parameters.InfrastructureOperationReference;
import de.fzi.se.quality.parameters.OperationReference;
import de.fzi.se.quality.parameters.ParameterInstance;
import de.fzi.se.quality.parameters.ParameterPartition;
import de.fzi.se.quality.parameters.ParameterReference;
import de.fzi.se.quality.parameters.ParameterValue;
import de.fzi.se.quality.parameters.ParametersFactory;
import de.fzi.se.quality.parameters.ParametersPackage;

import de.fzi.se.quality.parameters.pcm.PCMPackage;

import de.fzi.se.quality.parameters.pcm.impl.PCMPackageImpl;

import de.fzi.se.quality.qualityannotation.QualityAnnotationPackage;

import de.fzi.se.quality.qualityannotation.impl.QualityAnnotationPackageImpl;

import de.uka.ipd.sdq.identifier.IdentifierPackage;

import de.uka.ipd.sdq.pcm.PcmPackage;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.uml2.types.TypesPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ParametersPackageImpl extends EPackageImpl implements ParametersPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass parameterPartitionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass parameterValueEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass parameterInstanceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass callInstanceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass operationReferenceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass componentInstanceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass componentReferenceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass infrastructureOperationReferenceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass businessOperationReferenceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass parameterReferenceEClass = null;

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
	 * @see de.fzi.se.quality.parameters.ParametersPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private ParametersPackageImpl() {
		super(eNS_URI, ParametersFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link ParametersPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static ParametersPackage init() {
		if (isInited) return (ParametersPackage)EPackage.Registry.INSTANCE.getEPackage(ParametersPackage.eNS_URI);

		// Obtain or create and register package
		ParametersPackageImpl theParametersPackage = (ParametersPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof ParametersPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new ParametersPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		PcmPackage.eINSTANCE.eClass();
		TypesPackage.eINSTANCE.eClass();

		// Obtain or create and register interdependencies
		QualityPackageImpl theQualityPackage = (QualityPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(QualityPackage.eNS_URI) instanceof QualityPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(QualityPackage.eNS_URI) : QualityPackage.eINSTANCE);
		QualityAnnotationPackageImpl theQualityAnnotationPackage = (QualityAnnotationPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(QualityAnnotationPackage.eNS_URI) instanceof QualityAnnotationPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(QualityAnnotationPackage.eNS_URI) : QualityAnnotationPackage.eINSTANCE);
		PCMPackageImpl thePCMPackage = (PCMPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(PCMPackage.eNS_URI) instanceof PCMPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(PCMPackage.eNS_URI) : PCMPackage.eINSTANCE);

		// Create package meta-data objects
		theParametersPackage.createPackageContents();
		theQualityPackage.createPackageContents();
		theQualityAnnotationPackage.createPackageContents();
		thePCMPackage.createPackageContents();

		// Initialize created meta-data
		theParametersPackage.initializePackageContents();
		theQualityPackage.initializePackageContents();
		theQualityAnnotationPackage.initializePackageContents();
		thePCMPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theParametersPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(ParametersPackage.eNS_URI, theParametersPackage);
		return theParametersPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getParameterPartition() {
		return parameterPartitionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getParameterPartition_QualityAnnotation() {
		return (EReference)parameterPartitionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getParameterValue() {
		return parameterValueEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getParameterValue_ParameterInstance() {
		return (EReference)parameterValueEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getParameterInstance() {
		return parameterInstanceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getParameterInstance_ParameterReference() {
		return (EReference)parameterInstanceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getParameterInstance_InputCallInstance() {
		return (EReference)parameterInstanceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getParameterInstance_OutputCallInstance() {
		return (EReference)parameterInstanceEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getParameterInstance_ComponentInstance() {
		return (EReference)parameterInstanceEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getParameterInstance_ParameterValue() {
		return (EReference)parameterInstanceEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCallInstance() {
		return callInstanceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCallInstance_OperationReference() {
		return (EReference)callInstanceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCallInstance_OutputParameterInstances() {
		return (EReference)callInstanceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCallInstance_NumberOfCalls() {
		return (EAttribute)callInstanceEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCallInstance_InputParameterInstances() {
		return (EReference)callInstanceEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOperationReference() {
		return operationReferenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOperationReference_CallInstance() {
		return (EReference)operationReferenceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getComponentInstance() {
		return componentInstanceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getComponentInstance_ComponentReference() {
		return (EReference)componentInstanceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getComponentInstance_ParameterInstances() {
		return (EReference)componentInstanceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getComponentReference() {
		return componentReferenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getComponentReference_ComponentInstance() {
		return (EReference)componentReferenceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInfrastructureOperationReference() {
		return infrastructureOperationReferenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBusinessOperationReference() {
		return businessOperationReferenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getParameterReference() {
		return parameterReferenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getParameterReference_ParameterInstance() {
		return (EReference)parameterReferenceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getParameterReference_CallParameterDeviation() {
		return (EReference)parameterReferenceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ParametersFactory getParametersFactory() {
		return (ParametersFactory)getEFactoryInstance();
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
		parameterPartitionEClass = createEClass(PARAMETER_PARTITION);
		createEReference(parameterPartitionEClass, PARAMETER_PARTITION__QUALITY_ANNOTATION);

		parameterValueEClass = createEClass(PARAMETER_VALUE);
		createEReference(parameterValueEClass, PARAMETER_VALUE__PARAMETER_INSTANCE);

		parameterInstanceEClass = createEClass(PARAMETER_INSTANCE);
		createEReference(parameterInstanceEClass, PARAMETER_INSTANCE__PARAMETER_REFERENCE);
		createEReference(parameterInstanceEClass, PARAMETER_INSTANCE__INPUT_CALL_INSTANCE);
		createEReference(parameterInstanceEClass, PARAMETER_INSTANCE__OUTPUT_CALL_INSTANCE);
		createEReference(parameterInstanceEClass, PARAMETER_INSTANCE__COMPONENT_INSTANCE);
		createEReference(parameterInstanceEClass, PARAMETER_INSTANCE__PARAMETER_VALUE);

		callInstanceEClass = createEClass(CALL_INSTANCE);
		createEReference(callInstanceEClass, CALL_INSTANCE__OPERATION_REFERENCE);
		createEReference(callInstanceEClass, CALL_INSTANCE__OUTPUT_PARAMETER_INSTANCES);
		createEAttribute(callInstanceEClass, CALL_INSTANCE__NUMBER_OF_CALLS);
		createEReference(callInstanceEClass, CALL_INSTANCE__INPUT_PARAMETER_INSTANCES);

		operationReferenceEClass = createEClass(OPERATION_REFERENCE);
		createEReference(operationReferenceEClass, OPERATION_REFERENCE__CALL_INSTANCE);

		componentInstanceEClass = createEClass(COMPONENT_INSTANCE);
		createEReference(componentInstanceEClass, COMPONENT_INSTANCE__COMPONENT_REFERENCE);
		createEReference(componentInstanceEClass, COMPONENT_INSTANCE__PARAMETER_INSTANCES);

		componentReferenceEClass = createEClass(COMPONENT_REFERENCE);
		createEReference(componentReferenceEClass, COMPONENT_REFERENCE__COMPONENT_INSTANCE);

		infrastructureOperationReferenceEClass = createEClass(INFRASTRUCTURE_OPERATION_REFERENCE);

		businessOperationReferenceEClass = createEClass(BUSINESS_OPERATION_REFERENCE);

		parameterReferenceEClass = createEClass(PARAMETER_REFERENCE);
		createEReference(parameterReferenceEClass, PARAMETER_REFERENCE__PARAMETER_INSTANCE);
		createEReference(parameterReferenceEClass, PARAMETER_REFERENCE__CALL_PARAMETER_DEVIATION);
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
		PCMPackage thePCMPackage = (PCMPackage)EPackage.Registry.INSTANCE.getEPackage(PCMPackage.eNS_URI);
		IdentifierPackage theIdentifierPackage = (IdentifierPackage)EPackage.Registry.INSTANCE.getEPackage(IdentifierPackage.eNS_URI);
		QualityAnnotationPackage theQualityAnnotationPackage = (QualityAnnotationPackage)EPackage.Registry.INSTANCE.getEPackage(QualityAnnotationPackage.eNS_URI);

		// Add subpackages
		getESubpackages().add(thePCMPackage);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		parameterPartitionEClass.getESuperTypes().add(theIdentifierPackage.getIdentifier());
		parameterValueEClass.getESuperTypes().add(theIdentifierPackage.getIdentifier());
		parameterInstanceEClass.getESuperTypes().add(theIdentifierPackage.getIdentifier());
		callInstanceEClass.getESuperTypes().add(theIdentifierPackage.getIdentifier());
		operationReferenceEClass.getESuperTypes().add(theIdentifierPackage.getIdentifier());
		componentInstanceEClass.getESuperTypes().add(theIdentifierPackage.getIdentifier());
		componentReferenceEClass.getESuperTypes().add(theIdentifierPackage.getIdentifier());
		infrastructureOperationReferenceEClass.getESuperTypes().add(this.getOperationReference());
		businessOperationReferenceEClass.getESuperTypes().add(this.getOperationReference());
		parameterReferenceEClass.getESuperTypes().add(theIdentifierPackage.getIdentifier());

		// Initialize classes and features; add operations and parameters
		initEClass(parameterPartitionEClass, ParameterPartition.class, "ParameterPartition", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getParameterPartition_QualityAnnotation(), theQualityAnnotationPackage.getQualityAnnotation(), theQualityAnnotationPackage.getQualityAnnotation_ValidForParameterPartitions(), "qualityAnnotation", null, 1, 1, ParameterPartition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(parameterValueEClass, ParameterValue.class, "ParameterValue", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getParameterValue_ParameterInstance(), this.getParameterInstance(), this.getParameterInstance_ParameterValue(), "parameterInstance", null, 0, 1, ParameterValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(parameterInstanceEClass, ParameterInstance.class, "ParameterInstance", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getParameterInstance_ParameterReference(), this.getParameterReference(), this.getParameterReference_ParameterInstance(), "parameterReference", null, 0, 1, ParameterInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getParameterInstance_InputCallInstance(), this.getCallInstance(), this.getCallInstance_InputParameterInstances(), "inputCallInstance", null, 0, 1, ParameterInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getParameterInstance_OutputCallInstance(), this.getCallInstance(), this.getCallInstance_OutputParameterInstances(), "outputCallInstance", null, 0, 1, ParameterInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getParameterInstance_ComponentInstance(), this.getComponentInstance(), this.getComponentInstance_ParameterInstances(), "componentInstance", null, 0, 1, ParameterInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getParameterInstance_ParameterValue(), this.getParameterValue(), this.getParameterValue_ParameterInstance(), "parameterValue", null, 1, 1, ParameterInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(callInstanceEClass, CallInstance.class, "CallInstance", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCallInstance_OperationReference(), this.getOperationReference(), this.getOperationReference_CallInstance(), "operationReference", null, 1, 1, CallInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getCallInstance_OutputParameterInstances(), this.getParameterInstance(), this.getParameterInstance_OutputCallInstance(), "outputParameterInstances", null, 0, -1, CallInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getCallInstance_NumberOfCalls(), ecorePackage.getELong(), "numberOfCalls", "1", 1, 1, CallInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getCallInstance_InputParameterInstances(), this.getParameterInstance(), this.getParameterInstance_InputCallInstance(), "inputParameterInstances", null, 0, -1, CallInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(operationReferenceEClass, OperationReference.class, "OperationReference", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getOperationReference_CallInstance(), this.getCallInstance(), this.getCallInstance_OperationReference(), "callInstance", null, 0, 1, OperationReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(componentInstanceEClass, ComponentInstance.class, "ComponentInstance", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getComponentInstance_ComponentReference(), this.getComponentReference(), this.getComponentReference_ComponentInstance(), "componentReference", null, 0, -1, ComponentInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getComponentInstance_ParameterInstances(), this.getParameterInstance(), this.getParameterInstance_ComponentInstance(), "parameterInstances", null, 0, -1, ComponentInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(componentReferenceEClass, ComponentReference.class, "ComponentReference", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getComponentReference_ComponentInstance(), this.getComponentInstance(), this.getComponentInstance_ComponentReference(), "componentInstance", null, 0, 1, ComponentReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(infrastructureOperationReferenceEClass, InfrastructureOperationReference.class, "InfrastructureOperationReference", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(businessOperationReferenceEClass, BusinessOperationReference.class, "BusinessOperationReference", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(parameterReferenceEClass, ParameterReference.class, "ParameterReference", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getParameterReference_ParameterInstance(), this.getParameterInstance(), this.getParameterInstance_ParameterReference(), "parameterInstance", null, 0, 1, ParameterReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getParameterReference_CallParameterDeviation(), theQualityAnnotationPackage.getCallParameterDeviation(), theQualityAnnotationPackage.getCallParameterDeviation_ParameterReference(), "callParameterDeviation", null, 0, 1, ParameterReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
	}

} //ParametersPackageImpl
