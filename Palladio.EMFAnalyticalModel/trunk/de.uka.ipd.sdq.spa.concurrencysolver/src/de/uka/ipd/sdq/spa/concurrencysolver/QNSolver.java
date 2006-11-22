package de.uka.ipd.sdq.spa.concurrencysolver;

import java.util.ArrayList;
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
import de.uka.ipd.sdq.qnm.resultmodel.ResourceResult;
import de.uka.ipd.sdq.qnm.resultmodel.ResourceUsageTime;
import de.uka.ipd.sdq.qnm.resultmodel.ResultModelFactory;
import de.uka.ipd.sdq.qnm.resultmodel.TaskResourceUsage;
import de.uka.ipd.sdq.qnm.resultmodel.TaskResult;
import de.uka.ipd.sdq.spa.SPAModel;
import de.uka.ipd.sdq.spa.concurrencysolver.qnm.QNDirector;
import de.uka.ipd.sdq.spa.concurrencysolver.qnm.builder.qnm.ResourceModelBuilderImpl;
import de.uka.ipd.sdq.spa.concurrencysolver.qnm.helper.QNHelper;
import de.uka.ipd.sdq.spa.concurrencysolver.qnm.helper.QNResultModelHelper;
import de.uka.ipd.sdq.spa.resourcemodel.Resource;
import de.uka.ipd.sdq.spa.resourcemodel.ResourceUsage;
import de.uka.ipd.sdq.spa.util.EMFTools;

@SuppressWarnings("unchecked")
public class QNSolver {
	
	private static ResultModelFactory resultFactory = ResultModelFactory.eINSTANCE;
	private static IProbabilityFunctionFactory pfFactory = IProbabilityFunctionFactory.eINSTANCE;
	
	private static int numSamplingPoints = 256;
	private static double distance = 10.0;
	private static IUnit unit = pfFactory.createUnit("ms");
	
	private static final IUnit QUEUE_LENGTH_UNIT = pfFactory.createUnit("queue length");
	private static final int NUM_SAMPLING_POINTS = 256;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		QNModel qnModel = getQNModel("Concurrency.spa");
		QNMResultModel qnResult = initialize(qnModel);
		
		solve(qnResult);
		System.out.println("done.");
	}
	
	

	private static QNMResultModel initialize(QNModel qnModel) {
		QNMResultModel resultModel = resultFactory.createQNMResultModel();
		
		// add TaskResourceUsages
		for (Object objCR : qnModel.getTasks()) {
			Task cr = (Task) objCR;
			
			for (Object objSR : qnModel.getResources()) {
				Resource sr = (Resource) objSR;
				
				TaskResourceUsage usage = resultFactory.createTaskResourceUsage();
				usage.setTaskResult(cr);
				usage.setResourceResult(sr);
				usage.setWaitingTime(getZeroWaitingTime());
				usage.setWaitingTimeOneLess(getZeroWaitingTime());
				usage.setQueueLength(getZeroQueueLength());
				usage.setQueueLengthOneLess(getZeroQueueLength());
				usage.setTaskServiceTime(getZeroWaitingTime());
				
				resultModel.getTaskResourceUsages().add(usage);
				
			}
		}
		
		
		// add ResourceUsageTimes
		for (Object objCR : qnModel.getTasks()) {
			Task cr = (Task) objCR;
			for (Object dObj : cr.getAllDemands()) {
				ResourceUsage d = (ResourceUsage) dObj;
				ResourceUsageTime dr = resultFactory.createResourceUsageTime();
				dr.setResourceUsage(d);
				if (d instanceof ResourceUsage) {
					ResourceUsage dd = (ResourceUsage) d;
					dr.setResponseTime(new ManagedPDF(dd.getUsageTime()));
					dr.setServiceTime(new ManagedPDF(dd.getUsageTime()));
				} else {
					dr.setResponseTime(getZeroWaitingTime());
					dr.setServiceTime(getZeroWaitingTime());
				}
				resultModel.getResourceUsageTimes().add(dr);
			}
		}
		
		QNResultModelHelper qnHelper = new QNResultModelHelper(resultModel);
		
		// add DemandResourceUsages
		// TODO check this...
		for (Object objDR : resultModel.getResourceUsageTimes()){
			ResourceUsageTime dr = (ResourceUsageTime) objDR;
			for (Resource s: QNHelper.getUsedResources( dr.getResourceUsage())){
				ResourceResult sr = qnHelper.getResultForResource(s);
				ResourceUsageTime dsu = resultFactory.createResourceUsageTime();
				dsu.setResourceUsage(dr);
				dsu.setResource(sr);
				dsu.setMeanUsageTime(0);
				dsu.setUsageProbability(0);
				resultModel.getDemandResourceUsages().add(dsu);
			}
		}
		
		return resultModel;		
	}

	
	
	private static void solve(QNMResultModel qnModel) {
		
		do{
			computeResponseTimes(qnModel);
			computeAverageServiceTimes(qnModel);
			computeUsageTimes(qnModel);
			computeUsageProbabilities(qnModel);
			computeQueueLengths(qnModel);
			computeWaitingTimes(qnModel);
		} while (!fixPointReached(qnModel));
	}



	private static boolean fixPointReached(QNMResultModel qnModel) {
		// TODO Auto-generated method stub
		return false;
	}



	private static void computeWaitingTimes(QNMResultModel qnModel) {
		// TODO Auto-generated method stub
		
	}



	private static void computeQueueLengths(QNMResultModel qnModel) {
		// TODO Auto-generated method stub
		
	}



	private static void computeUsageProbabilities(QNMResultModel qnModel) {
		// TODO Auto-generated method stub
		
	}



	private static void computeUsageTimes(QNMResultModel qnModel) {
		// TODO Auto-generated method stub
		
	}



	private static void computeAverageServiceTimes(QNMResultModel qnModel) {
		// TODO Auto-generated method stub
		
	}



	private static void computeResponseTimes(QNMResultModel qnModel) {
		
		for (Object objCR : qnModel.getQnmodel().getTasks()) {
			Task cr = (Task) objCR;
		}
		
	}
	

	public static ManagedPDF sum(List<ManagedPDF> pdfList) {
		try {
			IProbabilityDensityFunction resultPDF = pfFactory.createDiracImpulse(numSamplingPoints, distance, unit).getFourierTransform();
			for (ManagedPDF pdf : pdfList) {
				resultPDF = resultPDF.mult(pdf.getPdfFrequencyDomain());
			}
			return new ManagedPDF(resultPDF);
		} catch (ProbabilityFunctionException e) {
			e.printStackTrace();
			return null;
		}
	}



	private static ManagedPMF getZeroQueueLength() {
		List<ISample> samples = new ArrayList<ISample>();
		IProbabilityMassFunction pmf = pfFactory.createProbabilityMassFunction(samples, QUEUE_LENGTH_UNIT, true);
		return new ManagedPMF(pmf);
	}


	private static ManagedPDF getZeroWaitingTime() {
		IProbabilityDensityFunction pdf = pfFactory.createDiracImpulse(numSamplingPoints, distance, unit);
		return new ManagedPDF(pdf);
	}


	public static QNModel getQNModel(String fileName){
		SPAModel spaModel = (SPAModel) EMFTools.loadFromXMI(fileName);
		ResourceModelBuilderImpl qnBuilder = new ResourceModelBuilderImpl();
		QNDirector qnDirector = new QNDirector(NUM_SAMPLING_POINTS); 
		qnDirector.buildFrom(spaModel, qnBuilder);
		return qnBuilder.getQNModel();
	}
}
