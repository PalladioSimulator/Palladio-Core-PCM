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
 * A representation of the model object '<em><b>Component Cost Per Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * <p>
 *     For&nbsp;components,&nbsp;the&nbsp;componentOperatingCost&nbsp;and&nbsp;componentInitialCost&nbsp;are&nbsp;directly&nbsp;specified&nbsp;and&nbsp;are&nbsp;used&nbsp;to&nbsp;derive&nbsp;the&nbsp;operatingCost&nbsp;and&nbsp;the&nbsp;initialCost&nbsp;1:1.&nbsp;
 * </p>
 * <p>
 *     ComponentCostPerType occur once for each component in the repository that is used in the system to analyse, regardless
 *     of how often the component is instantiated (in AssemblyContexts or AllocationContexts).
 * </p>
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.cost.ComponentCostPerType#getComponentOperatingCost <em>Component Operating Cost</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.cost.ComponentCostPerType#getComponentInitialCost <em>Component Initial Cost</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.cost.ComponentCostPerType#getRepositoryComponent <em>Repository Component</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.pcm.cost.costPackage#getComponentCostPerType()
 * @model
 * @generated
 */
public interface ComponentCostPerType extends Cost {
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
	 * @see de.uka.ipd.sdq.pcm.cost.costPackage#getComponentCostPerType_ComponentOperatingCost()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	double getComponentOperatingCost();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.cost.ComponentCostPerType#getComponentOperatingCost <em>Component Operating Cost</em>}' attribute.
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
	 * @see de.uka.ipd.sdq.pcm.cost.costPackage#getComponentCostPerType_ComponentInitialCost()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	double getComponentInitialCost();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.cost.ComponentCostPerType#getComponentInitialCost <em>Component Initial Cost</em>}' attribute.
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
	 * @see de.uka.ipd.sdq.pcm.cost.costPackage#getComponentCostPerType_RepositoryComponent()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	RepositoryComponent getRepositoryComponent();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.cost.ComponentCostPerType#getRepositoryComponent <em>Repository Component</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Repository Component</em>' reference.
	 * @see #getRepositoryComponent()
	 * @generated
	 */
	void setRepositoryComponent(RepositoryComponent value);

} // ComponentCostPerType
