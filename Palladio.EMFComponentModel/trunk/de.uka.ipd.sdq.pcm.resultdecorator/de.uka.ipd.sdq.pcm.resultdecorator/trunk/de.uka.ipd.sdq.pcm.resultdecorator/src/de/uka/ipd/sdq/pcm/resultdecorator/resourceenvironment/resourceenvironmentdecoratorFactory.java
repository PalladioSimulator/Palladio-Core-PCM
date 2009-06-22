/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.resultdecorator.resourceenvironment;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see de.uka.ipd.sdq.pcm.resultdecorator.resourceenvironment.resourceenvironmentdecoratorPackage
 * @generated
 */
public interface resourceenvironmentdecoratorFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	resourceenvironmentdecoratorFactory eINSTANCE = de.uka.ipd.sdq.pcm.resultdecorator.resourceenvironment.impl.resourceenvironmentdecoratorFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Linking Resource Results</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Linking Resource Results</em>'.
	 * @generated
	 */
	LinkingResourceResults createLinkingResourceResults();

	/**
	 * Returns a new object of class '<em>Resource Container Results</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Resource Container Results</em>'.
	 * @generated
	 */
	ResourceContainerResults createResourceContainerResults();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	resourceenvironmentdecoratorPackage getresourceenvironmentdecoratorPackage();

} //resourceenvironmentdecoratorFactory
