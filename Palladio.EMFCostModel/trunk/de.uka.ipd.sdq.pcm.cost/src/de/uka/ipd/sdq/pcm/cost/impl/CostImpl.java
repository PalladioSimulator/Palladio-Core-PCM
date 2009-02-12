/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.cost.impl;

import de.uka.ipd.sdq.pcm.cost.Cost;
import de.uka.ipd.sdq.pcm.cost.costPackage;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Cost</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.cost.impl.CostImpl#getOperatingCost <em>Operating Cost</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.cost.impl.CostImpl#getInitialCost <em>Initial Cost</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class CostImpl extends EObjectImpl implements Cost {
	/**
	 * The default value of the '{@link #getOperatingCost() <em>Operating Cost</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOperatingCost()
	 * @generated
	 * @ordered
	 */
	protected static final double OPERATING_COST_EDEFAULT = 0.0;

	/**
	 * The default value of the '{@link #getInitialCost() <em>Initial Cost</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInitialCost()
	 * @generated
	 * @ordered
	 */
	protected static final double INITIAL_COST_EDEFAULT = 0.0;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CostImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return costPackage.Literals.COST;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated not
	 */
	public abstract double getOperatingCost();/* {
		// TODO: implement this method to return the 'Operating Cost' attribute
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}*/

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated not
	 */
	public abstract double getInitialCost(); /* {
		// TODO: implement this method to return the 'Initial Cost' attribute
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}*/

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case costPackage.COST__OPERATING_COST:
				return new Double(getOperatingCost());
			case costPackage.COST__INITIAL_COST:
				return new Double(getInitialCost());
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case costPackage.COST__OPERATING_COST:
				return getOperatingCost() != OPERATING_COST_EDEFAULT;
			case costPackage.COST__INITIAL_COST:
				return getInitialCost() != INITIAL_COST_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

} //CostImpl
