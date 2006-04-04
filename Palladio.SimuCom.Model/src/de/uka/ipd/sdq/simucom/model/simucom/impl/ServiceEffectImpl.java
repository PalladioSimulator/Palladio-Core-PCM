/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.simucom.model.simucom.impl;

import de.uka.ipd.sdq.simucom.model.simucom.ServiceEffect;
import de.uka.ipd.sdq.simucom.model.simucom.SimuComModelPackage;

import java.util.Collection;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;

import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import org.eclipse.uml2.Activity;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Service Effect</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.simucom.model.simucom.impl.ServiceEffectImpl#getActivity <em>Activity</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ServiceEffectImpl extends EObjectImpl implements ServiceEffect {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "(c) by Steffen Becker, 2006"; //$NON-NLS-1$

	/**
	 * The cached value of the '{@link #getActivity() <em>Activity</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getActivity()
	 * @generated
	 * @ordered
	 */
	protected EList activity = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ServiceEffectImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return SimuComModelPackage.eINSTANCE.getServiceEffect();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getActivity() {
		if (activity == null) {
			activity = new EObjectResolvingEList(Activity.class, this, SimuComModelPackage.SERVICE_EFFECT__ACTIVITY);
		}
		return activity;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(EStructuralFeature eFeature, boolean resolve) {
		switch (eDerivedStructuralFeatureID(eFeature)) {
			case SimuComModelPackage.SERVICE_EFFECT__ACTIVITY:
				return getActivity();
		}
		return eDynamicGet(eFeature, resolve);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void eSet(EStructuralFeature eFeature, Object newValue) {
		switch (eDerivedStructuralFeatureID(eFeature)) {
			case SimuComModelPackage.SERVICE_EFFECT__ACTIVITY:
				getActivity().clear();
				getActivity().addAll((Collection)newValue);
				return;
		}
		eDynamicSet(eFeature, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void eUnset(EStructuralFeature eFeature) {
		switch (eDerivedStructuralFeatureID(eFeature)) {
			case SimuComModelPackage.SERVICE_EFFECT__ACTIVITY:
				getActivity().clear();
				return;
		}
		eDynamicUnset(eFeature);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean eIsSet(EStructuralFeature eFeature) {
		switch (eDerivedStructuralFeatureID(eFeature)) {
			case SimuComModelPackage.SERVICE_EFFECT__ACTIVITY:
				return activity != null && !activity.isEmpty();
		}
		return eDynamicIsSet(eFeature);
	}

} //ServiceEffectImpl
