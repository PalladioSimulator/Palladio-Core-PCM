package de.uka.ipd.sdq.simucomframework.variables.cache;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;

import de.uka.ipd.sdq.probfunction.BoxedPDF;
import de.uka.ipd.sdq.probfunction.ContinuousSample;
import de.uka.ipd.sdq.probfunction.ProbabilityMassFunction;
import de.uka.ipd.sdq.probfunction.Sample;
import de.uka.ipd.sdq.probfunction.math.IProbabilityDensityFunction;
import de.uka.ipd.sdq.probfunction.math.IProbabilityFunction;
import de.uka.ipd.sdq.probfunction.math.IProbabilityFunctionFactory;
import de.uka.ipd.sdq.probfunction.math.IProbabilityMassFunction;
import de.uka.ipd.sdq.probfunction.print.ProbFunctionPrettyPrint;
import de.uka.ipd.sdq.probfunction.util.ProbfunctionSwitch;
import de.uka.ipd.sdq.stoex.Expression;

/**
 * A cache for Probability Functions. This saves the time to calculate the 
 * inverse commulative distribution function every time again
 * @author Steffen Becker
 *
 */
public class ProbFunctionCache {
	private static Logger logger = 
		Logger.getLogger(ProbFunctionCache.class.getName());

	private HashMap<EObject,IProbabilityFunction> probFunctions = new HashMap<EObject,IProbabilityFunction>();
	
	/**
	 * Polymorphic switch to analyse and store probability functions 
	 */
	private ProbfunctionSwitch<Object> probFunctionAnnotator = new ProbfunctionSwitch<Object>() {
		@Override
		public Object caseBoxedPDF(BoxedPDF object) {
			adjustPDF(object);
			IProbabilityDensityFunction pdf = null;
			try {
				pdf = IProbabilityFunctionFactory.eINSTANCE.transformToPDF(object);
				pdf.checkConstrains();
			} catch(Exception ex) {
				RuntimeException ex2 = new RuntimeException("PDF not valid: "+new ProbFunctionPrettyPrint().doSwitch(object)+". Caused by "+ex.getMessage(), ex);
				if(logger.isEnabledFor(Level.ERROR))
					logger.error("PMF not valid!", ex2);
				throw ex2; 
			}
			probFunctions.put(object, pdf);
			return super.caseBoxedPDF(object);
		}

		private void adjustPDF(BoxedPDF object) {
			// Adjust PDFs which do not sum up to 1. Issue a warning if needed
			EList<ContinuousSample> samples = object.getSamples();
			double sum = 0;
			for(ContinuousSample sample : samples) {
				sum += sample.getProbability();
			}
			if (Math.abs(sum - 1) > 10e-10 ){
				//Get the problematic PDF as a string so the user can find it. 
				String sampleString = "...PDF[";
				for (ContinuousSample continuousSample : samples) {
					sampleString += "("+continuousSample.getValue()+";"+continuousSample.getProbability()+")";
				} 
				sampleString += "]";
				
				// Adjust wrong PDFs
				double delta = (1 - sum) / countNonZeroContiniousSamples(samples);
				for(ContinuousSample sample : samples) {
					if (sample.getProbability() > 0)
						sample.setProbability(sample.getProbability()+delta);
				}
				
				String sampleStringNew = "...PDF[";
				for (ContinuousSample continuousSample : samples) {
					sampleStringNew += "("+continuousSample.getValue()+";"+continuousSample.getProbability()+")";
				} 
				sampleStringNew += "]";

				if(logger.isEnabledFor(Level.WARN))
					logger.warn("Probfunction needed adjustment as it didn't sum up to 1! Fix your input specification!! Was: "+sampleString+", now is: "+sampleStringNew);
			}
			
		}

		private double countNonZeroContiniousSamples(EList<ContinuousSample> samples) {
			int count=0;
			for (ContinuousSample s : samples)
				if (s.getProbability()>0)
					count++;
			return count;
		}

		private double countNonZeroSamples(EList<Sample> samples) {
			int count=0;
			for (Sample s : samples)
				if (s.getProbability()>0)
					count++;
			return count;
		}
		
		@Override
		public Object caseProbabilityMassFunction(ProbabilityMassFunction object) {
			adjustPMF(object);

			IProbabilityMassFunction pmf = IProbabilityFunctionFactory.eINSTANCE.transformToPMF(object);		
			try {
				pmf.checkConstrains();
			} catch(Exception ex) {
				RuntimeException ex2 = new RuntimeException("PMF not valid: "+new ProbFunctionPrettyPrint().doSwitch(object), ex);
				if(logger.isEnabledFor(Level.ERROR))
					logger.error("PMF not valid!", ex2);
				throw ex2; 
			}
			probFunctions.put(object, pmf);
			return super.caseProbabilityMassFunction(object);
		}

		private void adjustPMF(ProbabilityMassFunction object) {
			// Adjust wrong PMFs
			EList<Sample> samples = object.getSamples();
			double sum = 0;
			for(Sample sample : (Collection<Sample>)samples) {
				sum += sample.getProbability();
			}
			if (Math.abs(sum - 1) > 10e-10 ){
				double delta = (1 - sum) / countNonZeroSamples(samples);
				for(Sample sample : (Collection<Sample>)samples) {
					if (sample.getProbability() > 0)
						sample.setProbability(sample.getProbability()+delta);
				}
				if(logger.isEnabledFor(Level.WARN))
					logger.warn("Probfunction needed adjustment as it didn't sum up to 1! Fix your input specification!!");
			}
		}
	};
	
	
	/**
	 * Initialise the probfunctition cache for all probfunctions in the 
	 * given expression. A visitor is used to search for and cache all 
	 * probfuntions
	 * @param ex The stoex to analyse
	 */
	public ProbFunctionCache(Expression ex) {
		for (Iterator<EObject> it=EcoreUtil.getAllContents(Collections.singleton(ex));
			it.hasNext(); ) {
			probFunctionAnnotator.doSwitch(it.next());
		}
	}

	
	/**
	 * Return the cached probfuntion for partial expression e
	 * @param e SubExpession which has to be a probfunction literal for
	 * which to query the cache
	 * @return Cached probfunction
	 */
	public IProbabilityFunction getProbFunction(EObject e) {
		assert probFunctions.containsKey(e);
		return probFunctions.get(e);
	}
}
