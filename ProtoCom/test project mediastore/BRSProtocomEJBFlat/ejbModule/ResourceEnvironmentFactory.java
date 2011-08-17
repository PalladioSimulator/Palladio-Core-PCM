
		public class ResourceEnvironmentFactory {
		
			/* All resources are located on this machine, regardless of their resource container
			 * in the model */
			public static void setUpResources(){
				de.uka.ipd.sdq.measurement.strategies.activeresource.IDemandStrategy strategy = null;
		   		

				double cpuProcessingRate = 12.13911009;
				
		//active Resources of container _8-cpgNo_EdyxgfK4Hy_RFA		
		
	if ("CPU".toLowerCase().contains("cpu")) {
	  strategy = new de.uka.ipd.sdq.measurement.strategies.activeresource.cpu.FibonacciDemand();
	  strategy.initializeStrategy(de.uka.ipd.sdq.measurement.strategies.activeresource.DegreeOfAccuracyEnum.MEDIUM,cpuProcessingRate);
	  de.uka.ipd.sdq.prototype.framework.strategies.DemandConsumerStrategiesRegistry.singleton()
	    .registerStrategyFor(de.uka.ipd.sdq.measurement.strategies.activeresource.ResourceTypeEnum.CPU, 
	    	strategy);
	} else if ("CPU".toLowerCase().contains("hdd")) { 
	  strategy = new de.uka.ipd.sdq.measurement.strategies.activeresource.hdd.ReadLargeChunksDemand("C://temp//files-for-hdd"); 
	  strategy.initializeStrategy(de.uka.ipd.sdq.measurement.strategies.activeresource.DegreeOfAccuracyEnum.MEDIUM,10.0);
	  de.uka.ipd.sdq.prototype.framework.strategies.DemandConsumerStrategiesRegistry.singleton()
	    .registerStrategyFor(de.uka.ipd.sdq.measurement.strategies.activeresource.ResourceTypeEnum.HDD, 
	    	strategy);
	}




 

		//active Resources of container _EX6xcdpAEdyxgfK4Hy_RFA		
		
	if ("CPU".toLowerCase().contains("cpu")) {
	  strategy = new de.uka.ipd.sdq.measurement.strategies.activeresource.cpu.FibonacciDemand();
	  strategy.initializeStrategy(de.uka.ipd.sdq.measurement.strategies.activeresource.DegreeOfAccuracyEnum.MEDIUM,cpuProcessingRate);
	  de.uka.ipd.sdq.prototype.framework.strategies.DemandConsumerStrategiesRegistry.singleton()
	    .registerStrategyFor(de.uka.ipd.sdq.measurement.strategies.activeresource.ResourceTypeEnum.CPU, 
	    	strategy);
	} else if ("CPU".toLowerCase().contains("hdd")) { 
	  strategy = new de.uka.ipd.sdq.measurement.strategies.activeresource.hdd.ReadLargeChunksDemand("C://temp"); 
	  strategy.initializeStrategy(de.uka.ipd.sdq.measurement.strategies.activeresource.DegreeOfAccuracyEnum.MEDIUM,10.0);
	  de.uka.ipd.sdq.prototype.framework.strategies.DemandConsumerStrategiesRegistry.singleton()
	    .registerStrategyFor(de.uka.ipd.sdq.measurement.strategies.activeresource.ResourceTypeEnum.HDD, 
	    	strategy);
	}




 

		//active Resources of container _U2Nv4dpAEdyxgfK4Hy_RFA		
		
	if ("CPU".toLowerCase().contains("cpu")) {
	  strategy = new de.uka.ipd.sdq.measurement.strategies.activeresource.cpu.FibonacciDemand();
	  strategy.initializeStrategy(de.uka.ipd.sdq.measurement.strategies.activeresource.DegreeOfAccuracyEnum.MEDIUM,cpuProcessingRate);
	  de.uka.ipd.sdq.prototype.framework.strategies.DemandConsumerStrategiesRegistry.singleton()
	    .registerStrategyFor(de.uka.ipd.sdq.measurement.strategies.activeresource.ResourceTypeEnum.CPU, 
	    	strategy);
	} else if ("CPU".toLowerCase().contains("hdd")) { 
	  strategy = new de.uka.ipd.sdq.measurement.strategies.activeresource.hdd.ReadLargeChunksDemand("C://temp"); 
	  strategy.initializeStrategy(de.uka.ipd.sdq.measurement.strategies.activeresource.DegreeOfAccuracyEnum.MEDIUM,10.0);
	  de.uka.ipd.sdq.prototype.framework.strategies.DemandConsumerStrategiesRegistry.singleton()
	    .registerStrategyFor(de.uka.ipd.sdq.measurement.strategies.activeresource.ResourceTypeEnum.HDD, 
	    	strategy);
	}




 

		//active Resources of container _L0Dy4dpAEdyxgfK4Hy_RFA		
		
	if ("CPU".toLowerCase().contains("cpu")) {
	  strategy = new de.uka.ipd.sdq.measurement.strategies.activeresource.cpu.FibonacciDemand();
	  strategy.initializeStrategy(de.uka.ipd.sdq.measurement.strategies.activeresource.DegreeOfAccuracyEnum.MEDIUM,cpuProcessingRate);
	  de.uka.ipd.sdq.prototype.framework.strategies.DemandConsumerStrategiesRegistry.singleton()
	    .registerStrategyFor(de.uka.ipd.sdq.measurement.strategies.activeresource.ResourceTypeEnum.CPU, 
	    	strategy);
	} else if ("CPU".toLowerCase().contains("hdd")) { 
	  strategy = new de.uka.ipd.sdq.measurement.strategies.activeresource.hdd.ReadLargeChunksDemand("C://temp"); 
	  strategy.initializeStrategy(de.uka.ipd.sdq.measurement.strategies.activeresource.DegreeOfAccuracyEnum.MEDIUM,10.0);
	  de.uka.ipd.sdq.prototype.framework.strategies.DemandConsumerStrategiesRegistry.singleton()
	    .registerStrategyFor(de.uka.ipd.sdq.measurement.strategies.activeresource.ResourceTypeEnum.HDD, 
	    	strategy);
	}




 

		//active Resources of container _IwYkwSYYEd-qOJxMJOMJYA		
		
	if ("CPU".toLowerCase().contains("cpu")) {
	  strategy = new de.uka.ipd.sdq.measurement.strategies.activeresource.cpu.FibonacciDemand();
	  strategy.initializeStrategy(de.uka.ipd.sdq.measurement.strategies.activeresource.DegreeOfAccuracyEnum.MEDIUM,cpuProcessingRate);
	  de.uka.ipd.sdq.prototype.framework.strategies.DemandConsumerStrategiesRegistry.singleton()
	    .registerStrategyFor(de.uka.ipd.sdq.measurement.strategies.activeresource.ResourceTypeEnum.CPU, 
	    	strategy);
	} else if ("CPU".toLowerCase().contains("hdd")) { 
	  strategy = new de.uka.ipd.sdq.measurement.strategies.activeresource.hdd.ReadLargeChunksDemand("C://temp"); 
	  strategy.initializeStrategy(de.uka.ipd.sdq.measurement.strategies.activeresource.DegreeOfAccuracyEnum.MEDIUM,10);
	  de.uka.ipd.sdq.prototype.framework.strategies.DemandConsumerStrategiesRegistry.singleton()
	    .registerStrategyFor(de.uka.ipd.sdq.measurement.strategies.activeresource.ResourceTypeEnum.HDD, 
	    	strategy);
	}




 

		//active Resources of container _PQNu8SYYEd-qOJxMJOMJYA		
		
	if ("CPU".toLowerCase().contains("cpu")) {
	  strategy = new de.uka.ipd.sdq.measurement.strategies.activeresource.cpu.FibonacciDemand();
	  strategy.initializeStrategy(de.uka.ipd.sdq.measurement.strategies.activeresource.DegreeOfAccuracyEnum.MEDIUM,cpuProcessingRate);
	  de.uka.ipd.sdq.prototype.framework.strategies.DemandConsumerStrategiesRegistry.singleton()
	    .registerStrategyFor(de.uka.ipd.sdq.measurement.strategies.activeresource.ResourceTypeEnum.CPU, 
	    	strategy);
	} else if ("CPU".toLowerCase().contains("hdd")) { 
	  strategy = new de.uka.ipd.sdq.measurement.strategies.activeresource.hdd.ReadLargeChunksDemand("C://temp"); 
	  strategy.initializeStrategy(de.uka.ipd.sdq.measurement.strategies.activeresource.DegreeOfAccuracyEnum.MEDIUM,10);
	  de.uka.ipd.sdq.prototype.framework.strategies.DemandConsumerStrategiesRegistry.singleton()
	    .registerStrategyFor(de.uka.ipd.sdq.measurement.strategies.activeresource.ResourceTypeEnum.HDD, 
	    	strategy);
	}




 

		//active Resources of container _PwyscSYYEd-qOJxMJOMJYA		
		
	if ("CPU".toLowerCase().contains("cpu")) {
	  strategy = new de.uka.ipd.sdq.measurement.strategies.activeresource.cpu.FibonacciDemand();
	  strategy.initializeStrategy(de.uka.ipd.sdq.measurement.strategies.activeresource.DegreeOfAccuracyEnum.MEDIUM,cpuProcessingRate);
	  de.uka.ipd.sdq.prototype.framework.strategies.DemandConsumerStrategiesRegistry.singleton()
	    .registerStrategyFor(de.uka.ipd.sdq.measurement.strategies.activeresource.ResourceTypeEnum.CPU, 
	    	strategy);
	} else if ("CPU".toLowerCase().contains("hdd")) { 
	  strategy = new de.uka.ipd.sdq.measurement.strategies.activeresource.hdd.ReadLargeChunksDemand("C://temp"); 
	  strategy.initializeStrategy(de.uka.ipd.sdq.measurement.strategies.activeresource.DegreeOfAccuracyEnum.MEDIUM,10);
	  de.uka.ipd.sdq.prototype.framework.strategies.DemandConsumerStrategiesRegistry.singleton()
	    .registerStrategyFor(de.uka.ipd.sdq.measurement.strategies.activeresource.ResourceTypeEnum.HDD, 
	    	strategy);
	}




 

		//active Resources of container _QEbaISYYEd-qOJxMJOMJYA		
		
	if ("CPU".toLowerCase().contains("cpu")) {
	  strategy = new de.uka.ipd.sdq.measurement.strategies.activeresource.cpu.FibonacciDemand();
	  strategy.initializeStrategy(de.uka.ipd.sdq.measurement.strategies.activeresource.DegreeOfAccuracyEnum.MEDIUM,cpuProcessingRate);
	  de.uka.ipd.sdq.prototype.framework.strategies.DemandConsumerStrategiesRegistry.singleton()
	    .registerStrategyFor(de.uka.ipd.sdq.measurement.strategies.activeresource.ResourceTypeEnum.CPU, 
	    	strategy);
	} else if ("CPU".toLowerCase().contains("hdd")) { 
	  strategy = new de.uka.ipd.sdq.measurement.strategies.activeresource.hdd.ReadLargeChunksDemand("C://temp"); 
	  strategy.initializeStrategy(de.uka.ipd.sdq.measurement.strategies.activeresource.DegreeOfAccuracyEnum.MEDIUM,10);
	  de.uka.ipd.sdq.prototype.framework.strategies.DemandConsumerStrategiesRegistry.singleton()
	    .registerStrategyFor(de.uka.ipd.sdq.measurement.strategies.activeresource.ResourceTypeEnum.HDD, 
	    	strategy);
	}




 

		//active Resources of container _QgPzcSYYEd-qOJxMJOMJYA		
		
	if ("CPU".toLowerCase().contains("cpu")) {
	  strategy = new de.uka.ipd.sdq.measurement.strategies.activeresource.cpu.FibonacciDemand();
	  strategy.initializeStrategy(de.uka.ipd.sdq.measurement.strategies.activeresource.DegreeOfAccuracyEnum.MEDIUM,cpuProcessingRate);
	  de.uka.ipd.sdq.prototype.framework.strategies.DemandConsumerStrategiesRegistry.singleton()
	    .registerStrategyFor(de.uka.ipd.sdq.measurement.strategies.activeresource.ResourceTypeEnum.CPU, 
	    	strategy);
	} else if ("CPU".toLowerCase().contains("hdd")) { 
	  strategy = new de.uka.ipd.sdq.measurement.strategies.activeresource.hdd.ReadLargeChunksDemand("C://temp"); 
	  strategy.initializeStrategy(de.uka.ipd.sdq.measurement.strategies.activeresource.DegreeOfAccuracyEnum.MEDIUM,10);
	  de.uka.ipd.sdq.prototype.framework.strategies.DemandConsumerStrategiesRegistry.singleton()
	    .registerStrategyFor(de.uka.ipd.sdq.measurement.strategies.activeresource.ResourceTypeEnum.HDD, 
	    	strategy);
	}





			}
		}
	