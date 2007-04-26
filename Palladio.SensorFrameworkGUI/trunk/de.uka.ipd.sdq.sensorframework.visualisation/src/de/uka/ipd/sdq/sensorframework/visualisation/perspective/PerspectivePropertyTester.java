package de.uka.ipd.sdq.sensorframework.visualisation.perspective;

import org.eclipse.core.expressions.PropertyTester;
import org.eclipse.ui.PlatformUI;

public class PerspectivePropertyTester extends PropertyTester {

	public boolean test(Object receiver, String property, Object[] args,
			Object expectedValue) {
		try{
			String perspective = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getPerspective().getId();
			return perspective.equals(expectedValue);
		} catch (Exception ex){
			return false;
		}
	}

}
