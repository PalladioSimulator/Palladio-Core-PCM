package de.uka.ipd.sdq.spa.concurrencysolver;

import java.util.Iterator;

import de.uka.ipd.sdq.probfunction.math.IProbabilityFunctionFactory;
import de.uka.ipd.sdq.probfunction.math.IUnit;
import de.uka.ipd.sdq.probfunction.math.ManagedPDF;
import de.uka.ipd.sdq.probfunction.math.PDFConfiguration;
import de.uka.ipd.sdq.probfunction.math.exception.ConfigurationNotSetException;
import de.uka.ipd.sdq.probfunction.math.exception.ProbabilityFunctionException;
import de.uka.ipd.sdq.qnm.QNModel;
import de.uka.ipd.sdq.qnm.Task;
import de.uka.ipd.sdq.qnm.resultmodel.QNMResultModel;
import de.uka.ipd.sdq.qnm.resultmodel.TimeConsumption;
import de.uka.ipd.sdq.qnm.resultmodel.TaskResourceUsage;
import de.uka.ipd.sdq.qnm.util.QNModelEMFTools;
import de.uka.ipd.sdq.spa.ProcessBehaviour;
import de.uka.ipd.sdq.spa.SPAModel;
import de.uka.ipd.sdq.spa.concurrencysolver.qnm.QNDirector;
import de.uka.ipd.sdq.spa.concurrencysolver.qnm.builder.qnm.ResourceModelBuilderImpl;
import de.uka.ipd.sdq.spa.concurrencysolver.qnm.helper.QNHelper;
import de.uka.ipd.sdq.spa.concurrencysolver.visualization.JFVisualisation;
import de.uka.ipd.sdq.spa.resourcemodel.Resource;
import de.uka.ipd.sdq.spa.resourcemodel.ResourceUsage;
import de.uka.ipd.sdq.spa.resourcemodel.SequentialResourceUsage;
import de.uka.ipd.sdq.spa.util.EMFTools;

public class QNSolverRunner {
	
	private static int numSamplingPoints = 32;

	private static double distance = 1.0;

	private static IUnit timeUnit = IProbabilityFunctionFactory.eINSTANCE.createUnit("ms");

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		testSolver();
//		testInput();
	}

	private static void testInput() {
		PDFConfiguration.setCurrentConfiguration(numSamplingPoints, distance, timeUnit);
		QNModel qnModel = loadQNModel("Test2.qnm");
		showInputs(qnModel);
	}

	/**
	 * 
	 */
	private static void testSolver() {
		try {
			PDFConfiguration.setCurrentConfiguration(numSamplingPoints, distance, timeUnit);
			
			// QNModel qnModel = getQNModelFromSPA("Concurrency.spa");
			QNModel qnModel = loadQNModel("Test2.qnm");
			
			QNSolver solver = new QNSolver(qnModel);
			solver.solve();
			
			System.out.println("done.");
			
			showResults( solver.getResultModel() );
			
			QNModelEMFTools.saveToXMI(solver.getResultModel(),"Test2.resultmodel");

		} catch (ProbabilityFunctionException e) {
			e.printStackTrace();
		} catch (ConfigurationNotSetException e){
			e.printStackTrace();
		}
	}
	
	private static QNModel loadQNModel(String fileName) {
		return (QNModel) QNModelEMFTools.loadFromXMI(fileName);
	}

	private static void showResults(QNMResultModel resultModel) {
		QNHelper qnHelper = new QNHelper(resultModel);
		
		Task task = (Task) resultModel.getQnmodel().getTasks().get(0);
		SequentialResourceUsage sru = (SequentialResourceUsage) task.getResourceUsage();
//		sru = (SequentialResourceUsage)sru.getResourceUsages().get(0);
		TimeConsumption usageTime = qnHelper.getTimeConsumptionFor(sru);
		Resource resource = usageTime.getResourceUsage().getResource();
		System.out.println(resource.getName());
		System.out.println(task.getName());
		TaskResourceUsage tru = qnHelper.getTaskResourceUsage(task, usageTime.getResourceUsage().getResource());
	
		try {
			JFVisualisation vis = new JFVisualisation(distance);
			vis.addSamplePDF(usageTime.getResponseTime(),"Response Time");
			vis.addSamplePDF(usageTime.getServiceTime(), "ServiceTime");
//			vis.addPMF(tru.getQueueLengthOneLess(), "Queue Length");
			vis.visualizeOverlay();
		} catch (ProbabilityFunctionException e) {
			e.printStackTrace();
		}
	}
		
		private static void showInputs(QNModel qnModel) {
			Task task = (Task) qnModel.getTasks().get(0);
			try {
				 SequentialResourceUsage sru = (SequentialResourceUsage) task.getResourceUsage();
				 sru = (SequentialResourceUsage) sru.getResourceUsages().get(0);
				 ResourceUsage ruCPU = (ResourceUsage) sru.getResourceUsages().get(0);
				 ResourceUsage ruDisk = (ResourceUsage) sru.getResourceUsages().get(1);
				 
				 
				JFVisualisation vis = new JFVisualisation(distance);
				vis.addSamplePDF(new ManagedPDF(ruCPU.getUsageTime(),true), "RU CPU");
				vis.addSamplePDF(new ManagedPDF(ruDisk.getUsageTime(),true), "RU Disk");
				vis.visualizeOverlay();
			} catch (ProbabilityFunctionException e) {
				e.printStackTrace();
			}
	}

	public static QNModel getQNModelFromSPA(String fileName){
		SPAModel spaModel = (SPAModel) EMFTools.loadFromXMI(fileName);
		int totalNumOfTasks = 0;
		for (Iterator iter = spaModel.getProcesses().iterator(); iter.hasNext();) {
			ProcessBehaviour process = (ProcessBehaviour) iter.next();
			totalNumOfTasks += process.getNumReplicas();
		}
		ResourceModelBuilderImpl qnBuilder = new ResourceModelBuilderImpl(totalNumOfTasks);
		QNDirector qnDirector = new QNDirector(); 
		qnDirector.buildFrom(spaModel, qnBuilder);
		return qnBuilder.getQNModel();
	}
	
}
