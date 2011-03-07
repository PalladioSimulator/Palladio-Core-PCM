
/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.seff.impl;

import de.uka.ipd.sdq.pcm.seff.ForkAction;
import de.uka.ipd.sdq.pcm.seff.ResourceDemandingBehaviour;
import de.uka.ipd.sdq.pcm.seff.SeffPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Fork Action</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.seff.impl.ForkActionImpl#getForkedBehaviours_Fork <em>Forked Behaviours Fork</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ForkActionImpl extends AbstractResourceDemandingActionImpl implements ForkAction {
	/**
	 * The cached value of the '{@link #getForkedBehaviours_Fork() <em>Forked Behaviours Fork</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getForkedBehaviours_Fork()
	 * @generated
	 * @ordered
	 */
	protected EList forkedBehaviours_Fork = null;


	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ForkActionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return SeffPackage.Literals.FORK_ACTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getForkedBehaviours_Fork() {
		if (forkedBehaviours_Fork == null) {
			forkedBehaviours_Fork = new EObjectContainmentEList(ResourceDemandingBehaviour.class, this, SeffPackage.FORK_ACTION__FORKED_BEHAVIOURS_FORK);
		}
		return forkedBehaviours_Fork;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SeffPackage.FORK_ACTION__FORKED_BEHAVIOURS_FORK:
				return ((InternalEList)getForkedBehaviours_Fork()).basicRemove(otherEnd, msgs);
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
			case SeffPackage.FORK_ACTION__FORKED_BEHAVIOURS_FORK:
				return getForkedBehaviours_Fork();
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
			case SeffPackage.FORK_ACTION__FORKED_BEHAVIOURS_FORK:
				getForkedBehaviours_Fork().clear();
				getForkedBehaviours_Fork().addAll((Collection)newValue);
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
			case SeffPackage.FORK_ACTION__FORKED_BEHAVIOURS_FORK:
				getForkedBehaviours_Fork().clear();
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
			case SeffPackage.FORK_ACTION__FORKED_BEHAVIOURS_FORK:
				return forkedBehaviours_Fork != null && !forkedBehaviours_Fork.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //ForkActionImpl