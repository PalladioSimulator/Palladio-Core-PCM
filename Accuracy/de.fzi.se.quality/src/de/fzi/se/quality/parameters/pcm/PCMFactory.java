/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.fzi.se.quality.parameters.pcm;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc --> The <b>Factory</b> for the model. It provides a create method for each
 * non-abstract class of the model. <!-- end-user-doc -->
 *
 * @see de.fzi.se.quality.parameters.pcm.PCMPackage
 * @generated
 */
public interface PCMFactory extends EFactory {

    /**
     * The singleton instance of the factory. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    PCMFactory eINSTANCE = de.fzi.se.quality.parameters.pcm.impl.PCMFactoryImpl.init();

    /**
     * Returns a new object of class '<em>Parameter Value</em>'. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @return a new object of class '<em>Parameter Value</em>'.
     * @generated
     */
    PCMParameterValue createPCMParameterValue();

    /**
     * Returns a new object of class '<em>Infrastructure Operation Reference</em>'. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @return a new object of class '<em>Infrastructure Operation Reference</em>'.
     * @generated
     */
    PCMInfrastructureOperationReference createPCMInfrastructureOperationReference();

    /**
     * Returns a new object of class '<em>Business Operation Reference</em>'. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     *
     * @return a new object of class '<em>Business Operation Reference</em>'.
     * @generated
     */
    PCMBusinessOperationReference createPCMBusinessOperationReference();

    /**
     * Returns a new object of class '<em>Component Reference</em>'. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @return a new object of class '<em>Component Reference</em>'.
     * @generated
     */
    PCMComponentReference createPCMComponentReference();

    /**
     * Returns a new object of class '<em>Component Parameter Reference</em>'. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     *
     * @return a new object of class '<em>Component Parameter Reference</em>'.
     * @generated
     */
    PCMComponentParameterReference createPCMComponentParameterReference();

    /**
     * Returns a new object of class '<em>Operation Parameter Reference</em>'. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     *
     * @return a new object of class '<em>Operation Parameter Reference</em>'.
     * @generated
     */
    PCMOperationParameterReference createPCMOperationParameterReference();

    /**
     * Returns a new object of class '
     * <em>Required Business Operation Return Parameter Reference</em>'. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @return a new object of class '
     *         <em>Required Business Operation Return Parameter Reference</em>'.
     * @generated
     */
    PCMRequiredBusinessOperationReturnParameterReference createPCMRequiredBusinessOperationReturnParameterReference();

    /**
     * Returns the package supported by this factory. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the package supported by this factory.
     * @generated
     */
    PCMPackage getPCMPackage();

} // PCMFactory
