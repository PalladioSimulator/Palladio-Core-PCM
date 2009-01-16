/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.sensorframework.impl;

import de.uka.ipd.sdq.sensorframework.MeasurableSensor;
import de.uka.ipd.sdq.sensorframework.sensorframeworkPackage;

import de.uka.ipd.sdq.sensorframework.util.sensorframeworkValidator;

import java.util.Map;

import javax.measure.unit.Unit;

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
 * An implementation of the model object '<em><b>Measurable Sensor</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.sensorframework.impl.MeasurableSensorImpl#getUnitOfMeasurements <em>Unit Of Measurements</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MeasurableSensorImpl extends SensorDeclarationImpl implements MeasurableSensor {
	/**
	 * The default value of the '{@link #getUnitOfMeasurements() <em>Unit Of Measurements</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUnitOfMeasurements()
	 * @generated
	 * @ordered
	 */
	protected static final Unit UNIT_OF_MEASUREMENTS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getUnitOfMeasurements() <em>Unit Of Measurements</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUnitOfMeasurements()
	 * @generated
	 * @ordered
	 */
	protected Unit unitOfMeasurements = UNIT_OF_MEASUREMENTS_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MeasurableSensorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return sensorframeworkPackage.Literals.MEASURABLE_SENSOR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Unit getUnitOfMeasurements() {
		return unitOfMeasurements;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUnitOfMeasurements(Unit newUnitOfMeasurements) {
		Unit oldUnitOfMeasurements = unitOfMeasurements;
		unitOfMeasurements = newUnitOfMeasurements;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, sensorframeworkPackage.MEASURABLE_SENSOR__UNIT_OF_MEASUREMENTS, oldUnitOfMeasurements, unitOfMeasurements));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean PersistencyKindNotEmf(DiagnosticChain diagnostics, Map context) {
		// TODO: implement this method
		// -> specify the condition that violates the invariant
		// -> verify the details of the diagnostic, including severity and message
		// Ensure that you remove @generated or mark it @generated NOT
		if (false) {
			if (diagnostics != null) {
				diagnostics.add
					(new BasicDiagnostic
						(Diagnostic.ERROR,
						 sensorframeworkValidator.DIAGNOSTIC_SOURCE,
						 sensorframeworkValidator.MEASURABLE_SENSOR__PERSISTENCY_KIND_NOT_EMF,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "PersistencyKindNotEmf", EObjectValidator.getObjectLabel(this, context) }),
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
			case sensorframeworkPackage.MEASURABLE_SENSOR__UNIT_OF_MEASUREMENTS:
				return getUnitOfMeasurements();
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
			case sensorframeworkPackage.MEASURABLE_SENSOR__UNIT_OF_MEASUREMENTS:
				setUnitOfMeasurements((Unit)newValue);
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
			case sensorframeworkPackage.MEASURABLE_SENSOR__UNIT_OF_MEASUREMENTS:
				setUnitOfMeasurements(UNIT_OF_MEASUREMENTS_EDEFAULT);
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
			case sensorframeworkPackage.MEASURABLE_SENSOR__UNIT_OF_MEASUREMENTS:
				return UNIT_OF_MEASUREMENTS_EDEFAULT == null ? unitOfMeasurements != null : !UNIT_OF_MEASUREMENTS_EDEFAULT.equals(unitOfMeasurements);
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
		result.append(" (unitOfMeasurements: ");
		result.append(unitOfMeasurements);
		result.append(')');
		return result.toString();
	}

} //MeasurableSensorImpl
