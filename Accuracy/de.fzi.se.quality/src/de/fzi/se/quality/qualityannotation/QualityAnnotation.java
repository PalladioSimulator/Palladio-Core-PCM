/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.fzi.se.quality.qualityannotation;

import org.eclipse.emf.common.util.EList;

import de.fzi.se.quality.QualityStatement;
import de.fzi.se.quality.parameters.ParameterPartition;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Quality Annotation</b></em>
 * '. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link de.fzi.se.quality.qualityannotation.QualityAnnotation#isValid <em>Is Valid</em>}</li>
 * <li>{@link de.fzi.se.quality.qualityannotation.QualityAnnotation#getForServiceSpecification <em>
 * For Service Specification</em>}</li>
 * <li>{@link de.fzi.se.quality.qualityannotation.QualityAnnotation#getStipulatedREPrecisions <em>
 * Stipulated RE Precisions</em>}</li>
 * <li>
 * {@link de.fzi.se.quality.qualityannotation.QualityAnnotation#getInternalStateInfluenceAnalysisResults
 * <em>Internal State Influence Analysis Results</em>}</li>
 * <li>{@link de.fzi.se.quality.qualityannotation.QualityAnnotation#getProbabilisticElements <em>
 * Probabilistic Elements</em>}</li>
 * <li>{@link de.fzi.se.quality.qualityannotation.QualityAnnotation#getValidForParameterPartitions
 * <em>Valid For Parameter Partitions</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.fzi.se.quality.qualityannotation.QualityAnnotationPackage#getQualityAnnotation()
 * @model
 * @generated
 */
public interface QualityAnnotation extends QualityStatement {

    /**
     * Returns the value of the '<em><b>Is Valid</b></em>' attribute. The default value is
     * <code>"false"</code>. <!-- begin-user-doc --> <!-- end-user-doc --> <!-- begin-model-doc -->
     * Checksum over the performance-relevant information within a RDSEFF. Used to check if the
     * quality annotations are valid for the referenced SEFF (or not). <!-- end-model-doc -->
     *
     * @return the value of the '<em>Is Valid</em>' attribute.
     * @see #setIsValid(boolean)
     * @see de.fzi.se.quality.qualityannotation.QualityAnnotationPackage#getQualityAnnotation_IsValid()
     * @model default="false" required="true" ordered="false"
     * @generated
     */
    boolean isValid();

    /**
     * Sets the value of the '{@link de.fzi.se.quality.qualityannotation.QualityAnnotation#isValid
     * <em>Is Valid</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @param value
     *            the new value of the '<em>Is Valid</em>' attribute.
     * @see #isValid()
     * @generated
     */
    void setIsValid(boolean value);

    /**
     * Returns the value of the '<em><b>For Service Specification</b></em>' containment reference.
     * It is bidirectional and its opposite is '
     * {@link de.fzi.se.quality.qualityannotation.ServiceSpecification#getQualityAnnotation
     * <em>Quality Annotation</em>}'. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>For Service Specification</em>' containment reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     *
     * @return the value of the '<em>For Service Specification</em>' containment reference.
     * @see #setForServiceSpecification(ServiceSpecification)
     * @see de.fzi.se.quality.qualityannotation.QualityAnnotationPackage#getQualityAnnotation_ForServiceSpecification()
     * @see de.fzi.se.quality.qualityannotation.ServiceSpecification#getQualityAnnotation
     * @model opposite="qualityAnnotation" containment="true" required="true" ordered="false"
     * @generated
     */
    ServiceSpecification getForServiceSpecification();

    /**
     * Sets the value of the '
     * {@link de.fzi.se.quality.qualityannotation.QualityAnnotation#getForServiceSpecification
     * <em>For Service Specification</em>}' containment reference. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @param value
     *            the new value of the '<em>For Service Specification</em>' containment reference.
     * @see #getForServiceSpecification()
     * @generated
     */
    void setForServiceSpecification(ServiceSpecification value);

    /**
     * Returns the value of the '<em><b>Stipulated RE Precisions</b></em>' containment reference
     * list. The list contents are of type
     * {@link de.fzi.se.quality.qualityannotation.RequiredElement}. It is bidirectional and its
     * opposite is '{@link de.fzi.se.quality.qualityannotation.RequiredElement#getQualityAnnotation
     * <em>Quality Annotation</em>}'. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Stipulated RE Precisions</em>' containment reference list isn't
     * clear, there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     *
     * @return the value of the '<em>Stipulated RE Precisions</em>' containment reference list.
     * @see de.fzi.se.quality.qualityannotation.QualityAnnotationPackage#getQualityAnnotation_StipulatedREPrecisions()
     * @see de.fzi.se.quality.qualityannotation.RequiredElement#getQualityAnnotation
     * @model opposite="qualityAnnotation" containment="true" ordered="false"
     * @generated
     */
    EList<RequiredElement> getStipulatedREPrecisions();

    /**
     * Returns the value of the '<em><b>Internal State Influence Analysis Results</b></em>'
     * containment reference list. The list contents are of type
     * {@link de.fzi.se.quality.qualityannotation.InternalStateInfluenceAnalysisAggregation}. It is
     * bidirectional and its opposite is '
     * {@link de.fzi.se.quality.qualityannotation.InternalStateInfluenceAnalysisAggregation#getQualityAnnotation
     * <em>Quality Annotation</em>}'. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Internal State Influence Analysis Results</em>' containment
     * reference list isn't clear, there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     *
     * @return the value of the '<em>Internal State Influence Analysis Results</em>' containment
     *         reference list.
     * @see de.fzi.se.quality.qualityannotation.QualityAnnotationPackage#getQualityAnnotation_InternalStateInfluenceAnalysisResults()
     * @see de.fzi.se.quality.qualityannotation.InternalStateInfluenceAnalysisAggregation#getQualityAnnotation
     * @model opposite="qualityAnnotation" containment="true" ordered="false"
     * @generated
     */
    EList<InternalStateInfluenceAnalysisAggregation> getInternalStateInfluenceAnalysisResults();

    /**
     * Returns the value of the '<em><b>Probabilistic Elements</b></em>' containment reference list.
     * The list contents are of type
     * {@link de.fzi.se.quality.qualityannotation.ProbabilisticElement}. It is bidirectional and its
     * opposite is '
     * {@link de.fzi.se.quality.qualityannotation.ProbabilisticElement#getQualityAnnotation
     * <em>Quality Annotation</em>}'. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Probabilistic Elements</em>' containment reference list isn't
     * clear, there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     *
     * @return the value of the '<em>Probabilistic Elements</em>' containment reference list.
     * @see de.fzi.se.quality.qualityannotation.QualityAnnotationPackage#getQualityAnnotation_ProbabilisticElements()
     * @see de.fzi.se.quality.qualityannotation.ProbabilisticElement#getQualityAnnotation
     * @model opposite="qualityAnnotation" containment="true" ordered="false"
     * @generated
     */
    EList<ProbabilisticElement> getProbabilisticElements();

    /**
     * Returns the value of the '<em><b>Valid For Parameter Partitions</b></em>' containment
     * reference list. The list contents are of type
     * {@link de.fzi.se.quality.parameters.ParameterPartition}. It is bidirectional and its opposite
     * is '{@link de.fzi.se.quality.parameters.ParameterPartition#getQualityAnnotation
     * <em>Quality Annotation</em>}'. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Valid For Parameter Partitions</em>' containment reference list
     * isn't clear, there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     *
     * @return the value of the '<em>Valid For Parameter Partitions</em>' containment reference
     *         list.
     * @see de.fzi.se.quality.qualityannotation.QualityAnnotationPackage#getQualityAnnotation_ValidForParameterPartitions()
     * @see de.fzi.se.quality.parameters.ParameterPartition#getQualityAnnotation
     * @model opposite="qualityAnnotation" containment="true" ordered="false"
     * @generated
     */
    EList<ParameterPartition> getValidForParameterPartitions();

} // QualityAnnotation
