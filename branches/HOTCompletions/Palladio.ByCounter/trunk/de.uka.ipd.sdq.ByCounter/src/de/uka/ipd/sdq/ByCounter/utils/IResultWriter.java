package de.uka.ipd.sdq.ByCounter.utils;

import de.uka.ipd.sdq.ByCounter.execution.CountingResult;

/**
 * TODO document
 * @author Martin Krogmann
 * @author Michael Kuperberg
 * @since 0.1
 * @version 1.1
 */
public interface IResultWriter {
	/**
	 * @param cr
	 * @return timestamp that is part of the file name
	 */
	public long writeResult(CountingResult cr);
}
