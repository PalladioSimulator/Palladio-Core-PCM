/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.fzi.se.quality.parameters;

import de.fzi.se.quality.qualityannotation.ParameterValueDeviation;
import de.uka.ipd.sdq.identifier.Identifier;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Parameter Reference</b></em>
 * '. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link de.fzi.se.quality.parameters.ParameterReference#getParameterPartition <em>Parameter
 * Partition</em>}</li>
 * <li>{@link de.fzi.se.quality.parameters.ParameterReference#getParameterInstance <em>Parameter
 * Instance</em>}</li>
 * <li>{@link de.fzi.se.quality.parameters.ParameterReference#getParameterValueDeviation <em>
 * Parameter Value Deviation</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.fzi.se.quality.parameters.ParametersPackage#getParameterReference()
 * @model abstract="true"
 * @generated
 */
public interface ParameterReference extends Identifier {

    /**
     * Returns the value of the '<em><b>Parameter Partition</b></em>' container reference. It is
     * bidirectional and its opposite is '
     * {@link de.fzi.se.quality.parameters.ParameterPartition#getParameterReference
     * <em>Parameter Reference</em>}'. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Parameter Partition</em>' container reference isn't clear, there
     * really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     *
     * @return the value of the '<em>Parameter Partition</em>' container reference.
     * @see #setParameterPartition(ParameterPartition)
     * @see de.fzi.se.quality.parameters.ParametersPackage#getParameterReference_ParameterPartition()
     * @see de.fzi.se.quality.parameters.ParameterPartition#getParameterReference
     * @model opposite="parameterReference" transient="false" ordered="false"
     * @generated
     */
    ParameterPartition getParameterPartition();

    /**
     * Sets the value of the '
     * {@link de.fzi.se.quality.parameters.ParameterReference#getParameterPartition
     * <em>Parameter Partition</em>}' container reference. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     *
     * @param value
     *            the new value of the '<em>Parameter Partition</em>' container reference.
     * @see #getParameterPartition()
     * @generated
     */
    void setParameterPartition(ParameterPartition value);

    /**
     * Returns the value of the '<em><b>Parameter Instance</b></em>' container reference. It is
     * bidirectional and its opposite is '
     * {@link de.fzi.se.quality.parameters.ParameterInstance#getParameterReference
     * <em>Parameter Reference</em>}'. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Parameter Instance</em>' container reference isn't clear, there
     * really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     *
     * @return the value of the '<em>Parameter Instance</em>' container reference.
     * @see #setParameterInstance(ParameterInstance)
     * @see de.fzi.se.quality.parameters.ParametersPackage#getParameterReference_ParameterInstance()
     * @see de.fzi.se.quality.parameters.ParameterInstance#getParameterReference
     * @model opposite="parameterReference" transient="false" ordered="false"
     * @generated
     */
    ParameterInstance getParameterInstance();

    /**
     * Sets the value of the '
     * {@link de.fzi.se.quality.parameters.ParameterReference#getParameterInstance
     * <em>Parameter Instance</em>}' container reference. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     *
     * @param value
     *            the new value of the '<em>Parameter Instance</em>' container reference.
     * @see #getParameterInstance()
     * @generated
     */
    void setParameterInstance(ParameterInstance value);

    /**
     * Returns the value of the '<em><b>Parameter Value Deviation</b></em>' container reference. It
     * is bidirectional and its opposite is '
     * {@link de.fzi.se.quality.qualityannotation.ParameterValueDeviation#getParameterReference
     * <em>Parameter Reference</em>}'. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Parameter Value Deviation</em>' container reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     *
     * @return the value of the '<em>Parameter Value Deviation</em>' container reference.
     * @see #setParameterValueDeviation(ParameterValueDeviation)
     * @see de.fzi.se.quality.parameters.ParametersPackage#getParameterReference_ParameterValueDeviation()
     * @see de.fzi.se.quality.qualityannotation.ParameterValueDeviation#getParameterReference
     * @model opposite="parameterReference" transient="false" ordered="false"
     * @generated
     */
    ParameterValueDeviation getParameterValueDeviation();

    /**
     * Sets the value of the '
     * {@link de.fzi.se.quality.parameters.ParameterReference#getParameterValueDeviation
     * <em>Parameter Value Deviation</em>}' container reference. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @param value
     *            the new value of the '<em>Parameter Value Deviation</em>' container reference.
     * @see #getParameterValueDeviation()
     * @generated
     */
    void setParameterValueDeviation(ParameterValueDeviation value);

} // ParameterReference
