package de.uka.ipd.sdq.pcmsolver.exprsolver;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.math.complex.Complex;
import org.apache.log4j.Logger;

import de.uka.ipd.sdq.pcmsolver.visitors.ExpressionHelper;
import de.uka.ipd.sdq.probfunction.ProbabilityMassFunction;
import de.uka.ipd.sdq.probfunction.math.IProbabilityDensityFunction;
import de.uka.ipd.sdq.probfunction.math.IProbabilityFunctionFactory;
import de.uka.ipd.sdq.probfunction.math.IProbabilityMassFunction;
import de.uka.ipd.sdq.probfunction.math.ISample;
import de.uka.ipd.sdq.probfunction.math.ISamplePDF;
import de.uka.ipd.sdq.probfunction.math.IUnit;
import de.uka.ipd.sdq.probfunction.math.ManagedPDF;
import de.uka.ipd.sdq.probfunction.math.PDFConfiguration;
import de.uka.ipd.sdq.probfunction.math.exception.ConfigurationNotSetException;
import de.uka.ipd.sdq.probfunction.math.exception.FunctionsInDifferenDomainsException;
import de.uka.ipd.sdq.probfunction.math.exception.IncompatibleUnitsException;
import de.uka.ipd.sdq.probfunction.math.exception.UnknownPDFTypeException;
import de.uka.ipd.sdq.spa.expression.Alternative;
import de.uka.ipd.sdq.spa.expression.Expression;
import de.uka.ipd.sdq.spa.expression.Loop;
import de.uka.ipd.sdq.spa.expression.Sequence;
import de.uka.ipd.sdq.spa.expression.Symbol;
import de.uka.ipd.sdq.spa.expression.util.ExpressionSwitch;
import de.uka.ipd.sdq.spa.resourcemodel.ResourceUsage;
import de.uka.ipd.sdq.stoex.ProbabilityFunctionLiteral;

public class ExpressionSolver {

	private static Logger logger = Logger.getLogger(ExpressionSolver.class
			.getName());

	private IProbabilityFunctionFactory pfFactory = IProbabilityFunctionFactory.eINSTANCE;

	public ExpressionSolver() {
	}

	public ManagedPDF getResponseTime(Expression expr) {
		return (ManagedPDF) exprSwitch.doSwitch(expr);
	}

	private ExpressionSwitch exprSwitch = new ExpressionSwitch() {

		@Override
		public Object caseAlternative(Alternative object) {

			// Do the logging:
			logger.debug("Visit Alternative");

			ManagedPDF leftManagedPDF = (ManagedPDF) doSwitch(object
					.getLeftOption().getRegexp());
			ManagedPDF rightManagedPDF = (ManagedPDF) doSwitch(object
					.getRightOption().getRegexp());

			if (leftManagedPDF == null && rightManagedPDF != null)
				return rightManagedPDF;
			else if (leftManagedPDF != null && rightManagedPDF == null)
				return leftManagedPDF;
			else if (leftManagedPDF == null && rightManagedPDF == null) {
				return null;
			}

			IProbabilityDensityFunction leftPDF = leftManagedPDF
					.getPdfFrequencyDomain();
			IProbabilityDensityFunction rightPDF = rightManagedPDF
					.getPdfFrequencyDomain();

			double leftProb = object.getLeftOption().getProbability();
			double rightProb = object.getRightOption().getProbability();

			IProbabilityDensityFunction resultPDF = null;
			try {
				resultPDF = leftPDF.scale(leftProb).add(
						rightPDF.scale(rightProb));
			} catch (FunctionsInDifferenDomainsException e) {
				e.printStackTrace();
			} catch (UnknownPDFTypeException e) {
				e.printStackTrace();
			} catch (IncompatibleUnitsException e) {
				e.printStackTrace();
			}

			return new ManagedPDF(resultPDF, true);
		}

		@Override
		public Object caseLoop(Loop object) {

			// Do the logging:
			logger.debug("Visit Loop");

			ManagedPDF innerManagedPDF = (ManagedPDF) doSwitch(object
					.getRegExp());
			if (innerManagedPDF == null)
				return null;

			IProbabilityMassFunction iterations = getIterPMF(object);

			reconfigureForLoopBody(innerManagedPDF, iterations);

			ISamplePDF innerPDF = innerManagedPDF.getSamplePdfFrequencyDomain();
			ISamplePDF resultPDF = null;
			ISamplePDF tempPDF = null;
			try {
				resultPDF = ManagedPDF.createZeroFunction()
						.getSamplePdfFrequencyDomain();
				tempPDF = ManagedPDF.createDiracImpulse()
						.getSamplePdfFrequencyDomain();
			} catch (ConfigurationNotSetException e) {
				e.printStackTrace();
			}

			int pos = 0;
			List<ISample> samples = iterations.getSamples();
			try {
				for (ISample sample : samples) {
					Integer nextPos = (Integer) sample.getValue();
					while (pos < nextPos) {
						tempPDF = (ISamplePDF) tempPDF.mult(innerPDF);
						pos++;
					}
					resultPDF = (ISamplePDF) resultPDF.add(tempPDF.scale(sample
							.getProbability()));
				}
			} catch (FunctionsInDifferenDomainsException e) {
				e.printStackTrace();
			} catch (UnknownPDFTypeException e) {
				e.printStackTrace();
			} catch (IncompatibleUnitsException e) {
				e.printStackTrace();
			}

			return new ManagedPDF(resultPDF, true);
		}

		/**
		 * Adjusts the maximum domain size of the managed PDFs, if the function
		 * resulting from convoluting the inner loop PDFs would need more
		 * sampling points.
		 * 
		 * @param innerManagedPDF
		 * @param iterations
		 */
		private void reconfigureForLoopBody(ManagedPDF innerManagedPDF,
				IProbabilityMassFunction iterations) {

			int maxDomainSize = (int) (getMaxIterations(iterations) * getLargestSamplingValue(innerManagedPDF));

			try {
				PDFConfiguration config = PDFConfiguration
						.getCurrentConfiguration();
				int currentDomainSize = config.getNumSamplingPoints();
				if (currentDomainSize < maxDomainSize) {
					double distance = config.getDistance();
					IUnit unit = config.getUnit();
					logger.debug("Adjusting MaxDomainSize from "
							+ currentDomainSize + " to " + maxDomainSize);
					PDFConfiguration.setCurrentConfiguration(maxDomainSize,
							distance, unit);
				}
			} catch (ConfigurationNotSetException e1) {
				e1.printStackTrace();
			}
		}

		private double getLargestSamplingValue(ManagedPDF innerManagedPDF) {
			ISamplePDF innerSamplePDF = innerManagedPDF
					.getSamplePdfTimeDomain();

			double largestValue = 0.0;
			List<Complex> list = innerSamplePDF.getValues();
			for (int i = list.size() - 1; i >= 0; i--) {
				Complex z = list.get(i);
				double prob = ((double) Math.round(z.getReal() * 10000.0)) / 10000.0;
				if (prob > 0.0) {
					largestValue = i;
					break;
				}
			}
			return largestValue;
		}

		private int getMaxIterations(IProbabilityMassFunction iterations) {
			List<ISample> sampleList = iterations.getSamples();
			int maxIterations = 0;
			for (int i = sampleList.size() - 1; i >= 0; i--) {
				ISample sample = sampleList.get(i);
				if (sample.getProbability() != 0.0) {
					maxIterations = (Integer) sample.getValue();
					break;
				}
			}
			return maxIterations;
		}

		private IProbabilityMassFunction getIterPMF(Loop object) {
			String iter = object.getIterationsString();
			try {
				int iterInt = Integer.parseInt(iter);
				ISample sample = pfFactory.createSample(iterInt, 1.0);
				List<ISample> sampleList = new ArrayList<ISample>();
				sampleList.add(sample);
				IUnit unit = pfFactory.createDefaultUnit();
				return pfFactory.createProbabilityMassFunction(sampleList,
						unit, true);
			} catch (NumberFormatException e) {
				ProbabilityFunctionLiteral loopLiteral = (ProbabilityFunctionLiteral) ExpressionHelper
						.parseToExpression(object.getIterationsString());
				ProbabilityMassFunction loopPMF = (ProbabilityMassFunction) loopLiteral
						.getFunction_ProbabilityFunctionLiteral();
				// return pfFactory.transformToPMF( object.getIterationsPMF() );
				return pfFactory.transformToPMF(loopPMF);
			}
		}

		@Override
		public Object caseSequence(Sequence object) {

			// Do the logging:
			logger.debug("Visit Sequence");

			ManagedPDF leftManagedPDF = (ManagedPDF) doSwitch(object
					.getLeftRegExp());
			ManagedPDF rightManagedPDF = (ManagedPDF) doSwitch(object
					.getRightRegExp());

			if (leftManagedPDF == null && rightManagedPDF != null)
				return rightManagedPDF;
			else if (leftManagedPDF != null && rightManagedPDF == null)
				return leftManagedPDF;
			else if (leftManagedPDF == null && rightManagedPDF == null) {
				return null;
			}

			IProbabilityDensityFunction leftPDF = leftManagedPDF
					.getPdfFrequencyDomain();
			IProbabilityDensityFunction rightPDF = rightManagedPDF
					.getPdfFrequencyDomain();

			IProbabilityDensityFunction resultPDF = null;
			try {
				resultPDF = leftPDF.mult(rightPDF);
			} catch (FunctionsInDifferenDomainsException e) {
				e.printStackTrace();
			} catch (UnknownPDFTypeException e) {
				e.printStackTrace();
			} catch (IncompatibleUnitsException e) {
				e.printStackTrace();
			}

			return new ManagedPDF(resultPDF, true);
		}

		@Override
		public Object caseSymbol(Symbol object) {

			// Do the logging:
			logger.debug("Visit Symbol: " + object.getName());
			
			List<ResourceUsage> resourceUsageList = (List<ResourceUsage>) object
					.getResourceUsages();
			IProbabilityDensityFunction resultPDF = null;
			for (ResourceUsage resourceUsage : resourceUsageList) {
				ManagedPDF managedPDF = new ManagedPDF(resourceUsage
						.getUsageTime(), true);
				IProbabilityDensityFunction iPDF = managedPDF
						.getPdfFrequencyDomain();

				if (resultPDF == null) {
					resultPDF = iPDF;
				} else {
					try {
						resultPDF = resultPDF.mult(iPDF); // add up resource
						// demands
					} catch (FunctionsInDifferenDomainsException e) {
						e.printStackTrace();
					} catch (UnknownPDFTypeException e) {
						e.printStackTrace();
					} catch (IncompatibleUnitsException e) {
						e.printStackTrace();
					}
				}

			}
			if (resultPDF == null)
				return null;
			else
				return new ManagedPDF(resultPDF, true);
		}

	};

}