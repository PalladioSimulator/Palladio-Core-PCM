package de.uka.ipd.sdq.qnm.simulator.tasks;

import org.eclipse.emf.common.util.EList;

import de.uka.ipd.sdq.probfunction.BoxedPDF;
import de.uka.ipd.sdq.probfunction.ProbabilityDensityFunction;
import de.uka.ipd.sdq.probfunction.SamplePDF;
import de.uka.ipd.sdq.probfunction.math.IBoxedPDF;
import de.uka.ipd.sdq.probfunction.math.IProbabilityFunctionFactory;
import de.uka.ipd.sdq.probfunction.math.ISamplePDF;
import de.uka.ipd.sdq.probfunction.math.exception.DoubleSampleException;
import de.uka.ipd.sdq.probfunction.math.exception.ProbabilitySumNotOneException;
import de.uka.ipd.sdq.probfunction.math.exception.UnknownPDFTypeException;
import de.uka.ipd.sdq.qnm.simulator.SimuQNModel;
import de.uka.ipd.sdq.qnm.simulator.resources.SimulatedPassiveResource;
import de.uka.ipd.sdq.qnm.simulator.resources.SimulatedProcessingResource;
import de.uka.ipd.sdq.qnm.simulator.resources.SimulatedResources;
import de.uka.ipd.sdq.spa.resourcemodel.AbstractResourceUsage;
import de.uka.ipd.sdq.spa.resourcemodel.PassiveResource;
import de.uka.ipd.sdq.spa.resourcemodel.ProcessingResource;
import de.uka.ipd.sdq.spa.resourcemodel.ResourceUsage;
import de.uka.ipd.sdq.spa.resourcemodel.SequentialResourceUsage;
import desmoj.core.dist.RealDistEmpirical;
import desmoj.core.simulator.Model;
import desmoj.core.simulator.SimProcess;
import desmoj.core.simulator.SimTime;
import flanagan.complex.Complex;

public class SimulatedTask extends SimProcess {

	private static final double EPSILON = 0.0001;
	
	private AbstractResourceUsage completeResourceUsage;
	private SimuQNModel model;
	
	private Double currentDemand;
	
	private IProbabilityFunctionFactory iProbFuncFactory = IProbabilityFunctionFactory.eINSTANCE;
	
	public SimulatedTask(Model owner, String name, 
			boolean showInTrace, AbstractResourceUsage aru, SimuQNModel model) {
		super(owner, name, showInTrace);
		completeResourceUsage = aru;
		this.model = model;
	}

	@Override
	public void lifeCycle() {

		while(true){
			SimTime startTime = currentTime();
			SequentialResourceUsage myUsage = (SequentialResourceUsage)completeResourceUsage;
			
			EList resourceUsages = myUsage.getResourceUsages();
			SimulatedResources resources = model.getResourceContainer();
			
			for (Object o : resourceUsages){
				if (o instanceof SequentialResourceUsage){
					SequentialResourceUsage innerUsage = (SequentialResourceUsage)o;
					PassiveResource passiveResource = innerUsage.getPassiveResource();
					
					SimProcess process = resources.getResources().get(passiveResource.getName());
					SimulatedPassiveResource simPassRes = (SimulatedPassiveResource)process;
					simPassRes.getWaitingTasks().insert(this);
					
					//simPassRes.activate(new SimTime(SimTime.NOW));
					simPassRes.activateAfter(this);
					//simPassRes.reActivate(new SimTime(0));
					
					passivate();
					
					EList innerResourceUsage = innerUsage.getResourceUsages();
					for (Object p : innerResourceUsage){
						ResourceUsage usage = (ResourceUsage)p;
						calculateCurrentDemand(usage);
						
						ProcessingResource ps = (ProcessingResource)usage.getResource();
						
						SimProcess simProcess = resources.getResources().get(ps.getName());
						SimulatedProcessingResource simProcRes = (SimulatedProcessingResource)simProcess;
						
						simProcRes.getWaitingTasks().insert(this);
						simProcRes.activateAfter(this);

						passivate();

					}
					
					// reactivate passive resource replica after finishing execution
					simPassRes.unlock(this);
				} 
			}
			
			SimTime stopTime = currentTime();
			double responseTime = stopTime.getTimeValue() - startTime.getTimeValue();
			model.serviceTimeMonitoringData.addValue(responseTime);
		}
		
	}

	public Double getCurrentDemand(){
		return currentDemand;
	}

	public void setCurrentDemand(Double currentDemand) {
		this.currentDemand = currentDemand;
	}

	private RealDistEmpirical getEmpirical(ISamplePDF pdf, String name) {
		RealDistEmpirical result = new RealDistEmpirical(model, name, true,
				false);

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
		currentDemand = distribution.sample();
	}
	
}
