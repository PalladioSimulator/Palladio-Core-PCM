package de.uka.ipd.sdq.sensorframework.adapter;

import java.util.Observable;
import java.util.Properties;

/**Superclass for all DataAdapter in the SensorFramework.
 * All Adapters can have property setting and changes need to be observed to
 * allow changes on the GUI.
 * @author Henning Groenda
 */
public abstract class DataAdapter extends Observable implements IAdapter {
	public static final String SETTINGS_CHANGED = "Settings have changed";
	
	/** The properties settings for this adapter */
	protected Properties adapterProperties;
	
	/**Initializes a new DataAdapter without properties. */
	public DataAdapter() {
		super();
		this.adapterProperties = new Properties();
	}

	/**Initializes a new DataAdapter with the given properties.
	 * @param adapterProperties The associated properties.
	 */
	public DataAdapter(Properties adapterProperties) {
		super();
		this.adapterProperties = adapterProperties;
	}
	
	/** {@inheritDoc}
	 */
	public Properties getProperties() {
		return adapterProperties;
	}

	/** {@inheritDoc}
	 */
	public void setProperties(Properties newProperties) {
		this.adapterProperties = newProperties;
		// notify observers that settings have changed.
		setChanged();
		notifyObservers(SETTINGS_CHANGED);
	}
	
}
