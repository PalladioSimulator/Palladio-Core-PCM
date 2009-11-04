/**
 * Copyright 2007 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.repository;

import de.uka.ipd.sdq.pcm.core.PCMRandomVariable;
import de.uka.ipd.sdq.pcm.core.entity.Entity;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Passive Resource</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * This entity represents a passive resource, e.g., a semaphore.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.repository.PassiveResource#getCapacity_PassiveResource <em>Capacity Passive Resource</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.pcm.repository.RepositoryPackage#getPassiveResource()
 * @model
 * @generated
 */
public interface PassiveResource extends Entity {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright 2005-2009 by SDQ, IPD, Karlsruhe Institute of Technology / University of Karlsruhe, Germany and SE, FZI Karlsruhe, Germany";

	/**
	 * Returns the value of the '<em><b>Capacity Passive Resource</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Capacity Passive Resource</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * This property holds the capacity of this passive resource.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Capacity Passive Resource</em>' containment reference.
	 * @see #setCapacity_PassiveResource(PCMRandomVariable)
	 * @see de.uka.ipd.sdq.pcm.repository.RepositoryPackage#getPassiveResource_Capacity_PassiveResource()
	 * @model containment="true" required="true" ordered="false"
	 * @generated
	 */
	PCMRandomVariable getCapacity_PassiveResource();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.repository.PassiveResource#getCapacity_PassiveResource <em>Capacity Passive Resource</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Capacity Passive Resource</em>' containment reference.
	 * @see #getCapacity_PassiveResource()
	 * @generated
	 */
	void setCapacity_PassiveResource(PCMRandomVariable value);

} // PassiveResource
