package de.uka.ipd.sdq.sensorframework.visualisation.dialogs;

import org.eclipse.core.runtime.IConfigurationElement;

import de.uka.ipd.sdq.sensorframework.adapter.IAdapterFactory;

public class ViewAndAdapterFactory {

	private IConfigurationElement view;
	private IAdapterFactory factory;
	public IConfigurationElement getView() {
		return view;
	}
	public IAdapterFactory getFactory() {
		return factory;
	}
	public ViewAndAdapterFactory(IConfigurationElement view,
			IAdapterFactory factory) {
		super();
		this.view = view;
		this.factory = factory;
	}
	
}
