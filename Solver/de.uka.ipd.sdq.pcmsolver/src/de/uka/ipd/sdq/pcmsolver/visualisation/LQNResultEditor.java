package de.uka.ipd.sdq.pcmsolver.visualisation;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.browser.Browser;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.part.EditorPart;
import org.eclipse.ui.part.FileEditorInput;

public class LQNResultEditor extends EditorPart {

	@Override
	public void doSave(IProgressMonitor monitor) {
		// TODO Auto-generated method stub

	}

	@Override
	public void doSaveAs() {
		// TODO Auto-generated method stub

	}

	@Override
	public void init(IEditorSite site, IEditorInput input)
			throws PartInitException {
		setSite(site); 
		setInput(input);
	}

	@Override
	public boolean isDirty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isSaveAsAllowed() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void createPartControl(Composite parent) {
		IEditorInput input = getEditorInput();

		Browser browser = new Browser(parent, SWT.BORDER);
		browser.setJavascriptEnabled(true);
		if (input != null) {
			if (input instanceof LQNResultEditorInput) {
				// display HTML code in browser
				browser.setText(((LQNResultEditorInput) input).getHtmlCode());
				
			} else {
				// see if we can extract HTML code from the given input
				String fileContent = getFileContent(input);
				if (fileContent.trim().startsWith("<html>")) {
					// assume we have an HTML file and try to display it
					browser.setText(fileContent);
				} else {
					browser.setText("<html><head><title>Markov Results</title></head>"
							+ "<body><font color=\"red\">Error:"
							+ " The given editor input could not be handled.</font>"
							+ "</body></html>");
				}
			}
		}
	}

	private String getFileContent(IEditorInput input) {
		StringBuilder fileContent = null;
		if (input instanceof FileEditorInput) {
			FileEditorInput fileEditorInput = (FileEditorInput) input;
			try {
				FileReader fileReader = new FileReader(fileEditorInput.getPath().toOSString());
				BufferedReader in = new BufferedReader(fileReader);
				String line = null;
				fileContent = new StringBuilder();
				String newLine = System.getProperty("line.separator");
				try {
					while ((line = in.readLine()) != null) {
						fileContent.append(line);
						fileContent.append(newLine);
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}
		return fileContent.toString();
	}

	@Override
	public void setFocus() {
		// TODO Auto-generated method stub

	}

}
