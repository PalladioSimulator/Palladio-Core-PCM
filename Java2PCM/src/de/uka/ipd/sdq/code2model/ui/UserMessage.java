/**
 * User interface specific classes.
 */
package de.uka.ipd.sdq.code2model.ui;

import org.apache.log4j.Logger;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Shell;

import de.uka.ipd.sdq.code2model.Activator;

/**
 * Provides convenience methods to display dialogs, including formatting of
 * exceptions. Only a shell has to be provided.
 * 
 * @author thomas
 */
public class UserMessage {
	
	private static Logger logger = Logger.getLogger("UserMessage");
	private static boolean bindingProblemsMessageDisplayed = false;
	private static String bindingProblemsMessage = "A binding could not be resolved.  " +
			"This likely means that your project has errors in the build path.  " +
			"The analysis will continue, but will probably not function correctly.";
	
	private static Shell getShell() {
		Shell shell = null;
		try {
			shell = Activator.getDefault().getWorkbench()
					.getActiveWorkbenchWindow().getShell();
		} catch (NullPointerException e) {
			logger.error("No shell available!");
		}
		return shell;
	}

	/**
	 * Inform the user about an exception.
	 * 
	 * @param t
	 *            the exception
	 */
	public static void displayException(Throwable t) {
		displayErrorMessage( formatException(t) );
	}

	/**
	 * Format an exception message and stack trace for nice output on screen.
	 * 
	 * @param t
	 *            the exception
	 * @return the formatted output
	 */
	private static String formatException(Throwable t) {
		String trace = "Trace: \n";
		StackTraceElement[] traceArray = t.getStackTrace();
		for (int i = 0; i < traceArray.length; i++) {
			trace += "    " + traceArray[i].toString() + "\n";
			if (i == 25) {
				trace += "[...]\n";
				break;
			}
		}

		String output = t + "\n\n" + trace;
		return output;
	}

	/**
	 * Display an error message.
	 * 
	 * @param message
	 *            the message to display
	 */
	public static void displayErrorMessage(String message) {
		Shell shell = getShell();
		if (shell != null) {
			MessageDialog.openError(shell, "Error", message);
		}
		logger.error("Error Message: " + message);
	}
	
	/**
	 * Display a default error message about problems with resolving bindings.
	 * It is displayed only once, client code does not have to check.
	 */
	public static void displayBindingProblemsMessage() {
		if (bindingProblemsMessageDisplayed) {
			return;
		}
		displayErrorMessage(bindingProblemsMessage);
		bindingProblemsMessageDisplayed = true;
	}

}
