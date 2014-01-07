package com.palladio_simulator.protocom.traverse.jse;

import com.palladio_simulator.protocom.traverse.framework.CommonConfigurationModule;
import com.palladio_simulator.protocom.traverse.framework.allocation.XAllocation;
import com.palladio_simulator.protocom.traverse.framework.repository.XBasicComponent;
import com.palladio_simulator.protocom.traverse.framework.repository.XCompositeComponent;
import com.palladio_simulator.protocom.traverse.framework.repository.XInfrastructureInterface;
import com.palladio_simulator.protocom.traverse.framework.repository.XOperationInterface;
import com.palladio_simulator.protocom.traverse.framework.resourceenvironment.XResourceEnvironment;
import com.palladio_simulator.protocom.traverse.framework.system.XSystem;
import com.palladio_simulator.protocom.traverse.framework.usage.XUsageScenario;
import com.palladio_simulator.protocom.traverse.jse.allocation.JseAllocation;
import com.palladio_simulator.protocom.traverse.jse.repository.JseBasicComponent;
import com.palladio_simulator.protocom.traverse.jse.repository.JseCompositeComponent;
import com.palladio_simulator.protocom.traverse.jse.repository.JseInfrastructureInterface;
import com.palladio_simulator.protocom.traverse.jse.repository.JseOperationInterface;
import com.palladio_simulator.protocom.traverse.jse.resourceenvironment.JseResourceEnvironment;
import com.palladio_simulator.protocom.traverse.jse.system.JseSystem;
import com.palladio_simulator.protocom.traverse.jse.usage.JseUsageScenario;

/**
 * Google Guice binding for Java Standard Edition Protocom.
 * This class is not using Xtend as its superclass it not working properly with it.
 * 
 * @author Thomas Zolynski
 */
public class JseConfigurationModule extends CommonConfigurationModule {

	@Override
	protected void configure() {
		super.configure();
		
		bind(XBasicComponent.class).to(JseBasicComponent.class);
		bind(XCompositeComponent.class).to(JseCompositeComponent.class);
		bind(XOperationInterface.class).to(JseOperationInterface.class);
		bind(XInfrastructureInterface.class).to(JseInfrastructureInterface.class);
		bind(XSystem.class).to(JseSystem.class);
		bind(XAllocation.class).to(JseAllocation.class);
		bind(XResourceEnvironment.class).to(JseResourceEnvironment.class);
		bind(XUsageScenario.class).to(JseUsageScenario.class);
	}
	
}
