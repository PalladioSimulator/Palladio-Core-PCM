package edu.kit.ipd.sdq.eventsim.system.context;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.EList;

import de.uka.ipd.sdq.pcm.resourceenvironment.ResourceContainer;
import edu.kit.ipd.sdq.simcomp.component.IPCMModel;
import edu.kit.ipd.sdq.simcomp.component.meta.IContextFieldValueProvider;

/**
 * Context field value provider for the container parameter of the active
 * resource simulation context.
 * 
 * @author Christoph Föhrdes
 * 
 */
public class ActiveResourceContainerContextValueProvider implements IContextFieldValueProvider {

	private static final long serialVersionUID = 8294016218496728572L;

	@Override
	public List<String> getPossibleValues(IPCMModel model) {
		List<String> values = new ArrayList<String>();

		// read list of resource containers
		EList<ResourceContainer> resourceContainverEnv = model.getResourceEnvironmentModel().getResourceContainer_ResourceEnvironment();
		for (ResourceContainer resourceContainer : resourceContainverEnv) {
			values.add(resourceContainer.getEntityName() + "#" + resourceContainer.getId());
		}

		return values;
	}

}
