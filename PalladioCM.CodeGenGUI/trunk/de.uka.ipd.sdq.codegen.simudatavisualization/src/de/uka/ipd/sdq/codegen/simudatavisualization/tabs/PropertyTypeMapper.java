/**
 * 
 */
package de.uka.ipd.sdq.codegen.simudatavisualization.tabs;

import org.eclipse.ui.views.properties.tabbed.ITypeMapper;

/**
 * @author admin
 *
 */
public class PropertyTypeMapper implements ITypeMapper {

	/* (non-Javadoc)
	 * @see org.eclipse.ui.views.properties.tabbed.ITypeMapper#mapType(java.lang.Object)
	 */
	public Class mapType(Object object) {
		return object.getClass();
	}
	
//	public Class<?> mapType(Object object) {
//		Class<?> type = object.getClass();
//		if (object instanceof EObject) {
//			return type;
//		}
//		return super.mapType(object);
//	}

}
