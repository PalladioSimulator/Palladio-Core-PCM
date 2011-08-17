
	   
	

	   package brs_repository.impl;
	      
	   
public class CRESingleMessageAdapter

	   

	   implements brs_repository.impl.ICRESingleMessageAdapter
	   {
	   	  
    

	//TODO: pass the assembly context id to here as it is done for the simulation. 
	String assemblyContextID = ""; 
	
	
    de.uka.ipd.sdq.sensorframework.entities.TimeSpanSensor tssCall_IDB_getSmallReport0__Component__CRESingleMessageAdapter__AssemblyCtx____this_assemblyContextID____CallID___gypPoGo2Ed631pecjlFspw_;

    de.uka.ipd.sdq.sensorframework.entities.TimeSpanSensor tssCall_IDB_getBigReport1__Component__CRESingleMessageAdapter__AssemblyCtx____this_assemblyContextID____CallID___yjTN0Go2Ed631pecjlFspw_;

    de.uka.ipd.sdq.sensorframework.entities.TimeSpanSensor tssCall_IDB_getCachedData2__Component__CRESingleMessageAdapter__AssemblyCtx____this_assemblyContextID____CallID___6YoLUGo2Ed631pecjlFspw_;

	
  
  de.uka.ipd.sdq.sensorframework.entities.TimeSpanSensor tssSEFF_IInnerDB_getSmallReportInner0__Component__CRESingleMessageAdapter__AssemblyCtx____this_assemblyContextID___;

  de.uka.ipd.sdq.sensorframework.entities.TimeSpanSensor tssSEFF_IInnerDB_getBigReportInner1__Component__CRESingleMessageAdapter__AssemblyCtx____this_assemblyContextID___;

  de.uka.ipd.sdq.sensorframework.entities.TimeSpanSensor tssSEFF_IInnerDB_getCachedDataInner2__Component__CRESingleMessageAdapter__AssemblyCtx____this_assemblyContextID___;


	
	de.uka.ipd.sdq.sensorframework.entities.ExperimentRun expRun;
	
	public CRESingleMessageAdapter(){

		expRun = de.uka.ipd.sdq.prototype.framework.AbstractMain.getLatestExperimentRun();
		
		

        tssCall_IDB_getSmallReport0__Component__CRESingleMessageAdapter__AssemblyCtx____this_assemblyContextID____CallID___gypPoGo2Ed631pecjlFspw_ 
            = de.uka.ipd.sdq.prototype.framework.AbstractMain.createOrReuseTimeSpanSensor(
                "Call IDB.getSmallReport0 <Component: CRESingleMessageAdapter, AssemblyCtx: "+this.assemblyContextID+", CallID: _gypPoGo2Ed631pecjlFspw>"
            );



        tssCall_IDB_getBigReport1__Component__CRESingleMessageAdapter__AssemblyCtx____this_assemblyContextID____CallID___yjTN0Go2Ed631pecjlFspw_ 
            = de.uka.ipd.sdq.prototype.framework.AbstractMain.createOrReuseTimeSpanSensor(
                "Call IDB.getBigReport1 <Component: CRESingleMessageAdapter, AssemblyCtx: "+this.assemblyContextID+", CallID: _yjTN0Go2Ed631pecjlFspw>"
            );



        tssCall_IDB_getCachedData2__Component__CRESingleMessageAdapter__AssemblyCtx____this_assemblyContextID____CallID___6YoLUGo2Ed631pecjlFspw_ 
            = de.uka.ipd.sdq.prototype.framework.AbstractMain.createOrReuseTimeSpanSensor(
                "Call IDB.getCachedData2 <Component: CRESingleMessageAdapter, AssemblyCtx: "+this.assemblyContextID+", CallID: _6YoLUGo2Ed631pecjlFspw>"
            );


		
		
  
        tssSEFF_IInnerDB_getSmallReportInner0__Component__CRESingleMessageAdapter__AssemblyCtx____this_assemblyContextID___ 
            = de.uka.ipd.sdq.prototype.framework.AbstractMain.createOrReuseTimeSpanSensor(
                "SEFF IInnerDB.getSmallReportInner0 <Component: CRESingleMessageAdapter, AssemblyCtx: "+this.assemblyContextID+">"
            );

        tssSEFF_IInnerDB_getBigReportInner1__Component__CRESingleMessageAdapter__AssemblyCtx____this_assemblyContextID___ 
            = de.uka.ipd.sdq.prototype.framework.AbstractMain.createOrReuseTimeSpanSensor(
                "SEFF IInnerDB.getBigReportInner1 <Component: CRESingleMessageAdapter, AssemblyCtx: "+this.assemblyContextID+">"
            );

        tssSEFF_IInnerDB_getCachedDataInner2__Component__CRESingleMessageAdapter__AssemblyCtx____this_assemblyContextID___ 
            = de.uka.ipd.sdq.prototype.framework.AbstractMain.createOrReuseTimeSpanSensor(
                "SEFF IInnerDB.getCachedDataInner2 <Component: CRESingleMessageAdapter, AssemblyCtx: "+this.assemblyContextID+">"
            );


		
		//FIXME: quick fix to initialise component params as setComponentFrame is not called by system for ejbs.
		this.setComponentFrame(this.myComponentStackFrame);
		
	}


 
	      
	
    

   	
    protected brs_repository.impl.ports.IInnerDB_CRESingleMessageAdapter m_portProvided_IDB_CRESingleMessageAdapter = new brs_repository.impl.ports.IInnerDB_CRESingleMessageAdapter(this);

   	
   public brs_repository.IInnerDB getPortProvided_IDB_CRESingleMessageAdapter () {
      return m_portProvided_IDB_CRESingleMessageAdapter;
   }


	      
   
   

   
   

   
   protected brs_repository.impl.contexts.ICRESingleMessageAdapterContext myContext = null;

   
   public void setContext(brs_repository.impl.contexts.ICRESingleMessageAdapterContext myContext) {
      this.myContext = myContext;
      
   }


	      
	
   public 
	
   de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object>

      iInnerDB_getSmallReportInner0
         (
	de.uka.ipd.sdq.simucomframework.variables.StackContext ctx
)

   { 
      /*PROTECTED REGION ID(getSmallReportInner0__RJLAYGo2Ed631pecjlFspw__AshHQKfFEd-L5vB0MCctNg) START*/
   	  
   	  	
	      
   
    

 
  
   
    // measure time for SEFF  
    
	
	// Start a response time measurement
	long startTimeSEFF_IInnerDB_getSmallReportInner0__Component__CRESingleMessageAdapter__AssemblyCtx____this_assemblyContextID___ = de.uka.ipd.sdq.prototype.framework.AbstractMain.takeStartTimeForInnerMeasurement();
	

   
  
 


	
	
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
	


   
      
   
	
   for (int iterationCount_r8sGMGo2Ed631pecjlFspw = 0, maxIterationCount_r8sGMGo2Ed631pecjlFspw = (Integer)ctx.evaluate("noOfEntries.VALUE",Integer.class); 
            iterationCount_r8sGMGo2Ed631pecjlFspw < maxIterationCount_r8sGMGo2Ed631pecjlFspw; iterationCount_r8sGMGo2Ed631pecjlFspw++){
       
   
    


	
	


   
      
   
/* ExternalCallAction - START */
 	{ //this scope is needed if the same service is called multiple times in one SEFF. Otherwise there is a duplicate local variable definition.

		    
	
	
	
	// Start Simulate an external call
	try{
	de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object> currentFrame = ctx.getStack().currentStackFrame();
	// prepare stackframe
	de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object> stackframe = ctx.getStack().createAndPushNewStackFrame();
	
		
			
				
					stackframe.addValue("noOfEntries.VALUE",
					   	ctx.evaluate("1",currentFrame));
				
			
		
	 

	
		
	
	// Start a response time measurement
	long startTimeCall_IDB_getSmallReport0__Component__CRESingleMessageAdapter__AssemblyCtx____this_assemblyContextID____CallID___gypPoGo2Ed631pecjlFspw_ = de.uka.ipd.sdq.prototype.framework.AbstractMain.takeStartTimeForInnerMeasurement();
	
 
			
	de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object> callResult =	


   	myContext.getRoleRequired_IDB_CRESingleMessageAdapter().getSmallReport0 
	   	(
	ctx
);
	
	
	// Stop the time measurement
	
		
	
	// Stop the response time measurement
	de.uka.ipd.sdq.prototype.framework.AbstractMain.takeMeasurement(startTimeCall_IDB_getSmallReport0__Component__CRESingleMessageAdapter__AssemblyCtx____this_assemblyContextID____CallID___gypPoGo2Ed631pecjlFspw_, expRun, tssCall_IDB_getSmallReport0__Component__CRESingleMessageAdapter__AssemblyCtx____this_assemblyContextID____CallID___gypPoGo2Ed631pecjlFspw_);
	

			

	 
	}
	finally
	{
		
 	ctx.getStack().removeStackFrame();

	}
	// END Simulate an external call



		    	
	}
/* ExternalCallAction - END */

   
      
   
	


	
	


   

   

   

   } 


   
      
   
	

 
  
   
    
	
	// Stop the response time measurement
	de.uka.ipd.sdq.prototype.framework.AbstractMain.takeMeasurement(startTimeSEFF_IInnerDB_getSmallReportInner0__Component__CRESingleMessageAdapter__AssemblyCtx____this_assemblyContextID___, expRun, tssSEFF_IInnerDB_getSmallReportInner0__Component__CRESingleMessageAdapter__AssemblyCtx____this_assemblyContextID___);
	

   
  
 


	
	
	return resultStackFrame;
	


   

   

   
      
    	
   	  
   	  /*PROTECTED REGION END*/
   }   

   public 
	
   de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object>

      iInnerDB_getBigReportInner1
         (
	de.uka.ipd.sdq.simucomframework.variables.StackContext ctx
)

   { 
      /*PROTECTED REGION ID(getBigReportInner1__RJLAYGo2Ed631pecjlFspw__AshHQKfFEd-L5vB0MCctNg) START*/
   	  
   	  	
	      
   
    

 
  
   
    // measure time for SEFF  
    
	
	// Start a response time measurement
	long startTimeSEFF_IInnerDB_getBigReportInner1__Component__CRESingleMessageAdapter__AssemblyCtx____this_assemblyContextID___ = de.uka.ipd.sdq.prototype.framework.AbstractMain.takeStartTimeForInnerMeasurement();
	

   
  
 


	
	
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
	


   
      
   
	
   for (int iterationCount_xOJYwGo2Ed631pecjlFspw = 0, maxIterationCount_xOJYwGo2Ed631pecjlFspw = (Integer)ctx.evaluate("noOfEntries.VALUE",Integer.class); 
            iterationCount_xOJYwGo2Ed631pecjlFspw < maxIterationCount_xOJYwGo2Ed631pecjlFspw; iterationCount_xOJYwGo2Ed631pecjlFspw++){
       
   
    


	
	


   
      
   
/* ExternalCallAction - START */
 	{ //this scope is needed if the same service is called multiple times in one SEFF. Otherwise there is a duplicate local variable definition.

		    
	
	
	
	// Start Simulate an external call
	try{
	de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object> currentFrame = ctx.getStack().currentStackFrame();
	// prepare stackframe
	de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object> stackframe = ctx.getStack().createAndPushNewStackFrame();
	
		
			
				
					stackframe.addValue("noOfEntries.VALUE",
					   	ctx.evaluate("1",currentFrame));
				
			
		
	 

	
		
	
	// Start a response time measurement
	long startTimeCall_IDB_getBigReport1__Component__CRESingleMessageAdapter__AssemblyCtx____this_assemblyContextID____CallID___yjTN0Go2Ed631pecjlFspw_ = de.uka.ipd.sdq.prototype.framework.AbstractMain.takeStartTimeForInnerMeasurement();
	
 
			
	de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object> callResult =	


   	myContext.getRoleRequired_IDB_CRESingleMessageAdapter().getBigReport1 
	   	(
	ctx
);
	
	
	// Stop the time measurement
	
		
	
	// Stop the response time measurement
	de.uka.ipd.sdq.prototype.framework.AbstractMain.takeMeasurement(startTimeCall_IDB_getBigReport1__Component__CRESingleMessageAdapter__AssemblyCtx____this_assemblyContextID____CallID___yjTN0Go2Ed631pecjlFspw_, expRun, tssCall_IDB_getBigReport1__Component__CRESingleMessageAdapter__AssemblyCtx____this_assemblyContextID____CallID___yjTN0Go2Ed631pecjlFspw_);
	

			

	 
	}
	finally
	{
		
 	ctx.getStack().removeStackFrame();

	}
	// END Simulate an external call



		    	
	}
/* ExternalCallAction - END */

   
      
   
	


	
	


   

   

   

   } 


   
      
   
	

 
  
   
    
	
	// Stop the response time measurement
	de.uka.ipd.sdq.prototype.framework.AbstractMain.takeMeasurement(startTimeSEFF_IInnerDB_getBigReportInner1__Component__CRESingleMessageAdapter__AssemblyCtx____this_assemblyContextID___, expRun, tssSEFF_IInnerDB_getBigReportInner1__Component__CRESingleMessageAdapter__AssemblyCtx____this_assemblyContextID___);
	

   
  
 


	
	
	return resultStackFrame;
	


   

   

   
      
    	
   	  
   	  /*PROTECTED REGION END*/
   }   

   public 
	
   de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object>

      iInnerDB_getCachedDataInner2
         (
	de.uka.ipd.sdq.simucomframework.variables.StackContext ctx
)

   { 
      /*PROTECTED REGION ID(getCachedDataInner2__RJLAYGo2Ed631pecjlFspw__AshHQKfFEd-L5vB0MCctNg) START*/
   	  
   	  	
	      
   
    

 
  
   
    // measure time for SEFF  
    
	
	// Start a response time measurement
	long startTimeSEFF_IInnerDB_getCachedDataInner2__Component__CRESingleMessageAdapter__AssemblyCtx____this_assemblyContextID___ = de.uka.ipd.sdq.prototype.framework.AbstractMain.takeStartTimeForInnerMeasurement();
	

   
  
 


	
	
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
	long startTimeCall_IDB_getCachedData2__Component__CRESingleMessageAdapter__AssemblyCtx____this_assemblyContextID____CallID___6YoLUGo2Ed631pecjlFspw_ = de.uka.ipd.sdq.prototype.framework.AbstractMain.takeStartTimeForInnerMeasurement();
	
 
			
	de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object> callResult =	


   	myContext.getRoleRequired_IDB_CRESingleMessageAdapter().getCachedData2 
	   	(
	ctx
);
	
	
	// Stop the time measurement
	
		
	
	// Stop the response time measurement
	de.uka.ipd.sdq.prototype.framework.AbstractMain.takeMeasurement(startTimeCall_IDB_getCachedData2__Component__CRESingleMessageAdapter__AssemblyCtx____this_assemblyContextID____CallID___6YoLUGo2Ed631pecjlFspw_, expRun, tssCall_IDB_getCachedData2__Component__CRESingleMessageAdapter__AssemblyCtx____this_assemblyContextID____CallID___6YoLUGo2Ed631pecjlFspw_);
	

			

	 
	}
	finally
	{
		
 	ctx.getStack().removeStackFrame();

	}
	// END Simulate an external call



		    	
	}
/* ExternalCallAction - END */

   
      
   
	

 
  
   
    
	
	// Stop the response time measurement
	de.uka.ipd.sdq.prototype.framework.AbstractMain.takeMeasurement(startTimeSEFF_IInnerDB_getCachedDataInner2__Component__CRESingleMessageAdapter__AssemblyCtx____this_assemblyContextID___, expRun, tssSEFF_IInnerDB_getCachedDataInner2__Component__CRESingleMessageAdapter__AssemblyCtx____this_assemblyContextID___);
	

   
  
 


	
	
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
	   
	
	
		

		
 

	