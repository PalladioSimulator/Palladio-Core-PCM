/**
 */
package org.palladiosimulator.pcmmeasuringpoint;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.palladiosimulator.edp2.models.measuringpoint.MeasuringpointPackage;

/**
 * <!-- begin-user-doc --> The <b>Package</b> for the model. It contains accessors for the meta
 * objects to represent
 * <ul>
 * <li>each class,</li>
 * <li>each feature of each class,</li>
 * <li>each operation of each class,</li>
 * <li>each enum,</li>
 * <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 *
 * @see org.palladiosimulator.pcmmeasuringpoint.PcmmeasuringpointFactory
 * @model kind="package"
 * @generated
 */
public interface PcmmeasuringpointPackage extends EPackage {

    /**
     * The package name. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    String eNAME = "pcmmeasuringpoint";

    /**
     * The package namespace URI. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    String eNS_URI = "http://palladiosimulator.org/PCM/MeasuringPoint/1.0";

    /**
     * The package namespace name. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    String eNS_PREFIX = "pcmmeasuringpoint";

    /**
     * The singleton instance of the package. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    PcmmeasuringpointPackage eINSTANCE = org.palladiosimulator.pcmmeasuringpoint.impl.PcmmeasuringpointPackageImpl
            .init();

    /**
     * The meta object id for the '
     * {@link org.palladiosimulator.pcmmeasuringpoint.impl.OperationReferenceImpl
     * <em>Operation Reference</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see org.palladiosimulator.pcmmeasuringpoint.impl.OperationReferenceImpl
     * @see org.palladiosimulator.pcmmeasuringpoint.impl.PcmmeasuringpointPackageImpl#getOperationReference()
     * @generated
     */
    int OPERATION_REFERENCE = 4;

    /**
     * The meta object id for the '
     * {@link org.palladiosimulator.pcmmeasuringpoint.impl.AssemblyOperationMeasuringPointImpl
     * <em>Assembly Operation Measuring Point</em>}' class. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @see org.palladiosimulator.pcmmeasuringpoint.impl.AssemblyOperationMeasuringPointImpl
     * @see org.palladiosimulator.pcmmeasuringpoint.impl.PcmmeasuringpointPackageImpl#getAssemblyOperationMeasuringPoint()
     * @generated
     */
    int ASSEMBLY_OPERATION_MEASURING_POINT = 0;

    /**
     * The feature id for the '<em><b>Measuring Point Repository</b></em>' container reference. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int ASSEMBLY_OPERATION_MEASURING_POINT__MEASURING_POINT_REPOSITORY = MeasuringpointPackage.MEASURING_POINT__MEASURING_POINT_REPOSITORY;

    /**
     * The feature id for the '<em><b>String Representation</b></em>' attribute. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int ASSEMBLY_OPERATION_MEASURING_POINT__STRING_REPRESENTATION = MeasuringpointPackage.MEASURING_POINT__STRING_REPRESENTATION;

    /**
     * The feature id for the '<em><b>Resource URI Representation</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int ASSEMBLY_OPERATION_MEASURING_POINT__RESOURCE_URI_REPRESENTATION = MeasuringpointPackage.MEASURING_POINT__RESOURCE_URI_REPRESENTATION;

    /**
     * The feature id for the '<em><b>Role</b></em>' reference. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int ASSEMBLY_OPERATION_MEASURING_POINT__ROLE = MeasuringpointPackage.MEASURING_POINT_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Operation Signature</b></em>' reference. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int ASSEMBLY_OPERATION_MEASURING_POINT__OPERATION_SIGNATURE = MeasuringpointPackage.MEASURING_POINT_FEATURE_COUNT + 1;

    /**
     * The feature id for the '<em><b>Assembly</b></em>' reference. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int ASSEMBLY_OPERATION_MEASURING_POINT__ASSEMBLY = MeasuringpointPackage.MEASURING_POINT_FEATURE_COUNT + 2;

    /**
     * The number of structural features of the '<em>Assembly Operation Measuring Point</em>' class.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int ASSEMBLY_OPERATION_MEASURING_POINT_FEATURE_COUNT = MeasuringpointPackage.MEASURING_POINT_FEATURE_COUNT + 3;

    /**
     * The meta object id for the '
     * {@link org.palladiosimulator.pcmmeasuringpoint.impl.AssemblyReferenceImpl
     * <em>Assembly Reference</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see org.palladiosimulator.pcmmeasuringpoint.impl.AssemblyReferenceImpl
     * @see org.palladiosimulator.pcmmeasuringpoint.impl.PcmmeasuringpointPackageImpl#getAssemblyReference()
     * @generated
     */
    int ASSEMBLY_REFERENCE = 5;

    /**
     * The meta object id for the '
     * {@link org.palladiosimulator.pcmmeasuringpoint.impl.AssemblyPassiveResourceMeasuringPointImpl
     * <em>Assembly Passive Resource Measuring Point</em>}' class. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @see org.palladiosimulator.pcmmeasuringpoint.impl.AssemblyPassiveResourceMeasuringPointImpl
     * @see org.palladiosimulator.pcmmeasuringpoint.impl.PcmmeasuringpointPackageImpl#getAssemblyPassiveResourceMeasuringPoint()
     * @generated
     */
    int ASSEMBLY_PASSIVE_RESOURCE_MEASURING_POINT = 1;

    /**
     * The feature id for the '<em><b>Measuring Point Repository</b></em>' container reference. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int ASSEMBLY_PASSIVE_RESOURCE_MEASURING_POINT__MEASURING_POINT_REPOSITORY = MeasuringpointPackage.MEASURING_POINT__MEASURING_POINT_REPOSITORY;

    /**
     * The feature id for the '<em><b>String Representation</b></em>' attribute. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int ASSEMBLY_PASSIVE_RESOURCE_MEASURING_POINT__STRING_REPRESENTATION = MeasuringpointPackage.MEASURING_POINT__STRING_REPRESENTATION;

    /**
     * The feature id for the '<em><b>Resource URI Representation</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int ASSEMBLY_PASSIVE_RESOURCE_MEASURING_POINT__RESOURCE_URI_REPRESENTATION = MeasuringpointPackage.MEASURING_POINT__RESOURCE_URI_REPRESENTATION;

    /**
     * The feature id for the '<em><b>Assembly</b></em>' reference. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int ASSEMBLY_PASSIVE_RESOURCE_MEASURING_POINT__ASSEMBLY = MeasuringpointPackage.MEASURING_POINT_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Passive Resource</b></em>' reference. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int ASSEMBLY_PASSIVE_RESOURCE_MEASURING_POINT__PASSIVE_RESOURCE = MeasuringpointPackage.MEASURING_POINT_FEATURE_COUNT + 1;

    /**
     * The number of structural features of the '<em>Assembly Passive Resource Measuring Point</em>'
     * class. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int ASSEMBLY_PASSIVE_RESOURCE_MEASURING_POINT_FEATURE_COUNT = MeasuringpointPackage.MEASURING_POINT_FEATURE_COUNT + 2;

    /**
     * The meta object id for the '
     * {@link org.palladiosimulator.pcmmeasuringpoint.impl.ActiveResourceMeasuringPointImpl
     * <em>Active Resource Measuring Point</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     *
     * @see org.palladiosimulator.pcmmeasuringpoint.impl.ActiveResourceMeasuringPointImpl
     * @see org.palladiosimulator.pcmmeasuringpoint.impl.PcmmeasuringpointPackageImpl#getActiveResourceMeasuringPoint()
     * @generated
     */
    int ACTIVE_RESOURCE_MEASURING_POINT = 2;

    /**
     * The meta object id for the '
     * {@link org.palladiosimulator.pcmmeasuringpoint.impl.SystemOperationMeasuringPointImpl
     * <em>System Operation Measuring Point</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     *
     * @see org.palladiosimulator.pcmmeasuringpoint.impl.SystemOperationMeasuringPointImpl
     * @see org.palladiosimulator.pcmmeasuringpoint.impl.PcmmeasuringpointPackageImpl#getSystemOperationMeasuringPoint()
     * @generated
     */
    int SYSTEM_OPERATION_MEASURING_POINT = 3;

    /**
     * The meta object id for the '
     * {@link org.palladiosimulator.pcmmeasuringpoint.impl.SystemReferenceImpl
     * <em>System Reference</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see org.palladiosimulator.pcmmeasuringpoint.impl.SystemReferenceImpl
     * @see org.palladiosimulator.pcmmeasuringpoint.impl.PcmmeasuringpointPackageImpl#getSystemReference()
     * @generated
     */
    int SYSTEM_REFERENCE = 6;

    /**
     * The meta object id for the '
     * {@link org.palladiosimulator.pcmmeasuringpoint.impl.PassiveResourceReferenceImpl
     * <em>Passive Resource Reference</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see org.palladiosimulator.pcmmeasuringpoint.impl.PassiveResourceReferenceImpl
     * @see org.palladiosimulator.pcmmeasuringpoint.impl.PcmmeasuringpointPackageImpl#getPassiveResourceReference()
     * @generated
     */
    int PASSIVE_RESOURCE_REFERENCE = 7;

    /**
     * The meta object id for the '
     * {@link org.palladiosimulator.pcmmeasuringpoint.impl.ActiveResourceReferenceImpl
     * <em>Active Resource Reference</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see org.palladiosimulator.pcmmeasuringpoint.impl.ActiveResourceReferenceImpl
     * @see org.palladiosimulator.pcmmeasuringpoint.impl.PcmmeasuringpointPackageImpl#getActiveResourceReference()
     * @generated
     */
    int ACTIVE_RESOURCE_REFERENCE = 8;

    /**
     * The feature id for the '<em><b>Measuring Point Repository</b></em>' container reference. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int ACTIVE_RESOURCE_MEASURING_POINT__MEASURING_POINT_REPOSITORY = MeasuringpointPackage.MEASURING_POINT__MEASURING_POINT_REPOSITORY;

    /**
     * The feature id for the '<em><b>String Representation</b></em>' attribute. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int ACTIVE_RESOURCE_MEASURING_POINT__STRING_REPRESENTATION = MeasuringpointPackage.MEASURING_POINT__STRING_REPRESENTATION;

    /**
     * The feature id for the '<em><b>Resource URI Representation</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int ACTIVE_RESOURCE_MEASURING_POINT__RESOURCE_URI_REPRESENTATION = MeasuringpointPackage.MEASURING_POINT__RESOURCE_URI_REPRESENTATION;

    /**
     * The feature id for the '<em><b>Active Resource</b></em>' reference. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int ACTIVE_RESOURCE_MEASURING_POINT__ACTIVE_RESOURCE = MeasuringpointPackage.MEASURING_POINT_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Replica ID</b></em>' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int ACTIVE_RESOURCE_MEASURING_POINT__REPLICA_ID = MeasuringpointPackage.MEASURING_POINT_FEATURE_COUNT + 1;

    /**
     * The number of structural features of the '<em>Active Resource Measuring Point</em>' class.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int ACTIVE_RESOURCE_MEASURING_POINT_FEATURE_COUNT = MeasuringpointPackage.MEASURING_POINT_FEATURE_COUNT + 2;

    /**
     * The feature id for the '<em><b>Measuring Point Repository</b></em>' container reference. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int SYSTEM_OPERATION_MEASURING_POINT__MEASURING_POINT_REPOSITORY = MeasuringpointPackage.MEASURING_POINT__MEASURING_POINT_REPOSITORY;

    /**
     * The feature id for the '<em><b>String Representation</b></em>' attribute. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int SYSTEM_OPERATION_MEASURING_POINT__STRING_REPRESENTATION = MeasuringpointPackage.MEASURING_POINT__STRING_REPRESENTATION;

    /**
     * The feature id for the '<em><b>Resource URI Representation</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int SYSTEM_OPERATION_MEASURING_POINT__RESOURCE_URI_REPRESENTATION = MeasuringpointPackage.MEASURING_POINT__RESOURCE_URI_REPRESENTATION;

    /**
     * The feature id for the '<em><b>Role</b></em>' reference. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int SYSTEM_OPERATION_MEASURING_POINT__ROLE = MeasuringpointPackage.MEASURING_POINT_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Operation Signature</b></em>' reference. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int SYSTEM_OPERATION_MEASURING_POINT__OPERATION_SIGNATURE = MeasuringpointPackage.MEASURING_POINT_FEATURE_COUNT + 1;

    /**
     * The feature id for the '<em><b>System</b></em>' reference. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int SYSTEM_OPERATION_MEASURING_POINT__SYSTEM = MeasuringpointPackage.MEASURING_POINT_FEATURE_COUNT + 2;

    /**
     * The number of structural features of the '<em>System Operation Measuring Point</em>' class.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int SYSTEM_OPERATION_MEASURING_POINT_FEATURE_COUNT = MeasuringpointPackage.MEASURING_POINT_FEATURE_COUNT + 3;

    /**
     * The feature id for the '<em><b>Role</b></em>' reference. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int OPERATION_REFERENCE__ROLE = 0;

    /**
     * The feature id for the '<em><b>Operation Signature</b></em>' reference. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int OPERATION_REFERENCE__OPERATION_SIGNATURE = 1;

    /**
     * The number of structural features of the '<em>Operation Reference</em>' class. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int OPERATION_REFERENCE_FEATURE_COUNT = 2;

    /**
     * The feature id for the '<em><b>Assembly</b></em>' reference. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int ASSEMBLY_REFERENCE__ASSEMBLY = 0;

    /**
     * The number of structural features of the '<em>Assembly Reference</em>' class. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int ASSEMBLY_REFERENCE_FEATURE_COUNT = 1;

    /**
     * The feature id for the '<em><b>System</b></em>' reference. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int SYSTEM_REFERENCE__SYSTEM = 0;

    /**
     * The number of structural features of the '<em>System Reference</em>' class. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int SYSTEM_REFERENCE_FEATURE_COUNT = 1;

    /**
     * The feature id for the '<em><b>Passive Resource</b></em>' reference. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int PASSIVE_RESOURCE_REFERENCE__PASSIVE_RESOURCE = 0;

    /**
     * The number of structural features of the '<em>Passive Resource Reference</em>' class. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int PASSIVE_RESOURCE_REFERENCE_FEATURE_COUNT = 1;

    /**
     * The feature id for the '<em><b>Active Resource</b></em>' reference. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int ACTIVE_RESOURCE_REFERENCE__ACTIVE_RESOURCE = 0;

    /**
     * The feature id for the '<em><b>Replica ID</b></em>' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int ACTIVE_RESOURCE_REFERENCE__REPLICA_ID = 1;

    /**
     * The number of structural features of the '<em>Active Resource Reference</em>' class. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int ACTIVE_RESOURCE_REFERENCE_FEATURE_COUNT = 2;

    /**
     * The meta object id for the '
     * {@link org.palladiosimulator.pcmmeasuringpoint.impl.LinkingResourceMeasuringPointImpl
     * <em>Linking Resource Measuring Point</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     *
     * @see org.palladiosimulator.pcmmeasuringpoint.impl.LinkingResourceMeasuringPointImpl
     * @see org.palladiosimulator.pcmmeasuringpoint.impl.PcmmeasuringpointPackageImpl#getLinkingResourceMeasuringPoint()
     * @generated
     */
    int LINKING_RESOURCE_MEASURING_POINT = 9;

    /**
     * The meta object id for the '
     * {@link org.palladiosimulator.pcmmeasuringpoint.impl.LinkingResourceReferenceImpl
     * <em>Linking Resource Reference</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see org.palladiosimulator.pcmmeasuringpoint.impl.LinkingResourceReferenceImpl
     * @see org.palladiosimulator.pcmmeasuringpoint.impl.PcmmeasuringpointPackageImpl#getLinkingResourceReference()
     * @generated
     */
    int LINKING_RESOURCE_REFERENCE = 10;

    /**
     * The feature id for the '<em><b>Measuring Point Repository</b></em>' container reference. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int LINKING_RESOURCE_MEASURING_POINT__MEASURING_POINT_REPOSITORY = MeasuringpointPackage.MEASURING_POINT__MEASURING_POINT_REPOSITORY;

    /**
     * The feature id for the '<em><b>String Representation</b></em>' attribute. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int LINKING_RESOURCE_MEASURING_POINT__STRING_REPRESENTATION = MeasuringpointPackage.MEASURING_POINT__STRING_REPRESENTATION;

    /**
     * The feature id for the '<em><b>Resource URI Representation</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int LINKING_RESOURCE_MEASURING_POINT__RESOURCE_URI_REPRESENTATION = MeasuringpointPackage.MEASURING_POINT__RESOURCE_URI_REPRESENTATION;

    /**
     * The feature id for the '<em><b>Linking Resource</b></em>' reference. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int LINKING_RESOURCE_MEASURING_POINT__LINKING_RESOURCE = MeasuringpointPackage.MEASURING_POINT_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Linking Resource Measuring Point</em>' class.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int LINKING_RESOURCE_MEASURING_POINT_FEATURE_COUNT = MeasuringpointPackage.MEASURING_POINT_FEATURE_COUNT + 1;

    /**
     * The feature id for the '<em><b>Linking Resource</b></em>' reference. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int LINKING_RESOURCE_REFERENCE__LINKING_RESOURCE = 0;

    /**
     * The number of structural features of the '<em>Linking Resource Reference</em>' class. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int LINKING_RESOURCE_REFERENCE_FEATURE_COUNT = 1;

    /**
     * The meta object id for the '
     * {@link org.palladiosimulator.pcmmeasuringpoint.impl.SubSystemOperationMeasuringPointImpl
     * <em>Sub System Operation Measuring Point</em>}' class. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @see org.palladiosimulator.pcmmeasuringpoint.impl.SubSystemOperationMeasuringPointImpl
     * @see org.palladiosimulator.pcmmeasuringpoint.impl.PcmmeasuringpointPackageImpl#getSubSystemOperationMeasuringPoint()
     * @generated
     */
    int SUB_SYSTEM_OPERATION_MEASURING_POINT = 11;

    /**
     * The meta object id for the '
     * {@link org.palladiosimulator.pcmmeasuringpoint.impl.SubSystemReferenceImpl
     * <em>Sub System Reference</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see org.palladiosimulator.pcmmeasuringpoint.impl.SubSystemReferenceImpl
     * @see org.palladiosimulator.pcmmeasuringpoint.impl.PcmmeasuringpointPackageImpl#getSubSystemReference()
     * @generated
     */
    int SUB_SYSTEM_REFERENCE = 12;

    /**
     * The feature id for the '<em><b>Measuring Point Repository</b></em>' container reference. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int SUB_SYSTEM_OPERATION_MEASURING_POINT__MEASURING_POINT_REPOSITORY = MeasuringpointPackage.MEASURING_POINT__MEASURING_POINT_REPOSITORY;

    /**
     * The feature id for the '<em><b>String Representation</b></em>' attribute. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int SUB_SYSTEM_OPERATION_MEASURING_POINT__STRING_REPRESENTATION = MeasuringpointPackage.MEASURING_POINT__STRING_REPRESENTATION;

    /**
     * The feature id for the '<em><b>Resource URI Representation</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int SUB_SYSTEM_OPERATION_MEASURING_POINT__RESOURCE_URI_REPRESENTATION = MeasuringpointPackage.MEASURING_POINT__RESOURCE_URI_REPRESENTATION;

    /**
     * The feature id for the '<em><b>Subsystem</b></em>' reference. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int SUB_SYSTEM_OPERATION_MEASURING_POINT__SUBSYSTEM = MeasuringpointPackage.MEASURING_POINT_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Role</b></em>' reference. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int SUB_SYSTEM_OPERATION_MEASURING_POINT__ROLE = MeasuringpointPackage.MEASURING_POINT_FEATURE_COUNT + 1;

    /**
     * The feature id for the '<em><b>Operation Signature</b></em>' reference. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int SUB_SYSTEM_OPERATION_MEASURING_POINT__OPERATION_SIGNATURE = MeasuringpointPackage.MEASURING_POINT_FEATURE_COUNT + 2;

    /**
     * The number of structural features of the '<em>Sub System Operation Measuring Point</em>'
     * class. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int SUB_SYSTEM_OPERATION_MEASURING_POINT_FEATURE_COUNT = MeasuringpointPackage.MEASURING_POINT_FEATURE_COUNT + 3;

    /**
     * The feature id for the '<em><b>Subsystem</b></em>' reference. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int SUB_SYSTEM_REFERENCE__SUBSYSTEM = 0;

    /**
     * The number of structural features of the '<em>Sub System Reference</em>' class. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int SUB_SYSTEM_REFERENCE_FEATURE_COUNT = 1;

    /**
     * The meta object id for the '
     * {@link org.palladiosimulator.pcmmeasuringpoint.impl.UsageScenarioMeasuringPointImpl
     * <em>Usage Scenario Measuring Point</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     *
     * @see org.palladiosimulator.pcmmeasuringpoint.impl.UsageScenarioMeasuringPointImpl
     * @see org.palladiosimulator.pcmmeasuringpoint.impl.PcmmeasuringpointPackageImpl#getUsageScenarioMeasuringPoint()
     * @generated
     */
    int USAGE_SCENARIO_MEASURING_POINT = 13;

    /**
     * The meta object id for the '
     * {@link org.palladiosimulator.pcmmeasuringpoint.impl.UsageScenarioReferenceImpl
     * <em>Usage Scenario Reference</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see org.palladiosimulator.pcmmeasuringpoint.impl.UsageScenarioReferenceImpl
     * @see org.palladiosimulator.pcmmeasuringpoint.impl.PcmmeasuringpointPackageImpl#getUsageScenarioReference()
     * @generated
     */
    int USAGE_SCENARIO_REFERENCE = 14;

    /**
     * The feature id for the '<em><b>Measuring Point Repository</b></em>' container reference. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int USAGE_SCENARIO_MEASURING_POINT__MEASURING_POINT_REPOSITORY = MeasuringpointPackage.MEASURING_POINT__MEASURING_POINT_REPOSITORY;

    /**
     * The feature id for the '<em><b>String Representation</b></em>' attribute. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int USAGE_SCENARIO_MEASURING_POINT__STRING_REPRESENTATION = MeasuringpointPackage.MEASURING_POINT__STRING_REPRESENTATION;

    /**
     * The feature id for the '<em><b>Resource URI Representation</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int USAGE_SCENARIO_MEASURING_POINT__RESOURCE_URI_REPRESENTATION = MeasuringpointPackage.MEASURING_POINT__RESOURCE_URI_REPRESENTATION;

    /**
     * The feature id for the '<em><b>Usage Scenario</b></em>' reference. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int USAGE_SCENARIO_MEASURING_POINT__USAGE_SCENARIO = MeasuringpointPackage.MEASURING_POINT_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Usage Scenario Measuring Point</em>' class.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int USAGE_SCENARIO_MEASURING_POINT_FEATURE_COUNT = MeasuringpointPackage.MEASURING_POINT_FEATURE_COUNT + 1;

    /**
     * The feature id for the '<em><b>Usage Scenario</b></em>' reference. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int USAGE_SCENARIO_REFERENCE__USAGE_SCENARIO = 0;

    /**
     * The number of structural features of the '<em>Usage Scenario Reference</em>' class. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int USAGE_SCENARIO_REFERENCE_FEATURE_COUNT = 1;

    /**
     * The meta object id for the '
     * {@link org.palladiosimulator.pcmmeasuringpoint.impl.EntryLevelSystemCallMeasuringPointImpl
     * <em>Entry Level System Call Measuring Point</em>}' class. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @see org.palladiosimulator.pcmmeasuringpoint.impl.EntryLevelSystemCallMeasuringPointImpl
     * @see org.palladiosimulator.pcmmeasuringpoint.impl.PcmmeasuringpointPackageImpl#getEntryLevelSystemCallMeasuringPoint()
     * @generated
     */
    int ENTRY_LEVEL_SYSTEM_CALL_MEASURING_POINT = 15;

    /**
     * The meta object id for the '
     * {@link org.palladiosimulator.pcmmeasuringpoint.impl.ExternalCallActionMeasuringPointImpl
     * <em>External Call Action Measuring Point</em>}' class. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @see org.palladiosimulator.pcmmeasuringpoint.impl.ExternalCallActionMeasuringPointImpl
     * @see org.palladiosimulator.pcmmeasuringpoint.impl.PcmmeasuringpointPackageImpl#getExternalCallActionMeasuringPoint()
     * @generated
     */
    int EXTERNAL_CALL_ACTION_MEASURING_POINT = 16;

    /**
     * The meta object id for the '
     * {@link org.palladiosimulator.pcmmeasuringpoint.impl.ExternalCallActionReferenceImpl
     * <em>External Call Action Reference</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     *
     * @see org.palladiosimulator.pcmmeasuringpoint.impl.ExternalCallActionReferenceImpl
     * @see org.palladiosimulator.pcmmeasuringpoint.impl.PcmmeasuringpointPackageImpl#getExternalCallActionReference()
     * @generated
     */
    int EXTERNAL_CALL_ACTION_REFERENCE = 17;

    /**
     * The meta object id for the '
     * {@link org.palladiosimulator.pcmmeasuringpoint.impl.EntryLevelSystemCallReferenceImpl
     * <em>Entry Level System Call Reference</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     *
     * @see org.palladiosimulator.pcmmeasuringpoint.impl.EntryLevelSystemCallReferenceImpl
     * @see org.palladiosimulator.pcmmeasuringpoint.impl.PcmmeasuringpointPackageImpl#getEntryLevelSystemCallReference()
     * @generated
     */
    int ENTRY_LEVEL_SYSTEM_CALL_REFERENCE = 18;

    /**
     * The feature id for the '<em><b>Measuring Point Repository</b></em>' container reference. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int ENTRY_LEVEL_SYSTEM_CALL_MEASURING_POINT__MEASURING_POINT_REPOSITORY = MeasuringpointPackage.MEASURING_POINT__MEASURING_POINT_REPOSITORY;

    /**
     * The feature id for the '<em><b>String Representation</b></em>' attribute. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int ENTRY_LEVEL_SYSTEM_CALL_MEASURING_POINT__STRING_REPRESENTATION = MeasuringpointPackage.MEASURING_POINT__STRING_REPRESENTATION;

    /**
     * The feature id for the '<em><b>Resource URI Representation</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int ENTRY_LEVEL_SYSTEM_CALL_MEASURING_POINT__RESOURCE_URI_REPRESENTATION = MeasuringpointPackage.MEASURING_POINT__RESOURCE_URI_REPRESENTATION;

    /**
     * The feature id for the '<em><b>Entry Level System Call</b></em>' reference. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int ENTRY_LEVEL_SYSTEM_CALL_MEASURING_POINT__ENTRY_LEVEL_SYSTEM_CALL = MeasuringpointPackage.MEASURING_POINT_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Entry Level System Call Measuring Point</em>'
     * class. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int ENTRY_LEVEL_SYSTEM_CALL_MEASURING_POINT_FEATURE_COUNT = MeasuringpointPackage.MEASURING_POINT_FEATURE_COUNT + 1;

    /**
     * The feature id for the '<em><b>Measuring Point Repository</b></em>' container reference. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int EXTERNAL_CALL_ACTION_MEASURING_POINT__MEASURING_POINT_REPOSITORY = MeasuringpointPackage.MEASURING_POINT__MEASURING_POINT_REPOSITORY;

    /**
     * The feature id for the '<em><b>String Representation</b></em>' attribute. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int EXTERNAL_CALL_ACTION_MEASURING_POINT__STRING_REPRESENTATION = MeasuringpointPackage.MEASURING_POINT__STRING_REPRESENTATION;

    /**
     * The feature id for the '<em><b>Resource URI Representation</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int EXTERNAL_CALL_ACTION_MEASURING_POINT__RESOURCE_URI_REPRESENTATION = MeasuringpointPackage.MEASURING_POINT__RESOURCE_URI_REPRESENTATION;

    /**
     * The feature id for the '<em><b>External Call</b></em>' reference. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int EXTERNAL_CALL_ACTION_MEASURING_POINT__EXTERNAL_CALL = MeasuringpointPackage.MEASURING_POINT_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>External Call Action Measuring Point</em>'
     * class. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int EXTERNAL_CALL_ACTION_MEASURING_POINT_FEATURE_COUNT = MeasuringpointPackage.MEASURING_POINT_FEATURE_COUNT + 1;

    /**
     * The feature id for the '<em><b>External Call</b></em>' reference. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int EXTERNAL_CALL_ACTION_REFERENCE__EXTERNAL_CALL = 0;

    /**
     * The number of structural features of the '<em>External Call Action Reference</em>' class.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int EXTERNAL_CALL_ACTION_REFERENCE_FEATURE_COUNT = 1;

    /**
     * The feature id for the '<em><b>Entry Level System Call</b></em>' reference. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int ENTRY_LEVEL_SYSTEM_CALL_REFERENCE__ENTRY_LEVEL_SYSTEM_CALL = 0;

    /**
     * The number of structural features of the '<em>Entry Level System Call Reference</em>' class.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int ENTRY_LEVEL_SYSTEM_CALL_REFERENCE_FEATURE_COUNT = 1;

    /**
     * The meta object id for the '
     * {@link org.palladiosimulator.pcmmeasuringpoint.impl.ResourceEnvironmentReferenceImpl
     * <em>Resource Environment Reference</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     *
     * @see org.palladiosimulator.pcmmeasuringpoint.impl.ResourceEnvironmentReferenceImpl
     * @see org.palladiosimulator.pcmmeasuringpoint.impl.PcmmeasuringpointPackageImpl#getResourceEnvironmentReference()
     * @generated
     */
    int RESOURCE_ENVIRONMENT_REFERENCE = 20;

    /**
     * The meta object id for the '
     * {@link org.palladiosimulator.pcmmeasuringpoint.impl.ResourceEnvironmentMeasuringPointImpl
     * <em>Resource Environment Measuring Point</em>}' class. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @see org.palladiosimulator.pcmmeasuringpoint.impl.ResourceEnvironmentMeasuringPointImpl
     * @see org.palladiosimulator.pcmmeasuringpoint.impl.PcmmeasuringpointPackageImpl#getResourceEnvironmentMeasuringPoint()
     * @generated
     */
    int RESOURCE_ENVIRONMENT_MEASURING_POINT = 19;

    /**
     * The feature id for the '<em><b>Measuring Point Repository</b></em>' container reference. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int RESOURCE_ENVIRONMENT_MEASURING_POINT__MEASURING_POINT_REPOSITORY = MeasuringpointPackage.MEASURING_POINT__MEASURING_POINT_REPOSITORY;

    /**
     * The feature id for the '<em><b>String Representation</b></em>' attribute. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int RESOURCE_ENVIRONMENT_MEASURING_POINT__STRING_REPRESENTATION = MeasuringpointPackage.MEASURING_POINT__STRING_REPRESENTATION;

    /**
     * The feature id for the '<em><b>Resource URI Representation</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int RESOURCE_ENVIRONMENT_MEASURING_POINT__RESOURCE_URI_REPRESENTATION = MeasuringpointPackage.MEASURING_POINT__RESOURCE_URI_REPRESENTATION;

    /**
     * The feature id for the '<em><b>Resource Environment</b></em>' reference. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int RESOURCE_ENVIRONMENT_MEASURING_POINT__RESOURCE_ENVIRONMENT = MeasuringpointPackage.MEASURING_POINT_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Resource Environment Measuring Point</em>'
     * class. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int RESOURCE_ENVIRONMENT_MEASURING_POINT_FEATURE_COUNT = MeasuringpointPackage.MEASURING_POINT_FEATURE_COUNT + 1;

    /**
     * The feature id for the '<em><b>Resource Environment</b></em>' reference. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int RESOURCE_ENVIRONMENT_REFERENCE__RESOURCE_ENVIRONMENT = 0;

    /**
     * The number of structural features of the '<em>Resource Environment Reference</em>' class.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int RESOURCE_ENVIRONMENT_REFERENCE_FEATURE_COUNT = 1;

    /**
     * The meta object id for the '
     * {@link org.palladiosimulator.pcmmeasuringpoint.impl.ResourceContainerMeasuringPointImpl
     * <em>Resource Container Measuring Point</em>}' class. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @see org.palladiosimulator.pcmmeasuringpoint.impl.ResourceContainerMeasuringPointImpl
     * @see org.palladiosimulator.pcmmeasuringpoint.impl.PcmmeasuringpointPackageImpl#getResourceContainerMeasuringPoint()
     * @generated
     */
    int RESOURCE_CONTAINER_MEASURING_POINT = 21;

    /**
     * The feature id for the '<em><b>Measuring Point Repository</b></em>' container reference. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int RESOURCE_CONTAINER_MEASURING_POINT__MEASURING_POINT_REPOSITORY = MeasuringpointPackage.MEASURING_POINT__MEASURING_POINT_REPOSITORY;

    /**
     * The feature id for the '<em><b>String Representation</b></em>' attribute. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int RESOURCE_CONTAINER_MEASURING_POINT__STRING_REPRESENTATION = MeasuringpointPackage.MEASURING_POINT__STRING_REPRESENTATION;

    /**
     * The feature id for the '<em><b>Resource URI Representation</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int RESOURCE_CONTAINER_MEASURING_POINT__RESOURCE_URI_REPRESENTATION = MeasuringpointPackage.MEASURING_POINT__RESOURCE_URI_REPRESENTATION;

    /**
     * The feature id for the '<em><b>Resource Container</b></em>' reference. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int RESOURCE_CONTAINER_MEASURING_POINT__RESOURCE_CONTAINER = MeasuringpointPackage.MEASURING_POINT_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Resource Container Measuring Point</em>' class.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int RESOURCE_CONTAINER_MEASURING_POINT_FEATURE_COUNT = MeasuringpointPackage.MEASURING_POINT_FEATURE_COUNT + 1;

    /**
     * The meta object id for the '
     * {@link org.palladiosimulator.pcmmeasuringpoint.impl.ResourceContainerReferenceImpl
     * <em>Resource Container Reference</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see org.palladiosimulator.pcmmeasuringpoint.impl.ResourceContainerReferenceImpl
     * @see org.palladiosimulator.pcmmeasuringpoint.impl.PcmmeasuringpointPackageImpl#getResourceContainerReference()
     * @generated
     */
    int RESOURCE_CONTAINER_REFERENCE = 22;

    /**
     * The feature id for the '<em><b>Resource Container</b></em>' reference. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int RESOURCE_CONTAINER_REFERENCE__RESOURCE_CONTAINER = 0;

    /**
     * The number of structural features of the '<em>Resource Container Reference</em>' class. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int RESOURCE_CONTAINER_REFERENCE_FEATURE_COUNT = 1;

    /**
     * Returns the meta object for class '
     * {@link org.palladiosimulator.pcmmeasuringpoint.AssemblyOperationMeasuringPoint
     * <em>Assembly Operation Measuring Point</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for class '<em>Assembly Operation Measuring Point</em>'.
     * @see org.palladiosimulator.pcmmeasuringpoint.AssemblyOperationMeasuringPoint
     * @generated
     */
    EClass getAssemblyOperationMeasuringPoint();

    /**
     * Returns the meta object for class '
     * {@link org.palladiosimulator.pcmmeasuringpoint.AssemblyPassiveResourceMeasuringPoint
     * <em>Assembly Passive Resource Measuring Point</em>}'. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @return the meta object for class '<em>Assembly Passive Resource Measuring Point</em>'.
     * @see org.palladiosimulator.pcmmeasuringpoint.AssemblyPassiveResourceMeasuringPoint
     * @generated
     */
    EClass getAssemblyPassiveResourceMeasuringPoint();

    /**
     * Returns the meta object for class '
     * {@link org.palladiosimulator.pcmmeasuringpoint.ActiveResourceMeasuringPoint
     * <em>Active Resource Measuring Point</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for class '<em>Active Resource Measuring Point</em>'.
     * @see org.palladiosimulator.pcmmeasuringpoint.ActiveResourceMeasuringPoint
     * @generated
     */
    EClass getActiveResourceMeasuringPoint();

    /**
     * Returns the meta object for class '
     * {@link org.palladiosimulator.pcmmeasuringpoint.SystemOperationMeasuringPoint
     * <em>System Operation Measuring Point</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for class '<em>System Operation Measuring Point</em>'.
     * @see org.palladiosimulator.pcmmeasuringpoint.SystemOperationMeasuringPoint
     * @generated
     */
    EClass getSystemOperationMeasuringPoint();

    /**
     * Returns the meta object for class '
     * {@link org.palladiosimulator.pcmmeasuringpoint.OperationReference
     * <em>Operation Reference</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for class '<em>Operation Reference</em>'.
     * @see org.palladiosimulator.pcmmeasuringpoint.OperationReference
     * @generated
     */
    EClass getOperationReference();

    /**
     * Returns the meta object for the reference '
     * {@link org.palladiosimulator.pcmmeasuringpoint.OperationReference#getRole <em>Role</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for the reference '<em>Role</em>'.
     * @see org.palladiosimulator.pcmmeasuringpoint.OperationReference#getRole()
     * @see #getOperationReference()
     * @generated
     */
    EReference getOperationReference_Role();

    /**
     * Returns the meta object for the reference '
     * {@link org.palladiosimulator.pcmmeasuringpoint.OperationReference#getOperationSignature
     * <em>Operation Signature</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for the reference '<em>Operation Signature</em>'.
     * @see org.palladiosimulator.pcmmeasuringpoint.OperationReference#getOperationSignature()
     * @see #getOperationReference()
     * @generated
     */
    EReference getOperationReference_OperationSignature();

    /**
     * Returns the meta object for class '
     * {@link org.palladiosimulator.pcmmeasuringpoint.AssemblyReference <em>Assembly Reference</em>}
     * '. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for class '<em>Assembly Reference</em>'.
     * @see org.palladiosimulator.pcmmeasuringpoint.AssemblyReference
     * @generated
     */
    EClass getAssemblyReference();

    /**
     * Returns the meta object for the reference '
     * {@link org.palladiosimulator.pcmmeasuringpoint.AssemblyReference#getAssembly
     * <em>Assembly</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for the reference '<em>Assembly</em>'.
     * @see org.palladiosimulator.pcmmeasuringpoint.AssemblyReference#getAssembly()
     * @see #getAssemblyReference()
     * @generated
     */
    EReference getAssemblyReference_Assembly();

    /**
     * Returns the meta object for class '
     * {@link org.palladiosimulator.pcmmeasuringpoint.SystemReference <em>System Reference</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for class '<em>System Reference</em>'.
     * @see org.palladiosimulator.pcmmeasuringpoint.SystemReference
     * @generated
     */
    EClass getSystemReference();

    /**
     * Returns the meta object for the reference '
     * {@link org.palladiosimulator.pcmmeasuringpoint.SystemReference#getSystem <em>System</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for the reference '<em>System</em>'.
     * @see org.palladiosimulator.pcmmeasuringpoint.SystemReference#getSystem()
     * @see #getSystemReference()
     * @generated
     */
    EReference getSystemReference_System();

    /**
     * Returns the meta object for class '
     * {@link org.palladiosimulator.pcmmeasuringpoint.PassiveResourceReference
     * <em>Passive Resource Reference</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for class '<em>Passive Resource Reference</em>'.
     * @see org.palladiosimulator.pcmmeasuringpoint.PassiveResourceReference
     * @generated
     */
    EClass getPassiveResourceReference();

    /**
     * Returns the meta object for the reference '
     * {@link org.palladiosimulator.pcmmeasuringpoint.PassiveResourceReference#getPassiveResource
     * <em>Passive Resource</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for the reference '<em>Passive Resource</em>'.
     * @see org.palladiosimulator.pcmmeasuringpoint.PassiveResourceReference#getPassiveResource()
     * @see #getPassiveResourceReference()
     * @generated
     */
    EReference getPassiveResourceReference_PassiveResource();

    /**
     * Returns the meta object for class '
     * {@link org.palladiosimulator.pcmmeasuringpoint.ActiveResourceReference
     * <em>Active Resource Reference</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for class '<em>Active Resource Reference</em>'.
     * @see org.palladiosimulator.pcmmeasuringpoint.ActiveResourceReference
     * @generated
     */
    EClass getActiveResourceReference();

    /**
     * Returns the meta object for the reference '
     * {@link org.palladiosimulator.pcmmeasuringpoint.ActiveResourceReference#getActiveResource
     * <em>Active Resource</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for the reference '<em>Active Resource</em>'.
     * @see org.palladiosimulator.pcmmeasuringpoint.ActiveResourceReference#getActiveResource()
     * @see #getActiveResourceReference()
     * @generated
     */
    EReference getActiveResourceReference_ActiveResource();

    /**
     * Returns the meta object for the attribute '
     * {@link org.palladiosimulator.pcmmeasuringpoint.ActiveResourceReference#getReplicaID
     * <em>Replica ID</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for the attribute '<em>Replica ID</em>'.
     * @see org.palladiosimulator.pcmmeasuringpoint.ActiveResourceReference#getReplicaID()
     * @see #getActiveResourceReference()
     * @generated
     */
    EAttribute getActiveResourceReference_ReplicaID();

    /**
     * Returns the meta object for class '
     * {@link org.palladiosimulator.pcmmeasuringpoint.LinkingResourceMeasuringPoint
     * <em>Linking Resource Measuring Point</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for class '<em>Linking Resource Measuring Point</em>'.
     * @see org.palladiosimulator.pcmmeasuringpoint.LinkingResourceMeasuringPoint
     * @generated
     */
    EClass getLinkingResourceMeasuringPoint();

    /**
     * Returns the meta object for class '
     * {@link org.palladiosimulator.pcmmeasuringpoint.LinkingResourceReference
     * <em>Linking Resource Reference</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for class '<em>Linking Resource Reference</em>'.
     * @see org.palladiosimulator.pcmmeasuringpoint.LinkingResourceReference
     * @generated
     */
    EClass getLinkingResourceReference();

    /**
     * Returns the meta object for the reference '
     * {@link org.palladiosimulator.pcmmeasuringpoint.LinkingResourceReference#getLinkingResource
     * <em>Linking Resource</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for the reference '<em>Linking Resource</em>'.
     * @see org.palladiosimulator.pcmmeasuringpoint.LinkingResourceReference#getLinkingResource()
     * @see #getLinkingResourceReference()
     * @generated
     */
    EReference getLinkingResourceReference_LinkingResource();

    /**
     * Returns the meta object for class '
     * {@link org.palladiosimulator.pcmmeasuringpoint.SubSystemOperationMeasuringPoint
     * <em>Sub System Operation Measuring Point</em>}'. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     *
     * @return the meta object for class '<em>Sub System Operation Measuring Point</em>'.
     * @see org.palladiosimulator.pcmmeasuringpoint.SubSystemOperationMeasuringPoint
     * @generated
     */
    EClass getSubSystemOperationMeasuringPoint();

    /**
     * Returns the meta object for class '
     * {@link org.palladiosimulator.pcmmeasuringpoint.SubSystemReference
     * <em>Sub System Reference</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for class '<em>Sub System Reference</em>'.
     * @see org.palladiosimulator.pcmmeasuringpoint.SubSystemReference
     * @generated
     */
    EClass getSubSystemReference();

    /**
     * Returns the meta object for the reference '
     * {@link org.palladiosimulator.pcmmeasuringpoint.SubSystemReference#getSubsystem
     * <em>Subsystem</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for the reference '<em>Subsystem</em>'.
     * @see org.palladiosimulator.pcmmeasuringpoint.SubSystemReference#getSubsystem()
     * @see #getSubSystemReference()
     * @generated
     */
    EReference getSubSystemReference_Subsystem();

    /**
     * Returns the meta object for class '
     * {@link org.palladiosimulator.pcmmeasuringpoint.UsageScenarioMeasuringPoint
     * <em>Usage Scenario Measuring Point</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for class '<em>Usage Scenario Measuring Point</em>'.
     * @see org.palladiosimulator.pcmmeasuringpoint.UsageScenarioMeasuringPoint
     * @generated
     */
    EClass getUsageScenarioMeasuringPoint();

    /**
     * Returns the meta object for class '
     * {@link org.palladiosimulator.pcmmeasuringpoint.UsageScenarioReference
     * <em>Usage Scenario Reference</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for class '<em>Usage Scenario Reference</em>'.
     * @see org.palladiosimulator.pcmmeasuringpoint.UsageScenarioReference
     * @generated
     */
    EClass getUsageScenarioReference();

    /**
     * Returns the meta object for the reference '
     * {@link org.palladiosimulator.pcmmeasuringpoint.UsageScenarioReference#getUsageScenario
     * <em>Usage Scenario</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for the reference '<em>Usage Scenario</em>'.
     * @see org.palladiosimulator.pcmmeasuringpoint.UsageScenarioReference#getUsageScenario()
     * @see #getUsageScenarioReference()
     * @generated
     */
    EReference getUsageScenarioReference_UsageScenario();

    /**
     * Returns the meta object for class '
     * {@link org.palladiosimulator.pcmmeasuringpoint.EntryLevelSystemCallMeasuringPoint
     * <em>Entry Level System Call Measuring Point</em>}'. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     *
     * @return the meta object for class '<em>Entry Level System Call Measuring Point</em>'.
     * @see org.palladiosimulator.pcmmeasuringpoint.EntryLevelSystemCallMeasuringPoint
     * @generated
     */
    EClass getEntryLevelSystemCallMeasuringPoint();

    /**
     * Returns the meta object for class '
     * {@link org.palladiosimulator.pcmmeasuringpoint.ExternalCallActionMeasuringPoint
     * <em>External Call Action Measuring Point</em>}'. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     *
     * @return the meta object for class '<em>External Call Action Measuring Point</em>'.
     * @see org.palladiosimulator.pcmmeasuringpoint.ExternalCallActionMeasuringPoint
     * @generated
     */
    EClass getExternalCallActionMeasuringPoint();

    /**
     * Returns the meta object for class '
     * {@link org.palladiosimulator.pcmmeasuringpoint.ExternalCallActionReference
     * <em>External Call Action Reference</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for class '<em>External Call Action Reference</em>'.
     * @see org.palladiosimulator.pcmmeasuringpoint.ExternalCallActionReference
     * @generated
     */
    EClass getExternalCallActionReference();

    /**
     * Returns the meta object for the reference '
     * {@link org.palladiosimulator.pcmmeasuringpoint.ExternalCallActionReference#getExternalCall
     * <em>External Call</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for the reference '<em>External Call</em>'.
     * @see org.palladiosimulator.pcmmeasuringpoint.ExternalCallActionReference#getExternalCall()
     * @see #getExternalCallActionReference()
     * @generated
     */
    EReference getExternalCallActionReference_ExternalCall();

    /**
     * Returns the meta object for class '
     * {@link org.palladiosimulator.pcmmeasuringpoint.EntryLevelSystemCallReference
     * <em>Entry Level System Call Reference</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for class '<em>Entry Level System Call Reference</em>'.
     * @see org.palladiosimulator.pcmmeasuringpoint.EntryLevelSystemCallReference
     * @generated
     */
    EClass getEntryLevelSystemCallReference();

    /**
     * Returns the meta object for the reference '
     * {@link org.palladiosimulator.pcmmeasuringpoint.EntryLevelSystemCallReference#getEntryLevelSystemCall
     * <em>Entry Level System Call</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for the reference '<em>Entry Level System Call</em>'.
     * @see org.palladiosimulator.pcmmeasuringpoint.EntryLevelSystemCallReference#getEntryLevelSystemCall()
     * @see #getEntryLevelSystemCallReference()
     * @generated
     */
    EReference getEntryLevelSystemCallReference_EntryLevelSystemCall();

    /**
     * Returns the meta object for class '
     * {@link org.palladiosimulator.pcmmeasuringpoint.ResourceEnvironmentMeasuringPoint
     * <em>Resource Environment Measuring Point</em>}'. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     *
     * @return the meta object for class '<em>Resource Environment Measuring Point</em>'.
     * @see org.palladiosimulator.pcmmeasuringpoint.ResourceEnvironmentMeasuringPoint
     * @generated
     */
    EClass getResourceEnvironmentMeasuringPoint();

    /**
     * Returns the meta object for class '
     * {@link org.palladiosimulator.pcmmeasuringpoint.ResourceEnvironmentReference
     * <em>Resource Environment Reference</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for class '<em>Resource Environment Reference</em>'.
     * @see org.palladiosimulator.pcmmeasuringpoint.ResourceEnvironmentReference
     * @generated
     */
    EClass getResourceEnvironmentReference();

    /**
     * Returns the meta object for the reference '
     * {@link org.palladiosimulator.pcmmeasuringpoint.ResourceEnvironmentReference#getResourceEnvironment
     * <em>Resource Environment</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for the reference '<em>Resource Environment</em>'.
     * @see org.palladiosimulator.pcmmeasuringpoint.ResourceEnvironmentReference#getResourceEnvironment()
     * @see #getResourceEnvironmentReference()
     * @generated
     */
    EReference getResourceEnvironmentReference_ResourceEnvironment();

    /**
     * Returns the meta object for class '
     * {@link org.palladiosimulator.pcmmeasuringpoint.ResourceContainerMeasuringPoint
     * <em>Resource Container Measuring Point</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for class '<em>Resource Container Measuring Point</em>'.
     * @see org.palladiosimulator.pcmmeasuringpoint.ResourceContainerMeasuringPoint
     * @generated
     */
    EClass getResourceContainerMeasuringPoint();

    /**
     * Returns the meta object for class '
     * {@link org.palladiosimulator.pcmmeasuringpoint.ResourceContainerReference
     * <em>Resource Container Reference</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for class '<em>Resource Container Reference</em>'.
     * @see org.palladiosimulator.pcmmeasuringpoint.ResourceContainerReference
     * @generated
     */
    EClass getResourceContainerReference();

    /**
     * Returns the meta object for the reference '
     * {@link org.palladiosimulator.pcmmeasuringpoint.ResourceContainerReference#getResourceContainer
     * <em>Resource Container</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for the reference '<em>Resource Container</em>'.
     * @see org.palladiosimulator.pcmmeasuringpoint.ResourceContainerReference#getResourceContainer()
     * @see #getResourceContainerReference()
     * @generated
     */
    EReference getResourceContainerReference_ResourceContainer();

    /**
     * Returns the factory that creates the instances of the model. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @return the factory that creates the instances of the model.
     * @generated
     */
    PcmmeasuringpointFactory getPcmmeasuringpointFactory();

    /**
     * <!-- begin-user-doc --> Defines literals for the meta objects that represent
     * <ul>
     * <li>each class,</li>
     * <li>each feature of each class,</li>
     * <li>each operation of each class,</li>
     * <li>each enum,</li>
     * <li>and each data type</li>
     * </ul>
     * <!-- end-user-doc -->
     *
     * @generated
     */
    interface Literals {

        /**
         * The meta object literal for the '
         * {@link org.palladiosimulator.pcmmeasuringpoint.impl.AssemblyOperationMeasuringPointImpl
         * <em>Assembly Operation Measuring Point</em>}' class. <!-- begin-user-doc --> <!--
         * end-user-doc -->
         *
         * @see org.palladiosimulator.pcmmeasuringpoint.impl.AssemblyOperationMeasuringPointImpl
         * @see org.palladiosimulator.pcmmeasuringpoint.impl.PcmmeasuringpointPackageImpl#getAssemblyOperationMeasuringPoint()
         * @generated
         */
        EClass ASSEMBLY_OPERATION_MEASURING_POINT = eINSTANCE.getAssemblyOperationMeasuringPoint();

        /**
         * The meta object literal for the '
         * {@link org.palladiosimulator.pcmmeasuringpoint.impl.AssemblyPassiveResourceMeasuringPointImpl
         * <em>Assembly Passive Resource Measuring Point</em>}' class. <!-- begin-user-doc --> <!--
         * end-user-doc -->
         *
         * @see org.palladiosimulator.pcmmeasuringpoint.impl.AssemblyPassiveResourceMeasuringPointImpl
         * @see org.palladiosimulator.pcmmeasuringpoint.impl.PcmmeasuringpointPackageImpl#getAssemblyPassiveResourceMeasuringPoint()
         * @generated
         */
        EClass ASSEMBLY_PASSIVE_RESOURCE_MEASURING_POINT = eINSTANCE.getAssemblyPassiveResourceMeasuringPoint();

        /**
         * The meta object literal for the '
         * {@link org.palladiosimulator.pcmmeasuringpoint.impl.ActiveResourceMeasuringPointImpl
         * <em>Active Resource Measuring Point</em>}' class. <!-- begin-user-doc --> <!--
         * end-user-doc -->
         *
         * @see org.palladiosimulator.pcmmeasuringpoint.impl.ActiveResourceMeasuringPointImpl
         * @see org.palladiosimulator.pcmmeasuringpoint.impl.PcmmeasuringpointPackageImpl#getActiveResourceMeasuringPoint()
         * @generated
         */
        EClass ACTIVE_RESOURCE_MEASURING_POINT = eINSTANCE.getActiveResourceMeasuringPoint();

        /**
         * The meta object literal for the '
         * {@link org.palladiosimulator.pcmmeasuringpoint.impl.SystemOperationMeasuringPointImpl
         * <em>System Operation Measuring Point</em>}' class. <!-- begin-user-doc --> <!--
         * end-user-doc -->
         *
         * @see org.palladiosimulator.pcmmeasuringpoint.impl.SystemOperationMeasuringPointImpl
         * @see org.palladiosimulator.pcmmeasuringpoint.impl.PcmmeasuringpointPackageImpl#getSystemOperationMeasuringPoint()
         * @generated
         */
        EClass SYSTEM_OPERATION_MEASURING_POINT = eINSTANCE.getSystemOperationMeasuringPoint();

        /**
         * The meta object literal for the '
         * {@link org.palladiosimulator.pcmmeasuringpoint.impl.OperationReferenceImpl
         * <em>Operation Reference</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
         *
         * @see org.palladiosimulator.pcmmeasuringpoint.impl.OperationReferenceImpl
         * @see org.palladiosimulator.pcmmeasuringpoint.impl.PcmmeasuringpointPackageImpl#getOperationReference()
         * @generated
         */
        EClass OPERATION_REFERENCE = eINSTANCE.getOperationReference();

        /**
         * The meta object literal for the '<em><b>Role</b></em>' reference feature. <!--
         * begin-user-doc --> <!-- end-user-doc -->
         *
         * @generated
         */
        EReference OPERATION_REFERENCE__ROLE = eINSTANCE.getOperationReference_Role();

        /**
         * The meta object literal for the '<em><b>Operation Signature</b></em>' reference feature.
         * <!-- begin-user-doc --> <!-- end-user-doc -->
         *
         * @generated
         */
        EReference OPERATION_REFERENCE__OPERATION_SIGNATURE = eINSTANCE.getOperationReference_OperationSignature();

        /**
         * The meta object literal for the '
         * {@link org.palladiosimulator.pcmmeasuringpoint.impl.AssemblyReferenceImpl
         * <em>Assembly Reference</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
         *
         * @see org.palladiosimulator.pcmmeasuringpoint.impl.AssemblyReferenceImpl
         * @see org.palladiosimulator.pcmmeasuringpoint.impl.PcmmeasuringpointPackageImpl#getAssemblyReference()
         * @generated
         */
        EClass ASSEMBLY_REFERENCE = eINSTANCE.getAssemblyReference();

        /**
         * The meta object literal for the '<em><b>Assembly</b></em>' reference feature. <!--
         * begin-user-doc --> <!-- end-user-doc -->
         *
         * @generated
         */
        EReference ASSEMBLY_REFERENCE__ASSEMBLY = eINSTANCE.getAssemblyReference_Assembly();

        /**
         * The meta object literal for the '
         * {@link org.palladiosimulator.pcmmeasuringpoint.impl.SystemReferenceImpl
         * <em>System Reference</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
         *
         * @see org.palladiosimulator.pcmmeasuringpoint.impl.SystemReferenceImpl
         * @see org.palladiosimulator.pcmmeasuringpoint.impl.PcmmeasuringpointPackageImpl#getSystemReference()
         * @generated
         */
        EClass SYSTEM_REFERENCE = eINSTANCE.getSystemReference();

        /**
         * The meta object literal for the '<em><b>System</b></em>' reference feature. <!--
         * begin-user-doc --> <!-- end-user-doc -->
         *
         * @generated
         */
        EReference SYSTEM_REFERENCE__SYSTEM = eINSTANCE.getSystemReference_System();

        /**
         * The meta object literal for the '
         * {@link org.palladiosimulator.pcmmeasuringpoint.impl.PassiveResourceReferenceImpl
         * <em>Passive Resource Reference</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc
         * -->
         *
         * @see org.palladiosimulator.pcmmeasuringpoint.impl.PassiveResourceReferenceImpl
         * @see org.palladiosimulator.pcmmeasuringpoint.impl.PcmmeasuringpointPackageImpl#getPassiveResourceReference()
         * @generated
         */
        EClass PASSIVE_RESOURCE_REFERENCE = eINSTANCE.getPassiveResourceReference();

        /**
         * The meta object literal for the '<em><b>Passive Resource</b></em>' reference feature.
         * <!-- begin-user-doc --> <!-- end-user-doc -->
         *
         * @generated
         */
        EReference PASSIVE_RESOURCE_REFERENCE__PASSIVE_RESOURCE = eINSTANCE
                .getPassiveResourceReference_PassiveResource();

        /**
         * The meta object literal for the '
         * {@link org.palladiosimulator.pcmmeasuringpoint.impl.ActiveResourceReferenceImpl
         * <em>Active Resource Reference</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
         *
         * @see org.palladiosimulator.pcmmeasuringpoint.impl.ActiveResourceReferenceImpl
         * @see org.palladiosimulator.pcmmeasuringpoint.impl.PcmmeasuringpointPackageImpl#getActiveResourceReference()
         * @generated
         */
        EClass ACTIVE_RESOURCE_REFERENCE = eINSTANCE.getActiveResourceReference();

        /**
         * The meta object literal for the '<em><b>Active Resource</b></em>' reference feature. <!--
         * begin-user-doc --> <!-- end-user-doc -->
         *
         * @generated
         */
        EReference ACTIVE_RESOURCE_REFERENCE__ACTIVE_RESOURCE = eINSTANCE.getActiveResourceReference_ActiveResource();

        /**
         * The meta object literal for the '<em><b>Replica ID</b></em>' attribute feature. <!--
         * begin-user-doc --> <!-- end-user-doc -->
         *
         * @generated
         */
        EAttribute ACTIVE_RESOURCE_REFERENCE__REPLICA_ID = eINSTANCE.getActiveResourceReference_ReplicaID();

        /**
         * The meta object literal for the '
         * {@link org.palladiosimulator.pcmmeasuringpoint.impl.LinkingResourceMeasuringPointImpl
         * <em>Linking Resource Measuring Point</em>}' class. <!-- begin-user-doc --> <!--
         * end-user-doc -->
         *
         * @see org.palladiosimulator.pcmmeasuringpoint.impl.LinkingResourceMeasuringPointImpl
         * @see org.palladiosimulator.pcmmeasuringpoint.impl.PcmmeasuringpointPackageImpl#getLinkingResourceMeasuringPoint()
         * @generated
         */
        EClass LINKING_RESOURCE_MEASURING_POINT = eINSTANCE.getLinkingResourceMeasuringPoint();

        /**
         * The meta object literal for the '
         * {@link org.palladiosimulator.pcmmeasuringpoint.impl.LinkingResourceReferenceImpl
         * <em>Linking Resource Reference</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc
         * -->
         *
         * @see org.palladiosimulator.pcmmeasuringpoint.impl.LinkingResourceReferenceImpl
         * @see org.palladiosimulator.pcmmeasuringpoint.impl.PcmmeasuringpointPackageImpl#getLinkingResourceReference()
         * @generated
         */
        EClass LINKING_RESOURCE_REFERENCE = eINSTANCE.getLinkingResourceReference();

        /**
         * The meta object literal for the '<em><b>Linking Resource</b></em>' reference feature.
         * <!-- begin-user-doc --> <!-- end-user-doc -->
         *
         * @generated
         */
        EReference LINKING_RESOURCE_REFERENCE__LINKING_RESOURCE = eINSTANCE
                .getLinkingResourceReference_LinkingResource();

        /**
         * The meta object literal for the '
         * {@link org.palladiosimulator.pcmmeasuringpoint.impl.SubSystemOperationMeasuringPointImpl
         * <em>Sub System Operation Measuring Point</em>}' class. <!-- begin-user-doc --> <!--
         * end-user-doc -->
         *
         * @see org.palladiosimulator.pcmmeasuringpoint.impl.SubSystemOperationMeasuringPointImpl
         * @see org.palladiosimulator.pcmmeasuringpoint.impl.PcmmeasuringpointPackageImpl#getSubSystemOperationMeasuringPoint()
         * @generated
         */
        EClass SUB_SYSTEM_OPERATION_MEASURING_POINT = eINSTANCE.getSubSystemOperationMeasuringPoint();

        /**
         * The meta object literal for the '
         * {@link org.palladiosimulator.pcmmeasuringpoint.impl.SubSystemReferenceImpl
         * <em>Sub System Reference</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
         *
         * @see org.palladiosimulator.pcmmeasuringpoint.impl.SubSystemReferenceImpl
         * @see org.palladiosimulator.pcmmeasuringpoint.impl.PcmmeasuringpointPackageImpl#getSubSystemReference()
         * @generated
         */
        EClass SUB_SYSTEM_REFERENCE = eINSTANCE.getSubSystemReference();

        /**
         * The meta object literal for the '<em><b>Subsystem</b></em>' reference feature. <!--
         * begin-user-doc --> <!-- end-user-doc -->
         *
         * @generated
         */
        EReference SUB_SYSTEM_REFERENCE__SUBSYSTEM = eINSTANCE.getSubSystemReference_Subsystem();

        /**
         * The meta object literal for the '
         * {@link org.palladiosimulator.pcmmeasuringpoint.impl.UsageScenarioMeasuringPointImpl
         * <em>Usage Scenario Measuring Point</em>}' class. <!-- begin-user-doc --> <!--
         * end-user-doc -->
         *
         * @see org.palladiosimulator.pcmmeasuringpoint.impl.UsageScenarioMeasuringPointImpl
         * @see org.palladiosimulator.pcmmeasuringpoint.impl.PcmmeasuringpointPackageImpl#getUsageScenarioMeasuringPoint()
         * @generated
         */
        EClass USAGE_SCENARIO_MEASURING_POINT = eINSTANCE.getUsageScenarioMeasuringPoint();

        /**
         * The meta object literal for the '
         * {@link org.palladiosimulator.pcmmeasuringpoint.impl.UsageScenarioReferenceImpl
         * <em>Usage Scenario Reference</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
         *
         * @see org.palladiosimulator.pcmmeasuringpoint.impl.UsageScenarioReferenceImpl
         * @see org.palladiosimulator.pcmmeasuringpoint.impl.PcmmeasuringpointPackageImpl#getUsageScenarioReference()
         * @generated
         */
        EClass USAGE_SCENARIO_REFERENCE = eINSTANCE.getUsageScenarioReference();

        /**
         * The meta object literal for the '<em><b>Usage Scenario</b></em>' reference feature. <!--
         * begin-user-doc --> <!-- end-user-doc -->
         *
         * @generated
         */
        EReference USAGE_SCENARIO_REFERENCE__USAGE_SCENARIO = eINSTANCE.getUsageScenarioReference_UsageScenario();

        /**
         * The meta object literal for the '
         * {@link org.palladiosimulator.pcmmeasuringpoint.impl.EntryLevelSystemCallMeasuringPointImpl
         * <em>Entry Level System Call Measuring Point</em>}' class. <!-- begin-user-doc --> <!--
         * end-user-doc -->
         *
         * @see org.palladiosimulator.pcmmeasuringpoint.impl.EntryLevelSystemCallMeasuringPointImpl
         * @see org.palladiosimulator.pcmmeasuringpoint.impl.PcmmeasuringpointPackageImpl#getEntryLevelSystemCallMeasuringPoint()
         * @generated
         */
        EClass ENTRY_LEVEL_SYSTEM_CALL_MEASURING_POINT = eINSTANCE.getEntryLevelSystemCallMeasuringPoint();

        /**
         * The meta object literal for the '
         * {@link org.palladiosimulator.pcmmeasuringpoint.impl.ExternalCallActionMeasuringPointImpl
         * <em>External Call Action Measuring Point</em>}' class. <!-- begin-user-doc --> <!--
         * end-user-doc -->
         *
         * @see org.palladiosimulator.pcmmeasuringpoint.impl.ExternalCallActionMeasuringPointImpl
         * @see org.palladiosimulator.pcmmeasuringpoint.impl.PcmmeasuringpointPackageImpl#getExternalCallActionMeasuringPoint()
         * @generated
         */
        EClass EXTERNAL_CALL_ACTION_MEASURING_POINT = eINSTANCE.getExternalCallActionMeasuringPoint();

        /**
         * The meta object literal for the '
         * {@link org.palladiosimulator.pcmmeasuringpoint.impl.ExternalCallActionReferenceImpl
         * <em>External Call Action Reference</em>}' class. <!-- begin-user-doc --> <!--
         * end-user-doc -->
         *
         * @see org.palladiosimulator.pcmmeasuringpoint.impl.ExternalCallActionReferenceImpl
         * @see org.palladiosimulator.pcmmeasuringpoint.impl.PcmmeasuringpointPackageImpl#getExternalCallActionReference()
         * @generated
         */
        EClass EXTERNAL_CALL_ACTION_REFERENCE = eINSTANCE.getExternalCallActionReference();

        /**
         * The meta object literal for the '<em><b>External Call</b></em>' reference feature. <!--
         * begin-user-doc --> <!-- end-user-doc -->
         *
         * @generated
         */
        EReference EXTERNAL_CALL_ACTION_REFERENCE__EXTERNAL_CALL = eINSTANCE
                .getExternalCallActionReference_ExternalCall();

        /**
         * The meta object literal for the '
         * {@link org.palladiosimulator.pcmmeasuringpoint.impl.EntryLevelSystemCallReferenceImpl
         * <em>Entry Level System Call Reference</em>}' class. <!-- begin-user-doc --> <!--
         * end-user-doc -->
         *
         * @see org.palladiosimulator.pcmmeasuringpoint.impl.EntryLevelSystemCallReferenceImpl
         * @see org.palladiosimulator.pcmmeasuringpoint.impl.PcmmeasuringpointPackageImpl#getEntryLevelSystemCallReference()
         * @generated
         */
        EClass ENTRY_LEVEL_SYSTEM_CALL_REFERENCE = eINSTANCE.getEntryLevelSystemCallReference();

        /**
         * The meta object literal for the '<em><b>Entry Level System Call</b></em>' reference
         * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         *
         * @generated
         */
        EReference ENTRY_LEVEL_SYSTEM_CALL_REFERENCE__ENTRY_LEVEL_SYSTEM_CALL = eINSTANCE
                .getEntryLevelSystemCallReference_EntryLevelSystemCall();

        /**
         * The meta object literal for the '
         * {@link org.palladiosimulator.pcmmeasuringpoint.impl.ResourceEnvironmentMeasuringPointImpl
         * <em>Resource Environment Measuring Point</em>}' class. <!-- begin-user-doc --> <!--
         * end-user-doc -->
         *
         * @see org.palladiosimulator.pcmmeasuringpoint.impl.ResourceEnvironmentMeasuringPointImpl
         * @see org.palladiosimulator.pcmmeasuringpoint.impl.PcmmeasuringpointPackageImpl#getResourceEnvironmentMeasuringPoint()
         * @generated
         */
        EClass RESOURCE_ENVIRONMENT_MEASURING_POINT = eINSTANCE.getResourceEnvironmentMeasuringPoint();

        /**
         * The meta object literal for the '
         * {@link org.palladiosimulator.pcmmeasuringpoint.impl.ResourceEnvironmentReferenceImpl
         * <em>Resource Environment Reference</em>}' class. <!-- begin-user-doc --> <!--
         * end-user-doc -->
         *
         * @see org.palladiosimulator.pcmmeasuringpoint.impl.ResourceEnvironmentReferenceImpl
         * @see org.palladiosimulator.pcmmeasuringpoint.impl.PcmmeasuringpointPackageImpl#getResourceEnvironmentReference()
         * @generated
         */
        EClass RESOURCE_ENVIRONMENT_REFERENCE = eINSTANCE.getResourceEnvironmentReference();

        /**
         * The meta object literal for the '<em><b>Resource Environment</b></em>' reference feature.
         * <!-- begin-user-doc --> <!-- end-user-doc -->
         *
         * @generated
         */
        EReference RESOURCE_ENVIRONMENT_REFERENCE__RESOURCE_ENVIRONMENT = eINSTANCE
                .getResourceEnvironmentReference_ResourceEnvironment();

        /**
         * The meta object literal for the '
         * {@link org.palladiosimulator.pcmmeasuringpoint.impl.ResourceContainerMeasuringPointImpl
         * <em>Resource Container Measuring Point</em>}' class. <!-- begin-user-doc --> <!--
         * end-user-doc -->
         *
         * @see org.palladiosimulator.pcmmeasuringpoint.impl.ResourceContainerMeasuringPointImpl
         * @see org.palladiosimulator.pcmmeasuringpoint.impl.PcmmeasuringpointPackageImpl#getResourceContainerMeasuringPoint()
         * @generated
         */
        EClass RESOURCE_CONTAINER_MEASURING_POINT = eINSTANCE.getResourceContainerMeasuringPoint();

        /**
         * The meta object literal for the '
         * {@link org.palladiosimulator.pcmmeasuringpoint.impl.ResourceContainerReferenceImpl
         * <em>Resource Container Reference</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc
         * -->
         *
         * @see org.palladiosimulator.pcmmeasuringpoint.impl.ResourceContainerReferenceImpl
         * @see org.palladiosimulator.pcmmeasuringpoint.impl.PcmmeasuringpointPackageImpl#getResourceContainerReference()
         * @generated
         */
        EClass RESOURCE_CONTAINER_REFERENCE = eINSTANCE.getResourceContainerReference();

        /**
         * The meta object literal for the '<em><b>Resource Container</b></em>' reference feature.
         * <!-- begin-user-doc --> <!-- end-user-doc -->
         *
         * @generated
         */
        EReference RESOURCE_CONTAINER_REFERENCE__RESOURCE_CONTAINER = eINSTANCE
                .getResourceContainerReference_ResourceContainer();

    }

} // PcmmeasuringpointPackage
