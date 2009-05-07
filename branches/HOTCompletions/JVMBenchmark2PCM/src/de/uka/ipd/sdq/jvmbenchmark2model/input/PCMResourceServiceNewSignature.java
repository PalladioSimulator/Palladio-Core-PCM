package de.uka.ipd.sdq.jvmbenchmark2model.input;

public class PCMResourceServiceNewSignature {
	String serviceName;
	Object parentServiceInterface = null;
	String parameterName;
//	PerformanceStatement //TODO decide on coupling...
	PerformanceMapping performanceMapping = null;
	
	PCMResourceServiceNewSignature(String serviceName, String parameterName){
		this.serviceName = serviceName;
		this.parameterName = parameterName;
	}
	PCMResourceServiceNewSignature(String serviceName, String parameterName, Object parentInterface){
		this.serviceName = serviceName;
		this.parameterName = parameterName;
		this.parentServiceInterface = parentInterface;
	}
	PCMResourceServiceNewSignature(String serviceName, String parameterName, PerformanceMapping mapping){
		this.serviceName = serviceName;
		this.parameterName = parameterName;
		this.performanceMapping = mapping;
	}
	PCMResourceServiceNewSignature(String serviceName, String parameterName, Object parentInterface, PerformanceMapping mapping){
		this.serviceName = serviceName;
		this.parameterName = parameterName;
		this.performanceMapping = mapping;
		this.parentServiceInterface = parentInterface;
	}

}
