/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.designdecision.GDoF.impl;

import de.uka.ipd.sdq.pcm.designdecision.GDoF.GDoFPackage;
import de.uka.ipd.sdq.pcm.designdecision.GDoF.StaticContextRule;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Static Context Rule</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.designdecision.GDoF.impl.StaticContextRuleImpl#getContextClass <em>Context Class</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class StaticContextRuleImpl extends EObjectImpl implements StaticContextRule {
	/**
	 * The cached value of the '{@link #getContextClass() <em>Context Class</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContextClass()
	 * @generated
	 * @ordered
	 */
	protected EClass contextClass;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected StaticContextRuleImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GDoFPackage.Literals.STATIC_CONTEXT_RULE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getContextClass() {
		if (contextClass != null && contextClass.eIsProxy()) {
			InternalEObject oldContextClass = (InternalEObject)contextClass;
			contextClass = (EClass)eResolveProxy(oldContextClass);
			if (contextClass != oldContextClass) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, GDoFPackage.STATIC_CONTEXT_RULE__CONTEXT_CLASS, oldContextClass, contextClass));
			}
		}
		return contextClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass basicGetContextClass() {
		return contextClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setContextClass(EClass newContextClass) {
		EClass oldContextClass = contextClass;
		contextClass = newContextClass;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GDoFPackage.STATIC_CONTEXT_RULE__CONTEXT_CLASS, oldContextClass, contextClass));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case GDoFPackage.STATIC_CONTEXT_RULE__CONTEXT_CLASS:
				if (resolve) return getContextClass();
				return basicGetContextClass();
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
			case GDoFPackage.STATIC_CONTEXT_RULE__CONTEXT_CLASS:
				setContextClass((EClass)newValue);
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
			case GDoFPackage.STATIC_CONTEXT_RULE__CONTEXT_CLASS:
				setContextClass((EClass)null);
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
			case GDoFPackage.STATIC_CONTEXT_RULE__CONTEXT_CLASS:
				return contextClass != null;
		}
		return super.eIsSet(featureID);
	}

} //StaticContextRuleImpl
