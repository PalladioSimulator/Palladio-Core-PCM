package de.uka.ipd.sdq.spa.concurrencysolver;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ocl.query.Query;
import org.eclipse.emf.ocl.query.QueryFactory;

import de.uka.ipd.sdq.probfunction.math.IProbabilityDensityFunction;
import de.uka.ipd.sdq.probfunction.math.IProbabilityFunctionFactory;
import de.uka.ipd.sdq.probfunction.math.IProbabilityMassFunction;
import de.uka.ipd.sdq.probfunction.math.ISample;
import de.uka.ipd.sdq.probfunction.math.IUnit;
import de.uka.ipd.sdq.probfunction.math.ManagedPDF;
import de.uka.ipd.sdq.probfunction.math.ManagedPMF;
import de.uka.ipd.sdq.probfunction.math.exception.FunctionNotInTimeDomainException;
import de.uka.ipd.sdq.probfunction.math.exception.FunctionsInDifferenDomainsException;
import de.uka.ipd.sdq.probfunction.math.exception.IncompatibleUnitsException;
import de.uka.ipd.sdq.probfunction.math.exception.ProbabilityFunctionException;
import de.uka.ipd.sdq.probfunction.math.exception.UnknownPDFTypeException;
import de.uka.ipd.sdq.qnm.Customer;
import de.uka.ipd.sdq.qnm.Demand;
import de.uka.ipd.sdq.qnm.DeviceDemand;
import de.uka.ipd.sdq.qnm.QNModel;
import de.uka.ipd.sdq.qnm.SequentialDemand;
import de.uka.ipd.sdq.qnm.Server;
import de.uka.ipd.sdq.qnm.qnResult.CustomerResult;
import de.uka.ipd.sdq.qnm.qnResult.CustomerServerUsage;
import de.uka.ipd.sdq.qnm.qnResult.DemandResult;
import de.uka.ipd.sdq.qnm.qnResult.DemandServerUsage;
import de.uka.ipd.sdq.qnm.qnResult.QNResultFactory;
import de.uka.ipd.sdq.qnm.qnResult.QNResultModel;
import de.uka.ipd.sdq.qnm.qnResult.ServerResult;
import de.uka.ipd.sdq.qnm.qnResult.util.QNResultSwitch;
import de.uka.ipd.sdq.qnm.util.QnmSwitch;
import de.uka.ipd.sdq.spa.SPAModel;
import de.uka.ipd.sdq.spa.concurrencysolver.qnm.QNDirector;
import de.uka.ipd.sdq.spa.concurrencysolver.qnm.builder.qnm.QNBuilder;
import de.uka.ipd.sdq.spa.concurrencysolver.qnm.solver.SolvQnResultFactory;
import de.uka.ipd.sdq.spa.util.EMFTools;

@SuppressWarnings("unchecked")
public class QNSolver {
	
	private static QNResultFactory resultFactory = new SolvQnResultFactory();
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
		QNResultModel qnResult = initialize(qnModel);
		
		solve(qnResult);
		System.out.println("done.");
	}
	
	

	private static QNResultModel initialize(QNModel qnModel) {
		QNResultModel resultModel = resultFactory.createQNResultModel();
		
		// add all customers and servers to the result model
		for (Object objC : qnModel.getCustomers()) {
			Customer c = (Customer) objC;
			CustomerResult cr = resultFactory.createCustomerResult();
			cr.setCustomer(c);
			resultModel.getCustomerResults().add(cr);
		}
			
		for (Object objS : qnModel.getServers()){
			Server s = (Server) objS;
			ServerResult sr = resultFactory.createServerResult();
			sr.setServer(s);
			resultModel.getServerResults().add(sr);
		}
		
		// add CustomerServerUsages
		for (Object objCR : resultModel.getCustomerResults()) {
			CustomerResult cr = (CustomerResult) objCR;
			
			for (Object objSR : resultModel.getServerResults()) {
				ServerResult sr = (ServerResult) objSR;
				
				CustomerServerUsage usage = resultFactory.createCustomerServerUsage();
				usage.setCustomerResult(cr);
				usage.setServerResult(sr);
				usage.setCausedWaitingTime(getZeroWaitingTime());
				usage.setCausedWaitingTimeOneLess(getZeroWaitingTime());
				usage.setQueueLength(getZeroQueueLength());
				usage.setQueueLengthOneLess(getZeroQueueLength());
				usage.setCustomerServiceTime(getZeroWaitingTime());
				
				resultModel.getCustomerServerUsage().add(usage);
				
			}
		}
		
		
		// add DemandResults
		for (Object objCR : resultModel.getCustomerResults()) {
			CustomerResult cr = (CustomerResult) objCR;
			for (Object dObj : cr.getCustomer().getAllDemands()) {
				Demand d = (Demand) dObj;
				DemandResult dr = resultFactory.createDemandResult();
				dr.setDemand(d);
				if (d instanceof DeviceDemand) {
					DeviceDemand dd = (DeviceDemand) d;
					dr.setResponseTime(dd.getServiceTime());
					dr.setServiceTime(dd.getServiceTime());
				} else {
					dr.setResponseTime(getZeroWaitingTime());
					dr.setServiceTime(getZeroWaitingTime());
				}
				resultModel.getDemandResults().add(dr);
			}
		}
		
		// add DemandServerUsages
		for (Object objDR : resultModel.getDemandResults()){
			DemandResult dr = (DemandResult) objDR;
			for (Object objS: dr.getDemand().getUsedResources()){
				Server s = (Server)objS;
				ServerResult sr = resultModel.getResultForServer(s);
				DemandServerUsage dsu = resultFactory.createDemandServerUsage();
				dsu.setDemand(dr);
				dsu.setServer(sr);
				dsu.setMeanUsageTime(0);
				dsu.setUsageProbability(0);
				resultModel.getDemandServerUsages().add(dsu);
			}
		}
		
		return resultModel;		
	}

	
	
	private static void solve(QNResultModel qnModel) {
		
		do{
			computeResponseTimes(qnModel);
			computeAverageServiceTimes(qnModel);
			computeUsageTimes(qnModel);
			computeUsageProbabilities(qnModel);
			computeQueueLengths(qnModel);
			computeWaitingTimes(qnModel);
		} while (!fixPointReached(qnModel));
	}



	private static boolean fixPointReached(QNResultModel qnModel) {
		// TODO Auto-generated method stub
		return false;
	}



	private static void computeWaitingTimes(QNResultModel qnModel) {
		// TODO Auto-generated method stub
		
	}



	private static void computeQueueLengths(QNResultModel qnModel) {
		// TODO Auto-generated method stub
		
	}



	private static void computeUsageProbabilities(QNResultModel qnModel) {
		// TODO Auto-generated method stub
		
	}



	private static void computeUsageTimes(QNResultModel qnModel) {
		// TODO Auto-generated method stub
		
	}



	private static void computeAverageServiceTimes(QNResultModel qnModel) {
		// TODO Auto-generated method stub
		
	}



	private static void computeResponseTimes(QNResultModel qnModel) {
		
		for (Object objCR : qnModel.getCustomerResults()) {
			CustomerResult cr = (CustomerResult) objCR;
			ResponseTimeSwitch rtSwitch
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
		QNBuilder qnBuilder = new QNBuilder();
		QNDirector qnDirector = new QNDirector(NUM_SAMPLING_POINTS); 
		qnDirector.buildFrom(spaModel, qnBuilder);
		return qnBuilder.getQNModel();
	}
}
