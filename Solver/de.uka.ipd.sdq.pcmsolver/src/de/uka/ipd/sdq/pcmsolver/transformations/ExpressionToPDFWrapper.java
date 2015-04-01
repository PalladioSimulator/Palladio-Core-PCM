package de.uka.ipd.sdq.pcmsolver.transformations;

import org.apache.log4j.Logger;
import org.palladiosimulator.commons.stoex.adapter.StoExSerializer;

import de.uka.ipd.sdq.pcm.core.CoreFactory;
import de.uka.ipd.sdq.pcm.core.PCMRandomVariable;
import de.uka.ipd.sdq.pcm.seff.seff_performance.ParametricResourceDemand;
import de.uka.ipd.sdq.probfunction.ProbabilityDensityFunction;
import de.uka.ipd.sdq.probfunction.ProbabilityFunction;
import de.uka.ipd.sdq.probfunction.ProbabilityMassFunction;
import de.uka.ipd.sdq.probfunction.ProbfunctionFactory;
import de.uka.ipd.sdq.probfunction.math.IContinousPDF;
import de.uka.ipd.sdq.probfunction.math.IProbabilityDensityFunction;
import de.uka.ipd.sdq.probfunction.math.ManagedPDF;
import de.uka.ipd.sdq.probfunction.math.ManagedPMF;
import de.uka.ipd.sdq.probfunction.math.PDFConfiguration;
import de.uka.ipd.sdq.probfunction.math.exception.ConfigurationNotSetException;
import de.uka.ipd.sdq.probfunction.math.exception.DomainNotNumbersException;
import de.uka.ipd.sdq.probfunction.math.exception.FunctionNotInTimeDomainException;
import de.uka.ipd.sdq.stoex.DoubleLiteral;
import de.uka.ipd.sdq.stoex.Expression;
import de.uka.ipd.sdq.stoex.FunctionLiteral;
import de.uka.ipd.sdq.stoex.IntLiteral;
import de.uka.ipd.sdq.stoex.NumericLiteral;
import de.uka.ipd.sdq.stoex.ProbabilityFunctionLiteral;
import de.uka.ipd.sdq.stoex.analyser.probfunction.ProbfunctionHelper;

/**
 * Wraps the actual content of an expression to allow computation with it. 
 * Only supports probability density function or double so far. 
 * Allows to access the expression as a PDF or to get the mean value.  
 * @author martens
 *
 */
public class ExpressionToPDFWrapper {
	ProbabilityDensityFunction pdf;
	Double meanValue;
	Double standardDeviation;
	boolean originalPDF;
	
	protected static Logger logger = Logger.getLogger("de.uka.ipd.sdq.pcmsolver.transformations");
	
	public ExpressionToPDFWrapper(ProbabilityDensityFunction pdf){
		this.pdf = pdf;
		this.originalPDF = true;
	}
	
	/**
	 * Can create a wrapper for {@link ProbabilityFunctionLiteral}s and {@link NumericLiteral}s.
	 * @param rdExpression
	 * @return
	 */
	public static ExpressionToPDFWrapper createExpressionToPDFWrapper(
			Expression rdExpression) {
		if (rdExpression instanceof ProbabilityFunctionLiteral){
			ProbabilityFunctionLiteral probFuncLit = (ProbabilityFunctionLiteral) rdExpression;
			ProbabilityFunction pf = probFuncLit.getFunction_ProbabilityFunctionLiteral();
			if (pf instanceof ProbabilityMassFunction){
				ProbabilityMassFunction pmf = (ProbabilityMassFunction)pf;
				ManagedPMF managedPmf = new ManagedPMF(pmf);
				double value = managedPmf.getExpectedValueDouble();
				return new ExpressionToPDFWrapper(value);
			} else {
				ProbabilityDensityFunction pdf = (ProbabilityDensityFunction)pf;
				return new ExpressionToPDFWrapper(pdf);
			} 
		} else if (rdExpression instanceof FunctionLiteral){
			FunctionLiteral fLit = (FunctionLiteral) rdExpression;
			ProbabilityDensityFunction pdf = ProbfunctionHelper.createFunction(fLit.getParameters_FunctionLiteral(), fLit.getId(), ProbfunctionFactory.eINSTANCE);
			return new ExpressionToPDFWrapper(pdf);
		} else if (rdExpression instanceof NumericLiteral){
			Double value = getDoubleValueForNumericLiteral((NumericLiteral)rdExpression);
			return new ExpressionToPDFWrapper(value);
		} else {
			String solvedExprString = null;
			if (rdExpression != null){
				solvedExprString = new StoExSerializer().valueOf(rdExpression);
			}
			throw new IllegalArgumentException("Handling expression "+solvedExprString+" in the ResourceDemandWrapper failed, could not cast it to "+ProbabilityFunctionLiteral.class+" or "+ FunctionLiteral.class);
		}
	}

	public ExpressionToPDFWrapper(Double meanValue){
		this.meanValue = meanValue;
		this.standardDeviation = new Double(0);
		this.originalPDF = false;
	}
	
	public ProbabilityDensityFunction getPDF(){
		if (pdf == null && meanValue != null){
			ProbabilityDensityFunction pdfLit = convertLiteralsToPDFs(this.meanValue);
			this.pdf = pdfLit;
		}
		return pdf;
	}

	
	public Double getMeanValue(){
		if (meanValue == null && pdf != null){
			ManagedPDF mpdf = new ManagedPDF(pdf);
			try {
				Double value = new Double(mpdf.getPdfTimeDomain().getArithmeticMeanValue());
				this.meanValue = value;
			} catch (DomainNotNumbersException e) {
				ContextWrapper.logger.error("Error calculating arithmetic mean value.", e);
				e.printStackTrace();
			} catch (FunctionNotInTimeDomainException e) {
				ContextWrapper.logger.error("Error calculating arithmetic mean value.", e);
				e.printStackTrace();
			} catch (RuntimeException e){
				logger.error("Could not get mean value of PDF "+pdf.toString());
				throw e;
			}
		}
		return meanValue;
	}
	
	public Double getStandardDeviation(){
		if (this.standardDeviation == null && this.pdf != null){
			ManagedPDF mpdf = new ManagedPDF(pdf);
			try {
				IProbabilityDensityFunction probFunction =  mpdf.getPdfTimeDomain();
				if (probFunction instanceof IContinousPDF){
					Double stdev = new Double(((IContinousPDF)probFunction).getStandardDeviation());
					this.standardDeviation = stdev;
				} else {
					this.standardDeviation = Double.NaN;
				}
				
			} catch (DomainNotNumbersException e) {
				ContextWrapper.logger.error("Error calculating arithmetic mean value.", e);
				e.printStackTrace();
			} catch (FunctionNotInTimeDomainException e) {
				ContextWrapper.logger.error("Error calculating arithmetic mean value.", e);
				e.printStackTrace();
			}
		} 
		return this.standardDeviation;
	}
	
	
	/**
	 * Converts the passed double to a PCMRandomVariable with a DoublePDF inside. 
	 * Modifies the passed {@link PCMRandomVariable} and sets a DoublePDF "around" the 
	 * resource demand if the resource demand was a constant. The 
	 * DoublePDF depends on the distance in {@link PDFConfiguration#getCurrentConfiguration()}. 
	 * @param actResDemSpecification
	 * @param rv
	 * @return
	 */
	private ProbabilityDensityFunction convertLiteralsToPDFs(Double demand) {

			double distance = 0.1;
			try {
				distance = PDFConfiguration.getCurrentConfiguration().getDistance();
			} catch (ConfigurationNotSetException e) {
				e.printStackTrace();
				throw new RuntimeException("Converting literal to pdf failed, wring initialisation. ",e);
			}
			//Ensure that demand is larger than 0 (for the included loop to terminate).
			//Hopefully, a negative demand is caught elsewhere...
			if (demand > 0 && distance > 0){
				while (demand-distance<=0) distance/=10;
			}
			Double firstValue = new Double(demand-distance);
			String newDemand = "DoublePDF[(" +
					firstValue.toString()+
					";0.0)("+demand+";1.0)(" +
					new Double(demand+distance).toString()+";0.0)]";
			
			PCMRandomVariable rv = CoreFactory.eINSTANCE.createPCMRandomVariable();
			rv.setSpecification(newDemand);
			
			ProbabilityFunctionLiteral exp = (ProbabilityFunctionLiteral)rv.getExpression();
			return (ProbabilityDensityFunction) exp.getFunction_ProbabilityFunctionLiteral();
		
	}
	
	/**
	 * Returns whether this resource demand is a derived pdf (i.e. it has been created using a mean value)
	 * or whether it is an original pdf (i.e. the mean value is derived). 
	 * @return true if it has been created using {@link #ResourceDemandWrapper(ParametricResourceDemand, ProbabilityDensityFunction)}, 
	 * false if this has been created using {@link #ResourceDemandWrapper(ParametricResourceDemand, Double)}.
	 */
	public boolean isOriginalPDF(){
		return this.originalPDF;
	}

	private static Double getDoubleValueForNumericLiteral(NumericLiteral rdExpression) {
		double value = 0;
		if (rdExpression instanceof DoubleLiteral){
			value = ((DoubleLiteral) rdExpression).getValue() ;
		} else if (rdExpression instanceof IntLiteral){
			value = ((IntLiteral) rdExpression).getValue(); 
		} else throw new RuntimeException("Unknown type of numeric literal: "+rdExpression.getClass());
		return value;
	}
	
	
}
