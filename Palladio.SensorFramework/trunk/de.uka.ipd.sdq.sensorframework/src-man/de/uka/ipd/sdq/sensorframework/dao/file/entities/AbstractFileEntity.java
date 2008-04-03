package de.uka.ipd.sdq.sensorframework.dao.file.entities;

import de.uka.ipd.sdq.sensorframework.dao.file.FileDAOFactory;
import de.uka.ipd.sdq.sensorframework.entities.dao.IDAOFactory;

public abstract class AbstractFileEntity implements SerializableEntity {
	
	/**
	 * File DAO which controls this entity 
	 */
	protected transient IDAOFactory factory;

	public AbstractFileEntity(IDAOFactory factory) {
		this.factory = factory;
	}
	
	public abstract String getFileName();

	public void serializeChildren() {
		// Default: We assume we have no children
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.sensorframework.dao.file.entities.NamedSerializable#setFactory(de.uka.ipd.sdq.sensorframework.dao.file.FileDAOFactory)
	 * 
	 * Called by the deserialisation method to provide the factory after deserialisation
	 */
	public void setFactory(FileDAOFactory factory) {
		this.factory = factory;
	}

}
