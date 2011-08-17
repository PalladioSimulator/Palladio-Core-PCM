/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.designdecision;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Candidates</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Candidates is the root element for specifying a set of solutions of the optimisation (or also any other candidate architecture). It contains one Candidate for each found solution.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.designdecision.Candidates#getCandidate <em>Candidate</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.designdecision.Candidates#getProblem <em>Problem</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.pcm.designdecision.designdecisionPackage#getCandidates()
 * @model
 * @generated
 */
public interface Candidates extends EObject {
	/**
	 * Returns the value of the '<em><b>Candidate</b></em>' containment reference list.
	 * The list contents are of type {@link de.uka.ipd.sdq.pcm.designdecision.Candidate}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Candidate</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Candidate</em>' containment reference list.
	 * @see de.uka.ipd.sdq.pcm.designdecision.designdecisionPackage#getCandidates_Candidate()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<Candidate> getCandidate();

	/**
	 * Returns the value of the '<em><b>Problem</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Problem</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Problem</em>' reference.
	 * @see #setProblem(DecisionSpace)
	 * @see de.uka.ipd.sdq.pcm.designdecision.designdecisionPackage#getCandidates_Problem()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	DecisionSpace getProblem();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.designdecision.Candidates#getProblem <em>Problem</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Problem</em>' reference.
	 * @see #getProblem()
	 * @generated
	 */
	void setProblem(DecisionSpace value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * self.candidate->forAll( c | c.choices->size() = self.problem.designdecision->size())
	 * @param diagnostics The chain of diagnostics to which problems are to be appended.
	 * @param context The cache of context-specific information.
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean numberOfChoicesMustEqualNumberOfDecisions(DiagnosticChain diagnostics, Map<Object, Object> context);

} // Candidates
