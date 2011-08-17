/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.designdecision.GDoF.impl;

import de.uka.ipd.sdq.pcm.designdecision.GDoF.ChangeableElementDescription;
import de.uka.ipd.sdq.pcm.designdecision.GDoF.GDoFPackage;
import de.uka.ipd.sdq.pcm.designdecision.GDoF.InstanceSelectionRule;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Instance Selection Rule</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.designdecision.GDoF.impl.InstanceSelectionRuleImpl#getContextInstance <em>Context Instance</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class InstanceSelectionRuleImpl extends SelectionRuleImpl implements InstanceSelectionRule {
	/**
	 * The cached value of the '{@link #getContextInstance() <em>Context Instance</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContextInstance()
	 * @generated
	 * @ordered
	 */
	protected ChangeableElementDescription contextInstance;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected InstanceSelectionRuleImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GDoFPackage.Literals.INSTANCE_SELECTION_RULE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ChangeableElementDescription getContextInstance() {
		if (contextInstance != null && contextInstance.eIsProxy()) {
			InternalEObject oldContextInstance = (InternalEObject)contextInstance;
			contextInstance = (ChangeableElementDescription)eResolveProxy(oldContextInstance);
			if (contextInstance != oldContextInstance) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, GDoFPackage.INSTANCE_SELECTION_RULE__CONTEXT_INSTANCE, oldContextInstance, contextInstance));
			}
		}
		return contextInstance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ChangeableElementDescription basicGetContextInstance() {
		return contextInstance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setContextInstance(ChangeableElementDescription newContextInstance) {
		ChangeableElementDescription oldContextInstance = contextInstance;
		contextInstance = newContextInstance;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GDoFPackage.INSTANCE_SELECTION_RULE__CONTEXT_INSTANCE, oldContextInstance, contextInstance));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case GDoFPackage.INSTANCE_SELECTION_RULE__CONTEXT_INSTANCE:
				if (resolve) return getContextInstance();
				return basicGetContextInstance();
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
			case GDoFPackage.INSTANCE_SELECTION_RULE__CONTEXT_INSTANCE:
				setContextInstance((ChangeableElementDescription)newValue);
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
			case GDoFPackage.INSTANCE_SELECTION_RULE__CONTEXT_INSTANCE:
				setContextInstance((ChangeableElementDescription)null);
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
			case GDoFPackage.INSTANCE_SELECTION_RULE__CONTEXT_INSTANCE:
				return contextInstance != null;
		}
		return super.eIsSet(featureID);
	}

} //InstanceSelectionRuleImpl
