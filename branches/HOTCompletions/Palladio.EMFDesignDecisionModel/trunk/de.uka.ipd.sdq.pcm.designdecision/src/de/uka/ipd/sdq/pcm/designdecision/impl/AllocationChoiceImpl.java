/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.designdecision.impl;

import de.uka.ipd.sdq.pcm.designdecision.AllocationChoice;
import de.uka.ipd.sdq.pcm.designdecision.designdecisionPackage;

import de.uka.ipd.sdq.pcm.resourceenvironment.ResourceContainer;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Allocation Choice</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.designdecision.impl.AllocationChoiceImpl#getChosenresourcecontainer <em>Chosenresourcecontainer</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AllocationChoiceImpl extends ChoiceImpl implements AllocationChoice {
	/**
	 * The cached value of the '{@link #getChosenresourcecontainer() <em>Chosenresourcecontainer</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getChosenresourcecontainer()
	 * @generated
	 * @ordered
	 */
	protected ResourceContainer chosenresourcecontainer;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AllocationChoiceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return designdecisionPackage.Literals.ALLOCATION_CHOICE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResourceContainer getChosenresourcecontainer() {
		if (chosenresourcecontainer != null && chosenresourcecontainer.eIsProxy()) {
			InternalEObject oldChosenresourcecontainer = (InternalEObject)chosenresourcecontainer;
			chosenresourcecontainer = (ResourceContainer)eResolveProxy(oldChosenresourcecontainer);
			if (chosenresourcecontainer != oldChosenresourcecontainer) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, designdecisionPackage.ALLOCATION_CHOICE__CHOSENRESOURCECONTAINER, oldChosenresourcecontainer, chosenresourcecontainer));
			}
		}
		return chosenresourcecontainer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResourceContainer basicGetChosenresourcecontainer() {
		return chosenresourcecontainer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setChosenresourcecontainer(ResourceContainer newChosenresourcecontainer) {
		ResourceContainer oldChosenresourcecontainer = chosenresourcecontainer;
		chosenresourcecontainer = newChosenresourcecontainer;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, designdecisionPackage.ALLOCATION_CHOICE__CHOSENRESOURCECONTAINER, oldChosenresourcecontainer, chosenresourcecontainer));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case designdecisionPackage.ALLOCATION_CHOICE__CHOSENRESOURCECONTAINER:
				if (resolve) return getChosenresourcecontainer();
				return basicGetChosenresourcecontainer();
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
			case designdecisionPackage.ALLOCATION_CHOICE__CHOSENRESOURCECONTAINER:
				setChosenresourcecontainer((ResourceContainer)newValue);
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
			case designdecisionPackage.ALLOCATION_CHOICE__CHOSENRESOURCECONTAINER:
				setChosenresourcecontainer((ResourceContainer)null);
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
			case designdecisionPackage.ALLOCATION_CHOICE__CHOSENRESOURCECONTAINER:
				return chosenresourcecontainer != null;
		}
		return super.eIsSet(featureID);
	}

} //AllocationChoiceImpl
