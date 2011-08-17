
	   
	

	   package mediastorerepository.impl;
	      
	   
public class DBCache

	   

	   implements mediastorerepository.impl.IDBCache
	   {
	   	  
 
	      
	
    

   	
    protected mediastorerepository.impl.ports.IAudioDB_DBCache m_portProvided_IAudioDB_DBCache = new mediastorerepository.impl.ports.IAudioDB_DBCache(this);

   	
   public mediastorerepository.IAudioDB getPortProvided_IAudioDB_DBCache () {
      return m_portProvided_IAudioDB_DBCache;
   }


	      
   
   

   
   

   
   protected mediastorerepository.impl.contexts.IDBCacheContext myContext = null;

   
   public void setContext(mediastorerepository.impl.contexts.IDBCacheContext myContext) {
      this.myContext = myContext;
      
   }


	      
	
   public 
	
   de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object>

      iAudioDB_queryDB0
         (
	de.uka.ipd.sdq.simucomframework.variables.StackContext ctx
)

   { 
      /*PROTECTED REGION ID(queryDB0__5ua00BwhEdyigt_qJDxvbA__yNjKgBpXEdyxqpPYxT_m3w) START*/
   	  
   	  	
	      
   
	
	
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
	


   
      
   
	
   for (int iterationCount_ngAZ8FE7Ed2iLYgaJYxY7w = 0, maxIterationCount_ngAZ8FE7Ed2iLYgaJYxY7w = (Integer)ctx.evaluate("ids.NUMBER_OF_ELEMENTS",Integer.class); 
            iterationCount_ngAZ8FE7Ed2iLYgaJYxY7w < maxIterationCount_ngAZ8FE7Ed2iLYgaJYxY7w; iterationCount_ngAZ8FE7Ed2iLYgaJYxY7w++){
       
   
	
	


   
      
   
	
	
	
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
		
			
				double u_0_YwMFE7Ed2iLYgaJYxY7w = (Double)ctx.evaluate("DoublePDF[(1;1.0)]",Double.class);
				double sum_0_YwMFE7Ed2iLYgaJYxY7w = 0;
				
	if (sum_0_YwMFE7Ed2iLYgaJYxY7w <= u_0_YwMFE7Ed2iLYgaJYxY7w && u_0_YwMFE7Ed2iLYgaJYxY7w < sum_0_YwMFE7Ed2iLYgaJYxY7w + 0.2 )
	{
		
   
	
	


   
      
   
	
	


   

   

	}
	sum_0_YwMFE7Ed2iLYgaJYxY7w += 0.2;

	if (sum_0_YwMFE7Ed2iLYgaJYxY7w <= u_0_YwMFE7Ed2iLYgaJYxY7w && u_0_YwMFE7Ed2iLYgaJYxY7w < sum_0_YwMFE7Ed2iLYgaJYxY7w + 0.8 )
	{
		
   
	
	


   
      
   
/* ExternalCallAction - START */
 	{ //this scope is needed if the same service is called multiple times in one SEFF. Otherwise there is a duplicate local variable definition.

		    
	
	
	
	// Start Simulate an external call
	try{
	de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object> currentFrame = ctx.getStack().currentStackFrame();
	// prepare stackframe
	de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object> stackframe = ctx.getStack().createAndPushNewStackFrame();
	
		
			
				
					stackframe.addValue("ids.NUMBER_OF_ELEMENTS",
					   	ctx.evaluate("1",currentFrame));
				
			
		
	 

	
		
	
	// Start a response time measurement
	long startTimeCall_IAudioDB_queryDB0__Component__DBCache__AssemblyCtx____this_assemblyContextID____CallID___K67acFE8Ed2iLYgaJYxY7w_ = System.nanoTime();
	

			
	de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object> callResult =	


   	myContext.getRoleRequired_IAudioDB_DBCache().queryDB0 
	   	(
	ctx
);
	
	
	// Stop the time measurement
	
		
	
	// Stop the response time measurement
	long endTimeCall_IAudioDB_queryDB0__Component__DBCache__AssemblyCtx____this_assemblyContextID____CallID___K67acFE8Ed2iLYgaJYxY7w_ = System.nanoTime();
	long resultCall_IAudioDB_queryDB0__Component__DBCache__AssemblyCtx____this_assemblyContextID____CallID___K67acFE8Ed2iLYgaJYxY7w_ = endTimeCall_IAudioDB_queryDB0__Component__DBCache__AssemblyCtx____this_assemblyContextID____CallID___K67acFE8Ed2iLYgaJYxY7w_ - startTimeCall_IAudioDB_queryDB0__Component__DBCache__AssemblyCtx____this_assemblyContextID____CallID___K67acFE8Ed2iLYgaJYxY7w_;
	//System.out.println("Call_IAudioDB_queryDB0__Component__DBCache__AssemblyCtx____this_assemblyContextID____CallID___K67acFE8Ed2iLYgaJYxY7w_: "+resultCall_IAudioDB_queryDB0__Component__DBCache__AssemblyCtx____this_assemblyContextID____CallID___K67acFE8Ed2iLYgaJYxY7w_);
	

			

	
		
			// Copy out parameter fileList to local stack frame
			
				
					methodBodyStackFrame.addValue("fileList.NUMBER_OF_ELEMENTS",
					   	ctx.evaluate("RETURN.NUMBER_OF_ELEMENTS",callResult));
				
			
		
	
		
			// Copy out parameter fileSize to local stack frame
			
				
					methodBodyStackFrame.addValue("fileSize.BYTESIZE",
					   	ctx.evaluate("RETURN.INNER.BYTESIZE",callResult));
				
			
		
	 
	}
	finally
	{
		
 	ctx.getStack().removeStackFrame();

	}
	// END Simulate an external call




		    	
	}
/* ExternalCallAction - END */

   
      
   
	
	


   

   

   

	}
	sum_0_YwMFE7Ed2iLYgaJYxY7w += 0.8;

			
		
	}


   
      
   
	
	


   

   

   

   

   } 


   
      
   
	
	
		
			
				resultStackFrame.addValue("RETURN.NUMBER_OF_ELEMENTS",
					ctx.evaluate("ids.NUMBER_OF_ELEMENTS"));
			
		
	
		
			
				resultStackFrame.addValue("RETURN.INNER.BYTESIZE",
				   	new de.uka.ipd.sdq.simucomframework.variables.EvaluationProxy("fileSize.BYTESIZE",methodBodyStackFrame.copyFrame()));
			
		
	


   
      
   
	
	
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
      /*PROTECTED REGION ID(addFile1__5ua00BwhEdyigt_qJDxvbA__yNjKgBpXEdyxqpPYxT_m3w) START*/
   	  
   	  	
	      
   
	
	
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
	


   
      
   
/* ExternalCallAction - START */
 	{ //this scope is needed if the same service is called multiple times in one SEFF. Otherwise there is a duplicate local variable definition.

		    
	
	
	
	// Start Simulate an external call
	try{
	de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object> currentFrame = ctx.getStack().currentStackFrame();
	// prepare stackframe
	de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object> stackframe = ctx.getStack().createAndPushNewStackFrame();
	
		
			
				
					stackframe.addValue("file.BYTESIZE",
					   	ctx.evaluate("file.BYTESIZE",currentFrame));
				
			
		
	 

	
		
	
	// Start a response time measurement
	long startTimeCall_IAudioDB_addFile1__Component__DBCache__AssemblyCtx____this_assemblyContextID____CallID___mWwoAFE9Ed2iLYgaJYxY7w_ = System.nanoTime();
	

			
	de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object> callResult =	


   	myContext.getRoleRequired_IAudioDB_DBCache().addFile1 
	   	(
	ctx
);
	
	
	// Stop the time measurement
	
		
	
	// Stop the response time measurement
	long endTimeCall_IAudioDB_addFile1__Component__DBCache__AssemblyCtx____this_assemblyContextID____CallID___mWwoAFE9Ed2iLYgaJYxY7w_ = System.nanoTime();
	long resultCall_IAudioDB_addFile1__Component__DBCache__AssemblyCtx____this_assemblyContextID____CallID___mWwoAFE9Ed2iLYgaJYxY7w_ = endTimeCall_IAudioDB_addFile1__Component__DBCache__AssemblyCtx____this_assemblyContextID____CallID___mWwoAFE9Ed2iLYgaJYxY7w_ - startTimeCall_IAudioDB_addFile1__Component__DBCache__AssemblyCtx____this_assemblyContextID____CallID___mWwoAFE9Ed2iLYgaJYxY7w_;
	//System.out.println("Call_IAudioDB_addFile1__Component__DBCache__AssemblyCtx____this_assemblyContextID____CallID___mWwoAFE9Ed2iLYgaJYxY7w_: "+resultCall_IAudioDB_addFile1__Component__DBCache__AssemblyCtx____this_assemblyContextID____CallID___mWwoAFE9Ed2iLYgaJYxY7w_);
	

			

	 
	}
	finally
	{
		
 	ctx.getStack().removeStackFrame();

	}
	// END Simulate an external call




		    	
	}
/* ExternalCallAction - END */

   
      
   
	
	
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
	   
	
	
		

		
 

	