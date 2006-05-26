package RegEx.visitor;

import RegEx.Complex;
import RegEx.DistributionFunction;
import RegEx.RegExFactory;
import RegEx.TimeConsumption;

public class LoopHandler implements IVisitHandler {
	
	private Complex[] iterations;
	
	public LoopHandler(DistributionFunction iterationDF){
		iterations = Tools.getPointArray(iterationDF);
	}

	public TimeConsumption handle(TimeConsumption tc1) {
		TimeConsumption tc = RegExFactory.eINSTANCE.createTimeConsumption();
		
		DistributionFunction result = Tools.getDiracImpulse(Tools.ACCURACY,1.0).scale(iterations[0].getRe());
		DistributionFunction current = tc1.getFreqDF();
		DistributionFunction inner = current;
		
		
		for (int i = 1; i < iterations.length; i++) {
			result = result.add(current.scale(iterations[i].getRe()));		
			current = current.multiply(inner);
		}
		tc.setFreqDF(result);
		return tc;
	}
	
	public TimeConsumption handle(TimeConsumption tc1, TimeConsumption tc2) {
		// TODO Auto-generated method stub
		return null;
	}
}
