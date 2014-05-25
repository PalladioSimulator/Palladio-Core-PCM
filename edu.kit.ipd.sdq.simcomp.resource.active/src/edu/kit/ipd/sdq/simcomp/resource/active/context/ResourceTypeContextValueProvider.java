package edu.kit.ipd.sdq.simcomp.resource.active.context;

import java.util.ArrayList;
import java.util.List;

import edu.kit.ipd.sdq.simcomp.component.IPCMModel;
import edu.kit.ipd.sdq.simcomp.component.meta.IContextFieldValueProvider;

/**
 * Reads all possible values for the resource type simulation context field for an
 * active resource simulation component.
 * 
 * TODO (SimComp): Read values from PCM model
 * 
 * @author Christoph Föhrdes
 * 
 */
public class ResourceTypeContextValueProvider implements IContextFieldValueProvider {

	private static final long serialVersionUID = 8606242044084081421L;

	@Override
	public List<String> getPossibleValues(IPCMModel model) {
		List<String> values = new ArrayList<String>();
		values.add("Resource Type XY");
		values.add("Resource Type YZ");
		return values;
	}

}
