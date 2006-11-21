package de.uka.ipd.sdq.spa.pmftest;


import java.io.StringBufferInputStream;

import antlr.RecognitionException;
import antlr.TokenStreamException;

import com.sun.java_cup.internal.sym;

import de.uka.ipd.sdq.pcm.core.stochastics.ProbabilityFunctionLiteral;
import de.uka.ipd.sdq.pcm.stochasticexpressions.ProbFunctionPrettyPrint;
import de.uka.ipd.sdq.pcm.stochasticexpressions.parser.StochasticExpressionsLexer;
import de.uka.ipd.sdq.pcm.stochasticexpressions.parser.StochasticExpressionsParser;
import de.uka.ipd.sdq.probfunction.BoxedPDF;
import de.uka.ipd.sdq.probfunction.ContinuousSample;
import de.uka.ipd.sdq.probfunction.ProbabilityDensityFunction;
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
		
		
		BoxedPDF pdf = pfFactory.createBoxedPDF();
		pdf.setUnit(unit);
		ContinuousSample cs = pfFactory.createContinuousSample();
		cs.setProbability(0.7);
		cs.setValue(2);
		pdf.getSamples().add(cs);
		cs = pfFactory.createContinuousSample();
		cs.setProbability(0.3);
		cs.setValue(7);
		pdf.getSamples().add(cs);
		
		ProbFunctionPrettyPrint pp = new ProbFunctionPrettyPrint();
		String str =  (String) pp.doSwitch(pdf);

		System.out.println(str);
		
		try {
			StochasticExpressionsLexer lexer = new StochasticExpressionsLexer(new StringBufferInputStream("=" + str));
			StochasticExpressionsParser parser = new StochasticExpressionsParser(lexer);
			ProbabilityFunctionLiteral value = (ProbabilityFunctionLiteral) parser.expression();
			BoxedPDF newPDF = (BoxedPDF) value.getFunction_ProbabilityFunctionLiteral();
			System.out.println(newPDF);
		} catch (RecognitionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TokenStreamException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		
		
		EMFTools.saveToXMI(loop, "test.expression");
		
		Loop loaded = (Loop) EMFTools.loadFromXMI("test.expression");
		System.out.println( loaded.getIterationsPMF() );
		System.out.println( loaded.getIterationsString() );
		
	}

}
