/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package scheduler.configuration.util;

import de.uka.ipd.sdq.identifier.Identifier;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import scheduler.configuration.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see scheduler.configuration.ConfigurationPackage
 * @generated
 */
public class ConfigurationAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static ConfigurationPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConfigurationAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = ConfigurationPackage.eINSTANCE;
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
	protected ConfigurationSwitch<Adapter> modelSwitch =
		new ConfigurationSwitch<Adapter>() {
			@Override
			public Adapter caseDynamicPriorityBoostConfiguratioin(DynamicPriorityBoostConfiguratioin object) {
				return createDynamicPriorityBoostConfiguratioinAdapter();
			}
			@Override
			public Adapter casePriorityBoostConfiguration(PriorityBoostConfiguration object) {
				return createPriorityBoostConfigurationAdapter();
			}
			@Override
			public Adapter caseLoadBalancing(LoadBalancing object) {
				return createLoadBalancingAdapter();
			}
			@Override
			public Adapter caseMultipleQueueConfiguration(MultipleQueueConfiguration object) {
				return createMultipleQueueConfigurationAdapter();
			}
			@Override
			public Adapter caseQueueingConfiguration(QueueingConfiguration object) {
				return createQueueingConfigurationAdapter();
			}
			@Override
			public Adapter caseQuantumTimeSliceConfiguration(QuantumTimeSliceConfiguration object) {
				return createQuantumTimeSliceConfigurationAdapter();
			}
			@Override
			public Adapter caseTimeSliceConfiguration(TimeSliceConfiguration object) {
				return createTimeSliceConfigurationAdapter();
			}
			@Override
			public Adapter casePreemptionConfiguration(PreemptionConfiguration object) {
				return createPreemptionConfigurationAdapter();
			}
			@Override
			public Adapter casePriorityConfiguration(PriorityConfiguration object) {
				return createPriorityConfigurationAdapter();
			}
			@Override
			public Adapter casePriorityRange(PriorityRange object) {
				return createPriorityRangeAdapter();
			}
			@Override
			public Adapter casePriorityDependentTimeSliceConfiguration(PriorityDependentTimeSliceConfiguration object) {
				return createPriorityDependentTimeSliceConfigurationAdapter();
			}
			@Override
			public Adapter caseActiveResourceConfiguration(ActiveResourceConfiguration object) {
				return createActiveResourceConfigurationAdapter();
			}
			@Override
			public Adapter casePassiveResourceConfiguration(PassiveResourceConfiguration object) {
				return createPassiveResourceConfigurationAdapter();
			}
			@Override
			public Adapter caseStaticPriorityBoost(StaticPriorityBoost object) {
				return createStaticPriorityBoostAdapter();
			}
			@Override
			public Adapter caseProcessConfiguration(ProcessConfiguration object) {
				return createProcessConfigurationAdapter();
			}
			@Override
			public Adapter caseSingleQueueConfiguration(SingleQueueConfiguration object) {
				return createSingleQueueConfigurationAdapter();
			}
			@Override
			public Adapter caseStaticPriorityBoostConfiguration(StaticPriorityBoostConfiguration object) {
				return createStaticPriorityBoostConfigurationAdapter();
			}
			@Override
			public Adapter caseSchedulerConfiguration(SchedulerConfiguration object) {
				return createSchedulerConfigurationAdapter();
			}
			@Override
			public Adapter caseStarvationBoost(StarvationBoost object) {
				return createStarvationBoostAdapter();
			}
			@Override
			public Adapter caseIdentifier(Identifier object) {
				return createIdentifierAdapter();
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
	 * Creates a new adapter for an object of class '{@link scheduler.configuration.DynamicPriorityBoostConfiguratioin <em>Dynamic Priority Boost Configuratioin</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see scheduler.configuration.DynamicPriorityBoostConfiguratioin
	 * @generated
	 */
	public Adapter createDynamicPriorityBoostConfiguratioinAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link scheduler.configuration.PriorityBoostConfiguration <em>Priority Boost Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see scheduler.configuration.PriorityBoostConfiguration
	 * @generated
	 */
	public Adapter createPriorityBoostConfigurationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link scheduler.configuration.LoadBalancing <em>Load Balancing</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see scheduler.configuration.LoadBalancing
	 * @generated
	 */
	public Adapter createLoadBalancingAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link scheduler.configuration.MultipleQueueConfiguration <em>Multiple Queue Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see scheduler.configuration.MultipleQueueConfiguration
	 * @generated
	 */
	public Adapter createMultipleQueueConfigurationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link scheduler.configuration.QueueingConfiguration <em>Queueing Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see scheduler.configuration.QueueingConfiguration
	 * @generated
	 */
	public Adapter createQueueingConfigurationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link scheduler.configuration.QuantumTimeSliceConfiguration <em>Quantum Time Slice Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see scheduler.configuration.QuantumTimeSliceConfiguration
	 * @generated
	 */
	public Adapter createQuantumTimeSliceConfigurationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link scheduler.configuration.TimeSliceConfiguration <em>Time Slice Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see scheduler.configuration.TimeSliceConfiguration
	 * @generated
	 */
	public Adapter createTimeSliceConfigurationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link scheduler.configuration.PreemptionConfiguration <em>Preemption Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see scheduler.configuration.PreemptionConfiguration
	 * @generated
	 */
	public Adapter createPreemptionConfigurationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link scheduler.configuration.PriorityConfiguration <em>Priority Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see scheduler.configuration.PriorityConfiguration
	 * @generated
	 */
	public Adapter createPriorityConfigurationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link scheduler.configuration.PriorityRange <em>Priority Range</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see scheduler.configuration.PriorityRange
	 * @generated
	 */
	public Adapter createPriorityRangeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link scheduler.configuration.PriorityDependentTimeSliceConfiguration <em>Priority Dependent Time Slice Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see scheduler.configuration.PriorityDependentTimeSliceConfiguration
	 * @generated
	 */
	public Adapter createPriorityDependentTimeSliceConfigurationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link scheduler.configuration.ActiveResourceConfiguration <em>Active Resource Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see scheduler.configuration.ActiveResourceConfiguration
	 * @generated
	 */
	public Adapter createActiveResourceConfigurationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link scheduler.configuration.PassiveResourceConfiguration <em>Passive Resource Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see scheduler.configuration.PassiveResourceConfiguration
	 * @generated
	 */
	public Adapter createPassiveResourceConfigurationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link scheduler.configuration.StaticPriorityBoost <em>Static Priority Boost</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see scheduler.configuration.StaticPriorityBoost
	 * @generated
	 */
	public Adapter createStaticPriorityBoostAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link scheduler.configuration.ProcessConfiguration <em>Process Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see scheduler.configuration.ProcessConfiguration
	 * @generated
	 */
	public Adapter createProcessConfigurationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link scheduler.configuration.SingleQueueConfiguration <em>Single Queue Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see scheduler.configuration.SingleQueueConfiguration
	 * @generated
	 */
	public Adapter createSingleQueueConfigurationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link scheduler.configuration.StaticPriorityBoostConfiguration <em>Static Priority Boost Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see scheduler.configuration.StaticPriorityBoostConfiguration
	 * @generated
	 */
	public Adapter createStaticPriorityBoostConfigurationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link scheduler.configuration.SchedulerConfiguration <em>Scheduler Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see scheduler.configuration.SchedulerConfiguration
	 * @generated
	 */
	public Adapter createSchedulerConfigurationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link scheduler.configuration.StarvationBoost <em>Starvation Boost</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see scheduler.configuration.StarvationBoost
	 * @generated
	 */
	public Adapter createStarvationBoostAdapter() {
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

} //ConfigurationAdapterFactory
