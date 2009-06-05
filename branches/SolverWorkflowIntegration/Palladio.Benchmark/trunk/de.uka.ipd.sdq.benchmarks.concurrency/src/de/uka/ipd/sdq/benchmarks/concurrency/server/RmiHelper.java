package de.uka.ipd.sdq.benchmarks.concurrency.server;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import de.uka.ipd.sdq.benchmarks.concurrency.behaviours.BehaviourWrapper;
import de.uka.ipd.sdq.benchmarks.concurrency.behaviours.IBehaviourStrategy;
import de.uka.ipd.sdq.benchmarks.measurements.MeasurementHolder;
import de.uka.ipd.sdq.sensorframework.util.ExperimentManager;

public class RmiHelper {

	public static void bindBehaviour(IBehaviourStrategy strategy) {
		if (System.getSecurityManager() == null) {
			System.setSecurityManager(new SecurityManager());
		}

		try {
			IBehaviourStrategy stub = (IBehaviourStrategy) UnicastRemoteObject
					.exportObject(strategy, 0);
			Naming.rebind(strategy.getName(), stub);
			System.out.println("Behaviour " + strategy.getName() + " bound.");
		} catch (Exception e) {
			System.err.println("Exception during binding:");
			e.printStackTrace();
			System.exit(-1);
		}
	}

	public static BehaviourWrapper lookUpAndReset(String name) {
		IBehaviourStrategy stub = null;
		try {
			Registry registry = LocateRegistry.getRegistry("localhost");
			stub = (IBehaviourStrategy) registry.lookup(name);
			stub.reset();
		} catch (Exception e) {
			System.err.println("Exception during lookup:");
			e.printStackTrace();
			System.exit(-1);

		}
		return new BehaviourWrapper(stub);
	}

	public static void store(String prefix, BehaviourWrapper b, ExperimentManager m) {
		List<MeasurementHolder> mhList = b.getResults();
		for (MeasurementHolder mh : mhList) {
			mh.store(prefix + mh.name + ".meas");
		}
	}
	
	
	public static void store(BehaviourWrapper b, ExperimentManager m) {
		List<MeasurementHolder> mhList = b.getResults();
		for (MeasurementHolder mh : mhList) {
			int max = mh.pos.get(); 
			System.out.println(mh.name + ": " + mh.pos.get());
			for (int i = 0; i < max; i++) {
				m.storeTimeSpan(b.getName() + " " + mh.name, mh.startTimes[i],
						mh.stopTimes[i]);
			}
		}
	}

}
