/**
 */
package org.palladiosimulator.pcm.resultdecorator.resourceenvironmentdecorator;

import org.eclipse.emf.ecore.EObject;

import org.palladiosimulator.pcm.core.entity.NamedElement;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Utilisation Result</b></em>
 * '. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>
 * {@link org.palladiosimulator.pcm.resultdecorator.resourceenvironmentdecorator.UtilisationResult#getNormalisedResourceUtilisation
 * <em>Normalised Resource Utilisation</em>}</li>
 * <li>
 * {@link org.palladiosimulator.pcm.resultdecorator.resourceenvironmentdecorator.UtilisationResult#getNormalisedWaitTime
 * <em>Normalised Wait Time</em>}</li>
 * <li>
 * {@link org.palladiosimulator.pcm.resultdecorator.resourceenvironmentdecorator.UtilisationResult#getResourceUtilisation
 * <em>Resource Utilisation</em>}</li>
 * <li>
 * {@link org.palladiosimulator.pcm.resultdecorator.resourceenvironmentdecorator.UtilisationResult#getAverageWaitTime
 * <em>Average Wait Time</em>}</li>
 * <li>
 * {@link org.palladiosimulator.pcm.resultdecorator.resourceenvironmentdecorator.UtilisationResult#getAverageQueueLength
 * <em>Average Queue Length</em>}</li>
 * <li>
 * {@link org.palladiosimulator.pcm.resultdecorator.resourceenvironmentdecorator.UtilisationResult#getMaxQueueLength
 * <em>Max Queue Length</em>}</li>
 * </ul>
 *
 * @see org.palladiosimulator.pcm.resultdecorator.resourceenvironmentdecorator.ResourceenvironmentdecoratorPackage#getUtilisationResult()
 * @model abstract="true"
 * @generated
 */
public interface UtilisationResult extends EObject, NamedElement {

    /**
     * Returns the value of the '<em><b>Normalised Resource Utilisation</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc --> <!-- begin-model-doc --> The resource utilisation
     * relative to all resource utilisations in this system. <!-- end-model-doc -->
     *
     * @return the value of the '<em>Normalised Resource Utilisation</em>' attribute.
     * @see #setNormalisedResourceUtilisation(double)
     * @see org.palladiosimulator.pcm.resultdecorator.resourceenvironmentdecorator.ResourceenvironmentdecoratorPackage#getUtilisationResult_NormalisedResourceUtilisation()
     * @model required="true" ordered="false"
     * @generated
     */
    double getNormalisedResourceUtilisation();

    /**
     * Sets the value of the '
     * {@link org.palladiosimulator.pcm.resultdecorator.resourceenvironmentdecorator.UtilisationResult#getNormalisedResourceUtilisation
     * <em>Normalised Resource Utilisation</em>}' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @param value
     *            the new value of the '<em>Normalised Resource Utilisation</em>' attribute.
     * @see #getNormalisedResourceUtilisation()
     * @generated
     */
    void setNormalisedResourceUtilisation(double value);

    /**
     * Returns the value of the '<em><b>Normalised Wait Time</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc --> <!-- begin-model-doc --> The wait time relative to
     * all resource utilisations in this system. <!-- end-model-doc -->
     *
     * @return the value of the '<em>Normalised Wait Time</em>' attribute.
     * @see #setNormalisedWaitTime(double)
     * @see org.palladiosimulator.pcm.resultdecorator.resourceenvironmentdecorator.ResourceenvironmentdecoratorPackage#getUtilisationResult_NormalisedWaitTime()
     * @model required="true" ordered="false"
     * @generated
     */
    double getNormalisedWaitTime();

    /**
     * Sets the value of the '
     * {@link org.palladiosimulator.pcm.resultdecorator.resourceenvironmentdecorator.UtilisationResult#getNormalisedWaitTime
     * <em>Normalised Wait Time</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @param value
     *            the new value of the '<em>Normalised Wait Time</em>' attribute.
     * @see #getNormalisedWaitTime()
     * @generated
     */
    void setNormalisedWaitTime(double value);

    /**
     * Returns the value of the '<em><b>Resource Utilisation</b></em>' attribute. The default value
     * is <code>"0"</code>. <!-- begin-user-doc --> <!-- end-user-doc --> <!-- begin-model-doc -->
     * The resource utilisation of this resource between 0 and 1. <!-- end-model-doc -->
     *
     * @return the value of the '<em>Resource Utilisation</em>' attribute.
     * @see #setResourceUtilisation(double)
     * @see org.palladiosimulator.pcm.resultdecorator.resourceenvironmentdecorator.ResourceenvironmentdecoratorPackage#getUtilisationResult_ResourceUtilisation()
     * @model default="0" required="true" ordered="false"
     * @generated
     */
    double getResourceUtilisation();

    /**
     * Sets the value of the '
     * {@link org.palladiosimulator.pcm.resultdecorator.resourceenvironmentdecorator.UtilisationResult#getResourceUtilisation
     * <em>Resource Utilisation</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @param value
     *            the new value of the '<em>Resource Utilisation</em>' attribute.
     * @see #getResourceUtilisation()
     * @generated
     */
    void setResourceUtilisation(double value);

    /**
     * Returns the value of the '<em><b>Average Wait Time</b></em>' attribute. The default value is
     * <code>"0"</code>. <!-- begin-user-doc --> <!-- end-user-doc --> <!-- begin-model-doc --> The
     * average time that each job has to wait before (FIFO) or while (processor sharing) accessing
     * the resource. <!-- end-model-doc -->
     *
     * @return the value of the '<em>Average Wait Time</em>' attribute.
     * @see #setAverageWaitTime(double)
     * @see org.palladiosimulator.pcm.resultdecorator.resourceenvironmentdecorator.ResourceenvironmentdecoratorPackage#getUtilisationResult_AverageWaitTime()
     * @model default="0" required="true" ordered="false"
     * @generated
     */
    double getAverageWaitTime();

    /**
     * Sets the value of the '
     * {@link org.palladiosimulator.pcm.resultdecorator.resourceenvironmentdecorator.UtilisationResult#getAverageWaitTime
     * <em>Average Wait Time</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @param value
     *            the new value of the '<em>Average Wait Time</em>' attribute.
     * @see #getAverageWaitTime()
     * @generated
     */
    void setAverageWaitTime(double value);

    /**
     * Returns the value of the '<em><b>Average Queue Length</b></em>' attribute. The default value
     * is <code>"0"</code>. <!-- begin-user-doc --> <!-- end-user-doc --> <!-- begin-model-doc -->
     * The average length of the queue at this resource. For processor sharing, this is the number
     * of busy jobs - 1. <!-- end-model-doc -->
     *
     * @return the value of the '<em>Average Queue Length</em>' attribute.
     * @see #setAverageQueueLength(double)
     * @see org.palladiosimulator.pcm.resultdecorator.resourceenvironmentdecorator.ResourceenvironmentdecoratorPackage#getUtilisationResult_AverageQueueLength()
     * @model default="0" required="true" ordered="false"
     * @generated
     */
    double getAverageQueueLength();

    /**
     * Sets the value of the '
     * {@link org.palladiosimulator.pcm.resultdecorator.resourceenvironmentdecorator.UtilisationResult#getAverageQueueLength
     * <em>Average Queue Length</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @param value
     *            the new value of the '<em>Average Queue Length</em>' attribute.
     * @see #getAverageQueueLength()
     * @generated
     */
    void setAverageQueueLength(double value);

    /**
     * Returns the value of the '<em><b>Max Queue Length</b></em>' attribute. The default value is
     * <code>"0"</code>. <!-- begin-user-doc --> <!-- end-user-doc --> <!-- begin-model-doc --> The
     * maximum length of the queue at this resource that has been observed during a simulation or
     * that has been analytically determined, if possible. For processor sharing, this is the
     * maximum number of busy jobs - 1. <!-- end-model-doc -->
     *
     * @return the value of the '<em>Max Queue Length</em>' attribute.
     * @see #setMaxQueueLength(int)
     * @see org.palladiosimulator.pcm.resultdecorator.resourceenvironmentdecorator.ResourceenvironmentdecoratorPackage#getUtilisationResult_MaxQueueLength()
     * @model default="0" required="true" ordered="false"
     * @generated
     */
    int getMaxQueueLength();

    /**
     * Sets the value of the '
     * {@link org.palladiosimulator.pcm.resultdecorator.resourceenvironmentdecorator.UtilisationResult#getMaxQueueLength
     * <em>Max Queue Length</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @param value
     *            the new value of the '<em>Max Queue Length</em>' attribute.
     * @see #getMaxQueueLength()
     * @generated
     */
    void setMaxQueueLength(int value);

} // UtilisationResult
