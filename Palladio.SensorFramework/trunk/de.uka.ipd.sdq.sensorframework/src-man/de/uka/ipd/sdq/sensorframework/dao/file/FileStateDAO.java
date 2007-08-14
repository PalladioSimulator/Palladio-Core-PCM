/**
 * 
 */
package de.uka.ipd.sdq.sensorframework.dao.file;

import java.util.Collection;

import de.uka.ipd.sdq.sensorframework.entities.State;
import de.uka.ipd.sdq.sensorframework.entities.StateSensor;
import de.uka.ipd.sdq.sensorframework.entities.dao.IStateDAO;

/**
 * @author ihssane
 *
 */
public class FileStateDAO implements IStateDAO {

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.sensorfactory.entities.dao.IStateDAO#addState(java.lang.String)
	 */
	public State addState(String p_stateliteral) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.sensorfactory.entities.dao.IStateDAO#findByStateLiteral(java.lang.String)
	 */
	public Collection<State> findByStateLiteral(String searchKey) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.sensorfactory.entities.dao.IStateDAO#get(long)
	 */
	public State get(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.sensorfactory.entities.dao.IStateDAO#getStates()
	 */
	public Collection<State> getStates() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.sensorfactory.entities.dao.IStateDAO#removeState(de.uka.ipd.sdq.sensorfactory.entities.State, boolean)
	 */
	public void removeState(State state, boolean doCascade) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.sensorfactory.entities.dao.IStateDAO#store(de.uka.ipd.sdq.sensorfactory.entities.StateSensor)
	 */
	public void store(StateSensor stateSen) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.sensorfactory.entities.dao.IStateDAO#store(de.uka.ipd.sdq.sensorfactory.entities.State)
	 */
	public void store(State st) {
		// TODO Auto-generated method stub

	}

}
