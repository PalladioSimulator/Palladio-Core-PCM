/**
 * 
 */
package de.uka.ipd.sdq.edp2.visualization;

import java.util.HashMap;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.ui.IPersistableElement;

/**
 * {@link IDataFlow} objects are both persistable ({@link IPersistableElement})
 * and adaptable to allow their usage by default eclipse mechanisms. In addition,
 * every {@link IDataFlow} element must implement methods to retrieve and set its specific properties.
 * 
 * @author Dominik Ernst
 */
public interface IDataFlow extends IPersistableElement, IAdaptable {
	/**
	 * Gets all attributes of this element which, for example, are shown in the
	 * properties view and are used for persistence.
	 * 
	 * @return Returns a map with the key as a {@link String} and the value as
	 *         an {@link Object}.
	 */
	public abstract HashMap<String, Object> getProperties();

	/**
	 * Sets the attributes of the source to the specified {@link HashMap}.
	 * 
	 * @param newProperties the
	 *            new set of properties.
	 */
	public abstract void setProperties(HashMap<String, Object> newProperties);
}
