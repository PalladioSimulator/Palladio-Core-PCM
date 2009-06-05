package de.uka.ipd.sdq.benchmarks.concurrency.workload;

import java.util.concurrent.ThreadFactory;

public class PriorityThreadFactory implements ThreadFactory {

	private int prio;

	public PriorityThreadFactory(int prio) {
		super();
		this.prio = prio;
	}

	@Override
	public Thread newThread(Runnable r) {
		Thread t = new Thread(r);
		t.setPriority(prio);
		return t;
	}

}
