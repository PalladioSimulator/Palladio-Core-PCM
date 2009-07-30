/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.UI.impl;

import de.uka.ipd.sdq.edp2.models.emfmodel.EmfmodelPackage;
import de.uka.ipd.sdq.edp2.models.emfmodel.ExperimentGroup;

import de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.UI.StorageNode;
import de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.UI.UIPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Storage Node</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.UI.impl.StorageNodeImpl#getExperimentGroup <em>Experiment Group</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class StorageNodeImpl extends EObjectImpl implements StorageNode {

	/**
	 * The cached value of the '{@link #getExperimentGroup() <em>Experiment Group</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExperimentGroup()
	 * @generated
	 * @ordered
	 */
	protected EList<ExperimentGroup> experimentGroup;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected StorageNodeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return UIPackage.Literals.STORAGE_NODE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ExperimentGroup> getExperimentGroup() {
		if (experimentGroup == null) {
			experimentGroup = new EObjectWithInverseResolvingEList<ExperimentGroup>(ExperimentGroup.class, this, UIPackage.STORAGE_NODE__EXPERIMENT_GROUP, EmfmodelPackage.EXPERIMENT_GROUP__STORAGE_NODE);
		}
		return experimentGroup;
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case UIPackage.STORAGE_NODE__EXPERIMENT_GROUP:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getExperimentGroup()).basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case UIPackage.STORAGE_NODE__EXPERIMENT_GROUP:
				return ((InternalEList<?>)getExperimentGroup()).basicRemove(otherEnd, msgs);
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
			case UIPackage.STORAGE_NODE__EXPERIMENT_GROUP:
				return getExperimentGroup();
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
			case UIPackage.STORAGE_NODE__EXPERIMENT_GROUP:
				getExperimentGroup().clear();
				getExperimentGroup().addAll((Collection<? extends ExperimentGroup>)newValue);
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
			case UIPackage.STORAGE_NODE__EXPERIMENT_GROUP:
				getExperimentGroup().clear();
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
			case UIPackage.STORAGE_NODE__EXPERIMENT_GROUP:
				return experimentGroup != null && !experimentGroup.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //StorageNodeImpl
