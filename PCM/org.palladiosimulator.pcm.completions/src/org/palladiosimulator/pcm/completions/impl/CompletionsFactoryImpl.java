/**
 * Copyright SDQ, IPD, U Karlsruhe, 2007
 */
package org.palladiosimulator.pcm.completions.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.palladiosimulator.pcm.completions.Completion;
import org.palladiosimulator.pcm.completions.CompletionRepository;
import org.palladiosimulator.pcm.completions.CompletionsFactory;
import org.palladiosimulator.pcm.completions.CompletionsPackage;
import org.palladiosimulator.pcm.completions.DelegatingExternalCallAction;
import org.palladiosimulator.pcm.completions.NetworkDemandParametricResourceDemand;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Factory</b>. <!-- end-user-doc -->
 *
 * @generated
 */
public class CompletionsFactoryImpl extends EFactoryImpl implements CompletionsFactory {

    /**
     * Creates the default factory implementation. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public static CompletionsFactory init() {
        try {
            final CompletionsFactory theCompletionsFactory = (CompletionsFactory) EPackage.Registry.INSTANCE
                    .getEFactory(CompletionsPackage.eNS_URI);
            if (theCompletionsFactory != null) {
                return theCompletionsFactory;
            }
        } catch (final Exception exception) {
            EcorePlugin.INSTANCE.log(exception);
        }
        return new CompletionsFactoryImpl();
    }

    /**
     * Creates an instance of the factory. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public CompletionsFactoryImpl() {
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
        case CompletionsPackage.COMPLETION:
            return this.createCompletion();
        case CompletionsPackage.COMPLETION_REPOSITORY:
            return this.createCompletionRepository();
        case CompletionsPackage.DELEGATING_EXTERNAL_CALL_ACTION:
            return this.createDelegatingExternalCallAction();
        case CompletionsPackage.NETWORK_DEMAND_PARAMETRIC_RESOURCE_DEMAND:
            return this.createNetworkDemandParametricResourceDemand();
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
    public Completion createCompletion() {
        final CompletionImpl completion = new CompletionImpl();
        return completion;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public CompletionRepository createCompletionRepository() {
        final CompletionRepositoryImpl completionRepository = new CompletionRepositoryImpl();
        return completionRepository;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public DelegatingExternalCallAction createDelegatingExternalCallAction() {
        final DelegatingExternalCallActionImpl delegatingExternalCallAction = new DelegatingExternalCallActionImpl();
        return delegatingExternalCallAction;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public NetworkDemandParametricResourceDemand createNetworkDemandParametricResourceDemand() {
        final NetworkDemandParametricResourceDemandImpl networkDemandParametricResourceDemand = new NetworkDemandParametricResourceDemandImpl();
        return networkDemandParametricResourceDemand;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public CompletionsPackage getCompletionsPackage() {
        return (CompletionsPackage) this.getEPackage();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @deprecated
     * @generated
     */
    @Deprecated
    public static CompletionsPackage getPackage() {
        return CompletionsPackage.eINSTANCE;
    }

} // CompletionsFactoryImpl
