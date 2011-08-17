
	   
	

	   package brs_repository.impl;
	      
	   
public class InnerCoreReportingEngine

	   

	   implements brs_repository.impl.IInnerCoreReportingEngine
	   {
	   	  
    

	//TODO: pass the assembly context id to here as it is done for the simulation. 
	String assemblyContextID = ""; 
	
	
    de.uka.ipd.sdq.sensorframework.entities.TimeSpanSensor tssCall_IInnerDB_getSmallReportInner0__Component__InnerCoreReportingEngine__AssemblyCtx____this_assemblyContextID____CallID___C0EQMPZnEdySh74qedEhsw_;

    de.uka.ipd.sdq.sensorframework.entities.TimeSpanSensor tssCall_IInnerDB_getBigReportInner1__Component__InnerCoreReportingEngine__AssemblyCtx____this_assemblyContextID____CallID___F113wPZqEdyw3N2eyRVO6Q_;

    de.uka.ipd.sdq.sensorframework.entities.TimeSpanSensor tssCall_ICache_doCacheAccess0__Component__InnerCoreReportingEngine__AssemblyCtx____this_assemblyContextID____CallID___hxjsUNo9EdyxgfK4Hy_RFA_;

    de.uka.ipd.sdq.sensorframework.entities.TimeSpanSensor tssCall_ICache_doCacheAccess0__Component__InnerCoreReportingEngine__AssemblyCtx____this_assemblyContextID____CallID___Lhg8QNo_EdyxgfK4Hy_RFA_;

	
  
  de.uka.ipd.sdq.sensorframework.entities.TimeSpanSensor tssSEFF_IReporting_getReport0__Component__InnerCoreReportingEngine__AssemblyCtx____this_assemblyContextID___;

  de.uka.ipd.sdq.sensorframework.entities.TimeSpanSensor tssSEFF_IReporting_getView1__Component__InnerCoreReportingEngine__AssemblyCtx____this_assemblyContextID___;

  de.uka.ipd.sdq.sensorframework.entities.TimeSpanSensor tssSEFF_IReporting_prepareView2__Component__InnerCoreReportingEngine__AssemblyCtx____this_assemblyContextID___;

  de.uka.ipd.sdq.sensorframework.entities.TimeSpanSensor tssSEFF_IReporting_finishView3__Component__InnerCoreReportingEngine__AssemblyCtx____this_assemblyContextID___;


  
  de.uka.ipd.sdq.sensorframework.entities.TimeSpanSensor tssSEFF_IAdmin_maintain0__Component__InnerCoreReportingEngine__AssemblyCtx____this_assemblyContextID___;


	
	de.uka.ipd.sdq.sensorframework.entities.ExperimentRun expRun;
	
	public InnerCoreReportingEngine(){

		expRun = de.uka.ipd.sdq.prototype.framework.AbstractMain.getLatestExperimentRun();
		
		

        tssCall_IInnerDB_getSmallReportInner0__Component__InnerCoreReportingEngine__AssemblyCtx____this_assemblyContextID____CallID___C0EQMPZnEdySh74qedEhsw_ 
            = de.uka.ipd.sdq.prototype.framework.AbstractMain.createOrReuseTimeSpanSensor(
                "Call IInnerDB.getSmallReportInner0 <Component: InnerCoreReportingEngine, AssemblyCtx: "+this.assemblyContextID+", CallID: _C0EQMPZnEdySh74qedEhsw>"
            );



        tssCall_IInnerDB_getBigReportInner1__Component__InnerCoreReportingEngine__AssemblyCtx____this_assemblyContextID____CallID___F113wPZqEdyw3N2eyRVO6Q_ 
            = de.uka.ipd.sdq.prototype.framework.AbstractMain.createOrReuseTimeSpanSensor(
                "Call IInnerDB.getBigReportInner1 <Component: InnerCoreReportingEngine, AssemblyCtx: "+this.assemblyContextID+", CallID: _F113wPZqEdyw3N2eyRVO6Q>"
            );



        tssCall_ICache_doCacheAccess0__Component__InnerCoreReportingEngine__AssemblyCtx____this_assemblyContextID____CallID___hxjsUNo9EdyxgfK4Hy_RFA_ 
            = de.uka.ipd.sdq.prototype.framework.AbstractMain.createOrReuseTimeSpanSensor(
                "Call ICache.doCacheAccess0 <Component: InnerCoreReportingEngine, AssemblyCtx: "+this.assemblyContextID+", CallID: _hxjsUNo9EdyxgfK4Hy_RFA>"
            );



        tssCall_ICache_doCacheAccess0__Component__InnerCoreReportingEngine__AssemblyCtx____this_assemblyContextID____CallID___Lhg8QNo_EdyxgfK4Hy_RFA_ 
            = de.uka.ipd.sdq.prototype.framework.AbstractMain.createOrReuseTimeSpanSensor(
                "Call ICache.doCacheAccess0 <Component: InnerCoreReportingEngine, AssemblyCtx: "+this.assemblyContextID+", CallID: _Lhg8QNo-EdyxgfK4Hy_RFA>"
            );


		
		
  
        tssSEFF_IReporting_getReport0__Component__InnerCoreReportingEngine__AssemblyCtx____this_assemblyContextID___ 
            = de.uka.ipd.sdq.prototype.framework.AbstractMain.createOrReuseTimeSpanSensor(
                "SEFF IReporting.getReport0 <Component: InnerCoreReportingEngine, AssemblyCtx: "+this.assemblyContextID+">"
            );

        tssSEFF_IReporting_getView1__Component__InnerCoreReportingEngine__AssemblyCtx____this_assemblyContextID___ 
            = de.uka.ipd.sdq.prototype.framework.AbstractMain.createOrReuseTimeSpanSensor(
                "SEFF IReporting.getView1 <Component: InnerCoreReportingEngine, AssemblyCtx: "+this.assemblyContextID+">"
            );

        tssSEFF_IReporting_prepareView2__Component__InnerCoreReportingEngine__AssemblyCtx____this_assemblyContextID___ 
            = de.uka.ipd.sdq.prototype.framework.AbstractMain.createOrReuseTimeSpanSensor(
                "SEFF IReporting.prepareView2 <Component: InnerCoreReportingEngine, AssemblyCtx: "+this.assemblyContextID+">"
            );

        tssSEFF_IReporting_finishView3__Component__InnerCoreReportingEngine__AssemblyCtx____this_assemblyContextID___ 
            = de.uka.ipd.sdq.prototype.framework.AbstractMain.createOrReuseTimeSpanSensor(
                "SEFF IReporting.finishView3 <Component: InnerCoreReportingEngine, AssemblyCtx: "+this.assemblyContextID+">"
            );


  
        tssSEFF_IAdmin_maintain0__Component__InnerCoreReportingEngine__AssemblyCtx____this_assemblyContextID___ 
            = de.uka.ipd.sdq.prototype.framework.AbstractMain.createOrReuseTimeSpanSensor(
                "SEFF IAdmin.maintain0 <Component: InnerCoreReportingEngine, AssemblyCtx: "+this.assemblyContextID+">"
            );


		
		//FIXME: quick fix to initialise component params as setComponentFrame is not called by system for ejbs.
		this.setComponentFrame(this.myComponentStackFrame);
		
	}


 
	      
	
    

    

   	
    protected brs_repository.impl.ports.IReporting_InnerCoreReportingEngine m_portProvided_IReporting_ReportingEngine = new brs_repository.impl.ports.IReporting_InnerCoreReportingEngine(this);

    protected brs_repository.impl.ports.IAdmin_InnerCoreReportingEngine m_portProvided_IAdmin_ReportingEngine = new brs_repository.impl.ports.IAdmin_InnerCoreReportingEngine(this);

   	
   public brs_repository.IReporting getPortProvided_IReporting_ReportingEngine () {
      return m_portProvided_IReporting_ReportingEngine;
   }

   public brs_repository.IAdmin getPortProvided_IAdmin_ReportingEngine () {
      return m_portProvided_IAdmin_ReportingEngine;
   }


	      
   
   

   
   

   
   protected brs_repository.impl.contexts.IInnerCoreReportingEngineContext myContext = null;

   
   public void setContext(brs_repository.impl.contexts.IInnerCoreReportingEngineContext myContext) {
      this.myContext = myContext;
      
   }


	      
	
   public 
	
   de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object>

      iReporting_getReport0
         (
	de.uka.ipd.sdq.simucomframework.variables.StackContext ctx
)

   { 
      /*PROTECTED REGION ID(getReport0__k7K64No4EdyCSNQKlT1LxA__Ebo4ANo5EdyCSNQKlT1LxA) START*/
   	  
   	  	
	      
   
    

 
  
   
    // measure time for SEFF  
    
	
	// Start a response time measurement
	long startTimeSEFF_IReporting_getReport0__Component__InnerCoreReportingEngine__AssemblyCtx____this_assemblyContextID___ = System.nanoTime();
	

   
  
 


	
	
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
      double demand = (Double) ctx.evaluate("0.1/100",Double.class);
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
		
			
				
	if ((Boolean)ctx.evaluate("isDetailed.VALUE == \"t\"") == true)
	{
		
   
    


	
	


   
      
   
	
	
	
   {
      double demand = (Double) ctx.evaluate("(DoublePDF[(0.3;0.3)(0.31;0.3)(0.32;0.3)(0.33;0.1)])/10/100  ",Double.class);
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
	
		
			
				
					stackframe.addValue("noOfEntries.VALUE",
					   	ctx.evaluate("requestedEntries.VALUE",currentFrame));
				
			
		
	 

	
		
	
	// Start a response time measurement
	long startTimeCall_IInnerDB_getBigReportInner1__Component__InnerCoreReportingEngine__AssemblyCtx____this_assemblyContextID____CallID___F113wPZqEdyw3N2eyRVO6Q_ = System.nanoTime();
	
 
			
	de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object> callResult =	


   	myContext.getRoleRequired_IInnerDB_ReportingEngine().getBigReportInner1 
	   	(
	ctx
);
	
	
	// Stop the time measurement
	
		
	
	// Stop the response time measurement
	de.uka.ipd.sdq.prototype.framework.AbstractMain.takeMeasurement(startTimeCall_IInnerDB_getBigReportInner1__Component__InnerCoreReportingEngine__AssemblyCtx____this_assemblyContextID____CallID___F113wPZqEdyw3N2eyRVO6Q_, expRun, tssCall_IInnerDB_getBigReportInner1__Component__InnerCoreReportingEngine__AssemblyCtx____this_assemblyContextID____CallID___F113wPZqEdyw3N2eyRVO6Q_);
	

			

	 
	}
	finally
	{
		
 	ctx.getStack().removeStackFrame();

	}
	// END Simulate an external call



		    	
	}
/* ExternalCallAction - END */

   
      
   
	
	
	
   {
      double demand = (Double) ctx.evaluate("(DoublePDF[(0.24;0.3)(0.25;0.4)(0.26;0.3)])/10/100",Double.class);
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




   
      
   
	
   for (int iterationCount_0owb09o9EdyxgfK4Hy_RFA = 0, maxIterationCount_0owb09o9EdyxgfK4Hy_RFA = (Integer)ctx.evaluate("2",Integer.class); 
            iterationCount_0owb09o9EdyxgfK4Hy_RFA < maxIterationCount_0owb09o9EdyxgfK4Hy_RFA; iterationCount_0owb09o9EdyxgfK4Hy_RFA++){
       
   
    


	
	


   
      
   
/* ExternalCallAction - START */
 	{ //this scope is needed if the same service is called multiple times in one SEFF. Otherwise there is a duplicate local variable definition.

		    
	
	
	
	// Start Simulate an external call
	try{
	de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object> currentFrame = ctx.getStack().currentStackFrame();
	// prepare stackframe
	de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object> stackframe = ctx.getStack().createAndPushNewStackFrame();
	 

	
		
	
	// Start a response time measurement
	long startTimeCall_ICache_doCacheAccess0__Component__InnerCoreReportingEngine__AssemblyCtx____this_assemblyContextID____CallID___hxjsUNo9EdyxgfK4Hy_RFA_ = System.nanoTime();
	
 
			
	de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object> callResult =	


   	myContext.getRoleRequired_ICache_ReportingEngine().doCacheAccess0 
	   	(
	ctx
);
	
	
	// Stop the time measurement
	
		
	
	// Stop the response time measurement
	de.uka.ipd.sdq.prototype.framework.AbstractMain.takeMeasurement(startTimeCall_ICache_doCacheAccess0__Component__InnerCoreReportingEngine__AssemblyCtx____this_assemblyContextID____CallID___hxjsUNo9EdyxgfK4Hy_RFA_, expRun, tssCall_ICache_doCacheAccess0__Component__InnerCoreReportingEngine__AssemblyCtx____this_assemblyContextID____CallID___hxjsUNo9EdyxgfK4Hy_RFA_);
	

			

	 
	}
	finally
	{
		
 	ctx.getStack().removeStackFrame();

	}
	// END Simulate an external call



		    	
	}
/* ExternalCallAction - END */

   
      
   
	


	
	


   

   

   

   } 


   
      
   
	


	
	


   

   

   

   

   

   

	}
 else 
	if ((Boolean)ctx.evaluate("isDetailed.VALUE == \"f\"") == true)
	{
		
   
    


	
	


   
      
   
	
	
	
   {
      double demand = (Double) ctx.evaluate("(DoublePDF[(0.03;0.1)(0.05;0.9)])/20/100",Double.class);
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
	
		
			
				
					stackframe.addValue("noOfEntries.VALUE",
					   	ctx.evaluate("requestedEntries.VALUE",currentFrame));
				
			
		
	 

	
		
	
	// Start a response time measurement
	long startTimeCall_IInnerDB_getSmallReportInner0__Component__InnerCoreReportingEngine__AssemblyCtx____this_assemblyContextID____CallID___C0EQMPZnEdySh74qedEhsw_ = System.nanoTime();
	
 
			
	de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object> callResult =	


   	myContext.getRoleRequired_IInnerDB_ReportingEngine().getSmallReportInner0 
	   	(
	ctx
);
	
	
	// Stop the time measurement
	
		
	
	// Stop the response time measurement
	de.uka.ipd.sdq.prototype.framework.AbstractMain.takeMeasurement(startTimeCall_IInnerDB_getSmallReportInner0__Component__InnerCoreReportingEngine__AssemblyCtx____this_assemblyContextID____CallID___C0EQMPZnEdySh74qedEhsw_, expRun, tssCall_IInnerDB_getSmallReportInner0__Component__InnerCoreReportingEngine__AssemblyCtx____this_assemblyContextID____CallID___C0EQMPZnEdySh74qedEhsw_);
	

			

	 
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
	de.uka.ipd.sdq.prototype.framework.AbstractMain.takeMeasurement(startTimeSEFF_IReporting_getReport0__Component__InnerCoreReportingEngine__AssemblyCtx____this_assemblyContextID___, expRun, tssSEFF_IReporting_getReport0__Component__InnerCoreReportingEngine__AssemblyCtx____this_assemblyContextID___);
	

   
  
 


	
	
	return resultStackFrame;
	


   

   

   

   
      
    	
   	  
   	  /*PROTECTED REGION END*/
   }   

   public 
	
   de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object>

      iReporting_getView1
         (
	de.uka.ipd.sdq.simucomframework.variables.StackContext ctx
)

   { 
      /*PROTECTED REGION ID(getView1__k7K64No4EdyCSNQKlT1LxA__Ebo4ANo5EdyCSNQKlT1LxA) START*/
   	  
   	  	
	      
   
    

 
  
   
    // measure time for SEFF  
    
	
	// Start a response time measurement
	long startTimeSEFF_IReporting_getView1__Component__InnerCoreReportingEngine__AssemblyCtx____this_assemblyContextID___ = System.nanoTime();
	

   
  
 


	
	
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
      double demand = (Double) ctx.evaluate("(DoublePDF[(1.2;0.15)(1.3;0.4)(1.4;0.3)(1.5;0.15)]+1.2)/20/100  ",Double.class);
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
	long startTimeCall_ICache_doCacheAccess0__Component__InnerCoreReportingEngine__AssemblyCtx____this_assemblyContextID____CallID___Lhg8QNo_EdyxgfK4Hy_RFA_ = System.nanoTime();
	
 
			
	de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object> callResult =	


   	myContext.getRoleRequired_ICache_ReportingEngine().doCacheAccess0 
	   	(
	ctx
);
	
	
	// Stop the time measurement
	
		
	
	// Stop the response time measurement
	de.uka.ipd.sdq.prototype.framework.AbstractMain.takeMeasurement(startTimeCall_ICache_doCacheAccess0__Component__InnerCoreReportingEngine__AssemblyCtx____this_assemblyContextID____CallID___Lhg8QNo_EdyxgfK4Hy_RFA_, expRun, tssCall_ICache_doCacheAccess0__Component__InnerCoreReportingEngine__AssemblyCtx____this_assemblyContextID____CallID___Lhg8QNo_EdyxgfK4Hy_RFA_);
	

			

	 
	}
	finally
	{
		
 	ctx.getStack().removeStackFrame();

	}
	// END Simulate an external call



		    	
	}
/* ExternalCallAction - END */

   
      
   
	

 
  
   
    
	
	// Stop the response time measurement
	de.uka.ipd.sdq.prototype.framework.AbstractMain.takeMeasurement(startTimeSEFF_IReporting_getView1__Component__InnerCoreReportingEngine__AssemblyCtx____this_assemblyContextID___, expRun, tssSEFF_IReporting_getView1__Component__InnerCoreReportingEngine__AssemblyCtx____this_assemblyContextID___);
	

   
  
 


	
	
	return resultStackFrame;
	


   

   

   

   
      
    	
   	  
   	  /*PROTECTED REGION END*/
   }   

   public 
	
   de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object>

      iReporting_prepareView2
         (
	de.uka.ipd.sdq.simucomframework.variables.StackContext ctx
)

   { 
      /*PROTECTED REGION ID(prepareView2__k7K64No4EdyCSNQKlT1LxA__Ebo4ANo5EdyCSNQKlT1LxA) START*/
   	  
   	  	
	      
   
    

 
  
   
    // measure time for SEFF  
    
	
	// Start a response time measurement
	long startTimeSEFF_IReporting_prepareView2__Component__InnerCoreReportingEngine__AssemblyCtx____this_assemblyContextID___ = System.nanoTime();
	

   
  
 


	
	
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
	


   
      
   
	
	
		
			
				resultStackFrame.addValue("RETURN.BYTESIZE",
					ctx.evaluate("info.BYTESIZE + 100"));
			
		
	


   
      
   
	
	
	
   {
      double demand = (Double) ctx.evaluate("0.001/100",Double.class);
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
	de.uka.ipd.sdq.prototype.framework.AbstractMain.takeMeasurement(startTimeSEFF_IReporting_prepareView2__Component__InnerCoreReportingEngine__AssemblyCtx____this_assemblyContextID___, expRun, tssSEFF_IReporting_prepareView2__Component__InnerCoreReportingEngine__AssemblyCtx____this_assemblyContextID___);
	

   
  
 


	
	
	return resultStackFrame;
	


   

   

   

   
      
    	
   	  
   	  /*PROTECTED REGION END*/
   }   

   public 
	
   de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object>

      iReporting_finishView3
         (
	de.uka.ipd.sdq.simucomframework.variables.StackContext ctx
)

   { 
      /*PROTECTED REGION ID(finishView3__k7K64No4EdyCSNQKlT1LxA__Ebo4ANo5EdyCSNQKlT1LxA) START*/
   	  
   	  	
	      
   
    

 
  
   
    // measure time for SEFF  
    
	
	// Start a response time measurement
	long startTimeSEFF_IReporting_finishView3__Component__InnerCoreReportingEngine__AssemblyCtx____this_assemblyContextID___ = System.nanoTime();
	

   
  
 


	
	
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
	


   
      
   
	

 
  
   
    
	
	// Stop the response time measurement
	de.uka.ipd.sdq.prototype.framework.AbstractMain.takeMeasurement(startTimeSEFF_IReporting_finishView3__Component__InnerCoreReportingEngine__AssemblyCtx____this_assemblyContextID___, expRun, tssSEFF_IReporting_finishView3__Component__InnerCoreReportingEngine__AssemblyCtx____this_assemblyContextID___);
	

   
  
 


	
	
	return resultStackFrame;
	


   

   
      
    	
   	  
   	  /*PROTECTED REGION END*/
   }   

   public 
	
   de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object>

      iAdmin_maintain0
         (
	de.uka.ipd.sdq.simucomframework.variables.StackContext ctx
)

   { 
      /*PROTECTED REGION ID(maintain0__k7K64No4EdyCSNQKlT1LxA__MeXLUFekEd6zR8NNmb-sJg) START*/
   	  
   	  	
	      
   
    

 
  
   
    // measure time for SEFF  
    
	
	// Start a response time measurement
	long startTimeSEFF_IAdmin_maintain0__Component__InnerCoreReportingEngine__AssemblyCtx____this_assemblyContextID___ = System.nanoTime();
	

   
  
 


	
	
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
      double demand = (Double) ctx.evaluate("150/100",Double.class);
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
	de.uka.ipd.sdq.prototype.framework.AbstractMain.takeMeasurement(startTimeSEFF_IAdmin_maintain0__Component__InnerCoreReportingEngine__AssemblyCtx____this_assemblyContextID___, expRun, tssSEFF_IAdmin_maintain0__Component__InnerCoreReportingEngine__AssemblyCtx____this_assemblyContextID___);
	

   
  
 


	
	
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
	   
	
	
		

		
 

	