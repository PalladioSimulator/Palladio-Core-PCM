package de.uka.ipd.sdq.codegen.simudatavisualisation.datatypes;

public class PieEntity {
	private double value = 0;
	private String label = "";
	
	public PieEntity(double value, String label) {
		super();
		this.value = value;
		this.label = label;
	}
	
	public double getValue() {
		return value;
	}
	public String getLabel() {
		return label;
	}
	
}
