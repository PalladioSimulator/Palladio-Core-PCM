package de.uka.ipd.sdq.simulation.command;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import de.uka.ipd.sdq.simulation.PCMModel;

public class CountingPCMModelCommandExecutor extends PCMModelCommandExecutor {

	@SuppressWarnings("unchecked")
	private Map<Class<? extends ICommand>, Integer> counts;
	
	@SuppressWarnings("unchecked")
	public CountingPCMModelCommandExecutor(PCMModel pcm) {
		super(pcm);
		counts = new HashMap<Class<? extends ICommand>, Integer>();
	}

	@Override
	public <T> T execute(ICommand<T, PCMModel> command) {
		Integer c = counts.get(command.getClass());
		if(c == null) {
			c = 0;
		}
		c++;
		counts.put(command.getClass(), c);
		return super.execute(command);
	}

	@SuppressWarnings("unchecked")
	public void printStatistics() {
		for(Entry<Class<? extends ICommand>, Integer> entry : counts.entrySet()) {
			String commandName = entry.getKey().getName();
			Integer callFrequency = entry.getValue();
			System.out.println(commandName + ": " + callFrequency);
		}
	}
	
}
