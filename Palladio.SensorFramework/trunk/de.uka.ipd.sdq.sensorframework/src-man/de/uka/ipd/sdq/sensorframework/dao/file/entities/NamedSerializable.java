/**
 * 
 */
package de.uka.ipd.sdq.sensorframework.dao.file.entities;

import de.uka.ipd.sdq.sensorframework.dao.file.FileDAOFactory;

/**
 * @author ihssane
 * 
 */
public interface NamedSerializable extends java.io.Serializable {

    public String getFileName();
    public void serializeChildren();
	public void setFactory(FileDAOFactory factory);
	public long getID();
}
