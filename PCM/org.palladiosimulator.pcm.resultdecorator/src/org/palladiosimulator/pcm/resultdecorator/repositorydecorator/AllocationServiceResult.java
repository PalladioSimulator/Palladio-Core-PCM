/**
 */
package org.palladiosimulator.pcm.resultdecorator.repositorydecorator;

import de.uka.ipd.sdq.pcm.allocation.AllocationContext;

/**
 * <!-- begin-user-doc --> A representation of the model object '
 * <em><b>Allocation Service Result</b></em>'. <!-- end-user-doc -->
 *
 * <!-- begin-model-doc --> Performance results of one service within one AllocationContext. Thus,
 * for one AllocationContext in the system there should only exist one AllocationServiceResult per
 * ResultdecoratorRepostory (TODO: OCL constraint). In particular, this means that even if the
 * system has several UsageScenarios, there is only one AllocationServiceResult. <!-- end-model-doc
 * -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>
 * {@link org.palladiosimulator.pcm.resultdecorator.repositorydecorator.AllocationServiceResult#getAllocationContext_AllocationServiceResult
 * <em>Allocation Context Allocation Service Result</em>}</li>
 * </ul>
 *
 * @see org.palladiosimulator.pcm.resultdecorator.repositorydecorator.RepositorydecoratorPackage#getAllocationServiceResult()
 * @model
 * @generated
 */
public interface AllocationServiceResult extends ServiceResult {

    /**
     * Returns the value of the '<em><b>Allocation Context Allocation Service Result</b></em>'
     * reference. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Allocation Context Allocation Service Result</em>' reference isn't
     * clear, there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     *
     * @return the value of the '<em>Allocation Context Allocation Service Result</em>' reference.
     * @see #setAllocationContext_AllocationServiceResult(AllocationContext)
     * @see org.palladiosimulator.pcm.resultdecorator.repositorydecorator.RepositorydecoratorPackage#getAllocationServiceResult_AllocationContext_AllocationServiceResult()
     * @model required="true" ordered="false"
     * @generated
     */
    AllocationContext getAllocationContext_AllocationServiceResult();

    /**
     * Sets the value of the '
     * {@link org.palladiosimulator.pcm.resultdecorator.repositorydecorator.AllocationServiceResult#getAllocationContext_AllocationServiceResult
     * <em>Allocation Context Allocation Service Result</em>}' reference. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @param value
     *            the new value of the '<em>Allocation Context Allocation Service Result</em>'
     *            reference.
     * @see #getAllocationContext_AllocationServiceResult()
     * @generated
     */
    void setAllocationContext_AllocationServiceResult(AllocationContext value);

} // AllocationServiceResult
