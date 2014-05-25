package edu.kit.ipd.sdq.simcomp.resource.active.context;

import java.util.ArrayList;
import java.util.List;

import edu.kit.ipd.sdq.simcomp.component.IPCMModel;
import edu.kit.ipd.sdq.simcomp.component.meta.IContextFieldValueProvider;

/**
 * Reads all possible values for the container simulation context field for an
 * active resource simulation component.
 * 
 * TODO (SimComp): Read values from PCM model
 * 
 * @author Christoph Föhrdes
 * 
 */
public class ContainerContextValueProvider implements IContextFieldValueProvider {

	private static final long serialVersionUID = 8294016218496728572L;

	@Override
	public List<String> getPossibleValues(IPCMModel model) {
		List<String> values = new ArrayList<String>();
		values.add("Container XY");
		values.add("Container YZ");
		return values;
	}

}
