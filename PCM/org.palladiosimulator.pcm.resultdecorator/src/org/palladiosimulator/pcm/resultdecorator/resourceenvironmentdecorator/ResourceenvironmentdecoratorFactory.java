/**
 */
package org.palladiosimulator.pcm.resultdecorator.resourceenvironmentdecorator;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc --> The <b>Factory</b> for the model. It provides a create method for each
 * non-abstract class of the model. <!-- end-user-doc -->
 *
 * @see org.palladiosimulator.pcm.resultdecorator.resourceenvironmentdecorator.
 *      ResourceenvironmentdecoratorPackage
 * @generated
 */
public interface ResourceenvironmentdecoratorFactory extends EFactory {

    /**
     * The singleton instance of the factory. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    ResourceenvironmentdecoratorFactory eINSTANCE = org.palladiosimulator.pcm.resultdecorator.resourceenvironmentdecorator.impl.ResourceenvironmentdecoratorFactoryImpl
            .init();

    /**
     * Returns a new object of class '<em>Linking Resource Results</em>'. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @return a new object of class '<em>Linking Resource Results</em>'.
     * @generated
     */
    LinkingResourceResults createLinkingResourceResults();

    /**
     * Returns a new object of class '<em>Resource Container Results</em>'. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @return a new object of class '<em>Resource Container Results</em>'.
     * @generated
     */
    ResourceContainerResults createResourceContainerResults();

    /**
     * Returns a new object of class '<em>Processing Resource Specification Result</em>'. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @return a new object of class '<em>Processing Resource Specification Result</em>'.
     * @generated
     */
    ProcessingResourceSpecificationResult createProcessingResourceSpecificationResult();

    /**
     * Returns a new object of class '<em>Passive Resource Result</em>'. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @return a new object of class '<em>Passive Resource Result</em>'.
     * @generated
     */
    PassiveResourceResult createPassiveResourceResult();

    /**
     * Returns the package supported by this factory. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the package supported by this factory.
     * @generated
     */
    ResourceenvironmentdecoratorPackage getResourceenvironmentdecoratorPackage();

} // ResourceenvironmentdecoratorFactory
