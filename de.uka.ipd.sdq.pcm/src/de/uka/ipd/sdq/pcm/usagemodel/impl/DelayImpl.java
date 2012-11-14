/**
 * Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.usagemodel.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import de.uka.ipd.sdq.pcm.core.CorePackage;
import de.uka.ipd.sdq.pcm.core.PCMRandomVariable;
import de.uka.ipd.sdq.pcm.usagemodel.Delay;
import de.uka.ipd.sdq.pcm.usagemodel.UsagemodelPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Delay</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.usagemodel.impl.DelayImpl#getTimeSpecification_Delay <em>Time Specification Delay</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DelayImpl extends AbstractUserActionImpl implements Delay {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany";

	/**
	 * The cached value of the '{@link #getTimeSpecification_Delay() <em>Time Specification Delay</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTimeSpecification_Delay()
	 * @generated
	 * @ordered
	 */
	protected PCMRandomVariable timeSpecification_Delay;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DelayImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return UsagemodelPackage.Literals.DELAY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PCMRandomVariable getTimeSpecification_Delay() {
		return timeSpecification_Delay;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTimeSpecification_Delay(PCMRandomVariable newTimeSpecification_Delay, NotificationChain msgs) {
		PCMRandomVariable oldTimeSpecification_Delay = timeSpecification_Delay;
		timeSpecification_Delay = newTimeSpecification_Delay;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UsagemodelPackage.DELAY__TIME_SPECIFICATION_DELAY, oldTimeSpecification_Delay, newTimeSpecification_Delay);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTimeSpecification_Delay(PCMRandomVariable newTimeSpecification_Delay) {
		if (newTimeSpecification_Delay != timeSpecification_Delay) {
			NotificationChain msgs = null;
			if (timeSpecification_Delay != null)
				msgs = ((InternalEObject)timeSpecification_Delay).eInverseRemove(this, CorePackage.PCM_RANDOM_VARIABLE__DELAY_TIME_SPECIFICATION, PCMRandomVariable.class, msgs);
			if (newTimeSpecification_Delay != null)
				msgs = ((InternalEObject)newTimeSpecification_Delay).eInverseAdd(this, CorePackage.PCM_RANDOM_VARIABLE__DELAY_TIME_SPECIFICATION, PCMRandomVariable.class, msgs);
			msgs = basicSetTimeSpecification_Delay(newTimeSpecification_Delay, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UsagemodelPackage.DELAY__TIME_SPECIFICATION_DELAY, newTimeSpecification_Delay, newTimeSpecification_Delay));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case UsagemodelPackage.DELAY__TIME_SPECIFICATION_DELAY:
				if (timeSpecification_Delay != null)
					msgs = ((InternalEObject)timeSpecification_Delay).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UsagemodelPackage.DELAY__TIME_SPECIFICATION_DELAY, null, msgs);
				return basicSetTimeSpecification_Delay((PCMRandomVariable)otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case UsagemodelPackage.DELAY__TIME_SPECIFICATION_DELAY:
				return basicSetTimeSpecification_Delay(null, msgs);
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
			case UsagemodelPackage.DELAY__TIME_SPECIFICATION_DELAY:
				return getTimeSpecification_Delay();
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
			case UsagemodelPackage.DELAY__TIME_SPECIFICATION_DELAY:
				setTimeSpecification_Delay((PCMRandomVariable)newValue);
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
			case UsagemodelPackage.DELAY__TIME_SPECIFICATION_DELAY:
				setTimeSpecification_Delay((PCMRandomVariable)null);
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
			case UsagemodelPackage.DELAY__TIME_SPECIFICATION_DELAY:
				return timeSpecification_Delay != null;
		}
		return super.eIsSet(featureID);
	}

} //DelayImpl
