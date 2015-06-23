/**
 * Copyright SDQ, IPD, U Karlsruhe, 2007
 */
package org.palladiosimulator.pcm.completions.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.ecore.EObject;
import org.palladiosimulator.pcm.completions.Completion;
import org.palladiosimulator.pcm.completions.CompletionRepository;
import org.palladiosimulator.pcm.completions.CompletionsPackage;
import org.palladiosimulator.pcm.completions.DelegatingExternalCallAction;
import org.palladiosimulator.pcm.completions.NetworkDemandParametricResourceDemand;

import de.uka.ipd.sdq.identifier.Identifier;

/**
 * <!-- begin-user-doc --> The <b>Adapter Factory</b> for the model. It provides an adapter
 * <code>createXXX</code> method for each class of the model. <!-- end-user-doc -->
 * 
 * @see org.palladiosimulator.pcm.completions.CompletionsPackage
 * @generated
 */
public class CompletionsAdapterFactory extends AdapterFactoryImpl {

    /**
     * The cached model package. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected static CompletionsPackage modelPackage;

    /**
     * Creates an instance of the adapter factory. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public CompletionsAdapterFactory() {
        if (modelPackage == null) {
            modelPackage = CompletionsPackage.eINSTANCE;
        }
    }

    /**
     * Returns whether this factory is applicable for the type of the object. <!-- begin-user-doc
     * --> This implementation returns <code>true</code> if the object is either the model's package
     * or is an instance object of the model. <!-- end-user-doc -->
     * 
     * @return whether this factory is applicable for the type of the object.
     * @generated
     */
    @Override
    public boolean isFactoryForType(final Object object) {
        if (object == modelPackage) {
            return true;
        }
        if (object instanceof EObject) {
            return ((EObject) object).eClass().getEPackage() == modelPackage;
        }
        return false;
    }

    /**
     * The switch that delegates to the <code>createXXX</code> methods. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     */
    protected CompletionsSwitch<Adapter> modelSwitch = new CompletionsSwitch<Adapter>() {

        @Override
        public Adapter caseCompletion(final Completion object) {
            return CompletionsAdapterFactory.this.createCompletionAdapter();
        }

        @Override
        public Adapter caseCompletionRepository(final CompletionRepository object) {
            return CompletionsAdapterFactory.this.createCompletionRepositoryAdapter();
        }

        @Override
        public Adapter caseDelegatingExternalCallAction(final DelegatingExternalCallAction object) {
            return CompletionsAdapterFactory.this.createDelegatingExternalCallActionAdapter();
        }

        @Override
        public Adapter caseNetworkDemandParametricResourceDemand(final NetworkDemandParametricResourceDemand object) {
            return CompletionsAdapterFactory.this.createNetworkDemandParametricResourceDemandAdapter();
        }

        @Override
        public Adapter caseIdentifier(final Identifier object) {
            return CompletionsAdapterFactory.this.createIdentifierAdapter();
        }

        @Override
        public Adapter caseNamedElement(final org.palladiosimulator.pcm.core.entity.NamedElement object) {
            return CompletionsAdapterFactory.this.createNamedElementAdapter();
        }

        @Override
        public Adapter caseEntity(final org.palladiosimulator.pcm.core.entity.Entity object) {
            return CompletionsAdapterFactory.this.createEntityAdapter();
        }

        @Override
        public Adapter caseComposedStructure(final org.palladiosimulator.pcm.core.composition.ComposedStructure object) {
            return CompletionsAdapterFactory.this.createComposedStructureAdapter();
        }

        @Override
        public Adapter caseInterfaceProvidingEntity(
                final org.palladiosimulator.pcm.core.entity.InterfaceProvidingEntity object) {
            return CompletionsAdapterFactory.this.createInterfaceProvidingEntityAdapter();
        }

        @Override
        public Adapter caseResourceInterfaceRequiringEntity(
                final org.palladiosimulator.pcm.core.entity.ResourceInterfaceRequiringEntity object) {
            return CompletionsAdapterFactory.this.createResourceInterfaceRequiringEntityAdapter();
        }

        @Override
        public Adapter caseInterfaceRequiringEntity(
                final org.palladiosimulator.pcm.core.entity.InterfaceRequiringEntity object) {
            return CompletionsAdapterFactory.this.createInterfaceRequiringEntityAdapter();
        }

        @Override
        public Adapter caseInterfaceProvidingRequiringEntity(
                final org.palladiosimulator.pcm.core.entity.InterfaceProvidingRequiringEntity object) {
            return CompletionsAdapterFactory.this.createInterfaceProvidingRequiringEntityAdapter();
        }

        @Override
        public Adapter caseComposedProvidingRequiringEntity(
                final org.palladiosimulator.pcm.core.entity.ComposedProvidingRequiringEntity object) {
            return CompletionsAdapterFactory.this.createComposedProvidingRequiringEntityAdapter();
        }

        @Override
        public Adapter caseRepositoryComponent(final org.palladiosimulator.pcm.repository.RepositoryComponent object) {
            return CompletionsAdapterFactory.this.createRepositoryComponentAdapter();
        }

        @Override
        public Adapter caseImplementationComponentType(
                final org.palladiosimulator.pcm.repository.ImplementationComponentType object) {
            return CompletionsAdapterFactory.this.createImplementationComponentTypeAdapter();
        }

        @Override
        public Adapter caseAbstractAction(final org.palladiosimulator.pcm.seff.AbstractAction object) {
            return CompletionsAdapterFactory.this.createAbstractActionAdapter();
        }

        @Override
        public Adapter caseCallAction(final org.palladiosimulator.pcm.seff.CallAction object) {
            return CompletionsAdapterFactory.this.createCallActionAdapter();
        }

        @Override
        public Adapter caseCallReturnAction(final org.palladiosimulator.pcm.seff.CallReturnAction object) {
            return CompletionsAdapterFactory.this.createCallReturnActionAdapter();
        }

        @Override
        public Adapter caseFailureHandlingEntity(
                final org.palladiosimulator.pcm.seff.seff_reliability.FailureHandlingEntity object) {
            return CompletionsAdapterFactory.this.createFailureHandlingEntityAdapter();
        }

        @Override
        public Adapter caseExternalCallAction(final org.palladiosimulator.pcm.seff.ExternalCallAction object) {
            return CompletionsAdapterFactory.this.createExternalCallActionAdapter();
        }

        @Override
        public Adapter caseParametricResourceDemand(
                final org.palladiosimulator.pcm.seff.seff_performance.ParametricResourceDemand object) {
            return CompletionsAdapterFactory.this.createParametricResourceDemandAdapter();
        }

        @Override
        public Adapter defaultCase(final EObject object) {
            return CompletionsAdapterFactory.this.createEObjectAdapter();
        }
    };

    /**
     * Creates an adapter for the <code>target</code>. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param target
     *            the object to adapt.
     * @return the adapter for the <code>target</code>.
     * @generated
     */
    @Override
    public Adapter createAdapter(final Notifier target) {
        return this.modelSwitch.doSwitch((EObject) target);
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link org.palladiosimulator.pcm.completions.Completion <em>Completion</em>}'. <!--
     * begin-user-doc --> This default implementation returns null so that we can easily ignore
     * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
     * end-user-doc -->
     *
     * @return the new adapter.
     * @see org.palladiosimulator.pcm.completions.Completion
     * @generated
     */
    public Adapter createCompletionAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link org.palladiosimulator.pcm.completions.CompletionRepository
     * <em>Completion Repository</em>}'. <!-- begin-user-doc --> This default implementation returns
     * null so that we can easily ignore cases; it's useful to ignore a case when inheritance will
     * catch all the cases anyway. <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see org.palladiosimulator.pcm.completions.CompletionRepository
     * @generated
     */
    public Adapter createCompletionRepositoryAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link org.palladiosimulator.pcm.completions.DelegatingExternalCallAction
     * <em>Delegating External Call Action</em>}'. <!-- begin-user-doc --> This default
     * implementation returns null so that we can easily ignore cases; it's useful to ignore a case
     * when inheritance will catch all the cases anyway. <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see org.palladiosimulator.pcm.completions.DelegatingExternalCallAction
     * @generated
     */
    public Adapter createDelegatingExternalCallActionAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link org.palladiosimulator.pcm.completions.NetworkDemandParametricResourceDemand
     * <em>Network Demand Parametric Resource Demand</em>}'. <!-- begin-user-doc --> This default
     * implementation returns null so that we can easily ignore cases; it's useful to ignore a case
     * when inheritance will catch all the cases anyway. <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see org.palladiosimulator.pcm.completions.NetworkDemandParametricResourceDemand
     * @generated
     */
    public Adapter createNetworkDemandParametricResourceDemandAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.identifier.Identifier
     * <em>Identifier</em>}'. <!-- begin-user-doc --> This default implementation returns null so
     * that we can easily ignore cases; it's useful to ignore a case when inheritance will catch all
     * the cases anyway. <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see de.uka.ipd.sdq.identifier.Identifier
     * @generated
     */
    public Adapter createIdentifierAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link org.palladiosimulator.pcm.core.entity.NamedElement <em>Named Element</em>}'. <!--
     * begin-user-doc --> This default implementation returns null so that we can easily ignore
     * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
     * end-user-doc -->
     *
     * @return the new adapter.
     * @see org.palladiosimulator.pcm.core.entity.NamedElement
     * @generated
     */
    public Adapter createNamedElementAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.palladiosimulator.pcm.core.entity.Entity
     * <em>Entity</em>}'. <!-- begin-user-doc --> This default implementation returns null so that
     * we can easily ignore cases; it's useful to ignore a case when inheritance will catch all the
     * cases anyway. <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see org.palladiosimulator.pcm.core.entity.Entity
     * @generated
     */
    public Adapter createEntityAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link org.palladiosimulator.pcm.core.composition.ComposedStructure <em>Composed Structure</em>}'.
     * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
     * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
     * end-user-doc -->
     * 
     * @return the new adapter.
     * @see org.palladiosimulator.pcm.core.composition.ComposedStructure
     * @generated
     */
    public Adapter createComposedStructureAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link org.palladiosimulator.pcm.core.entity.InterfaceProvidingEntity
     * <em>Interface Providing Entity</em>}'. <!-- begin-user-doc --> This default implementation
     * returns null so that we can easily ignore cases; it's useful to ignore a case when
     * inheritance will catch all the cases anyway. <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see org.palladiosimulator.pcm.core.entity.InterfaceProvidingEntity
     * @generated
     */
    public Adapter createInterfaceProvidingEntityAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link org.palladiosimulator.pcm.core.entity.ResourceInterfaceRequiringEntity
     * <em>Resource Interface Requiring Entity</em>}'. <!-- begin-user-doc --> This default
     * implementation returns null so that we can easily ignore cases; it's useful to ignore a case
     * when inheritance will catch all the cases anyway. <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see org.palladiosimulator.pcm.core.entity.ResourceInterfaceRequiringEntity
     * @generated
     */
    public Adapter createResourceInterfaceRequiringEntityAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link org.palladiosimulator.pcm.core.entity.InterfaceRequiringEntity
     * <em>Interface Requiring Entity</em>}'. <!-- begin-user-doc --> This default implementation
     * returns null so that we can easily ignore cases; it's useful to ignore a case when
     * inheritance will catch all the cases anyway. <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see org.palladiosimulator.pcm.core.entity.InterfaceRequiringEntity
     * @generated
     */
    public Adapter createInterfaceRequiringEntityAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link org.palladiosimulator.pcm.core.entity.InterfaceProvidingRequiringEntity
     * <em>Interface Providing Requiring Entity</em>}'. <!-- begin-user-doc --> This default
     * implementation returns null so that we can easily ignore cases; it's useful to ignore a case
     * when inheritance will catch all the cases anyway. <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see org.palladiosimulator.pcm.core.entity.InterfaceProvidingRequiringEntity
     * @generated
     */
    public Adapter createInterfaceProvidingRequiringEntityAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link org.palladiosimulator.pcm.core.entity.ComposedProvidingRequiringEntity
     * <em>Composed Providing Requiring Entity</em>}'. <!-- begin-user-doc --> This default
     * implementation returns null so that we can easily ignore cases; it's useful to ignore a case
     * when inheritance will catch all the cases anyway. <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see org.palladiosimulator.pcm.core.entity.ComposedProvidingRequiringEntity
     * @generated
     */
    public Adapter createComposedProvidingRequiringEntityAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link org.palladiosimulator.pcm.repository.RepositoryComponent <em>Component</em>}'. <!--
     * begin-user-doc --> This default implementation returns null so that we can easily ignore
     * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
     * end-user-doc -->
     *
     * @return the new adapter.
     * @see org.palladiosimulator.pcm.repository.RepositoryComponent
     * @generated
     */
    public Adapter createRepositoryComponentAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link org.palladiosimulator.pcm.repository.ImplementationComponentType
     * <em>Implementation Component Type</em>}'. <!-- begin-user-doc --> This default implementation
     * returns null so that we can easily ignore cases; it's useful to ignore a case when
     * inheritance will catch all the cases anyway. <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see org.palladiosimulator.pcm.repository.ImplementationComponentType
     * @generated
     */
    public Adapter createImplementationComponentTypeAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.palladiosimulator.pcm.seff.AbstractAction
     * <em>Abstract Action</em>}'. <!-- begin-user-doc --> This default implementation returns null
     * so that we can easily ignore cases; it's useful to ignore a case when inheritance will catch
     * all the cases anyway. <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see org.palladiosimulator.pcm.seff.AbstractAction
     * @generated
     */
    public Adapter createAbstractActionAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.palladiosimulator.pcm.seff.CallAction
     * <em>Call Action</em>}'. <!-- begin-user-doc --> This default implementation returns null so
     * that we can easily ignore cases; it's useful to ignore a case when inheritance will catch all
     * the cases anyway. <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see org.palladiosimulator.pcm.seff.CallAction
     * @generated
     */
    public Adapter createCallActionAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.palladiosimulator.pcm.seff.CallReturnAction
     * <em>Call Return Action</em>}'. <!-- begin-user-doc --> This default implementation returns
     * null so that we can easily ignore cases; it's useful to ignore a case when inheritance will
     * catch all the cases anyway. <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see org.palladiosimulator.pcm.seff.CallReturnAction
     * @generated
     */
    public Adapter createCallReturnActionAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link org.palladiosimulator.pcm.seff.seff_reliability.FailureHandlingEntity
     * <em>Failure Handling Entity</em>}'. <!-- begin-user-doc --> This default implementation
     * returns null so that we can easily ignore cases; it's useful to ignore a case when
     * inheritance will catch all the cases anyway. <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see org.palladiosimulator.pcm.seff.seff_reliability.FailureHandlingEntity
     * @generated
     */
    public Adapter createFailureHandlingEntityAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link org.palladiosimulator.pcm.seff.ExternalCallAction <em>External Call Action</em>}'.
     * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
     * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
     * end-user-doc -->
     *
     * @return the new adapter.
     * @see org.palladiosimulator.pcm.seff.ExternalCallAction
     * @generated
     */
    public Adapter createExternalCallActionAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link org.palladiosimulator.pcm.seff.seff_performance.ParametricResourceDemand
     * <em>Parametric Resource Demand</em>}'. <!-- begin-user-doc --> This default implementation
     * returns null so that we can easily ignore cases; it's useful to ignore a case when
     * inheritance will catch all the cases anyway. <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see org.palladiosimulator.pcm.seff.seff_performance.ParametricResourceDemand
     * @generated
     */
    public Adapter createParametricResourceDemandAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for the default case. <!-- begin-user-doc --> This default
     * implementation returns null. <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @generated
     */
    public Adapter createEObjectAdapter() {
        return null;
    }

} // CompletionsAdapterFactory
