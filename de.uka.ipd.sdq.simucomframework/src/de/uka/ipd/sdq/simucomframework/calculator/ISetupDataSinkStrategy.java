package de.uka.ipd.sdq.simucomframework.calculator;

import de.uka.ipd.sdq.pipesandfilters.framework.MetaDataInit;
import de.uka.ipd.sdq.pipesandfilters.framework.recorder.Recorder;
import de.uka.ipd.sdq.probespec.framework.calculator.Calculator;

interface ISetupDataSinkStrategy {

	public Recorder setupDataSink(Calculator calculator,
			MetaDataInit metaData);
	
}
