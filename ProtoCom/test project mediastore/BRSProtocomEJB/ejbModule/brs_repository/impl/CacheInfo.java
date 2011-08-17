
	   
	

	   package brs_repository.impl;
	      
	   
public class CacheInfo

	   

	   implements brs_repository.impl.ICacheInfo
	   {
	   	  
 
	      
	
    

   	
    protected brs_repository.impl.ports.ICache_CacheInfo m_portProvided_ICache_CacheInfo = new brs_repository.impl.ports.ICache_CacheInfo(this);

   	
   public brs_repository.ICache getPortProvided_ICache_CacheInfo () {
      return m_portProvided_ICache_CacheInfo;
   }


	      
   
   

   
   

   
   protected brs_repository.impl.contexts.ICacheInfoContext myContext = null;

   
   public void setContext(brs_repository.impl.contexts.ICacheInfoContext myContext) {
      this.myContext = myContext;
      
   }


	      
	
   public 
	
   de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object>

      iCache_doCacheAccess0
         (
	de.uka.ipd.sdq.simucomframework.variables.StackContext ctx
)

   { 
      /*PROTECTED REGION ID(doCacheAccess0__nEBdwNo4EdyCSNQKlT1LxA__cooDoNo9EdyxgfK4Hy_RFA) START*/
   	  
   	  	
	      
   
	
	
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
	


   
      
   
	
	
	
   {
      double demand = (Double) ctx.evaluate("0.01",Double.class);
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
		
			
				double u_eJP4cFhDEd6UHd_VhJH9SQ = (Double)ctx.evaluate("DoublePDF[(1;1.0)]",Double.class);
				double sum_eJP4cFhDEd6UHd_VhJH9SQ = 0;
				
	if (sum_eJP4cFhDEd6UHd_VhJH9SQ <= u_eJP4cFhDEd6UHd_VhJH9SQ && u_eJP4cFhDEd6UHd_VhJH9SQ < sum_eJP4cFhDEd6UHd_VhJH9SQ + 0.2 )
	{
		
   
	
	


   
      
   
	
	


   

   

	}
	sum_eJP4cFhDEd6UHd_VhJH9SQ += 0.2;

	if (sum_eJP4cFhDEd6UHd_VhJH9SQ <= u_eJP4cFhDEd6UHd_VhJH9SQ && u_eJP4cFhDEd6UHd_VhJH9SQ < sum_eJP4cFhDEd6UHd_VhJH9SQ + 0.8 )
	{
		
   
	
	


   
      
   
	
	
	
   {
      double demand = (Double) ctx.evaluate("0.04  ",Double.class);
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




   
      
   
/* ExternalCallAction - START */
 	{ //this scope is needed if the same service is called multiple times in one SEFF. Otherwise there is a duplicate local variable definition.

		    
	
	
	
	// Start Simulate an external call
	try{
	de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object> currentFrame = ctx.getStack().currentStackFrame();
	// prepare stackframe
	de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object> stackframe = ctx.getStack().createAndPushNewStackFrame();
	 

	
		
	
	// Start a response time measurement
	long startTimeCall_IDB_getCachedData2__Component__CacheInfo__AssemblyCtx____this_assemblyContextID____CallID___d2S7MNo_EdyxgfK4Hy_RFA_ = System.nanoTime();
	

			
	de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object> callResult =	


   	myContext.getRoleRequired_IDB_CacheInfo().getCachedData2 
	   	(
	ctx
);
	
	
	// Stop the time measurement
	
		
	
	// Stop the response time measurement
	long endTimeCall_IDB_getCachedData2__Component__CacheInfo__AssemblyCtx____this_assemblyContextID____CallID___d2S7MNo_EdyxgfK4Hy_RFA_ = System.nanoTime();
	long resultCall_IDB_getCachedData2__Component__CacheInfo__AssemblyCtx____this_assemblyContextID____CallID___d2S7MNo_EdyxgfK4Hy_RFA_ = endTimeCall_IDB_getCachedData2__Component__CacheInfo__AssemblyCtx____this_assemblyContextID____CallID___d2S7MNo_EdyxgfK4Hy_RFA_ - startTimeCall_IDB_getCachedData2__Component__CacheInfo__AssemblyCtx____this_assemblyContextID____CallID___d2S7MNo_EdyxgfK4Hy_RFA_;
	System.out.println("Call_IDB_getCachedData2__Component__CacheInfo__AssemblyCtx____this_assemblyContextID____CallID___d2S7MNo_EdyxgfK4Hy_RFA_: "+resultCall_IDB_getCachedData2__Component__CacheInfo__AssemblyCtx____this_assemblyContextID____CallID___d2S7MNo_EdyxgfK4Hy_RFA_);
	

			

	 
	}
	finally
	{
		
 	ctx.getStack().removeStackFrame();

	}
	// END Simulate an external call




		    	
	}
/* ExternalCallAction - END */

   
      
   
	
	


   

   

   

   

	}
	sum_eJP4cFhDEd6UHd_VhJH9SQ += 0.8;

			
		
	}


   
      
   
	
	
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
		
			
		
	}


	   }
	   
	
	
		

		
 

	