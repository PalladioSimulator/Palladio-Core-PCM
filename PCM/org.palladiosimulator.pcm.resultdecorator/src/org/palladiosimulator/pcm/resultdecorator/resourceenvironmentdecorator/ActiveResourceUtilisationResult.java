/**
 */
package org.palladiosimulator.pcm.resultdecorator.resourceenvironmentdecorator;

/**
 * <!-- begin-user-doc --> A representation of the model object '
 * <em><b>Active Resource Utilisation Result</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>
 * {@link org.palladiosimulator.pcm.resultdecorator.resourceenvironmentdecorator.ActiveResourceUtilisationResult#getNormalisedDemandedTime
 * <em>Normalised Demanded Time</em>}</li>
 * <li>
 * {@link org.palladiosimulator.pcm.resultdecorator.resourceenvironmentdecorator.ActiveResourceUtilisationResult#getDemandedTime
 * <em>Demanded Time</em>}</li>
 * </ul>
 *
 * @see org.palladiosimulator.pcm.resultdecorator.resourceenvironmentdecorator.ResourceenvironmentdecoratorPackage#getActiveResourceUtilisationResult()
 * @model abstract="true"
 * @generated
 */
public interface ActiveResourceUtilisationResult extends UtilisationResult {

    /**
     * Returns the value of the '<em><b>Normalised Demanded Time</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc --> <!-- begin-model-doc --> The demanded time relative
     * to all demanded times (in the system or in the resource container?) <!-- end-model-doc -->
     *
     * @return the value of the '<em>Normalised Demanded Time</em>' attribute.
     * @see #setNormalisedDemandedTime(double)
     * @see org.palladiosimulator.pcm.resultdecorator.resourceenvironmentdecorator.ResourceenvironmentdecoratorPackage#getActiveResourceUtilisationResult_NormalisedDemandedTime()
     * @model required="true" ordered="false"
     * @generated
     */
    double getNormalisedDemandedTime();

    /**
     * Sets the value of the '
     * {@link org.palladiosimulator.pcm.resultdecorator.resourceenvironmentdecorator.ActiveResourceUtilisationResult#getNormalisedDemandedTime
     * <em>Normalised Demanded Time</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @param value
     *            the new value of the '<em>Normalised Demanded Time</em>' attribute.
     * @see #getNormalisedDemandedTime()
     * @generated
     */
    void setNormalisedDemandedTime(double value);

    /**
     * Returns the value of the '<em><b>Demanded Time</b></em>' attribute. The default value is
     * <code>"0"</code>. <!-- begin-user-doc --> <!-- end-user-doc --> <!-- begin-model-doc --> The
     * average time that each job requests from this active resource. <!-- end-model-doc -->
     *
     * @return the value of the '<em>Demanded Time</em>' attribute.
     * @see #setDemandedTime(double)
     * @see org.palladiosimulator.pcm.resultdecorator.resourceenvironmentdecorator.ResourceenvironmentdecoratorPackage#getActiveResourceUtilisationResult_DemandedTime()
     * @model default="0" required="true" ordered="false"
     * @generated
     */
    double getDemandedTime();

    /**
     * Sets the value of the '
     * {@link org.palladiosimulator.pcm.resultdecorator.resourceenvironmentdecorator.ActiveResourceUtilisationResult#getDemandedTime
     * <em>Demanded Time</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @param value
     *            the new value of the '<em>Demanded Time</em>' attribute.
     * @see #getDemandedTime()
     * @generated
     */
    void setDemandedTime(double value);

} // ActiveResourceUtilisationResult
