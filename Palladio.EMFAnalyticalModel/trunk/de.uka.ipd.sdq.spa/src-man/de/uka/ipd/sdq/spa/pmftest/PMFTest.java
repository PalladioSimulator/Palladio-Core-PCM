package de.uka.ipd.sdq.spa.pmftest;


import com.sun.java_cup.internal.sym;

import de.uka.ipd.sdq.probfunction.ProbabilityMassFunction;
import de.uka.ipd.sdq.probfunction.ProbfunctionFactory;
import de.uka.ipd.sdq.probfunction.Sample;
import de.uka.ipd.sdq.probfunction.Unit;
import de.uka.ipd.sdq.spa.expression.Expression;
import de.uka.ipd.sdq.spa.expression.ExpressionFactory;
import de.uka.ipd.sdq.spa.expression.Loop;
import de.uka.ipd.sdq.spa.expression.Symbol;
import de.uka.ipd.sdq.spa.util.EMFTools;

public class PMFTest {
	
	private static ProbfunctionFactory pfFactory = ProbfunctionFactory.eINSTANCE;
	
	public static void main(String[] args) {
		Loop loop = ExpressionFactory.eINSTANCE.createLoop();
		Symbol symbol = ExpressionFactory.eINSTANCE.createSymbol();
		symbol.setName("A");
		loop.setRegExp(symbol);
		ProbabilityMassFunction pmf = pfFactory.createProbabilityMassFunction();
		Unit unit =pfFactory.createUnit();
		unit.setUnitName("ms");
		pmf.setOrderedDomain(false);
		pmf.setUnit(unit);
		Sample s = pfFactory.createSample();
		s.setProbability(0.3);
		s.setValue("eins");
		pmf.getSamples().add(s);
		s = pfFactory.createSample();
		s.setProbability(0.7);
		s.setValue("zwei");
		pmf.getSamples().add(s);
		loop.setIterationsPMF(pmf);
		
		EMFTools.saveToXMI(loop, "test.expression");
		
		Loop loaded = (Loop) EMFTools.loadFromXMI("test.expression");
		System.out.println( loaded.getIterationsPMF() );
		System.out.println( loaded.getIterationsString() );
		
	}

}
