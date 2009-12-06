package de.uka.ipd.sdq.simucomframework.calculator;

import java.util.HashMap;

import de.uka.ipd.sdq.probespec.framework.calculator.Calculator;

public class CalculatorRepository {

	private HashMap<String, Calculator> calculators;

	public CalculatorRepository() {
		calculators = new HashMap<String, Calculator>();
	}
	
	public void addCalculator(String calculatorId, Calculator calculator) {
		calculators.put(calculatorId, calculator);
	}
	
	public Calculator getCalculatorForId(String calculatorId) {
		return calculators.get(calculatorId);
	}

}
