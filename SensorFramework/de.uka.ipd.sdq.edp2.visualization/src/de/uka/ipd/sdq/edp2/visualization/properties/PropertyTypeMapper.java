package de.uka.ipd.sdq.edp2.visualization.properties;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.eclipse.ui.views.properties.tabbed.ITypeMapper;


public class PropertyTypeMapper implements ITypeMapper{
	/**logger*/
	private static Logger logger = Logger.getLogger(PropertyTypeMapper.class.getCanonicalName());
	
	@SuppressWarnings("unchecked")
	@Override
	public Class mapType(Object object) {
		logger.log(Level.INFO , "object.class"+object.getClass());
		return object.getClass();
	}

}
