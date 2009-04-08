package de.uka.ipd.sdq.codegen.workflow;

import java.io.PrintStream;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.ui.console.ConsolePlugin;
import org.eclipse.ui.console.IConsole;
import org.eclipse.ui.console.MessageConsole;

/**
 * 
 * 
 * @author Steffen
 *
 */
public class UIBasedWorkflow extends Workflow {

	private PrintStream outStream;
	private PrintStream errStream;

	private static MessageConsole console = null;
	private static PrintStream myOutStream = null;
	
	public UIBasedWorkflow(IJob job, IProgressMonitor monitor, WorkflowExceptionHandler workflowExceptionHandler) {
		super(job, monitor, workflowExceptionHandler);
	}

	@Override
	public void run() {
		redirectIOStreamsForLogging();
		super.run();
		resetIOStreams();
	}
	
	private void resetIOStreams() {
		System.setOut(outStream);
		System.setErr(errStream);
	}

	private void redirectIOStreamsForLogging() {
		/* Redirect standard IO streams for tools run in the workflow which do not 
		 * support "real" logging.
		 */
		outStream = System.out;
		errStream = System.err;
		PrintStream consoleStream = getPrintStream();
		System.setOut(consoleStream);
		System.setErr(consoleStream);
	}
	
	private MessageConsole getConsole() {
		if (console == null) {
			console = new MessageConsole("SimuComController Generator Console",
					null);
			ConsolePlugin.getDefault().getConsoleManager().addConsoles(
					new IConsole[] { console });
		}
		console.activate();
		return console;
	}
	
	private PrintStream getPrintStream() {
		if (myOutStream == null) {
			MessageConsole console = getConsole();
			myOutStream = new PrintStream(console.newMessageStream());
		}
		return myOutStream;
	}	
}
