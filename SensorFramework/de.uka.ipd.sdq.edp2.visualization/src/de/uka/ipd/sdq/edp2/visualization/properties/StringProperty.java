package de.uka.ipd.sdq.edp2.visualization.properties;

import org.eclipse.ui.IMemento;

public class StringProperty extends AbstractProperty<String> {

	public StringProperty(String key, String value, String display, String description){
		setPropertyKey(key);
		setPropertyValue(value);
		setDisplayName(display);
		setDescription(description);
	}
	
	public StringProperty(String key, String value){
		new StringProperty(key,value,"","");
	}
	
	public StringProperty(String key){
		new StringProperty(key,"");
	}
	
	public StringProperty(){
		new StringProperty("");
	}
	
	@Override
	public PropertyTypeEnum getPropertyType() {
		return PropertyTypeEnum.STRING;
	}

	@Override
	public IProperty<String> restoreProperty(IMemento memento) {
		IMemento child = memento.getChild(getPropertyType().toString());
		setPropertyKey(child.getString(KEY));
		setPropertyValue(child.getString(VALUE));
		setDisplayName(child.getString(DISPLAY));
		setDescription(child.getString(DESCRIPTION));
		return this;
	}

	@Override
	public void saveState(IMemento memento) {
		IMemento child = memento.createChild(getPropertyType().toString());
		child.putString(KEY, getPropertyKey());
		child.putString(VALUE, getPropertyValue());
		child.putString(DISPLAY, getDescription());
		child.putString(DESCRIPTION, getDescription());
	}
	
}
