//package de.uka.ipd.sdq.spa.concurrencysolver;
//
//import java.util.ArrayList;
//import java.util.Iterator;
//import java.util.List;
//
//import de.uka.ipd.sdq.probfunction.math.IProbabilityFunctionFactory;
//import de.uka.ipd.sdq.probfunction.math.exception.DomainNotNumbersException;
//import de.uka.ipd.sdq.probfunction.math.exception.FunctionNotInTimeDomainException;
//import de.uka.ipd.sdq.probfunction.math.exception.ProbabilityFunctionException;
//import de.uka.ipd.sdq.probfunction.math.util.MathTools;
//import de.uka.ipd.sdq.spa.SPAModel;
//import de.uka.ipd.sdq.spa.basicsolver.operations.RUTableOperations;
//import de.uka.ipd.sdq.spa.basicsolver.util.EMFTools;
//import de.uka.ipd.sdq.spa.concurrencysolver.exceptions.ConcurrencySolverException;
//import de.uka.ipd.sdq.spa.concurrencysolver.simplify.ExpressionSlicer;
//import de.uka.ipd.sdq.spa.concurrencysolver.simplify.ServiceCentre;
//import de.uka.ipd.sdq.spa.concurrencysolver.simplify.ServiceCentreTime;
//import de.uka.ipd.sdq.spa.environment.PassiveResource;
//import de.uka.ipd.sdq.spa.environment.ProcessBehaviour;
//import de.uka.ipd.sdq.spa.expression.Acquire;
//import de.uka.ipd.sdq.spa.expression.Expression;
//import de.uka.ipd.sdq.spa.expression.Release;
//
//public class Solver {
//
//	static IProbabilityFunctionFactory pfFactory = IProbabilityFunctionFactory.eINSTANCE;
//
//	public static void main(String[] args) {
//		try {
//			SPAModel model = (SPAModel) EMFTools.loadFromXMI("Concurrency.spa");
//			ProcessBehaviour behaviour = (ProcessBehaviour) model
//					.getProcesses().get(0);
//			
//			List<Expression> expressionList = simplify(behaviour);
//			
//			if (isValid(expressionList)) {
//				RUTreeNode ruTree = getResourceUsageTree(expressionList,256);
////				fixPoint(ruTree, behaviour.getNumReplicas());
//				printServiceTimes(ruTree);
//				visualizeServiceTimes(ruTree);
//			} else {
//				System.out.println("Expresion is not valid");
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//
//
//	private static void visualizeServiceTimes(RUTreeNode ruTree) {
//		// TODO Auto-generated method stub
//		
//	}
//
//
//	private static void printServiceTimes(RUTreeNode ruTree) {
//		// TODO Auto-generated method stub
//		
//	}
//
//
////	private static void fixPoint(RUTreeNode ruTree, int numReplicas) {
////		List<ServiceCentreTime> scTimeList = getSCTimeList(serviceCentreList);
////		List<Double> probList = initialiseProbabilityList(0, serviceCentreList.size());
////		List<Double> probListOld = initialiseProbabilityList(1, serviceCentreList.size());
////
////		int numOtherProcesses = numProcesses - 1;
////
////		while (!preciseEnough(probList, probListOld)) {
////			probListOld = probList;
////			probList = computeProbabilities(scTimeList);
////
////			Iterator<Double> probIter = probList.iterator();
////			for (ServiceCentreTime queue : scTimeList) {
////				queue.computeNewValues(probIter.next(), numOtherProcesses);
////			}
////		}
////	}
//
//	private static RUTreeNode getResourceUsageTree(List<Expression> expressionList, int numSamplingPoints) {
//		RUTableOperations ruTabOps = new RUTableOperations(numSamplingPoints);
//		ResourceTreeBuilder rtbuilder = new ResourceTreeBuilder(ruTabOps);
//		return rtbuilder.build(expressionList);
//	}
//
//	private static List<ServiceCentreTime> fixPoint(
//			List<ServiceCentre> serviceCentreList, int numProcesses)
//			throws ProbabilityFunctionException, ConcurrencySolverException {
//
//		List<ServiceCentreTime> scTimeList = getSCTimeList(serviceCentreList);
//		List<Double> probList = initialiseProbabilityList(0, serviceCentreList.size());
//		List<Double> probListOld = initialiseProbabilityList(1, serviceCentreList.size());
//
//		int numOtherProcesses = numProcesses - 1;
//
//		while (!preciseEnough(probList, probListOld)) {
//			probListOld = probList;
//			probList = computeProbabilities(scTimeList);
//
//			Iterator<Double> probIter = probList.iterator();
//			for (ServiceCentreTime queue : scTimeList) {
//				queue.computeNewValues(probIter.next(), numOtherProcesses);
//			}
//		}
//		return scTimeList;
//	}
//
//	private static List<Double> computeProbabilities(
//			List<ServiceCentreTime> queueList) throws FunctionNotInTimeDomainException {
//		List<Double> meanTimeList = computeMeanValues(queueList);
//		double totalTime = MathTools.sumOfDoubles(meanTimeList);
//		List<Double> probList = new ArrayList<Double>();
//		for (Double meanTime : meanTimeList) {
//			double p = meanTime / totalTime;
//			probList.add(p);
//		}
//		return probList;
//	}
//
//	private static List<Double> computeMeanValues(List<ServiceCentreTime> queueList) throws FunctionNotInTimeDomainException {
//		List<Double> meanTimeList = null;
//		try {
//			meanTimeList = new ArrayList<Double>();
//			for (ServiceCentreTime queue : queueList) {
//				double meanTime = queue.getSojournTime()
//						.getArithmeticMeanValue();
//				meanTimeList.add(meanTime);
//			}
//		} catch (DomainNotNumbersException e) {
//			e.printStackTrace();
//			System.exit(1);
//		}
//		return meanTimeList;
//	}
//
//	private static boolean preciseEnough(List<Double> probList,
//			List<Double> probListOld) {
//		boolean result = true;
//		for (int i = 0; i < probList.size(); i++) {
//			if (Math.abs(probList.get(i) - probListOld.get(i)) > 0.001) {
//				result = false;
//				break;
//			}
//		}
//		return result;
//	}
//
//	private static List<Double> initialiseProbabilityList(double prob, int size) {
//		List<Double> probList = new ArrayList<Double>();
//		for (int i = 0; i < size; i++) {
//			probList.add(prob);
//		}
//		return probList;
//	}
//
//	private static List<ServiceCentreTime> getSCTimeList(
//			List<ServiceCentre> centreList) {
//		List<ServiceCentreTime> queueList = new ArrayList<ServiceCentreTime>();
//		for (ServiceCentre centre : centreList) {
//			ServiceCentreTime queue = new ServiceCentreTime(centre);
//			queueList.add(queue);
//		}
//		return queueList;
//	}
//
//	/**
//	 * each acquire is followed by a release of the same resource without any
//	 * intermediate aquire, release or sleep operations.
//	 * 
//	 * @param expressionList
//	 * @return
//	 */
//	private static boolean isValid(List<Expression> expressionList) {
//		PassiveResource expectedRelease = null;
//		boolean isValid = true;
//		for (Expression expr : expressionList) {
//			if (expr instanceof Acquire) {
//				if (expectedRelease == null) {
//					Acquire ac = (Acquire) expr;
//					expectedRelease = ac.getResource();
//				} else {
//					isValid = false;
//					break;
//				}
//			} else if (expr instanceof Release) {
//				Release rel = (Release) expr;
//				if (expectedRelease != null
//						&& rel.getResource().equals(expectedRelease)) {
//					expectedRelease = null;
//				} else {
//					isValid = false;
//					break;
//				}
//			} 
//		}
//		return (isValid && expectedRelease == null);
//	}
//
//	public static List<Expression> simplify(ProcessBehaviour process) {
//		ExpressionSlicer sv = new ExpressionSlicer();
//		sv.visit(process.getBehaviour());
//		return sv.slice();
//	}
//}
