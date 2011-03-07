package de.uka.ipd.sdq.sensorframework.dao.file.entities;

import de.uka.ipd.sdq.sensorframework.dao.file.FileDAOFactory;
import de.uka.ipd.sdq.sensorframework.entities.dao.IDAOFactory;

/** Abstract superclass of all entities persistable by File DAOs
 * @author Steffen Becker
 *
 */
public abstract class AbstractFileEntity implements SerializableEntity {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * File DAO which controls this entity. Used to create child objects of this object by subclasses
	 */
	protected transient IDAOFactory factory;

	public AbstractFileEntity(IDAOFactory factory) {
		this.factory = factory;
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
