/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.fzi.se.quality.parameters.pcm.impl;

import de.fzi.se.quality.parameters.pcm.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class PCMFactoryImpl extends EFactoryImpl implements PCMFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static PCMFactory init() {
		try {
			PCMFactory thePCMFactory = (PCMFactory)EPackage.Registry.INSTANCE.getEFactory("http://fzi.de/PalladioComponentModel/Quality/Parameters/PCM/0.2"); 
			if (thePCMFactory != null) {
				return thePCMFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new PCMFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PCMFactoryImpl() {
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
			case PCMPackage.PCM_PARAMETER_VALUE: return createPCMParameterValue();
			case PCMPackage.PCM_INFRASTRUCTURE_OPERATION_REFERENCE: return createPCMInfrastructureOperationReference();
			case PCMPackage.PCM_BUSINESS_OPERATION_REFERENCE: return createPCMBusinessOperationReference();
			case PCMPackage.PCM_COMPONENT_REFERENCE: return createPCMComponentReference();
			case PCMPackage.PCM_COMPONENT_PARAMETER_REFERENCE: return createPCMComponentParameterReference();
			case PCMPackage.PCM_OPERATION_PARAMETER_REFERENCE: return createPCMOperationParameterReference();
			case PCMPackage.PCM_REQUIRED_BUSINESS_OPERATION_RETURN_PARAMETER_REFERENCE: return createPCMRequiredBusinessOperationReturnParameterReference();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PCMParameterValue createPCMParameterValue() {
		PCMParameterValueImpl pcmParameterValue = new PCMParameterValueImpl();
		return pcmParameterValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PCMInfrastructureOperationReference createPCMInfrastructureOperationReference() {
		PCMInfrastructureOperationReferenceImpl pcmInfrastructureOperationReference = new PCMInfrastructureOperationReferenceImpl();
		return pcmInfrastructureOperationReference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PCMBusinessOperationReference createPCMBusinessOperationReference() {
		PCMBusinessOperationReferenceImpl pcmBusinessOperationReference = new PCMBusinessOperationReferenceImpl();
		return pcmBusinessOperationReference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PCMComponentReference createPCMComponentReference() {
		PCMComponentReferenceImpl pcmComponentReference = new PCMComponentReferenceImpl();
		return pcmComponentReference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PCMComponentParameterReference createPCMComponentParameterReference() {
		PCMComponentParameterReferenceImpl pcmComponentParameterReference = new PCMComponentParameterReferenceImpl();
		return pcmComponentParameterReference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PCMOperationParameterReference createPCMOperationParameterReference() {
		PCMOperationParameterReferenceImpl pcmOperationParameterReference = new PCMOperationParameterReferenceImpl();
		return pcmOperationParameterReference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PCMRequiredBusinessOperationReturnParameterReference createPCMRequiredBusinessOperationReturnParameterReference() {
		PCMRequiredBusinessOperationReturnParameterReferenceImpl pcmRequiredBusinessOperationReturnParameterReference = new PCMRequiredBusinessOperationReturnParameterReferenceImpl();
		return pcmRequiredBusinessOperationReturnParameterReference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PCMPackage getPCMPackage() {
		return (PCMPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static PCMPackage getPackage() {
		return PCMPackage.eINSTANCE;
	}

} //PCMFactoryImpl
