/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.measurements.tasks.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import de.uka.ipd.sdq.measurements.MachineReference;
import de.uka.ipd.sdq.measurements.tasks.MachineTask;
import de.uka.ipd.sdq.measurements.tasks.TasksPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Machine Task</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.measurements.tasks.impl.MachineTaskImpl#getMachine <em>Machine</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class MachineTaskImpl extends AbstractTaskImpl implements MachineTask {
	/**
	 * The cached value of the '{@link #getMachine() <em>Machine</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMachine()
	 * @generated
	 * @ordered
	 */
	protected MachineReference machine;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MachineTaskImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TasksPackage.Literals.MACHINE_TASK;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MachineReference getMachine() {
		if (machine != null && machine.eIsProxy()) {
			InternalEObject oldMachine = (InternalEObject)machine;
			machine = (MachineReference)eResolveProxy(oldMachine);
			if (machine != oldMachine) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, TasksPackage.MACHINE_TASK__MACHINE, oldMachine, machine));
			}
		}
		return machine;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MachineReference basicGetMachine() {
		return machine;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMachine(MachineReference newMachine) {
		MachineReference oldMachine = machine;
		machine = newMachine;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TasksPackage.MACHINE_TASK__MACHINE, oldMachine, machine));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case TasksPackage.MACHINE_TASK__MACHINE:
				if (resolve) return getMachine();
				return basicGetMachine();
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
			case TasksPackage.MACHINE_TASK__MACHINE:
				setMachine((MachineReference)newValue);
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
			case TasksPackage.MACHINE_TASK__MACHINE:
				setMachine((MachineReference)null);
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
			case TasksPackage.MACHINE_TASK__MACHINE:
				return machine != null;
		}
		return super.eIsSet(featureID);
	}

} //MachineTaskImpl
