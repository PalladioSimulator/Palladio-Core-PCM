/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.resultdecorator.repositorydecorator;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see de.uka.ipd.sdq.pcm.resultdecorator.repositorydecorator.RepositorydecoratorPackage
 * @generated
 */
public interface RepositorydecoratorFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	RepositorydecoratorFactory eINSTANCE = de.uka.ipd.sdq.pcm.resultdecorator.repositorydecorator.impl.RepositorydecoratorFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Interface Providing Requiring Entity Results</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Interface Providing Requiring Entity Results</em>'.
	 * @generated
	 */
	InterfaceProvidingRequiringEntityResults createInterfaceProvidingRequiringEntityResults();

	/**
	 * Returns a new object of class '<em>Allocation Context Results</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Allocation Context Results</em>'.
	 * @generated
	 */
	AllocationContextResults createAllocationContextResults();

	/**
	 * Returns a new object of class '<em>Allocation Service Result</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Allocation Service Result</em>'.
	 * @generated
	 */
	AllocationServiceResult createAllocationServiceResult();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	RepositorydecoratorPackage getRepositorydecoratorPackage();

} //RepositorydecoratorFactory
