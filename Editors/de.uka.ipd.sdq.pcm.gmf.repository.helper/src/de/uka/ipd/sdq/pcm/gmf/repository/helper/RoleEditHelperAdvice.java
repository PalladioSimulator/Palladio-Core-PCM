package de.uka.ipd.sdq.pcm.gmf.repository.helper;

import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.commands.SetValueCommand;
import org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelperAdvice;
import org.eclipse.gmf.runtime.emf.type.core.edithelper.IEditHelperAdvice;
import org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;

import de.uka.ipd.sdq.pcm.core.entity.EntityPackage;
import de.uka.ipd.sdq.pcm.repository.InfrastructureProvidedRole;
import de.uka.ipd.sdq.pcm.repository.InfrastructureRequiredRole;
import de.uka.ipd.sdq.pcm.repository.OperationProvidedRole;
import de.uka.ipd.sdq.pcm.repository.OperationRequiredRole;
import de.uka.ipd.sdq.pcm.repository.Role;
import de.uka.ipd.sdq.pcm.repository.SinkRole;
import de.uka.ipd.sdq.pcm.repository.SourceRole;

/**
 * EditHelper for assigning meaningful names to operational, infrastructure and event roles
 * (associations).
 * 
 * @author joerg
 * 
 */
public class RoleEditHelperAdvice extends AbstractEditHelperAdvice implements IEditHelperAdvice {

    @Override
    protected ICommand getAfterConfigureCommand(ConfigureRequest request) {
        Role r = (Role) request.getElementToConfigure();
        String interfaceName = "";
        String componentName = "";
        String prefix = "";
        if (r instanceof OperationProvidedRole) {
            OperationProvidedRole pr = (OperationProvidedRole) r;
            interfaceName = pr.getProvidedInterface__OperationProvidedRole() == null ? "interface" : pr
                    .getProvidedInterface__OperationProvidedRole().getEntityName();
            componentName = pr.getProvidingEntity_ProvidedRole() == null ? "component" : pr
                    .getProvidingEntity_ProvidedRole().getEntityName();
            prefix = "Provided";
        } else if (r instanceof OperationRequiredRole) {
            OperationRequiredRole rr = (OperationRequiredRole) r;
            interfaceName = rr.getRequiredInterface__OperationRequiredRole() == null ? "interface" : rr
                    .getRequiredInterface__OperationRequiredRole().getEntityName();
            componentName = rr.getRequiringEntity_RequiredRole() == null ? "component" : rr
                    .getRequiringEntity_RequiredRole().getEntityName();
            prefix = "Required";
        } else if (r instanceof InfrastructureProvidedRole) {
            InfrastructureProvidedRole pr = (InfrastructureProvidedRole) r;
            interfaceName = pr.getProvidedInterface__InfrastructureProvidedRole() == null ? "infrastructureInterface"
                    : pr.getProvidedInterface__InfrastructureProvidedRole().getEntityName();
            componentName = pr.getProvidingEntity_ProvidedRole() == null ? "infrastructureComponent" : pr
                    .getProvidingEntity_ProvidedRole().getEntityName();
            prefix = "Provided";
        } else if (r instanceof InfrastructureRequiredRole) {
            InfrastructureRequiredRole pr = (InfrastructureRequiredRole) r;
            interfaceName = pr.getRequiredInterface__InfrastructureRequiredRole() == null ? "infrastructureInterface"
                    : pr.getRequiredInterface__InfrastructureRequiredRole().getEntityName();
            componentName = pr.getRequiringEntity_RequiredRole() == null ? "infrastructureComponent" : pr
                    .getRequiringEntity_RequiredRole().getEntityName();
            prefix = "Required";
        } else if (r instanceof SourceRole) {
            SourceRole sr = (SourceRole) r;
            interfaceName = sr.getEventGroup__SourceRole() == null ? "eventGroup" : sr.getEventGroup__SourceRole()
                    .getEntityName();
            componentName = sr.getRequiringEntity_RequiredRole() == null ? "eventComponent" : sr
                    .getRequiringEntity_RequiredRole().getEntityName();
            prefix = "Source";
        } else if (r instanceof SinkRole) {
            SinkRole sr = (SinkRole) r;
            interfaceName = sr.getEventGroup__SinkRole() == null ? "eventGroup" : sr.getEventGroup__SinkRole()
                    .getEntityName();
            componentName = sr.getProvidingEntity_ProvidedRole() == null ? "eventComponent" : sr
                    .getProvidingEntity_ProvidedRole().getEntityName();
            prefix = "Sink";
        }
        SetRequest setRequest = new SetRequest(r, EntityPackage.eINSTANCE.getNamedElement_EntityName(), prefix + "_"
                + interfaceName + "_" + componentName);
        return new SetValueCommand(setRequest);
    }

}
