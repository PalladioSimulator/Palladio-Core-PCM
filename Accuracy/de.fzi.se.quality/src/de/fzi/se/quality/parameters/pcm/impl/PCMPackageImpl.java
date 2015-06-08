/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.fzi.se.quality.parameters.pcm.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;

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
import de.uka.ipd.sdq.pcm.PcmPackage;
import de.uka.ipd.sdq.pcm.parameter.ParameterPackage;
import de.uka.ipd.sdq.pcm.repository.RepositoryPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Package</b>. <!-- end-user-doc -->
 *
 * @generated
 */
public class PCMPackageImpl extends EPackageImpl implements PCMPackage {

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    private EClass pcmParameterReferenceEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    private EClass pcmParameterValueEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    private EClass pcmInfrastructureOperationReferenceEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    private EClass pcmBusinessOperationReferenceEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    private EClass pcmComponentReferenceEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    private EClass pcmComponentParameterReferenceEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    private EClass pcmOperationParameterReferenceEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    private EClass pcmRequiredBusinessOperationReturnParameterReferenceEClass = null;

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
     * @see de.fzi.se.quality.parameters.pcm.PCMPackage#eNS_URI
     * @see #init()
     * @generated
     */
    private PCMPackageImpl() {
        super(eNS_URI, PCMFactory.eINSTANCE);
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
     * This method is used to initialize {@link PCMPackage#eINSTANCE} when that field is accessed.
     * Clients should not invoke it directly. Instead, they should simply access that field to
     * obtain the package. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #eNS_URI
     * @see #createPackageContents()
     * @see #initializePackageContents()
     * @generated
     */
    public static PCMPackage init() {
        if (isInited) {
            return (PCMPackage) EPackage.Registry.INSTANCE.getEPackage(PCMPackage.eNS_URI);
        }

        // Obtain or create and register package
        final PCMPackageImpl thePCMPackage = (PCMPackageImpl) (EPackage.Registry.INSTANCE.get(eNS_URI) instanceof PCMPackageImpl ? EPackage.Registry.INSTANCE
                .get(eNS_URI) : new PCMPackageImpl());

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
        final ParametersPackageImpl theParametersPackage = (ParametersPackageImpl) (EPackage.Registry.INSTANCE
                .getEPackage(ParametersPackage.eNS_URI) instanceof ParametersPackageImpl ? EPackage.Registry.INSTANCE
                .getEPackage(ParametersPackage.eNS_URI) : ParametersPackage.eINSTANCE);

        // Create package meta-data objects
        thePCMPackage.createPackageContents();
        theQualityPackage.createPackageContents();
        theQualityAnnotationPackage.createPackageContents();
        theParametersPackage.createPackageContents();

        // Initialize created meta-data
        thePCMPackage.initializePackageContents();
        theQualityPackage.initializePackageContents();
        theQualityAnnotationPackage.initializePackageContents();
        theParametersPackage.initializePackageContents();

        // Mark meta-data to indicate it can't be changed
        thePCMPackage.freeze();

        // Update the registry and return the package
        EPackage.Registry.INSTANCE.put(PCMPackage.eNS_URI, thePCMPackage);
        return thePCMPackage;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EClass getPCMParameterReference() {
        return this.pcmParameterReferenceEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EClass getPCMParameterValue() {
        return this.pcmParameterValueEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EReference getPCMParameterValue_VariableCharacterisations() {
        return (EReference) this.pcmParameterValueEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EClass getPCMInfrastructureOperationReference() {
        return this.pcmInfrastructureOperationReferenceEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EReference getPCMInfrastructureOperationReference_Role() {
        return (EReference) this.pcmInfrastructureOperationReferenceEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EReference getPCMInfrastructureOperationReference_Signature() {
        return (EReference) this.pcmInfrastructureOperationReferenceEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EClass getPCMBusinessOperationReference() {
        return this.pcmBusinessOperationReferenceEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EReference getPCMBusinessOperationReference_Role() {
        return (EReference) this.pcmBusinessOperationReferenceEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EReference getPCMBusinessOperationReference_Signature() {
        return (EReference) this.pcmBusinessOperationReferenceEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EClass getPCMComponentReference() {
        return this.pcmComponentReferenceEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EReference getPCMComponentReference_BasicComponent() {
        return (EReference) this.pcmComponentReferenceEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EClass getPCMComponentParameterReference() {
        return this.pcmComponentParameterReferenceEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EReference getPCMComponentParameterReference_ImplementationComponentType() {
        return (EReference) this.pcmComponentParameterReferenceEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EReference getPCMComponentParameterReference_VariableUsage() {
        return (EReference) this.pcmComponentParameterReferenceEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EClass getPCMOperationParameterReference() {
        return this.pcmOperationParameterReferenceEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EReference getPCMOperationParameterReference_Parameter() {
        return (EReference) this.pcmOperationParameterReferenceEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EClass getPCMRequiredBusinessOperationReturnParameterReference() {
        return this.pcmRequiredBusinessOperationReturnParameterReferenceEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EReference getPCMRequiredBusinessOperationReturnParameterReference_RequiredRole() {
        return (EReference) this.pcmRequiredBusinessOperationReturnParameterReferenceEClass.getEStructuralFeatures()
                .get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EReference getPCMRequiredBusinessOperationReturnParameterReference_Signature() {
        return (EReference) this.pcmRequiredBusinessOperationReturnParameterReferenceEClass.getEStructuralFeatures()
                .get(1);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public PCMFactory getPCMFactory() {
        return (PCMFactory) this.getEFactoryInstance();
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
        this.pcmParameterReferenceEClass = this.createEClass(PCM_PARAMETER_REFERENCE);

        this.pcmParameterValueEClass = this.createEClass(PCM_PARAMETER_VALUE);
        this.createEReference(this.pcmParameterValueEClass, PCM_PARAMETER_VALUE__VARIABLE_CHARACTERISATIONS);

        this.pcmInfrastructureOperationReferenceEClass = this.createEClass(PCM_INFRASTRUCTURE_OPERATION_REFERENCE);
        this.createEReference(this.pcmInfrastructureOperationReferenceEClass,
                PCM_INFRASTRUCTURE_OPERATION_REFERENCE__ROLE);
        this.createEReference(this.pcmInfrastructureOperationReferenceEClass,
                PCM_INFRASTRUCTURE_OPERATION_REFERENCE__SIGNATURE);

        this.pcmBusinessOperationReferenceEClass = this.createEClass(PCM_BUSINESS_OPERATION_REFERENCE);
        this.createEReference(this.pcmBusinessOperationReferenceEClass, PCM_BUSINESS_OPERATION_REFERENCE__ROLE);
        this.createEReference(this.pcmBusinessOperationReferenceEClass, PCM_BUSINESS_OPERATION_REFERENCE__SIGNATURE);

        this.pcmComponentReferenceEClass = this.createEClass(PCM_COMPONENT_REFERENCE);
        this.createEReference(this.pcmComponentReferenceEClass, PCM_COMPONENT_REFERENCE__BASIC_COMPONENT);

        this.pcmComponentParameterReferenceEClass = this.createEClass(PCM_COMPONENT_PARAMETER_REFERENCE);
        this.createEReference(this.pcmComponentParameterReferenceEClass,
                PCM_COMPONENT_PARAMETER_REFERENCE__IMPLEMENTATION_COMPONENT_TYPE);
        this.createEReference(this.pcmComponentParameterReferenceEClass,
                PCM_COMPONENT_PARAMETER_REFERENCE__VARIABLE_USAGE);

        this.pcmOperationParameterReferenceEClass = this.createEClass(PCM_OPERATION_PARAMETER_REFERENCE);
        this.createEReference(this.pcmOperationParameterReferenceEClass, PCM_OPERATION_PARAMETER_REFERENCE__PARAMETER);

        this.pcmRequiredBusinessOperationReturnParameterReferenceEClass = this
                .createEClass(PCM_REQUIRED_BUSINESS_OPERATION_RETURN_PARAMETER_REFERENCE);
        this.createEReference(this.pcmRequiredBusinessOperationReturnParameterReferenceEClass,
                PCM_REQUIRED_BUSINESS_OPERATION_RETURN_PARAMETER_REFERENCE__REQUIRED_ROLE);
        this.createEReference(this.pcmRequiredBusinessOperationReturnParameterReferenceEClass,
                PCM_REQUIRED_BUSINESS_OPERATION_RETURN_PARAMETER_REFERENCE__SIGNATURE);
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
        final ParametersPackage theParametersPackage = (ParametersPackage) EPackage.Registry.INSTANCE
                .getEPackage(ParametersPackage.eNS_URI);
        final ParameterPackage theParameterPackage = (ParameterPackage) EPackage.Registry.INSTANCE
                .getEPackage(ParameterPackage.eNS_URI);
        final RepositoryPackage theRepositoryPackage = (RepositoryPackage) EPackage.Registry.INSTANCE
                .getEPackage(RepositoryPackage.eNS_URI);

        // Create type parameters

        // Set bounds for type parameters

        // Add supertypes to classes
        this.pcmParameterReferenceEClass.getESuperTypes().add(theParametersPackage.getParameterReference());
        this.pcmParameterValueEClass.getESuperTypes().add(theParametersPackage.getParameterValue());
        this.pcmInfrastructureOperationReferenceEClass.getESuperTypes().add(
                theParametersPackage.getOperationReference());
        this.pcmBusinessOperationReferenceEClass.getESuperTypes().add(theParametersPackage.getOperationReference());
        this.pcmComponentReferenceEClass.getESuperTypes().add(theParametersPackage.getComponentReference());
        this.pcmComponentParameterReferenceEClass.getESuperTypes().add(this.getPCMParameterReference());
        this.pcmOperationParameterReferenceEClass.getESuperTypes().add(this.getPCMParameterReference());
        this.pcmRequiredBusinessOperationReturnParameterReferenceEClass.getESuperTypes().add(
                this.getPCMParameterReference());

        // Initialize classes and features; add operations and parameters
        this.initEClass(this.pcmParameterReferenceEClass, PCMParameterReference.class, "PCMParameterReference",
                IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        this.initEClass(this.pcmParameterValueEClass, PCMParameterValue.class, "PCMParameterValue", !IS_ABSTRACT,
                !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        this.initEReference(this.getPCMParameterValue_VariableCharacterisations(),
                theParameterPackage.getVariableUsage(), null, "variableCharacterisations", null, 1, -1,
                PCMParameterValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES,
                !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

        this.initEClass(this.pcmInfrastructureOperationReferenceEClass, PCMInfrastructureOperationReference.class,
                "PCMInfrastructureOperationReference", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        this.initEReference(this.getPCMInfrastructureOperationReference_Role(),
                theRepositoryPackage.getInfrastructureRequiredRole(), null, "role", null, 1, 1,
                PCMInfrastructureOperationReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
                IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        this.initEReference(this.getPCMInfrastructureOperationReference_Signature(),
                theRepositoryPackage.getInfrastructureSignature(), null, "signature", null, 1, 1,
                PCMInfrastructureOperationReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
                IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

        this.initEClass(this.pcmBusinessOperationReferenceEClass, PCMBusinessOperationReference.class,
                "PCMBusinessOperationReference", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        this.initEReference(this.getPCMBusinessOperationReference_Role(),
                theRepositoryPackage.getOperationRequiredRole(), null, "role", null, 1, 1,
                PCMBusinessOperationReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
                IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        this.initEReference(this.getPCMBusinessOperationReference_Signature(),
                theRepositoryPackage.getOperationSignature(), null, "signature", null, 1, 1,
                PCMBusinessOperationReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
                IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

        this.initEClass(this.pcmComponentReferenceEClass, PCMComponentReference.class, "PCMComponentReference",
                !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        this.initEReference(this.getPCMComponentReference_BasicComponent(), theRepositoryPackage.getBasicComponent(),
                null, "basicComponent", null, 1, 1, PCMComponentReference.class, !IS_TRANSIENT, !IS_VOLATILE,
                IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

        this.initEClass(this.pcmComponentParameterReferenceEClass, PCMComponentParameterReference.class,
                "PCMComponentParameterReference", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        this.initEReference(this.getPCMComponentParameterReference_ImplementationComponentType(),
                theRepositoryPackage.getImplementationComponentType(), null, "implementationComponentType", null, 1, 1,
                PCMComponentParameterReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
                IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        this.initEReference(this.getPCMComponentParameterReference_VariableUsage(),
                theParameterPackage.getVariableUsage(), null, "variableUsage", null, 1, 1,
                PCMComponentParameterReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
                IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

        this.initEClass(this.pcmOperationParameterReferenceEClass, PCMOperationParameterReference.class,
                "PCMOperationParameterReference", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        this.initEReference(this.getPCMOperationParameterReference_Parameter(), theRepositoryPackage.getParameter(),
                null, "parameter", null, 1, 1, PCMOperationParameterReference.class, !IS_TRANSIENT, !IS_VOLATILE,
                IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

        this.initEClass(this.pcmRequiredBusinessOperationReturnParameterReferenceEClass,
                PCMRequiredBusinessOperationReturnParameterReference.class,
                "PCMRequiredBusinessOperationReturnParameterReference", !IS_ABSTRACT, !IS_INTERFACE,
                IS_GENERATED_INSTANCE_CLASS);
        this.initEReference(this.getPCMRequiredBusinessOperationReturnParameterReference_RequiredRole(),
                theRepositoryPackage.getOperationRequiredRole(), null, "requiredRole", null, 1, 1,
                PCMRequiredBusinessOperationReturnParameterReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
                !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        this.initEReference(this.getPCMRequiredBusinessOperationReturnParameterReference_Signature(),
                theRepositoryPackage.getOperationSignature(), null, "signature", null, 1, 1,
                PCMRequiredBusinessOperationReturnParameterReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
                !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
    }

} // PCMPackageImpl
