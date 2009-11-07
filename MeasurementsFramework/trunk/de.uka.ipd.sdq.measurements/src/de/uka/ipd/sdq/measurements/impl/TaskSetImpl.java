/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.measurements.impl;

import de.uka.ipd.sdq.identifier.impl.IdentifierImpl;

import de.uka.ipd.sdq.measurements.AbstractTask;
import de.uka.ipd.sdq.measurements.MachineReference;
import de.uka.ipd.sdq.measurements.MeasurementsPackage;
import de.uka.ipd.sdq.measurements.TaskSet;

import de.uka.ipd.sdq.probespec.ProbeSpecRepository;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Task Set</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.measurements.impl.TaskSetImpl#getName <em>Name</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.measurements.impl.TaskSetImpl#getRootTask <em>Root Task</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.measurements.impl.TaskSetImpl#getProbeSpecRepository <em>Probe Spec Repository</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.measurements.impl.TaskSetImpl#getMachineReferences <em>Machine References</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TaskSetImpl extends IdentifierImpl implements TaskSet {
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getRootTask() <em>Root Task</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRootTask()
	 * @generated
	 * @ordered
	 */
	protected AbstractTask rootTask;

	/**
	 * The cached value of the '{@link #getProbeSpecRepository() <em>Probe Spec Repository</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProbeSpecRepository()
	 * @generated
	 * @ordered
	 */
	protected ProbeSpecRepository probeSpecRepository;

	/**
	 * The cached value of the '{@link #getMachineReferences() <em>Machine References</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMachineReferences()
	 * @generated
	 * @ordered
	 */
	protected EList<MachineReference> machineReferences;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TaskSetImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MeasurementsPackage.Literals.TASK_SET;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MeasurementsPackage.TASK_SET__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AbstractTask getRootTask() {
		return rootTask;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetRootTask(AbstractTask newRootTask, NotificationChain msgs) {
		AbstractTask oldRootTask = rootTask;
		rootTask = newRootTask;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MeasurementsPackage.TASK_SET__ROOT_TASK, oldRootTask, newRootTask);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRootTask(AbstractTask newRootTask) {
		if (newRootTask != rootTask) {
			NotificationChain msgs = null;
			if (rootTask != null)
				msgs = ((InternalEObject)rootTask).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MeasurementsPackage.TASK_SET__ROOT_TASK, null, msgs);
			if (newRootTask != null)
				msgs = ((InternalEObject)newRootTask).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MeasurementsPackage.TASK_SET__ROOT_TASK, null, msgs);
			msgs = basicSetRootTask(newRootTask, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MeasurementsPackage.TASK_SET__ROOT_TASK, newRootTask, newRootTask));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProbeSpecRepository getProbeSpecRepository() {
		return probeSpecRepository;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetProbeSpecRepository(ProbeSpecRepository newProbeSpecRepository, NotificationChain msgs) {
		ProbeSpecRepository oldProbeSpecRepository = probeSpecRepository;
		probeSpecRepository = newProbeSpecRepository;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MeasurementsPackage.TASK_SET__PROBE_SPEC_REPOSITORY, oldProbeSpecRepository, newProbeSpecRepository);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProbeSpecRepository(ProbeSpecRepository newProbeSpecRepository) {
		if (newProbeSpecRepository != probeSpecRepository) {
			NotificationChain msgs = null;
			if (probeSpecRepository != null)
				msgs = ((InternalEObject)probeSpecRepository).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MeasurementsPackage.TASK_SET__PROBE_SPEC_REPOSITORY, null, msgs);
			if (newProbeSpecRepository != null)
				msgs = ((InternalEObject)newProbeSpecRepository).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MeasurementsPackage.TASK_SET__PROBE_SPEC_REPOSITORY, null, msgs);
			msgs = basicSetProbeSpecRepository(newProbeSpecRepository, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MeasurementsPackage.TASK_SET__PROBE_SPEC_REPOSITORY, newProbeSpecRepository, newProbeSpecRepository));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<MachineReference> getMachineReferences() {
		if (machineReferences == null) {
			machineReferences = new EObjectContainmentEList<MachineReference>(MachineReference.class, this, MeasurementsPackage.TASK_SET__MACHINE_REFERENCES);
		}
		return machineReferences;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case MeasurementsPackage.TASK_SET__ROOT_TASK:
				return basicSetRootTask(null, msgs);
			case MeasurementsPackage.TASK_SET__PROBE_SPEC_REPOSITORY:
				return basicSetProbeSpecRepository(null, msgs);
			case MeasurementsPackage.TASK_SET__MACHINE_REFERENCES:
				return ((InternalEList<?>)getMachineReferences()).basicRemove(otherEnd, msgs);
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
			case MeasurementsPackage.TASK_SET__NAME:
				return getName();
			case MeasurementsPackage.TASK_SET__ROOT_TASK:
				return getRootTask();
			case MeasurementsPackage.TASK_SET__PROBE_SPEC_REPOSITORY:
				return getProbeSpecRepository();
			case MeasurementsPackage.TASK_SET__MACHINE_REFERENCES:
				return getMachineReferences();
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
			case MeasurementsPackage.TASK_SET__NAME:
				setName((String)newValue);
				return;
			case MeasurementsPackage.TASK_SET__ROOT_TASK:
				setRootTask((AbstractTask)newValue);
				return;
			case MeasurementsPackage.TASK_SET__PROBE_SPEC_REPOSITORY:
				setProbeSpecRepository((ProbeSpecRepository)newValue);
				return;
			case MeasurementsPackage.TASK_SET__MACHINE_REFERENCES:
				getMachineReferences().clear();
				getMachineReferences().addAll((Collection<? extends MachineReference>)newValue);
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
			case MeasurementsPackage.TASK_SET__NAME:
				setName(NAME_EDEFAULT);
				return;
			case MeasurementsPackage.TASK_SET__ROOT_TASK:
				setRootTask((AbstractTask)null);
				return;
			case MeasurementsPackage.TASK_SET__PROBE_SPEC_REPOSITORY:
				setProbeSpecRepository((ProbeSpecRepository)null);
				return;
			case MeasurementsPackage.TASK_SET__MACHINE_REFERENCES:
				getMachineReferences().clear();
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
			case MeasurementsPackage.TASK_SET__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case MeasurementsPackage.TASK_SET__ROOT_TASK:
				return rootTask != null;
			case MeasurementsPackage.TASK_SET__PROBE_SPEC_REPOSITORY:
				return probeSpecRepository != null;
			case MeasurementsPackage.TASK_SET__MACHINE_REFERENCES:
				return machineReferences != null && !machineReferences.isEmpty();
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
		result.append(" (name: ");
		result.append(name);
		result.append(')');
		return result.toString();
	}

} //TaskSetImpl
