/**
 * Copyright 2007 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.resourceenvironment;

import org.eclipse.emf.ecore.EObject;

import de.uka.ipd.sdq.pcm.core.PCMRandomVariable;
import de.uka.ipd.sdq.pcm.resourcetype.ProcessingResourceType;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Processing Resource Specification</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.resourceenvironment.ProcessingResourceSpecification#getSchedulingPolicy <em>Scheduling Policy</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.resourceenvironment.ProcessingResourceSpecification#getActiveResourceType_ActiveResourceSpecification <em>Active Resource Type Active Resource Specification</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.resourceenvironment.ProcessingResourceSpecification#getProcessingRate_ProcessingResourceSpecification <em>Processing Rate Processing Resource Specification</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.pcm.resourceenvironment.ResourceenvironmentPackage#getProcessingResourceSpecification()
 * @model
 * @generated
 */
public interface ProcessingResourceSpecification extends EObject {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright 2007 by SDQ, IPD, University of Karlsruhe, Germany";

	/**
	 * Returns the value of the '<em><b>Scheduling Policy</b></em>' attribute.
	 * The literals are from the enumeration {@link de.uka.ipd.sdq.pcm.resourceenvironment.SchedulingPolicy}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Scheduling Policy</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Scheduling Policy</em>' attribute.
	 * @see de.uka.ipd.sdq.pcm.resourceenvironment.SchedulingPolicy
	 * @see #setSchedulingPolicy(SchedulingPolicy)
	 * @see de.uka.ipd.sdq.pcm.resourceenvironment.ResourceenvironmentPackage#getProcessingResourceSpecification_SchedulingPolicy()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	SchedulingPolicy getSchedulingPolicy();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.resourceenvironment.ProcessingResourceSpecification#getSchedulingPolicy <em>Scheduling Policy</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Scheduling Policy</em>' attribute.
	 * @see de.uka.ipd.sdq.pcm.resourceenvironment.SchedulingPolicy
	 * @see #getSchedulingPolicy()
	 * @generated
	 */
	void setSchedulingPolicy(SchedulingPolicy value);

	/**
	 * Returns the value of the '<em><b>Active Resource Type Active Resource Specification</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Active Resource Type Active Resource Specification</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Active Resource Type Active Resource Specification</em>' reference.
	 * @see #setActiveResourceType_ActiveResourceSpecification(ProcessingResourceType)
	 * @see de.uka.ipd.sdq.pcm.resourceenvironment.ResourceenvironmentPackage#getProcessingResourceSpecification_ActiveResourceType_ActiveResourceSpecification()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	ProcessingResourceType getActiveResourceType_ActiveResourceSpecification();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.resourceenvironment.ProcessingResourceSpecification#getActiveResourceType_ActiveResourceSpecification <em>Active Resource Type Active Resource Specification</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Active Resource Type Active Resource Specification</em>' reference.
	 * @see #getActiveResourceType_ActiveResourceSpecification()
	 * @generated
	 */
	void setActiveResourceType_ActiveResourceSpecification(ProcessingResourceType value);

	/**
	 * Returns the value of the '<em><b>Processing Rate Processing Resource Specification</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Processing Rate Processing Resource Specification</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Processing Rate Processing Resource Specification</em>' containment reference.
	 * @see #setProcessingRate_ProcessingResourceSpecification(PCMRandomVariable)
	 * @see de.uka.ipd.sdq.pcm.resourceenvironment.ResourceenvironmentPackage#getProcessingResourceSpecification_ProcessingRate_ProcessingResourceSpecification()
	 * @model containment="true" required="true" ordered="false"
	 * @generated
	 */
	PCMRandomVariable getProcessingRate_ProcessingResourceSpecification();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.resourceenvironment.ProcessingResourceSpecification#getProcessingRate_ProcessingResourceSpecification <em>Processing Rate Processing Resource Specification</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Processing Rate Processing Resource Specification</em>' containment reference.
	 * @see #getProcessingRate_ProcessingResourceSpecification()
	 * @generated
	 */
	void setProcessingRate_ProcessingResourceSpecification(PCMRandomVariable value);

} // ProcessingResourceSpecification
