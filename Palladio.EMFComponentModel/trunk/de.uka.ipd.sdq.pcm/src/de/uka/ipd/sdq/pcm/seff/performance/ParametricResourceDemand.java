/**
 * Copyright 2007 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.seff.performance;

import org.eclipse.emf.ecore.EObject;

import de.uka.ipd.sdq.pcm.core.PCMRandomVariable;
import de.uka.ipd.sdq.pcm.resourcetype.ProcessingResourceType;
import de.uka.ipd.sdq.pcm.seff.AbstractInternalControlFlowAction;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Parametric Resource Demand</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * TODO (Überarbeitung durch MH)
 * Parametric Resource Demand Specifies the amount of processing requested from a certain type of resource in a parametrised way. It assigns the demand specified as a Random-Variable to an abstract ProcessingResourceType (e.g., CPU, hard disk) instead of a concrete ProcessingResourceSpecification (e.g., 5 Ghz CPU, 20 MByte/s hard disk). This keeps the RDSEFF independent from a specific resource environment, and makes the concrete resources replaceable to answer sizing questions.
 * The demand’s unit is equal for all ProcessingResourceSpecifications referencing
 * the same ProcessingResourceType. It can for example be ”WorkUnits”
 * for CPUs [Smi02] or ”BytesRead” for hard disks. Each ProcessingResource-
 * Specification contains a processing rate for demands (e.g., 1000 WorkUnits/s, 20
 * MB/s), which analysis tools use to compute an actual timing value in seconds. They
 * use this timing value for example as the service demand on a service center in a queueing
 * network or the firing delay of a transition in a Petri net. As multiple component services
 * might request processing on the same resource, these analytical or simulation models
 * allow determining the waiting delay induced by this contention effect.
 * Besides this parameterisation over different resource environments, Parametric-
 * ResourceDemands also parameterise over the usage profile. For this, the stochastic expression
 * specifying the resource demand can contain references to the service’s input
 * parameters or the component parameters. Upon evaluating the resource demand, analysis
 * tools use the current characterisation of the referenced input or component parameter
 * and substitute the reference with this characterisation in the stochastic expression.
 * Solving the stochastic expression, which can be a function involving arithmetic operators
 * (Chapter 3.3.6), then yields a constant or probability function for the resource demand.
 * As an example for solving the parameterisation over resource environment and usage
 * profile, consider an RDSEFF for a service implementing the bubblesort algorithm. It
 * might include a CPU demand specification of n2A?2000WorkUnits derived from complexity
 * theory (n2) and empirical measurements (2000). In this case n refers to the length of
 * the list the algorithm shall sort, which is an input parameter of the service. If the current
 * characterisation of the list’s length is 100 (as the modelled usage profile), analysis tools
 * derive 1002 A? 2000  12000 WorkUnits from the specification, thus resolving the usage
 * profile dependency. If the CPU ProcessingResourceSpecification the service’s
 * 126
 * 4.3. Resource Demanding Service Effect Specification
 * component is allocated on then contains a processing rate of 10000WorkUnits/s, analysis
 * tools derive an execution time of 12000 WorkUnits {10000 WorkUnits/s = 1:2 s from the
 * specification, thus resolving the resource environment dependency.
 * The stochastic expression for a ParametricResourceDemand depends on the implementation
 * of the service. Component developers can specify it using complexity theory,
 * estimations, or measurements. However, how to get data to define such expressions
 * accurately is beyond of the scope of this thesis. Woodside et al. [WVCB01] and Krogmann
 * [Kro07] present approaches for measuring resource demands in dependency to input parameters.
 * Meyerhoefer et al. [ML05] and Kuperberg et al. [KB07] propose methods to
 * establish resource demands independent from concrete resources. For the scope of this
 * thesis, it is assumed that these methods have been applied and an accurate specification
 * of the ParametricResourceDemand is available.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.seff.performance.ParametricResourceDemand#getSpecification_ParametericResourceDemand <em>Specification Parameteric Resource Demand</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.seff.performance.ParametricResourceDemand#getRequiredResource_ParametricResourceDemand <em>Required Resource Parametric Resource Demand</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.seff.performance.ParametricResourceDemand#getAction_ParametricResourceDemand <em>Action Parametric Resource Demand</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.pcm.seff.performance.PerformancePackage#getParametricResourceDemand()
 * @model
 * @generated
 */
public interface ParametricResourceDemand extends EObject {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany";

	/**
	 * Returns the value of the '<em><b>Specification Parameteric Resource Demand</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Specification Parameteric Resource Demand</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Specification Parameteric Resource Demand</em>' containment reference.
	 * @see #setSpecification_ParametericResourceDemand(PCMRandomVariable)
	 * @see de.uka.ipd.sdq.pcm.seff.performance.PerformancePackage#getParametricResourceDemand_Specification_ParametericResourceDemand()
	 * @model containment="true" required="true" ordered="false"
	 * @generated
	 */
	PCMRandomVariable getSpecification_ParametericResourceDemand();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.seff.performance.ParametricResourceDemand#getSpecification_ParametericResourceDemand <em>Specification Parameteric Resource Demand</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Specification Parameteric Resource Demand</em>' containment reference.
	 * @see #getSpecification_ParametericResourceDemand()
	 * @generated
	 */
	void setSpecification_ParametericResourceDemand(PCMRandomVariable value);

	/**
	 * Returns the value of the '<em><b>Required Resource Parametric Resource Demand</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Required Resource Parametric Resource Demand</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Required Resource Parametric Resource Demand</em>' reference.
	 * @see #setRequiredResource_ParametricResourceDemand(ProcessingResourceType)
	 * @see de.uka.ipd.sdq.pcm.seff.performance.PerformancePackage#getParametricResourceDemand_RequiredResource_ParametricResourceDemand()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	ProcessingResourceType getRequiredResource_ParametricResourceDemand();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.seff.performance.ParametricResourceDemand#getRequiredResource_ParametricResourceDemand <em>Required Resource Parametric Resource Demand</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Required Resource Parametric Resource Demand</em>' reference.
	 * @see #getRequiredResource_ParametricResourceDemand()
	 * @generated
	 */
	void setRequiredResource_ParametricResourceDemand(ProcessingResourceType value);

	/**
	 * Returns the value of the '<em><b>Action Parametric Resource Demand</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.uka.ipd.sdq.pcm.seff.AbstractInternalControlFlowAction#getResourceDemand_Action <em>Resource Demand Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Action Parametric Resource Demand</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Action Parametric Resource Demand</em>' container reference.
	 * @see #setAction_ParametricResourceDemand(AbstractInternalControlFlowAction)
	 * @see de.uka.ipd.sdq.pcm.seff.performance.PerformancePackage#getParametricResourceDemand_Action_ParametricResourceDemand()
	 * @see de.uka.ipd.sdq.pcm.seff.AbstractInternalControlFlowAction#getResourceDemand_Action
	 * @model opposite="resourceDemand_Action" required="true" transient="false" ordered="false"
	 * @generated
	 */
	AbstractInternalControlFlowAction getAction_ParametricResourceDemand();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.seff.performance.ParametricResourceDemand#getAction_ParametricResourceDemand <em>Action Parametric Resource Demand</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Action Parametric Resource Demand</em>' container reference.
	 * @see #getAction_ParametricResourceDemand()
	 * @generated
	 */
	void setAction_ParametricResourceDemand(AbstractInternalControlFlowAction value);

} // ParametricResourceDemand
