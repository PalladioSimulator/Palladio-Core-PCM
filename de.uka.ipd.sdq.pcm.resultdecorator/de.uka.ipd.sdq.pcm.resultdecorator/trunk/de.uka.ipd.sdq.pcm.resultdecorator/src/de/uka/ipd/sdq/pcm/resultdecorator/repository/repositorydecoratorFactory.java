/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.resultdecorator.repository;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see de.uka.ipd.sdq.pcm.resultdecorator.repository.repositorydecoratorPackage
 * @generated
 */
public interface repositorydecoratorFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	repositorydecoratorFactory eINSTANCE = de.uka.ipd.sdq.pcm.resultdecorator.repository.impl.repositorydecoratorFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Interface Providing Requiring Entity Results</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Interface Providing Requiring Entity Results</em>'.
	 * @generated
	 */
	InterfaceProvidingRequiringEntityResults createInterfaceProvidingRequiringEntityResults();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	repositorydecoratorPackage getrepositorydecoratorPackage();

} //repositorydecoratorFactory
