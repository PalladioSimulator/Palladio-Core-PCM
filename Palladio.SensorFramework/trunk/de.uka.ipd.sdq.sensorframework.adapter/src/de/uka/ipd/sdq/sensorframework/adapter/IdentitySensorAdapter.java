package de.uka.ipd.sdq.sensorframework.adapter;

import java.util.Properties;


public class IdentitySensorAdapter implements IAdapter {

	private Properties p = new Properties();
	private Object o;
	
	public IdentitySensorAdapter(Object adaptee) {
		this.o = adaptee;
	}

	public Object getAdaptedObject() {
		return o;
	}

	public Properties getProperties() {
		return p;
	}

	public void setProperties(Properties newProperties) {
		p = newProperties;
	}

}
