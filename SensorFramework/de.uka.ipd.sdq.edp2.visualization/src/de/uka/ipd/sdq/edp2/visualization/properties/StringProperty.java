package de.uka.ipd.sdq.edp2.visualization.properties;

import org.eclipse.ui.IMemento;

public class StringProperty extends AbstractProperty<String> {

	@Override
	public PropertyTypeEnum getPropertyType() {
		return PropertyTypeEnum.STRING;
	}

	@Override
	public IProperty<String> restoreProperty(IMemento memento) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveState(IMemento memento) {
		// TODO Auto-generated method stub
		
	}
	
}
