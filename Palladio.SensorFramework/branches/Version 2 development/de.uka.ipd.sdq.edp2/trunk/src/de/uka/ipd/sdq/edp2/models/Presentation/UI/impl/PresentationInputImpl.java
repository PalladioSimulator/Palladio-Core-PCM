/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.edp2.models.Presentation.UI.impl;

import de.uka.ipd.sdq.edp2.models.Presentation.DataSource;
import de.uka.ipd.sdq.edp2.models.Presentation.UI.PresentationInput;
import de.uka.ipd.sdq.edp2.models.Presentation.UI.UIPackage;


import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Presentation Input</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.Presentation.UI.impl.PresentationInputImpl#getDataSourceDescription <em>Data Source Description</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PresentationInputImpl extends EObjectImpl implements PresentationInput {
	/**
	 * The cached value of the '{@link #getDataSourceDescription() <em>Data Source Description</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDataSourceDescription()
	 * @generated
	 * @ordered
	 */
	protected EList<DataSource> dataSourceDescription;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PresentationInputImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return UIPackage.Literals.PRESENTATION_INPUT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<DataSource> getDataSourceDescription() {
		if (dataSourceDescription == null) {
			dataSourceDescription = new EObjectContainmentEList<DataSource>(DataSource.class, this, UIPackage.PRESENTATION_INPUT__DATA_SOURCE_DESCRIPTION);
		}
		return dataSourceDescription;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case UIPackage.PRESENTATION_INPUT__DATA_SOURCE_DESCRIPTION:
				return ((InternalEList<?>)getDataSourceDescription()).basicRemove(otherEnd, msgs);
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
			case UIPackage.PRESENTATION_INPUT__DATA_SOURCE_DESCRIPTION:
				return getDataSourceDescription();
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
			case UIPackage.PRESENTATION_INPUT__DATA_SOURCE_DESCRIPTION:
				getDataSourceDescription().clear();
				getDataSourceDescription().addAll((Collection<? extends DataSource>)newValue);
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
			case UIPackage.PRESENTATION_INPUT__DATA_SOURCE_DESCRIPTION:
				getDataSourceDescription().clear();
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
			case UIPackage.PRESENTATION_INPUT__DATA_SOURCE_DESCRIPTION:
				return dataSourceDescription != null && !dataSourceDescription.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //PresentationInputImpl
