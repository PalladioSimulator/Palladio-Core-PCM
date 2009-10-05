/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.designdecision.impl;

import de.uka.ipd.sdq.pcm.designdecision.Choice;
import de.uka.ipd.sdq.pcm.designdecision.DegreeOfFreedom;
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
 *   <li>{@link de.uka.ipd.sdq.pcm.designdecision.impl.ChoiceImpl#getDegreeOfFreedom <em>Degree Of Freedom</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class ChoiceImpl extends EObjectImpl implements Choice {
	/**
	 * The cached value of the '{@link #getDegreeOfFreedom() <em>Degree Of Freedom</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDegreeOfFreedom()
	 * @generated
	 * @ordered
	 */
	protected DegreeOfFreedom degreeOfFreedom;

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
	public DegreeOfFreedom getDegreeOfFreedom() {
		if (degreeOfFreedom != null && degreeOfFreedom.eIsProxy()) {
			InternalEObject oldDegreeOfFreedom = (InternalEObject)degreeOfFreedom;
			degreeOfFreedom = (DegreeOfFreedom)eResolveProxy(oldDegreeOfFreedom);
			if (degreeOfFreedom != oldDegreeOfFreedom) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, designdecisionPackage.CHOICE__DEGREE_OF_FREEDOM, oldDegreeOfFreedom, degreeOfFreedom));
			}
		}
		return degreeOfFreedom;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DegreeOfFreedom basicGetDegreeOfFreedom() {
		return degreeOfFreedom;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDegreeOfFreedom(DegreeOfFreedom newDegreeOfFreedom) {
		DegreeOfFreedom oldDegreeOfFreedom = degreeOfFreedom;
		degreeOfFreedom = newDegreeOfFreedom;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, designdecisionPackage.CHOICE__DEGREE_OF_FREEDOM, oldDegreeOfFreedom, degreeOfFreedom));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case designdecisionPackage.CHOICE__DEGREE_OF_FREEDOM:
				if (resolve) return getDegreeOfFreedom();
				return basicGetDegreeOfFreedom();
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
			case designdecisionPackage.CHOICE__DEGREE_OF_FREEDOM:
				setDegreeOfFreedom((DegreeOfFreedom)newValue);
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
			case designdecisionPackage.CHOICE__DEGREE_OF_FREEDOM:
				setDegreeOfFreedom((DegreeOfFreedom)null);
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
			case designdecisionPackage.CHOICE__DEGREE_OF_FREEDOM:
				return degreeOfFreedom != null;
		}
		return super.eIsSet(featureID);
	}

} //ChoiceImpl
