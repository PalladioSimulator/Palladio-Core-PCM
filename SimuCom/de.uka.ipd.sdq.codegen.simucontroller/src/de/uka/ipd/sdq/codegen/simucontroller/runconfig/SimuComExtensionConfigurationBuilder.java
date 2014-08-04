package de.uka.ipd.sdq.codegen.simucontroller.runconfig;

import java.util.Map;

import de.uka.ipd.sdq.simucomframework.SimuComConfigExtension;
import de.uka.ipd.sdq.workflow.extension.AbstractWorkflowExtensionConfigurationBuilder;

/**
 * Provides an abstract class for which an implementation has to be provided by a SimuCom extension.
 * The class has to provide the logic to derive SimuCom configuration values based on the given
 * Eclipse AbstractWorkflowBasedRunConfiguration.
 * 
 * @author hauck
 *
 */
public abstract class SimuComExtensionConfigurationBuilder extends AbstractWorkflowExtensionConfigurationBuilder {

    public abstract SimuComConfigExtension deriveSimuComConfigExtension(Map<String, Object> configuration);

}
