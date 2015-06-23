/**
 * Copyright SDQ, IPD, U Karlsruhe, 2007
 */
package org.palladiosimulator.completions.impl;

import java.util.Collection;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import org.palladiosimulator.completions.Completion;
import org.palladiosimulator.completions.CompletionRepository;
import org.palladiosimulator.completions.CompletionsPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Completion Repository</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.palladiosimulator.completions.impl.CompletionRepositoryImpl#getCompletions_CompletionRepository <em>Completions Completion Repository</em>}</li>
 * </ul>
 *
 * @generated
 */
public class CompletionRepositoryImpl extends EObjectImpl implements CompletionRepository {
    /**
     * The cached value of the '{@link #getCompletions_CompletionRepository() <em>Completions Completion Repository</em>}' reference list.
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
            completions_CompletionRepository = new EObjectResolvingEList<Completion>(Completion.class, this, CompletionsPackage.COMPLETION_REPOSITORY__COMPLETIONS_COMPLETION_REPOSITORY);
        }
        return completions_CompletionRepository;
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
