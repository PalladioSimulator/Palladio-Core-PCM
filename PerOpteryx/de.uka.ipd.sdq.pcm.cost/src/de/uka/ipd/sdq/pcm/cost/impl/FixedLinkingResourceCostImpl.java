/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.cost.impl;

import de.uka.ipd.sdq.pcm.cost.FixedLinkingResourceCost;
import de.uka.ipd.sdq.pcm.cost.costPackage;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Fixed Linking Resource Cost</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class FixedLinkingResourceCostImpl extends LinkingResourceCostImpl implements FixedLinkingResourceCost {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FixedLinkingResourceCostImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return costPackage.Literals.FIXED_LINKING_RESOURCE_COST;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated not
	 */
	@Override
	public double getOperatingCost() {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated not
	 */
	@Override
	public double getInitialCost() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public EObject basicGetAnnotatedElement() {
		return this.getLinkingresource();
	}

} //FixedLinkingResourceCostImpl
