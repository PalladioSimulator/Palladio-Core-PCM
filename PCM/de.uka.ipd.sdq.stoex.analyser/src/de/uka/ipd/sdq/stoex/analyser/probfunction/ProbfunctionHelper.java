package de.uka.ipd.sdq.stoex.analyser.probfunction;

import java.util.List;


import de.uka.ipd.sdq.probfunction.ContinuousPDF;
import de.uka.ipd.sdq.probfunction.ExponentialDistribution;
import de.uka.ipd.sdq.probfunction.GammaDistribution;
import de.uka.ipd.sdq.probfunction.LognormalDistribution;
import de.uka.ipd.sdq.probfunction.NormalDistribution;
import de.uka.ipd.sdq.probfunction.ProbfunctionFactory;
import de.uka.ipd.sdq.probfunction.math.IGammaDistribution;
import de.uka.ipd.sdq.probfunction.math.ILognormalDistribution;

import de.uka.ipd.sdq.probfunction.math.impl.ProbabilityFunctionFactoryImpl;
import de.uka.ipd.sdq.stoex.DoubleLiteral;
import de.uka.ipd.sdq.stoex.Expression;
import de.uka.ipd.sdq.stoex.IntLiteral;
import de.uka.ipd.sdq.stoex.NegativeExpression;
import de.uka.ipd.sdq.stoex.NumericLiteral;
import de.uka.ipd.sdq.stoex.Unary;

public class ProbfunctionHelper {
	
	public static final String LOGNORM = "Lognorm";
	public static final String LOGNORM2 = "LognormMoments";
	public static final String GAMMA = "Gamma";
	public static final String GAMMA2 = "GammaMoments";
	public static final String NORM = "Norm";
	
	public static final Object EXP = "Exp";
	public static final Object POIS = "Pois";
	public static final Object UNIINT = "UniInt";
	public static final Object UNIDOUBLE = "UniDouble";
	public static final Object BINOM = "Binom";

	public static ContinuousPDF createFunction(List<Expression> parameters, String type, ProbfunctionFactory probFuncFactory) {
		
		try {
		
			if (type.equals(LOGNORM)){
				LognormalDistribution lognorm = probFuncFactory.createLognormalDistribution();
				lognorm.setMu(getDoubleValue((Unary)parameters.get(0)));
				lognorm.setSigma(getDoubleValue((NumericLiteral)parameters.get(1)));
				return lognorm;
			} else if (type.equals(LOGNORM2)){
				LognormalDistribution lognorm = probFuncFactory.createLognormalDistribution();
				double mean = getDoubleValue((NumericLiteral)parameters.get(0));
				double stdev = getDoubleValue((NumericLiteral)parameters.get(1));
				double variance = stdev * stdev ;
				ILognormalDistribution dist = ProbabilityFunctionFactoryImpl.getInstance().getPDFFactory().createLognormalDistributionFromMoments(mean, variance);
				lognorm.setMu(dist.getMu());
				lognorm.setSigma(dist.getSigma());
				return lognorm;
			} else if (type.equals(GAMMA)){
				GammaDistribution gamma = probFuncFactory.createGammaDistribution();
				gamma.setAlpha(getDoubleValue((NumericLiteral)parameters.get(0)));
				gamma.setTheta(getDoubleValue((NumericLiteral)parameters.get(1)));
				return gamma;
			} else if (type.equals(GAMMA2)){
				GammaDistribution gamma = probFuncFactory.createGammaDistribution();
				double mean = getDoubleValue((NumericLiteral)parameters.get(0));
				double coeffVar = getDoubleValue((NumericLiteral)parameters.get(1));
				IGammaDistribution dist = ProbabilityFunctionFactoryImpl.getInstance().getPDFFactory().createGammaDistributionFromMoments(mean, coeffVar);
				gamma.setAlpha(dist.getAlpha());
				gamma.setTheta(dist.getTheta());
				return gamma;
			} else if (type.equals(NORM)){
				NormalDistribution expo = probFuncFactory.createNormalDistribution();
				double mean = getDoubleValue((NumericLiteral)parameters.get(0));
				double sigma = getDoubleValue((NumericLiteral)parameters.get(1));
				expo.setMu(mean);
				expo.setSigma(sigma);
				return expo;
			} else if (type.equals(EXP)){
				ExponentialDistribution exp = probFuncFactory.createExponentialDistribution();
				exp.setRate(getDoubleValue((NumericLiteral)parameters.get(0)));
				return exp;
			} else throw new UnsupportedOperationException("Function "+type+" not supported!");
		} catch (IndexOutOfBoundsException e){
			throw new UnsupportedOperationException("Function "+type+" needs more parameters. See help and stacktrace.", e);
		}
	} 
	
	private static double getDoubleValue(Unary unary) {
		if (unary instanceof DoubleLiteral){
			return ((DoubleLiteral)unary).getValue();
		} else if (unary instanceof IntLiteral){
			return ((IntLiteral)unary).getValue();
		} else if (unary instanceof NegativeExpression){
			return (-1.0) * getDoubleValue(((NegativeExpression)unary).getInner());
		} else {
			throw new RuntimeException("Unknown numeric literal "+unary.getClass().getName()+" encountered. Cannot handle it, aborting. Please contact developers.");
		}
	}

	public static boolean isFunctionWithTwoParameterID(String id){
		if (id.equals(LOGNORM) 
				|| id.equals(LOGNORM2)
				|| id.equals(NORM)
				|| id.equals(GAMMA)
				|| id.equals(GAMMA2))
			return true;
		return false;
	}
	
	public static boolean isFunctionWithOneParameterID(String id){
		if (id.equals(EXP) 
				|| id.equals(BINOM)
				|| id.equals(POIS)
				|| id.equals(UNIINT))
			return true;
		return false;
	}
	
	public static boolean isFunctionID(String id){
		if (isFunctionWithOneParameterID(id)
				|| isFunctionWithTwoParameterID(id))
			return true;
		return false;
	}

	
}
