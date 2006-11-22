package de.uka.ipd.sdq.probfunction.math;


public class ManagedPMF {

	private IProbabilityMassFunction pmfTimeDomain;


	public ManagedPMF(IProbabilityMassFunction pmf) {
		this();
		setPmf(pmf);
	}

	public ManagedPMF() {
		this.pmfTimeDomain = null;
	}

	public IProbabilityMassFunction getPmfTimeDomain() {
		return pmfTimeDomain;
	}

	public void setPmf(IProbabilityMassFunction pmf) {
		pmfTimeDomain = pmf;
	}
}
