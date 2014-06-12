package org.palladiosimulator.protocom.framework.jee.servlet.stubs;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;

@JsonAutoDetect(fieldVisibility = Visibility.ANY)
public class SimulatedStack {
	public void createAndPushNewStackFrame() {
	}
	
	public void removeStackFrame() {
	}
}
