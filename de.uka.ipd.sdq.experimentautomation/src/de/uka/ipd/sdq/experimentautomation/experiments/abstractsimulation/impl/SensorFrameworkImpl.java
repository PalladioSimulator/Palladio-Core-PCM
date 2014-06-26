/**
 */
package de.uka.ipd.sdq.experimentautomation.experiments.abstractsimulation.impl;

import de.uka.ipd.sdq.experimentautomation.experiments.abstractsimulation.AbstractSimulationPackage;
import de.uka.ipd.sdq.experimentautomation.experiments.abstractsimulation.SensorFramework;
import de.uka.ipd.sdq.experimentautomation.experiments.abstractsimulation.SensorFrameworkDatasource;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Sensor Framework</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.experimentautomation.experiments.abstractsimulation.impl.SensorFrameworkImpl#getDatasource <em>Datasource</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SensorFrameworkImpl extends PersistenceFrameworkImpl implements SensorFramework {
	/**
	 * The cached value of the '{@link #getDatasource() <em>Datasource</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDatasource()
	 * @generated
	 * @ordered
	 */
	protected SensorFrameworkDatasource datasource;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SensorFrameworkImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AbstractSimulationPackage.Literals.SENSOR_FRAMEWORK;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SensorFrameworkDatasource getDatasource() {
		return datasource;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDatasource(SensorFrameworkDatasource newDatasource, NotificationChain msgs) {
		SensorFrameworkDatasource oldDatasource = datasource;
		datasource = newDatasource;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AbstractSimulationPackage.SENSOR_FRAMEWORK__DATASOURCE, oldDatasource, newDatasource);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDatasource(SensorFrameworkDatasource newDatasource) {
		if (newDatasource != datasource) {
			NotificationChain msgs = null;
			if (datasource != null)
				msgs = ((InternalEObject)datasource).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AbstractSimulationPackage.SENSOR_FRAMEWORK__DATASOURCE, null, msgs);
			if (newDatasource != null)
				msgs = ((InternalEObject)newDatasource).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AbstractSimulationPackage.SENSOR_FRAMEWORK__DATASOURCE, null, msgs);
			msgs = basicSetDatasource(newDatasource, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AbstractSimulationPackage.SENSOR_FRAMEWORK__DATASOURCE, newDatasource, newDatasource));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case AbstractSimulationPackage.SENSOR_FRAMEWORK__DATASOURCE:
				return basicSetDatasource(null, msgs);
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
			case AbstractSimulationPackage.SENSOR_FRAMEWORK__DATASOURCE:
				return getDatasource();
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
			case AbstractSimulationPackage.SENSOR_FRAMEWORK__DATASOURCE:
				setDatasource((SensorFrameworkDatasource)newValue);
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
			case AbstractSimulationPackage.SENSOR_FRAMEWORK__DATASOURCE:
				setDatasource((SensorFrameworkDatasource)null);
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
			case AbstractSimulationPackage.SENSOR_FRAMEWORK__DATASOURCE:
				return datasource != null;
		}
		return super.eIsSet(featureID);
	}

} //SensorFrameworkImpl
