/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.capra.resources;

import de.uka.ipd.sdq.capra.schedulers.Scheduler;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Processing Resource</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.capra.resources.ProcessingResource#getScheduler <em>Scheduler</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.capra.resources.ResourcesPackage#getProcessingResource()
 * @model
 * @generated
 */
public interface ProcessingResource extends ContentionResource, ActiveResource {
	/**
	 * Returns the value of the '<em><b>Scheduler</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Scheduler</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Scheduler</em>' containment reference.
	 * @see #setScheduler(Scheduler)
	 * @see de.uka.ipd.sdq.capra.resources.ResourcesPackage#getProcessingResource_Scheduler()
	 * @model containment="true" required="true" ordered="false"
	 * @generated
	 */
	Scheduler getScheduler();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.capra.resources.ProcessingResource#getScheduler <em>Scheduler</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Scheduler</em>' containment reference.
	 * @see #getScheduler()
	 * @generated
	 */
	void setScheduler(Scheduler value);

} // ProcessingResource
