package de.uka.ipd.sdq.BySuite.utils;

import java.io.Serializable;
import java.util.TreeMap;
import java.util.UUID;

/** The description of the setting where the counting or benchmarkingr 
 * was performed (e.g. time, CPU, JVM, JVM parameters etc.). 
 * Can also be used to describe a platform for which the predicion is done.
 * Needs to be filled with fields. Currently too generic for BySuite.
 * @author Michael
 */
public class AbstractExecutionSetting 
implements Comparable<AbstractExecutionSetting>, Serializable{
	
	/**
	 * to implement Serializable
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Human-readable description/note about the setting/scenario
	 */
	String description;
	
	/**
	 * Numeric values, e.g. benchmarking start time
	 */
	TreeMap<String,Double> doubleProperties;
	
	/**
	 * Generic properties, such as a reference to File objects
	 */
	TreeMap<String,Object> genericProperties;
	
	/**
	 * Textual properties of the benchmark
	 */
	TreeMap<String,String> stringProperties;
	
	/**
	 * Unique ID, used for versioning etc. 
	 */
	UUID uid;
	
	@Override
	public int compareTo(AbstractExecutionSetting o) {
		// TODO modify this/override in subclasses
		return 0;
	}

//	@Override
//	public int hashCode() {
//		final int prime = 31;
//		int result = 1;
//		result = prime * result
//				+ ((description == null) ? 0 : description.hashCode());
//		result = prime
//				* result
//				+ ((doubleProperties == null) ? 0 : doubleProperties.hashCode());
//		result = prime
//				* result
//				+ ((genericProperties == null) ? 0 : genericProperties
//						.hashCode());
//		result = prime
//				* result
//				+ ((stringProperties == null) ? 0 : stringProperties.hashCode());
//		result = prime * result + ((uid == null) ? 0 : uid.hashCode());
//		return result;
//	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AbstractExecutionSetting other = (AbstractExecutionSetting) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (doubleProperties == null) {
			if (other.doubleProperties != null)
				return false;
		} else if (!doubleProperties.equals(other.doubleProperties))
			return false;
		if (genericProperties == null) {
			if (other.genericProperties != null)
				return false;
		} else if (!genericProperties.equals(other.genericProperties))
			return false;
		if (stringProperties == null) {
			if (other.stringProperties != null)
				return false;
		} else if (!stringProperties.equals(other.stringProperties))
			return false;
		if (uid == null) {
			if (other.uid != null)
				return false;
		} else if (!uid.equals(other.uid))
			return false;
		return true;
	}

	public String getDescription() {
		return description;
	}

	public TreeMap<String, Double> getDoubleProperties() {
		return doubleProperties;
	}

	public TreeMap<String, Object> getGenericProperties() {
		return genericProperties;
	}

	public TreeMap<String, String> getStringProperties() {
		return stringProperties;
	}

	public UUID getUid() {
		return uid;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setDoubleProperties(TreeMap<String, Double> doubleProperties) {
		this.doubleProperties = doubleProperties;
	}

	public void setGenericProperties(TreeMap<String, Object> genericProperties) {
		this.genericProperties = genericProperties;
	}

	public void setStringProperties(TreeMap<String, String> stringProperties) {
		this.stringProperties = stringProperties;
	}

	public void setUid(UUID uid) {
		this.uid = uid;
	}
}
