/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.fzi.se.quality.qualityannotation.util;

import de.fzi.se.quality.QualityStatement;

import de.fzi.se.quality.parameters.ParameterPartition;

import de.fzi.se.quality.qualityannotation.*;

import de.uka.ipd.sdq.identifier.Identifier;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see de.fzi.se.quality.qualityannotation.QualityAnnotationPackage
 * @generated
 */
public class QualityAnnotationAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static QualityAnnotationPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public QualityAnnotationAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = QualityAnnotationPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected QualityAnnotationSwitch<Adapter> modelSwitch =
		new QualityAnnotationSwitch<Adapter>() {
			@Override
			public Adapter caseCallParameterDeviation(CallParameterDeviation object) {
				return createCallParameterDeviationAdapter();
			}
			@Override
			public Adapter caseQualityAnnotation(QualityAnnotation object) {
				return createQualityAnnotationAdapter();
			}
			@Override
			public Adapter caseServiceSpecification(ServiceSpecification object) {
				return createServiceSpecificationAdapter();
			}
			@Override
			public Adapter caseRequiredElement(RequiredElement object) {
				return createRequiredElementAdapter();
			}
			@Override
			public Adapter caseNumberOfCallsDeviation(NumberOfCallsDeviation object) {
				return createNumberOfCallsDeviationAdapter();
			}
			@Override
			public Adapter caseInternalStateInfluenceAnalysisAggregation(InternalStateInfluenceAnalysisAggregation object) {
				return createInternalStateInfluenceAnalysisAggregationAdapter();
			}
			@Override
			public Adapter caseREPrecision(REPrecision object) {
				return createREPrecisionAdapter();
			}
			@Override
			public Adapter casePrecision(Precision object) {
				return createPrecisionAdapter();
			}
			@Override
			public Adapter casePCMParameterPartition(PCMParameterPartition object) {
				return createPCMParameterPartitionAdapter();
			}
			@Override
			public Adapter caseCharacterisedPCMParameterPartition(CharacterisedPCMParameterPartition object) {
				return createCharacterisedPCMParameterPartitionAdapter();
			}
			@Override
			public Adapter caseCharacterisedPCMParameterPartitionInterval(CharacterisedPCMParameterPartitionInterval object) {
				return createCharacterisedPCMParameterPartitionIntervalAdapter();
			}
			@Override
			public Adapter caseCharacterisedPCMParameterPartitionRange(CharacterisedPCMParameterPartitionRange object) {
				return createCharacterisedPCMParameterPartitionRangeAdapter();
			}
			@Override
			public Adapter caseExactlyAsSpecifiedPrecision(ExactlyAsSpecifiedPrecision object) {
				return createExactlyAsSpecifiedPrecisionAdapter();
			}
			@Override
			public Adapter caseLimitedDeviationPrecision(LimitedDeviationPrecision object) {
				return createLimitedDeviationPrecisionAdapter();
			}
			@Override
			public Adapter caseNoPrecision(NoPrecision object) {
				return createNoPrecisionAdapter();
			}
			@Override
			public Adapter casePCMRECategory(PCMRECategory object) {
				return createPCMRECategoryAdapter();
			}
			@Override
			public Adapter casePCMRE(PCMRE object) {
				return createPCMREAdapter();
			}
			@Override
			public Adapter casePCMREInterface(PCMREInterface object) {
				return createPCMREInterfaceAdapter();
			}
			@Override
			public Adapter casePCMRERole(PCMRERole object) {
				return createPCMRERoleAdapter();
			}
			@Override
			public Adapter casePCMRESignature(PCMRESignature object) {
				return createPCMRESignatureAdapter();
			}
			@Override
			public Adapter casePCMServiceSpecification(PCMServiceSpecification object) {
				return createPCMServiceSpecificationAdapter();
			}
			@Override
			public Adapter casePCMREResourceInterface(PCMREResourceInterface object) {
				return createPCMREResourceInterfaceAdapter();
			}
			@Override
			public Adapter casePCMREResourceSignature(PCMREResourceSignature object) {
				return createPCMREResourceSignatureAdapter();
			}
			@Override
			public Adapter casePCMREResource(PCMREResource object) {
				return createPCMREResourceAdapter();
			}
			@Override
			public Adapter casePCMREResourceRole(PCMREResourceRole object) {
				return createPCMREResourceRoleAdapter();
			}
			@Override
			public Adapter casePCMRECIBehavior(PCMRECIBehavior object) {
				return createPCMRECIBehaviorAdapter();
			}
			@Override
			public Adapter casePCMREInfrastructureInterface(PCMREInfrastructureInterface object) {
				return createPCMREInfrastructureInterfaceAdapter();
			}
			@Override
			public Adapter casePCMREInfrastructureRole(PCMREInfrastructureRole object) {
				return createPCMREInfrastructureRoleAdapter();
			}
			@Override
			public Adapter casePCMREInfrastructureSignature(PCMREInfrastructureSignature object) {
				return createPCMREInfrastructureSignatureAdapter();
			}
			@Override
			public Adapter caseIdentifier(Identifier object) {
				return createIdentifierAdapter();
			}
			@Override
			public Adapter caseQualityStatement(QualityStatement object) {
				return createQualityStatementAdapter();
			}
			@Override
			public Adapter caseParameterPartition(ParameterPartition object) {
				return createParameterPartitionAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link de.fzi.se.quality.qualityannotation.CallParameterDeviation <em>Call Parameter Deviation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.fzi.se.quality.qualityannotation.CallParameterDeviation
	 * @generated
	 */
	public Adapter createCallParameterDeviationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.fzi.se.quality.qualityannotation.QualityAnnotation <em>Quality Annotation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.fzi.se.quality.qualityannotation.QualityAnnotation
	 * @generated
	 */
	public Adapter createQualityAnnotationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.fzi.se.quality.qualityannotation.ServiceSpecification <em>Service Specification</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.fzi.se.quality.qualityannotation.ServiceSpecification
	 * @generated
	 */
	public Adapter createServiceSpecificationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.fzi.se.quality.qualityannotation.RequiredElement <em>Required Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.fzi.se.quality.qualityannotation.RequiredElement
	 * @generated
	 */
	public Adapter createRequiredElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.fzi.se.quality.qualityannotation.NumberOfCallsDeviation <em>Number Of Calls Deviation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.fzi.se.quality.qualityannotation.NumberOfCallsDeviation
	 * @generated
	 */
	public Adapter createNumberOfCallsDeviationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.fzi.se.quality.qualityannotation.InternalStateInfluenceAnalysisAggregation <em>Internal State Influence Analysis Aggregation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.fzi.se.quality.qualityannotation.InternalStateInfluenceAnalysisAggregation
	 * @generated
	 */
	public Adapter createInternalStateInfluenceAnalysisAggregationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.fzi.se.quality.qualityannotation.REPrecision <em>RE Precision</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.fzi.se.quality.qualityannotation.REPrecision
	 * @generated
	 */
	public Adapter createREPrecisionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.fzi.se.quality.qualityannotation.Precision <em>Precision</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.fzi.se.quality.qualityannotation.Precision
	 * @generated
	 */
	public Adapter createPrecisionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.fzi.se.quality.qualityannotation.PCMParameterPartition <em>PCM Parameter Partition</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.fzi.se.quality.qualityannotation.PCMParameterPartition
	 * @generated
	 */
	public Adapter createPCMParameterPartitionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.fzi.se.quality.qualityannotation.CharacterisedPCMParameterPartition <em>Characterised PCM Parameter Partition</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.fzi.se.quality.qualityannotation.CharacterisedPCMParameterPartition
	 * @generated
	 */
	public Adapter createCharacterisedPCMParameterPartitionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.fzi.se.quality.qualityannotation.CharacterisedPCMParameterPartitionInterval <em>Characterised PCM Parameter Partition Interval</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.fzi.se.quality.qualityannotation.CharacterisedPCMParameterPartitionInterval
	 * @generated
	 */
	public Adapter createCharacterisedPCMParameterPartitionIntervalAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.fzi.se.quality.qualityannotation.CharacterisedPCMParameterPartitionRange <em>Characterised PCM Parameter Partition Range</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.fzi.se.quality.qualityannotation.CharacterisedPCMParameterPartitionRange
	 * @generated
	 */
	public Adapter createCharacterisedPCMParameterPartitionRangeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.fzi.se.quality.qualityannotation.ExactlyAsSpecifiedPrecision <em>Exactly As Specified Precision</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.fzi.se.quality.qualityannotation.ExactlyAsSpecifiedPrecision
	 * @generated
	 */
	public Adapter createExactlyAsSpecifiedPrecisionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.fzi.se.quality.qualityannotation.LimitedDeviationPrecision <em>Limited Deviation Precision</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.fzi.se.quality.qualityannotation.LimitedDeviationPrecision
	 * @generated
	 */
	public Adapter createLimitedDeviationPrecisionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.fzi.se.quality.qualityannotation.NoPrecision <em>No Precision</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.fzi.se.quality.qualityannotation.NoPrecision
	 * @generated
	 */
	public Adapter createNoPrecisionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.fzi.se.quality.qualityannotation.PCMRECategory <em>PCMRE Category</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.fzi.se.quality.qualityannotation.PCMRECategory
	 * @generated
	 */
	public Adapter createPCMRECategoryAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.fzi.se.quality.qualityannotation.PCMRE <em>PCMRE</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.fzi.se.quality.qualityannotation.PCMRE
	 * @generated
	 */
	public Adapter createPCMREAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.fzi.se.quality.qualityannotation.PCMREInterface <em>PCMRE Interface</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.fzi.se.quality.qualityannotation.PCMREInterface
	 * @generated
	 */
	public Adapter createPCMREInterfaceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.fzi.se.quality.qualityannotation.PCMRERole <em>PCMRE Role</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.fzi.se.quality.qualityannotation.PCMRERole
	 * @generated
	 */
	public Adapter createPCMRERoleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.fzi.se.quality.qualityannotation.PCMRESignature <em>PCMRE Signature</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.fzi.se.quality.qualityannotation.PCMRESignature
	 * @generated
	 */
	public Adapter createPCMRESignatureAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.fzi.se.quality.qualityannotation.PCMServiceSpecification <em>PCM Service Specification</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.fzi.se.quality.qualityannotation.PCMServiceSpecification
	 * @generated
	 */
	public Adapter createPCMServiceSpecificationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.fzi.se.quality.qualityannotation.PCMREResourceInterface <em>PCMRE Resource Interface</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.fzi.se.quality.qualityannotation.PCMREResourceInterface
	 * @generated
	 */
	public Adapter createPCMREResourceInterfaceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.fzi.se.quality.qualityannotation.PCMREResourceSignature <em>PCMRE Resource Signature</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.fzi.se.quality.qualityannotation.PCMREResourceSignature
	 * @generated
	 */
	public Adapter createPCMREResourceSignatureAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.fzi.se.quality.qualityannotation.PCMREResource <em>PCMRE Resource</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.fzi.se.quality.qualityannotation.PCMREResource
	 * @generated
	 */
	public Adapter createPCMREResourceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.fzi.se.quality.qualityannotation.PCMREResourceRole <em>PCMRE Resource Role</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.fzi.se.quality.qualityannotation.PCMREResourceRole
	 * @generated
	 */
	public Adapter createPCMREResourceRoleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.fzi.se.quality.qualityannotation.PCMRECIBehavior <em>PCMRECI Behavior</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.fzi.se.quality.qualityannotation.PCMRECIBehavior
	 * @generated
	 */
	public Adapter createPCMRECIBehaviorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.fzi.se.quality.qualityannotation.PCMREInfrastructureInterface <em>PCMRE Infrastructure Interface</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.fzi.se.quality.qualityannotation.PCMREInfrastructureInterface
	 * @generated
	 */
	public Adapter createPCMREInfrastructureInterfaceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.fzi.se.quality.qualityannotation.PCMREInfrastructureRole <em>PCMRE Infrastructure Role</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.fzi.se.quality.qualityannotation.PCMREInfrastructureRole
	 * @generated
	 */
	public Adapter createPCMREInfrastructureRoleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.fzi.se.quality.qualityannotation.PCMREInfrastructureSignature <em>PCMRE Infrastructure Signature</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.fzi.se.quality.qualityannotation.PCMREInfrastructureSignature
	 * @generated
	 */
	public Adapter createPCMREInfrastructureSignatureAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.identifier.Identifier <em>Identifier</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.uka.ipd.sdq.identifier.Identifier
	 * @generated
	 */
	public Adapter createIdentifierAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.fzi.se.quality.QualityStatement <em>Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.fzi.se.quality.QualityStatement
	 * @generated
	 */
	public Adapter createQualityStatementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.fzi.se.quality.parameters.ParameterPartition <em>Parameter Partition</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.fzi.se.quality.parameters.ParameterPartition
	 * @generated
	 */
	public Adapter createParameterPartitionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //QualityAnnotationAdapterFactory
