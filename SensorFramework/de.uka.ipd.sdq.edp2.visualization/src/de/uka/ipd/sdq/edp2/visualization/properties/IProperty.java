package de.uka.ipd.sdq.edp2.visualization.properties;

import de.uka.ipd.sdq.edp2.visualization.IDataFlow;

/**
 * This interface describes the default behavior of properties used by {@link IDataFlow} elements.
 * @author Dominik Ernst
 *
 */
public interface IProperty {
	
	/**
	 * The key, which identifies the property and is used for persistance.
	 * @return the unique property key
	 */
	public String getPropertyKey();
	
	/**
	 * Sets the key to the specified {@link String} value.
	 * Should be called only once: in the constructor
	 * @param key the property's new key
	 */
	void setPropertyKey(String key);
	
	/**
	 * A {@link String}, which is used to display the property's key more nicely in GUI elements.
	 * @return {@link String} used in GUI elements
	 */
	String getDisplayName();
	
	/**
	 * @see #getDisplayName()
	 * @param displayName the new display name
	 */
	void setDisplayName(String displayName);
	
	/**
	 * Delivers a short {@link String} description of this property. Useful in 'Help'-menus or
	 * tooltips.
	 * @return a short description of the property
	 */
	String getDescription();
	
	/**
	 * @see #getDescription()
	 * @param description the new description for this property
	 */
	void setDescription(String description);
	
	/**
	 * This property's type in the sense of {@link PropertyTypeEnum}. The enum class is used to
	 * determine the way the property is persisted and transformed into a basic type such as int or double.
	 * @return
	 */
	PropertyTypeEnum getPropertyType();
	
	/**
	 * Sets this property's type to one of the types specified in {@link PropertyTypeEnum}.
	 * Should be called only once: in the constructor.
	 * @param type
	 */
	void setPropertyType(PropertyTypeEnum type);
	
	/**
	 * Returns this property's current value.
	 * @return the current value.
	 */
	Object getPropertyValue();
	
	/**
	 * Sets the property's value.
	 * @param value the value to set
	 * @return true if it could be successfully set
	 */
	boolean setPropertyValue(Object value);
	
	/**
	 * A {@link String}-representation of the value, used for persistence.
	 * @return a persistable {@link String}
	 */
	public String getPersistableValue();
	
}
