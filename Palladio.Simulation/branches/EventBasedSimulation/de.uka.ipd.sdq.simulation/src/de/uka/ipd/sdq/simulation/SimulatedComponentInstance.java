package de.uka.ipd.sdq.simulation;

import java.util.ArrayList;
import java.util.List;

import de.uka.ipd.sdq.pcm.core.composition.AssemblyContext;
import de.uka.ipd.sdq.pcm.parameter.VariableCharacterisation;
import de.uka.ipd.sdq.pcm.parameter.VariableUsage;
import de.uka.ipd.sdq.pcm.repository.BasicComponent;
import de.uka.ipd.sdq.pcm.repository.OperationProvidedRole;
import de.uka.ipd.sdq.pcm.repository.OperationRequiredRole;
import de.uka.ipd.sdq.pcm.repository.OperationSignature;
import de.uka.ipd.sdq.pcm.repository.ProvidedRole;
import de.uka.ipd.sdq.pcm.repository.RequiredRole;
import de.uka.ipd.sdq.pcm.seff.ResourceDemandingSEFF;
import de.uka.ipd.sdq.pcm.seff.ServiceEffectSpecification;
import de.uka.ipd.sdq.simucomframework.variables.EvaluationProxy;
import de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe;
import de.uka.ipd.sdq.simulation.util.PCMEntityHelper;
import de.uka.ipd.sdq.simulation.util.ParameterHelper;

public class SimulatedComponentInstance {

    private final BasicComponent componentType; // TODO this should be ImplementationComponentType
    private final List<SimulatedRole> providedRoles;
    private final List<SimulatedRole> requiredRoles;
    private final AssemblyContext assemblyCtx;
    private SimulatedStackframe<Object> componentParameters;

    public SimulatedComponentInstance(final BasicComponent type, final AssemblyContext assemblyCtx) {
        assert (type != null) : "The argument type may not be null.";
        assert (assemblyCtx != null) : "The argument assemblyCtx may not be null.";

        this.componentType = type;
        this.assemblyCtx = assemblyCtx;
        this.providedRoles = new ArrayList<SimulatedRole>();
        this.componentParameters = new SimulatedStackframe<Object>();
        for (final ProvidedRole r : type.getProvidedRoles_InterfaceProvidingEntity()) {
            final OperationProvidedRole prov = (OperationProvidedRole) r;
            this.providedRoles.add(new SimulatedRole(prov.getProvidedInterface__OperationProvidedRole(), r.getId(),
                    this));
        }
        this.requiredRoles = new ArrayList<SimulatedRole>();
        for (final RequiredRole r : type.getRequiredRoles_InterfaceRequiringEntity()) {
            final OperationRequiredRole req = (OperationRequiredRole) r;
            this.requiredRoles
                    .add(new SimulatedRole(req.getRequiredInterface__OperationRequiredRole(), r.getId(), this));
        }

        initialiseComponentParameters();
    }

    private void initialiseComponentParameters() {
        // TODO use ParameterHelper.evaluateParametersAndCopyToFrame(...) here
        SimulatedStackframe<Object> defaultComponentFrame = new SimulatedStackframe<Object>();
        for (VariableUsage u : this.componentType.getComponentParameterUsage_ImplementationComponentType()) {
            String parameterUsageLHS = ParameterHelper.getId(u.getNamedReference__VariableUsage());
            for (VariableCharacterisation c : u.getVariableCharacterisation_VariableUsage()) {
                defaultComponentFrame.addValue(parameterUsageLHS + "." + c.getType().toString(), new EvaluationProxy(c
                        .getSpecification_VariableCharacterisation().getSpecification(),
                        new SimulatedStackframe<Object>()));
            }
        }
        componentParameters.addVariables(defaultComponentFrame);

        SimulatedStackframe<Object> overwrittenComponentFrame = new SimulatedStackframe<Object>();
        for (VariableUsage u : this.assemblyCtx.getConfigParameterUsages_AssemblyContext()) {
            String parameterUsageLHS = ParameterHelper.getId(u.getNamedReference__VariableUsage());
            for (VariableCharacterisation c : u.getVariableCharacterisation_VariableUsage()) {
                overwrittenComponentFrame.addValue(parameterUsageLHS + "." + c.getType().toString(),
                        new EvaluationProxy(c.getSpecification_VariableCharacterisation().getSpecification(),
                                new SimulatedStackframe<Object>()));
            }
        }
        componentParameters.addVariables(defaultComponentFrame);
    }

    public SimulatedRole getProvidedRoleById(final String roleId) {
        for (final SimulatedRole r : this.providedRoles) {
            if (r.getId().equals(roleId)) {
                return r;
            }
        }
        return null;
    }

    public SimulatedRole getRequiredRoleById(final String roleId) {
        for (final SimulatedRole r : this.requiredRoles) {
            if (r.getId().equals(roleId)) {
                return r;
            }
        }
        return null;
    }

    public SimulatedComponentInstance findProvidingComponent(final OperationSignature signature) {
        for (final SimulatedRole r : this.requiredRoles) {
            for (final OperationSignature s : r.getInterface().getSignatures__OperationInterface()) {
                if (PCMEntityHelper.equals(s, signature)) {
                    return r.getLinkedRole().getComponent();
                }
            }
        }
        throw new RuntimeException("Could not find a matching component."); // TODO
    }

    public AssemblyContext getAssemblyCtx() {
        return this.assemblyCtx;
    }

    public ResourceDemandingSEFF getSeff(final OperationSignature signature) {
        for (final ServiceEffectSpecification s : this.componentType.getServiceEffectSpecifications__BasicComponent()) {
            if (PCMEntityHelper.equals(s.getDescribedService__SEFF(), signature)) {
                return (ResourceDemandingSEFF) s;
            }
        }
        return null;
    }

    public SimulatedStackframe<Object> getComponentParameters() {
        return componentParameters;
    }

}
