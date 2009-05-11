package de.uka.ipd.sdq.sensorframework.visualisation.tabs;

import org.eclipse.ui.views.properties.tabbed.ITypeMapper;

public class PropertyTypeMapper implements ITypeMapper {

	/* (non-Javadoc)
	 * @see org.eclipse.ui.views.properties.tabbed.ITypeMapper#mapType(java.lang.Object)
	 */
	@SuppressWarnings("unchecked")
	public Class mapType(Object object) {
		return object.getClass();
	}
}
