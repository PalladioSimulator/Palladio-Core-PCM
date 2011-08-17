/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.sourcecodedecorator.rawResourceDemandCounts;

import de.uka.ipd.sdq.identifier.Identifier;

import de.uka.ipd.sdq.pcm.seff.AbstractInternalControlFlowAction;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Raw Resource Demands Link</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.sourcecodedecorator.rawResourceDemandCounts.RawResourceDemandsLink#getInternalAction <em>Internal Action</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.sourcecodedecorator.rawResourceDemandCounts.RawResourceDemandsLink#getBytecodeMonitoringRuns <em>Bytecode Monitoring Runs</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.rawResourceDemandCounts.RawResourceDemandCountsPackage#getRawResourceDemandsLink()
 * @model
 * @generated
 */
public interface RawResourceDemandsLink extends Identifier {
	/**
	 * Returns the value of the '<em><b>Internal Action</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Internal Action</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Internal Action</em>' reference.
	 * @see #setInternalAction(AbstractInternalControlFlowAction)
	 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.rawResourceDemandCounts.RawResourceDemandCountsPackage#getRawResourceDemandsLink_InternalAction()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	AbstractInternalControlFlowAction getInternalAction();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.sourcecodedecorator.rawResourceDemandCounts.RawResourceDemandsLink#getInternalAction <em>Internal Action</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Internal Action</em>' reference.
	 * @see #getInternalAction()
	 * @generated
	 */
	void setInternalAction(AbstractInternalControlFlowAction value);

	/**
	 * Returns the value of the '<em><b>Bytecode Monitoring Runs</b></em>' reference list.
	 * The list contents are of type {@link de.uka.ipd.sdq.pcm.sourcecodedecorator.rawResourceDemandCounts.BytecodeMonitoringRun}.
	 * It is bidirectional and its opposite is '{@link de.uka.ipd.sdq.pcm.sourcecodedecorator.rawResourceDemandCounts.BytecodeMonitoringRun#getRawResourceDemandsLink <em>Raw Resource Demands Link</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Bytecode Monitoring Runs</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Bytecode Monitoring Runs</em>' reference list.
	 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.rawResourceDemandCounts.RawResourceDemandCountsPackage#getRawResourceDemandsLink_BytecodeMonitoringRuns()
	 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.rawResourceDemandCounts.BytecodeMonitoringRun#getRawResourceDemandsLink
	 * @model opposite="rawResourceDemandsLink" ordered="false"
	 * @generated
	 */
	EList<BytecodeMonitoringRun> getBytecodeMonitoringRuns();

} // RawResourceDemandsLink
