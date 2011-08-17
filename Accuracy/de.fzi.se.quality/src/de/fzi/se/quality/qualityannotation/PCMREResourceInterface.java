/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.fzi.se.quality.qualityannotation;

import de.uka.ipd.sdq.pcm.resourcetype.ResourceInterface;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>PCMRE Resource Interface</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.fzi.se.quality.qualityannotation.PCMREResourceInterface#getResourceInterface <em>Resource Interface</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.fzi.se.quality.qualityannotation.QualityAnnotationPackage#getPCMREResourceInterface()
 * @model
 * @generated
 */
public interface PCMREResourceInterface extends PCMRE {
	/**
	 * Returns the value of the '<em><b>Resource Interface</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Resource Interface</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Resource Interface</em>' reference.
	 * @see #setResourceInterface(ResourceInterface)
	 * @see de.fzi.se.quality.qualityannotation.QualityAnnotationPackage#getPCMREResourceInterface_ResourceInterface()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	ResourceInterface getResourceInterface();

	/**
	 * Sets the value of the '{@link de.fzi.se.quality.qualityannotation.PCMREResourceInterface#getResourceInterface <em>Resource Interface</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Resource Interface</em>' reference.
	 * @see #getResourceInterface()
	 * @generated
	 */
	void setResourceInterface(ResourceInterface value);

} // PCMREResourceInterface
