package de.uka.ipd.sdq.pcmsolver;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Device;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.console.IOConsoleOutputStream;
import org.eclipse.ui.console.IPatternMatchListener;
import org.eclipse.ui.console.MessageConsole;
import org.eclipse.ui.console.PatternMatchEvent;
import org.eclipse.ui.console.TextConsole;

public class PCMSolverPatternMatchListener implements IPatternMatchListener {

	MessageConsole myConsole;
	IOConsoleOutputStream stream;
	
	@Override
	public int getCompilerFlags() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getLineQualifier() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getPattern() {
		// TODO Auto-generated method stub
		return "INFO";
	}

	@Override
	public void connect(TextConsole console) {
		if (console instanceof MessageConsole) {
			myConsole = (MessageConsole)console;
			stream = myConsole.newOutputStream();
		}
			
	}

	@Override
	public void disconnect() {
		// TODO Auto-generated method stub

	}

	@Override
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
