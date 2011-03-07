package de.uka.ipd.sdq.simulation.resources;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import scheduler.SchedulerLibrary;
import scheduler.configuration.ActiveResourceConfiguration;
import scheduler.configuration.ConfigurationFactory;
import scheduler.configuration.SchedulerConfiguration;
import de.uka.ipd.sdq.scheduler.IActiveResource;
import de.uka.ipd.sdq.scheduler.ISchedulableProcess;
import de.uka.ipd.sdq.scheduler.sensors.IActiveResourceStateSensor;
import de.uka.ipd.sdq.scheduler.tools.SchedulerTools;
import de.uka.ipd.sdq.simucomframework.Context;
import de.uka.ipd.sdq.simulation.resources.listener.IDemandListener;
import de.uka.ipd.sdq.simulation.resources.listener.IOverallUtilizationListener;
import de.uka.ipd.sdq.simulation.resources.listener.IStateListener;

/*
 * TODO: conceptually this should be an entity too
 */
public class SimulatedActiveResource {

    private static Logger logger = Logger.getLogger(SimulatedActiveResource.class);

    private Map<Integer, List<IStateListener>> stateListener;
    private List<IDemandListener> demandListener;
    private List<IOverallUtilizationListener> overallUtilizationListener;

    private IActiveResource schedulerResource;
    private String processingRate;
    private int numberOfInstances;
    private String description;

    public SimulatedActiveResource(IActiveResource resource, String processingRate, int numberOfInstances) {
        this.schedulerResource = resource;
        this.processingRate = processingRate;
        this.numberOfInstances = numberOfInstances;

        setupStateListenerAdapter(this.schedulerResource);
        stateListener = new HashMap<Integer, List<IStateListener>>();
        for (int instance = 0; instance < numberOfInstances; instance++) {
            stateListener.put(instance, new ArrayList<IStateListener>());
        }
        overallUtilizationListener = new ArrayList<IOverallUtilizationListener>();
        demandListener = new ArrayList<IDemandListener>();
    }

    /**
     * Translates the {@link IActiveResourceStateSensor} listener to the {@link IActiveResource}
     * listener. As a result, all {@link IActiveResource} listeners of this resource gets notified
     * if the encapsulated scheduler resource fires a {@link IActiveResourceStateSensor} event.
     */
    private void setupStateListenerAdapter(IActiveResource resource) {
        resource.addObserver(new IActiveResourceStateSensor() {
            @Override
            public void update(int state, int instanceId) {
                fireStateEvent(state, instanceId);
            }
        });
    }

    public void consumeResource(ISchedulableProcess process, double abstractDemand) {
        if (logger.isDebugEnabled()) {
            logger.debug("Requested resource " + schedulerResource + " with an abstract demand of " + abstractDemand);
        }
        double concreteDemand = calculateConcreteDemand(abstractDemand);
        schedulerResource.process(process, concreteDemand);

        // notify demands listeners
        fireDemand(abstractDemand);
    }

    private double calculateConcreteDemand(double abstractDemand) {
        return abstractDemand / (Double) Context.evaluateStatic(processingRate, Double.class);
    }

    /**
     * @return the id of the resource by returning the id of the encapsulated scheduler resource.
     * 
     * @see IActiveResource#getId()
     */
    public String getId() {
        return schedulerResource.getId();
    }

    /**
     * @return the name of the resource by returning the name of the encapsulated scheduler
     *         resource.
     */
    public String getName() {
        return schedulerResource.getName();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void addStateListener(final IStateListener listener, int instance) {
        stateListener.get(instance).add(listener);
    }

    public void addOverallUtilizationListener(IOverallUtilizationListener listener) {
        overallUtilizationListener.add(listener);
    }

    /**
     * @see IStateListener
     */
    protected void fireStateEvent(int queueLength, int instance) {
        for (IStateListener l : stateListener.get(instance)) {
            l.stateChanged(queueLength, instance);
        }
    }

    protected void fireOverallUtilization(double resourceDemand, double totalTime) {
        for (IOverallUtilizationListener l : overallUtilizationListener) {
            l.utilizationChanged(resourceDemand, totalTime);
        }
    }

    public void addDemandListener(IDemandListener listener) {
        demandListener.add(listener);
    }

    protected void fireDemand(double demand) {
        for (IDemandListener l : demandListener) {
            l.demand(demand);
        }
    }

    // private void registerProcessWindows(ISchedulableProcess process,
    // IActiveResource resource) {
    // if (resourceConf != null) {
    // ProcessConfiguration processConf = ConfigurationFactory.eINSTANCE
    // .createProcessConfiguration();
    // processConf.setName(process.getId());
    // processConf.setPriority(PriorityClass.DEFAULT);
    // processConf.setReplicas(1);
    // ProcessWithPriority p = (ProcessWithPriority) ISchedulingFactory.eINSTANCE
    // .createRunningProcess(process, processConf, resourceConf);
    //            
    // resource.registerProcess(p);
    // }
    // }

    public int getNumberOfInstances() {
        return numberOfInstances;
    }

    /* Loads scheduler configuration */
    private ActiveResourceConfiguration getSchedulerConfiguration(String schedulerLibFileName, String schedulerName,
            int numReplicas) {

        SchedulerLibrary lib = (SchedulerLibrary) SchedulerTools.loadFromXMI(schedulerLibFileName);
        SchedulerConfiguration selectedConf = null;
        for (SchedulerConfiguration conf : lib.getSchedulerConfiguration()) {
            if (conf.getName().equals(schedulerName)) {
                selectedConf = conf;
                break;
            }
        }
        if (selectedConf != null) {
            ActiveResourceConfiguration resourceConf = ConfigurationFactory.eINSTANCE
                    .createActiveResourceConfiguration();
            resourceConf.setName(schedulerName);
            resourceConf.setReplicas(numReplicas);
            resourceConf.setSchedulerConfiguration(selectedConf);
            return resourceConf;
        }
        return null;
    }

}
