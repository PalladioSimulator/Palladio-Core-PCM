
	   
	

	   package brs_repository.impl;
	      
	   
public class WebServer3

	   

	   implements brs_repository.impl.IWebServer3
	   {
	   	  
    

	//TODO: pass the assembly context id to here as it is done for the simulation. 
	String assemblyContextID = ""; 
	
	
    de.uka.ipd.sdq.sensorframework.entities.TimeSpanSensor tssCall_IBRSSystem_logout3__Component__WebServer3__AssemblyCtx____this_assemblyContextID____CallID___T3QcgFhJEd6UHd_VhJH9SQ3_;

    de.uka.ipd.sdq.sensorframework.entities.TimeSpanSensor tssCall_IBRSSystem_login2__Component__WebServer3__AssemblyCtx____this_assemblyContextID____CallID___SMQ6UFhJEd6UHd_VhJH9SQ3_;

    de.uka.ipd.sdq.sensorframework.entities.TimeSpanSensor tssCall_IBRSSystem_report0__Component__WebServer3__AssemblyCtx____this_assemblyContextID____CallID___l5Vm8F6hEd6D97fyAyMq6A3_;

    de.uka.ipd.sdq.sensorframework.entities.TimeSpanSensor tssCall_IBRSSystem_report0__Component__WebServer3__AssemblyCtx____this_assemblyContextID____CallID___L8754F6iEd6D97fyAyMq6A3_;

    de.uka.ipd.sdq.sensorframework.entities.TimeSpanSensor tssCall_IBRSSystem_view1__Component__WebServer3__AssemblyCtx____this_assemblyContextID____CallID___NtSaEGyAEd68zLmG_5OTdQ3_;

    de.uka.ipd.sdq.sensorframework.entities.TimeSpanSensor tssCall_IBRSSystem_view1__Component__WebServer3__AssemblyCtx____this_assemblyContextID____CallID___ThqzgGyAEd68zLmG_5OTdQ3_;

	
  
  de.uka.ipd.sdq.sensorframework.entities.TimeSpanSensor tssSEFF_IHTTP_processLoginLogout0__Component__WebServer3__AssemblyCtx____this_assemblyContextID___;

  de.uka.ipd.sdq.sensorframework.entities.TimeSpanSensor tssSEFF_IHTTP_processGraphicalReport1__Component__WebServer3__AssemblyCtx____this_assemblyContextID___;

  de.uka.ipd.sdq.sensorframework.entities.TimeSpanSensor tssSEFF_IHTTP_processOnlineReport2__Component__WebServer3__AssemblyCtx____this_assemblyContextID___;

  de.uka.ipd.sdq.sensorframework.entities.TimeSpanSensor tssSEFF_IHTTP_processGraphicalView3__Component__WebServer3__AssemblyCtx____this_assemblyContextID___;

  de.uka.ipd.sdq.sensorframework.entities.TimeSpanSensor tssSEFF_IHTTP_processOnlineView4__Component__WebServer3__AssemblyCtx____this_assemblyContextID___;


	
	de.uka.ipd.sdq.sensorframework.entities.ExperimentRun expRun;
	
	public WebServer3(){

		expRun = de.uka.ipd.sdq.prototype.framework.AbstractMain.getLatestExperimentRun();
		
		

        tssCall_IBRSSystem_logout3__Component__WebServer3__AssemblyCtx____this_assemblyContextID____CallID___T3QcgFhJEd6UHd_VhJH9SQ3_ 
            = de.uka.ipd.sdq.prototype.framework.AbstractMain.createOrReuseTimeSpanSensor(
                "Call IBRSSystem.logout3 <Component: WebServer3, AssemblyCtx: "+this.assemblyContextID+", CallID: _T3QcgFhJEd6UHd_VhJH9SQ3>"
            );



        tssCall_IBRSSystem_login2__Component__WebServer3__AssemblyCtx____this_assemblyContextID____CallID___SMQ6UFhJEd6UHd_VhJH9SQ3_ 
            = de.uka.ipd.sdq.prototype.framework.AbstractMain.createOrReuseTimeSpanSensor(
                "Call IBRSSystem.login2 <Component: WebServer3, AssemblyCtx: "+this.assemblyContextID+", CallID: _SMQ6UFhJEd6UHd_VhJH9SQ3>"
            );



        tssCall_IBRSSystem_report0__Component__WebServer3__AssemblyCtx____this_assemblyContextID____CallID___l5Vm8F6hEd6D97fyAyMq6A3_ 
            = de.uka.ipd.sdq.prototype.framework.AbstractMain.createOrReuseTimeSpanSensor(
                "Call IBRSSystem.report0 <Component: WebServer3, AssemblyCtx: "+this.assemblyContextID+", CallID: _l5Vm8F6hEd6D97fyAyMq6A3>"
            );



        tssCall_IBRSSystem_report0__Component__WebServer3__AssemblyCtx____this_assemblyContextID____CallID___L8754F6iEd6D97fyAyMq6A3_ 
            = de.uka.ipd.sdq.prototype.framework.AbstractMain.createOrReuseTimeSpanSensor(
                "Call IBRSSystem.report0 <Component: WebServer3, AssemblyCtx: "+this.assemblyContextID+", CallID: _L8754F6iEd6D97fyAyMq6A3>"
            );



        tssCall_IBRSSystem_view1__Component__WebServer3__AssemblyCtx____this_assemblyContextID____CallID___NtSaEGyAEd68zLmG_5OTdQ3_ 
            = de.uka.ipd.sdq.prototype.framework.AbstractMain.createOrReuseTimeSpanSensor(
                "Call IBRSSystem.view1 <Component: WebServer3, AssemblyCtx: "+this.assemblyContextID+", CallID: _NtSaEGyAEd68zLmG_5OTdQ3>"
            );



        tssCall_IBRSSystem_view1__Component__WebServer3__AssemblyCtx____this_assemblyContextID____CallID___ThqzgGyAEd68zLmG_5OTdQ3_ 
            = de.uka.ipd.sdq.prototype.framework.AbstractMain.createOrReuseTimeSpanSensor(
                "Call IBRSSystem.view1 <Component: WebServer3, AssemblyCtx: "+this.assemblyContextID+", CallID: _ThqzgGyAEd68zLmG_5OTdQ3>"
            );


		
		
  
        tssSEFF_IHTTP_processLoginLogout0__Component__WebServer3__AssemblyCtx____this_assemblyContextID___ 
            = de.uka.ipd.sdq.prototype.framework.AbstractMain.createOrReuseTimeSpanSensor(
                "SEFF IHTTP.processLoginLogout0 <Component: WebServer3, AssemblyCtx: "+this.assemblyContextID+">"
            );

        tssSEFF_IHTTP_processGraphicalReport1__Component__WebServer3__AssemblyCtx____this_assemblyContextID___ 
            = de.uka.ipd.sdq.prototype.framework.AbstractMain.createOrReuseTimeSpanSensor(
                "SEFF IHTTP.processGraphicalReport1 <Component: WebServer3, AssemblyCtx: "+this.assemblyContextID+">"
            );

        tssSEFF_IHTTP_processOnlineReport2__Component__WebServer3__AssemblyCtx____this_assemblyContextID___ 
            = de.uka.ipd.sdq.prototype.framework.AbstractMain.createOrReuseTimeSpanSensor(
                "SEFF IHTTP.processOnlineReport2 <Component: WebServer3, AssemblyCtx: "+this.assemblyContextID+">"
            );

        tssSEFF_IHTTP_processGraphicalView3__Component__WebServer3__AssemblyCtx____this_assemblyContextID___ 
            = de.uka.ipd.sdq.prototype.framework.AbstractMain.createOrReuseTimeSpanSensor(
                "SEFF IHTTP.processGraphicalView3 <Component: WebServer3, AssemblyCtx: "+this.assemblyContextID+">"
            );

        tssSEFF_IHTTP_processOnlineView4__Component__WebServer3__AssemblyCtx____this_assemblyContextID___ 
            = de.uka.ipd.sdq.prototype.framework.AbstractMain.createOrReuseTimeSpanSensor(
                "SEFF IHTTP.processOnlineView4 <Component: WebServer3, AssemblyCtx: "+this.assemblyContextID+">"
            );


		
		//FIXME: quick fix to initialise component params as setComponentFrame is not called by system for ejbs.
		this.setComponentFrame(this.myComponentStackFrame);
		
	}


 
	      
	
    

   	
    protected brs_repository.impl.ports.IHTTP_WebServer3 m_portProvided_IHTTP_WebServer = new brs_repository.impl.ports.IHTTP_WebServer3(this);

   	
   public brs_repository.IHTTP getPortProvided_IHTTP_WebServer () {
      return m_portProvided_IHTTP_WebServer;
   }


	      
   
   

   
   

   
   protected brs_repository.impl.contexts.IWebServer3Context myContext = null;

   
   public void setContext(brs_repository.impl.contexts.IWebServer3Context myContext) {
      this.myContext = myContext;
      
   }


	      
	
   public 
	
   de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object>

      iHTTP_processLoginLogout0
         (
	de.uka.ipd.sdq.simucomframework.variables.StackContext ctx
)

   { 
      /*PROTECTED REGION ID(processLoginLogout0__6bAEENo5EdyCSNQKlT1LxA3__36kHoNo5EdyCSNQKlT1LxA) START*/
   	  
   	  	
	      
   
    

 
  
   
    // measure time for SEFF  
    
	
	// Start a response time measurement
	long startTimeSEFF_IHTTP_processLoginLogout0__Component__WebServer3__AssemblyCtx____this_assemblyContextID___ = de.uka.ipd.sdq.prototype.framework.AbstractMain.takeStartTimeForInnerMeasurement();
	

   
  
 


	
	
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
		
			
				
	if ((Boolean)ctx.evaluate("type.VALUE==\"login\"") == true)
	{
		
   
    


	
	


   
      
   
/* ExternalCallAction - START */
 	{ //this scope is needed if the same service is called multiple times in one SEFF. Otherwise there is a duplicate local variable definition.

		    
	
	
	
	// Start Simulate an external call
	try{
	de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object> currentFrame = ctx.getStack().currentStackFrame();
	// prepare stackframe
	de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object> stackframe = ctx.getStack().createAndPushNewStackFrame();
	 

	
		
	
	// Start a response time measurement
	long startTimeCall_IBRSSystem_login2__Component__WebServer3__AssemblyCtx____this_assemblyContextID____CallID___SMQ6UFhJEd6UHd_VhJH9SQ3_ = de.uka.ipd.sdq.prototype.framework.AbstractMain.takeStartTimeForInnerMeasurement();
	
 
			
	de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object> callResult =	


   	myContext.getRoleRequired_IBRSSystem_WebServer().login2 
	   	(
	ctx
);
	
	
	// Stop the time measurement
	
		
	
	// Stop the response time measurement
	de.uka.ipd.sdq.prototype.framework.AbstractMain.takeMeasurement(startTimeCall_IBRSSystem_login2__Component__WebServer3__AssemblyCtx____this_assemblyContextID____CallID___SMQ6UFhJEd6UHd_VhJH9SQ3_, expRun, tssCall_IBRSSystem_login2__Component__WebServer3__AssemblyCtx____this_assemblyContextID____CallID___SMQ6UFhJEd6UHd_VhJH9SQ3_);
	

			

	 
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
	if ((Boolean)ctx.evaluate("type.VALUE==\"logout\"") == true)
	{
		
   
    


	
	


   
      
   
/* ExternalCallAction - START */
 	{ //this scope is needed if the same service is called multiple times in one SEFF. Otherwise there is a duplicate local variable definition.

		    
	
	
	
	// Start Simulate an external call
	try{
	de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object> currentFrame = ctx.getStack().currentStackFrame();
	// prepare stackframe
	de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object> stackframe = ctx.getStack().createAndPushNewStackFrame();
	 

	
		
	
	// Start a response time measurement
	long startTimeCall_IBRSSystem_logout3__Component__WebServer3__AssemblyCtx____this_assemblyContextID____CallID___T3QcgFhJEd6UHd_VhJH9SQ3_ = de.uka.ipd.sdq.prototype.framework.AbstractMain.takeStartTimeForInnerMeasurement();
	
 
			
	de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object> callResult =	


   	myContext.getRoleRequired_IBRSSystem_WebServer().logout3 
	   	(
	ctx
);
	
	
	// Stop the time measurement
	
		
	
	// Stop the response time measurement
	de.uka.ipd.sdq.prototype.framework.AbstractMain.takeMeasurement(startTimeCall_IBRSSystem_logout3__Component__WebServer3__AssemblyCtx____this_assemblyContextID____CallID___T3QcgFhJEd6UHd_VhJH9SQ3_, expRun, tssCall_IBRSSystem_logout3__Component__WebServer3__AssemblyCtx____this_assemblyContextID____CallID___T3QcgFhJEd6UHd_VhJH9SQ3_);
	

			

	 
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


   
      
   
	

 
  
   
    
	
	// Stop the response time measurement
	de.uka.ipd.sdq.prototype.framework.AbstractMain.takeMeasurement(startTimeSEFF_IHTTP_processLoginLogout0__Component__WebServer3__AssemblyCtx____this_assemblyContextID___, expRun, tssSEFF_IHTTP_processLoginLogout0__Component__WebServer3__AssemblyCtx____this_assemblyContextID___);
	

   
  
 


	
	
	return resultStackFrame;
	


   

   

   
      
    	
   	  
   	  /*PROTECTED REGION END*/
   }   

   public 
	
   de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object>

      iHTTP_processGraphicalReport1
         (
	de.uka.ipd.sdq.simucomframework.variables.StackContext ctx
)

   { 
      /*PROTECTED REGION ID(processGraphicalReport1__6bAEENo5EdyCSNQKlT1LxA3__36kHoNo5EdyCSNQKlT1LxA) START*/
   	  
   	  	
	      
   
    

 
  
   
    // measure time for SEFF  
    
	
	// Start a response time measurement
	long startTimeSEFF_IHTTP_processGraphicalReport1__Component__WebServer3__AssemblyCtx____this_assemblyContextID___ = de.uka.ipd.sdq.prototype.framework.AbstractMain.takeStartTimeForInnerMeasurement();
	

   
  
 


	
	
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
      double demand = (Double) ctx.evaluate("0.5",Double.class);
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
	
		
			
				
					stackframe.addValue("isDetailed.VALUE",
					   	ctx.evaluate("isDetailed.VALUE",currentFrame));
				
			
		
	
		
			
				
					stackframe.addValue("requestedEntries.VALUE",
					   	ctx.evaluate("requestedEntries.VALUE",currentFrame));
				
			
		
	
		
			
				
					stackframe.addValue("type.VALUE",
					   	ctx.evaluate("\"graphical\"",currentFrame));
				
			
		
	 

	
		
	
	// Start a response time measurement
	long startTimeCall_IBRSSystem_report0__Component__WebServer3__AssemblyCtx____this_assemblyContextID____CallID___l5Vm8F6hEd6D97fyAyMq6A3_ = de.uka.ipd.sdq.prototype.framework.AbstractMain.takeStartTimeForInnerMeasurement();
	
 
			
	de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object> callResult =	


   	myContext.getRoleRequired_IBRSSystem_WebServer().report0 
	   	(
	ctx
);
	
	
	// Stop the time measurement
	
		
	
	// Stop the response time measurement
	de.uka.ipd.sdq.prototype.framework.AbstractMain.takeMeasurement(startTimeCall_IBRSSystem_report0__Component__WebServer3__AssemblyCtx____this_assemblyContextID____CallID___l5Vm8F6hEd6D97fyAyMq6A3_, expRun, tssCall_IBRSSystem_report0__Component__WebServer3__AssemblyCtx____this_assemblyContextID____CallID___l5Vm8F6hEd6D97fyAyMq6A3_);
	

			

	 
	}
	finally
	{
		
 	ctx.getStack().removeStackFrame();

	}
	// END Simulate an external call



		    	
	}
/* ExternalCallAction - END */

   
      
   
	

 
  
   
    
	
	// Stop the response time measurement
	de.uka.ipd.sdq.prototype.framework.AbstractMain.takeMeasurement(startTimeSEFF_IHTTP_processGraphicalReport1__Component__WebServer3__AssemblyCtx____this_assemblyContextID___, expRun, tssSEFF_IHTTP_processGraphicalReport1__Component__WebServer3__AssemblyCtx____this_assemblyContextID___);
	

   
  
 


	
	
	return resultStackFrame;
	


   

   

   

   
      
    	
   	  
   	  /*PROTECTED REGION END*/
   }   

   public 
	
   de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object>

      iHTTP_processOnlineReport2
         (
	de.uka.ipd.sdq.simucomframework.variables.StackContext ctx
)

   { 
      /*PROTECTED REGION ID(processOnlineReport2__6bAEENo5EdyCSNQKlT1LxA3__36kHoNo5EdyCSNQKlT1LxA) START*/
   	  
   	  	
	      
   
    

 
  
   
    // measure time for SEFF  
    
	
	// Start a response time measurement
	long startTimeSEFF_IHTTP_processOnlineReport2__Component__WebServer3__AssemblyCtx____this_assemblyContextID___ = de.uka.ipd.sdq.prototype.framework.AbstractMain.takeStartTimeForInnerMeasurement();
	

   
  
 


	
	
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
      double demand = (Double) ctx.evaluate("0.5",Double.class);
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
	
		
			
				
					stackframe.addValue("isDetailed.VALUE",
					   	ctx.evaluate("isDetailed.VALUE",currentFrame));
				
			
		
	
		
			
				
					stackframe.addValue("requestedEntries.VALUE",
					   	ctx.evaluate("requestedEntries.VALUE",currentFrame));
				
			
		
	
		
			
				
					stackframe.addValue("type.VALUE",
					   	ctx.evaluate("\"online\"",currentFrame));
				
			
		
	 

	
		
	
	// Start a response time measurement
	long startTimeCall_IBRSSystem_report0__Component__WebServer3__AssemblyCtx____this_assemblyContextID____CallID___L8754F6iEd6D97fyAyMq6A3_ = de.uka.ipd.sdq.prototype.framework.AbstractMain.takeStartTimeForInnerMeasurement();
	
 
			
	de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object> callResult =	


   	myContext.getRoleRequired_IBRSSystem_WebServer().report0 
	   	(
	ctx
);
	
	
	// Stop the time measurement
	
		
	
	// Stop the response time measurement
	de.uka.ipd.sdq.prototype.framework.AbstractMain.takeMeasurement(startTimeCall_IBRSSystem_report0__Component__WebServer3__AssemblyCtx____this_assemblyContextID____CallID___L8754F6iEd6D97fyAyMq6A3_, expRun, tssCall_IBRSSystem_report0__Component__WebServer3__AssemblyCtx____this_assemblyContextID____CallID___L8754F6iEd6D97fyAyMq6A3_);
	

			

	 
	}
	finally
	{
		
 	ctx.getStack().removeStackFrame();

	}
	// END Simulate an external call



		    	
	}
/* ExternalCallAction - END */

   
      
   
	

 
  
   
    
	
	// Stop the response time measurement
	de.uka.ipd.sdq.prototype.framework.AbstractMain.takeMeasurement(startTimeSEFF_IHTTP_processOnlineReport2__Component__WebServer3__AssemblyCtx____this_assemblyContextID___, expRun, tssSEFF_IHTTP_processOnlineReport2__Component__WebServer3__AssemblyCtx____this_assemblyContextID___);
	

   
  
 


	
	
	return resultStackFrame;
	


   

   

   

   
      
    	
   	  
   	  /*PROTECTED REGION END*/
   }   

   public 
	
   de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object>

      iHTTP_processGraphicalView3
         (
	de.uka.ipd.sdq.simucomframework.variables.StackContext ctx
)

   { 
      /*PROTECTED REGION ID(processGraphicalView3__6bAEENo5EdyCSNQKlT1LxA3__36kHoNo5EdyCSNQKlT1LxA) START*/
   	  
   	  	
	      
   
    

 
  
   
    // measure time for SEFF  
    
	
	// Start a response time measurement
	long startTimeSEFF_IHTTP_processGraphicalView3__Component__WebServer3__AssemblyCtx____this_assemblyContextID___ = de.uka.ipd.sdq.prototype.framework.AbstractMain.takeStartTimeForInnerMeasurement();
	

   
  
 


	
	
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
      double demand = (Double) ctx.evaluate("0.04",Double.class);
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
	
		
			
				
					stackframe.addValue("type.VALUE",
					   	ctx.evaluate("\"graphical\"  ",currentFrame));
				
			
		
	 

	
		
	
	// Start a response time measurement
	long startTimeCall_IBRSSystem_view1__Component__WebServer3__AssemblyCtx____this_assemblyContextID____CallID___NtSaEGyAEd68zLmG_5OTdQ3_ = de.uka.ipd.sdq.prototype.framework.AbstractMain.takeStartTimeForInnerMeasurement();
	
 
			
	de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object> callResult =	


   	myContext.getRoleRequired_IBRSSystem_WebServer().view1 
	   	(
	ctx
);
	
	
	// Stop the time measurement
	
		
	
	// Stop the response time measurement
	de.uka.ipd.sdq.prototype.framework.AbstractMain.takeMeasurement(startTimeCall_IBRSSystem_view1__Component__WebServer3__AssemblyCtx____this_assemblyContextID____CallID___NtSaEGyAEd68zLmG_5OTdQ3_, expRun, tssCall_IBRSSystem_view1__Component__WebServer3__AssemblyCtx____this_assemblyContextID____CallID___NtSaEGyAEd68zLmG_5OTdQ3_);
	

			

	 
	}
	finally
	{
		
 	ctx.getStack().removeStackFrame();

	}
	// END Simulate an external call



		    	
	}
/* ExternalCallAction - END */

   
      
   
	

 
  
   
    
	
	// Stop the response time measurement
	de.uka.ipd.sdq.prototype.framework.AbstractMain.takeMeasurement(startTimeSEFF_IHTTP_processGraphicalView3__Component__WebServer3__AssemblyCtx____this_assemblyContextID___, expRun, tssSEFF_IHTTP_processGraphicalView3__Component__WebServer3__AssemblyCtx____this_assemblyContextID___);
	

   
  
 


	
	
	return resultStackFrame;
	


   

   

   

   
      
    	
   	  
   	  /*PROTECTED REGION END*/
   }   

   public 
	
   de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object>

      iHTTP_processOnlineView4
         (
	de.uka.ipd.sdq.simucomframework.variables.StackContext ctx
)

   { 
      /*PROTECTED REGION ID(processOnlineView4__6bAEENo5EdyCSNQKlT1LxA3__36kHoNo5EdyCSNQKlT1LxA) START*/
   	  
   	  	
	      
   
    

 
  
   
    // measure time for SEFF  
    
	
	// Start a response time measurement
	long startTimeSEFF_IHTTP_processOnlineView4__Component__WebServer3__AssemblyCtx____this_assemblyContextID___ = de.uka.ipd.sdq.prototype.framework.AbstractMain.takeStartTimeForInnerMeasurement();
	

   
  
 


	
	
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
      double demand = (Double) ctx.evaluate("0.04",Double.class);
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
	
		
			
				
					stackframe.addValue("type.VALUE",
					   	ctx.evaluate("\"online\"",currentFrame));
				
			
		
	 

	
		
	
	// Start a response time measurement
	long startTimeCall_IBRSSystem_view1__Component__WebServer3__AssemblyCtx____this_assemblyContextID____CallID___ThqzgGyAEd68zLmG_5OTdQ3_ = de.uka.ipd.sdq.prototype.framework.AbstractMain.takeStartTimeForInnerMeasurement();
	
 
			
	de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object> callResult =	


   	myContext.getRoleRequired_IBRSSystem_WebServer().view1 
	   	(
	ctx
);
	
	
	// Stop the time measurement
	
		
	
	// Stop the response time measurement
	de.uka.ipd.sdq.prototype.framework.AbstractMain.takeMeasurement(startTimeCall_IBRSSystem_view1__Component__WebServer3__AssemblyCtx____this_assemblyContextID____CallID___ThqzgGyAEd68zLmG_5OTdQ3_, expRun, tssCall_IBRSSystem_view1__Component__WebServer3__AssemblyCtx____this_assemblyContextID____CallID___ThqzgGyAEd68zLmG_5OTdQ3_);
	

			

	 
	}
	finally
	{
		
 	ctx.getStack().removeStackFrame();

	}
	// END Simulate an external call



		    	
	}
/* ExternalCallAction - END */

   
      
   
	

 
  
   
    
	
	// Stop the response time measurement
	de.uka.ipd.sdq.prototype.framework.AbstractMain.takeMeasurement(startTimeSEFF_IHTTP_processOnlineView4__Component__WebServer3__AssemblyCtx____this_assemblyContextID___, expRun, tssSEFF_IHTTP_processOnlineView4__Component__WebServer3__AssemblyCtx____this_assemblyContextID___);
	

   
  
 


	
	
	return resultStackFrame;
	


   

   

   

   
      
    	
   	  
   	  /*PROTECTED REGION END*/
   }   


		  
	
	// Component Parameter Defaults
	// TODO: The stackframes are not yet initialised by calling setComponentFrame in Protocom, thus initialise them here, too
	protected de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object> myDefaultComponentStackFrame = new de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object>();

	// Component Parameter setter
	// TODO: The stackframes are not yet initialised by calling setComponentFrame in Protocom, thus initialise them here, too
	protected de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object> myComponentStackFrame = new de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object>();
	
	public void setComponentFrame(de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object> myComponentStackFrame) {
		this.myComponentStackFrame = myComponentStackFrame;	
		this.myDefaultComponentStackFrame = new de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object>();
		
			
		
	}


	   }
	   
	
	
		

		
 

	