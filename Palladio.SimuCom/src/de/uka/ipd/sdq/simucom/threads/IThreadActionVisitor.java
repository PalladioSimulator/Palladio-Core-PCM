package de.uka.ipd.sdq.simucom.threads;

import de.uka.ipd.sdq.simucom.component.Component;
import de.uka.ipd.sdq.simucom.component.Method;
import de.uka.ipd.sdq.simucom.component.ServiceEffect;

public interface IThreadActionVisitor {
	void visitComponent(Component c) throws Exception;
	void visitMethod(Method m) throws Exception;
	void visitServiceEffect(ServiceEffect se) throws Exception;
}
