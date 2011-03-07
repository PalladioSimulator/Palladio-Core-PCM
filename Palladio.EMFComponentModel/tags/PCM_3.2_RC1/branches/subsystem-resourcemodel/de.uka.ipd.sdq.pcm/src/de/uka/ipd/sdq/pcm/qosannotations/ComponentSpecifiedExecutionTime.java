/**
 * Copyright 2007 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.qosannotations;

import de.uka.ipd.sdq.pcm.core.composition.AssemblyContext;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Component Specified Execution Time</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.qosannotations.ComponentSpecifiedExecutionTime#getAssemblyContext_ComponentSpecifiedExecutionTime <em>Assembly Context Component Specified Execution Time</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.pcm.qosannotations.QosannotationsPackage#getComponentSpecifiedExecutionTime()
 * @model
 * @generated
 */
public interface ComponentSpecifiedExecutionTime extends SpecifiedExecutionTime {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright 2007 by SDQ, IPD, University of Karlsruhe, Germany";

	/**
	 * Returns the value of the '<em><b>Assembly Context Component Specified Execution Time</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Assembly Context Component Specified Execution Time</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Assembly Context Component Specified Execution Time</em>' reference.
	 * @see #setAssemblyContext_ComponentSpecifiedExecutionTime(AssemblyContext)
	 * @see de.uka.ipd.sdq.pcm.qosannotations.QosannotationsPackage#getComponentSpecifiedExecutionTime_AssemblyContext_ComponentSpecifiedExecutionTime()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	AssemblyContext getAssemblyContext_ComponentSpecifiedExecutionTime();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.qosannotations.ComponentSpecifiedExecutionTime#getAssemblyContext_ComponentSpecifiedExecutionTime <em>Assembly Context Component Specified Execution Time</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Assembly Context Component Specified Execution Time</em>' reference.
	 * @see #getAssemblyContext_ComponentSpecifiedExecutionTime()
	 * @generated
	 */
	void setAssemblyContext_ComponentSpecifiedExecutionTime(AssemblyContext value);

} // ComponentSpecifiedExecutionTime
