package de.uka.ipd.sdq.spa.concurrencysolver;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import de.uka.ipd.sdq.probfunction.math.IProbabilityDensityFunction;
import de.uka.ipd.sdq.probfunction.math.IProbabilityFunctionFactory;
import de.uka.ipd.sdq.probfunction.math.IProbabilityMassFunction;
import de.uka.ipd.sdq.probfunction.math.ISample;
import de.uka.ipd.sdq.probfunction.math.IUnit;
import de.uka.ipd.sdq.probfunction.math.ManagedPDF;
import de.uka.ipd.sdq.probfunction.math.ManagedPMF;
import de.uka.ipd.sdq.probfunction.math.exception.ProbabilityFunctionException;
import de.uka.ipd.sdq.qnm.QNModel;
import de.uka.ipd.sdq.qnm.Task;
import de.uka.ipd.sdq.qnm.resultmodel.QNMResultModel;
import de.uka.ipd.sdq.qnm.resultmodel.ResourceUsageTime;
import de.uka.ipd.sdq.qnm.resultmodel.ResultModelFactory;
import de.uka.ipd.sdq.qnm.resultmodel.ServiceTimeBreakDown;
import de.uka.ipd.sdq.qnm.resultmodel.TaskResourceUsage;
import de.uka.ipd.sdq.spa.basicsolver.operations.RUOperations;
import de.uka.ipd.sdq.spa.concurrencysolver.qnm.helper.QNHelper;
import de.uka.ipd.sdq.spa.resourcemodel.AbstractResourceUsage;
import de.uka.ipd.sdq.spa.resourcemodel.DelayResource;
import de.uka.ipd.sdq.spa.resourcemodel.Resource;
import de.uka.ipd.sdq.spa.resourcemodel.ResourceUsage;
import de.uka.ipd.sdq.spa.resourcemodel.SequentialResourceUsage;

@SuppressWarnings("unchecked")
public class QNSolver {
	
	private static ResultModelFactory resultFactory = ResultModelFactory.eINSTANCE;
	private static IProbabilityFunctionFactory pfFactory = IProbabilityFunctionFactory.eINSTANCE;
	
	private int numSamplingPoints = 256;
	private double distance = 10.0;
	private IUnit timeUnit = pfFactory.createUnit("ms");
	private IUnit queueLengthUnit = pfFactory.createUnit("queue length");
	
	
	private QNMResultModel resultModel;
	private QNModel qnModel;
	private QNHelper qnHelper;
	
	private RUOperations operations;
	
	
	public QNSolver(QNModel qnModel) {
		super();
		this.qnModel = qnModel;
		this.resultModel = initialize();
		this.qnHelper = new QNHelper(resultModel);
		this.operations = new RUOperations(numSamplingPoints);
	}
	
	

	public QNModel getQnModel() {
		return qnModel;
	}



	public QNMResultModel getResultModel() {
		return resultModel;
	}


	
	
	public void solve() throws ProbabilityFunctionException {
		do{
			computeResponseTimes();
			computeAverageServiceTimes();
			computeUsageTimes();
			computeUsageProbabilities();
			computeQueueLengths();
			computeWaitingTimes();
		} while (!fixPointReached());
	}
	

	private boolean fixPointReached() {
		// TODO Auto-generated method stub
		return false;
	}



	private void computeWaitingTimes() {
		// TODO Auto-generated method stub
		
	}



	private void computeQueueLengths() {
		// TODO Auto-generated method stub
		
	}



	private void computeUsageProbabilities() {
		// TODO Auto-generated method stub
		
	}



	private void computeUsageTimes() {
		// TODO Auto-generated method stub
		
	}



	private void computeAverageServiceTimes() throws ProbabilityFunctionException {
		for (Iterator taskIter = qnModel.getTasks().iterator(); taskIter.hasNext();) {
			Task task = (Task) taskIter.next();
			for (Iterator resourceIter = qnModel.getResources().iterator(); resourceIter.hasNext();) {
				Resource resource = (Resource) resourceIter.next();
				TaskResourceUsage tru = qnHelper.getTaskResourceUsage(task, resource);
				ManagedPDF taskServiceTime = getTaskServiceTime(task, resource);
				tru.setTaskServiceTime(taskServiceTime);
			}
		}
	}



	private ManagedPDF getTaskServiceTime(Task task, Resource resource) throws ProbabilityFunctionException {
		List<AbstractResourceUsage> usageList = qnHelper.getUsagesOf(task,resource);
		if (usageList.size() > 0) {
			IProbabilityDensityFunction resultPDF = getZeroFunction().getPdfFrequencyDomain();
			double prob = 1.0 / (double) usageList.size();
			for (AbstractResourceUsage usage : usageList) {
				ResourceUsageTime time = qnHelper.getUsageTime(usage);
				IProbabilityDensityFunction pdf = time.getServiceTime().getPdfFrequencyDomain();
				resultPDF = resultPDF.add(pdf.scale(prob));
			}
			return new ManagedPDF(resultPDF);
		} else {
			return getZeroTime();
		}
	}



	private void computeResponseTimes() throws ProbabilityFunctionException {
		for (Object taskObj : qnModel.getTasks()) {
			Task task = (Task) taskObj;
			computeResponseTime(task.getResourceUsage(), task);
		}
	}



	private void computeResponseTime(AbstractResourceUsage abstractUsage, Task task) throws ProbabilityFunctionException {
		ResourceUsageTime time = computeServiceTime(abstractUsage, task);
		
		if (abstractUsage.getResource() instanceof DelayResource) {
			time.setResponseTime(time.getServiceTime()); // no queueing for delayresources
		} else {
			ManagedPDF waitingTime = getWaitingTimeFor(abstractUsage.getResource(), task);
			ManagedPDF responseTime = operations.computeSequence(time.getServiceTime(), waitingTime);
			time.setResponseTime(responseTime);
		}
	}

	private ManagedPDF getWaitingTimeFor(Resource resource, Task task) throws ProbabilityFunctionException {
		List<Task> usingTasks = qnHelper.getUsingTasks(resource);
		ManagedPDF waitingTime = getZeroTime();
		for (Task usingTask : usingTasks) {
			TaskResourceUsage usage = qnHelper.getTaskResourceUsage(usingTask, resource);
			if (task.equals(usingTask)){
				waitingTime = operations.computeSequence(waitingTime, usage.getWaitingTimeOneLess());
			} else {
				waitingTime = operations.computeSequence(waitingTime, usage.getWaitingTime());
			}
		}
		return waitingTime;
	}



	private ResourceUsageTime computeServiceTime(AbstractResourceUsage abstractUsage, Task task) throws ProbabilityFunctionException {
		ResourceUsageTime time = qnHelper.getUsageTime(abstractUsage);
		
		if (abstractUsage instanceof SequentialResourceUsage) {
			SequentialResourceUsage seqRU = (SequentialResourceUsage) abstractUsage;
			
			ManagedPDF resultTime = getZeroTime();
			
			for (Object subUsageObj : seqRU.getResourceUsages()) {
				AbstractResourceUsage subUsage = (AbstractResourceUsage) subUsageObj;
				computeResponseTime(subUsage, task);
				ResourceUsageTime subTime = qnHelper.getUsageTime(subUsage);
				
				resultTime = operations.computeSequence(resultTime, subTime.getResponseTime());
				
			}
			time.setServiceTime(resultTime);
		}
		
		return time;
	}




	private QNMResultModel initialize() {
		QNMResultModel resultModel = resultFactory.createQNMResultModel();
		
		// add TaskResourceUsages
		for (Object objCR : qnModel.getTasks()) {
			Task task = (Task) objCR;
			
			for (Object objSR : qnModel.getResources()) {
				Resource resource = (Resource) objSR;
				
				TaskResourceUsage usage = resultFactory.createTaskResourceUsage();
				usage.setTask(task);
				usage.setResource(resource);
				usage.setWaitingTime(getZeroTime());
				usage.setWaitingTimeOneLess(getZeroTime());
				usage.setQueueLength(getZeroQueueLength());
				usage.setQueueLengthOneLess(getZeroQueueLength());
				usage.setTaskServiceTime(getZeroTime());
				
				resultModel.getTaskResourceUsages().add(usage);
				
			}
		}
		
		
		// add ResourceUsageTimes
		for (Object objTask : qnModel.getTasks()) {
			Task task = (Task) objTask;
			for (AbstractResourceUsage resourceUsage : qnHelper.getAllResourceUsages(task)) {
				ResourceUsageTime usageTime = resultFactory.createResourceUsageTime();
				usageTime.setResourceUsage(resourceUsage);
				if (resourceUsage instanceof ResourceUsage) {
					ResourceUsage ru = (ResourceUsage) resourceUsage;
					usageTime.setResponseTime(new ManagedPDF(ru.getUsageTime()));
					usageTime.setServiceTime(new ManagedPDF(ru.getUsageTime()));
				} else {
					usageTime.setResponseTime(getZeroTime());
					usageTime.setServiceTime(getZeroTime());
				}
				resultModel.getResourceUsageTimes().add(usageTime);
			}
		}
		
		
		// add ServiceTimeBreakDowns
		for (Object objDR : resultModel.getResourceUsageTimes()){
			ResourceUsageTime usageTime = (ResourceUsageTime) objDR;
			for (Resource resource: qnHelper.getUsedResources( usageTime.getResourceUsage()) ){
				ServiceTimeBreakDown stBreakDown = resultFactory.createServiceTimeBreakDown();
				stBreakDown.setUsedResource(resource);
				stBreakDown.setUsageTime(0);
				stBreakDown.setUsageProbability(0);
				usageTime.getServiceTimeBreakDowns().add(stBreakDown);
			}
		}
		
		return resultModel;		
	}





	protected ManagedPDF sum(List<ManagedPDF> pdfList) {
		try {
			IProbabilityDensityFunction resultPDF = pfFactory.createDiracImpulse(numSamplingPoints, distance, timeUnit).getFourierTransform();
			for (ManagedPDF pdf : pdfList) {
				resultPDF = resultPDF.mult(pdf.getPdfFrequencyDomain());
			}
			return new ManagedPDF(resultPDF);
		} catch (ProbabilityFunctionException e) {
			e.printStackTrace();
			return null;
		}
	}


	private ManagedPMF getZeroQueueLength() {
		List<ISample> samples = new ArrayList<ISample>();
		IProbabilityMassFunction pmf = pfFactory.createProbabilityMassFunction(samples, queueLengthUnit, true);
		return new ManagedPMF(pmf);
	}


	private ManagedPDF getZeroTime() {
		IProbabilityDensityFunction pdf = pfFactory.createDiracImpulse(numSamplingPoints, distance, timeUnit);
		return new ManagedPDF(pdf);
	}
	
	private ManagedPDF getZeroFunction() {
		IProbabilityDensityFunction pdf = pfFactory.createZeroFunction(numSamplingPoints, distance, timeUnit);
		return new ManagedPDF(pdf);
	}
}
