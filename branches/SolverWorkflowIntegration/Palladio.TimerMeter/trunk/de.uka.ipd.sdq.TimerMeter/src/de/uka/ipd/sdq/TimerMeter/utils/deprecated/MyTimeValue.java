package de.uka.ipd.sdq.TimerMeter.utils.deprecated;

public class MyTimeValue {//TODO convert to enum
	
	public enum MyTimeUnitEnum{
		DAY 		("day", 		"d", 	7, 86400D, 			0.000011574074074074074074074074074074074074074074074074074074074074074D),
		HOUR 		("hour", 		"h", 	6, 3600D, 			0.000277777777777777777777777777777777777777777777777777777777777777778D),
		MICROSECOND ("microsecond", "µs", 	3, 0.000001D, 		1000000D),
		MILLISECOND ("millisecond", "ms", 	2, 0.001D, 			1000D),
		MINUTE 		("minute", 		"min", 	5, 60D, 			0.016666666666666666666666666666666666666666666666666666666666666666667D),
		//to second, from second
		NANOSECOND 	("nanosecond", 	"ns", 	4, 0.000000001D, 	1000000000D),
		SECOND 		("second", 		"s", 	1, 1D,				1D);
		
		private final double factorFromSecond;
	    private final double factorToSecond;
		private final String longName;
		private final int number;
		private final String shortName;
	    MyTimeUnitEnum(
	    		String pLongName,
	    		String pShortName, 
	    		int pNumber,
	    		double pFactorToSecond, 
	    		double pFactorFromSecond) {
	        this.longName = pLongName;
	        this.shortName = pShortName;
	        this.number = pNumber;
	        this.factorToSecond = pFactorToSecond;
	        this.factorFromSecond = pFactorFromSecond;
	    }
		public double getFactorFromSecond() {
			return factorFromSecond;
		}
		public double getFactorToSecond() {
			return factorToSecond;
		}
		public String getLongName() {
			return longName;
		}
		public int getNumber() {
			return number;
		}
		public String getShortName() {
			return shortName;
		}
	}
	
	public static void convert(MyTimeValue src, MyTimeValue target){
		if(target.getUnit()==null){
			//TODO warn/error
		}else{
			double srcAmount = src.getAmount();
			MyTimeUnitEnum srcUnit = src.getUnit();
			MyTimeUnitEnum targetUnit = target.getUnit();
			double targetAmount = srcAmount*srcUnit.getFactorToSecond(); //for better understanding...
			targetAmount = targetAmount*targetUnit.getFactorFromSecond();
			target.setAmount(targetAmount);
		}
	}

	public static void main(String[] args){
		MyTimeValue mtv = new MyTimeValue();
		mtv.test();
	}

	private double amount;

	private MyTimeUnitEnum unit;

	public MyTimeValue() {
		super();
		this.amount = Double.NaN;
		this.unit = MyTimeUnitEnum.SECOND;
	}
	
	public MyTimeValue(double amount) {
		super();
		this.amount = amount;
		this.unit = MyTimeUnitEnum.SECOND;
	}
	
	public MyTimeValue(double amount, MyTimeUnitEnum unit) {
		super();
		this.amount = amount;
		this.unit = unit;
	}

	public MyTimeValue(MyTimeUnitEnum unit) {
		super();
		this.amount = Double.NaN;
		this.unit = unit;
	}

	public void changeUnit(MyTimeUnitEnum newUnit) {
		double newAmount = this.amount;
		newAmount = newAmount*this.unit.getFactorToSecond();
		newAmount = newAmount*newUnit.getFactorFromSecond();
		this.setUnit(newUnit);
		this.setAmount(newAmount);
	}

	public double getAmount() {
		return amount;
	}

	public MyTimeUnitEnum getUnit() {
		return unit;
	}
	
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	public void setUnit(MyTimeUnitEnum unit) {
		this.unit = unit;
	}
	
	public void test(){
		MyTimeValue v1 = new MyTimeValue(1345.6, MyTimeUnitEnum.NANOSECOND);
		MyTimeValue v2 = new MyTimeValue(MyTimeUnitEnum.SECOND);
		MyTimeValue.convert(v1, v2);
		System.out.println(v2);
		
		v1 = new MyTimeValue(1345.6, MyTimeUnitEnum.SECOND);
		v2 = new MyTimeValue(MyTimeUnitEnum.MINUTE);
		MyTimeValue.convert(v1, v2);
		System.out.println(v2);

		v1 = new MyTimeValue(90000, MyTimeUnitEnum.MILLISECOND);
		v2 = new MyTimeValue(MyTimeUnitEnum.MINUTE);
		MyTimeValue.convert(v1, v2);
		System.out.println(v2);
	}
	
	public String toString(){
		return this.amount+" "+this.unit.getShortName(); //userFormatter!
	}
	
}