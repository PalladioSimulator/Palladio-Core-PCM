package regexVisitor;

import org.eclipse.emf.common.util.EList;

import RegEx.*;
import de.uka.sdq.math.*;

public class RegExPerformanceVisitor extends ReflectionBasedVisitor {
	
	private Complex[] result = null;
	private int accuracy = 32;

	public RegExPerformanceVisitor(Expression expr) {
		visit(expr);
		Complex[] freqPoints = getPoints(expr.getDistributionFunctionFreq());
		Complex[] points = FFT.ifft(freqPoints);
		expr.setDistributionFunction(getDistributionFunction(points));
		result = points;
	}
	
	public Complex[] getResult(){
		return result;
	}
	
	public void visitAlternative(Alternative alt){
		visit(alt.getAltOne());
		visit(alt.getAltTwo());
		Complex[] altPoints = WeightAlternatives(alt.getProbOne(), alt.getAltOne().getDistributionFunctionFreq(), alt.getProbTwo(), alt.getAltTwo().getDistributionFunctionFreq());
		alt.setDistributionFunctionFreq(getDistributionFunction(altPoints));		
	}
	
	public void visitLoop(Loop loop){
		visit(loop.getInner());
		
		Complex[] reiterations = getPoints(loop.getReiterationDistribution());
		result = scale(reiterations[0].getRe(), getDiracImpulse(accuracy));
		Complex[] current = getPoints(loop.getInner().getDistributionFunctionFreq());
		Complex[] inner = current;
		
		
		for (int i = 1; i < reiterations.length; i++) {
			result = add(result, scale(reiterations[i].getRe(), current));		
			current = multiply(current, inner);
		}
		loop.setDistributionFunctionFreq(getDistributionFunction(result));				
	}
	
	private Complex[] getDiracImpulse(int length) {
		Complex[] result = new Complex[length];
	    result[0] = RegExFactory.eINSTANCE.createComplex();
	    result[0].setRe(1.0);
	    for(int i=1; i < length; i++){
	    	result[i] = RegExFactory.eINSTANCE.createComplex();
	    }
		return result;
	}

	public void visitParallel(Parallel par){
		visit(par.getTaskOne());
		visit(par.getTaskTwo());		
	}
	
	public void visitSequence(Sequence seq){
		visit(seq.getPre());
		visit(seq.getPost());
		Complex[] pointsPre = getPoints(seq.getPre().getDistributionFunctionFreq());
		Complex[] pointsPost = getPoints(seq.getPost().getDistributionFunctionFreq());
		Complex[] convPoints = multiply( pointsPre, pointsPost );
		seq.setDistributionFunctionFreq(getDistributionFunction(convPoints));
		
	}
	

	public void visitSymbol(Symbol sym){		
		//makePow2Elements(sym.getDistributionFunction());
		expandTo(sym.getDistributionFunction(), accuracy);
		Complex[] points = getPoints(sym.getDistributionFunction());
		Complex[] freqPoints = FFT.fft(points);
		sym.setDistributionFunctionFreq(getDistributionFunction(freqPoints));		
	}
	
	
	private void makePow2Elements(DistributionFunction distributionFunction) {
		 EList points = distributionFunction.getPoints();		 
		 int i = 0;
		 while(points.size() > java.lang.Math.pow(2, i)) { 
			 i++;
		 }
		 expandTo(distributionFunction, (int)java.lang.Math.pow(2, i));
	}
	
	private void expandTo(DistributionFunction distributionFunction, int length) {
		 EList points = distributionFunction.getPoints();		 
		 for (int i=points.size(); i < length; i++){
			 points.add(RegExFactory.eINSTANCE.createComplex());
		 }		
	}

	private Complex[] WeightAlternatives(double prob1, DistributionFunction distributionFunctionFreq1, double prob2, DistributionFunction distributionFunctionFreq2) {
		Complex[] points1 = getPoints(distributionFunctionFreq1);
		Complex[] points2 = getPoints(distributionFunctionFreq2);
		points1 = scale(prob1, points1);
		points2 = scale(prob2, points2);
		Complex[] resultPoints = add(points1, points2);
		return resultPoints;
	}
	
	
	private Complex[] add(Complex[] points1, Complex[] points2) {
		if (points1.length < points2.length){
			Complex[] temp = points1;
			points1 = points2;
			points2 = temp;
		}		
		Complex[] resultPoints = new Complex[points1.length];
		Complex zero = RegExFactory.eINSTANCE.createComplex();
		zero.setIm(0);
		zero.setRe(0);
		for (int i = 0; i < points1.length; i++) {
			if (i < points2.length){
			resultPoints[i] = points1[i].plus(points2[i]);
			} else {
				resultPoints[i] = points1[i];
			}
		}
		return resultPoints;
	}

	private Complex[] scale(double fac, Complex[] points) {
		Complex cfac = RegExFactory.eINSTANCE.createComplex();
		cfac.setRe(fac);
		Complex[] result = new Complex[points.length];
		for (int i = 0; i < points.length; i++) {
			result[i] = points[i].times(cfac);
		}		
		return result;
	}

	private Complex[] multiply(Complex[] points1, Complex[] points2) {
		if (points1.length < points2.length){
			Complex[] temp = points1;
			points1 = points2;
			points2 = temp;
		}		
		Complex[] resultPoints = new Complex[points1.length];
		Complex zero = RegExFactory.eINSTANCE.createComplex();
		zero.setIm(0);
		zero.setRe(0);
		for (int i = 0; i < points1.length; i++) {
			if (i < points2.length){
			resultPoints[i] = points1[i].times(points2[i]);
			} else {
				resultPoints[i] = points1[i].times(zero);
			}
		}
		return resultPoints;
	}
	
	private DistributionFunction getDistributionFunction(Complex[] points) {
		DistributionFunction df = RegExFactory.eINSTANCE.createDistributionFunction();
		df.setDistance(1.0);
		for (int i = 0; i < points.length; i++) {
			df.getPoints().add(points[i]);			
		}
		return df;
	}

	private Complex[] getPoints(DistributionFunction df){
		return (Complex[]) df.getPoints().toArray();
	}

}
