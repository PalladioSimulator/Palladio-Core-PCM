package de.uka.ipd.sdq.measurements.osscheduler.systemadapter;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Logger;

import org.eclipse.emf.common.util.EList;

import de.uka.ipd.sdq.identifier.Identifier;
import de.uka.ipd.sdq.measurements.MachineDescription;
import de.uka.ipd.sdq.measurements.MachineMapping;
import de.uka.ipd.sdq.measurements.MachineReference;
import de.uka.ipd.sdq.measurements.rmi.tasks.RmiAbstractTask;
import de.uka.ipd.sdq.measurements.rmi.tasks.RmiDemand;
import de.uka.ipd.sdq.measurements.rmi.tasks.RmiLoopTask;
import de.uka.ipd.sdq.measurements.rmi.tasks.RmiMachineTask;
import de.uka.ipd.sdq.measurements.rmi.tasks.RmiParallelProcessTask;
import de.uka.ipd.sdq.measurements.rmi.tasks.RmiParallelTask;
import de.uka.ipd.sdq.measurements.rmi.tasks.RmiResourceStrategyMeasurementAfterIoTask;
import de.uka.ipd.sdq.measurements.rmi.tasks.RmiResourceStrategyMeasurementTask;
import de.uka.ipd.sdq.measurements.rmi.tasks.RmiSequenceTask;
import de.uka.ipd.sdq.measurements.scheduler.ParallelProcessTask;
import de.uka.ipd.sdq.measurements.scheduler.ResourceStrategyDemand;
import de.uka.ipd.sdq.measurements.scheduler.ResourceStrategyMeasurementAfterIoTask;
import de.uka.ipd.sdq.measurements.scheduler.ResourceStrategyMeasurementTask;
import de.uka.ipd.sdq.measurements.scheduler.impl.ParallelProcessTaskImpl;
import de.uka.ipd.sdq.measurements.scheduler.impl.ResourceStrategyMeasurementAfterIoTaskImpl;
import de.uka.ipd.sdq.measurements.scheduler.impl.ResourceStrategyMeasurementTaskImpl;
import de.uka.ipd.sdq.measurements.tasks.AbstractTask;
import de.uka.ipd.sdq.measurements.tasks.LoopTask;
import de.uka.ipd.sdq.measurements.tasks.MachineTask;
import de.uka.ipd.sdq.measurements.tasks.ParallelTask;
import de.uka.ipd.sdq.measurements.tasks.SequenceTask;
import de.uka.ipd.sdq.measurements.tasks.TaskSet;
import de.uka.ipd.sdq.measurements.tasks.impl.LoopTaskImpl;
import de.uka.ipd.sdq.measurements.tasks.impl.ParallelTaskImpl;
import de.uka.ipd.sdq.measurements.tasks.impl.SequenceTaskImpl;
import de.uka.ipd.sdq.probespec.BinaryCalculator;
import de.uka.ipd.sdq.probespec.Calculator;
import de.uka.ipd.sdq.probespec.ProbeSet;
import de.uka.ipd.sdq.probespec.ProbeSetPosition;
import de.uka.ipd.sdq.probespec.ProbeSpecRepository;

public class EmfTaskToRmiTaskConverter {
	
	private static Logger logger = Logger.getLogger(EmfTaskToRmiTaskConverter.class.getName());
	private static int idCounter = 0;
	
	TaskSet taskSet = null;
	List<MachineDescription> machineDescriptions = null;
	
	public EmfTaskToRmiTaskConverter(TaskSet taskSet, List<MachineDescription> machineDescriptions) {
		this.taskSet = taskSet;
		this.machineDescriptions = machineDescriptions;
	}
	
	public RmiAbstractTask convert(AbstractTask emfTask) {
		if (emfTask.getClass().equals(SequenceTaskImpl.class)) {
			return convertSequenceTask((SequenceTask)emfTask);
		} else if (emfTask.getClass().equals(ParallelTaskImpl.class)) {
			return convertParallelTask((ParallelTask)emfTask);
		} else if (emfTask.getClass().equals(LoopTaskImpl.class)) {
			return convertLoopTask((LoopTask)emfTask);
		} else if (emfTask.getClass().equals(ResourceStrategyMeasurementTaskImpl.class)) {
			return convertResourceStrategyMeasurementTask((ResourceStrategyMeasurementTask)emfTask);
		} else if (emfTask.getClass().equals(ParallelProcessTaskImpl.class)) {
			return convertParallelProcessTask((ParallelProcessTask)emfTask);
		} else if (emfTask.getClass().equals(ResourceStrategyMeasurementAfterIoTaskImpl.class)) {
			return convertResourceStrategyMeasurementAfterIoTask((ResourceStrategyMeasurementAfterIoTask)emfTask);
		}
		return null;
	}
	
	private void prepareAbstractTask(RmiAbstractTask rmiAbstractTask, AbstractTask emfTask) {
		rmiAbstractTask.setName(emfTask.getName());
		if (hasSensor(emfTask, taskSet.getProbeSpecRepository())) {
			rmiAbstractTask.setSensor(true);
		}
	}
	
	private void prepareMachineTask(RmiMachineTask rmiMachineTask, MachineTask emfTask) {
		prepareAbstractTask(rmiMachineTask, emfTask);
		MachineDescription description = getMachineDescription(emfTask.getMachine());
		if (description != null) {
			rmiMachineTask.setMachineIp(description.getIp());
			rmiMachineTask.setMachinePort(description.getPort());
			rmiMachineTask.setMachineName(description.getName());
		}
	}
	
	private MachineDescription getMachineDescription(
			MachineReference machineReference) {
		for (MachineDescription description : machineDescriptions) {
			for (MachineMapping mapping : description.getMachineMappings()) {
				if (mapping.getMachineReference().equals(machineReference)) {
					return description;
				}
			}
		}
		logger.severe("No machine reference found!");
		return null;
	}
	
	public RmiAbstractTask convertSequenceTask(SequenceTask emfTask) {
		RmiSequenceTask rmiSequenceTask = new RmiSequenceTask(++idCounter);
		prepareAbstractTask(rmiSequenceTask, emfTask);
		List<RmiAbstractTask> tasks = new ArrayList<RmiAbstractTask>();
		Iterator<AbstractTask> taskIterator = emfTask.getTasks().iterator();
		while (taskIterator.hasNext()) {
			tasks.add(convert(taskIterator.next()));
		}
		rmiSequenceTask.setTasks(tasks);
		return rmiSequenceTask;
	}
	
	public RmiAbstractTask convertParallelTask(ParallelTask emfTask) {
		RmiParallelTask rmiParallelTask = new RmiParallelTask(++idCounter);
		prepareAbstractTask(rmiParallelTask, emfTask);
		List<RmiAbstractTask> tasks = new ArrayList<RmiAbstractTask>();
		Iterator<AbstractTask> taskIterator = emfTask.getTasks().iterator();
		while (taskIterator.hasNext()) {
			tasks.add(convert(taskIterator.next()));
		}
		rmiParallelTask.setTasks(tasks);
		return rmiParallelTask;
	}
	
	public RmiAbstractTask convertParallelProcessTask(ParallelProcessTask emfTask) {
		RmiParallelProcessTask rmiParallelProcessTask = new RmiParallelProcessTask(++idCounter);
		prepareAbstractTask(rmiParallelProcessTask, emfTask);
		List<RmiAbstractTask> tasks = new ArrayList<RmiAbstractTask>();
		Iterator<AbstractTask> taskIterator = emfTask.getTasks().iterator();
		while (taskIterator.hasNext()) {
			tasks.add(convert(taskIterator.next()));
		}
		rmiParallelProcessTask.setTasks(tasks);
		return rmiParallelProcessTask;
	}
	
	public RmiAbstractTask convertLoopTask(LoopTask emfTask) {
		RmiLoopTask rmiLoopTask = new RmiLoopTask(++idCounter);
		prepareAbstractTask(rmiLoopTask, emfTask);
		rmiLoopTask.setNumberOfIterations(emfTask.getNumberOfIterations());
		rmiLoopTask.setNestedTask(convert(emfTask.getTask()));
		return rmiLoopTask;
	}
	
	public RmiAbstractTask convertResourceStrategyMeasurementTask(ResourceStrategyMeasurementTask emfTask) {
		RmiResourceStrategyMeasurementTask rmiResourceStrategyMeasurementTask = new RmiResourceStrategyMeasurementTask(++idCounter);
		prepareResourceStrategyMeasurementTask(rmiResourceStrategyMeasurementTask, emfTask);
		return rmiResourceStrategyMeasurementTask;
	}
	
	private void prepareResourceStrategyMeasurementTask(RmiResourceStrategyMeasurementTask rmiTask, ResourceStrategyMeasurementTask emfTask) {
		prepareMachineTask(rmiTask, emfTask);
		rmiTask.setMeasurementTime(emfTask.getDuration());
		rmiTask.setDemand(getRmiDemand(emfTask.getDemand()));
	}
	
	private RmiDemand getRmiDemand(ResourceStrategyDemand demand) {
		switch (demand) {
		case MANDELBROT_DEMAND:
			return RmiDemand.MANDELBROT_DEMAND;
		case FIBONACCI_DEMAND:
			return RmiDemand.FIBONACCI_DEMAND;
		case WAIT_DEMAND:
			return RmiDemand.WAIT_DEMAND;
		case READ_FROM_HDD_DEMAND:
			return RmiDemand.READ_FROM_HDD_DEMAND;
		}
		return null;
	}
	
	public RmiAbstractTask convertResourceStrategyMeasurementAfterIoTask(ResourceStrategyMeasurementAfterIoTask emfTask) {
		RmiResourceStrategyMeasurementAfterIoTask rmiResourceStrategyMeasurementAfterIoTask = new RmiResourceStrategyMeasurementAfterIoTask(++idCounter);
		prepareResourceStrategyMeasurementTask(rmiResourceStrategyMeasurementAfterIoTask, emfTask);
		return rmiResourceStrategyMeasurementAfterIoTask;
	}
	
	
	
	
	private boolean hasSensor(AbstractTask emfTask, ProbeSpecRepository probeSpecRepository) {
		for (Calculator calculator : probeSpecRepository.getCalculator()) {
			if (calculator instanceof BinaryCalculator) {
				BinaryCalculator binaryCalculator = (BinaryCalculator)calculator;
				List<ProbeSet> relevantProbeSets = getProbeSetsForTask(emfTask, binaryCalculator.getProbeSet());
				// Look, if we have at least one probeset with position BEFORE and one with position AFTER
				boolean foundBefore = false;
				boolean foundAfter = false;
				for (ProbeSet probeSet : relevantProbeSets) {
					if (probeSet.getPosition().equals(ProbeSetPosition.BEFORE)) {
						foundBefore = true;
					} else if (probeSet.getPosition().equals(ProbeSetPosition.AFTER)) {
						foundAfter = true;
					}
					if ((foundBefore == true) && (foundAfter == true)) {
						// TODO currently we don't check what kind of probs are in the probeset
						// (there should be at least one CurrentTimeProbe)
						return true;
					}
				}
			}
		}
	return false;	
	}
	
	private List<ProbeSet> getProbeSetsForTask(AbstractTask emfTask, EList<ProbeSet> probeSets) {
		List<ProbeSet> foundProbeSets = new ArrayList<ProbeSet>();
		for (ProbeSet probeSet : probeSets) {
			if (probeSet.getAnnotatedElement() instanceof Identifier) {
				if (((Identifier)probeSet.getAnnotatedElement()).getId().equals(emfTask.getId())) {
					foundProbeSets.add(probeSet);
				}
			}
		}
		return foundProbeSets;
	}

}
