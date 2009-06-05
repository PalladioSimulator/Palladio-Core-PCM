package de.uka.ipd.sdq.spa.concurrencysolver.simplify;

import de.uka.ipd.sdq.probfunction.math.IProbabilityDensityFunction;
import de.uka.ipd.sdq.probfunction.math.exception.ProbabilityFunctionException;
import de.uka.ipd.sdq.spa.resourcemodel.PassiveResource;

public class ServiceCentre {
	
	private PassiveResource resource;

	private IProbabilityDensityFunction serviceTime;
	private IProbabilityDensityFunction serviceTimeFourier;

	private String name;

	public ServiceCentre(PassiveResource resource,
			IProbabilityDensityFunction serviceTime, String name) {
		super();
		try {
			this.resource = resource;
			if (serviceTime.isInTimeDomain()){
				this.serviceTime = serviceTime;
				this.serviceTimeFourier = serviceTime.getFourierTransform();
			} else {
				this.serviceTimeFourier = serviceTime;
				this.serviceTime = serviceTime.getInverseFourierTransform();
			}
			this.name = name;
		} catch (ProbabilityFunctionException e) {
			e.printStackTrace();
			System.exit(1);
		}
	}

	public String getName() {
		return name;
	}


	public PassiveResource getResource() {
		return resource;
	}

	public IProbabilityDensityFunction getServiceTimeFourier() {
		return serviceTimeFourier;
	}

	public IProbabilityDensityFunction getServiceTime() {
		return serviceTime;
	}
}
