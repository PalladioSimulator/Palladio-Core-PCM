/**
 * Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.subsystem;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc --> The <b>Factory</b> for the model. It provides a create method for each
 * non-abstract class of the model. <!-- end-user-doc -->
 *
 * @see de.uka.ipd.sdq.pcm.subsystem.SubsystemPackage
 * @generated
 */
public interface SubsystemFactory extends EFactory {
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
    SubsystemFactory eINSTANCE = de.uka.ipd.sdq.pcm.subsystem.impl.SubsystemFactoryImpl.init();

    /**
     * Returns a new object of class '<em>Sub System</em>'. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @return a new object of class '<em>Sub System</em>'.
     * @generated
     */
    SubSystem createSubSystem();

    /**
     * Returns the package supported by this factory. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the package supported by this factory.
     * @generated
     */
    SubsystemPackage getSubsystemPackage();

} // SubsystemFactory
