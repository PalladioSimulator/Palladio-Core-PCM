/**
 */
package org.palladiosimulator.pcm.resultdecorator.repositorydecorator.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.ecore.EObject;
import org.palladiosimulator.pcm.resultdecorator.repositorydecorator.AllocationContextResults;
import org.palladiosimulator.pcm.resultdecorator.repositorydecorator.AllocationServiceResult;
import org.palladiosimulator.pcm.resultdecorator.repositorydecorator.ComponentResult;
import org.palladiosimulator.pcm.resultdecorator.repositorydecorator.InterfaceProvidingRequiringEntityResults;
import org.palladiosimulator.pcm.resultdecorator.repositorydecorator.RepositorydecoratorPackage;
import org.palladiosimulator.pcm.resultdecorator.repositorydecorator.ServiceResult;

import org.palladiosimulator.pcm.core.entity.NamedElement;

/**
 * <!-- begin-user-doc --> The <b>Adapter Factory</b> for the model. It provides an adapter
 * <code>createXXX</code> method for each class of the model. <!-- end-user-doc -->
 *
 * @see org.palladiosimulator.pcm.resultdecorator.repositorydecorator.RepositorydecoratorPackage
 * @generated
 */
public class RepositorydecoratorAdapterFactory extends AdapterFactoryImpl {

    /**
     * The cached model package. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected static RepositorydecoratorPackage modelPackage;

    /**
     * Creates an instance of the adapter factory. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public RepositorydecoratorAdapterFactory() {
        if (modelPackage == null) {
            modelPackage = RepositorydecoratorPackage.eINSTANCE;
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
    protected RepositorydecoratorSwitch<Adapter> modelSwitch = new RepositorydecoratorSwitch<Adapter>() {

        @Override
        public Adapter caseInterfaceProvidingRequiringEntityResults(
                final InterfaceProvidingRequiringEntityResults object) {
            return RepositorydecoratorAdapterFactory.this.createInterfaceProvidingRequiringEntityResultsAdapter();
        }

        @Override
        public Adapter caseComponentResult(final ComponentResult object) {
            return RepositorydecoratorAdapterFactory.this.createComponentResultAdapter();
        }

        @Override
        public Adapter caseAllocationContextResults(final AllocationContextResults object) {
            return RepositorydecoratorAdapterFactory.this.createAllocationContextResultsAdapter();
        }

        @Override
        public Adapter caseServiceResult(final ServiceResult object) {
            return RepositorydecoratorAdapterFactory.this.createServiceResultAdapter();
        }

        @Override
        public Adapter caseAllocationServiceResult(final AllocationServiceResult object) {
            return RepositorydecoratorAdapterFactory.this.createAllocationServiceResultAdapter();
        }

        @Override
        public Adapter caseNamedElement(final NamedElement object) {
            return RepositorydecoratorAdapterFactory.this.createNamedElementAdapter();
        }

        @Override
        public Adapter defaultCase(final EObject object) {
            return RepositorydecoratorAdapterFactory.this.createEObjectAdapter();
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
     * {@link org.palladiosimulator.pcm.resultdecorator.repositorydecorator.InterfaceProvidingRequiringEntityResults
     * <em>Interface Providing Requiring Entity Results</em>}'. <!-- begin-user-doc --> This default
     * implementation returns null so that we can easily ignore cases; it's useful to ignore a case
     * when inheritance will catch all the cases anyway. <!-- end-user-doc -->
     *
     * @return the new adapter.
     * @see org.palladiosimulator.pcm.resultdecorator.repositorydecorator.
     *      InterfaceProvidingRequiringEntityResults
     * @generated
     */
    public Adapter createInterfaceProvidingRequiringEntityResultsAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link org.palladiosimulator.pcm.resultdecorator.repositorydecorator.ComponentResult
     * <em>Component Result</em>}'. <!-- begin-user-doc --> This default implementation returns null
     * so that we can easily ignore cases; it's useful to ignore a case when inheritance will catch
     * all the cases anyway. <!-- end-user-doc -->
     *
     * @return the new adapter.
     * @see org.palladiosimulator.pcm.resultdecorator.repositorydecorator.ComponentResult
     * @generated
     */
    public Adapter createComponentResultAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link org.palladiosimulator.pcm.resultdecorator.repositorydecorator.AllocationContextResults
     * <em>Allocation Context Results</em>}'. <!-- begin-user-doc --> This default implementation
     * returns null so that we can easily ignore cases; it's useful to ignore a case when
     * inheritance will catch all the cases anyway. <!-- end-user-doc -->
     *
     * @return the new adapter.
     * @see org.palladiosimulator.pcm.resultdecorator.repositorydecorator.AllocationContextResults
     * @generated
     */
    public Adapter createAllocationContextResultsAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link org.palladiosimulator.pcm.resultdecorator.repositorydecorator.ServiceResult
     * <em>Service Result</em>}'. <!-- begin-user-doc --> This default implementation returns null
     * so that we can easily ignore cases; it's useful to ignore a case when inheritance will catch
     * all the cases anyway. <!-- end-user-doc -->
     *
     * @return the new adapter.
     * @see org.palladiosimulator.pcm.resultdecorator.repositorydecorator.ServiceResult
     * @generated
     */
    public Adapter createServiceResultAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link org.palladiosimulator.pcm.resultdecorator.repositorydecorator.AllocationServiceResult
     * <em>Allocation Service Result</em>}'. <!-- begin-user-doc --> This default implementation
     * returns null so that we can easily ignore cases; it's useful to ignore a case when
     * inheritance will catch all the cases anyway. <!-- end-user-doc -->
     *
     * @return the new adapter.
     * @see org.palladiosimulator.pcm.resultdecorator.repositorydecorator.AllocationServiceResult
     * @generated
     */
    public Adapter createAllocationServiceResultAdapter() {
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
     * Creates a new adapter for the default case. <!-- begin-user-doc --> This default
     * implementation returns null. <!-- end-user-doc -->
     *
     * @return the new adapter.
     * @generated
     */
    public Adapter createEObjectAdapter() {
        return null;
    }

} // RepositorydecoratorAdapterFactory
