package de.uka.ipd.sdq.simucomframework.calculator;

import de.uka.ipd.sdq.pipesandfilters.framework.MetaDataInit;
import de.uka.ipd.sdq.probespec.framework.calculator.Calculator;

public interface ISetupDataSinkStrategy {

	public void setupDataSink(Calculator calculator,
			MetaDataInit metaData);
	
}
