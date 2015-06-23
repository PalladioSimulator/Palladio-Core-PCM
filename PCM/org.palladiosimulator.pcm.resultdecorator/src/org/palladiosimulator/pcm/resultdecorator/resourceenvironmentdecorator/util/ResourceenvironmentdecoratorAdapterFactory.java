/**
 */
package org.palladiosimulator.pcm.resultdecorator.resourceenvironmentdecorator.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.ecore.EObject;
import org.palladiosimulator.pcm.resultdecorator.resourceenvironmentdecorator.ActiveResourceUtilisationResult;
import org.palladiosimulator.pcm.resultdecorator.resourceenvironmentdecorator.LinkingResourceResults;
import org.palladiosimulator.pcm.resultdecorator.resourceenvironmentdecorator.PassiveResourceResult;
import org.palladiosimulator.pcm.resultdecorator.resourceenvironmentdecorator.ProcessingResourceSpecificationResult;
import org.palladiosimulator.pcm.resultdecorator.resourceenvironmentdecorator.ResourceContainerResults;
import org.palladiosimulator.pcm.resultdecorator.resourceenvironmentdecorator.ResourceenvironmentdecoratorPackage;
import org.palladiosimulator.pcm.resultdecorator.resourceenvironmentdecorator.UtilisationResult;

import de.uka.ipd.sdq.pcm.core.entity.NamedElement;

/**
 * <!-- begin-user-doc --> The <b>Adapter Factory</b> for the model. It provides an adapter
 * <code>createXXX</code> method for each class of the model. <!-- end-user-doc -->
 *
 * @see org.palladiosimulator.pcm.resultdecorator.resourceenvironmentdecorator.
 *      ResourceenvironmentdecoratorPackage
 * @generated
 */
public class ResourceenvironmentdecoratorAdapterFactory extends AdapterFactoryImpl {

    /**
     * The cached model package. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected static ResourceenvironmentdecoratorPackage modelPackage;

    /**
     * Creates an instance of the adapter factory. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public ResourceenvironmentdecoratorAdapterFactory() {
        if (modelPackage == null) {
            modelPackage = ResourceenvironmentdecoratorPackage.eINSTANCE;
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
    protected ResourceenvironmentdecoratorSwitch<Adapter> modelSwitch = new ResourceenvironmentdecoratorSwitch<Adapter>() {

        @Override
        public Adapter caseLinkingResourceResults(final LinkingResourceResults object) {
            return ResourceenvironmentdecoratorAdapterFactory.this.createLinkingResourceResultsAdapter();
        }

        @Override
        public Adapter caseActiveResourceUtilisationResult(final ActiveResourceUtilisationResult object) {
            return ResourceenvironmentdecoratorAdapterFactory.this.createActiveResourceUtilisationResultAdapter();
        }

        @Override
        public Adapter caseUtilisationResult(final UtilisationResult object) {
            return ResourceenvironmentdecoratorAdapterFactory.this.createUtilisationResultAdapter();
        }

        @Override
        public Adapter caseResourceContainerResults(final ResourceContainerResults object) {
            return ResourceenvironmentdecoratorAdapterFactory.this.createResourceContainerResultsAdapter();
        }

        @Override
        public Adapter caseProcessingResourceSpecificationResult(final ProcessingResourceSpecificationResult object) {
            return ResourceenvironmentdecoratorAdapterFactory.this.createProcessingResourceSpecificationResultAdapter();
        }

        @Override
        public Adapter casePassiveResourceResult(final PassiveResourceResult object) {
            return ResourceenvironmentdecoratorAdapterFactory.this.createPassiveResourceResultAdapter();
        }

        @Override
        public Adapter caseNamedElement(final NamedElement object) {
            return ResourceenvironmentdecoratorAdapterFactory.this.createNamedElementAdapter();
        }

        @Override
        public Adapter defaultCase(final EObject object) {
            return ResourceenvironmentdecoratorAdapterFactory.this.createEObjectAdapter();
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
     * {@link org.palladiosimulator.pcm.resultdecorator.resourceenvironmentdecorator.LinkingResourceResults
     * <em>Linking Resource Results</em>}'. <!-- begin-user-doc --> This default implementation
     * returns null so that we can easily ignore cases; it's useful to ignore a case when
     * inheritance will catch all the cases anyway. <!-- end-user-doc -->
     *
     * @return the new adapter.
     * @see org.palladiosimulator.pcm.resultdecorator.resourceenvironmentdecorator.
     *      LinkingResourceResults
     * @generated
     */
    public Adapter createLinkingResourceResultsAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link org.palladiosimulator.pcm.resultdecorator.resourceenvironmentdecorator.ActiveResourceUtilisationResult
     * <em>Active Resource Utilisation Result</em>}'. <!-- begin-user-doc --> This default
     * implementation returns null so that we can easily ignore cases; it's useful to ignore a case
     * when inheritance will catch all the cases anyway. <!-- end-user-doc -->
     *
     * @return the new adapter.
     * @see org.palladiosimulator.pcm.resultdecorator.resourceenvironmentdecorator.
     *      ActiveResourceUtilisationResult
     * @generated
     */
    public Adapter createActiveResourceUtilisationResultAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link org.palladiosimulator.pcm.resultdecorator.resourceenvironmentdecorator.UtilisationResult
     * <em>Utilisation Result</em>}'. <!-- begin-user-doc --> This default implementation returns
     * null so that we can easily ignore cases; it's useful to ignore a case when inheritance will
     * catch all the cases anyway. <!-- end-user-doc -->
     *
     * @return the new adapter.
     * @see org.palladiosimulator.pcm.resultdecorator.resourceenvironmentdecorator.UtilisationResult
     * @generated
     */
    public Adapter createUtilisationResultAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link org.palladiosimulator.pcm.resultdecorator.resourceenvironmentdecorator.ResourceContainerResults
     * <em>Resource Container Results</em>}'. <!-- begin-user-doc --> This default implementation
     * returns null so that we can easily ignore cases; it's useful to ignore a case when
     * inheritance will catch all the cases anyway. <!-- end-user-doc -->
     *
     * @return the new adapter.
     * @see org.palladiosimulator.pcm.resultdecorator.resourceenvironmentdecorator.
     *      ResourceContainerResults
     * @generated
     */
    public Adapter createResourceContainerResultsAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link org.palladiosimulator.pcm.resultdecorator.resourceenvironmentdecorator.ProcessingResourceSpecificationResult
     * <em>Processing Resource Specification Result</em>}'. <!-- begin-user-doc --> This default
     * implementation returns null so that we can easily ignore cases; it's useful to ignore a case
     * when inheritance will catch all the cases anyway. <!-- end-user-doc -->
     *
     * @return the new adapter.
     * @see org.palladiosimulator.pcm.resultdecorator.resourceenvironmentdecorator.
     *      ProcessingResourceSpecificationResult
     * @generated
     */
    public Adapter createProcessingResourceSpecificationResultAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link org.palladiosimulator.pcm.resultdecorator.resourceenvironmentdecorator.PassiveResourceResult
     * <em>Passive Resource Result</em>}'. <!-- begin-user-doc --> This default implementation
     * returns null so that we can easily ignore cases; it's useful to ignore a case when
     * inheritance will catch all the cases anyway. <!-- end-user-doc -->
     *
     * @return the new adapter.
     * @see org.palladiosimulator.pcm.resultdecorator.resourceenvironmentdecorator.
     *      PassiveResourceResult
     * @generated
     */
    public Adapter createPassiveResourceResultAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link de.uka.ipd.sdq.pcm.core.entity.NamedElement <em>Named Element</em>}'. <!--
     * begin-user-doc --> This default implementation returns null so that we can easily ignore
     * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
     * end-user-doc -->
     *
     * @return the new adapter.
     * @see de.uka.ipd.sdq.pcm.core.entity.NamedElement
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

} // ResourceenvironmentdecoratorAdapterFactory
