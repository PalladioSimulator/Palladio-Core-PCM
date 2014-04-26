/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.sensitivity;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see de.uka.ipd.sdq.sensitivity.SensitivityPackage
 * @generated
 */
public interface SensitivityFactory extends EFactory {
	/**
     * The singleton instance of the factory.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	SensitivityFactory eINSTANCE = de.uka.ipd.sdq.sensitivity.impl.SensitivityFactoryImpl.init();

	/**
     * Returns a new object of class '<em>Configuration</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>Configuration</em>'.
     * @generated
     */
	SensitivityConfiguration createSensitivityConfiguration();

	/**
     * Returns a new object of class '<em>Combined Sensitivity Parameter</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>Combined Sensitivity Parameter</em>'.
     * @generated
     */
	CombinedSensitivityParameter createCombinedSensitivityParameter();

	/**
     * Returns a new object of class '<em>Component Reliability Parameter</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>Component Reliability Parameter</em>'.
     * @generated
     */
	ComponentReliabilityParameter createComponentReliabilityParameter();

	/**
     * Returns a new object of class '<em>String Parameter Sequence</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>String Parameter Sequence</em>'.
     * @generated
     */
	StringParameterSequence createStringParameterSequence();

	/**
     * Returns a new object of class '<em>Double Parameter Range</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>Double Parameter Range</em>'.
     * @generated
     */
	DoubleParameterRange createDoubleParameterRange();

	/**
     * Returns a new object of class '<em>Double Parameter Sequence</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>Double Parameter Sequence</em>'.
     * @generated
     */
	DoubleParameterSequence createDoubleParameterSequence();

	/**
     * Returns a new object of class '<em>Internal Action Reliability Parameter</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>Internal Action Reliability Parameter</em>'.
     * @generated
     */
	InternalActionReliabilityParameter createInternalActionReliabilityParameter();

	/**
     * Returns a new object of class '<em>Probabilistic Branch Parameter</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>Probabilistic Branch Parameter</em>'.
     * @generated
     */
	ProbabilisticBranchParameter createProbabilisticBranchParameter();

	/**
     * Returns a new object of class '<em>Hardware MTTF Parameter</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>Hardware MTTF Parameter</em>'.
     * @generated
     */
	HardwareMTTFParameter createHardwareMTTFParameter();

	/**
     * Returns a new object of class '<em>Hardware MTTR Parameter</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>Hardware MTTR Parameter</em>'.
     * @generated
     */
	HardwareMTTRParameter createHardwareMTTRParameter();

	/**
     * Returns a new object of class '<em>Resource MTTF Parameter</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>Resource MTTF Parameter</em>'.
     * @generated
     */
	ResourceMTTFParameter createResourceMTTFParameter();

	/**
     * Returns a new object of class '<em>Resource MTTR Parameter</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>Resource MTTR Parameter</em>'.
     * @generated
     */
	ResourceMTTRParameter createResourceMTTRParameter();

	/**
     * Returns a new object of class '<em>Network Reliability Parameter</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>Network Reliability Parameter</em>'.
     * @generated
     */
	NetworkReliabilityParameter createNetworkReliabilityParameter();

	/**
     * Returns a new object of class '<em>Communication Link Reliability Parameter</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>Communication Link Reliability Parameter</em>'.
     * @generated
     */
	CommunicationLinkReliabilityParameter createCommunicationLinkReliabilityParameter();

	/**
     * Returns a new object of class '<em>Software Reliability Parameter</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>Software Reliability Parameter</em>'.
     * @generated
     */
	SoftwareReliabilityParameter createSoftwareReliabilityParameter();

	/**
     * Returns a new object of class '<em>Variable Usage Parameter</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>Variable Usage Parameter</em>'.
     * @generated
     */
	VariableUsageParameter createVariableUsageParameter();

	/**
     * Returns a new object of class '<em>Usage Branch Parameter</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>Usage Branch Parameter</em>'.
     * @generated
     */
	UsageBranchParameter createUsageBranchParameter();

	/**
     * Returns a new object of class '<em>Double Offset Sequence</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>Double Offset Sequence</em>'.
     * @generated
     */
	DoubleOffsetSequence createDoubleOffsetSequence();

	/**
     * Returns a new object of class '<em>Software Failure Types Parameter</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>Software Failure Types Parameter</em>'.
     * @generated
     */
	SoftwareFailureTypesParameter createSoftwareFailureTypesParameter();

	/**
     * Returns a new object of class '<em>Failure Type Result Specification</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>Failure Type Result Specification</em>'.
     * @generated
     */
	FailureTypeResultSpecification createFailureTypeResultSpecification();

	/**
     * Returns a new object of class '<em>Failure Dimension Result Specification</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>Failure Dimension Result Specification</em>'.
     * @generated
     */
	FailureDimensionResultSpecification createFailureDimensionResultSpecification();

	/**
     * Returns the package supported by this factory.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the package supported by this factory.
     * @generated
     */
	SensitivityPackage getSensitivityPackage();

} //SensitivityFactory
