/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.fzi.se.quality.parameters;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import de.uka.ipd.sdq.identifier.IdentifierPackage;

/**
 * <!-- begin-user-doc --> The <b>Package</b> for the model. It contains accessors for the meta
 * objects to represent
 * <ul>
 * <li>each class,</li>
 * <li>each feature of each class,</li>
 * <li>each enum,</li>
 * <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * 
 * @see de.fzi.se.quality.parameters.ParametersFactory
 * @model kind="package"
 * @generated
 */
public interface ParametersPackage extends EPackage {

    /**
     * The package name. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    String eNAME = "parameters";

    /**
     * The package namespace URI. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    String eNS_URI = "http://fzi.de/PalladioComponentModel/Quality/Parameters/0.2";

    /**
     * The package namespace name. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    String eNS_PREFIX = "parameters";

    /**
     * The singleton instance of the package. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    ParametersPackage eINSTANCE = de.fzi.se.quality.parameters.impl.ParametersPackageImpl.init();

    /**
     * The meta object id for the '{@link de.fzi.se.quality.parameters.impl.ParameterPartitionImpl
     * <em>Parameter Partition</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see de.fzi.se.quality.parameters.impl.ParameterPartitionImpl
     * @see de.fzi.se.quality.parameters.impl.ParametersPackageImpl#getParameterPartition()
     * @generated
     */
    int PARAMETER_PARTITION = 0;

    /**
     * The feature id for the '<em><b>Id</b></em>' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int PARAMETER_PARTITION__ID = IdentifierPackage.IDENTIFIER__ID;

    /**
     * The feature id for the '<em><b>Quality Annotation</b></em>' container reference. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int PARAMETER_PARTITION__QUALITY_ANNOTATION = IdentifierPackage.IDENTIFIER_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Parameter Reference</b></em>' containment reference. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int PARAMETER_PARTITION__PARAMETER_REFERENCE = IdentifierPackage.IDENTIFIER_FEATURE_COUNT + 1;

    /**
     * The number of structural features of the '<em>Parameter Partition</em>' class. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int PARAMETER_PARTITION_FEATURE_COUNT = IdentifierPackage.IDENTIFIER_FEATURE_COUNT + 2;

    /**
     * The meta object id for the '{@link de.fzi.se.quality.parameters.impl.ParameterValueImpl
     * <em>Parameter Value</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see de.fzi.se.quality.parameters.impl.ParameterValueImpl
     * @see de.fzi.se.quality.parameters.impl.ParametersPackageImpl#getParameterValue()
     * @generated
     */
    int PARAMETER_VALUE = 1;

    /**
     * The feature id for the '<em><b>Id</b></em>' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int PARAMETER_VALUE__ID = IdentifierPackage.IDENTIFIER__ID;

    /**
     * The feature id for the '<em><b>Parameter Instance</b></em>' container reference. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int PARAMETER_VALUE__PARAMETER_INSTANCE = IdentifierPackage.IDENTIFIER_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Parameter Value Deviation</b></em>' container reference. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int PARAMETER_VALUE__PARAMETER_VALUE_DEVIATION = IdentifierPackage.IDENTIFIER_FEATURE_COUNT + 1;

    /**
     * The number of structural features of the '<em>Parameter Value</em>' class. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int PARAMETER_VALUE_FEATURE_COUNT = IdentifierPackage.IDENTIFIER_FEATURE_COUNT + 2;

    /**
     * The meta object id for the '{@link de.fzi.se.quality.parameters.impl.ParameterInstanceImpl
     * <em>Parameter Instance</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see de.fzi.se.quality.parameters.impl.ParameterInstanceImpl
     * @see de.fzi.se.quality.parameters.impl.ParametersPackageImpl#getParameterInstance()
     * @generated
     */
    int PARAMETER_INSTANCE = 2;

    /**
     * The feature id for the '<em><b>Id</b></em>' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int PARAMETER_INSTANCE__ID = IdentifierPackage.IDENTIFIER__ID;

    /**
     * The feature id for the '<em><b>Parameter Reference</b></em>' containment reference. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int PARAMETER_INSTANCE__PARAMETER_REFERENCE = IdentifierPackage.IDENTIFIER_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Input Call Instance</b></em>' container reference. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int PARAMETER_INSTANCE__INPUT_CALL_INSTANCE = IdentifierPackage.IDENTIFIER_FEATURE_COUNT + 1;

    /**
     * The feature id for the '<em><b>Output Call Instance</b></em>' container reference. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int PARAMETER_INSTANCE__OUTPUT_CALL_INSTANCE = IdentifierPackage.IDENTIFIER_FEATURE_COUNT + 2;

    /**
     * The feature id for the '<em><b>Component Instance</b></em>' container reference. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int PARAMETER_INSTANCE__COMPONENT_INSTANCE = IdentifierPackage.IDENTIFIER_FEATURE_COUNT + 3;

    /**
     * The feature id for the '<em><b>Parameter Value</b></em>' containment reference. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int PARAMETER_INSTANCE__PARAMETER_VALUE = IdentifierPackage.IDENTIFIER_FEATURE_COUNT + 4;

    /**
     * The number of structural features of the '<em>Parameter Instance</em>' class. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int PARAMETER_INSTANCE_FEATURE_COUNT = IdentifierPackage.IDENTIFIER_FEATURE_COUNT + 5;

    /**
     * The meta object id for the '{@link de.fzi.se.quality.parameters.impl.CallInstanceImpl
     * <em>Call Instance</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see de.fzi.se.quality.parameters.impl.CallInstanceImpl
     * @see de.fzi.se.quality.parameters.impl.ParametersPackageImpl#getCallInstance()
     * @generated
     */
    int CALL_INSTANCE = 3;

    /**
     * The feature id for the '<em><b>Id</b></em>' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int CALL_INSTANCE__ID = IdentifierPackage.IDENTIFIER__ID;

    /**
     * The feature id for the '<em><b>Operation Reference</b></em>' containment reference. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int CALL_INSTANCE__OPERATION_REFERENCE = IdentifierPackage.IDENTIFIER_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Output Parameter Instances</b></em>' containment reference
     * list. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int CALL_INSTANCE__OUTPUT_PARAMETER_INSTANCES = IdentifierPackage.IDENTIFIER_FEATURE_COUNT + 1;

    /**
     * The feature id for the '<em><b>Number Of Calls</b></em>' attribute. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int CALL_INSTANCE__NUMBER_OF_CALLS = IdentifierPackage.IDENTIFIER_FEATURE_COUNT + 2;

    /**
     * The feature id for the '<em><b>Input Parameter Instances</b></em>' containment reference
     * list. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int CALL_INSTANCE__INPUT_PARAMETER_INSTANCES = IdentifierPackage.IDENTIFIER_FEATURE_COUNT + 3;

    /**
     * The number of structural features of the '<em>Call Instance</em>' class. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int CALL_INSTANCE_FEATURE_COUNT = IdentifierPackage.IDENTIFIER_FEATURE_COUNT + 4;

    /**
     * The meta object id for the '{@link de.fzi.se.quality.parameters.impl.OperationReferenceImpl
     * <em>Operation Reference</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see de.fzi.se.quality.parameters.impl.OperationReferenceImpl
     * @see de.fzi.se.quality.parameters.impl.ParametersPackageImpl#getOperationReference()
     * @generated
     */
    int OPERATION_REFERENCE = 4;

    /**
     * The feature id for the '<em><b>Id</b></em>' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int OPERATION_REFERENCE__ID = IdentifierPackage.IDENTIFIER__ID;

    /**
     * The feature id for the '<em><b>Call Instance</b></em>' container reference. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int OPERATION_REFERENCE__CALL_INSTANCE = IdentifierPackage.IDENTIFIER_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Operation Reference</em>' class. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int OPERATION_REFERENCE_FEATURE_COUNT = IdentifierPackage.IDENTIFIER_FEATURE_COUNT + 1;

    /**
     * The meta object id for the '{@link de.fzi.se.quality.parameters.impl.ComponentInstanceImpl
     * <em>Component Instance</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see de.fzi.se.quality.parameters.impl.ComponentInstanceImpl
     * @see de.fzi.se.quality.parameters.impl.ParametersPackageImpl#getComponentInstance()
     * @generated
     */
    int COMPONENT_INSTANCE = 5;

    /**
     * The feature id for the '<em><b>Id</b></em>' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int COMPONENT_INSTANCE__ID = IdentifierPackage.IDENTIFIER__ID;

    /**
     * The feature id for the '<em><b>Component Reference</b></em>' containment reference. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int COMPONENT_INSTANCE__COMPONENT_REFERENCE = IdentifierPackage.IDENTIFIER_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Parameter Instances</b></em>' containment reference list. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int COMPONENT_INSTANCE__PARAMETER_INSTANCES = IdentifierPackage.IDENTIFIER_FEATURE_COUNT + 1;

    /**
     * The number of structural features of the '<em>Component Instance</em>' class. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int COMPONENT_INSTANCE_FEATURE_COUNT = IdentifierPackage.IDENTIFIER_FEATURE_COUNT + 2;

    /**
     * The meta object id for the '{@link de.fzi.se.quality.parameters.impl.ComponentReferenceImpl
     * <em>Component Reference</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see de.fzi.se.quality.parameters.impl.ComponentReferenceImpl
     * @see de.fzi.se.quality.parameters.impl.ParametersPackageImpl#getComponentReference()
     * @generated
     */
    int COMPONENT_REFERENCE = 6;

    /**
     * The feature id for the '<em><b>Id</b></em>' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int COMPONENT_REFERENCE__ID = IdentifierPackage.IDENTIFIER__ID;

    /**
     * The feature id for the '<em><b>Component Instance</b></em>' container reference. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int COMPONENT_REFERENCE__COMPONENT_INSTANCE = IdentifierPackage.IDENTIFIER_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Component Reference</em>' class. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int COMPONENT_REFERENCE_FEATURE_COUNT = IdentifierPackage.IDENTIFIER_FEATURE_COUNT + 1;

    /**
     * The meta object id for the '{@link de.fzi.se.quality.parameters.impl.ParameterReferenceImpl
     * <em>Parameter Reference</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see de.fzi.se.quality.parameters.impl.ParameterReferenceImpl
     * @see de.fzi.se.quality.parameters.impl.ParametersPackageImpl#getParameterReference()
     * @generated
     */
    int PARAMETER_REFERENCE = 7;

    /**
     * The feature id for the '<em><b>Id</b></em>' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int PARAMETER_REFERENCE__ID = IdentifierPackage.IDENTIFIER__ID;

    /**
     * The feature id for the '<em><b>Parameter Partition</b></em>' container reference. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int PARAMETER_REFERENCE__PARAMETER_PARTITION = IdentifierPackage.IDENTIFIER_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Parameter Instance</b></em>' container reference. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int PARAMETER_REFERENCE__PARAMETER_INSTANCE = IdentifierPackage.IDENTIFIER_FEATURE_COUNT + 1;

    /**
     * The feature id for the '<em><b>Parameter Value Deviation</b></em>' container reference. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int PARAMETER_REFERENCE__PARAMETER_VALUE_DEVIATION = IdentifierPackage.IDENTIFIER_FEATURE_COUNT + 2;

    /**
     * The number of structural features of the '<em>Parameter Reference</em>' class. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int PARAMETER_REFERENCE_FEATURE_COUNT = IdentifierPackage.IDENTIFIER_FEATURE_COUNT + 3;

    /**
     * Returns the meta object for class '{@link de.fzi.se.quality.parameters.ParameterPartition
     * <em>Parameter Partition</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for class '<em>Parameter Partition</em>'.
     * @see de.fzi.se.quality.parameters.ParameterPartition
     * @generated
     */
    EClass getParameterPartition();

    /**
     * Returns the meta object for the container reference '
     * {@link de.fzi.se.quality.parameters.ParameterPartition#getQualityAnnotation
     * <em>Quality Annotation</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the container reference '<em>Quality Annotation</em>'.
     * @see de.fzi.se.quality.parameters.ParameterPartition#getQualityAnnotation()
     * @see #getParameterPartition()
     * @generated
     */
    EReference getParameterPartition_QualityAnnotation();

    /**
     * Returns the meta object for the containment reference '
     * {@link de.fzi.se.quality.parameters.ParameterPartition#getParameterReference
     * <em>Parameter Reference</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the containment reference '<em>Parameter Reference</em>'.
     * @see de.fzi.se.quality.parameters.ParameterPartition#getParameterReference()
     * @see #getParameterPartition()
     * @generated
     */
    EReference getParameterPartition_ParameterReference();

    /**
     * Returns the meta object for class '{@link de.fzi.se.quality.parameters.ParameterValue
     * <em>Parameter Value</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for class '<em>Parameter Value</em>'.
     * @see de.fzi.se.quality.parameters.ParameterValue
     * @generated
     */
    EClass getParameterValue();

    /**
     * Returns the meta object for the container reference '
     * {@link de.fzi.se.quality.parameters.ParameterValue#getParameterInstance
     * <em>Parameter Instance</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the container reference '<em>Parameter Instance</em>'.
     * @see de.fzi.se.quality.parameters.ParameterValue#getParameterInstance()
     * @see #getParameterValue()
     * @generated
     */
    EReference getParameterValue_ParameterInstance();

    /**
     * Returns the meta object for the container reference '
     * {@link de.fzi.se.quality.parameters.ParameterValue#getParameterValueDeviation
     * <em>Parameter Value Deviation</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the container reference '<em>Parameter Value Deviation</em>'.
     * @see de.fzi.se.quality.parameters.ParameterValue#getParameterValueDeviation()
     * @see #getParameterValue()
     * @generated
     */
    EReference getParameterValue_ParameterValueDeviation();

    /**
     * Returns the meta object for class '{@link de.fzi.se.quality.parameters.ParameterInstance
     * <em>Parameter Instance</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for class '<em>Parameter Instance</em>'.
     * @see de.fzi.se.quality.parameters.ParameterInstance
     * @generated
     */
    EClass getParameterInstance();

    /**
     * Returns the meta object for the containment reference '
     * {@link de.fzi.se.quality.parameters.ParameterInstance#getParameterReference
     * <em>Parameter Reference</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the containment reference '<em>Parameter Reference</em>'.
     * @see de.fzi.se.quality.parameters.ParameterInstance#getParameterReference()
     * @see #getParameterInstance()
     * @generated
     */
    EReference getParameterInstance_ParameterReference();

    /**
     * Returns the meta object for the container reference '
     * {@link de.fzi.se.quality.parameters.ParameterInstance#getInputCallInstance
     * <em>Input Call Instance</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the container reference '<em>Input Call Instance</em>'.
     * @see de.fzi.se.quality.parameters.ParameterInstance#getInputCallInstance()
     * @see #getParameterInstance()
     * @generated
     */
    EReference getParameterInstance_InputCallInstance();

    /**
     * Returns the meta object for the container reference '
     * {@link de.fzi.se.quality.parameters.ParameterInstance#getOutputCallInstance
     * <em>Output Call Instance</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the container reference '<em>Output Call Instance</em>'.
     * @see de.fzi.se.quality.parameters.ParameterInstance#getOutputCallInstance()
     * @see #getParameterInstance()
     * @generated
     */
    EReference getParameterInstance_OutputCallInstance();

    /**
     * Returns the meta object for the container reference '
     * {@link de.fzi.se.quality.parameters.ParameterInstance#getComponentInstance
     * <em>Component Instance</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the container reference '<em>Component Instance</em>'.
     * @see de.fzi.se.quality.parameters.ParameterInstance#getComponentInstance()
     * @see #getParameterInstance()
     * @generated
     */
    EReference getParameterInstance_ComponentInstance();

    /**
     * Returns the meta object for the containment reference '
     * {@link de.fzi.se.quality.parameters.ParameterInstance#getParameterValue
     * <em>Parameter Value</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the containment reference '<em>Parameter Value</em>'.
     * @see de.fzi.se.quality.parameters.ParameterInstance#getParameterValue()
     * @see #getParameterInstance()
     * @generated
     */
    EReference getParameterInstance_ParameterValue();

    /**
     * Returns the meta object for class '{@link de.fzi.se.quality.parameters.CallInstance
     * <em>Call Instance</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for class '<em>Call Instance</em>'.
     * @see de.fzi.se.quality.parameters.CallInstance
     * @generated
     */
    EClass getCallInstance();

    /**
     * Returns the meta object for the containment reference '
     * {@link de.fzi.se.quality.parameters.CallInstance#getOperationReference
     * <em>Operation Reference</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the containment reference '<em>Operation Reference</em>'.
     * @see de.fzi.se.quality.parameters.CallInstance#getOperationReference()
     * @see #getCallInstance()
     * @generated
     */
    EReference getCallInstance_OperationReference();

    /**
     * Returns the meta object for the containment reference list '
     * {@link de.fzi.se.quality.parameters.CallInstance#getOutputParameterInstances
     * <em>Output Parameter Instances</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the containment reference list '
     *         <em>Output Parameter Instances</em>'.
     * @see de.fzi.se.quality.parameters.CallInstance#getOutputParameterInstances()
     * @see #getCallInstance()
     * @generated
     */
    EReference getCallInstance_OutputParameterInstances();

    /**
     * Returns the meta object for the attribute '
     * {@link de.fzi.se.quality.parameters.CallInstance#getNumberOfCalls <em>Number Of Calls</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>Number Of Calls</em>'.
     * @see de.fzi.se.quality.parameters.CallInstance#getNumberOfCalls()
     * @see #getCallInstance()
     * @generated
     */
    EAttribute getCallInstance_NumberOfCalls();

    /**
     * Returns the meta object for the containment reference list '
     * {@link de.fzi.se.quality.parameters.CallInstance#getInputParameterInstances
     * <em>Input Parameter Instances</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the containment reference list '
     *         <em>Input Parameter Instances</em>'.
     * @see de.fzi.se.quality.parameters.CallInstance#getInputParameterInstances()
     * @see #getCallInstance()
     * @generated
     */
    EReference getCallInstance_InputParameterInstances();

    /**
     * Returns the meta object for class '{@link de.fzi.se.quality.parameters.OperationReference
     * <em>Operation Reference</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for class '<em>Operation Reference</em>'.
     * @see de.fzi.se.quality.parameters.OperationReference
     * @generated
     */
    EClass getOperationReference();

    /**
     * Returns the meta object for the container reference '
     * {@link de.fzi.se.quality.parameters.OperationReference#getCallInstance
     * <em>Call Instance</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the container reference '<em>Call Instance</em>'.
     * @see de.fzi.se.quality.parameters.OperationReference#getCallInstance()
     * @see #getOperationReference()
     * @generated
     */
    EReference getOperationReference_CallInstance();

    /**
     * Returns the meta object for class '{@link de.fzi.se.quality.parameters.ComponentInstance
     * <em>Component Instance</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for class '<em>Component Instance</em>'.
     * @see de.fzi.se.quality.parameters.ComponentInstance
     * @generated
     */
    EClass getComponentInstance();

    /**
     * Returns the meta object for the containment reference '
     * {@link de.fzi.se.quality.parameters.ComponentInstance#getComponentReference
     * <em>Component Reference</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the containment reference '<em>Component Reference</em>'.
     * @see de.fzi.se.quality.parameters.ComponentInstance#getComponentReference()
     * @see #getComponentInstance()
     * @generated
     */
    EReference getComponentInstance_ComponentReference();

    /**
     * Returns the meta object for the containment reference list '
     * {@link de.fzi.se.quality.parameters.ComponentInstance#getParameterInstances
     * <em>Parameter Instances</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the containment reference list '<em>Parameter Instances</em>'.
     * @see de.fzi.se.quality.parameters.ComponentInstance#getParameterInstances()
     * @see #getComponentInstance()
     * @generated
     */
    EReference getComponentInstance_ParameterInstances();

    /**
     * Returns the meta object for class '{@link de.fzi.se.quality.parameters.ComponentReference
     * <em>Component Reference</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for class '<em>Component Reference</em>'.
     * @see de.fzi.se.quality.parameters.ComponentReference
     * @generated
     */
    EClass getComponentReference();

    /**
     * Returns the meta object for the container reference '
     * {@link de.fzi.se.quality.parameters.ComponentReference#getComponentInstance
     * <em>Component Instance</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the container reference '<em>Component Instance</em>'.
     * @see de.fzi.se.quality.parameters.ComponentReference#getComponentInstance()
     * @see #getComponentReference()
     * @generated
     */
    EReference getComponentReference_ComponentInstance();

    /**
     * Returns the meta object for class '{@link de.fzi.se.quality.parameters.ParameterReference
     * <em>Parameter Reference</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for class '<em>Parameter Reference</em>'.
     * @see de.fzi.se.quality.parameters.ParameterReference
     * @generated
     */
    EClass getParameterReference();

    /**
     * Returns the meta object for the container reference '
     * {@link de.fzi.se.quality.parameters.ParameterReference#getParameterPartition
     * <em>Parameter Partition</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the container reference '<em>Parameter Partition</em>'.
     * @see de.fzi.se.quality.parameters.ParameterReference#getParameterPartition()
     * @see #getParameterReference()
     * @generated
     */
    EReference getParameterReference_ParameterPartition();

    /**
     * Returns the meta object for the container reference '
     * {@link de.fzi.se.quality.parameters.ParameterReference#getParameterInstance
     * <em>Parameter Instance</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the container reference '<em>Parameter Instance</em>'.
     * @see de.fzi.se.quality.parameters.ParameterReference#getParameterInstance()
     * @see #getParameterReference()
     * @generated
     */
    EReference getParameterReference_ParameterInstance();

    /**
     * Returns the meta object for the container reference '
     * {@link de.fzi.se.quality.parameters.ParameterReference#getParameterValueDeviation
     * <em>Parameter Value Deviation</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the container reference '<em>Parameter Value Deviation</em>'.
     * @see de.fzi.se.quality.parameters.ParameterReference#getParameterValueDeviation()
     * @see #getParameterReference()
     * @generated
     */
    EReference getParameterReference_ParameterValueDeviation();

    /**
     * Returns the factory that creates the instances of the model. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @return the factory that creates the instances of the model.
     * @generated
     */
    ParametersFactory getParametersFactory();

    /**
     * <!-- begin-user-doc --> Defines literals for the meta objects that represent
     * <ul>
     * <li>each class,</li>
     * <li>each feature of each class,</li>
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
         * {@link de.fzi.se.quality.parameters.impl.ParameterPartitionImpl
         * <em>Parameter Partition</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @see de.fzi.se.quality.parameters.impl.ParameterPartitionImpl
         * @see de.fzi.se.quality.parameters.impl.ParametersPackageImpl#getParameterPartition()
         * @generated
         */
        EClass PARAMETER_PARTITION = eINSTANCE.getParameterPartition();

        /**
         * The meta object literal for the '<em><b>Quality Annotation</b></em>' container reference
         * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EReference PARAMETER_PARTITION__QUALITY_ANNOTATION = eINSTANCE.getParameterPartition_QualityAnnotation();

        /**
         * The meta object literal for the '<em><b>Parameter Reference</b></em>' containment
         * reference feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EReference PARAMETER_PARTITION__PARAMETER_REFERENCE = eINSTANCE.getParameterPartition_ParameterReference();

        /**
         * The meta object literal for the '
         * {@link de.fzi.se.quality.parameters.impl.ParameterValueImpl <em>Parameter Value</em>}'
         * class. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @see de.fzi.se.quality.parameters.impl.ParameterValueImpl
         * @see de.fzi.se.quality.parameters.impl.ParametersPackageImpl#getParameterValue()
         * @generated
         */
        EClass PARAMETER_VALUE = eINSTANCE.getParameterValue();

        /**
         * The meta object literal for the '<em><b>Parameter Instance</b></em>' container reference
         * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EReference PARAMETER_VALUE__PARAMETER_INSTANCE = eINSTANCE.getParameterValue_ParameterInstance();

        /**
         * The meta object literal for the '<em><b>Parameter Value Deviation</b></em>' container
         * reference feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EReference PARAMETER_VALUE__PARAMETER_VALUE_DEVIATION = eINSTANCE.getParameterValue_ParameterValueDeviation();

        /**
         * The meta object literal for the '
         * {@link de.fzi.se.quality.parameters.impl.ParameterInstanceImpl
         * <em>Parameter Instance</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @see de.fzi.se.quality.parameters.impl.ParameterInstanceImpl
         * @see de.fzi.se.quality.parameters.impl.ParametersPackageImpl#getParameterInstance()
         * @generated
         */
        EClass PARAMETER_INSTANCE = eINSTANCE.getParameterInstance();

        /**
         * The meta object literal for the '<em><b>Parameter Reference</b></em>' containment
         * reference feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EReference PARAMETER_INSTANCE__PARAMETER_REFERENCE = eINSTANCE.getParameterInstance_ParameterReference();

        /**
         * The meta object literal for the '<em><b>Input Call Instance</b></em>' container reference
         * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EReference PARAMETER_INSTANCE__INPUT_CALL_INSTANCE = eINSTANCE.getParameterInstance_InputCallInstance();

        /**
         * The meta object literal for the '<em><b>Output Call Instance</b></em>' container
         * reference feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EReference PARAMETER_INSTANCE__OUTPUT_CALL_INSTANCE = eINSTANCE.getParameterInstance_OutputCallInstance();

        /**
         * The meta object literal for the '<em><b>Component Instance</b></em>' container reference
         * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EReference PARAMETER_INSTANCE__COMPONENT_INSTANCE = eINSTANCE.getParameterInstance_ComponentInstance();

        /**
         * The meta object literal for the '<em><b>Parameter Value</b></em>' containment reference
         * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EReference PARAMETER_INSTANCE__PARAMETER_VALUE = eINSTANCE.getParameterInstance_ParameterValue();

        /**
         * The meta object literal for the '
         * {@link de.fzi.se.quality.parameters.impl.CallInstanceImpl <em>Call Instance</em>}' class.
         * <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @see de.fzi.se.quality.parameters.impl.CallInstanceImpl
         * @see de.fzi.se.quality.parameters.impl.ParametersPackageImpl#getCallInstance()
         * @generated
         */
        EClass CALL_INSTANCE = eINSTANCE.getCallInstance();

        /**
         * The meta object literal for the '<em><b>Operation Reference</b></em>' containment
         * reference feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EReference CALL_INSTANCE__OPERATION_REFERENCE = eINSTANCE.getCallInstance_OperationReference();

        /**
         * The meta object literal for the '<em><b>Output Parameter Instances</b></em>' containment
         * reference list feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EReference CALL_INSTANCE__OUTPUT_PARAMETER_INSTANCES = eINSTANCE.getCallInstance_OutputParameterInstances();

        /**
         * The meta object literal for the '<em><b>Number Of Calls</b></em>' attribute feature. <!--
         * begin-user-doc --> <!-- end-user-doc -->
         *
         * @generated
         */
        EAttribute CALL_INSTANCE__NUMBER_OF_CALLS = eINSTANCE.getCallInstance_NumberOfCalls();

        /**
         * The meta object literal for the '<em><b>Input Parameter Instances</b></em>' containment
         * reference list feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EReference CALL_INSTANCE__INPUT_PARAMETER_INSTANCES = eINSTANCE.getCallInstance_InputParameterInstances();

        /**
         * The meta object literal for the '
         * {@link de.fzi.se.quality.parameters.impl.OperationReferenceImpl
         * <em>Operation Reference</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @see de.fzi.se.quality.parameters.impl.OperationReferenceImpl
         * @see de.fzi.se.quality.parameters.impl.ParametersPackageImpl#getOperationReference()
         * @generated
         */
        EClass OPERATION_REFERENCE = eINSTANCE.getOperationReference();

        /**
         * The meta object literal for the '<em><b>Call Instance</b></em>' container reference
         * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EReference OPERATION_REFERENCE__CALL_INSTANCE = eINSTANCE.getOperationReference_CallInstance();

        /**
         * The meta object literal for the '
         * {@link de.fzi.se.quality.parameters.impl.ComponentInstanceImpl
         * <em>Component Instance</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @see de.fzi.se.quality.parameters.impl.ComponentInstanceImpl
         * @see de.fzi.se.quality.parameters.impl.ParametersPackageImpl#getComponentInstance()
         * @generated
         */
        EClass COMPONENT_INSTANCE = eINSTANCE.getComponentInstance();

        /**
         * The meta object literal for the '<em><b>Component Reference</b></em>' containment
         * reference feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EReference COMPONENT_INSTANCE__COMPONENT_REFERENCE = eINSTANCE.getComponentInstance_ComponentReference();

        /**
         * The meta object literal for the '<em><b>Parameter Instances</b></em>' containment
         * reference list feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EReference COMPONENT_INSTANCE__PARAMETER_INSTANCES = eINSTANCE.getComponentInstance_ParameterInstances();

        /**
         * The meta object literal for the '
         * {@link de.fzi.se.quality.parameters.impl.ComponentReferenceImpl
         * <em>Component Reference</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @see de.fzi.se.quality.parameters.impl.ComponentReferenceImpl
         * @see de.fzi.se.quality.parameters.impl.ParametersPackageImpl#getComponentReference()
         * @generated
         */
        EClass COMPONENT_REFERENCE = eINSTANCE.getComponentReference();

        /**
         * The meta object literal for the '<em><b>Component Instance</b></em>' container reference
         * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EReference COMPONENT_REFERENCE__COMPONENT_INSTANCE = eINSTANCE.getComponentReference_ComponentInstance();

        /**
         * The meta object literal for the '
         * {@link de.fzi.se.quality.parameters.impl.ParameterReferenceImpl
         * <em>Parameter Reference</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @see de.fzi.se.quality.parameters.impl.ParameterReferenceImpl
         * @see de.fzi.se.quality.parameters.impl.ParametersPackageImpl#getParameterReference()
         * @generated
         */
        EClass PARAMETER_REFERENCE = eINSTANCE.getParameterReference();

        /**
         * The meta object literal for the '<em><b>Parameter Partition</b></em>' container reference
         * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EReference PARAMETER_REFERENCE__PARAMETER_PARTITION = eINSTANCE.getParameterReference_ParameterPartition();

        /**
         * The meta object literal for the '<em><b>Parameter Instance</b></em>' container reference
         * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EReference PARAMETER_REFERENCE__PARAMETER_INSTANCE = eINSTANCE.getParameterReference_ParameterInstance();

        /**
         * The meta object literal for the '<em><b>Parameter Value Deviation</b></em>' container
         * reference feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EReference PARAMETER_REFERENCE__PARAMETER_VALUE_DEVIATION = eINSTANCE
                .getParameterReference_ParameterValueDeviation();

    }

} // ParametersPackage
