/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.resultdecorator.resourceenvironment.impl;

import de.uka.ipd.sdq.pcm.resultdecorator.resourceenvironment.*;

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
public class resourceenvironmentdecoratorFactoryImpl extends EFactoryImpl implements resourceenvironmentdecoratorFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static resourceenvironmentdecoratorFactory init() {
		try {
			resourceenvironmentdecoratorFactory theresourceenvironmentdecoratorFactory = (resourceenvironmentdecoratorFactory)EPackage.Registry.INSTANCE.getEFactory("http://sdq.ipd.uka.de/ResultDecorator/ResourceEnvironment/1.0"); 
			if (theresourceenvironmentdecoratorFactory != null) {
				return theresourceenvironmentdecoratorFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new resourceenvironmentdecoratorFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public resourceenvironmentdecoratorFactoryImpl() {
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
			case resourceenvironmentdecoratorPackage.LINKING_RESOURCE_RESULTS: return createLinkingResourceResults();
			case resourceenvironmentdecoratorPackage.RESOURCE_CONTAINER_RESULTS: return createResourceContainerResults();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LinkingResourceResults createLinkingResourceResults() {
		LinkingResourceResultsImpl linkingResourceResults = new LinkingResourceResultsImpl();
		return linkingResourceResults;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResourceContainerResults createResourceContainerResults() {
		ResourceContainerResultsImpl resourceContainerResults = new ResourceContainerResultsImpl();
		return resourceContainerResults;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public resourceenvironmentdecoratorPackage getresourceenvironmentdecoratorPackage() {
		return (resourceenvironmentdecoratorPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static resourceenvironmentdecoratorPackage getPackage() {
		return resourceenvironmentdecoratorPackage.eINSTANCE;
	}

} //resourceenvironmentdecoratorFactoryImpl
