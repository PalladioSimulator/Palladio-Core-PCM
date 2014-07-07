/**
 * Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.reliability.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.ecore.EObject;

import de.uka.ipd.sdq.identifier.Identifier;
import de.uka.ipd.sdq.pcm.core.entity.Entity;
import de.uka.ipd.sdq.pcm.core.entity.NamedElement;
import de.uka.ipd.sdq.pcm.reliability.ExternalFailureOccurrenceDescription;
import de.uka.ipd.sdq.pcm.reliability.FailureOccurrenceDescription;
import de.uka.ipd.sdq.pcm.reliability.FailureType;
import de.uka.ipd.sdq.pcm.reliability.HardwareInducedFailureType;
import de.uka.ipd.sdq.pcm.reliability.InternalFailureOccurrenceDescription;
import de.uka.ipd.sdq.pcm.reliability.NetworkInducedFailureType;
import de.uka.ipd.sdq.pcm.reliability.ReliabilityPackage;
import de.uka.ipd.sdq.pcm.reliability.ResourceTimeoutFailureType;
import de.uka.ipd.sdq.pcm.reliability.SoftwareInducedFailureType;

/**
 * <!-- begin-user-doc --> The <b>Adapter Factory</b> for the model. It provides an adapter
 * <code>createXXX</code> method for each class of the model. <!-- end-user-doc -->
 * 
 * @see de.uka.ipd.sdq.pcm.reliability.ReliabilityPackage
 * @generated
 */
public class ReliabilityAdapterFactory extends AdapterFactoryImpl {
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public static final String copyright = "Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany";

    /**
     * The cached model package. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected static ReliabilityPackage modelPackage;

    /**
     * Creates an instance of the adapter factory. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public ReliabilityAdapterFactory() {
        if (modelPackage == null) {
            modelPackage = ReliabilityPackage.eINSTANCE;
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
    public boolean isFactoryForType(Object object) {
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
    protected ReliabilitySwitch<Adapter> modelSwitch = new ReliabilitySwitch<Adapter>() {
        @Override
        public Adapter caseFailureOccurrenceDescription(FailureOccurrenceDescription object) {
            return createFailureOccurrenceDescriptionAdapter();
        }

        @Override
        public Adapter caseHardwareInducedFailureType(HardwareInducedFailureType object) {
            return createHardwareInducedFailureTypeAdapter();
        }

        @Override
        public Adapter caseSoftwareInducedFailureType(SoftwareInducedFailureType object) {
            return createSoftwareInducedFailureTypeAdapter();
        }

        @Override
        public Adapter caseInternalFailureOccurrenceDescription(InternalFailureOccurrenceDescription object) {
            return createInternalFailureOccurrenceDescriptionAdapter();
        }

        @Override
        public Adapter caseNetworkInducedFailureType(NetworkInducedFailureType object) {
            return createNetworkInducedFailureTypeAdapter();
        }

        @Override
        public Adapter caseExternalFailureOccurrenceDescription(ExternalFailureOccurrenceDescription object) {
            return createExternalFailureOccurrenceDescriptionAdapter();
        }

        @Override
        public Adapter caseResourceTimeoutFailureType(ResourceTimeoutFailureType object) {
            return createResourceTimeoutFailureTypeAdapter();
        }

        @Override
        public Adapter caseFailureType(FailureType object) {
            return createFailureTypeAdapter();
        }

        @Override
        public Adapter caseIdentifier(Identifier object) {
            return createIdentifierAdapter();
        }

        @Override
        public Adapter caseNamedElement(NamedElement object) {
            return createNamedElementAdapter();
        }

        @Override
        public Adapter caseEntity(Entity object) {
            return createEntityAdapter();
        }

        @Override
        public Adapter defaultCase(EObject object) {
            return createEObjectAdapter();
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
    public Adapter createAdapter(Notifier target) {
        return modelSwitch.doSwitch((EObject) target);
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link de.uka.ipd.sdq.pcm.reliability.FailureOccurrenceDescription
     * <em>Failure Occurrence Description</em>}'. <!-- begin-user-doc --> This default
     * implementation returns null so that we can easily ignore cases; it's useful to ignore a case
     * when inheritance will catch all the cases anyway. <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see de.uka.ipd.sdq.pcm.reliability.FailureOccurrenceDescription
     * @generated
     */
    public Adapter createFailureOccurrenceDescriptionAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link de.uka.ipd.sdq.pcm.reliability.HardwareInducedFailureType
     * <em>Hardware Induced Failure Type</em>}'. <!-- begin-user-doc --> This default implementation
     * returns null so that we can easily ignore cases; it's useful to ignore a case when
     * inheritance will catch all the cases anyway. <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see de.uka.ipd.sdq.pcm.reliability.HardwareInducedFailureType
     * @generated
     */
    public Adapter createHardwareInducedFailureTypeAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link de.uka.ipd.sdq.pcm.reliability.ExternalFailureOccurrenceDescription
     * <em>External Failure Occurrence Description</em>}'. <!-- begin-user-doc --> This default
     * implementation returns null so that we can easily ignore cases; it's useful to ignore a case
     * when inheritance will catch all the cases anyway. <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see de.uka.ipd.sdq.pcm.reliability.ExternalFailureOccurrenceDescription
     * @generated
     */
    public Adapter createExternalFailureOccurrenceDescriptionAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link de.uka.ipd.sdq.pcm.reliability.ResourceTimeoutFailureType
     * <em>Resource Timeout Failure Type</em>}'. <!-- begin-user-doc --> This default implementation
     * returns null so that we can easily ignore cases; it's useful to ignore a case when
     * inheritance will catch all the cases anyway. <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see de.uka.ipd.sdq.pcm.reliability.ResourceTimeoutFailureType
     * @generated
     */
    public Adapter createResourceTimeoutFailureTypeAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link de.uka.ipd.sdq.pcm.reliability.NetworkInducedFailureType
     * <em>Network Induced Failure Type</em>}'. <!-- begin-user-doc --> This default implementation
     * returns null so that we can easily ignore cases; it's useful to ignore a case when
     * inheritance will catch all the cases anyway. <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see de.uka.ipd.sdq.pcm.reliability.NetworkInducedFailureType
     * @generated
     */
    public Adapter createNetworkInducedFailureTypeAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link de.uka.ipd.sdq.pcm.reliability.InternalFailureOccurrenceDescription
     * <em>Internal Failure Occurrence Description</em>}'. <!-- begin-user-doc --> This default
     * implementation returns null so that we can easily ignore cases; it's useful to ignore a case
     * when inheritance will catch all the cases anyway. <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see de.uka.ipd.sdq.pcm.reliability.InternalFailureOccurrenceDescription
     * @generated
     */
    public Adapter createInternalFailureOccurrenceDescriptionAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link de.uka.ipd.sdq.pcm.reliability.SoftwareInducedFailureType
     * <em>Software Induced Failure Type</em>}'. <!-- begin-user-doc --> This default implementation
     * returns null so that we can easily ignore cases; it's useful to ignore a case when
     * inheritance will catch all the cases anyway. <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see de.uka.ipd.sdq.pcm.reliability.SoftwareInducedFailureType
     * @generated
     */
    public Adapter createSoftwareInducedFailureTypeAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link de.uka.ipd.sdq.pcm.reliability.FailureType <em>Failure Type</em>} '. <!--
     * begin-user-doc --> This default implementation returns null so that we can easily ignore
     * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
     * end-user-doc -->
     * 
     * @return the new adapter.
     * @see de.uka.ipd.sdq.pcm.reliability.FailureType
     * @generated
     */
    public Adapter createFailureTypeAdapter() {
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
     * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.pcm.core.entity.Entity
     * <em>Entity</em>}'. <!-- begin-user-doc --> This default implementation returns null so that
     * we can easily ignore cases; it's useful to ignore a case when inheritance will catch all the
     * cases anyway. <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see de.uka.ipd.sdq.pcm.core.entity.Entity
     * @generated
     */
    public Adapter createEntityAdapter() {
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

} // ReliabilityAdapterFactory
