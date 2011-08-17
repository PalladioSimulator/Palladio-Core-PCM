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
 * A representation of the model object '<em><b>Environment Characterisation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * e.g. settings of JVM or Garbage Collection
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.sourcecodedecorator.rawResourceDemandCounts.EnvironmentCharacterisation#getBytecodeMonitoringRuns <em>Bytecode Monitoring Runs</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.rawResourceDemandCounts.RawResourceDemandCountsPackage#getEnvironmentCharacterisation()
 * @model abstract="true"
 * @generated
 */
public interface EnvironmentCharacterisation extends Identifier {
	/**
	 * Returns the value of the '<em><b>Bytecode Monitoring Runs</b></em>' reference list.
	 * The list contents are of type {@link de.uka.ipd.sdq.pcm.sourcecodedecorator.rawResourceDemandCounts.BytecodeMonitoringRun}.
	 * It is bidirectional and its opposite is '{@link de.uka.ipd.sdq.pcm.sourcecodedecorator.rawResourceDemandCounts.BytecodeMonitoringRun#getEnvironmentCharacterisation <em>Environment Characterisation</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Bytecode Monitoring Runs</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Bytecode Monitoring Runs</em>' reference list.
	 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.rawResourceDemandCounts.RawResourceDemandCountsPackage#getEnvironmentCharacterisation_BytecodeMonitoringRuns()
	 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.rawResourceDemandCounts.BytecodeMonitoringRun#getEnvironmentCharacterisation
	 * @model opposite="environmentCharacterisation" ordered="false"
	 * @generated
	 */
	EList<BytecodeMonitoringRun> getBytecodeMonitoringRuns();

} // EnvironmentCharacterisation
