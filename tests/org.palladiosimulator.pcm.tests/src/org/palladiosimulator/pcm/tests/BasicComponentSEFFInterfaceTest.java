package org.palladiosimulator.pcm.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.palladiosimulator.pcm.repository.BasicComponent;
import org.palladiosimulator.pcm.repository.InfrastructureSignature;
import org.palladiosimulator.pcm.repository.OperationSignature;
import org.palladiosimulator.pcm.repository.RepositoryFactory;
import org.palladiosimulator.pcm.seff.ResourceDemandingSEFF;
import org.palladiosimulator.pcm.seff.SeffFactory;
import org.palladiosimulator.pcm.tests.impl.ConstraintTestBase;

/**
 * For testing the OCL constraint everyOperationInterfaceMethodsNeedsSEFF
 * @author majuwa
 *
 */
public class BasicComponentSEFFInterfaceTest extends ConstraintTestBase {
	
	private OperationSignature operationSignature;
	private InfrastructureSignature infrastructureSignature;
	private BasicComponent component;
	private ResourceDemandingSEFF seff;
	
	
	@BeforeEach
	void initTest() {
		var repository = RepositoryFactory.eINSTANCE.createRepository();
		
		component = RepositoryFactory.eINSTANCE.createBasicComponent();
		component.setRepository__RepositoryComponent(repository);
		
		
		var operationInterface = RepositoryFactory.eINSTANCE.createOperationInterface();
		operationSignature = RepositoryFactory.eINSTANCE.createOperationSignature();
		operationSignature.setEntityName("test");
		operationInterface.getSignatures__OperationInterface().add(operationSignature);
		
		repository.getInterfaces__Repository().add(operationInterface);
		
		var providedOperationRole = RepositoryFactory.eINSTANCE.createOperationProvidedRole();
		providedOperationRole.setProvidedInterface__OperationProvidedRole(operationInterface);
		providedOperationRole.setProvidingEntity_ProvidedRole(component);
		
		var infrastructureInterface = RepositoryFactory.eINSTANCE.createInfrastructureInterface();
		infrastructureSignature = RepositoryFactory.eINSTANCE.createInfrastructureSignature();
		infrastructureSignature.setEntityName("testInfra");
		infrastructureInterface.getInfrastructureSignatures__InfrastructureInterface().add(infrastructureSignature);
		
		var providedInfrastructureRole = RepositoryFactory.eINSTANCE.createInfrastructureProvidedRole();
		providedInfrastructureRole.setProvidedInterface__InfrastructureProvidedRole(infrastructureInterface);
		providedInfrastructureRole.setProvidingEntity_ProvidedRole(component);
		
		seff = SeffFactory.eINSTANCE.createResourceDemandingSEFF();
		
		var startAction = SeffFactory.eINSTANCE.createStartAction();
		var stopAction = SeffFactory.eINSTANCE.createStopAction();
		
		seff.getSteps_Behaviour().add(startAction);
		seff.getSteps_Behaviour().add(stopAction);
		startAction.setSuccessor_AbstractAction(stopAction);
		stopAction.setPredecessor_AbstractAction(startAction);
		
		component.getServiceEffectSpecifications__BasicComponent().add(seff);
		
	}
	
	@Test
	void noSeffOperation() {
		component.getProvidedRoles_InterfaceProvidingEntity().remove(1);
		component.getServiceEffectSpecifications__BasicComponent().clear();
		assertViolation(component, "everyOperationInterfaceMethodsNeedsSEFF");
	}
	
	@Test
	void seffWrongServiceOperation() {
		component.getProvidedRoles_InterfaceProvidingEntity().remove(1);
		seff.setDescribedService__SEFF(null);
		assertViolation(component, "everyOperationInterfaceMethodsNeedsSEFF");
	}
	
	@Test
	void SeffOperation() {
		component.getProvidedRoles_InterfaceProvidingEntity().remove(1);
		seff.setDescribedService__SEFF(operationSignature);
		assertNoViolation(component, "everyOperationInterfaceMethodsNeedsSEFF");
	}
	@Test
	void noSeffInfrastructure() {
		component.getProvidedRoles_InterfaceProvidingEntity().remove(0);
		component.getServiceEffectSpecifications__BasicComponent().clear();
		assertViolation(component, "everyInfrastructureInterfaceMethodsNeedsSEFF");
	}
	
	@Test
	void seffWrongServiceInfrastructure() {
		component.getProvidedRoles_InterfaceProvidingEntity().remove(0);
		seff.setDescribedService__SEFF(null);
		assertViolation(component, "everyInfrastructureInterfaceMethodsNeedsSEFF");
	}
	
	@Test
	void SeffInfrastructure() {
		component.getProvidedRoles_InterfaceProvidingEntity().remove(0);
		seff.setDescribedService__SEFF(infrastructureSignature);
		assertNoViolation(component, "everyInfrastructureInterfaceMethodsNeedsSEFF");
	}
	
	
}
