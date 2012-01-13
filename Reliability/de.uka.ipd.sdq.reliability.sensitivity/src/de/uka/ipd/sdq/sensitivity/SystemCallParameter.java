/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.sensitivity;

import de.uka.ipd.sdq.pcm.parameter.VariableCharacterisationType;
import de.uka.ipd.sdq.pcm.usagemodel.EntryLevelSystemCall;
import de.uka.ipd.sdq.pcm.parameter.VariableUsage;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>System Call Parameter</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * This parameter refers to a stochastic specification of an input parameter of an EntryLevelSystemCall.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.sensitivity.SystemCallParameter#getInputParameterName <em>Input Parameter Name</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.sensitivity.SystemCallParameter#getEntryLevelSystemCall__SystemCallParameter <em>Entry Level System Call System Call Parameter</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.sensitivity.SystemCallParameter#getVariableCharacterisationType__SystemCallParameter <em>Variable Characterisation Type System Call Parameter</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.sensitivity.SensitivityPackage#getSystemCallParameter()
 * @model
 * @generated
 */
public interface SystemCallParameter extends SingleSensitivityParameter {
	/**
	 * Returns the value of the '<em><b>Input Parameter Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Input Parameter Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Input Parameter Name</em>' attribute.
	 * @see #setInputParameterName(String)
	 * @see de.uka.ipd.sdq.sensitivity.SensitivityPackage#getSystemCallParameter_InputParameterName()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	String getInputParameterName();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.sensitivity.SystemCallParameter#getInputParameterName <em>Input Parameter Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Input Parameter Name</em>' attribute.
	 * @see #getInputParameterName()
	 * @generated
	 */
	void setInputParameterName(String value);

	/**
	 * Returns the value of the '<em><b>Entry Level System Call System Call Parameter</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Entry Level System Call System Call Parameter</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Entry Level System Call System Call Parameter</em>' reference.
	 * @see #setEntryLevelSystemCall__SystemCallParameter(EntryLevelSystemCall)
	 * @see de.uka.ipd.sdq.sensitivity.SensitivityPackage#getSystemCallParameter_EntryLevelSystemCall__SystemCallParameter()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	EntryLevelSystemCall getEntryLevelSystemCall__SystemCallParameter();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.sensitivity.SystemCallParameter#getEntryLevelSystemCall__SystemCallParameter <em>Entry Level System Call System Call Parameter</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Entry Level System Call System Call Parameter</em>' reference.
	 * @see #getEntryLevelSystemCall__SystemCallParameter()
	 * @generated
	 */
	void setEntryLevelSystemCall__SystemCallParameter(EntryLevelSystemCall value);

	/**
	 * Returns the value of the '<em><b>Variable Characterisation Type System Call Parameter</b></em>' attribute.
	 * The literals are from the enumeration {@link de.uka.ipd.sdq.pcm.parameter.VariableCharacterisationType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Variable Characterisation Type System Call Parameter</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Variable Characterisation Type System Call Parameter</em>' attribute.
	 * @see de.uka.ipd.sdq.pcm.parameter.VariableCharacterisationType
	 * @see #setVariableCharacterisationType__SystemCallParameter(VariableCharacterisationType)
	 * @see de.uka.ipd.sdq.sensitivity.SensitivityPackage#getSystemCallParameter_VariableCharacterisationType__SystemCallParameter()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	VariableCharacterisationType getVariableCharacterisationType__SystemCallParameter();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.sensitivity.SystemCallParameter#getVariableCharacterisationType__SystemCallParameter <em>Variable Characterisation Type System Call Parameter</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Variable Characterisation Type System Call Parameter</em>' attribute.
	 * @see de.uka.ipd.sdq.pcm.parameter.VariableCharacterisationType
	 * @see #getVariableCharacterisationType__SystemCallParameter()
	 * @generated
	 */
	void setVariableCharacterisationType__SystemCallParameter(VariableCharacterisationType value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * self.sensitivityParameterVariation__SingleSensitivityParameter.oclIsTypeOf(StringParameterSequence)
	 * @param diagnostics The chain of diagnostics to which problems are to be appended.
	 * @param context The cache of context-specific information.
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean SystemCallParameterMustHaveStringSequence(DiagnosticChain diagnostics, Map<Object, Object> context);

} // SystemCallParameter
