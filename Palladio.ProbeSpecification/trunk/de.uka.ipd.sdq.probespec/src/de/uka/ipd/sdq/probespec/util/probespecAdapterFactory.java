/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.probespec.util;

import de.uka.ipd.sdq.identifier.Identifier;

import de.uka.ipd.sdq.probespec.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see de.uka.ipd.sdq.probespec.probespecPackage
 * @generated
 */
public class probespecAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static probespecPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public probespecAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = probespecPackage.eINSTANCE;
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
	protected probespecSwitch<Adapter> modelSwitch =
		new probespecSwitch<Adapter>() {
			@Override
			public Adapter caseCalculator(Calculator object) {
				return createCalculatorAdapter();
			}
			@Override
			public Adapter casePassiveResourceCalculator(PassiveResourceCalculator object) {
				return createPassiveResourceCalculatorAdapter();
			}
			@Override
			public Adapter caseUnaryCalculator(UnaryCalculator object) {
				return createUnaryCalculatorAdapter();
			}
			@Override
			public Adapter caseProbeSet(ProbeSet object) {
				return createProbeSetAdapter();
			}
			@Override
			public Adapter caseProbe(Probe object) {
				return createProbeAdapter();
			}
			@Override
			public Adapter casePassiveResourceStateProbe(PassiveResourceStateProbe object) {
				return createPassiveResourceStateProbeAdapter();
			}
			@Override
			public Adapter caseStoExProbe(StoExProbe object) {
				return createStoExProbeAdapter();
			}
			@Override
			public Adapter caseSEFFParameterProbe(SEFFParameterProbe object) {
				return createSEFFParameterProbeAdapter();
			}
			@Override
			public Adapter caseCurrentTimeProbe(CurrentTimeProbe object) {
				return createCurrentTimeProbeAdapter();
			}
			@Override
			public Adapter caseStoExCalculator(StoExCalculator object) {
				return createStoExCalculatorAdapter();
			}
			@Override
			public Adapter caseSEFFParameterCalculator(SEFFParameterCalculator object) {
				return createSEFFParameterCalculatorAdapter();
			}
			@Override
			public Adapter caseResponseTimeCalculator(ResponseTimeCalculator object) {
				return createResponseTimeCalculatorAdapter();
			}
			@Override
			public Adapter caseBinaryCalculator(BinaryCalculator object) {
				return createBinaryCalculatorAdapter();
			}
			@Override
			public Adapter caseWaitingTimeCalculator(WaitingTimeCalculator object) {
				return createWaitingTimeCalculatorAdapter();
			}
			@Override
			public Adapter caseProbeSpecRepository(ProbeSpecRepository object) {
				return createProbeSpecRepositoryAdapter();
			}
			@Override
			public Adapter caseCPUStateProbe(CPUStateProbe object) {
				return createCPUStateProbeAdapter();
			}
			@Override
			public Adapter caseHDDStateProbe(HDDStateProbe object) {
				return createHDDStateProbeAdapter();
			}
			@Override
			public Adapter caseCPUDemandProbe(CPUDemandProbe object) {
				return createCPUDemandProbeAdapter();
			}
			@Override
			public Adapter caseHDDDemandProbe(HDDDemandProbe object) {
				return createHDDDemandProbeAdapter();
			}
			@Override
			public Adapter caseHDDStateCalculator(HDDStateCalculator object) {
				return createHDDStateCalculatorAdapter();
			}
			@Override
			public Adapter caseCPUStateCalculator(CPUStateCalculator object) {
				return createCPUStateCalculatorAdapter();
			}
			@Override
			public Adapter caseCPUDemandCalculator(CPUDemandCalculator object) {
				return createCPUDemandCalculatorAdapter();
			}
			@Override
			public Adapter caseHDDDemandCalculator(HDDDemandCalculator object) {
				return createHDDDemandCalculatorAdapter();
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
	 * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.probespec.Calculator <em>Calculator</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.uka.ipd.sdq.probespec.Calculator
	 * @generated
	 */
	public Adapter createCalculatorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.probespec.PassiveResourceCalculator <em>Passive Resource Calculator</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.uka.ipd.sdq.probespec.PassiveResourceCalculator
	 * @generated
	 */
	public Adapter createPassiveResourceCalculatorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.probespec.UnaryCalculator <em>Unary Calculator</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.uka.ipd.sdq.probespec.UnaryCalculator
	 * @generated
	 */
	public Adapter createUnaryCalculatorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.probespec.ProbeSet <em>Probe Set</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.uka.ipd.sdq.probespec.ProbeSet
	 * @generated
	 */
	public Adapter createProbeSetAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.probespec.Probe <em>Probe</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.uka.ipd.sdq.probespec.Probe
	 * @generated
	 */
	public Adapter createProbeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.probespec.PassiveResourceStateProbe <em>Passive Resource State Probe</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.uka.ipd.sdq.probespec.PassiveResourceStateProbe
	 * @generated
	 */
	public Adapter createPassiveResourceStateProbeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.probespec.StoExProbe <em>Sto Ex Probe</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.uka.ipd.sdq.probespec.StoExProbe
	 * @generated
	 */
	public Adapter createStoExProbeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.probespec.SEFFParameterProbe <em>SEFF Parameter Probe</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.uka.ipd.sdq.probespec.SEFFParameterProbe
	 * @generated
	 */
	public Adapter createSEFFParameterProbeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.probespec.CurrentTimeProbe <em>Current Time Probe</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.uka.ipd.sdq.probespec.CurrentTimeProbe
	 * @generated
	 */
	public Adapter createCurrentTimeProbeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.probespec.StoExCalculator <em>Sto Ex Calculator</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.uka.ipd.sdq.probespec.StoExCalculator
	 * @generated
	 */
	public Adapter createStoExCalculatorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.probespec.SEFFParameterCalculator <em>SEFF Parameter Calculator</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.uka.ipd.sdq.probespec.SEFFParameterCalculator
	 * @generated
	 */
	public Adapter createSEFFParameterCalculatorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.probespec.ResponseTimeCalculator <em>Response Time Calculator</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.uka.ipd.sdq.probespec.ResponseTimeCalculator
	 * @generated
	 */
	public Adapter createResponseTimeCalculatorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.probespec.BinaryCalculator <em>Binary Calculator</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.uka.ipd.sdq.probespec.BinaryCalculator
	 * @generated
	 */
	public Adapter createBinaryCalculatorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.probespec.WaitingTimeCalculator <em>Waiting Time Calculator</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.uka.ipd.sdq.probespec.WaitingTimeCalculator
	 * @generated
	 */
	public Adapter createWaitingTimeCalculatorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.probespec.ProbeSpecRepository <em>Probe Spec Repository</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.uka.ipd.sdq.probespec.ProbeSpecRepository
	 * @generated
	 */
	public Adapter createProbeSpecRepositoryAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.probespec.CPUStateProbe <em>CPU State Probe</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.uka.ipd.sdq.probespec.CPUStateProbe
	 * @generated
	 */
	public Adapter createCPUStateProbeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.probespec.HDDStateProbe <em>HDD State Probe</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.uka.ipd.sdq.probespec.HDDStateProbe
	 * @generated
	 */
	public Adapter createHDDStateProbeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.probespec.CPUDemandProbe <em>CPU Demand Probe</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.uka.ipd.sdq.probespec.CPUDemandProbe
	 * @generated
	 */
	public Adapter createCPUDemandProbeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.probespec.HDDDemandProbe <em>HDD Demand Probe</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.uka.ipd.sdq.probespec.HDDDemandProbe
	 * @generated
	 */
	public Adapter createHDDDemandProbeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.probespec.HDDStateCalculator <em>HDD State Calculator</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.uka.ipd.sdq.probespec.HDDStateCalculator
	 * @generated
	 */
	public Adapter createHDDStateCalculatorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.probespec.CPUStateCalculator <em>CPU State Calculator</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.uka.ipd.sdq.probespec.CPUStateCalculator
	 * @generated
	 */
	public Adapter createCPUStateCalculatorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.probespec.CPUDemandCalculator <em>CPU Demand Calculator</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.uka.ipd.sdq.probespec.CPUDemandCalculator
	 * @generated
	 */
	public Adapter createCPUDemandCalculatorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.probespec.HDDDemandCalculator <em>HDD Demand Calculator</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.uka.ipd.sdq.probespec.HDDDemandCalculator
	 * @generated
	 */
	public Adapter createHDDDemandCalculatorAdapter() {
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

} //probespecAdapterFactory
