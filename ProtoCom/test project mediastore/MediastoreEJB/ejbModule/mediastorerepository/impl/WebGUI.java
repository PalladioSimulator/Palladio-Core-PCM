
	   
	

	   package mediastorerepository.impl;

     
	   
public class WebGUI

	   
	   implements mediastorerepository.impl.IWebGUI
	   {
	   	  
 
	      
	
    

   	
    protected mediastorerepository.impl.ports.IHTTP_WebGUI m_portProvided_IHTTP_WebGUI = new mediastorerepository.impl.ports.IHTTP_WebGUI(this);

   	
   public mediastorerepository.IHTTP getPortProvided_IHTTP_WebGUI () {
      return m_portProvided_IHTTP_WebGUI;
   }


	      
   
   

   
   

   
   protected mediastorerepository.impl.contexts.IWebGUIContext myContext = null;

   
   public void setContext(mediastorerepository.impl.contexts.IWebGUIContext myContext) {
      this.myContext = myContext;
      
   }


	      
	
   public 
	
   de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object>

      iHTTP_HTTPDownload0
         (
	de.uka.ipd.sdq.simucomframework.variables.StackContext ctx
)

   { 
      /*PROTECTED REGION ID(HTTPDownload0__q5WkIBpXEdyxqpPYxT_m3w__wflM0BpXEdyxqpPYxT_m3w) START*/
   	  
   	  	
	      
   
	
	
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
      double demand = (Double) ctx.evaluate("10",Double.class);
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
	
		
			
				
					stackframe.addValue("ids.NUMBER_OF_ELEMENTS",
					   	ctx.evaluate("request.requestedFiles.NUMBER_OF_ELEMENTS",currentFrame));
				
			
		
	 

	
		
	
	// Start a response time measurement
	long startTimeCall_IMediaStore_download0__Component__WebGUI__AssemblyCtx____this_assemblyContextID____CallID___A__1YEg_Ed2v5eXKEbOQ9g_ = System.nanoTime();
	

			
	de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object> callResult =	


   	myContext.getRoleRequired_IMediaStore_WebGUI().download0 
	   	(
	ctx
);
	
	
	// Stop the time measurement
	
		
	
	// Stop the response time measurement
	long endTimeCall_IMediaStore_download0__Component__WebGUI__AssemblyCtx____this_assemblyContextID____CallID___A__1YEg_Ed2v5eXKEbOQ9g_ = System.nanoTime();
	long resultCall_IMediaStore_download0__Component__WebGUI__AssemblyCtx____this_assemblyContextID____CallID___A__1YEg_Ed2v5eXKEbOQ9g_ = endTimeCall_IMediaStore_download0__Component__WebGUI__AssemblyCtx____this_assemblyContextID____CallID___A__1YEg_Ed2v5eXKEbOQ9g_ - startTimeCall_IMediaStore_download0__Component__WebGUI__AssemblyCtx____this_assemblyContextID____CallID___A__1YEg_Ed2v5eXKEbOQ9g_;
	//System.out.println("Call_IMediaStore_download0__Component__WebGUI__AssemblyCtx____this_assemblyContextID____CallID___A__1YEg_Ed2v5eXKEbOQ9g_: "+resultCall_IMediaStore_download0__Component__WebGUI__AssemblyCtx____this_assemblyContextID____CallID___A__1YEg_Ed2v5eXKEbOQ9g_);
	

			

	 
	}
	finally
	{
		
 	ctx.getStack().removeStackFrame();

	}
	// END Simulate an external call




		    	
	}
/* ExternalCallAction - END */

   
      
   
	
	
	
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




   
      
   
	
	
	return resultStackFrame;
	


   

   

   

   

   
      
    	
   	  
   	  /*PROTECTED REGION END*/
   }   

   public 
	
   de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object>

      iHTTP_HTTPUpload1
         (
	de.uka.ipd.sdq.simucomframework.variables.StackContext ctx
)

   { 
      /*PROTECTED REGION ID(HTTPUpload1__q5WkIBpXEdyxqpPYxT_m3w__wflM0BpXEdyxqpPYxT_m3w) START*/
   	  
   	  	
	      
   
	
	
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
      double demand = (Double) ctx.evaluate("10",Double.class);
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
	
		
			
				
					stackframe.addValue("file.BYTESIZE",
					   	ctx.evaluate("file.BYTESIZE",currentFrame));
				
			
				
					stackframe.addValue("file.VALUE",
					   	ctx.evaluate("file.VALUE",currentFrame));
				
			
				
					stackframe.addValue("file.TYPE",
					   	ctx.evaluate("file.TYPE",currentFrame));
				
			
		
	 

	
		
	
	// Start a response time measurement
	long startTimeCall_IMediaStore_upload1__Component__WebGUI__AssemblyCtx____this_assemblyContextID____CallID___Q8jwMEg9Ed2v5eXKEbOQ9g_ = System.nanoTime();
	

			
	de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object> callResult =	


   	myContext.getRoleRequired_IMediaStore_WebGUI().upload1 
	   	(
	ctx
);
	
	
	// Stop the time measurement
	
		
	
	// Stop the response time measurement
	long endTimeCall_IMediaStore_upload1__Component__WebGUI__AssemblyCtx____this_assemblyContextID____CallID___Q8jwMEg9Ed2v5eXKEbOQ9g_ = System.nanoTime();
	long resultCall_IMediaStore_upload1__Component__WebGUI__AssemblyCtx____this_assemblyContextID____CallID___Q8jwMEg9Ed2v5eXKEbOQ9g_ = endTimeCall_IMediaStore_upload1__Component__WebGUI__AssemblyCtx____this_assemblyContextID____CallID___Q8jwMEg9Ed2v5eXKEbOQ9g_ - startTimeCall_IMediaStore_upload1__Component__WebGUI__AssemblyCtx____this_assemblyContextID____CallID___Q8jwMEg9Ed2v5eXKEbOQ9g_;
	//System.out.println("Call_IMediaStore_upload1__Component__WebGUI__AssemblyCtx____this_assemblyContextID____CallID___Q8jwMEg9Ed2v5eXKEbOQ9g_: "+resultCall_IMediaStore_upload1__Component__WebGUI__AssemblyCtx____this_assemblyContextID____CallID___Q8jwMEg9Ed2v5eXKEbOQ9g_);
	

			

	 
	}
	finally
	{
		
 	ctx.getStack().removeStackFrame();

	}
	// END Simulate an external call




		    	
	}
/* ExternalCallAction - END */

   
      
   
	
	
	
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
	   
	
	
		

		
 

	