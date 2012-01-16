/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.sensitivity.impl;

import de.uka.ipd.sdq.pcm.parameter.VariableCharacterisationType;

import de.uka.ipd.sdq.pcm.usagemodel.EntryLevelSystemCall;

import de.uka.ipd.sdq.sensitivity.SensitivityPackage;
import de.uka.ipd.sdq.sensitivity.SystemCallParameter;

import de.uka.ipd.sdq.sensitivity.util.SensitivityValidator;

import java.util.Map;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.emf.ecore.util.EObjectValidator;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>System Call Parameter</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.sensitivity.impl.SystemCallParameterImpl#getInputParameterName <em>Input Parameter Name</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.sensitivity.impl.SystemCallParameterImpl#getEntryLevelSystemCall__SystemCallParameter <em>Entry Level System Call System Call Parameter</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.sensitivity.impl.SystemCallParameterImpl#getVariableCharacterisationType__SystemCallParameter <em>Variable Characterisation Type System Call Parameter</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SystemCallParameterImpl extends SingleSensitivityParameterImpl implements SystemCallParameter {
	/**
	 * The default value of the '{@link #getInputParameterName() <em>Input Parameter Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInputParameterName()
	 * @generated
	 * @ordered
	 */
	protected static final String INPUT_PARAMETER_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getInputParameterName() <em>Input Parameter Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInputParameterName()
	 * @generated
	 * @ordered
	 */
	protected String inputParameterName = INPUT_PARAMETER_NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getEntryLevelSystemCall__SystemCallParameter() <em>Entry Level System Call System Call Parameter</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEntryLevelSystemCall__SystemCallParameter()
	 * @generated
	 * @ordered
	 */
	protected EntryLevelSystemCall entryLevelSystemCall__SystemCallParameter;

	/**
	 * The default value of the '{@link #getVariableCharacterisationType__SystemCallParameter() <em>Variable Characterisation Type System Call Parameter</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVariableCharacterisationType__SystemCallParameter()
	 * @generated
	 * @ordered
	 */
	protected static final VariableCharacterisationType VARIABLE_CHARACTERISATION_TYPE_SYSTEM_CALL_PARAMETER_EDEFAULT = VariableCharacterisationType.STRUCTURE;

	/**
	 * The cached value of the '{@link #getVariableCharacterisationType__SystemCallParameter() <em>Variable Characterisation Type System Call Parameter</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVariableCharacterisationType__SystemCallParameter()
	 * @generated
	 * @ordered
	 */
	protected VariableCharacterisationType variableCharacterisationType__SystemCallParameter = VARIABLE_CHARACTERISATION_TYPE_SYSTEM_CALL_PARAMETER_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SystemCallParameterImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SensitivityPackage.Literals.SYSTEM_CALL_PARAMETER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getInputParameterName() {
		return inputParameterName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInputParameterName(String newInputParameterName) {
		String oldInputParameterName = inputParameterName;
		inputParameterName = newInputParameterName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SensitivityPackage.SYSTEM_CALL_PARAMETER__INPUT_PARAMETER_NAME, oldInputParameterName, inputParameterName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EntryLevelSystemCall getEntryLevelSystemCall__SystemCallParameter() {
		if (entryLevelSystemCall__SystemCallParameter != null && entryLevelSystemCall__SystemCallParameter.eIsProxy()) {
			InternalEObject oldEntryLevelSystemCall__SystemCallParameter = (InternalEObject)entryLevelSystemCall__SystemCallParameter;
			entryLevelSystemCall__SystemCallParameter = (EntryLevelSystemCall)eResolveProxy(oldEntryLevelSystemCall__SystemCallParameter);
			if (entryLevelSystemCall__SystemCallParameter != oldEntryLevelSystemCall__SystemCallParameter) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SensitivityPackage.SYSTEM_CALL_PARAMETER__ENTRY_LEVEL_SYSTEM_CALL_SYSTEM_CALL_PARAMETER, oldEntryLevelSystemCall__SystemCallParameter, entryLevelSystemCall__SystemCallParameter));
			}
		}
		return entryLevelSystemCall__SystemCallParameter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EntryLevelSystemCall basicGetEntryLevelSystemCall__SystemCallParameter() {
		return entryLevelSystemCall__SystemCallParameter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEntryLevelSystemCall__SystemCallParameter(EntryLevelSystemCall newEntryLevelSystemCall__SystemCallParameter) {
		EntryLevelSystemCall oldEntryLevelSystemCall__SystemCallParameter = entryLevelSystemCall__SystemCallParameter;
		entryLevelSystemCall__SystemCallParameter = newEntryLevelSystemCall__SystemCallParameter;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SensitivityPackage.SYSTEM_CALL_PARAMETER__ENTRY_LEVEL_SYSTEM_CALL_SYSTEM_CALL_PARAMETER, oldEntryLevelSystemCall__SystemCallParameter, entryLevelSystemCall__SystemCallParameter));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VariableCharacterisationType getVariableCharacterisationType__SystemCallParameter() {
		return variableCharacterisationType__SystemCallParameter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVariableCharacterisationType__SystemCallParameter(VariableCharacterisationType newVariableCharacterisationType__SystemCallParameter) {
		VariableCharacterisationType oldVariableCharacterisationType__SystemCallParameter = variableCharacterisationType__SystemCallParameter;
		variableCharacterisationType__SystemCallParameter = newVariableCharacterisationType__SystemCallParameter == null ? VARIABLE_CHARACTERISATION_TYPE_SYSTEM_CALL_PARAMETER_EDEFAULT : newVariableCharacterisationType__SystemCallParameter;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SensitivityPackage.SYSTEM_CALL_PARAMETER__VARIABLE_CHARACTERISATION_TYPE_SYSTEM_CALL_PARAMETER, oldVariableCharacterisationType__SystemCallParameter, variableCharacterisationType__SystemCallParameter));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean SystemCallParameterMustHaveStringSequence(DiagnosticChain diagnostics, Map<Object, Object> context) {
		// TODO: implement this method
		// -> specify the condition that violates the invariant
		// -> verify the details of the diagnostic, including severity and message
		// Ensure that you remove @generated or mark it @generated NOT
		if (false) {
			if (diagnostics != null) {
				diagnostics.add
					(new BasicDiagnostic
						(Diagnostic.ERROR,
						 SensitivityValidator.DIAGNOSTIC_SOURCE,
						 SensitivityValidator.SYSTEM_CALL_PARAMETER__SYSTEM_CALL_PARAMETER_MUST_HAVE_STRING_SEQUENCE,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "SystemCallParameterMustHaveStringSequence", EObjectValidator.getObjectLabel(this, context) }),
						 new Object [] { this }));
			}
			return false;
		}
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SensitivityPackage.SYSTEM_CALL_PARAMETER__INPUT_PARAMETER_NAME:
				return getInputParameterName();
			case SensitivityPackage.SYSTEM_CALL_PARAMETER__ENTRY_LEVEL_SYSTEM_CALL_SYSTEM_CALL_PARAMETER:
				if (resolve) return getEntryLevelSystemCall__SystemCallParameter();
				return basicGetEntryLevelSystemCall__SystemCallParameter();
			case SensitivityPackage.SYSTEM_CALL_PARAMETER__VARIABLE_CHARACTERISATION_TYPE_SYSTEM_CALL_PARAMETER:
				return getVariableCharacterisationType__SystemCallParameter();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case SensitivityPackage.SYSTEM_CALL_PARAMETER__INPUT_PARAMETER_NAME:
				setInputParameterName((String)newValue);
				return;
			case SensitivityPackage.SYSTEM_CALL_PARAMETER__ENTRY_LEVEL_SYSTEM_CALL_SYSTEM_CALL_PARAMETER:
				setEntryLevelSystemCall__SystemCallParameter((EntryLevelSystemCall)newValue);
				return;
			case SensitivityPackage.SYSTEM_CALL_PARAMETER__VARIABLE_CHARACTERISATION_TYPE_SYSTEM_CALL_PARAMETER:
				setVariableCharacterisationType__SystemCallParameter((VariableCharacterisationType)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case SensitivityPackage.SYSTEM_CALL_PARAMETER__INPUT_PARAMETER_NAME:
				setInputParameterName(INPUT_PARAMETER_NAME_EDEFAULT);
				return;
			case SensitivityPackage.SYSTEM_CALL_PARAMETER__ENTRY_LEVEL_SYSTEM_CALL_SYSTEM_CALL_PARAMETER:
				setEntryLevelSystemCall__SystemCallParameter((EntryLevelSystemCall)null);
				return;
			case SensitivityPackage.SYSTEM_CALL_PARAMETER__VARIABLE_CHARACTERISATION_TYPE_SYSTEM_CALL_PARAMETER:
				setVariableCharacterisationType__SystemCallParameter(VARIABLE_CHARACTERISATION_TYPE_SYSTEM_CALL_PARAMETER_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case SensitivityPackage.SYSTEM_CALL_PARAMETER__INPUT_PARAMETER_NAME:
				return INPUT_PARAMETER_NAME_EDEFAULT == null ? inputParameterName != null : !INPUT_PARAMETER_NAME_EDEFAULT.equals(inputParameterName);
			case SensitivityPackage.SYSTEM_CALL_PARAMETER__ENTRY_LEVEL_SYSTEM_CALL_SYSTEM_CALL_PARAMETER:
				return entryLevelSystemCall__SystemCallParameter != null;
			case SensitivityPackage.SYSTEM_CALL_PARAMETER__VARIABLE_CHARACTERISATION_TYPE_SYSTEM_CALL_PARAMETER:
				return variableCharacterisationType__SystemCallParameter != VARIABLE_CHARACTERISATION_TYPE_SYSTEM_CALL_PARAMETER_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (inputParameterName: ");
		result.append(inputParameterName);
		result.append(", variableCharacterisationType__SystemCallParameter: ");
		result.append(variableCharacterisationType__SystemCallParameter);
		result.append(')');
		return result.toString();
	}

} //SystemCallParameterImpl
