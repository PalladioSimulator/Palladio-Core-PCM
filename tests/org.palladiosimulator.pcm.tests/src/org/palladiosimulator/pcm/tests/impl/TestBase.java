package org.palladiosimulator.pcm.tests.impl;

import java.util.Collection;
import java.util.Iterator;
import java.util.Optional;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import tools.mdsd.library.standalone.initialization.StandaloneInitializationException;
import tools.mdsd.library.standalone.initialization.StandaloneInitializerBuilder;

public class TestBase {

    private static final String PROJECT_NAME_TEST = "org.palladiosimulator.pcm.tests";
    private ResourceSetImpl rs;

    @BeforeAll
    public static void init() throws StandaloneInitializationException {
        StandaloneInitializerBuilder.builder()
            .registerProjectURI(ConstraintTestBase.class, PROJECT_NAME_TEST)
            .build()
            .init();
    }

    @BeforeEach
    public void setup() {
        rs = new ResourceSetImpl();
    }

    public <T extends EObject> T loadModel(String path, Class<T> rootElementType) {
        return Optional.ofNullable(rs.getResource(createURIFromRelativePath(path), true))
            .map(Resource::getContents)
            .map(Collection::iterator)
            .map(Iterator::next)
            .filter(rootElementType::isInstance)
            .map(rootElementType::cast)
            .orElseThrow(() -> new IllegalArgumentException());
    }

    protected static URI createURIFromRelativePath(String path) {
        return URI.createPlatformPluginURI(String.format("%s/%s", PROJECT_NAME_TEST, path), false);
    }

}
