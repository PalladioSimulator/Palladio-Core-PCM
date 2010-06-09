/**
 * Copyright 2007 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.parameter;

import de.uka.ipd.sdq.pcm.core.entity.EntityPackage;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

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
	 * The meta object id for the '{@link de.uka.ipd.sdq.pcm.parameter.impl.SetVariableImpl <em>Set Variable</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pcm.parameter.impl.SetVariableImpl
	 * @see de.uka.ipd.sdq.pcm.parameter.impl.ParameterPackageImpl#getSetVariable()
	 * @generated
	 */
	int SET_VARIABLE = 0;

	/**
	 * The feature id for the '<em><b>Variable Characterisation Variable Usage</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_VARIABLE__VARIABLE_CHARACTERISATION_VARIABLE_USAGE = 0;

	/**
	 * The feature id for the '<em><b>User Data Variable Usage</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_VARIABLE__USER_DATA_VARIABLE_USAGE = 1;

	/**
	 * The feature id for the '<em><b>Assembly Context Variable Usage</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_VARIABLE__ASSEMBLY_CONTEXT_VARIABLE_USAGE = 2;

	/**
	 * The feature id for the '<em><b>Entry Level System Call Input Parameter Usage</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_VARIABLE__ENTRY_LEVEL_SYSTEM_CALL_INPUT_PARAMETER_USAGE = 3;

	/**
	 * The feature id for the '<em><b>Entry Level System Call Output Parameter Usage</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_VARIABLE__ENTRY_LEVEL_SYSTEM_CALL_OUTPUT_PARAMETER_USAGE = 4;

	/**
	 * The feature id for the '<em><b>Call Action Set Variable</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_VARIABLE__CALL_ACTION_SET_VARIABLE = 5;

	/**
	 * The feature id for the '<em><b>Synchronisation Point Variable Usage</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_VARIABLE__SYNCHRONISATION_POINT_VARIABLE_USAGE = 6;

	/**
	 * The feature id for the '<em><b>Call Return Action Set Variable</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_VARIABLE__CALL_RETURN_ACTION_SET_VARIABLE = 7;

	/**
	 * The feature id for the '<em><b>Set Variable Action Variable Usage</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_VARIABLE__SET_VARIABLE_ACTION_VARIABLE_USAGE = 8;

	/**
	 * The feature id for the '<em><b>Specified Output Parameter Abstraction expected External Outputs Variable Usage</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_VARIABLE__SPECIFIED_OUTPUT_PARAMETER_ABSTRACTION_EXPECTED_EXTERNAL_OUTPUTS_VARIABLE_USAGE = 9;

	/**
	 * The feature id for the '<em><b>Variable Variable Usage</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_VARIABLE__VARIABLE_VARIABLE_USAGE = 10;

	/**
	 * The number of structural features of the '<em>Set Variable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_VARIABLE_FEATURE_COUNT = 11;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.pcm.parameter.impl.VariableCharacterisationImpl <em>Variable Characterisation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pcm.parameter.impl.VariableCharacterisationImpl
	 * @see de.uka.ipd.sdq.pcm.parameter.impl.ParameterPackageImpl#getVariableCharacterisation()
	 * @generated
	 */
	int VARIABLE_CHARACTERISATION = 1;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.pcm.parameter.impl.CharacterisedVariableImpl <em>Characterised Variable</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pcm.parameter.impl.CharacterisedVariableImpl
	 * @see de.uka.ipd.sdq.pcm.parameter.impl.ParameterPackageImpl#getCharacterisedVariable()
	 * @generated
	 */
	int CHARACTERISED_VARIABLE = 2;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_CHARACTERISATION__TYPE = 0;

	/**
	 * The feature id for the '<em><b>Specification Variable Characterisation</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_CHARACTERISATION__SPECIFICATION_VARIABLE_CHARACTERISATION = 1;

	/**
	 * The feature id for the '<em><b>Variable Usage Variable Characterisation</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_CHARACTERISATION__VARIABLE_USAGE_VARIABLE_CHARACTERISATION = 2;

	/**
	 * The number of structural features of the '<em>Variable Characterisation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_CHARACTERISATION_FEATURE_COUNT = 3;

	/**
	 * The feature id for the '<em><b>Id Variable</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHARACTERISED_VARIABLE__ID_VARIABLE = StoexPackage.VARIABLE__ID_VARIABLE;

	/**
	 * The feature id for the '<em><b>Variable</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHARACTERISED_VARIABLE__VARIABLE = StoexPackage.VARIABLE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Characterisation Definition</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHARACTERISED_VARIABLE__CHARACTERISATION_DEFINITION = StoexPackage.VARIABLE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Characterised Variable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHARACTERISED_VARIABLE_FEATURE_COUNT = StoexPackage.VARIABLE_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.pcm.parameter.impl.VariableImpl <em>Variable</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pcm.parameter.impl.VariableImpl
	 * @see de.uka.ipd.sdq.pcm.parameter.impl.ParameterPackageImpl#getVariable()
	 * @generated
	 */
	int VARIABLE = 3;

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
	 * The feature id for the '<em><b>Event Type Variable</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE__EVENT_TYPE_VARIABLE = EntityPackage.ENTITY_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Implementation Component Type Variable</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE__IMPLEMENTATION_COMPONENT_TYPE_VARIABLE = EntityPackage.ENTITY_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Data Type Variable</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE__DATA_TYPE_VARIABLE = EntityPackage.ENTITY_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Composite Data Type Variable</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE__COMPOSITE_DATA_TYPE_VARIABLE = EntityPackage.ENTITY_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Resource Signature Variable</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE__RESOURCE_SIGNATURE_VARIABLE = EntityPackage.ENTITY_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Infrastructure Signature Variable</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE__INFRASTRUCTURE_SIGNATURE_VARIABLE = EntityPackage.ENTITY_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Operation Signature Variable</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE__OPERATION_SIGNATURE_VARIABLE = EntityPackage.ENTITY_FEATURE_COUNT + 6;

	/**
	 * The number of structural features of the '<em>Variable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_FEATURE_COUNT = EntityPackage.ENTITY_FEATURE_COUNT + 7;


	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.pcm.parameter.SetVariable <em>Set Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Set Variable</em>'.
	 * @see de.uka.ipd.sdq.pcm.parameter.SetVariable
	 * @generated
	 */
	EClass getSetVariable();

	/**
	 * Returns the meta object for the containment reference list '{@link de.uka.ipd.sdq.pcm.parameter.SetVariable#getVariableCharacterisation_VariableUsage <em>Variable Characterisation Variable Usage</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Variable Characterisation Variable Usage</em>'.
	 * @see de.uka.ipd.sdq.pcm.parameter.SetVariable#getVariableCharacterisation_VariableUsage()
	 * @see #getSetVariable()
	 * @generated
	 */
	EReference getSetVariable_VariableCharacterisation_VariableUsage();

	/**
	 * Returns the meta object for the container reference '{@link de.uka.ipd.sdq.pcm.parameter.SetVariable#getUserData_VariableUsage <em>User Data Variable Usage</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>User Data Variable Usage</em>'.
	 * @see de.uka.ipd.sdq.pcm.parameter.SetVariable#getUserData_VariableUsage()
	 * @see #getSetVariable()
	 * @generated
	 */
	EReference getSetVariable_UserData_VariableUsage();

	/**
	 * Returns the meta object for the container reference '{@link de.uka.ipd.sdq.pcm.parameter.SetVariable#getAssemblyContext_VariableUsage <em>Assembly Context Variable Usage</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Assembly Context Variable Usage</em>'.
	 * @see de.uka.ipd.sdq.pcm.parameter.SetVariable#getAssemblyContext_VariableUsage()
	 * @see #getSetVariable()
	 * @generated
	 */
	EReference getSetVariable_AssemblyContext_VariableUsage();

	/**
	 * Returns the meta object for the container reference '{@link de.uka.ipd.sdq.pcm.parameter.SetVariable#getEntryLevelSystemCall_InputParameterUsage <em>Entry Level System Call Input Parameter Usage</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Entry Level System Call Input Parameter Usage</em>'.
	 * @see de.uka.ipd.sdq.pcm.parameter.SetVariable#getEntryLevelSystemCall_InputParameterUsage()
	 * @see #getSetVariable()
	 * @generated
	 */
	EReference getSetVariable_EntryLevelSystemCall_InputParameterUsage();

	/**
	 * Returns the meta object for the container reference '{@link de.uka.ipd.sdq.pcm.parameter.SetVariable#getEntryLevelSystemCall_OutputParameterUsage <em>Entry Level System Call Output Parameter Usage</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Entry Level System Call Output Parameter Usage</em>'.
	 * @see de.uka.ipd.sdq.pcm.parameter.SetVariable#getEntryLevelSystemCall_OutputParameterUsage()
	 * @see #getSetVariable()
	 * @generated
	 */
	EReference getSetVariable_EntryLevelSystemCall_OutputParameterUsage();

	/**
	 * Returns the meta object for the container reference '{@link de.uka.ipd.sdq.pcm.parameter.SetVariable#getCallAction__SetVariable <em>Call Action Set Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Call Action Set Variable</em>'.
	 * @see de.uka.ipd.sdq.pcm.parameter.SetVariable#getCallAction__SetVariable()
	 * @see #getSetVariable()
	 * @generated
	 */
	EReference getSetVariable_CallAction__SetVariable();

	/**
	 * Returns the meta object for the container reference '{@link de.uka.ipd.sdq.pcm.parameter.SetVariable#getSynchronisationPoint_VariableUsage <em>Synchronisation Point Variable Usage</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Synchronisation Point Variable Usage</em>'.
	 * @see de.uka.ipd.sdq.pcm.parameter.SetVariable#getSynchronisationPoint_VariableUsage()
	 * @see #getSetVariable()
	 * @generated
	 */
	EReference getSetVariable_SynchronisationPoint_VariableUsage();

	/**
	 * Returns the meta object for the container reference '{@link de.uka.ipd.sdq.pcm.parameter.SetVariable#getCallReturnAction__SetVariable <em>Call Return Action Set Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Call Return Action Set Variable</em>'.
	 * @see de.uka.ipd.sdq.pcm.parameter.SetVariable#getCallReturnAction__SetVariable()
	 * @see #getSetVariable()
	 * @generated
	 */
	EReference getSetVariable_CallReturnAction__SetVariable();

	/**
	 * Returns the meta object for the container reference '{@link de.uka.ipd.sdq.pcm.parameter.SetVariable#getSetVariableAction_VariableUsage <em>Set Variable Action Variable Usage</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Set Variable Action Variable Usage</em>'.
	 * @see de.uka.ipd.sdq.pcm.parameter.SetVariable#getSetVariableAction_VariableUsage()
	 * @see #getSetVariable()
	 * @generated
	 */
	EReference getSetVariable_SetVariableAction_VariableUsage();

	/**
	 * Returns the meta object for the container reference '{@link de.uka.ipd.sdq.pcm.parameter.SetVariable#getSpecifiedOutputParameterAbstraction_expectedExternalOutputs_VariableUsage <em>Specified Output Parameter Abstraction expected External Outputs Variable Usage</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Specified Output Parameter Abstraction expected External Outputs Variable Usage</em>'.
	 * @see de.uka.ipd.sdq.pcm.parameter.SetVariable#getSpecifiedOutputParameterAbstraction_expectedExternalOutputs_VariableUsage()
	 * @see #getSetVariable()
	 * @generated
	 */
	EReference getSetVariable_SpecifiedOutputParameterAbstraction_expectedExternalOutputs_VariableUsage();

	/**
	 * Returns the meta object for the reference '{@link de.uka.ipd.sdq.pcm.parameter.SetVariable#getVariable_VariableUsage <em>Variable Variable Usage</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Variable Variable Usage</em>'.
	 * @see de.uka.ipd.sdq.pcm.parameter.SetVariable#getVariable_VariableUsage()
	 * @see #getSetVariable()
	 * @generated
	 */
	EReference getSetVariable_Variable_VariableUsage();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.pcm.parameter.VariableCharacterisation <em>Variable Characterisation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Variable Characterisation</em>'.
	 * @see de.uka.ipd.sdq.pcm.parameter.VariableCharacterisation
	 * @generated
	 */
	EClass getVariableCharacterisation();

	/**
	 * Returns the meta object for the reference '{@link de.uka.ipd.sdq.pcm.parameter.VariableCharacterisation#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Type</em>'.
	 * @see de.uka.ipd.sdq.pcm.parameter.VariableCharacterisation#getType()
	 * @see #getVariableCharacterisation()
	 * @generated
	 */
	EReference getVariableCharacterisation_Type();

	/**
	 * Returns the meta object for the containment reference '{@link de.uka.ipd.sdq.pcm.parameter.VariableCharacterisation#getSpecification_VariableCharacterisation <em>Specification Variable Characterisation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Specification Variable Characterisation</em>'.
	 * @see de.uka.ipd.sdq.pcm.parameter.VariableCharacterisation#getSpecification_VariableCharacterisation()
	 * @see #getVariableCharacterisation()
	 * @generated
	 */
	EReference getVariableCharacterisation_Specification_VariableCharacterisation();

	/**
	 * Returns the meta object for the container reference '{@link de.uka.ipd.sdq.pcm.parameter.VariableCharacterisation#getVariableUsage_VariableCharacterisation <em>Variable Usage Variable Characterisation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Variable Usage Variable Characterisation</em>'.
	 * @see de.uka.ipd.sdq.pcm.parameter.VariableCharacterisation#getVariableUsage_VariableCharacterisation()
	 * @see #getVariableCharacterisation()
	 * @generated
	 */
	EReference getVariableCharacterisation_VariableUsage_VariableCharacterisation();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.pcm.parameter.CharacterisedVariable <em>Characterised Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Characterised Variable</em>'.
	 * @see de.uka.ipd.sdq.pcm.parameter.CharacterisedVariable
	 * @generated
	 */
	EClass getCharacterisedVariable();

	/**
	 * Returns the meta object for the reference '{@link de.uka.ipd.sdq.pcm.parameter.CharacterisedVariable#getVariable <em>Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Variable</em>'.
	 * @see de.uka.ipd.sdq.pcm.parameter.CharacterisedVariable#getVariable()
	 * @see #getCharacterisedVariable()
	 * @generated
	 */
	EReference getCharacterisedVariable_Variable();

	/**
	 * Returns the meta object for the reference '{@link de.uka.ipd.sdq.pcm.parameter.CharacterisedVariable#getCharacterisationDefinition <em>Characterisation Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Characterisation Definition</em>'.
	 * @see de.uka.ipd.sdq.pcm.parameter.CharacterisedVariable#getCharacterisationDefinition()
	 * @see #getCharacterisedVariable()
	 * @generated
	 */
	EReference getCharacterisedVariable_CharacterisationDefinition();

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
	 * Returns the meta object for the container reference '{@link de.uka.ipd.sdq.pcm.parameter.Variable#getImplementationComponentType_Variable <em>Implementation Component Type Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Implementation Component Type Variable</em>'.
	 * @see de.uka.ipd.sdq.pcm.parameter.Variable#getImplementationComponentType_Variable()
	 * @see #getVariable()
	 * @generated
	 */
	EReference getVariable_ImplementationComponentType_Variable();

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
	 * Returns the meta object for the container reference '{@link de.uka.ipd.sdq.pcm.parameter.Variable#getCompositeDataType_Variable <em>Composite Data Type Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Composite Data Type Variable</em>'.
	 * @see de.uka.ipd.sdq.pcm.parameter.Variable#getCompositeDataType_Variable()
	 * @see #getVariable()
	 * @generated
	 */
	EReference getVariable_CompositeDataType_Variable();

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
		 * The meta object literal for the '{@link de.uka.ipd.sdq.pcm.parameter.impl.SetVariableImpl <em>Set Variable</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.pcm.parameter.impl.SetVariableImpl
		 * @see de.uka.ipd.sdq.pcm.parameter.impl.ParameterPackageImpl#getSetVariable()
		 * @generated
		 */
		EClass SET_VARIABLE = eINSTANCE.getSetVariable();

		/**
		 * The meta object literal for the '<em><b>Variable Characterisation Variable Usage</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SET_VARIABLE__VARIABLE_CHARACTERISATION_VARIABLE_USAGE = eINSTANCE.getSetVariable_VariableCharacterisation_VariableUsage();

		/**
		 * The meta object literal for the '<em><b>User Data Variable Usage</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SET_VARIABLE__USER_DATA_VARIABLE_USAGE = eINSTANCE.getSetVariable_UserData_VariableUsage();

		/**
		 * The meta object literal for the '<em><b>Assembly Context Variable Usage</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SET_VARIABLE__ASSEMBLY_CONTEXT_VARIABLE_USAGE = eINSTANCE.getSetVariable_AssemblyContext_VariableUsage();

		/**
		 * The meta object literal for the '<em><b>Entry Level System Call Input Parameter Usage</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SET_VARIABLE__ENTRY_LEVEL_SYSTEM_CALL_INPUT_PARAMETER_USAGE = eINSTANCE.getSetVariable_EntryLevelSystemCall_InputParameterUsage();

		/**
		 * The meta object literal for the '<em><b>Entry Level System Call Output Parameter Usage</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SET_VARIABLE__ENTRY_LEVEL_SYSTEM_CALL_OUTPUT_PARAMETER_USAGE = eINSTANCE.getSetVariable_EntryLevelSystemCall_OutputParameterUsage();

		/**
		 * The meta object literal for the '<em><b>Call Action Set Variable</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SET_VARIABLE__CALL_ACTION_SET_VARIABLE = eINSTANCE.getSetVariable_CallAction__SetVariable();

		/**
		 * The meta object literal for the '<em><b>Synchronisation Point Variable Usage</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SET_VARIABLE__SYNCHRONISATION_POINT_VARIABLE_USAGE = eINSTANCE.getSetVariable_SynchronisationPoint_VariableUsage();

		/**
		 * The meta object literal for the '<em><b>Call Return Action Set Variable</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SET_VARIABLE__CALL_RETURN_ACTION_SET_VARIABLE = eINSTANCE.getSetVariable_CallReturnAction__SetVariable();

		/**
		 * The meta object literal for the '<em><b>Set Variable Action Variable Usage</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SET_VARIABLE__SET_VARIABLE_ACTION_VARIABLE_USAGE = eINSTANCE.getSetVariable_SetVariableAction_VariableUsage();

		/**
		 * The meta object literal for the '<em><b>Specified Output Parameter Abstraction expected External Outputs Variable Usage</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SET_VARIABLE__SPECIFIED_OUTPUT_PARAMETER_ABSTRACTION_EXPECTED_EXTERNAL_OUTPUTS_VARIABLE_USAGE = eINSTANCE.getSetVariable_SpecifiedOutputParameterAbstraction_expectedExternalOutputs_VariableUsage();

		/**
		 * The meta object literal for the '<em><b>Variable Variable Usage</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SET_VARIABLE__VARIABLE_VARIABLE_USAGE = eINSTANCE.getSetVariable_Variable_VariableUsage();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.pcm.parameter.impl.VariableCharacterisationImpl <em>Variable Characterisation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.pcm.parameter.impl.VariableCharacterisationImpl
		 * @see de.uka.ipd.sdq.pcm.parameter.impl.ParameterPackageImpl#getVariableCharacterisation()
		 * @generated
		 */
		EClass VARIABLE_CHARACTERISATION = eINSTANCE.getVariableCharacterisation();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VARIABLE_CHARACTERISATION__TYPE = eINSTANCE.getVariableCharacterisation_Type();

		/**
		 * The meta object literal for the '<em><b>Specification Variable Characterisation</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VARIABLE_CHARACTERISATION__SPECIFICATION_VARIABLE_CHARACTERISATION = eINSTANCE.getVariableCharacterisation_Specification_VariableCharacterisation();

		/**
		 * The meta object literal for the '<em><b>Variable Usage Variable Characterisation</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VARIABLE_CHARACTERISATION__VARIABLE_USAGE_VARIABLE_CHARACTERISATION = eINSTANCE.getVariableCharacterisation_VariableUsage_VariableCharacterisation();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.pcm.parameter.impl.CharacterisedVariableImpl <em>Characterised Variable</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.pcm.parameter.impl.CharacterisedVariableImpl
		 * @see de.uka.ipd.sdq.pcm.parameter.impl.ParameterPackageImpl#getCharacterisedVariable()
		 * @generated
		 */
		EClass CHARACTERISED_VARIABLE = eINSTANCE.getCharacterisedVariable();

		/**
		 * The meta object literal for the '<em><b>Variable</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CHARACTERISED_VARIABLE__VARIABLE = eINSTANCE.getCharacterisedVariable_Variable();

		/**
		 * The meta object literal for the '<em><b>Characterisation Definition</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CHARACTERISED_VARIABLE__CHARACTERISATION_DEFINITION = eINSTANCE.getCharacterisedVariable_CharacterisationDefinition();

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
		 * The meta object literal for the '<em><b>Implementation Component Type Variable</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VARIABLE__IMPLEMENTATION_COMPONENT_TYPE_VARIABLE = eINSTANCE.getVariable_ImplementationComponentType_Variable();

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
		EReference VARIABLE__COMPOSITE_DATA_TYPE_VARIABLE = eINSTANCE.getVariable_CompositeDataType_Variable();

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

	}

} //ParameterPackage
