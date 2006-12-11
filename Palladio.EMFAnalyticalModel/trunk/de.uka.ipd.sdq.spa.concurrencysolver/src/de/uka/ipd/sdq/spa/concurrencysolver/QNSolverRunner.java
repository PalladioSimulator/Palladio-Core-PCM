package de.uka.ipd.sdq.spa.concurrencysolver;

import java.util.Iterator;

import de.uka.ipd.sdq.probfunction.math.IProbabilityFunctionFactory;
import de.uka.ipd.sdq.probfunction.math.IUnit;
import de.uka.ipd.sdq.probfunction.math.ManagedPDF;
import de.uka.ipd.sdq.probfunction.math.PDFConfiguration;
import de.uka.ipd.sdq.probfunction.math.exception.ProbabilityFunctionException;
import de.uka.ipd.sdq.qnm.QNModel;
import de.uka.ipd.sdq.qnm.Task;
import de.uka.ipd.sdq.qnm.resultmodel.QNMResultModel;
import de.uka.ipd.sdq.qnm.resultmodel.TaskResourceUsage;
import de.uka.ipd.sdq.qnm.resultmodel.TimeConsumption;
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
	
	private static int numSamplingPoints = 256;

	private static double distance = 1.0;

	private static IUnit timeUnit = IProbabilityFunctionFactory.eINSTANCE.createUnit("ms");
	
	private static String exampleDir = "/home/jens/Diss/runtime-EclipseApplication(1)/SPA-Instance/";


	/**
	 * @param args
	 */
	public static void main(String[] args) {
		PDFConfiguration.setCurrentConfiguration(numSamplingPoints, distance, timeUnit);

//		String file = "Test1 - 2 _threads_1_CPU_Fixed.qnm";
//		String file = "Test1 - 2 _threads_1_CPU_Variable.qnm";
//		String file = "Test2 - 2 _threads_1_CPU_1_HD_Fixed.qnm";
//		String file = "Test2 - 2 _threads_1_CPU_1_HD_Variable.qnm";
//		String file = "Test3 - 10 _threads_1_CPU_1_HD_Fixed.qnm";
//		String file = "Test3 - 10 _threads_1_CPU_1_HD_Variable.qnm";
//		String file = "Test4 - 2 _threads_1_CPU_1_HD_1_NW_Fixed.qnm";
//		String file = "Test4 - 2 _threads_1_CPU_1_HD_1_NW_Variable.qnm";
//		String file = "Test5 - 10 _threads_1_CPU_1_HD_1_NW_Fixed.qnm";
		String file = "Test5 - 10 _threads_1_CPU_1_HD_1_NW_Variable.qnm";
//		String file = "Test6 - 10 _threads_2_CPU_1_HD_2_NW_Fixed.qnm";
//		String file = "Test6 - 10 _threads_2_CPU_1_HD_2_NW_Variable.qnm";
		QNModel qnModel = loadQNModel(exampleDir + file);
		
		//testSolver(qnModel);
		
		showInputs(qnModel);

	}

	/**
	 * 
	 */
	private static void testSolver(QNModel qnModel) {
		try {
			QNSolver solver = new QNSolver(qnModel);
			solver.solve();
			
			System.out.println("done.");
			
			showResults( solver.getResultModel() );
			
//			QNModelEMFTools.saveToXMI(solver.getResultModel(),"Test2.resultmodel");

		} catch (Exception e) {
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
		sru = (SequentialResourceUsage) sru.getResourceUsages().get(0);
		TimeConsumption usageTime = qnHelper.getTimeConsumptionFor(sru);
		Resource resource = usageTime.getResourceUsage().getResource();
		System.out.println(resource.getName());
		System.out.println(task.getName());
		TaskResourceUsage tru = qnHelper.getTaskResourceUsage(task, usageTime.getResourceUsage().getResource());
	
		try {
			JFVisualisation vis = new JFVisualisation(distance);
			vis.addSamplePDF(usageTime.getResponseTime(),"Execution Time");
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
				 ResourceUsage ruNet = (ResourceUsage) sru.getResourceUsages().get(2);
//				 ResourceUsage ruDelay = (ResourceUsage) sru.getResourceUsages().get(1);
				 
				 
				JFVisualisation vis = new JFVisualisation(distance);
//				vis.addSamplePDF(new ManagedPDF(ruCPU.getUsageTime(),true), "CPU");
				vis.addSamplePDF(new ManagedPDF(ruDisk.getUsageTime(),true), "Disk");
//				vis.addSamplePDF(new ManagedPDF(ruNet.getUsageTime(),true), "Network");
//				vis.addSamplePDF(new ManagedPDF(ruDelay.getUsageTime(),true), "DelayResource");
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
