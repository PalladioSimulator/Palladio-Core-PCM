package de.uka.ipd.sdq.sensorframework.adapter;

import java.util.Properties;

public interface IAdapter {
	Object getAdaptedObject();
	Properties getProperties();
	void setProperties(Properties newProperties);
}
