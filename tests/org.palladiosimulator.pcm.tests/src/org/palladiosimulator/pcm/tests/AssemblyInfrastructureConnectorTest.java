package org.palladiosimulator.pcm.tests;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.palladiosimulator.pcm.core.composition.AssemblyContext;
import org.palladiosimulator.pcm.core.composition.CompositionFactory;
import org.palladiosimulator.pcm.repository.BasicComponent;
import org.palladiosimulator.pcm.repository.InfrastructureProvidedRole;
import org.palladiosimulator.pcm.repository.InfrastructureRequiredRole;
import org.palladiosimulator.pcm.repository.RepositoryFactory;
import org.palladiosimulator.pcm.tests.impl.ConstraintTestBase;

public class AssemblyInfrastructureConnectorTest extends ConstraintTestBase {
	
	
	
	
	
	
	private BasicComponent providedInfrastructureComponent;
	private BasicComponent providedInfrastructureComponentAlternative;
	private BasicComponent requiredInfrastructureComponent;
	private InfrastructureProvidedRole providedRole1;
	private InfrastructureRequiredRole requiredRole1;
	private InfrastructureProvidedRole providedRole2;
	private AssemblyContext assemblyProvided;
	private AssemblyContext assemblyRequired;
	
	@BeforeEach
	void initModel() {
		providedInfrastructureComponent = RepositoryFactory.eINSTANCE.createBasicComponent();
		providedInfrastructureComponentAlternative = RepositoryFactory.eINSTANCE.createBasicComponent();
		requiredInfrastructureComponent = RepositoryFactory.eINSTANCE.createBasicComponent();
		
		providedRole1 = RepositoryFactory.eINSTANCE.createInfrastructureProvidedRole();
		requiredRole1 = RepositoryFactory.eINSTANCE.createInfrastructureRequiredRole();
		providedRole2 = RepositoryFactory.eINSTANCE.createInfrastructureProvidedRole();
		
		
		
		var infraInterface1 = RepositoryFactory.eINSTANCE.createInfrastructureInterface();
		var infraInterface2 =
				RepositoryFactory.eINSTANCE.createInfrastructureInterface();
		
		providedRole1.setProvidedInterface__InfrastructureProvidedRole(infraInterface1);
		providedRole2.setProvidedInterface__InfrastructureProvidedRole(infraInterface2);
		requiredRole1.setRequiredInterface__InfrastructureRequiredRole(infraInterface1);
		
		providedInfrastructureComponent.getProvidedRoles_InterfaceProvidingEntity().add(providedRole1);
		providedInfrastructureComponentAlternative.getProvidedRoles_InterfaceProvidingEntity().add(providedRole2);
		requiredInfrastructureComponent.getRequiredRoles_InterfaceRequiringEntity().add(requiredRole1);
		
		providedRole1.setProvidingEntity_ProvidedRole(providedInfrastructureComponent);
		providedRole2.setProvidingEntity_ProvidedRole(providedInfrastructureComponentAlternative);
		requiredRole1.setRequiringEntity_RequiredRole(requiredInfrastructureComponent);
		
		assemblyProvided = CompositionFactory.eINSTANCE.createAssemblyContext();
		assemblyRequired = CompositionFactory.eINSTANCE.createAssemblyContext();
		
		
		assemblyProvided.setEncapsulatedComponent__AssemblyContext(providedInfrastructureComponent);
		assemblyRequired.setEncapsulatedComponent__AssemblyContext(requiredInfrastructureComponent);
		

		
	}

	@Test
	void noTypeError() {

		
		var assemblyConnector = CompositionFactory.eINSTANCE.createAssemblyInfrastructureConnector();
		assemblyConnector.setProvidedRole__AssemblyInfrastructureConnector(providedRole1);
		assemblyConnector.setRequiredRole__AssemblyInfrastructureConnector(requiredRole1);
		assemblyConnector.setProvidingAssemblyContext__AssemblyInfrastructureConnector(assemblyProvided);
		assemblyConnector.setRequiringAssemblyContext__AssemblyInfrastructureConnector(assemblyRequired);
		
		
		var diagnostic = Diagnostician.INSTANCE.validate(assemblyConnector);
		
		assertFalse(diagnostic.getChildren().stream().anyMatch(this::checkForConstraint));
		
	}
	
	@Test
	void WrongProvidedTypes() {

		
		var assemblyConnector = CompositionFactory.eINSTANCE.createAssemblyInfrastructureConnector();
		assemblyConnector.setProvidedRole__AssemblyInfrastructureConnector(providedRole2);
		assemblyConnector.setRequiredRole__AssemblyInfrastructureConnector(requiredRole1);
		assemblyConnector.setProvidingAssemblyContext__AssemblyInfrastructureConnector(assemblyProvided);
		assemblyConnector.setRequiringAssemblyContext__AssemblyInfrastructureConnector(assemblyRequired);
		
		
		var diagnostic = Diagnostician.INSTANCE.validate(assemblyConnector);
		
		assertTrue(diagnostic.getChildren().stream().anyMatch(this::checkForConstraint));
		
	}
	
	@Test
	void WrongAssembly() {

		var assemblyProvided2 = CompositionFactory.eINSTANCE.createAssemblyContext();
		assemblyProvided2.setEncapsulatedComponent__AssemblyContext(providedInfrastructureComponentAlternative);
		
		var assemblyConnector = CompositionFactory.eINSTANCE.createAssemblyInfrastructureConnector();
		assemblyConnector.setProvidedRole__AssemblyInfrastructureConnector(providedRole2);
		assemblyConnector.setRequiredRole__AssemblyInfrastructureConnector(requiredRole1);
		assemblyConnector.setProvidingAssemblyContext__AssemblyInfrastructureConnector(assemblyProvided2);
		assemblyConnector.setRequiringAssemblyContext__AssemblyInfrastructureConnector(assemblyRequired);
		
		
		var diagnostic = Diagnostician.INSTANCE.validate(assemblyConnector);
		
		assertTrue(diagnostic.getChildren().stream().anyMatch(this::checkForConstraint));
		
	}
	
	@Test
	void WrongRequiredTypes() {

		
		var assemblyConnector = CompositionFactory.eINSTANCE.createAssemblyInfrastructureConnector();
		assemblyConnector.setProvidedRole__AssemblyInfrastructureConnector(providedRole2);
		assemblyConnector.setRequiredRole__AssemblyInfrastructureConnector(null);
		assemblyConnector.setProvidingAssemblyContext__AssemblyInfrastructureConnector(assemblyProvided);
		assemblyConnector.setRequiringAssemblyContext__AssemblyInfrastructureConnector(assemblyRequired);
		
		
		var diagnostic = Diagnostician.INSTANCE.validate(assemblyConnector);
		
		assertTrue(diagnostic.getChildren().stream().anyMatch(this::checkForConstraint));
		
	}
	
	
	
	private boolean checkForConstraint(Diagnostic diagnostic) {
		return diagnostic.getMessage().contains("The 'referencedInfrastructureProvidedRoleNotProvidedByAssemblyContext' constraint is violated on") ||
		diagnostic.getMessage().contains("The 'referencedInfrastructureRequiredRoleNotRequiredByAssemblyContext' constraint is violated on") ||
		diagnostic.getMessage().contains("The 'InfrastructureInterfacesNotCompatible' constraint is violated on");
	}
	

}
