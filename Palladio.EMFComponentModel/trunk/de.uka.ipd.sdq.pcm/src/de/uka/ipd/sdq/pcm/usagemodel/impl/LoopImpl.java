
/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.usagemodel.impl;

import de.uka.ipd.sdq.pcm.usagemodel.Loop;
import de.uka.ipd.sdq.pcm.usagemodel.ScenarioBehaviour;
import de.uka.ipd.sdq.pcm.usagemodel.UsagemodelPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Loop</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.usagemodel.impl.LoopImpl#getBodyBehaviour_Loop <em>Body Behaviour Loop</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.usagemodel.impl.LoopImpl#getIterations <em>Iterations</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class LoopImpl extends AbstractUserActionImpl implements Loop {
	/**
	 * The cached value of the '{@link #getBodyBehaviour_Loop() <em>Body Behaviour Loop</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBodyBehaviour_Loop()
	 * @generated
	 * @ordered
	 */
	protected ScenarioBehaviour bodyBehaviour_Loop = null;

	/**
	 * The default value of the '{@link #getIterations() <em>Iterations</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIterations()
	 * @generated
	 * @ordered
	 */
	protected static final String ITERATIONS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getIterations() <em>Iterations</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIterations()
	 * @generated
	 * @ordered
	 */
	protected String iterations = ITERATIONS_EDEFAULT;


	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LoopImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return UsagemodelPackage.Literals.LOOP;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ScenarioBehaviour getBodyBehaviour_Loop() {
		return bodyBehaviour_Loop;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetBodyBehaviour_Loop(ScenarioBehaviour newBodyBehaviour_Loop, NotificationChain msgs) {
		ScenarioBehaviour oldBodyBehaviour_Loop = bodyBehaviour_Loop;
		bodyBehaviour_Loop = newBodyBehaviour_Loop;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UsagemodelPackage.LOOP__BODY_BEHAVIOUR_LOOP, oldBodyBehaviour_Loop, newBodyBehaviour_Loop);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBodyBehaviour_Loop(ScenarioBehaviour newBodyBehaviour_Loop) {
		if (newBodyBehaviour_Loop != bodyBehaviour_Loop) {
			NotificationChain msgs = null;
			if (bodyBehaviour_Loop != null)
				msgs = ((InternalEObject)bodyBehaviour_Loop).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UsagemodelPackage.LOOP__BODY_BEHAVIOUR_LOOP, null, msgs);
			if (newBodyBehaviour_Loop != null)
				msgs = ((InternalEObject)newBodyBehaviour_Loop).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UsagemodelPackage.LOOP__BODY_BEHAVIOUR_LOOP, null, msgs);
			msgs = basicSetBodyBehaviour_Loop(newBodyBehaviour_Loop, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UsagemodelPackage.LOOP__BODY_BEHAVIOUR_LOOP, newBodyBehaviour_Loop, newBodyBehaviour_Loop));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getIterations() {
		return iterations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIterations(String newIterations) {
		String oldIterations = iterations;
		iterations = newIterations;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UsagemodelPackage.LOOP__ITERATIONS, oldIterations, iterations));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case UsagemodelPackage.LOOP__BODY_BEHAVIOUR_LOOP:
				return basicSetBodyBehaviour_Loop(null, msgs);
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
			case UsagemodelPackage.LOOP__BODY_BEHAVIOUR_LOOP:
				return getBodyBehaviour_Loop();
			case UsagemodelPackage.LOOP__ITERATIONS:
				return getIterations();
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
			case UsagemodelPackage.LOOP__BODY_BEHAVIOUR_LOOP:
				setBodyBehaviour_Loop((ScenarioBehaviour)newValue);
				return;
			case UsagemodelPackage.LOOP__ITERATIONS:
				setIterations((String)newValue);
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
			case UsagemodelPackage.LOOP__BODY_BEHAVIOUR_LOOP:
				setBodyBehaviour_Loop((ScenarioBehaviour)null);
				return;
			case UsagemodelPackage.LOOP__ITERATIONS:
				setIterations(ITERATIONS_EDEFAULT);
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
			case UsagemodelPackage.LOOP__BODY_BEHAVIOUR_LOOP:
				return bodyBehaviour_Loop != null;
			case UsagemodelPackage.LOOP__ITERATIONS:
				return ITERATIONS_EDEFAULT == null ? iterations != null : !ITERATIONS_EDEFAULT.equals(iterations);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (iterations: ");
		result.append(iterations);
		result.append(')');
		return result.toString();
	}

} //LoopImpl