package de.uka.ipd.sdq.fixit;


import java.math.BigDecimal;
import java.util.Arrays;

import de.uka.ipd.sdq.fixit.simplify.SimplificationProcessor;
import de.uka.ipd.sdq.fixit.simplify.SimplificationVisitor;
import de.uka.ipd.sdq.fixit.simplify.exceptions.InvalidStackStateException;
import de.uka.ipd.sdq.model.analysis.expression.RegularExpression;
import de.uka.ipd.sdq.model.analysis.expression.Sequence;
import de.uka.ipd.sdq.model.analysis.expression.Sleep;
import de.uka.ipd.sdq.model.analysis.expression.Terminal;
import de.uka.ipd.sdq.model.analysis.resource.Semaphore;
import de.uka.ipd.sdq.model.analysis.system.Behaviour;
import de.uka.ipd.sdq.model.analysis.system.SystemModel;
import de.uka.ipd.sdq.probfunction.math.impl.ProbabilityFunctionFactoryImpl;
import de.uka.ipd.sdq.probfunction.math.visualization.Visualization;
import de.uka.ipd.sdq.util.EMFTools;
import flanagan.complex.Complex;
import flanagan.math.FourierTransform;

public class FixIt {
	
	static ProbabilityFunctionFactoryImpl factory = new ProbabilityFunctionFactoryImpl();


	public static void main(String[] args){
		//SystemModel model = (SystemModel)EMFTools.loadFromXMI("WithoutResources.model");
		//Behaviour behaviour = (Behaviour) model.getProcesses().get(0);
		//simplify(behaviour);
		fixPointIteration();
	}
	
	public static void simplify(Behaviour customer) {
		RegularExpression behaviour = customer.getBehaviour();
		SimplificationProcessor proc = new SimplificationProcessor();
		SimplificationVisitor vis = new SimplificationVisitor(proc);
		try {
			vis.visit(behaviour);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			RegularExpression result = proc.getResult();
			EMFTools.saveToXMI(result,"result.model");
		} catch (InvalidStackStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void fixPointIteration(){
		SystemModel model = (SystemModel)EMFTools.loadFromXMI("Simple.model");
		
		Behaviour customer = (Behaviour) model.getProcesses().get(0);
		Semaphore queue = (Semaphore) model.getResources().get(0);
				
		DistributionFunction serviceTime = getServiceTime(customer, queue);
		serviceTime.expand(256);
		DistributionFunction serviceTimeFFT = getFFT(serviceTime);
		DistributionFunction thinkTime = getThinkTime(customer);
		DistributionFunction sojournTime = serviceTime;
		DistributionFunction queueLength = null;
				
		double mThinkTime = thinkTime.meanValue();
		
		double pSojourn = 0;
		double pOldSojourn = 1;
		
		
		while(Math.abs(pSojourn - pOldSojourn) > 0.001){
			double mSojournTime = sojournTime.meanValue();
			double mTotalTime = mThinkTime + mSojournTime;		
			
			pOldSojourn = pSojourn;
			pSojourn = mSojournTime / mTotalTime;
			
			// -1, da der aktuelle Prozess definitiv an der queue ist
			queueLength = getQueueLength(pSojourn, customer.getNumReplicas()-1);
			DistributionFunction waitingTimeFFT = getWaitingTimeFFT(serviceTimeFFT, queueLength);
			DistributionFunction sojournTimeFFT = getSojournTimeFFT(serviceTimeFFT, waitingTimeFFT);
			sojournTime = getInverseFFT(sojournTimeFFT);

			System.out.println("mQ " + queueLength.meanValue());
			System.out.println("sQ " + queueLength.sumUpSamplingPoints());
			System.out.println("mS " + sojournTime.meanValue());
			System.out.println("sS " + sojournTime.sumUpSamplingPoints() + "\n");			
		}
		
		Visualization vis = new Visualization(sojournTime.getDistance(),"Fix Point");
//		vis.addDistributionFunction(serviceTime, "ServiceTime");
//		vis.addDistributionFunction(thinkTime, "ThinkTime");
		vis.addDistributionFunction(queueLength, "QueueLength");
		vis.addDistributionFunction(sojournTime, "SojournTime");
		vis.visualizeOverlay();		
	}


	public static DistributionFunction getSojournTimeFFT(DistributionFunction serviceTimeFFT, DistributionFunction waitingTimeFFT) {
		return waitingTimeFFT.mult(serviceTimeFFT);
	}

	public static DistributionFunction getWaitingTimeFFT(DistributionFunction serviceTimeFFT, DistributionFunction queueLength) {
		DistributionFunction currentTime = factory.createDiracImpulse(serviceTimeFFT.getSamplingPoints().size(), serviceTimeFFT.getDistance(), pfFactory.createDefaultUnit());
		DistributionFunction waitingTime = factory.createZeroFunction(serviceTimeFFT.getSamplingPoints().size(), serviceTimeFFT.getDistance());
		
		DistributionFunction currentTimeFFT = getFFT(currentTime);
		DistributionFunction waitingTimeFFT = getFFT(waitingTime);
		
		for (Complex c : queueLength.getSamplingPoints()) {
			waitingTimeFFT = waitingTimeFFT.add(currentTimeFFT.scale(c));
			currentTimeFFT = currentTimeFFT.mult(serviceTimeFFT);
		}
		return waitingTimeFFT;
	}
	
	public static DistributionFunction getFFT(DistributionFunction df){
		FourierTransform fft = new FourierTransform();
		fft.setData(df.getSamplingPoints().toArray(
				new Complex[] {}));
		fft.transform();
		
		DistributionFunction newDf = factory.createDistributionFunction();
		newDf.setDistance(df.getDistance());
		newDf.setSamplingPoints(Arrays
				.asList(fft.getTransformedDataAsComplex()));
		return newDf;
	}
	
	public static DistributionFunction getInverseFFT(DistributionFunction df){
		FourierTransform fft = new FourierTransform();
		fft.setData(df.getSamplingPoints().toArray(
				new Complex[] {}));
		fft.inverse();
		
		DistributionFunction newDf = factory.createDistributionFunction();
		newDf.setDistance(df.getDistance());
		newDf.setSamplingPoints(Arrays
				.asList(fft.getTransformedDataAsComplex()));
		return newDf;
	}

	public static DistributionFunction getQueueLength(double prob, int numberOfCustomers) {
		DistributionFunction queueLength = factory.createDistributionFunction();
		queueLength.setDistance(1.0);
		
		int n = numberOfCustomers;		
		BigDecimal p = new BigDecimal(prob), q = new BigDecimal(1-prob);
		
		for(int k=0; k<= n; k++){
			double qProb = over(n,k).multiply(p.pow(k).multiply(q.pow(n - k))).doubleValue();
			queueLength.getSamplingPoints().add(new Complex(qProb));
		}
		return queueLength;
	}

	public static BigDecimal over(int n, int k) {
		return fac(n).divide(fac(k).multiply(fac(n-k)));
	}

	public static BigDecimal fac(long n) {
		if (n<0) 
			return null;
		if (n == 0) 
			return new BigDecimal(1);
		BigDecimal fac = new BigDecimal(1);
		for(long i=1; i<= n; i++){
			fac = fac.multiply(new BigDecimal(i));
		}
		return fac;
	}

	public static DistributionFunction getThinkTime(Behaviour customer) {
		Sequence seq = (Sequence) customer.getBehaviour();
		Sleep sleep = (Sleep) seq.getLeftRegExp();
		return factory.transformModelDistributionFunction(sleep.getInputVal());		
	}

	public static DistributionFunction getServiceTime(Behaviour customer, Semaphore queue) {
		Sequence seq = (Sequence) customer.getBehaviour();
		seq = (Sequence) seq.getRightRegExp();
		seq = (Sequence) seq.getLeftRegExp();
		Terminal t = (Terminal) seq.getRightRegExp();
		return factory.transformModelDistributionFunction(t.getInputValue());
//		ServiceTimeVisitor visitor = ServiceTimeVisitor(customer.getBehaviour(), queue);
//		return visitor.getServiceTime();
	}
	
}
