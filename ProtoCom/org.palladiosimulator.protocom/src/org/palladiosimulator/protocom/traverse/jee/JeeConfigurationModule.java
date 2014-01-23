package org.palladiosimulator.protocom.traverse.jee;

import org.palladiosimulator.protocom.traverse.framework.CommonConfigurationModule;
import org.palladiosimulator.protocom.traverse.framework.repository.XBasicComponent;
import org.palladiosimulator.protocom.traverse.framework.repository.XOperationInterface;
import org.palladiosimulator.protocom.traverse.jee.repository.JeeBasicComponent;
import org.palladiosimulator.protocom.traverse.jee.repository.JeeOperationInterface;

/**
 * Google Guice binding for Java Enterprise Edition Protocom.
 * This class is not using Xtend as its superclass it not working properly with it.
 * 
 * @author Daria Giacinto
 */
public class JeeConfigurationModule extends CommonConfigurationModule {

	@Override
	protected void configure() {
		super.configure();
		bind(XBasicComponent.class).to(JeeBasicComponent.class);
		bind(XOperationInterface.class).to(JeeOperationInterface.class);
	}
	
}
