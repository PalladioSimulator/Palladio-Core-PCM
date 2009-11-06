/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package measurements.impl;

import java.util.Collection;

import measurements.MachineDescription;
import measurements.MeasurementScript;
import measurements.MeasurementsPackage;
import measurements.TaskSet;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Measurement Script</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link measurements.impl.MeasurementScriptImpl#getTaskSets <em>Task Sets</em>}</li>
 *   <li>{@link measurements.impl.MeasurementScriptImpl#getMachineDescriptions <em>Machine Descriptions</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MeasurementScriptImpl extends EObjectImpl implements MeasurementScript {
	/**
	 * The cached value of the '{@link #getTaskSets() <em>Task Sets</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTaskSets()
	 * @generated
	 * @ordered
	 */
	protected EList<TaskSet> taskSets;

	/**
	 * The cached value of the '{@link #getMachineDescriptions() <em>Machine Descriptions</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMachineDescriptions()
	 * @generated
	 * @ordered
	 */
	protected EList<MachineDescription> machineDescriptions;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MeasurementScriptImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MeasurementsPackage.Literals.MEASUREMENT_SCRIPT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TaskSet> getTaskSets() {
		if (taskSets == null) {
			taskSets = new EObjectResolvingEList<TaskSet>(TaskSet.class, this, MeasurementsPackage.MEASUREMENT_SCRIPT__TASK_SETS);
		}
		return taskSets;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<MachineDescription> getMachineDescriptions() {
		if (machineDescriptions == null) {
			machineDescriptions = new EObjectContainmentEList<MachineDescription>(MachineDescription.class, this, MeasurementsPackage.MEASUREMENT_SCRIPT__MACHINE_DESCRIPTIONS);
		}
		return machineDescriptions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case MeasurementsPackage.MEASUREMENT_SCRIPT__MACHINE_DESCRIPTIONS:
				return ((InternalEList<?>)getMachineDescriptions()).basicRemove(otherEnd, msgs);
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
			case MeasurementsPackage.MEASUREMENT_SCRIPT__TASK_SETS:
				return getTaskSets();
			case MeasurementsPackage.MEASUREMENT_SCRIPT__MACHINE_DESCRIPTIONS:
				return getMachineDescriptions();
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
			case MeasurementsPackage.MEASUREMENT_SCRIPT__TASK_SETS:
				getTaskSets().clear();
				getTaskSets().addAll((Collection<? extends TaskSet>)newValue);
				return;
			case MeasurementsPackage.MEASUREMENT_SCRIPT__MACHINE_DESCRIPTIONS:
				getMachineDescriptions().clear();
				getMachineDescriptions().addAll((Collection<? extends MachineDescription>)newValue);
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
			case MeasurementsPackage.MEASUREMENT_SCRIPT__TASK_SETS:
				getTaskSets().clear();
				return;
			case MeasurementsPackage.MEASUREMENT_SCRIPT__MACHINE_DESCRIPTIONS:
				getMachineDescriptions().clear();
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
			case MeasurementsPackage.MEASUREMENT_SCRIPT__TASK_SETS:
				return taskSets != null && !taskSets.isEmpty();
			case MeasurementsPackage.MEASUREMENT_SCRIPT__MACHINE_DESCRIPTIONS:
				return machineDescriptions != null && !machineDescriptions.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //MeasurementScriptImpl
