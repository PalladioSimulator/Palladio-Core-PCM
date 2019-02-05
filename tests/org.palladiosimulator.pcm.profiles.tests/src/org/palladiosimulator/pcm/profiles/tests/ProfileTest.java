package org.palladiosimulator.pcm.profiles.tests;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.modelversioning.emfprofileapplication.ProfileApplication;
import org.palladiosimulator.mdsdprofiles.api.ProfileAPI;

/**
 * Tests profile methods by applying these to the repository of the parent class.
 * 
 * @author Sebastian Lehrig
 */
public class ProfileTest extends AbstractTest {

    private static final String PROFILE_NAME = "TestProfile";

    @Test
    public void applyProfile() {
        assertFalse(ProfileAPI.hasProfileApplication(this.repositoryResource));

        ProfileAPI.applyProfile(this.repositoryResource, getProfile(PROFILE_NAME));

        assertTrue(ProfileAPI.hasProfileApplication(this.repositoryResource));
    }

    private void unapplyProfile() {
        ProfileAPI.unapplyProfile(this.repositoryResource, getProfile(PROFILE_NAME));

        assertFalse(ProfileAPI.hasProfileApplication(this.repositoryResource));
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
        final ProfileApplication profileApplication = ProfileAPI.getProfileApplication(this.repositoryResource);
        assertTrue(profileApplication.getImportedProfiles().get(0).getProfile().getName().equals(PROFILE_NAME));
    }

    @Test(expected = RuntimeException.class)
    public void getProfileApplicationWithoutBeingApplied() {
        getProfileApplication();
    }

    @Test
    public void storeLoadProfiledResource() {
        assertFalse(ProfileAPI.hasProfileApplication(this.repositoryResource));
        applyProfile();
        assertTrue(ProfileAPI.hasProfileApplication(this.repositoryResource));
        getProfileApplication();
        save();
        load();
        assertTrue(ProfileAPI.hasProfileApplication(this.repositoryResource));
        getProfileApplication();
        unapplyProfile();
        assertFalse(ProfileAPI.hasProfileApplication(this.repositoryResource));
        save();
        load();
        assertFalse(ProfileAPI.hasProfileApplication(this.repositoryResource));
        reset();
    }

}
