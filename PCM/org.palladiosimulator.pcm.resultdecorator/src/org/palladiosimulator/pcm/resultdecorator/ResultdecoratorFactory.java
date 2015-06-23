/**
 */
package org.palladiosimulator.pcm.resultdecorator;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc --> The <b>Factory</b> for the model. It provides a create method for each
 * non-abstract class of the model. <!-- end-user-doc -->
 *
 * @see org.palladiosimulator.pcm.resultdecorator.ResultdecoratorPackage
 * @generated
 */
public interface ResultdecoratorFactory extends EFactory {

    /**
     * The singleton instance of the factory. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    ResultdecoratorFactory eINSTANCE = org.palladiosimulator.pcm.resultdecorator.impl.ResultdecoratorFactoryImpl.init();

    /**
     * Returns a new object of class '<em>Result Decorator Repository</em>'. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @return a new object of class '<em>Result Decorator Repository</em>'.
     * @generated
     */
    ResultDecoratorRepository createResultDecoratorRepository();

    /**
     * Returns the package supported by this factory. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the package supported by this factory.
     * @generated
     */
    ResultdecoratorPackage getResultdecoratorPackage();

} // ResultdecoratorFactory
