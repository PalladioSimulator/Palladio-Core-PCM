package RegEx.visitor;

import RegEx.RegExFactory;
import RegEx.TimeConsumption;

public class SequenceHandler implements IVisitHandler {

	public SequenceHandler() {}
	
	
	public TimeConsumption handle(TimeConsumption tc1, TimeConsumption tc2) {
		TimeConsumption tc = RegExFactory.eINSTANCE.createTimeConsumption();
		tc.setFreqDF(tc1.getFreqDF().multiply(tc2.getFreqDF()));
		return tc;
	}


	public TimeConsumption handle(TimeConsumption tc1) {
		// TODO Auto-generated method stub
		return null;
	}

}
