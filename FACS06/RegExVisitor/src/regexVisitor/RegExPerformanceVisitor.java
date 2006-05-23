package regexVisitor;

import RegEx.*;

public class RegExPerformanceVisitor extends ReflectionBasedVisitor {
	
	private DistributionFunction finalResult = null;
	private int accuracy = 32;

	public RegExPerformanceVisitor(Expression expr) {
		visit(expr);
		finalResult = expr.getDistributionFunctionFreq().getIFFT();
	}
	
	public DistributionFunction getResult(){
		return finalResult;
	}
	
	public void visitAlternative(Alternative alt){
		visit(alt.getAltOne());
		visit(alt.getAltTwo());
		alt.setDistributionFunctionFreq(WeightAlternatives(alt.getProbOne(), alt.getAltOne().getDistributionFunctionFreq(), alt.getProbTwo(), alt.getAltTwo().getDistributionFunctionFreq()));		
	}
	
	public void visitLoop(Loop loop){
		visit(loop.getInner());
		
		Complex[] reiterations = getPointArray(loop.getReiterationDistribution());
		DistributionFunction result = getDiracImpulse(accuracy,1.0).scale(reiterations[0].getRe());
		DistributionFunction current = loop.getInner().getDistributionFunctionFreq();
		DistributionFunction inner = current;
		
		
		for (int i = 1; i < reiterations.length; i++) {
			result = result.add(current.scale(reiterations[i].getRe()));		
			current = current.multiply(inner);
		}
		loop.setDistributionFunctionFreq(result);				
	}
	
	private DistributionFunction getDiracImpulse(int length, double distance) {
		DistributionFunction df = RegExFactory.eINSTANCE.createDistributionFunction();
		df.setDistance(distance);
	    Complex one = RegExFactory.eINSTANCE.createComplex();
	    one.setRe(1.0);
		df.addPoint(one);
		df.expandTo(length);
		return df;
	}

	public void visitParallel(Parallel par){
		visit(par.getTaskOne());
		visit(par.getTaskTwo());
		
		
	}
	
	public void visitSequence(Sequence seq){
		visit(seq.getPre());
		visit(seq.getPost());
		DistributionFunction conv= seq.getPre().getDistributionFunctionFreq().multiply(seq.getPost().getDistributionFunctionFreq());
		seq.setDistributionFunctionFreq(conv);		
	}
	

	public void visitSymbol(Symbol sym){		
		//makePow2Elements(sym.getDistributionFunction());
		sym.getDistributionFunction().expandTo(accuracy);
		sym.setDistributionFunctionFreq(sym.getDistributionFunction().getFFT());		
	}
	
	private DistributionFunction WeightAlternatives(double prob1, DistributionFunction distributionFunctionFreq1, double prob2, DistributionFunction distributionFunctionFreq2) {
		DistributionFunction sdf1 = distributionFunctionFreq1.scale(prob1);
		DistributionFunction sdf2 = distributionFunctionFreq2.scale(prob2);
		return sdf1.add(sdf2);		
	}	

	public static Complex[] getPointArray(DistributionFunction df){
		return (Complex[]) df.getPoints().toArray();
	}
}
