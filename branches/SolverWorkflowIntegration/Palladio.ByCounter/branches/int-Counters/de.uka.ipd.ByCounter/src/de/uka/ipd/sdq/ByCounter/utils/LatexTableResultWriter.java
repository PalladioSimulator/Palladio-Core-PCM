package de.uka.ipd.sdq.ByCounter.utils;

import org.apache.log4j.Logger;

import de.uka.ipd.sdq.ByCounter.execution.CountingResult;

/**
 * @author Martin Krogmann
 * @author Michael Kuperberg
 * @since 0.1
 * @version 0.9
 */
public class LatexTableResultWriter implements IResultWriter {

	/**
	 * see http://en.wikipedia.org/wiki/Data_log
	 */
	@SuppressWarnings("unused")
	private Logger log = Logger.getLogger(this.getClass().getCanonicalName());
	
	@Override
	public void writeResult(CountingResult cr) {
//		@SuppressWarnings("unused")
//		StringBuffer opcodes_texSB = new StringBuffer(); 	//for LaTeX tables
//		@SuppressWarnings("unused")
//		StringBuffer opnames_texSB = new StringBuffer();	//for LaTeX tables
//		@SuppressWarnings("unused")
//		StringBuffer opcounts_texSB = new StringBuffer();	//for LaTeX tables
//		@SuppressWarnings("unused")
//		StringBuffer instrnames_texSB = new StringBuffer();	//for LaTeX tables
//		@SuppressWarnings("unused")
//		StringBuffer instrcounts_texSB = new StringBuffer();//for LaTeX tables
//
//
	}

}
