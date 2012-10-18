/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.resultdecorator.repositorydecorator.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import de.uka.ipd.sdq.pcm.core.entity.InterfaceProvidingRequiringEntity;
import de.uka.ipd.sdq.pcm.resultdecorator.repositorydecorator.InterfaceProvidingRequiringEntityResults;
import de.uka.ipd.sdq.pcm.resultdecorator.repositorydecorator.RepositorydecoratorPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Interface Providing Requiring Entity Results</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.resultdecorator.repositorydecorator.impl.InterfaceProvidingRequiringEntityResultsImpl#getInterfaceProvidingRequiringEntity_InterfaceProvidingRequiringEntityResult <em>Interface Providing Requiring Entity Interface Providing Requiring Entity Result</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class InterfaceProvidingRequiringEntityResultsImpl extends ComponentResultImpl implements InterfaceProvidingRequiringEntityResults {
	/**
	 * The cached value of the '{@link #getInterfaceProvidingRequiringEntity_InterfaceProvidingRequiringEntityResult() <em>Interface Providing Requiring Entity Interface Providing Requiring Entity Result</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInterfaceProvidingRequiringEntity_InterfaceProvidingRequiringEntityResult()
	 * @generated
	 * @ordered
	 */
	protected InterfaceProvidingRequiringEntity interfaceProvidingRequiringEntity_InterfaceProvidingRequiringEntityResult;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected InterfaceProvidingRequiringEntityResultsImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RepositorydecoratorPackage.Literals.INTERFACE_PROVIDING_REQUIRING_ENTITY_RESULTS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InterfaceProvidingRequiringEntity getInterfaceProvidingRequiringEntity_InterfaceProvidingRequiringEntityResult() {
		if (interfaceProvidingRequiringEntity_InterfaceProvidingRequiringEntityResult != null && interfaceProvidingRequiringEntity_InterfaceProvidingRequiringEntityResult.eIsProxy()) {
			InternalEObject oldInterfaceProvidingRequiringEntity_InterfaceProvidingRequiringEntityResult = (InternalEObject)interfaceProvidingRequiringEntity_InterfaceProvidingRequiringEntityResult;
			interfaceProvidingRequiringEntity_InterfaceProvidingRequiringEntityResult = (InterfaceProvidingRequiringEntity)eResolveProxy(oldInterfaceProvidingRequiringEntity_InterfaceProvidingRequiringEntityResult);
			if (interfaceProvidingRequiringEntity_InterfaceProvidingRequiringEntityResult != oldInterfaceProvidingRequiringEntity_InterfaceProvidingRequiringEntityResult) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, RepositorydecoratorPackage.INTERFACE_PROVIDING_REQUIRING_ENTITY_RESULTS__INTERFACE_PROVIDING_REQUIRING_ENTITY_INTERFACE_PROVIDING_REQUIRING_ENTITY_RESULT, oldInterfaceProvidingRequiringEntity_InterfaceProvidingRequiringEntityResult, interfaceProvidingRequiringEntity_InterfaceProvidingRequiringEntityResult));
			}
		}
		return interfaceProvidingRequiringEntity_InterfaceProvidingRequiringEntityResult;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InterfaceProvidingRequiringEntity basicGetInterfaceProvidingRequiringEntity_InterfaceProvidingRequiringEntityResult() {
		return interfaceProvidingRequiringEntity_InterfaceProvidingRequiringEntityResult;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInterfaceProvidingRequiringEntity_InterfaceProvidingRequiringEntityResult(InterfaceProvidingRequiringEntity newInterfaceProvidingRequiringEntity_InterfaceProvidingRequiringEntityResult) {
		InterfaceProvidingRequiringEntity oldInterfaceProvidingRequiringEntity_InterfaceProvidingRequiringEntityResult = interfaceProvidingRequiringEntity_InterfaceProvidingRequiringEntityResult;
		interfaceProvidingRequiringEntity_InterfaceProvidingRequiringEntityResult = newInterfaceProvidingRequiringEntity_InterfaceProvidingRequiringEntityResult;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RepositorydecoratorPackage.INTERFACE_PROVIDING_REQUIRING_ENTITY_RESULTS__INTERFACE_PROVIDING_REQUIRING_ENTITY_INTERFACE_PROVIDING_REQUIRING_ENTITY_RESULT, oldInterfaceProvidingRequiringEntity_InterfaceProvidingRequiringEntityResult, interfaceProvidingRequiringEntity_InterfaceProvidingRequiringEntityResult));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case RepositorydecoratorPackage.INTERFACE_PROVIDING_REQUIRING_ENTITY_RESULTS__INTERFACE_PROVIDING_REQUIRING_ENTITY_INTERFACE_PROVIDING_REQUIRING_ENTITY_RESULT:
				if (resolve) return getInterfaceProvidingRequiringEntity_InterfaceProvidingRequiringEntityResult();
				return basicGetInterfaceProvidingRequiringEntity_InterfaceProvidingRequiringEntityResult();
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
			case RepositorydecoratorPackage.INTERFACE_PROVIDING_REQUIRING_ENTITY_RESULTS__INTERFACE_PROVIDING_REQUIRING_ENTITY_INTERFACE_PROVIDING_REQUIRING_ENTITY_RESULT:
				setInterfaceProvidingRequiringEntity_InterfaceProvidingRequiringEntityResult((InterfaceProvidingRequiringEntity)newValue);
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
			case RepositorydecoratorPackage.INTERFACE_PROVIDING_REQUIRING_ENTITY_RESULTS__INTERFACE_PROVIDING_REQUIRING_ENTITY_INTERFACE_PROVIDING_REQUIRING_ENTITY_RESULT:
				setInterfaceProvidingRequiringEntity_InterfaceProvidingRequiringEntityResult((InterfaceProvidingRequiringEntity)null);
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
			case RepositorydecoratorPackage.INTERFACE_PROVIDING_REQUIRING_ENTITY_RESULTS__INTERFACE_PROVIDING_REQUIRING_ENTITY_INTERFACE_PROVIDING_REQUIRING_ENTITY_RESULT:
				return interfaceProvidingRequiringEntity_InterfaceProvidingRequiringEntityResult != null;
		}
		return super.eIsSet(featureID);
	}

} //InterfaceProvidingRequiringEntityResultsImpl
