/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.UI.impl;

import de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.UI.StorageNode;
import de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.UI.StorageNodes;
import de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.UI.UIPackage;

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
 * An implementation of the model object '<em><b>Storage Nodes</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.UI.impl.StorageNodesImpl#getStoragenNode <em>Storagen Node</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class StorageNodesImpl extends EObjectImpl implements StorageNodes {
	/**
	 * The cached value of the '{@link #getStoragenNode() <em>Storagen Node</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStoragenNode()
	 * @generated
	 * @ordered
	 */
	protected EList<StorageNode> storagenNode;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected StorageNodesImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return UIPackage.Literals.STORAGE_NODES;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<StorageNode> getStoragenNode() {
		if (storagenNode == null) {
			storagenNode = new EObjectContainmentEList<StorageNode>(StorageNode.class, this, UIPackage.STORAGE_NODES__STORAGEN_NODE);
		}
		return storagenNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case UIPackage.STORAGE_NODES__STORAGEN_NODE:
				return ((InternalEList<?>)getStoragenNode()).basicRemove(otherEnd, msgs);
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
			case UIPackage.STORAGE_NODES__STORAGEN_NODE:
				return getStoragenNode();
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
			case UIPackage.STORAGE_NODES__STORAGEN_NODE:
				getStoragenNode().clear();
				getStoragenNode().addAll((Collection<? extends StorageNode>)newValue);
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
			case UIPackage.STORAGE_NODES__STORAGEN_NODE:
				getStoragenNode().clear();
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
			case UIPackage.STORAGE_NODES__STORAGEN_NODE:
				return storagenNode != null && !storagenNode.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //StorageNodesImpl
