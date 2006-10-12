/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.spa.system.impl;

import de.uka.ipd.sdq.spa.expression.RegularExpression;

import de.uka.ipd.sdq.spa.system.Behaviour;
import de.uka.ipd.sdq.spa.system.SystemPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Behaviour</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.spa.system.impl.BehaviourImpl#getNumReplicas <em>Num Replicas</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.spa.system.impl.BehaviourImpl#getName <em>Name</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.spa.system.impl.BehaviourImpl#getBehaviour <em>Behaviour</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class BehaviourImpl extends EObjectImpl implements Behaviour {
	/**
	 * The default value of the '{@link #getNumReplicas() <em>Num Replicas</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNumReplicas()
	 * @generated
	 * @ordered
	 */
	protected static final int NUM_REPLICAS_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getNumReplicas() <em>Num Replicas</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNumReplicas()
	 * @generated
	 * @ordered
	 */
	protected int numReplicas = NUM_REPLICAS_EDEFAULT;

	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = "";

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
	 * The cached value of the '{@link #getBehaviour() <em>Behaviour</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBehaviour()
	 * @generated
	 * @ordered
	 */
	protected RegularExpression behaviour = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BehaviourImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return SystemPackage.Literals.BEHAVIOUR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getNumReplicas() {
		return numReplicas;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNumReplicas(int newNumReplicas) {
		int oldNumReplicas = numReplicas;
		numReplicas = newNumReplicas;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SystemPackage.BEHAVIOUR__NUM_REPLICAS, oldNumReplicas, numReplicas));
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
			eNotify(new ENotificationImpl(this, Notification.SET, SystemPackage.BEHAVIOUR__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RegularExpression getBehaviour() {
		return behaviour;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetBehaviour(RegularExpression newBehaviour, NotificationChain msgs) {
		RegularExpression oldBehaviour = behaviour;
		behaviour = newBehaviour;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SystemPackage.BEHAVIOUR__BEHAVIOUR, oldBehaviour, newBehaviour);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBehaviour(RegularExpression newBehaviour) {
		if (newBehaviour != behaviour) {
			NotificationChain msgs = null;
			if (behaviour != null)
				msgs = ((InternalEObject)behaviour).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SystemPackage.BEHAVIOUR__BEHAVIOUR, null, msgs);
			if (newBehaviour != null)
				msgs = ((InternalEObject)newBehaviour).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SystemPackage.BEHAVIOUR__BEHAVIOUR, null, msgs);
			msgs = basicSetBehaviour(newBehaviour, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SystemPackage.BEHAVIOUR__BEHAVIOUR, newBehaviour, newBehaviour));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SystemPackage.BEHAVIOUR__BEHAVIOUR:
				return basicSetBehaviour(null, msgs);
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
			case SystemPackage.BEHAVIOUR__NUM_REPLICAS:
				return new Integer(getNumReplicas());
			case SystemPackage.BEHAVIOUR__NAME:
				return getName();
			case SystemPackage.BEHAVIOUR__BEHAVIOUR:
				return getBehaviour();
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
			case SystemPackage.BEHAVIOUR__NUM_REPLICAS:
				setNumReplicas(((Integer)newValue).intValue());
				return;
			case SystemPackage.BEHAVIOUR__NAME:
				setName((String)newValue);
				return;
			case SystemPackage.BEHAVIOUR__BEHAVIOUR:
				setBehaviour((RegularExpression)newValue);
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
			case SystemPackage.BEHAVIOUR__NUM_REPLICAS:
				setNumReplicas(NUM_REPLICAS_EDEFAULT);
				return;
			case SystemPackage.BEHAVIOUR__NAME:
				setName(NAME_EDEFAULT);
				return;
			case SystemPackage.BEHAVIOUR__BEHAVIOUR:
				setBehaviour((RegularExpression)null);
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
			case SystemPackage.BEHAVIOUR__NUM_REPLICAS:
				return numReplicas != NUM_REPLICAS_EDEFAULT;
			case SystemPackage.BEHAVIOUR__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case SystemPackage.BEHAVIOUR__BEHAVIOUR:
				return behaviour != null;
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
		result.append(" (numReplicas: ");
		result.append(numReplicas);
		result.append(", name: ");
		result.append(name);
		result.append(')');
		return result.toString();
	}

} //BehaviourImpl