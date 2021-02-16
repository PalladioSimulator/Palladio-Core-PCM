package org.palladiosimulator.pcm.stoex.api.impl;

import java.util.Collection;
import java.util.Iterator;
import java.util.Optional;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.TestMethodOrder;

import tools.mdsd.library.standalone.initialization.StandaloneInitializationException;
import tools.mdsd.library.standalone.initialization.StandaloneInitializerBuilder;

@TestMethodOrder(OrderAnnotation.class)
public class TestBase {
    
    private static final String PROJECT_NAME_TEST = "org.palladiosimulator.pcm.tests";
    protected ResourceSetImpl rs;

    @BeforeAll
    public static void init() throws StandaloneInitializationException {
        StandaloneInitializerBuilder.builder()
            .registerProjectURI(TestBase.class, PROJECT_NAME_TEST)
            .build()
            .init();
    }

    @BeforeEach
    public void setup() {
        rs = new ResourceSetImpl();
    }

    protected <T extends EObject> T loadModel(String path, Class<T> rootElementType) {
        return Optional.ofNullable(rs.getResource(createURIFromRelativePath(path), true))
            .map(Resource::getContents)
            .map(Collection::iterator)
            .map(Iterator::next)
            .filter(rootElementType::isInstance)
            .map(rootElementType::cast)
            .orElseThrow(() -> new IllegalArgumentException());
    }

    protected static URI createURIFromRelativePath(String path) {
        return URI.createPlatformResourceURI(String.format("%s/%s", PROJECT_NAME_TEST, path), false);
    }
}
