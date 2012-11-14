/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.resultdecorator.repository;

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
 * @see de.uka.ipd.sdq.pcm.resultdecorator.repository.repositorydecoratorFactory
 * @model kind="package"
 * @generated
 */
public interface repositorydecoratorPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "repository";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://sdq.ipd.uka.de/ResultDecorator/Repository/1.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "resultdecorator.repository";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	repositorydecoratorPackage eINSTANCE = de.uka.ipd.sdq.pcm.resultdecorator.repository.impl.repositorydecoratorPackageImpl.init();

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.pcm.resultdecorator.repository.impl.InterfaceProvidingRequiringEntityResultsImpl <em>Interface Providing Requiring Entity Results</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pcm.resultdecorator.repository.impl.InterfaceProvidingRequiringEntityResultsImpl
	 * @see de.uka.ipd.sdq.pcm.resultdecorator.repository.impl.repositorydecoratorPackageImpl#getInterfaceProvidingRequiringEntityResults()
	 * @generated
	 */
	int INTERFACE_PROVIDING_REQUIRING_ENTITY_RESULTS = 0;

	/**
	 * The feature id for the '<em><b>Interfaceprovidingrequiringentity</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERFACE_PROVIDING_REQUIRING_ENTITY_RESULTS__INTERFACEPROVIDINGREQUIRINGENTITY = 0;

	/**
	 * The feature id for the '<em><b>Normalised Resource Demand</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERFACE_PROVIDING_REQUIRING_ENTITY_RESULTS__NORMALISED_RESOURCE_DEMAND = 1;

	/**
	 * The feature id for the '<em><b>Normalised Response Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERFACE_PROVIDING_REQUIRING_ENTITY_RESULTS__NORMALISED_RESPONSE_TIME = 2;

	/**
	 * The number of structural features of the '<em>Interface Providing Requiring Entity Results</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERFACE_PROVIDING_REQUIRING_ENTITY_RESULTS_FEATURE_COUNT = 3;


	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.pcm.resultdecorator.repository.InterfaceProvidingRequiringEntityResults <em>Interface Providing Requiring Entity Results</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Interface Providing Requiring Entity Results</em>'.
	 * @see de.uka.ipd.sdq.pcm.resultdecorator.repository.InterfaceProvidingRequiringEntityResults
	 * @generated
	 */
	EClass getInterfaceProvidingRequiringEntityResults();

	/**
	 * Returns the meta object for the reference '{@link de.uka.ipd.sdq.pcm.resultdecorator.repository.InterfaceProvidingRequiringEntityResults#getInterfaceprovidingrequiringentity <em>Interfaceprovidingrequiringentity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Interfaceprovidingrequiringentity</em>'.
	 * @see de.uka.ipd.sdq.pcm.resultdecorator.repository.InterfaceProvidingRequiringEntityResults#getInterfaceprovidingrequiringentity()
	 * @see #getInterfaceProvidingRequiringEntityResults()
	 * @generated
	 */
	EReference getInterfaceProvidingRequiringEntityResults_Interfaceprovidingrequiringentity();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.pcm.resultdecorator.repository.InterfaceProvidingRequiringEntityResults#getNormalisedResourceDemand <em>Normalised Resource Demand</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Normalised Resource Demand</em>'.
	 * @see de.uka.ipd.sdq.pcm.resultdecorator.repository.InterfaceProvidingRequiringEntityResults#getNormalisedResourceDemand()
	 * @see #getInterfaceProvidingRequiringEntityResults()
	 * @generated
	 */
	EAttribute getInterfaceProvidingRequiringEntityResults_NormalisedResourceDemand();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.pcm.resultdecorator.repository.InterfaceProvidingRequiringEntityResults#getNormalisedResponseTime <em>Normalised Response Time</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Normalised Response Time</em>'.
	 * @see de.uka.ipd.sdq.pcm.resultdecorator.repository.InterfaceProvidingRequiringEntityResults#getNormalisedResponseTime()
	 * @see #getInterfaceProvidingRequiringEntityResults()
	 * @generated
	 */
	EAttribute getInterfaceProvidingRequiringEntityResults_NormalisedResponseTime();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	repositorydecoratorFactory getrepositorydecoratorFactory();

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
		 * The meta object literal for the '{@link de.uka.ipd.sdq.pcm.resultdecorator.repository.impl.InterfaceProvidingRequiringEntityResultsImpl <em>Interface Providing Requiring Entity Results</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.pcm.resultdecorator.repository.impl.InterfaceProvidingRequiringEntityResultsImpl
		 * @see de.uka.ipd.sdq.pcm.resultdecorator.repository.impl.repositorydecoratorPackageImpl#getInterfaceProvidingRequiringEntityResults()
		 * @generated
		 */
		EClass INTERFACE_PROVIDING_REQUIRING_ENTITY_RESULTS = eINSTANCE.getInterfaceProvidingRequiringEntityResults();

		/**
		 * The meta object literal for the '<em><b>Interfaceprovidingrequiringentity</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTERFACE_PROVIDING_REQUIRING_ENTITY_RESULTS__INTERFACEPROVIDINGREQUIRINGENTITY = eINSTANCE.getInterfaceProvidingRequiringEntityResults_Interfaceprovidingrequiringentity();

		/**
		 * The meta object literal for the '<em><b>Normalised Resource Demand</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INTERFACE_PROVIDING_REQUIRING_ENTITY_RESULTS__NORMALISED_RESOURCE_DEMAND = eINSTANCE.getInterfaceProvidingRequiringEntityResults_NormalisedResourceDemand();

		/**
		 * The meta object literal for the '<em><b>Normalised Response Time</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INTERFACE_PROVIDING_REQUIRING_ENTITY_RESULTS__NORMALISED_RESPONSE_TIME = eINSTANCE.getInterfaceProvidingRequiringEntityResults_NormalisedResponseTime();

	}

} //repositorydecoratorPackage
