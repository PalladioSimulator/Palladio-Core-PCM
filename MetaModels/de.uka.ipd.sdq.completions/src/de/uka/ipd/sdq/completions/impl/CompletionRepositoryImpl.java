/**
 * Copyright SDQ, IPD, U Karlsruhe, 2007
 *
 * $Id$
 */
package de.uka.ipd.sdq.completions.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import de.uka.ipd.sdq.completions.Completion;
import de.uka.ipd.sdq.completions.CompletionRepository;
import de.uka.ipd.sdq.completions.CompletionsPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Completion Repository</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.completions.impl.CompletionRepositoryImpl#getCompletions_CompletionRepository <em>Completions Completion Repository</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CompletionRepositoryImpl extends EObjectImpl implements CompletionRepository {
	/**
	 * The cached value of the '{@link #getCompletions_CompletionRepository() <em>Completions Completion Repository</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCompletions_CompletionRepository()
	 * @generated
	 * @ordered
	 */
	protected EList<Completion> completions_CompletionRepository;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CompletionRepositoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CompletionsPackage.Literals.COMPLETION_REPOSITORY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Completion> getCompletions_CompletionRepository() {
		if (completions_CompletionRepository == null) {
			completions_CompletionRepository = new EObjectContainmentEList<Completion>(Completion.class, this, CompletionsPackage.COMPLETION_REPOSITORY__COMPLETIONS_COMPLETION_REPOSITORY);
		}
		return completions_CompletionRepository;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CompletionsPackage.COMPLETION_REPOSITORY__COMPLETIONS_COMPLETION_REPOSITORY:
				return ((InternalEList<?>)getCompletions_CompletionRepository()).basicRemove(otherEnd, msgs);
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
			case CompletionsPackage.COMPLETION_REPOSITORY__COMPLETIONS_COMPLETION_REPOSITORY:
				return getCompletions_CompletionRepository();
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
			case CompletionsPackage.COMPLETION_REPOSITORY__COMPLETIONS_COMPLETION_REPOSITORY:
				getCompletions_CompletionRepository().clear();
				getCompletions_CompletionRepository().addAll((Collection<? extends Completion>)newValue);
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
			case CompletionsPackage.COMPLETION_REPOSITORY__COMPLETIONS_COMPLETION_REPOSITORY:
				getCompletions_CompletionRepository().clear();
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
			case CompletionsPackage.COMPLETION_REPOSITORY__COMPLETIONS_COMPLETION_REPOSITORY:
				return completions_CompletionRepository != null && !completions_CompletionRepository.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //CompletionRepositoryImpl
