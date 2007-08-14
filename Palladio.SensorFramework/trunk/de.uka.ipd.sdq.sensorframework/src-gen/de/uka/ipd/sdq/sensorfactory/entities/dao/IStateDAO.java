package de.uka.ipd.sdq.sensorfactory.entities.dao;

import de.uka.ipd.sdq.sensorfactory.entities.State;
import de.uka.ipd.sdq.sensorfactory.entities.StateSensor;

public interface IStateDAO {

	de.uka.ipd.sdq.sensorfactory.entities.State addState(

	String p_stateliteral);
	
	void removeState(de.uka.ipd.sdq.sensorfactory.entities.State state, boolean doCascade);

	/* Finder methods to search for States */

	java.util.Collection<de.uka.ipd.sdq.sensorfactory.entities.State> findByStateLiteral(
			String searchKey);;

	de.uka.ipd.sdq.sensorfactory.entities.State get(long id);

	java.util.Collection<de.uka.ipd.sdq.sensorfactory.entities.State> getStates();

	void store(StateSensor stateSen);

	void store(State st);
}
