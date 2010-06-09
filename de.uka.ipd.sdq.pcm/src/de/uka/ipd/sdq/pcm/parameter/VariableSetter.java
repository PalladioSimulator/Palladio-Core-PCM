/**
 * Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.parameter;

import org.eclipse.emf.ecore.EObject;

import de.uka.ipd.sdq.pcm.core.PCMRandomVariable;
import de.uka.ipd.sdq.pcm.core.composition.AssemblyContext;
import de.uka.ipd.sdq.pcm.qosannotations.SpecifiedOutputParameterAbstraction;
import de.uka.ipd.sdq.pcm.seff.CallAction;
import de.uka.ipd.sdq.pcm.seff.CallReturnAction;
import de.uka.ipd.sdq.pcm.seff.SetVariableAction;
import de.uka.ipd.sdq.pcm.seff.SynchronisationPoint;
import de.uka.ipd.sdq.pcm.usagemodel.EntryLevelSystemCall;
import de.uka.ipd.sdq.pcm.usagemodel.UserData;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Variable Setter</b></em>'.
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
 *   <li>{@link de.uka.ipd.sdq.pcm.parameter.VariableSetter#getSpecification__VariableSetter <em>Specification Variable Setter</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.parameter.VariableSetter#getUserData__VariableSetter <em>User Data Variable Setter</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.parameter.VariableSetter#getAssemblyContext__VariableSetter <em>Assembly Context Variable Setter</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.parameter.VariableSetter#getEntryLevelSystemCall__InputVariableSetter <em>Entry Level System Call Input Variable Setter</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.parameter.VariableSetter#getEntryLevelSystemCall__OutputVariableSetter <em>Entry Level System Call Output Variable Setter</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.parameter.VariableSetter#getCallAction__VariableSetter <em>Call Action Variable Setter</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.parameter.VariableSetter#getSynchronisationPoint__VariableSetter <em>Synchronisation Point Variable Setter</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.parameter.VariableSetter#getCallReturnAction__VariableSetter <em>Call Return Action Variable Setter</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.parameter.VariableSetter#getSetVariableAction__VariableSetter <em>Set Variable Action Variable Setter</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.parameter.VariableSetter#getSpecifiedOutputParameterAbstraction_expectedExternalOutputs_VariableSetter <em>Specified Output Parameter Abstraction expected External Outputs Variable Setter</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.parameter.VariableSetter#getVariableCharacteristic__VariableSetter <em>Variable Characteristic Variable Setter</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.pcm.parameter.ParameterPackage#getVariableSetter()
 * @model
 * @generated
 */
public interface VariableSetter extends EObject {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany";

	/**
	 * Returns the value of the '<em><b>Specification Variable Setter</b></em>' containment reference.
	 * It is bidirectional and its opposite is '{@link de.uka.ipd.sdq.pcm.core.PCMRandomVariable#getVariableSetter__PCMRandomVariable <em>Variable Setter PCM Random Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * This association contains the information which abstract information on a specific variable is available. For example, whether we know something on the variable's value, its structure or memory footprint. There can be multiple characterisations of the same variable if more than one type of information is available.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Specification Variable Setter</em>' containment reference.
	 * @see #setSpecification__VariableSetter(PCMRandomVariable)
	 * @see de.uka.ipd.sdq.pcm.parameter.ParameterPackage#getVariableSetter_Specification__VariableSetter()
	 * @see de.uka.ipd.sdq.pcm.core.PCMRandomVariable#getVariableSetter__PCMRandomVariable
	 * @model opposite="variableSetter__PCMRandomVariable" containment="true" required="true" ordered="false"
	 * @generated
	 */
	PCMRandomVariable getSpecification__VariableSetter();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.parameter.VariableSetter#getSpecification__VariableSetter <em>Specification Variable Setter</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Specification Variable Setter</em>' containment reference.
	 * @see #getSpecification__VariableSetter()
	 * @generated
	 */
	void setSpecification__VariableSetter(PCMRandomVariable value);

	/**
	 * Returns the value of the '<em><b>User Data Variable Setter</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.uka.ipd.sdq.pcm.usagemodel.UserData#getUserDataVariableSetters__UserData <em>User Data Variable Setters User Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>User Data Variable Setter</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>User Data Variable Setter</em>' container reference.
	 * @see #setUserData__VariableSetter(UserData)
	 * @see de.uka.ipd.sdq.pcm.parameter.ParameterPackage#getVariableSetter_UserData__VariableSetter()
	 * @see de.uka.ipd.sdq.pcm.usagemodel.UserData#getUserDataVariableSetters__UserData
	 * @model opposite="userDataVariableSetters__UserData" transient="false" ordered="false"
	 * @generated
	 */
	UserData getUserData__VariableSetter();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.parameter.VariableSetter#getUserData__VariableSetter <em>User Data Variable Setter</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>User Data Variable Setter</em>' container reference.
	 * @see #getUserData__VariableSetter()
	 * @generated
	 */
	void setUserData__VariableSetter(UserData value);

	/**
	 * Returns the value of the '<em><b>Assembly Context Variable Setter</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.uka.ipd.sdq.pcm.core.composition.AssemblyContext#getConfigVariableSetters__AssemblyContext <em>Config Variable Setters Assembly Context</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Assembly Context Variable Setter</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Assembly Context Variable Setter</em>' container reference.
	 * @see #setAssemblyContext__VariableSetter(AssemblyContext)
	 * @see de.uka.ipd.sdq.pcm.parameter.ParameterPackage#getVariableSetter_AssemblyContext__VariableSetter()
	 * @see de.uka.ipd.sdq.pcm.core.composition.AssemblyContext#getConfigVariableSetters__AssemblyContext
	 * @model opposite="configVariableSetters__AssemblyContext" transient="false" ordered="false"
	 * @generated
	 */
	AssemblyContext getAssemblyContext__VariableSetter();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.parameter.VariableSetter#getAssemblyContext__VariableSetter <em>Assembly Context Variable Setter</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Assembly Context Variable Setter</em>' container reference.
	 * @see #getAssemblyContext__VariableSetter()
	 * @generated
	 */
	void setAssemblyContext__VariableSetter(AssemblyContext value);

	/**
	 * Returns the value of the '<em><b>Entry Level System Call Input Variable Setter</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.uka.ipd.sdq.pcm.usagemodel.EntryLevelSystemCall#getInputVariableSetters__EntryLevelSystemCall <em>Input Variable Setters Entry Level System Call</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Entry Level System Call Input Variable Setter</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Entry Level System Call Input Variable Setter</em>' container reference.
	 * @see #setEntryLevelSystemCall__InputVariableSetter(EntryLevelSystemCall)
	 * @see de.uka.ipd.sdq.pcm.parameter.ParameterPackage#getVariableSetter_EntryLevelSystemCall__InputVariableSetter()
	 * @see de.uka.ipd.sdq.pcm.usagemodel.EntryLevelSystemCall#getInputVariableSetters__EntryLevelSystemCall
	 * @model opposite="inputVariableSetters__EntryLevelSystemCall" transient="false" ordered="false"
	 * @generated
	 */
	EntryLevelSystemCall getEntryLevelSystemCall__InputVariableSetter();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.parameter.VariableSetter#getEntryLevelSystemCall__InputVariableSetter <em>Entry Level System Call Input Variable Setter</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Entry Level System Call Input Variable Setter</em>' container reference.
	 * @see #getEntryLevelSystemCall__InputVariableSetter()
	 * @generated
	 */
	void setEntryLevelSystemCall__InputVariableSetter(EntryLevelSystemCall value);

	/**
	 * Returns the value of the '<em><b>Entry Level System Call Output Variable Setter</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.uka.ipd.sdq.pcm.usagemodel.EntryLevelSystemCall#getOutputVariableSetters__EntryLevelSystemCall <em>Output Variable Setters Entry Level System Call</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Entry Level System Call Output Variable Setter</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Entry Level System Call Output Variable Setter</em>' container reference.
	 * @see #setEntryLevelSystemCall__OutputVariableSetter(EntryLevelSystemCall)
	 * @see de.uka.ipd.sdq.pcm.parameter.ParameterPackage#getVariableSetter_EntryLevelSystemCall__OutputVariableSetter()
	 * @see de.uka.ipd.sdq.pcm.usagemodel.EntryLevelSystemCall#getOutputVariableSetters__EntryLevelSystemCall
	 * @model opposite="outputVariableSetters__EntryLevelSystemCall" transient="false" ordered="false"
	 * @generated
	 */
	EntryLevelSystemCall getEntryLevelSystemCall__OutputVariableSetter();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.parameter.VariableSetter#getEntryLevelSystemCall__OutputVariableSetter <em>Entry Level System Call Output Variable Setter</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Entry Level System Call Output Variable Setter</em>' container reference.
	 * @see #getEntryLevelSystemCall__OutputVariableSetter()
	 * @generated
	 */
	void setEntryLevelSystemCall__OutputVariableSetter(EntryLevelSystemCall value);

	/**
	 * Returns the value of the '<em><b>Call Action Variable Setter</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.uka.ipd.sdq.pcm.seff.CallAction#getVariableSetterInputs__CallAction <em>Variable Setter Inputs Call Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Call Action Variable Setter</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Call Action Variable Setter</em>' container reference.
	 * @see #setCallAction__VariableSetter(CallAction)
	 * @see de.uka.ipd.sdq.pcm.parameter.ParameterPackage#getVariableSetter_CallAction__VariableSetter()
	 * @see de.uka.ipd.sdq.pcm.seff.CallAction#getVariableSetterInputs__CallAction
	 * @model opposite="variableSetterInputs__CallAction" transient="false" ordered="false"
	 * @generated
	 */
	CallAction getCallAction__VariableSetter();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.parameter.VariableSetter#getCallAction__VariableSetter <em>Call Action Variable Setter</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Call Action Variable Setter</em>' container reference.
	 * @see #getCallAction__VariableSetter()
	 * @generated
	 */
	void setCallAction__VariableSetter(CallAction value);

	/**
	 * Returns the value of the '<em><b>Synchronisation Point Variable Setter</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.uka.ipd.sdq.pcm.seff.SynchronisationPoint#getOutputVariableSetters__SynchronisationPoint <em>Output Variable Setters Synchronisation Point</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Synchronisation Point Variable Setter</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Synchronisation Point Variable Setter</em>' container reference.
	 * @see #setSynchronisationPoint__VariableSetter(SynchronisationPoint)
	 * @see de.uka.ipd.sdq.pcm.parameter.ParameterPackage#getVariableSetter_SynchronisationPoint__VariableSetter()
	 * @see de.uka.ipd.sdq.pcm.seff.SynchronisationPoint#getOutputVariableSetters__SynchronisationPoint
	 * @model opposite="outputVariableSetters__SynchronisationPoint" transient="false" ordered="false"
	 * @generated
	 */
	SynchronisationPoint getSynchronisationPoint__VariableSetter();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.parameter.VariableSetter#getSynchronisationPoint__VariableSetter <em>Synchronisation Point Variable Setter</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Synchronisation Point Variable Setter</em>' container reference.
	 * @see #getSynchronisationPoint__VariableSetter()
	 * @generated
	 */
	void setSynchronisationPoint__VariableSetter(SynchronisationPoint value);

	/**
	 * Returns the value of the '<em><b>Call Return Action Variable Setter</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.uka.ipd.sdq.pcm.seff.CallReturnAction#getVariableSetterReturns__CallReturnAction <em>Variable Setter Returns Call Return Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Call Return Action Variable Setter</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Call Return Action Variable Setter</em>' container reference.
	 * @see #setCallReturnAction__VariableSetter(CallReturnAction)
	 * @see de.uka.ipd.sdq.pcm.parameter.ParameterPackage#getVariableSetter_CallReturnAction__VariableSetter()
	 * @see de.uka.ipd.sdq.pcm.seff.CallReturnAction#getVariableSetterReturns__CallReturnAction
	 * @model opposite="variableSetterReturns__CallReturnAction" transient="false" ordered="false"
	 * @generated
	 */
	CallReturnAction getCallReturnAction__VariableSetter();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.parameter.VariableSetter#getCallReturnAction__VariableSetter <em>Call Return Action Variable Setter</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Call Return Action Variable Setter</em>' container reference.
	 * @see #getCallReturnAction__VariableSetter()
	 * @generated
	 */
	void setCallReturnAction__VariableSetter(CallReturnAction value);

	/**
	 * Returns the value of the '<em><b>Set Variable Action Variable Setter</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.uka.ipd.sdq.pcm.seff.SetVariableAction#getLocalVariableUsages_SetVariableAction <em>Local Variable Usages Set Variable Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Set Variable Action Variable Setter</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Set Variable Action Variable Setter</em>' container reference.
	 * @see #setSetVariableAction__VariableSetter(SetVariableAction)
	 * @see de.uka.ipd.sdq.pcm.parameter.ParameterPackage#getVariableSetter_SetVariableAction__VariableSetter()
	 * @see de.uka.ipd.sdq.pcm.seff.SetVariableAction#getLocalVariableUsages_SetVariableAction
	 * @model opposite="localVariableUsages_SetVariableAction" transient="false" ordered="false"
	 * @generated
	 */
	SetVariableAction getSetVariableAction__VariableSetter();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.parameter.VariableSetter#getSetVariableAction__VariableSetter <em>Set Variable Action Variable Setter</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Set Variable Action Variable Setter</em>' container reference.
	 * @see #getSetVariableAction__VariableSetter()
	 * @generated
	 */
	void setSetVariableAction__VariableSetter(SetVariableAction value);

	/**
	 * Returns the value of the '<em><b>Specified Output Parameter Abstraction expected External Outputs Variable Setter</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.uka.ipd.sdq.pcm.qosannotations.SpecifiedOutputParameterAbstraction#getExpectedExternalOutputs_SpecifiedOutputParameterAbstraction <em>Expected External Outputs Specified Output Parameter Abstraction</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Specified Output Parameter Abstraction expected External Outputs Variable Setter</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Specified Output Parameter Abstraction expected External Outputs Variable Setter</em>' container reference.
	 * @see #setSpecifiedOutputParameterAbstraction_expectedExternalOutputs_VariableSetter(SpecifiedOutputParameterAbstraction)
	 * @see de.uka.ipd.sdq.pcm.parameter.ParameterPackage#getVariableSetter_SpecifiedOutputParameterAbstraction_expectedExternalOutputs_VariableSetter()
	 * @see de.uka.ipd.sdq.pcm.qosannotations.SpecifiedOutputParameterAbstraction#getExpectedExternalOutputs_SpecifiedOutputParameterAbstraction
	 * @model opposite="expectedExternalOutputs_SpecifiedOutputParameterAbstraction" transient="false" ordered="false"
	 * @generated
	 */
	SpecifiedOutputParameterAbstraction getSpecifiedOutputParameterAbstraction_expectedExternalOutputs_VariableSetter();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.parameter.VariableSetter#getSpecifiedOutputParameterAbstraction_expectedExternalOutputs_VariableSetter <em>Specified Output Parameter Abstraction expected External Outputs Variable Setter</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Specified Output Parameter Abstraction expected External Outputs Variable Setter</em>' container reference.
	 * @see #getSpecifiedOutputParameterAbstraction_expectedExternalOutputs_VariableSetter()
	 * @generated
	 */
	void setSpecifiedOutputParameterAbstraction_expectedExternalOutputs_VariableSetter(SpecifiedOutputParameterAbstraction value);

	/**
	 * Returns the value of the '<em><b>Variable Characteristic Variable Setter</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Variable Characteristic Variable Setter</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Variable Characteristic Variable Setter</em>' reference.
	 * @see #setVariableCharacteristic__VariableSetter(VariableCharacteristic)
	 * @see de.uka.ipd.sdq.pcm.parameter.ParameterPackage#getVariableSetter_VariableCharacteristic__VariableSetter()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	VariableCharacteristic getVariableCharacteristic__VariableSetter();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.parameter.VariableSetter#getVariableCharacteristic__VariableSetter <em>Variable Characteristic Variable Setter</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Variable Characteristic Variable Setter</em>' reference.
	 * @see #getVariableCharacteristic__VariableSetter()
	 * @generated
	 */
	void setVariableCharacteristic__VariableSetter(VariableCharacteristic value);

} // VariableSetter
