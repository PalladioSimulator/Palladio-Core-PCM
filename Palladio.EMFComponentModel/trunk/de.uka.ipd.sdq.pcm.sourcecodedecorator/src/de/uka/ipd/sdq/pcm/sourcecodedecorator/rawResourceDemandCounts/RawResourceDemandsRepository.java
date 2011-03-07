/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.sourcecodedecorator.rawResourceDemandCounts;

import de.uka.ipd.sdq.identifier.Identifier;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Raw Resource Demands Repository</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.sourcecodedecorator.rawResourceDemandCounts.RawResourceDemandsRepository#getBytecodeMonitoringRuns <em>Bytecode Monitoring Runs</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.sourcecodedecorator.rawResourceDemandCounts.RawResourceDemandsRepository#getRawResourceDemandsLinks <em>Raw Resource Demands Links</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.sourcecodedecorator.rawResourceDemandCounts.RawResourceDemandsRepository#getEnvironmentCharacterisations <em>Environment Characterisations</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.rawResourceDemandCounts.RawResourceDemandCountsPackage#getRawResourceDemandsRepository()
 * @model
 * @generated
 */
public interface RawResourceDemandsRepository extends Identifier {
	/**
	 * Returns the value of the '<em><b>Bytecode Monitoring Runs</b></em>' containment reference list.
	 * The list contents are of type {@link de.uka.ipd.sdq.pcm.sourcecodedecorator.rawResourceDemandCounts.BytecodeMonitoringRun}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Bytecode Monitoring Runs</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Bytecode Monitoring Runs</em>' containment reference list.
	 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.rawResourceDemandCounts.RawResourceDemandCountsPackage#getRawResourceDemandsRepository_BytecodeMonitoringRuns()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<BytecodeMonitoringRun> getBytecodeMonitoringRuns();

	/**
	 * Returns the value of the '<em><b>Raw Resource Demands Links</b></em>' containment reference list.
	 * The list contents are of type {@link de.uka.ipd.sdq.pcm.sourcecodedecorator.rawResourceDemandCounts.RawResourceDemandsLink}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Raw Resource Demands Links</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Raw Resource Demands Links</em>' containment reference list.
	 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.rawResourceDemandCounts.RawResourceDemandCountsPackage#getRawResourceDemandsRepository_RawResourceDemandsLinks()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<RawResourceDemandsLink> getRawResourceDemandsLinks();

	/**
	 * Returns the value of the '<em><b>Environment Characterisations</b></em>' containment reference list.
	 * The list contents are of type {@link de.uka.ipd.sdq.pcm.sourcecodedecorator.rawResourceDemandCounts.EnvironmentCharacterisation}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Environment Characterisations</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Environment Characterisations</em>' containment reference list.
	 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.rawResourceDemandCounts.RawResourceDemandCountsPackage#getRawResourceDemandsRepository_EnvironmentCharacterisations()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<EnvironmentCharacterisation> getEnvironmentCharacterisations();

} // RawResourceDemandsRepository
