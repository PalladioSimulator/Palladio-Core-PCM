package de.uka.ipd.sdq.stoex.analyser.probfunction;

import umontreal.iro.lecuyer.probdist.GammaDistFromMoments;
import umontreal.iro.lecuyer.probdist.LognormalDistFromMoments;
import de.uka.ipd.sdq.probfunction.ContinuousPDF;
import de.uka.ipd.sdq.probfunction.GammaDistribution;
import de.uka.ipd.sdq.probfunction.LognormalDistribution;
import de.uka.ipd.sdq.probfunction.NormalDistribution;
import de.uka.ipd.sdq.probfunction.ProbfunctionFactory;
import de.uka.ipd.sdq.stoex.DoubleLiteral;
import de.uka.ipd.sdq.stoex.Expression;

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

	public static ContinuousPDF createFunction(Expression solvedFirst,Expression solvedSecond, String type, ProbfunctionFactory probFuncFactory) {
		
		if (type.equals(LOGNORM)){
			LognormalDistribution lognorm = probFuncFactory.createLognormalDistribution();
			lognorm.setMu(((DoubleLiteral)solvedFirst).getValue());
			lognorm.setSigma(((DoubleLiteral)solvedSecond).getValue());
			return lognorm;
		} else if (type.equals(LOGNORM2)){
			LognormalDistribution lognorm = probFuncFactory.createLognormalDistribution();
			double mean = ((DoubleLiteral)solvedFirst).getValue();
			double coeffVar = ((DoubleLiteral)solvedSecond).getValue();
			double variance = coeffVar * coeffVar * mean * mean ;
			LognormalDistFromMoments dist = new LognormalDistFromMoments(mean, variance);
			lognorm.setMu(dist.getMu());
			lognorm.setSigma(dist.getSigma());
			return lognorm;
		} else if (type.equals(GAMMA)){
			GammaDistribution gamma = probFuncFactory.createGammaDistribution();
			gamma.setAlpha(((DoubleLiteral)solvedFirst).getValue());
			gamma.setBeta(((DoubleLiteral)solvedSecond).getValue());
			return gamma;
		} else if (type.equals(GAMMA2)){
			GammaDistribution gamma = probFuncFactory.createGammaDistribution();
			double mean = ((DoubleLiteral)solvedFirst).getValue();
			double coeffVar = ((DoubleLiteral)solvedSecond).getValue();
			double variance = coeffVar * coeffVar * mean * mean ;
			GammaDistFromMoments dist = new GammaDistFromMoments(mean, variance);
			gamma.setAlpha(dist.getAlpha());
			gamma.setBeta(dist.getLambda());
			return gamma;
		} else if (type.equals("Norm")){
			NormalDistribution expo = ProbfunctionFactory.eINSTANCE.createNormalDistribution();
			double mean = ((DoubleLiteral)solvedFirst).getValue();
			double sigma = ((DoubleLiteral)solvedSecond).getValue();
			expo.setMu(mean);
			expo.setSigma(sigma);
			return expo;
			
		} else throw new UnsupportedOperationException("Function "+type+" not supported!");
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
