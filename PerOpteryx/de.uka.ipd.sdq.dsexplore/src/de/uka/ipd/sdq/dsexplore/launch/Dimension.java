package de.uka.ipd.sdq.dsexplore.launch;

/**
 * To be replaced by the QML Criterion (= objective or constraint).
 * 
 * This is not yet the Opt4J objective. 
 * 
 * Store the objective using its getID string.
 * 
 * @author martens
 *
 */
@Deprecated
public class Dimension { //HÄ? Objective oder Criterion??
	
	private String id;

	public Dimension(String id){
		this.id = id;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

}
