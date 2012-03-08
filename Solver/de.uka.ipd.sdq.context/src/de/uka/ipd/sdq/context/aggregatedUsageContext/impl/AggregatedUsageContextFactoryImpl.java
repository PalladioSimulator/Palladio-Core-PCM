/**
 * Copyright 2006, SDQ Group, University Karlsruhe (TH)
 *
 * $Id$
 */
package de.uka.ipd.sdq.context.aggregatedUsageContext.impl;

import de.uka.ipd.sdq.context.aggregatedUsageContext.*;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;

import de.uka.ipd.sdq.context.aggregatedUsageContext.AggregatedCommunication;
import de.uka.ipd.sdq.context.aggregatedUsageContext.AggregatedResourceDemand;
import de.uka.ipd.sdq.context.aggregatedUsageContext.AggregatedUsageContextFactory;
import de.uka.ipd.sdq.context.aggregatedUsageContext.AggregatedUsageContextPackage;
import de.uka.ipd.sdq.context.aggregatedUsageContext.ComputedAggregatedUsage;
import de.uka.ipd.sdq.context.aggregatedUsageContext.ServiceExecutionContext;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class AggregatedUsageContextFactoryImpl extends EFactoryImpl implements AggregatedUsageContextFactory {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright 2006, SDQ Group, University Karlsruhe (TH)";

	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static AggregatedUsageContextFactory init() {
		try {
			AggregatedUsageContextFactory theAggregatedUsageContextFactory = (AggregatedUsageContextFactory)EPackage.Registry.INSTANCE.getEFactory("http:///context/aggregatedUsageContext.ecore"); 
			if (theAggregatedUsageContextFactory != null) {
				return theAggregatedUsageContextFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new AggregatedUsageContextFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AggregatedUsageContextFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case AggregatedUsageContextPackage.SERVICE_EXECUTION_CONTEXT: return createServiceExecutionContext();
			case AggregatedUsageContextPackage.AGGREGATED_RESOURCE_DEMAND: return createAggregatedResourceDemand();
			case AggregatedUsageContextPackage.AGGREGATED_COMMUNICATION: return createAggregatedCommunication();
			case AggregatedUsageContextPackage.COMPUTED_AGGREGATED_USAGE: return createComputedAggregatedUsage();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ServiceExecutionContext createServiceExecutionContext() {
		ServiceExecutionContextImpl serviceExecutionContext = new ServiceExecutionContextImpl();
		return serviceExecutionContext;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AggregatedResourceDemand createAggregatedResourceDemand() {
		AggregatedResourceDemandImpl aggregatedResourceDemand = new AggregatedResourceDemandImpl();
		return aggregatedResourceDemand;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AggregatedCommunication createAggregatedCommunication() {
		AggregatedCommunicationImpl aggregatedCommunication = new AggregatedCommunicationImpl();
		return aggregatedCommunication;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComputedAggregatedUsage createComputedAggregatedUsage() {
		ComputedAggregatedUsageImpl computedAggregatedUsage = new ComputedAggregatedUsageImpl();
		return computedAggregatedUsage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AggregatedUsageContextPackage getAggregatedUsageContextPackage() {
		return (AggregatedUsageContextPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static AggregatedUsageContextPackage getPackage() {
		return AggregatedUsageContextPackage.eINSTANCE;
	}

} //AggregatedUsageContextFactoryImpl
