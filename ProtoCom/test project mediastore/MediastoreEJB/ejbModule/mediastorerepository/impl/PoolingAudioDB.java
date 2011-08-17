
	   
	

	   package mediastorerepository.impl;
	      
	   
public class PoolingAudioDB

	   

	   implements mediastorerepository.impl.IPoolingAudioDB
	   {
	   	  
 
	      
	
    

   	
    protected mediastorerepository.impl.ports.IAudioDB_PoolingAudioDB m_portProvided_IAudioDB_PoolingAudioDB = new mediastorerepository.impl.ports.IAudioDB_PoolingAudioDB(this);

   	
   public mediastorerepository.IAudioDB getPortProvided_IAudioDB_PoolingAudioDB () {
      return m_portProvided_IAudioDB_PoolingAudioDB;
   }


	      
   
   

   
   

   
   protected mediastorerepository.impl.contexts.IPoolingAudioDBContext myContext = null;

   
   public void setContext(mediastorerepository.impl.contexts.IPoolingAudioDBContext myContext) {
      this.myContext = myContext;
      
   }


	      
	
   public 
	
   de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object>

      iAudioDB_queryDB0
         (
	de.uka.ipd.sdq.simucomframework.variables.StackContext ctx
)

   { 
      /*PROTECTED REGION ID(queryDB0__q2UeYCAiEdyB2fTIEA4hbA__yNjKgBpXEdyxqpPYxT_m3w) START*/
   	  
   	  	
	      
   
	
	
		de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object> resultStackFrame = 
			new de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object>();
		de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object> methodBodyStackFrame = 
			ctx.getStack().currentStackFrame();
		if (this.myDefaultComponentStackFrame.getContents().size() > 0) {
			methodBodyStackFrame.addVariables(this.myDefaultComponentStackFrame);
		}
		if (this.myComponentStackFrame.getContents().size() > 0) {
			methodBodyStackFrame.addVariables(this.myComponentStackFrame);
		}
	


   
      
   
	
	// Aquire de.uka.ipd.sdq.pcm.repository.impl.PassiveResourceImpl@3a4246 (id: _BcM9k1E5Ed2iLYgaJYxY7w) (entityName: dbConnectionPool)
	// TODO: Implement code to get the resource


   
      
   
	
   for (int iterationCount_PqqnYFE5Ed2iLYgaJYxY7w = 0, maxIterationCount_PqqnYFE5Ed2iLYgaJYxY7w = (Integer)ctx.evaluate("ids.NUMBER_OF_ELEMENTS",Integer.class); 
            iterationCount_PqqnYFE5Ed2iLYgaJYxY7w < maxIterationCount_PqqnYFE5Ed2iLYgaJYxY7w; iterationCount_PqqnYFE5Ed2iLYgaJYxY7w++){
       
   
	
	


   
      
   
	
	
	
   {
      double demand = (Double) ctx.evaluate("1",Double.class);
      // TODO: Consume different resource types actively
      try {
		//Thread.sleep((long) (demand * 1000));
		//TODO: Erstmal nur CPU, sonst hier unterscheiden!
		String neededResource = "CPU";
		
		if (neededResource.toLowerCase().contains("cpu")){
		  de.uka.ipd.sdq.prototype.framework.strategies.DemandConsumerStrategiesRegistry.singleton()
		    .getStrategyFor(de.uka.ipd.sdq.measurement.strategies.activeresource.ResourceTypeEnum.CPU).consume(demand);
		} 
		else if (neededResource.toLowerCase().contains("hdd")){
		  de.uka.ipd.sdq.prototype.framework.strategies.DemandConsumerStrategiesRegistry.singleton()
		    .getStrategyFor(de.uka.ipd.sdq.measurement.strategies.activeresource.ResourceTypeEnum.HDD).consume(demand);
		} else {
			throw new java.lang.UnsupportedOperationException("Resourcetype not yet supported in prototype");
		}
	  } catch (Exception e) {
		e.printStackTrace();
		System.exit(-1);
	  }
   }




   
      
   
	
	
	
   {
      double demand = (Double) ctx.evaluate("fileSize.BYTESIZE",Double.class);
      // TODO: Consume different resource types actively
      try {
		//Thread.sleep((long) (demand * 1000));
		//TODO: Erstmal nur CPU, sonst hier unterscheiden!
		String neededResource = "HDD";
		
		if (neededResource.toLowerCase().contains("cpu")){
		  de.uka.ipd.sdq.prototype.framework.strategies.DemandConsumerStrategiesRegistry.singleton()
		    .getStrategyFor(de.uka.ipd.sdq.measurement.strategies.activeresource.ResourceTypeEnum.CPU).consume(demand);
		} 
		else if (neededResource.toLowerCase().contains("hdd")){
		  de.uka.ipd.sdq.prototype.framework.strategies.DemandConsumerStrategiesRegistry.singleton()
		    .getStrategyFor(de.uka.ipd.sdq.measurement.strategies.activeresource.ResourceTypeEnum.HDD).consume(demand);
		} else {
			throw new java.lang.UnsupportedOperationException("Resourcetype not yet supported in prototype");
		}
	  } catch (Exception e) {
		e.printStackTrace();
		System.exit(-1);
	  }
   }




   
      
   
	
	


   

   

   

   

   } 


   
      
   
	
	
		
			
				resultStackFrame.addValue("RETURN.NUMBER_OF_ELEMENTS",
					ctx.evaluate("ids.NUMBER_OF_ELEMENTS"));
			
		
	
		
			
				resultStackFrame.addValue("RETURN.INNER.BYTESIZE",
				   	new de.uka.ipd.sdq.simucomframework.variables.EvaluationProxy("fileSize.BYTESIZE",methodBodyStackFrame.copyFrame()));
			
		
	


   
      
   
	
	// Release de.uka.ipd.sdq.pcm.repository.impl.PassiveResourceImpl@3a4246 (id: _BcM9k1E5Ed2iLYgaJYxY7w) (entityName: dbConnectionPool)
	// TODO: Implement code to release the resource


   
      
   
	
	
	return resultStackFrame;
	


   

   

   

   

   

   
      
    	
   	  
   	  /*PROTECTED REGION END*/
   }   

   public 
	
   de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object>

      iAudioDB_addFile1
         (
	de.uka.ipd.sdq.simucomframework.variables.StackContext ctx
)

   { 
      /*PROTECTED REGION ID(addFile1__q2UeYCAiEdyB2fTIEA4hbA__yNjKgBpXEdyxqpPYxT_m3w) START*/
   	  
   	  	
	      
   
	
	
		de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object> resultStackFrame = 
			new de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object>();
		de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object> methodBodyStackFrame = 
			ctx.getStack().currentStackFrame();
		if (this.myDefaultComponentStackFrame.getContents().size() > 0) {
			methodBodyStackFrame.addVariables(this.myDefaultComponentStackFrame);
		}
		if (this.myComponentStackFrame.getContents().size() > 0) {
			methodBodyStackFrame.addVariables(this.myComponentStackFrame);
		}
	


   
      
   
	
	// Aquire de.uka.ipd.sdq.pcm.repository.impl.PassiveResourceImpl@3a4246 (id: _BcM9k1E5Ed2iLYgaJYxY7w) (entityName: dbConnectionPool)
	// TODO: Implement code to get the resource


   
      
   
	
	
	
   {
      double demand = (Double) ctx.evaluate("5",Double.class);
      // TODO: Consume different resource types actively
      try {
		//Thread.sleep((long) (demand * 1000));
		//TODO: Erstmal nur CPU, sonst hier unterscheiden!
		String neededResource = "CPU";
		
		if (neededResource.toLowerCase().contains("cpu")){
		  de.uka.ipd.sdq.prototype.framework.strategies.DemandConsumerStrategiesRegistry.singleton()
		    .getStrategyFor(de.uka.ipd.sdq.measurement.strategies.activeresource.ResourceTypeEnum.CPU).consume(demand);
		} 
		else if (neededResource.toLowerCase().contains("hdd")){
		  de.uka.ipd.sdq.prototype.framework.strategies.DemandConsumerStrategiesRegistry.singleton()
		    .getStrategyFor(de.uka.ipd.sdq.measurement.strategies.activeresource.ResourceTypeEnum.HDD).consume(demand);
		} else {
			throw new java.lang.UnsupportedOperationException("Resourcetype not yet supported in prototype");
		}
	  } catch (Exception e) {
		e.printStackTrace();
		System.exit(-1);
	  }
   }




   
      
   
	
	
	
   {
      double demand = (Double) ctx.evaluate("file.BYTESIZE",Double.class);
      // TODO: Consume different resource types actively
      try {
		//Thread.sleep((long) (demand * 1000));
		//TODO: Erstmal nur CPU, sonst hier unterscheiden!
		String neededResource = "HDD";
		
		if (neededResource.toLowerCase().contains("cpu")){
		  de.uka.ipd.sdq.prototype.framework.strategies.DemandConsumerStrategiesRegistry.singleton()
		    .getStrategyFor(de.uka.ipd.sdq.measurement.strategies.activeresource.ResourceTypeEnum.CPU).consume(demand);
		} 
		else if (neededResource.toLowerCase().contains("hdd")){
		  de.uka.ipd.sdq.prototype.framework.strategies.DemandConsumerStrategiesRegistry.singleton()
		    .getStrategyFor(de.uka.ipd.sdq.measurement.strategies.activeresource.ResourceTypeEnum.HDD).consume(demand);
		} else {
			throw new java.lang.UnsupportedOperationException("Resourcetype not yet supported in prototype");
		}
	  } catch (Exception e) {
		e.printStackTrace();
		System.exit(-1);
	  }
   }




   
      
   
	
	// Release de.uka.ipd.sdq.pcm.repository.impl.PassiveResourceImpl@3a4246 (id: _BcM9k1E5Ed2iLYgaJYxY7w) (entityName: dbConnectionPool)
	// TODO: Implement code to release the resource


   
      
   
	
	
	return resultStackFrame;
	


   

   

   

   

   

   
      
    	
   	  
   	  /*PROTECTED REGION END*/
   }   


		  
	
	// Component Parameter Defaults
	protected de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object> myDefaultComponentStackFrame = null;

	// Component Parameter setter
	protected de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object> myComponentStackFrame = null;
	
	public void setComponentFrame(de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object> myComponentStackFrame) {
		this.myComponentStackFrame = myComponentStackFrame;	
		this.myDefaultComponentStackFrame = new de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object>();
		
			
				
					this.myDefaultComponentStackFrame.addValue("fileSize.BYTESIZE",
					   	new de.uka.ipd.sdq.simucomframework.variables.EvaluationProxy("IntPMF[ (500000; 0.00000000) (1000000; 0.05100000) (2000000; 0.13400000) (3000000; 0.19300000) (4000000; 0.21200000) (5000000; 0.22400000) (6000000; 0.18600000) ]",
					   	new de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object>()));
				
			
		
	}


	   }
	   
	
	
		

		
 

	