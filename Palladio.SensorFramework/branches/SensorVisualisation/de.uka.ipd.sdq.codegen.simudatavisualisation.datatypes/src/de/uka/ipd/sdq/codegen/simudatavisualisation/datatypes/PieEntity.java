package de.uka.ipd.sdq.codegen.simudatavisualisation.datatypes;

import java.io.Serializable;

/**
 * @author groenda, Michael Kuperberg
 *
 */
public class PieEntity implements Comparable<PieEntity>, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String label = "";
	
	private double value = 0;
	
	/**
	 * TODO is a null label permitted? 
	 * TODO are negative values for "value" permitted?
	 * TODO are values like Double.NaN, Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY permitted?
	 * @param value
	 * @param label
	 */
	public PieEntity(double value, String label) {
		super();
		this.value = value;
		this.label = label;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	public int compareTo(PieEntity other) {
		int valueComparison = Double.compare(this.value, other.value);
		if(valueComparison!=0 || this.getLabel()==null || other.getLabel()==null){
			return valueComparison;
		}else{
			return this.getLabel().compareTo(other.getLabel());
		}
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof PieEntity){
			PieEntity other = (PieEntity) obj;
			if(this.compareTo(other)==0){
				return true;
			}else{
				return false;
			}
		}else{
			return false;
		}
	}
	
	public String getLabel() {
		return label;
	}

	public double getValue() {
		return value;
	}
}
