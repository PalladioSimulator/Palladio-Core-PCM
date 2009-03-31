/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.edp2.models.emfmodel.impl;

import de.uka.ipd.sdq.edp2.models.emfmodel.EmfmodelPackage;
import de.uka.ipd.sdq.edp2.models.emfmodel.OrdinalScalarMeasure;

import de.uka.ipd.sdq.edp2.models.emfmodel.util.EmfmodelValidator;

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
 * An implementation of the model object '<em><b>Ordinal Scalar Measure</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.emfmodel.impl.OrdinalScalarMeasureImpl#getDefaultUnitOfMeasurements <em>Default Unit Of Measurements</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class OrdinalScalarMeasureImpl extends MeasureImpl implements OrdinalScalarMeasure {
	/**
	 * The default value of the '{@link #getDefaultUnitOfMeasurements() <em>Default Unit Of Measurements</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDefaultUnitOfMeasurements()
	 * @generated
	 * @ordered
	 */
	protected static final Unit DEFAULT_UNIT_OF_MEASUREMENTS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDefaultUnitOfMeasurements() <em>Default Unit Of Measurements</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDefaultUnitOfMeasurements()
	 * @generated
	 * @ordered
	 */
	protected Unit defaultUnitOfMeasurements = DEFAULT_UNIT_OF_MEASUREMENTS_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected OrdinalScalarMeasureImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EmfmodelPackage.Literals.ORDINAL_SCALAR_MEASURE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Unit getDefaultUnitOfMeasurements() {
		return defaultUnitOfMeasurements;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDefaultUnitOfMeasurements(Unit newDefaultUnitOfMeasurements) {
		Unit oldDefaultUnitOfMeasurements = defaultUnitOfMeasurements;
		defaultUnitOfMeasurements = newDefaultUnitOfMeasurements;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EmfmodelPackage.ORDINAL_SCALAR_MEASURE__DEFAULT_UNIT_OF_MEASUREMENTS, oldDefaultUnitOfMeasurements, defaultUnitOfMeasurements));
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
						 EmfmodelValidator.DIAGNOSTIC_SOURCE,
						 EmfmodelValidator.ORDINAL_SCALAR_MEASURE__PERSISTENCY_KIND_NOT_EMF,
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
			case EmfmodelPackage.ORDINAL_SCALAR_MEASURE__DEFAULT_UNIT_OF_MEASUREMENTS:
				return getDefaultUnitOfMeasurements();
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
			case EmfmodelPackage.ORDINAL_SCALAR_MEASURE__DEFAULT_UNIT_OF_MEASUREMENTS:
				setDefaultUnitOfMeasurements((Unit)newValue);
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
			case EmfmodelPackage.ORDINAL_SCALAR_MEASURE__DEFAULT_UNIT_OF_MEASUREMENTS:
				setDefaultUnitOfMeasurements(DEFAULT_UNIT_OF_MEASUREMENTS_EDEFAULT);
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
			case EmfmodelPackage.ORDINAL_SCALAR_MEASURE__DEFAULT_UNIT_OF_MEASUREMENTS:
				return DEFAULT_UNIT_OF_MEASUREMENTS_EDEFAULT == null ? defaultUnitOfMeasurements != null : !DEFAULT_UNIT_OF_MEASUREMENTS_EDEFAULT.equals(defaultUnitOfMeasurements);
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
		result.append(" (defaultUnitOfMeasurements: ");
		result.append(defaultUnitOfMeasurements);
		result.append(')');
		return result.toString();
	}

} //OrdinalScalarMeasureImpl
