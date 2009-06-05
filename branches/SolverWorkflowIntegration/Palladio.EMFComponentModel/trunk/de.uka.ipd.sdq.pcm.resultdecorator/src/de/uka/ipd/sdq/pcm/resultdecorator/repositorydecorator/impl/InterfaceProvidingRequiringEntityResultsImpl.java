/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.resultdecorator.repositorydecorator.impl;

import de.uka.ipd.sdq.pcm.core.entity.InterfaceProvidingRequiringEntity;

import de.uka.ipd.sdq.pcm.resultdecorator.repositorydecorator.InterfaceProvidingRequiringEntityResults;
import de.uka.ipd.sdq.pcm.resultdecorator.repositorydecorator.RepositorydecoratorPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Interface Providing Requiring Entity Results</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.resultdecorator.repositorydecorator.impl.InterfaceProvidingRequiringEntityResultsImpl#getInterfaceprovidingrequiringentity <em>Interfaceprovidingrequiringentity</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class InterfaceProvidingRequiringEntityResultsImpl extends ComponentResultImpl implements InterfaceProvidingRequiringEntityResults {
	/**
	 * The cached value of the '{@link #getInterfaceprovidingrequiringentity() <em>Interfaceprovidingrequiringentity</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInterfaceprovidingrequiringentity()
	 * @generated
	 * @ordered
	 */
	protected InterfaceProvidingRequiringEntity interfaceprovidingrequiringentity;

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
	public InterfaceProvidingRequiringEntity getInterfaceprovidingrequiringentity() {
		if (interfaceprovidingrequiringentity != null && interfaceprovidingrequiringentity.eIsProxy()) {
			InternalEObject oldInterfaceprovidingrequiringentity = (InternalEObject)interfaceprovidingrequiringentity;
			interfaceprovidingrequiringentity = (InterfaceProvidingRequiringEntity)eResolveProxy(oldInterfaceprovidingrequiringentity);
			if (interfaceprovidingrequiringentity != oldInterfaceprovidingrequiringentity) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, RepositorydecoratorPackage.INTERFACE_PROVIDING_REQUIRING_ENTITY_RESULTS__INTERFACEPROVIDINGREQUIRINGENTITY, oldInterfaceprovidingrequiringentity, interfaceprovidingrequiringentity));
			}
		}
		return interfaceprovidingrequiringentity;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InterfaceProvidingRequiringEntity basicGetInterfaceprovidingrequiringentity() {
		return interfaceprovidingrequiringentity;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInterfaceprovidingrequiringentity(InterfaceProvidingRequiringEntity newInterfaceprovidingrequiringentity) {
		InterfaceProvidingRequiringEntity oldInterfaceprovidingrequiringentity = interfaceprovidingrequiringentity;
		interfaceprovidingrequiringentity = newInterfaceprovidingrequiringentity;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RepositorydecoratorPackage.INTERFACE_PROVIDING_REQUIRING_ENTITY_RESULTS__INTERFACEPROVIDINGREQUIRINGENTITY, oldInterfaceprovidingrequiringentity, interfaceprovidingrequiringentity));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case RepositorydecoratorPackage.INTERFACE_PROVIDING_REQUIRING_ENTITY_RESULTS__INTERFACEPROVIDINGREQUIRINGENTITY:
				if (resolve) return getInterfaceprovidingrequiringentity();
				return basicGetInterfaceprovidingrequiringentity();
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
			case RepositorydecoratorPackage.INTERFACE_PROVIDING_REQUIRING_ENTITY_RESULTS__INTERFACEPROVIDINGREQUIRINGENTITY:
				setInterfaceprovidingrequiringentity((InterfaceProvidingRequiringEntity)newValue);
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
			case RepositorydecoratorPackage.INTERFACE_PROVIDING_REQUIRING_ENTITY_RESULTS__INTERFACEPROVIDINGREQUIRINGENTITY:
				setInterfaceprovidingrequiringentity((InterfaceProvidingRequiringEntity)null);
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
			case RepositorydecoratorPackage.INTERFACE_PROVIDING_REQUIRING_ENTITY_RESULTS__INTERFACEPROVIDINGREQUIRINGENTITY:
				return interfaceprovidingrequiringentity != null;
		}
		return super.eIsSet(featureID);
	}

} //InterfaceProvidingRequiringEntityResultsImpl
