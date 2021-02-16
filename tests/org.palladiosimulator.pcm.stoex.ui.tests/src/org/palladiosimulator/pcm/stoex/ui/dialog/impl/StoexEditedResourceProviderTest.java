package org.palladiosimulator.pcm.stoex.ui.dialog.impl;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.isA;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.eclipse.xtext.resource.XtextResource;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.palladiosimulator.commons.stoex.StoexStandaloneSetup;

import tools.mdsd.library.standalone.initialization.StandaloneInitializationException;
import tools.mdsd.library.standalone.initialization.StandaloneInitializerBuilder;

public class StoexEditedResourceProviderTest {

    private StoexEditedResourceProvider subject;

    @BeforeAll
    public static void init() throws StandaloneInitializationException {
        StandaloneInitializerBuilder.builder()
            .addCustomTask(StoexStandaloneSetup::doSetup)
            .build()
            .init();
    }

    @BeforeEach
    public void setup() {
        subject = new StoexEditedResourceProvider();
    }

    @Test
    public void testXtextResource() {
        var actual = subject.createResource();
        assertThat(actual, isA(XtextResource.class));
    }

    @Test
    public void testTwoCallsDoNotYieldSameResource() {
        var actual1 = subject.createResource();
        var actual2 = subject.createResource();
        assertTrue(actual1 != actual2);
    }
}
