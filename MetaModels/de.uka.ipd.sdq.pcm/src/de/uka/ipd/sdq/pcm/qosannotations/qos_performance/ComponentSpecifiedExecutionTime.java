/**
 * Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.qosannotations.qos_performance;

import de.uka.ipd.sdq.pcm.core.composition.AssemblyContext;

/**
 * <!-- begin-user-doc --> A representation of the model object '
 * <em><b>Component Specified Execution Time</b></em>'. <!-- end-user-doc -->
 * 
 * <!-- begin-model-doc --> The ComponentSpecifiedExecutionTime allows software architects (and
 * performance analysts) to specify the response time of a service (signature + role) of a
 * component. However, the response time is not given for the considered component in general, but
 * the component in a specific context (i.e., in a specific hardware environment with specific
 * external components connected) determined by the AssemblyContext. This allows software architects
 * to include Provided- and CompleteComponentTypes into their software architecuture that still miss
 * a description of their internals. Even though the internals are missing, performance predictions
 * are still possible.
 * 
 * 
 * Note: - Is it actually the response time or total service demand specified here? -> I guess it
 * should be response time. Otherwise, we would require also an assignment to resources. - I guess
 * it's necessary to replace the association to the AssemblyContext by an association to an
 * AllocationContext, since the Response time is heavily determined by the underlying hardware...
 * 
 * 
 * <!-- end-model-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>
 * {@link de.uka.ipd.sdq.pcm.qosannotations.qos_performance.ComponentSpecifiedExecutionTime#getAssemblyContext_ComponentSpecifiedExecutionTime
 * <em>Assembly Context Component Specified Execution Time</em>}</li>
 * </ul>
 * </p>
 * 
 * @see de.uka.ipd.sdq.pcm.qosannotations.qos_performance.QosPerformancePackage#getComponentSpecifiedExecutionTime()
 * @model
 * @generated
 */
public interface ComponentSpecifiedExecutionTime extends SpecifiedExecutionTime {
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    String copyright = "Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany";

    /**
     * Returns the value of the '
     * <em><b>Assembly Context Component Specified Execution Time</b></em>' reference. <!--
     * begin-user-doc -->
     * <p>
     * If the meaning of the ' <em>Assembly Context Component Specified Execution Time</em>'
     * reference isn't clear, there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the ' <em>Assembly Context Component Specified Execution Time</em>'
     *         reference.
     * @see #setAssemblyContext_ComponentSpecifiedExecutionTime(AssemblyContext)
     * @see de.uka.ipd.sdq.pcm.qosannotations.qos_performance.QosPerformancePackage#getComponentSpecifiedExecutionTime_AssemblyContext_ComponentSpecifiedExecutionTime()
     * @model required="true" ordered="false"
     * @generated
     */
    AssemblyContext getAssemblyContext_ComponentSpecifiedExecutionTime();

    /**
     * Sets the value of the '
     * {@link de.uka.ipd.sdq.pcm.qosannotations.qos_performance.ComponentSpecifiedExecutionTime#getAssemblyContext_ComponentSpecifiedExecutionTime
     * <em>Assembly Context Component Specified Execution Time</em>}' reference. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     * 
     * @param value
     *            the new value of the '
     *            <em>Assembly Context Component Specified Execution Time</em>' reference.
     * @see #getAssemblyContext_ComponentSpecifiedExecutionTime()
     * @generated
     */
    void setAssemblyContext_ComponentSpecifiedExecutionTime(AssemblyContext value);

} // ComponentSpecifiedExecutionTime
