/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.impl;

import de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.AspectRequirement;
import de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.QMLContractPackage;
import de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.ValueLiteral;

import de.uka.ipd.sdq.identifier.impl.IdentifierImpl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Aspect Requirement</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.impl.AspectRequirementImpl#getAspectRequirementLiteral <em>Aspect Requirement Literal</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class AspectRequirementImpl extends IdentifierImpl implements AspectRequirement {
	/**
	 * The cached value of the '{@link #getAspectRequirementLiteral() <em>Aspect Requirement Literal</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAspectRequirementLiteral()
	 * @generated
	 * @ordered
	 */
	protected ValueLiteral aspectRequirementLiteral;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AspectRequirementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return QMLContractPackage.Literals.ASPECT_REQUIREMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ValueLiteral getAspectRequirementLiteral() {
		return aspectRequirementLiteral;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetAspectRequirementLiteral(ValueLiteral newAspectRequirementLiteral, NotificationChain msgs) {
		ValueLiteral oldAspectRequirementLiteral = aspectRequirementLiteral;
		aspectRequirementLiteral = newAspectRequirementLiteral;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, QMLContractPackage.ASPECT_REQUIREMENT__ASPECT_REQUIREMENT_LITERAL, oldAspectRequirementLiteral, newAspectRequirementLiteral);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAspectRequirementLiteral(ValueLiteral newAspectRequirementLiteral) {
		if (newAspectRequirementLiteral != aspectRequirementLiteral) {
			NotificationChain msgs = null;
			if (aspectRequirementLiteral != null)
				msgs = ((InternalEObject)aspectRequirementLiteral).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - QMLContractPackage.ASPECT_REQUIREMENT__ASPECT_REQUIREMENT_LITERAL, null, msgs);
			if (newAspectRequirementLiteral != null)
				msgs = ((InternalEObject)newAspectRequirementLiteral).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - QMLContractPackage.ASPECT_REQUIREMENT__ASPECT_REQUIREMENT_LITERAL, null, msgs);
			msgs = basicSetAspectRequirementLiteral(newAspectRequirementLiteral, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QMLContractPackage.ASPECT_REQUIREMENT__ASPECT_REQUIREMENT_LITERAL, newAspectRequirementLiteral, newAspectRequirementLiteral));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case QMLContractPackage.ASPECT_REQUIREMENT__ASPECT_REQUIREMENT_LITERAL:
				return basicSetAspectRequirementLiteral(null, msgs);
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
			case QMLContractPackage.ASPECT_REQUIREMENT__ASPECT_REQUIREMENT_LITERAL:
				return getAspectRequirementLiteral();
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
			case QMLContractPackage.ASPECT_REQUIREMENT__ASPECT_REQUIREMENT_LITERAL:
				setAspectRequirementLiteral((ValueLiteral)newValue);
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
			case QMLContractPackage.ASPECT_REQUIREMENT__ASPECT_REQUIREMENT_LITERAL:
				setAspectRequirementLiteral((ValueLiteral)null);
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
			case QMLContractPackage.ASPECT_REQUIREMENT__ASPECT_REQUIREMENT_LITERAL:
				return aspectRequirementLiteral != null;
		}
		return super.eIsSet(featureID);
	}

} //AspectRequirementImpl
