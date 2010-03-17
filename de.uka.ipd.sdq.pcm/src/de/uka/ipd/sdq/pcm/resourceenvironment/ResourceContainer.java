/**
 * Copyright 2007 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.resourceenvironment;

import org.eclipse.emf.common.util.EList;

import de.uka.ipd.sdq.pcm.core.entity.Entity;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Resource Container</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.resourceenvironment.ResourceContainer#getActiveResourceSpecifications_ResourceContainer <em>Active Resource Specifications Resource Container</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.resourceenvironment.ResourceContainer#getScheduler <em>Scheduler</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.pcm.resourceenvironment.ResourceenvironmentPackage#getResourceContainer()
 * @model
 * @generated
 */
public interface ResourceContainer extends Entity {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany";

	/**
	 * Returns the value of the '<em><b>Active Resource Specifications Resource Container</b></em>' containment reference list.
	 * The list contents are of type {@link de.uka.ipd.sdq.pcm.resourceenvironment.ProcessingResourceSpecification}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Active Resource Specifications Resource Container</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Active Resource Specifications Resource Container</em>' containment reference list.
	 * @see de.uka.ipd.sdq.pcm.resourceenvironment.ResourceenvironmentPackage#getResourceContainer_ActiveResourceSpecifications_ResourceContainer()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<ProcessingResourceSpecification> getActiveResourceSpecifications_ResourceContainer();

	/**
	 * Returns the value of the '<em><b>Scheduler</b></em>' attribute.
	 * The default value is <code>"ABSTRACT"</code>.
	 * The literals are from the enumeration {@link de.uka.ipd.sdq.pcm.resourceenvironment.ContainerCPUScheduler}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Scheduler</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Scheduler</em>' attribute.
	 * @see de.uka.ipd.sdq.pcm.resourceenvironment.ContainerCPUScheduler
	 * @see #setScheduler(ContainerCPUScheduler)
	 * @see de.uka.ipd.sdq.pcm.resourceenvironment.ResourceenvironmentPackage#getResourceContainer_Scheduler()
	 * @model default="ABSTRACT"
	 * @generated
	 */
	ContainerCPUScheduler getScheduler();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.resourceenvironment.ResourceContainer#getScheduler <em>Scheduler</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Scheduler</em>' attribute.
	 * @see de.uka.ipd.sdq.pcm.resourceenvironment.ContainerCPUScheduler
	 * @see #getScheduler()
	 * @generated
	 */
	void setScheduler(ContainerCPUScheduler value);

} // ResourceContainer
