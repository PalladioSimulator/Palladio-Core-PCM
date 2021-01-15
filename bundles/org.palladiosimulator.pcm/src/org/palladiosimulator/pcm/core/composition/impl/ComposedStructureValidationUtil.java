package org.palladiosimulator.pcm.core.composition.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import org.palladiosimulator.pcm.core.composition.AssemblyContext;
import org.palladiosimulator.pcm.core.composition.ComposedStructure;
import org.palladiosimulator.pcm.subsystem.SubSystem;

/**
 * Utility class for validating invariants implemented in Java for the composition package.
 * 
 * The reason for this class is to reduce the amount of code that has to be placed within GenModel
 * annotations as much as possible.
 */
public final class ComposedStructureValidationUtil {

    private ComposedStructureValidationUtil() {
        // intentionally left blank
    }

    /**
     * Validates the constraint "sameSubsystemMustNotBeInstantiatedMoreThanOnce" on the given composed structure.
     * @param composedStructure The entity to execute the validation on.
     * @return True if no violation could be detected, false otherwise.
     */
    public static boolean validateSameSubsystemMustNotBeInstantiatedMoreThanOnce(ComposedStructure composedStructure) {
        try {
            return !isSameSubsystemInstantiatedMoreThanOnce(composedStructure);            
        } catch (IllegalStateException e) {
            return false;
        }
    }

    /**
     * @return True if the same subsystem is instantiated more than once, false otherwise.
     */
    private static boolean isSameSubsystemInstantiatedMoreThanOnce(ComposedStructure composedStructure) {
        var instantiatedSubsystems = getInstantiatedSubsystems(composedStructure);
        var uniqueInstantiatedSubsystems = new HashSet<>(instantiatedSubsystems);
        return instantiatedSubsystems.size() != uniqueInstantiatedSubsystems.size();
    }

    /**
     * Collects all transitively instantiated subsystems within this composed structure.
     * 
     * @return A list of instantiated subsystems. The list might contain duplicates if the component
     *         has been instantiated more than once.
     */
    private static Collection<SubSystem> getInstantiatedSubsystems(ComposedStructure composedStructure) {
        Collection<AssemblyContext> assemblyContexts = getContainedAssemblyContexts(composedStructure,
                Collections.emptySet());
        return assemblyContexts.stream()
            .map(AssemblyContext::getEncapsulatedComponent__AssemblyContext)
            .filter(SubSystem.class::isInstance)
            .map(SubSystem.class::cast)
            .collect(Collectors.toList());
    }

    /**
     * Recursively collects all assembly contexts of the given composed structure.
     * 
     * @param composedStructure
     *            The composed structure to start the search with.
     * @param visitedComponents
     *            The components that already have been visited during the recursion.
     * @return A collection of all transitive assembly contexts (might contain duplicates).
     */
    private static Collection<AssemblyContext> getContainedAssemblyContexts(ComposedStructure composedStructure,
            Set<ComposedStructure> visitedComponents) {
        var result = new ArrayList<AssemblyContext>();
        if (visitedComponents.contains(composedStructure)) {
            throw new IllegalStateException("There is a cyclic instantiation!");
        }
        var newVisitedComponents = new HashSet<>(visitedComponents);
        newVisitedComponents.add(composedStructure);
        for (var containedAc : composedStructure.getAssemblyContexts__ComposedStructure()) {
            result.add(containedAc);
            result.addAll(getContainedAssemblyContexts(containedAc, newVisitedComponents));
        }
        return result;
    }

    /**
     * Recursively collects all assembly contexts instantiated within the given assembly context.
     * The result will not contain the given assembly context.
     * 
     * If the assembly context does not instantiate a composed structure, this method will return en
     * empty collection.
     * 
     * @param ac
     *            The assembly context to start the search with.
     * @param visitedComponents
     *            The components that already have been visited during the recursion.
     * @return A collection of all transitive assembly contexts (might contain duplicates).
     */
    private static Collection<AssemblyContext> getContainedAssemblyContexts(AssemblyContext ac,
            Set<ComposedStructure> visitedComponents) {
        var component = ac.getEncapsulatedComponent__AssemblyContext();
        if (component instanceof ComposedStructure) {
            return getContainedAssemblyContexts((ComposedStructure) component, visitedComponents);
        }
        return Collections.emptyList();
    }

}
