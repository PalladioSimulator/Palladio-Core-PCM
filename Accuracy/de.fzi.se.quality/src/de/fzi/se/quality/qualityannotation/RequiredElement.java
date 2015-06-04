/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.fzi.se.quality.qualityannotation;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;

import de.uka.ipd.sdq.identifier.Identifier;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Required Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link de.fzi.se.quality.qualityannotation.RequiredElement#getRequiredElementDeviation <em>
 * Required Element Deviation</em>}</li>
 * <li>{@link de.fzi.se.quality.qualityannotation.RequiredElement#getChildREs <em>Child REs</em>}</li>
 * <li>{@link de.fzi.se.quality.qualityannotation.RequiredElement#getParentRE <em>Parent RE</em>}</li>
 * <li>{@link de.fzi.se.quality.qualityannotation.RequiredElement#getPrecision <em>Precision</em>}</li>
 * <li>{@link de.fzi.se.quality.qualityannotation.RequiredElement#getQualityAnnotation <em>Quality
 * Annotation</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.fzi.se.quality.qualityannotation.QualityAnnotationPackage#getRequiredElement()
 * @model abstract="true"
 * @generated
 */
public interface RequiredElement extends Identifier {

    /**
     * Returns the value of the '<em><b>Required Element Deviation</b></em>' container reference. It
     * is bidirectional and its opposite is '
     * {@link de.fzi.se.quality.qualityannotation.RequiredElementDeviation#getRequiredElement
     * <em>Required Element</em>}'. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Required Element Deviation</em>' container reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     *
     * @return the value of the '<em>Required Element Deviation</em>' container reference.
     * @see #setRequiredElementDeviation(RequiredElementDeviation)
     * @see de.fzi.se.quality.qualityannotation.QualityAnnotationPackage#getRequiredElement_RequiredElementDeviation()
     * @see de.fzi.se.quality.qualityannotation.RequiredElementDeviation#getRequiredElement
     * @model opposite="requiredElement" transient="false" ordered="false"
     * @generated
     */
    RequiredElementDeviation getRequiredElementDeviation();

    /**
     * Sets the value of the '
     * {@link de.fzi.se.quality.qualityannotation.RequiredElement#getRequiredElementDeviation
     * <em>Required Element Deviation</em>}' container reference. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @param value
     *            the new value of the '<em>Required Element Deviation</em>' container reference.
     * @see #getRequiredElementDeviation()
     * @generated
     */
    void setRequiredElementDeviation(RequiredElementDeviation value);

    /**
     * Returns the value of the '<em><b>Child REs</b></em>' containment reference list. The list
     * contents are of type {@link de.fzi.se.quality.qualityannotation.RequiredElement}. It is
     * bidirectional and its opposite is '
     * {@link de.fzi.se.quality.qualityannotation.RequiredElement#getParentRE <em>Parent RE</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Child REs</em>' containment reference list isn't clear, there
     * really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     *
     * @return the value of the '<em>Child REs</em>' containment reference list.
     * @see de.fzi.se.quality.qualityannotation.QualityAnnotationPackage#getRequiredElement_ChildREs()
     * @see de.fzi.se.quality.qualityannotation.RequiredElement#getParentRE
     * @model opposite="parentRE" containment="true" ordered="false"
     * @generated
     */
    EList<RequiredElement> getChildREs();

    /**
     * Returns the value of the '<em><b>Parent RE</b></em>' container reference. It is bidirectional
     * and its opposite is '{@link de.fzi.se.quality.qualityannotation.RequiredElement#getChildREs
     * <em>Child REs</em>}'. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Parent RE</em>' container reference isn't clear, there really
     * should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     *
     * @return the value of the '<em>Parent RE</em>' container reference.
     * @see #setParentRE(RequiredElement)
     * @see de.fzi.se.quality.qualityannotation.QualityAnnotationPackage#getRequiredElement_ParentRE()
     * @see de.fzi.se.quality.qualityannotation.RequiredElement#getChildREs
     * @model opposite="childREs" transient="false" ordered="false"
     * @generated
     */
    RequiredElement getParentRE();

    /**
     * Sets the value of the '
     * {@link de.fzi.se.quality.qualityannotation.RequiredElement#getParentRE <em>Parent RE</em>}'
     * container reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @param value
     *            the new value of the '<em>Parent RE</em>' container reference.
     * @see #getParentRE()
     * @generated
     */
    void setParentRE(RequiredElement value);

    /**
     * Returns the value of the '<em><b>Precision</b></em>' containment reference. It is
     * bidirectional and its opposite is '
     * {@link de.fzi.se.quality.qualityannotation.REPrecision#getRequiredElement
     * <em>Required Element</em>}'. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Precision</em>' containment reference isn't clear, there really
     * should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     *
     * @return the value of the '<em>Precision</em>' containment reference.
     * @see #setPrecision(REPrecision)
     * @see de.fzi.se.quality.qualityannotation.QualityAnnotationPackage#getRequiredElement_Precision()
     * @see de.fzi.se.quality.qualityannotation.REPrecision#getRequiredElement
     * @model opposite="requiredElement" containment="true" ordered="false"
     * @generated
     */
    REPrecision getPrecision();

    /**
     * Sets the value of the '
     * {@link de.fzi.se.quality.qualityannotation.RequiredElement#getPrecision <em>Precision</em>}'
     * containment reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @param value
     *            the new value of the '<em>Precision</em>' containment reference.
     * @see #getPrecision()
     * @generated
     */
    void setPrecision(REPrecision value);

    /**
     * Returns the value of the '<em><b>Quality Annotation</b></em>' container reference. It is
     * bidirectional and its opposite is '
     * {@link de.fzi.se.quality.qualityannotation.QualityAnnotation#getStipulatedREPrecisions
     * <em>Stipulated RE Precisions</em>}'. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Quality Annotation</em>' container reference isn't clear, there
     * really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     *
     * @return the value of the '<em>Quality Annotation</em>' container reference.
     * @see #setQualityAnnotation(QualityAnnotation)
     * @see de.fzi.se.quality.qualityannotation.QualityAnnotationPackage#getRequiredElement_QualityAnnotation()
     * @see de.fzi.se.quality.qualityannotation.QualityAnnotation#getStipulatedREPrecisions
     * @model opposite="stipulatedREPrecisions" transient="false" ordered="false"
     * @generated
     */
    QualityAnnotation getQualityAnnotation();

    /**
     * Sets the value of the '
     * {@link de.fzi.se.quality.qualityannotation.RequiredElement#getQualityAnnotation
     * <em>Quality Annotation</em>}' container reference. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     *
     * @param value
     *            the new value of the '<em>Quality Annotation</em>' container reference.
     * @see #getQualityAnnotation()
     * @generated
     */
    void setQualityAnnotation(QualityAnnotation value);

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc --> <!-- begin-model-doc -->
     *
     * @param diagnostics
     *            The chain of diagnostics to which problems are to be appended.
     * @param context
     *            The cache of context-specific information. <!-- end-model-doc -->
     * @model annotation=
     *        "http://www.eclipse.org/uml2/1.1.0/GenModel body='self.qualityAnnotation->size() = self.precision->size()'"
     * @generated
     */
    boolean StipulatedPrecisionMustBeSetInStipulationContext(DiagnosticChain diagnostics, Map<Object, Object> context);

} // RequiredElement
