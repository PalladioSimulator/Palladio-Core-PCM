/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.designdecision.impl;

import de.uka.ipd.sdq.pcm.designdecision.DegreeOfFreedomInstance;

import de.uka.ipd.sdq.pcm.designdecision.GDoF.DegreeOfFreedom;

import de.uka.ipd.sdq.pcm.designdecision.designdecisionPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Degree Of Freedom Instance</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.designdecision.impl.DegreeOfFreedomInstanceImpl#getPrimaryChanged <em>Primary Changed</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.designdecision.impl.DegreeOfFreedomInstanceImpl#getDof <em>Dof</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class DegreeOfFreedomInstanceImpl extends EObjectImpl implements DegreeOfFreedomInstance {
	/**
	 * The cached value of the '{@link #getPrimaryChanged() <em>Primary Changed</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPrimaryChanged()
	 * @generated
	 * @ordered
	 */
	protected EObject primaryChanged;

	/**
	 * The cached value of the '{@link #getDof() <em>Dof</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDof()
	 * @generated
	 * @ordered
	 */
	protected DegreeOfFreedom dof;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DegreeOfFreedomInstanceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return designdecisionPackage.Literals.DEGREE_OF_FREEDOM_INSTANCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject getPrimaryChanged() {
		if (primaryChanged != null && primaryChanged.eIsProxy()) {
			InternalEObject oldPrimaryChanged = (InternalEObject)primaryChanged;
			primaryChanged = eResolveProxy(oldPrimaryChanged);
			if (primaryChanged != oldPrimaryChanged) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, designdecisionPackage.DEGREE_OF_FREEDOM_INSTANCE__PRIMARY_CHANGED, oldPrimaryChanged, primaryChanged));
			}
		}
		return primaryChanged;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject basicGetPrimaryChanged() {
		return primaryChanged;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPrimaryChanged(EObject newPrimaryChanged) {
		EObject oldPrimaryChanged = primaryChanged;
		primaryChanged = newPrimaryChanged;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, designdecisionPackage.DEGREE_OF_FREEDOM_INSTANCE__PRIMARY_CHANGED, oldPrimaryChanged, primaryChanged));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DegreeOfFreedom getDof() {
		if (dof != null && dof.eIsProxy()) {
			InternalEObject oldDof = (InternalEObject)dof;
			dof = (DegreeOfFreedom)eResolveProxy(oldDof);
			if (dof != oldDof) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, designdecisionPackage.DEGREE_OF_FREEDOM_INSTANCE__DOF, oldDof, dof));
			}
		}
		return dof;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DegreeOfFreedom basicGetDof() {
		return dof;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDof(DegreeOfFreedom newDof) {
		DegreeOfFreedom oldDof = dof;
		dof = newDof;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, designdecisionPackage.DEGREE_OF_FREEDOM_INSTANCE__DOF, oldDof, dof));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case designdecisionPackage.DEGREE_OF_FREEDOM_INSTANCE__PRIMARY_CHANGED:
				if (resolve) return getPrimaryChanged();
				return basicGetPrimaryChanged();
			case designdecisionPackage.DEGREE_OF_FREEDOM_INSTANCE__DOF:
				if (resolve) return getDof();
				return basicGetDof();
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
			case designdecisionPackage.DEGREE_OF_FREEDOM_INSTANCE__PRIMARY_CHANGED:
				setPrimaryChanged((EObject)newValue);
				return;
			case designdecisionPackage.DEGREE_OF_FREEDOM_INSTANCE__DOF:
				setDof((DegreeOfFreedom)newValue);
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
			case designdecisionPackage.DEGREE_OF_FREEDOM_INSTANCE__PRIMARY_CHANGED:
				setPrimaryChanged((EObject)null);
				return;
			case designdecisionPackage.DEGREE_OF_FREEDOM_INSTANCE__DOF:
				setDof((DegreeOfFreedom)null);
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
			case designdecisionPackage.DEGREE_OF_FREEDOM_INSTANCE__PRIMARY_CHANGED:
				return primaryChanged != null;
			case designdecisionPackage.DEGREE_OF_FREEDOM_INSTANCE__DOF:
				return dof != null;
		}
		return super.eIsSet(featureID);
	}

} //DegreeOfFreedomInstanceImpl
