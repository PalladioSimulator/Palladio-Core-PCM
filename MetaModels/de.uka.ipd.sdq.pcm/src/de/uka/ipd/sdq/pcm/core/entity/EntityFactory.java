/**
 * Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.core.entity;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc --> The <b>Factory</b> for the model. It provides a create method for each
 * non-abstract class of the model. <!-- end-user-doc -->
 * 
 * @see de.uka.ipd.sdq.pcm.core.entity.EntityPackage
 * @generated
 */
public interface EntityFactory extends EFactory {
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    String copyright = "Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany";

    /**
     * The singleton instance of the factory. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    EntityFactory eINSTANCE = de.uka.ipd.sdq.pcm.core.entity.impl.EntityFactoryImpl.init();

    /**
     * Returns a new object of class '<em>Resource Provided Role</em>'. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @return a new object of class '<em>Resource Provided Role</em>'.
     * @generated
     */
    ResourceProvidedRole createResourceProvidedRole();

    /**
     * Returns a new object of class '<em>Resource Interface Requiring Entity</em>'. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return a new object of class '<em>Resource Interface Requiring Entity</em>'.
     * @generated
     */
    ResourceInterfaceRequiringEntity createResourceInterfaceRequiringEntity();

    /**
     * Returns a new object of class '<em>Resource Required Role</em>'. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @return a new object of class '<em>Resource Required Role</em>'.
     * @generated
     */
    ResourceRequiredRole createResourceRequiredRole();

    /**
     * Returns a new object of class '<em>Resource Interface Providing Entity</em>'. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return a new object of class '<em>Resource Interface Providing Entity</em>'.
     * @generated
     */
    ResourceInterfaceProvidingEntity createResourceInterfaceProvidingEntity();

    /**
     * Returns a new object of class '<em>Resource Interface Providing Requiring Entity</em>'. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return a new object of class '<em>Resource Interface Providing Requiring Entity</em>'.
     * @generated
     */
    ResourceInterfaceProvidingRequiringEntity createResourceInterfaceProvidingRequiringEntity();

    /**
     * Returns the package supported by this factory. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the package supported by this factory.
     * @generated
     */
    EntityPackage getEntityPackage();

} // EntityFactory
