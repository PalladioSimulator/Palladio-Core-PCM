
		public class ResourceEnvironmentFactory {
		
			/* All resources are located on this machine, regardless of their resource container
			 * in the model */
			public static void setUpResources(){
				de.uka.ipd.sdq.measurement.strategies.activeresource.IDemandStrategy strategy = null;
		   		

		//active Resources of container _1zQooDglEeCFP6TiQB0B7A		
		
	if ("CPU".toLowerCase().contains("cpu")) {
	  strategy = new de.uka.ipd.sdq.measurement.strategies.activeresource.cpu.FibonacciDemand();
	  strategy.initializeStrategy(de.uka.ipd.sdq.measurement.strategies.activeresource.DegreeOfAccuracyEnum.MEDIUM,1);
	  de.uka.ipd.sdq.prototype.framework.strategies.DemandConsumerStrategiesRegistry.singleton()
	    .registerStrategyFor(de.uka.ipd.sdq.measurement.strategies.activeresource.ResourceTypeEnum.CPU, 
	    	strategy);
	} else if ("CPU".toLowerCase().contains("hdd")) { 
	  strategy = new de.uka.ipd.sdq.measurement.strategies.activeresource.hdd.ReadLargeChunksDemand("C://temp"); 
	  strategy.initializeStrategy(de.uka.ipd.sdq.measurement.strategies.activeresource.DegreeOfAccuracyEnum.MEDIUM,1);
	  de.uka.ipd.sdq.prototype.framework.strategies.DemandConsumerStrategiesRegistry.singleton()
	    .registerStrategyFor(de.uka.ipd.sdq.measurement.strategies.activeresource.ResourceTypeEnum.HDD, 
	    	strategy);
	}




 

		//active Resources of container _2kZKoDglEeCFP6TiQB0B7A		
		
	if ("CPU".toLowerCase().contains("cpu")) {
	  strategy = new de.uka.ipd.sdq.measurement.strategies.activeresource.cpu.FibonacciDemand();
	  strategy.initializeStrategy(de.uka.ipd.sdq.measurement.strategies.activeresource.DegreeOfAccuracyEnum.MEDIUM,1);
	  de.uka.ipd.sdq.prototype.framework.strategies.DemandConsumerStrategiesRegistry.singleton()
	    .registerStrategyFor(de.uka.ipd.sdq.measurement.strategies.activeresource.ResourceTypeEnum.CPU, 
	    	strategy);
	} else if ("CPU".toLowerCase().contains("hdd")) { 
	  strategy = new de.uka.ipd.sdq.measurement.strategies.activeresource.hdd.ReadLargeChunksDemand("C://temp"); 
	  strategy.initializeStrategy(de.uka.ipd.sdq.measurement.strategies.activeresource.DegreeOfAccuracyEnum.MEDIUM,1);
	  de.uka.ipd.sdq.prototype.framework.strategies.DemandConsumerStrategiesRegistry.singleton()
	    .registerStrategyFor(de.uka.ipd.sdq.measurement.strategies.activeresource.ResourceTypeEnum.HDD, 
	    	strategy);
	}




 

		//active Resources of container _3NmfsDglEeCFP6TiQB0B7A		
		
	if ("CPU".toLowerCase().contains("cpu")) {
	  strategy = new de.uka.ipd.sdq.measurement.strategies.activeresource.cpu.FibonacciDemand();
	  strategy.initializeStrategy(de.uka.ipd.sdq.measurement.strategies.activeresource.DegreeOfAccuracyEnum.MEDIUM,1);
	  de.uka.ipd.sdq.prototype.framework.strategies.DemandConsumerStrategiesRegistry.singleton()
	    .registerStrategyFor(de.uka.ipd.sdq.measurement.strategies.activeresource.ResourceTypeEnum.CPU, 
	    	strategy);
	} else if ("CPU".toLowerCase().contains("hdd")) { 
	  strategy = new de.uka.ipd.sdq.measurement.strategies.activeresource.hdd.ReadLargeChunksDemand("C://temp"); 
	  strategy.initializeStrategy(de.uka.ipd.sdq.measurement.strategies.activeresource.DegreeOfAccuracyEnum.MEDIUM,1);
	  de.uka.ipd.sdq.prototype.framework.strategies.DemandConsumerStrategiesRegistry.singleton()
	    .registerStrategyFor(de.uka.ipd.sdq.measurement.strategies.activeresource.ResourceTypeEnum.HDD, 
	    	strategy);
	}





			}
		}
	