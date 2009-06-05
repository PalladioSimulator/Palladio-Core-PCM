package de.uka.ipd.sdq.ByCounter.utils;

import de.uka.ipd.sdq.ByCounter.execution.CountingResult;

/**
 * @author Martin Krogmann
 * @author Michael Kuperberg
 * @since 0.1
 * @version 0.9
 */
public interface IResultWriter {
	public void writeResult(CountingResult cr);
}
