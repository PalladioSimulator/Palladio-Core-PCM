package org.palladiosimulator.protocom.framework.jee.servlet.common;

import org.palladiosimulator.protocom.framework.jee.servlet.stubs.SimulatedStackframe;

public interface IComponent {
	void setContext(Object context);
	void setComponentFrame(SimulatedStackframe<Object> stackframe);
}
