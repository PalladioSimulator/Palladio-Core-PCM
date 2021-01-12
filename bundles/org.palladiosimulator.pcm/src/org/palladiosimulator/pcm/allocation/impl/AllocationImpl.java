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
import org.palladiosimulator.pcm.allocation.Allocation;
import org.palladiosimulator.pcm.allocation.AllocationContext;
import org.palladiosimulator.pcm.allocation.util.AllocationValidator;
import org.palladiosimulator.pcm.core.composition.AssemblyContext;
import org.palladiosimulator.pcm.core.entity.Entity;
import org.palladiosimulator.pcm.subsystem.SubSystem;

public class AllocationImpl extends AllocationImplGen {

    protected static class ValidationResult {
        
        private final boolean isValid;
        private final String message;

        public ValidationResult() {
            this.isValid = true;
            this.message = "";
        }
        
        public ValidationResult(String message) {
            this.isValid = false;
            this.message = message;
        }

        public boolean isValid() {
            return isValid;
        }

        public String getMessage() {
            return message;
        }

    }

    
    /**
     * {@inheritDoc}
     */
    @Override
    public boolean validateEachAssemblyContextWithinSystemHasToBeAllocatedExactlyOnce(DiagnosticChain diagnostics, Map<Object, Object> context) {
        var validationResult = validateEachAssemblyContextWithinSystemHasToBeAllocatedExactlyOnce();
        if (!validationResult.isValid() && diagnostics != null) {
            var defaultMessage = EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "eachAssemblyContextWithinSystemHasToBeAllocatedExactlyOnce", getEntityLabel(this) });
            var validationMessage = String.format("%s: %s", defaultMessage, validationResult.getMessage());
            diagnostics.add
                (new BasicDiagnostic
                    (Diagnostic.ERROR,
                     AllocationValidator.DIAGNOSTIC_SOURCE,
                     AllocationValidator.ALLOCATION__VALIDATE_EACH_ASSEMBLY_CONTEXT_WITHIN_SYSTEM_HAS_TO_BE_ALLOCATED_EXACTLY_ONCE,
                     validationMessage,
                     new Object [] { this }));
        }
        return validationResult.isValid();
    }

    /**
     * Tests if each assembly context within the referenced system has been allocated correctly.
     * 
     * @return Test result.
     */
    protected ValidationResult validateEachAssemblyContextWithinSystemHasToBeAllocatedExactlyOnce() {
        var testResult = testAtMostOneAllocationForAssemblyContextExists();
        if (!testResult.isValid()) {
            // assembly context allocated more than one time
            return testResult;
        }
        var allocatedAssemblyContexts = getAllocatedAssemblyContexts();
        var unallocatedAssemblyContexts = findUnallocatedAssemblyContexts(allocatedAssemblyContexts);

        var remainingSubsystems = extractAllSubsystems(unallocatedAssemblyContexts);
        if (remainingSubsystems.size() != unallocatedAssemblyContexts.size()) {
            // there are unallocated assembly contexts
            var assemblyContextMessagePart = unallocatedAssemblyContexts.stream()
                .map(AllocationImpl::getEntityLabel)
                .collect(Collectors.joining(", "));
            return new ValidationResult(String.format("There are unallocated %s elements: %s",
                    AssemblyContext.class.getSimpleName(), assemblyContextMessagePart));
        }

        return testCorrectAllocationOfSubsystems(remainingSubsystems, allocatedAssemblyContexts);
    }


    /**
     * Tests if each assembly context is allocated at most once.
     * 
     * @return Test result.
     */
    protected ValidationResult testAtMostOneAllocationForAssemblyContextExists() {
        var allocatedAssemblyContexts = new HashSet<>();
        for (var allocation : getAllocationContexts_Allocation()) {
            if (!allocatedAssemblyContexts.add(allocation.getAllocation_AllocationContext())) {
                return new ValidationResult(
                        String.format("%s %s allocates %s elements more than once.", Allocation.class.getSimpleName(),
                                getEntityLabel(allocation), AssemblyContext.class.getSimpleName()));
            }
        }
        return new ValidationResult();
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
     * @return Test result.
     */
    protected static ValidationResult testCorrectAllocationOfSubsystems(Set<SubSystem> subsystems,
            Set<AssemblyContext> allocatedAssemblyContexts) {
        var queue = new LinkedList<>(subsystems);
        while (!queue.isEmpty()) {
            var subSystem = queue.pop();
            for (var ac : subSystem.getAssemblyContexts__ComposedStructure()) {
                if (!allocatedAssemblyContexts.contains(ac)) {
                    var encapsulatedComponent = ac.getEncapsulatedComponent__AssemblyContext();
                    if (!(encapsulatedComponent instanceof SubSystem)) {
                        return new ValidationResult(String.format("%s %s of %s %s is not allocated.",
                                AssemblyContext.class.getSimpleName(), getEntityLabel(ac),
                                SubSystem.class.getSimpleName(), getEntityLabel(subSystem)));
                    }
                    queue.add((SubSystem) encapsulatedComponent);
                }
            }
        }
        return new ValidationResult();
    }

    /**
     * Generates a label for an {@link Entity} to be used in validation messages.
     * 
     * @param entity
     *            The entity.
     * @return The label.
     */
    protected static String getEntityLabel(Entity entity) {
        return String.format("%s (%s)", entity.getEntityName(), entity.getId());
    }

}
