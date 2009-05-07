/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.capra.core.impl;

import de.uka.ipd.sdq.capra.core.CapraExpression;
import de.uka.ipd.sdq.capra.core.CorePackage;
import de.uka.ipd.sdq.capra.core.ParallelComposition;

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
 * An implementation of the model object '<em><b>Parallel Composition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.capra.core.impl.ParallelCompositionImpl#getParallelProcesses <em>Parallel Processes</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.capra.core.impl.ParallelCompositionImpl#getTargetProcess <em>Target Process</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.capra.core.impl.ParallelCompositionImpl#isIsSynchronised <em>Is Synchronised</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ParallelCompositionImpl extends OperatorImpl implements ParallelComposition {
	/**
	 * The cached value of the '{@link #getParallelProcesses() <em>Parallel Processes</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParallelProcesses()
	 * @generated
	 * @ordered
	 */
	protected EList<CapraExpression> parallelProcesses;

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
	 * The default value of the '{@link #isIsSynchronised() <em>Is Synchronised</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsSynchronised()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_SYNCHRONISED_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isIsSynchronised() <em>Is Synchronised</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsSynchronised()
	 * @generated
	 * @ordered
	 */
	protected boolean isSynchronised = IS_SYNCHRONISED_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ParallelCompositionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CorePackage.Literals.PARALLEL_COMPOSITION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<CapraExpression> getParallelProcesses() {
		if (parallelProcesses == null) {
			parallelProcesses = new EObjectContainmentEList<CapraExpression>(CapraExpression.class, this, CorePackage.PARALLEL_COMPOSITION__PARALLEL_PROCESSES);
		}
		return parallelProcesses;
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CorePackage.PARALLEL_COMPOSITION__TARGET_PROCESS, oldTargetProcess, newTargetProcess);
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
				msgs = ((InternalEObject)targetProcess).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CorePackage.PARALLEL_COMPOSITION__TARGET_PROCESS, null, msgs);
			if (newTargetProcess != null)
				msgs = ((InternalEObject)newTargetProcess).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CorePackage.PARALLEL_COMPOSITION__TARGET_PROCESS, null, msgs);
			msgs = basicSetTargetProcess(newTargetProcess, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CorePackage.PARALLEL_COMPOSITION__TARGET_PROCESS, newTargetProcess, newTargetProcess));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isIsSynchronised() {
		return isSynchronised;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsSynchronised(boolean newIsSynchronised) {
		boolean oldIsSynchronised = isSynchronised;
		isSynchronised = newIsSynchronised;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CorePackage.PARALLEL_COMPOSITION__IS_SYNCHRONISED, oldIsSynchronised, isSynchronised));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CorePackage.PARALLEL_COMPOSITION__PARALLEL_PROCESSES:
				return ((InternalEList<?>)getParallelProcesses()).basicRemove(otherEnd, msgs);
			case CorePackage.PARALLEL_COMPOSITION__TARGET_PROCESS:
				return basicSetTargetProcess(null, msgs);
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
			case CorePackage.PARALLEL_COMPOSITION__PARALLEL_PROCESSES:
				return getParallelProcesses();
			case CorePackage.PARALLEL_COMPOSITION__TARGET_PROCESS:
				return getTargetProcess();
			case CorePackage.PARALLEL_COMPOSITION__IS_SYNCHRONISED:
				return isIsSynchronised() ? Boolean.TRUE : Boolean.FALSE;
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
			case CorePackage.PARALLEL_COMPOSITION__PARALLEL_PROCESSES:
				getParallelProcesses().clear();
				getParallelProcesses().addAll((Collection<? extends CapraExpression>)newValue);
				return;
			case CorePackage.PARALLEL_COMPOSITION__TARGET_PROCESS:
				setTargetProcess((CapraExpression)newValue);
				return;
			case CorePackage.PARALLEL_COMPOSITION__IS_SYNCHRONISED:
				setIsSynchronised(((Boolean)newValue).booleanValue());
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
			case CorePackage.PARALLEL_COMPOSITION__PARALLEL_PROCESSES:
				getParallelProcesses().clear();
				return;
			case CorePackage.PARALLEL_COMPOSITION__TARGET_PROCESS:
				setTargetProcess((CapraExpression)null);
				return;
			case CorePackage.PARALLEL_COMPOSITION__IS_SYNCHRONISED:
				setIsSynchronised(IS_SYNCHRONISED_EDEFAULT);
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
			case CorePackage.PARALLEL_COMPOSITION__PARALLEL_PROCESSES:
				return parallelProcesses != null && !parallelProcesses.isEmpty();
			case CorePackage.PARALLEL_COMPOSITION__TARGET_PROCESS:
				return targetProcess != null;
			case CorePackage.PARALLEL_COMPOSITION__IS_SYNCHRONISED:
				return isSynchronised != IS_SYNCHRONISED_EDEFAULT;
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
		result.append(" (isSynchronised: ");
		result.append(isSynchronised);
		result.append(')');
		return result.toString();
	}

} //ParallelCompositionImpl
