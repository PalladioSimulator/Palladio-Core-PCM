package de.uka.ipd.sdq.capra.simulator.resources.scheduling.old;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import de.uka.ipd.sdq.capra.simulator.resources.scheduling.IJobManager;
import de.uka.ipd.sdq.capra.simulator.resources.scheduling.impl.PreemptiveJob;

public class SynchronousTimeProgressionJobManager implements IJobManager {

	List<PreemptiveJob> jobList;
	
	public SynchronousTimeProgressionJobManager() {
		super();
		jobList = new ArrayList<PreemptiveJob>();
	}

	@Override
	public void addJob(PreemptiveJob job) {
		jobList.add(job);

	}

	@Override
	public void notifyCompletion(PreemptiveJob job) {
		jobList.remove(job);
	}

	@Override
	public int getNumberOfJobs() {
		return jobList.size();
	}

	@Override
	public Iterator<PreemptiveJob> iterator() {
		return jobList.iterator();
	}
}
