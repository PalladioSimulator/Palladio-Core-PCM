/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.fzi.se.quality.parameters;

import de.uka.ipd.sdq.identifier.Identifier;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Parameter Instance</b></em>
 * '. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link de.fzi.se.quality.parameters.ParameterInstance#getParameterReference <em>Parameter
 * Reference</em>}</li>
 * <li>{@link de.fzi.se.quality.parameters.ParameterInstance#getInputCallInstance <em>Input Call
 * Instance</em>}</li>
 * <li>{@link de.fzi.se.quality.parameters.ParameterInstance#getOutputCallInstance <em>Output Call
 * Instance</em>}</li>
 * <li>{@link de.fzi.se.quality.parameters.ParameterInstance#getComponentInstance <em>Component
 * Instance</em>}</li>
 * <li>{@link de.fzi.se.quality.parameters.ParameterInstance#getParameterValue <em>Parameter Value
 * </em>}</li>
 * </ul>
 * </p>
 *
 * @see de.fzi.se.quality.parameters.ParametersPackage#getParameterInstance()
 * @model
 * @generated
 */
public interface ParameterInstance extends Identifier {

    /**
     * Returns the value of the '<em><b>Parameter Reference</b></em>' containment reference. It is
     * bidirectional and its opposite is '
     * {@link de.fzi.se.quality.parameters.ParameterReference#getParameterInstance
     * <em>Parameter Instance</em>}'. <!-- begin-user-doc --> <!-- end-user-doc --> <!--
     * begin-model-doc --> Reference to the parameter. No reference if, and only if, the return
     * value of an operation is addressed. <!-- end-model-doc -->
     *
     * @return the value of the '<em>Parameter Reference</em>' containment reference.
     * @see #setParameterReference(ParameterReference)
     * @see de.fzi.se.quality.parameters.ParametersPackage#getParameterInstance_ParameterReference()
     * @see de.fzi.se.quality.parameters.ParameterReference#getParameterInstance
     * @model opposite="parameterInstance" containment="true" ordered="false"
     * @generated
     */
    ParameterReference getParameterReference();

    /**
     * Sets the value of the '
     * {@link de.fzi.se.quality.parameters.ParameterInstance#getParameterReference
     * <em>Parameter Reference</em>}' containment reference. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @param value
     *            the new value of the '<em>Parameter Reference</em>' containment reference.
     * @see #getParameterReference()
     * @generated
     */
    void setParameterReference(ParameterReference value);

    /**
     * Returns the value of the '<em><b>Input Call Instance</b></em>' container reference. It is
     * bidirectional and its opposite is '
     * {@link de.fzi.se.quality.parameters.CallInstance#getInputParameterInstances
     * <em>Input Parameter Instances</em>}'. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Input Call Instance</em>' container reference isn't clear, there
     * really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     *
     * @return the value of the '<em>Input Call Instance</em>' container reference.
     * @see #setInputCallInstance(CallInstance)
     * @see de.fzi.se.quality.parameters.ParametersPackage#getParameterInstance_InputCallInstance()
     * @see de.fzi.se.quality.parameters.CallInstance#getInputParameterInstances
     * @model opposite="inputParameterInstances" transient="false" ordered="false"
     * @generated
     */
    CallInstance getInputCallInstance();

    /**
     * Sets the value of the '
     * {@link de.fzi.se.quality.parameters.ParameterInstance#getInputCallInstance
     * <em>Input Call Instance</em>}' container reference. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     *
     * @param value
     *            the new value of the '<em>Input Call Instance</em>' container reference.
     * @see #getInputCallInstance()
     * @generated
     */
    void setInputCallInstance(CallInstance value);

    /**
     * Returns the value of the '<em><b>Output Call Instance</b></em>' container reference. It is
     * bidirectional and its opposite is '
     * {@link de.fzi.se.quality.parameters.CallInstance#getOutputParameterInstances
     * <em>Output Parameter Instances</em>}'. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Output Call Instance</em>' container reference isn't clear, there
     * really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     *
     * @return the value of the '<em>Output Call Instance</em>' container reference.
     * @see #setOutputCallInstance(CallInstance)
     * @see de.fzi.se.quality.parameters.ParametersPackage#getParameterInstance_OutputCallInstance()
     * @see de.fzi.se.quality.parameters.CallInstance#getOutputParameterInstances
     * @model opposite="outputParameterInstances" transient="false" ordered="false"
     * @generated
     */
    CallInstance getOutputCallInstance();

    /**
     * Sets the value of the '
     * {@link de.fzi.se.quality.parameters.ParameterInstance#getOutputCallInstance
     * <em>Output Call Instance</em>}' container reference. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @param value
     *            the new value of the '<em>Output Call Instance</em>' container reference.
     * @see #getOutputCallInstance()
     * @generated
     */
    void setOutputCallInstance(CallInstance value);

    /**
     * Returns the value of the '<em><b>Component Instance</b></em>' container reference. It is
     * bidirectional and its opposite is '
     * {@link de.fzi.se.quality.parameters.ComponentInstance#getParameterInstances
     * <em>Parameter Instances</em>}'. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Component Instance</em>' container reference isn't clear, there
     * really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     *
     * @return the value of the '<em>Component Instance</em>' container reference.
     * @see #setComponentInstance(ComponentInstance)
     * @see de.fzi.se.quality.parameters.ParametersPackage#getParameterInstance_ComponentInstance()
     * @see de.fzi.se.quality.parameters.ComponentInstance#getParameterInstances
     * @model opposite="parameterInstances" transient="false" ordered="false"
     * @generated
     */
    ComponentInstance getComponentInstance();

    /**
     * Sets the value of the '
     * {@link de.fzi.se.quality.parameters.ParameterInstance#getComponentInstance
     * <em>Component Instance</em>}' container reference. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     *
     * @param value
     *            the new value of the '<em>Component Instance</em>' container reference.
     * @see #getComponentInstance()
     * @generated
     */
    void setComponentInstance(ComponentInstance value);

    /**
     * Returns the value of the '<em><b>Parameter Value</b></em>' containment reference. It is
     * bidirectional and its opposite is '
     * {@link de.fzi.se.quality.parameters.ParameterValue#getParameterInstance
     * <em>Parameter Instance</em>}'. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Parameter Value</em>' containment reference isn't clear, there
     * really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     *
     * @return the value of the '<em>Parameter Value</em>' containment reference.
     * @see #setParameterValue(ParameterValue)
     * @see de.fzi.se.quality.parameters.ParametersPackage#getParameterInstance_ParameterValue()
     * @see de.fzi.se.quality.parameters.ParameterValue#getParameterInstance
     * @model opposite="parameterInstance" containment="true" required="true" ordered="false"
     * @generated
     */
    ParameterValue getParameterValue();

    /**
     * Sets the value of the '
     * {@link de.fzi.se.quality.parameters.ParameterInstance#getParameterValue
     * <em>Parameter Value</em>}' containment reference. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     *
     * @param value
     *            the new value of the '<em>Parameter Value</em>' containment reference.
     * @see #getParameterValue()
     * @generated
     */
    void setParameterValue(ParameterValue value);

} // ParameterInstance
