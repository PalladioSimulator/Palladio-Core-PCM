/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.spa.resourcemodel.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;

import de.uka.ipd.sdq.spa.resourcemodel.AlternativeResourceUsage;
import de.uka.ipd.sdq.spa.resourcemodel.DelayResource;
import de.uka.ipd.sdq.spa.resourcemodel.Option;
import de.uka.ipd.sdq.spa.resourcemodel.PassiveResource;
import de.uka.ipd.sdq.spa.resourcemodel.ProcessingResource;
import de.uka.ipd.sdq.spa.resourcemodel.ResourceModelFactory;
import de.uka.ipd.sdq.spa.resourcemodel.ResourceModelPackage;
import de.uka.ipd.sdq.spa.resourcemodel.ResourceUsage;
import de.uka.ipd.sdq.spa.resourcemodel.SequentialResourceUsage;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Factory</b>. <!-- end-user-doc -->
 * 
 * @generated
 */
public class ResourceModelFactoryImpl extends EFactoryImpl implements ResourceModelFactory {
    /**
     * Creates the default factory implementation. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public static ResourceModelFactory init() {
        try {
            ResourceModelFactory theResourceModelFactory = (ResourceModelFactory) EPackage.Registry.INSTANCE
                    .getEFactory("http://sdq.ipd.uka.de/ResourceModel/1.0");
            if (theResourceModelFactory != null) {
                return theResourceModelFactory;
            }
        } catch (Exception exception) {
            EcorePlugin.INSTANCE.log(exception);
        }
        return new ResourceModelFactoryImpl();
    }

    /**
     * Creates an instance of the factory. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public ResourceModelFactoryImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EObject create(EClass eClass) {
        switch (eClass.getClassifierID()) {
        case ResourceModelPackage.SEQUENTIAL_RESOURCE_USAGE:
            return createSequentialResourceUsage();
        case ResourceModelPackage.ALTERNATIVE_RESOURCE_USAGE:
            return createAlternativeResourceUsage();
        case ResourceModelPackage.RESOURCE_USAGE:
            return createResourceUsage();
        case ResourceModelPackage.PASSIVE_RESOURCE:
            return createPassiveResource();
        case ResourceModelPackage.PROCESSING_RESOURCE:
            return createProcessingResource();
        case ResourceModelPackage.DELAY_RESOURCE:
            return createDelayResource();
        case ResourceModelPackage.OPTION:
            return createOption();
        default:
            throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public SequentialResourceUsage createSequentialResourceUsage() {
        SequentialResourceUsageImpl sequentialResourceUsage = new SequentialResourceUsageImpl();
        return sequentialResourceUsage;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public AlternativeResourceUsage createAlternativeResourceUsage() {
        AlternativeResourceUsageImpl alternativeResourceUsage = new AlternativeResourceUsageImpl();
        return alternativeResourceUsage;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public ResourceUsage createResourceUsage() {
        ResourceUsageImpl resourceUsage = new ResourceUsageImpl();
        return resourceUsage;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public PassiveResource createPassiveResource() {
        PassiveResourceImpl passiveResource = new PassiveResourceImpl();
        return passiveResource;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public ProcessingResource createProcessingResource() {
        ProcessingResourceImpl processingResource = new ProcessingResourceImpl();
        return processingResource;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public DelayResource createDelayResource() {
        DelayResourceImpl delayResource = new DelayResourceImpl();
        return delayResource;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public Option createOption() {
        OptionImpl option = new OptionImpl();
        return option;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public ResourceModelPackage getResourceModelPackage() {
        return (ResourceModelPackage) getEPackage();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @deprecated
     * @generated
     */
    public static ResourceModelPackage getPackage() {
        return ResourceModelPackage.eINSTANCE;
    }

} // ResourceModelFactoryImpl
