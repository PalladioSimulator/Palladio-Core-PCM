/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.fzi.se.quality.qualityannotation;

import de.uka.ipd.sdq.identifier.Identifier;

/**
 * <!-- begin-user-doc --> A representation of the model object '
 * <em><b>Service Specification</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link de.fzi.se.quality.qualityannotation.ServiceSpecification#getChecksum <em>Checksum
 * </em>}</li>
 * <li>{@link de.fzi.se.quality.qualityannotation.ServiceSpecification#getChecksumAlg <em>Checksum
 * Alg</em>}</li>
 * <li>{@link de.fzi.se.quality.qualityannotation.ServiceSpecification#getQualityAnnotation <em>
 * Quality Annotation</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.fzi.se.quality.qualityannotation.QualityAnnotationPackage#getServiceSpecification()
 * @model abstract="true"
 * @generated
 */
public interface ServiceSpecification extends Identifier {

    /**
     * Returns the value of the '<em><b>Checksum</b></em>' attribute. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Checksum</em>' attribute isn't clear, there really should be more
     * of a description here...
     * </p>
     * <!-- end-user-doc -->
     *
     * @return the value of the '<em>Checksum</em>' attribute.
     * @see #setChecksum(long)
     * @see de.fzi.se.quality.qualityannotation.QualityAnnotationPackage#getServiceSpecification_Checksum()
     * @model ordered="false"
     * @generated
     */
    long getChecksum();

    /**
     * Sets the value of the '
     * {@link de.fzi.se.quality.qualityannotation.ServiceSpecification#getChecksum
     * <em>Checksum</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @param value
     *            the new value of the '<em>Checksum</em>' attribute.
     * @see #getChecksum()
     * @generated
     */
    void setChecksum(long value);

    /**
     * Returns the value of the '<em><b>Checksum Alg</b></em>' attribute. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Checksum Alg</em>' attribute isn't clear, there really should be
     * more of a description here...
     * </p>
     * <!-- end-user-doc -->
     *
     * @return the value of the '<em>Checksum Alg</em>' attribute.
     * @see #setChecksumAlg(String)
     * @see de.fzi.se.quality.qualityannotation.QualityAnnotationPackage#getServiceSpecification_ChecksumAlg()
     * @model required="true" ordered="false"
     * @generated
     */
    String getChecksumAlg();

    /**
     * Sets the value of the '
     * {@link de.fzi.se.quality.qualityannotation.ServiceSpecification#getChecksumAlg
     * <em>Checksum Alg</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @param value
     *            the new value of the '<em>Checksum Alg</em>' attribute.
     * @see #getChecksumAlg()
     * @generated
     */
    void setChecksumAlg(String value);

    /**
     * Returns the value of the '<em><b>Quality Annotation</b></em>' container reference. It is
     * bidirectional and its opposite is '
     * {@link de.fzi.se.quality.qualityannotation.QualityAnnotation#getForServiceSpecification
     * <em>For Service Specification</em>}'. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Quality Annotation</em>' container reference isn't clear, there
     * really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     *
     * @return the value of the '<em>Quality Annotation</em>' container reference.
     * @see #setQualityAnnotation(QualityAnnotation)
     * @see de.fzi.se.quality.qualityannotation.QualityAnnotationPackage#getServiceSpecification_QualityAnnotation()
     * @see de.fzi.se.quality.qualityannotation.QualityAnnotation#getForServiceSpecification
     * @model opposite="forServiceSpecification" required="true" transient="false" ordered="false"
     * @generated
     */
    QualityAnnotation getQualityAnnotation();

    /**
     * Sets the value of the '
     * {@link de.fzi.se.quality.qualityannotation.ServiceSpecification#getQualityAnnotation
     * <em>Quality Annotation</em>}' container reference. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     *
     * @param value
     *            the new value of the '<em>Quality Annotation</em>' container reference.
     * @see #getQualityAnnotation()
     * @generated
     */
    void setQualityAnnotation(QualityAnnotation value);

} // ServiceSpecification
