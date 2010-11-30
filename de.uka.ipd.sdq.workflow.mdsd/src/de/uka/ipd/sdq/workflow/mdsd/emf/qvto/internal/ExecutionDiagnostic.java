/*******************************************************************************
 * Copyright (c) 2009 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *   
 * Contributors:
 *     Borland Software Corporation - initial API and implementation
 *******************************************************************************/
package de.uka.ipd.sdq.workflow.mdsd.emf.qvto.internal;

//Copied from QVT-O Plugin to enable trace output
//Remove this in future QVT-O versions when there is a
//public API to retrieve the trace

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.m2m.internal.qvt.oml.evaluator.QvtRuntimeException;
import org.eclipse.m2m.qvt.oml.ExecutionStackTraceElement;

/**
 * A diagnostic class representing the result status of a transformation
 * execution.
 * 
 * @since 2.0
 * 
 * @noextend This class is not intended to be sub-classed by clients.
 */
public class ExecutionDiagnostic extends BasicDiagnostic {

	/**
	 * The execution was terminated by failed QVT assertion.
	 */
	public static final int FATAL_ASSERTION = 100;

	/**
	 * The execution received user interruption request
	 */
	public static final int USER_INTERRUPTED = 110;

	public static final int EXCEPTION_THROWN = 120;

	public static final int VALIDATION = 130;

	public static final int MODEL_PARAMETER_MISMATCH = 140;

	public static final int TRANSFORMATION_LOAD_FAILED = 200;

	public static final String SOURCE = "org.eclipse.m2m.qvt.oml.execution"; //$NON-NLS-1$

	static final ExecutionDiagnostic OK_INSTANCE = new ExecutionDiagnostic(
			Diagnostic.OK, 0, "OK", null); //$NON-NLS-1$

	// instance fields

	private List<ExecutionStackTraceElement> fStackTrace;

	protected ExecutionDiagnostic(int severity, int code, String message, Object[] data) {
		super(severity, SOURCE, code, message, data);
	}

	protected ExecutionDiagnostic(int severity, int code, String message) {
		super(severity, SOURCE, code, message, null);
	}

	protected void setStackTrace(List<? extends ExecutionStackTraceElement> stackElements) {
		fStackTrace = new ArrayList<ExecutionStackTraceElement>(stackElements);
	}

	/**
	 * Gets the stack trace that resulted from interrupted execution either by
	 * user termination request or exception thrown
	 * 
	 * @return list of trace elements or an empty list
	 */
	public List<ExecutionStackTraceElement> getStackTrace() {
		return fStackTrace != null ? Collections.unmodifiableList(fStackTrace)
				: Collections.<ExecutionStackTraceElement> emptyList();
	}

	/**
	 * Prints the execution stack-trace (if available) of this diagnostic to the
	 * specified print writer.
	 * 
	 * @param writer
	 *            <code>PrintWriter</code> to use for output
	 */
	public void printStackTrace(PrintWriter writer) {
		if (fStackTrace != null) {
			QvtRuntimeException.printQvtStackTrace(writer, fStackTrace);
		}
	}
}
