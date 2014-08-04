/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.sensitivity;

/**
 * <!-- begin-user-doc --> A representation of the model object '
 * <em><b>Double Parameter Range</b></em>'. <!-- end-user-doc -->
 *
 * <!-- begin-model-doc --> Specifies&nbsp;a value range (i.e. an interval) with a given step size
 * or step count, to define&nbsp;a variation&nbsp;of&nbsp;a&nbsp;sensitivity parameter of type
 * DOUBLE. <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link de.uka.ipd.sdq.sensitivity.DoubleParameterRange#isConsiderStepSize <em>Consider Step
 * Size</em>}</li>
 * <li>{@link de.uka.ipd.sdq.sensitivity.DoubleParameterRange#getFirstValue <em>First Value</em>}</li>
 * <li>{@link de.uka.ipd.sdq.sensitivity.DoubleParameterRange#getLastValue <em>Last Value</em>}</li>
 * <li>{@link de.uka.ipd.sdq.sensitivity.DoubleParameterRange#getStepSize <em>Step Size</em>}</li>
 * <li>{@link de.uka.ipd.sdq.sensitivity.DoubleParameterRange#getStepCount <em>Step Count</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.sensitivity.SensitivityPackage#getDoubleParameterRange()
 * @model
 * @generated
 */
public interface DoubleParameterRange extends DoubleParameterVariation {
    /**
     * Returns the value of the '<em><b>Consider Step Size</b></em>' attribute. <!-- begin-user-doc
     * --> <!-- end-user-doc --> <!-- begin-model-doc -->
     * Decides&nbsp;if&nbsp;the&nbsp;step&nbsp;width
     * &nbsp;is&nbsp;used&nbsp;to&nbsp;determine&nbsp;the
     * &nbsp;value&nbsp;sequence&nbsp;(considerStepSize
     * &nbsp;==&nbsp;true)&nbsp;or&nbsp;the&nbsp;step&nbsp;count<br />
     * (considerStepSize&nbsp;==&nbsp;false). <!-- end-model-doc -->
     * 
     * @return the value of the '<em>Consider Step Size</em>' attribute.
     * @see #setConsiderStepSize(boolean)
     * @see de.uka.ipd.sdq.sensitivity.SensitivityPackage#getDoubleParameterRange_ConsiderStepSize()
     * @model required="true" ordered="false"
     * @generated
     */
    boolean isConsiderStepSize();

    /**
     * Sets the value of the '
     * {@link de.uka.ipd.sdq.sensitivity.DoubleParameterRange#isConsiderStepSize
     * <em>Consider Step Size</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>Consider Step Size</em>' attribute.
     * @see #isConsiderStepSize()
     * @generated
     */
    void setConsiderStepSize(boolean value);

    /**
     * Returns the value of the '<em><b>First Value</b></em>' attribute. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>First Value</em>' attribute isn't clear, there really should be
     * more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>First Value</em>' attribute.
     * @see #setFirstValue(double)
     * @see de.uka.ipd.sdq.sensitivity.SensitivityPackage#getDoubleParameterRange_FirstValue()
     * @model required="true" ordered="false"
     * @generated
     */
    double getFirstValue();

    /**
     * Sets the value of the '{@link de.uka.ipd.sdq.sensitivity.DoubleParameterRange#getFirstValue
     * <em>First Value</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>First Value</em>' attribute.
     * @see #getFirstValue()
     * @generated
     */
    void setFirstValue(double value);

    /**
     * Returns the value of the '<em><b>Last Value</b></em>' attribute. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Last Value</em>' attribute isn't clear, there really should be
     * more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Last Value</em>' attribute.
     * @see #setLastValue(double)
     * @see de.uka.ipd.sdq.sensitivity.SensitivityPackage#getDoubleParameterRange_LastValue()
     * @model required="true" ordered="false"
     * @generated
     */
    double getLastValue();

    /**
     * Sets the value of the '{@link de.uka.ipd.sdq.sensitivity.DoubleParameterRange#getLastValue
     * <em>Last Value</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>Last Value</em>' attribute.
     * @see #getLastValue()
     * @generated
     */
    void setLastValue(double value);

    /**
     * Returns the value of the '<em><b>Step Size</b></em>' attribute. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Step Size</em>' attribute isn't clear, there really should be more
     * of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Step Size</em>' attribute.
     * @see #setStepSize(double)
     * @see de.uka.ipd.sdq.sensitivity.SensitivityPackage#getDoubleParameterRange_StepSize()
     * @model required="true" ordered="false"
     * @generated
     */
    double getStepSize();

    /**
     * Sets the value of the '{@link de.uka.ipd.sdq.sensitivity.DoubleParameterRange#getStepSize
     * <em>Step Size</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>Step Size</em>' attribute.
     * @see #getStepSize()
     * @generated
     */
    void setStepSize(double value);

    /**
     * Returns the value of the '<em><b>Step Count</b></em>' attribute. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Step Count</em>' attribute isn't clear, there really should be
     * more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Step Count</em>' attribute.
     * @see #setStepCount(int)
     * @see de.uka.ipd.sdq.sensitivity.SensitivityPackage#getDoubleParameterRange_StepCount()
     * @model required="true" ordered="false"
     * @generated
     */
    int getStepCount();

    /**
     * Sets the value of the '{@link de.uka.ipd.sdq.sensitivity.DoubleParameterRange#getStepCount
     * <em>Step Count</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>Step Count</em>' attribute.
     * @see #getStepCount()
     * @generated
     */
    void setStepCount(int value);

} // DoubleParameterRange
