/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.designdecision.util;

import de.uka.ipd.sdq.pcm.designdecision.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see de.uka.ipd.sdq.pcm.designdecision.designdecisionPackage
 * @generated
 */
public class designdecisionAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static designdecisionPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public designdecisionAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = designdecisionPackage.eINSTANCE;
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
	protected designdecisionSwitch<Adapter> modelSwitch =
		new designdecisionSwitch<Adapter>() {
			@Override
			public Adapter caseDegreeOfFreedomInstance(DegreeOfFreedomInstance object) {
				return createDegreeOfFreedomInstanceAdapter();
			}
			@Override
			public Adapter caseChoice(Choice object) {
				return createChoiceAdapter();
			}
			@Override
			public Adapter caseRangeDegree(RangeDegree object) {
				return createRangeDegreeAdapter();
			}
			@Override
			public Adapter caseDataTypeDegree(DataTypeDegree object) {
				return createDataTypeDegreeAdapter();
			}
			@Override
			public Adapter caseClassDegree(ClassDegree object) {
				return createClassDegreeAdapter();
			}
			@Override
			public Adapter caseClassChoice(ClassChoice object) {
				return createClassChoiceAdapter();
			}
			@Override
			public Adapter caseContinousRangeChoice(ContinousRangeChoice object) {
				return createContinousRangeChoiceAdapter();
			}
			@Override
			public Adapter caseContinuousProcessingRateDegree(ContinuousProcessingRateDegree object) {
				return createContinuousProcessingRateDegreeAdapter();
			}
			@Override
			public Adapter caseContinuousRangeDegree(ContinuousRangeDegree object) {
				return createContinuousRangeDegreeAdapter();
			}
			@Override
			public Adapter caseProcessingRateDegree(ProcessingRateDegree object) {
				return createProcessingRateDegreeAdapter();
			}
			@Override
			public Adapter caseProcessingResourceDegree(ProcessingResourceDegree object) {
				return createProcessingResourceDegreeAdapter();
			}
			@Override
			public Adapter caseAllocationDegree(AllocationDegree object) {
				return createAllocationDegreeAdapter();
			}
			@Override
			public Adapter caseClassAsReferenceDegree(ClassAsReferenceDegree object) {
				return createClassAsReferenceDegreeAdapter();
			}
			@Override
			public Adapter caseAssembledComponentDegree(AssembledComponentDegree object) {
				return createAssembledComponentDegreeAdapter();
			}
			@Override
			public Adapter caseDiscreteRangeDegree(DiscreteRangeDegree object) {
				return createDiscreteRangeDegreeAdapter();
			}
			@Override
			public Adapter caseDiscreteDegree(DiscreteDegree object) {
				return createDiscreteDegreeAdapter();
			}
			@Override
			public Adapter caseDiscreteRangeChoice(DiscreteRangeChoice object) {
				return createDiscreteRangeChoiceAdapter();
			}
			@Override
			public Adapter caseResourceContainerReplicationDegree(ResourceContainerReplicationDegree object) {
				return createResourceContainerReplicationDegreeAdapter();
			}
			@Override
			public Adapter caseDecisionSpace(DecisionSpace object) {
				return createDecisionSpaceAdapter();
			}
			@Override
			public Adapter caseCandidate(Candidate object) {
				return createCandidateAdapter();
			}
			@Override
			public Adapter caseCandidates(Candidates object) {
				return createCandidatesAdapter();
			}
			@Override
			public Adapter caseFeatureConfigDegree(FeatureConfigDegree object) {
				return createFeatureConfigDegreeAdapter();
			}
			@Override
			public Adapter caseFeatureGroupDegree(FeatureGroupDegree object) {
				return createFeatureGroupDegreeAdapter();
			}
			@Override
			public Adapter caseFeatureSubset(FeatureSubset object) {
				return createFeatureSubsetAdapter();
			}
			@Override
			public Adapter caseOptionalFeatureDegree(OptionalFeatureDegree object) {
				return createOptionalFeatureDegreeAdapter();
			}
			@Override
			public Adapter caseDiscreteProcessingRateDegree(DiscreteProcessingRateDegree object) {
				return createDiscreteProcessingRateDegreeAdapter();
			}
			@Override
			public Adapter caseCapacityDegree(CapacityDegree object) {
				return createCapacityDegreeAdapter();
			}
			@Override
			public Adapter caseSchedulingPolicyDegree(SchedulingPolicyDegree object) {
				return createSchedulingPolicyDegreeAdapter();
			}
			@Override
			public Adapter caseEnumDegree(EnumDegree object) {
				return createEnumDegreeAdapter();
			}
			@Override
			public Adapter caseUnorderedDegree(UnorderedDegree object) {
				return createUnorderedDegreeAdapter();
			}
			@Override
			public Adapter caseClassWithCopyDegree(ClassWithCopyDegree object) {
				return createClassWithCopyDegreeAdapter();
			}
			@Override
			public Adapter caseResourceSelectionDegree(ResourceSelectionDegree object) {
				return createResourceSelectionDegreeAdapter();
			}
			@Override
			public Adapter caseStringSetDegree(StringSetDegree object) {
				return createStringSetDegreeAdapter();
			}
			@Override
			public Adapter caseDiscreteComponentParamDegree(DiscreteComponentParamDegree object) {
				return createDiscreteComponentParamDegreeAdapter();
			}
			@Override
			public Adapter caseContinuousComponentParamDegree(ContinuousComponentParamDegree object) {
				return createContinuousComponentParamDegreeAdapter();
			}
			@Override
			public Adapter caseStringComponentParamDegree(StringComponentParamDegree object) {
				return createStringComponentParamDegreeAdapter();
			}
			@Override
			public Adapter caseUnorderedPrimitiveDegree(UnorderedPrimitiveDegree object) {
				return createUnorderedPrimitiveDegreeAdapter();
			}
			@Override
			public Adapter caseNumberOfCoresAsRangeDegree(NumberOfCoresAsRangeDegree object) {
				return createNumberOfCoresAsRangeDegreeAdapter();
			}
			@Override
			public Adapter caseNumberOfCoresDegree(NumberOfCoresDegree object) {
				return createNumberOfCoresDegreeAdapter();
			}
			@Override
			public Adapter caseResourceContainerReplicationDegreeWithComponentChange(ResourceContainerReplicationDegreeWithComponentChange object) {
				return createResourceContainerReplicationDegreeWithComponentChangeAdapter();
			}
			@Override
			public Adapter caseExchangeComponentRule(ExchangeComponentRule object) {
				return createExchangeComponentRuleAdapter();
			}
			@Override
			public Adapter caseOrderedDataTypeDegree(OrderedDataTypeDegree object) {
				return createOrderedDataTypeDegreeAdapter();
			}
			@Override
			public Adapter caseOrderedIntegerDegree(OrderedIntegerDegree object) {
				return createOrderedIntegerDegreeAdapter();
			}
			@Override
			public Adapter caseNumberOfCoresAsListDegree(NumberOfCoresAsListDegree object) {
				return createNumberOfCoresAsListDegreeAdapter();
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
	 * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.pcm.designdecision.DegreeOfFreedomInstance <em>Degree Of Freedom Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.uka.ipd.sdq.pcm.designdecision.DegreeOfFreedomInstance
	 * @generated
	 */
	public Adapter createDegreeOfFreedomInstanceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.pcm.designdecision.Choice <em>Choice</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.uka.ipd.sdq.pcm.designdecision.Choice
	 * @generated
	 */
	public Adapter createChoiceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.pcm.designdecision.RangeDegree <em>Range Degree</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.uka.ipd.sdq.pcm.designdecision.RangeDegree
	 * @generated
	 */
	public Adapter createRangeDegreeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.pcm.designdecision.DataTypeDegree <em>Data Type Degree</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.uka.ipd.sdq.pcm.designdecision.DataTypeDegree
	 * @generated
	 */
	public Adapter createDataTypeDegreeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.pcm.designdecision.ClassDegree <em>Class Degree</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.uka.ipd.sdq.pcm.designdecision.ClassDegree
	 * @generated
	 */
	public Adapter createClassDegreeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.pcm.designdecision.ClassChoice <em>Class Choice</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.uka.ipd.sdq.pcm.designdecision.ClassChoice
	 * @generated
	 */
	public Adapter createClassChoiceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.pcm.designdecision.ContinousRangeChoice <em>Continous Range Choice</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.uka.ipd.sdq.pcm.designdecision.ContinousRangeChoice
	 * @generated
	 */
	public Adapter createContinousRangeChoiceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.pcm.designdecision.ContinuousProcessingRateDegree <em>Continuous Processing Rate Degree</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.uka.ipd.sdq.pcm.designdecision.ContinuousProcessingRateDegree
	 * @generated
	 */
	public Adapter createContinuousProcessingRateDegreeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.pcm.designdecision.ContinuousRangeDegree <em>Continuous Range Degree</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.uka.ipd.sdq.pcm.designdecision.ContinuousRangeDegree
	 * @generated
	 */
	public Adapter createContinuousRangeDegreeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.pcm.designdecision.ProcessingRateDegree <em>Processing Rate Degree</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.uka.ipd.sdq.pcm.designdecision.ProcessingRateDegree
	 * @generated
	 */
	public Adapter createProcessingRateDegreeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.pcm.designdecision.ProcessingResourceDegree <em>Processing Resource Degree</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.uka.ipd.sdq.pcm.designdecision.ProcessingResourceDegree
	 * @generated
	 */
	public Adapter createProcessingResourceDegreeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.pcm.designdecision.AllocationDegree <em>Allocation Degree</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.uka.ipd.sdq.pcm.designdecision.AllocationDegree
	 * @generated
	 */
	public Adapter createAllocationDegreeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.pcm.designdecision.ClassAsReferenceDegree <em>Class As Reference Degree</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.uka.ipd.sdq.pcm.designdecision.ClassAsReferenceDegree
	 * @generated
	 */
	public Adapter createClassAsReferenceDegreeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.pcm.designdecision.AssembledComponentDegree <em>Assembled Component Degree</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.uka.ipd.sdq.pcm.designdecision.AssembledComponentDegree
	 * @generated
	 */
	public Adapter createAssembledComponentDegreeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.pcm.designdecision.DiscreteRangeDegree <em>Discrete Range Degree</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.uka.ipd.sdq.pcm.designdecision.DiscreteRangeDegree
	 * @generated
	 */
	public Adapter createDiscreteRangeDegreeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.pcm.designdecision.DiscreteDegree <em>Discrete Degree</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.uka.ipd.sdq.pcm.designdecision.DiscreteDegree
	 * @generated
	 */
	public Adapter createDiscreteDegreeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.pcm.designdecision.DiscreteRangeChoice <em>Discrete Range Choice</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.uka.ipd.sdq.pcm.designdecision.DiscreteRangeChoice
	 * @generated
	 */
	public Adapter createDiscreteRangeChoiceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.pcm.designdecision.ResourceContainerReplicationDegree <em>Resource Container Replication Degree</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.uka.ipd.sdq.pcm.designdecision.ResourceContainerReplicationDegree
	 * @generated
	 */
	public Adapter createResourceContainerReplicationDegreeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.pcm.designdecision.DecisionSpace <em>Decision Space</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.uka.ipd.sdq.pcm.designdecision.DecisionSpace
	 * @generated
	 */
	public Adapter createDecisionSpaceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.pcm.designdecision.Candidate <em>Candidate</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.uka.ipd.sdq.pcm.designdecision.Candidate
	 * @generated
	 */
	public Adapter createCandidateAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.pcm.designdecision.Candidates <em>Candidates</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.uka.ipd.sdq.pcm.designdecision.Candidates
	 * @generated
	 */
	public Adapter createCandidatesAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.pcm.designdecision.FeatureConfigDegree <em>Feature Config Degree</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.uka.ipd.sdq.pcm.designdecision.FeatureConfigDegree
	 * @generated
	 */
	public Adapter createFeatureConfigDegreeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.pcm.designdecision.FeatureGroupDegree <em>Feature Group Degree</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.uka.ipd.sdq.pcm.designdecision.FeatureGroupDegree
	 * @generated
	 */
	public Adapter createFeatureGroupDegreeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.pcm.designdecision.FeatureSubset <em>Feature Subset</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.uka.ipd.sdq.pcm.designdecision.FeatureSubset
	 * @generated
	 */
	public Adapter createFeatureSubsetAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.pcm.designdecision.OptionalFeatureDegree <em>Optional Feature Degree</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.uka.ipd.sdq.pcm.designdecision.OptionalFeatureDegree
	 * @generated
	 */
	public Adapter createOptionalFeatureDegreeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.pcm.designdecision.DiscreteProcessingRateDegree <em>Discrete Processing Rate Degree</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.uka.ipd.sdq.pcm.designdecision.DiscreteProcessingRateDegree
	 * @generated
	 */
	public Adapter createDiscreteProcessingRateDegreeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.pcm.designdecision.CapacityDegree <em>Capacity Degree</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.uka.ipd.sdq.pcm.designdecision.CapacityDegree
	 * @generated
	 */
	public Adapter createCapacityDegreeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.pcm.designdecision.SchedulingPolicyDegree <em>Scheduling Policy Degree</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.uka.ipd.sdq.pcm.designdecision.SchedulingPolicyDegree
	 * @generated
	 */
	public Adapter createSchedulingPolicyDegreeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.pcm.designdecision.EnumDegree <em>Enum Degree</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.uka.ipd.sdq.pcm.designdecision.EnumDegree
	 * @generated
	 */
	public Adapter createEnumDegreeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.pcm.designdecision.UnorderedDegree <em>Unordered Degree</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.uka.ipd.sdq.pcm.designdecision.UnorderedDegree
	 * @generated
	 */
	public Adapter createUnorderedDegreeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.pcm.designdecision.ClassWithCopyDegree <em>Class With Copy Degree</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.uka.ipd.sdq.pcm.designdecision.ClassWithCopyDegree
	 * @generated
	 */
	public Adapter createClassWithCopyDegreeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.pcm.designdecision.ResourceSelectionDegree <em>Resource Selection Degree</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.uka.ipd.sdq.pcm.designdecision.ResourceSelectionDegree
	 * @generated
	 */
	public Adapter createResourceSelectionDegreeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.pcm.designdecision.StringSetDegree <em>String Set Degree</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.uka.ipd.sdq.pcm.designdecision.StringSetDegree
	 * @generated
	 */
	public Adapter createStringSetDegreeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.pcm.designdecision.DiscreteComponentParamDegree <em>Discrete Component Param Degree</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.uka.ipd.sdq.pcm.designdecision.DiscreteComponentParamDegree
	 * @generated
	 */
	public Adapter createDiscreteComponentParamDegreeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.pcm.designdecision.ContinuousComponentParamDegree <em>Continuous Component Param Degree</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.uka.ipd.sdq.pcm.designdecision.ContinuousComponentParamDegree
	 * @generated
	 */
	public Adapter createContinuousComponentParamDegreeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.pcm.designdecision.StringComponentParamDegree <em>String Component Param Degree</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.uka.ipd.sdq.pcm.designdecision.StringComponentParamDegree
	 * @generated
	 */
	public Adapter createStringComponentParamDegreeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.pcm.designdecision.UnorderedPrimitiveDegree <em>Unordered Primitive Degree</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.uka.ipd.sdq.pcm.designdecision.UnorderedPrimitiveDegree
	 * @generated
	 */
	public Adapter createUnorderedPrimitiveDegreeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.pcm.designdecision.NumberOfCoresAsRangeDegree <em>Number Of Cores As Range Degree</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.uka.ipd.sdq.pcm.designdecision.NumberOfCoresAsRangeDegree
	 * @generated
	 */
	public Adapter createNumberOfCoresAsRangeDegreeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.pcm.designdecision.NumberOfCoresDegree <em>Number Of Cores Degree</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.uka.ipd.sdq.pcm.designdecision.NumberOfCoresDegree
	 * @generated
	 */
	public Adapter createNumberOfCoresDegreeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.pcm.designdecision.ResourceContainerReplicationDegreeWithComponentChange <em>Resource Container Replication Degree With Component Change</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.uka.ipd.sdq.pcm.designdecision.ResourceContainerReplicationDegreeWithComponentChange
	 * @generated
	 */
	public Adapter createResourceContainerReplicationDegreeWithComponentChangeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.pcm.designdecision.ExchangeComponentRule <em>Exchange Component Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.uka.ipd.sdq.pcm.designdecision.ExchangeComponentRule
	 * @generated
	 */
	public Adapter createExchangeComponentRuleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.pcm.designdecision.OrderedDataTypeDegree <em>Ordered Data Type Degree</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.uka.ipd.sdq.pcm.designdecision.OrderedDataTypeDegree
	 * @generated
	 */
	public Adapter createOrderedDataTypeDegreeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.pcm.designdecision.OrderedIntegerDegree <em>Ordered Integer Degree</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.uka.ipd.sdq.pcm.designdecision.OrderedIntegerDegree
	 * @generated
	 */
	public Adapter createOrderedIntegerDegreeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.pcm.designdecision.NumberOfCoresAsListDegree <em>Number Of Cores As List Degree</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.uka.ipd.sdq.pcm.designdecision.NumberOfCoresAsListDegree
	 * @generated
	 */
	public Adapter createNumberOfCoresAsListDegreeAdapter() {
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

} //designdecisionAdapterFactory
