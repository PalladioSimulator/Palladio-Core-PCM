/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.capra.impl;

import de.uka.ipd.sdq.capra.CapraModel;
import de.uka.ipd.sdq.capra.CapraPackage;

import de.uka.ipd.sdq.capra.core.Identifier;
import de.uka.ipd.sdq.capra.core.ReplicatedProcess;

import de.uka.ipd.sdq.capra.measurement.Sensor;

import de.uka.ipd.sdq.capra.resources.Resource;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Model</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.capra.impl.CapraModelImpl#getProcesses <em>Processes</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.capra.impl.CapraModelImpl#getResources <em>Resources</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.capra.impl.CapraModelImpl#getIdentifiers <em>Identifiers</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.capra.impl.CapraModelImpl#getSensors <em>Sensors</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CapraModelImpl extends EObjectImpl implements CapraModel {
	/**
	 * The cached value of the '{@link #getProcesses() <em>Processes</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProcesses()
	 * @generated
	 * @ordered
	 */
	protected EList<ReplicatedProcess> processes;

	/**
	 * The cached value of the '{@link #getResources() <em>Resources</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResources()
	 * @generated
	 * @ordered
	 */
	protected EList<Resource> resources;

	/**
	 * The cached value of the '{@link #getIdentifiers() <em>Identifiers</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIdentifiers()
	 * @generated
	 * @ordered
	 */
	protected EList<Identifier> identifiers;

	/**
	 * The cached value of the '{@link #getSensors() <em>Sensors</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSensors()
	 * @generated
	 * @ordered
	 */
	protected EList<Sensor> sensors;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CapraModelImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CapraPackage.Literals.CAPRA_MODEL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ReplicatedProcess> getProcesses() {
		if (processes == null) {
			processes = new EObjectContainmentEList<ReplicatedProcess>(ReplicatedProcess.class, this, CapraPackage.CAPRA_MODEL__PROCESSES);
		}
		return processes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Resource> getResources() {
		if (resources == null) {
			resources = new EObjectContainmentEList<Resource>(Resource.class, this, CapraPackage.CAPRA_MODEL__RESOURCES);
		}
		return resources;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Identifier> getIdentifiers() {
		if (identifiers == null) {
			identifiers = new EObjectContainmentEList<Identifier>(Identifier.class, this, CapraPackage.CAPRA_MODEL__IDENTIFIERS);
		}
		return identifiers;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Sensor> getSensors() {
		if (sensors == null) {
			sensors = new EObjectContainmentEList<Sensor>(Sensor.class, this, CapraPackage.CAPRA_MODEL__SENSORS);
		}
		return sensors;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CapraPackage.CAPRA_MODEL__PROCESSES:
				return ((InternalEList<?>)getProcesses()).basicRemove(otherEnd, msgs);
			case CapraPackage.CAPRA_MODEL__RESOURCES:
				return ((InternalEList<?>)getResources()).basicRemove(otherEnd, msgs);
			case CapraPackage.CAPRA_MODEL__IDENTIFIERS:
				return ((InternalEList<?>)getIdentifiers()).basicRemove(otherEnd, msgs);
			case CapraPackage.CAPRA_MODEL__SENSORS:
				return ((InternalEList<?>)getSensors()).basicRemove(otherEnd, msgs);
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
			case CapraPackage.CAPRA_MODEL__PROCESSES:
				return getProcesses();
			case CapraPackage.CAPRA_MODEL__RESOURCES:
				return getResources();
			case CapraPackage.CAPRA_MODEL__IDENTIFIERS:
				return getIdentifiers();
			case CapraPackage.CAPRA_MODEL__SENSORS:
				return getSensors();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case CapraPackage.CAPRA_MODEL__PROCESSES:
				getProcesses().clear();
				getProcesses().addAll((Collection<? extends ReplicatedProcess>)newValue);
				return;
			case CapraPackage.CAPRA_MODEL__RESOURCES:
				getResources().clear();
				getResources().addAll((Collection<? extends Resource>)newValue);
				return;
			case CapraPackage.CAPRA_MODEL__IDENTIFIERS:
				getIdentifiers().clear();
				getIdentifiers().addAll((Collection<? extends Identifier>)newValue);
				return;
			case CapraPackage.CAPRA_MODEL__SENSORS:
				getSensors().clear();
				getSensors().addAll((Collection<? extends Sensor>)newValue);
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
			case CapraPackage.CAPRA_MODEL__PROCESSES:
				getProcesses().clear();
				return;
			case CapraPackage.CAPRA_MODEL__RESOURCES:
				getResources().clear();
				return;
			case CapraPackage.CAPRA_MODEL__IDENTIFIERS:
				getIdentifiers().clear();
				return;
			case CapraPackage.CAPRA_MODEL__SENSORS:
				getSensors().clear();
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
			case CapraPackage.CAPRA_MODEL__PROCESSES:
				return processes != null && !processes.isEmpty();
			case CapraPackage.CAPRA_MODEL__RESOURCES:
				return resources != null && !resources.isEmpty();
			case CapraPackage.CAPRA_MODEL__IDENTIFIERS:
				return identifiers != null && !identifiers.isEmpty();
			case CapraPackage.CAPRA_MODEL__SENSORS:
				return sensors != null && !sensors.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //CapraModelImpl
