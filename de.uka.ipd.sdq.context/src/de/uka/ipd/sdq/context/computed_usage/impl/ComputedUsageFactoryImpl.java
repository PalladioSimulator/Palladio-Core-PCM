/**
 * Copyright 2006, SDQ Group, University Karlsruhe (TH)
 *
 * $Id$
 */
package de.uka.ipd.sdq.context.computed_usage.impl;

import de.uka.ipd.sdq.context.computed_usage.*;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;

import de.uka.ipd.sdq.context.computed_usage.BranchProbability;
import de.uka.ipd.sdq.context.computed_usage.ComputedUsage;
import de.uka.ipd.sdq.context.computed_usage.ComputedUsageContext;
import de.uka.ipd.sdq.context.computed_usage.ComputedUsageFactory;
import de.uka.ipd.sdq.context.computed_usage.ComputedUsagePackage;
import de.uka.ipd.sdq.context.computed_usage.ExternalCallInput;
import de.uka.ipd.sdq.context.computed_usage.ExternalCallOutput;
import de.uka.ipd.sdq.context.computed_usage.Input;
import de.uka.ipd.sdq.context.computed_usage.LoopIteration;
import de.uka.ipd.sdq.context.computed_usage.Output;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ComputedUsageFactoryImpl extends EFactoryImpl implements ComputedUsageFactory {
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
	public static ComputedUsageFactory init() {
		try {
			ComputedUsageFactory theComputedUsageFactory = (ComputedUsageFactory)EPackage.Registry.INSTANCE.getEFactory("http://sdq.ipd.uka.de/Context/Usage/1.0"); 
			if (theComputedUsageFactory != null) {
				return theComputedUsageFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new ComputedUsageFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComputedUsageFactoryImpl() {
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
			case ComputedUsagePackage.COMPUTED_USAGE_CONTEXT: return createComputedUsageContext();
			case ComputedUsagePackage.BRANCH_PROBABILITY: return createBranchProbability();
			case ComputedUsagePackage.LOOP_ITERATION: return createLoopIteration();
			case ComputedUsagePackage.INPUT: return createInput();
			case ComputedUsagePackage.EXTERNAL_CALL_OUTPUT: return createExternalCallOutput();
			case ComputedUsagePackage.EXTERNAL_CALL_INPUT: return createExternalCallInput();
			case ComputedUsagePackage.OUTPUT: return createOutput();
			case ComputedUsagePackage.COMPUTED_USAGE: return createComputedUsage();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComputedUsageContext createComputedUsageContext() {
		ComputedUsageContextImpl computedUsageContext = new ComputedUsageContextImpl();
		return computedUsageContext;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BranchProbability createBranchProbability() {
		BranchProbabilityImpl branchProbability = new BranchProbabilityImpl();
		return branchProbability;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LoopIteration createLoopIteration() {
		LoopIterationImpl loopIteration = new LoopIterationImpl();
		return loopIteration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Input createInput() {
		InputImpl input = new InputImpl();
		return input;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExternalCallOutput createExternalCallOutput() {
		ExternalCallOutputImpl externalCallOutput = new ExternalCallOutputImpl();
		return externalCallOutput;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExternalCallInput createExternalCallInput() {
		ExternalCallInputImpl externalCallInput = new ExternalCallInputImpl();
		return externalCallInput;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Output createOutput() {
		OutputImpl output = new OutputImpl();
		return output;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComputedUsage createComputedUsage() {
		ComputedUsageImpl computedUsage = new ComputedUsageImpl();
		return computedUsage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComputedUsagePackage getComputedUsagePackage() {
		return (ComputedUsagePackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static ComputedUsagePackage getPackage() {
		return ComputedUsagePackage.eINSTANCE;
	}

} //ComputedUsageFactoryImpl
