package RegEx.visitor;

import java.util.ArrayList;
import java.util.List;

import RegEx.Complex;
import RegEx.DistributionFunction;
import RegEx.Parallel;
import RegEx.RegExFactory;
import RegEx.TimeConsumption;


public class ParallelHandlerRoundRobin implements IParallelHandler {
	
	protected int numCPUs;
	
	public ParallelHandlerRoundRobin(int numCPUs){
		this.numCPUs = numCPUs;
	}
	/* (non-Javadoc)
	 * @see RegEx.visitor.IParallelHandler#handle(RegEx.Parallel)
	 */
	@SuppressWarnings("unchecked")
	public void handle(Parallel par){
		List<TimeConsumption> times = new ArrayList<TimeConsumption>(); 
		times.addAll(par.getTaskOne().getCpuTimes());
		times.addAll(par.getTaskTwo().getCpuTimes());
		times = joinTimes(times);
		par.getCpuTimes().addAll(times);
	}
	
	private List<TimeConsumption> joinTimes(List<TimeConsumption> times) {
		List<DistributionFunction> pNactive = getProbNActive(times);
		List<TimeConsumption> resultTimes = new ArrayList<TimeConsumption>();
		Tools.printTC(times);
		for (int i=1; i<=numCPUs; i++) {
			resultTimes.add(getTimeForCpu(i, pNactive));
		}
		return resultTimes;
	}

	@SuppressWarnings("unchecked")
	private TimeConsumption getTimeForCpu(int cpuID, List<DistributionFunction> nactive) {
		Complex[] p0 = getP0(cpuID, nactive);
		Complex[] p1 = getP1(cpuID, nactive);
		Complex[][] pg1 = getPg1(cpuID, nactive);
				
		double distance = Tools.DISTANCE / numCPUs;
		int accuracy = numCPUs * Tools.ACCURACY;
		DistributionFunction result = Tools.getDiracImpulse(accuracy, distance).getFFT();
		
		result.adjustDistance(distance);
		for(int i=0; i<p0.length; i++){
			DistributionFunction fft = Tools.getZeros(accuracy, distance);
			fft.getPoints().set(0, p0[i]);
			if (i<p1.length)
				fft.getPoints().set(numCPUs, p1[i]);
			else {
				Complex c = RegExFactory.eINSTANCE.createComplex();
				fft.getPoints().set(numCPUs, c);
			}
			for (int j = 0; j< pg1.length; j++) {
				if (i<pg1[j].length) {
					Complex val = pg1[j][i];
					int id = numCPUs + 1 + j;
					fft.getPoints().set(id , val);
				} else {
					Complex c = RegExFactory.eINSTANCE.createComplex();
					fft.getPoints().set(numCPUs + 1 + j, c);
				}

			}
			fft = fft.getFFT();
			result = result.multiply(fft);
		}
		
		result = result.getIFFT();
		result = result.adjustDistance(Tools.DISTANCE);
		
		Tools.println("tc cpu"+cpuID);
		Tools.printDF(result);
		
		TimeConsumption resultTc = RegExFactory.eINSTANCE.createTimeConsumption();
		
		resultTc.setNormDF(result);
		return resultTc;
	}

	private Complex[] getP0(int cpuID, List<DistributionFunction> nactive) {
		DistributionFunction result = Tools.getZeros(Tools.ACCURACY, Tools.DISTANCE);
		for (int i=0; (i<cpuID) && (i<nactive.size()); i++){
			result = result.add(nactive.get(i));
		}
		return Tools.getPointArray(result);
	}
	
	private Complex[] getP1(int cpuID, List<DistributionFunction> nactive) {
		DistributionFunction result = Tools.getZeros(Tools.ACCURACY, Tools.DISTANCE);
		for (int i=cpuID; (i<=numCPUs) && (i<nactive.size()); i++){
			result = result.add(nactive.get(i));
		}
		return Tools.getPointArray(result);
	}

	private Complex[][] getPg1(int cpuID, List<DistributionFunction> nactive) {
		int start = numCPUs + 1;
		Complex[][] result = new Complex[nactive.size()- start][];
		for (int i=start; i<nactive.size(); i++){
			result[i-start] = Tools.getPointArray(nactive.get(i));
		}
		return result;
	}

	private List<DistributionFunction> getProbNActive(List<TimeConsumption> times) {
		List<DistributionFunction> pActive = new ArrayList<DistributionFunction>();
		List<DistributionFunction> pPassive = new ArrayList<DistributionFunction>();
		List<DistributionFunction> pNactive = new ArrayList<DistributionFunction>();
				
		for (TimeConsumption tc : times) {
			DistributionFunction cdf = tc.getNormDF().getCDF();
			pPassive.add(cdf);
			pActive.add(cdf.getNegative());
			pNactive.add(Tools.getZeros(Tools.ACCURACY, Tools.DISTANCE));
		}
		pNactive.add(Tools.getZeros(Tools.ACCURACY, Tools.DISTANCE));
		
		computeProbRec(pActive,pPassive, 0, 0, null, pNactive);
		return pNactive;
	}


	private void computeProbRec(List<DistributionFunction> active, List<DistributionFunction> passive, int numActive, int numPassive, DistributionFunction pCurrent, List<DistributionFunction> result) {
		int pos = numActive + numPassive;
		if ( pos == numCPUs){
			DistributionFunction old = result.get(numActive);
			result.set(numActive, old.add(pCurrent));
		} else {
			if (pCurrent == null) {
				computeProbRec(active, passive, numActive+1, numPassive, active.get(pos), result);
				computeProbRec(active, passive, numActive, numPassive+1, passive.get(pos), result);
			} else {
				computeProbRec(active, passive, numActive+1, numPassive, pCurrent.multiply(active.get(pos)), result);
				computeProbRec(active, passive, numActive, numPassive+1, pCurrent.multiply(passive.get(pos)), result);
			}
		}
	}
	
}
