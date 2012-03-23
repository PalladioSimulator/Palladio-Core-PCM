package de.uka.ipd.sdq.edp2.visualization.properties;

import org.eclipse.jface.viewers.CellLabelProvider;
import org.eclipse.jface.viewers.ViewerCell;

public class PropertyCellLabelProvider<T> extends CellLabelProvider {
	
	private String key;
	private Class<?> type;
	
	public PropertyCellLabelProvider(String key, Class<?> type){
		this.key = key;
		this.type = type;
	}
	
	@Override
	public void update(ViewerCell cell) {
		T content = (T) cell.getElement();
		

	}

}
