/**
 * Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.seff.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import de.uka.ipd.sdq.pcm.parameter.Variable;
import de.uka.ipd.sdq.pcm.seff.CollectionIteratorAction;
import de.uka.ipd.sdq.pcm.seff.SeffPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Collection Iterator Action</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.seff.impl.CollectionIteratorActionImpl#getVariable__CollectionIteratorAction <em>Variable Collection Iterator Action</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CollectionIteratorActionImpl extends AbstractLoopActionImpl implements CollectionIteratorAction {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany";

	/**
	 * The cached value of the '{@link #getVariable__CollectionIteratorAction() <em>Variable Collection Iterator Action</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVariable__CollectionIteratorAction()
	 * @generated
	 * @ordered
	 */
	protected Variable variable__CollectionIteratorAction;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CollectionIteratorActionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SeffPackage.Literals.COLLECTION_ITERATOR_ACTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Variable getVariable__CollectionIteratorAction() {
		if (variable__CollectionIteratorAction != null && variable__CollectionIteratorAction.eIsProxy()) {
			InternalEObject oldVariable__CollectionIteratorAction = (InternalEObject)variable__CollectionIteratorAction;
			variable__CollectionIteratorAction = (Variable)eResolveProxy(oldVariable__CollectionIteratorAction);
			if (variable__CollectionIteratorAction != oldVariable__CollectionIteratorAction) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SeffPackage.COLLECTION_ITERATOR_ACTION__VARIABLE_COLLECTION_ITERATOR_ACTION, oldVariable__CollectionIteratorAction, variable__CollectionIteratorAction));
			}
		}
		return variable__CollectionIteratorAction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Variable basicGetVariable__CollectionIteratorAction() {
		return variable__CollectionIteratorAction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVariable__CollectionIteratorAction(Variable newVariable__CollectionIteratorAction) {
		Variable oldVariable__CollectionIteratorAction = variable__CollectionIteratorAction;
		variable__CollectionIteratorAction = newVariable__CollectionIteratorAction;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SeffPackage.COLLECTION_ITERATOR_ACTION__VARIABLE_COLLECTION_ITERATOR_ACTION, oldVariable__CollectionIteratorAction, variable__CollectionIteratorAction));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SeffPackage.COLLECTION_ITERATOR_ACTION__VARIABLE_COLLECTION_ITERATOR_ACTION:
				if (resolve) return getVariable__CollectionIteratorAction();
				return basicGetVariable__CollectionIteratorAction();
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
			case SeffPackage.COLLECTION_ITERATOR_ACTION__VARIABLE_COLLECTION_ITERATOR_ACTION:
				setVariable__CollectionIteratorAction((Variable)newValue);
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
			case SeffPackage.COLLECTION_ITERATOR_ACTION__VARIABLE_COLLECTION_ITERATOR_ACTION:
				setVariable__CollectionIteratorAction((Variable)null);
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
			case SeffPackage.COLLECTION_ITERATOR_ACTION__VARIABLE_COLLECTION_ITERATOR_ACTION:
				return variable__CollectionIteratorAction != null;
		}
		return super.eIsSet(featureID);
	}

} //CollectionIteratorActionImpl
