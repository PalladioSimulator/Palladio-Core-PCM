/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.measurements.impl;

import de.uka.ipd.sdq.measurements.MeasurementsPackage;
import de.uka.ipd.sdq.measurements.PlainMachineReference;
import de.uka.ipd.sdq.measurements.VirtualMachineReference;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Virtual Machine Reference</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.measurements.impl.VirtualMachineReferenceImpl#getHostMachine <em>Host Machine</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class VirtualMachineReferenceImpl extends MachineReferenceImpl implements VirtualMachineReference {
	/**
	 * The cached value of the '{@link #getHostMachine() <em>Host Machine</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHostMachine()
	 * @generated
	 * @ordered
	 */
	protected PlainMachineReference hostMachine;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected VirtualMachineReferenceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MeasurementsPackage.Literals.VIRTUAL_MACHINE_REFERENCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PlainMachineReference getHostMachine() {
		if (hostMachine != null && hostMachine.eIsProxy()) {
			InternalEObject oldHostMachine = (InternalEObject)hostMachine;
			hostMachine = (PlainMachineReference)eResolveProxy(oldHostMachine);
			if (hostMachine != oldHostMachine) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, MeasurementsPackage.VIRTUAL_MACHINE_REFERENCE__HOST_MACHINE, oldHostMachine, hostMachine));
			}
		}
		return hostMachine;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PlainMachineReference basicGetHostMachine() {
		return hostMachine;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setHostMachine(PlainMachineReference newHostMachine) {
		PlainMachineReference oldHostMachine = hostMachine;
		hostMachine = newHostMachine;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MeasurementsPackage.VIRTUAL_MACHINE_REFERENCE__HOST_MACHINE, oldHostMachine, hostMachine));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case MeasurementsPackage.VIRTUAL_MACHINE_REFERENCE__HOST_MACHINE:
				if (resolve) return getHostMachine();
				return basicGetHostMachine();
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
			case MeasurementsPackage.VIRTUAL_MACHINE_REFERENCE__HOST_MACHINE:
				setHostMachine((PlainMachineReference)newValue);
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
			case MeasurementsPackage.VIRTUAL_MACHINE_REFERENCE__HOST_MACHINE:
				setHostMachine((PlainMachineReference)null);
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
			case MeasurementsPackage.VIRTUAL_MACHINE_REFERENCE__HOST_MACHINE:
				return hostMachine != null;
		}
		return super.eIsSet(featureID);
	}

} //VirtualMachineReferenceImpl
