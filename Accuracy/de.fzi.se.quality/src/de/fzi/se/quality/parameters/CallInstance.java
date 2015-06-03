/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.fzi.se.quality.parameters;

import org.eclipse.emf.common.util.EList;

import de.uka.ipd.sdq.identifier.Identifier;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Call Instance</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link de.fzi.se.quality.parameters.CallInstance#getOperationReference <em>Operation
 * Reference</em>}</li>
 * <li>{@link de.fzi.se.quality.parameters.CallInstance#getOutputParameterInstances <em>Output
 * Parameter Instances</em>}</li>
 * <li>{@link de.fzi.se.quality.parameters.CallInstance#getNumberOfCalls <em>Number Of Calls</em>}</li>
 * <li>{@link de.fzi.se.quality.parameters.CallInstance#getInputParameterInstances <em>Input
 * Parameter Instances</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.fzi.se.quality.parameters.ParametersPackage#getCallInstance()
 * @model
 * @generated
 */
public interface CallInstance extends Identifier {

    /**
     * Returns the value of the '<em><b>Operation Reference</b></em>' containment reference. It is
     * bidirectional and its opposite is '
     * {@link de.fzi.se.quality.parameters.OperationReference#getCallInstance
     * <em>Call Instance</em>}'. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Operation Reference</em>' containment reference isn't clear, there
     * really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     *
     * @return the value of the '<em>Operation Reference</em>' containment reference.
     * @see #setOperationReference(OperationReference)
     * @see de.fzi.se.quality.parameters.ParametersPackage#getCallInstance_OperationReference()
     * @see de.fzi.se.quality.parameters.OperationReference#getCallInstance
     * @model opposite="callInstance" containment="true" required="true" ordered="false"
     * @generated
     */
    OperationReference getOperationReference();

    /**
     * Sets the value of the '
     * {@link de.fzi.se.quality.parameters.CallInstance#getOperationReference
     * <em>Operation Reference</em>}' containment reference. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @param value
     *            the new value of the '<em>Operation Reference</em>' containment reference.
     * @see #getOperationReference()
     * @generated
     */
    void setOperationReference(OperationReference value);

    /**
     * Returns the value of the '<em><b>Output Parameter Instances</b></em>' containment reference
     * list. The list contents are of type {@link de.fzi.se.quality.parameters.ParameterInstance}.
     * It is bidirectional and its opposite is '
     * {@link de.fzi.se.quality.parameters.ParameterInstance#getOutputCallInstance
     * <em>Output Call Instance</em>}'. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Output Parameter Instances</em>' containment reference list isn't
     * clear, there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     *
     * @return the value of the '<em>Output Parameter Instances</em>' containment reference list.
     * @see de.fzi.se.quality.parameters.ParametersPackage#getCallInstance_OutputParameterInstances()
     * @see de.fzi.se.quality.parameters.ParameterInstance#getOutputCallInstance
     * @model opposite="outputCallInstance" containment="true" ordered="false"
     * @generated
     */
    EList<ParameterInstance> getOutputParameterInstances();

    /**
     * Returns the value of the '<em><b>Number Of Calls</b></em>' attribute. The default value is
     * <code>"1"</code>. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Number Of Calls</em>' attribute isn't clear, there really should
     * be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     *
     * @return the value of the '<em>Number Of Calls</em>' attribute.
     * @see #setNumberOfCalls(long)
     * @see de.fzi.se.quality.parameters.ParametersPackage#getCallInstance_NumberOfCalls()
     * @model default="1" required="true" ordered="false"
     * @generated
     */
    long getNumberOfCalls();

    /**
     * Sets the value of the '{@link de.fzi.se.quality.parameters.CallInstance#getNumberOfCalls
     * <em>Number Of Calls</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @param value
     *            the new value of the '<em>Number Of Calls</em>' attribute.
     * @see #getNumberOfCalls()
     * @generated
     */
    void setNumberOfCalls(long value);

    /**
     * Returns the value of the '<em><b>Input Parameter Instances</b></em>' containment reference
     * list. The list contents are of type {@link de.fzi.se.quality.parameters.ParameterInstance}.
     * It is bidirectional and its opposite is '
     * {@link de.fzi.se.quality.parameters.ParameterInstance#getInputCallInstance
     * <em>Input Call Instance</em>}'. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Input Parameter Instances</em>' containment reference list isn't
     * clear, there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     *
     * @return the value of the '<em>Input Parameter Instances</em>' containment reference list.
     * @see de.fzi.se.quality.parameters.ParametersPackage#getCallInstance_InputParameterInstances()
     * @see de.fzi.se.quality.parameters.ParameterInstance#getInputCallInstance
     * @model opposite="inputCallInstance" containment="true" ordered="false"
     * @generated
     */
    EList<ParameterInstance> getInputParameterInstances();

} // CallInstance
