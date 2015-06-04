/**
 */
package de.fzi.se.quality.qualityannotation;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc --> A representation of the model object '
 * <em><b>Required Element Deviation</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 * <li>
 * {@link de.fzi.se.quality.qualityannotation.RequiredElementDeviation#getInternalStateInfluenceAnalysisAggregation
 * <em>Internal State Influence Analysis Aggregation</em>}</li>
 * <li>
 * {@link de.fzi.se.quality.qualityannotation.RequiredElementDeviation#getMaximumDeviationNumberOfCalls
 * <em>Maximum Deviation Number Of Calls</em>}</li>
 * <li>
 * {@link de.fzi.se.quality.qualityannotation.RequiredElementDeviation#getMaximumDeviationCallParameterValues
 * <em>Maximum Deviation Call Parameter Values</em>}</li>
 * <li>{@link de.fzi.se.quality.qualityannotation.RequiredElementDeviation#getRequiredElement <em>
 * Required Element</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.fzi.se.quality.qualityannotation.QualityAnnotationPackage#getRequiredElementDeviation()
 * @model
 * @generated
 */
public interface RequiredElementDeviation extends EObject {

    /**
     * Returns the value of the '<em><b>Internal State Influence Analysis Aggregation</b></em>'
     * container reference. It is bidirectional and its opposite is '
     * {@link de.fzi.se.quality.qualityannotation.InternalStateInfluenceAnalysisAggregation#getRequiredElementDeviations
     * <em>Required Element Deviations</em>}'. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Internal State Influence Analysis Aggregation</em>' container
     * reference isn't clear, there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     *
     * @return the value of the '<em>Internal State Influence Analysis Aggregation</em>' container
     *         reference.
     * @see #setInternalStateInfluenceAnalysisAggregation(InternalStateInfluenceAnalysisAggregation)
     * @see de.fzi.se.quality.qualityannotation.QualityAnnotationPackage#getRequiredElementDeviation_InternalStateInfluenceAnalysisAggregation()
     * @see de.fzi.se.quality.qualityannotation.InternalStateInfluenceAnalysisAggregation#getRequiredElementDeviations
     * @model opposite="requiredElementDeviations" required="true" transient="false" ordered="false"
     * @generated
     */
    InternalStateInfluenceAnalysisAggregation getInternalStateInfluenceAnalysisAggregation();

    /**
     * Sets the value of the '
     * {@link de.fzi.se.quality.qualityannotation.RequiredElementDeviation#getInternalStateInfluenceAnalysisAggregation
     * <em>Internal State Influence Analysis Aggregation</em>}' container reference. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @param value
     *            the new value of the '<em>Internal State Influence Analysis Aggregation</em>'
     *            container reference.
     * @see #getInternalStateInfluenceAnalysisAggregation()
     * @generated
     */
    void setInternalStateInfluenceAnalysisAggregation(InternalStateInfluenceAnalysisAggregation value);

    /**
     * Returns the value of the '<em><b>Maximum Deviation Number Of Calls</b></em>' reference. <!--
     * begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Maximum Deviation Number Of Calls</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     *
     * @return the value of the '<em>Maximum Deviation Number Of Calls</em>' reference.
     * @see #setMaximumDeviationNumberOfCalls(Precision)
     * @see de.fzi.se.quality.qualityannotation.QualityAnnotationPackage#getRequiredElementDeviation_MaximumDeviationNumberOfCalls()
     * @model required="true" ordered="false"
     * @generated
     */
    Precision getMaximumDeviationNumberOfCalls();

    /**
     * Sets the value of the '
     * {@link de.fzi.se.quality.qualityannotation.RequiredElementDeviation#getMaximumDeviationNumberOfCalls
     * <em>Maximum Deviation Number Of Calls</em>}' reference. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @param value
     *            the new value of the '<em>Maximum Deviation Number Of Calls</em>' reference.
     * @see #getMaximumDeviationNumberOfCalls()
     * @generated
     */
    void setMaximumDeviationNumberOfCalls(Precision value);

    /**
     * Returns the value of the '<em><b>Maximum Deviation Call Parameter Values</b></em>'
     * containment reference list. The list contents are of type
     * {@link de.fzi.se.quality.qualityannotation.ParameterValueDeviation}. It is bidirectional and
     * its opposite is '
     * {@link de.fzi.se.quality.qualityannotation.ParameterValueDeviation#getRequiredElementDeviation
     * <em>Required Element Deviation</em>}'. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Maximum Deviation Call Parameter Values</em>' containment
     * reference list isn't clear, there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     *
     * @return the value of the '<em>Maximum Deviation Call Parameter Values</em>' containment
     *         reference list.
     * @see de.fzi.se.quality.qualityannotation.QualityAnnotationPackage#getRequiredElementDeviation_MaximumDeviationCallParameterValues()
     * @see de.fzi.se.quality.qualityannotation.ParameterValueDeviation#getRequiredElementDeviation
     * @model opposite="requiredElementDeviation" containment="true" ordered="false"
     * @generated
     */
    EList<ParameterValueDeviation> getMaximumDeviationCallParameterValues();

    /**
     * Returns the value of the '<em><b>Required Element</b></em>' containment reference. It is
     * bidirectional and its opposite is '
     * {@link de.fzi.se.quality.qualityannotation.RequiredElement#getRequiredElementDeviation
     * <em>Required Element Deviation</em>}'. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Required Element</em>' containment reference isn't clear, there
     * really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     *
     * @return the value of the '<em>Required Element</em>' containment reference.
     * @see #setRequiredElement(RequiredElement)
     * @see de.fzi.se.quality.qualityannotation.QualityAnnotationPackage#getRequiredElementDeviation_RequiredElement()
     * @see de.fzi.se.quality.qualityannotation.RequiredElement#getRequiredElementDeviation
     * @model opposite="requiredElementDeviation" containment="true" required="true" ordered="false"
     * @generated
     */
    RequiredElement getRequiredElement();

    /**
     * Sets the value of the '
     * {@link de.fzi.se.quality.qualityannotation.RequiredElementDeviation#getRequiredElement
     * <em>Required Element</em>}' containment reference. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     *
     * @param value
     *            the new value of the '<em>Required Element</em>' containment reference.
     * @see #getRequiredElement()
     * @generated
     */
    void setRequiredElement(RequiredElement value);

} // RequiredElementDeviation
