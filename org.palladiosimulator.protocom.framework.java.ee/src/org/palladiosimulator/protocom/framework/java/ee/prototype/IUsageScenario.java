package org.palladiosimulator.protocom.framework.java.ee.prototype;

import java.net.URL;

import com.fasterxml.jackson.annotation.JsonIgnore;

public interface IUsageScenario {
	String getId();
	String getName();

	@JsonIgnore
	URL getFileUrl();

	@JsonIgnore
	String getFileName();
}
