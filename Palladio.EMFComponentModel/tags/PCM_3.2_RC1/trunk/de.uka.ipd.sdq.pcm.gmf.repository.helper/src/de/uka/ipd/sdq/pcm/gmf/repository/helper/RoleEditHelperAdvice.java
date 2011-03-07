package de.uka.ipd.sdq.pcm.gmf.repository.helper;

import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.commands.SetValueCommand;
import org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelperAdvice;
import org.eclipse.gmf.runtime.emf.type.core.edithelper.IEditHelperAdvice;
import org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;

import de.uka.ipd.sdq.pcm.core.entity.EntityPackage;
import de.uka.ipd.sdq.pcm.repository.OperationProvidedRole;
import de.uka.ipd.sdq.pcm.repository.OperationRequiredRole;
import de.uka.ipd.sdq.pcm.repository.Role;

public class RoleEditHelperAdvice extends AbstractEditHelperAdvice implements
		IEditHelperAdvice {

	@Override
	protected ICommand getAfterConfigureCommand(ConfigureRequest request) {
		Role r = (Role) request.getElementToConfigure();
		String interfaceName = "";
		String componentName = "";
		String prefix = "";
		if (r instanceof OperationProvidedRole) {
			OperationProvidedRole pr = (OperationProvidedRole) r;
			interfaceName = pr.getProvidedInterface__OperationProvidedRole() == null ? "interface"
					: pr.getProvidedInterface__OperationProvidedRole().getEntityName();
			componentName = pr.getProvidingEntity_ProvidedRole() == null ? "component"
					: pr.getProvidingEntity_ProvidedRole().getEntityName();
			prefix = "Provided";
		} else if (r instanceof OperationRequiredRole) {
			OperationRequiredRole rr = (OperationRequiredRole) r;
			interfaceName = rr.getRequiredInterface__OperationRequiredRole() == null ? "interface"
					: rr.getRequiredInterface__OperationRequiredRole().getEntityName();
			componentName = rr.getRequiringEntity_RequiredRole() == null ? "component"
					: rr.getRequiringEntity_RequiredRole().getEntityName();
			prefix = "Required";
		}
		SetRequest setRequest = new SetRequest(r, EntityPackage.eINSTANCE
				.getNamedElement_EntityName(), prefix + "_" + interfaceName + "_"
				+ componentName);
		return new SetValueCommand(setRequest);
	}

}
