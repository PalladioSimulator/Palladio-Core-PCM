package de.uka.ipd.sdq.probfunction.math;

import de.uka.ipd.sdq.probfunction.math.exception.FunctionNotInFrequencyDomainException;
import de.uka.ipd.sdq.probfunction.math.exception.FunctionNotInTimeDomainException;

public class ManagedPDF {

	private IProbabilityDensityFunction pdfTimeDomain;

	private IProbabilityDensityFunction pdfFrequencyDomain;

	public ManagedPDF(IProbabilityDensityFunction pdf) {
		this();
		setPdf(pdf);
	}

	public ManagedPDF() {
		this.pdfFrequencyDomain = null;
		this.pdfTimeDomain = null;
	}

	public IProbabilityDensityFunction getPdfTimeDomain() {
		if (pdfTimeDomain == null) {
			if (pdfFrequencyDomain != null)
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
			if (pdfTimeDomain != null)
				try {
					pdfFrequencyDomain = pdfTimeDomain.getFourierTransform();
				} catch (FunctionNotInTimeDomainException e) {
					e.printStackTrace();
					System.exit(1);
				}
		}
		return pdfFrequencyDomain;
	}

	public void setPdf(IProbabilityDensityFunction pdf) {
		if (pdf.isInFrequencyDomain()) {
			pdfTimeDomain = null;
			pdfFrequencyDomain = pdf;
		} else {
			pdfTimeDomain = pdf;
			pdfFrequencyDomain = null;
		}
	}
}
