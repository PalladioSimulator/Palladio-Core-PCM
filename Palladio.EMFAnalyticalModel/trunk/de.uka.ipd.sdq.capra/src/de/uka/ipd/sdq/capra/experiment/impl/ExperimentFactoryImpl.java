/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.capra.experiment.impl;

import de.uka.ipd.sdq.capra.experiment.*;

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
public class ExperimentFactoryImpl extends EFactoryImpl implements ExperimentFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ExperimentFactory init() {
		try {
			ExperimentFactory theExperimentFactory = (ExperimentFactory)EPackage.Registry.INSTANCE.getEFactory("http://sdq.ipd.uka.de/Capra/Experiment/1.0"); 
			if (theExperimentFactory != null) {
				return theExperimentFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new ExperimentFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExperimentFactoryImpl() {
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
			case ExperimentPackage.RESOURCE_USAGE_SPECIFICATION: return createResourceUsageSpecification();
			case ExperimentPackage.EXPERIMENT: return createExperiment();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResourceUsageSpecification createResourceUsageSpecification() {
		ResourceUsageSpecificationImpl resourceUsageSpecification = new ResourceUsageSpecificationImpl();
		return resourceUsageSpecification;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Experiment createExperiment() {
		ExperimentImpl experiment = new ExperimentImpl();
		return experiment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExperimentPackage getExperimentPackage() {
		return (ExperimentPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static ExperimentPackage getPackage() {
		return ExperimentPackage.eINSTANCE;
	}

} //ExperimentFactoryImpl
