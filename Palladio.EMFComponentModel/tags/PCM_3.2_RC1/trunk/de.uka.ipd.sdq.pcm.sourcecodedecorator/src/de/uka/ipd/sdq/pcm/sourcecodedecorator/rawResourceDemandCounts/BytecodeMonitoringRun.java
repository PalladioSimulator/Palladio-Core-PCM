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
 * A representation of the model object '<em><b>Bytecode Monitoring Run</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.sourcecodedecorator.rawResourceDemandCounts.BytecodeMonitoringRun#getMeasuredCounts <em>Measured Counts</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.sourcecodedecorator.rawResourceDemandCounts.BytecodeMonitoringRun#getInputParameterCharacterisations <em>Input Parameter Characterisations</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.sourcecodedecorator.rawResourceDemandCounts.BytecodeMonitoringRun#getEnvironmentCharacterisation <em>Environment Characterisation</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.sourcecodedecorator.rawResourceDemandCounts.BytecodeMonitoringRun#getRawResourceDemandsLink <em>Raw Resource Demands Link</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.rawResourceDemandCounts.RawResourceDemandCountsPackage#getBytecodeMonitoringRun()
 * @model
 * @generated
 */
public interface BytecodeMonitoringRun extends Identifier {
	/**
	 * Returns the value of the '<em><b>Measured Counts</b></em>' containment reference list.
	 * The list contents are of type {@link de.uka.ipd.sdq.pcm.sourcecodedecorator.rawResourceDemandCounts.MeasuredCount}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Measured Counts</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Measured Counts</em>' containment reference list.
	 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.rawResourceDemandCounts.RawResourceDemandCountsPackage#getBytecodeMonitoringRun_MeasuredCounts()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<MeasuredCount> getMeasuredCounts();

	/**
	 * Returns the value of the '<em><b>Input Parameter Characterisations</b></em>' containment reference list.
	 * The list contents are of type {@link de.uka.ipd.sdq.pcm.sourcecodedecorator.rawResourceDemandCounts.MeasuredCharacterisationValue}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Input Parameter Characterisations</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Input Parameter Characterisations</em>' containment reference list.
	 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.rawResourceDemandCounts.RawResourceDemandCountsPackage#getBytecodeMonitoringRun_InputParameterCharacterisations()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<MeasuredCharacterisationValue> getInputParameterCharacterisations();

	/**
	 * Returns the value of the '<em><b>Environment Characterisation</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link de.uka.ipd.sdq.pcm.sourcecodedecorator.rawResourceDemandCounts.EnvironmentCharacterisation#getBytecodeMonitoringRuns <em>Bytecode Monitoring Runs</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Environment Characterisation</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Environment Characterisation</em>' reference.
	 * @see #setEnvironmentCharacterisation(EnvironmentCharacterisation)
	 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.rawResourceDemandCounts.RawResourceDemandCountsPackage#getBytecodeMonitoringRun_EnvironmentCharacterisation()
	 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.rawResourceDemandCounts.EnvironmentCharacterisation#getBytecodeMonitoringRuns
	 * @model opposite="bytecodeMonitoringRuns" ordered="false"
	 * @generated
	 */
	EnvironmentCharacterisation getEnvironmentCharacterisation();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.sourcecodedecorator.rawResourceDemandCounts.BytecodeMonitoringRun#getEnvironmentCharacterisation <em>Environment Characterisation</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Environment Characterisation</em>' reference.
	 * @see #getEnvironmentCharacterisation()
	 * @generated
	 */
	void setEnvironmentCharacterisation(EnvironmentCharacterisation value);

	/**
	 * Returns the value of the '<em><b>Raw Resource Demands Link</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link de.uka.ipd.sdq.pcm.sourcecodedecorator.rawResourceDemandCounts.RawResourceDemandsLink#getBytecodeMonitoringRuns <em>Bytecode Monitoring Runs</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Raw Resource Demands Link</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Raw Resource Demands Link</em>' reference.
	 * @see #setRawResourceDemandsLink(RawResourceDemandsLink)
	 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.rawResourceDemandCounts.RawResourceDemandCountsPackage#getBytecodeMonitoringRun_RawResourceDemandsLink()
	 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.rawResourceDemandCounts.RawResourceDemandsLink#getBytecodeMonitoringRuns
	 * @model opposite="bytecodeMonitoringRuns" required="true" ordered="false"
	 * @generated
	 */
	RawResourceDemandsLink getRawResourceDemandsLink();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.sourcecodedecorator.rawResourceDemandCounts.BytecodeMonitoringRun#getRawResourceDemandsLink <em>Raw Resource Demands Link</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Raw Resource Demands Link</em>' reference.
	 * @see #getRawResourceDemandsLink()
	 * @generated
	 */
	void setRawResourceDemandsLink(RawResourceDemandsLink value);

} // BytecodeMonitoringRun
