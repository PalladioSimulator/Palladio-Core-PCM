package org.palladiosimulator.pcm.allocation.impl;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.stream.Collectors;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.emf.ecore.util.EObjectValidator;
import org.palladiosimulator.pcm.allocation.AllocationContext;
import org.palladiosimulator.pcm.allocation.util.AllocationValidator;
import org.palladiosimulator.pcm.core.composition.AssemblyContext;
import org.palladiosimulator.pcm.subsystem.SubSystem;

public class AllocationImpl extends AllocationImplGen {

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean validateEachAssemblyContextWithinSystemHasToBeAllocatedExactlyOnce(DiagnosticChain diagnostics, Map<Object, Object> context) {
        var validationResult = validateEachAssemblyContextWithinSystemHasToBeAllocatedExactlyOnce();
        if (!validationResult && diagnostics != null) {
            diagnostics.add
                (new BasicDiagnostic
                    (Diagnostic.ERROR,
                     AllocationValidator.DIAGNOSTIC_SOURCE,
                     AllocationValidator.ALLOCATION__VALIDATE_EACH_ASSEMBLY_CONTEXT_WITHIN_SYSTEM_HAS_TO_BE_ALLOCATED_EXACTLY_ONCE,
                     EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "eachAssemblyContextWithinSystemHasToBeAllocatedExactlyOnce", EObjectValidator.getObjectLabel(this, context) }),
                     new Object [] { this }));
        }
        return validationResult;
    }

    protected boolean validateEachAssemblyContextWithinSystemHasToBeAllocatedExactlyOnce() {
        // collect all assembly contexts that have been allocated
        var allocatedAssemblyContexts = this.getAllocationContexts_Allocation()
            .stream()
            .map(AllocationContext::getAssemblyContext_AllocationContext)
            .collect(Collectors.toSet());

        // collect all assembly contexts that have to be allocated
        var requiredAssemblyContexts = this.getSystem_Allocation()
            .getAssemblyContexts__ComposedStructure();

        // find the assembly contexts that have not be allocated
        var unallocatedAssemblyContexts = new HashSet<>(requiredAssemblyContexts);
        unallocatedAssemblyContexts.removeAll(allocatedAssemblyContexts);

        // ensure that the unallocated assembly contexts are all subsystems
        var remainingSubsystems = new HashSet<>(unallocatedAssemblyContexts.stream()
            .map(AssemblyContext::getEncapsulatedComponent__AssemblyContext)
            .filter(SubSystem.class::isInstance)
            .map(SubSystem.class::cast)
            .collect(Collectors.toSet()));
        if (remainingSubsystems.size() != unallocatedAssemblyContexts.size()) {
            return false;
        }

        // ensure that all remaining subsystems are either allocated directly or every nested
        // assembly context is allocated
        var queue = new LinkedList<>(remainingSubsystems);
        while (!queue.isEmpty()) {
            var subSystem = queue.pop();
            for (var ac : subSystem.getAssemblyContexts__ComposedStructure()) {
                if (!allocatedAssemblyContexts.contains(ac)) {
                    var encapsulatedComponent = ac.getEncapsulatedComponent__AssemblyContext();
                    if (!(encapsulatedComponent instanceof SubSystem)) {
                        return false;
                    }
                    queue.add((SubSystem) encapsulatedComponent);
                }
            }
        }

        // no assembly contexts remaining
        return true;
    }

}
