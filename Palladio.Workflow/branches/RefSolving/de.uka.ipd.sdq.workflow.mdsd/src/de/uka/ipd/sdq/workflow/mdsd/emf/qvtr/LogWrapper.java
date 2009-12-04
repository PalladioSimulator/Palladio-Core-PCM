/**
 * 
 */
package de.uka.ipd.sdq.workflow.mdsd.emf.qvtr;


import org.apache.log4j.Logger;

import uk.ac.kent.cs.kmf.util.ILog;

/**
 * @author thomasS
 *
 */
public class LogWrapper implements ILog {

	private Logger logger=null;
	private int errors;
	private int warnings;
	
	/**
	 * 
	 */
	public LogWrapper(String loggerClass) {
		errors = 0;
		warnings = 0;
		logger = Logger.getLogger(loggerClass);
	}

	/* (non-Javadoc)
	 * @see uk.ac.kent.cs.kmf.util.ILog#close()
	 */
	@Override
	public void close() {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see uk.ac.kent.cs.kmf.util.ILog#finalReport()
	 */
	@Override
	public void finalReport() {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see uk.ac.kent.cs.kmf.util.ILog#getErrors()
	 */
	@Override
	public int getErrors() {
		return errors;
	}

	/* (non-Javadoc)
	 * @see uk.ac.kent.cs.kmf.util.ILog#getWarnings()
	 */
	@Override
	public int getWarnings() {
		return warnings;
	}

	/* (non-Javadoc)
	 * @see uk.ac.kent.cs.kmf.util.ILog#hasErrors()
	 */
	@Override
	public boolean hasErrors() {
		return errors > 0;
	}

	/* (non-Javadoc)
	 * @see uk.ac.kent.cs.kmf.util.ILog#hasViolations()
	 */
	@Override
	public boolean hasViolations() {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see uk.ac.kent.cs.kmf.util.ILog#hasWarnings()
	 */
	@Override
	public boolean hasWarnings() {
		return warnings > 0;
	}

	/* (non-Javadoc)
	 * @see uk.ac.kent.cs.kmf.util.ILog#printMessage(java.lang.String)
	 */
	@Override
	public void printMessage(String arg0) {
		logger.info(arg0);
	}

	/* (non-Javadoc)
	 * @see uk.ac.kent.cs.kmf.util.ILog#reportError(java.lang.String)
	 */
	@Override
	public void reportError(String arg0) {
		errors++;
		logger.error(arg0);
	}

	/* (non-Javadoc)
	 * @see uk.ac.kent.cs.kmf.util.ILog#reportError(java.lang.String, java.lang.Exception)
	 */
	@Override
	public void reportError(String arg0, Exception arg1) {
		errors++;
		logger.error(arg0, arg1);
	}

	/* (non-Javadoc)
	 * @see uk.ac.kent.cs.kmf.util.ILog#reportMessage(java.lang.String)
	 */
	@Override
	public void reportMessage(String arg0) {
		logger.info(arg0);
	}

	/* (non-Javadoc)
	 * @see uk.ac.kent.cs.kmf.util.ILog#reportWarning(java.lang.String)
	 */
	@Override
	public void reportWarning(String arg0) {
		warnings++;
		logger.warn(arg0);
	}

	/* (non-Javadoc)
	 * @see uk.ac.kent.cs.kmf.util.ILog#reportWarning(java.lang.String, java.lang.Exception)
	 */
	@Override
	public void reportWarning(String arg0, Exception arg1) {
		warnings++;
		logger.warn(arg0, arg1);
	}

	/* (non-Javadoc)
	 * @see uk.ac.kent.cs.kmf.util.ILog#reset()
	 */
	@Override
	public void reset() {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see uk.ac.kent.cs.kmf.util.ILog#resetErrors()
	 */
	@Override
	public void resetErrors() {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see uk.ac.kent.cs.kmf.util.ILog#resetViolations()
	 */
	@Override
	public void resetViolations() {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see uk.ac.kent.cs.kmf.util.ILog#resetWarnings()
	 */
	@Override
	public void resetWarnings() {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see uk.ac.kent.cs.kmf.util.ILog#tooManyViolations()
	 */
	@Override
	public boolean tooManyViolations() {
		// TODO Auto-generated method stub
		return false;
	}

}
