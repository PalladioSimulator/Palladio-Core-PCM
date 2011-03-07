package de.uka.ipd.sdq.sensorframework.entities.impl;

import de.uka.ipd.sdq.sensorframework.entities.dao.IDAOFactory;

@javax.persistence.Entity
public class ScalabilitySensorImpl extends de.uka.ipd.sdq.sensorframework.entities.base.AbstractScalabilitySensor {

	public ScalabilitySensorImpl(IDAOFactory myFactory) {
		super(myFactory);
	}
	
	public int getNbParams() {
		return 1;
	}
}
