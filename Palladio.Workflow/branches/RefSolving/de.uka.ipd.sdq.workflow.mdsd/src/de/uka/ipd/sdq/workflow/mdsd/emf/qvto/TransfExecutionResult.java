package de.uka.ipd.sdq.workflow.mdsd.emf.qvto;

import java.io.IOException;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.m2m.internal.qvt.oml.common.MdaException;
import org.eclipse.m2m.internal.qvt.oml.common.io.eclipse.EclipseFile;
import org.eclipse.m2m.internal.qvt.oml.emf.util.WorkspaceUtils;
import org.eclipse.m2m.internal.qvt.oml.runtime.generator.TraceSerializer;
import org.eclipse.m2m.internal.qvt.oml.trace.Trace;

@SuppressWarnings("restriction")
public class TransfExecutionResult {
	String outConsole;
	Trace outTrace;
	List<EObject> outMainParams;
	List<IModelTransfTarget> outModels;

	public TransfExecutionResult(String outConsole, Trace outTrace, List<EObject> outMailParams, List<IModelTransfTarget> outModels) {
		this.outConsole = (outConsole==null ? "" : outConsole);
		this.outTrace = outTrace;
		this.outMainParams = outMailParams;
		this.outModels = outModels;
	}
	public List<IModelTransfTarget> getOutModels() {
		return outModels;
	}
	public List<EObject> getOutParameters() {
		return outMainParams;
	}
	public String getConsoleOutput() {
		return outConsole;
	}
	public boolean saveTrace(URI traceUri) throws IOException {
			if(traceUri == null || outTrace == null)
				return false;
			IFile traceFile = traceUri != null ? WorkspaceUtils.getWorkspaceFile(traceUri) : null;
			if(traceFile == null)
				return false;
			TraceSerializer traceSerializer = new TraceSerializer(outTrace);
			try {
				traceSerializer.saveTraceModel(new EclipseFile(traceFile));
			} catch (MdaException e) {
				throw new IOException("The trace saving is failed ("+traceUri.toString()+")", e);
			}
			try {
				traceSerializer.markUnboundObjects(traceFile);
			} catch (CoreException e) {
			}
			return true;					
	}
}