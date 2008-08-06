/**
 * 
 */
package de.uka.ipd.sdq.sensorframework.dao.file.entities;

import de.uka.ipd.sdq.sensorframework.dao.file.FileDAOFactory;
import de.uka.ipd.sdq.sensorframework.entities.State;
import de.uka.ipd.sdq.sensorframework.entities.dao.IDAOFactory;

/**
 * @author Ihssane El-Oudghiri 
 * 
 */
public class StateImpl extends AbstractFileEntity implements State, SerializableEntity {

	private static final long serialVersionUID = -458584924706735994L;
	private long stateID;
	private String stateLiteral;

	public StateImpl(IDAOFactory factory) {
		super(factory);
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof State))
			return false;
		State s = (State) obj;
		if (!(stateID == s.getStateID() && stateLiteral.equals(s
				.getStateLiteral())))
			return false;
		return true;
	}

	public String getFileName() {
		return FileDAOFactory.STATE_FILE_NAME_PREFIX + getStateID();
	}

	public long getID() {
		return this.stateID;
	}

	public long getStateID() {
		return stateID;
	}

	public String getStateLiteral() {
		return stateLiteral;
	}

	public void serializeChildren() {
		// Nothing to serialize here
	}

	public void setFactory(FileDAOFactory factory) {
	}

	public void setStateID(long value) {
		this.stateID = value;
	}

	public void setStateLiteral(String value) {
		this.stateLiteral = value;
	}
}
