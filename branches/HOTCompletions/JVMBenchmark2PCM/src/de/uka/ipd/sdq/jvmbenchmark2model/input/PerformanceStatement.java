package de.uka.ipd.sdq.jvmbenchmark2model.input;

public class PerformanceStatement {
	private double[] polynomialFactors;
	
	double computePolynomialValue(double xValue){
		double retValue = 0D;
		if(polynomialFactors==null){
			return Double.NaN;//TODO add logging
		}
		if(polynomialFactors.length==0){
			return 0D;//TODO add logging
		}
		double currFactor = 0D;
		for(int i=0; i<polynomialFactors.length; i++){
			currFactor = polynomialFactors[i];
			if(currFactor != Double.NaN 
					&& currFactor != Double.NEGATIVE_INFINITY
					&& currFactor != Double.POSITIVE_INFINITY
					){//TODO add logging for these checks
				retValue += currFactor*Math.pow(xValue, i);
			}
		}
		return retValue;
	}
	
	public PerformanceStatement() {
		polynomialFactors = new double[1];
		polynomialFactors[0]=0D;
	}

	public PerformanceStatement(double constantValue) {
		polynomialFactors = new double[1];
		polynomialFactors[0]=constantValue;
	}

	public PerformanceStatement(double[] factorsInPolynomial) throws NullPointerException {
		if(factorsInPolynomial==null){
			throw new NullPointerException("Parameter is null");
		}else if(factorsInPolynomial.length==0){
			new PerformanceStatement();
		}else{
			polynomialFactors = new double[factorsInPolynomial.length];
			for(int i = 0; i < factorsInPolynomial.length; i++) {
				polynomialFactors[i] = factorsInPolynomial[i];
			}
		}
	}
}
