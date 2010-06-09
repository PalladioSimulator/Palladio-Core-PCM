/**
 * Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.seff;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Internal Action</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Internal Action Combines the execution of a number of internal computations by a component service in a single model entity. It models calculations inside a component service, which do not include calls to required services. For a desired high abstraction level, an RDSEFF has only one InternalAction for all instructions between two calls to required services. A high abstraction level is needed to keep the model tractable for mathematical analysis methods. However, in principle it is also possible to use multiple InternalActions in direct succession to model on a lower abstraction level and enable more accurate predictions.
 * InternalActions provide an abstraction from the complete behaviour (i.e., control and data flow) of a component service, as they can hide different possible control and data flows not affecting external service calls and express their resource demands as a single stochastic expression. This abstraction underlies the assumption that the resource demands of a number of instruction can be captured sufficiently accurate enough in one such expression
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.seff.InternalAction#getFailureOccurrenceDescriptions <em>Failure Occurrence Descriptions</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.pcm.seff.SeffPackage#getInternalAction()
 * @model
 * @generated
 */
public interface InternalAction extends AbstractInternalControlFlowAction {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany";

	/**
	 * Returns the value of the '<em><b>Failure Occurrence Descriptions</b></em>' containment reference list.
	 * The list contents are of type {@link de.uka.ipd.sdq.pcm.seff.FailureOccurrenceDescription}.
	 * It is bidirectional and its opposite is '{@link de.uka.ipd.sdq.pcm.seff.FailureOccurrenceDescription#getFailureOccurenceDescriptions <em>Failure Occurence Descriptions</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Failure Occurrence Descriptions</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Failure Occurrence Descriptions</em>' containment reference list.
	 * @see de.uka.ipd.sdq.pcm.seff.SeffPackage#getInternalAction_FailureOccurrenceDescriptions()
	 * @see de.uka.ipd.sdq.pcm.seff.FailureOccurrenceDescription#getFailureOccurenceDescriptions
	 * @model opposite="failureOccurenceDescriptions" containment="true" ordered="false"
	 * @generated
	 */
	EList<FailureOccurrenceDescription> getFailureOccurrenceDescriptions();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * self.failureOccurrenceDescriptions->forAll(x : FailureOccurrenceDescription,y:FailureOccurrenceDescription  | x<>y implies x.failureType <> y.failureType )
	 * @param diagnostics The chain of diagnostics to which problems are to be appended.
	 * @param context The cache of context-specific information.
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/uml2/1.1.0/GenModel body='self.failureOccurrenceDescriptions->forAll(x : FailureOccurrenceDescription,y:FailureOccurrenceDescription  | x<>y implies x.failureType <> y.failureType )'"
	 * @generated
	 */
	boolean Multipleusagesofsamefailuretypearenotallowed(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * self.failureOccurrenceDescriptions.failureProbability.oclAsType(Real)->sum()<=1
	 * @param diagnostics The chain of diagnostics to which problems are to be appended.
	 * @param context The cache of context-specific information.
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/uml2/1.1.0/GenModel body='self.failureOccurrenceDescriptions.failureProbability.oclAsType(Real)->sum()<=1'"
	 * @generated
	 */
	boolean Sumoffailureoccurrenceprobabilitiesmustnotexceed10(DiagnosticChain diagnostics, Map<Object, Object> context);

} // InternalAction
