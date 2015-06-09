/**
 * Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.qosannotations.qos_performance;

import de.uka.ipd.sdq.pcm.core.PCMRandomVariable;
import de.uka.ipd.sdq.pcm.qosannotations.SpecifiedQoSAnnotation;

/**
 * <!-- begin-user-doc --> A representation of the model object '
 * <em><b>Specified Execution Time</b></em>'. <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * <p>
 * Specifies an execution time
 * in&nbsp;terms&nbsp;of&nbsp;a&nbsp;PCMRandomVariable&nbsp;which&nbsp;may
 * &nbsp;depend&nbsp;on&nbsp;component&nbsp;or&nbsp;input&nbsp;parameters&nbsp;of&nbsp;the
 * referenced&nbsp;service.
 * </p>
 * <p>
 * Notes:
 * </p>
 * <p>
 * -&nbsp;Is&nbsp;it&nbsp;correct&nbsp;that&nbsp;the&nbsp;PCMRandomvariable&nbsp;can&nbsp;depend&
 * nbsp;on&nbsp;parameters?<br />
 * -&nbsp;How&nbsp;is&nbsp;the&nbsp;relation&nbsp;of&nbsp;the&nbsp;specified&nbsp;QoS&nbsp;to&nbsp;
 * the&nbsp;input&nbsp;parameters&nbsp;established?<br />
 * </p>
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 * <li>
 * {@link de.uka.ipd.sdq.pcm.qosannotations.qos_performance.SpecifiedExecutionTime#getSpecification_SpecifiedExecutionTime
 * <em>Specification Specified Execution Time</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.pcm.qosannotations.qos_performance.QosPerformancePackage#getSpecifiedExecutionTime()
 * @model abstract="true"
 * @generated
 */
public interface SpecifiedExecutionTime extends SpecifiedQoSAnnotation {

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    String copyright = "Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany";

    /**
     * Returns the value of the '<em><b>Specification Specified Execution Time</b></em>' containment
     * reference. It is bidirectional and its opposite is '
     * {@link de.uka.ipd.sdq.pcm.core.PCMRandomVariable#getSpecifiedExecutionTime_PCMRandomVariable
     * <em>Specified Execution Time PCM Random Variable</em>}'. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Specification Specified Execution Time</em>' containment reference
     * isn't clear, there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Specification Specified Execution Time</em>' containment
     *         reference.
     * @see #setSpecification_SpecifiedExecutionTime(PCMRandomVariable)
     * @see de.uka.ipd.sdq.pcm.qosannotations.qos_performance.QosPerformancePackage#getSpecifiedExecutionTime_Specification_SpecifiedExecutionTime()
     * @see de.uka.ipd.sdq.pcm.core.PCMRandomVariable#getSpecifiedExecutionTime_PCMRandomVariable
     * @model opposite="specifiedExecutionTime_PCMRandomVariable" containment="true" required="true"
     *        ordered="false"
     * @generated
     */
    PCMRandomVariable getSpecification_SpecifiedExecutionTime();

    /**
     * Sets the value of the '
     * {@link de.uka.ipd.sdq.pcm.qosannotations.qos_performance.SpecifiedExecutionTime#getSpecification_SpecifiedExecutionTime
     * <em>Specification Specified Execution Time</em>}' containment reference. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>Specification Specified Execution Time</em>' containment
     *            reference.
     * @see #getSpecification_SpecifiedExecutionTime()
     * @generated
     */
    void setSpecification_SpecifiedExecutionTime(PCMRandomVariable value);

} // SpecifiedExecutionTime
