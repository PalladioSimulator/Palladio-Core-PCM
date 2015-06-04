package org.palladiosimulator.pcm.profiles.tests;

import java.io.IOException;
import java.util.Collections;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.junit.Before;
import org.junit.BeforeClass;
import org.modelversioning.emfprofile.Profile;
import org.modelversioning.emfprofile.registry.IProfileRegistry;
import org.palladiosimulator.commons.emfutils.EMFLoadHelper;

import de.uka.ipd.sdq.pcm.repository.Repository;

/**
 * @author Sebastian Lehrig
 */
public abstract class AbstractTest {

    private static final String SYSTEM_TEMP = System.getProperty("java.io.tmpdir");
    private static final String FILE_URI = "file://" + SYSTEM_TEMP + "/Palladio/ProfileTest.repository";
    private static final String REPOSITORY_URI = "platform:/plugin/org.palladiosimulator.pcm.profiles.tests/model/default.repository";
    private static final String REPOSITORY_ID = "_Mh6NQAOdEeW7RJF7nLqWPA";
    private static final String ORIGINAL_REPOSITORY_URI = REPOSITORY_URI + "#" + REPOSITORY_ID;
    private static final String STORAGE_REPOSITORY_URI = FILE_URI + "#" + REPOSITORY_ID;

    public AbstractTest() {
        super();
    }

    protected Repository repository;
    protected Resource repositoryResource;

    @BeforeClass
    public static void setUpStatic() {
        reset();
    }

    @Before
    public void setUp() {
        load();
    }

    protected static Profile getProfile(final String profileName) {
        for (final Profile profile : IProfileRegistry.eINSTANCE.getRegisteredProfiles()) {
            if (profile.getName().equals(profileName)) {
                return profile;
            }
        }

        throw new RuntimeException("GetProfile failed: No profile with name " + profileName + " found!");
    }

    protected void save() {
        try {
            this.repository.eResource().save(Collections.EMPTY_MAP);
        } catch (final IOException e) {
            e.printStackTrace();
        }
    }

    protected void load() {
        this.repository = (Repository) EMFLoadHelper.loadAndResolveEObject(STORAGE_REPOSITORY_URI);
        this.repositoryResource = this.repository.eResource();
    }

    protected static void reset() {
        final Resource resource = (new ResourceSetImpl()).createResource(URI.createURI(FILE_URI));
        resource.getContents().add(EMFLoadHelper.loadAndResolveEObject(ORIGINAL_REPOSITORY_URI));
        try {
            resource.save(Collections.EMPTY_MAP);
        } catch (final IOException e) {
            e.printStackTrace();
        }
        System.out.println("Stored repository in: " + FILE_URI);
    }
}