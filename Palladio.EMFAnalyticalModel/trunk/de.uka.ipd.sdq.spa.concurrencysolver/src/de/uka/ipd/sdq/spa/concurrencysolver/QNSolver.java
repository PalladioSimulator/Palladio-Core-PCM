package de.uka.ipd.sdq.spa.concurrencysolver;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;

import de.uka.ipd.sdq.probfunction.math.IProbabilityDensityFunction;
import de.uka.ipd.sdq.probfunction.math.IProbabilityFunctionFactory;
import de.uka.ipd.sdq.probfunction.math.IProbabilityMassFunction;
import de.uka.ipd.sdq.probfunction.math.ISample;
import de.uka.ipd.sdq.probfunction.math.IUnit;
import de.uka.ipd.sdq.probfunction.math.ManagedPDF;
import de.uka.ipd.sdq.probfunction.math.ManagedPMF;
import de.uka.ipd.sdq.probfunction.math.exception.ConfigurationNotSetException;
import de.uka.ipd.sdq.probfunction.math.exception.ProbabilityFunctionException;
import de.uka.ipd.sdq.probfunction.math.util.MathTools;
import de.uka.ipd.sdq.qnm.QNModel;
import de.uka.ipd.sdq.qnm.Task;
import de.uka.ipd.sdq.qnm.resultmodel.QNMResultModel;
import de.uka.ipd.sdq.qnm.resultmodel.TimeConsumption;
import de.uka.ipd.sdq.qnm.resultmodel.ResultModelFactory;
import de.uka.ipd.sdq.qnm.resultmodel.ServiceTimeBreakDown;
import de.uka.ipd.sdq.qnm.resultmodel.TaskResourceUsage;
import de.uka.ipd.sdq.spa.basicsolver.operations.PDFPerformanceOps;
import de.uka.ipd.sdq.spa.concurrencysolver.exceptions.InvalidSystemStateException;
import de.uka.ipd.sdq.spa.concurrencysolver.qnm.helper.QNHelper;
import de.uka.ipd.sdq.spa.resourcemodel.AbstractResourceUsage;
import de.uka.ipd.sdq.spa.resourcemodel.CompositeResourceUsage;
import de.uka.ipd.sdq.spa.resourcemodel.ContentionResource;
import de.uka.ipd.sdq.spa.resourcemodel.DelayResource;
import de.uka.ipd.sdq.spa.resourcemodel.Resource;
import de.uka.ipd.sdq.spa.resourcemodel.ResourceUsage;
import de.uka.ipd.sdq.spa.resourcemodel.SequentialResourceUsage;

@SuppressWarnings("unchecked")
public class QNSolver {

	private static ResultModelFactory resultFactory = ResultModelFactory.eINSTANCE;

	private static IProbabilityFunctionFactory pfFactory = IProbabilityFunctionFactory.eINSTANCE;

	private IUnit queueLengthUnit = pfFactory.createUnit("queue length");

	private double epsilon = 0.001;

	private QNMResultModel resultModel;

	private QNModel qnModel;

	private QNHelper qnHelper;

	private PDFPerformanceOps performanceOps;

	public QNSolver(QNModel qnModel) {
		super();
		this.qnModel = qnModel;
		this.performanceOps = new PDFPerformanceOps();
		resultModel = resultFactory.createQNMResultModel();
		resultModel.setQnmodel(qnModel);
		qnHelper = new QNHelper(resultModel);

		try {
			initializeResultModel();
		} catch (ConfigurationNotSetException e) {
			e.printStackTrace();
			System.exit(-1);
		}
	}

	public QNModel getQnModel() {
		return qnModel;
	}

	public QNMResultModel getResultModel() {
		return resultModel;
	}

	public void solve() throws ProbabilityFunctionException,
			ConfigurationNotSetException, InvalidSystemStateException {
		do {
			computeResponseTimes();
			computeAverageServiceTimes();
			computeServiceTimeBreakDown();
			computeContention();
		} while (!fixPointReached());
	}
	
	
	

	private boolean fixPointReached() {
		for (Iterator iter = qnModel.getTasks().iterator(); iter.hasNext();) {
			Task task = (Task) iter.next();
			TimeConsumption usageTime = qnHelper.getTimeConsumptionFor(task
					.getResourceUsage());
			for (Iterator bdIter = usageTime.getServiceTimeBreakDowns()
					.iterator(); bdIter.hasNext();) {
				ServiceTimeBreakDown breakdown = (ServiceTimeBreakDown) bdIter
						.next();
				if (Math.abs(breakdown.getUsageProbability()
						- breakdown.getLastUsageProbability()) > epsilon) {
					return false;
				}
			}
		}
		return true;
	}

	private void computeContention() throws ProbabilityFunctionException,
			ConfigurationNotSetException {
		for (Iterator iter = resultModel.getTaskResourceUsages().iterator(); iter
				.hasNext();) {
			TaskResourceUsage tru = (TaskResourceUsage) iter.next();

			if (tru.getResource() instanceof ContentionResource) {
				ServiceTimeBreakDown breakdown = qnHelper
						.getServiceTimeBreakDown(tru.getTask()
								.getResourceUsage(), tru.getResource());

				double probability = breakdown.getUsageProbability();
				int numOfTasks = tru.getTask().getNumReplicas();
				ManagedPMF queueLength = getQueueLength(probability, numOfTasks);
				ManagedPMF queueLengthOneLess = getQueueLength(probability,
						numOfTasks - 1);

				int numOfResources = -1;
				if (tru.getResource() instanceof ContentionResource) {

					numOfResources = ((ContentionResource) tru.getResource())
							.getNumReplicas();
				}
				ManagedPMF waitQueue = getQueueForReplicas(queueLength,
						numOfResources);
				ManagedPMF waitQueueOneLess = getQueueForReplicas(
						queueLengthOneLess, numOfResources);

				ManagedPDF waitingTime = getWaitingTime(waitQueue, tru
						.getTaskServiceTime());
				ManagedPDF waitingTimeOneLess = getWaitingTime(
						waitQueueOneLess, tru.getTaskServiceTime());

				tru.setQueueLength(queueLength);
				tru.setQueueLengthOneLess(queueLengthOneLess);
				tru.setWaitingTime(waitingTime);
				tru.setWaitingTimeOneLess(waitingTimeOneLess);
			}
		}
	}

	private ManagedPMF getQueueForReplicas(ManagedPMF queueLength,
			int numReplicas) {
		if (numReplicas <= 0) {
			return getZeroQueueLength();
		} else if (numReplicas == 1) {
			return queueLength;
		} else {
			List<ISample> samples = new ArrayList<ISample>();
			List<ISample> qSamples = queueLength.getPmfTimeDomain()
					.getSamples();

			int k = 0;
			Iterator<ISample> qsIterator = qSamples.iterator();
			while (qsIterator.hasNext()) {
				double probability = 0;
				for (int i = 0; i < numReplicas; i++) {
					if (qsIterator.hasNext()) {
						ISample s = qsIterator.next();
						probability += s.getProbability();
					}
				}
				ISample newSample = pfFactory.createSample(k, probability);
				samples.add(newSample);
				k++;
			}

			return new ManagedPMF(pfFactory.createProbabilityMassFunction(
					samples, queueLengthUnit, true));
		}
	}

	private ManagedPDF getWaitingTime(ManagedPMF queueLength,
			ManagedPDF serviceTime) throws ProbabilityFunctionException,
			ConfigurationNotSetException {
		return performanceOps.computeIteration(serviceTime, queueLength
				.getPmfTimeDomain());
	}

	private ManagedPMF getQueueLength(double prob, int numberOfTasks) {
		List<ISample> samples = new ArrayList<ISample>();
		int n = numberOfTasks;
		BigDecimal p = new BigDecimal(prob), q = new BigDecimal(1 - prob);

		for (int k = 0; k <= n; k++) {
			double qProb = MathTools.over(n, k).multiply(
					p.pow(k).multiply(q.pow(n - k))).doubleValue();
			ISample sample = pfFactory.createSample(k, qProb);
			samples.add(sample);
		}
		return new ManagedPMF(pfFactory.createProbabilityMassFunction(samples,
				queueLengthUnit, true));
	}

	/**
	 * Computes the service time breakdown for each task. The service time
	 * breakdown contains information on the probabilities and times different
	 * resources are used.
	 * 
	 * @throws ProbabilityFunctionException
	 * @throws InvalidSystemStateException 
	 */
	private void computeServiceTimeBreakDown()
			throws ProbabilityFunctionException, InvalidSystemStateException {
		for (Iterator iter = qnModel.getTasks().iterator(); iter.hasNext();) {
			Task task = (Task) iter.next();
			computeServiceTimeBreakDown(task.getResourceUsage());
		}
	}

	/**
	 * 
	 * @param abstractUsage
	 * @return
	 * @throws ProbabilityFunctionException
	 * @throws InvalidSystemStateException 
	 */
	private Hashtable<Resource, ServiceTimeBreakDown> computeServiceTimeBreakDown(
			AbstractResourceUsage abstractUsage)
			throws ProbabilityFunctionException, InvalidSystemStateException {

		TimeConsumption time = qnHelper.getTimeConsumptionFor(abstractUsage);
		Hashtable<Resource, ServiceTimeBreakDown> breakdownTable = qnHelper
				.createInitialServiceTimeBreakDownTable(abstractUsage);
		initialiseValues(breakdownTable);

		ServiceTimeBreakDown breakdown = qnHelper.getServiceTimeBreakDown(time,
				abstractUsage.getResource());

		// TODO responsetime or servicetime?
		double totalTime = time.getResponseTime().getPdfTimeDomain()
				.getArithmeticMeanValue();

		breakdown.setUsageTime(totalTime);
		breakdown.setUsageProbability(1);

		if (abstractUsage instanceof CompositeResourceUsage) {
			handleCompositeResourceUsage(time, breakdownTable,
					(CompositeResourceUsage) abstractUsage, totalTime);
		}

		return breakdownTable;

	}

	/**
	 * @param time
	 * @param breakdownTable
	 * @param compUsage
	 * @throws ProbabilityFunctionException
	 * @throws InvalidSystemStateException 
	 */
	private void handleCompositeResourceUsage(TimeConsumption time,
			Hashtable<Resource, ServiceTimeBreakDown> breakdownTable,
			CompositeResourceUsage compUsage, double totalTime)
			throws ProbabilityFunctionException, InvalidSystemStateException {
		for (Iterator iter = compUsage.getResourceUsages().iterator(); iter
				.hasNext();) {
			AbstractResourceUsage innerUsage = (AbstractResourceUsage) iter
					.next();
			Hashtable<Resource, ServiceTimeBreakDown> innerTable = computeServiceTimeBreakDown(innerUsage);
			for (Resource resource : innerTable.keySet()) {
				ServiceTimeBreakDown resultBreakdown = breakdownTable
						.get(resource);
				// TODO differentiate computations for alternative, parallel,
				// iterative, etc.
				double usageTime = resultBreakdown.getUsageTime()
						+ innerTable.get(resource).getUsageTime();
				breakdownTable.get(resource).setUsageTime(usageTime);
			}
		}

		if (MathTools.equalsDouble(totalTime, 0.0)) {
			for (ServiceTimeBreakDown bd : breakdownTable.values()) {
				// TODO What happens if all usage times are 0 ?
				bd.setUsageProbability(0);
			}
		} else {
			for (ServiceTimeBreakDown bd : breakdownTable.values()) {
				double usageTime = bd.getUsageTime();
				bd.setUsageProbability(usageTime / totalTime);
				if (usageTime > totalTime)
					throw new InvalidSystemStateException();
			}
		}
	}


	private void initialiseValues(
			Hashtable<Resource, ServiceTimeBreakDown> breakdownTable) {
		for (ServiceTimeBreakDown breakdown : breakdownTable.values()) {
			breakdown.setLastUsageProbability(breakdown.getUsageProbability());
			breakdown.setLastUsageTime(breakdown.getUsageTime());
			breakdown.setUsageProbability(0);
			breakdown.setUsageTime(0);
		}
	}

	private void computeAverageServiceTimes()
			throws ProbabilityFunctionException, ConfigurationNotSetException {
		for (Iterator iter = resultModel.getTaskResourceUsages().iterator(); iter
				.hasNext();) {
			TaskResourceUsage tru = (TaskResourceUsage) iter.next();
			ManagedPDF taskServiceTime = getAverageServiceTimeForTask(tru.getTask(), tru
					.getResource());
			tru.setTaskServiceTime(taskServiceTime);
		}
	}

	private ManagedPDF getAverageServiceTimeForTask(Task task, Resource resource)
			throws ProbabilityFunctionException, ConfigurationNotSetException {
		List<AbstractResourceUsage> usageList = qnHelper.getUsagesOf(task,
				resource);
		if (usageList.size() > 0) {
			IProbabilityDensityFunction resultPDF = ManagedPDF
					.createZeroFunction().getPdfFrequencyDomain();
			double prob = 1.0 / (double) usageList.size();
			for (AbstractResourceUsage usage : usageList) {
				TimeConsumption time = qnHelper.getTimeConsumptionFor(usage);
				IProbabilityDensityFunction pdf = time.getServiceTime()
						.getPdfFrequencyDomain();
				resultPDF = resultPDF.add(pdf.scale(prob));
			}
			return new ManagedPDF(resultPDF, true);
		} else {
			return ManagedPDF.createDiracImpulse();
		}
	}

	private void computeResponseTimes() throws ProbabilityFunctionException,
			ConfigurationNotSetException {
		for (Object taskObj : qnModel.getTasks()) {
			Task task = (Task) taskObj;
			computeResponseTime(task.getResourceUsage(), task);
		}
	}

	private void computeResponseTime(AbstractResourceUsage abstractUsage,
			Task task) throws ProbabilityFunctionException,
			ConfigurationNotSetException {
		// note: the possible number of parrallel tasks using a resource depends 
		// on the counter of a surrounding semaphore, no more tasks are let in!!!

		TimeConsumption time = computeServiceTime(abstractUsage, task);

		if (abstractUsage.getResource() instanceof DelayResource) {
			time.setResponseTime(time.getServiceTime()); // no queueing for
			// delayresources
		} else {
			ManagedPDF waitingTime = getWaitingTimeFor(abstractUsage
					.getResource(), task);
			ManagedPDF responseTime = performanceOps.computeSequence(time
					.getServiceTime(), waitingTime);
			time.setResponseTime(responseTime);
		}
	}

	private ManagedPDF getWaitingTimeFor(Resource resource, Task task)
			throws ProbabilityFunctionException, ConfigurationNotSetException {
		List<Task> usingTasks = qnHelper.getUsingTasks(resource);
		ManagedPDF waitingTime = ManagedPDF.createDiracImpulse();
		for (Task usingTask : usingTasks) {
			TaskResourceUsage usage = qnHelper.getTaskResourceUsage(usingTask,
					resource);
			if (task.equals(usingTask)) {
				waitingTime = performanceOps.computeSequence(waitingTime, usage
						.getWaitingTimeOneLess());
			} else {
				waitingTime = performanceOps.computeSequence(waitingTime, usage
						.getWaitingTime());
			}
		}
		return waitingTime;
	}

	private TimeConsumption computeServiceTime(
			AbstractResourceUsage abstractUsage, Task task)
			throws ProbabilityFunctionException, ConfigurationNotSetException {
		TimeConsumption time = qnHelper.getTimeConsumptionFor(abstractUsage);

		if (abstractUsage instanceof SequentialResourceUsage) {
			SequentialResourceUsage seqRU = (SequentialResourceUsage) abstractUsage;

			ManagedPDF resultTime = ManagedPDF.createDiracImpulse();

			for (Object subUsageObj : seqRU.getResourceUsages()) {
				AbstractResourceUsage subUsage = (AbstractResourceUsage) subUsageObj;
				computeResponseTime(subUsage, task);
				TimeConsumption subTime = qnHelper
						.getTimeConsumptionFor(subUsage);

				resultTime = performanceOps.computeSequence(resultTime, subTime
						.getResponseTime());

			}
			time.setServiceTime(resultTime);
		}

		return time;
	}

	@SuppressWarnings("static-access")
	private void initializeResultModel() throws ConfigurationNotSetException {

		// add TaskResourceUsages
		for (Object objCR : qnModel.getTasks()) {
			Task task = (Task) objCR;

			for (Resource resource : qnHelper.getUsedResources(task
					.getResourceUsage())) {
				TaskResourceUsage usage = resultFactory
						.createTaskResourceUsage();
				usage.setTask(task);
				usage.setResource(resource);
				usage.setWaitingTime(ManagedPDF.createDiracImpulse());
				usage.setWaitingTimeOneLess(ManagedPDF.createDiracImpulse());
				usage.setQueueLength(getZeroQueueLength());
				usage.setQueueLengthOneLess(getZeroQueueLength());
				usage.setTaskServiceTime(ManagedPDF.createDiracImpulse());

				resultModel.getTaskResourceUsages().add(usage);

			}
		}

		// add ResourceUsageTimes
		for (Object objTask : qnModel.getTasks()) {
			Task task = (Task) objTask;
			for (AbstractResourceUsage resourceUsage : QNHelper
					.getAllResourceUsages(task)) {
				TimeConsumption usageTime = resultFactory
						.createResourceUsageTime();
				usageTime.setResourceUsage(resourceUsage);
				if (resourceUsage instanceof ResourceUsage) {
					ResourceUsage ru = (ResourceUsage) resourceUsage;
					usageTime.setResponseTime(new ManagedPDF(ru.getUsageTime(),
							true));
					usageTime.setServiceTime(new ManagedPDF(ru.getUsageTime(),
							true));
				} else {
					usageTime.setResponseTime(ManagedPDF.createDiracImpulse());
					usageTime.setServiceTime(ManagedPDF.createDiracImpulse());
				}
				resultModel.getResourceUsageTimes().add(usageTime);
			}
		}

		// add ServiceTimeBreakDowns
		for (Object objDR : resultModel.getResourceUsageTimes()) {
			TimeConsumption usageTime = (TimeConsumption) objDR;
			for (Resource resource : qnHelper.getUsedResources(usageTime
					.getResourceUsage())) {
				ServiceTimeBreakDown stBreakDown = resultFactory
						.createServiceTimeBreakDown();
				stBreakDown.setUsedResource(resource);
				stBreakDown.setUsageTime(0);
				stBreakDown.setUsageProbability(0);
				stBreakDown.setLastUsageProbability(-1);
				stBreakDown.setLastUsageTime(-1);
				usageTime.getServiceTimeBreakDowns().add(stBreakDown);
			}
		}
	}

	protected ManagedPDF sum(List<ManagedPDF> pdfList)
			throws ConfigurationNotSetException {
		try {
			IProbabilityDensityFunction resultPDF = ManagedPDF
					.createDiracImpulse().getPdfFrequencyDomain();
			for (ManagedPDF pdf : pdfList) {
				resultPDF = resultPDF.mult(pdf.getPdfFrequencyDomain());
			}
			return new ManagedPDF(resultPDF, true);
		} catch (ProbabilityFunctionException e) {
			e.printStackTrace();
			return null;
		}
	}

	private ManagedPMF getZeroQueueLength() {
		List<ISample> samples = new ArrayList<ISample>();
		IProbabilityMassFunction pmf = pfFactory.createProbabilityMassFunction(
				samples, queueLengthUnit, true);
		return new ManagedPMF(pmf);
	}

}
