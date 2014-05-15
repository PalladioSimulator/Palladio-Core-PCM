package edu.kit.ipd.sdq.simcomp.ui.data;

/**
 * Stores the meta information about a simulation component.
 * 
 * @author Christoph Föhrdes
 * 
 */
public class SimulationComponentMetaData {

	private String id;
	private String title;

	public SimulationComponentMetaData(String id, String title) {
		this.id = id;
		this.title = title;
	}

	public String getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

}
