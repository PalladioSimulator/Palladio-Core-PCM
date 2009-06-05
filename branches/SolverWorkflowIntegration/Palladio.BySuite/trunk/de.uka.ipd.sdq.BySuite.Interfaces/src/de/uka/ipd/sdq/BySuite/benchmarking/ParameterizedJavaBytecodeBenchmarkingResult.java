/**
 * 
 */
package de.uka.ipd.sdq.BySuite.benchmarking;

import de.uka.ipd.sdq.BySuite.benchmarking.AbstractBenchmarkingResult.Units;
import de.uka.ipd.sdq.BySuite.benchmarking.exceptions.ParametersNotSuitableException;
import de.uka.ipd.sdq.BySuite.utils.CSVGenericWriterAndAppender;

/**
 * @author Michael Kuperberg, mkuper@ipd.uka.de
 * TODO test getBenchmarkingValue method
 */
public class ParameterizedJavaBytecodeBenchmarkingResult extends
		AbstractBenchmarkingResult {

	/**
	 * As usual
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * TODO
	 * @param opcode
	 * @param setting
	 * @param unit
	 * @param value
	 */
	public ParameterizedJavaBytecodeBenchmarkingResult(
			int opcode,
			BenchmarkingSetting setting, 
			Units unit, 
			double value) {
		super(opcode, setting, unit, value);
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.BySuite.ByPred.benchmarking.results.AbstractBenchmarkingResult#getBenchmarkingValue(java.lang.Object[], java.lang.String[])
	 */
	@Override
	public double getBenchmarkingValue(
			Object[] parameterValues,
			Integer[] parameterTypes) throws ParametersNotSuitableException {
		for(int i=0; i<this.parameterTypes.length; i++){
			if(!this.parameterTypes[i].equals(parameterTypes[i])){
				System.err.println("The types passed to getBenchmarkingValue " +
						"do not match: expected "+
						CSVGenericWriterAndAppender.TYPES_BY_NAME[this.parameterTypes[i]]+
						", passed "+CSVGenericWriterAndAppender.TYPES_BY_NAME[parameterTypes[i]]);
				return Double.NaN;
//					|| this.parameterTypes[i].equals(CSVGenericWriterAndAppender.INTEGER_COLUMN_TYPE)
//					   && parameterTypes[i].equals(CSVGenericWriterAndAppender.LONG_COLUMN_TYPE)
//					|| ){
//				
//			}else{
//				
			}
		}
		double multiplicationFactor = 1D;//Rundungsfehler...
		for(int i=0; i<this.parameterValues.length; i++){
			if(this.parameterValues[i].equals(parameterValues[i])){
				//do not change the multiplication factor
			}else{
				if(parameterValues[i]==null){
					return Double.NaN; //TODO add warning/logging
				}else if(parameterTypes[i].equals(CSVGenericWriterAndAppender.INTEGER_COLUMN_TYPE)){
					Integer myValue = (Integer) this.parameterValues[i];
					Integer inputValue = (Integer) parameterValues[i];
					if(myValue.equals(0)){//...yet the input value is non-zero...
						//do nothing //TODO parameterise this using new fields in this class
					}else{
						if(inputValue.equals(0)){//...yet my value is non-zero...
							//do nothing //TODO parameterise this using new fields in this class
						}else{
							multiplicationFactor *= inputValue.doubleValue()/myValue.doubleValue();
						}
					}
				}else if(parameterTypes[i].equals(CSVGenericWriterAndAppender.LONG_COLUMN_TYPE)){
					Long myValue = (Long) this.parameterValues[i];
					Long inputValue = (Long) parameterValues[i];
					if(myValue.equals(0)){//...yet the input value is non-zero...
						//do nothing //TODO parameterise this using new fields in this class
					}else{
						if(inputValue.equals(0)){//...yet my value is non-zero...
							//do nothing //TODO parameterise this using new fields in this class
						}else{
							multiplicationFactor *= inputValue.doubleValue()/myValue.doubleValue();
						}
					}
				}else if(parameterTypes[i].equals(CSVGenericWriterAndAppender.FLOAT_COLUMN_TYPE)){
					Float myValue = (Float) this.parameterValues[i];
					Float inputValue = (Float) parameterValues[i];
					if(myValue.equals(0)){//...yet the input value is non-zero...
						//do nothing //TODO parameterise this using new fields in this class
					}else{
						if(inputValue.equals(0)){//...yet my value is non-zero...
							//do nothing //TODO parameterise this using new fields in this class
						}else{
							multiplicationFactor *= inputValue.doubleValue()/myValue.doubleValue();
						}
					}
				}else if(parameterTypes[i].equals(CSVGenericWriterAndAppender.DOUBLE_COLUMN_TYPE)){
					Double myValue = (Double) this.parameterValues[i];
					Double inputValue = (Double) parameterValues[i];
					if(myValue.equals(0)){//...yet the input value is non-zero...
						//do nothing //TODO parameterise this using new fields in this class
					}else{
						if(inputValue.equals(0)){//...yet my value is non-zero...
							//do nothing //TODO parameterise this using new fields in this class
						}else{
							multiplicationFactor *= inputValue.doubleValue()/myValue.doubleValue();
						}
					}
				}else if(parameterTypes[i].equals(CSVGenericWriterAndAppender.BOOLEAN_COLUMN_TYPE)){
					Double myValue = (Double) this.parameterValues[i];
					Double inputValue = (Double) parameterValues[i];
					if(myValue.equals(true) && inputValue.equals(false)){
						return Double.NaN; //TODO parameterise this using new fields in this class
					}else if(myValue.equals(false) && inputValue.equals(true)){
						return Double.NaN; //TODO parameterise this using new fields in this class
					}else{
						System.err.println("Implementation error in " +
								"ParameterizedJavaBytecodeBenchmarkingResult.getBenchmarkingValue");
					}
				}else if(parameterTypes[i].equals(CSVGenericWriterAndAppender.STRING_COLUMN_TYPE)){
					return Double.NaN;
				}else{
					System.err.println("New parameter type, " +
							"previously not accounted for in " +
							"ParameterizedJavaBytecodeBenchmarkingResult.getBenchmarkingValue");
				}
//						(CSVGenericWriterAndAppender.isNumType(parameterTypes[i]) && )
			}
		}
		return this.value*multiplicationFactor;
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.BySuite.ByPred.benchmarking.results.AbstractBenchmarkingResult#verifyParameterTypes()
	 */
	@Override
	public int verifyParameterTypes() throws NoSuchMethodException{
		throw new NoSuchMethodException("The method verifyParameterTypes is not yet implemented");
//		return 0;
	}

//	/**
//	 * @param args
//	 */
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//
//	}

}
