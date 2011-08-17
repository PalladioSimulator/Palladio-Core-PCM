
	   
	

	   package brs_repository.impl;
	      
	   
public class OnlineReporting

	   

	   implements brs_repository.impl.IOnlineReporting
	   {
	   	  
    

	//TODO: pass the assembly context id to here as it is done for the simulation. 
	String assemblyContextID = ""; 
	
	
    de.uka.ipd.sdq.sensorframework.entities.TimeSpanSensor tssCall_IReporting_getReport0__Component__OnlineReporting__AssemblyCtx____this_assemblyContextID____CallID___hwDx4FelEd6zR8NNmb_sJg_;

    de.uka.ipd.sdq.sensorframework.entities.TimeSpanSensor tssCall_IReporting_getView1__Component__OnlineReporting__AssemblyCtx____this_assemblyContextID____CallID___YUt40FelEd6zR8NNmb_sJg_;

    de.uka.ipd.sdq.sensorframework.entities.TimeSpanSensor tssCall_IReporting_finishView3__Component__OnlineReporting__AssemblyCtx____this_assemblyContextID____CallID___AoYV0F85Ed6_caU7WM0FRw_;

    de.uka.ipd.sdq.sensorframework.entities.TimeSpanSensor tssCall_IReporting_prepareView2__Component__OnlineReporting__AssemblyCtx____this_assemblyContextID____CallID___AOTB4F85Ed6_caU7WM0FRw_;

	
  
  de.uka.ipd.sdq.sensorframework.entities.TimeSpanSensor tssSEFF_IOnlineReport_onlineReport0__Component__OnlineReporting__AssemblyCtx____this_assemblyContextID___;

  de.uka.ipd.sdq.sensorframework.entities.TimeSpanSensor tssSEFF_IOnlineReport_viewOnline1__Component__OnlineReporting__AssemblyCtx____this_assemblyContextID___;


	
	de.uka.ipd.sdq.sensorframework.entities.ExperimentRun expRun;
	
	public OnlineReporting(){

		expRun = de.uka.ipd.sdq.prototype.framework.AbstractMain.getLatestExperimentRun();
		
		

        tssCall_IReporting_getReport0__Component__OnlineReporting__AssemblyCtx____this_assemblyContextID____CallID___hwDx4FelEd6zR8NNmb_sJg_ 
            = de.uka.ipd.sdq.prototype.framework.AbstractMain.createOrReuseTimeSpanSensor(
                "Call IReporting.getReport0 <Component: OnlineReporting, AssemblyCtx: "+this.assemblyContextID+", CallID: _hwDx4FelEd6zR8NNmb-sJg>"
            );



        tssCall_IReporting_getView1__Component__OnlineReporting__AssemblyCtx____this_assemblyContextID____CallID___YUt40FelEd6zR8NNmb_sJg_ 
            = de.uka.ipd.sdq.prototype.framework.AbstractMain.createOrReuseTimeSpanSensor(
                "Call IReporting.getView1 <Component: OnlineReporting, AssemblyCtx: "+this.assemblyContextID+", CallID: _YUt40FelEd6zR8NNmb-sJg>"
            );



        tssCall_IReporting_finishView3__Component__OnlineReporting__AssemblyCtx____this_assemblyContextID____CallID___AoYV0F85Ed6_caU7WM0FRw_ 
            = de.uka.ipd.sdq.prototype.framework.AbstractMain.createOrReuseTimeSpanSensor(
                "Call IReporting.finishView3 <Component: OnlineReporting, AssemblyCtx: "+this.assemblyContextID+", CallID: _AoYV0F85Ed6-caU7WM0FRw>"
            );



        tssCall_IReporting_prepareView2__Component__OnlineReporting__AssemblyCtx____this_assemblyContextID____CallID___AOTB4F85Ed6_caU7WM0FRw_ 
            = de.uka.ipd.sdq.prototype.framework.AbstractMain.createOrReuseTimeSpanSensor(
                "Call IReporting.prepareView2 <Component: OnlineReporting, AssemblyCtx: "+this.assemblyContextID+", CallID: _AOTB4F85Ed6-caU7WM0FRw>"
            );


		
		
  
        tssSEFF_IOnlineReport_onlineReport0__Component__OnlineReporting__AssemblyCtx____this_assemblyContextID___ 
            = de.uka.ipd.sdq.prototype.framework.AbstractMain.createOrReuseTimeSpanSensor(
                "SEFF IOnlineReport.onlineReport0 <Component: OnlineReporting, AssemblyCtx: "+this.assemblyContextID+">"
            );

        tssSEFF_IOnlineReport_viewOnline1__Component__OnlineReporting__AssemblyCtx____this_assemblyContextID___ 
            = de.uka.ipd.sdq.prototype.framework.AbstractMain.createOrReuseTimeSpanSensor(
                "SEFF IOnlineReport.viewOnline1 <Component: OnlineReporting, AssemblyCtx: "+this.assemblyContextID+">"
            );


		
		//FIXME: quick fix to initialise component params as setComponentFrame is not called by system for ejbs.
		this.setComponentFrame(this.myComponentStackFrame);
		
	}


 
	      
	
    

   	
    protected brs_repository.impl.ports.IOnlineReport_OnlineReporting m_portProvided_IReporting_OnlineReporting = new brs_repository.impl.ports.IOnlineReport_OnlineReporting(this);

   	
   public brs_repository.IOnlineReport getPortProvided_IReporting_OnlineReporting () {
      return m_portProvided_IReporting_OnlineReporting;
   }


	      
   
   

   
   

   
   protected brs_repository.impl.contexts.IOnlineReportingContext myContext = null;

   
   public void setContext(brs_repository.impl.contexts.IOnlineReportingContext myContext) {
      this.myContext = myContext;
      
   }


	      
	
   public 
	
   de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object>

      iOnlineReport_onlineReport0
         (
	de.uka.ipd.sdq.simucomframework.variables.StackContext ctx
)

   { 
      /*PROTECTED REGION ID(onlineReport0__M0cTkFelEd6zR8NNmb-sJg__pRP18FemEd6zR8NNmb-sJg) START*/
   	  
   	  	
	      
   
    

 
  
   
    // measure time for SEFF  
    
	
	// Start a response time measurement
	long startTimeSEFF_IOnlineReport_onlineReport0__Component__OnlineReporting__AssemblyCtx____this_assemblyContextID___ = de.uka.ipd.sdq.prototype.framework.AbstractMain.takeStartTimeForInnerMeasurement();
	

   
  
 


	
	
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
	long startTimeCall_IReporting_getReport0__Component__OnlineReporting__AssemblyCtx____this_assemblyContextID____CallID___hwDx4FelEd6zR8NNmb_sJg_ = de.uka.ipd.sdq.prototype.framework.AbstractMain.takeStartTimeForInnerMeasurement();
	
 
			
	de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object> callResult =	


   	myContext.getRoleRequired_IReporting_OnlineReporting().getReport0 
	   	(
	ctx
);
	
	
	// Stop the time measurement
	
		
	
	// Stop the response time measurement
	de.uka.ipd.sdq.prototype.framework.AbstractMain.takeMeasurement(startTimeCall_IReporting_getReport0__Component__OnlineReporting__AssemblyCtx____this_assemblyContextID____CallID___hwDx4FelEd6zR8NNmb_sJg_, expRun, tssCall_IReporting_getReport0__Component__OnlineReporting__AssemblyCtx____this_assemblyContextID____CallID___hwDx4FelEd6zR8NNmb_sJg_);
	

			

	 
	}
	finally
	{
		
 	ctx.getStack().removeStackFrame();

	}
	// END Simulate an external call



		    	
	}
/* ExternalCallAction - END */

   
      
   
	

 
  
   
    
	
	// Stop the response time measurement
	de.uka.ipd.sdq.prototype.framework.AbstractMain.takeMeasurement(startTimeSEFF_IOnlineReport_onlineReport0__Component__OnlineReporting__AssemblyCtx____this_assemblyContextID___, expRun, tssSEFF_IOnlineReport_onlineReport0__Component__OnlineReporting__AssemblyCtx____this_assemblyContextID___);
	

   
  
 


	
	
	return resultStackFrame;
	


   

   

   

   
      
    	
   	  
   	  /*PROTECTED REGION END*/
   }   

   public 
	
   de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object>

      iOnlineReport_viewOnline1
         (
	de.uka.ipd.sdq.simucomframework.variables.StackContext ctx
)

   { 
      /*PROTECTED REGION ID(viewOnline1__M0cTkFelEd6zR8NNmb-sJg__pRP18FemEd6zR8NNmb-sJg) START*/
   	  
   	  	
	      
   
    

 
  
   
    // measure time for SEFF  
    
	
	// Start a response time measurement
	long startTimeSEFF_IOnlineReport_viewOnline1__Component__OnlineReporting__AssemblyCtx____this_assemblyContextID___ = de.uka.ipd.sdq.prototype.framework.AbstractMain.takeStartTimeForInnerMeasurement();
	

   
  
 


	
	
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




   
      
   
	
   for (int iterationCount_JOYwEF8_Ed6_caU7WM0FRw = 0, maxIterationCount_JOYwEF8_Ed6_caU7WM0FRw = (Integer)ctx.evaluate("3",Integer.class); 
            iterationCount_JOYwEF8_Ed6_caU7WM0FRw < maxIterationCount_JOYwEF8_Ed6_caU7WM0FRw; iterationCount_JOYwEF8_Ed6_caU7WM0FRw++){
       
   
    


	
	


   
      
   
/* ExternalCallAction - START */
 	{ //this scope is needed if the same service is called multiple times in one SEFF. Otherwise there is a duplicate local variable definition.

		    
	
	
	
	// Start Simulate an external call
	try{
	de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object> currentFrame = ctx.getStack().currentStackFrame();
	// prepare stackframe
	de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object> stackframe = ctx.getStack().createAndPushNewStackFrame();
	
		
			
				
					stackframe.addValue("info.BYTESIZE",
					   	ctx.evaluate("64+20  ",currentFrame));
				
			
		
	 

	
		
	
	// Start a response time measurement
	long startTimeCall_IReporting_prepareView2__Component__OnlineReporting__AssemblyCtx____this_assemblyContextID____CallID___AOTB4F85Ed6_caU7WM0FRw_ = de.uka.ipd.sdq.prototype.framework.AbstractMain.takeStartTimeForInnerMeasurement();
	
 
			
	de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object> callResult =	


   	myContext.getRoleRequired_IReporting_OnlineReporting().prepareView2 
	   	(
	ctx
);
	
	
	// Stop the time measurement
	
		
	
	// Stop the response time measurement
	de.uka.ipd.sdq.prototype.framework.AbstractMain.takeMeasurement(startTimeCall_IReporting_prepareView2__Component__OnlineReporting__AssemblyCtx____this_assemblyContextID____CallID___AOTB4F85Ed6_caU7WM0FRw_, expRun, tssCall_IReporting_prepareView2__Component__OnlineReporting__AssemblyCtx____this_assemblyContextID____CallID___AOTB4F85Ed6_caU7WM0FRw_);
	

			

	 
	}
	finally
	{
		
 	ctx.getStack().removeStackFrame();

	}
	// END Simulate an external call



		    	
	}
/* ExternalCallAction - END */

   
      
   
	


	
	


   

   

   

   } 


   
      
   
/* ExternalCallAction - START */
 	{ //this scope is needed if the same service is called multiple times in one SEFF. Otherwise there is a duplicate local variable definition.

		    
	
	
	
	// Start Simulate an external call
	try{
	de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object> currentFrame = ctx.getStack().currentStackFrame();
	// prepare stackframe
	de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object> stackframe = ctx.getStack().createAndPushNewStackFrame();
	 

	
		
	
	// Start a response time measurement
	long startTimeCall_IReporting_getView1__Component__OnlineReporting__AssemblyCtx____this_assemblyContextID____CallID___YUt40FelEd6zR8NNmb_sJg_ = de.uka.ipd.sdq.prototype.framework.AbstractMain.takeStartTimeForInnerMeasurement();
	
 
			
	de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object> callResult =	


   	myContext.getRoleRequired_IReporting_OnlineReporting().getView1 
	   	(
	ctx
);
	
	
	// Stop the time measurement
	
		
	
	// Stop the response time measurement
	de.uka.ipd.sdq.prototype.framework.AbstractMain.takeMeasurement(startTimeCall_IReporting_getView1__Component__OnlineReporting__AssemblyCtx____this_assemblyContextID____CallID___YUt40FelEd6zR8NNmb_sJg_, expRun, tssCall_IReporting_getView1__Component__OnlineReporting__AssemblyCtx____this_assemblyContextID____CallID___YUt40FelEd6zR8NNmb_sJg_);
	

			

	 
	}
	finally
	{
		
 	ctx.getStack().removeStackFrame();

	}
	// END Simulate an external call



		    	
	}
/* ExternalCallAction - END */

   
      
   
	
   for (int iterationCount_KfvqQF8_Ed6_caU7WM0FRw = 0, maxIterationCount_KfvqQF8_Ed6_caU7WM0FRw = (Integer)ctx.evaluate("3",Integer.class); 
            iterationCount_KfvqQF8_Ed6_caU7WM0FRw < maxIterationCount_KfvqQF8_Ed6_caU7WM0FRw; iterationCount_KfvqQF8_Ed6_caU7WM0FRw++){
       
   
    


	
	


   
      
   
/* ExternalCallAction - START */
 	{ //this scope is needed if the same service is called multiple times in one SEFF. Otherwise there is a duplicate local variable definition.

		    
	
	
	
	// Start Simulate an external call
	try{
	de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object> currentFrame = ctx.getStack().currentStackFrame();
	// prepare stackframe
	de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object> stackframe = ctx.getStack().createAndPushNewStackFrame();
	
		
			
				
					stackframe.addValue("status.BYTESIZE",
					   	ctx.evaluate("16+20",currentFrame));
				
			
		
	 

	
		
	
	// Start a response time measurement
	long startTimeCall_IReporting_finishView3__Component__OnlineReporting__AssemblyCtx____this_assemblyContextID____CallID___AoYV0F85Ed6_caU7WM0FRw_ = de.uka.ipd.sdq.prototype.framework.AbstractMain.takeStartTimeForInnerMeasurement();
	
 
			
	de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object> callResult =	


   	myContext.getRoleRequired_IReporting_OnlineReporting().finishView3 
	   	(
	ctx
);
	
	
	// Stop the time measurement
	
		
	
	// Stop the response time measurement
	de.uka.ipd.sdq.prototype.framework.AbstractMain.takeMeasurement(startTimeCall_IReporting_finishView3__Component__OnlineReporting__AssemblyCtx____this_assemblyContextID____CallID___AoYV0F85Ed6_caU7WM0FRw_, expRun, tssCall_IReporting_finishView3__Component__OnlineReporting__AssemblyCtx____this_assemblyContextID____CallID___AoYV0F85Ed6_caU7WM0FRw_);
	

			

	 
	}
	finally
	{
		
 	ctx.getStack().removeStackFrame();

	}
	// END Simulate an external call



		    	
	}
/* ExternalCallAction - END */

   
      
   
	


	
	


   

   

   

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




   
      
   
	

 
  
   
    
	
	// Stop the response time measurement
	de.uka.ipd.sdq.prototype.framework.AbstractMain.takeMeasurement(startTimeSEFF_IOnlineReport_viewOnline1__Component__OnlineReporting__AssemblyCtx____this_assemblyContextID___, expRun, tssSEFF_IOnlineReport_viewOnline1__Component__OnlineReporting__AssemblyCtx____this_assemblyContextID___);
	

   
  
 


	
	
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
	   
	
	
		

		
 

	