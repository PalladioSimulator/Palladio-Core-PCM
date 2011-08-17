/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pipesandfilters.impl;

import de.uka.ipd.sdq.pipesandfilters.Filter;
import de.uka.ipd.sdq.pipesandfilters.PipeElement;
import de.uka.ipd.sdq.pipesandfilters.pipesandfiltersPackage;

import java.util.Collection;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Filter</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pipesandfilters.impl.FilterImpl#getSuccessors <em>Successors</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class FilterImpl extends PipeElementImpl implements Filter {
	/**
	 * The cached value of the '{@link #getSuccessors() <em>Successors</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSuccessors()
	 * @generated
	 * @ordered
	 */
	protected EList<PipeElement> successors;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FilterImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return pipesandfiltersPackage.Literals.FILTER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<PipeElement> getSuccessors() {
		if (successors == null) {
			successors = new EObjectResolvingEList<PipeElement>(PipeElement.class, this, pipesandfiltersPackage.FILTER__SUCCESSORS);
		}
		return successors;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case pipesandfiltersPackage.FILTER__SUCCESSORS:
				return getSuccessors();
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
			case pipesandfiltersPackage.FILTER__SUCCESSORS:
				getSuccessors().clear();
				getSuccessors().addAll((Collection<? extends PipeElement>)newValue);
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
			case pipesandfiltersPackage.FILTER__SUCCESSORS:
				getSuccessors().clear();
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
			case pipesandfiltersPackage.FILTER__SUCCESSORS:
				return successors != null && !successors.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //FilterImpl
