/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.fzi.se.quality.parameters.pcm.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;

import de.fzi.se.quality.parameters.pcm.PCMBusinessOperationReference;
import de.fzi.se.quality.parameters.pcm.PCMComponentParameterReference;
import de.fzi.se.quality.parameters.pcm.PCMComponentReference;
import de.fzi.se.quality.parameters.pcm.PCMFactory;
import de.fzi.se.quality.parameters.pcm.PCMInfrastructureOperationReference;
import de.fzi.se.quality.parameters.pcm.PCMOperationParameterReference;
import de.fzi.se.quality.parameters.pcm.PCMPackage;
import de.fzi.se.quality.parameters.pcm.PCMParameterValue;
import de.fzi.se.quality.parameters.pcm.PCMRequiredBusinessOperationReturnParameterReference;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Factory</b>. <!-- end-user-doc -->
 * 
 * @generated
 */
public class PCMFactoryImpl extends EFactoryImpl implements PCMFactory {

    /**
     * Creates the default factory implementation. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public static PCMFactory init() {
        try {
            final PCMFactory thePCMFactory = (PCMFactory) EPackage.Registry.INSTANCE.getEFactory(PCMPackage.eNS_URI);
            if (thePCMFactory != null) {
                return thePCMFactory;
            }
        } catch (final Exception exception) {
            EcorePlugin.INSTANCE.log(exception);
        }
        return new PCMFactoryImpl();
    }

    /**
     * Creates an instance of the factory. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public PCMFactoryImpl() {
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
        case PCMPackage.PCM_PARAMETER_VALUE:
            return this.createPCMParameterValue();
        case PCMPackage.PCM_INFRASTRUCTURE_OPERATION_REFERENCE:
            return this.createPCMInfrastructureOperationReference();
        case PCMPackage.PCM_BUSINESS_OPERATION_REFERENCE:
            return this.createPCMBusinessOperationReference();
        case PCMPackage.PCM_COMPONENT_REFERENCE:
            return this.createPCMComponentReference();
        case PCMPackage.PCM_COMPONENT_PARAMETER_REFERENCE:
            return this.createPCMComponentParameterReference();
        case PCMPackage.PCM_OPERATION_PARAMETER_REFERENCE:
            return this.createPCMOperationParameterReference();
        case PCMPackage.PCM_REQUIRED_BUSINESS_OPERATION_RETURN_PARAMETER_REFERENCE:
            return this.createPCMRequiredBusinessOperationReturnParameterReference();
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
    public PCMParameterValue createPCMParameterValue() {
        final PCMParameterValueImpl pcmParameterValue = new PCMParameterValueImpl();
        return pcmParameterValue;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public PCMInfrastructureOperationReference createPCMInfrastructureOperationReference() {
        final PCMInfrastructureOperationReferenceImpl pcmInfrastructureOperationReference = new PCMInfrastructureOperationReferenceImpl();
        return pcmInfrastructureOperationReference;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public PCMBusinessOperationReference createPCMBusinessOperationReference() {
        final PCMBusinessOperationReferenceImpl pcmBusinessOperationReference = new PCMBusinessOperationReferenceImpl();
        return pcmBusinessOperationReference;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public PCMComponentReference createPCMComponentReference() {
        final PCMComponentReferenceImpl pcmComponentReference = new PCMComponentReferenceImpl();
        return pcmComponentReference;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public PCMComponentParameterReference createPCMComponentParameterReference() {
        final PCMComponentParameterReferenceImpl pcmComponentParameterReference = new PCMComponentParameterReferenceImpl();
        return pcmComponentParameterReference;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public PCMOperationParameterReference createPCMOperationParameterReference() {
        final PCMOperationParameterReferenceImpl pcmOperationParameterReference = new PCMOperationParameterReferenceImpl();
        return pcmOperationParameterReference;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public PCMRequiredBusinessOperationReturnParameterReference createPCMRequiredBusinessOperationReturnParameterReference() {
        final PCMRequiredBusinessOperationReturnParameterReferenceImpl pcmRequiredBusinessOperationReturnParameterReference = new PCMRequiredBusinessOperationReturnParameterReferenceImpl();
        return pcmRequiredBusinessOperationReturnParameterReference;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public PCMPackage getPCMPackage() {
        return (PCMPackage) this.getEPackage();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @deprecated
     * @generated
     */
    @Deprecated
    public static PCMPackage getPackage() {
        return PCMPackage.eINSTANCE;
    }

} // PCMFactoryImpl
