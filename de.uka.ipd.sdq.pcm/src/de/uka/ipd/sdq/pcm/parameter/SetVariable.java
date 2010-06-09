/**
 * Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.parameter;

import de.uka.ipd.sdq.pcm.core.composition.AssemblyContext;

import de.uka.ipd.sdq.pcm.qosannotations.SpecifiedOutputParameterAbstraction;

import de.uka.ipd.sdq.pcm.seff.CallAction;
import de.uka.ipd.sdq.pcm.seff.CallReturnAction;
import de.uka.ipd.sdq.pcm.seff.SetVariableAction;
import de.uka.ipd.sdq.pcm.seff.SynchronisationPoint;

import de.uka.ipd.sdq.pcm.usagemodel.EntryLevelSystemCall;
import de.uka.ipd.sdq.pcm.usagemodel.UserData;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Set Variable</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * <p>
 *     SetVariable is used to set the characterisations of a Variable to certain values. Each of the set characterisations and
 *     the values are referenced via VariableCharacterisation. The deprecated name of this element was VariableUsage.
 * </p>
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.parameter.SetVariable#getVariableCharacterisation_VariableUsage <em>Variable Characterisation Variable Usage</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.parameter.SetVariable#getUserData_VariableUsage <em>User Data Variable Usage</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.parameter.SetVariable#getAssemblyContext_VariableUsage <em>Assembly Context Variable Usage</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.parameter.SetVariable#getEntryLevelSystemCall_InputParameterUsage <em>Entry Level System Call Input Parameter Usage</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.parameter.SetVariable#getEntryLevelSystemCall_OutputParameterUsage <em>Entry Level System Call Output Parameter Usage</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.parameter.SetVariable#getCallAction__SetVariable <em>Call Action Set Variable</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.parameter.SetVariable#getSynchronisationPoint_VariableUsage <em>Synchronisation Point Variable Usage</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.parameter.SetVariable#getCallReturnAction__SetVariable <em>Call Return Action Set Variable</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.parameter.SetVariable#getSetVariableAction_VariableUsage <em>Set Variable Action Variable Usage</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.parameter.SetVariable#getSpecifiedOutputParameterAbstraction_expectedExternalOutputs_VariableUsage <em>Specified Output Parameter Abstraction expected External Outputs Variable Usage</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.parameter.SetVariable#getVariable_VariableUsage <em>Variable Variable Usage</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.pcm.parameter.ParameterPackage#getSetVariable()
 * @model
 * @generated
 */
public interface SetVariable extends EObject {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany";

	/**
	 * Returns the value of the '<em><b>Variable Characterisation Variable Usage</b></em>' containment reference list.
	 * The list contents are of type {@link de.uka.ipd.sdq.pcm.parameter.VariableCharacterisation}.
	 * It is bidirectional and its opposite is '{@link de.uka.ipd.sdq.pcm.parameter.VariableCharacterisation#getVariableUsage_VariableCharacterisation <em>Variable Usage Variable Characterisation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * This association contains the information which abstract information on a specific variable is available. For example, whether we know something on the variable's value, its structure or memory footprint. There can be multiple characterisations of the same variable if more than one type of information is available.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Variable Characterisation Variable Usage</em>' containment reference list.
	 * @see de.uka.ipd.sdq.pcm.parameter.ParameterPackage#getSetVariable_VariableCharacterisation_VariableUsage()
	 * @see de.uka.ipd.sdq.pcm.parameter.VariableCharacterisation#getVariableUsage_VariableCharacterisation
	 * @model opposite="variableUsage_VariableCharacterisation" containment="true" ordered="false"
	 * @generated
	 */
	EList<VariableCharacterisation> getVariableCharacterisation_VariableUsage();

	/**
	 * Returns the value of the '<em><b>User Data Variable Usage</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.uka.ipd.sdq.pcm.usagemodel.UserData#getUserDataParameterUsages_UserData <em>User Data Parameter Usages User Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>User Data Variable Usage</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>User Data Variable Usage</em>' container reference.
	 * @see #setUserData_VariableUsage(UserData)
	 * @see de.uka.ipd.sdq.pcm.parameter.ParameterPackage#getSetVariable_UserData_VariableUsage()
	 * @see de.uka.ipd.sdq.pcm.usagemodel.UserData#getUserDataParameterUsages_UserData
	 * @model opposite="userDataParameterUsages_UserData" transient="false" ordered="false"
	 * @generated
	 */
	UserData getUserData_VariableUsage();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.parameter.SetVariable#getUserData_VariableUsage <em>User Data Variable Usage</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>User Data Variable Usage</em>' container reference.
	 * @see #getUserData_VariableUsage()
	 * @generated
	 */
	void setUserData_VariableUsage(UserData value);

	/**
	 * Returns the value of the '<em><b>Assembly Context Variable Usage</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.uka.ipd.sdq.pcm.core.composition.AssemblyContext#getConfigParameterUsages_AssemblyContext <em>Config Parameter Usages Assembly Context</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Assembly Context Variable Usage</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Assembly Context Variable Usage</em>' container reference.
	 * @see #setAssemblyContext_VariableUsage(AssemblyContext)
	 * @see de.uka.ipd.sdq.pcm.parameter.ParameterPackage#getSetVariable_AssemblyContext_VariableUsage()
	 * @see de.uka.ipd.sdq.pcm.core.composition.AssemblyContext#getConfigParameterUsages_AssemblyContext
	 * @model opposite="configParameterUsages_AssemblyContext" transient="false" ordered="false"
	 * @generated
	 */
	AssemblyContext getAssemblyContext_VariableUsage();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.parameter.SetVariable#getAssemblyContext_VariableUsage <em>Assembly Context Variable Usage</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Assembly Context Variable Usage</em>' container reference.
	 * @see #getAssemblyContext_VariableUsage()
	 * @generated
	 */
	void setAssemblyContext_VariableUsage(AssemblyContext value);

	/**
	 * Returns the value of the '<em><b>Entry Level System Call Input Parameter Usage</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.uka.ipd.sdq.pcm.usagemodel.EntryLevelSystemCall#getInputParameterUsages_EntryLevelSystemCall <em>Input Parameter Usages Entry Level System Call</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Entry Level System Call Input Parameter Usage</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Entry Level System Call Input Parameter Usage</em>' container reference.
	 * @see #setEntryLevelSystemCall_InputParameterUsage(EntryLevelSystemCall)
	 * @see de.uka.ipd.sdq.pcm.parameter.ParameterPackage#getSetVariable_EntryLevelSystemCall_InputParameterUsage()
	 * @see de.uka.ipd.sdq.pcm.usagemodel.EntryLevelSystemCall#getInputParameterUsages_EntryLevelSystemCall
	 * @model opposite="inputParameterUsages_EntryLevelSystemCall" transient="false" ordered="false"
	 * @generated
	 */
	EntryLevelSystemCall getEntryLevelSystemCall_InputParameterUsage();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.parameter.SetVariable#getEntryLevelSystemCall_InputParameterUsage <em>Entry Level System Call Input Parameter Usage</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Entry Level System Call Input Parameter Usage</em>' container reference.
	 * @see #getEntryLevelSystemCall_InputParameterUsage()
	 * @generated
	 */
	void setEntryLevelSystemCall_InputParameterUsage(EntryLevelSystemCall value);

	/**
	 * Returns the value of the '<em><b>Entry Level System Call Output Parameter Usage</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.uka.ipd.sdq.pcm.usagemodel.EntryLevelSystemCall#getOutputParameterUsages_EntryLevelSystemCall <em>Output Parameter Usages Entry Level System Call</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Entry Level System Call Output Parameter Usage</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Entry Level System Call Output Parameter Usage</em>' container reference.
	 * @see #setEntryLevelSystemCall_OutputParameterUsage(EntryLevelSystemCall)
	 * @see de.uka.ipd.sdq.pcm.parameter.ParameterPackage#getSetVariable_EntryLevelSystemCall_OutputParameterUsage()
	 * @see de.uka.ipd.sdq.pcm.usagemodel.EntryLevelSystemCall#getOutputParameterUsages_EntryLevelSystemCall
	 * @model opposite="outputParameterUsages_EntryLevelSystemCall" transient="false" ordered="false"
	 * @generated
	 */
	EntryLevelSystemCall getEntryLevelSystemCall_OutputParameterUsage();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.parameter.SetVariable#getEntryLevelSystemCall_OutputParameterUsage <em>Entry Level System Call Output Parameter Usage</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Entry Level System Call Output Parameter Usage</em>' container reference.
	 * @see #getEntryLevelSystemCall_OutputParameterUsage()
	 * @generated
	 */
	void setEntryLevelSystemCall_OutputParameterUsage(EntryLevelSystemCall value);

	/**
	 * Returns the value of the '<em><b>Call Action Set Variable</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.uka.ipd.sdq.pcm.seff.CallAction#getSetVariableInputs__CallAction <em>Set Variable Inputs Call Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Call Action Set Variable</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Call Action Set Variable</em>' container reference.
	 * @see #setCallAction__SetVariable(CallAction)
	 * @see de.uka.ipd.sdq.pcm.parameter.ParameterPackage#getSetVariable_CallAction__SetVariable()
	 * @see de.uka.ipd.sdq.pcm.seff.CallAction#getSetVariableInputs__CallAction
	 * @model opposite="setVariableInputs__CallAction" transient="false" ordered="false"
	 * @generated
	 */
	CallAction getCallAction__SetVariable();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.parameter.SetVariable#getCallAction__SetVariable <em>Call Action Set Variable</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Call Action Set Variable</em>' container reference.
	 * @see #getCallAction__SetVariable()
	 * @generated
	 */
	void setCallAction__SetVariable(CallAction value);

	/**
	 * Returns the value of the '<em><b>Synchronisation Point Variable Usage</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.uka.ipd.sdq.pcm.seff.SynchronisationPoint#getOutputParameterUsage_SynchronisationPoint <em>Output Parameter Usage Synchronisation Point</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Synchronisation Point Variable Usage</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Synchronisation Point Variable Usage</em>' container reference.
	 * @see #setSynchronisationPoint_VariableUsage(SynchronisationPoint)
	 * @see de.uka.ipd.sdq.pcm.parameter.ParameterPackage#getSetVariable_SynchronisationPoint_VariableUsage()
	 * @see de.uka.ipd.sdq.pcm.seff.SynchronisationPoint#getOutputParameterUsage_SynchronisationPoint
	 * @model opposite="outputParameterUsage_SynchronisationPoint" transient="false" ordered="false"
	 * @generated
	 */
	SynchronisationPoint getSynchronisationPoint_VariableUsage();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.parameter.SetVariable#getSynchronisationPoint_VariableUsage <em>Synchronisation Point Variable Usage</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Synchronisation Point Variable Usage</em>' container reference.
	 * @see #getSynchronisationPoint_VariableUsage()
	 * @generated
	 */
	void setSynchronisationPoint_VariableUsage(SynchronisationPoint value);

	/**
	 * Returns the value of the '<em><b>Call Return Action Set Variable</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.uka.ipd.sdq.pcm.seff.CallReturnAction#getSetVariableReturns__CallReturnAction <em>Set Variable Returns Call Return Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Call Return Action Set Variable</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Call Return Action Set Variable</em>' container reference.
	 * @see #setCallReturnAction__SetVariable(CallReturnAction)
	 * @see de.uka.ipd.sdq.pcm.parameter.ParameterPackage#getSetVariable_CallReturnAction__SetVariable()
	 * @see de.uka.ipd.sdq.pcm.seff.CallReturnAction#getSetVariableReturns__CallReturnAction
	 * @model opposite="setVariableReturns__CallReturnAction" transient="false" ordered="false"
	 * @generated
	 */
	CallReturnAction getCallReturnAction__SetVariable();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.parameter.SetVariable#getCallReturnAction__SetVariable <em>Call Return Action Set Variable</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Call Return Action Set Variable</em>' container reference.
	 * @see #getCallReturnAction__SetVariable()
	 * @generated
	 */
	void setCallReturnAction__SetVariable(CallReturnAction value);

	/**
	 * Returns the value of the '<em><b>Set Variable Action Variable Usage</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.uka.ipd.sdq.pcm.seff.SetVariableAction#getLocalVariableUsages_SetVariableAction <em>Local Variable Usages Set Variable Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Set Variable Action Variable Usage</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Set Variable Action Variable Usage</em>' container reference.
	 * @see #setSetVariableAction_VariableUsage(SetVariableAction)
	 * @see de.uka.ipd.sdq.pcm.parameter.ParameterPackage#getSetVariable_SetVariableAction_VariableUsage()
	 * @see de.uka.ipd.sdq.pcm.seff.SetVariableAction#getLocalVariableUsages_SetVariableAction
	 * @model opposite="localVariableUsages_SetVariableAction" transient="false" ordered="false"
	 * @generated
	 */
	SetVariableAction getSetVariableAction_VariableUsage();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.parameter.SetVariable#getSetVariableAction_VariableUsage <em>Set Variable Action Variable Usage</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Set Variable Action Variable Usage</em>' container reference.
	 * @see #getSetVariableAction_VariableUsage()
	 * @generated
	 */
	void setSetVariableAction_VariableUsage(SetVariableAction value);

	/**
	 * Returns the value of the '<em><b>Specified Output Parameter Abstraction expected External Outputs Variable Usage</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.uka.ipd.sdq.pcm.qosannotations.SpecifiedOutputParameterAbstraction#getExpectedExternalOutputs_SpecifiedOutputParameterAbstraction <em>Expected External Outputs Specified Output Parameter Abstraction</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Specified Output Parameter Abstraction expected External Outputs Variable Usage</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Specified Output Parameter Abstraction expected External Outputs Variable Usage</em>' container reference.
	 * @see #setSpecifiedOutputParameterAbstraction_expectedExternalOutputs_VariableUsage(SpecifiedOutputParameterAbstraction)
	 * @see de.uka.ipd.sdq.pcm.parameter.ParameterPackage#getSetVariable_SpecifiedOutputParameterAbstraction_expectedExternalOutputs_VariableUsage()
	 * @see de.uka.ipd.sdq.pcm.qosannotations.SpecifiedOutputParameterAbstraction#getExpectedExternalOutputs_SpecifiedOutputParameterAbstraction
	 * @model opposite="expectedExternalOutputs_SpecifiedOutputParameterAbstraction" transient="false" ordered="false"
	 * @generated
	 */
	SpecifiedOutputParameterAbstraction getSpecifiedOutputParameterAbstraction_expectedExternalOutputs_VariableUsage();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.parameter.SetVariable#getSpecifiedOutputParameterAbstraction_expectedExternalOutputs_VariableUsage <em>Specified Output Parameter Abstraction expected External Outputs Variable Usage</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Specified Output Parameter Abstraction expected External Outputs Variable Usage</em>' container reference.
	 * @see #getSpecifiedOutputParameterAbstraction_expectedExternalOutputs_VariableUsage()
	 * @generated
	 */
	void setSpecifiedOutputParameterAbstraction_expectedExternalOutputs_VariableUsage(SpecifiedOutputParameterAbstraction value);

	/**
	 * Returns the value of the '<em><b>Variable Variable Usage</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Variable Variable Usage</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Variable Variable Usage</em>' reference.
	 * @see #setVariable_VariableUsage(Variable)
	 * @see de.uka.ipd.sdq.pcm.parameter.ParameterPackage#getSetVariable_Variable_VariableUsage()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	Variable getVariable_VariableUsage();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.parameter.SetVariable#getVariable_VariableUsage <em>Variable Variable Usage</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Variable Variable Usage</em>' reference.
	 * @see #getVariable_VariableUsage()
	 * @generated
	 */
	void setVariable_VariableUsage(Variable value);

} // SetVariable
