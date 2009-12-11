package de.uka.ipd.sdq.workflow.mdsd.emf.qvto.internal;

import org.apache.log4j.Logger;
import org.eclipse.m2m.qvt.oml.util.Log;

public class QVTOLogger implements Log {
	private static final Logger logger = Logger.getLogger(QVTOLogger.class);
	
	@Override
	public void log(String message) {
		this.log(1, message, null);
	}

	@Override
	public void log(int level, String message) {
		this.log(level, message, null);
	}

	@Override
	public void log(String message, Object param) {
		this.log(1, message, param);
	}

	@Override
	public void log(int level, String message, Object param) {
		String paramToString = param == null ? "" : " <"+param+">";
		logger.info(message+paramToString);
	}

}
