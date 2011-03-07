/**
 * Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.seff;

import java.util.Map;
import org.eclipse.emf.common.util.DiagnosticChain;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Recovery Block Alternative Behaviour</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.seff.RecoveryBlockAlternativeBehaviour#getNextAlternative <em>Next Alternative</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.pcm.seff.SeffPackage#getRecoveryBlockAlternativeBehaviour()
 * @model
 * @generated
 */
public interface RecoveryBlockAlternativeBehaviour extends ResourceDemandingBehaviour, FailureHandlingEntity {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany";

	/**
	 * Returns the value of the '<em><b>Next Alternative</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Next Alternative</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Next Alternative</em>' reference.
	 * @see #setNextAlternative(RecoveryBlockAlternativeBehaviour)
	 * @see de.uka.ipd.sdq.pcm.seff.SeffPackage#getRecoveryBlockAlternativeBehaviour_NextAlternative()
	 * @model ordered="false"
	 * @generated
	 */
	RecoveryBlockAlternativeBehaviour getNextAlternative();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.seff.RecoveryBlockAlternativeBehaviour#getNextAlternative <em>Next Alternative</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Next Alternative</em>' reference.
	 * @see #getNextAlternative()
	 * @generated
	 */
	void setNextAlternative(RecoveryBlockAlternativeBehaviour value);

} // RecoveryBlockAlternativeBehaviour
