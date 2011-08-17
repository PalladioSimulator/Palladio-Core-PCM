package de.uka.ipd.sdq.sensorfactory.dao.db4o;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import com.db4o.ObjectContainer;
import com.db4o.ext.ExtObjectContainer;
import com.db4o.query.Predicate;

import de.uka.ipd.sdq.sensorfactory.dao.db4o.entities.ExperimentImpl;
import de.uka.ipd.sdq.sensorfactory.dao.db4o.entities.StateImpl;
import de.uka.ipd.sdq.sensorfactory.entities.Experiment;
import de.uka.ipd.sdq.sensorfactory.entities.Sensor;
import de.uka.ipd.sdq.sensorfactory.entities.State;
import de.uka.ipd.sdq.sensorfactory.entities.StateSensor;
import de.uka.ipd.sdq.sensorfactory.entities.dao.IDAOFactory;
import de.uka.ipd.sdq.sensorfactory.entities.dao.IStateDAO;

public class DB4OStateDAO implements IStateDAO {

	private IDAOFactory factory;
	private ObjectContainer db;
	private IDGenerator idGen;

	public DB4OStateDAO(DB4ODAOFactory factory, ObjectContainer db, IDGenerator idGen) {
		this.factory = factory;
		this.db = db;
		this.idGen = idGen;
	}

	public synchronized State addState(String p_stateliteral) {
		State result = new StateImpl(factory);
		result.setStateID(idGen.getNextStateID());
		result.setStateLiteral(p_stateliteral);
		
		db.set(result);
		db.commit();
		
		return result;
	}

	public synchronized Collection<State> findByStateLiteral(final String searchKey) {
		List<State> resultList = db.query(new Predicate<State>() {
	          public boolean match(State s) {
	              return s.getStateLiteral().equals(searchKey);
	          }
		});  
		return Collections.unmodifiableCollection(resultList);
	}

	private HashMap<Long, State> cache = new HashMap<Long, State>();
	
	public synchronized State get(final long id) {
		if (!cache.containsKey(id)){
			List<State> resultList = db.query(new Predicate<State>() {
			          public boolean match(State state) {
			              return state.getStateID() == id;
			          }
			});  
			cache.put(id, resultList.get(0));
		}
		return cache.get(id);
	}

	public Collection<State> getStates() {
		// TODO Auto-generated method stub
		return null;
	}

	public synchronized void store(StateSensor stateSen) {
		((ExtObjectContainer)db).set(stateSen,3);
		db.commit();
	}

	public synchronized void removeState(State state, boolean doCascade) {
		if (state == null) {
			return;
		}
		
		if (cache.containsKey(state.getStateID()))
			cache.remove(cache.get(state.getStateID()));
		
		db.delete(state);
		db.commit();
	}

	public void store(State st) {
		db.set(st);
		db.commit();
	}

}
