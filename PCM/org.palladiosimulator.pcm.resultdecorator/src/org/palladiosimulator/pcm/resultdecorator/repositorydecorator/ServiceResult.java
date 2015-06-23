/**
 */
package org.palladiosimulator.pcm.resultdecorator.repositorydecorator;

import org.eclipse.emf.ecore.EObject;

import de.uka.ipd.sdq.pcm.seff.ServiceEffectSpecification;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Service Result</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc --> Performance results of one service. The context of the resulst is
 * defined by the concrete subclasses (e.g. service result per AllocationContext, etc.) <!--
 * end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>
 * {@link org.palladiosimulator.pcm.resultdecorator.repositorydecorator.ServiceResult#getMeanResponseTime
 * <em>Mean Response Time</em>}</li>
 * <li>
 * {@link org.palladiosimulator.pcm.resultdecorator.repositorydecorator.ServiceResult#getThroughput
 * <em>Throughput</em>}</li>
 * <li>
 * {@link org.palladiosimulator.pcm.resultdecorator.repositorydecorator.ServiceResult#getServiceEffectSpecification_ServiceResult
 * <em>Service Effect Specification Service Result</em>}</li>
 * </ul>
 *
 * @see org.palladiosimulator.pcm.resultdecorator.repositorydecorator.RepositorydecoratorPackage#getServiceResult()
 * @model abstract="true"
 * @generated
 */
public interface ServiceResult extends EObject {

    /**
     * Returns the value of the '<em><b>Mean Response Time</b></em>' attribute. <!-- begin-user-doc
     * -->
     * <p>
     * If the meaning of the '<em>Mean Response Time</em>' attribute isn't clear, there really
     * should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     *
     * @return the value of the '<em>Mean Response Time</em>' attribute.
     * @see #setMeanResponseTime(double)
     * @see org.palladiosimulator.pcm.resultdecorator.repositorydecorator.RepositorydecoratorPackage#getServiceResult_MeanResponseTime()
     * @model required="true" ordered="false"
     * @generated
     */
    double getMeanResponseTime();

    /**
     * Sets the value of the '
     * {@link org.palladiosimulator.pcm.resultdecorator.repositorydecorator.ServiceResult#getMeanResponseTime
     * <em>Mean Response Time</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @param value
     *            the new value of the '<em>Mean Response Time</em>' attribute.
     * @see #getMeanResponseTime()
     * @generated
     */
    void setMeanResponseTime(double value);

    /**
     * Returns the value of the '<em><b>Throughput</b></em>' attribute. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Throughput</em>' attribute isn't clear, there really should be
     * more of a description here...
     * </p>
     * <!-- end-user-doc -->
     *
     * @return the value of the '<em>Throughput</em>' attribute.
     * @see #setThroughput(double)
     * @see org.palladiosimulator.pcm.resultdecorator.repositorydecorator.RepositorydecoratorPackage#getServiceResult_Throughput()
     * @model required="true" ordered="false"
     * @generated
     */
    double getThroughput();

    /**
     * Sets the value of the '
     * {@link org.palladiosimulator.pcm.resultdecorator.repositorydecorator.ServiceResult#getThroughput
     * <em>Throughput</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @param value
     *            the new value of the '<em>Throughput</em>' attribute.
     * @see #getThroughput()
     * @generated
     */
    void setThroughput(double value);

    /**
     * Returns the value of the '<em><b>Service Effect Specification Service Result</b></em>'
     * reference. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Service Effect Specification Service Result</em>' reference isn't
     * clear, there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     *
     * @return the value of the '<em>Service Effect Specification Service Result</em>' reference.
     * @see #setServiceEffectSpecification_ServiceResult(ServiceEffectSpecification)
     * @see org.palladiosimulator.pcm.resultdecorator.repositorydecorator.RepositorydecoratorPackage#getServiceResult_ServiceEffectSpecification_ServiceResult()
     * @model required="true" ordered="false"
     * @generated
     */
    ServiceEffectSpecification getServiceEffectSpecification_ServiceResult();

    /**
     * Sets the value of the '
     * {@link org.palladiosimulator.pcm.resultdecorator.repositorydecorator.ServiceResult#getServiceEffectSpecification_ServiceResult
     * <em>Service Effect Specification Service Result</em>}' reference. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @param value
     *            the new value of the '<em>Service Effect Specification Service Result</em>'
     *            reference.
     * @see #getServiceEffectSpecification_ServiceResult()
     * @generated
     */
    void setServiceEffectSpecification_ServiceResult(ServiceEffectSpecification value);

} // ServiceResult
