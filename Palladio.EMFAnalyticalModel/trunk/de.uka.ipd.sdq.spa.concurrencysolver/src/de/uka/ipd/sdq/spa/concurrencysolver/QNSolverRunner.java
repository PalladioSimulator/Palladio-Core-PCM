package de.uka.ipd.sdq.spa.concurrencysolver;

import de.uka.ipd.sdq.probfunction.math.exception.ProbabilityFunctionException;
import de.uka.ipd.sdq.qnm.QNModel;
import de.uka.ipd.sdq.spa.SPAModel;
import de.uka.ipd.sdq.spa.concurrencysolver.qnm.QNDirector;
import de.uka.ipd.sdq.spa.concurrencysolver.qnm.builder.qnm.ResourceModelBuilderImpl;
import de.uka.ipd.sdq.spa.util.EMFTools;

public class QNSolverRunner {
	
	private static final int NUM_SAMPLING_POINTS = 256;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			QNModel qnModel = getQNModel("Concurrency.spa");
			
			QNSolver solver = new QNSolver(qnModel);
			solver.solve();
			
			System.out.println("done.");
		} catch (ProbabilityFunctionException e) {
			e.printStackTrace();
		}
	}
	
	public static QNModel getQNModel(String fileName){
		SPAModel spaModel = (SPAModel) EMFTools.loadFromXMI(fileName);
		ResourceModelBuilderImpl qnBuilder = new ResourceModelBuilderImpl();
		QNDirector qnDirector = new QNDirector(NUM_SAMPLING_POINTS); 
		qnDirector.buildFrom(spaModel, qnBuilder);
		return qnBuilder.getQNModel();
	}
	
}
