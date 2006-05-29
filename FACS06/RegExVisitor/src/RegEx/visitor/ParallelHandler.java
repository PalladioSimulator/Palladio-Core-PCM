package RegEx.visitor;

import java.util.ArrayList;
import java.util.List;

import RegEx.Complex;
import RegEx.DistributionFunction;
import RegEx.Parallel;
import RegEx.RegExFactory;
import RegEx.TimeConsumption;

public class ParallelHandler implements IParallelHandler {
	
	protected int numCPUs;
	
	public ParallelHandler(int numCPUs){
		this.numCPUs = numCPUs;
	}
	
	/* (non-Javadoc)
	 * @see RegEx.visitor.IParallelHandler#handle(RegEx.Parallel)
	 */
	@SuppressWarnings("unchecked")
	public void handle(Parallel par){
		List<TimeConsumption> concurrencyTimes = par.getTaskOne().getCpuTimes(); // getCpuUsageTimes(par.getTaskOne().getCpuTimes());
		List<TimeConsumption> addTimes = par.getTaskTwo().getCpuTimes(); //getCpuUsageTimes(par.getTaskTwo().getCpuTimes());
		for (TimeConsumption time : addTimes) {
			addLast(concurrencyTimes,time);
			concurrencyTimes = getCpuUsageTimes(concurrencyTimes);
		}
		par.getCpuTimes().addAll(concurrencyTimes);
	}
	
	private void addLast(List<TimeConsumption> cpuTimes, TimeConsumption time) {
		TimeConsumption tcCpu = cpuTimes.get(numCPUs-1);
		DistributionFunction dfCpu = tcCpu.getFreqDF();
		DistributionFunction newDfCpu = dfCpu.multiply(time.getFreqDF());
		tcCpu.setFreqDF(newDfCpu);
	}

	private List<TimeConsumption> getCpuUsageTimes(List<TimeConsumption> cpuTimes) {
		List<DistributionFunction> pActive = new ArrayList<DistributionFunction>();
		List<DistributionFunction> pPassive = new ArrayList<DistributionFunction>();
		List<DistributionFunction> pNactive = new ArrayList<DistributionFunction>();
		
		List<TimeConsumption> tcResult = new ArrayList<TimeConsumption>();
		
		DistributionFunction zeroDF = Tools.getZeros(Tools.ACCURACY, Tools.DISTANCE);
		
		for (TimeConsumption tc : cpuTimes) {
			DistributionFunction cdf = tc.getNormDF().getCDF();
			pPassive.add(cdf);
			pActive.add(cdf.getNegative());
			pNactive.add(zeroDF);
		}
		pNactive.add(zeroDF);
		
		computeProbRec(pActive,pPassive, 0, 0, null, pNactive);
		
		for(int i=0; i< numCPUs; i++){
			DistributionFunction pMore = Tools.getZeros(Tools.ACCURACY, Tools.DISTANCE);
			for(int j = i; j < numCPUs; j++ ){
				pMore = pMore.add(pNactive.get(j+1));
			}
			TimeConsumption tc = RegExFactory.eINSTANCE.createTimeConsumption();
			DistributionFunction pmf = pMore.getNegative().getPMF();
			tc.setNormDF(pmf);
			tcResult.add(i, tc);
		}
		
		return tcResult;
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
