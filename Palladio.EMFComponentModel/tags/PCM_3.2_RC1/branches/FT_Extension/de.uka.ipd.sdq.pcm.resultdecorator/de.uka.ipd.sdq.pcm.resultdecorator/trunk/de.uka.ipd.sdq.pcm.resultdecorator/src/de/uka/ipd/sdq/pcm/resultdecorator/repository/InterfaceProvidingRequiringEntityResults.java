/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.resultdecorator.repository;

import de.uka.ipd.sdq.pcm.core.entity.InterfaceProvidingRequiringEntity;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Interface Providing Requiring Entity Results</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.resultdecorator.repository.InterfaceProvidingRequiringEntityResults#getInterfaceprovidingrequiringentity <em>Interfaceprovidingrequiringentity</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.resultdecorator.repository.InterfaceProvidingRequiringEntityResults#getNormalisedResourceDemand <em>Normalised Resource Demand</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.resultdecorator.repository.InterfaceProvidingRequiringEntityResults#getNormalisedResponseTime <em>Normalised Response Time</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.pcm.resultdecorator.repository.repositorydecoratorPackage#getInterfaceProvidingRequiringEntityResults()
 * @model
 * @generated
 */
public interface InterfaceProvidingRequiringEntityResults extends EObject {
	/**
	 * Returns the value of the '<em><b>Interfaceprovidingrequiringentity</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Interfaceprovidingrequiringentity</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Interfaceprovidingrequiringentity</em>' reference.
	 * @see #setInterfaceprovidingrequiringentity(InterfaceProvidingRequiringEntity)
	 * @see de.uka.ipd.sdq.pcm.resultdecorator.repository.repositorydecoratorPackage#getInterfaceProvidingRequiringEntityResults_Interfaceprovidingrequiringentity()
	 * @model ordered="false"
	 * @generated
	 */
	InterfaceProvidingRequiringEntity getInterfaceprovidingrequiringentity();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.resultdecorator.repository.InterfaceProvidingRequiringEntityResults#getInterfaceprovidingrequiringentity <em>Interfaceprovidingrequiringentity</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Interfaceprovidingrequiringentity</em>' reference.
	 * @see #getInterfaceprovidingrequiringentity()
	 * @generated
	 */
	void setInterfaceprovidingrequiringentity(InterfaceProvidingRequiringEntity value);

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
	 * @see de.uka.ipd.sdq.pcm.resultdecorator.repository.repositorydecoratorPackage#getInterfaceProvidingRequiringEntityResults_NormalisedResourceDemand()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	double getNormalisedResourceDemand();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.resultdecorator.repository.InterfaceProvidingRequiringEntityResults#getNormalisedResourceDemand <em>Normalised Resource Demand</em>}' attribute.
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
	 * @see de.uka.ipd.sdq.pcm.resultdecorator.repository.repositorydecoratorPackage#getInterfaceProvidingRequiringEntityResults_NormalisedResponseTime()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	double getNormalisedResponseTime();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.resultdecorator.repository.InterfaceProvidingRequiringEntityResults#getNormalisedResponseTime <em>Normalised Response Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Normalised Response Time</em>' attribute.
	 * @see #getNormalisedResponseTime()
	 * @generated
	 */
	void setNormalisedResponseTime(double value);

} // InterfaceProvidingRequiringEntityResults
