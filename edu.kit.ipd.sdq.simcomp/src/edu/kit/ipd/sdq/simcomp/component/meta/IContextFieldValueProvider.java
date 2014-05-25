package edu.kit.ipd.sdq.simcomp.component.meta;

import java.io.Serializable;
import java.util.List;

import edu.kit.ipd.sdq.simcomp.component.IPCMModel;

/**
 * An instance of this provider fetches a list of values for a specific
 * simulation context field based on a given PCM model. Each simulation context
 * filed must register a provider for its values.
 * 
 * @author Christoph Föhrdes
 * 
 */
public interface IContextFieldValueProvider extends Serializable {

	public List<String> getPossibleValues(IPCMModel model);

}
