/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.designdecision.resourcerepository.impl;

import de.uka.ipd.sdq.pcm.designdecision.resourcerepository.*;

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
public class ResourcerepositoryFactoryImpl extends EFactoryImpl implements ResourcerepositoryFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ResourcerepositoryFactory init() {
		try {
			ResourcerepositoryFactory theResourcerepositoryFactory = (ResourcerepositoryFactory)EPackage.Registry.INSTANCE.getEFactory("http:///DesignDecision/resourcerepository.ecore"); 
			if (theResourcerepositoryFactory != null) {
				return theResourcerepositoryFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new ResourcerepositoryFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResourcerepositoryFactoryImpl() {
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
			case ResourcerepositoryPackage.RESOURCE_DESCRIPTION_REPOSITORY: return createResourceDescriptionRepository();
			case ResourcerepositoryPackage.RESOURCE_DESCRIPTION: return createResourceDescription();
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
	public ResourcerepositoryPackage getResourcerepositoryPackage() {
		return (ResourcerepositoryPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static ResourcerepositoryPackage getPackage() {
		return ResourcerepositoryPackage.eINSTANCE;
	}

} //ResourcerepositoryFactoryImpl
