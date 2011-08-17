
	   
	

	   package brs_repository.impl;
	      
	   
public class IAdminStub

	   

	   implements brs_repository.impl.IIAdminStub
	   {
	   	  
    

	//TODO: pass the assembly context id to here as it is done for the simulation. 
	String assemblyContextID = ""; 
	
	
    de.uka.ipd.sdq.sensorframework.entities.TimeSpanSensor tssCall_IAdmin_maintain0__Component__IAdminStub__AssemblyCtx____this_assemblyContextID____CallID___Fj8fp1E_EeCAJIcLKkksgA_;

	
  
  de.uka.ipd.sdq.sensorframework.entities.TimeSpanSensor tssSEFF_IAdmin_maintain0__Component__IAdminStub__AssemblyCtx____this_assemblyContextID___;


	
	de.uka.ipd.sdq.sensorframework.entities.ExperimentRun expRun;
	
	public IAdminStub(){

		expRun = de.uka.ipd.sdq.prototype.framework.AbstractMain.getLatestExperimentRun();
		
		

        tssCall_IAdmin_maintain0__Component__IAdminStub__AssemblyCtx____this_assemblyContextID____CallID___Fj8fp1E_EeCAJIcLKkksgA_ 
            = de.uka.ipd.sdq.prototype.framework.AbstractMain.createOrReuseTimeSpanSensor(
                "Call IAdmin.maintain0 <Component: IAdminStub, AssemblyCtx: "+this.assemblyContextID+", CallID: _Fj8fp1E_EeCAJIcLKkksgA>"
            );


		
		
  
        tssSEFF_IAdmin_maintain0__Component__IAdminStub__AssemblyCtx____this_assemblyContextID___ 
            = de.uka.ipd.sdq.prototype.framework.AbstractMain.createOrReuseTimeSpanSensor(
                "SEFF IAdmin.maintain0 <Component: IAdminStub, AssemblyCtx: "+this.assemblyContextID+">"
            );


		
		//FIXME: quick fix to initialise component params as setComponentFrame is not called by system for ejbs.
		this.setComponentFrame(this.myComponentStackFrame);
		
	}


 
	      
	
    

   	
    protected brs_repository.impl.ports.IAdmin_IAdminStub m_portaName = new brs_repository.impl.ports.IAdmin_IAdminStub(this);

   	
   public brs_repository.IAdmin getPortaName () {
      return m_portaName;
   }


	      
   
   

   
   

   
   protected brs_repository.impl.contexts.IIAdminStubContext myContext = null;

   
   public void setContext(brs_repository.impl.contexts.IIAdminStubContext myContext) {
      this.myContext = myContext;
      
   }


	      
	
   public 
	
   de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object>

      iAdmin_maintain0
         (
	de.uka.ipd.sdq.simucomframework.variables.StackContext ctx
)

   { 
      /*PROTECTED REGION ID(maintain0__-anFcFE-EeCAJIcLKkksgA__MeXLUFekEd6zR8NNmb-sJg) START*/
   	  
   	  	
	      
   
    

 
  
   
    // measure time for SEFF  
    
	
	// Start a response time measurement
	long startTimeSEFF_IAdmin_maintain0__Component__IAdminStub__AssemblyCtx____this_assemblyContextID___ 
	    = de.uka.ipd.sdq.prototype.framework.AbstractMain.takeStartTimeForInnerMeasurement();
	

   
  
 


	
	
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
	long startTimeCall_IAdmin_maintain0__Component__IAdminStub__AssemblyCtx____this_assemblyContextID____CallID___Fj8fp1E_EeCAJIcLKkksgA_ 
	    = de.uka.ipd.sdq.prototype.framework.AbstractMain.takeStartTimeForInnerMeasurement();
	
 
			
	de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object> callResult =	


   	myContext.getRolereq_IAdmin_Stub().maintain0 
	   	(
	ctx
);
	
	
	// Stop the time measurement
	
		
	
	// Stop the response time measurement
	de.uka.ipd.sdq.prototype.framework.AbstractMain.takeMeasurement(startTimeCall_IAdmin_maintain0__Component__IAdminStub__AssemblyCtx____this_assemblyContextID____CallID___Fj8fp1E_EeCAJIcLKkksgA_, expRun, tssCall_IAdmin_maintain0__Component__IAdminStub__AssemblyCtx____this_assemblyContextID____CallID___Fj8fp1E_EeCAJIcLKkksgA_);
	

			

	 
	}
	finally
	{
		
 	ctx.getStack().removeStackFrame();

	}
	// END Simulate an external call



		    	
	}
/* ExternalCallAction - END */

   
      
   
	

 
  
   
    
	
	// Stop the response time measurement
	de.uka.ipd.sdq.prototype.framework.AbstractMain.takeMeasurement(startTimeSEFF_IAdmin_maintain0__Component__IAdminStub__AssemblyCtx____this_assemblyContextID___, expRun, tssSEFF_IAdmin_maintain0__Component__IAdminStub__AssemblyCtx____this_assemblyContextID___);
	

   
  
 


	
	
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
	   
	
	
		

		
 

	