/**
 * Copyright 2007 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.seff.performance;

import de.uka.ipd.sdq.pcm.core.PCMRandomVariable;

import de.uka.ipd.sdq.pcm.repository.ResourceRequiredRole;

import de.uka.ipd.sdq.pcm.seff.AbstractInternalControlFlowAction;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Parametric Resource Demand</b></em>'.
 * <!-- end-user-doc -->
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
	String copyright = "Copyright 2007 by SDQ, IPD, University of Karlsruhe, Germany";

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
	 * @see #setRequiredResource_ParametricResourceDemand(ResourceRequiredRole)
	 * @see de.uka.ipd.sdq.pcm.seff.performance.PerformancePackage#getParametricResourceDemand_RequiredResource_ParametricResourceDemand()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	ResourceRequiredRole getRequiredResource_ParametricResourceDemand();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.seff.performance.ParametricResourceDemand#getRequiredResource_ParametricResourceDemand <em>Required Resource Parametric Resource Demand</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Required Resource Parametric Resource Demand</em>' reference.
	 * @see #getRequiredResource_ParametricResourceDemand()
	 * @generated
	 */
	void setRequiredResource_ParametricResourceDemand(ResourceRequiredRole value);

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
