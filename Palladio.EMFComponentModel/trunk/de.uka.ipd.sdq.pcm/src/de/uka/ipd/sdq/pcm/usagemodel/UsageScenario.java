/**
 * Copyright 2007 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.usagemodel;

import de.uka.ipd.sdq.pcm.core.entity.Entity;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Usage Scenario</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * UsageScenarios are concurrently executed behaviours of users within one UsageModel.  It describes which
 * services are directly invoked by users in one specific use case and models the possible sequences of calling
 * them. Each UsageScenario includes a workload and a scenario behaviour. 
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.usagemodel.UsageScenario#getWorkload_UsageScenario <em>Workload Usage Scenario</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.usagemodel.UsageScenario#getScenarioBehaviour_UsageScenario <em>Scenario Behaviour Usage Scenario</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.pcm.usagemodel.UsagemodelPackage#getUsageScenario()
 * @model
 * @generated
 */
public interface UsageScenario extends Entity {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright 2005-2009 by SDQ, IPD, Karlsruhe Institute of Technology / University of Karlsruhe, Germany and SE, FZI Karlsruhe, Germany";

	/**
	 * Returns the value of the '<em><b>Workload Usage Scenario</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Workload Usage Scenario</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Workload Usage Scenario</em>' containment reference.
	 * @see #setWorkload_UsageScenario(Workload)
	 * @see de.uka.ipd.sdq.pcm.usagemodel.UsagemodelPackage#getUsageScenario_Workload_UsageScenario()
	 * @model containment="true" required="true" ordered="false"
	 * @generated
	 */
	Workload getWorkload_UsageScenario();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.usagemodel.UsageScenario#getWorkload_UsageScenario <em>Workload Usage Scenario</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Workload Usage Scenario</em>' containment reference.
	 * @see #getWorkload_UsageScenario()
	 * @generated
	 */
	void setWorkload_UsageScenario(Workload value);

	/**
	 * Returns the value of the '<em><b>Scenario Behaviour Usage Scenario</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Scenario Behaviour Usage Scenario</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Scenario Behaviour Usage Scenario</em>' containment reference.
	 * @see #setScenarioBehaviour_UsageScenario(ScenarioBehaviour)
	 * @see de.uka.ipd.sdq.pcm.usagemodel.UsagemodelPackage#getUsageScenario_ScenarioBehaviour_UsageScenario()
	 * @model containment="true" required="true" ordered="false"
	 * @generated
	 */
	ScenarioBehaviour getScenarioBehaviour_UsageScenario();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.usagemodel.UsageScenario#getScenarioBehaviour_UsageScenario <em>Scenario Behaviour Usage Scenario</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Scenario Behaviour Usage Scenario</em>' containment reference.
	 * @see #getScenarioBehaviour_UsageScenario()
	 * @generated
	 */
	void setScenarioBehaviour_UsageScenario(ScenarioBehaviour value);

} // UsageScenario
