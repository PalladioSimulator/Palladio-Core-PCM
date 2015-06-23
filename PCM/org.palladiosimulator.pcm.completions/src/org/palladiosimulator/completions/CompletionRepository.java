/**
 * Copyright SDQ, IPD, U Karlsruhe, 2007
 */
package org.palladiosimulator.completions;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Completion Repository</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.palladiosimulator.completions.CompletionRepository#getCompletions_CompletionRepository <em>Completions Completion Repository</em>}</li>
 * </ul>
 *
 * @see org.palladiosimulator.completions.CompletionsPackage#getCompletionRepository()
 * @model
 * @generated
 */
public interface CompletionRepository extends EObject {
    /**
     * Returns the value of the '<em><b>Completions Completion Repository</b></em>' reference list.
     * The list contents are of type {@link org.palladiosimulator.completions.Completion}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Completions Completion Repository</em>' reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Completions Completion Repository</em>' reference list.
     * @see org.palladiosimulator.completions.CompletionsPackage#getCompletionRepository_Completions_CompletionRepository()
     * @model ordered="false"
     * @generated
     */
    EList<Completion> getCompletions_CompletionRepository();

} // CompletionRepository
