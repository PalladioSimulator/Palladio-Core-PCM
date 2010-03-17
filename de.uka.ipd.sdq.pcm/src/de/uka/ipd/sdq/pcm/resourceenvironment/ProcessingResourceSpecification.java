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
 *   <li>{@link de.uka.ipd.sdq.pcm.resourceenvironment.ProcessingResourceSpecification#getMTTR <em>MTTR</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.resourceenvironment.ProcessingResourceSpecification#getMTTF <em>MTTF</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.resourceenvironment.ProcessingResourceSpecification#getSchedulingPolicy <em>Scheduling Policy</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.resourceenvironment.ProcessingResourceSpecification#getActiveResourceType_ActiveResourceSpecification <em>Active Resource Type Active Resource Specification</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.resourceenvironment.ProcessingResourceSpecification#getProcessingRate_ProcessingResourceSpecification <em>Processing Rate Processing Resource Specification</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.resourceenvironment.ProcessingResourceSpecification#getNoOfReplicas <em>No Of Replicas</em>}</li>
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
	String copyright = "Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany";

	/**
	 * Returns the value of the '<em><b>MTTR</b></em>' attribute.
	 * The default value is <code>"0.0"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The Mean Time To Repair (MTTR) of a physical resource is the expected timespan from breakdown of this physical resource to its repair or replacement.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>MTTR</em>' attribute.
	 * @see #setMTTR(double)
	 * @see de.uka.ipd.sdq.pcm.resourceenvironment.ResourceenvironmentPackage#getProcessingResourceSpecification_MTTR()
	 * @model default="0.0" required="true" ordered="false"
	 * @generated
	 */
	double getMTTR();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.resourceenvironment.ProcessingResourceSpecification#getMTTR <em>MTTR</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>MTTR</em>' attribute.
	 * @see #getMTTR()
	 * @generated
	 */
	void setMTTR(double value);

	/**
	 * Returns the value of the '<em><b>MTTF</b></em>' attribute.
	 * The default value is <code>"0.0"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The Mean Time To Failure (MTTF) of a physical resource is the expected timespan from the start of its usage until breakdown.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>MTTF</em>' attribute.
	 * @see #setMTTF(double)
	 * @see de.uka.ipd.sdq.pcm.resourceenvironment.ResourceenvironmentPackage#getProcessingResourceSpecification_MTTF()
	 * @model default="0.0" required="true" ordered="false"
	 * @generated
	 */
	double getMTTF();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.resourceenvironment.ProcessingResourceSpecification#getMTTF <em>MTTF</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>MTTF</em>' attribute.
	 * @see #getMTTF()
	 * @generated
	 */
	void setMTTF(double value);

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

	/**
	 * Returns the value of the '<em><b>No Of Replicas</b></em>' attribute.
	 * The default value is <code>"1"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>No Of Replicas</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>No Of Replicas</em>' attribute.
	 * @see #setNoOfReplicas(int)
	 * @see de.uka.ipd.sdq.pcm.resourceenvironment.ResourceenvironmentPackage#getProcessingResourceSpecification_NoOfReplicas()
	 * @model default="1"
	 * @generated
	 */
	int getNoOfReplicas();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.resourceenvironment.ProcessingResourceSpecification#getNoOfReplicas <em>No Of Replicas</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>No Of Replicas</em>' attribute.
	 * @see #getNoOfReplicas()
	 * @generated
	 */
	void setNoOfReplicas(int value);

} // ProcessingResourceSpecification
