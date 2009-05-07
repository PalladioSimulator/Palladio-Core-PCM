package de.uka.ipd.sdq.sensorframework.visualisation.rvisualisation.utils;

import java.util.Vector;

import org.apache.log4j.Logger;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.rosuda.JRI.REXP;
import org.rosuda.JRI.Rengine;

import de.uka.ipd.sdq.sensorframework.visualisation.rvisualisation.RVisualisationPlugin;

/**Encapsulate the access to the R engine.
 * Is responsible for the initialization of the R engine and the execution
 * of R commands.
 * @author groenda
 */
public class RConnection {
	/** The logger used by this class. */
	private static Logger logger = 
		Logger.getLogger(RConnection.class.getName());

	/** The text console of the connected R engine. */
	private static RTextConsole rConsole = new RTextConsole();
	/** The R engine that is used by this class. */
	private static Rengine rengine = null;
	/** Global connection to the R engine. */
	private static RConnection rConnection = null;

	static {
		rConnection = new RConnection();
	}
	
	/**Initializes the connection to the R engine.
	 */
	public RConnection() {
		initalizeConnection();
	}

	/**Initializes the connection to a R engine.
	 */
	protected void initalizeConnection() {
		if (rConnection != null) {
			return;
		}
		
		checkPathValidity();

		// initialize connection
		try {
			System.loadLibrary("jri");
		} catch (UnsatisfiedLinkError ule) {
			RVisualisationPlugin.log(
					IStatus.ERROR,
					"Could not load the dynamic link libaries that are "
					+ "necessary to connect the sensorframework " 
					+ " to R 2.6. The JRI provided with this package is "
					+ "designed for R 2.6.1, check the detailed " 
					+ "error message if a version conflict may have occured."
					+ "Ensure jri.dll is within the java.library.path "
					+ "variable and R's bin directory is on the system "
					+ "path. Details: java.library.path=" 
					+ System.getProperty("java.library.path")
					+ ";errorMessage=" + ule.getMessage());
			new MessageDialog(
					PlatformUI.getWorkbench().getActiveWorkbenchWindow()
					.getShell(),
					"Error loading R",
					null,
					"Could not load R 2.6. You need to install the correct "
					+ "Version of R on your machine. Put R's binary "
					+ "folder into your system path, so the dynamic link "
					+ "libraries can be found. "
					+ "Check the error log for a detailed message.",
					MessageDialog.ERROR, new String[] { "OK" }, 0).open();
			return;
		}

		// just making sure we have the right version of everything
		if (!Rengine.versionCheck()) {
			RVisualisationPlugin
			.log(
					IStatus.ERROR,
					"Creating R engine ** Version mismatch - Java files don't "
					+ "match library version.");
			new MessageDialog(
					PlatformUI.getWorkbench().getActiveWorkbenchWindow()
					.getShell(),
					"Error loading R",
					null,
					"Could not load R. The version of the java files and the "
					+ "library versions dont match.",
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
					"Creating R engine ** Waiting for the R engine to come up "
					+ "failed.");
			new MessageDialog(
					PlatformUI.getWorkbench()
					.getActiveWorkbenchWindow().getShell(),
					"Error loading R",
					null,
					"Could not load R. The R engine didn't come up in time.",
					MessageDialog.ERROR, new String[] { "OK" }, 0).open();
			rengine = null;
			return;
		}
		
		RVisualisationPlugin.log(IStatus.INFO, "Connection to R established "
				+ "successfully.");
		prepareEnvironment();
		checkPackageAvailability();
	}

	/**Checks the availability of the package with the given name in R.
	 * If it is not available an error message is logged and displayed.
	 * @param packageName The name of the R package.
	 */
	private void checkPackageAvailability(final String packageName) {
		String previousMessage = getLastConsoleMessage();
		rengine.eval("library(" + packageName + ")");
		String result = getLastConsoleMessage();
		if (!previousMessage.equals(result)) {
			RVisualisationPlugin
			.log(
					IStatus.ERROR,
					"Library \"" + packageName + "\" is not available. Please "
					+ "install the \"" + packageName + "\" package in your R "
					+ "installation.\n Error details: " + result + "\n"
					+ "Possible Solution: \n"
					+ "If you are using Windows Vista check if the package is "
					+ "in the installation path of R and not in the user path."
					+ "This can be achieved by executing the R command "
					+ "\"library\".");
			//Get the ActiveWorkbenchWindow to send the error message to or handle it of there is none. 
			IWorkbenchWindow wbw = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
			if (wbw != null){
				new MessageDialog(
						wbw.getShell(),
						"Library \"" + packageName + "\" is not available in R",
						null,
						"The library \"" + packageName + "\" is not available. "
						+ "Please install the \"" + packageName + "\" package in "
						+ "your R installation or"
						+ " the R reports will not work properly. Check the PDE "
						+ "error log for more information.",
						MessageDialog.ERROR, new String[] { "OK" }, 0).open();
			} 
		}
	}

	/**Checks the availability of all necessary packages.
	 * If some are not available an error message is logged.
	 */
	private void checkPackageAvailability() {
		checkPackageAvailability("plotrix");
	}

	/**Checks if the java.library.path is valid for system.loadLibrary().
	 */
	private void checkPathValidity() {
		String libraryPath = System.getProperty("java.library.path");
		String[] libraryPaths = libraryPath.split(";");
		Vector<String> conflictingPaths = new Vector<String>();
		for (String path : libraryPaths) {
			if (path.contains(" ") && !path.startsWith("\"") 
					&& !path.endsWith("\"")) {
				conflictingPaths.add(path);
			}
		}
		if (!conflictingPaths.isEmpty()) {
			String formattedPath = "";
			for (String conflictPath : conflictingPaths) {
				formattedPath += "'" + conflictPath + "', ";
			}
			// cut last ", "
			formattedPath = 
				formattedPath.substring(0, formattedPath.length() - 2); 
			RVisualisationPlugin.log(
					IStatus.WARNING,
					"The environment variable java.library.path contains "
					+ " unescaped spaces. This may lead to errors loading "
					+ "the necessary dynamic link libraries of R.\n\n"
					+ "Conflicting parts of the java.library.path are: " 
					+ formattedPath + "\n\n"
					+ "A possible solution is to set the library path to"
					+ " point to the path containing jri.dll via the -D"
					+ " command line switch of the java VM of by setting"
					+ " it via the eclipse.ini file. However, this does"
					+ " not work in all cases.");
		}
	}

	/**This method is used to prepare the R environment. Additionally,
	 * Information about the R environment is gathered and logged with 
	 * level debug.
	 */
	private void prepareEnvironment() {
		rengine.eval("Sys.setlocale(\"LC_ALL\", \"German_Germany.1252\")");
		rengine.eval("Sys.setlocale(\"LC_NUMERIC\", \"C\")");
		rengine.eval("rUser <- chartr(\"\\\\\", \"/\", "
				+ "Sys.getenv(\"R_USER\"))");
		rengine.eval("rLibs <- chartr(\"\\\\\", \"/\", "
				+ "Sys.getenv(\"R_LIBS_USER\"))");
		rengine.eval("homedrive <- chartr(\"\\\\\", \"/\", "
				+ "Sys.getenv(\"HOMEDRIVE\"))");
		rengine.eval("homepath <- chartr(\"\\\\\", \"/\", "
				+ "Sys.getenv(\"HOMEPATH\"))");
		rengine.eval("usrLibPath <- substring(strsplit(rLibs, "
				+ "rUser)[[1]][2],2)");
		rengine.eval("Sys.setenv(\"R_USER\"=paste(homedrive, homepath, "
				+ "sep=\"\"))");
		rengine.eval("Sys.setenv(\"R_LIBS_USER\"=paste(Sys.getenv(\"R_USER\"), "
				+ "usrLibPath, sep=\"\")[[1]])");

		REXP envContent = rengine.eval("Sys.getenv()");
		REXP envNames = rengine.eval("names(s <- Sys.getenv())");
		String[] sEnvContent = envContent.asStringArray();
		String[] sEnvNames = envNames.asStringArray();
		String locale = "";
		for (int number = 0; number < sEnvContent.length; number++) {
			locale += sEnvNames[number] + " = " + sEnvContent[number] + "\n";
		}
		REXP locales = rengine.eval("Sys.getlocale()");
		String[] sLocales = locales.asStringArray();
		locale += "\nLocalization information:\n";
		for (int number = 0; number < sLocales.length; number++) {
			locale += sLocales[number] + "\n";
		}

		logger.debug("Environmental Information:\n" 
				+ locale);
		// MessageBox needed, as PDE log only allows few characters.
//		new MessageDialog(
//				PlatformUI.getWorkbench()
//				.getActiveWorkbenchWindow().getShell(),
//				"Environmental Information",
//				null,
//				locale,
//				MessageDialog.INFORMATION, new String[] { "OK" }, 0).open();
	}

	/**Executes the command(s) in R.
	 * @param rCommands One or more valid commands in R, separated by 
	 *        <code>\n</code>.
	 * @return result Result returned from R. Empty if no result was returned.
	 */
	public Vector<REXP> execute(final String rCommands) {
		if (!isEngineAvailable()) {
			throw new UnsupportedOperationException(
					"Tried to execute command in R without having a R engine"
					+ " available.");
		}
		
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
	
	/**Stores an array in a R variable.
	 * @param name Name of the R variable in which the array is stored.
	 * @param array Array to store in an R variable.
	 */
	public void assign(final String name, final double[] array) {
		rengine.assign(name, array);
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
