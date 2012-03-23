package de.uka.ipd.sdq.edp2.visualization.properties;

import java.util.ArrayList;

import org.eclipse.ui.IMemento;
import org.eclipse.ui.IPersistable;
import org.eclipse.ui.IPersistableElement;

import de.uka.ipd.sdq.edp2.visualization.IDataFlow;

/**
 * This interface describes the default behavior of properties used by {@link IDataFlow} elements.
 * @author Dominik Ernst
 *
 */
public interface IProperty<T extends Object> extends IPersistable {
	
	/**
	 * The key, which identifies the property and is used for persistance - should be globally unique and static.
	 * @return the unique property key
	 */
	public String getPropertyKey();
	
	/**
	 * Specifies the key of a property. 
	 * @param key the property's key
	 */
	void setPropertyKey(String key);
	
	/**
	 * A {@link String}, which is used to display the property's key more nicely in GUI elements.
	 * @return {@link String} used in GUI elements
	 */
	public String getDisplayName();
	
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
	public String getDescription();
	
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
	public PropertyTypeEnum getPropertyType();
	
	/**
	 * Returns this property's current value.
	 * @return the current value.
	 */
	public T getPropertyValue();
	
	/**
	 * Sets the property's value.
	 * @param value the value to set
	 * @return true if it could be successfully set
	 */
	boolean setPropertyValue(T value);
	
	/**
	 * Describes how a persisted {@link IProperty} is restored from an {@link IMemento}.
	 * @return an instance of a {@link IProperty}.
	 */
	public IProperty<T> restoreProperty(IMemento memento);
	
}
