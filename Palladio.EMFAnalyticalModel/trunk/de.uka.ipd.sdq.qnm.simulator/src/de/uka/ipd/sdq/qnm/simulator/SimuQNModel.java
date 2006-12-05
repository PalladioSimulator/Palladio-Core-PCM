package de.uka.ipd.sdq.qnm.simulator;

import org.eclipse.emf.common.util.EList;

import de.uka.ipd.sdq.probfunction.math.IProbabilityDensityFunction;
import de.uka.ipd.sdq.qnm.Task;
import de.uka.ipd.sdq.qnm.resultmodel.QNMResultModel;
import de.uka.ipd.sdq.qnm.resultmodel.ResultModelFactory;
import de.uka.ipd.sdq.qnm.simulator.resources.SimulatedDelayResource;
import de.uka.ipd.sdq.qnm.simulator.resources.SimulatedPassiveResource;
import de.uka.ipd.sdq.qnm.simulator.resources.SimulatedPassiveResourceReplica;
import de.uka.ipd.sdq.qnm.simulator.resources.SimulatedProcessingResource;
import de.uka.ipd.sdq.qnm.simulator.resources.SimulatedProcessingResourceReplica;
import de.uka.ipd.sdq.qnm.simulator.resources.SimulatedResources;
import de.uka.ipd.sdq.qnm.simulator.tasks.SimulatedTask;
import de.uka.ipd.sdq.qnm.simulator.sensors.SensorFactory;
import de.uka.ipd.sdq.qnm.simulator.ui.MainUI;
import de.uka.ipd.sdq.spa.resourcemodel.AbstractResourceUsage;
import de.uka.ipd.sdq.spa.resourcemodel.DelayResource;
import de.uka.ipd.sdq.spa.resourcemodel.PassiveResource;
import de.uka.ipd.sdq.spa.resourcemodel.ProcessingResource;
import desmoj.core.dist.RealDistEmpirical;
import desmoj.core.simulator.Experiment;
import desmoj.core.simulator.Model;
import desmoj.core.simulator.ProcessQueue;
import desmoj.core.simulator.SimTime;

public class SimuQNModel extends Model {

	protected ProcessQueue taskQueue;

	protected ProcessQueue idleProcessingResourceQueue;

	private RealDistEmpirical serviceTime;

	private RealDistEmpirical thinkTime;

	private QNModelInstance emfModel;
	
	private SimulatedResources resourceContainer; 
	
	protected SensorFactory sensorFactory = null;
	
	protected static final int SIMULATION_TIME = 100000;
	
	public MonitoringData serviceTimeMonitoringData;
	public MonitoringData monitoredSingleFunction;
	
	public SimuQNModel(Model owner, String name, boolean showInReport,
			boolean showIntrace) {
		super(owner, name, showInReport, showIntrace);
		emfModel = new QNModelInstance();
		resourceContainer = new SimulatedResources();
		
		serviceTimeMonitoringData = new MonitoringData();
		monitoredSingleFunction = new MonitoringData();
		
		sensorFactory = new SensorFactory(this);
	}

	public SimuQNModel() {
		this(null, "SimuQNModel", true, true);
	}

	@Override
	public String description() {
		return "Model for simulating the queueing network part " +
			"of the Palladio Component Model (c) 2006";
	}

	@Override
	public void doInitialSchedules() {
		createSimulatedResources();
		createSimulatedTasks();
	}

	private void createSimulatedTasks() {
		EList tasks = emfModel.getQnModel().getTasks();
		for (Object o : tasks){
			Task task = (Task)o;
			AbstractResourceUsage aru = task.getResourceUsage();
			for (int i=0; i<task.getNumReplicas(); i++){
				String id = task.getName() + "#" + i;
				SimulatedTask simTask = new SimulatedTask(this,	id, false, aru);
				simTask.activate(new SimTime(0));
				resourceContainer.getResources().put(id, simTask);
			}
		}
	}

	private void createSimulatedResources() {
		EList resources = emfModel.getQnModel().getResources();
		for (Object o : resources){
			if (o instanceof ProcessingResource){
				ProcessingResource ps = (ProcessingResource)o;
				
				ProcessQueue waitingTasks = new ProcessQueue(this, ps.getName()+"TaskQueue", true, false);
				ProcessQueue waitingProcessors = new ProcessQueue(this, ps.getName()+"ProcessorQueue", true, false);
				
				SimulatedProcessingResource procRes = new SimulatedProcessingResource(this, ps.getName(), false, waitingTasks, waitingProcessors);
				resourceContainer.getResources().put(ps.getName(), procRes);
				procRes.activate(new SimTime(0));
				
				for (int i = 0; i < ps.getNumReplicas(); i++) {
					String id = ps.getName() + "_" + i;
					SimulatedProcessingResourceReplica processor = 
						new SimulatedProcessingResourceReplica(
							this, id, false, procRes);
					processor.activate(new SimTime(0));
					resourceContainer.getResources().put(id, processor);
					procRes.addChildResource(processor);
				}
			} else if (o instanceof PassiveResource){
				PassiveResource ps = (PassiveResource)o;

				ProcessQueue waitingTasks = new ProcessQueue(this, ps.getName()+"TaskQueue", true, false);
				ProcessQueue waitingPassiveResources = new ProcessQueue(this, ps.getName()+"PassiveResourceQueue", true, false);
				
				SimulatedPassiveResource passRes = new SimulatedPassiveResource(this, ps.getName(), false, waitingTasks, waitingPassiveResources);
				resourceContainer.getResources().put(ps.getName(), passRes);
				passRes.activate(new SimTime(0));
				for (int i= 0; i< ps.getNumReplicas(); i++){
					String id = ps.getName() + "_" + i;
					SimulatedPassiveResourceReplica passiveResource = 
						new SimulatedPassiveResourceReplica(
								this, id, false, passRes);
					passiveResource.activate(new SimTime(0));
					resourceContainer.getResources().put(id, passiveResource);
					passRes.addChildResource(passiveResource);
				}

			} else if (o instanceof DelayResource){
				DelayResource ds = (DelayResource)o;
				SimulatedDelayResource delayServer = 
					new SimulatedDelayResource(
							this, ds.getName(), true);
				delayServer.activate(new SimTime(0));
				resourceContainer.getResources().put(ds.getName(), delayServer);
			}
		}
	}

	@Override
	public void init() {
		taskQueue = new ProcessQueue(this, "taskQueue", true, false);
		idleProcessingResourceQueue = new ProcessQueue(this,
				"idleProcessingResourceQueue", true, false);
	}
	
	public static void main(String[] args) {
		Experiment exp = new Experiment("TestRun");

		SimuQNModel queueingModel = new SimuQNModel(null, "SimQNModel", true, false);
		queueingModel.connectToExperiment(exp);

		// set experiment parameters
		exp.setShowProgressBar(false); // display a progress bar (or not)
		exp.stop(new SimTime(SIMULATION_TIME)); // set end of simulation at 1500
												// time units
		exp.tracePeriod(new SimTime(0.0), new SimTime(SIMULATION_TIME));
		exp.debugPeriod(new SimTime(0.0), new SimTime(SIMULATION_TIME)); 
		
		new MainUI(queueingModel).setVisible(true);

		exp.start();

		// generate the report (and other output files)
		exp.report();

		// stop all threads still alive and close all output files
		exp.finish();
		
		//queueingModel.serviceTimeMonitoringData.visualize(1);
		//queueingModel.monitoredSingleFunction.visualize(1);

	}

	private static void storeResults(SimuQNModel queueingModel) {
		//ResultModelFactory resultFactory = ResultModelFactory.eINSTANCE;
		//QNMResultModel results = resultFactory.createQNMResultModel();
		
		//results.setQnmodel(new QNModelInstance().getQnModel());
		//results.getTaskResourceUsages()
		//TODO
		
		//IProbabilityDensityFunction serviceTime = queueingModel.serviceTimeMonitoringData.getDistFunc(1.0);
	}

	public SimulatedResources getResourceContainer() {
		return resourceContainer;
	}

	public void setResourceContainer(SimulatedResources resourceContainer) {
		this.resourceContainer = resourceContainer;
	}

	public MonitoringData getMonitoredSingleFunction() {
		return monitoredSingleFunction;
	}

	public void setMonitoredSingleFunction(MonitoringData monitoredSingleFunction) {
		this.monitoredSingleFunction = monitoredSingleFunction;
	}

	public SensorFactory getSensorFactory() {
		return sensorFactory;
	}

	public QNModelInstance getEmfModel() {
		return emfModel;
	}
}
