/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.capra.schedulers.impl;

import de.uka.ipd.sdq.capra.schedulers.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class SchedulersFactoryImpl extends EFactoryImpl implements SchedulersFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static SchedulersFactory init() {
		try {
			SchedulersFactory theSchedulersFactory = (SchedulersFactory)EPackage.Registry.INSTANCE.getEFactory("http://sdq.ipd.uka.de/Capra/Schedulers/1.0"); 
			if (theSchedulersFactory != null) {
				return theSchedulersFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new SchedulersFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SchedulersFactoryImpl() {
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
			case SchedulersPackage.TIME_CONSUMPTION: return createTimeConsumption();
			case SchedulersPackage.NON_PREEMPTIVE: return createNonPreemptive();
			case SchedulersPackage.PREEMPTIVE: return createPreemptive();
			case SchedulersPackage.QUANTUM: return createQuantum();
			case SchedulersPackage.WAITING_TIME: return createWaitingTime();
			case SchedulersPackage.PRIORITY: return createPriority();
			case SchedulersPackage.PRIORTY_QUANTUMS: return createPriortyQuantums();
			case SchedulersPackage.SCHEDULER: return createScheduler();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case SchedulersPackage.LOAD_BALANCING:
				return createLoadBalancingFromString(eDataType, initialValue);
			case SchedulersPackage.BIG_OCLASS:
				return createBigOClassFromString(eDataType, initialValue);
			case SchedulersPackage.PREFERENCE:
				return createPreferenceFromString(eDataType, initialValue);
			case SchedulersPackage.PRIORITY_TYPE:
				return createPriorityTypeFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case SchedulersPackage.LOAD_BALANCING:
				return convertLoadBalancingToString(eDataType, instanceValue);
			case SchedulersPackage.BIG_OCLASS:
				return convertBigOClassToString(eDataType, instanceValue);
			case SchedulersPackage.PREFERENCE:
				return convertPreferenceToString(eDataType, instanceValue);
			case SchedulersPackage.PRIORITY_TYPE:
				return convertPriorityTypeToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TimeConsumption createTimeConsumption() {
		TimeConsumptionImpl timeConsumption = new TimeConsumptionImpl();
		return timeConsumption;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NonPreemptive createNonPreemptive() {
		NonPreemptiveImpl nonPreemptive = new NonPreemptiveImpl();
		return nonPreemptive;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Preemptive createPreemptive() {
		PreemptiveImpl preemptive = new PreemptiveImpl();
		return preemptive;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Quantum createQuantum() {
		QuantumImpl quantum = new QuantumImpl();
		return quantum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public WaitingTime createWaitingTime() {
		WaitingTimeImpl waitingTime = new WaitingTimeImpl();
		return waitingTime;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Priority createPriority() {
		PriorityImpl priority = new PriorityImpl();
		return priority;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PriortyQuantums createPriortyQuantums() {
		PriortyQuantumsImpl priortyQuantums = new PriortyQuantumsImpl();
		return priortyQuantums;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Scheduler createScheduler() {
		SchedulerImpl scheduler = new SchedulerImpl();
		return scheduler;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LoadBalancing createLoadBalancingFromString(EDataType eDataType, String initialValue) {
		LoadBalancing result = LoadBalancing.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertLoadBalancingToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BigOClass createBigOClassFromString(EDataType eDataType, String initialValue) {
		BigOClass result = BigOClass.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertBigOClassToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Preference createPreferenceFromString(EDataType eDataType, String initialValue) {
		Preference result = Preference.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertPreferenceToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PriorityType createPriorityTypeFromString(EDataType eDataType, String initialValue) {
		PriorityType result = PriorityType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertPriorityTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SchedulersPackage getSchedulersPackage() {
		return (SchedulersPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static SchedulersPackage getPackage() {
		return SchedulersPackage.eINSTANCE;
	}

} //SchedulersFactoryImpl
