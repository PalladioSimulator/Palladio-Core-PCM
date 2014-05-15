package edu.kit.ipd.sdq.simcomp.ui.data;

import java.util.ArrayList;
import java.util.List;

public class SimulationContextField {

	private String id;
	private String title;
	private List<String> possibleValues;

	public SimulationContextField(String id, String title) {
		this.id = id;
		this.title = title;
		
		possibleValues = new ArrayList<String>();
	}

	public String getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public List<String> getPossibleValues() {
		return possibleValues;
	}

	public void addPossibleValue(String possibleValue) {
		this.possibleValues.add(possibleValue);
	}

}
