/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.resourcerepository.impl;

import de.uka.ipd.sdq.pcm.resourcerepository.*;

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
public class resourcerepositoryFactoryImpl extends EFactoryImpl implements resourcerepositoryFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static resourcerepositoryFactory init() {
		try {
			resourcerepositoryFactory theresourcerepositoryFactory = (resourcerepositoryFactory)EPackage.Registry.INSTANCE.getEFactory("http://sdq.ipd.uka.de/DesignDecision/ResourceRepository/2.0"); 
			if (theresourcerepositoryFactory != null) {
				return theresourcerepositoryFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new resourcerepositoryFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public resourcerepositoryFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case resourcerepositoryPackage.RESOURCE_DESCRIPTION_REPOSITORY: return createResourceDescriptionRepository();
			case resourcerepositoryPackage.RESOURCE_DESCRIPTION: return createResourceDescription();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResourceDescriptionRepository createResourceDescriptionRepository() {
		ResourceDescriptionRepositoryImpl resourceDescriptionRepository = new ResourceDescriptionRepositoryImpl();
		return resourceDescriptionRepository;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResourceDescription createResourceDescription() {
		ResourceDescriptionImpl resourceDescription = new ResourceDescriptionImpl();
		return resourceDescription;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public resourcerepositoryPackage getresourcerepositoryPackage() {
		return (resourcerepositoryPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static resourcerepositoryPackage getPackage() {
		return resourcerepositoryPackage.eINSTANCE;
	}

} //resourcerepositoryFactoryImpl
