package edu.kit.ipd.sdq.simcomp.resource.active.context;

import edu.kit.ipd.sdq.simcomp.component.AbstractSimulationContext;

/**
 * Simulation context for the dynamic binding of active resource simulation components.  
 * 
 * @author Christoph Föhrdes
 *
 */
public class ActiveResourceSimulationContext extends AbstractSimulationContext {

	public static String FIELD_ID_CONTAINER = "resource.active.ctx.container";
	public static String FIELD_ID_RESOURCE_TYPE = "resource.active.ctx.resource_type";

	public ActiveResourceSimulationContext(String container, String resourceType) {
		super();
		setValue(FIELD_ID_CONTAINER, container);
		setValue(FIELD_ID_RESOURCE_TYPE, resourceType);
	}

	public String getContainer() {
		return getValue(FIELD_ID_CONTAINER);
	}

	public String getResourceType() {
		return getValue(FIELD_ID_RESOURCE_TYPE);
	}

}
