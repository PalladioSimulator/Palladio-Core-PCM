/**
 * Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.seff;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

import de.uka.ipd.sdq.pcm.repository.FailureType;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Failure Handling Entity</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * <p>
 *     Failure handling entities are any program constructs that can handle failures. Instances of failure handling entities
 *     specify any number of failure types that can be handled.
 * </p>
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.seff.FailureHandlingEntity#getFailureTypes <em>Failure Types</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.pcm.seff.SeffPackage#getFailureHandlingEntity()
 * @model abstract="true"
 * @generated
 */
public interface FailureHandlingEntity extends EObject {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany";

	/**
	 * Returns the value of the '<em><b>Failure Types</b></em>' reference list.
	 * The list contents are of type {@link de.uka.ipd.sdq.pcm.repository.FailureType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Failure Types</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Failure Types</em>' reference list.
	 * @see de.uka.ipd.sdq.pcm.seff.SeffPackage#getFailureHandlingEntity_FailureTypes()
	 * @model ordered="false"
	 * @generated
	 */
	EList<FailureType> getFailureTypes();

} // FailureHandlingEntity
