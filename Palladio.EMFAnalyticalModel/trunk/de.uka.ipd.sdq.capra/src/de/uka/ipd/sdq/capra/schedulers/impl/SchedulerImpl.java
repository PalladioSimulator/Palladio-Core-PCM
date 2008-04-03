/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.capra.schedulers.impl;

import de.uka.ipd.sdq.capra.schedulers.Assignment;
import de.uka.ipd.sdq.capra.schedulers.LoadBalancing;
import de.uka.ipd.sdq.capra.schedulers.Scheduler;
import de.uka.ipd.sdq.capra.schedulers.SchedulersPackage;
import de.uka.ipd.sdq.capra.schedulers.SelectionPolicy;
import de.uka.ipd.sdq.capra.schedulers.TimeConsumption;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Scheduler</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.capra.schedulers.impl.SchedulerImpl#getAssignment <em>Assignment</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.capra.schedulers.impl.SchedulerImpl#getSelectionpolicy <em>Selectionpolicy</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.capra.schedulers.impl.SchedulerImpl#getTimeconsumption <em>Timeconsumption</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.capra.schedulers.impl.SchedulerImpl#getName <em>Name</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.capra.schedulers.impl.SchedulerImpl#getLoadBalancing <em>Load Balancing</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SchedulerImpl extends EObjectImpl implements Scheduler {
	/**
	 * The cached value of the '{@link #getAssignment() <em>Assignment</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAssignment()
	 * @generated
	 * @ordered
	 */
	protected Assignment assignment;

	/**
	 * The cached value of the '{@link #getSelectionpolicy() <em>Selectionpolicy</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSelectionpolicy()
	 * @generated
	 * @ordered
	 */
	protected SelectionPolicy selectionpolicy;

	/**
	 * The cached value of the '{@link #getTimeconsumption() <em>Timeconsumption</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTimeconsumption()
	 * @generated
	 * @ordered
	 */
	protected TimeConsumption timeconsumption;

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
	 * The default value of the '{@link #getLoadBalancing() <em>Load Balancing</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLoadBalancing()
	 * @generated
	 * @ordered
	 */
	protected static final LoadBalancing LOAD_BALANCING_EDEFAULT = LoadBalancing.ON_IDLE;

	/**
	 * The cached value of the '{@link #getLoadBalancing() <em>Load Balancing</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLoadBalancing()
	 * @generated
	 * @ordered
	 */
	protected LoadBalancing loadBalancing = LOAD_BALANCING_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SchedulerImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SchedulersPackage.Literals.SCHEDULER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Assignment getAssignment() {
		return assignment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetAssignment(Assignment newAssignment, NotificationChain msgs) {
		Assignment oldAssignment = assignment;
		assignment = newAssignment;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SchedulersPackage.SCHEDULER__ASSIGNMENT, oldAssignment, newAssignment);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAssignment(Assignment newAssignment) {
		if (newAssignment != assignment) {
			NotificationChain msgs = null;
			if (assignment != null)
				msgs = ((InternalEObject)assignment).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SchedulersPackage.SCHEDULER__ASSIGNMENT, null, msgs);
			if (newAssignment != null)
				msgs = ((InternalEObject)newAssignment).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SchedulersPackage.SCHEDULER__ASSIGNMENT, null, msgs);
			msgs = basicSetAssignment(newAssignment, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SchedulersPackage.SCHEDULER__ASSIGNMENT, newAssignment, newAssignment));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SelectionPolicy getSelectionpolicy() {
		return selectionpolicy;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSelectionpolicy(SelectionPolicy newSelectionpolicy, NotificationChain msgs) {
		SelectionPolicy oldSelectionpolicy = selectionpolicy;
		selectionpolicy = newSelectionpolicy;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SchedulersPackage.SCHEDULER__SELECTIONPOLICY, oldSelectionpolicy, newSelectionpolicy);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSelectionpolicy(SelectionPolicy newSelectionpolicy) {
		if (newSelectionpolicy != selectionpolicy) {
			NotificationChain msgs = null;
			if (selectionpolicy != null)
				msgs = ((InternalEObject)selectionpolicy).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SchedulersPackage.SCHEDULER__SELECTIONPOLICY, null, msgs);
			if (newSelectionpolicy != null)
				msgs = ((InternalEObject)newSelectionpolicy).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SchedulersPackage.SCHEDULER__SELECTIONPOLICY, null, msgs);
			msgs = basicSetSelectionpolicy(newSelectionpolicy, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SchedulersPackage.SCHEDULER__SELECTIONPOLICY, newSelectionpolicy, newSelectionpolicy));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TimeConsumption getTimeconsumption() {
		return timeconsumption;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTimeconsumption(TimeConsumption newTimeconsumption, NotificationChain msgs) {
		TimeConsumption oldTimeconsumption = timeconsumption;
		timeconsumption = newTimeconsumption;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SchedulersPackage.SCHEDULER__TIMECONSUMPTION, oldTimeconsumption, newTimeconsumption);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTimeconsumption(TimeConsumption newTimeconsumption) {
		if (newTimeconsumption != timeconsumption) {
			NotificationChain msgs = null;
			if (timeconsumption != null)
				msgs = ((InternalEObject)timeconsumption).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SchedulersPackage.SCHEDULER__TIMECONSUMPTION, null, msgs);
			if (newTimeconsumption != null)
				msgs = ((InternalEObject)newTimeconsumption).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SchedulersPackage.SCHEDULER__TIMECONSUMPTION, null, msgs);
			msgs = basicSetTimeconsumption(newTimeconsumption, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SchedulersPackage.SCHEDULER__TIMECONSUMPTION, newTimeconsumption, newTimeconsumption));
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
			eNotify(new ENotificationImpl(this, Notification.SET, SchedulersPackage.SCHEDULER__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LoadBalancing getLoadBalancing() {
		return loadBalancing;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLoadBalancing(LoadBalancing newLoadBalancing) {
		LoadBalancing oldLoadBalancing = loadBalancing;
		loadBalancing = newLoadBalancing == null ? LOAD_BALANCING_EDEFAULT : newLoadBalancing;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SchedulersPackage.SCHEDULER__LOAD_BALANCING, oldLoadBalancing, loadBalancing));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SchedulersPackage.SCHEDULER__ASSIGNMENT:
				return basicSetAssignment(null, msgs);
			case SchedulersPackage.SCHEDULER__SELECTIONPOLICY:
				return basicSetSelectionpolicy(null, msgs);
			case SchedulersPackage.SCHEDULER__TIMECONSUMPTION:
				return basicSetTimeconsumption(null, msgs);
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
			case SchedulersPackage.SCHEDULER__ASSIGNMENT:
				return getAssignment();
			case SchedulersPackage.SCHEDULER__SELECTIONPOLICY:
				return getSelectionpolicy();
			case SchedulersPackage.SCHEDULER__TIMECONSUMPTION:
				return getTimeconsumption();
			case SchedulersPackage.SCHEDULER__NAME:
				return getName();
			case SchedulersPackage.SCHEDULER__LOAD_BALANCING:
				return getLoadBalancing();
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
			case SchedulersPackage.SCHEDULER__ASSIGNMENT:
				setAssignment((Assignment)newValue);
				return;
			case SchedulersPackage.SCHEDULER__SELECTIONPOLICY:
				setSelectionpolicy((SelectionPolicy)newValue);
				return;
			case SchedulersPackage.SCHEDULER__TIMECONSUMPTION:
				setTimeconsumption((TimeConsumption)newValue);
				return;
			case SchedulersPackage.SCHEDULER__NAME:
				setName((String)newValue);
				return;
			case SchedulersPackage.SCHEDULER__LOAD_BALANCING:
				setLoadBalancing((LoadBalancing)newValue);
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
			case SchedulersPackage.SCHEDULER__ASSIGNMENT:
				setAssignment((Assignment)null);
				return;
			case SchedulersPackage.SCHEDULER__SELECTIONPOLICY:
				setSelectionpolicy((SelectionPolicy)null);
				return;
			case SchedulersPackage.SCHEDULER__TIMECONSUMPTION:
				setTimeconsumption((TimeConsumption)null);
				return;
			case SchedulersPackage.SCHEDULER__NAME:
				setName(NAME_EDEFAULT);
				return;
			case SchedulersPackage.SCHEDULER__LOAD_BALANCING:
				setLoadBalancing(LOAD_BALANCING_EDEFAULT);
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
			case SchedulersPackage.SCHEDULER__ASSIGNMENT:
				return assignment != null;
			case SchedulersPackage.SCHEDULER__SELECTIONPOLICY:
				return selectionpolicy != null;
			case SchedulersPackage.SCHEDULER__TIMECONSUMPTION:
				return timeconsumption != null;
			case SchedulersPackage.SCHEDULER__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case SchedulersPackage.SCHEDULER__LOAD_BALANCING:
				return loadBalancing != LOAD_BALANCING_EDEFAULT;
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
		result.append(", loadBalancing: ");
		result.append(loadBalancing);
		result.append(')');
		return result.toString();
	}

} //SchedulerImpl
