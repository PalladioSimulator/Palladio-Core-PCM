/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.capra.core.impl;

import de.uka.ipd.sdq.capra.core.BoundedLoop;
import de.uka.ipd.sdq.capra.core.CapraExpression;
import de.uka.ipd.sdq.capra.core.CorePackage;

import de.uka.ipd.sdq.probfunction.ProbabilityMassFunction;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Bounded Loop</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.capra.core.impl.BoundedLoopImpl#getRepeatedProcess <em>Repeated Process</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.capra.core.impl.BoundedLoopImpl#getTargetProcess <em>Target Process</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.capra.core.impl.BoundedLoopImpl#getNumberOfIterations <em>Number Of Iterations</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class BoundedLoopImpl extends OperatorImpl implements BoundedLoop {
	/**
	 * The cached value of the '{@link #getRepeatedProcess() <em>Repeated Process</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRepeatedProcess()
	 * @generated
	 * @ordered
	 */
	protected CapraExpression repeatedProcess;

	/**
	 * The cached value of the '{@link #getTargetProcess() <em>Target Process</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTargetProcess()
	 * @generated
	 * @ordered
	 */
	protected CapraExpression targetProcess;

	/**
	 * The cached value of the '{@link #getNumberOfIterations() <em>Number Of Iterations</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNumberOfIterations()
	 * @generated
	 * @ordered
	 */
	protected ProbabilityMassFunction numberOfIterations;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BoundedLoopImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CorePackage.Literals.BOUNDED_LOOP;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CapraExpression getRepeatedProcess() {
		return repeatedProcess;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetRepeatedProcess(CapraExpression newRepeatedProcess, NotificationChain msgs) {
		CapraExpression oldRepeatedProcess = repeatedProcess;
		repeatedProcess = newRepeatedProcess;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CorePackage.BOUNDED_LOOP__REPEATED_PROCESS, oldRepeatedProcess, newRepeatedProcess);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRepeatedProcess(CapraExpression newRepeatedProcess) {
		if (newRepeatedProcess != repeatedProcess) {
			NotificationChain msgs = null;
			if (repeatedProcess != null)
				msgs = ((InternalEObject)repeatedProcess).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CorePackage.BOUNDED_LOOP__REPEATED_PROCESS, null, msgs);
			if (newRepeatedProcess != null)
				msgs = ((InternalEObject)newRepeatedProcess).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CorePackage.BOUNDED_LOOP__REPEATED_PROCESS, null, msgs);
			msgs = basicSetRepeatedProcess(newRepeatedProcess, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CorePackage.BOUNDED_LOOP__REPEATED_PROCESS, newRepeatedProcess, newRepeatedProcess));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CapraExpression getTargetProcess() {
		return targetProcess;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTargetProcess(CapraExpression newTargetProcess, NotificationChain msgs) {
		CapraExpression oldTargetProcess = targetProcess;
		targetProcess = newTargetProcess;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CorePackage.BOUNDED_LOOP__TARGET_PROCESS, oldTargetProcess, newTargetProcess);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTargetProcess(CapraExpression newTargetProcess) {
		if (newTargetProcess != targetProcess) {
			NotificationChain msgs = null;
			if (targetProcess != null)
				msgs = ((InternalEObject)targetProcess).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CorePackage.BOUNDED_LOOP__TARGET_PROCESS, null, msgs);
			if (newTargetProcess != null)
				msgs = ((InternalEObject)newTargetProcess).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CorePackage.BOUNDED_LOOP__TARGET_PROCESS, null, msgs);
			msgs = basicSetTargetProcess(newTargetProcess, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CorePackage.BOUNDED_LOOP__TARGET_PROCESS, newTargetProcess, newTargetProcess));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProbabilityMassFunction getNumberOfIterations() {
		return numberOfIterations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetNumberOfIterations(ProbabilityMassFunction newNumberOfIterations, NotificationChain msgs) {
		ProbabilityMassFunction oldNumberOfIterations = numberOfIterations;
		numberOfIterations = newNumberOfIterations;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CorePackage.BOUNDED_LOOP__NUMBER_OF_ITERATIONS, oldNumberOfIterations, newNumberOfIterations);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNumberOfIterations(ProbabilityMassFunction newNumberOfIterations) {
		if (newNumberOfIterations != numberOfIterations) {
			NotificationChain msgs = null;
			if (numberOfIterations != null)
				msgs = ((InternalEObject)numberOfIterations).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CorePackage.BOUNDED_LOOP__NUMBER_OF_ITERATIONS, null, msgs);
			if (newNumberOfIterations != null)
				msgs = ((InternalEObject)newNumberOfIterations).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CorePackage.BOUNDED_LOOP__NUMBER_OF_ITERATIONS, null, msgs);
			msgs = basicSetNumberOfIterations(newNumberOfIterations, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CorePackage.BOUNDED_LOOP__NUMBER_OF_ITERATIONS, newNumberOfIterations, newNumberOfIterations));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CorePackage.BOUNDED_LOOP__REPEATED_PROCESS:
				return basicSetRepeatedProcess(null, msgs);
			case CorePackage.BOUNDED_LOOP__TARGET_PROCESS:
				return basicSetTargetProcess(null, msgs);
			case CorePackage.BOUNDED_LOOP__NUMBER_OF_ITERATIONS:
				return basicSetNumberOfIterations(null, msgs);
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
			case CorePackage.BOUNDED_LOOP__REPEATED_PROCESS:
				return getRepeatedProcess();
			case CorePackage.BOUNDED_LOOP__TARGET_PROCESS:
				return getTargetProcess();
			case CorePackage.BOUNDED_LOOP__NUMBER_OF_ITERATIONS:
				return getNumberOfIterations();
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
			case CorePackage.BOUNDED_LOOP__REPEATED_PROCESS:
				setRepeatedProcess((CapraExpression)newValue);
				return;
			case CorePackage.BOUNDED_LOOP__TARGET_PROCESS:
				setTargetProcess((CapraExpression)newValue);
				return;
			case CorePackage.BOUNDED_LOOP__NUMBER_OF_ITERATIONS:
				setNumberOfIterations((ProbabilityMassFunction)newValue);
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
			case CorePackage.BOUNDED_LOOP__REPEATED_PROCESS:
				setRepeatedProcess((CapraExpression)null);
				return;
			case CorePackage.BOUNDED_LOOP__TARGET_PROCESS:
				setTargetProcess((CapraExpression)null);
				return;
			case CorePackage.BOUNDED_LOOP__NUMBER_OF_ITERATIONS:
				setNumberOfIterations((ProbabilityMassFunction)null);
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
			case CorePackage.BOUNDED_LOOP__REPEATED_PROCESS:
				return repeatedProcess != null;
			case CorePackage.BOUNDED_LOOP__TARGET_PROCESS:
				return targetProcess != null;
			case CorePackage.BOUNDED_LOOP__NUMBER_OF_ITERATIONS:
				return numberOfIterations != null;
		}
		return super.eIsSet(featureID);
	}

} //BoundedLoopImpl
