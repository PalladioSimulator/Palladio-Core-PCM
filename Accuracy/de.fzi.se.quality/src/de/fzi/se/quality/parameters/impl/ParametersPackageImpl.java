/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.fzi.se.quality.parameters.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;

import de.fzi.se.quality.QualityPackage;
import de.fzi.se.quality.impl.QualityPackageImpl;
import de.fzi.se.quality.parameters.CallInstance;
import de.fzi.se.quality.parameters.ComponentInstance;
import de.fzi.se.quality.parameters.ComponentReference;
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

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Package</b>. <!-- end-user-doc -->
 * 
 * @generated
 */
public class ParametersPackageImpl extends EPackageImpl implements ParametersPackage {

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass parameterPartitionEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass parameterValueEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass parameterInstanceEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass callInstanceEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass operationReferenceEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass componentInstanceEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass componentReferenceEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass parameterReferenceEClass = null;

    /**
     * Creates an instance of the model <b>Package</b>, registered with
     * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package package URI
     * value.
     * <p>
     * Note: the correct way to create the package is via the static factory method {@link #init
     * init()}, which also performs initialization of the package, or returns the registered
     * package, if one already exists. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see org.eclipse.emf.ecore.EPackage.Registry
     * @see de.fzi.se.quality.parameters.ParametersPackage#eNS_URI
     * @see #init()
     * @generated
     */
    private ParametersPackageImpl() {
        super(eNS_URI, ParametersFactory.eINSTANCE);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private static boolean isInited = false;

    /**
     * Creates, registers, and initializes the <b>Package</b> for this model, and for any others
     * upon which it depends.
     *
     * <p>
     * This method is used to initialize {@link ParametersPackage#eINSTANCE} when that field is
     * accessed. Clients should not invoke it directly. Instead, they should simply access that
     * field to obtain the package. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #eNS_URI
     * @see #createPackageContents()
     * @see #initializePackageContents()
     * @generated
     */
    public static ParametersPackage init() {
        if (isInited) {
            return (ParametersPackage) EPackage.Registry.INSTANCE.getEPackage(ParametersPackage.eNS_URI);
        }

        // Obtain or create and register package
        final ParametersPackageImpl theParametersPackage = (ParametersPackageImpl) (EPackage.Registry.INSTANCE
                .get(eNS_URI) instanceof ParametersPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI)
                : new ParametersPackageImpl());

        isInited = true;

        // Initialize simple dependencies
        PcmPackage.eINSTANCE.eClass();

        // Obtain or create and register interdependencies
        final QualityPackageImpl theQualityPackage = (QualityPackageImpl) (EPackage.Registry.INSTANCE
                .getEPackage(QualityPackage.eNS_URI) instanceof QualityPackageImpl ? EPackage.Registry.INSTANCE
                        .getEPackage(QualityPackage.eNS_URI) : QualityPackage.eINSTANCE);
        final QualityAnnotationPackageImpl theQualityAnnotationPackage = (QualityAnnotationPackageImpl) (EPackage.Registry.INSTANCE
                .getEPackage(QualityAnnotationPackage.eNS_URI) instanceof QualityAnnotationPackageImpl ? EPackage.Registry.INSTANCE
                        .getEPackage(QualityAnnotationPackage.eNS_URI) : QualityAnnotationPackage.eINSTANCE);
        final PCMPackageImpl thePCMPackage = (PCMPackageImpl) (EPackage.Registry.INSTANCE
                .getEPackage(PCMPackage.eNS_URI) instanceof PCMPackageImpl ? EPackage.Registry.INSTANCE
                .getEPackage(PCMPackage.eNS_URI) : PCMPackage.eINSTANCE);

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
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getParameterPartition() {
        return this.parameterPartitionEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getParameterPartition_QualityAnnotation() {
        return (EReference) this.parameterPartitionEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getParameterPartition_ParameterReference() {
        return (EReference) this.parameterPartitionEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getParameterValue() {
        return this.parameterValueEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getParameterValue_ParameterInstance() {
        return (EReference) this.parameterValueEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getParameterValue_ParameterValueDeviation() {
        return (EReference) this.parameterValueEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getParameterInstance() {
        return this.parameterInstanceEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getParameterInstance_ParameterReference() {
        return (EReference) this.parameterInstanceEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getParameterInstance_InputCallInstance() {
        return (EReference) this.parameterInstanceEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getParameterInstance_OutputCallInstance() {
        return (EReference) this.parameterInstanceEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getParameterInstance_ComponentInstance() {
        return (EReference) this.parameterInstanceEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getParameterInstance_ParameterValue() {
        return (EReference) this.parameterInstanceEClass.getEStructuralFeatures().get(4);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getCallInstance() {
        return this.callInstanceEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getCallInstance_OperationReference() {
        return (EReference) this.callInstanceEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getCallInstance_OutputParameterInstances() {
        return (EReference) this.callInstanceEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getCallInstance_NumberOfCalls() {
        return (EAttribute) this.callInstanceEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getCallInstance_InputParameterInstances() {
        return (EReference) this.callInstanceEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getOperationReference() {
        return this.operationReferenceEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getOperationReference_CallInstance() {
        return (EReference) this.operationReferenceEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getComponentInstance() {
        return this.componentInstanceEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getComponentInstance_ComponentReference() {
        return (EReference) this.componentInstanceEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getComponentInstance_ParameterInstances() {
        return (EReference) this.componentInstanceEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getComponentReference() {
        return this.componentReferenceEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getComponentReference_ComponentInstance() {
        return (EReference) this.componentReferenceEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getParameterReference() {
        return this.parameterReferenceEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getParameterReference_ParameterPartition() {
        return (EReference) this.parameterReferenceEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getParameterReference_ParameterInstance() {
        return (EReference) this.parameterReferenceEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getParameterReference_ParameterValueDeviation() {
        return (EReference) this.parameterReferenceEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public ParametersFactory getParametersFactory() {
        return (ParametersFactory) this.getEFactoryInstance();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private boolean isCreated = false;

    /**
     * Creates the meta-model objects for the package. This method is guarded to have no affect on
     * any invocation but its first. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public void createPackageContents() {
        if (this.isCreated) {
            return;
        }
        this.isCreated = true;

        // Create classes and their features
        this.parameterPartitionEClass = this.createEClass(PARAMETER_PARTITION);
        this.createEReference(this.parameterPartitionEClass, PARAMETER_PARTITION__QUALITY_ANNOTATION);
        this.createEReference(this.parameterPartitionEClass, PARAMETER_PARTITION__PARAMETER_REFERENCE);

        this.parameterValueEClass = this.createEClass(PARAMETER_VALUE);
        this.createEReference(this.parameterValueEClass, PARAMETER_VALUE__PARAMETER_INSTANCE);
        this.createEReference(this.parameterValueEClass, PARAMETER_VALUE__PARAMETER_VALUE_DEVIATION);

        this.parameterInstanceEClass = this.createEClass(PARAMETER_INSTANCE);
        this.createEReference(this.parameterInstanceEClass, PARAMETER_INSTANCE__PARAMETER_REFERENCE);
        this.createEReference(this.parameterInstanceEClass, PARAMETER_INSTANCE__INPUT_CALL_INSTANCE);
        this.createEReference(this.parameterInstanceEClass, PARAMETER_INSTANCE__OUTPUT_CALL_INSTANCE);
        this.createEReference(this.parameterInstanceEClass, PARAMETER_INSTANCE__COMPONENT_INSTANCE);
        this.createEReference(this.parameterInstanceEClass, PARAMETER_INSTANCE__PARAMETER_VALUE);

        this.callInstanceEClass = this.createEClass(CALL_INSTANCE);
        this.createEReference(this.callInstanceEClass, CALL_INSTANCE__OPERATION_REFERENCE);
        this.createEReference(this.callInstanceEClass, CALL_INSTANCE__OUTPUT_PARAMETER_INSTANCES);
        this.createEAttribute(this.callInstanceEClass, CALL_INSTANCE__NUMBER_OF_CALLS);
        this.createEReference(this.callInstanceEClass, CALL_INSTANCE__INPUT_PARAMETER_INSTANCES);

        this.operationReferenceEClass = this.createEClass(OPERATION_REFERENCE);
        this.createEReference(this.operationReferenceEClass, OPERATION_REFERENCE__CALL_INSTANCE);

        this.componentInstanceEClass = this.createEClass(COMPONENT_INSTANCE);
        this.createEReference(this.componentInstanceEClass, COMPONENT_INSTANCE__COMPONENT_REFERENCE);
        this.createEReference(this.componentInstanceEClass, COMPONENT_INSTANCE__PARAMETER_INSTANCES);

        this.componentReferenceEClass = this.createEClass(COMPONENT_REFERENCE);
        this.createEReference(this.componentReferenceEClass, COMPONENT_REFERENCE__COMPONENT_INSTANCE);

        this.parameterReferenceEClass = this.createEClass(PARAMETER_REFERENCE);
        this.createEReference(this.parameterReferenceEClass, PARAMETER_REFERENCE__PARAMETER_PARTITION);
        this.createEReference(this.parameterReferenceEClass, PARAMETER_REFERENCE__PARAMETER_INSTANCE);
        this.createEReference(this.parameterReferenceEClass, PARAMETER_REFERENCE__PARAMETER_VALUE_DEVIATION);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private boolean isInitialized = false;

    /**
     * Complete the initialization of the package and its meta-model. This method is guarded to have
     * no affect on any invocation but its first. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public void initializePackageContents() {
        if (this.isInitialized) {
            return;
        }
        this.isInitialized = true;

        // Initialize package
        this.setName(eNAME);
        this.setNsPrefix(eNS_PREFIX);
        this.setNsURI(eNS_URI);

        // Obtain other dependent packages
        final PCMPackage thePCMPackage = (PCMPackage) EPackage.Registry.INSTANCE.getEPackage(PCMPackage.eNS_URI);
        final IdentifierPackage theIdentifierPackage = (IdentifierPackage) EPackage.Registry.INSTANCE
                .getEPackage(IdentifierPackage.eNS_URI);
        final QualityAnnotationPackage theQualityAnnotationPackage = (QualityAnnotationPackage) EPackage.Registry.INSTANCE
                .getEPackage(QualityAnnotationPackage.eNS_URI);

        // Add subpackages
        this.getESubpackages().add(thePCMPackage);

        // Create type parameters

        // Set bounds for type parameters

        // Add supertypes to classes
        this.parameterPartitionEClass.getESuperTypes().add(theIdentifierPackage.getIdentifier());
        this.parameterValueEClass.getESuperTypes().add(theIdentifierPackage.getIdentifier());
        this.parameterInstanceEClass.getESuperTypes().add(theIdentifierPackage.getIdentifier());
        this.callInstanceEClass.getESuperTypes().add(theIdentifierPackage.getIdentifier());
        this.operationReferenceEClass.getESuperTypes().add(theIdentifierPackage.getIdentifier());
        this.componentInstanceEClass.getESuperTypes().add(theIdentifierPackage.getIdentifier());
        this.componentReferenceEClass.getESuperTypes().add(theIdentifierPackage.getIdentifier());
        this.parameterReferenceEClass.getESuperTypes().add(theIdentifierPackage.getIdentifier());

        // Initialize classes and features; add operations and parameters
        this.initEClass(this.parameterPartitionEClass, ParameterPartition.class, "ParameterPartition", IS_ABSTRACT,
                !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        this.initEReference(this.getParameterPartition_QualityAnnotation(),
                theQualityAnnotationPackage.getQualityAnnotation(),
                theQualityAnnotationPackage.getQualityAnnotation_ValidForParameterPartitions(), "qualityAnnotation",
                null, 1, 1, ParameterPartition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
                !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        this.initEReference(this.getParameterPartition_ParameterReference(), this.getParameterReference(),
                this.getParameterReference_ParameterPartition(), "parameterReference", null, 1, 1,
                ParameterPartition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
                !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

        this.initEClass(this.parameterValueEClass, ParameterValue.class, "ParameterValue", IS_ABSTRACT, !IS_INTERFACE,
                IS_GENERATED_INSTANCE_CLASS);
        this.initEReference(this.getParameterValue_ParameterInstance(), this.getParameterInstance(),
                this.getParameterInstance_ParameterValue(), "parameterInstance", null, 0, 1, ParameterValue.class,
                !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE,
                IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        this.initEReference(this.getParameterValue_ParameterValueDeviation(),
                theQualityAnnotationPackage.getParameterValueDeviation(),
                theQualityAnnotationPackage.getParameterValueDeviation_ParameterValue(), "parameterValueDeviation",
                null, 0, 1, ParameterValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
                !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

        this.initEClass(this.parameterInstanceEClass, ParameterInstance.class, "ParameterInstance", !IS_ABSTRACT,
                !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        this.initEReference(this.getParameterInstance_ParameterReference(), this.getParameterReference(),
                this.getParameterReference_ParameterInstance(), "parameterReference", null, 0, 1,
                ParameterInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES,
                !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        this.initEReference(this.getParameterInstance_InputCallInstance(), this.getCallInstance(),
                this.getCallInstance_InputParameterInstances(), "inputCallInstance", null, 0, 1,
                ParameterInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
                !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        this.initEReference(this.getParameterInstance_OutputCallInstance(), this.getCallInstance(),
                this.getCallInstance_OutputParameterInstances(), "outputCallInstance", null, 0, 1,
                ParameterInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
                !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        this.initEReference(this.getParameterInstance_ComponentInstance(), this.getComponentInstance(),
                this.getComponentInstance_ParameterInstances(), "componentInstance", null, 0, 1,
                ParameterInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
                !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        this.initEReference(this.getParameterInstance_ParameterValue(), this.getParameterValue(),
                this.getParameterValue_ParameterInstance(), "parameterValue", null, 1, 1, ParameterInstance.class,
                !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE,
                IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

        this.initEClass(this.callInstanceEClass, CallInstance.class, "CallInstance", !IS_ABSTRACT, !IS_INTERFACE,
                IS_GENERATED_INSTANCE_CLASS);
        this.initEReference(this.getCallInstance_OperationReference(), this.getOperationReference(),
                this.getOperationReference_CallInstance(), "operationReference", null, 1, 1, CallInstance.class,
                !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE,
                IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        this.initEReference(this.getCallInstance_OutputParameterInstances(), this.getParameterInstance(),
                this.getParameterInstance_OutputCallInstance(), "outputParameterInstances", null, 0, -1,
                CallInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES,
                !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        this.initEAttribute(this.getCallInstance_NumberOfCalls(), this.ecorePackage.getELong(), "numberOfCalls", "1",
                1, 1, CallInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
                IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        this.initEReference(this.getCallInstance_InputParameterInstances(), this.getParameterInstance(),
                this.getParameterInstance_InputCallInstance(), "inputParameterInstances", null, 0, -1,
                CallInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES,
                !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

        this.initEClass(this.operationReferenceEClass, OperationReference.class, "OperationReference", IS_ABSTRACT,
                !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        this.initEReference(this.getOperationReference_CallInstance(), this.getCallInstance(),
                this.getCallInstance_OperationReference(), "callInstance", null, 0, 1, OperationReference.class,
                !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE,
                IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

        this.initEClass(this.componentInstanceEClass, ComponentInstance.class, "ComponentInstance", !IS_ABSTRACT,
                !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        this.initEReference(this.getComponentInstance_ComponentReference(), this.getComponentReference(),
                this.getComponentReference_ComponentInstance(), "componentReference", null, 1, 1,
                ComponentInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES,
                !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        this.initEReference(this.getComponentInstance_ParameterInstances(), this.getParameterInstance(),
                this.getParameterInstance_ComponentInstance(), "parameterInstances", null, 0, -1,
                ComponentInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES,
                !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

        this.initEClass(this.componentReferenceEClass, ComponentReference.class, "ComponentReference", IS_ABSTRACT,
                !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        this.initEReference(this.getComponentReference_ComponentInstance(), this.getComponentInstance(),
                this.getComponentInstance_ComponentReference(), "componentInstance", null, 0, 1,
                ComponentReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
                !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

        this.initEClass(this.parameterReferenceEClass, ParameterReference.class, "ParameterReference", IS_ABSTRACT,
                !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        this.initEReference(this.getParameterReference_ParameterPartition(), this.getParameterPartition(),
                this.getParameterPartition_ParameterReference(), "parameterPartition", null, 0, 1,
                ParameterReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
                !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        this.initEReference(this.getParameterReference_ParameterInstance(), this.getParameterInstance(),
                this.getParameterInstance_ParameterReference(), "parameterInstance", null, 0, 1,
                ParameterReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
                !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        this.initEReference(this.getParameterReference_ParameterValueDeviation(),
                theQualityAnnotationPackage.getParameterValueDeviation(),
                theQualityAnnotationPackage.getParameterValueDeviation_ParameterReference(), "parameterValueDeviation",
                null, 0, 1, ParameterReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
                !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
    }

} // ParametersPackageImpl
