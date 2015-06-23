/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.resultdecorator.repositorydecorator.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;

import de.uka.ipd.sdq.pcm.resultdecorator.repositorydecorator.AllocationContextResults;
import de.uka.ipd.sdq.pcm.resultdecorator.repositorydecorator.AllocationServiceResult;
import de.uka.ipd.sdq.pcm.resultdecorator.repositorydecorator.InterfaceProvidingRequiringEntityResults;
import de.uka.ipd.sdq.pcm.resultdecorator.repositorydecorator.RepositorydecoratorFactory;
import de.uka.ipd.sdq.pcm.resultdecorator.repositorydecorator.RepositorydecoratorPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class RepositorydecoratorFactoryImpl extends EFactoryImpl implements RepositorydecoratorFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static RepositorydecoratorFactory init() {
		try {
			RepositorydecoratorFactory theRepositorydecoratorFactory = (RepositorydecoratorFactory)EPackage.Registry.INSTANCE.getEFactory("http://sdq.ipd.uka.de/ResultDecorator/Repository/1.0"); 
			if (theRepositorydecoratorFactory != null) {
				return theRepositorydecoratorFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new RepositorydecoratorFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RepositorydecoratorFactoryImpl() {
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
			case RepositorydecoratorPackage.INTERFACE_PROVIDING_REQUIRING_ENTITY_RESULTS: return createInterfaceProvidingRequiringEntityResults();
			case RepositorydecoratorPackage.ALLOCATION_CONTEXT_RESULTS: return createAllocationContextResults();
			case RepositorydecoratorPackage.ALLOCATION_SERVICE_RESULT: return createAllocationServiceResult();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InterfaceProvidingRequiringEntityResults createInterfaceProvidingRequiringEntityResults() {
		InterfaceProvidingRequiringEntityResultsImpl interfaceProvidingRequiringEntityResults = new InterfaceProvidingRequiringEntityResultsImpl();
		return interfaceProvidingRequiringEntityResults;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AllocationContextResults createAllocationContextResults() {
		AllocationContextResultsImpl allocationContextResults = new AllocationContextResultsImpl();
		return allocationContextResults;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AllocationServiceResult createAllocationServiceResult() {
		AllocationServiceResultImpl allocationServiceResult = new AllocationServiceResultImpl();
		return allocationServiceResult;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RepositorydecoratorPackage getRepositorydecoratorPackage() {
		return (RepositorydecoratorPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static RepositorydecoratorPackage getPackage() {
		return RepositorydecoratorPackage.eINSTANCE;
	}

} //RepositorydecoratorFactoryImpl
