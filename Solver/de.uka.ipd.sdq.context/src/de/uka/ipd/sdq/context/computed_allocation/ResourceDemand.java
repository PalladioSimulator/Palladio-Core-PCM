/**
 * Copyright 2006, SDQ Group, University Karlsruhe (TH)
 *
 * $Id$
 */
package de.uka.ipd.sdq.context.computed_allocation;

import org.eclipse.emf.ecore.EObject;

import de.uka.ipd.sdq.pcm.core.PCMRandomVariable;
import de.uka.ipd.sdq.pcm.seff.seff_performance.ParametricResourceDemand;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Resource Demand</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 * <li>
 * {@link de.uka.ipd.sdq.context.computed_allocation.ResourceDemand#getParametricResourceDemand_ResourceDemand
 * <em>Parametric Resource Demand Resource Demand</em>}</li>
 * <li>
 * {@link de.uka.ipd.sdq.context.computed_allocation.ResourceDemand#getSpecification_ResourceDemand
 * <em>Specification Resource Demand</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.context.computed_allocation.ComputedAllocationPackage#getResourceDemand()
 * @model
 * @generated
 */
public interface ResourceDemand extends EObject {
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    String copyright = "Copyright 2006, SDQ Group, University Karlsruhe (TH)";

    /**
     * Returns the value of the '<em><b>Parametric Resource Demand Resource Demand</b></em>'
     * reference. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Parametric Resource Demand Resource Demand</em>' reference isn't
     * clear, there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Parametric Resource Demand Resource Demand</em>' reference.
     * @see #setParametricResourceDemand_ResourceDemand(ParametricResourceDemand)
     * @see de.uka.ipd.sdq.context.computed_allocation.ComputedAllocationPackage#getResourceDemand_ParametricResourceDemand_ResourceDemand()
     * @model required="true" ordered="false"
     * @generated
     */
    ParametricResourceDemand getParametricResourceDemand_ResourceDemand();

    /**
     * Sets the value of the '
     * {@link de.uka.ipd.sdq.context.computed_allocation.ResourceDemand#getParametricResourceDemand_ResourceDemand
     * <em>Parametric Resource Demand Resource Demand</em>}' reference. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>Parametric Resource Demand Resource Demand</em>'
     *            reference.
     * @see #getParametricResourceDemand_ResourceDemand()
     * @generated
     */
    void setParametricResourceDemand_ResourceDemand(ParametricResourceDemand value);

    /**
     * Returns the value of the '<em><b>Specification Resource Demand</b></em>' containment
     * reference. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Specification Resource Demand</em>' containment reference isn't
     * clear, there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Specification Resource Demand</em>' containment reference.
     * @see #setSpecification_ResourceDemand(PCMRandomVariable)
     * @see de.uka.ipd.sdq.context.computed_allocation.ComputedAllocationPackage#getResourceDemand_Specification_ResourceDemand()
     * @model containment="true" required="true" ordered="false"
     * @generated
     */
    PCMRandomVariable getSpecification_ResourceDemand();

    /**
     * Sets the value of the '
     * {@link de.uka.ipd.sdq.context.computed_allocation.ResourceDemand#getSpecification_ResourceDemand
     * <em>Specification Resource Demand</em>}' containment reference. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>Specification Resource Demand</em>' containment
     *            reference.
     * @see #getSpecification_ResourceDemand()
     * @generated
     */
    void setSpecification_ResourceDemand(PCMRandomVariable value);

} // ResourceDemand
