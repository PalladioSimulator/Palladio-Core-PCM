
	   
	

	   package brs_repository.impl;
	      
	   
public class GraphicalReporting

	   

	   implements brs_repository.impl.IGraphicalReporting
	   {
	   	  
    

	//TODO: pass the assembly context id to here as it is done for the simulation. 
	String assemblyContextID = ""; 
	
	
    de.uka.ipd.sdq.sensorframework.entities.TimeSpanSensor tssCall_IReporting_getReport0__Component__GraphicalReporting__AssemblyCtx____this_assemblyContextID____CallID____tGNYFelEd6zR8NNmb_sJg_;

    de.uka.ipd.sdq.sensorframework.entities.TimeSpanSensor tssCall_IReporting_getView1__Component__GraphicalReporting__AssemblyCtx____this_assemblyContextID____CallID___cwlAIFelEd6zR8NNmb_sJg_;

	
  
  de.uka.ipd.sdq.sensorframework.entities.TimeSpanSensor tssSEFF_IGraphicalReport_graphicalReport0__Component__GraphicalReporting__AssemblyCtx____this_assemblyContextID___;

  de.uka.ipd.sdq.sensorframework.entities.TimeSpanSensor tssSEFF_IGraphicalReport_viewGraphically1__Component__GraphicalReporting__AssemblyCtx____this_assemblyContextID___;


	
	de.uka.ipd.sdq.sensorframework.entities.ExperimentRun expRun;
	
	public GraphicalReporting(){

		expRun = de.uka.ipd.sdq.prototype.framework.AbstractMain.getLatestExperimentRun();
		
		

        tssCall_IReporting_getReport0__Component__GraphicalReporting__AssemblyCtx____this_assemblyContextID____CallID____tGNYFelEd6zR8NNmb_sJg_ 
            = de.uka.ipd.sdq.prototype.framework.AbstractMain.createAndAddTimeSpanSensor(
                "Call IReporting.getReport0 <Component: GraphicalReporting, AssemblyCtx: "+this.assemblyContextID+", CallID: __tGNYFelEd6zR8NNmb-sJg>"
            );



        tssCall_IReporting_getView1__Component__GraphicalReporting__AssemblyCtx____this_assemblyContextID____CallID___cwlAIFelEd6zR8NNmb_sJg_ 
            = de.uka.ipd.sdq.prototype.framework.AbstractMain.createAndAddTimeSpanSensor(
                "Call IReporting.getView1 <Component: GraphicalReporting, AssemblyCtx: "+this.assemblyContextID+", CallID: _cwlAIFelEd6zR8NNmb-sJg>"
            );


		
		
  
        tssSEFF_IGraphicalReport_graphicalReport0__Component__GraphicalReporting__AssemblyCtx____this_assemblyContextID___ 
            = de.uka.ipd.sdq.prototype.framework.AbstractMain.createAndAddTimeSpanSensor(
                "SEFF IGraphicalReport.graphicalReport0 <Component: GraphicalReporting, AssemblyCtx: "+this.assemblyContextID+">"
            );

        tssSEFF_IGraphicalReport_viewGraphically1__Component__GraphicalReporting__AssemblyCtx____this_assemblyContextID___ 
            = de.uka.ipd.sdq.prototype.framework.AbstractMain.createAndAddTimeSpanSensor(
                "SEFF IGraphicalReport.viewGraphically1 <Component: GraphicalReporting, AssemblyCtx: "+this.assemblyContextID+">"
            );


		
		//FIXME: quick fix to initialise component params as setComponentFrame is not called by system for ejbs.
		this.setComponentFrame(this.myComponentStackFrame);
		
	}


 
	      
	
    

   	
    protected brs_repository.impl.ports.IGraphicalReport_GraphicalReporting m_portProvided_IReporting_GraphicalReporting = new brs_repository.impl.ports.IGraphicalReport_GraphicalReporting(this);

   	
   public brs_repository.IGraphicalReport getPortProvided_IReporting_GraphicalReporting () {
      return m_portProvided_IReporting_GraphicalReporting;
   }


	      
   
   

   
   

   
   protected brs_repository.impl.contexts.IGraphicalReportingContext myContext = null;

   
   public void setContext(brs_repository.impl.contexts.IGraphicalReportingContext myContext) {
      this.myContext = myContext;
      
   }


	      
	
   public 
	
   de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object>

      iGraphicalReport_graphicalReport0
         (
	de.uka.ipd.sdq.simucomframework.variables.StackContext ctx
)

   { 
      /*PROTECTED REGION ID(graphicalReport0__LP3icFelEd6zR8NNmb-sJg__oHCsoFemEd6zR8NNmb-sJg) START*/
   	  
   	  	
	      
   
    

 
  
   
    // measure time for SEFF  
    
	
	// Start a response time measurement
	long startTimeSEFF_IGraphicalReport_graphicalReport0__Component__GraphicalReporting__AssemblyCtx____this_assemblyContextID___ = de.uka.ipd.sdq.prototype.framework.AbstractMain.takeStartTimeForInnerMeasurement();
	

   
  
 


	
	
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
	long startTimeCall_IReporting_getReport0__Component__GraphicalReporting__AssemblyCtx____this_assemblyContextID____CallID____tGNYFelEd6zR8NNmb_sJg_ = de.uka.ipd.sdq.prototype.framework.AbstractMain.takeStartTimeForInnerMeasurement();
	
 
			
	de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object> callResult =	


   	myContext.getRoleRequired_IReporting_GraphicalReporting().getReport0 
	   	(
	ctx
);
	
	
	// Stop the time measurement
	
		
	
	// Stop the response time measurement
	de.uka.ipd.sdq.prototype.framework.AbstractMain.takeMeasurement(startTimeCall_IReporting_getReport0__Component__GraphicalReporting__AssemblyCtx____this_assemblyContextID____CallID____tGNYFelEd6zR8NNmb_sJg_, expRun, tssCall_IReporting_getReport0__Component__GraphicalReporting__AssemblyCtx____this_assemblyContextID____CallID____tGNYFelEd6zR8NNmb_sJg_);
	

			

	 
	}
	finally
	{
		
 	ctx.getStack().removeStackFrame();

	}
	// END Simulate an external call



		    	
	}
/* ExternalCallAction - END */

   
      
   
	
	
	
   {
      double demand = (Double) ctx.evaluate("requestedEntries.VALUE * 0.6",Double.class);
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
	de.uka.ipd.sdq.prototype.framework.AbstractMain.takeMeasurement(startTimeSEFF_IGraphicalReport_graphicalReport0__Component__GraphicalReporting__AssemblyCtx____this_assemblyContextID___, expRun, tssSEFF_IGraphicalReport_graphicalReport0__Component__GraphicalReporting__AssemblyCtx____this_assemblyContextID___);
	

   
  
 


	
	
	return resultStackFrame;
	


   

   

   

   

   
      
    	
   	  
   	  /*PROTECTED REGION END*/
   }   

   public 
	
   de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object>

      iGraphicalReport_viewGraphically1
         (
	de.uka.ipd.sdq.simucomframework.variables.StackContext ctx
)

   { 
      /*PROTECTED REGION ID(viewGraphically1__LP3icFelEd6zR8NNmb-sJg__oHCsoFemEd6zR8NNmb-sJg) START*/
   	  
   	  	
	      
   
    

 
  
   
    // measure time for SEFF  
    
	
	// Start a response time measurement
	long startTimeSEFF_IGraphicalReport_viewGraphically1__Component__GraphicalReporting__AssemblyCtx____this_assemblyContextID___ = de.uka.ipd.sdq.prototype.framework.AbstractMain.takeStartTimeForInnerMeasurement();
	

   
  
 


	
	
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
	 

	
		
	
	// Start a response time measurement
	long startTimeCall_IReporting_getView1__Component__GraphicalReporting__AssemblyCtx____this_assemblyContextID____CallID___cwlAIFelEd6zR8NNmb_sJg_ = de.uka.ipd.sdq.prototype.framework.AbstractMain.takeStartTimeForInnerMeasurement();
	
 
			
	de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object> callResult =	


   	myContext.getRoleRequired_IReporting_GraphicalReporting().getView1 
	   	(
	ctx
);
	
	
	// Stop the time measurement
	
		
	
	// Stop the response time measurement
	de.uka.ipd.sdq.prototype.framework.AbstractMain.takeMeasurement(startTimeCall_IReporting_getView1__Component__GraphicalReporting__AssemblyCtx____this_assemblyContextID____CallID___cwlAIFelEd6zR8NNmb_sJg_, expRun, tssCall_IReporting_getView1__Component__GraphicalReporting__AssemblyCtx____this_assemblyContextID____CallID___cwlAIFelEd6zR8NNmb_sJg_);
	

			

	 
	}
	finally
	{
		
 	ctx.getStack().removeStackFrame();

	}
	// END Simulate an external call



		    	
	}
/* ExternalCallAction - END */

   
      
   
	
	
	
   {
      double demand = (Double) ctx.evaluate("1.2",Double.class);
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
	de.uka.ipd.sdq.prototype.framework.AbstractMain.takeMeasurement(startTimeSEFF_IGraphicalReport_viewGraphically1__Component__GraphicalReporting__AssemblyCtx____this_assemblyContextID___, expRun, tssSEFF_IGraphicalReport_viewGraphically1__Component__GraphicalReporting__AssemblyCtx____this_assemblyContextID___);
	

   
  
 


	
	
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
	   
	
	
		

		
 

	