/**
 * Copyright 2008, sdq.ipd.uka.de, U KA
 *
 * $Id$
 */
package de.uka.ipd.sdq.simucomframework.simucomstatus;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Wait For Delay</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link de.uka.ipd.sdq.simucomframework.simucomstatus.WaitForDelay#getDelay <em>Delay</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.simucomframework.simucomstatus.SimucomstatusPackage#getWaitForDelay()
 * @model
 * @generated
 */
public interface WaitForDelay extends Action {
    /**
     * Returns the value of the '<em><b>Delay</b></em>' attribute. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Delay</em>' attribute isn't clear, there really should be more of
     * a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Delay</em>' attribute.
     * @see #setDelay(double)
     * @see de.uka.ipd.sdq.simucomframework.simucomstatus.SimucomstatusPackage#getWaitForDelay_Delay()
     * @model required="true" ordered="false"
     * @generated
     */
    double getDelay();

    /**
     * Sets the value of the '
     * {@link de.uka.ipd.sdq.simucomframework.simucomstatus.WaitForDelay#getDelay <em>Delay</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>Delay</em>' attribute.
     * @see #getDelay()
     * @generated
     */
    void setDelay(double value);

} // WaitForDelay
