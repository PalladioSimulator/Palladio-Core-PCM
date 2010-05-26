/**
 * Copyright 2007 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.usagemodel;

import org.eclipse.emf.common.util.EList;

import de.uka.ipd.sdq.pcm.parameter.VariableUsage;
import de.uka.ipd.sdq.pcm.repository.ProvidedRole;
import de.uka.ipd.sdq.pcm.repository.Signature;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Entry Level System Call</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * An EntryLevelSystemCall models the call to a service provided by a system. Therefore, an
 * EntryLevelSystemCall references a ProvidedRole of a PCM System, from which the
 * called interface and the providing component within the system can be derived, and a Signature
 * specifying the called service. Notice, that the usage model does not permit the domain expert to
 * model calls directly to components, but only to system roles. (TODO: Add such a constraint.) This decouples the System structure
 * (i.e., the component-based software architecture model and its allocation) from the UsageModel
 * and the software architect can change the System (e.g., include new components, remove existing
 * components, or change their wiring or allocation) independently from the domain expert, if
 * the system provided roles are not affected. EntryLevelSystemCalls may include a set of
 * input parameter characterisations and a set of output parameter characterisations (as described in
 * the pcm::parameters package). However, the random variables characterising the input parameters
 * like NUMBER_OF_ELEMENTS can not depend on other variables in the usage model. They have
 * to be composed from literals only including literals describing random variables having a
 * certain fixed distribution.
 * 
 * TODO Anne: Constraint that ensures that the referred signature is contained in the interface referenced by the ProvidedRole (see Diagram)
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.usagemodel.EntryLevelSystemCall#getProvidedRole_EntryLevelSystemCall <em>Provided Role Entry Level System Call</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.usagemodel.EntryLevelSystemCall#getSignature_EntryLevelSystemCall <em>Signature Entry Level System Call</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.usagemodel.EntryLevelSystemCall#getOutputParameterUsages_EntryLevelSystemCall <em>Output Parameter Usages Entry Level System Call</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.usagemodel.EntryLevelSystemCall#getInputParameterUsages_EntryLevelSystemCall <em>Input Parameter Usages Entry Level System Call</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.pcm.usagemodel.UsagemodelPackage#getEntryLevelSystemCall()
 * @model
 * @generated
 */
public interface EntryLevelSystemCall extends AbstractUserAction {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany";

	/**
	 * Returns the value of the '<em><b>Input Parameter Usages Entry Level System Call</b></em>' containment reference list.
	 * The list contents are of type {@link de.uka.ipd.sdq.pcm.parameter.VariableUsage}.
	 * It is bidirectional and its opposite is '{@link de.uka.ipd.sdq.pcm.parameter.VariableUsage#getEntryLevelSystemCall_VariableUsage <em>Entry Level System Call Variable Usage</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Input Parameter Usages Entry Level System Call</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Input Parameter Usages Entry Level System Call</em>' containment reference list.
	 * @see de.uka.ipd.sdq.pcm.usagemodel.UsagemodelPackage#getEntryLevelSystemCall_InputParameterUsages_EntryLevelSystemCall()
	 * @see de.uka.ipd.sdq.pcm.parameter.VariableUsage#getEntryLevelSystemCall_VariableUsage
	 * @model opposite="entryLevelSystemCall_VariableUsage" containment="true" ordered="false"
	 * @generated
	 */
	EList<VariableUsage> getInputParameterUsages_EntryLevelSystemCall();

	/**
	 * Returns the value of the '<em><b>Provided Role Entry Level System Call</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Provided Role Entry Level System Call</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Provided Role Entry Level System Call</em>' reference.
	 * @see #setProvidedRole_EntryLevelSystemCall(ProvidedRole)
	 * @see de.uka.ipd.sdq.pcm.usagemodel.UsagemodelPackage#getEntryLevelSystemCall_ProvidedRole_EntryLevelSystemCall()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	ProvidedRole getProvidedRole_EntryLevelSystemCall();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.usagemodel.EntryLevelSystemCall#getProvidedRole_EntryLevelSystemCall <em>Provided Role Entry Level System Call</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Provided Role Entry Level System Call</em>' reference.
	 * @see #getProvidedRole_EntryLevelSystemCall()
	 * @generated
	 */
	void setProvidedRole_EntryLevelSystemCall(ProvidedRole value);

	/**
	 * Returns the value of the '<em><b>Signature Entry Level System Call</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Signature Entry Level System Call</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Signature Entry Level System Call</em>' reference.
	 * @see #setSignature_EntryLevelSystemCall(Signature)
	 * @see de.uka.ipd.sdq.pcm.usagemodel.UsagemodelPackage#getEntryLevelSystemCall_Signature_EntryLevelSystemCall()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	Signature getSignature_EntryLevelSystemCall();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.usagemodel.EntryLevelSystemCall#getSignature_EntryLevelSystemCall <em>Signature Entry Level System Call</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Signature Entry Level System Call</em>' reference.
	 * @see #getSignature_EntryLevelSystemCall()
	 * @generated
	 */
	void setSignature_EntryLevelSystemCall(Signature value);

	/**
	 * Returns the value of the '<em><b>Output Parameter Usages Entry Level System Call</b></em>' containment reference list.
	 * The list contents are of type {@link de.uka.ipd.sdq.pcm.parameter.VariableUsage}.
	 * It is bidirectional and its opposite is '{@link de.uka.ipd.sdq.pcm.parameter.VariableUsage#getEntryLevelSystemCall_OutputParameterUsage <em>Entry Level System Call Output Parameter Usage</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Output Parameter Usages Entry Level System Call</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Output Parameter Usages Entry Level System Call</em>' containment reference list.
	 * @see de.uka.ipd.sdq.pcm.usagemodel.UsagemodelPackage#getEntryLevelSystemCall_OutputParameterUsages_EntryLevelSystemCall()
	 * @see de.uka.ipd.sdq.pcm.parameter.VariableUsage#getEntryLevelSystemCall_OutputParameterUsage
	 * @model opposite="entryLevelSystemCall_OutputParameterUsage" containment="true" ordered="false"
	 * @generated
	 */
	EList<VariableUsage> getOutputParameterUsages_EntryLevelSystemCall();

} // EntryLevelSystemCall
