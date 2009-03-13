/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.ByBench.impl;

import de.uka.ipd.sdq.ByBench.AtomicInstruction;
import de.uka.ipd.sdq.ByBench.ByBenchPackage;

import de.uka.ipd.sdq.ByBench.util.ByBenchValidator;

import java.util.Map;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.emf.ecore.util.EObjectValidator;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Atomic Instruction</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.ByBench.impl.AtomicInstructionImpl#getParameterValue <em>Parameter Value</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.ByBench.impl.AtomicInstructionImpl#getParameterConversion <em>Parameter Conversion</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.ByBench.impl.AtomicInstructionImpl#getOpcode <em>Opcode</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AtomicInstructionImpl extends SequenceElementImpl implements AtomicInstruction {
	/**
	 * The default value of the '{@link #getParameterValue() <em>Parameter Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParameterValue()
	 * @generated
	 * @ordered
	 */
	protected static final Object PARAMETER_VALUE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getParameterValue() <em>Parameter Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParameterValue()
	 * @generated
	 * @ordered
	 */
	protected Object parameterValue = PARAMETER_VALUE_EDEFAULT;

	/**
	 * The default value of the '{@link #getParameterConversion() <em>Parameter Conversion</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParameterConversion()
	 * @generated
	 * @ordered
	 */
	protected static final int PARAMETER_CONVERSION_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getParameterConversion() <em>Parameter Conversion</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParameterConversion()
	 * @generated
	 * @ordered
	 */
	protected int parameterConversion = PARAMETER_CONVERSION_EDEFAULT;

	/**
	 * The default value of the '{@link #getOpcode() <em>Opcode</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOpcode()
	 * @generated
	 * @ordered
	 */
	protected static final int OPCODE_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getOpcode() <em>Opcode</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOpcode()
	 * @generated
	 * @ordered
	 */
	protected int opcode = OPCODE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AtomicInstructionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ByBenchPackage.Literals.ATOMIC_INSTRUCTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getParameterValue() {
		return parameterValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParameterValue(Object newParameterValue) {
		Object oldParameterValue = parameterValue;
		parameterValue = newParameterValue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ByBenchPackage.ATOMIC_INSTRUCTION__PARAMETER_VALUE, oldParameterValue, parameterValue));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getParameterConversion() {
		return parameterConversion;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParameterConversion(int newParameterConversion) {
		int oldParameterConversion = parameterConversion;
		parameterConversion = newParameterConversion;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ByBenchPackage.ATOMIC_INSTRUCTION__PARAMETER_CONVERSION, oldParameterConversion, parameterConversion));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getOpcode() {
		return opcode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOpcode(int newOpcode) {
		int oldOpcode = opcode;
		opcode = newOpcode;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ByBenchPackage.ATOMIC_INSTRUCTION__OPCODE, oldOpcode, opcode));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean ensureValidOpcode(DiagnosticChain diagnostics, Map context) {
		// TODO: implement this method
		// -> specify the condition that violates the invariant
		// -> verify the details of the diagnostic, including severity and message
		// Ensure that you remove @generated or mark it @generated NOT
		if (false) {
			if (diagnostics != null) {
				diagnostics.add
					(new BasicDiagnostic
						(Diagnostic.ERROR,
						 ByBenchValidator.DIAGNOSTIC_SOURCE,
						 ByBenchValidator.ATOMIC_INSTRUCTION__ENSURE_VALID_OPCODE,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "ensureValidOpcode", EObjectValidator.getObjectLabel(this, context) }),
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
			case ByBenchPackage.ATOMIC_INSTRUCTION__PARAMETER_VALUE:
				return getParameterValue();
			case ByBenchPackage.ATOMIC_INSTRUCTION__PARAMETER_CONVERSION:
				return new Integer(getParameterConversion());
			case ByBenchPackage.ATOMIC_INSTRUCTION__OPCODE:
				return new Integer(getOpcode());
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
			case ByBenchPackage.ATOMIC_INSTRUCTION__PARAMETER_VALUE:
				setParameterValue(newValue);
				return;
			case ByBenchPackage.ATOMIC_INSTRUCTION__PARAMETER_CONVERSION:
				setParameterConversion(((Integer)newValue).intValue());
				return;
			case ByBenchPackage.ATOMIC_INSTRUCTION__OPCODE:
				setOpcode(((Integer)newValue).intValue());
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
			case ByBenchPackage.ATOMIC_INSTRUCTION__PARAMETER_VALUE:
				setParameterValue(PARAMETER_VALUE_EDEFAULT);
				return;
			case ByBenchPackage.ATOMIC_INSTRUCTION__PARAMETER_CONVERSION:
				setParameterConversion(PARAMETER_CONVERSION_EDEFAULT);
				return;
			case ByBenchPackage.ATOMIC_INSTRUCTION__OPCODE:
				setOpcode(OPCODE_EDEFAULT);
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
			case ByBenchPackage.ATOMIC_INSTRUCTION__PARAMETER_VALUE:
				return PARAMETER_VALUE_EDEFAULT == null ? parameterValue != null : !PARAMETER_VALUE_EDEFAULT.equals(parameterValue);
			case ByBenchPackage.ATOMIC_INSTRUCTION__PARAMETER_CONVERSION:
				return parameterConversion != PARAMETER_CONVERSION_EDEFAULT;
			case ByBenchPackage.ATOMIC_INSTRUCTION__OPCODE:
				return opcode != OPCODE_EDEFAULT;
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
		result.append(" (ParameterValue: ");
		result.append(parameterValue);
		result.append(", ParameterConversion: ");
		result.append(parameterConversion);
		result.append(", opcode: ");
		result.append(opcode);
		result.append(')');
		return result.toString();
	}

} //AtomicInstructionImpl
