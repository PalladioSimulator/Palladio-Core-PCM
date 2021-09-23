package org.palladiosimulator.pcm.repository.impl;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.palladiosimulator.pcm.repository.Interface;
import org.palladiosimulator.pcm.repository.RepositoryFactory;

import tools.mdsd.library.standalone.initialization.StandaloneInitializationException;
import tools.mdsd.library.standalone.initialization.StandaloneInitializerBuilder;

public class InterfaceTest {

    @BeforeAll
    public static void init() throws StandaloneInitializationException {
        StandaloneInitializerBuilder.builder()
            .build()
            .init();
    }

    @Test
    public void testIsAssignedFromNull() {
        var i0 = createInterface();
        assertFalse(i0.isAssignableFrom(null));
    }
    
    @Test
    public void testIsAssignedFromUnrelatedInterface() {
        var i0 = createInterface();
        var i1 = createInterface();
        assertFalse(i0.isAssignableFrom(i1));
    }
    
    @Test
    public void testIsAssignedFromSameInterface() {
        var i0 = createInterface();
        assertTrue(i0.isAssignableFrom(i0));
    }
    
    @Test
    public void testIsAssignedFromDirectParent() {
        var i0 = createInterface();
        var i0_0 = createInterface();
        i0.getParentInterfaces__Interface().add(i0_0);
        assertTrue(i0.isAssignableFrom(i0_0));
        assertFalse(i0_0.isAssignableFrom(i0));
    }
    
    @Test
    public void testIsAssignedFromDirectParentFromList() {
        var i0 = createInterface();
        var i0_0 = createInterface();
        var i0_1 = createInterface();
        i0.getParentInterfaces__Interface().add(i0_0);
        i0.getParentInterfaces__Interface().add(i0_1);
        assertTrue(i0.isAssignableFrom(i0_0));
        assertTrue(i0.isAssignableFrom(i0_1));
        assertFalse(i0_0.isAssignableFrom(i0));
        assertFalse(i0_1.isAssignableFrom(i0));
    }
    
    @Test
    public void testIsAssignedFromIndirectParent() {
        var i0 = createInterface();
        var i0_0 = createInterface();
        i0.getParentInterfaces__Interface().add(i0_0);
        var i0_0_0 = createInterface();
        i0_0.getParentInterfaces__Interface().add(i0_0_0);
        assertTrue(i0.isAssignableFrom(i0_0_0));
        assertFalse(i0_0_0.isAssignableFrom(i0));
        assertFalse(i0_0_0.isAssignableFrom(i0_0));
    }
    
    @Test
    public void testIsAssignedFromIndirectParentInDiamond() {
        var i0 = createInterface();
        var i0_0 = createInterface();
        var i0_1 = createInterface();
        var i0_01_0 = createInterface();
        i0.getParentInterfaces__Interface().add(i0_0);
        i0.getParentInterfaces__Interface().add(i0_1);
        i0_0.getParentInterfaces__Interface().add(i0_01_0);
        i0_1.getParentInterfaces__Interface().add(i0_01_0);
        assertTrue(i0.isAssignableFrom(i0_01_0));
        assertFalse(i0_01_0.isAssignableFrom(i0));
    }

    protected static Interface createInterface() {
        return RepositoryFactory.eINSTANCE.createOperationInterface();
    }

}
