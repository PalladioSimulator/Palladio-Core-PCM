/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.ByBench;

import de.uka.ipd.sdq.identifier.Identifier;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Scenario</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.ByBench.Scenario#getScenarioprecondition <em>Scenarioprecondition</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.ByBench.Scenario#getMeasurementstart <em>Measurementstart</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.ByBench.Scenario#getScenariocore <em>Scenariocore</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.ByBench.Scenario#getMeasurementend <em>Measurementend</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.ByBench.Scenario#getScenariopostcondition <em>Scenariopostcondition</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.ByBench.Scenario#getNamedcardinality <em>Namedcardinality</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.ByBench.Scenario#getBenchmarkedInstruction <em>Benchmarked Instruction</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.ByBench.ByBenchPackage#getScenario()
 * @model
 * @generated
 */
public interface Scenario extends Identifier {
	/**
	 * Returns the value of the '<em><b>Scenarioprecondition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Scenarioprecondition</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Scenarioprecondition</em>' containment reference.
	 * @see #setScenarioprecondition(ScenarioPrecondition)
	 * @see de.uka.ipd.sdq.ByBench.ByBenchPackage#getScenario_Scenarioprecondition()
	 * @model containment="true" required="true" ordered="false"
	 * @generated
	 */
	ScenarioPrecondition getScenarioprecondition();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.ByBench.Scenario#getScenarioprecondition <em>Scenarioprecondition</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Scenarioprecondition</em>' containment reference.
	 * @see #getScenarioprecondition()
	 * @generated
	 */
	void setScenarioprecondition(ScenarioPrecondition value);

	/**
	 * Returns the value of the '<em><b>Measurementstart</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Measurementstart</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Measurementstart</em>' containment reference.
	 * @see #setMeasurementstart(MeasurementStart)
	 * @see de.uka.ipd.sdq.ByBench.ByBenchPackage#getScenario_Measurementstart()
	 * @model containment="true" required="true" ordered="false"
	 * @generated
	 */
	MeasurementStart getMeasurementstart();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.ByBench.Scenario#getMeasurementstart <em>Measurementstart</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Measurementstart</em>' containment reference.
	 * @see #getMeasurementstart()
	 * @generated
	 */
	void setMeasurementstart(MeasurementStart value);

	/**
	 * Returns the value of the '<em><b>Scenariocore</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Scenariocore</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Scenariocore</em>' containment reference.
	 * @see #setScenariocore(ScenarioCore)
	 * @see de.uka.ipd.sdq.ByBench.ByBenchPackage#getScenario_Scenariocore()
	 * @model containment="true" required="true" ordered="false"
	 * @generated
	 */
	ScenarioCore getScenariocore();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.ByBench.Scenario#getScenariocore <em>Scenariocore</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Scenariocore</em>' containment reference.
	 * @see #getScenariocore()
	 * @generated
	 */
	void setScenariocore(ScenarioCore value);

	/**
	 * Returns the value of the '<em><b>Measurementend</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Measurementend</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Measurementend</em>' containment reference.
	 * @see #setMeasurementend(MeasurementEnd)
	 * @see de.uka.ipd.sdq.ByBench.ByBenchPackage#getScenario_Measurementend()
	 * @model containment="true" required="true" ordered="false"
	 * @generated
	 */
	MeasurementEnd getMeasurementend();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.ByBench.Scenario#getMeasurementend <em>Measurementend</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Measurementend</em>' containment reference.
	 * @see #getMeasurementend()
	 * @generated
	 */
	void setMeasurementend(MeasurementEnd value);

	/**
	 * Returns the value of the '<em><b>Scenariopostcondition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Scenariopostcondition</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Scenariopostcondition</em>' containment reference.
	 * @see #setScenariopostcondition(ScenarioPostcondition)
	 * @see de.uka.ipd.sdq.ByBench.ByBenchPackage#getScenario_Scenariopostcondition()
	 * @model containment="true" required="true" ordered="false"
	 * @generated
	 */
	ScenarioPostcondition getScenariopostcondition();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.ByBench.Scenario#getScenariopostcondition <em>Scenariopostcondition</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Scenariopostcondition</em>' containment reference.
	 * @see #getScenariopostcondition()
	 * @generated
	 */
	void setScenariopostcondition(ScenarioPostcondition value);

	/**
	 * Returns the value of the '<em><b>Namedcardinality</b></em>' containment reference list.
	 * The list contents are of type {@link de.uka.ipd.sdq.ByBench.NamedCardinality}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Namedcardinality</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Namedcardinality</em>' containment reference list.
	 * @see de.uka.ipd.sdq.ByBench.ByBenchPackage#getScenario_Namedcardinality()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<NamedCardinality> getNamedcardinality();

	/**
	 * Returns the value of the '<em><b>Benchmarked Instruction</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Benchmarked Instruction</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Benchmarked Instruction</em>' reference.
	 * @see #setBenchmarkedInstruction(AtomicInstruction)
	 * @see de.uka.ipd.sdq.ByBench.ByBenchPackage#getScenario_BenchmarkedInstruction()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	AtomicInstruction getBenchmarkedInstruction();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.ByBench.Scenario#getBenchmarkedInstruction <em>Benchmarked Instruction</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Benchmarked Instruction</em>' reference.
	 * @see #getBenchmarkedInstruction()
	 * @generated
	 */
	void setBenchmarkedInstruction(AtomicInstruction value);

} // Scenario
