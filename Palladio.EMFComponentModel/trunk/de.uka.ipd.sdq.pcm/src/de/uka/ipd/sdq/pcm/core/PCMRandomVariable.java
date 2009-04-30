/**
 * Copyright 2007 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.core;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;

import de.uka.ipd.sdq.stoex.RandomVariable;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>PCM Random Variable</b></em>'.
 * A 'PCM Random Variable' is different from 'Random Variables' in the fact
 * that it has to have all characterisations for/of a variable. 
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Random variables are used to describe user and component behaviour. They allow not only constant values (e.g., 3 loop iterations), but also probabilistic values (e.g., 2 loop iterations with a probability of 0.4 and 3 loop iterations with a probability of 0.6). They are well-suited for capturing uncertainty when modelling systems during early development stages. Examples where developers may use random variables are:
 * - Characterisations of Input Parameters: Describes the QoS relevant characteristics of parameters of component services.
 * - Inter-Arrival Time: Describes how much time passes between the arrival of two subsequent users.
 * - Think Time: Describes how much time passes between the execution of a user scenario and the start of the next execution of this scenario.
 * - Loop Iteration Count: Describes the number of repetitions of a loop.
 * - Guarded Branch Transitions: Used to determine whether to conditionally execute a certain behaviour.
 * 
 * PCMRandomVariable extends RandomVariable in a way, that the only type of variables available in the PCMRandomVariable are references to variable characterisations like a.NUMBER_OF_ELEMENTS. The corresponding editors ensure that the user can enter only valid expressions.
 * <!-- end-model-doc -->
 *
 *
 * @see de.uka.ipd.sdq.pcm.core.CorePackage#getPCMRandomVariable()
 * @model
 * @generated
 */
public interface PCMRandomVariable extends RandomVariable {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany";

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * not self.specification.oclIsUndefined() and self.specification <> ''
	 * @param diagnostics The chain of diagnostics to which problems are to be appended.
	 * @param context The cache of context-specific information.
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/uml2/1.1.0/GenModel body='not self.specification.oclIsUndefined() and self.specification <> \'\''"
	 * @generated
	 */
	boolean SpecificationMustNotBeNULL(DiagnosticChain diagnostics, Map<Object, Object> context);

} // PCMRandomVariable
