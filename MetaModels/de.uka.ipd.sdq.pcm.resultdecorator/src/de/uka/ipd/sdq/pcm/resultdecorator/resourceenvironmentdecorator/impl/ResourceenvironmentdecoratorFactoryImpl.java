/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.resultdecorator.resourceenvironmentdecorator.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;

import de.uka.ipd.sdq.pcm.resultdecorator.resourceenvironmentdecorator.LinkingResourceResults;
import de.uka.ipd.sdq.pcm.resultdecorator.resourceenvironmentdecorator.PassiveResourceResult;
import de.uka.ipd.sdq.pcm.resultdecorator.resourceenvironmentdecorator.ProcessingResourceSpecificationResult;
import de.uka.ipd.sdq.pcm.resultdecorator.resourceenvironmentdecorator.ResourceContainerResults;
import de.uka.ipd.sdq.pcm.resultdecorator.resourceenvironmentdecorator.ResourceenvironmentdecoratorFactory;
import de.uka.ipd.sdq.pcm.resultdecorator.resourceenvironmentdecorator.ResourceenvironmentdecoratorPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ResourceenvironmentdecoratorFactoryImpl extends EFactoryImpl implements ResourceenvironmentdecoratorFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ResourceenvironmentdecoratorFactory init() {
		try {
			ResourceenvironmentdecoratorFactory theResourceenvironmentdecoratorFactory = (ResourceenvironmentdecoratorFactory)EPackage.Registry.INSTANCE.getEFactory("http://sdq.ipd.uka.de/ResultDecorator/ResourceEnvironment/1.0"); 
			if (theResourceenvironmentdecoratorFactory != null) {
				return theResourceenvironmentdecoratorFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new ResourceenvironmentdecoratorFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResourceenvironmentdecoratorFactoryImpl() {
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
			case ResourceenvironmentdecoratorPackage.LINKING_RESOURCE_RESULTS: return createLinkingResourceResults();
			case ResourceenvironmentdecoratorPackage.RESOURCE_CONTAINER_RESULTS: return createResourceContainerResults();
			case ResourceenvironmentdecoratorPackage.PROCESSING_RESOURCE_SPECIFICATION_RESULT: return createProcessingResourceSpecificationResult();
			case ResourceenvironmentdecoratorPackage.PASSIVE_RESOURCE_RESULT: return createPassiveResourceResult();
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
	public ProcessingResourceSpecificationResult createProcessingResourceSpecificationResult() {
		ProcessingResourceSpecificationResultImpl processingResourceSpecificationResult = new ProcessingResourceSpecificationResultImpl();
		return processingResourceSpecificationResult;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PassiveResourceResult createPassiveResourceResult() {
		PassiveResourceResultImpl passiveResourceResult = new PassiveResourceResultImpl();
		return passiveResourceResult;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResourceenvironmentdecoratorPackage getResourceenvironmentdecoratorPackage() {
		return (ResourceenvironmentdecoratorPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static ResourceenvironmentdecoratorPackage getPackage() {
		return ResourceenvironmentdecoratorPackage.eINSTANCE;
	}

} //ResourceenvironmentdecoratorFactoryImpl
