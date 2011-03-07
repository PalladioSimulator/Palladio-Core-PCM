/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.designdecision.impl;

import de.uka.ipd.sdq.featuremodel.Simple;

import de.uka.ipd.sdq.pcm.designdecision.OptionalFeatureDegree;
import de.uka.ipd.sdq.pcm.designdecision.designdecisionPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Optional Feature Degree</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.designdecision.impl.OptionalFeatureDegreeImpl#getSimple <em>Simple</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class OptionalFeatureDegreeImpl extends FeatureConfigDegreeImpl implements OptionalFeatureDegree {
	/**
	 * The cached value of the '{@link #getSimple() <em>Simple</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSimple()
	 * @generated
	 * @ordered
	 */
	protected Simple simple;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected OptionalFeatureDegreeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return designdecisionPackage.Literals.OPTIONAL_FEATURE_DEGREE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Simple getSimple() {
		if (simple != null && simple.eIsProxy()) {
			InternalEObject oldSimple = (InternalEObject)simple;
			simple = (Simple)eResolveProxy(oldSimple);
			if (simple != oldSimple) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, designdecisionPackage.OPTIONAL_FEATURE_DEGREE__SIMPLE, oldSimple, simple));
			}
		}
		return simple;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Simple basicGetSimple() {
		return simple;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSimple(Simple newSimple) {
		Simple oldSimple = simple;
		simple = newSimple;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, designdecisionPackage.OPTIONAL_FEATURE_DEGREE__SIMPLE, oldSimple, simple));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case designdecisionPackage.OPTIONAL_FEATURE_DEGREE__SIMPLE:
				if (resolve) return getSimple();
				return basicGetSimple();
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
			case designdecisionPackage.OPTIONAL_FEATURE_DEGREE__SIMPLE:
				setSimple((Simple)newValue);
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
			case designdecisionPackage.OPTIONAL_FEATURE_DEGREE__SIMPLE:
				setSimple((Simple)null);
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
			case designdecisionPackage.OPTIONAL_FEATURE_DEGREE__SIMPLE:
				return simple != null;
		}
		return super.eIsSet(featureID);
	}

} //OptionalFeatureDegreeImpl
