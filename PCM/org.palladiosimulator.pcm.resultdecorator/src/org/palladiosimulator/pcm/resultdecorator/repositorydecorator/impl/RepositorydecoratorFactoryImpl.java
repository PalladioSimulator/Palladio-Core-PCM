/**
 */
package org.palladiosimulator.pcm.resultdecorator.repositorydecorator.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.palladiosimulator.pcm.resultdecorator.repositorydecorator.AllocationContextResults;
import org.palladiosimulator.pcm.resultdecorator.repositorydecorator.AllocationServiceResult;
import org.palladiosimulator.pcm.resultdecorator.repositorydecorator.InterfaceProvidingRequiringEntityResults;
import org.palladiosimulator.pcm.resultdecorator.repositorydecorator.RepositorydecoratorFactory;
import org.palladiosimulator.pcm.resultdecorator.repositorydecorator.RepositorydecoratorPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Factory</b>. <!-- end-user-doc -->
 *
 * @generated
 */
public class RepositorydecoratorFactoryImpl extends EFactoryImpl implements RepositorydecoratorFactory {

    /**
     * Creates the default factory implementation. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public static RepositorydecoratorFactory init() {
        try {
            final RepositorydecoratorFactory theRepositorydecoratorFactory = (RepositorydecoratorFactory) EPackage.Registry.INSTANCE
                    .getEFactory(RepositorydecoratorPackage.eNS_URI);
            if (theRepositorydecoratorFactory != null) {
                return theRepositorydecoratorFactory;
            }
        } catch (final Exception exception) {
            EcorePlugin.INSTANCE.log(exception);
        }
        return new RepositorydecoratorFactoryImpl();
    }

    /**
     * Creates an instance of the factory. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public RepositorydecoratorFactoryImpl() {
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
        case RepositorydecoratorPackage.INTERFACE_PROVIDING_REQUIRING_ENTITY_RESULTS:
            return this.createInterfaceProvidingRequiringEntityResults();
        case RepositorydecoratorPackage.ALLOCATION_CONTEXT_RESULTS:
            return this.createAllocationContextResults();
        case RepositorydecoratorPackage.ALLOCATION_SERVICE_RESULT:
            return this.createAllocationServiceResult();
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
    public InterfaceProvidingRequiringEntityResults createInterfaceProvidingRequiringEntityResults() {
        final InterfaceProvidingRequiringEntityResultsImpl interfaceProvidingRequiringEntityResults = new InterfaceProvidingRequiringEntityResultsImpl();
        return interfaceProvidingRequiringEntityResults;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public AllocationContextResults createAllocationContextResults() {
        final AllocationContextResultsImpl allocationContextResults = new AllocationContextResultsImpl();
        return allocationContextResults;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public AllocationServiceResult createAllocationServiceResult() {
        final AllocationServiceResultImpl allocationServiceResult = new AllocationServiceResultImpl();
        return allocationServiceResult;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public RepositorydecoratorPackage getRepositorydecoratorPackage() {
        return (RepositorydecoratorPackage) this.getEPackage();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @deprecated
     * @generated
     */
    @Deprecated
    public static RepositorydecoratorPackage getPackage() {
        return RepositorydecoratorPackage.eINSTANCE;
    }

} // RepositorydecoratorFactoryImpl
