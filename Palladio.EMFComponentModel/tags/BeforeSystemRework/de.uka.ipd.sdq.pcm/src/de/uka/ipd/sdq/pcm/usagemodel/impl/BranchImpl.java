
/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.usagemodel.impl;

import de.uka.ipd.sdq.pcm.usagemodel.Branch;
import de.uka.ipd.sdq.pcm.usagemodel.ScenarioBehaviour;
import de.uka.ipd.sdq.pcm.usagemodel.UsagemodelPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Branch</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.usagemodel.impl.BranchImpl#getBranchedBehaviour_Branch <em>Branched Behaviour Branch</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class BranchImpl extends AbstractUserActionImpl implements Branch {
	/**
	 * The cached value of the '{@link #getBranchedBehaviour_Branch() <em>Branched Behaviour Branch</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBranchedBehaviour_Branch()
	 * @generated
	 * @ordered
	 */
	protected EList branchedBehaviour_Branch = null;


	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BranchImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return UsagemodelPackage.Literals.BRANCH;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getBranchedBehaviour_Branch() {
		if (branchedBehaviour_Branch == null) {
			branchedBehaviour_Branch = new EObjectContainmentEList(ScenarioBehaviour.class, this, UsagemodelPackage.BRANCH__BRANCHED_BEHAVIOUR_BRANCH);
		}
		return branchedBehaviour_Branch;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case UsagemodelPackage.BRANCH__BRANCHED_BEHAVIOUR_BRANCH:
				return ((InternalEList)getBranchedBehaviour_Branch()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case UsagemodelPackage.BRANCH__BRANCHED_BEHAVIOUR_BRANCH:
				return getBranchedBehaviour_Branch();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case UsagemodelPackage.BRANCH__BRANCHED_BEHAVIOUR_BRANCH:
				getBranchedBehaviour_Branch().clear();
				getBranchedBehaviour_Branch().addAll((Collection)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void eUnset(int featureID) {
		switch (featureID) {
			case UsagemodelPackage.BRANCH__BRANCHED_BEHAVIOUR_BRANCH:
				getBranchedBehaviour_Branch().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case UsagemodelPackage.BRANCH__BRANCHED_BEHAVIOUR_BRANCH:
				return branchedBehaviour_Branch != null && !branchedBehaviour_Branch.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //BranchImpl