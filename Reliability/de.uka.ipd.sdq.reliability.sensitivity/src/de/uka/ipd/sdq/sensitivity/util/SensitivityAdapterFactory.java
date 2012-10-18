/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.sensitivity.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.ecore.EObject;

import de.uka.ipd.sdq.identifier.Identifier;
import de.uka.ipd.sdq.pcm.core.entity.Entity;
import de.uka.ipd.sdq.pcm.core.entity.NamedElement;
import de.uka.ipd.sdq.sensitivity.CombinedSensitivityParameter;
import de.uka.ipd.sdq.sensitivity.CommunicationLinkReliabilityParameter;
import de.uka.ipd.sdq.sensitivity.ComponentReliabilityParameter;
import de.uka.ipd.sdq.sensitivity.DoubleOffsetSequence;
import de.uka.ipd.sdq.sensitivity.DoubleParameterFunction;
import de.uka.ipd.sdq.sensitivity.DoubleParameterRange;
import de.uka.ipd.sdq.sensitivity.DoubleParameterSequence;
import de.uka.ipd.sdq.sensitivity.DoubleParameterVariation;
import de.uka.ipd.sdq.sensitivity.FailureDimensionResultSpecification;
import de.uka.ipd.sdq.sensitivity.FailureTypeResultSpecification;
import de.uka.ipd.sdq.sensitivity.HardwareMTTFParameter;
import de.uka.ipd.sdq.sensitivity.HardwareMTTRParameter;
import de.uka.ipd.sdq.sensitivity.InternalActionReliabilityParameter;
import de.uka.ipd.sdq.sensitivity.NetworkReliabilityParameter;
import de.uka.ipd.sdq.sensitivity.ProbabilisticBranchParameter;
import de.uka.ipd.sdq.sensitivity.ResourceMTTFParameter;
import de.uka.ipd.sdq.sensitivity.ResourceMTTRParameter;
import de.uka.ipd.sdq.sensitivity.SensitivityConfiguration;
import de.uka.ipd.sdq.sensitivity.SensitivityPackage;
import de.uka.ipd.sdq.sensitivity.SensitivityParameter;
import de.uka.ipd.sdq.sensitivity.SensitivityParameterVariation;
import de.uka.ipd.sdq.sensitivity.SensitivityResultSpecification;
import de.uka.ipd.sdq.sensitivity.SingleSensitivityParameter;
import de.uka.ipd.sdq.sensitivity.SoftwareFailureTypesParameter;
import de.uka.ipd.sdq.sensitivity.SoftwareReliabilityParameter;
import de.uka.ipd.sdq.sensitivity.StringParameterSequence;
import de.uka.ipd.sdq.sensitivity.UsageBranchParameter;
import de.uka.ipd.sdq.sensitivity.VariableUsageParameter;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see de.uka.ipd.sdq.sensitivity.SensitivityPackage
 * @generated
 */
public class SensitivityAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static SensitivityPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SensitivityAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = SensitivityPackage.eINSTANCE;
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
	protected SensitivitySwitch<Adapter> modelSwitch =
		new SensitivitySwitch<Adapter>() {
			@Override
			public Adapter caseSensitivityConfiguration(SensitivityConfiguration object) {
				return createSensitivityConfigurationAdapter();
			}
			@Override
			public Adapter caseSensitivityParameter(SensitivityParameter object) {
				return createSensitivityParameterAdapter();
			}
			@Override
			public Adapter caseCombinedSensitivityParameter(CombinedSensitivityParameter object) {
				return createCombinedSensitivityParameterAdapter();
			}
			@Override
			public Adapter caseSensitivityResultSpecification(SensitivityResultSpecification object) {
				return createSensitivityResultSpecificationAdapter();
			}
			@Override
			public Adapter caseSingleSensitivityParameter(SingleSensitivityParameter object) {
				return createSingleSensitivityParameterAdapter();
			}
			@Override
			public Adapter caseSensitivityParameterVariation(SensitivityParameterVariation object) {
				return createSensitivityParameterVariationAdapter();
			}
			@Override
			public Adapter caseComponentReliabilityParameter(ComponentReliabilityParameter object) {
				return createComponentReliabilityParameterAdapter();
			}
			@Override
			public Adapter caseDoubleParameterVariation(DoubleParameterVariation object) {
				return createDoubleParameterVariationAdapter();
			}
			@Override
			public Adapter caseStringParameterSequence(StringParameterSequence object) {
				return createStringParameterSequenceAdapter();
			}
			@Override
			public Adapter caseDoubleParameterRange(DoubleParameterRange object) {
				return createDoubleParameterRangeAdapter();
			}
			@Override
			public Adapter caseDoubleParameterSequence(DoubleParameterSequence object) {
				return createDoubleParameterSequenceAdapter();
			}
			@Override
			public Adapter caseDoubleParameterFunction(DoubleParameterFunction object) {
				return createDoubleParameterFunctionAdapter();
			}
			@Override
			public Adapter caseInternalActionReliabilityParameter(InternalActionReliabilityParameter object) {
				return createInternalActionReliabilityParameterAdapter();
			}
			@Override
			public Adapter caseProbabilisticBranchParameter(ProbabilisticBranchParameter object) {
				return createProbabilisticBranchParameterAdapter();
			}
			@Override
			public Adapter caseHardwareMTTFParameter(HardwareMTTFParameter object) {
				return createHardwareMTTFParameterAdapter();
			}
			@Override
			public Adapter caseHardwareMTTRParameter(HardwareMTTRParameter object) {
				return createHardwareMTTRParameterAdapter();
			}
			@Override
			public Adapter caseResourceMTTFParameter(ResourceMTTFParameter object) {
				return createResourceMTTFParameterAdapter();
			}
			@Override
			public Adapter caseResourceMTTRParameter(ResourceMTTRParameter object) {
				return createResourceMTTRParameterAdapter();
			}
			@Override
			public Adapter caseNetworkReliabilityParameter(NetworkReliabilityParameter object) {
				return createNetworkReliabilityParameterAdapter();
			}
			@Override
			public Adapter caseCommunicationLinkReliabilityParameter(CommunicationLinkReliabilityParameter object) {
				return createCommunicationLinkReliabilityParameterAdapter();
			}
			@Override
			public Adapter caseSoftwareReliabilityParameter(SoftwareReliabilityParameter object) {
				return createSoftwareReliabilityParameterAdapter();
			}
			@Override
			public Adapter caseVariableUsageParameter(VariableUsageParameter object) {
				return createVariableUsageParameterAdapter();
			}
			@Override
			public Adapter caseUsageBranchParameter(UsageBranchParameter object) {
				return createUsageBranchParameterAdapter();
			}
			@Override
			public Adapter caseDoubleOffsetSequence(DoubleOffsetSequence object) {
				return createDoubleOffsetSequenceAdapter();
			}
			@Override
			public Adapter caseSoftwareFailureTypesParameter(SoftwareFailureTypesParameter object) {
				return createSoftwareFailureTypesParameterAdapter();
			}
			@Override
			public Adapter caseFailureTypeResultSpecification(FailureTypeResultSpecification object) {
				return createFailureTypeResultSpecificationAdapter();
			}
			@Override
			public Adapter caseFailureDimensionResultSpecification(FailureDimensionResultSpecification object) {
				return createFailureDimensionResultSpecificationAdapter();
			}
			@Override
			public Adapter caseIdentifier(Identifier object) {
				return createIdentifierAdapter();
			}
			@Override
			public Adapter caseNamedElement(NamedElement object) {
				return createNamedElementAdapter();
			}
			@Override
			public Adapter caseEntity(Entity object) {
				return createEntityAdapter();
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
	 * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.sensitivity.SensitivityConfiguration <em>Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.uka.ipd.sdq.sensitivity.SensitivityConfiguration
	 * @generated
	 */
	public Adapter createSensitivityConfigurationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.sensitivity.SensitivityParameter <em>Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.uka.ipd.sdq.sensitivity.SensitivityParameter
	 * @generated
	 */
	public Adapter createSensitivityParameterAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.sensitivity.CombinedSensitivityParameter <em>Combined Sensitivity Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.uka.ipd.sdq.sensitivity.CombinedSensitivityParameter
	 * @generated
	 */
	public Adapter createCombinedSensitivityParameterAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.sensitivity.SensitivityResultSpecification <em>Result Specification</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.uka.ipd.sdq.sensitivity.SensitivityResultSpecification
	 * @generated
	 */
	public Adapter createSensitivityResultSpecificationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.sensitivity.SingleSensitivityParameter <em>Single Sensitivity Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.uka.ipd.sdq.sensitivity.SingleSensitivityParameter
	 * @generated
	 */
	public Adapter createSingleSensitivityParameterAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.sensitivity.SensitivityParameterVariation <em>Parameter Variation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.uka.ipd.sdq.sensitivity.SensitivityParameterVariation
	 * @generated
	 */
	public Adapter createSensitivityParameterVariationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.sensitivity.ComponentReliabilityParameter <em>Component Reliability Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.uka.ipd.sdq.sensitivity.ComponentReliabilityParameter
	 * @generated
	 */
	public Adapter createComponentReliabilityParameterAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.sensitivity.DoubleParameterVariation <em>Double Parameter Variation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.uka.ipd.sdq.sensitivity.DoubleParameterVariation
	 * @generated
	 */
	public Adapter createDoubleParameterVariationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.sensitivity.StringParameterSequence <em>String Parameter Sequence</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.uka.ipd.sdq.sensitivity.StringParameterSequence
	 * @generated
	 */
	public Adapter createStringParameterSequenceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.sensitivity.DoubleParameterRange <em>Double Parameter Range</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.uka.ipd.sdq.sensitivity.DoubleParameterRange
	 * @generated
	 */
	public Adapter createDoubleParameterRangeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.sensitivity.DoubleParameterSequence <em>Double Parameter Sequence</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.uka.ipd.sdq.sensitivity.DoubleParameterSequence
	 * @generated
	 */
	public Adapter createDoubleParameterSequenceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.sensitivity.DoubleParameterFunction <em>Double Parameter Function</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.uka.ipd.sdq.sensitivity.DoubleParameterFunction
	 * @generated
	 */
	public Adapter createDoubleParameterFunctionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.sensitivity.InternalActionReliabilityParameter <em>Internal Action Reliability Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.uka.ipd.sdq.sensitivity.InternalActionReliabilityParameter
	 * @generated
	 */
	public Adapter createInternalActionReliabilityParameterAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.sensitivity.ProbabilisticBranchParameter <em>Probabilistic Branch Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.uka.ipd.sdq.sensitivity.ProbabilisticBranchParameter
	 * @generated
	 */
	public Adapter createProbabilisticBranchParameterAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.sensitivity.HardwareMTTFParameter <em>Hardware MTTF Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.uka.ipd.sdq.sensitivity.HardwareMTTFParameter
	 * @generated
	 */
	public Adapter createHardwareMTTFParameterAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.sensitivity.HardwareMTTRParameter <em>Hardware MTTR Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.uka.ipd.sdq.sensitivity.HardwareMTTRParameter
	 * @generated
	 */
	public Adapter createHardwareMTTRParameterAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.sensitivity.ResourceMTTFParameter <em>Resource MTTF Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.uka.ipd.sdq.sensitivity.ResourceMTTFParameter
	 * @generated
	 */
	public Adapter createResourceMTTFParameterAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.sensitivity.ResourceMTTRParameter <em>Resource MTTR Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.uka.ipd.sdq.sensitivity.ResourceMTTRParameter
	 * @generated
	 */
	public Adapter createResourceMTTRParameterAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.sensitivity.NetworkReliabilityParameter <em>Network Reliability Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.uka.ipd.sdq.sensitivity.NetworkReliabilityParameter
	 * @generated
	 */
	public Adapter createNetworkReliabilityParameterAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.sensitivity.CommunicationLinkReliabilityParameter <em>Communication Link Reliability Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.uka.ipd.sdq.sensitivity.CommunicationLinkReliabilityParameter
	 * @generated
	 */
	public Adapter createCommunicationLinkReliabilityParameterAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.sensitivity.SoftwareReliabilityParameter <em>Software Reliability Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.uka.ipd.sdq.sensitivity.SoftwareReliabilityParameter
	 * @generated
	 */
	public Adapter createSoftwareReliabilityParameterAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.sensitivity.VariableUsageParameter <em>Variable Usage Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.uka.ipd.sdq.sensitivity.VariableUsageParameter
	 * @generated
	 */
	public Adapter createVariableUsageParameterAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.sensitivity.UsageBranchParameter <em>Usage Branch Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.uka.ipd.sdq.sensitivity.UsageBranchParameter
	 * @generated
	 */
	public Adapter createUsageBranchParameterAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.sensitivity.DoubleOffsetSequence <em>Double Offset Sequence</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.uka.ipd.sdq.sensitivity.DoubleOffsetSequence
	 * @generated
	 */
	public Adapter createDoubleOffsetSequenceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.sensitivity.SoftwareFailureTypesParameter <em>Software Failure Types Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.uka.ipd.sdq.sensitivity.SoftwareFailureTypesParameter
	 * @generated
	 */
	public Adapter createSoftwareFailureTypesParameterAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.sensitivity.FailureTypeResultSpecification <em>Failure Type Result Specification</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.uka.ipd.sdq.sensitivity.FailureTypeResultSpecification
	 * @generated
	 */
	public Adapter createFailureTypeResultSpecificationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.sensitivity.FailureDimensionResultSpecification <em>Failure Dimension Result Specification</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.uka.ipd.sdq.sensitivity.FailureDimensionResultSpecification
	 * @generated
	 */
	public Adapter createFailureDimensionResultSpecificationAdapter() {
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
	 * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.pcm.core.entity.NamedElement <em>Named Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.uka.ipd.sdq.pcm.core.entity.NamedElement
	 * @generated
	 */
	public Adapter createNamedElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.pcm.core.entity.Entity <em>Entity</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.uka.ipd.sdq.pcm.core.entity.Entity
	 * @generated
	 */
	public Adapter createEntityAdapter() {
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

} //SensitivityAdapterFactory
