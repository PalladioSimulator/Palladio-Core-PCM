package org.palladiosimulator.pcm.tests;

import java.util.function.Function;

import org.eclipse.emf.ecore.EObject;
import org.junit.jupiter.api.Test;
import org.palladiosimulator.pcm.core.composition.ComposedStructure;
import org.palladiosimulator.pcm.tests.impl.ConstraintTestBase;

public class ComposedStructureTest extends ConstraintTestBase {

    @Test
    public void testSystemNoViolation() {
        /**
         * System consists of only one assembly. Assembly instantiates a subsystem.
         */
        testSameSubsystemMustNotBeInstantiatedTwice("testmodels/Subsystem_Test/default.system", true,
                org.palladiosimulator.pcm.system.System.class::cast);
    }

    @Test
    public void testSystemViolationDirectlyInstantiated() {
        /**
         * System consists of two assemblies. Both assemblies instantiate the same subsystem ->
         * violation.
         */
        testSameSubsystemMustNotBeInstantiatedTwice("testmodels/Subsystem_Test/twoInstancesOfSameSubsystem.system",
                false, org.palladiosimulator.pcm.system.System.class::cast);
    }

    @Test
    public void testSystemViolationTransitivelyInstantiated() {
        /**
         * System consists of two assemblies. First assembly instantiates a subsystem, second
         * assembly instantiates another subsystem. First subsystem is instantiated within second
         * subsystem -> violation.
         */
        testSameSubsystemMustNotBeInstantiatedTwice(
                "testmodels/Subsystem_Test/twoInstancesOfSameSubsystemTransitively.system", false,
                org.palladiosimulator.pcm.system.System.class::cast);
    }

    @Test
    public void testCompositeViolationDirectlyInstantiated() {
        /**
         * Composite component consists of two assemblies. Both assemblies instantiate the same
         * subsystem -> violation.
         */
        testSameSubsystemMustNotBeInstantiatedTwice("testmodels/Subsystem_Test/subsystemInstantiation.repository",
                false, root -> findInRepoByName(root, "CompositeDirectViolation"));
    }

    @Test
    public void testCompositeViolationTransitivelyInstantiated() {
        /**
         * Composite component consists of two assemblies. First assembly instantiates a subsystem,
         * second assembly instantiates another subsystem. First subsystem is instantiated within
         * second subsystem -> violation.
         */
        testSameSubsystemMustNotBeInstantiatedTwice("testmodels/Subsystem_Test/subsystemInstantiation.repository",
                false, root -> findInRepoByName(root, "CompositeNestedViolation"));
    }

    @Test
    public void testSubsystemViolationDirectlyInstantiated() {
        /**
         * Subsystem consists of two assemblies. Both assemblies instantiate the same subsystem ->
         * violation.
         */
        testSameSubsystemMustNotBeInstantiatedTwice("testmodels/Subsystem_Test/subsystemInstantiation.repository",
                false, root -> findInRepoByName(root, "SubsystemDirectViolation"));
    }

    @Test
    public void testSubsystemViolationTransitivelyInstantiated() {
        /**
         * Subsystem consists of two assemblies. First assembly instantiates a subsystem, second
         * assembly instantiates another subsystem. First subsystem is instantiated within second
         * subsystem -> violation.
         */
        testSameSubsystemMustNotBeInstantiatedTwice("testmodels/Subsystem_Test/subsystemInstantiation.repository",
                false, root -> findInRepoByName(root, "SubsystemNestedViolation"));
    }

    protected ComposedStructure findInRepoByName(EObject root, String name) {
        for (var iter = root.eAllContents(); iter.hasNext();) {
            var content = iter.next();
            if (content instanceof ComposedStructure) {
                var composite = (ComposedStructure) content;
                if (name.equals(composite.getEntityName())) {
                    return composite;
                }
            }
        }
        return null;
    }

    protected void testSameSubsystemMustNotBeInstantiatedTwice(String modelName, boolean expectSuccess,
            Function<EObject, ComposedStructure> validationTargetSelector) {
        var root = loadModel(modelName, EObject.class);
        var composite = validationTargetSelector.apply(root);
        if (expectSuccess) {
            assertNoViolation(composite, "sameSubsystemMustNotBeInstantiatedMoreThanOnce");
        } else {
            assertViolation(composite, "sameSubsystemMustNotBeInstantiatedMoreThanOnce");
        }
    }

}
