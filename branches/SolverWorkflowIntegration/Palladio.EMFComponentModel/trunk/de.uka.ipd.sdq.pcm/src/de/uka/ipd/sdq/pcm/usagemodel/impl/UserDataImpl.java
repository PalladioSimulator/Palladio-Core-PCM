/**
 * Copyright 2007 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.usagemodel.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import de.uka.ipd.sdq.pcm.core.composition.AssemblyContext;
import de.uka.ipd.sdq.pcm.parameter.VariableUsage;
import de.uka.ipd.sdq.pcm.usagemodel.UsagemodelPackage;
import de.uka.ipd.sdq.pcm.usagemodel.UserData;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>User Data</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.usagemodel.impl.UserDataImpl#getUserDataParameterUsages_UserData <em>User Data Parameter Usages User Data</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.usagemodel.impl.UserDataImpl#getAssemblyContext_userData <em>Assembly Context user Data</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class UserDataImpl extends EObjectImpl implements UserData {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany";

	/**
	 * The cached value of the '{@link #getUserDataParameterUsages_UserData() <em>User Data Parameter Usages User Data</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUserDataParameterUsages_UserData()
	 * @generated
	 * @ordered
	 */
	protected EList<VariableUsage> userDataParameterUsages_UserData;

	/**
	 * The cached value of the '{@link #getAssemblyContext_userData() <em>Assembly Context user Data</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAssemblyContext_userData()
	 * @generated
	 * @ordered
	 */
	protected AssemblyContext assemblyContext_userData;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected UserDataImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return UsagemodelPackage.Literals.USER_DATA;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<VariableUsage> getUserDataParameterUsages_UserData() {
		if (userDataParameterUsages_UserData == null) {
			userDataParameterUsages_UserData = new EObjectContainmentEList<VariableUsage>(VariableUsage.class, this, UsagemodelPackage.USER_DATA__USER_DATA_PARAMETER_USAGES_USER_DATA);
		}
		return userDataParameterUsages_UserData;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AssemblyContext getAssemblyContext_userData() {
		if (assemblyContext_userData != null && assemblyContext_userData.eIsProxy()) {
			InternalEObject oldAssemblyContext_userData = (InternalEObject)assemblyContext_userData;
			assemblyContext_userData = (AssemblyContext)eResolveProxy(oldAssemblyContext_userData);
			if (assemblyContext_userData != oldAssemblyContext_userData) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UsagemodelPackage.USER_DATA__ASSEMBLY_CONTEXT_USER_DATA, oldAssemblyContext_userData, assemblyContext_userData));
			}
		}
		return assemblyContext_userData;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AssemblyContext basicGetAssemblyContext_userData() {
		return assemblyContext_userData;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAssemblyContext_userData(AssemblyContext newAssemblyContext_userData) {
		AssemblyContext oldAssemblyContext_userData = assemblyContext_userData;
		assemblyContext_userData = newAssemblyContext_userData;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UsagemodelPackage.USER_DATA__ASSEMBLY_CONTEXT_USER_DATA, oldAssemblyContext_userData, assemblyContext_userData));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case UsagemodelPackage.USER_DATA__USER_DATA_PARAMETER_USAGES_USER_DATA:
				return ((InternalEList<?>)getUserDataParameterUsages_UserData()).basicRemove(otherEnd, msgs);
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
			case UsagemodelPackage.USER_DATA__USER_DATA_PARAMETER_USAGES_USER_DATA:
				return getUserDataParameterUsages_UserData();
			case UsagemodelPackage.USER_DATA__ASSEMBLY_CONTEXT_USER_DATA:
				if (resolve) return getAssemblyContext_userData();
				return basicGetAssemblyContext_userData();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case UsagemodelPackage.USER_DATA__USER_DATA_PARAMETER_USAGES_USER_DATA:
				getUserDataParameterUsages_UserData().clear();
				getUserDataParameterUsages_UserData().addAll((Collection<? extends VariableUsage>)newValue);
				return;
			case UsagemodelPackage.USER_DATA__ASSEMBLY_CONTEXT_USER_DATA:
				setAssemblyContext_userData((AssemblyContext)newValue);
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
			case UsagemodelPackage.USER_DATA__USER_DATA_PARAMETER_USAGES_USER_DATA:
				getUserDataParameterUsages_UserData().clear();
				return;
			case UsagemodelPackage.USER_DATA__ASSEMBLY_CONTEXT_USER_DATA:
				setAssemblyContext_userData((AssemblyContext)null);
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
			case UsagemodelPackage.USER_DATA__USER_DATA_PARAMETER_USAGES_USER_DATA:
				return userDataParameterUsages_UserData != null && !userDataParameterUsages_UserData.isEmpty();
			case UsagemodelPackage.USER_DATA__ASSEMBLY_CONTEXT_USER_DATA:
				return assemblyContext_userData != null;
		}
		return super.eIsSet(featureID);
	}

} //UserDataImpl
