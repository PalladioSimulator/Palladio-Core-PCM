/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.capra.experiment;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see de.uka.ipd.sdq.capra.experiment.ExperimentFactory
 * @model kind="package"
 * @generated
 */
public interface ExperimentPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "experiment";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://sdq.ipd.uka.de/Capra/Experiment/1.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "experiment";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ExperimentPackage eINSTANCE = de.uka.ipd.sdq.capra.experiment.impl.ExperimentPackageImpl.init();

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.capra.experiment.impl.ResourceUsageSpecificationImpl <em>Resource Usage Specification</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.capra.experiment.impl.ResourceUsageSpecificationImpl
	 * @see de.uka.ipd.sdq.capra.experiment.impl.ExperimentPackageImpl#getResourceUsageSpecification()
	 * @generated
	 */
	int RESOURCE_USAGE_SPECIFICATION = 0;

	/**
	 * The feature id for the '<em><b>Variable</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_USAGE_SPECIFICATION__VARIABLE = 0;

	/**
	 * The feature id for the '<em><b>Resource Usage Specification</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_USAGE_SPECIFICATION__RESOURCE_USAGE_SPECIFICATION = 1;

	/**
	 * The number of structural features of the '<em>Resource Usage Specification</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_USAGE_SPECIFICATION_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.capra.experiment.impl.ExperimentImpl <em>Experiment</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.capra.experiment.impl.ExperimentImpl
	 * @see de.uka.ipd.sdq.capra.experiment.impl.ExperimentPackageImpl#getExperiment()
	 * @generated
	 */
	int EXPERIMENT = 1;

	/**
	 * The feature id for the '<em><b>Resource Usage Specification</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPERIMENT__RESOURCE_USAGE_SPECIFICATION = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPERIMENT__NAME = 1;

	/**
	 * The number of structural features of the '<em>Experiment</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPERIMENT_FEATURE_COUNT = 2;


	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.capra.experiment.ResourceUsageSpecification <em>Resource Usage Specification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Resource Usage Specification</em>'.
	 * @see de.uka.ipd.sdq.capra.experiment.ResourceUsageSpecification
	 * @generated
	 */
	EClass getResourceUsageSpecification();

	/**
	 * Returns the meta object for the reference '{@link de.uka.ipd.sdq.capra.experiment.ResourceUsageSpecification#getVariable <em>Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Variable</em>'.
	 * @see de.uka.ipd.sdq.capra.experiment.ResourceUsageSpecification#getVariable()
	 * @see #getResourceUsageSpecification()
	 * @generated
	 */
	EReference getResourceUsageSpecification_Variable();

	/**
	 * Returns the meta object for the containment reference '{@link de.uka.ipd.sdq.capra.experiment.ResourceUsageSpecification#getResourceUsageSpecification <em>Resource Usage Specification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Resource Usage Specification</em>'.
	 * @see de.uka.ipd.sdq.capra.experiment.ResourceUsageSpecification#getResourceUsageSpecification()
	 * @see #getResourceUsageSpecification()
	 * @generated
	 */
	EReference getResourceUsageSpecification_ResourceUsageSpecification();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.capra.experiment.Experiment <em>Experiment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Experiment</em>'.
	 * @see de.uka.ipd.sdq.capra.experiment.Experiment
	 * @generated
	 */
	EClass getExperiment();

	/**
	 * Returns the meta object for the containment reference list '{@link de.uka.ipd.sdq.capra.experiment.Experiment#getResourceUsageSpecification <em>Resource Usage Specification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Resource Usage Specification</em>'.
	 * @see de.uka.ipd.sdq.capra.experiment.Experiment#getResourceUsageSpecification()
	 * @see #getExperiment()
	 * @generated
	 */
	EReference getExperiment_ResourceUsageSpecification();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.capra.experiment.Experiment#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see de.uka.ipd.sdq.capra.experiment.Experiment#getName()
	 * @see #getExperiment()
	 * @generated
	 */
	EAttribute getExperiment_Name();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ExperimentFactory getExperimentFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.capra.experiment.impl.ResourceUsageSpecificationImpl <em>Resource Usage Specification</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.capra.experiment.impl.ResourceUsageSpecificationImpl
		 * @see de.uka.ipd.sdq.capra.experiment.impl.ExperimentPackageImpl#getResourceUsageSpecification()
		 * @generated
		 */
		EClass RESOURCE_USAGE_SPECIFICATION = eINSTANCE.getResourceUsageSpecification();

		/**
		 * The meta object literal for the '<em><b>Variable</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RESOURCE_USAGE_SPECIFICATION__VARIABLE = eINSTANCE.getResourceUsageSpecification_Variable();

		/**
		 * The meta object literal for the '<em><b>Resource Usage Specification</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RESOURCE_USAGE_SPECIFICATION__RESOURCE_USAGE_SPECIFICATION = eINSTANCE.getResourceUsageSpecification_ResourceUsageSpecification();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.capra.experiment.impl.ExperimentImpl <em>Experiment</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.capra.experiment.impl.ExperimentImpl
		 * @see de.uka.ipd.sdq.capra.experiment.impl.ExperimentPackageImpl#getExperiment()
		 * @generated
		 */
		EClass EXPERIMENT = eINSTANCE.getExperiment();

		/**
		 * The meta object literal for the '<em><b>Resource Usage Specification</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXPERIMENT__RESOURCE_USAGE_SPECIFICATION = eINSTANCE.getExperiment_ResourceUsageSpecification();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXPERIMENT__NAME = eINSTANCE.getExperiment_Name();

	}

} //ExperimentPackage
