
	   
	

	   package brs_repository.impl;
	      
	   
public class Scheduler

	   

	   implements brs_repository.impl.IScheduler
	   {
	   	  
 
	      
	
    

   	
    protected brs_repository.impl.ports.IBRSSystem_Scheduler m_portProvided_IBRSSystem_Scheduler = new brs_repository.impl.ports.IBRSSystem_Scheduler(this);

   	
   public brs_repository.IBRSSystem getPortProvided_IBRSSystem_Scheduler () {
      return m_portProvided_IBRSSystem_Scheduler;
   }


	      
   
   

   
   

   
   protected brs_repository.impl.contexts.ISchedulerContext myContext = null;

   
   public void setContext(brs_repository.impl.contexts.ISchedulerContext myContext) {
      this.myContext = myContext;
      
   }


	      
	
   public 
	
   de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object>

      iBRSSystem_report0
         (
	de.uka.ipd.sdq.simucomframework.variables.StackContext ctx
)

   { 
      /*PROTECTED REGION ID(report0__jpoagNo4EdyCSNQKlT1LxA__0bp4oFhFEd6UHd_VhJH9SQ) START*/
   	  
   	  	
	      
   
	
	
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
      double demand = (Double) ctx.evaluate("0.05",Double.class);
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
	long startTimeCall_IUserMgmt_logUserActivity2__Component__Scheduler__AssemblyCtx____this_assemblyContextID____CallID___ebMmAFjxEd6UHd_VhJH9SQ_ = System.nanoTime();
	

			
	de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object> callResult =	


   	myContext.getRoleRequired_IUserMgmt_Scheduler().logUserActivity2 
	   	(
	ctx
);
	
	
	// Stop the time measurement
	
		
	
	// Stop the response time measurement
	long endTimeCall_IUserMgmt_logUserActivity2__Component__Scheduler__AssemblyCtx____this_assemblyContextID____CallID___ebMmAFjxEd6UHd_VhJH9SQ_ = System.nanoTime();
	long resultCall_IUserMgmt_logUserActivity2__Component__Scheduler__AssemblyCtx____this_assemblyContextID____CallID___ebMmAFjxEd6UHd_VhJH9SQ_ = endTimeCall_IUserMgmt_logUserActivity2__Component__Scheduler__AssemblyCtx____this_assemblyContextID____CallID___ebMmAFjxEd6UHd_VhJH9SQ_ - startTimeCall_IUserMgmt_logUserActivity2__Component__Scheduler__AssemblyCtx____this_assemblyContextID____CallID___ebMmAFjxEd6UHd_VhJH9SQ_;
	System.out.println("Call_IUserMgmt_logUserActivity2__Component__Scheduler__AssemblyCtx____this_assemblyContextID____CallID___ebMmAFjxEd6UHd_VhJH9SQ_: "+resultCall_IUserMgmt_logUserActivity2__Component__Scheduler__AssemblyCtx____this_assemblyContextID____CallID___ebMmAFjxEd6UHd_VhJH9SQ_);
	

			

	 
	}
	finally
	{
		
 	ctx.getStack().removeStackFrame();

	}
	// END Simulate an external call




		    	
	}
/* ExternalCallAction - END */

   
      
   
	
	{
		
			
				
	if ((Boolean)ctx.evaluate("type.VALUE == \"graphical\"") == true)
	{
		
   
	
	


   
      
   
/* ExternalCallAction - START */
 	{ //this scope is needed if the same service is called multiple times in one SEFF. Otherwise there is a duplicate local variable definition.

		    
	
	
	
	// Start Simulate an external call
	try{
	de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object> currentFrame = ctx.getStack().currentStackFrame();
	// prepare stackframe
	de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object> stackframe = ctx.getStack().createAndPushNewStackFrame();
	
		
			
				
					stackframe.addValue("isDetailed.VALUE",
					   	ctx.evaluate("isDetailed.VALUE",currentFrame));
				
			
		
	
		
			
				
					stackframe.addValue("requestedEntries.VALUE",
					   	ctx.evaluate("requestedEntries.VALUE",currentFrame));
				
			
		
	 

	
		
	
	// Start a response time measurement
	long startTimeCall_IGraphicalReport_graphicalReport0__Component__Scheduler__AssemblyCtx____this_assemblyContextID____CallID___jP7_UFenEd6zR8NNmb_sJg_ = System.nanoTime();
	

			
	de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object> callResult =	


   	myContext.getRoleRequired_IGraphicalReport_Scheduler().graphicalReport0 
	   	(
	ctx
);
	
	
	// Stop the time measurement
	
		
	
	// Stop the response time measurement
	long endTimeCall_IGraphicalReport_graphicalReport0__Component__Scheduler__AssemblyCtx____this_assemblyContextID____CallID___jP7_UFenEd6zR8NNmb_sJg_ = System.nanoTime();
	long resultCall_IGraphicalReport_graphicalReport0__Component__Scheduler__AssemblyCtx____this_assemblyContextID____CallID___jP7_UFenEd6zR8NNmb_sJg_ = endTimeCall_IGraphicalReport_graphicalReport0__Component__Scheduler__AssemblyCtx____this_assemblyContextID____CallID___jP7_UFenEd6zR8NNmb_sJg_ - startTimeCall_IGraphicalReport_graphicalReport0__Component__Scheduler__AssemblyCtx____this_assemblyContextID____CallID___jP7_UFenEd6zR8NNmb_sJg_;
	System.out.println("Call_IGraphicalReport_graphicalReport0__Component__Scheduler__AssemblyCtx____this_assemblyContextID____CallID___jP7_UFenEd6zR8NNmb_sJg_: "+resultCall_IGraphicalReport_graphicalReport0__Component__Scheduler__AssemblyCtx____this_assemblyContextID____CallID___jP7_UFenEd6zR8NNmb_sJg_);
	

			

	 
	}
	finally
	{
		
 	ctx.getStack().removeStackFrame();

	}
	// END Simulate an external call




		    	
	}
/* ExternalCallAction - END */

   
      
   
	
	


   

   

   

	}
 else 
	if ((Boolean)ctx.evaluate("type.VALUE == \"online\"") == true)
	{
		
   
	
	


   
      
   
/* ExternalCallAction - START */
 	{ //this scope is needed if the same service is called multiple times in one SEFF. Otherwise there is a duplicate local variable definition.

		    
	
	
	
	// Start Simulate an external call
	try{
	de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object> currentFrame = ctx.getStack().currentStackFrame();
	// prepare stackframe
	de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object> stackframe = ctx.getStack().createAndPushNewStackFrame();
	
		
			
				
					stackframe.addValue("isDetailed.VALUE",
					   	ctx.evaluate("isDetailed.VALUE",currentFrame));
				
			
		
	
		
			
				
					stackframe.addValue("requestedEntries.VALUE",
					   	ctx.evaluate("requestedEntries.VALUE",currentFrame));
				
			
		
	 

	
		
	
	// Start a response time measurement
	long startTimeCall_IOnlineReport_onlineReport0__Component__Scheduler__AssemblyCtx____this_assemblyContextID____CallID___koTfcFenEd6zR8NNmb_sJg_ = System.nanoTime();
	

			
	de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object> callResult =	


   	myContext.getRoleRequired_IOnlineReport_Scheduler().onlineReport0 
	   	(
	ctx
);
	
	
	// Stop the time measurement
	
		
	
	// Stop the response time measurement
	long endTimeCall_IOnlineReport_onlineReport0__Component__Scheduler__AssemblyCtx____this_assemblyContextID____CallID___koTfcFenEd6zR8NNmb_sJg_ = System.nanoTime();
	long resultCall_IOnlineReport_onlineReport0__Component__Scheduler__AssemblyCtx____this_assemblyContextID____CallID___koTfcFenEd6zR8NNmb_sJg_ = endTimeCall_IOnlineReport_onlineReport0__Component__Scheduler__AssemblyCtx____this_assemblyContextID____CallID___koTfcFenEd6zR8NNmb_sJg_ - startTimeCall_IOnlineReport_onlineReport0__Component__Scheduler__AssemblyCtx____this_assemblyContextID____CallID___koTfcFenEd6zR8NNmb_sJg_;
	System.out.println("Call_IOnlineReport_onlineReport0__Component__Scheduler__AssemblyCtx____this_assemblyContextID____CallID___koTfcFenEd6zR8NNmb_sJg_: "+resultCall_IOnlineReport_onlineReport0__Component__Scheduler__AssemblyCtx____this_assemblyContextID____CallID___koTfcFenEd6zR8NNmb_sJg_);
	

			

	 
	}
	finally
	{
		
 	ctx.getStack().removeStackFrame();

	}
	// END Simulate an external call




		    	
	}
/* ExternalCallAction - END */

   
      
   
	
	


   

   

   

	}

				else
					throw new RuntimeException("No branch condition evaluated to true :-(");
			
		
	}


   
      
   
	
	
	return resultStackFrame;
	


   

   

   

   

   
      
    	
   	  
   	  /*PROTECTED REGION END*/
   }   

   public 
	
   de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object>

      iBRSSystem_view1
         (
	de.uka.ipd.sdq.simucomframework.variables.StackContext ctx
)

   { 
      /*PROTECTED REGION ID(view1__jpoagNo4EdyCSNQKlT1LxA__0bp4oFhFEd6UHd_VhJH9SQ) START*/
   	  
   	  	
	      
   
	
	
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
      double demand = (Double) ctx.evaluate("0.1",Double.class);
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
	long startTimeCall_IUserMgmt_logUserActivity2__Component__Scheduler__AssemblyCtx____this_assemblyContextID____CallID___hQZRgFjxEd6UHd_VhJH9SQ_ = System.nanoTime();
	

			
	de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object> callResult =	


   	myContext.getRoleRequired_IUserMgmt_Scheduler().logUserActivity2 
	   	(
	ctx
);
	
	
	// Stop the time measurement
	
		
	
	// Stop the response time measurement
	long endTimeCall_IUserMgmt_logUserActivity2__Component__Scheduler__AssemblyCtx____this_assemblyContextID____CallID___hQZRgFjxEd6UHd_VhJH9SQ_ = System.nanoTime();
	long resultCall_IUserMgmt_logUserActivity2__Component__Scheduler__AssemblyCtx____this_assemblyContextID____CallID___hQZRgFjxEd6UHd_VhJH9SQ_ = endTimeCall_IUserMgmt_logUserActivity2__Component__Scheduler__AssemblyCtx____this_assemblyContextID____CallID___hQZRgFjxEd6UHd_VhJH9SQ_ - startTimeCall_IUserMgmt_logUserActivity2__Component__Scheduler__AssemblyCtx____this_assemblyContextID____CallID___hQZRgFjxEd6UHd_VhJH9SQ_;
	System.out.println("Call_IUserMgmt_logUserActivity2__Component__Scheduler__AssemblyCtx____this_assemblyContextID____CallID___hQZRgFjxEd6UHd_VhJH9SQ_: "+resultCall_IUserMgmt_logUserActivity2__Component__Scheduler__AssemblyCtx____this_assemblyContextID____CallID___hQZRgFjxEd6UHd_VhJH9SQ_);
	

			

	 
	}
	finally
	{
		
 	ctx.getStack().removeStackFrame();

	}
	// END Simulate an external call




		    	
	}
/* ExternalCallAction - END */

   
      
   
	
	{
		
			
				
	if ((Boolean)ctx.evaluate("type.VALUE == \"graphical\"") == true)
	{
		
   
	
	


   
      
   
/* ExternalCallAction - START */
 	{ //this scope is needed if the same service is called multiple times in one SEFF. Otherwise there is a duplicate local variable definition.

		    
	
	
	
	// Start Simulate an external call
	try{
	de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object> currentFrame = ctx.getStack().currentStackFrame();
	// prepare stackframe
	de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object> stackframe = ctx.getStack().createAndPushNewStackFrame();
	 

	
		
	
	// Start a response time measurement
	long startTimeCall_IGraphicalReport_viewGraphically1__Component__Scheduler__AssemblyCtx____this_assemblyContextID____CallID___350MYFenEd6zR8NNmb_sJg_ = System.nanoTime();
	

			
	de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object> callResult =	


   	myContext.getRoleRequired_IGraphicalReport_Scheduler().viewGraphically1 
	   	(
	ctx
);
	
	
	// Stop the time measurement
	
		
	
	// Stop the response time measurement
	long endTimeCall_IGraphicalReport_viewGraphically1__Component__Scheduler__AssemblyCtx____this_assemblyContextID____CallID___350MYFenEd6zR8NNmb_sJg_ = System.nanoTime();
	long resultCall_IGraphicalReport_viewGraphically1__Component__Scheduler__AssemblyCtx____this_assemblyContextID____CallID___350MYFenEd6zR8NNmb_sJg_ = endTimeCall_IGraphicalReport_viewGraphically1__Component__Scheduler__AssemblyCtx____this_assemblyContextID____CallID___350MYFenEd6zR8NNmb_sJg_ - startTimeCall_IGraphicalReport_viewGraphically1__Component__Scheduler__AssemblyCtx____this_assemblyContextID____CallID___350MYFenEd6zR8NNmb_sJg_;
	System.out.println("Call_IGraphicalReport_viewGraphically1__Component__Scheduler__AssemblyCtx____this_assemblyContextID____CallID___350MYFenEd6zR8NNmb_sJg_: "+resultCall_IGraphicalReport_viewGraphically1__Component__Scheduler__AssemblyCtx____this_assemblyContextID____CallID___350MYFenEd6zR8NNmb_sJg_);
	

			

	 
	}
	finally
	{
		
 	ctx.getStack().removeStackFrame();

	}
	// END Simulate an external call




		    	
	}
/* ExternalCallAction - END */

   
      
   
	
	


   

   

   

	}
 else 
	if ((Boolean)ctx.evaluate("type.VALUE == \"online\"") == true)
	{
		
   
	
	


   
      
   
/* ExternalCallAction - START */
 	{ //this scope is needed if the same service is called multiple times in one SEFF. Otherwise there is a duplicate local variable definition.

		    
	
	
	
	// Start Simulate an external call
	try{
	de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object> currentFrame = ctx.getStack().currentStackFrame();
	// prepare stackframe
	de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object> stackframe = ctx.getStack().createAndPushNewStackFrame();
	 

	
		
	
	// Start a response time measurement
	long startTimeCall_IOnlineReport_viewOnline1__Component__Scheduler__AssemblyCtx____this_assemblyContextID____CallID___4trSQFenEd6zR8NNmb_sJg_ = System.nanoTime();
	

			
	de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object> callResult =	


   	myContext.getRoleRequired_IOnlineReport_Scheduler().viewOnline1 
	   	(
	ctx
);
	
	
	// Stop the time measurement
	
		
	
	// Stop the response time measurement
	long endTimeCall_IOnlineReport_viewOnline1__Component__Scheduler__AssemblyCtx____this_assemblyContextID____CallID___4trSQFenEd6zR8NNmb_sJg_ = System.nanoTime();
	long resultCall_IOnlineReport_viewOnline1__Component__Scheduler__AssemblyCtx____this_assemblyContextID____CallID___4trSQFenEd6zR8NNmb_sJg_ = endTimeCall_IOnlineReport_viewOnline1__Component__Scheduler__AssemblyCtx____this_assemblyContextID____CallID___4trSQFenEd6zR8NNmb_sJg_ - startTimeCall_IOnlineReport_viewOnline1__Component__Scheduler__AssemblyCtx____this_assemblyContextID____CallID___4trSQFenEd6zR8NNmb_sJg_;
	System.out.println("Call_IOnlineReport_viewOnline1__Component__Scheduler__AssemblyCtx____this_assemblyContextID____CallID___4trSQFenEd6zR8NNmb_sJg_: "+resultCall_IOnlineReport_viewOnline1__Component__Scheduler__AssemblyCtx____this_assemblyContextID____CallID___4trSQFenEd6zR8NNmb_sJg_);
	

			

	 
	}
	finally
	{
		
 	ctx.getStack().removeStackFrame();

	}
	// END Simulate an external call




		    	
	}
/* ExternalCallAction - END */

   
      
   
	
	


   

   

   

	}

				else
					throw new RuntimeException("No branch condition evaluated to true :-(");
			
		
	}


   
      
   
	
	
	return resultStackFrame;
	


   

   

   

   

   
      
    	
   	  
   	  /*PROTECTED REGION END*/
   }   

   public 
	
   de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object>

      iBRSSystem_login2
         (
	de.uka.ipd.sdq.simucomframework.variables.StackContext ctx
)

   { 
      /*PROTECTED REGION ID(login2__jpoagNo4EdyCSNQKlT1LxA__0bp4oFhFEd6UHd_VhJH9SQ) START*/
   	  
   	  	
	      
   
	
	
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
      double demand = (Double) ctx.evaluate("0.1  ",Double.class);
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
	long startTimeCall_IUserMgmt_userLogin0__Component__Scheduler__AssemblyCtx____this_assemblyContextID____CallID___ScHbkFhGEd6UHd_VhJH9SQ_ = System.nanoTime();
	

			
	de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object> callResult =	


   	myContext.getRoleRequired_IUserMgmt_Scheduler().userLogin0 
	   	(
	ctx
);
	
	
	// Stop the time measurement
	
		
	
	// Stop the response time measurement
	long endTimeCall_IUserMgmt_userLogin0__Component__Scheduler__AssemblyCtx____this_assemblyContextID____CallID___ScHbkFhGEd6UHd_VhJH9SQ_ = System.nanoTime();
	long resultCall_IUserMgmt_userLogin0__Component__Scheduler__AssemblyCtx____this_assemblyContextID____CallID___ScHbkFhGEd6UHd_VhJH9SQ_ = endTimeCall_IUserMgmt_userLogin0__Component__Scheduler__AssemblyCtx____this_assemblyContextID____CallID___ScHbkFhGEd6UHd_VhJH9SQ_ - startTimeCall_IUserMgmt_userLogin0__Component__Scheduler__AssemblyCtx____this_assemblyContextID____CallID___ScHbkFhGEd6UHd_VhJH9SQ_;
	System.out.println("Call_IUserMgmt_userLogin0__Component__Scheduler__AssemblyCtx____this_assemblyContextID____CallID___ScHbkFhGEd6UHd_VhJH9SQ_: "+resultCall_IUserMgmt_userLogin0__Component__Scheduler__AssemblyCtx____this_assemblyContextID____CallID___ScHbkFhGEd6UHd_VhJH9SQ_);
	

			

	 
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

   public 
	
   de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object>

      iBRSSystem_logout3
         (
	de.uka.ipd.sdq.simucomframework.variables.StackContext ctx
)

   { 
      /*PROTECTED REGION ID(logout3__jpoagNo4EdyCSNQKlT1LxA__0bp4oFhFEd6UHd_VhJH9SQ) START*/
   	  
   	  	
	      
   
	
	
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
      double demand = (Double) ctx.evaluate("0.1  ",Double.class);
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
	long startTimeCall_IUserMgmt_userLogout1__Component__Scheduler__AssemblyCtx____this_assemblyContextID____CallID___VI0SYFhGEd6UHd_VhJH9SQ_ = System.nanoTime();
	

			
	de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object> callResult =	


   	myContext.getRoleRequired_IUserMgmt_Scheduler().userLogout1 
	   	(
	ctx
);
	
	
	// Stop the time measurement
	
		
	
	// Stop the response time measurement
	long endTimeCall_IUserMgmt_userLogout1__Component__Scheduler__AssemblyCtx____this_assemblyContextID____CallID___VI0SYFhGEd6UHd_VhJH9SQ_ = System.nanoTime();
	long resultCall_IUserMgmt_userLogout1__Component__Scheduler__AssemblyCtx____this_assemblyContextID____CallID___VI0SYFhGEd6UHd_VhJH9SQ_ = endTimeCall_IUserMgmt_userLogout1__Component__Scheduler__AssemblyCtx____this_assemblyContextID____CallID___VI0SYFhGEd6UHd_VhJH9SQ_ - startTimeCall_IUserMgmt_userLogout1__Component__Scheduler__AssemblyCtx____this_assemblyContextID____CallID___VI0SYFhGEd6UHd_VhJH9SQ_;
	System.out.println("Call_IUserMgmt_userLogout1__Component__Scheduler__AssemblyCtx____this_assemblyContextID____CallID___VI0SYFhGEd6UHd_VhJH9SQ_: "+resultCall_IUserMgmt_userLogout1__Component__Scheduler__AssemblyCtx____this_assemblyContextID____CallID___VI0SYFhGEd6UHd_VhJH9SQ_);
	

			

	 
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
		
			
		
	}


	   }
	   
	
	
		

		
 

	