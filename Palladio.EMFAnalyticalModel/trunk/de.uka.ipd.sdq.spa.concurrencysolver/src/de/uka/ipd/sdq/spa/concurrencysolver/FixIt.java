package de.uka.ipd.sdq.spa.concurrencysolver;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import de.uka.ipd.sdq.probfunction.math.IProbabilityFunctionFactory;
import de.uka.ipd.sdq.probfunction.math.exception.DomainNotNumbersException;
import de.uka.ipd.sdq.probfunction.math.exception.FunctionNotInTimeDomainException;
import de.uka.ipd.sdq.probfunction.math.exception.ProbabilityFunctionException;
import de.uka.ipd.sdq.probfunction.math.util.MathTools;
import de.uka.ipd.sdq.probfunction.math.visualization.Visualization;
import de.uka.ipd.sdq.spa.SPAModel;
import de.uka.ipd.sdq.spa.basicsolver.util.EMFTools;
import de.uka.ipd.sdq.spa.concurrencysolver.exceptions.ConcurrencySolverException;
import de.uka.ipd.sdq.spa.concurrencysolver.simplify.ServiceCentre;
import de.uka.ipd.sdq.spa.concurrencysolver.simplify.ServiceCentreQueue;
import de.uka.ipd.sdq.spa.concurrencysolver.simplify.ServiceTimeVisitor;
import de.uka.ipd.sdq.spa.concurrencysolver.simplify.SimplificationVisitor;
import de.uka.ipd.sdq.spa.environment.PassiveResource;
import de.uka.ipd.sdq.spa.environment.ProcessBehaviour;
import de.uka.ipd.sdq.spa.expression.Acquire;
import de.uka.ipd.sdq.spa.expression.Expression;
import de.uka.ipd.sdq.spa.expression.Release;
import de.uka.ipd.sdq.spa.expression.Sleep;

public class FixIt {

	static IProbabilityFunctionFactory pfFactory = IProbabilityFunctionFactory.eINSTANCE;

	public static void main(String[] args) {
		try {
			SPAModel model = (SPAModel) EMFTools.loadFromXMI("Concurrency.spa");
			ProcessBehaviour behaviour = (ProcessBehaviour) model
					.getProcesses().get(0);
			List<Expression> expressionList = simplify(behaviour);
			if (isValid(expressionList)) {
				List<ServiceCentre> timeList = getServiceTimes(expressionList,
						256);
				List<ServiceCentreQueue> queueList = fixPoint(timeList,
						behaviour.getNumReplicas());
				Visualization vis = new Visualization();
				for (ServiceCentreQueue queue : queueList) {
					vis.addProbabilityFunction(queue.getSojournTime());
					System.out.println(queue);
				}
				vis.visualize();
			} else {
				System.out.println("Expresion is not valid");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static List<ServiceCentreQueue> fixPoint(
			List<ServiceCentre> serviceCentreList, int numProcesses)
			throws ProbabilityFunctionException, ConcurrencySolverException {

		List<ServiceCentreQueue> queueList = getQueueList(serviceCentreList);
		List<Double> probList = getProbList(0, serviceCentreList.size());
		List<Double> probListOld = getProbList(1, serviceCentreList.size());

		int numOtherProcesses = numProcesses - 1;

		while (!preciseEnough(probList, probListOld)) {
			probListOld = probList;
			probList = computeProbabilities(queueList);

			Iterator<Double> probIter = probList.iterator();
			for (ServiceCentreQueue queue : queueList) {
				queue.computeNewValues(probIter.next(), numOtherProcesses);
			}
		}
		return queueList;
	}

	private static List<Double> computeProbabilities(
			List<ServiceCentreQueue> queueList) throws FunctionNotInTimeDomainException {
		List<Double> meanTimeList = getMeans(queueList);
		double totalTime = MathTools.sumOfDoubles(meanTimeList);
		List<Double> probList = new ArrayList<Double>();
		for (Double meanTime : meanTimeList) {
			double p = meanTime / totalTime;
			probList.add(p);
		}
		return probList;
	}

	private static List<Double> getMeans(List<ServiceCentreQueue> queueList) throws FunctionNotInTimeDomainException {
		List<Double> meanTimeList = null;
		try {
			meanTimeList = new ArrayList<Double>();
			for (ServiceCentreQueue queue : queueList) {
				double meanTime = queue.getSojournTime()
						.getArithmeticMeanValue();
				meanTimeList.add(meanTime);
			}
		} catch (DomainNotNumbersException e) {
			e.printStackTrace();
			System.exit(1);
		}
		return meanTimeList;
	}

	private static boolean preciseEnough(List<Double> probList,
			List<Double> probListOld) {
		boolean result = true;
		for (int i = 0; i < probList.size(); i++) {
			if (Math.abs(probList.get(i) - probListOld.get(i)) > 0.001) {
				result = false;
				break;
			}
		}
		return result;
	}

	private static List<Double> getProbList(double prob, int size) {
		List<Double> probList = new ArrayList<Double>();
		for (int i = 0; i < size; i++) {
			probList.add(prob);
		}
		return probList;
	}

	private static List<ServiceCentreQueue> getQueueList(
			List<ServiceCentre> centreList) {
		List<ServiceCentreQueue> queueList = new ArrayList<ServiceCentreQueue>();
		for (ServiceCentre centre : centreList) {
			ServiceCentreQueue queue = new ServiceCentreQueue(centre);
			queueList.add(queue);
		}
		return queueList;
	}

	private static List<ServiceCentre> getServiceTimes(
			List<Expression> expressionList, int domainSize) {
		ServiceTimeVisitor sv = new ServiceTimeVisitor(domainSize);
		return sv.visit(expressionList);
	}

	/**
	 * each acquire is followed by a release of the same resource without any
	 * intermediate aquire, release or sleep operations.
	 * 
	 * @param expressionList
	 * @return
	 */
	private static boolean isValid(List<Expression> expressionList) {
		PassiveResource expectedRelease = null;
		boolean isValid = true;
		for (Expression expr : expressionList) {
			if (expr instanceof Acquire) {
				if (expectedRelease == null) {
					Acquire ac = (Acquire) expr;
					expectedRelease = ac.getResource();
				} else {
					isValid = false;
					break;
				}
			} else if (expr instanceof Release) {
				Release rel = (Release) expr;
				if (expectedRelease != null
						&& rel.getResource().equals(expectedRelease)) {
					expectedRelease = null;
				} else {
					isValid = false;
					break;
				}
			} else if (expr instanceof Sleep) {
				if (expectedRelease != null) {
					isValid = false;
					break;
				}
			}
		}
		return (isValid && expectedRelease == null);
	}

	public static List<Expression> simplify(ProcessBehaviour process) {
		SimplificationVisitor sv = new SimplificationVisitor();
		sv.visit(process.getBehaviour());
		return sv.getResultList();
	}
}
