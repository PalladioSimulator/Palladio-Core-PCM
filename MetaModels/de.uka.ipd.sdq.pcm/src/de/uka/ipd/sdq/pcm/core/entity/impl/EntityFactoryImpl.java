/**
 * Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.core.entity.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;

import de.uka.ipd.sdq.pcm.core.entity.EntityFactory;
import de.uka.ipd.sdq.pcm.core.entity.EntityPackage;
import de.uka.ipd.sdq.pcm.core.entity.ResourceInterfaceProvidingEntity;
import de.uka.ipd.sdq.pcm.core.entity.ResourceInterfaceProvidingRequiringEntity;
import de.uka.ipd.sdq.pcm.core.entity.ResourceInterfaceRequiringEntity;
import de.uka.ipd.sdq.pcm.core.entity.ResourceProvidedRole;
import de.uka.ipd.sdq.pcm.core.entity.ResourceRequiredRole;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Factory</b>. <!-- end-user-doc -->
 * 
 * @generated
 */
public class EntityFactoryImpl extends EFactoryImpl implements EntityFactory {
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public static final String copyright = "Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany";

    /**
     * Creates the default factory implementation. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public static EntityFactory init() {
        try {
            EntityFactory theEntityFactory = (EntityFactory) EPackage.Registry.INSTANCE
                    .getEFactory(EntityPackage.eNS_URI);
            if (theEntityFactory != null) {
                return theEntityFactory;
            }
        } catch (Exception exception) {
            EcorePlugin.INSTANCE.log(exception);
        }
        return new EntityFactoryImpl();
    }

    /**
     * Creates an instance of the factory. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EntityFactoryImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EObject create(EClass eClass) {
        switch (eClass.getClassifierID()) {
        case EntityPackage.RESOURCE_PROVIDED_ROLE:
            return (EObject) createResourceProvidedRole();
        case EntityPackage.RESOURCE_INTERFACE_REQUIRING_ENTITY:
            return (EObject) createResourceInterfaceRequiringEntity();
        case EntityPackage.RESOURCE_REQUIRED_ROLE:
            return (EObject) createResourceRequiredRole();
        case EntityPackage.RESOURCE_INTERFACE_PROVIDING_ENTITY:
            return (EObject) createResourceInterfaceProvidingEntity();
        case EntityPackage.RESOURCE_INTERFACE_PROVIDING_REQUIRING_ENTITY:
            return (EObject) createResourceInterfaceProvidingRequiringEntity();
        default:
            throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public ResourceProvidedRole createResourceProvidedRole() {
        ResourceProvidedRoleImpl resourceProvidedRole = new ResourceProvidedRoleImpl();
        return resourceProvidedRole;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public ResourceInterfaceRequiringEntity createResourceInterfaceRequiringEntity() {
        ResourceInterfaceRequiringEntityImpl resourceInterfaceRequiringEntity = new ResourceInterfaceRequiringEntityImpl();
        return resourceInterfaceRequiringEntity;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public ResourceRequiredRole createResourceRequiredRole() {
        ResourceRequiredRoleImpl resourceRequiredRole = new ResourceRequiredRoleImpl();
        return resourceRequiredRole;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public ResourceInterfaceProvidingEntity createResourceInterfaceProvidingEntity() {
        ResourceInterfaceProvidingEntityImpl resourceInterfaceProvidingEntity = new ResourceInterfaceProvidingEntityImpl();
        return resourceInterfaceProvidingEntity;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public ResourceInterfaceProvidingRequiringEntity createResourceInterfaceProvidingRequiringEntity() {
        ResourceInterfaceProvidingRequiringEntityImpl resourceInterfaceProvidingRequiringEntity = new ResourceInterfaceProvidingRequiringEntityImpl();
        return resourceInterfaceProvidingRequiringEntity;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EntityPackage getEntityPackage() {
        return (EntityPackage) getEPackage();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @deprecated
     * @generated
     */
    @Deprecated
    public static EntityPackage getPackage() {
        return EntityPackage.eINSTANCE;
    }

} // EntityFactoryImpl
