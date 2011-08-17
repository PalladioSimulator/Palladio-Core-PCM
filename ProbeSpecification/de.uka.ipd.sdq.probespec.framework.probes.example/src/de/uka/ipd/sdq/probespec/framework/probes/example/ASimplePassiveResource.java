package de.uka.ipd.sdq.probespec.framework.probes.example;

public abstract class ASimplePassiveResource {

	private int size;
	
	private int free;
	
	public ASimplePassiveResource(int size) {
		this.size = size;
		this.free = size;
	}
	
	public void acquire() {
		--free;
	}
	
	public void release() {
		++free;
	}
	
	public boolean canAcquire() {
		return free > 0;
	}

	public int getSize() {
		return size;
	}

	public int getFree() {
		return free;
	}
	
}
