/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.designdecision;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Continuous Processing Rate Degree</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * ProcessingRateDegree represents a degree of freedom to choose the processing speed of a resource.  It refers to a ResourceContainer as changeableEntity, which is the server. Additionally, it refers to a ProcessingResourceType which determines whether the CPU respource or HDD resource is meant to be changed. The speed is assumed to range in a certain interval "from" to "to".
 * 
 * TODO OCL: The changeableEntity must be an ResourceContainer. 
 * <!-- end-model-doc -->
 *
 *
 * @see de.uka.ipd.sdq.pcm.designdecision.designdecisionPackage#getContinuousProcessingRateDegree()
 * @model
 * @generated
 */
public interface ContinuousProcessingRateDegree extends ContinuousRangeDegree, ProcessingRateDegree {
} // ContinuousProcessingRateDegree
