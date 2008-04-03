/**
 * 
 */
package de.uka.ipd.sdq.sensorframework.dao.file.entities;

import de.uka.ipd.sdq.sensorframework.dao.file.FileDAOFactory;

/**
 * @author ihssane
 * 
 */
public interface SerializableEntity extends java.io.Serializable {
	public void setFactory(FileDAOFactory factory);
	public long getID();
}
