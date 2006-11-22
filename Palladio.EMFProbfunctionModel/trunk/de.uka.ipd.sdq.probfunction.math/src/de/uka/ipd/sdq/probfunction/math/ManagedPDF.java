package de.uka.ipd.sdq.probfunction.math;

import de.uka.ipd.sdq.probfunction.ProbabilityDensityFunction;
import de.uka.ipd.sdq.probfunction.math.exception.FunctionNotInFrequencyDomainException;
import de.uka.ipd.sdq.probfunction.math.exception.FunctionNotInTimeDomainException;
import de.uka.ipd.sdq.probfunction.math.exception.ProbabilityFunctionException;

public class ManagedPDF {

	private IProbabilityDensityFunction pdfTimeDomain;

	private IProbabilityDensityFunction pdfFrequencyDomain;
	
	private ProbabilityDensityFunction modelPDF;


	public ManagedPDF() {
		reset();
	}

	public ManagedPDF(IProbabilityDensityFunction pdf) {
		this();
		setPdf(pdf);
	}

	public ManagedPDF(ProbabilityDensityFunction pdf) {
		this();
		setModelPdf(pdf);
	}
	
	private void reset(){
		this.pdfFrequencyDomain = null;
		this.pdfTimeDomain = null;
		this.modelPDF = null;
	}

	public IProbabilityDensityFunction getPdfTimeDomain() {
		if (pdfTimeDomain == null) {
			if (modelPDF != null){
				try {
					pdfTimeDomain = IProbabilityFunctionFactory.eINSTANCE.transformToPDF(modelPDF);
				} catch (ProbabilityFunctionException e) {
					e.printStackTrace();
					System.exit(1);
				}
			} else if (pdfFrequencyDomain != null)
				try {
					pdfTimeDomain = pdfFrequencyDomain
							.getInverseFourierTransform();
				} catch (FunctionNotInFrequencyDomainException e) {
					e.printStackTrace();
					System.exit(1);
				}
		}
		return pdfTimeDomain;
	}

	public IProbabilityDensityFunction getPdfFrequencyDomain() {
		if (pdfFrequencyDomain == null) {
			if (this.getPdfTimeDomain() != null)
				try {
					pdfFrequencyDomain = this.getPdfTimeDomain().getFourierTransform();
				} catch (FunctionNotInTimeDomainException e) {
					e.printStackTrace();
					System.exit(1);
				}
		}
		return pdfFrequencyDomain;
	}

	public void setPdf(IProbabilityDensityFunction pdf) {
		reset();
		if (pdf.isInFrequencyDomain()) {
			pdfFrequencyDomain = pdf;
		} else {
			pdfTimeDomain = pdf;
		}
	}
	
	public void setModelPdf(ProbabilityDensityFunction pdf) {
		reset();
		this.modelPDF = pdf;
	}
	
	public ProbabilityDensityFunction getModelPdf(){
		try {
			if (this.modelPDF == null) {
				this.modelPDF = IProbabilityFunctionFactory.eINSTANCE.transformToModelPDF(this.getPdfTimeDomain());
			}
		} catch (ProbabilityFunctionException e) {
			e.printStackTrace();
			System.exit(1);
		}
		return this.modelPDF;
	}

}
