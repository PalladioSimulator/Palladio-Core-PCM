/**
 * Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.core.composition.impl;

import de.uka.ipd.sdq.pcm.core.composition.*;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;

import de.uka.ipd.sdq.pcm.core.composition.AssemblyConnector;
import de.uka.ipd.sdq.pcm.core.composition.AssemblyContext;
import de.uka.ipd.sdq.pcm.core.composition.AssemblyEventConnector;
import de.uka.ipd.sdq.pcm.core.composition.AssemblyInfrastructureConnector;
import de.uka.ipd.sdq.pcm.core.composition.CompositionFactory;
import de.uka.ipd.sdq.pcm.core.composition.CompositionPackage;
import de.uka.ipd.sdq.pcm.core.composition.EventChannel;
import de.uka.ipd.sdq.pcm.core.composition.EventChannelSinkConnector;
import de.uka.ipd.sdq.pcm.core.composition.EventChannelSourceConnector;
import de.uka.ipd.sdq.pcm.core.composition.ProvidedDelegationConnector;
import de.uka.ipd.sdq.pcm.core.composition.ProvidedInfrastructureDelegationConnector;
import de.uka.ipd.sdq.pcm.core.composition.RequiredDelegationConnector;
import de.uka.ipd.sdq.pcm.core.composition.RequiredInfrastructureDelegationConnector;
import de.uka.ipd.sdq.pcm.core.composition.RequiredResourceDelegationConnector;
import de.uka.ipd.sdq.pcm.core.composition.ResourceRequiredDelegationConnector;
import de.uka.ipd.sdq.pcm.core.composition.SinkDelegationConnector;
import de.uka.ipd.sdq.pcm.core.composition.SourceDelegationConnector;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class CompositionFactoryImpl extends EFactoryImpl implements CompositionFactory {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany";

	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static CompositionFactory init() {
		try {
			CompositionFactory theCompositionFactory = (CompositionFactory)EPackage.Registry.INSTANCE.getEFactory("http://sdq.ipd.uka.de/PalladioComponentModel/Core/Composition/5.0"); 
			if (theCompositionFactory != null) {
				return theCompositionFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new CompositionFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CompositionFactoryImpl() {
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
			case CompositionPackage.RESOURCE_REQUIRED_DELEGATION_CONNECTOR: return createResourceRequiredDelegationConnector();
			case CompositionPackage.EVENT_CHANNEL: return createEventChannel();
			case CompositionPackage.EVENT_CHANNEL_SOURCE_CONNECTOR: return createEventChannelSourceConnector();
			case CompositionPackage.EVENT_CHANNEL_SINK_CONNECTOR: return createEventChannelSinkConnector();
			case CompositionPackage.PROVIDED_DELEGATION_CONNECTOR: return createProvidedDelegationConnector();
			case CompositionPackage.REQUIRED_DELEGATION_CONNECTOR: return createRequiredDelegationConnector();
			case CompositionPackage.ASSEMBLY_CONNECTOR: return createAssemblyConnector();
			case CompositionPackage.ASSEMBLY_EVENT_CONNECTOR: return createAssemblyEventConnector();
			case CompositionPackage.SOURCE_DELEGATION_CONNECTOR: return createSourceDelegationConnector();
			case CompositionPackage.SINK_DELEGATION_CONNECTOR: return createSinkDelegationConnector();
			case CompositionPackage.ASSEMBLY_INFRASTRUCTURE_CONNECTOR: return createAssemblyInfrastructureConnector();
			case CompositionPackage.PROVIDED_INFRASTRUCTURE_DELEGATION_CONNECTOR: return createProvidedInfrastructureDelegationConnector();
			case CompositionPackage.REQUIRED_INFRASTRUCTURE_DELEGATION_CONNECTOR: return createRequiredInfrastructureDelegationConnector();
			case CompositionPackage.REQUIRED_RESOURCE_DELEGATION_CONNECTOR: return createRequiredResourceDelegationConnector();
			case CompositionPackage.ASSEMBLY_CONTEXT: return createAssemblyContext();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProvidedDelegationConnector createProvidedDelegationConnector() {
		ProvidedDelegationConnectorImpl providedDelegationConnector = new ProvidedDelegationConnectorImpl();
		return providedDelegationConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AssemblyContext createAssemblyContext() {
		AssemblyContextImpl assemblyContext = new AssemblyContextImpl();
		return assemblyContext;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RequiredDelegationConnector createRequiredDelegationConnector() {
		RequiredDelegationConnectorImpl requiredDelegationConnector = new RequiredDelegationConnectorImpl();
		return requiredDelegationConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AssemblyConnector createAssemblyConnector() {
		AssemblyConnectorImpl assemblyConnector = new AssemblyConnectorImpl();
		return assemblyConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResourceRequiredDelegationConnector createResourceRequiredDelegationConnector() {
		ResourceRequiredDelegationConnectorImpl resourceRequiredDelegationConnector = new ResourceRequiredDelegationConnectorImpl();
		return resourceRequiredDelegationConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EventChannel createEventChannel() {
		EventChannelImpl eventChannel = new EventChannelImpl();
		return eventChannel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AssemblyEventConnector createAssemblyEventConnector() {
		AssemblyEventConnectorImpl assemblyEventConnector = new AssemblyEventConnectorImpl();
		return assemblyEventConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SourceDelegationConnector createSourceDelegationConnector() {
		SourceDelegationConnectorImpl sourceDelegationConnector = new SourceDelegationConnectorImpl();
		return sourceDelegationConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SinkDelegationConnector createSinkDelegationConnector() {
		SinkDelegationConnectorImpl sinkDelegationConnector = new SinkDelegationConnectorImpl();
		return sinkDelegationConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AssemblyInfrastructureConnector createAssemblyInfrastructureConnector() {
		AssemblyInfrastructureConnectorImpl assemblyInfrastructureConnector = new AssemblyInfrastructureConnectorImpl();
		return assemblyInfrastructureConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RequiredInfrastructureDelegationConnector createRequiredInfrastructureDelegationConnector() {
		RequiredInfrastructureDelegationConnectorImpl requiredInfrastructureDelegationConnector = new RequiredInfrastructureDelegationConnectorImpl();
		return requiredInfrastructureDelegationConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProvidedInfrastructureDelegationConnector createProvidedInfrastructureDelegationConnector() {
		ProvidedInfrastructureDelegationConnectorImpl providedInfrastructureDelegationConnector = new ProvidedInfrastructureDelegationConnectorImpl();
		return providedInfrastructureDelegationConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RequiredResourceDelegationConnector createRequiredResourceDelegationConnector() {
		RequiredResourceDelegationConnectorImpl requiredResourceDelegationConnector = new RequiredResourceDelegationConnectorImpl();
		return requiredResourceDelegationConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EventChannelSinkConnector createEventChannelSinkConnector() {
		EventChannelSinkConnectorImpl eventChannelSinkConnector = new EventChannelSinkConnectorImpl();
		return eventChannelSinkConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EventChannelSourceConnector createEventChannelSourceConnector() {
		EventChannelSourceConnectorImpl eventChannelSourceConnector = new EventChannelSourceConnectorImpl();
		return eventChannelSourceConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CompositionPackage getCompositionPackage() {
		return (CompositionPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static CompositionPackage getPackage() {
		return CompositionPackage.eINSTANCE;
	}

} //CompositionFactoryImpl
