/**
 * Copyright 2007 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.parameter;

import de.uka.ipd.sdq.pcm.core.composition.AssemblyContext;
import de.uka.ipd.sdq.pcm.qosannotations.SpecifiedOutputParameterAbstraction;
import de.uka.ipd.sdq.pcm.seff.CallAction;
import de.uka.ipd.sdq.pcm.seff.SetVariableAction;
import de.uka.ipd.sdq.pcm.seff.SynchronisationPoint;
import de.uka.ipd.sdq.pcm.usagemodel.EntryLevelSystemCall;
import de.uka.ipd.sdq.pcm.usagemodel.UserData;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

import de.uka.ipd.sdq.stoex.AbstractNamedReference;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Variable Usage</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Variable usages are used to characterise variables like input and output variables or component parameters. They contain the specification of the variable as VariableCharacterisation and also refer to the name of the characterised variable in its namedReference association. Note that it was an explicit design decision to refer to variable names instead of the actual variables (i.e., by refering to Parameter class). It eased the writing of transformations (DSolver as well as SimuCom) but put some complexity in the frontend for entering the variable usages.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.parameter.VariableUsage#getVariableCharacterisation_VariableUsage <em>Variable Characterisation Variable Usage</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.parameter.VariableUsage#getNamedReference_VariableUsage <em>Named Reference Variable Usage</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.parameter.VariableUsage#getUserData_VariableUsage <em>User Data Variable Usage</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.parameter.VariableUsage#getAssemblyContext_VariableUsage <em>Assembly Context Variable Usage</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.parameter.VariableUsage#getEntryLevelSystemCall_VariableUsage <em>Entry Level System Call Variable Usage</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.parameter.VariableUsage#getEntryLevelSystemCall_OutputParameterUsage <em>Entry Level System Call Output Parameter Usage</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.parameter.VariableUsage#getCallAction_in_VariableUsage <em>Call Action in Variable Usage</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.parameter.VariableUsage#getSynchronisationPoint_VariableUsage <em>Synchronisation Point Variable Usage</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.parameter.VariableUsage#getSetVariableAction_VariableUsage <em>Set Variable Action Variable Usage</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.parameter.VariableUsage#getCallAction_out_VariableUsage <em>Call Action out Variable Usage</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.parameter.VariableUsage#getSpecifiedOutputParameterAbstraction_expectedExternalOutputs_VariableUsage <em>Specified Output Parameter Abstraction expected External Outputs Variable Usage</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.pcm.parameter.ParameterPackage#getVariableUsage()
 * @model
 * @generated
 */
public interface VariableUsage extends EObject {
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
	 * <p>
	 * If the meaning of the '<em>Variable Characterisation Variable Usage</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * This association contains the information which abstract information on a specific variable is available. For example, whether we know something on the variable's value, its structure or memory footprint. There can be multiple characterisations of the same variable if more than one type of information is available.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Variable Characterisation Variable Usage</em>' containment reference list.
	 * @see de.uka.ipd.sdq.pcm.parameter.ParameterPackage#getVariableUsage_VariableCharacterisation_VariableUsage()
	 * @see de.uka.ipd.sdq.pcm.parameter.VariableCharacterisation#getVariableUsage_VariableCharacterisation
	 * @model opposite="variableUsage_VariableCharacterisation" containment="true" ordered="false"
	 * @generated
	 */
	EList<VariableCharacterisation> getVariableCharacterisation_VariableUsage();

	/**
	 * Returns the value of the '<em><b>Named Reference Variable Usage</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Named Reference Variable Usage</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * This association is used to store the reference to the characterised variable. The references are of the form "namespace1.namespace2.variable" split up into namespace references and a variable reference. The reference has to identify the referenced variable in a unique way, i.e., no two variables can have the same name in a given scope.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Named Reference Variable Usage</em>' containment reference.
	 * @see #setNamedReference_VariableUsage(AbstractNamedReference)
	 * @see de.uka.ipd.sdq.pcm.parameter.ParameterPackage#getVariableUsage_NamedReference_VariableUsage()
	 * @model containment="true" required="true" ordered="false"
	 * @generated
	 */
	AbstractNamedReference getNamedReference_VariableUsage();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.parameter.VariableUsage#getNamedReference_VariableUsage <em>Named Reference Variable Usage</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Named Reference Variable Usage</em>' containment reference.
	 * @see #getNamedReference_VariableUsage()
	 * @generated
	 */
	void setNamedReference_VariableUsage(AbstractNamedReference value);

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
	 * @see de.uka.ipd.sdq.pcm.parameter.ParameterPackage#getVariableUsage_UserData_VariableUsage()
	 * @see de.uka.ipd.sdq.pcm.usagemodel.UserData#getUserDataParameterUsages_UserData
	 * @model opposite="userDataParameterUsages_UserData" transient="false" ordered="false"
	 * @generated
	 */
	UserData getUserData_VariableUsage();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.parameter.VariableUsage#getUserData_VariableUsage <em>User Data Variable Usage</em>}' container reference.
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
	 * @see de.uka.ipd.sdq.pcm.parameter.ParameterPackage#getVariableUsage_AssemblyContext_VariableUsage()
	 * @see de.uka.ipd.sdq.pcm.core.composition.AssemblyContext#getConfigParameterUsages_AssemblyContext
	 * @model opposite="configParameterUsages_AssemblyContext" transient="false" ordered="false"
	 * @generated
	 */
	AssemblyContext getAssemblyContext_VariableUsage();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.parameter.VariableUsage#getAssemblyContext_VariableUsage <em>Assembly Context Variable Usage</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Assembly Context Variable Usage</em>' container reference.
	 * @see #getAssemblyContext_VariableUsage()
	 * @generated
	 */
	void setAssemblyContext_VariableUsage(AssemblyContext value);

	/**
	 * Returns the value of the '<em><b>Entry Level System Call Variable Usage</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.uka.ipd.sdq.pcm.usagemodel.EntryLevelSystemCall#getInputParameterUsages_EntryLevelSystemCall <em>Input Parameter Usages Entry Level System Call</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Entry Level System Call Variable Usage</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Entry Level System Call Variable Usage</em>' container reference.
	 * @see #setEntryLevelSystemCall_VariableUsage(EntryLevelSystemCall)
	 * @see de.uka.ipd.sdq.pcm.parameter.ParameterPackage#getVariableUsage_EntryLevelSystemCall_VariableUsage()
	 * @see de.uka.ipd.sdq.pcm.usagemodel.EntryLevelSystemCall#getInputParameterUsages_EntryLevelSystemCall
	 * @model opposite="inputParameterUsages_EntryLevelSystemCall" transient="false" ordered="false"
	 * @generated
	 */
	EntryLevelSystemCall getEntryLevelSystemCall_VariableUsage();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.parameter.VariableUsage#getEntryLevelSystemCall_VariableUsage <em>Entry Level System Call Variable Usage</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Entry Level System Call Variable Usage</em>' container reference.
	 * @see #getEntryLevelSystemCall_VariableUsage()
	 * @generated
	 */
	void setEntryLevelSystemCall_VariableUsage(EntryLevelSystemCall value);

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
	 * @see de.uka.ipd.sdq.pcm.parameter.ParameterPackage#getVariableUsage_EntryLevelSystemCall_OutputParameterUsage()
	 * @see de.uka.ipd.sdq.pcm.usagemodel.EntryLevelSystemCall#getOutputParameterUsages_EntryLevelSystemCall
	 * @model opposite="outputParameterUsages_EntryLevelSystemCall" transient="false" ordered="false"
	 * @generated
	 */
	EntryLevelSystemCall getEntryLevelSystemCall_OutputParameterUsage();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.parameter.VariableUsage#getEntryLevelSystemCall_OutputParameterUsage <em>Entry Level System Call Output Parameter Usage</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Entry Level System Call Output Parameter Usage</em>' container reference.
	 * @see #getEntryLevelSystemCall_OutputParameterUsage()
	 * @generated
	 */
	void setEntryLevelSystemCall_OutputParameterUsage(EntryLevelSystemCall value);

	/**
	 * Returns the value of the '<em><b>Call Action in Variable Usage</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.uka.ipd.sdq.pcm.seff.CallAction#getInputParameterUsages_ExternalCallAction <em>Input Parameter Usages External Call Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Call Action in Variable Usage</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Call Action in Variable Usage</em>' container reference.
	 * @see #setCallAction_in_VariableUsage(CallAction)
	 * @see de.uka.ipd.sdq.pcm.parameter.ParameterPackage#getVariableUsage_CallAction_in_VariableUsage()
	 * @see de.uka.ipd.sdq.pcm.seff.CallAction#getInputParameterUsages_ExternalCallAction
	 * @model opposite="inputParameterUsages_ExternalCallAction" transient="false" ordered="false"
	 * @generated
	 */
	CallAction getCallAction_in_VariableUsage();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.parameter.VariableUsage#getCallAction_in_VariableUsage <em>Call Action in Variable Usage</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Call Action in Variable Usage</em>' container reference.
	 * @see #getCallAction_in_VariableUsage()
	 * @generated
	 */
	void setCallAction_in_VariableUsage(CallAction value);

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
	 * @see de.uka.ipd.sdq.pcm.parameter.ParameterPackage#getVariableUsage_SynchronisationPoint_VariableUsage()
	 * @see de.uka.ipd.sdq.pcm.seff.SynchronisationPoint#getOutputParameterUsage_SynchronisationPoint
	 * @model opposite="outputParameterUsage_SynchronisationPoint" transient="false" ordered="false"
	 * @generated
	 */
	SynchronisationPoint getSynchronisationPoint_VariableUsage();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.parameter.VariableUsage#getSynchronisationPoint_VariableUsage <em>Synchronisation Point Variable Usage</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Synchronisation Point Variable Usage</em>' container reference.
	 * @see #getSynchronisationPoint_VariableUsage()
	 * @generated
	 */
	void setSynchronisationPoint_VariableUsage(SynchronisationPoint value);

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
	 * @see de.uka.ipd.sdq.pcm.parameter.ParameterPackage#getVariableUsage_SetVariableAction_VariableUsage()
	 * @see de.uka.ipd.sdq.pcm.seff.SetVariableAction#getLocalVariableUsages_SetVariableAction
	 * @model opposite="localVariableUsages_SetVariableAction" transient="false" ordered="false"
	 * @generated
	 */
	SetVariableAction getSetVariableAction_VariableUsage();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.parameter.VariableUsage#getSetVariableAction_VariableUsage <em>Set Variable Action Variable Usage</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Set Variable Action Variable Usage</em>' container reference.
	 * @see #getSetVariableAction_VariableUsage()
	 * @generated
	 */
	void setSetVariableAction_VariableUsage(SetVariableAction value);

	/**
	 * Returns the value of the '<em><b>Call Action out Variable Usage</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.uka.ipd.sdq.pcm.seff.CallAction#getOutputVariableUsages_ExternalCallAction <em>Output Variable Usages External Call Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Call Action out Variable Usage</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Call Action out Variable Usage</em>' container reference.
	 * @see #setCallAction_out_VariableUsage(CallAction)
	 * @see de.uka.ipd.sdq.pcm.parameter.ParameterPackage#getVariableUsage_CallAction_out_VariableUsage()
	 * @see de.uka.ipd.sdq.pcm.seff.CallAction#getOutputVariableUsages_ExternalCallAction
	 * @model opposite="outputVariableUsages_ExternalCallAction" transient="false" ordered="false"
	 * @generated
	 */
	CallAction getCallAction_out_VariableUsage();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.parameter.VariableUsage#getCallAction_out_VariableUsage <em>Call Action out Variable Usage</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Call Action out Variable Usage</em>' container reference.
	 * @see #getCallAction_out_VariableUsage()
	 * @generated
	 */
	void setCallAction_out_VariableUsage(CallAction value);

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
	 * @see de.uka.ipd.sdq.pcm.parameter.ParameterPackage#getVariableUsage_SpecifiedOutputParameterAbstraction_expectedExternalOutputs_VariableUsage()
	 * @see de.uka.ipd.sdq.pcm.qosannotations.SpecifiedOutputParameterAbstraction#getExpectedExternalOutputs_SpecifiedOutputParameterAbstraction
	 * @model opposite="expectedExternalOutputs_SpecifiedOutputParameterAbstraction" transient="false" ordered="false"
	 * @generated
	 */
	SpecifiedOutputParameterAbstraction getSpecifiedOutputParameterAbstraction_expectedExternalOutputs_VariableUsage();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.parameter.VariableUsage#getSpecifiedOutputParameterAbstraction_expectedExternalOutputs_VariableUsage <em>Specified Output Parameter Abstraction expected External Outputs Variable Usage</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Specified Output Parameter Abstraction expected External Outputs Variable Usage</em>' container reference.
	 * @see #getSpecifiedOutputParameterAbstraction_expectedExternalOutputs_VariableUsage()
	 * @generated
	 */
	void setSpecifiedOutputParameterAbstraction_expectedExternalOutputs_VariableUsage(SpecifiedOutputParameterAbstraction value);

} // VariableUsage
