package de.uka.ipd.sdq.jvmbenchmark2model.actions;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;

import de.uka.ipd.sdq.jvmbenchmark2model.LoggingManager;
import de.uka.ipd.sdq.jvmbenchmark2model.pcm.JvmBenchmark2ModelRepository;

/**
 * The handler as defined by {@link AbstractHandler} by Eclipse.
 */
public class GenerateJVMComponentHandler extends AbstractHandler {
	
	/* (non-Javadoc)
	 * @see org.eclipse.core.commands.AbstractHandler#execute(org.eclipse.core.commands.ExecutionEvent)
	 */
	@Override
	public Object execute(ExecutionEvent arg0) throws ExecutionException {
		initializeLogging();
		JvmBenchmark2ModelRepository jvmBenchmark2ModelRepository = new JvmBenchmark2ModelRepository();
		jvmBenchmark2ModelRepository.createJvmComponent("TestJvmComponent");

		// As of 2007-05-06, this is mandatory
		return null;
	}

	/**
	 * Initializes the logging system of the plug-in. Must be called before any
	 * logging call is done!
	 * <p>
	 * It takes the user selection as parameter to find out the project name, in
	 * order to place the log file into the project directory.
	 * </p>
	 * 
	 * @param selection the user selection
	 */
	private void initializeLogging() {
		LoggingManager.initializeLogging();
	}

	
}
