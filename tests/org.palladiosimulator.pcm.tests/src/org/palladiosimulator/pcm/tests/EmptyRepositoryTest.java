package org.palladiosimulator.pcm.tests;

import org.junit.jupiter.api.Test;
import org.palladiosimulator.pcm.reliability.ReliabilityFactory;
import org.palladiosimulator.pcm.repository.RepositoryFactory;
import org.palladiosimulator.pcm.tests.impl.ConstraintTestBase;

public class EmptyRepositoryTest extends ConstraintTestBase{
	
	@Test
	public void emptyRepository() {
		var repository = RepositoryFactory.eINSTANCE.createRepository();
		assertViolation(repository, "repositorynotempty");
	}
	@Test
	public void repositoryWithInterface() {
		var repository = RepositoryFactory.eINSTANCE.createRepository();
		var interfaceOperation = RepositoryFactory.eINSTANCE.createOperationInterface();
		repository.getInterfaces__Repository().add(interfaceOperation);
		assertNoViolation(repository, "repositorynotempty");
	}
	@Test
	public void repositoryComponentInterface() {
		var repository = RepositoryFactory.eINSTANCE.createRepository();
		var component = RepositoryFactory.eINSTANCE.createBasicComponent();
		repository.getComponents__Repository().add(component);
		assertNoViolation(repository, "repositorynotempty");
	}
	@Test
	public void repositoryWithDatatype() {
		var repository = RepositoryFactory.eINSTANCE.createRepository();
		var dataType = RepositoryFactory.eINSTANCE.createPrimitiveDataType();
		repository.getDataTypes__Repository().add(dataType);
		assertNoViolation(repository, "repositorynotempty");
	}
	@Test
	public void repositoryFailure() {
		var repository = RepositoryFactory.eINSTANCE.createRepository();
		var failureType = ReliabilityFactory.eINSTANCE.createSoftwareInducedFailureType();
		repository.getFailureTypes__Repository().add(failureType);
		assertNoViolation(repository, "repositorynotempty");
	}

}
