package de.uka.ipd.sdq.simulation.staticstructure.commands;

import java.util.Map;
import java.util.Map.Entry;

import de.uka.ipd.sdq.simulation.PCMModel;
import de.uka.ipd.sdq.simulation.command.BuildComponentInstances;
import de.uka.ipd.sdq.simulation.command.ICommandExecutor;
import de.uka.ipd.sdq.simulation.command.IPCMCommand;
import de.uka.ipd.sdq.simulation.staticstructure.ComponentInstance;
import de.uka.ipd.sdq.simulation.staticstructure.PassiveResourceRegistry;
import de.uka.ipd.sdq.simulation.staticstructure.SimulatedSystem;

public class BuildSimulatedSystem implements IPCMCommand<SimulatedSystem> {

    @Override
    public SimulatedSystem execute(PCMModel model, ICommandExecutor<PCMModel> executor) {
        SimulatedSystem system = new SimulatedSystem();
        
        this.passiveResourceRegistry = new PassiveResourceRegistry();
        
        // initialise resource environment and allocation
        this.resourceEnvironment = this.execute(new BuildSimulatedResourceEnvironment(this));
        this.resourceAllocation = this.execute(new BuildResourceAllocation(this.resourceEnvironment));
        
        // initialise passive resources
        this.execute(new BuildAndRegisterPassiveResources(this, this.resourceAllocation));
        
        // initialise component instances
        Map<String, ComponentInstance> components = executor.execute(new BuildComponentInstances(this, this.resourceAllocation));
        for(Entry<String, ComponentInstance> e : components.entrySet()) {
            system.addComponentInstance(e.getValue(), e.getKey());
        }
        
        return system;
    }
    
    @Override
    public boolean cachable() {
        return false;
    }

}
