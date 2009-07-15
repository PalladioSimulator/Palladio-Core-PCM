/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.resultdecorator.resourceenvironmentdecorator;

import de.uka.ipd.sdq.pcm.core.entity.NamedElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Utilisation Result</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.resultdecorator.resourceenvironmentdecorator.UtilisationResult#getNormalisedResourceUtilisation <em>Normalised Resource Utilisation</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.resultdecorator.resourceenvironmentdecorator.UtilisationResult#getNormalisedDemandedTime <em>Normalised Demanded Time</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.resultdecorator.resourceenvironmentdecorator.UtilisationResult#getNormalisedWaitTime <em>Normalised Wait Time</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.pcm.resultdecorator.resourceenvironmentdecorator.ResourceenvironmentdecoratorPackage#getUtilisationResult()
 * @model abstract="true"
 * @generated
 */
public interface UtilisationResult extends NamedElement {
	/**
	 * Returns the value of the '<em><b>Normalised Resource Utilisation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Normalised Resource Utilisation</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Normalised Resource Utilisation</em>' attribute.
	 * @see #setNormalisedResourceUtilisation(double)
	 * @see de.uka.ipd.sdq.pcm.resultdecorator.resourceenvironmentdecorator.ResourceenvironmentdecoratorPackage#getUtilisationResult_NormalisedResourceUtilisation()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	double getNormalisedResourceUtilisation();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.resultdecorator.resourceenvironmentdecorator.UtilisationResult#getNormalisedResourceUtilisation <em>Normalised Resource Utilisation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Normalised Resource Utilisation</em>' attribute.
	 * @see #getNormalisedResourceUtilisation()
	 * @generated
	 */
	void setNormalisedResourceUtilisation(double value);

	/**
	 * Returns the value of the '<em><b>Normalised Demanded Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Normalised Demanded Time</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Normalised Demanded Time</em>' attribute.
	 * @see #setNormalisedDemandedTime(double)
	 * @see de.uka.ipd.sdq.pcm.resultdecorator.resourceenvironmentdecorator.ResourceenvironmentdecoratorPackage#getUtilisationResult_NormalisedDemandedTime()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	double getNormalisedDemandedTime();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.resultdecorator.resourceenvironmentdecorator.UtilisationResult#getNormalisedDemandedTime <em>Normalised Demanded Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Normalised Demanded Time</em>' attribute.
	 * @see #getNormalisedDemandedTime()
	 * @generated
	 */
	void setNormalisedDemandedTime(double value);

	/**
	 * Returns the value of the '<em><b>Normalised Wait Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Normalised Wait Time</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Normalised Wait Time</em>' attribute.
	 * @see #setNormalisedWaitTime(double)
	 * @see de.uka.ipd.sdq.pcm.resultdecorator.resourceenvironmentdecorator.ResourceenvironmentdecoratorPackage#getUtilisationResult_NormalisedWaitTime()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	double getNormalisedWaitTime();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.resultdecorator.resourceenvironmentdecorator.UtilisationResult#getNormalisedWaitTime <em>Normalised Wait Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Normalised Wait Time</em>' attribute.
	 * @see #getNormalisedWaitTime()
	 * @generated
	 */
	void setNormalisedWaitTime(double value);

} // UtilisationResult
