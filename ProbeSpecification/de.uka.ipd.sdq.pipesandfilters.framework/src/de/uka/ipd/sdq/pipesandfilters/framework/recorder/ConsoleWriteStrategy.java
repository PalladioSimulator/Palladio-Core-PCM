package de.uka.ipd.sdq.pipesandfilters.framework.recorder;

import de.uka.ipd.sdq.pipesandfilters.framework.MetaDataInit;
import de.uka.ipd.sdq.pipesandfilters.framework.PipeData;

public class ConsoleWriteStrategy implements IRawWriteStrategy {

	@Override
	public void flush() {
		// do nothing
	}

	@Override
	public void initialize(MetaDataInit metaData) {
//		System.out.println("Initialize WriteStrategy: " + metaData.)
	}

	@Override
	public void writeData(PipeData data) {
		String out = "";
		for (int i = 0; i<data.getTupleSize(); i++) {
			out += data.getTupleElement(i).toString() + "\t";
		}
		System.out.println(out);
	}

}
