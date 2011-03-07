/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.stoex.impl;

import de.uka.ipd.sdq.stoex.AbstractNamedReference;
import de.uka.ipd.sdq.stoex.StoexPackage;
import de.uka.ipd.sdq.stoex.Variable;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Variable</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.stoex.impl.VariableImpl#getId_Variable <em>Id Variable</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class VariableImpl extends AtomImpl implements Variable {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright 2006, SDQ, IPD, U Karlsruhe (TH)";

	/**
	 * The cached value of the '{@link #getId_Variable() <em>Id Variable</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId_Variable()
	 * @generated
	 * @ordered
	 */
	protected AbstractNamedReference id_Variable = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected VariableImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return StoexPackage.Literals.VARIABLE;
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, StoexPackage.VARIABLE__ID_VARIABLE, oldId_Variable, id_Variable));
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
			eNotify(new ENotificationImpl(this, Notification.SET, StoexPackage.VARIABLE__ID_VARIABLE, oldId_Variable, id_Variable));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case StoexPackage.VARIABLE__ID_VARIABLE:
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
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case StoexPackage.VARIABLE__ID_VARIABLE:
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
	public void eUnset(int featureID) {
		switch (featureID) {
			case StoexPackage.VARIABLE__ID_VARIABLE:
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
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case StoexPackage.VARIABLE__ID_VARIABLE:
				return id_Variable != null;
		}
		return super.eIsSet(featureID);
	}

} //VariableImpl