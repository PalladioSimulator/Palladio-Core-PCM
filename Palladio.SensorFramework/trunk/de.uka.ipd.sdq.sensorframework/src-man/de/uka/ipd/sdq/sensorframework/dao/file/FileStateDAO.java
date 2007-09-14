/**
 * 
 */
package de.uka.ipd.sdq.sensorframework.dao.file;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;

import de.uka.ipd.sdq.sensorframework.dao.db4o.IDGenerator;
import de.uka.ipd.sdq.sensorframework.dao.file.entities.Serializable;
import de.uka.ipd.sdq.sensorframework.dao.file.entities.StateImpl;
import de.uka.ipd.sdq.sensorframework.entities.State;
import de.uka.ipd.sdq.sensorframework.entities.StateSensor;
import de.uka.ipd.sdq.sensorframework.entities.dao.IStateDAO;

/**
 * @author ihssane
 * 
 * Data Access Object (DAO) for persistence of State Objects.
 * 
 */
public class FileStateDAO implements IStateDAO {

    private HashMap<Long, State> states;
    private FileDAOFactory factory;
    private IDGenerator idGen;

    public FileStateDAO(FileDAOFactory factory, IDGenerator idGen) {
	this.factory = factory;
	this.idGen = idGen;
	states = new HashMap<Long, State>();
	loadStates();
    }

    private void loadStates() {
	File[] files = factory.getFileManager().listFiles(
		FileDAOFactory.STATE_FILE_NAME_PREFIX);
	for (File file : files) {
	    State state = factory.getFileManager().getState(file);
	    states.put(state.getStateID(), state);
	}
    }

    public State addState(String p_stateliteral) {
	State state = new StateImpl(idGen.getNextStateID(), p_stateliteral);
	states.put(state.getStateID(), state);
	// factory.serializeToFile(state);
	return state;
    }

    public Collection<State> findByStateLiteral(String searchKey) {
	Collection<State> result = new ArrayList<State>();
	for (State state : states.values())
	    if (state.getStateLiteral().equals(searchKey))
		result.add(state);
	return Collections.unmodifiableCollection(result);
    }

    public State get(long id) {
	return states.get(id);
    }

    public Collection<State> getStates() {
	return null;
    }

    public void removeState(State state, boolean doCascade) {
	if (state == null) {
	    return;
	}
	factory.getFileManager().removeFile((Serializable) state);
	states.remove(state.getStateID());
    }

    public void store(StateSensor stateSen) {
	factory.getFileManager().serializeToFile((Serializable) stateSen);
	factory.createSensorDAO().store(stateSen);
    }

    public void store(State st) {
	factory.getFileManager().serializeToFile((Serializable) st);
    }

}
