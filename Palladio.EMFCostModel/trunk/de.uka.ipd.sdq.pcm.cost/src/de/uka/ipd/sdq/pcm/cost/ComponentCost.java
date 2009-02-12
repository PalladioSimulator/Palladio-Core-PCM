/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.cost;

import de.uka.ipd.sdq.pcm.repository.RepositoryComponent;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Component Cost</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.cost.ComponentCost#getComponentOperatingCost <em>Component Operating Cost</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.cost.ComponentCost#getComponentInitialCost <em>Component Initial Cost</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.cost.ComponentCost#getRepositoryComponent <em>Repository Component</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.pcm.cost.costPackage#getComponentCost()
 * @model
 * @generated
 */
public interface ComponentCost extends Cost {
	/**
	 * Returns the value of the '<em><b>Component Operating Cost</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Component Operating Cost</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Component Operating Cost</em>' attribute.
	 * @see #setComponentOperatingCost(double)
	 * @see de.uka.ipd.sdq.pcm.cost.costPackage#getComponentCost_ComponentOperatingCost()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	double getComponentOperatingCost();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.cost.ComponentCost#getComponentOperatingCost <em>Component Operating Cost</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Component Operating Cost</em>' attribute.
	 * @see #getComponentOperatingCost()
	 * @generated
	 */
	void setComponentOperatingCost(double value);

	/**
	 * Returns the value of the '<em><b>Component Initial Cost</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Component Initial Cost</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Component Initial Cost</em>' attribute.
	 * @see #setComponentInitialCost(double)
	 * @see de.uka.ipd.sdq.pcm.cost.costPackage#getComponentCost_ComponentInitialCost()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	double getComponentInitialCost();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.cost.ComponentCost#getComponentInitialCost <em>Component Initial Cost</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Component Initial Cost</em>' attribute.
	 * @see #getComponentInitialCost()
	 * @generated
	 */
	void setComponentInitialCost(double value);

	/**
	 * Returns the value of the '<em><b>Repository Component</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Repository Component</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Repository Component</em>' reference.
	 * @see #setRepositoryComponent(RepositoryComponent)
	 * @see de.uka.ipd.sdq.pcm.cost.costPackage#getComponentCost_RepositoryComponent()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	RepositoryComponent getRepositoryComponent();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.cost.ComponentCost#getRepositoryComponent <em>Repository Component</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Repository Component</em>' reference.
	 * @see #getRepositoryComponent()
	 * @generated
	 */
	void setRepositoryComponent(RepositoryComponent value);

} // ComponentCost
