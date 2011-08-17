package de.uka.ipd.sdq.pipesandfilters.framework.test;

import de.uka.ipd.sdq.pipesandfilters.framework.MetaDataInit;
import de.uka.ipd.sdq.pipesandfilters.framework.PipeData;
import de.uka.ipd.sdq.pipesandfilters.framework.recorder.IRawWriteStrategy;

/**
 * This dummy class is supposed to be used in test cases in order to test
 * recorders, avoiding data storage every time the test case is performed.
 * 
 * @author Baum
 */
public class DummyRawWriteStrategy implements IRawWriteStrategy {

	private MetaDataInit lastArrivedMetaDataInit;
	private PipeData lastArrivedPipeData;

	@Override
	public void flush() {
	}

	@Override
	public void initialize(MetaDataInit metaData) {
		lastArrivedMetaDataInit = metaData;
	}

	@Override
	public void writeData(PipeData data) {
		lastArrivedPipeData = data;
	}

	/**
	 * Returns the last MetaDataInit object that has arrived. Supposed to be
	 * used for test cases only.
	 * 
	 * @return The last MetaDataInit object that has arrived.
	 */
	public MetaDataInit getLastArrivedMetaDataInit() {
		return lastArrivedMetaDataInit;
	}

	/**
	 * Returns the last PipeData object that has arrived. Supposed to be used
	 * for test cases only.
	 * 
	 * @return The last PipeData object that has arrived.
	 */
	public PipeData getLastArrivedPipeData() {
		return lastArrivedPipeData;
	}
}
