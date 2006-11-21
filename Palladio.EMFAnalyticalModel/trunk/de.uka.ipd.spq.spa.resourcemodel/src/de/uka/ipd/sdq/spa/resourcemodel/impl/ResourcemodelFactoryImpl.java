/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.spa.resourcemodel.impl;

import de.uka.ipd.sdq.spa.resourcemodel.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ResourcemodelFactoryImpl extends EFactoryImpl implements ResourcemodelFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ResourcemodelFactory init() {
		try {
			ResourcemodelFactory theResourcemodelFactory = (ResourcemodelFactory)EPackage.Registry.INSTANCE.getEFactory("http://sdq.ipd.uka.de/ResourceModel/1.0"); 
			if (theResourcemodelFactory != null) {
				return theResourcemodelFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new ResourcemodelFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResourcemodelFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case ResourcemodelPackage.RESOURCE_USAGE: return createResourceUsage();
			case ResourcemodelPackage.PASSIVE_RESOURCE: return createPassiveResource();
			case ResourcemodelPackage.PROCESSING_RESOURCE: return createProcessingResource();
			case ResourcemodelPackage.DELAY_RESOURCE: return createDelayResource();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResourceUsage createResourceUsage() {
		ResourceUsageImpl resourceUsage = new ResourceUsageImpl();
		return resourceUsage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PassiveResource createPassiveResource() {
		PassiveResourceImpl passiveResource = new PassiveResourceImpl();
		return passiveResource;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProcessingResource createProcessingResource() {
		ProcessingResourceImpl processingResource = new ProcessingResourceImpl();
		return processingResource;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DelayResource createDelayResource() {
		DelayResourceImpl delayResource = new DelayResourceImpl();
		return delayResource;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResourcemodelPackage getResourcemodelPackage() {
		return (ResourcemodelPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	public static ResourcemodelPackage getPackage() {
		return ResourcemodelPackage.eINSTANCE;
	}

} //ResourcemodelFactoryImpl
