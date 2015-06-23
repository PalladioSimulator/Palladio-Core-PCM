/**
 */
package org.palladiosimulator.pcm.resultdecorator.resourceenvironmentdecorator.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.palladiosimulator.pcm.resultdecorator.resourceenvironmentdecorator.LinkingResourceResults;
import org.palladiosimulator.pcm.resultdecorator.resourceenvironmentdecorator.PassiveResourceResult;
import org.palladiosimulator.pcm.resultdecorator.resourceenvironmentdecorator.ProcessingResourceSpecificationResult;
import org.palladiosimulator.pcm.resultdecorator.resourceenvironmentdecorator.ResourceContainerResults;
import org.palladiosimulator.pcm.resultdecorator.resourceenvironmentdecorator.ResourceenvironmentdecoratorFactory;
import org.palladiosimulator.pcm.resultdecorator.resourceenvironmentdecorator.ResourceenvironmentdecoratorPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Factory</b>. <!-- end-user-doc -->
 *
 * @generated
 */
public class ResourceenvironmentdecoratorFactoryImpl extends EFactoryImpl
        implements ResourceenvironmentdecoratorFactory {

    /**
     * Creates the default factory implementation. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public static ResourceenvironmentdecoratorFactory init() {
        try {
            final ResourceenvironmentdecoratorFactory theResourceenvironmentdecoratorFactory = (ResourceenvironmentdecoratorFactory) EPackage.Registry.INSTANCE
                    .getEFactory(ResourceenvironmentdecoratorPackage.eNS_URI);
            if (theResourceenvironmentdecoratorFactory != null) {
                return theResourceenvironmentdecoratorFactory;
            }
        } catch (final Exception exception) {
            EcorePlugin.INSTANCE.log(exception);
        }
        return new ResourceenvironmentdecoratorFactoryImpl();
    }

    /**
     * Creates an instance of the factory. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public ResourceenvironmentdecoratorFactoryImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EObject create(final EClass eClass) {
        switch (eClass.getClassifierID()) {
        case ResourceenvironmentdecoratorPackage.LINKING_RESOURCE_RESULTS:
            return this.createLinkingResourceResults();
        case ResourceenvironmentdecoratorPackage.RESOURCE_CONTAINER_RESULTS:
            return this.createResourceContainerResults();
        case ResourceenvironmentdecoratorPackage.PROCESSING_RESOURCE_SPECIFICATION_RESULT:
            return this.createProcessingResourceSpecificationResult();
        case ResourceenvironmentdecoratorPackage.PASSIVE_RESOURCE_RESULT:
            return this.createPassiveResourceResult();
        default:
            throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public LinkingResourceResults createLinkingResourceResults() {
        final LinkingResourceResultsImpl linkingResourceResults = new LinkingResourceResultsImpl();
        return linkingResourceResults;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public ResourceContainerResults createResourceContainerResults() {
        final ResourceContainerResultsImpl resourceContainerResults = new ResourceContainerResultsImpl();
        return resourceContainerResults;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public ProcessingResourceSpecificationResult createProcessingResourceSpecificationResult() {
        final ProcessingResourceSpecificationResultImpl processingResourceSpecificationResult = new ProcessingResourceSpecificationResultImpl();
        return processingResourceSpecificationResult;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public PassiveResourceResult createPassiveResourceResult() {
        final PassiveResourceResultImpl passiveResourceResult = new PassiveResourceResultImpl();
        return passiveResourceResult;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public ResourceenvironmentdecoratorPackage getResourceenvironmentdecoratorPackage() {
        return (ResourceenvironmentdecoratorPackage) this.getEPackage();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @deprecated
     * @generated
     */
    @Deprecated
    public static ResourceenvironmentdecoratorPackage getPackage() {
        return ResourceenvironmentdecoratorPackage.eINSTANCE;
    }

} // ResourceenvironmentdecoratorFactoryImpl
