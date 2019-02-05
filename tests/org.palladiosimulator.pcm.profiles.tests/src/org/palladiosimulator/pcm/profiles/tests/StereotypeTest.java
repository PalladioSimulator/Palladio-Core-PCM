package org.palladiosimulator.pcm.profiles.tests;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Collection;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.junit.Test;
import org.modelversioning.emfprofile.Profile;
import org.modelversioning.emfprofile.Stereotype;
import org.modelversioning.emfprofileapplication.StereotypeApplication;
import org.palladiosimulator.mdsdprofiles.api.ProfileAPI;
import org.palladiosimulator.mdsdprofiles.api.StereotypeAPI;
import org.palladiosimulator.pcm.repository.BasicComponent;
import org.palladiosimulator.pcm.repository.OperationInterface;
import org.palladiosimulator.pcm.repository.OperationProvidedRole;

/**
 * Tests stereotype methods by applying these to the component of the parent
 * class' repository.
 * 
 * @author Sebastian Lehrig, Max Schettler
 */
public class StereotypeTest extends AbstractTest {

	private static final String PROFILE_NAME = "TestProfile";
	private static final String TEST_TAGGED_VALUE = "testTaggedValue";
	private static final String TEST_TAGGED_VALUE_VALUE = "testValue";
	private static final String NONEXISTENT_TAGGED_VALUE = "nonexistentTaggedValue";

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

	@Test
	public void getParameters() {
		final Stereotype stereotype = this.stereotype;

		final Collection<EStructuralFeature> parameters = StereotypeAPI.getParameters(stereotype);
		assertTrue(parameters.size() == 1);
		assertTrue(parameters.iterator().next().getName().equals(TEST_TAGGED_VALUE));
	}

	@Test
	public void getParameter() {
		applyStereotype();
		getStereotypeApplication();
		final StereotypeApplication stereotypeApplication = StereotypeAPI.getStereotypeApplication(this.component, this.stereotype);

		final EStructuralFeature parameter = StereotypeAPI.getParameter(stereotypeApplication.getStereotype(), TEST_TAGGED_VALUE);
		assertTrue(parameter.getName().equals(TEST_TAGGED_VALUE));
		assertTrue(stereotypeApplication.eGet(parameter) == null);
	}

	@Test(expected = RuntimeException.class)
	public void getNonexistentParameter() {
		final Stereotype stereotype = this.stereotype;

		StereotypeAPI.getParameter(stereotype, NONEXISTENT_TAGGED_VALUE);
	}

	@Test
	public void storeLoadParameter() {
		applyStereotype();
		getStereotypeApplication();
		final StereotypeApplication stereotypeApplication = StereotypeAPI.getStereotypeApplication(this.component,
				this.stereotype);

		// Check that we do not start with the new value
		if (TEST_TAGGED_VALUE_VALUE.equals(stereotypeApplication.eGet(StereotypeAPI.getParameter(this.stereotype, TEST_TAGGED_VALUE)))) {
			fail();
		}

		stereotypeApplication.eSet(StereotypeAPI.getParameter(this.stereotype, TEST_TAGGED_VALUE),
				TEST_TAGGED_VALUE_VALUE);
		save();
		load();
		assertTrue(stereotypeApplication.eGet(StereotypeAPI.getParameter(this.stereotype, TEST_TAGGED_VALUE))
				.equals(TEST_TAGGED_VALUE_VALUE));
		reset();
	}

}
