package org.palladiosimulator.pcm.profiles.tests;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.modelversioning.emfprofileapplication.ProfileApplication;

/**
 * Tests profile methods by applying these to the repository of the parent class.
 * 
 * @author Sebastian Lehrig
 */
public class ProfileTest extends AbstractTest {

    private static final String PROFILE_NAME = "TestProfile";

    @Test
    public void applyProfile() {
        assertFalse(repository.hasProfileApplication());

        repository.applyProfile(getProfile(PROFILE_NAME));

        assertTrue(repository.hasProfileApplication());
    }

    private void unapplyProfile() {
        repository.unapplyProfile(getProfile(PROFILE_NAME));

        assertFalse(repository.hasProfileApplication());
    }

    @Test
    public void applyUnapplyProfile() {
        applyProfile();
        unapplyProfile();
    }

    @Test
    public void applyGetUnapplyProfileApplication() {
        applyProfile();
        getProfileApplication();
        unapplyProfile();
    }

    private void getProfileApplication() {
        final ProfileApplication profileApplication = repository.getProfileApplication();
        assertTrue(profileApplication.getImportedProfiles().get(0).getProfile().getName().equals(PROFILE_NAME));
    }

    @Test(expected = RuntimeException.class)
    public void getProfileApplicationWithoutBeingApplied() {
        repository.getProfileApplication();
    }

    @Test
    public void storeLoadProfiledResource() {
        assertFalse(repository.hasProfileApplication());
        applyProfile();
        assertTrue(repository.hasProfileApplication());
        getProfileApplication();
        save();
        load();
        assertTrue(repository.hasProfileApplication());
        getProfileApplication();
        unapplyProfile();
        assertFalse(repository.hasProfileApplication());
        save();
        load();
        assertFalse(repository.hasProfileApplication());
        reset();
    }

}
