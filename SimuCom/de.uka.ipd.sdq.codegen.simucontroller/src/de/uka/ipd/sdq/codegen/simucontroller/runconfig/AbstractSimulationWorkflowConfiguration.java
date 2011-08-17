package de.uka.ipd.sdq.codegen.simucontroller.runconfig;

import java.util.List;

import de.uka.ipd.sdq.simucomframework.AbstractSimulationConfig;

/**
 * Abstract base class for workflow configurations of PCM simulators. 
 * 
 * @author Philipp Merkle
 *
 */
public abstract class AbstractSimulationWorkflowConfiguration extends AbstractPCMCompletionWorkflowRunConfiguration {

    private boolean simulateLinkingResources;
    private boolean simulateFailures;
    private String featureConfigFile;
    
    private AbstractSimulationConfig simConfig;
    
    public AbstractSimulationConfig getSimulationConfiguration() {
        return simConfig;
    }

    public void setSimulationConfiguration(AbstractSimulationConfig simConfig) {
        checkFixed();
        this.simConfig = simConfig;
    }
    
    public boolean getSimulateLinkingResources() {
        return simulateLinkingResources;
    }

    public void setSimulateLinkingResources(boolean simulateLinkingResources) {
        checkFixed();
        this.simulateLinkingResources = simulateLinkingResources;
        this.setLoadMiddlewareAndCompletionFiles(simulateLinkingResources);
    }
    
    public boolean getSimulateFailures() {
        return simulateFailures;
    }

    public void setSimulateFailures(boolean simulateFailures) {
        checkFixed();
        this.simulateFailures = simulateFailures;
    }
    
    /**
     * @return Returns the filename of the mark model instance containing the PCM connector completion configuration
     */
    public String getFeatureConfigFile() {
        return featureConfigFile;
    }

    /** Sets the filename of the mark model for connector completions
     * @param featureConfigFile File name of the connector completion file
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
    
}
