package org.palladiosimulator.pcm.profiles.tests;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.modelversioning.emfprofile.Profile;
import org.modelversioning.emfprofile.Stereotype;
import org.modelversioning.emfprofileapplication.StereotypeApplication;
import org.palladiosimulator.mdsdprofiles.api.ProfileAPI;
import org.palladiosimulator.mdsdprofiles.api.StereotypeAPI;

import de.uka.ipd.sdq.pcm.repository.BasicComponent;
import de.uka.ipd.sdq.pcm.repository.OperationInterface;
import de.uka.ipd.sdq.pcm.repository.OperationProvidedRole;

/**
 * Tests stereotype methods by applying these to the component of the parent class' repository.
 * 
 * @author Sebastian Lehrig
 */
public class StereotypeTest extends AbstractTest {

    private static final String PROFILE_NAME = "TestProfile";
    private static final String TEST_TAGGED_VALUE = "testTaggedValue";

    private Profile profile;
    private Stereotype stereotype;
    private BasicComponent component;
    private OperationInterface componentInterface;

    @Override
    protected void load() {
        super.load();
        if (!ProfileAPI.hasProfileApplication(this.repositoryResource)) {
            ProfileAPI.applyProfile(this.repositoryResource, getProfile(PROFILE_NAME));
        }
        assertTrue(ProfileAPI.hasProfileApplication(this.repositoryResource));

        this.profile = ProfileAPI.getProfileApplication(this.repositoryResource).getImportedProfiles().get(0)
                .getProfile();
        this.stereotype = this.profile.getStereotypes().get(0);

        this.component = (BasicComponent) this.repository.getComponents__Repository().get(0);
        this.componentInterface = ((OperationProvidedRole) (this.component.getProvidedRoles_InterfaceProvidingEntity()
                .get(0))).getProvidedInterface__OperationProvidedRole();
    }

    @Test
    public void getApplicableStereotypes() {
        assertTrue(StereotypeAPI.getApplicableStereotypes(this.component).get(0).getName()
                .equals(this.stereotype.getName()));
        assertTrue(StereotypeAPI.getApplicableStereotypes(this.component, this.profile).get(0).getName()
                .equals(this.stereotype.getName()));
        assertTrue(StereotypeAPI.getApplicableStereotypes(this.component, this.stereotype.getName()).get(0).getName()
                .equals(this.stereotype.getName()));
    }

    @Test
    public void applyStereotype() {
        assertFalse(StereotypeAPI.hasStereotypeApplications(this.component));
        assertTrue(StereotypeAPI.isStereotypeApplicable(this.component, this.stereotype));
        assertFalse(StereotypeAPI.isStereotypeApplied(this.component, this.stereotype));

        StereotypeAPI.applyStereotype(this.component, this.stereotype);

        assertTrue(StereotypeAPI.hasStereotypeApplications(this.component));
        assertTrue(StereotypeAPI.isStereotypeApplied(this.component, this.stereotype));
    }

    @Test
    public void applyStereotypeString() {
        assertFalse(StereotypeAPI.hasStereotypeApplications(this.component));
        assertTrue(StereotypeAPI.isStereotypeApplicable(this.component, this.stereotype.getName()));
        assertFalse(StereotypeAPI.isStereotypeApplied(this.component, this.stereotype.getName()));

        StereotypeAPI.applyStereotype(this.component, this.stereotype.getName());

        assertTrue(StereotypeAPI.hasStereotypeApplications(this.component));
        assertTrue(StereotypeAPI.isStereotypeApplied(this.component, this.stereotype.getName()));
    }

    @Test(expected = RuntimeException.class)
    public void stereotypeNotApplicable() {
        assertFalse(StereotypeAPI.hasStereotypeApplications(this.componentInterface));
        assertFalse(StereotypeAPI.isStereotypeApplicable(this.componentInterface, this.stereotype));

        StereotypeAPI.applyStereotype(this.componentInterface, this.stereotype.getName());
    }

    private void unapplyStereotype() {
        StereotypeAPI.unapplyStereotype(this.component, this.stereotype);

        assertFalse(StereotypeAPI.hasStereotypeApplications(this.component));
        assertFalse(StereotypeAPI.isStereotypeApplied(this.component, this.stereotype));
    }

    private void unapplyStereotypeString() {
        StereotypeAPI.unapplyStereotype(this.component, this.stereotype.getName());

        assertFalse(StereotypeAPI.hasStereotypeApplications(this.component));
        assertFalse(StereotypeAPI.isStereotypeApplied(this.component, this.stereotype.getName()));
    }

    @Test
    public void applyUnapplyStereotype() {
        applyStereotype();
        unapplyStereotype();
    }

    @Test
    public void applyUnapplyStereotypeString() {
        applyStereotypeString();
        unapplyStereotypeString();
    }

    @Test
    public void applyGetUnapplyStereotypeApplication() {
        applyStereotype();
        getStereotypeApplication();
        unapplyStereotype();
    }

    private void getStereotypeApplication() {
        final StereotypeApplication stereotypeApplication = StereotypeAPI.getStereotypeApplication(this.component,
                this.stereotype);

        assertTrue(stereotypeApplication.getAppliedTo().equals(this.component));
        assertTrue(stereotypeApplication.getStereotype().getTaggedValue(TEST_TAGGED_VALUE) != null);

        assertTrue(StereotypeAPI.getStereotypeApplications(this.component).size() == 1);
        assertTrue(StereotypeAPI.getStereotypeApplications(this.component, this.profile).size() == 1);
        assertTrue(StereotypeAPI.getStereotypeApplications(this.component, this.stereotype.getName()).size() == 1);
    }

    @Test(expected = RuntimeException.class)
    public void getStereotypeApplicationWithoutBeingApplied() {
        StereotypeAPI.getStereotypeApplication(this.component, this.stereotype);
    }

    @Test
    public void storeLoadStereotypedResource() {
        assertFalse(StereotypeAPI.hasStereotypeApplications(this.component));
        applyStereotype();
        assertTrue(StereotypeAPI.hasStereotypeApplications(this.component));
        getStereotypeApplication();
        save();
        load();
        assertTrue(StereotypeAPI.hasStereotypeApplications(this.component));
        getStereotypeApplication();
        unapplyStereotype();
        assertFalse(StereotypeAPI.hasStereotypeApplications(this.component));
        save();
        load();
        assertFalse(StereotypeAPI.hasStereotypeApplications(this.component));
        reset();
    }

}
