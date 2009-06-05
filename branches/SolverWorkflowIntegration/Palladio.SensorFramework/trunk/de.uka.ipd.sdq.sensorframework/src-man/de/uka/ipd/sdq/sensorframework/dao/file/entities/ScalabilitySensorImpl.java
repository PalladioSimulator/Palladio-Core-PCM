package de.uka.ipd.sdq.sensorframework.dao.file.entities;

import de.uka.ipd.sdq.sensorframework.dao.file.FileDAOFactory;
import de.uka.ipd.sdq.sensorframework.entities.ScalabilitySensor;
/**
 * @author Ihssane El-Oudghiri 
 */
public class ScalabilitySensorImpl extends SensorImpl implements ScalabilitySensor{

    private static final long serialVersionUID = 7666935674459276065L;
    
    private int nbParameters;
    
    public ScalabilitySensorImpl(final FileDAOFactory factory) {
	super(factory);
    }
    
    

    @Override
    public boolean equals(final Object obj) {
	if (!(obj instanceof ScalabilitySensorImpl)) {
	    return false;
	}
	ScalabilitySensorImpl s = (ScalabilitySensorImpl) obj;
	if (!(sensorID == s.getSensorID() && sensorName.equals(s
		.getSensorName()))) {
	    return false;
	}
	return true;
    }

	public int getNbParams() {
		return nbParameters;
	}
	
	public void serializeChildren() {
		// Nothing to serialize here
	}
}


