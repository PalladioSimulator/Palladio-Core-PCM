//package edu.kit.ipd.sdq.eventsim.resources.probespec.commands;
//
//import java.util.LinkedHashSet;
//import java.util.Set;
//
//import edu.kit.ipd.sdq.eventsim.command.ICommand;
//import edu.kit.ipd.sdq.eventsim.command.ICommandExecutor;
//import edu.kit.ipd.sdq.eventsim.resources.entities.SimActiveResource;
//import edu.kit.ipd.sdq.eventsim.system.staticstructure.SimulatedResourceContainer;
//import edu.kit.ipd.sdq.eventsim.system.staticstructure.SimulatedResourceEnvironment;
//import edu.kit.ipd.sdq.simcomp.component.IPCMModel;
//
///**
// * Creates and returns a set of all active resources present in a specified
// * {@link SimulatedResourceEnvironment}.
// * 
// * @author Philipp Merkle
// * 
// */
//public class CollectActiveResources implements ICommand<Set<SimActiveResource>, IPCMModel> {
//
//    private SimulatedResourceEnvironment environment;
//
//    public CollectActiveResources(SimulatedResourceEnvironment environment) {
//        this.environment = environment;
//    }
//
//    @Override
//    public Set<SimActiveResource> execute(IPCMModel pcm, ICommandExecutor<IPCMModel> executor) {
//        // collect all active resources
//        Set<SimActiveResource> resources = new LinkedHashSet<SimActiveResource>();
//        for (SimulatedResourceContainer c : environment.getResourceContainers()) {
//            for (SimActiveResource r : c.getResources()) {
//                resources.add(r);
//            }
//        }
////        return resources;
//    }
//
//    @Override
//    public boolean cachable() {
//        return false;
//    }
//
//}
