/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.sensorframework.impl;

import de.uka.ipd.sdq.sensorframework.RawYValues;
import de.uka.ipd.sdq.sensorframework.Statistics;
import de.uka.ipd.sdq.sensorframework.sensorframeworkPackage;

import de.uka.ipd.sdq.sensorframework.util.sensorframeworkValidator;

import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.emf.ecore.util.EObjectValidator;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Raw YValues</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.sensorframework.impl.RawYValuesImpl#getStatistics <em>Statistics</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class RawYValuesImpl extends EObjectImpl implements RawYValues {
	/**
	 * The cached value of the '{@link #getStatistics() <em>Statistics</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStatistics()
	 * @generated
	 * @ordered
	 */
	protected Statistics statistics;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RawYValuesImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return sensorframeworkPackage.Literals.RAW_YVALUES;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Statistics getStatistics() {
		return statistics;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetStatistics(Statistics newStatistics, NotificationChain msgs) {
		Statistics oldStatistics = statistics;
		statistics = newStatistics;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, sensorframeworkPackage.RAW_YVALUES__STATISTICS, oldStatistics, newStatistics);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStatistics(Statistics newStatistics) {
		if (newStatistics != statistics) {
			NotificationChain msgs = null;
			if (statistics != null)
				msgs = ((InternalEObject)statistics).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - sensorframeworkPackage.RAW_YVALUES__STATISTICS, null, msgs);
			if (newStatistics != null)
				msgs = ((InternalEObject)newStatistics).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - sensorframeworkPackage.RAW_YVALUES__STATISTICS, null, msgs);
			msgs = basicSetStatistics(newStatistics, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, sensorframeworkPackage.RAW_YVALUES__STATISTICS, newStatistics, newStatistics));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean Statisticsonlyformeasurablevalues(DiagnosticChain diagnostics, Map context) {
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
						 sensorframeworkValidator.RAW_YVALUES__STATISTICSONLYFORMEASURABLEVALUES,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "Statisticsonlyformeasurablevalues", EObjectValidator.getObjectLabel(this, context) }),
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
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case sensorframeworkPackage.RAW_YVALUES__STATISTICS:
				return basicSetStatistics(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case sensorframeworkPackage.RAW_YVALUES__STATISTICS:
				return getStatistics();
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
			case sensorframeworkPackage.RAW_YVALUES__STATISTICS:
				setStatistics((Statistics)newValue);
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
			case sensorframeworkPackage.RAW_YVALUES__STATISTICS:
				setStatistics((Statistics)null);
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
			case sensorframeworkPackage.RAW_YVALUES__STATISTICS:
				return statistics != null;
		}
		return super.eIsSet(featureID);
	}

} //RawYValuesImpl
