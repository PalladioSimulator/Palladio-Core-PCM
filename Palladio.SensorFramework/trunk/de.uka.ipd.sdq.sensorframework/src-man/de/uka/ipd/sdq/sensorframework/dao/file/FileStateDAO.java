/**
 * 
 */
package de.uka.ipd.sdq.sensorframework.dao.file;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import de.uka.ipd.sdq.sensorframework.dao.db4o.IDGenerator;
import de.uka.ipd.sdq.sensorframework.dao.file.entities.StateImpl;
import de.uka.ipd.sdq.sensorframework.entities.State;
import de.uka.ipd.sdq.sensorframework.entities.StateSensor;
import de.uka.ipd.sdq.sensorframework.entities.dao.IStateDAO;

/**
 * @author ihssane
 * 
 */
public class FileStateDAO implements IStateDAO {

	private FileDAOFactory factory;
	private IDGenerator idGen;

	public FileStateDAO(FileDAOFactory factory, IDGenerator idGen) {
		this.factory = factory;
		this.idGen = idGen;
	}

	public State addState(String p_stateliteral) {
		State state = new StateImpl(idGen.getNextStateID(), p_stateliteral);
		factory.serializeToFile("state" + state.getStateID(), state);
		return state;
	}

	//TODO: Laden zu beginn
	public Collection<State> findByStateLiteral(String searchKey) {
		Collection<State> result = new ArrayList<State>();
		File[] files = factory.listFiles("state");
		for (File file : files) {
			State state = (State) factory.deserializeFromFile(file);
			if (state.getStateLiteral().equals(searchKey))
				result.add(state);
		}
		return Collections.unmodifiableCollection(result);
	}

	//TODO: Laden zu beginn.
	public State get(long id) {
		File[] files = factory.listFiles("state" + id);
		State state = null;
		if (files.length == 0)
			return null;
		else {
			for (File file : files)
				state = (State) factory.deserializeFromFile(file);

		}
		return state;
	}

	public Collection<State> getStates() {
		return null;
	}

	public void removeState(State state, boolean doCascade) {
		if (state == null) {
			return;
		}
		//TODO: Objekte müssen ihren Dateinamen kennen
		factory.removeFile("state" + state.getStateID());
	}

	public void store(StateSensor stateSen) {
	}

	public void store(State st) {
		//TODO: Objekte müssen ihren Dateinamen kennen
		factory.serializeToFile("state" + st.getStateID(), st);
	}

}
