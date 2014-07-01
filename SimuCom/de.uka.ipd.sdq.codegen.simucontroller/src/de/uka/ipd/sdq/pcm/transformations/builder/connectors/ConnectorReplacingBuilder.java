package de.uka.ipd.sdq.pcm.transformations.builder.connectors;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import de.uka.ipd.sdq.featureconfig.FeatureConfig;
import de.uka.ipd.sdq.pcm.allocation.AllocationContext;
import de.uka.ipd.sdq.pcm.core.composition.AssemblyConnector;
import de.uka.ipd.sdq.pcm.core.composition.AssemblyContext;
import de.uka.ipd.sdq.pcm.core.composition.ComposedStructure;
import de.uka.ipd.sdq.pcm.core.composition.CompositionFactory;
import de.uka.ipd.sdq.pcm.repository.InfrastructureProvidedRole;
import de.uka.ipd.sdq.pcm.repository.Interface;
import de.uka.ipd.sdq.pcm.repository.OperationProvidedRole;
import de.uka.ipd.sdq.pcm.repository.OperationRequiredRole;
import de.uka.ipd.sdq.pcm.repository.ProvidedRole;
import de.uka.ipd.sdq.pcm.resourceenvironment.LinkingResource;
import de.uka.ipd.sdq.pcm.resourceenvironment.ResourceContainer;
import de.uka.ipd.sdq.pcm.transformations.FeatureUtils;
import de.uka.ipd.sdq.pcm.transformations.builder.IBuilder;
import de.uka.ipd.sdq.pcm.transformations.builder.IComponentBuilder;
import de.uka.ipd.sdq.pcm.transformations.builder.resourceconsumer.LocalCommunicationComponentBuilder;
import de.uka.ipd.sdq.pcm.transformations.builder.resourceconsumer.NetworkLoadingComponentBuilder;
import de.uka.ipd.sdq.pcm.transformations.builder.util.PCMAndCompletionModelHolder;

/**
 * This builder replaces a given connector with a component built by the given component builder.
 * @author Snowball
 *
 */
public class ConnectorReplacingBuilder implements IBuilder {

    private final Logger logger = Logger.getLogger(ConnectorReplacingBuilder.class);

    private final AssemblyConnector connector;
    private final ComposedStructure parent;
    private final LinkingResource linkingRes;
    private final PCMAndCompletionModelHolder models;
    private final FeatureConfig featureConfig;

    public ConnectorReplacingBuilder(final PCMAndCompletionModelHolder models, final AssemblyConnector con, final FeatureConfig featureConfig) {
        this.models = models;
        this.connector = con;
        this.linkingRes = findLinkingResource(connector);
        this.parent = con.getParentStructure__Connector();
        this.featureConfig = featureConfig;
    }

    @Override
    public void build() {
        // Teste hier: Entweder sind es 2 Prozesse auf dem selben Rechner _oder_ zwei Prozesse auf verschiedenen Rechner.
        // Im letzten Fall ist die Konfigurationsoption "SameAddressSpace" illegal und wird somit uebergangen...
        if (FeatureUtils.hasFeature(featureConfig,"DifferentAddressSpace") || linkingRes != null) {
            if(logger.isEnabledFor(Level.INFO)) {
                logger.info("Expanding a completion for remote connector "+connector.getEntityName());
            }

            final IClientServerConnectorCompletionComponentBuilder componentBuilder =
                    configureCompletionComponentBuilder();

            // First build the completion component
            componentBuilder.build();

            // Then integrate the component in the structure instead of the AssemblyConnector
            parent.getAssemblyContexts__ComposedStructure().add(componentBuilder.getAssemblyContext());

            embeddConnectorCompletionInApplication(componentBuilder);
            connectConnectorCompletionWithMiddleware(componentBuilder);

            // Finally, remove the connector from the architecture
            parent.getConnectors__ComposedStructure().remove(connector);
        }
    }

    private IClientServerConnectorCompletionComponentBuilder configureCompletionComponentBuilder() {
        IComponentBuilder builder = null;
        IClientServerConnectorCompletionComponentBuilder result;
        ResourceContainer clientContainer = null;
        ResourceContainer serverContainer = null;

        if (linkingRes  != null) {
            //TODO
            //Hauck: Changed code here because of changed metamodel. Please check.
            if ((linkingRes.getConnectedResourceContainers_LinkingResource() != null) && (linkingRes.getConnectedResourceContainers_LinkingResource().size()>1)) {
                clientContainer = linkingRes.getConnectedResourceContainers_LinkingResource().get(0);
                serverContainer = linkingRes.getConnectedResourceContainers_LinkingResource().get(1);
                //clientContainer = linkingRes.getFromResourceContainer_LinkingResource().get(0);
                //serverContainer = linkingRes.getToResourceContainer_LinkingResource().get(0);
                builder = new NetworkLoadingComponentBuilder(models, connector.getRequiredRole_AssemblyConnector().getRequiredInterface__OperationRequiredRole(),linkingRes);
            }
        } else {
            clientContainer = findContainer(this.connector.getRequiringAssemblyContext_AssemblyConnector());
            serverContainer = clientContainer;
            builder = new LocalCommunicationComponentBuilder(models, connector.getRequiredRole_AssemblyConnector().getRequiredInterface__OperationRequiredRole());
        }
        /***************************************************************
		Lucka: Commented to avoid encryption and authentication effects on a connector per default --> will be moved in for this purpose designed completion
         ****************************************************************
		if (FeatureUtils.hasFeature(featureConfig,"Encryption"))
			builder = new PairwiseMiddlewareInteractingInnerConnectorCompletionBuilder(models,connector,clientContainer,serverContainer,builder,"encrypt","decrypt");
		if (FeatureUtils.hasFeature(featureConfig,"Authentication"))
			builder = new ConfigurableMiddlewareCallingConnectorCompletionBuilder(models,connector,clientContainer,serverContainer,builder,"createCredentials","checkCredentials",null,null);
         ****************************************************************/
        result = new MarshallingConnectorCompletionBuilder(models,connector,clientContainer,serverContainer,builder);

        return result;
    }

    private void connectConnectorCompletionWithMiddleware(final IClientServerConnectorCompletionComponentBuilder componentBuilder) {
        // Only support point-to-point connections
        final AllocationContext clientMWContext = findClientSideMiddlewareAllocationContext();
        assert (clientMWContext.getAssemblyContext_AllocationContext().getEncapsulatedComponent__AssemblyContext().getProvidedRoles_InterfaceProvidingEntity().get(0) instanceof OperationProvidedRole);
        addAssemblyConnector(componentBuilder.getClientSideMiddlewareRole(), componentBuilder.getAssemblyContext(),
                (OperationProvidedRole)clientMWContext.getAssemblyContext_AllocationContext().getEncapsulatedComponent__AssemblyContext().getProvidedRoles_InterfaceProvidingEntity().get(0),
                clientMWContext.getAssemblyContext_AllocationContext());
        final AllocationContext serverMWContext = findServerSideMiddlewareAllocationContext();
        assert (serverMWContext.getAssemblyContext_AllocationContext().getEncapsulatedComponent__AssemblyContext().getProvidedRoles_InterfaceProvidingEntity().get(0) instanceof OperationProvidedRole);
        addAssemblyConnector(componentBuilder.getServerSideMiddlewareRole(), componentBuilder.getAssemblyContext(),
                (OperationProvidedRole)serverMWContext.getAssemblyContext_AllocationContext().getEncapsulatedComponent__AssemblyContext().getProvidedRoles_InterfaceProvidingEntity().get(0),
                serverMWContext.getAssemblyContext_AllocationContext());
    }

    private void embeddConnectorCompletionInApplication(final IClientServerConnectorCompletionComponentBuilder componentBuilder) {
        addAssemblyConnector(connector.getRequiredRole_AssemblyConnector(),
                connector.getRequiringAssemblyContext_AssemblyConnector(),
                componentBuilder.getOperationProvidedRole(),
                componentBuilder.getAssemblyContext());
        addAssemblyConnector(componentBuilder.getOperationRequiredRole(),
                componentBuilder.getAssemblyContext(),
                connector.getProvidedRole_AssemblyConnector(),
                connector.getProvidingAssemblyContext_AssemblyConnector());
    }

    private void addAssemblyConnector(final OperationRequiredRole from, final AssemblyContext fromContext, final OperationProvidedRole to, final AssemblyContext toContext){
        final AssemblyConnector acon = CompositionFactory.eINSTANCE.createAssemblyConnector();
        acon.setParentStructure__Connector(parent);
        acon.setRequiredRole_AssemblyConnector(from);
        acon.setRequiringAssemblyContext_AssemblyConnector(fromContext);
        acon.setProvidedRole_AssemblyConnector(to);
        acon.setProvidingAssemblyContext_AssemblyConnector(toContext);
    }

    private AllocationContext findClientSideMiddlewareAllocationContext() {
        //Hauck: Changed code here because of changed metamodel. Please check.
        ResourceContainer container = null;
        if (linkingRes != null) {
            if ((linkingRes.getConnectedResourceContainers_LinkingResource() != null) && (linkingRes.getConnectedResourceContainers_LinkingResource().size()>0)) {
                linkingRes.getConnectedResourceContainers_LinkingResource().get(0);
            }
        }
        if (container == null) {
            container = findContainer(connector.getRequiringAssemblyContext_AssemblyConnector());
        }
        return findAllocationContext(container,models.getMiddlewareRepository().getInterfaces__Repository().get(0));
    }

    private AllocationContext findServerSideMiddlewareAllocationContext(){
        final ResourceContainer container = linkingRes == null ? findContainer(connector.getRequiringAssemblyContext_AssemblyConnector()) : linkingRes.getConnectedResourceContainers_LinkingResource().get(0) ;
        //	private AllocationContext findServerSideMiddlewareAllocationContext() {
        //		//Hauck: Changed code here because of changed metamodel. Please check.
        //		ResourceContainer container = null;
        //		if (linkingRes != null) {
        //			if ((linkingRes.getConnectedResourceContainers_LinkingResource() != null) && (linkingRes.getConnectedResourceContainers_LinkingResource().size()>1)) {
        //				linkingRes.getConnectedResourceContainers_LinkingResource().get(1);
        //			}
        //		}
        //		if (container == null) {
        //			findContainer(connector.getRequiringAssemblyContext_AssemblyConnector());
        //		}
        return findAllocationContext(container,models.getMiddlewareRepository().getInterfaces__Repository().get(0));
    }

    /**
     * Search through all allocation contexts of the given resource container
     * to find the one which contains the component which is the one providing
     * the given interface.
     * If such an allocation context cannot be found, a RuntimeException is thrown.
     * @param resourceContainer the resource container to be searched through
     * @param interfaceToSearch the interface to be searched for
     * @return the allocation context which has been found
     */
    private AllocationContext findAllocationContext(
            final ResourceContainer resourceContainer, final Interface interfaceToSearch) {
        for (final AllocationContext context : models.getAllocation().getAllocationContexts_Allocation()) {
            if (context.getResourceContainer_AllocationContext() == resourceContainer
                    && context.getAssemblyContext_AllocationContext()
                    .getEncapsulatedComponent__AssemblyContext()
                    .getProvidedRoles_InterfaceProvidingEntity().size() > 0) {
                final ProvidedRole providedRole = context
                        .getAssemblyContext_AllocationContext()
                        .getEncapsulatedComponent__AssemblyContext()
                        .getProvidedRoles_InterfaceProvidingEntity().get(0);
                if (providedRole instanceof OperationProvidedRole) {
                    final OperationProvidedRole role = (OperationProvidedRole) providedRole;
                    if (role.getProvidedInterface__OperationProvidedRole() == interfaceToSearch) {
                        return context;
                    }
                } else if (providedRole instanceof InfrastructureProvidedRole) {
                    final InfrastructureProvidedRole role = (InfrastructureProvidedRole) providedRole;
                    if (role.getProvidedInterface__InfrastructureProvidedRole() == interfaceToSearch) {
                        return context;
                    }
                } else {
                    throw new RuntimeException("Unsupported type of provided role found during transformation.");
                }
            }
        }
        throw new RuntimeException("Model invalid, unable to find middleware component for resource container "+resourceContainer.getEntityName());
    }

    /**
     * Retrieve the linking resource for the given assembly connector
     * @param con The connector to retrieve the linking resource for
     * @return The linking resource on which the given connector is deployed
     */
    private LinkingResource findLinkingResource(final AssemblyConnector con) {
        final ResourceContainer requiredSide=findContainer(con.getRequiringAssemblyContext_AssemblyConnector());
        final ResourceContainer providedSide=findContainer(con.getProvidingAssemblyContext_AssemblyConnector());

        if(requiredSide==providedSide) {
            return null;
        }

        for (final LinkingResource lr : models.getAllocation().getTargetResourceEnvironment_Allocation().getLinkingResources__ResourceEnvironment()){
            if (lr.getConnectedResourceContainers_LinkingResource().contains(requiredSide) &&
                    lr.getConnectedResourceContainers_LinkingResource().contains(providedSide)) {
                return lr;
            }
        }
        if (findContainer(con.getRequiringAssemblyContext_AssemblyConnector()) != findContainer(con.getProvidingAssemblyContext_AssemblyConnector())) {
            throw new RuntimeException("AssemblyConnector "+con.getEntityName()+" links different ResourceContainer, but there is no linking resource between the containers!");
        }
        return null;
    }

    private ResourceContainer findContainer(
            final AssemblyContext requiringAssemblyContext_AssemblyConnector) {
        for(final AllocationContext ac : this.models.getAllocation().getAllocationContexts_Allocation()) {
            if (ac.getAssemblyContext_AllocationContext().getId().equals(requiringAssemblyContext_AssemblyConnector.getId())) {
                return ac.getResourceContainer_AllocationContext();
            }
        }
        return null;
    }
}
