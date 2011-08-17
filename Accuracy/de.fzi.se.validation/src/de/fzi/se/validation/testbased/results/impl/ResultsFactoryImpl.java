/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.fzi.se.validation.testbased.results.impl;

import de.fzi.se.validation.testbased.results.*;

import org.eclipse.emf.ecore.EClass;
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
public class ResultsFactoryImpl extends EFactoryImpl implements ResultsFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ResultsFactory init() {
		try {
			ResultsFactory theResultsFactory = (ResultsFactory)EPackage.Registry.INSTANCE.getEFactory("http://fzi.de/PalladioComponentModel/Validation/TestBased/Results/0.2"); 
			if (theResultsFactory != null) {
				return theResultsFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new ResultsFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResultsFactoryImpl() {
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
			case ResultsPackage.PARAMETER_VFN: return createParameterVFN();
			case ResultsPackage.INFRASTRUCTURE_CALL_VFN: return createInfrastructureCallVFN();
			case ResultsPackage.EXTERNAL_CALL_VFN: return createExternalCallVFN();
			case ResultsPackage.EXECUTION_TRACE_VFN: return createExecutionTraceVFN();
			case ResultsPackage.RUN_PROTOCOL: return createRunProtocol();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ParameterVFN createParameterVFN() {
		ParameterVFNImpl parameterVFN = new ParameterVFNImpl();
		return parameterVFN;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InfrastructureCallVFN createInfrastructureCallVFN() {
		InfrastructureCallVFNImpl infrastructureCallVFN = new InfrastructureCallVFNImpl();
		return infrastructureCallVFN;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExternalCallVFN createExternalCallVFN() {
		ExternalCallVFNImpl externalCallVFN = new ExternalCallVFNImpl();
		return externalCallVFN;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExecutionTraceVFN createExecutionTraceVFN() {
		ExecutionTraceVFNImpl executionTraceVFN = new ExecutionTraceVFNImpl();
		return executionTraceVFN;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RunProtocol createRunProtocol() {
		RunProtocolImpl runProtocol = new RunProtocolImpl();
		return runProtocol;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResultsPackage getResultsPackage() {
		return (ResultsPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static ResultsPackage getPackage() {
		return ResultsPackage.eINSTANCE;
	}

} //ResultsFactoryImpl
