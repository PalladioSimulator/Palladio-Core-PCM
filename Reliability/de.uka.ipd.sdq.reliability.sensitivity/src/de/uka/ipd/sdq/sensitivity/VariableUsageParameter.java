/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.sensitivity;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;

import de.uka.ipd.sdq.pcm.parameter.VariableCharacterisationType;
import de.uka.ipd.sdq.pcm.repository.BasicComponent;
import de.uka.ipd.sdq.pcm.usagemodel.EntryLevelSystemCall;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Variable Usage Parameter</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * This&nbsp;parameter&nbsp;refers&nbsp;to&nbsp;a&nbsp;stochastic&nbsp;specification&nbsp;of&nbsp;a variable usage.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.sensitivity.VariableUsageParameter#getVariableName <em>Variable Name</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.sensitivity.VariableUsageParameter#getEntryLevelSystemCall__VariableUsageParameter <em>Entry Level System Call Variable Usage Parameter</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.sensitivity.VariableUsageParameter#getVariableCharacterisationType__VariableUsageParameter <em>Variable Characterisation Type Variable Usage Parameter</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.sensitivity.VariableUsageParameter#getVariableUsageType__VariableUsageParameter <em>Variable Usage Type Variable Usage Parameter</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.sensitivity.VariableUsageParameter#getBasicComponent__VariableUsageParameter <em>Basic Component Variable Usage Parameter</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.sensitivity.SensitivityPackage#getVariableUsageParameter()
 * @model
 * @generated
 */
public interface VariableUsageParameter extends SingleSensitivityParameter {
	/**
	 * Returns the value of the '<em><b>Variable Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Variable Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Variable Name</em>' attribute.
	 * @see #setVariableName(String)
	 * @see de.uka.ipd.sdq.sensitivity.SensitivityPackage#getVariableUsageParameter_VariableName()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	String getVariableName();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.sensitivity.VariableUsageParameter#getVariableName <em>Variable Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Variable Name</em>' attribute.
	 * @see #getVariableName()
	 * @generated
	 */
	void setVariableName(String value);

	/**
	 * Returns the value of the '<em><b>Entry Level System Call Variable Usage Parameter</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Entry Level System Call Variable Usage Parameter</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Entry Level System Call Variable Usage Parameter</em>' reference.
	 * @see #setEntryLevelSystemCall__VariableUsageParameter(EntryLevelSystemCall)
	 * @see de.uka.ipd.sdq.sensitivity.SensitivityPackage#getVariableUsageParameter_EntryLevelSystemCall__VariableUsageParameter()
	 * @model ordered="false"
	 * @generated
	 */
	EntryLevelSystemCall getEntryLevelSystemCall__VariableUsageParameter();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.sensitivity.VariableUsageParameter#getEntryLevelSystemCall__VariableUsageParameter <em>Entry Level System Call Variable Usage Parameter</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Entry Level System Call Variable Usage Parameter</em>' reference.
	 * @see #getEntryLevelSystemCall__VariableUsageParameter()
	 * @generated
	 */
	void setEntryLevelSystemCall__VariableUsageParameter(EntryLevelSystemCall value);

	/**
	 * Returns the value of the '<em><b>Variable Characterisation Type Variable Usage Parameter</b></em>' attribute.
	 * The literals are from the enumeration {@link de.uka.ipd.sdq.pcm.parameter.VariableCharacterisationType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Variable Characterisation Type Variable Usage Parameter</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Variable Characterisation Type Variable Usage Parameter</em>' attribute.
	 * @see de.uka.ipd.sdq.pcm.parameter.VariableCharacterisationType
	 * @see #setVariableCharacterisationType__VariableUsageParameter(VariableCharacterisationType)
	 * @see de.uka.ipd.sdq.sensitivity.SensitivityPackage#getVariableUsageParameter_VariableCharacterisationType__VariableUsageParameter()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	VariableCharacterisationType getVariableCharacterisationType__VariableUsageParameter();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.sensitivity.VariableUsageParameter#getVariableCharacterisationType__VariableUsageParameter <em>Variable Characterisation Type Variable Usage Parameter</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Variable Characterisation Type Variable Usage Parameter</em>' attribute.
	 * @see de.uka.ipd.sdq.pcm.parameter.VariableCharacterisationType
	 * @see #getVariableCharacterisationType__VariableUsageParameter()
	 * @generated
	 */
	void setVariableCharacterisationType__VariableUsageParameter(VariableCharacterisationType value);

	/**
	 * Returns the value of the '<em><b>Variable Usage Type Variable Usage Parameter</b></em>' attribute.
	 * The literals are from the enumeration {@link de.uka.ipd.sdq.sensitivity.VariableUsageType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Variable Usage Type Variable Usage Parameter</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Variable Usage Type Variable Usage Parameter</em>' attribute.
	 * @see de.uka.ipd.sdq.sensitivity.VariableUsageType
	 * @see #setVariableUsageType__VariableUsageParameter(VariableUsageType)
	 * @see de.uka.ipd.sdq.sensitivity.SensitivityPackage#getVariableUsageParameter_VariableUsageType__VariableUsageParameter()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	VariableUsageType getVariableUsageType__VariableUsageParameter();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.sensitivity.VariableUsageParameter#getVariableUsageType__VariableUsageParameter <em>Variable Usage Type Variable Usage Parameter</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Variable Usage Type Variable Usage Parameter</em>' attribute.
	 * @see de.uka.ipd.sdq.sensitivity.VariableUsageType
	 * @see #getVariableUsageType__VariableUsageParameter()
	 * @generated
	 */
	void setVariableUsageType__VariableUsageParameter(VariableUsageType value);

	/**
	 * Returns the value of the '<em><b>Basic Component Variable Usage Parameter</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Basic Component Variable Usage Parameter</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Basic Component Variable Usage Parameter</em>' reference.
	 * @see #setBasicComponent__VariableUsageParameter(BasicComponent)
	 * @see de.uka.ipd.sdq.sensitivity.SensitivityPackage#getVariableUsageParameter_BasicComponent__VariableUsageParameter()
	 * @model ordered="false"
	 * @generated
	 */
	BasicComponent getBasicComponent__VariableUsageParameter();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.sensitivity.VariableUsageParameter#getBasicComponent__VariableUsageParameter <em>Basic Component Variable Usage Parameter</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Basic Component Variable Usage Parameter</em>' reference.
	 * @see #getBasicComponent__VariableUsageParameter()
	 * @generated
	 */
	void setBasicComponent__VariableUsageParameter(BasicComponent value);

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

} // VariableUsageParameter
