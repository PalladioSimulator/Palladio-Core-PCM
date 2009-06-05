/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.designdecision.impl;

import de.uka.ipd.sdq.pcm.designdecision.Choice;
import de.uka.ipd.sdq.pcm.designdecision.DesignDecision;
import de.uka.ipd.sdq.pcm.designdecision.designdecisionPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Choice</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.designdecision.impl.ChoiceImpl#getDesigndecision <em>Designdecision</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class ChoiceImpl extends EObjectImpl implements Choice {
	/**
	 * The cached value of the '{@link #getDesigndecision() <em>Designdecision</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDesigndecision()
	 * @generated
	 * @ordered
	 */
	protected DesignDecision designdecision;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ChoiceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return designdecisionPackage.Literals.CHOICE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DesignDecision getDesigndecision() {
		if (designdecision != null && designdecision.eIsProxy()) {
			InternalEObject oldDesigndecision = (InternalEObject)designdecision;
			designdecision = (DesignDecision)eResolveProxy(oldDesigndecision);
			if (designdecision != oldDesigndecision) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, designdecisionPackage.CHOICE__DESIGNDECISION, oldDesigndecision, designdecision));
			}
		}
		return designdecision;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DesignDecision basicGetDesigndecision() {
		return designdecision;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDesigndecision(DesignDecision newDesigndecision) {
		DesignDecision oldDesigndecision = designdecision;
		designdecision = newDesigndecision;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, designdecisionPackage.CHOICE__DESIGNDECISION, oldDesigndecision, designdecision));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case designdecisionPackage.CHOICE__DESIGNDECISION:
				if (resolve) return getDesigndecision();
				return basicGetDesigndecision();
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
			case designdecisionPackage.CHOICE__DESIGNDECISION:
				setDesigndecision((DesignDecision)newValue);
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
			case designdecisionPackage.CHOICE__DESIGNDECISION:
				setDesigndecision((DesignDecision)null);
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
			case designdecisionPackage.CHOICE__DESIGNDECISION:
				return designdecision != null;
		}
		return super.eIsSet(featureID);
	}

} //ChoiceImpl
