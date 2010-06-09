/**
 * Copyright 2007-2009, SDQ, IPD, U Karlsruhe
 *
 * $Id$
 */
package de.uka.ipd.sdq.stoex.impl;

import de.uka.ipd.sdq.stoex.AbstractNamedReference;
import de.uka.ipd.sdq.stoex.StoExVariable;
import de.uka.ipd.sdq.stoex.StoexPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Sto Ex Variable</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.stoex.impl.StoExVariableImpl#getId_Variable <em>Id Variable</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class StoExVariableImpl extends AtomImpl implements StoExVariable {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright 2007-2009, SDQ, IPD, U Karlsruhe";

	/**
	 * The cached value of the '{@link #getId_Variable() <em>Id Variable</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId_Variable()
	 * @generated
	 * @ordered
	 */
	protected AbstractNamedReference id_Variable;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected StoExVariableImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return StoexPackage.Literals.STO_EX_VARIABLE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AbstractNamedReference getId_Variable() {
		if (id_Variable != null && id_Variable.eIsProxy()) {
			InternalEObject oldId_Variable = (InternalEObject)id_Variable;
			id_Variable = (AbstractNamedReference)eResolveProxy(oldId_Variable);
			if (id_Variable != oldId_Variable) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, StoexPackage.STO_EX_VARIABLE__ID_VARIABLE, oldId_Variable, id_Variable));
			}
		}
		return id_Variable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AbstractNamedReference basicGetId_Variable() {
		return id_Variable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setId_Variable(AbstractNamedReference newId_Variable) {
		AbstractNamedReference oldId_Variable = id_Variable;
		id_Variable = newId_Variable;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StoexPackage.STO_EX_VARIABLE__ID_VARIABLE, oldId_Variable, id_Variable));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case StoexPackage.STO_EX_VARIABLE__ID_VARIABLE:
				if (resolve) return getId_Variable();
				return basicGetId_Variable();
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
			case StoexPackage.STO_EX_VARIABLE__ID_VARIABLE:
				setId_Variable((AbstractNamedReference)newValue);
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
			case StoexPackage.STO_EX_VARIABLE__ID_VARIABLE:
				setId_Variable((AbstractNamedReference)null);
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
			case StoexPackage.STO_EX_VARIABLE__ID_VARIABLE:
				return id_Variable != null;
		}
		return super.eIsSet(featureID);
	}

} //StoExVariableImpl
