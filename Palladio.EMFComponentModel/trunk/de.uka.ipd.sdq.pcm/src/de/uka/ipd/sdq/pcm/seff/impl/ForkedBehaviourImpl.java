/**
 * Copyright 2007 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.seff.impl;

import de.uka.ipd.sdq.pcm.seff.ForkedBehaviour;
import de.uka.ipd.sdq.pcm.seff.SeffPackage;

import de.uka.ipd.sdq.stoex.PCMRandomVariable;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Forked Behaviour</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.seff.impl.ForkedBehaviourImpl#getNumberOfReplicas_ForkedBehaviour <em>Number Of Replicas Forked Behaviour</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ForkedBehaviourImpl extends ResourceDemandingBehaviourImpl implements ForkedBehaviour {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright 2007 by SDQ, IPD, University of Karlsruhe, Germany";

	/**
	 * The cached value of the '{@link #getNumberOfReplicas_ForkedBehaviour() <em>Number Of Replicas Forked Behaviour</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNumberOfReplicas_ForkedBehaviour()
	 * @generated
	 * @ordered
	 */
	protected PCMRandomVariable numberOfReplicas_ForkedBehaviour;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ForkedBehaviourImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SeffPackage.Literals.FORKED_BEHAVIOUR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PCMRandomVariable getNumberOfReplicas_ForkedBehaviour() {
		return numberOfReplicas_ForkedBehaviour;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetNumberOfReplicas_ForkedBehaviour(PCMRandomVariable newNumberOfReplicas_ForkedBehaviour, NotificationChain msgs) {
		PCMRandomVariable oldNumberOfReplicas_ForkedBehaviour = numberOfReplicas_ForkedBehaviour;
		numberOfReplicas_ForkedBehaviour = newNumberOfReplicas_ForkedBehaviour;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SeffPackage.FORKED_BEHAVIOUR__NUMBER_OF_REPLICAS_FORKED_BEHAVIOUR, oldNumberOfReplicas_ForkedBehaviour, newNumberOfReplicas_ForkedBehaviour);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNumberOfReplicas_ForkedBehaviour(PCMRandomVariable newNumberOfReplicas_ForkedBehaviour) {
		if (newNumberOfReplicas_ForkedBehaviour != numberOfReplicas_ForkedBehaviour) {
			NotificationChain msgs = null;
			if (numberOfReplicas_ForkedBehaviour != null)
				msgs = ((InternalEObject)numberOfReplicas_ForkedBehaviour).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SeffPackage.FORKED_BEHAVIOUR__NUMBER_OF_REPLICAS_FORKED_BEHAVIOUR, null, msgs);
			if (newNumberOfReplicas_ForkedBehaviour != null)
				msgs = ((InternalEObject)newNumberOfReplicas_ForkedBehaviour).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SeffPackage.FORKED_BEHAVIOUR__NUMBER_OF_REPLICAS_FORKED_BEHAVIOUR, null, msgs);
			msgs = basicSetNumberOfReplicas_ForkedBehaviour(newNumberOfReplicas_ForkedBehaviour, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SeffPackage.FORKED_BEHAVIOUR__NUMBER_OF_REPLICAS_FORKED_BEHAVIOUR, newNumberOfReplicas_ForkedBehaviour, newNumberOfReplicas_ForkedBehaviour));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SeffPackage.FORKED_BEHAVIOUR__NUMBER_OF_REPLICAS_FORKED_BEHAVIOUR:
				return basicSetNumberOfReplicas_ForkedBehaviour(null, msgs);
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
			case SeffPackage.FORKED_BEHAVIOUR__NUMBER_OF_REPLICAS_FORKED_BEHAVIOUR:
				return getNumberOfReplicas_ForkedBehaviour();
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
			case SeffPackage.FORKED_BEHAVIOUR__NUMBER_OF_REPLICAS_FORKED_BEHAVIOUR:
				setNumberOfReplicas_ForkedBehaviour((PCMRandomVariable)newValue);
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
			case SeffPackage.FORKED_BEHAVIOUR__NUMBER_OF_REPLICAS_FORKED_BEHAVIOUR:
				setNumberOfReplicas_ForkedBehaviour((PCMRandomVariable)null);
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
			case SeffPackage.FORKED_BEHAVIOUR__NUMBER_OF_REPLICAS_FORKED_BEHAVIOUR:
				return numberOfReplicas_ForkedBehaviour != null;
		}
		return super.eIsSet(featureID);
	}

} //ForkedBehaviourImpl
