/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.fzi.se.quality.qualityannotation;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see de.fzi.se.quality.qualityannotation.QualityAnnotationPackage
 * @generated
 */
public interface QualityAnnotationFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	QualityAnnotationFactory eINSTANCE = de.fzi.se.quality.qualityannotation.impl.QualityAnnotationFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Call Parameter Deviation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Call Parameter Deviation</em>'.
	 * @generated
	 */
	CallParameterDeviation createCallParameterDeviation();

	/**
	 * Returns a new object of class '<em>Quality Annotation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Quality Annotation</em>'.
	 * @generated
	 */
	QualityAnnotation createQualityAnnotation();

	/**
	 * Returns a new object of class '<em>Required Element</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Required Element</em>'.
	 * @generated
	 */
	RequiredElement createRequiredElement();

	/**
	 * Returns a new object of class '<em>Number Of Calls Deviation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Number Of Calls Deviation</em>'.
	 * @generated
	 */
	NumberOfCallsDeviation createNumberOfCallsDeviation();

	/**
	 * Returns a new object of class '<em>Internal State Influence Analysis Aggregation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Internal State Influence Analysis Aggregation</em>'.
	 * @generated
	 */
	InternalStateInfluenceAnalysisAggregation createInternalStateInfluenceAnalysisAggregation();

	/**
	 * Returns a new object of class '<em>RE Precision</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>RE Precision</em>'.
	 * @generated
	 */
	REPrecision createREPrecision();

	/**
	 * Returns a new object of class '<em>PCM Parameter Partition</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>PCM Parameter Partition</em>'.
	 * @generated
	 */
	PCMParameterPartition createPCMParameterPartition();

	/**
	 * Returns a new object of class '<em>Characterised PCM Parameter Partition Interval</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Characterised PCM Parameter Partition Interval</em>'.
	 * @generated
	 */
	CharacterisedPCMParameterPartitionInterval createCharacterisedPCMParameterPartitionInterval();

	/**
	 * Returns a new object of class '<em>Characterised PCM Parameter Partition Range</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Characterised PCM Parameter Partition Range</em>'.
	 * @generated
	 */
	CharacterisedPCMParameterPartitionRange createCharacterisedPCMParameterPartitionRange();

	/**
	 * Returns a new object of class '<em>Exactly As Specified Precision</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Exactly As Specified Precision</em>'.
	 * @generated
	 */
	ExactlyAsSpecifiedPrecision createExactlyAsSpecifiedPrecision();

	/**
	 * Returns a new object of class '<em>Limited Deviation Precision</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Limited Deviation Precision</em>'.
	 * @generated
	 */
	LimitedDeviationPrecision createLimitedDeviationPrecision();

	/**
	 * Returns a new object of class '<em>No Precision</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>No Precision</em>'.
	 * @generated
	 */
	NoPrecision createNoPrecision();

	/**
	 * Returns a new object of class '<em>PCMRE Category</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>PCMRE Category</em>'.
	 * @generated
	 */
	PCMRECategory createPCMRECategory();

	/**
	 * Returns a new object of class '<em>PCMRE Interface</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>PCMRE Interface</em>'.
	 * @generated
	 */
	PCMREInterface createPCMREInterface();

	/**
	 * Returns a new object of class '<em>PCMRE Role</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>PCMRE Role</em>'.
	 * @generated
	 */
	PCMRERole createPCMRERole();

	/**
	 * Returns a new object of class '<em>PCMRE Signature</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>PCMRE Signature</em>'.
	 * @generated
	 */
	PCMRESignature createPCMRESignature();

	/**
	 * Returns a new object of class '<em>PCM Service Specification</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>PCM Service Specification</em>'.
	 * @generated
	 */
	PCMServiceSpecification createPCMServiceSpecification();

	/**
	 * Returns a new object of class '<em>PCMRE Resource Interface</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>PCMRE Resource Interface</em>'.
	 * @generated
	 */
	PCMREResourceInterface createPCMREResourceInterface();

	/**
	 * Returns a new object of class '<em>PCMRE Resource Signature</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>PCMRE Resource Signature</em>'.
	 * @generated
	 */
	PCMREResourceSignature createPCMREResourceSignature();

	/**
	 * Returns a new object of class '<em>PCMRE Resource</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>PCMRE Resource</em>'.
	 * @generated
	 */
	PCMREResource createPCMREResource();

	/**
	 * Returns a new object of class '<em>PCMRE Resource Role</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>PCMRE Resource Role</em>'.
	 * @generated
	 */
	PCMREResourceRole createPCMREResourceRole();

	/**
	 * Returns a new object of class '<em>PCMRECI Behavior</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>PCMRECI Behavior</em>'.
	 * @generated
	 */
	PCMRECIBehavior createPCMRECIBehavior();

	/**
	 * Returns a new object of class '<em>PCMRE Infrastructure Interface</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>PCMRE Infrastructure Interface</em>'.
	 * @generated
	 */
	PCMREInfrastructureInterface createPCMREInfrastructureInterface();

	/**
	 * Returns a new object of class '<em>PCMRE Infrastructure Role</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>PCMRE Infrastructure Role</em>'.
	 * @generated
	 */
	PCMREInfrastructureRole createPCMREInfrastructureRole();

	/**
	 * Returns a new object of class '<em>PCMRE Infrastructure Signature</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>PCMRE Infrastructure Signature</em>'.
	 * @generated
	 */
	PCMREInfrastructureSignature createPCMREInfrastructureSignature();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	QualityAnnotationPackage getQualityAnnotationPackage();

} //QualityAnnotationFactory
