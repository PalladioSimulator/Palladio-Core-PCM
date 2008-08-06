package de.uka.ipd.sdq.sensorframework.entities.dao;


public interface IStateDAO {

	de.uka.ipd.sdq.sensorframework.entities.State addState(

	String p_stateliteral);
	
	void removeState(de.uka.ipd.sdq.sensorframework.entities.State state, boolean doCascade);

	/* Finder methods to search for States */

	java.util.Collection<de.uka.ipd.sdq.sensorframework.entities.State> findByStateLiteral(
			String searchKey);;

	de.uka.ipd.sdq.sensorframework.entities.State get(long id);

	java.util.Collection<de.uka.ipd.sdq.sensorframework.entities.State> getStates();

	void storeAll();
}
