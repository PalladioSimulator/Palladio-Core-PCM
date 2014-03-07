package de.uka.ipd.sdq.scheduler.resources.passive;

import java.util.ArrayList;
import java.util.List;

import de.uka.ipd.sdq.scheduler.IPassiveResource;
import de.uka.ipd.sdq.scheduler.ISchedulableProcess;
import de.uka.ipd.sdq.scheduler.sensors.IPassiveResourceSensor;

/**
 * Provides observer functionality to passive resources. Normally this
 * functionality would reside in an (abstract) super class, but for passive
 * resources there is no such class that all resources inherit.
 * 
 * @author Philipp Merkle
 * 
 */
public class PassiveResourceObservee {

	private final List<IPassiveResourceSensor> observers;

	public PassiveResourceObservee() {
		observers = new ArrayList<IPassiveResourceSensor>();
	}

	/**
	 * Notifies observers that the resource has been requested.
	 */
	public void fireRequest(ISchedulableProcess process, long num) {
		for (IPassiveResourceSensor o : observers) {
			o.request(process, num);
		}
	}
	
	/**
	 * Notifies observers that the resource has been acquired.
	 */
	public void fireAquire(ISchedulableProcess process, long num) {
		for (IPassiveResourceSensor o : observers) {
			o.acquire(process, num);
		}
	}

	/**
	 * Notifies observers that the resource has been released.
	 */
	public void fireRelease(ISchedulableProcess process, long num) {
		for (IPassiveResourceSensor o : observers) {
			o.release(process, num);
		}
	}

	/**
	 * @see IPassiveResource#addObserver(IPassiveResourceSensor)
	 */
	public void addObserver(IPassiveResourceSensor observer) {
		observers.add(observer);
	}

	/**
	 * @see IPassiveResource#removeObserver(IPassiveResourceSensor)
	 */
	public void removeObserver(IPassiveResourceSensor observer) {
		observers.remove(observer);
	}

}
