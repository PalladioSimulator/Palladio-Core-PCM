/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.designdecision;

import de.uka.ipd.sdq.pcm.resourcetype.ProcessingResourceType;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Processing Rate Degree</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * ProcessingRateDegree represents a degree of freedom to choose the processing speed of a resource.  It refers to a ResourceContainer as changeableEntity, which is the server. Additionally, it refers to a ProcessingResourceType which determines whether the CPU respource or HDD resource is meant to be changed. The speed is assumed to range in a certain interval "from" to "to".
 * 
 * TODO OCL: The changeableEntity must be an ResourceContainer. 
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.designdecision.ProcessingRateDegree#getProcessingresourcetype <em>Processingresourcetype</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.pcm.designdecision.designdecisionPackage#getProcessingRateDegree()
 * @model
 * @generated
 */
public interface ProcessingRateDegree extends ContinuousRangeDegree {

	/**
	 * Returns the value of the '<em><b>Processingresourcetype</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The ProcessingResourceType for which the speed should be adjusted, for example CPU or HDD. 
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Processingresourcetype</em>' reference.
	 * @see #setProcessingresourcetype(ProcessingResourceType)
	 * @see de.uka.ipd.sdq.pcm.designdecision.designdecisionPackage#getProcessingRateDegree_Processingresourcetype()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	ProcessingResourceType getProcessingresourcetype();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.designdecision.ProcessingRateDegree#getProcessingresourcetype <em>Processingresourcetype</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Processingresourcetype</em>' reference.
	 * @see #getProcessingresourcetype()
	 * @generated
	 */
	void setProcessingresourcetype(ProcessingResourceType value);
} // ProcessingRateDegree
