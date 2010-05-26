/**
 * Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.repository;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Stop Failure Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Represents failures with stop semantics. Such failures lead to direct interuption of the current control flow and passing
 * the failure information up the calling hierarchy.
 * <!-- end-model-doc -->
 *
 *
 * @see de.uka.ipd.sdq.pcm.repository.RepositoryPackage#getStopFailureType()
 * @model abstract="true"
 * @generated
 */
public interface StopFailureType extends FailureType {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany";

} // StopFailureType
