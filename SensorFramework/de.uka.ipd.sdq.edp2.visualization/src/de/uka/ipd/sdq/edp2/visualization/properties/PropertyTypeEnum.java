package de.uka.ipd.sdq.edp2.visualization.properties;

import org.eclipse.jface.viewers.CellEditor;

public enum PropertyTypeEnum {
	INT, DOUBLE, STRING, BOOLEAN, COLOR;

	static CellEditor getCellEditorForPropertyType(PropertyTypeEnum type) {
		switch (type) {
		case INT:
			return null;
		case DOUBLE:
			return null;
		case BOOLEAN:
			return null;
		case COLOR:
			return null;
		default:
			return null;

		}
	}
}
