/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.designdecision.impl;

import de.uka.ipd.sdq.pcm.designdecision.ComponentChoice;
import de.uka.ipd.sdq.pcm.designdecision.designdecisionPackage;

import de.uka.ipd.sdq.pcm.repository.RepositoryComponent;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Component Choice</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.designdecision.impl.ComponentChoiceImpl#getChosenrepositorycomponent <em>Chosenrepositorycomponent</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ComponentChoiceImpl extends ChoiceImpl implements ComponentChoice {
	/**
	 * The cached value of the '{@link #getChosenrepositorycomponent() <em>Chosenrepositorycomponent</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getChosenrepositorycomponent()
	 * @generated
	 * @ordered
	 */
	protected RepositoryComponent chosenrepositorycomponent;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ComponentChoiceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return designdecisionPackage.Literals.COMPONENT_CHOICE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RepositoryComponent getChosenrepositorycomponent() {
		if (chosenrepositorycomponent != null && chosenrepositorycomponent.eIsProxy()) {
			InternalEObject oldChosenrepositorycomponent = (InternalEObject)chosenrepositorycomponent;
			chosenrepositorycomponent = (RepositoryComponent)eResolveProxy(oldChosenrepositorycomponent);
			if (chosenrepositorycomponent != oldChosenrepositorycomponent) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, designdecisionPackage.COMPONENT_CHOICE__CHOSENREPOSITORYCOMPONENT, oldChosenrepositorycomponent, chosenrepositorycomponent));
			}
		}
		return chosenrepositorycomponent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RepositoryComponent basicGetChosenrepositorycomponent() {
		return chosenrepositorycomponent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setChosenrepositorycomponent(RepositoryComponent newChosenrepositorycomponent) {
		RepositoryComponent oldChosenrepositorycomponent = chosenrepositorycomponent;
		chosenrepositorycomponent = newChosenrepositorycomponent;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, designdecisionPackage.COMPONENT_CHOICE__CHOSENREPOSITORYCOMPONENT, oldChosenrepositorycomponent, chosenrepositorycomponent));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case designdecisionPackage.COMPONENT_CHOICE__CHOSENREPOSITORYCOMPONENT:
				if (resolve) return getChosenrepositorycomponent();
				return basicGetChosenrepositorycomponent();
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
			case designdecisionPackage.COMPONENT_CHOICE__CHOSENREPOSITORYCOMPONENT:
				setChosenrepositorycomponent((RepositoryComponent)newValue);
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
			case designdecisionPackage.COMPONENT_CHOICE__CHOSENREPOSITORYCOMPONENT:
				setChosenrepositorycomponent((RepositoryComponent)null);
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
			case designdecisionPackage.COMPONENT_CHOICE__CHOSENREPOSITORYCOMPONENT:
				return chosenrepositorycomponent != null;
		}
		return super.eIsSet(featureID);
	}

} //ComponentChoiceImpl
