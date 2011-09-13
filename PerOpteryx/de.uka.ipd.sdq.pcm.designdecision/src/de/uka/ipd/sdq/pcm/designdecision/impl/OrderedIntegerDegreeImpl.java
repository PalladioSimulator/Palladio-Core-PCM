/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.designdecision.impl;

import de.uka.ipd.sdq.pcm.designdecision.OrderedIntegerDegree;
import de.uka.ipd.sdq.pcm.designdecision.designdecisionPackage;

import java.util.Collection;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ordered Integer Degree</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.designdecision.impl.OrderedIntegerDegreeImpl#getListOfIntegers <em>List Of Integers</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class OrderedIntegerDegreeImpl extends DiscreteDegreeImpl implements OrderedIntegerDegree {
	/**
	 * The cached value of the '{@link #getListOfIntegers() <em>List Of Integers</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getListOfIntegers()
	 * @generated
	 * @ordered
	 */
	protected EList<Integer> listOfIntegers;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected OrderedIntegerDegreeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return designdecisionPackage.Literals.ORDERED_INTEGER_DEGREE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Integer> getListOfIntegers() {
		if (listOfIntegers == null) {
			listOfIntegers = new EDataTypeUniqueEList<Integer>(Integer.class, this, designdecisionPackage.ORDERED_INTEGER_DEGREE__LIST_OF_INTEGERS);
		}
		return listOfIntegers;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case designdecisionPackage.ORDERED_INTEGER_DEGREE__LIST_OF_INTEGERS:
				return getListOfIntegers();
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
			case designdecisionPackage.ORDERED_INTEGER_DEGREE__LIST_OF_INTEGERS:
				getListOfIntegers().clear();
				getListOfIntegers().addAll((Collection<? extends Integer>)newValue);
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
			case designdecisionPackage.ORDERED_INTEGER_DEGREE__LIST_OF_INTEGERS:
				getListOfIntegers().clear();
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
			case designdecisionPackage.ORDERED_INTEGER_DEGREE__LIST_OF_INTEGERS:
				return listOfIntegers != null && !listOfIntegers.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (listOfIntegers: ");
		result.append(listOfIntegers);
		result.append(')');
		return result.toString();
	}

} //OrderedIntegerDegreeImpl
