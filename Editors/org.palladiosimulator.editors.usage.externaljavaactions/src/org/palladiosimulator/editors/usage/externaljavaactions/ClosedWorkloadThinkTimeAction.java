package org.palladiosimulator.editors.usage.externaljavaactions;

import java.util.Collection;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.sirius.diagram.business.internal.metamodel.spec.DNodeListElementSpec;
import org.eclipse.sirius.tools.api.ui.IExternalJavaAction;
import org.eclipse.ui.PlatformUI;
import org.palladiosimulator.editors.ui.dialog.TextInputDialog;

public class ClosedWorkloadThinkTimeAction implements IExternalJavaAction {

	public ClosedWorkloadThinkTimeAction() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean canExecute(Collection<? extends EObject> arg0) {
		for (EObject element: arg0) {
			System.out.println(element);
		}
		return true;
	}

	@Override
	public void execute(Collection<? extends EObject> arg0,
			Map<String, Object> arg1) {
	    DNodeListElementSpec ele = (DNodeListElementSpec) arg0.iterator().next();

	    TextInputDialog dialog = new TextInputDialog(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(), 0, "");
	    dialog.open();
		for (EObject element: arg0) {
			System.out.println(element);
		}
		for (String element: arg1.keySet()) {
			System.out.println(element);
		}
		for (Object element: arg1.values()) {
			System.out.println(element);
		}
	}

}
