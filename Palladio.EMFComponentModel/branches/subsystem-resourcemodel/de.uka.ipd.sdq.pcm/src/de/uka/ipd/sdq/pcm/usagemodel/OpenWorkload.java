/**
 * Copyright 2007 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.usagemodel;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;

import de.uka.ipd.sdq.pcm.core.PCMRandomVariable;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Open Workload</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * OpenWorkload specifies usage intensity with an inter-arrival time (i.e., the time between two
 * user arrivals at the system) as a RandomVariable with an arbitrary probability distribution. It
 * models that an infinite stream of users arrives at a system. The users execute their scenario, and then
 * leave the system. The user population (i.e., the number of users concurrently present in a system) is
 * not fixed in an OpenWorkload.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.usagemodel.OpenWorkload#getInterArrivalTime_OpenWorkload <em>Inter Arrival Time Open Workload</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.pcm.usagemodel.UsagemodelPackage#getOpenWorkload()
 * @model
 * @generated
 */
public interface OpenWorkload extends Workload {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright 2007 by SDQ, IPD, University of Karlsruhe, Germany";

	/**
	 * Returns the value of the '<em><b>Inter Arrival Time Open Workload</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Inter Arrival Time Open Workload</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Inter Arrival Time Open Workload</em>' containment reference.
	 * @see #setInterArrivalTime_OpenWorkload(PCMRandomVariable)
	 * @see de.uka.ipd.sdq.pcm.usagemodel.UsagemodelPackage#getOpenWorkload_InterArrivalTime_OpenWorkload()
	 * @model containment="true" required="true" ordered="false"
	 * @generated
	 */
	PCMRandomVariable getInterArrivalTime_OpenWorkload();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.usagemodel.OpenWorkload#getInterArrivalTime_OpenWorkload <em>Inter Arrival Time Open Workload</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Inter Arrival Time Open Workload</em>' containment reference.
	 * @see #getInterArrivalTime_OpenWorkload()
	 * @generated
	 */
	void setInterArrivalTime_OpenWorkload(PCMRandomVariable value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * not self.interArrivalTime_OpenWorkload.oclIsUndefined() and self.interArrivalTime_OpenWorkload.specification <> ''
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean InterArrivalTimeInOpenWorkloadNeedsToBeSpecified(DiagnosticChain diagnostics, Map<Object, Object> context);

} // OpenWorkload
