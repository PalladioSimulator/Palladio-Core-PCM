package de.uka.ipd.sdq.edp2.visualization.util;

import org.eclipse.ui.IMemento;

import de.uka.ipd.sdq.edp2.visualization.IDataFlow;

/**
 * Class for Tags, which are used as Keys in {@link IMemento} to persist {@link IDataFlow} elements.
 * @author Dominik Ernst
 *
 */
public enum PersistenceTag {
	REPOSITORY ("repositoryURI", "String"),
	SOURCE ("source","String"),
	RAW_MEASUREMENTS ("rawMeasurementsUUID", "String"),
	DROPPED_VALUES_ABS ("droppedValuesAbsolute", "Integer"),
	DROPPED_VALUES_REL ("droppedValuesRelative", "Float"),
	DATA_SERIES_INDEX ("selectedDataSeries","Integer"),
	NUMBER_OF_BINS ("numberBins","Integer")
	;
	
	
	private final String identifier;
	private final String type;
	
	PersistenceTag(String identifier, String description) {
		this.identifier = identifier;
		this.type = description;
	}
	
	public String getID() {
		return identifier;
	}
	
	public String getType() {
		return type;
	}
	
	
}
