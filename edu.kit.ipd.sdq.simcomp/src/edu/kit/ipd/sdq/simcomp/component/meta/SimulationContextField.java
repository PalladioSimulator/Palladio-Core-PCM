package edu.kit.ipd.sdq.simcomp.component.meta;

import java.util.ArrayList;
import java.util.List;

public class SimulationContextField {

	private String id;
	private String name;
	private List<String> possibleValues;

	public SimulationContextField(String id, String name) {
		this.id = id;
		this.name = name;
		
		possibleValues = new ArrayList<String>();
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public List<String> getPossibleValues() {
		return possibleValues;
	}

	public void addPossibleValue(String possibleValue) {
		this.possibleValues.add(possibleValue);
	}

}
