/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.edp2.models.ExperimentData.impl;

import de.uka.ipd.sdq.edp2.models.ExperimentData.CategoryIdentifier;
import de.uka.ipd.sdq.edp2.models.ExperimentData.ExperimentDataPackage;
import de.uka.ipd.sdq.edp2.models.ExperimentData.ObservedCategory;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Observed Category</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.ExperimentData.impl.ObservedCategoryImpl#getCategoryIdentifier <em>Category Identifier</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ObservedCategoryImpl extends EObjectImpl implements ObservedCategory {
	/**
	 * The cached value of the '{@link #getCategoryIdentifier() <em>Category Identifier</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCategoryIdentifier()
	 * @generated
	 * @ordered
	 */
	protected CategoryIdentifier categoryIdentifier;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ObservedCategoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ExperimentDataPackage.Literals.OBSERVED_CATEGORY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CategoryIdentifier getCategoryIdentifier() {
		if (categoryIdentifier != null && categoryIdentifier.eIsProxy()) {
			InternalEObject oldCategoryIdentifier = (InternalEObject)categoryIdentifier;
			categoryIdentifier = (CategoryIdentifier)eResolveProxy(oldCategoryIdentifier);
			if (categoryIdentifier != oldCategoryIdentifier) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ExperimentDataPackage.OBSERVED_CATEGORY__CATEGORY_IDENTIFIER, oldCategoryIdentifier, categoryIdentifier));
			}
		}
		return categoryIdentifier;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CategoryIdentifier basicGetCategoryIdentifier() {
		return categoryIdentifier;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCategoryIdentifier(CategoryIdentifier newCategoryIdentifier) {
		CategoryIdentifier oldCategoryIdentifier = categoryIdentifier;
		categoryIdentifier = newCategoryIdentifier;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExperimentDataPackage.OBSERVED_CATEGORY__CATEGORY_IDENTIFIER, oldCategoryIdentifier, categoryIdentifier));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ExperimentDataPackage.OBSERVED_CATEGORY__CATEGORY_IDENTIFIER:
				if (resolve) return getCategoryIdentifier();
				return basicGetCategoryIdentifier();
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
			case ExperimentDataPackage.OBSERVED_CATEGORY__CATEGORY_IDENTIFIER:
				setCategoryIdentifier((CategoryIdentifier)newValue);
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
			case ExperimentDataPackage.OBSERVED_CATEGORY__CATEGORY_IDENTIFIER:
				setCategoryIdentifier((CategoryIdentifier)null);
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
			case ExperimentDataPackage.OBSERVED_CATEGORY__CATEGORY_IDENTIFIER:
				return categoryIdentifier != null;
		}
		return super.eIsSet(featureID);
	}

} //ObservedCategoryImpl
