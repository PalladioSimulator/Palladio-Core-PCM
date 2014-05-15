package org.palladiosimulator.protocom.traverse.jeeservlet;

import org.palladiosimulator.protocom.traverse.framework.CommonConfigurationModule;
import org.palladiosimulator.protocom.traverse.framework.repository.XBasicComponent;
import org.palladiosimulator.protocom.traverse.framework.system.XSystem;
import org.palladiosimulator.protocom.traverse.jeeservlet.repository.JeeServletBasicComponent;
import org.palladiosimulator.protocom.traverse.jeeservlet.system.JeeServletSystem;

/**
 * 
 * @author Christian Klaussner
 */
public class JeeServletConfigurationModule extends CommonConfigurationModule {
	
	@Override
	protected void configure() {
		super.configure();
		
		bind(XBasicComponent.class).to(JeeServletBasicComponent.class);
		bind(XSystem.class).to(JeeServletSystem.class);
	}
}
