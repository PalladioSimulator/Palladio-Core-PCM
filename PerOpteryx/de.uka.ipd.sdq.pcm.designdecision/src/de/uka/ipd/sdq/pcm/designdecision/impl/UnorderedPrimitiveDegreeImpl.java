/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.designdecision.impl;


import de.uka.ipd.sdq.pcm.designdecision.UnorderedPrimitiveDegree;
import de.uka.ipd.sdq.pcm.designdecision.designdecisionPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Unordered Primitive Degree</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.designdecision.impl.UnorderedPrimitiveDegreeImpl#getPrimitiveValues <em>Primitive Values</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class UnorderedPrimitiveDegreeImpl extends UnorderedDegreeImpl implements UnorderedPrimitiveDegree {
	/**
	 * The cached value of the '{@link #getPrimitiveValues() <em>Primitive Values</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPrimitiveValues()
	 * @generated
	 * @ordered
	 */
	protected EList<EDataType> primitiveValues;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected UnorderedPrimitiveDegreeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return designdecisionPackage.Literals.UNORDERED_PRIMITIVE_DEGREE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EDataType> getPrimitiveValues() {
		if (primitiveValues == null) {
			primitiveValues = new EObjectContainmentEList<EDataType>(EDataType.class, this, designdecisionPackage.UNORDERED_PRIMITIVE_DEGREE__PRIMITIVE_VALUES);
		}
		return primitiveValues;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case designdecisionPackage.UNORDERED_PRIMITIVE_DEGREE__PRIMITIVE_VALUES:
				return ((InternalEList<?>)getPrimitiveValues()).basicRemove(otherEnd, msgs);
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
			case designdecisionPackage.UNORDERED_PRIMITIVE_DEGREE__PRIMITIVE_VALUES:
				return getPrimitiveValues();
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
			case designdecisionPackage.UNORDERED_PRIMITIVE_DEGREE__PRIMITIVE_VALUES:
				getPrimitiveValues().clear();
				getPrimitiveValues().addAll((Collection<? extends EDataType>)newValue);
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
			case designdecisionPackage.UNORDERED_PRIMITIVE_DEGREE__PRIMITIVE_VALUES:
				getPrimitiveValues().clear();
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
			case designdecisionPackage.UNORDERED_PRIMITIVE_DEGREE__PRIMITIVE_VALUES:
				return primitiveValues != null && !primitiveValues.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //UnorderedPrimitiveDegreeImpl
