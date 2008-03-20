package de.uka.ipd.sdq.codegen.rvisualisation.actions;

import java.util.Vector;

import org.apache.log4j.Logger;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.ui.PlatformUI;
import org.rosuda.JRI.REXP;
import org.rosuda.JRI.Rengine;

import de.uka.ipd.sdq.codegen.rvisualisation.RVisualisationPlugin;

public class RConnection {
	protected static Logger logger = Logger.getLogger(RConnection.class.getName());

	private static RTextConsole rConsole = new RTextConsole();
	private static Rengine rengine = null;
	private static RConnection rConnection = null;

	static {
		rConnection = new RConnection();
	}
	/**Constructs
	 * 
	 */
	public RConnection() {
		initalizeConnection();
	}

	/**Initializes the connection to a R engine.
	 */
	protected void initalizeConnection() {
		if (rConnection != null)
			return;
		
		checkPathValidity();

		// initialize connection
		try {
			System.loadLibrary("jri");
		} catch (UnsatisfiedLinkError ule) {
			RVisualisationPlugin.log(
					IStatus.ERROR,
					"Could not load the dynamic link libaries that are necessary to connect the sensorframework " + 
					" to R 2.6. The JRI provided with this package is designed for R 2.6.1, check the detailed " +
					"error message if a version conflict may have occured. Ensure jri.dll is within the java.library.path variable and " +
					"R's bin directory is on the system path. Details: java.library.path=" + System.getProperty("java.library.path") +
					";errorMessage=" + ule.getMessage());
			new MessageDialog(
					PlatformUI.getWorkbench().getActiveWorkbenchWindow()
					.getShell(),
					"Error loading R",
					null,
					"Could not load R 2.6. You need to install the correct Version of R on your machine. Put R's binary "
					+ "folder into your system path, so the dynamic link libraries can be found. " +
					"Check the error log for a detailed message.",
					MessageDialog.ERROR, new String[] { "OK" }, 0).open();
			return;
		}

		// just making sure we have the right version of everything
		if (!Rengine.versionCheck()) {
			RVisualisationPlugin
			.log(
					IStatus.ERROR,
					"Creating R engine ** Version mismatch - Java files don't match library version.");
			new MessageDialog(
					PlatformUI.getWorkbench().getActiveWorkbenchWindow()
					.getShell(),
					"Error loading R",
					null,
					"Could not load R. The version of the java files and the library versions dont match.",
					MessageDialog.ERROR, new String[] { "OK" }, 0).open();
			return;
		}
		
		// 1) we pass the arguments from the command line
		// 2) we won't use the main loop at first, we'll start it later
		// (that's the "false" as second argument)
		// 3) the callbacks are implemented by the TextConsole class
		// above
		rengine = new Rengine(new String[] {}, false, rConsole);

		// the engine creates R is a new thread, so we should wait until
		// it's ready
		if (!rengine.waitForR()) {
			RVisualisationPlugin
			.log(
					IStatus.ERROR,
					"Creating R engine ** Waiting for the R engine to come up failed.");
			new MessageDialog(
					PlatformUI.getWorkbench()
					.getActiveWorkbenchWindow().getShell(),
					"Error loading R",
					null,
					"Could not load R. The R engine dind't come up in time.",
					MessageDialog.ERROR, new String[] { "OK" }, 0).open();
			rengine = null;
			return;
		}
		
		RVisualisationPlugin.log(IStatus.INFO, "Connection to R established successfully.");
		logEnvironmentalInformation();
	}

	/**Checks if the java.library.path is valid for system.loadLibrary().
	 */
	private void checkPathValidity() {
		String libraryPath = System.getProperty("java.library.path");
		String libraryPaths[] = libraryPath.split(";");
		for (String path : libraryPaths) {
			if (path.contains(" ") && !path.startsWith("\"") && !path.endsWith("\""))
				RVisualisationPlugin.log(
					IStatus.WARNING,
					"The environment variable java.library.path contains unescaped spaced. " +
					"This may lead to errors loading the necessary dynamic link libraries of R. " +
					"Details: java.library.path=" + libraryPath);
		}
	}

	/**This method is used for debugging purposes. Information about the R environment is
	 * gathered and logged with level debug.
	 */
	private void logEnvironmentalInformation() {
		REXP result = rengine.eval("Sys.localeconv()");
		RVisualisationPlugin.log(
				IStatus.WARNING,
				"RInterface::debugEnvironemnt() Localization Information:\n" + 
				result.toString());
		logger.debug("RInterface::debugEnvironemnt() Localization Information:\n" + 
				result.toString());
	}

	/**Executes the command(s) in R.
	 * @param rCommands One or more valid commands in R, separated by <code>\n</code>.
	 * @return result Result returned from R. Empty if no result was returned.
	 */
	public Vector<REXP> execute(String rCommands) {
		if (!isEngineAvailable())
			throw new UnsupportedOperationException("Tried to execute command in R without having a R engine available.");
		
		String[] commands = rCommands.split("\n");
		String result = "";
		REXP resultExp;
		Vector<REXP> resultExpArray = new Vector<REXP>();

		for (String command : commands) {
			resultExp = rengine.eval(command);
			if (resultExp != null) {
				result += resultExp.toString() + "\n";
				resultExpArray.add(resultExp);
			}
		}

		return resultExpArray;
	}

	/**checks if an R engine could be found and the connection is established.
	 * @return <code>true</code> if the connection is established.
	 */
	public static boolean isEngineAvailable() {
		return !(rengine == null);
	}

	/**
	 * @return returns the current RConnection.
	 */
	public static RConnection getRConnection() {
		return rConnection;
	}
	
	/**
	 * @return the last message on the console of the connected R engine.
	 */
	public String getLastConsoleMessage() {
		return rConsole.getLastMessage();
		
	}
}
