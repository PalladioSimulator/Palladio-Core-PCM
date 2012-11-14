package de.uka.ipd.sdq.codegen.simucontroller.runconfig;

import java.util.List;
import java.util.Map;

import de.uka.ipd.sdq.simulation.AbstractSimulationConfig;
import de.uka.ipd.sdq.workflow.launchconfig.extension.ExtendableJobConfiguration;
import de.uka.ipd.sdq.workflow.pcm.configurations.AbstractCodeGenerationWorkflowRunConfiguration;

public abstract class AbstractSimulationWorkflowConfiguration extends AbstractCodeGenerationWorkflowRunConfiguration
        implements Cloneable, ExtendableJobConfiguration {

    /** The configuration of the current launch to work with. */
    private Map<String, Object> attributes = null;
    
    private boolean simulateLinkingResources;
    
    private String featureConfigFile;

    public AbstractSimulationWorkflowConfiguration(Map<String, Object> attributes) {
        this.attributes = attributes;
    }
    
    public boolean getSimulateLinkingResources() {
        return simulateLinkingResources;
    }
    
    public void setSimulateLinkingResources(boolean simulateLinkingResources) {
        checkFixed();
        this.simulateLinkingResources = simulateLinkingResources;
        this.setLoadMiddlewareAndCompletionFiles(simulateLinkingResources);
    }
    
    public abstract AbstractSimulationConfig getSimulationConfiguration();
    
    /**
     * Get the configuration of the current launch.
     * 
     * @return the launchConfiguration
     */
    public Map<String, Object> getAttributes() {
        return attributes;
    }
    
    /**
     * @return Returns the filename of the mark model instance containing the
     *         PCM connector completion configuration
     */
    public String getFeatureConfigFile() {
        return featureConfigFile;
    }

    /**
     * Sets the filename of the mark model for connector completions
     *
     * @param featureConfigFile
     *            File name of the connector completion file
     */
    public void setFeatureConfigFile(String featureConfigFile) {
        checkFixed();
        this.featureConfigFile = featureConfigFile;
    }
    
    /**
     * Call super.getPCMModelFiles and then add my own featureconfig file.
     */
    @Override
    public List<String> getPCMModelFiles() {
        List<String> pcmModelFiles = super.getPCMModelFiles();

        if (featureConfigFile != null)
            pcmModelFiles.add(featureConfigFile);

        return pcmModelFiles;
    }
    
    @Override
    protected Object clone() throws CloneNotSupportedException {
    	AbstractSimulationWorkflowConfiguration config = (AbstractSimulationWorkflowConfiguration) super.clone();
    	config.featureConfigFile = this.featureConfigFile;
    	config.simulateLinkingResources = this.simulateLinkingResources;
		return config;
    }
    
}
