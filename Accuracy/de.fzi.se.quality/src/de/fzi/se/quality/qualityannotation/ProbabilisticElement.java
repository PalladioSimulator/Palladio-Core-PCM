/**
 */
package de.fzi.se.quality.qualityannotation;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc --> A representation of the model object '
 * <em><b>Probabilistic Element</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link de.fzi.se.quality.qualityannotation.ProbabilisticElement#getPrecision <em>Precision
 * </em>}</li>
 * <li>{@link de.fzi.se.quality.qualityannotation.ProbabilisticElement#getChildPEs <em>Child PEs
 * </em>}</li>
 * <li>{@link de.fzi.se.quality.qualityannotation.ProbabilisticElement#getParentPE <em>Parent PE
 * </em>}</li>
 * <li>{@link de.fzi.se.quality.qualityannotation.ProbabilisticElement#getQualityAnnotation <em>
 * Quality Annotation</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.fzi.se.quality.qualityannotation.QualityAnnotationPackage#getProbabilisticElement()
 * @model abstract="true"
 * @generated
 */
public interface ProbabilisticElement extends EObject {

    /**
     * Returns the value of the '<em><b>Precision</b></em>' containment reference. <!--
     * begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Precision</em>' containment reference isn't clear, there really
     * should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     *
     * @return the value of the '<em>Precision</em>' containment reference.
     * @see #setPrecision(Precision)
     * @see de.fzi.se.quality.qualityannotation.QualityAnnotationPackage#getProbabilisticElement_Precision()
     * @model containment="true" required="true" ordered="false"
     * @generated
     */
    Precision getPrecision();

    /**
     * Sets the value of the '
     * {@link de.fzi.se.quality.qualityannotation.ProbabilisticElement#getPrecision
     * <em>Precision</em>}' containment reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @param value
     *            the new value of the '<em>Precision</em>' containment reference.
     * @see #getPrecision()
     * @generated
     */
    void setPrecision(Precision value);

    /**
     * Returns the value of the '<em><b>Child PEs</b></em>' containment reference list. The list
     * contents are of type {@link de.fzi.se.quality.qualityannotation.ProbabilisticElement}. It is
     * bidirectional and its opposite is '
     * {@link de.fzi.se.quality.qualityannotation.ProbabilisticElement#getParentPE
     * <em>Parent PE</em>}'. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Child PEs</em>' containment reference list isn't clear, there
     * really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     *
     * @return the value of the '<em>Child PEs</em>' containment reference list.
     * @see de.fzi.se.quality.qualityannotation.QualityAnnotationPackage#getProbabilisticElement_ChildPEs()
     * @see de.fzi.se.quality.qualityannotation.ProbabilisticElement#getParentPE
     * @model opposite="parentPE" containment="true" ordered="false"
     * @generated
     */
    EList<ProbabilisticElement> getChildPEs();

    /**
     * Returns the value of the '<em><b>Parent PE</b></em>' container reference. It is bidirectional
     * and its opposite is '
     * {@link de.fzi.se.quality.qualityannotation.ProbabilisticElement#getChildPEs
     * <em>Child PEs</em>}'. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Parent PE</em>' container reference isn't clear, there really
     * should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     *
     * @return the value of the '<em>Parent PE</em>' container reference.
     * @see #setParentPE(ProbabilisticElement)
     * @see de.fzi.se.quality.qualityannotation.QualityAnnotationPackage#getProbabilisticElement_ParentPE()
     * @see de.fzi.se.quality.qualityannotation.ProbabilisticElement#getChildPEs
     * @model opposite="childPEs" transient="false" ordered="false"
     * @generated
     */
    ProbabilisticElement getParentPE();

    /**
     * Sets the value of the '
     * {@link de.fzi.se.quality.qualityannotation.ProbabilisticElement#getParentPE
     * <em>Parent PE</em>}' container reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @param value
     *            the new value of the '<em>Parent PE</em>' container reference.
     * @see #getParentPE()
     * @generated
     */
    void setParentPE(ProbabilisticElement value);

    /**
     * Returns the value of the '<em><b>Quality Annotation</b></em>' container reference. It is
     * bidirectional and its opposite is '
     * {@link de.fzi.se.quality.qualityannotation.QualityAnnotation#getProbabilisticElements
     * <em>Probabilistic Elements</em>}'. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Quality Annotation</em>' container reference isn't clear, there
     * really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     *
     * @return the value of the '<em>Quality Annotation</em>' container reference.
     * @see #setQualityAnnotation(QualityAnnotation)
     * @see de.fzi.se.quality.qualityannotation.QualityAnnotationPackage#getProbabilisticElement_QualityAnnotation()
     * @see de.fzi.se.quality.qualityannotation.QualityAnnotation#getProbabilisticElements
     * @model opposite="probabilisticElements" transient="false" ordered="false"
     * @generated
     */
    QualityAnnotation getQualityAnnotation();

    /**
     * Sets the value of the '
     * {@link de.fzi.se.quality.qualityannotation.ProbabilisticElement#getQualityAnnotation
     * <em>Quality Annotation</em>}' container reference. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     *
     * @param value
     *            the new value of the '<em>Quality Annotation</em>' container reference.
     * @see #getQualityAnnotation()
     * @generated
     */
    void setQualityAnnotation(QualityAnnotation value);

} // ProbabilisticElement
