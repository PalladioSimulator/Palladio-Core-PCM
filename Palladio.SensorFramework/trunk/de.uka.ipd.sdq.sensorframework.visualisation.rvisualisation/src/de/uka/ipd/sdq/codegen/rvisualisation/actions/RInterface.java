package de.uka.ipd.sdq.codegen.rvisualisation.actions;

import java.awt.FileDialog;
import java.awt.Frame;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.ui.PlatformUI;
import org.rosuda.JRI.REXP;
import org.rosuda.JRI.RMainLoopCallbacks;
import org.rosuda.JRI.Rengine;

import de.uka.ipd.sdq.codegen.rvisualisation.RVisualisationPlugin;

class TextConsole implements RMainLoopCallbacks {
	protected String myTextOutput = "";

	public void rWriteConsole(Rengine re, String text) {
		myTextOutput += text + "\n";
	}

	public void rBusy(Rengine re, int which) {
		// System.out.println("rBusy(" + which + ")");
	}

	public String rReadConsole(Rengine re, String prompt, int addToHistory) {
		return null;
	}

	public void rShowMessage(Rengine re, String message) {
		myTextOutput += message + "\n";
	}

	public String rChooseFile(Rengine re, int newFile) {
		FileDialog fd = new FileDialog(new Frame(),
				(newFile == 0) ? "Select a file" : "Select a new file",
				(newFile == 0) ? FileDialog.LOAD : FileDialog.SAVE);
		fd.show();
		String res = null;
		if (fd.getDirectory() != null)
			res = fd.getDirectory();
		if (fd.getFile() != null)
			res = (res == null) ? fd.getFile() : (res + fd.getFile());
		return res;
	}

	public void rFlushConsole(Rengine re) {
	}

	public void rLoadHistory(Rengine re, String filename) {
	}

	public void rSaveHistory(Rengine re, String filename) {
	}

	public String getText() {
		return myTextOutput;
	}

	public void rWriteConsole(Rengine arg0, String arg1, int arg2) {
		// TODO Auto-generated method stub
		
	}
}

public class RInterface {

	private static TextConsole myConsole = new TextConsole();
	private static Rengine re = null;
	private static boolean engineAvailable = false;

	static {
		try {
			System.loadLibrary("jri");
			// just making sure we have the right version of everything
			if (!Rengine.versionCheck()) {
				RVisualisationPlugin
						.log(
								IStatus.ERROR,
								"Creating Rengine ** Version mismatch - Java files don't match library version.");
				new MessageDialog(
						PlatformUI.getWorkbench().getActiveWorkbenchWindow()
								.getShell(),
						"Error loading R",
						null,
						"Could not load R. You need to install R including rJava on your machine. Put R's binary "
								+ "folder into your system path. Add jri.jar to the java classpath",
						MessageDialog.ERROR, new String[] { "OK" }, 0).open();
			} else {
				RVisualisationPlugin.log(IStatus.INFO,
						"Creating Rengine (with arguments)");

				// 1) we pass the arguments from the command line
				// 2) we won't use the main loop at first, we'll start it later
				// (that's the "false" as second argument)
				// 3) the callbacks are implemented by the TextConsole class
				// above
				re = new Rengine(new String[] {}, false, myConsole);

				// the engine creates R is a new thread, so we should wait until
				// it's
				// ready
				if (!re.waitForR()) {
					RVisualisationPlugin
							.log(
									IStatus.ERROR,
									"Creating Rengine ** Version mismatch - Java files don't match library version.");
					new MessageDialog(
							PlatformUI.getWorkbench()
									.getActiveWorkbenchWindow().getShell(),
							"Error loading R",
							null,
							"Could not load R. You need to install R including rJava on your machine. Put R's binary "
									+ "folder into your system path. Add jri.dll to the java library path",
							MessageDialog.ERROR, new String[] { "OK" }, 0).open();
				}
				engineAvailable = true;
			}
		} catch (UnsatisfiedLinkError e) {
			RVisualisationPlugin
					.log(
							IStatus.ERROR,
							"No jri.dll found or R not loadable. Ensure jri.dll is in java.library.path variable part of the JVM and " +
							"R is on the system path.");
			new MessageDialog(
					PlatformUI.getWorkbench().getActiveWorkbenchWindow()
							.getShell(),
					"Error loading R",
					null,
					"Could not load R. You need to install R including rJava on your machine. Put R's binary "
							+ "folder into your system path. Ensure jri.dll is in java.library.path variable of the JVM.",
					MessageDialog.ERROR, new String[] { "OK" }, 0).open();
		}
	}

	private REXP lastResult;

	public String getRawTextualResult() {
		return myConsole.getText();
	}

	public String execute(String rCommands) {
		String[] commands = rCommands.split("\n");
		String result = "";
		REXP x;

		for (String command : commands) {
			x = re.eval(command);
			if (x != null) {
				result += x.toString() + "\n";
				lastResult = x;
			}
		}

		return result;
	}

	public REXP getLastResult() {
		return lastResult;
	}

	public static boolean isEngineAvailable() {
		return engineAvailable;
	}
}
