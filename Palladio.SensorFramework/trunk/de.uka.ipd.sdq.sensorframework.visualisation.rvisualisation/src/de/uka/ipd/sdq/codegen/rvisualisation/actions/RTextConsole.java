package de.uka.ipd.sdq.codegen.rvisualisation.actions;

import java.awt.FileDialog;
import java.awt.Frame;

import org.rosuda.JRI.RMainLoopCallbacks;
import org.rosuda.JRI.Rengine;

public class RTextConsole implements RMainLoopCallbacks {

	protected String myTextOutput = "";
	protected String outputHistory = "";

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

	@SuppressWarnings("deprecation")
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

	public void rWriteConsole(Rengine arg0, String message, int arg2) {
		outputHistory += message;
	}
}
