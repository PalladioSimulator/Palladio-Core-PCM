package de.uka.ipd.sdq.pcmbench.tabs;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.ui.views.properties.tabbed.ITypeMapper;


/**
 * @author Snowball
 * The necessary PropertyTypeMapper. We react on any EMF object.
 */
public class PropertyTypeMapper implements ITypeMapper {

	public Class mapType(Object object) {
		Class type = object.getClass();
		if (object instanceof EObject) {
			return type;
		}
		return type;
	}

}
