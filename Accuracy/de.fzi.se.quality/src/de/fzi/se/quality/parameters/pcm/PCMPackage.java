/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.fzi.se.quality.parameters.pcm;

import de.fzi.se.quality.parameters.ParametersPackage;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see de.fzi.se.quality.parameters.pcm.PCMFactory
 * @model kind="package"
 * @generated
 */
public interface PCMPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "pcm";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://fzi.de/PalladioComponentModel/Quality/Parameters/PCM/0.2";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "pcmparameters";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	PCMPackage eINSTANCE = de.fzi.se.quality.parameters.pcm.impl.PCMPackageImpl.init();

	/**
	 * The meta object id for the '{@link de.fzi.se.quality.parameters.pcm.impl.PCMParameterReferenceImpl <em>Parameter Reference</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.fzi.se.quality.parameters.pcm.impl.PCMParameterReferenceImpl
	 * @see de.fzi.se.quality.parameters.pcm.impl.PCMPackageImpl#getPCMParameterReference()
	 * @generated
	 */
	int PCM_PARAMETER_REFERENCE = 0;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PCM_PARAMETER_REFERENCE__ID = ParametersPackage.PARAMETER_REFERENCE__ID;

	/**
	 * The feature id for the '<em><b>Parameter Partition</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PCM_PARAMETER_REFERENCE__PARAMETER_PARTITION = ParametersPackage.PARAMETER_REFERENCE__PARAMETER_PARTITION;

	/**
	 * The feature id for the '<em><b>Parameter Instance</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PCM_PARAMETER_REFERENCE__PARAMETER_INSTANCE = ParametersPackage.PARAMETER_REFERENCE__PARAMETER_INSTANCE;

	/**
	 * The feature id for the '<em><b>Parameter Value Deviation</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PCM_PARAMETER_REFERENCE__PARAMETER_VALUE_DEVIATION = ParametersPackage.PARAMETER_REFERENCE__PARAMETER_VALUE_DEVIATION;

	/**
	 * The number of structural features of the '<em>Parameter Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PCM_PARAMETER_REFERENCE_FEATURE_COUNT = ParametersPackage.PARAMETER_REFERENCE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.fzi.se.quality.parameters.pcm.impl.PCMParameterValueImpl <em>Parameter Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.fzi.se.quality.parameters.pcm.impl.PCMParameterValueImpl
	 * @see de.fzi.se.quality.parameters.pcm.impl.PCMPackageImpl#getPCMParameterValue()
	 * @generated
	 */
	int PCM_PARAMETER_VALUE = 1;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PCM_PARAMETER_VALUE__ID = ParametersPackage.PARAMETER_VALUE__ID;

	/**
	 * The feature id for the '<em><b>Parameter Instance</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PCM_PARAMETER_VALUE__PARAMETER_INSTANCE = ParametersPackage.PARAMETER_VALUE__PARAMETER_INSTANCE;

	/**
	 * The feature id for the '<em><b>Parameter Value Deviation</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PCM_PARAMETER_VALUE__PARAMETER_VALUE_DEVIATION = ParametersPackage.PARAMETER_VALUE__PARAMETER_VALUE_DEVIATION;

	/**
	 * The feature id for the '<em><b>Variable Characterisation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PCM_PARAMETER_VALUE__VARIABLE_CHARACTERISATION = ParametersPackage.PARAMETER_VALUE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Parameter Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PCM_PARAMETER_VALUE_FEATURE_COUNT = ParametersPackage.PARAMETER_VALUE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link de.fzi.se.quality.parameters.pcm.impl.PCMInfrastructureOperationReferenceImpl <em>Infrastructure Operation Reference</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.fzi.se.quality.parameters.pcm.impl.PCMInfrastructureOperationReferenceImpl
	 * @see de.fzi.se.quality.parameters.pcm.impl.PCMPackageImpl#getPCMInfrastructureOperationReference()
	 * @generated
	 */
	int PCM_INFRASTRUCTURE_OPERATION_REFERENCE = 2;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PCM_INFRASTRUCTURE_OPERATION_REFERENCE__ID = ParametersPackage.OPERATION_REFERENCE__ID;

	/**
	 * The feature id for the '<em><b>Call Instance</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PCM_INFRASTRUCTURE_OPERATION_REFERENCE__CALL_INSTANCE = ParametersPackage.OPERATION_REFERENCE__CALL_INSTANCE;

	/**
	 * The feature id for the '<em><b>Role</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PCM_INFRASTRUCTURE_OPERATION_REFERENCE__ROLE = ParametersPackage.OPERATION_REFERENCE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Signature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PCM_INFRASTRUCTURE_OPERATION_REFERENCE__SIGNATURE = ParametersPackage.OPERATION_REFERENCE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Infrastructure Operation Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PCM_INFRASTRUCTURE_OPERATION_REFERENCE_FEATURE_COUNT = ParametersPackage.OPERATION_REFERENCE_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link de.fzi.se.quality.parameters.pcm.impl.PCMBusinessOperationReferenceImpl <em>Business Operation Reference</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.fzi.se.quality.parameters.pcm.impl.PCMBusinessOperationReferenceImpl
	 * @see de.fzi.se.quality.parameters.pcm.impl.PCMPackageImpl#getPCMBusinessOperationReference()
	 * @generated
	 */
	int PCM_BUSINESS_OPERATION_REFERENCE = 3;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PCM_BUSINESS_OPERATION_REFERENCE__ID = ParametersPackage.OPERATION_REFERENCE__ID;

	/**
	 * The feature id for the '<em><b>Call Instance</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PCM_BUSINESS_OPERATION_REFERENCE__CALL_INSTANCE = ParametersPackage.OPERATION_REFERENCE__CALL_INSTANCE;

	/**
	 * The feature id for the '<em><b>Role</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PCM_BUSINESS_OPERATION_REFERENCE__ROLE = ParametersPackage.OPERATION_REFERENCE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Signature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PCM_BUSINESS_OPERATION_REFERENCE__SIGNATURE = ParametersPackage.OPERATION_REFERENCE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Business Operation Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PCM_BUSINESS_OPERATION_REFERENCE_FEATURE_COUNT = ParametersPackage.OPERATION_REFERENCE_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link de.fzi.se.quality.parameters.pcm.impl.PCMComponentReferenceImpl <em>Component Reference</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.fzi.se.quality.parameters.pcm.impl.PCMComponentReferenceImpl
	 * @see de.fzi.se.quality.parameters.pcm.impl.PCMPackageImpl#getPCMComponentReference()
	 * @generated
	 */
	int PCM_COMPONENT_REFERENCE = 4;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PCM_COMPONENT_REFERENCE__ID = ParametersPackage.COMPONENT_REFERENCE__ID;

	/**
	 * The feature id for the '<em><b>Component Instance</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PCM_COMPONENT_REFERENCE__COMPONENT_INSTANCE = ParametersPackage.COMPONENT_REFERENCE__COMPONENT_INSTANCE;

	/**
	 * The feature id for the '<em><b>Basic Component</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PCM_COMPONENT_REFERENCE__BASIC_COMPONENT = ParametersPackage.COMPONENT_REFERENCE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Component Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PCM_COMPONENT_REFERENCE_FEATURE_COUNT = ParametersPackage.COMPONENT_REFERENCE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link de.fzi.se.quality.parameters.pcm.impl.PCMComponentParameterReferenceImpl <em>Component Parameter Reference</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.fzi.se.quality.parameters.pcm.impl.PCMComponentParameterReferenceImpl
	 * @see de.fzi.se.quality.parameters.pcm.impl.PCMPackageImpl#getPCMComponentParameterReference()
	 * @generated
	 */
	int PCM_COMPONENT_PARAMETER_REFERENCE = 5;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PCM_COMPONENT_PARAMETER_REFERENCE__ID = PCM_PARAMETER_REFERENCE__ID;

	/**
	 * The feature id for the '<em><b>Parameter Partition</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PCM_COMPONENT_PARAMETER_REFERENCE__PARAMETER_PARTITION = PCM_PARAMETER_REFERENCE__PARAMETER_PARTITION;

	/**
	 * The feature id for the '<em><b>Parameter Instance</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PCM_COMPONENT_PARAMETER_REFERENCE__PARAMETER_INSTANCE = PCM_PARAMETER_REFERENCE__PARAMETER_INSTANCE;

	/**
	 * The feature id for the '<em><b>Parameter Value Deviation</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PCM_COMPONENT_PARAMETER_REFERENCE__PARAMETER_VALUE_DEVIATION = PCM_PARAMETER_REFERENCE__PARAMETER_VALUE_DEVIATION;

	/**
	 * The feature id for the '<em><b>Implementation Component Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PCM_COMPONENT_PARAMETER_REFERENCE__IMPLEMENTATION_COMPONENT_TYPE = PCM_PARAMETER_REFERENCE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Variable Usage</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PCM_COMPONENT_PARAMETER_REFERENCE__VARIABLE_USAGE = PCM_PARAMETER_REFERENCE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Component Parameter Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PCM_COMPONENT_PARAMETER_REFERENCE_FEATURE_COUNT = PCM_PARAMETER_REFERENCE_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link de.fzi.se.quality.parameters.pcm.impl.PCMOperationParameterReferenceImpl <em>Operation Parameter Reference</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.fzi.se.quality.parameters.pcm.impl.PCMOperationParameterReferenceImpl
	 * @see de.fzi.se.quality.parameters.pcm.impl.PCMPackageImpl#getPCMOperationParameterReference()
	 * @generated
	 */
	int PCM_OPERATION_PARAMETER_REFERENCE = 6;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PCM_OPERATION_PARAMETER_REFERENCE__ID = PCM_PARAMETER_REFERENCE__ID;

	/**
	 * The feature id for the '<em><b>Parameter Partition</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PCM_OPERATION_PARAMETER_REFERENCE__PARAMETER_PARTITION = PCM_PARAMETER_REFERENCE__PARAMETER_PARTITION;

	/**
	 * The feature id for the '<em><b>Parameter Instance</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PCM_OPERATION_PARAMETER_REFERENCE__PARAMETER_INSTANCE = PCM_PARAMETER_REFERENCE__PARAMETER_INSTANCE;

	/**
	 * The feature id for the '<em><b>Parameter Value Deviation</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PCM_OPERATION_PARAMETER_REFERENCE__PARAMETER_VALUE_DEVIATION = PCM_PARAMETER_REFERENCE__PARAMETER_VALUE_DEVIATION;

	/**
	 * The feature id for the '<em><b>Parameter</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PCM_OPERATION_PARAMETER_REFERENCE__PARAMETER = PCM_PARAMETER_REFERENCE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Operation Parameter Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PCM_OPERATION_PARAMETER_REFERENCE_FEATURE_COUNT = PCM_PARAMETER_REFERENCE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link de.fzi.se.quality.parameters.pcm.impl.PCMRequiredBusinessOperationReturnParameterReferenceImpl <em>Required Business Operation Return Parameter Reference</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.fzi.se.quality.parameters.pcm.impl.PCMRequiredBusinessOperationReturnParameterReferenceImpl
	 * @see de.fzi.se.quality.parameters.pcm.impl.PCMPackageImpl#getPCMRequiredBusinessOperationReturnParameterReference()
	 * @generated
	 */
	int PCM_REQUIRED_BUSINESS_OPERATION_RETURN_PARAMETER_REFERENCE = 7;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PCM_REQUIRED_BUSINESS_OPERATION_RETURN_PARAMETER_REFERENCE__ID = PCM_PARAMETER_REFERENCE__ID;

	/**
	 * The feature id for the '<em><b>Parameter Partition</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PCM_REQUIRED_BUSINESS_OPERATION_RETURN_PARAMETER_REFERENCE__PARAMETER_PARTITION = PCM_PARAMETER_REFERENCE__PARAMETER_PARTITION;

	/**
	 * The feature id for the '<em><b>Parameter Instance</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PCM_REQUIRED_BUSINESS_OPERATION_RETURN_PARAMETER_REFERENCE__PARAMETER_INSTANCE = PCM_PARAMETER_REFERENCE__PARAMETER_INSTANCE;

	/**
	 * The feature id for the '<em><b>Parameter Value Deviation</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PCM_REQUIRED_BUSINESS_OPERATION_RETURN_PARAMETER_REFERENCE__PARAMETER_VALUE_DEVIATION = PCM_PARAMETER_REFERENCE__PARAMETER_VALUE_DEVIATION;

	/**
	 * The feature id for the '<em><b>Required Role</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PCM_REQUIRED_BUSINESS_OPERATION_RETURN_PARAMETER_REFERENCE__REQUIRED_ROLE = PCM_PARAMETER_REFERENCE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Signature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PCM_REQUIRED_BUSINESS_OPERATION_RETURN_PARAMETER_REFERENCE__SIGNATURE = PCM_PARAMETER_REFERENCE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Required Business Operation Return Parameter Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PCM_REQUIRED_BUSINESS_OPERATION_RETURN_PARAMETER_REFERENCE_FEATURE_COUNT = PCM_PARAMETER_REFERENCE_FEATURE_COUNT + 2;


	/**
	 * Returns the meta object for class '{@link de.fzi.se.quality.parameters.pcm.PCMParameterReference <em>Parameter Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Parameter Reference</em>'.
	 * @see de.fzi.se.quality.parameters.pcm.PCMParameterReference
	 * @generated
	 */
	EClass getPCMParameterReference();

	/**
	 * Returns the meta object for class '{@link de.fzi.se.quality.parameters.pcm.PCMParameterValue <em>Parameter Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Parameter Value</em>'.
	 * @see de.fzi.se.quality.parameters.pcm.PCMParameterValue
	 * @generated
	 */
	EClass getPCMParameterValue();

	/**
	 * Returns the meta object for the containment reference list '{@link de.fzi.se.quality.parameters.pcm.PCMParameterValue#getVariableCharacterisation <em>Variable Characterisation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Variable Characterisation</em>'.
	 * @see de.fzi.se.quality.parameters.pcm.PCMParameterValue#getVariableCharacterisation()
	 * @see #getPCMParameterValue()
	 * @generated
	 */
	EReference getPCMParameterValue_VariableCharacterisation();

	/**
	 * Returns the meta object for class '{@link de.fzi.se.quality.parameters.pcm.PCMInfrastructureOperationReference <em>Infrastructure Operation Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Infrastructure Operation Reference</em>'.
	 * @see de.fzi.se.quality.parameters.pcm.PCMInfrastructureOperationReference
	 * @generated
	 */
	EClass getPCMInfrastructureOperationReference();

	/**
	 * Returns the meta object for the reference '{@link de.fzi.se.quality.parameters.pcm.PCMInfrastructureOperationReference#getRole <em>Role</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Role</em>'.
	 * @see de.fzi.se.quality.parameters.pcm.PCMInfrastructureOperationReference#getRole()
	 * @see #getPCMInfrastructureOperationReference()
	 * @generated
	 */
	EReference getPCMInfrastructureOperationReference_Role();

	/**
	 * Returns the meta object for the reference '{@link de.fzi.se.quality.parameters.pcm.PCMInfrastructureOperationReference#getSignature <em>Signature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Signature</em>'.
	 * @see de.fzi.se.quality.parameters.pcm.PCMInfrastructureOperationReference#getSignature()
	 * @see #getPCMInfrastructureOperationReference()
	 * @generated
	 */
	EReference getPCMInfrastructureOperationReference_Signature();

	/**
	 * Returns the meta object for class '{@link de.fzi.se.quality.parameters.pcm.PCMBusinessOperationReference <em>Business Operation Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Business Operation Reference</em>'.
	 * @see de.fzi.se.quality.parameters.pcm.PCMBusinessOperationReference
	 * @generated
	 */
	EClass getPCMBusinessOperationReference();

	/**
	 * Returns the meta object for the reference '{@link de.fzi.se.quality.parameters.pcm.PCMBusinessOperationReference#getRole <em>Role</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Role</em>'.
	 * @see de.fzi.se.quality.parameters.pcm.PCMBusinessOperationReference#getRole()
	 * @see #getPCMBusinessOperationReference()
	 * @generated
	 */
	EReference getPCMBusinessOperationReference_Role();

	/**
	 * Returns the meta object for the reference '{@link de.fzi.se.quality.parameters.pcm.PCMBusinessOperationReference#getSignature <em>Signature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Signature</em>'.
	 * @see de.fzi.se.quality.parameters.pcm.PCMBusinessOperationReference#getSignature()
	 * @see #getPCMBusinessOperationReference()
	 * @generated
	 */
	EReference getPCMBusinessOperationReference_Signature();

	/**
	 * Returns the meta object for class '{@link de.fzi.se.quality.parameters.pcm.PCMComponentReference <em>Component Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Component Reference</em>'.
	 * @see de.fzi.se.quality.parameters.pcm.PCMComponentReference
	 * @generated
	 */
	EClass getPCMComponentReference();

	/**
	 * Returns the meta object for the reference '{@link de.fzi.se.quality.parameters.pcm.PCMComponentReference#getBasicComponent <em>Basic Component</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Basic Component</em>'.
	 * @see de.fzi.se.quality.parameters.pcm.PCMComponentReference#getBasicComponent()
	 * @see #getPCMComponentReference()
	 * @generated
	 */
	EReference getPCMComponentReference_BasicComponent();

	/**
	 * Returns the meta object for class '{@link de.fzi.se.quality.parameters.pcm.PCMComponentParameterReference <em>Component Parameter Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Component Parameter Reference</em>'.
	 * @see de.fzi.se.quality.parameters.pcm.PCMComponentParameterReference
	 * @generated
	 */
	EClass getPCMComponentParameterReference();

	/**
	 * Returns the meta object for the reference '{@link de.fzi.se.quality.parameters.pcm.PCMComponentParameterReference#getImplementationComponentType <em>Implementation Component Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Implementation Component Type</em>'.
	 * @see de.fzi.se.quality.parameters.pcm.PCMComponentParameterReference#getImplementationComponentType()
	 * @see #getPCMComponentParameterReference()
	 * @generated
	 */
	EReference getPCMComponentParameterReference_ImplementationComponentType();

	/**
	 * Returns the meta object for the reference '{@link de.fzi.se.quality.parameters.pcm.PCMComponentParameterReference#getVariableUsage <em>Variable Usage</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Variable Usage</em>'.
	 * @see de.fzi.se.quality.parameters.pcm.PCMComponentParameterReference#getVariableUsage()
	 * @see #getPCMComponentParameterReference()
	 * @generated
	 */
	EReference getPCMComponentParameterReference_VariableUsage();

	/**
	 * Returns the meta object for class '{@link de.fzi.se.quality.parameters.pcm.PCMOperationParameterReference <em>Operation Parameter Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Operation Parameter Reference</em>'.
	 * @see de.fzi.se.quality.parameters.pcm.PCMOperationParameterReference
	 * @generated
	 */
	EClass getPCMOperationParameterReference();

	/**
	 * Returns the meta object for the reference '{@link de.fzi.se.quality.parameters.pcm.PCMOperationParameterReference#getParameter <em>Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Parameter</em>'.
	 * @see de.fzi.se.quality.parameters.pcm.PCMOperationParameterReference#getParameter()
	 * @see #getPCMOperationParameterReference()
	 * @generated
	 */
	EReference getPCMOperationParameterReference_Parameter();

	/**
	 * Returns the meta object for class '{@link de.fzi.se.quality.parameters.pcm.PCMRequiredBusinessOperationReturnParameterReference <em>Required Business Operation Return Parameter Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Required Business Operation Return Parameter Reference</em>'.
	 * @see de.fzi.se.quality.parameters.pcm.PCMRequiredBusinessOperationReturnParameterReference
	 * @generated
	 */
	EClass getPCMRequiredBusinessOperationReturnParameterReference();

	/**
	 * Returns the meta object for the reference '{@link de.fzi.se.quality.parameters.pcm.PCMRequiredBusinessOperationReturnParameterReference#getRequiredRole <em>Required Role</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Required Role</em>'.
	 * @see de.fzi.se.quality.parameters.pcm.PCMRequiredBusinessOperationReturnParameterReference#getRequiredRole()
	 * @see #getPCMRequiredBusinessOperationReturnParameterReference()
	 * @generated
	 */
	EReference getPCMRequiredBusinessOperationReturnParameterReference_RequiredRole();

	/**
	 * Returns the meta object for the reference '{@link de.fzi.se.quality.parameters.pcm.PCMRequiredBusinessOperationReturnParameterReference#getSignature <em>Signature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Signature</em>'.
	 * @see de.fzi.se.quality.parameters.pcm.PCMRequiredBusinessOperationReturnParameterReference#getSignature()
	 * @see #getPCMRequiredBusinessOperationReturnParameterReference()
	 * @generated
	 */
	EReference getPCMRequiredBusinessOperationReturnParameterReference_Signature();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	PCMFactory getPCMFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link de.fzi.se.quality.parameters.pcm.impl.PCMParameterReferenceImpl <em>Parameter Reference</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.fzi.se.quality.parameters.pcm.impl.PCMParameterReferenceImpl
		 * @see de.fzi.se.quality.parameters.pcm.impl.PCMPackageImpl#getPCMParameterReference()
		 * @generated
		 */
		EClass PCM_PARAMETER_REFERENCE = eINSTANCE.getPCMParameterReference();

		/**
		 * The meta object literal for the '{@link de.fzi.se.quality.parameters.pcm.impl.PCMParameterValueImpl <em>Parameter Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.fzi.se.quality.parameters.pcm.impl.PCMParameterValueImpl
		 * @see de.fzi.se.quality.parameters.pcm.impl.PCMPackageImpl#getPCMParameterValue()
		 * @generated
		 */
		EClass PCM_PARAMETER_VALUE = eINSTANCE.getPCMParameterValue();

		/**
		 * The meta object literal for the '<em><b>Variable Characterisation</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PCM_PARAMETER_VALUE__VARIABLE_CHARACTERISATION = eINSTANCE.getPCMParameterValue_VariableCharacterisation();

		/**
		 * The meta object literal for the '{@link de.fzi.se.quality.parameters.pcm.impl.PCMInfrastructureOperationReferenceImpl <em>Infrastructure Operation Reference</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.fzi.se.quality.parameters.pcm.impl.PCMInfrastructureOperationReferenceImpl
		 * @see de.fzi.se.quality.parameters.pcm.impl.PCMPackageImpl#getPCMInfrastructureOperationReference()
		 * @generated
		 */
		EClass PCM_INFRASTRUCTURE_OPERATION_REFERENCE = eINSTANCE.getPCMInfrastructureOperationReference();

		/**
		 * The meta object literal for the '<em><b>Role</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PCM_INFRASTRUCTURE_OPERATION_REFERENCE__ROLE = eINSTANCE.getPCMInfrastructureOperationReference_Role();

		/**
		 * The meta object literal for the '<em><b>Signature</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PCM_INFRASTRUCTURE_OPERATION_REFERENCE__SIGNATURE = eINSTANCE.getPCMInfrastructureOperationReference_Signature();

		/**
		 * The meta object literal for the '{@link de.fzi.se.quality.parameters.pcm.impl.PCMBusinessOperationReferenceImpl <em>Business Operation Reference</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.fzi.se.quality.parameters.pcm.impl.PCMBusinessOperationReferenceImpl
		 * @see de.fzi.se.quality.parameters.pcm.impl.PCMPackageImpl#getPCMBusinessOperationReference()
		 * @generated
		 */
		EClass PCM_BUSINESS_OPERATION_REFERENCE = eINSTANCE.getPCMBusinessOperationReference();

		/**
		 * The meta object literal for the '<em><b>Role</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PCM_BUSINESS_OPERATION_REFERENCE__ROLE = eINSTANCE.getPCMBusinessOperationReference_Role();

		/**
		 * The meta object literal for the '<em><b>Signature</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PCM_BUSINESS_OPERATION_REFERENCE__SIGNATURE = eINSTANCE.getPCMBusinessOperationReference_Signature();

		/**
		 * The meta object literal for the '{@link de.fzi.se.quality.parameters.pcm.impl.PCMComponentReferenceImpl <em>Component Reference</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.fzi.se.quality.parameters.pcm.impl.PCMComponentReferenceImpl
		 * @see de.fzi.se.quality.parameters.pcm.impl.PCMPackageImpl#getPCMComponentReference()
		 * @generated
		 */
		EClass PCM_COMPONENT_REFERENCE = eINSTANCE.getPCMComponentReference();

		/**
		 * The meta object literal for the '<em><b>Basic Component</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PCM_COMPONENT_REFERENCE__BASIC_COMPONENT = eINSTANCE.getPCMComponentReference_BasicComponent();

		/**
		 * The meta object literal for the '{@link de.fzi.se.quality.parameters.pcm.impl.PCMComponentParameterReferenceImpl <em>Component Parameter Reference</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.fzi.se.quality.parameters.pcm.impl.PCMComponentParameterReferenceImpl
		 * @see de.fzi.se.quality.parameters.pcm.impl.PCMPackageImpl#getPCMComponentParameterReference()
		 * @generated
		 */
		EClass PCM_COMPONENT_PARAMETER_REFERENCE = eINSTANCE.getPCMComponentParameterReference();

		/**
		 * The meta object literal for the '<em><b>Implementation Component Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PCM_COMPONENT_PARAMETER_REFERENCE__IMPLEMENTATION_COMPONENT_TYPE = eINSTANCE.getPCMComponentParameterReference_ImplementationComponentType();

		/**
		 * The meta object literal for the '<em><b>Variable Usage</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PCM_COMPONENT_PARAMETER_REFERENCE__VARIABLE_USAGE = eINSTANCE.getPCMComponentParameterReference_VariableUsage();

		/**
		 * The meta object literal for the '{@link de.fzi.se.quality.parameters.pcm.impl.PCMOperationParameterReferenceImpl <em>Operation Parameter Reference</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.fzi.se.quality.parameters.pcm.impl.PCMOperationParameterReferenceImpl
		 * @see de.fzi.se.quality.parameters.pcm.impl.PCMPackageImpl#getPCMOperationParameterReference()
		 * @generated
		 */
		EClass PCM_OPERATION_PARAMETER_REFERENCE = eINSTANCE.getPCMOperationParameterReference();

		/**
		 * The meta object literal for the '<em><b>Parameter</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PCM_OPERATION_PARAMETER_REFERENCE__PARAMETER = eINSTANCE.getPCMOperationParameterReference_Parameter();

		/**
		 * The meta object literal for the '{@link de.fzi.se.quality.parameters.pcm.impl.PCMRequiredBusinessOperationReturnParameterReferenceImpl <em>Required Business Operation Return Parameter Reference</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.fzi.se.quality.parameters.pcm.impl.PCMRequiredBusinessOperationReturnParameterReferenceImpl
		 * @see de.fzi.se.quality.parameters.pcm.impl.PCMPackageImpl#getPCMRequiredBusinessOperationReturnParameterReference()
		 * @generated
		 */
		EClass PCM_REQUIRED_BUSINESS_OPERATION_RETURN_PARAMETER_REFERENCE = eINSTANCE.getPCMRequiredBusinessOperationReturnParameterReference();

		/**
		 * The meta object literal for the '<em><b>Required Role</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PCM_REQUIRED_BUSINESS_OPERATION_RETURN_PARAMETER_REFERENCE__REQUIRED_ROLE = eINSTANCE.getPCMRequiredBusinessOperationReturnParameterReference_RequiredRole();

		/**
		 * The meta object literal for the '<em><b>Signature</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PCM_REQUIRED_BUSINESS_OPERATION_RETURN_PARAMETER_REFERENCE__SIGNATURE = eINSTANCE.getPCMRequiredBusinessOperationReturnParameterReference_Signature();

	}

} //PCMPackage
