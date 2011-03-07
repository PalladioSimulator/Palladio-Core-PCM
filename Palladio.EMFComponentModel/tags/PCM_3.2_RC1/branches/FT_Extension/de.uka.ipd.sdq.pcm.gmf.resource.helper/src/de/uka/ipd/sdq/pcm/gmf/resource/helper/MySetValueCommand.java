package de.uka.ipd.sdq.pcm.gmf.resource.helper;

import org.eclipse.gmf.runtime.emf.type.core.commands.SetValueCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;

public class MySetValueCommand extends SetValueCommand {

	public MySetValueCommand(SetRequest request) {
		super(request);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public boolean canExecute() {
		return true;
	}

}
