package org.palladiosimulator.pcm.tests;

import org.junit.jupiter.api.Test;
import org.palladiosimulator.pcm.repository.BasicComponent;
import org.palladiosimulator.pcm.repository.RepositoryFactory;
import org.palladiosimulator.pcm.tests.impl.ConstraintTestBase;

public class InterFaceProvidingEntityTest extends ConstraintTestBase{
	
	@Test
	public void testNoID() {
		var component = createComponent();
		component.setId(null);
		assertViolation(component, "needID");
	}

	@Test
	public void testEmptyID() {
		var component = createComponent();
		component.setId("");
		assertViolation(component, "needID");
	}
	@Test
	public void testID() {
		var component = createComponent();
		component.setId("test");
		assertNoViolation(component, "needID");
	}
	
	private BasicComponent createComponent() {
		var repo = RepositoryFactory.eINSTANCE.createRepository();
		var component = RepositoryFactory.eINSTANCE.createBasicComponent();
		component.setRepository__RepositoryComponent(repo);
		return component;
	}

}
