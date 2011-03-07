package de.uka.ipd.sdq.tcfmoop.tcmanager;

import de.uka.ipd.sdq.tcfmoop.outputtree.Tree;

public interface IOutputChangedListener {

	/**
	 * Logic witch should be executed when the Termination Criteria Manager updates the output tree.
	 * @param instance of the output tree.
	 */
	public void handleOutputChangedEvent(Tree outPut);
	
}
