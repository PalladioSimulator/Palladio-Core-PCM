package org.palladiosimulator.pcm.profiles.tests;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.modelversioning.emfprofile.Profile;
import org.modelversioning.emfprofile.Stereotype;
import org.modelversioning.emfprofileapplication.StereotypeApplication;

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
        if (!this.repository.hasProfileApplication()) {
            this.repository.applyProfile(getProfile(PROFILE_NAME));
        }
        assertTrue(this.repository.hasProfileApplication());

        this.profile = this.repository.getProfileApplication().getImportedProfiles().get(0).getProfile();
        this.stereotype = this.profile.getStereotypes().get(0);

        this.component = (BasicComponent) this.repository.getComponents__Repository().get(0);
        this.componentInterface = ((OperationProvidedRole) (this.component.getProvidedRoles_InterfaceProvidingEntity()
                .get(0))).getProvidedInterface__OperationProvidedRole();
    }

    @Test
    public void getApplicableStereotypes() {
        assertTrue(this.component.getApplicableStereotypes().get(0).getName().equals(this.stereotype.getName()));
        assertTrue(this.component.getApplicableStereotypes(this.profile).get(0).getName()
                .equals(this.stereotype.getName()));
        assertTrue(this.component.getApplicableStereotypes(this.stereotype.getName()).get(0).getName()
                .equals(this.stereotype.getName()));
    }

    @Test
    public void applyStereotype() {
        assertFalse(this.component.hasStereotypeApplications());
        assertTrue(this.component.isStereotypeApplicable(this.stereotype));
        assertFalse(this.component.isStereotypeApplied(this.stereotype));

        this.component.applyStereotype(this.stereotype);

        assertTrue(this.component.hasStereotypeApplications());
        assertTrue(this.component.isStereotypeApplied(this.stereotype));
    }

    @Test
    public void applyStereotypeString() {
        assertFalse(this.component.hasStereotypeApplications());
        assertTrue(this.component.isStereotypeApplicable(this.stereotype.getName()));
        assertFalse(this.component.isStereotypeApplied(this.stereotype.getName()));

        this.component.applyStereotype(this.stereotype.getName());

        assertTrue(this.component.hasStereotypeApplications());
        assertTrue(this.component.isStereotypeApplied(this.stereotype.getName()));
    }

    @Test(expected = RuntimeException.class)
    public void stereotypeNotApplicable() {
        assertFalse(this.componentInterface.hasStereotypeApplications());
        assertFalse(this.componentInterface.isStereotypeApplicable(this.stereotype));

        this.componentInterface.applyStereotype(this.stereotype.getName());
    }

    private void unapplyStereotype() {
        this.component.unapplyStereotype(this.stereotype);

        assertFalse(this.component.hasStereotypeApplications());
        assertFalse(this.component.isStereotypeApplied(this.stereotype));
    }

    private void unapplyStereotypeString() {
        this.component.unapplyStereotype(this.stereotype.getName());

        assertFalse(this.component.hasStereotypeApplications());
        assertFalse(this.component.isStereotypeApplied(this.stereotype.getName()));
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
        final StereotypeApplication stereotypeApplication = this.component.getStereotypeApplication(this.stereotype);

        assertTrue(stereotypeApplication.getAppliedTo().equals(this.component));
        assertTrue(stereotypeApplication.getExtension().getSource().getTaggedValue(TEST_TAGGED_VALUE) != null);

        assertTrue(this.component.getStereotypeApplications().size() == 1);
        assertTrue(this.component.getStereotypeApplications(this.profile).size() == 1);
        assertTrue(this.component.getStereotypeApplications(this.stereotype.getName()).size() == 1);
    }

    @Test(expected = RuntimeException.class)
    public void getStereotypeApplicationWithoutBeingApplied() {
        this.component.getStereotypeApplication(this.stereotype);
    }

    @Test
    public void storeLoadStereotypedResource() {
        assertFalse(this.component.hasStereotypeApplications());
        applyStereotype();
        assertTrue(this.component.hasStereotypeApplications());
        getStereotypeApplication();
        save();
        load();
        assertTrue(this.component.hasStereotypeApplications());
        getStereotypeApplication();
        unapplyStereotype();
        assertFalse(this.component.hasStereotypeApplications());
        save();
        load();
        assertFalse(this.component.hasStereotypeApplications());
        reset();
    }

}
