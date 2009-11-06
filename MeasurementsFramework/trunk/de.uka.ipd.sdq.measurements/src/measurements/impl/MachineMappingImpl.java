/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package measurements.impl;

import de.uka.ipd.sdq.identifier.impl.IdentifierImpl;

import measurements.MachineMapping;
import measurements.MachineReference;
import measurements.MeasurementsPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Machine Mapping</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link measurements.impl.MachineMappingImpl#getMachineReference <em>Machine Reference</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MachineMappingImpl extends IdentifierImpl implements MachineMapping {
	/**
	 * The cached value of the '{@link #getMachineReference() <em>Machine Reference</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMachineReference()
	 * @generated
	 * @ordered
	 */
	protected MachineReference machineReference;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MachineMappingImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MeasurementsPackage.Literals.MACHINE_MAPPING;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MachineReference getMachineReference() {
		if (machineReference != null && machineReference.eIsProxy()) {
			InternalEObject oldMachineReference = (InternalEObject)machineReference;
			machineReference = (MachineReference)eResolveProxy(oldMachineReference);
			if (machineReference != oldMachineReference) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, MeasurementsPackage.MACHINE_MAPPING__MACHINE_REFERENCE, oldMachineReference, machineReference));
			}
		}
		return machineReference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MachineReference basicGetMachineReference() {
		return machineReference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMachineReference(MachineReference newMachineReference) {
		MachineReference oldMachineReference = machineReference;
		machineReference = newMachineReference;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MeasurementsPackage.MACHINE_MAPPING__MACHINE_REFERENCE, oldMachineReference, machineReference));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case MeasurementsPackage.MACHINE_MAPPING__MACHINE_REFERENCE:
				if (resolve) return getMachineReference();
				return basicGetMachineReference();
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
			case MeasurementsPackage.MACHINE_MAPPING__MACHINE_REFERENCE:
				setMachineReference((MachineReference)newValue);
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
			case MeasurementsPackage.MACHINE_MAPPING__MACHINE_REFERENCE:
				setMachineReference((MachineReference)null);
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
			case MeasurementsPackage.MACHINE_MAPPING__MACHINE_REFERENCE:
				return machineReference != null;
		}
		return super.eIsSet(featureID);
	}

} //MachineMappingImpl
