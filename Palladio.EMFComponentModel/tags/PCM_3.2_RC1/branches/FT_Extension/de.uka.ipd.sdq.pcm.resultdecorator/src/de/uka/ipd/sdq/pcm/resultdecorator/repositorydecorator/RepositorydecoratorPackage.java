/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.resultdecorator.repositorydecorator;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import de.uka.ipd.sdq.pcm.core.entity.EntityPackage;

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
 * @see de.uka.ipd.sdq.pcm.resultdecorator.repositorydecorator.RepositorydecoratorFactory
 * @model kind="package"
 * @generated
 */
public interface RepositorydecoratorPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "repositorydecorator";

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
	String eNS_PREFIX = "repositorydecorator";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	RepositorydecoratorPackage eINSTANCE = de.uka.ipd.sdq.pcm.resultdecorator.repositorydecorator.impl.RepositorydecoratorPackageImpl.init();

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.pcm.resultdecorator.repositorydecorator.impl.ComponentResultImpl <em>Component Result</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pcm.resultdecorator.repositorydecorator.impl.ComponentResultImpl
	 * @see de.uka.ipd.sdq.pcm.resultdecorator.repositorydecorator.impl.RepositorydecoratorPackageImpl#getComponentResult()
	 * @generated
	 */
	int COMPONENT_RESULT = 1;

	/**
	 * The feature id for the '<em><b>Entity Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_RESULT__ENTITY_NAME = EntityPackage.NAMED_ELEMENT__ENTITY_NAME;

	/**
	 * The feature id for the '<em><b>Normalised Resource Demand</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_RESULT__NORMALISED_RESOURCE_DEMAND = EntityPackage.NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Normalised Response Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_RESULT__NORMALISED_RESPONSE_TIME = EntityPackage.NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Component Result</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_RESULT_FEATURE_COUNT = EntityPackage.NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.pcm.resultdecorator.repositorydecorator.impl.InterfaceProvidingRequiringEntityResultsImpl <em>Interface Providing Requiring Entity Results</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pcm.resultdecorator.repositorydecorator.impl.InterfaceProvidingRequiringEntityResultsImpl
	 * @see de.uka.ipd.sdq.pcm.resultdecorator.repositorydecorator.impl.RepositorydecoratorPackageImpl#getInterfaceProvidingRequiringEntityResults()
	 * @generated
	 */
	int INTERFACE_PROVIDING_REQUIRING_ENTITY_RESULTS = 0;

	/**
	 * The feature id for the '<em><b>Entity Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERFACE_PROVIDING_REQUIRING_ENTITY_RESULTS__ENTITY_NAME = COMPONENT_RESULT__ENTITY_NAME;

	/**
	 * The feature id for the '<em><b>Normalised Resource Demand</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERFACE_PROVIDING_REQUIRING_ENTITY_RESULTS__NORMALISED_RESOURCE_DEMAND = COMPONENT_RESULT__NORMALISED_RESOURCE_DEMAND;

	/**
	 * The feature id for the '<em><b>Normalised Response Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERFACE_PROVIDING_REQUIRING_ENTITY_RESULTS__NORMALISED_RESPONSE_TIME = COMPONENT_RESULT__NORMALISED_RESPONSE_TIME;

	/**
	 * The feature id for the '<em><b>Interfaceprovidingrequiringentity</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERFACE_PROVIDING_REQUIRING_ENTITY_RESULTS__INTERFACEPROVIDINGREQUIRINGENTITY = COMPONENT_RESULT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Interface Providing Requiring Entity Results</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERFACE_PROVIDING_REQUIRING_ENTITY_RESULTS_FEATURE_COUNT = COMPONENT_RESULT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.pcm.resultdecorator.repositorydecorator.impl.AllocationContextResultsImpl <em>Allocation Context Results</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pcm.resultdecorator.repositorydecorator.impl.AllocationContextResultsImpl
	 * @see de.uka.ipd.sdq.pcm.resultdecorator.repositorydecorator.impl.RepositorydecoratorPackageImpl#getAllocationContextResults()
	 * @generated
	 */
	int ALLOCATION_CONTEXT_RESULTS = 2;

	/**
	 * The feature id for the '<em><b>Entity Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALLOCATION_CONTEXT_RESULTS__ENTITY_NAME = COMPONENT_RESULT__ENTITY_NAME;

	/**
	 * The feature id for the '<em><b>Normalised Resource Demand</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALLOCATION_CONTEXT_RESULTS__NORMALISED_RESOURCE_DEMAND = COMPONENT_RESULT__NORMALISED_RESOURCE_DEMAND;

	/**
	 * The feature id for the '<em><b>Normalised Response Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALLOCATION_CONTEXT_RESULTS__NORMALISED_RESPONSE_TIME = COMPONENT_RESULT__NORMALISED_RESPONSE_TIME;

	/**
	 * The feature id for the '<em><b>Allocationcontext</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALLOCATION_CONTEXT_RESULTS__ALLOCATIONCONTEXT = COMPONENT_RESULT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Allocation Context Results</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALLOCATION_CONTEXT_RESULTS_FEATURE_COUNT = COMPONENT_RESULT_FEATURE_COUNT + 1;


	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.pcm.resultdecorator.repositorydecorator.InterfaceProvidingRequiringEntityResults <em>Interface Providing Requiring Entity Results</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Interface Providing Requiring Entity Results</em>'.
	 * @see de.uka.ipd.sdq.pcm.resultdecorator.repositorydecorator.InterfaceProvidingRequiringEntityResults
	 * @generated
	 */
	EClass getInterfaceProvidingRequiringEntityResults();

	/**
	 * Returns the meta object for the reference '{@link de.uka.ipd.sdq.pcm.resultdecorator.repositorydecorator.InterfaceProvidingRequiringEntityResults#getInterfaceprovidingrequiringentity <em>Interfaceprovidingrequiringentity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Interfaceprovidingrequiringentity</em>'.
	 * @see de.uka.ipd.sdq.pcm.resultdecorator.repositorydecorator.InterfaceProvidingRequiringEntityResults#getInterfaceprovidingrequiringentity()
	 * @see #getInterfaceProvidingRequiringEntityResults()
	 * @generated
	 */
	EReference getInterfaceProvidingRequiringEntityResults_Interfaceprovidingrequiringentity();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.pcm.resultdecorator.repositorydecorator.ComponentResult <em>Component Result</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Component Result</em>'.
	 * @see de.uka.ipd.sdq.pcm.resultdecorator.repositorydecorator.ComponentResult
	 * @generated
	 */
	EClass getComponentResult();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.pcm.resultdecorator.repositorydecorator.ComponentResult#getNormalisedResourceDemand <em>Normalised Resource Demand</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Normalised Resource Demand</em>'.
	 * @see de.uka.ipd.sdq.pcm.resultdecorator.repositorydecorator.ComponentResult#getNormalisedResourceDemand()
	 * @see #getComponentResult()
	 * @generated
	 */
	EAttribute getComponentResult_NormalisedResourceDemand();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.pcm.resultdecorator.repositorydecorator.ComponentResult#getNormalisedResponseTime <em>Normalised Response Time</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Normalised Response Time</em>'.
	 * @see de.uka.ipd.sdq.pcm.resultdecorator.repositorydecorator.ComponentResult#getNormalisedResponseTime()
	 * @see #getComponentResult()
	 * @generated
	 */
	EAttribute getComponentResult_NormalisedResponseTime();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.pcm.resultdecorator.repositorydecorator.AllocationContextResults <em>Allocation Context Results</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Allocation Context Results</em>'.
	 * @see de.uka.ipd.sdq.pcm.resultdecorator.repositorydecorator.AllocationContextResults
	 * @generated
	 */
	EClass getAllocationContextResults();

	/**
	 * Returns the meta object for the reference '{@link de.uka.ipd.sdq.pcm.resultdecorator.repositorydecorator.AllocationContextResults#getAllocationcontext <em>Allocationcontext</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Allocationcontext</em>'.
	 * @see de.uka.ipd.sdq.pcm.resultdecorator.repositorydecorator.AllocationContextResults#getAllocationcontext()
	 * @see #getAllocationContextResults()
	 * @generated
	 */
	EReference getAllocationContextResults_Allocationcontext();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	RepositorydecoratorFactory getRepositorydecoratorFactory();

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
		 * The meta object literal for the '{@link de.uka.ipd.sdq.pcm.resultdecorator.repositorydecorator.impl.InterfaceProvidingRequiringEntityResultsImpl <em>Interface Providing Requiring Entity Results</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.pcm.resultdecorator.repositorydecorator.impl.InterfaceProvidingRequiringEntityResultsImpl
		 * @see de.uka.ipd.sdq.pcm.resultdecorator.repositorydecorator.impl.RepositorydecoratorPackageImpl#getInterfaceProvidingRequiringEntityResults()
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
		 * The meta object literal for the '{@link de.uka.ipd.sdq.pcm.resultdecorator.repositorydecorator.impl.ComponentResultImpl <em>Component Result</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.pcm.resultdecorator.repositorydecorator.impl.ComponentResultImpl
		 * @see de.uka.ipd.sdq.pcm.resultdecorator.repositorydecorator.impl.RepositorydecoratorPackageImpl#getComponentResult()
		 * @generated
		 */
		EClass COMPONENT_RESULT = eINSTANCE.getComponentResult();

		/**
		 * The meta object literal for the '<em><b>Normalised Resource Demand</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMPONENT_RESULT__NORMALISED_RESOURCE_DEMAND = eINSTANCE.getComponentResult_NormalisedResourceDemand();

		/**
		 * The meta object literal for the '<em><b>Normalised Response Time</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMPONENT_RESULT__NORMALISED_RESPONSE_TIME = eINSTANCE.getComponentResult_NormalisedResponseTime();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.pcm.resultdecorator.repositorydecorator.impl.AllocationContextResultsImpl <em>Allocation Context Results</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.pcm.resultdecorator.repositorydecorator.impl.AllocationContextResultsImpl
		 * @see de.uka.ipd.sdq.pcm.resultdecorator.repositorydecorator.impl.RepositorydecoratorPackageImpl#getAllocationContextResults()
		 * @generated
		 */
		EClass ALLOCATION_CONTEXT_RESULTS = eINSTANCE.getAllocationContextResults();

		/**
		 * The meta object literal for the '<em><b>Allocationcontext</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ALLOCATION_CONTEXT_RESULTS__ALLOCATIONCONTEXT = eINSTANCE.getAllocationContextResults_Allocationcontext();

	}

} //RepositorydecoratorPackage
