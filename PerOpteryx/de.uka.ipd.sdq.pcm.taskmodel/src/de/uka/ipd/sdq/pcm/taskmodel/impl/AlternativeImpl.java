/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.taskmodel.impl;

import de.uka.ipd.sdq.pcm.taskmodel.Alternative;
import de.uka.ipd.sdq.pcm.taskmodel.AlternativeTask;
import de.uka.ipd.sdq.pcm.taskmodel.taskmodelPackage;

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
 * An implementation of the model object '<em><b>Alternative</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.taskmodel.impl.AlternativeImpl#getAlternativetasks_Alternative <em>Alternativetasks Alternative</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AlternativeImpl extends EObjectImpl implements Alternative {
	/**
	 * The cached value of the '{@link #getAlternativetasks_Alternative() <em>Alternativetasks Alternative</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAlternativetasks_Alternative()
	 * @generated
	 * @ordered
	 */
	protected EList<AlternativeTask> alternativetasks_Alternative;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AlternativeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return taskmodelPackage.Literals.ALTERNATIVE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<AlternativeTask> getAlternativetasks_Alternative() {
		if (alternativetasks_Alternative == null) {
			alternativetasks_Alternative = new EObjectContainmentEList<AlternativeTask>(AlternativeTask.class, this, taskmodelPackage.ALTERNATIVE__ALTERNATIVETASKS_ALTERNATIVE);
		}
		return alternativetasks_Alternative;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case taskmodelPackage.ALTERNATIVE__ALTERNATIVETASKS_ALTERNATIVE:
				return ((InternalEList<?>)getAlternativetasks_Alternative()).basicRemove(otherEnd, msgs);
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
			case taskmodelPackage.ALTERNATIVE__ALTERNATIVETASKS_ALTERNATIVE:
				return getAlternativetasks_Alternative();
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
			case taskmodelPackage.ALTERNATIVE__ALTERNATIVETASKS_ALTERNATIVE:
				getAlternativetasks_Alternative().clear();
				getAlternativetasks_Alternative().addAll((Collection<? extends AlternativeTask>)newValue);
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
			case taskmodelPackage.ALTERNATIVE__ALTERNATIVETASKS_ALTERNATIVE:
				getAlternativetasks_Alternative().clear();
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
			case taskmodelPackage.ALTERNATIVE__ALTERNATIVETASKS_ALTERNATIVE:
				return alternativetasks_Alternative != null && !alternativetasks_Alternative.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //AlternativeImpl
