package de.uka.ipd.sdq.pcmsolver;

import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.console.IOConsoleOutputStream;
import org.eclipse.ui.console.IPatternMatchListener;
import org.eclipse.ui.console.MessageConsole;
import org.eclipse.ui.console.PatternMatchEvent;
import org.eclipse.ui.console.TextConsole;

public class PCMSolverPatternMatchListener implements IPatternMatchListener {

	MessageConsole myConsole;
	IOConsoleOutputStream stream;
	
	public int getCompilerFlags() {
		// TODO Auto-generated method stub
		return 0;
	}

	public String getLineQualifier() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getPattern() {
		// TODO Auto-generated method stub
		return "INFO";
	}

	public void connect(TextConsole console) {
		if (console instanceof MessageConsole) {
			myConsole = (MessageConsole)console;
			stream = myConsole.newOutputStream();
		}
			
	}

	public void disconnect() {
		// TODO Auto-generated method stub

	}

	public void matchFound(PatternMatchEvent event) {
		stream.setColor(new org.eclipse.swt.graphics.Color(Display.getCurrent(), 0, 255, 0));

	}

	public IOConsoleOutputStream getStream() {
		return stream;
	}

	public void setStream(IOConsoleOutputStream stream) {
		this.stream = stream;
	}

}
