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
        if (!repository.hasProfileApplication()) {
            repository.applyProfile(getProfile(PROFILE_NAME));
        }
        assertTrue(repository.hasProfileApplication());

        profile = repository.getProfileApplication().getImportedProfiles().get(0).getProfile();
        stereotype = profile.getStereotypes().get(0);

        component = (BasicComponent) repository.getComponents__Repository().get(0);
        componentInterface = ((OperationProvidedRole) (component.getProvidedRoles_InterfaceProvidingEntity().get(0)))
                .getProvidedInterface__OperationProvidedRole();
    }

    @Test
    public void getApplicableStereotypes() {
        assertTrue(component.getApplicableStereotypes().get(0).getName().equals(stereotype.getName()));
        assertTrue(component.getApplicableStereotypes(profile).get(0).getName().equals(stereotype.getName()));
        assertTrue(component.getApplicableStereotypes(stereotype.getName()).get(0).getName()
                .equals(stereotype.getName()));
    }

    @Test
    public void getProfileableElement() {
        assertTrue(component.getProfileableElement().equals(repository));
    }

    @Test
    public void applyStereotype() {
        assertFalse(component.hasStereotypeApplications());
        assertTrue(component.isStereotypeApplicable(stereotype));
        assertFalse(component.isStereotypeApplied(stereotype));

        component.applyStereotype(stereotype);

        assertTrue(component.hasStereotypeApplications());
        assertTrue(component.isStereotypeApplied(stereotype));
    }

    @Test
    public void applyStereotypeString() {
        assertFalse(component.hasStereotypeApplications());
        assertTrue(component.isStereotypeApplicable(stereotype.getName()));
        assertFalse(component.isStereotypeApplied(stereotype.getName()));

        component.applyStereotype(stereotype.getName());

        assertTrue(component.hasStereotypeApplications());
        assertTrue(component.isStereotypeApplied(stereotype.getName()));
    }

    @Test(expected = RuntimeException.class)
    public void stereotypeNotApplicable() {
        assertFalse(componentInterface.hasStereotypeApplications());
        assertFalse(componentInterface.isStereotypeApplicable(stereotype));

        componentInterface.applyStereotype(stereotype.getName());
    }

    private void unapplyStereotype() {
        component.unapplyStereotype(stereotype);

        assertFalse(component.hasStereotypeApplications());
        assertFalse(component.isStereotypeApplied(stereotype));
    }

    private void unapplyStereotypeString() {
        component.unapplyStereotype(stereotype.getName());

        assertFalse(component.hasStereotypeApplications());
        assertFalse(component.isStereotypeApplied(stereotype.getName()));
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
        final StereotypeApplication stereotypeApplication = component.getStereotypeApplication(stereotype);

        assertTrue(stereotypeApplication.getAppliedTo().equals(component));
        assertTrue(stereotypeApplication.getExtension().getSource().getTaggedValue(TEST_TAGGED_VALUE) != null);

        assertTrue(component.getStereotypeApplications().size() == 1);
        assertTrue(component.getStereotypeApplications(profile).size() == 1);
        assertTrue(component.getStereotypeApplications(stereotype.getName()).size() == 1);
    }

    @Test(expected = RuntimeException.class)
    public void getStereotypeApplicationWithoutBeingApplied() {
        component.getStereotypeApplication(stereotype);
    }

    @Test
    public void storeLoadStereotypedResource() {
        assertFalse(component.hasStereotypeApplications());
        applyStereotype();
        assertTrue(component.hasStereotypeApplications());
        getStereotypeApplication();
        save();
        load();
        assertTrue(component.hasStereotypeApplications());
        getStereotypeApplication();
        unapplyStereotype();
        assertFalse(component.hasStereotypeApplications());
        save();
        load();
        assertFalse(component.hasStereotypeApplications());
        reset();
    }

}
