/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.fzi.se.controlflowdescription.impl;

import de.fzi.se.controlflowdescription.ControlFlowDescription;
import de.fzi.se.controlflowdescription.ControlFlowDescriptionPackage;
import de.fzi.se.controlflowdescription.ControlFlowDescriptions;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Control Flow Descriptions</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.fzi.se.controlflowdescription.impl.ControlFlowDescriptionsImpl#getControlFlowDescription <em>Control Flow Description</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ControlFlowDescriptionsImpl extends EObjectImpl implements ControlFlowDescriptions {
	/**
	 * The cached value of the '{@link #getControlFlowDescription() <em>Control Flow Description</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getControlFlowDescription()
	 * @generated
	 * @ordered
	 */
	protected EList<ControlFlowDescription> controlFlowDescription;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ControlFlowDescriptionsImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ControlFlowDescriptionPackage.Literals.CONTROL_FLOW_DESCRIPTIONS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ControlFlowDescription> getControlFlowDescription() {
		if (controlFlowDescription == null) {
			controlFlowDescription = new EObjectContainmentWithInverseEList<ControlFlowDescription>(ControlFlowDescription.class, this, ControlFlowDescriptionPackage.CONTROL_FLOW_DESCRIPTIONS__CONTROL_FLOW_DESCRIPTION, ControlFlowDescriptionPackage.CONTROL_FLOW_DESCRIPTION__CONTROLFLOWDESCRIPTIONS);
		}
		return controlFlowDescription;
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
			case ControlFlowDescriptionPackage.CONTROL_FLOW_DESCRIPTIONS__CONTROL_FLOW_DESCRIPTION:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getControlFlowDescription()).basicAdd(otherEnd, msgs);
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
			case ControlFlowDescriptionPackage.CONTROL_FLOW_DESCRIPTIONS__CONTROL_FLOW_DESCRIPTION:
				return ((InternalEList<?>)getControlFlowDescription()).basicRemove(otherEnd, msgs);
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
			case ControlFlowDescriptionPackage.CONTROL_FLOW_DESCRIPTIONS__CONTROL_FLOW_DESCRIPTION:
				return getControlFlowDescription();
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
			case ControlFlowDescriptionPackage.CONTROL_FLOW_DESCRIPTIONS__CONTROL_FLOW_DESCRIPTION:
				getControlFlowDescription().clear();
				getControlFlowDescription().addAll((Collection<? extends ControlFlowDescription>)newValue);
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
			case ControlFlowDescriptionPackage.CONTROL_FLOW_DESCRIPTIONS__CONTROL_FLOW_DESCRIPTION:
				getControlFlowDescription().clear();
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
			case ControlFlowDescriptionPackage.CONTROL_FLOW_DESCRIPTIONS__CONTROL_FLOW_DESCRIPTION:
				return controlFlowDescription != null && !controlFlowDescription.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //ControlFlowDescriptionsImpl
