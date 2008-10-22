/**
 * Copyright 2007 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.subsystem;

import de.uka.ipd.sdq.pcm.core.entity.ComposedProvidingRequiringEntity;
import de.uka.ipd.sdq.pcm.repository.Repository;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Sub System</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.subsystem.SubSystem#getRepository__SubSystem <em>Repository Sub System</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.pcm.subsystem.SubsystemPackage#getSubSystem()
 * @model
 * @generated
 */
public interface SubSystem extends ComposedProvidingRequiringEntity {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright 2007 by SDQ, IPD, University of Karlsruhe, Germany";

	/**
	 * Returns the value of the '<em><b>Repository Sub System</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.uka.ipd.sdq.pcm.repository.Repository#getSubsystems__Repository <em>Subsystems Repository</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Repository Sub System</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Repository Sub System</em>' container reference.
	 * @see #setRepository__SubSystem(Repository)
	 * @see de.uka.ipd.sdq.pcm.subsystem.SubsystemPackage#getSubSystem_Repository__SubSystem()
	 * @see de.uka.ipd.sdq.pcm.repository.Repository#getSubsystems__Repository
	 * @model opposite="subsystems__Repository" required="true" transient="false" ordered="false"
	 * @generated
	 */
	Repository getRepository__SubSystem();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.subsystem.SubSystem#getRepository__SubSystem <em>Repository Sub System</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Repository Sub System</em>' container reference.
	 * @see #getRepository__SubSystem()
	 * @generated
	 */
	void setRepository__SubSystem(Repository value);

} // SubSystem
