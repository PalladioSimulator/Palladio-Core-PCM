/**
 */
package org.palladiosimulator.pcm.resultdecorator.resourceenvironmentdecorator;

import org.palladiosimulator.pcm.core.composition.AssemblyContext;
import org.palladiosimulator.pcm.repository.PassiveResource;

/**
 * <!-- begin-user-doc --> A representation of the model object '
 * <em><b>Passive Resource Result</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>
 * {@link org.palladiosimulator.pcm.resultdecorator.resourceenvironmentdecorator.PassiveResourceResult#getPassiveResource_PassiveResourceResult
 * <em>Passive Resource Passive Resource Result</em>}</li>
 * <li>
 * {@link org.palladiosimulator.pcm.resultdecorator.resourceenvironmentdecorator.PassiveResourceResult#getAssemblyContext_PassiveResourceResult
 * <em>Assembly Context Passive Resource Result</em>}</li>
 * <li>
 * {@link org.palladiosimulator.pcm.resultdecorator.resourceenvironmentdecorator.PassiveResourceResult#getAverageHoldingTime
 * <em>Average Holding Time</em>}</li>
 * </ul>
 *
 * @see org.palladiosimulator.pcm.resultdecorator.resourceenvironmentdecorator.ResourceenvironmentdecoratorPackage#getPassiveResourceResult()
 * @model
 * @generated
 */
public interface PassiveResourceResult extends UtilisationResult {

    /**
     * Returns the value of the '<em><b>Passive Resource Passive Resource Result</b></em>'
     * reference. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Passive Resource Passive Resource Result</em>' reference isn't
     * clear, there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     *
     * @return the value of the '<em>Passive Resource Passive Resource Result</em>' reference.
     * @see #setPassiveResource_PassiveResourceResult(PassiveResource)
     * @see org.palladiosimulator.pcm.resultdecorator.resourceenvironmentdecorator.ResourceenvironmentdecoratorPackage#getPassiveResourceResult_PassiveResource_PassiveResourceResult()
     * @model required="true" ordered="false"
     * @generated
     */
    PassiveResource getPassiveResource_PassiveResourceResult();

    /**
     * Sets the value of the '
     * {@link org.palladiosimulator.pcm.resultdecorator.resourceenvironmentdecorator.PassiveResourceResult#getPassiveResource_PassiveResourceResult
     * <em>Passive Resource Passive Resource Result</em>}' reference. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @param value
     *            the new value of the '<em>Passive Resource Passive Resource Result</em>'
     *            reference.
     * @see #getPassiveResource_PassiveResourceResult()
     * @generated
     */
    void setPassiveResource_PassiveResourceResult(PassiveResource value);

    /**
     * Returns the value of the '<em><b>Assembly Context Passive Resource Result</b></em>'
     * reference. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Assembly Context Passive Resource Result</em>' reference isn't
     * clear, there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     *
     * @return the value of the '<em>Assembly Context Passive Resource Result</em>' reference.
     * @see #setAssemblyContext_PassiveResourceResult(AssemblyContext)
     * @see org.palladiosimulator.pcm.resultdecorator.resourceenvironmentdecorator.ResourceenvironmentdecoratorPackage#getPassiveResourceResult_AssemblyContext_PassiveResourceResult()
     * @model ordered="false"
     * @generated
     */
    AssemblyContext getAssemblyContext_PassiveResourceResult();

    /**
     * Sets the value of the '
     * {@link org.palladiosimulator.pcm.resultdecorator.resourceenvironmentdecorator.PassiveResourceResult#getAssemblyContext_PassiveResourceResult
     * <em>Assembly Context Passive Resource Result</em>}' reference. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @param value
     *            the new value of the '<em>Assembly Context Passive Resource Result</em>'
     *            reference.
     * @see #getAssemblyContext_PassiveResourceResult()
     * @generated
     */
    void setAssemblyContext_PassiveResourceResult(AssemblyContext value);

    /**
     * Returns the value of the '<em><b>Average Holding Time</b></em>' attribute. <!--
     * begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Average Holding Time</em>' attribute isn't clear, there really
     * should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     *
     * @return the value of the '<em>Average Holding Time</em>' attribute.
     * @see #setAverageHoldingTime(double)
     * @see org.palladiosimulator.pcm.resultdecorator.resourceenvironmentdecorator.ResourceenvironmentdecoratorPackage#getPassiveResourceResult_AverageHoldingTime()
     * @model required="true" ordered="false"
     * @generated
     */
    double getAverageHoldingTime();

    /**
     * Sets the value of the '
     * {@link org.palladiosimulator.pcm.resultdecorator.resourceenvironmentdecorator.PassiveResourceResult#getAverageHoldingTime
     * <em>Average Holding Time</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @param value
     *            the new value of the '<em>Average Holding Time</em>' attribute.
     * @see #getAverageHoldingTime()
     * @generated
     */
    void setAverageHoldingTime(double value);

} // PassiveResourceResult
