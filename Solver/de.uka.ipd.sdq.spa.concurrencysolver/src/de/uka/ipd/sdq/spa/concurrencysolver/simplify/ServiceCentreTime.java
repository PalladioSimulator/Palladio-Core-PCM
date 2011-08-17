package de.uka.ipd.sdq.spa.concurrencysolver.simplify;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import de.uka.ipd.sdq.probfunction.math.IProbabilityDensityFunction;
import de.uka.ipd.sdq.probfunction.math.IProbabilityFunctionFactory;
import de.uka.ipd.sdq.probfunction.math.IProbabilityMassFunction;
import de.uka.ipd.sdq.probfunction.math.ISample;
import de.uka.ipd.sdq.probfunction.math.ISamplePDF;
import de.uka.ipd.sdq.probfunction.math.IUnit;
import de.uka.ipd.sdq.probfunction.math.ManagedPDF;
import de.uka.ipd.sdq.probfunction.math.exception.ConfigurationNotSetException;
import de.uka.ipd.sdq.probfunction.math.exception.FunctionNotInFrequencyDomainException;
import de.uka.ipd.sdq.probfunction.math.exception.FunctionNotInTimeDomainException;
import de.uka.ipd.sdq.probfunction.math.exception.ProbabilityFunctionException;
import de.uka.ipd.sdq.probfunction.math.util.MathTools;
import de.uka.ipd.sdq.spa.basicsolver.operations.PDFPerformanceOps;
import de.uka.ipd.sdq.spa.concurrencysolver.exceptions.ConcurrencySolverException;
import de.uka.ipd.sdq.spa.concurrencysolver.exceptions.NumProcessesSmallerThanZeroException;

public class ServiceCentreTime {
	
	@Override
	public String toString() {
		String result = centre.getName() + "\n";
		try{
		result += "queueLength: " + getQueueLength().getArithmeticMeanValue() + "\n";
		result += "sojournTime: " + getSojournTime().getArithmeticMeanValue() + "\n";
		result += "serviceTime: " + centre.getServiceTime().getArithmeticMeanValue() + "\n";
		} catch (ProbabilityFunctionException e){
			e.printStackTrace();
			System.exit(1);
		}
		return result;
	}

	private ServiceCentre centre;

	private IProbabilityMassFunction queueLength;

	private IProbabilityDensityFunction sojournTime;

	private IProbabilityDensityFunction sojournTimeFourier;
	
	private IProbabilityDensityFunction waitingTime;
	
	private IProbabilityDensityFunction waitingTimeFourier;
	
	private PDFPerformanceOps performanceOps;
	
	private static IProbabilityFunctionFactory pfFactory = IProbabilityFunctionFactory.eINSTANCE;
	
	private static IUnit queueUnit = pfFactory.createUnit("length (int)");

	public ServiceCentreTime(ServiceCentre centre) {
		super();
		try {
			this.centre = centre;
			sojournTime = centre.getServiceTime();
			sojournTimeFourier = centre.getServiceTimeFourier();
			queueLength = getZeroQueueLength();
			ISamplePDF pdf = (ISamplePDF) sojournTime;
			int size = pdf.getValues().size();
			double distance = pdf.getDistance();
			IUnit unit = pdf.getUnit();
			waitingTime = pfFactory.createDiracImpulse(size, distance, unit);
			waitingTimeFourier = waitingTime.getFourierTransform();
			
			performanceOps = new PDFPerformanceOps();
		} catch (FunctionNotInTimeDomainException e) {
			e.printStackTrace();
			System.exit(1);
		}
	}
	
	public void computeNewValues(double prob, int numOtherProcesses) throws ProbabilityFunctionException, ConcurrencySolverException, ConfigurationNotSetException {
		if (numOtherProcesses < 0)
			throw new NumProcessesSmallerThanZeroException();
		
		queueLength = getQueueLength(prob,numOtherProcesses);
		waitingTimeFourier = getWaitingTimeFourier(centre.getServiceTimeFourier(), queueLength);
		waitingTime = null;
		waitingTime = getWaitingTime();
		sojournTimeFourier = getSojournTimeFourier(centre.getServiceTimeFourier(), waitingTimeFourier);
		sojournTime = null;
		sojournTime = getSojournTime();
	}
	
	private IProbabilityDensityFunction getSojournTimeFourier(IProbabilityDensityFunction serviceTimeFourier, IProbabilityDensityFunction waitingTimeFourier) throws ProbabilityFunctionException {
		return waitingTimeFourier.mult(serviceTimeFourier);
	}


	private IProbabilityDensityFunction getWaitingTimeFourier(IProbabilityDensityFunction serviceTimeFourier, IProbabilityMassFunction queueLength) throws ProbabilityFunctionException, ConfigurationNotSetException {
		return performanceOps.computeIteration(new ManagedPDF( serviceTimeFourier, true), queueLength).getPdfFrequencyDomain();
	}

	

	public IProbabilityDensityFunction getWaitingTime() {
		try {
			if (waitingTime == null){
				waitingTime = waitingTimeFourier.getInverseFourierTransform();
			}
		} catch (FunctionNotInFrequencyDomainException e) {
			e.printStackTrace();
			System.exit(1);
		}
		return waitingTime;
	}

	public IProbabilityDensityFunction getWaitingTimeFourier() {
		return waitingTimeFourier;
	}

	public ServiceCentre getCentre() {
		return centre;
	}

	public IProbabilityMassFunction getQueueLength() {
		return queueLength;
	}

	public IProbabilityDensityFunction getSojournTime() {
		try {
			if (sojournTime == null) {
				sojournTime = sojournTimeFourier.getInverseFourierTransform();
			}
		} catch (FunctionNotInFrequencyDomainException e) {
			e.printStackTrace();
			System.exit(0);
		}
		return sojournTime;
	}

	public IProbabilityDensityFunction getSojournTimeFourier() {
		return sojournTimeFourier;
	}

	private IProbabilityMassFunction getZeroQueueLength() {
		List<ISample> samples = new ArrayList<ISample>();

		ISample sample = pfFactory.createSample(0, 1);
		samples.add(sample);

		for (int k = 1; k < 10; k++) {
			sample = pfFactory.createSample(k, 0);
			samples.add(sample);
		}

		return pfFactory.createProbabilityMassFunction(samples, queueUnit, true);
	}

	private IProbabilityMassFunction getQueueLength(double prob,
			int numberOfCustomers) {
		List<ISample> samples = new ArrayList<ISample>();
		int n = numberOfCustomers;
		BigDecimal p = new BigDecimal(prob), q = new BigDecimal(1 - prob);

		for (int k = 0; k <= n; k++) {
			double qProb = MathTools.over(n, k).multiply(
					p.pow(k).multiply(q.pow(n - k))).doubleValue();
			ISample sample = pfFactory.createSample(k, qProb);
			samples.add(sample);
		}
		return pfFactory.createProbabilityMassFunction(samples, queueUnit, true);
	}
}
