package org.palladiosimulator.editors.sirius.repository.externaljavaactions;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.sirius.diagram.DDiagramElement;
import org.eclipse.sirius.diagram.DEdge;
import org.eclipse.sirius.diagram.EdgeTarget;
import org.eclipse.sirius.diagram.business.internal.metamodel.spec.DEdgeSpec;
import org.eclipse.sirius.diagram.business.internal.metamodel.spec.DNodeContainerSpec;
import org.eclipse.sirius.diagram.business.internal.metamodel.spec.DNodeSpec;
import org.eclipse.sirius.tools.api.ui.IExternalJavaAction;
import org.palladiosimulator.pcm.repository.CompleteComponentType;
import org.palladiosimulator.pcm.repository.CompositeComponent;
import org.palladiosimulator.pcm.repository.ProvidesComponentType;


public class DeleteType implements IExternalJavaAction {

	public DeleteType() {
		// TODO Auto-generated constructor stub
	}

	
	public void execute(Collection<? extends EObject> selections, Map<String, Object> parameters) {
		
		for (Entry<String, Object> entry : parameters.entrySet()) {
			DEdgeSpec value = (DEdgeSpec) entry.getValue();

			EObject source = value.getTarget();
			CompleteComponentType cc = (CompleteComponentType) source;
			
			
			EdgeTarget targetNode = value.getTargetNode(); 
			ProvidesComponentType pc = (ProvidesComponentType) (((DDiagramElement) targetNode).getTarget());
			
			
			cc.getParentProvidesComponentTypes().remove(pc);
			
		}
	}

	@Override
	public boolean canExecute(Collection<? extends EObject> selections) {
		return true;
	}

}
