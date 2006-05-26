package RegEx.visitor;

import java.util.ArrayList;
import java.util.List;

import RegEx.DistributionFunction;
import RegEx.Parallel;
import RegEx.RegExFactory;
import RegEx.TimeConsumption;


public class ParallelHandlerRoundRobin implements IParallelHandler {
	
	protected int numCPUs;
	
	public ParallelHandlerRoundRobin(int numCPUs){
		this.numCPUs = numCPUs;
	}
	
	@SuppressWarnings("unchecked")
	public void handle(Parallel par){
		List<TimeConsumption> concurrencyTimes = getCpuUsageTimes(par.getTaskOne().getCpuTimes());
		List<TimeConsumption> addTimes = getCpuUsageTimes(par.getTaskTwo().getCpuTimes());
		for (TimeConsumption time : addTimes) {
			concurrencyTimes.add(time);
			concurrencyTimes = joinTimes(concurrencyTimes);
		}
		par.getCpuTimes().addAll(concurrencyTimes);
	}
	

	private List<TimeConsumption> joinTimes(List<TimeConsumption> concurrencyTimes) {
		return null;
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
		
		computeProbRec(pActive,pPassive, 0, 0, Tools.getOnes(Tools.ACCURACY, Tools.DISTANCE), pNactive);
		
		for(int i=0; i< numCPUs; i++){
			DistributionFunction pMore = Tools.getZeros(Tools.ACCURACY, Tools.DISTANCE);
			for(int j = i; j < numCPUs; j++ ){
				pMore = pMore.add(pNactive.get(j+1));
			}
			TimeConsumption tc = RegExFactory.eINSTANCE.createTimeConsumption();
			tc.setNormDF(pMore.getNegative().getPMF());
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
			computeProbRec(active, passive, numActive+1, numPassive, pCurrent.multiply(active.get(pos)), result);
			computeProbRec(active, passive, numActive, numPassive+1, pCurrent.multiply(passive.get(pos)), result);
		}
	}
}
