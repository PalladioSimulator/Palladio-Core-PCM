package de.uka.ipd.sdq.qnm.visitors;

import org.eclipse.emf.common.util.EList;

import de.uka.ipd.sdq.probfunction.ProbabilityDensityFunction;
import de.uka.ipd.sdq.probfunction.ProbfunctionFactory;
import de.uka.ipd.sdq.probfunction.math.IProbabilityFunctionFactory;
import de.uka.ipd.sdq.probfunction.math.ISamplePDF;
import de.uka.ipd.sdq.probfunction.math.exception.DoubleSampleException;
import de.uka.ipd.sdq.probfunction.math.exception.ProbabilitySumNotOneException;
import de.uka.ipd.sdq.probfunction.math.exception.UnknownPDFTypeException;
import de.uka.ipd.sdq.probfunction.math.impl.ProbabilityFunctionFactoryImpl;
import de.uka.ipd.sdq.qnm.simulator.SimuQNModel;
import de.uka.ipd.sdq.qnm.simulator.resources.SimulatedDelayResource;
import de.uka.ipd.sdq.qnm.simulator.resources.SimulatedPassiveResource;
import de.uka.ipd.sdq.qnm.simulator.resources.SimulatedProcessingResource;
import de.uka.ipd.sdq.qnm.simulator.resources.SimulatedResources;
import de.uka.ipd.sdq.qnm.simulator.tasks.SimulatedTask;
import de.uka.ipd.sdq.spa.resourcemodel.AbstractResourceUsage;
import de.uka.ipd.sdq.spa.resourcemodel.ActiveResource;
import de.uka.ipd.sdq.spa.resourcemodel.AlternativeResourceUsage;
import de.uka.ipd.sdq.spa.resourcemodel.IterativeResourceUsage;
import de.uka.ipd.sdq.spa.resourcemodel.ParallelResourceUsage;
import de.uka.ipd.sdq.spa.resourcemodel.PassiveResource;
import de.uka.ipd.sdq.spa.resourcemodel.ProcessingResource;
import de.uka.ipd.sdq.spa.resourcemodel.Resource;
import de.uka.ipd.sdq.spa.resourcemodel.ResourceUsage;
import de.uka.ipd.sdq.spa.resourcemodel.SequentialResourceUsage;
import de.uka.ipd.sdq.spa.resourcemodel.util.ResourceModelSwitch;
import desmoj.core.dist.IntDistUniform;
import desmoj.core.dist.RealDistEmpirical;
import desmoj.core.dist.RealDistUniform;
import desmoj.core.simulator.SimProcess;
import desmoj.core.simulator.SimTime;
import flanagan.complex.Complex;

public class ResourceModelVisitor extends ResourceModelSwitch {

	private SimulatedTask task;

	private SimulatedResources resources;

	private static final double EPSILON = 0.0001;

	private IProbabilityFunctionFactory iProbFuncFactory = IProbabilityFunctionFactory.eINSTANCE;

	public ResourceModelVisitor(SimulatedTask task) {
		this.task = task;
		this.resources = ((SimuQNModel) task.getModel()).getResourceContainer();

	}

	public Object caseSequentialResourceUsage(SequentialResourceUsage sru) {
		
		SimTime startTime = task.currentTime();

		SimTime stopTime = task.currentTime();
		model.getSensorFactory().getValueSupplierForSensor(histogramId)
			.newResponseTimeMeasurement(
					SimTime.diff(stopTime, startTime).getTimeValue());
		
		
		// get corresponding passive resource
		PassiveResource passiveResource = (PassiveResource) sru.getResource();
		SimulatedPassiveResource simPassRes = acquirePassiveResource(passiveResource);

		// now execute resource usages sequentially
		EList innerResourceUsage = sru.getResourceUsages();
		for (Object o : innerResourceUsage) {
			doSwitch((AbstractResourceUsage) o);
		}

		// reactivate passive resource replica after finishing execution
		simPassRes.unlock(task);

		return sru;
	}

	public Object caseAlternativeResourceUsage(AlternativeResourceUsage aru){
		// get corresponding passive resource
		PassiveResource passiveResource = (PassiveResource) aru.getResource();
		SimulatedPassiveResource simPassRes = acquirePassiveResource(passiveResource);
		
		// now execute exactly one of the inner resource usages
		// TODO: this needs to be fixed as the probabilities 
		// for inner resource usages should be specified
		EList innerResourceUsage = aru.getResourceUsages();
		IntDistUniform distribution = new IntDistUniform(
				task.getModel(),"alternative",0,innerResourceUsage.size()-1, true, false);
		int numberOfSelectedUsage = (int)distribution.sample();
		//System.out.println("SelectedUsage: "+numberOfSelectedUsage);
		AbstractResourceUsage selectedUsage = 
			(AbstractResourceUsage) innerResourceUsage
				.get(numberOfSelectedUsage);
		doSwitch(selectedUsage);
		
		
		// reactivate passive resource replica after finishing execution
		simPassRes.unlock(task);

		return aru;
	}
	
	public Object caseIterativeResourceUsage(IterativeResourceUsage iru){
		// get corresponding passive resource
		PassiveResource passiveResource = (PassiveResource) iru.getResource();
		SimulatedPassiveResource simPassRes = acquirePassiveResource(passiveResource);
		
		// now execute the inner resource usages within a loop
		// TODO: this needs to be fixed as the number of loop
		// iterations needs to be specified
		// here: execute the loop only once
		EList innerResourceUsage = iru.getResourceUsages();
		for (Object o : innerResourceUsage) {
			doSwitch((AbstractResourceUsage) o);
		}

		// reactivate passive resource replica after finishing execution
		simPassRes.unlock(task);

		return iru;
	}
	
	public Object caseParallelResourceUsage(ParallelResourceUsage pru){
		// get corresponding passive resource
		PassiveResource passiveResource = (PassiveResource) pru.getResource();
		SimulatedPassiveResource simPassRes = acquirePassiveResource(passiveResource);
		
		// now execute the inner resource usages concurrently
		// TODO: this needs to be fixed 
		EList innerResourceUsage = pru.getResourceUsages();
		for (Object o : innerResourceUsage) {
			doSwitch((AbstractResourceUsage) o);
		}
		
		// reactivate passive resource replica after finishing execution
		simPassRes.unlock(task);

		return pru;
	}
	
	
	private SimulatedPassiveResource acquirePassiveResource(PassiveResource passiveResource) {
		SimulatedResources resources = ((SimuQNModel) task.getModel())
				.getResourceContainer();
		SimProcess process = resources.getResources().get(
				passiveResource.getName());
		SimulatedPassiveResource simPassRes = (SimulatedPassiveResource) process;
		simPassRes.getWaitingTasks().insert(task);

		// activate passive resource controller
		simPassRes.activateAfter(task);

		// wait for acquiring passive resource
		task.passivate();
		return simPassRes;
	}

	public Object caseResourceUsage(ResourceUsage ru) {
		calculateCurrentDemand(ru);
		//System.out.println("Using "+ru.getResource().getName());
		doSwitch(ru.getResource());
		return ru;
	}

	public Object caseProcessingResource(ProcessingResource pr) {

		// get the processing resource controller for this processing resource
		SimProcess simProcess = resources.getResources().get(pr.getName());
		SimulatedProcessingResource simProcRes = (SimulatedProcessingResource) simProcess;

		// enqueue
		simProcRes.getWaitingTasks().insert(task);
		simProcRes.activateAfter(task);

		// wait for service
		task.passivate();

		return pr;
	}

	private RealDistEmpirical getEmpirical(ISamplePDF pdf, String name) {
		RealDistEmpirical result = 
			new RealDistEmpirical(task.getModel(), name, true, false);

		double freq = 0;
		double pos = pdf.getDistance() / 2;
		for (Complex point : pdf.getValues()) {
			if (point.getReal() > EPSILON) {
				if (freq == 0) {
					double zeroPos = Math.max(pos - pdf.getDistance(), 0);
					result.addEntry(zeroPos, 0.0);
				}
				freq += point.getReal();
				result.addEntry(pos, freq);
			}
			pos += pdf.getDistance();
		}
		if (freq < 1.0) {
			result.addEntry(1.0, pos);
		}
		return result;
	}

	private void calculateCurrentDemand(ResourceUsage usage) {
		ProbabilityDensityFunction pdf = usage.getUsageTime();
		ISamplePDF iSamplePDF = null;
		try {
			// should work for BoxedPDF as well as SamplePDF
			iSamplePDF = iProbFuncFactory.transformToSamplePDF(pdf);
		} catch (UnknownPDFTypeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ProbabilitySumNotOneException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DoubleSampleException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		RealDistEmpirical distribution = getEmpirical(iSamplePDF, "serviceTime");
		task.setCurrentDemand(distribution.sample());
	}
}
