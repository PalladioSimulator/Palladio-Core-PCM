package edu.kit.ipd.sdq.eventsim.command;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.log4j.Logger;

import edu.kit.ipd.sdq.simcomp.component.IPCMModel;

public class CountingPCMModelCommandExecutor extends PCMModelCommandExecutor {

	private static Logger logger = Logger.getLogger(CountingPCMModelCommandExecutor.class);
	
	@SuppressWarnings("rawtypes")
	private Map<Class<? extends ICommand>, Integer> counts;
	
	@SuppressWarnings("rawtypes")
	public CountingPCMModelCommandExecutor(IPCMModel pcm) {
		super(pcm);
		counts = new HashMap<Class<? extends ICommand>, Integer>();
	}

	@Override
	public <T> T execute(ICommand<T, IPCMModel> command) {
		Integer c = counts.get(command.getClass());
		if(c == null) {
			c = 0;
		}
		c++;
		counts.put(command.getClass(), c);
		return super.execute(command);
	}

	@SuppressWarnings("rawtypes")
	public void printStatistics() {
		for(Entry<Class<? extends ICommand>, Integer> entry : counts.entrySet()) {
			if(logger.isDebugEnabled()) {
				String commandName = entry.getKey().getName();
				Integer callFrequency = entry.getValue();
				logger.debug(commandName + ": " + callFrequency);
			}
		}
	}
	
}
