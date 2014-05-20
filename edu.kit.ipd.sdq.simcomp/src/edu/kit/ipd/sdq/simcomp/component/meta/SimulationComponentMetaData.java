package edu.kit.ipd.sdq.simcomp.component.meta;

/**
 * Stores the meta information about a simulation component.
 * 
 * @author Christoph Föhrdes
 * 
 */
public class SimulationComponentMetaData {

	private String id;
	private String name;

	public SimulationComponentMetaData(String id, String name) {
		this.id = id;
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return this.name;
	}

}
