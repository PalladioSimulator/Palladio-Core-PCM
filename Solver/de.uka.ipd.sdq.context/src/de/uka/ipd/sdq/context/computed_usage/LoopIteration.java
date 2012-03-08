/**
 * Copyright 2006, SDQ Group, University Karlsruhe (TH)
 *
 * $Id$
 */
package de.uka.ipd.sdq.context.computed_usage;

import de.uka.ipd.sdq.pcm.core.PCMRandomVariable;
import de.uka.ipd.sdq.pcm.seff.AbstractLoopAction;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Loop Iteration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.context.computed_usage.LoopIteration#getLoopaction_LoopIteration <em>Loopaction Loop Iteration</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.context.computed_usage.LoopIteration#getSpecification_LoopIteration <em>Specification Loop Iteration</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.context.computed_usage.ComputedUsagePackage#getLoopIteration()
 * @model
 * @generated
 */
public interface LoopIteration extends EObject {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright 2006, SDQ Group, University Karlsruhe (TH)";

	/**
	 * Returns the value of the '<em><b>Loopaction Loop Iteration</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Loopaction Loop Iteration</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Loopaction Loop Iteration</em>' reference.
	 * @see #setLoopaction_LoopIteration(AbstractLoopAction)
	 * @see de.uka.ipd.sdq.context.computed_usage.ComputedUsagePackage#getLoopIteration_Loopaction_LoopIteration()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	AbstractLoopAction getLoopaction_LoopIteration();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.context.computed_usage.LoopIteration#getLoopaction_LoopIteration <em>Loopaction Loop Iteration</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Loopaction Loop Iteration</em>' reference.
	 * @see #getLoopaction_LoopIteration()
	 * @generated
	 */
	void setLoopaction_LoopIteration(AbstractLoopAction value);

	/**
	 * Returns the value of the '<em><b>Specification Loop Iteration</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Specification Loop Iteration</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Specification Loop Iteration</em>' containment reference.
	 * @see #setSpecification_LoopIteration(PCMRandomVariable)
	 * @see de.uka.ipd.sdq.context.computed_usage.ComputedUsagePackage#getLoopIteration_Specification_LoopIteration()
	 * @model containment="true" required="true" ordered="false"
	 * @generated
	 */
	PCMRandomVariable getSpecification_LoopIteration();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.context.computed_usage.LoopIteration#getSpecification_LoopIteration <em>Specification Loop Iteration</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Specification Loop Iteration</em>' containment reference.
	 * @see #getSpecification_LoopIteration()
	 * @generated
	 */
	void setSpecification_LoopIteration(PCMRandomVariable value);

} // LoopIteration
