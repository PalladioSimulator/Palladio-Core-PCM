package de.uka.ipd.sdq.pipesandfilters.framework.recorder.sensorframework.strategies;

import de.uka.ipd.sdq.pipesandfilters.framework.MetaDataInit;
import de.uka.ipd.sdq.pipesandfilters.framework.PipeData;

public interface IWriteDataStrategy {

	public void initialise(MetaDataInit metaData);
	
	public void writeData(PipeData data);
	
}
