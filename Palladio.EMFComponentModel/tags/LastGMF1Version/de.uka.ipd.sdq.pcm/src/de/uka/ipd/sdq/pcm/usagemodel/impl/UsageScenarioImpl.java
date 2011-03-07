
/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.usagemodel.impl;

import de.uka.ipd.sdq.pcm.core.entity.impl.EntityImpl;

import de.uka.ipd.sdq.pcm.usagemodel.ScenarioBehaviour;
import de.uka.ipd.sdq.pcm.usagemodel.UsageScenario;
import de.uka.ipd.sdq.pcm.usagemodel.UsagemodelPackage;
import de.uka.ipd.sdq.pcm.usagemodel.Workload;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Usage Scenario</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.usagemodel.impl.UsageScenarioImpl#getWorkload_UsageScenario <em>Workload Usage Scenario</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.usagemodel.impl.UsageScenarioImpl#getScenarioBehaviour_UsageScenario <em>Scenario Behaviour Usage Scenario</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class UsageScenarioImpl extends EntityImpl implements UsageScenario {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "(c) by SDQ, IPD, U Karlsruhe (TH), 2006";

	/**
	 * The cached value of the '{@link #getWorkload_UsageScenario() <em>Workload Usage Scenario</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWorkload_UsageScenario()
	 * @generated
	 * @ordered
	 */
	protected Workload workload_UsageScenario = null;

	/**
	 * The cached value of the '{@link #getScenarioBehaviour_UsageScenario() <em>Scenario Behaviour Usage Scenario</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getScenarioBehaviour_UsageScenario()
	 * @generated
	 * @ordered
	 */
	protected ScenarioBehaviour scenarioBehaviour_UsageScenario = null;


	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected UsageScenarioImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return UsagemodelPackage.Literals.USAGE_SCENARIO;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Workload getWorkload_UsageScenario() {
		return workload_UsageScenario;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetWorkload_UsageScenario(Workload newWorkload_UsageScenario, NotificationChain msgs) {
		Workload oldWorkload_UsageScenario = workload_UsageScenario;
		workload_UsageScenario = newWorkload_UsageScenario;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UsagemodelPackage.USAGE_SCENARIO__WORKLOAD_USAGE_SCENARIO, oldWorkload_UsageScenario, newWorkload_UsageScenario);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setWorkload_UsageScenario(Workload newWorkload_UsageScenario) {
		if (newWorkload_UsageScenario != workload_UsageScenario) {
			NotificationChain msgs = null;
			if (workload_UsageScenario != null)
				msgs = ((InternalEObject)workload_UsageScenario).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UsagemodelPackage.USAGE_SCENARIO__WORKLOAD_USAGE_SCENARIO, null, msgs);
			if (newWorkload_UsageScenario != null)
				msgs = ((InternalEObject)newWorkload_UsageScenario).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UsagemodelPackage.USAGE_SCENARIO__WORKLOAD_USAGE_SCENARIO, null, msgs);
			msgs = basicSetWorkload_UsageScenario(newWorkload_UsageScenario, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UsagemodelPackage.USAGE_SCENARIO__WORKLOAD_USAGE_SCENARIO, newWorkload_UsageScenario, newWorkload_UsageScenario));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ScenarioBehaviour getScenarioBehaviour_UsageScenario() {
		return scenarioBehaviour_UsageScenario;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetScenarioBehaviour_UsageScenario(ScenarioBehaviour newScenarioBehaviour_UsageScenario, NotificationChain msgs) {
		ScenarioBehaviour oldScenarioBehaviour_UsageScenario = scenarioBehaviour_UsageScenario;
		scenarioBehaviour_UsageScenario = newScenarioBehaviour_UsageScenario;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UsagemodelPackage.USAGE_SCENARIO__SCENARIO_BEHAVIOUR_USAGE_SCENARIO, oldScenarioBehaviour_UsageScenario, newScenarioBehaviour_UsageScenario);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setScenarioBehaviour_UsageScenario(ScenarioBehaviour newScenarioBehaviour_UsageScenario) {
		if (newScenarioBehaviour_UsageScenario != scenarioBehaviour_UsageScenario) {
			NotificationChain msgs = null;
			if (scenarioBehaviour_UsageScenario != null)
				msgs = ((InternalEObject)scenarioBehaviour_UsageScenario).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UsagemodelPackage.USAGE_SCENARIO__SCENARIO_BEHAVIOUR_USAGE_SCENARIO, null, msgs);
			if (newScenarioBehaviour_UsageScenario != null)
				msgs = ((InternalEObject)newScenarioBehaviour_UsageScenario).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UsagemodelPackage.USAGE_SCENARIO__SCENARIO_BEHAVIOUR_USAGE_SCENARIO, null, msgs);
			msgs = basicSetScenarioBehaviour_UsageScenario(newScenarioBehaviour_UsageScenario, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UsagemodelPackage.USAGE_SCENARIO__SCENARIO_BEHAVIOUR_USAGE_SCENARIO, newScenarioBehaviour_UsageScenario, newScenarioBehaviour_UsageScenario));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case UsagemodelPackage.USAGE_SCENARIO__WORKLOAD_USAGE_SCENARIO:
				return basicSetWorkload_UsageScenario(null, msgs);
			case UsagemodelPackage.USAGE_SCENARIO__SCENARIO_BEHAVIOUR_USAGE_SCENARIO:
				return basicSetScenarioBehaviour_UsageScenario(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case UsagemodelPackage.USAGE_SCENARIO__WORKLOAD_USAGE_SCENARIO:
				return getWorkload_UsageScenario();
			case UsagemodelPackage.USAGE_SCENARIO__SCENARIO_BEHAVIOUR_USAGE_SCENARIO:
				return getScenarioBehaviour_UsageScenario();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case UsagemodelPackage.USAGE_SCENARIO__WORKLOAD_USAGE_SCENARIO:
				setWorkload_UsageScenario((Workload)newValue);
				return;
			case UsagemodelPackage.USAGE_SCENARIO__SCENARIO_BEHAVIOUR_USAGE_SCENARIO:
				setScenarioBehaviour_UsageScenario((ScenarioBehaviour)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void eUnset(int featureID) {
		switch (featureID) {
			case UsagemodelPackage.USAGE_SCENARIO__WORKLOAD_USAGE_SCENARIO:
				setWorkload_UsageScenario((Workload)null);
				return;
			case UsagemodelPackage.USAGE_SCENARIO__SCENARIO_BEHAVIOUR_USAGE_SCENARIO:
				setScenarioBehaviour_UsageScenario((ScenarioBehaviour)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case UsagemodelPackage.USAGE_SCENARIO__WORKLOAD_USAGE_SCENARIO:
				return workload_UsageScenario != null;
			case UsagemodelPackage.USAGE_SCENARIO__SCENARIO_BEHAVIOUR_USAGE_SCENARIO:
				return scenarioBehaviour_UsageScenario != null;
		}
		return super.eIsSet(featureID);
	}

} //UsageScenarioImpl