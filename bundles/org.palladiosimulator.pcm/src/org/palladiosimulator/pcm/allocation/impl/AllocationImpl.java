package org.palladiosimulator.pcm.allocation.impl;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
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

    /**
     * Tests if each assembly context within the referenced system has been allocated correctly.
     * 
     * @return True if the allocation is correct, False otherwise.
     */
    protected boolean validateEachAssemblyContextWithinSystemHasToBeAllocatedExactlyOnce() {
        if (moreThanOneAllocationForAssemblyContextExists()) {
            // assembly context allocated more than one time
            return false;
        }
        var allocatedAssemblyContexts = getAllocatedAssemblyContexts();
        var unallocatedAssemblyContexts = findUnallocatedAssemblyContexts(allocatedAssemblyContexts);

        var remainingSubsystems = extractAllSubsystems(unallocatedAssemblyContexts);
        if (remainingSubsystems.size() != unallocatedAssemblyContexts.size()) {
            // there are unallocated components
            return false;
        }

        return testCorrectAllocationOfSubsystems(remainingSubsystems, allocatedAssemblyContexts);
    }

    /**
     * Determines if one assembly context has been allocated more than once.
     * 
     * @return True if an assembly context has been allocated more than once, false otherwise.
     */
    protected boolean moreThanOneAllocationForAssemblyContextExists() {
        var allocatedAssemblyContexts = new HashSet<>();
        for (var allocation : getAllocationContexts_Allocation()) {
            if (!allocatedAssemblyContexts.add(allocation.getAllocation_AllocationContext())) {
                return true;
            }
        }
        return false;
    }

    /**
     * Determines all assembly contexts that are part of the current allocation (this).
     * 
     * @return A set of assembly contexts.
     */
    protected Set<AssemblyContext> getAllocatedAssemblyContexts() {
        return this.getAllocationContexts_Allocation()
            .stream()
            .map(AllocationContext::getAssemblyContext_AllocationContext)
            .collect(Collectors.toSet());
    }

    /**
     * Determines assembly contexts of the system that are not part of a given set of assembly
     * contexts. The given set represents assembly contexts that have already been allocated.
     * 
     * @param allocatedAssemblyContexts
     *            A set of assembly contexts that shall not be part of the result set.
     * @return A set of unallocated system assembly contexts.
     */
    protected Set<AssemblyContext> findUnallocatedAssemblyContexts(Set<AssemblyContext> allocatedAssemblyContexts) {
        return this.getSystem_Allocation()
            .getAssemblyContexts__ComposedStructure()
            .stream()
            .filter(ac -> !allocatedAssemblyContexts.contains(ac))
            .collect(Collectors.toSet());
    }

    /**
     * Determines all {@link SubSystem} elements that are encapsulated by the given assembly
     * contexts.
     * 
     * This method ignores all other types of encapsulated components.
     * 
     * @param assemblyContexts
     * @return The set of encapsulated {@link SubSystem} elements.
     */
    protected static Set<SubSystem> extractAllSubsystems(Set<AssemblyContext> assemblyContexts) {
        return assemblyContexts.stream()
            .map(AssemblyContext::getEncapsulatedComponent__AssemblyContext)
            .filter(SubSystem.class::isInstance)
            .map(SubSystem.class::cast)
            .collect(Collectors.toSet());
    }

    /**
     * Tests if all given {@link SubSystem} elements are allocated correctly by the given set of
     * allocated {@link AssemblyContext} elements.
     * 
     * A {@link SubSystem} is allocated correctly if it either is allocated directly or if all of
     * its encapsulated components are allocated correctly.
     * 
     * @param subsystems
     *            The set of subsystems to test.
     * @param allocatedAssemblyContexts
     *            The set of allocated assembly contexts.
     * @return True if all subsystems are allocated correctly, False otherwise.
     */
    protected static boolean testCorrectAllocationOfSubsystems(Set<SubSystem> subsystems,
            Set<AssemblyContext> allocatedAssemblyContexts) {
        var queue = new LinkedList<>(subsystems);
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
        return true;
    }

}
