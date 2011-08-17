/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.probespec;

import de.uka.ipd.sdq.identifier.Identifier;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Probe Set</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.probespec.ProbeSet#getProbes <em>Probes</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.probespec.ProbeSet#getPosition <em>Position</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.probespec.ProbeSet#getAnnotatedElement <em>Annotated Element</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.probespec.probespecPackage#getProbeSet()
 * @model
 * @generated
 */
public interface ProbeSet extends Identifier {
	/**
	 * Returns the value of the '<em><b>Probes</b></em>' containment reference list.
	 * The list contents are of type {@link de.uka.ipd.sdq.probespec.Probe}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Probes</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Probes</em>' containment reference list.
	 * @see de.uka.ipd.sdq.probespec.probespecPackage#getProbeSet_Probes()
	 * @model containment="true" required="true" ordered="false"
	 * @generated
	 */
	EList<Probe> getProbes();

	/**
	 * Returns the value of the '<em><b>Position</b></em>' attribute.
	 * The literals are from the enumeration {@link de.uka.ipd.sdq.probespec.ProbeSetPosition}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Position</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Position</em>' attribute.
	 * @see de.uka.ipd.sdq.probespec.ProbeSetPosition
	 * @see #setPosition(ProbeSetPosition)
	 * @see de.uka.ipd.sdq.probespec.probespecPackage#getProbeSet_Position()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	ProbeSetPosition getPosition();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.probespec.ProbeSet#getPosition <em>Position</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Position</em>' attribute.
	 * @see de.uka.ipd.sdq.probespec.ProbeSetPosition
	 * @see #getPosition()
	 * @generated
	 */
	void setPosition(ProbeSetPosition value);

	/**
	 * Returns the value of the '<em><b>Annotated Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Annotated Element</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Annotated Element</em>' reference.
	 * @see #setAnnotatedElement(EObject)
	 * @see de.uka.ipd.sdq.probespec.probespecPackage#getProbeSet_AnnotatedElement()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	EObject getAnnotatedElement();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.probespec.ProbeSet#getAnnotatedElement <em>Annotated Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Annotated Element</em>' reference.
	 * @see #getAnnotatedElement()
	 * @generated
	 */
	void setAnnotatedElement(EObject value);

} // ProbeSet
