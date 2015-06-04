/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.fzi.se.quality.parameters.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.ecore.EObject;
import org.palladiosimulator.mdsdprofiles.StereotypableElement;

import de.fzi.se.quality.parameters.CallInstance;
import de.fzi.se.quality.parameters.ComponentInstance;
import de.fzi.se.quality.parameters.ComponentReference;
import de.fzi.se.quality.parameters.OperationReference;
import de.fzi.se.quality.parameters.ParameterInstance;
import de.fzi.se.quality.parameters.ParameterPartition;
import de.fzi.se.quality.parameters.ParameterReference;
import de.fzi.se.quality.parameters.ParameterValue;
import de.fzi.se.quality.parameters.ParametersPackage;
import de.uka.ipd.sdq.identifier.Identifier;

/**
 * <!-- begin-user-doc --> The <b>Adapter Factory</b> for the model. It provides an adapter
 * <code>createXXX</code> method for each class of the model. <!-- end-user-doc -->
 * 
 * @see de.fzi.se.quality.parameters.ParametersPackage
 * @generated
 */
public class ParametersAdapterFactory extends AdapterFactoryImpl {

    /**
     * The cached model package. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected static ParametersPackage modelPackage;

    /**
     * Creates an instance of the adapter factory. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public ParametersAdapterFactory() {
        if (modelPackage == null) {
            modelPackage = ParametersPackage.eINSTANCE;
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
    protected ParametersSwitch<Adapter> modelSwitch = new ParametersSwitch<Adapter>() {

        @Override
        public Adapter caseParameterPartition(final ParameterPartition object) {
            return ParametersAdapterFactory.this.createParameterPartitionAdapter();
        }

        @Override
        public Adapter caseParameterValue(final ParameterValue object) {
            return ParametersAdapterFactory.this.createParameterValueAdapter();
        }

        @Override
        public Adapter caseParameterInstance(final ParameterInstance object) {
            return ParametersAdapterFactory.this.createParameterInstanceAdapter();
        }

        @Override
        public Adapter caseCallInstance(final CallInstance object) {
            return ParametersAdapterFactory.this.createCallInstanceAdapter();
        }

        @Override
        public Adapter caseOperationReference(final OperationReference object) {
            return ParametersAdapterFactory.this.createOperationReferenceAdapter();
        }

        @Override
        public Adapter caseComponentInstance(final ComponentInstance object) {
            return ParametersAdapterFactory.this.createComponentInstanceAdapter();
        }

        @Override
        public Adapter caseComponentReference(final ComponentReference object) {
            return ParametersAdapterFactory.this.createComponentReferenceAdapter();
        }

        @Override
        public Adapter caseParameterReference(final ParameterReference object) {
            return ParametersAdapterFactory.this.createParameterReferenceAdapter();
        }

        @Override
        public Adapter caseStereotypableElement(final StereotypableElement object) {
            return ParametersAdapterFactory.this.createStereotypableElementAdapter();
        }

        @Override
        public Adapter caseIdentifier(final Identifier object) {
            return ParametersAdapterFactory.this.createIdentifierAdapter();
        }

        @Override
        public Adapter defaultCase(final EObject object) {
            return ParametersAdapterFactory.this.createEObjectAdapter();
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
     * {@link de.fzi.se.quality.parameters.ParameterPartition <em>Parameter Partition</em>}'. <!--
     * begin-user-doc --> This default implementation returns null so that we can easily ignore
     * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
     * end-user-doc -->
     *
     * @return the new adapter.
     * @see de.fzi.se.quality.parameters.ParameterPartition
     * @generated
     */
    public Adapter createParameterPartitionAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link de.fzi.se.quality.parameters.ParameterValue <em>Parameter Value</em>}'. <!--
     * begin-user-doc --> This default implementation returns null so that we can easily ignore
     * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
     * end-user-doc -->
     *
     * @return the new adapter.
     * @see de.fzi.se.quality.parameters.ParameterValue
     * @generated
     */
    public Adapter createParameterValueAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link de.fzi.se.quality.parameters.ParameterInstance <em>Parameter Instance</em>}'. <!--
     * begin-user-doc --> This default implementation returns null so that we can easily ignore
     * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
     * end-user-doc -->
     *
     * @return the new adapter.
     * @see de.fzi.se.quality.parameters.ParameterInstance
     * @generated
     */
    public Adapter createParameterInstanceAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link de.fzi.se.quality.parameters.CallInstance <em>Call Instance</em>}'. <!--
     * begin-user-doc --> This default implementation returns null so that we can easily ignore
     * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
     * end-user-doc -->
     *
     * @return the new adapter.
     * @see de.fzi.se.quality.parameters.CallInstance
     * @generated
     */
    public Adapter createCallInstanceAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link de.fzi.se.quality.parameters.OperationReference <em>Operation Reference</em>}'. <!--
     * begin-user-doc --> This default implementation returns null so that we can easily ignore
     * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
     * end-user-doc -->
     *
     * @return the new adapter.
     * @see de.fzi.se.quality.parameters.OperationReference
     * @generated
     */
    public Adapter createOperationReferenceAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link de.fzi.se.quality.parameters.ComponentInstance <em>Component Instance</em>}'. <!--
     * begin-user-doc --> This default implementation returns null so that we can easily ignore
     * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
     * end-user-doc -->
     *
     * @return the new adapter.
     * @see de.fzi.se.quality.parameters.ComponentInstance
     * @generated
     */
    public Adapter createComponentInstanceAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link de.fzi.se.quality.parameters.ComponentReference <em>Component Reference</em>}'. <!--
     * begin-user-doc --> This default implementation returns null so that we can easily ignore
     * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
     * end-user-doc -->
     *
     * @return the new adapter.
     * @see de.fzi.se.quality.parameters.ComponentReference
     * @generated
     */
    public Adapter createComponentReferenceAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link de.fzi.se.quality.parameters.ParameterReference <em>Parameter Reference</em>}'. <!--
     * begin-user-doc --> This default implementation returns null so that we can easily ignore
     * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
     * end-user-doc -->
     *
     * @return the new adapter.
     * @see de.fzi.se.quality.parameters.ParameterReference
     * @generated
     */
    public Adapter createParameterReferenceAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link org.palladiosimulator.mdsdprofiles.StereotypableElement
     * <em>Stereotypable Element</em>}'. <!-- begin-user-doc --> This default implementation returns
     * null so that we can easily ignore cases; it's useful to ignore a case when inheritance will
     * catch all the cases anyway. <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see org.palladiosimulator.mdsdprofiles.StereotypableElement
     * @generated
     */
    public Adapter createStereotypableElementAdapter() {
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
     * Creates a new adapter for the default case. <!-- begin-user-doc --> This default
     * implementation returns null. <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @generated
     */
    public Adapter createEObjectAdapter() {
        return null;
    }

} // ParametersAdapterFactory
