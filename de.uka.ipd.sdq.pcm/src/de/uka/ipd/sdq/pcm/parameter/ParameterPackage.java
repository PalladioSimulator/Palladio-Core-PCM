/**
 * Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.parameter;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import de.uka.ipd.sdq.pcm.core.entity.EntityPackage;
import de.uka.ipd.sdq.stoex.StoexPackage;

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
 * <!-- begin-model-doc -->
 * The parameter package allows to model data dependent performance characteristics of software systems. It is mainly used to specify performance dependencies on input and output parameters of single service calls. It can also be used to describe dependencies on the state of components by the use of component parameters. The latter describe stochastically a component state which does not change over time. 
 * 
 * Parameters are described by the use of variable usages which on the one side contain a performance abstraction of the variable's value and on the other side the name of the variable for refering to the variable. Characterisations available include Structure (information on the data's internal structure like "sorted" or "unsorted" for an array), Number of Elements (size of a collection), Value (the actuall variable value), Bytesize (the variable's memory footprint), or type (the type of the variable in polymorphic cases).
 * 
 * Example for variable usages may be a.NUMBER_OF_ELEMENTS = 10 (array "a" contains 10 elements), tree.STRUCTURE = "balanced" (tree "tree" is a balanced tree), and so on.
 * <!-- end-model-doc -->
 * @see de.uka.ipd.sdq.pcm.parameter.ParameterFactory
 * @model kind="package"
 * @generated
 */
public interface ParameterPackage extends EPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany";

	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "parameter";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://sdq.ipd.uka.de/PalladioComponentModel/Parameter/4.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ParameterPackage eINSTANCE = de.uka.ipd.sdq.pcm.parameter.impl.ParameterPackageImpl.init();

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.pcm.parameter.impl.VariableSetterImpl <em>Variable Setter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pcm.parameter.impl.VariableSetterImpl
	 * @see de.uka.ipd.sdq.pcm.parameter.impl.ParameterPackageImpl#getVariableSetter()
	 * @generated
	 */
	int VARIABLE_SETTER = 0;

	/**
	 * The feature id for the '<em><b>Specification Variable Setter</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_SETTER__SPECIFICATION_VARIABLE_SETTER = 0;

	/**
	 * The feature id for the '<em><b>User Data Variable Setter</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_SETTER__USER_DATA_VARIABLE_SETTER = 1;

	/**
	 * The feature id for the '<em><b>Assembly Context Variable Setter</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_SETTER__ASSEMBLY_CONTEXT_VARIABLE_SETTER = 2;

	/**
	 * The feature id for the '<em><b>Entry Level System Call Input Variable Setter</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_SETTER__ENTRY_LEVEL_SYSTEM_CALL_INPUT_VARIABLE_SETTER = 3;

	/**
	 * The feature id for the '<em><b>Entry Level System Call Output Variable Setter</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_SETTER__ENTRY_LEVEL_SYSTEM_CALL_OUTPUT_VARIABLE_SETTER = 4;

	/**
	 * The feature id for the '<em><b>Call Action Variable Setter</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_SETTER__CALL_ACTION_VARIABLE_SETTER = 5;

	/**
	 * The feature id for the '<em><b>Synchronisation Point Variable Setter</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_SETTER__SYNCHRONISATION_POINT_VARIABLE_SETTER = 6;

	/**
	 * The feature id for the '<em><b>Call Return Action Variable Setter</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_SETTER__CALL_RETURN_ACTION_VARIABLE_SETTER = 7;

	/**
	 * The feature id for the '<em><b>Set Variable Action Variable Setter</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_SETTER__SET_VARIABLE_ACTION_VARIABLE_SETTER = 8;

	/**
	 * The feature id for the '<em><b>Specified Output Parameter Abstraction expected External Outputs Variable Setter</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_SETTER__SPECIFIED_OUTPUT_PARAMETER_ABSTRACTION_EXPECTED_EXTERNAL_OUTPUTS_VARIABLE_SETTER = 9;

	/**
	 * The feature id for the '<em><b>Variable Characteristic Variable Setter</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_SETTER__VARIABLE_CHARACTERISTIC_VARIABLE_SETTER = 10;

	/**
	 * The number of structural features of the '<em>Variable Setter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_SETTER_FEATURE_COUNT = 11;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.pcm.parameter.VariableCharacterisationType <em>Variable Characterisation Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pcm.parameter.VariableCharacterisationType
	 * @see de.uka.ipd.sdq.pcm.parameter.impl.ParameterPackageImpl#getVariableCharacterisationType()
	 * @generated
	 */
	int VARIABLE_CHARACTERISATION_TYPE = 3;


	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.pcm.parameter.VariableSetter <em>Variable Setter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Variable Setter</em>'.
	 * @see de.uka.ipd.sdq.pcm.parameter.VariableSetter
	 * @generated
	 */
	EClass getVariableSetter();

	/**
	 * Returns the meta object for the containment reference '{@link de.uka.ipd.sdq.pcm.parameter.VariableSetter#getSpecification__VariableSetter <em>Specification Variable Setter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Specification Variable Setter</em>'.
	 * @see de.uka.ipd.sdq.pcm.parameter.VariableSetter#getSpecification__VariableSetter()
	 * @see #getVariableSetter()
	 * @generated
	 */
	EReference getVariableSetter_Specification__VariableSetter();

	/**
	 * Returns the meta object for the container reference '{@link de.uka.ipd.sdq.pcm.parameter.VariableSetter#getUserData__VariableSetter <em>User Data Variable Setter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>User Data Variable Setter</em>'.
	 * @see de.uka.ipd.sdq.pcm.parameter.VariableSetter#getUserData__VariableSetter()
	 * @see #getVariableSetter()
	 * @generated
	 */
	EReference getVariableSetter_UserData__VariableSetter();

	/**
	 * Returns the meta object for the container reference '{@link de.uka.ipd.sdq.pcm.parameter.VariableSetter#getAssemblyContext__VariableSetter <em>Assembly Context Variable Setter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Assembly Context Variable Setter</em>'.
	 * @see de.uka.ipd.sdq.pcm.parameter.VariableSetter#getAssemblyContext__VariableSetter()
	 * @see #getVariableSetter()
	 * @generated
	 */
	EReference getVariableSetter_AssemblyContext__VariableSetter();

	/**
	 * Returns the meta object for the container reference '{@link de.uka.ipd.sdq.pcm.parameter.VariableSetter#getEntryLevelSystemCall__InputVariableSetter <em>Entry Level System Call Input Variable Setter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Entry Level System Call Input Variable Setter</em>'.
	 * @see de.uka.ipd.sdq.pcm.parameter.VariableSetter#getEntryLevelSystemCall__InputVariableSetter()
	 * @see #getVariableSetter()
	 * @generated
	 */
	EReference getVariableSetter_EntryLevelSystemCall__InputVariableSetter();

	/**
	 * Returns the meta object for the container reference '{@link de.uka.ipd.sdq.pcm.parameter.VariableSetter#getEntryLevelSystemCall__OutputVariableSetter <em>Entry Level System Call Output Variable Setter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Entry Level System Call Output Variable Setter</em>'.
	 * @see de.uka.ipd.sdq.pcm.parameter.VariableSetter#getEntryLevelSystemCall__OutputVariableSetter()
	 * @see #getVariableSetter()
	 * @generated
	 */
	EReference getVariableSetter_EntryLevelSystemCall__OutputVariableSetter();

	/**
	 * Returns the meta object for the container reference '{@link de.uka.ipd.sdq.pcm.parameter.VariableSetter#getCallAction__VariableSetter <em>Call Action Variable Setter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Call Action Variable Setter</em>'.
	 * @see de.uka.ipd.sdq.pcm.parameter.VariableSetter#getCallAction__VariableSetter()
	 * @see #getVariableSetter()
	 * @generated
	 */
	EReference getVariableSetter_CallAction__VariableSetter();

	/**
	 * Returns the meta object for the container reference '{@link de.uka.ipd.sdq.pcm.parameter.VariableSetter#getSynchronisationPoint__VariableSetter <em>Synchronisation Point Variable Setter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Synchronisation Point Variable Setter</em>'.
	 * @see de.uka.ipd.sdq.pcm.parameter.VariableSetter#getSynchronisationPoint__VariableSetter()
	 * @see #getVariableSetter()
	 * @generated
	 */
	EReference getVariableSetter_SynchronisationPoint__VariableSetter();

	/**
	 * Returns the meta object for the container reference '{@link de.uka.ipd.sdq.pcm.parameter.VariableSetter#getCallReturnAction__VariableSetter <em>Call Return Action Variable Setter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Call Return Action Variable Setter</em>'.
	 * @see de.uka.ipd.sdq.pcm.parameter.VariableSetter#getCallReturnAction__VariableSetter()
	 * @see #getVariableSetter()
	 * @generated
	 */
	EReference getVariableSetter_CallReturnAction__VariableSetter();

	/**
	 * Returns the meta object for the container reference '{@link de.uka.ipd.sdq.pcm.parameter.VariableSetter#getSetVariableAction__VariableSetter <em>Set Variable Action Variable Setter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Set Variable Action Variable Setter</em>'.
	 * @see de.uka.ipd.sdq.pcm.parameter.VariableSetter#getSetVariableAction__VariableSetter()
	 * @see #getVariableSetter()
	 * @generated
	 */
	EReference getVariableSetter_SetVariableAction__VariableSetter();

	/**
	 * Returns the meta object for the container reference '{@link de.uka.ipd.sdq.pcm.parameter.VariableSetter#getSpecifiedOutputParameterAbstraction_expectedExternalOutputs_VariableSetter <em>Specified Output Parameter Abstraction expected External Outputs Variable Setter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Specified Output Parameter Abstraction expected External Outputs Variable Setter</em>'.
	 * @see de.uka.ipd.sdq.pcm.parameter.VariableSetter#getSpecifiedOutputParameterAbstraction_expectedExternalOutputs_VariableSetter()
	 * @see #getVariableSetter()
	 * @generated
	 */
	EReference getVariableSetter_SpecifiedOutputParameterAbstraction_expectedExternalOutputs_VariableSetter();

	/**
	 * Returns the meta object for the reference '{@link de.uka.ipd.sdq.pcm.parameter.VariableSetter#getVariableCharacteristic__VariableSetter <em>Variable Characteristic Variable Setter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Variable Characteristic Variable Setter</em>'.
	 * @see de.uka.ipd.sdq.pcm.parameter.VariableSetter#getVariableCharacteristic__VariableSetter()
	 * @see #getVariableSetter()
	 * @generated
	 */
	EReference getVariableSetter_VariableCharacteristic__VariableSetter();

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.pcm.parameter.impl.VariableImpl <em>Variable</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pcm.parameter.impl.VariableImpl
	 * @see de.uka.ipd.sdq.pcm.parameter.impl.ParameterPackageImpl#getVariable()
	 * @generated
	 */
	int VARIABLE = 1;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE__ID = EntityPackage.ENTITY__ID;

	/**
	 * The feature id for the '<em><b>Entity Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE__ENTITY_NAME = EntityPackage.ENTITY__ENTITY_NAME;

	/**
	 * The feature id for the '<em><b>Implementation Component Type Variable</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE__IMPLEMENTATION_COMPONENT_TYPE_VARIABLE = EntityPackage.ENTITY_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Data Type Variable</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE__DATA_TYPE_VARIABLE = EntityPackage.ENTITY_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Composite Data Type Variable</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE__COMPOSITE_DATA_TYPE_VARIABLE = EntityPackage.ENTITY_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Resource Signature Variable</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE__RESOURCE_SIGNATURE_VARIABLE = EntityPackage.ENTITY_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Infrastructure Signature Variable</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE__INFRASTRUCTURE_SIGNATURE_VARIABLE = EntityPackage.ENTITY_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Event Type Variable</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE__EVENT_TYPE_VARIABLE = EntityPackage.ENTITY_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Variable Characteristics Variable</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE__VARIABLE_CHARACTERISTICS_VARIABLE = EntityPackage.ENTITY_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Operation Signature Variable</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE__OPERATION_SIGNATURE_VARIABLE = EntityPackage.ENTITY_FEATURE_COUNT + 7;

	/**
	 * The number of structural features of the '<em>Variable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_FEATURE_COUNT = EntityPackage.ENTITY_FEATURE_COUNT + 8;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.pcm.parameter.impl.VariableCharacteristicImpl <em>Variable Characteristic</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pcm.parameter.impl.VariableCharacteristicImpl
	 * @see de.uka.ipd.sdq.pcm.parameter.impl.ParameterPackageImpl#getVariableCharacteristic()
	 * @generated
	 */
	int VARIABLE_CHARACTERISTIC = 2;

	/**
	 * The feature id for the '<em><b>Id Variable</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_CHARACTERISTIC__ID_VARIABLE = StoexPackage.STO_EX_VARIABLE__ID_VARIABLE;

	/**
	 * The feature id for the '<em><b>Characterisation Definition Variable Characteristic</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_CHARACTERISTIC__CHARACTERISATION_DEFINITION_VARIABLE_CHARACTERISTIC = StoexPackage.STO_EX_VARIABLE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Variable Variable Characteristic</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_CHARACTERISTIC__VARIABLE_VARIABLE_CHARACTERISTIC = StoexPackage.STO_EX_VARIABLE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Variable Characteristic</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_CHARACTERISTIC_FEATURE_COUNT = StoexPackage.STO_EX_VARIABLE_FEATURE_COUNT + 2;

	/**
	 * Returns the meta object for enum '{@link de.uka.ipd.sdq.pcm.parameter.VariableCharacterisationType <em>Variable Characterisation Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Variable Characterisation Type</em>'.
	 * @see de.uka.ipd.sdq.pcm.parameter.VariableCharacterisationType
	 * @generated
	 */
	EEnum getVariableCharacterisationType();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.pcm.parameter.Variable <em>Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Variable</em>'.
	 * @see de.uka.ipd.sdq.pcm.parameter.Variable
	 * @generated
	 */
	EClass getVariable();

	/**
	 * Returns the meta object for the container reference '{@link de.uka.ipd.sdq.pcm.parameter.Variable#getImplementationComponentType__Variable <em>Implementation Component Type Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Implementation Component Type Variable</em>'.
	 * @see de.uka.ipd.sdq.pcm.parameter.Variable#getImplementationComponentType__Variable()
	 * @see #getVariable()
	 * @generated
	 */
	EReference getVariable_ImplementationComponentType__Variable();

	/**
	 * Returns the meta object for the container reference '{@link de.uka.ipd.sdq.pcm.parameter.Variable#getEventType__Variable <em>Event Type Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Event Type Variable</em>'.
	 * @see de.uka.ipd.sdq.pcm.parameter.Variable#getEventType__Variable()
	 * @see #getVariable()
	 * @generated
	 */
	EReference getVariable_EventType__Variable();

	/**
	 * Returns the meta object for the containment reference list '{@link de.uka.ipd.sdq.pcm.parameter.Variable#getVariableCharacteristics__Variable <em>Variable Characteristics Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Variable Characteristics Variable</em>'.
	 * @see de.uka.ipd.sdq.pcm.parameter.Variable#getVariableCharacteristics__Variable()
	 * @see #getVariable()
	 * @generated
	 */
	EReference getVariable_VariableCharacteristics__Variable();

	/**
	 * Returns the meta object for the reference '{@link de.uka.ipd.sdq.pcm.parameter.Variable#getDataType__Variable <em>Data Type Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Data Type Variable</em>'.
	 * @see de.uka.ipd.sdq.pcm.parameter.Variable#getDataType__Variable()
	 * @see #getVariable()
	 * @generated
	 */
	EReference getVariable_DataType__Variable();

	/**
	 * Returns the meta object for the container reference '{@link de.uka.ipd.sdq.pcm.parameter.Variable#getCompositeDataType__Variable <em>Composite Data Type Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Composite Data Type Variable</em>'.
	 * @see de.uka.ipd.sdq.pcm.parameter.Variable#getCompositeDataType__Variable()
	 * @see #getVariable()
	 * @generated
	 */
	EReference getVariable_CompositeDataType__Variable();

	/**
	 * Returns the meta object for the container reference '{@link de.uka.ipd.sdq.pcm.parameter.Variable#getResourceSignature__Variable <em>Resource Signature Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Resource Signature Variable</em>'.
	 * @see de.uka.ipd.sdq.pcm.parameter.Variable#getResourceSignature__Variable()
	 * @see #getVariable()
	 * @generated
	 */
	EReference getVariable_ResourceSignature__Variable();

	/**
	 * Returns the meta object for the container reference '{@link de.uka.ipd.sdq.pcm.parameter.Variable#getInfrastructureSignature__Variable <em>Infrastructure Signature Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Infrastructure Signature Variable</em>'.
	 * @see de.uka.ipd.sdq.pcm.parameter.Variable#getInfrastructureSignature__Variable()
	 * @see #getVariable()
	 * @generated
	 */
	EReference getVariable_InfrastructureSignature__Variable();

	/**
	 * Returns the meta object for the container reference '{@link de.uka.ipd.sdq.pcm.parameter.Variable#getOperationSignature__Variable <em>Operation Signature Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Operation Signature Variable</em>'.
	 * @see de.uka.ipd.sdq.pcm.parameter.Variable#getOperationSignature__Variable()
	 * @see #getVariable()
	 * @generated
	 */
	EReference getVariable_OperationSignature__Variable();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.pcm.parameter.VariableCharacteristic <em>Variable Characteristic</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Variable Characteristic</em>'.
	 * @see de.uka.ipd.sdq.pcm.parameter.VariableCharacteristic
	 * @generated
	 */
	EClass getVariableCharacteristic();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.pcm.parameter.VariableCharacteristic#getCharacterisationDefinition__VariableCharacteristic <em>Characterisation Definition Variable Characteristic</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Characterisation Definition Variable Characteristic</em>'.
	 * @see de.uka.ipd.sdq.pcm.parameter.VariableCharacteristic#getCharacterisationDefinition__VariableCharacteristic()
	 * @see #getVariableCharacteristic()
	 * @generated
	 */
	EAttribute getVariableCharacteristic_CharacterisationDefinition__VariableCharacteristic();

	/**
	 * Returns the meta object for the container reference '{@link de.uka.ipd.sdq.pcm.parameter.VariableCharacteristic#getVariable__VariableCharacteristic <em>Variable Variable Characteristic</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Variable Variable Characteristic</em>'.
	 * @see de.uka.ipd.sdq.pcm.parameter.VariableCharacteristic#getVariable__VariableCharacteristic()
	 * @see #getVariableCharacteristic()
	 * @generated
	 */
	EReference getVariableCharacteristic_Variable__VariableCharacteristic();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ParameterFactory getParameterFactory();

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
		 * The meta object literal for the '{@link de.uka.ipd.sdq.pcm.parameter.impl.VariableSetterImpl <em>Variable Setter</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.pcm.parameter.impl.VariableSetterImpl
		 * @see de.uka.ipd.sdq.pcm.parameter.impl.ParameterPackageImpl#getVariableSetter()
		 * @generated
		 */
		EClass VARIABLE_SETTER = eINSTANCE.getVariableSetter();

		/**
		 * The meta object literal for the '<em><b>Specification Variable Setter</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VARIABLE_SETTER__SPECIFICATION_VARIABLE_SETTER = eINSTANCE.getVariableSetter_Specification__VariableSetter();

		/**
		 * The meta object literal for the '<em><b>User Data Variable Setter</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VARIABLE_SETTER__USER_DATA_VARIABLE_SETTER = eINSTANCE.getVariableSetter_UserData__VariableSetter();

		/**
		 * The meta object literal for the '<em><b>Assembly Context Variable Setter</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VARIABLE_SETTER__ASSEMBLY_CONTEXT_VARIABLE_SETTER = eINSTANCE.getVariableSetter_AssemblyContext__VariableSetter();

		/**
		 * The meta object literal for the '<em><b>Entry Level System Call Input Variable Setter</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VARIABLE_SETTER__ENTRY_LEVEL_SYSTEM_CALL_INPUT_VARIABLE_SETTER = eINSTANCE.getVariableSetter_EntryLevelSystemCall__InputVariableSetter();

		/**
		 * The meta object literal for the '<em><b>Entry Level System Call Output Variable Setter</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VARIABLE_SETTER__ENTRY_LEVEL_SYSTEM_CALL_OUTPUT_VARIABLE_SETTER = eINSTANCE.getVariableSetter_EntryLevelSystemCall__OutputVariableSetter();

		/**
		 * The meta object literal for the '<em><b>Call Action Variable Setter</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VARIABLE_SETTER__CALL_ACTION_VARIABLE_SETTER = eINSTANCE.getVariableSetter_CallAction__VariableSetter();

		/**
		 * The meta object literal for the '<em><b>Synchronisation Point Variable Setter</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VARIABLE_SETTER__SYNCHRONISATION_POINT_VARIABLE_SETTER = eINSTANCE.getVariableSetter_SynchronisationPoint__VariableSetter();

		/**
		 * The meta object literal for the '<em><b>Call Return Action Variable Setter</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VARIABLE_SETTER__CALL_RETURN_ACTION_VARIABLE_SETTER = eINSTANCE.getVariableSetter_CallReturnAction__VariableSetter();

		/**
		 * The meta object literal for the '<em><b>Set Variable Action Variable Setter</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VARIABLE_SETTER__SET_VARIABLE_ACTION_VARIABLE_SETTER = eINSTANCE.getVariableSetter_SetVariableAction__VariableSetter();

		/**
		 * The meta object literal for the '<em><b>Specified Output Parameter Abstraction expected External Outputs Variable Setter</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VARIABLE_SETTER__SPECIFIED_OUTPUT_PARAMETER_ABSTRACTION_EXPECTED_EXTERNAL_OUTPUTS_VARIABLE_SETTER = eINSTANCE.getVariableSetter_SpecifiedOutputParameterAbstraction_expectedExternalOutputs_VariableSetter();

		/**
		 * The meta object literal for the '<em><b>Variable Characteristic Variable Setter</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VARIABLE_SETTER__VARIABLE_CHARACTERISTIC_VARIABLE_SETTER = eINSTANCE.getVariableSetter_VariableCharacteristic__VariableSetter();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.pcm.parameter.VariableCharacterisationType <em>Variable Characterisation Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.pcm.parameter.VariableCharacterisationType
		 * @see de.uka.ipd.sdq.pcm.parameter.impl.ParameterPackageImpl#getVariableCharacterisationType()
		 * @generated
		 */
		EEnum VARIABLE_CHARACTERISATION_TYPE = eINSTANCE.getVariableCharacterisationType();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.pcm.parameter.impl.VariableImpl <em>Variable</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.pcm.parameter.impl.VariableImpl
		 * @see de.uka.ipd.sdq.pcm.parameter.impl.ParameterPackageImpl#getVariable()
		 * @generated
		 */
		EClass VARIABLE = eINSTANCE.getVariable();

		/**
		 * The meta object literal for the '<em><b>Event Type Variable</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VARIABLE__EVENT_TYPE_VARIABLE = eINSTANCE.getVariable_EventType__Variable();

		/**
		 * The meta object literal for the '<em><b>Variable Characteristics Variable</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VARIABLE__VARIABLE_CHARACTERISTICS_VARIABLE = eINSTANCE.getVariable_VariableCharacteristics__Variable();

		/**
		 * The meta object literal for the '<em><b>Implementation Component Type Variable</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VARIABLE__IMPLEMENTATION_COMPONENT_TYPE_VARIABLE = eINSTANCE.getVariable_ImplementationComponentType__Variable();

		/**
		 * The meta object literal for the '<em><b>Data Type Variable</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VARIABLE__DATA_TYPE_VARIABLE = eINSTANCE.getVariable_DataType__Variable();

		/**
		 * The meta object literal for the '<em><b>Composite Data Type Variable</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VARIABLE__COMPOSITE_DATA_TYPE_VARIABLE = eINSTANCE.getVariable_CompositeDataType__Variable();

		/**
		 * The meta object literal for the '<em><b>Resource Signature Variable</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VARIABLE__RESOURCE_SIGNATURE_VARIABLE = eINSTANCE.getVariable_ResourceSignature__Variable();

		/**
		 * The meta object literal for the '<em><b>Infrastructure Signature Variable</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VARIABLE__INFRASTRUCTURE_SIGNATURE_VARIABLE = eINSTANCE.getVariable_InfrastructureSignature__Variable();

		/**
		 * The meta object literal for the '<em><b>Operation Signature Variable</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VARIABLE__OPERATION_SIGNATURE_VARIABLE = eINSTANCE.getVariable_OperationSignature__Variable();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.pcm.parameter.impl.VariableCharacteristicImpl <em>Variable Characteristic</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.pcm.parameter.impl.VariableCharacteristicImpl
		 * @see de.uka.ipd.sdq.pcm.parameter.impl.ParameterPackageImpl#getVariableCharacteristic()
		 * @generated
		 */
		EClass VARIABLE_CHARACTERISTIC = eINSTANCE.getVariableCharacteristic();

		/**
		 * The meta object literal for the '<em><b>Characterisation Definition Variable Characteristic</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VARIABLE_CHARACTERISTIC__CHARACTERISATION_DEFINITION_VARIABLE_CHARACTERISTIC = eINSTANCE.getVariableCharacteristic_CharacterisationDefinition__VariableCharacteristic();

		/**
		 * The meta object literal for the '<em><b>Variable Variable Characteristic</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VARIABLE_CHARACTERISTIC__VARIABLE_VARIABLE_CHARACTERISTIC = eINSTANCE.getVariableCharacteristic_Variable__VariableCharacteristic();

	}

} //ParameterPackage
