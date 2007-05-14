package RegEx.visitor;

import RegEx.DistributionFunction;
import RegEx.RegExFactory;
import RegEx.TimeConsumption;

public class AlternativeHandler implements IVisitHandler {
	
	private double p1;
	private double p2;
	
	public AlternativeHandler(double p1, double p2){
		this.p1 = p1;
		this.p2 = p2;
	}
	
	/* (non-Javadoc)
	 * @see RegEx.visitor.IVisitHandler#handle(RegEx.TimeConsumption, RegEx.TimeConsumption)
	 */
	public TimeConsumption handle(TimeConsumption tc1, TimeConsumption tc2){
		TimeConsumption tc = RegExFactory.eINSTANCE.createTimeConsumption();
		DistributionFunction df1 = tc1.getFreqDF().scale(p1);
		DistributionFunction df2 = tc2.getFreqDF().scale(p2);
		tc.setFreqDF(df1.add(df2));
		return tc;
	}

	public TimeConsumption handle(TimeConsumption tc1) {
		// TODO Auto-generated method stub
		return null;
	}	
}
