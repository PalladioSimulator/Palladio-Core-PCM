/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.resultdecorator.repositorydecorator;

import de.uka.ipd.sdq.pcm.core.entity.NamedElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Component Result</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.resultdecorator.repositorydecorator.ComponentResult#getNormalisedResourceDemand <em>Normalised Resource Demand</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.resultdecorator.repositorydecorator.ComponentResult#getNormalisedResponseTime <em>Normalised Response Time</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.resultdecorator.repositorydecorator.ComponentResult#getAverageResourceDemand <em>Average Resource Demand</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.resultdecorator.repositorydecorator.ComponentResult#getMeanResponseTime <em>Mean Response Time</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.resultdecorator.repositorydecorator.ComponentResult#getAverageNumberOfSentMessages <em>Average Number Of Sent Messages</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.pcm.resultdecorator.repositorydecorator.RepositorydecoratorPackage#getComponentResult()
 * @model abstract="true"
 * @generated
 */
public interface ComponentResult extends NamedElement {
	/**
	 * Returns the value of the '<em><b>Normalised Resource Demand</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Normalised Resource Demand</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Normalised Resource Demand</em>' attribute.
	 * @see #setNormalisedResourceDemand(double)
	 * @see de.uka.ipd.sdq.pcm.resultdecorator.repositorydecorator.RepositorydecoratorPackage#getComponentResult_NormalisedResourceDemand()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	double getNormalisedResourceDemand();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.resultdecorator.repositorydecorator.ComponentResult#getNormalisedResourceDemand <em>Normalised Resource Demand</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Normalised Resource Demand</em>' attribute.
	 * @see #getNormalisedResourceDemand()
	 * @generated
	 */
	void setNormalisedResourceDemand(double value);

	/**
	 * Returns the value of the '<em><b>Normalised Response Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Normalised Response Time</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Normalised Response Time</em>' attribute.
	 * @see #setNormalisedResponseTime(double)
	 * @see de.uka.ipd.sdq.pcm.resultdecorator.repositorydecorator.RepositorydecoratorPackage#getComponentResult_NormalisedResponseTime()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	double getNormalisedResponseTime();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.resultdecorator.repositorydecorator.ComponentResult#getNormalisedResponseTime <em>Normalised Response Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Normalised Response Time</em>' attribute.
	 * @see #getNormalisedResponseTime()
	 * @generated
	 */
	void setNormalisedResponseTime(double value);

	/**
	 * Returns the value of the '<em><b>Average Resource Demand</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Average Resource Demand</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Average Resource Demand</em>' attribute.
	 * @see #setAverageResourceDemand(double)
	 * @see de.uka.ipd.sdq.pcm.resultdecorator.repositorydecorator.RepositorydecoratorPackage#getComponentResult_AverageResourceDemand()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	double getAverageResourceDemand();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.resultdecorator.repositorydecorator.ComponentResult#getAverageResourceDemand <em>Average Resource Demand</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Average Resource Demand</em>' attribute.
	 * @see #getAverageResourceDemand()
	 * @generated
	 */
	void setAverageResourceDemand(double value);

	/**
	 * Returns the value of the '<em><b>Mean Response Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mean Response Time</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mean Response Time</em>' attribute.
	 * @see #setMeanResponseTime(double)
	 * @see de.uka.ipd.sdq.pcm.resultdecorator.repositorydecorator.RepositorydecoratorPackage#getComponentResult_MeanResponseTime()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	double getMeanResponseTime();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.resultdecorator.repositorydecorator.ComponentResult#getMeanResponseTime <em>Mean Response Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Mean Response Time</em>' attribute.
	 * @see #getMeanResponseTime()
	 * @generated
	 */
	void setMeanResponseTime(double value);

	/**
	 * Returns the value of the '<em><b>Average Number Of Sent Messages</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Average Number Of Sent Messages</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Average Number Of Sent Messages</em>' attribute.
	 * @see #setAverageNumberOfSentMessages(double)
	 * @see de.uka.ipd.sdq.pcm.resultdecorator.repositorydecorator.RepositorydecoratorPackage#getComponentResult_AverageNumberOfSentMessages()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	double getAverageNumberOfSentMessages();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.resultdecorator.repositorydecorator.ComponentResult#getAverageNumberOfSentMessages <em>Average Number Of Sent Messages</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Average Number Of Sent Messages</em>' attribute.
	 * @see #getAverageNumberOfSentMessages()
	 * @generated
	 */
	void setAverageNumberOfSentMessages(double value);

} // ComponentResult
