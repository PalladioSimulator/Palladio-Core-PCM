package org.palladiosimulator.pcm.tests;

import org.junit.jupiter.api.Test;
import org.palladiosimulator.pcm.allocation.Allocation;
import org.palladiosimulator.pcm.tests.impl.ConstraintTestBase;

public class AllocationConstraintTest extends ConstraintTestBase {

    @Test
    public void testAllocateSubSystemDirectly() {
        /*
         * System consists of one subsystem.
         * Allocation allocates this subsystem directly. 
         */
        var allocation = loadModel("testmodels/Subsystem_Test/default-allocateSubsystemDirectly.allocation", Allocation.class);
        assertNoViolation(allocation);
    }
    
    @Test
    public void testSubsystem_SubsystemAllocatedDirectly() {
        /*
         * System consists of one subsystem.
         * Allocation allocates this subsystem twice and additional other components 
         */
        var allocation = loadModel("testmodels/Subsystem_Test/allocateSubSystemDirectly.allocation",
                Allocation.class);
        assertViolation(allocation);
    }
        
    @Test
    public void testSubsystem_ComponentInsideSubsystem() {
        /*
         * System consists of one subsystem.
         * Allocation allocates the component of the subsystem but not the subsystem
         */
        var allocation = loadModel("testmodels/Subsystem_Test/default.allocation", Allocation.class);
        assertNoViolation(allocation);
    }

    @Test
    public void testSubsystem_NestedSubsystems() {
        /*
         * System consists of one subsystem that contains another subsystem
         * Allocation allocates the component of the nested subsystem but not the subsystem
         */
        var allocation = loadModel("testmodels/Subsystem_Test/nestedSubsystems.allocation", Allocation.class);
        assertNoViolation(allocation);
    }

    @Test
    public void testSubsystem_NestedSubsystemsDirectlyAllocated() {
        /*
         * System consists of one subsystem that contains another subsystem
         * Allocation allocates the subsystem
         */
        var allocation = loadModel("testmodels/Subsystem_Test/NestedSubsystemDirectlyAllocated.allocation",
                Allocation.class);
        assertNoViolation(allocation);
    }
    
    @Test
    public void testSubsystem_Empty() {
        /*
         * System consists of one subsystem
         * Allocation allocates nothing
         */
        var allocation = loadModel("testmodels/Subsystem_Test/empty.allocation",
                Allocation.class);
        assertViolation(allocation);
    }
    
    @Test
    public void testSubsystem_EmptyForNested() {
        /*
         * System consists of one subsystem that contains another subsystem
         * Allocation allocates nothing
         */
        var allocation = loadModel("testmodels/Subsystem_Test/emptyForNested.allocation",
                Allocation.class);
        assertViolation(allocation);
    }

    @Test
    public void testSubsystem_SubsystemInstantiatedTwiceContentsAllocated() {
        /*
         * System consists of two subsystems
         * Allocation allocates one subsystem twice
         */
        var allocation = loadModel("testmodels/Subsystem_Test/subsystemInstantiatedTwiceContentsAllocated.allocation",
                Allocation.class);
        assertViolation(allocation);
    }
    
    @Test
    public void testSubsystem_MissingComponentAllocation() {
        /*
         * System consists of subsystem and component
         * Allocation allocates the subsystem
         */
        var allocation = loadModel("testmodels/Subsystem_Test/subsystemAndComponent_missingComponent.allocation",
                Allocation.class);
        assertViolation(allocation);
    }
    
}
