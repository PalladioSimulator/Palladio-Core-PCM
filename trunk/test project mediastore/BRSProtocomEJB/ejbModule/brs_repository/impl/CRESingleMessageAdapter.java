
	   
	

	   package brs_repository.impl;
	      
	   
public class CRESingleMessageAdapter

	   

	   implements brs_repository.impl.ICRESingleMessageAdapter
	   {
	   	  
 
	      
	
    

   	
    protected brs_repository.impl.ports.IDB_CRESingleMessageAdapter m_portProvided_IDB_CRESingleMessageAdapter = new brs_repository.impl.ports.IDB_CRESingleMessageAdapter(this);

   	
   public brs_repository.IDB getPortProvided_IDB_CRESingleMessageAdapter () {
      return m_portProvided_IDB_CRESingleMessageAdapter;
   }


	      
   
   

   
   

   
   protected brs_repository.impl.contexts.ICRESingleMessageAdapterContext myContext = null;

   
   public void setContext(brs_repository.impl.contexts.ICRESingleMessageAdapterContext myContext) {
      this.myContext = myContext;
      
   }


	      
	
   public 
	
   de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object>

      iDB_getSmallReport0
         (
	de.uka.ipd.sdq.simucomframework.variables.StackContext ctx
)

   { 
      /*PROTECTED REGION ID(getSmallReport0__RJLAYGo2Ed631pecjlFspw__bt-WENo5EdyCSNQKlT1LxA) START*/
   	  
   	  	
	      
   
	
	
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
	long startTimeCall_IDB_getSmallReport0__Component__CRESingleMessageAdapter__AssemblyCtx____this_assemblyContextID____CallID___gypPoGo2Ed631pecjlFspw_ = System.nanoTime();
	

			
	de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object> callResult =	


   	myContext.getRoleRequired_IDB_CRESingleMessageAdapter().getSmallReport0 
	   	(
	ctx
);
	
	
	// Stop the time measurement
	
		
	
	// Stop the response time measurement
	long endTimeCall_IDB_getSmallReport0__Component__CRESingleMessageAdapter__AssemblyCtx____this_assemblyContextID____CallID___gypPoGo2Ed631pecjlFspw_ = System.nanoTime();
	long resultCall_IDB_getSmallReport0__Component__CRESingleMessageAdapter__AssemblyCtx____this_assemblyContextID____CallID___gypPoGo2Ed631pecjlFspw_ = endTimeCall_IDB_getSmallReport0__Component__CRESingleMessageAdapter__AssemblyCtx____this_assemblyContextID____CallID___gypPoGo2Ed631pecjlFspw_ - startTimeCall_IDB_getSmallReport0__Component__CRESingleMessageAdapter__AssemblyCtx____this_assemblyContextID____CallID___gypPoGo2Ed631pecjlFspw_;
	System.out.println("Call_IDB_getSmallReport0__Component__CRESingleMessageAdapter__AssemblyCtx____this_assemblyContextID____CallID___gypPoGo2Ed631pecjlFspw_: "+resultCall_IDB_getSmallReport0__Component__CRESingleMessageAdapter__AssemblyCtx____this_assemblyContextID____CallID___gypPoGo2Ed631pecjlFspw_);
	

			

	 
	}
	finally
	{
		
 	ctx.getStack().removeStackFrame();

	}
	// END Simulate an external call




		    	
	}
/* ExternalCallAction - END */

   
      
   
	
	


   

   

   

   } 


   
      
   
	
	
	return resultStackFrame;
	


   

   

   
      
    	
   	  
   	  /*PROTECTED REGION END*/
   }   

   public 
	
   de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object>

      iDB_getBigReport1
         (
	de.uka.ipd.sdq.simucomframework.variables.StackContext ctx
)

   { 
      /*PROTECTED REGION ID(getBigReport1__RJLAYGo2Ed631pecjlFspw__bt-WENo5EdyCSNQKlT1LxA) START*/
   	  
   	  	
	      
   
	
	
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
	long startTimeCall_IDB_getBigReport1__Component__CRESingleMessageAdapter__AssemblyCtx____this_assemblyContextID____CallID___yjTN0Go2Ed631pecjlFspw_ = System.nanoTime();
	

			
	de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object> callResult =	


   	myContext.getRoleRequired_IDB_CRESingleMessageAdapter().getBigReport1 
	   	(
	ctx
);
	
	
	// Stop the time measurement
	
		
	
	// Stop the response time measurement
	long endTimeCall_IDB_getBigReport1__Component__CRESingleMessageAdapter__AssemblyCtx____this_assemblyContextID____CallID___yjTN0Go2Ed631pecjlFspw_ = System.nanoTime();
	long resultCall_IDB_getBigReport1__Component__CRESingleMessageAdapter__AssemblyCtx____this_assemblyContextID____CallID___yjTN0Go2Ed631pecjlFspw_ = endTimeCall_IDB_getBigReport1__Component__CRESingleMessageAdapter__AssemblyCtx____this_assemblyContextID____CallID___yjTN0Go2Ed631pecjlFspw_ - startTimeCall_IDB_getBigReport1__Component__CRESingleMessageAdapter__AssemblyCtx____this_assemblyContextID____CallID___yjTN0Go2Ed631pecjlFspw_;
	System.out.println("Call_IDB_getBigReport1__Component__CRESingleMessageAdapter__AssemblyCtx____this_assemblyContextID____CallID___yjTN0Go2Ed631pecjlFspw_: "+resultCall_IDB_getBigReport1__Component__CRESingleMessageAdapter__AssemblyCtx____this_assemblyContextID____CallID___yjTN0Go2Ed631pecjlFspw_);
	

			

	 
	}
	finally
	{
		
 	ctx.getStack().removeStackFrame();

	}
	// END Simulate an external call




		    	
	}
/* ExternalCallAction - END */

   
      
   
	
	


   

   

   

   } 


   
      
   
	
	
	return resultStackFrame;
	


   

   

   
      
    	
   	  
   	  /*PROTECTED REGION END*/
   }   

   public 
	
   de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object>

      iDB_getCachedData2
         (
	de.uka.ipd.sdq.simucomframework.variables.StackContext ctx
)

   { 
      /*PROTECTED REGION ID(getCachedData2__RJLAYGo2Ed631pecjlFspw__bt-WENo5EdyCSNQKlT1LxA) START*/
   	  
   	  	
	      
   
	
	
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
	long startTimeCall_IDB_getCachedData2__Component__CRESingleMessageAdapter__AssemblyCtx____this_assemblyContextID____CallID___6YoLUGo2Ed631pecjlFspw_ = System.nanoTime();
	

			
	de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object> callResult =	


   	myContext.getRoleRequired_IDB_CRESingleMessageAdapter().getCachedData2 
	   	(
	ctx
);
	
	
	// Stop the time measurement
	
		
	
	// Stop the response time measurement
	long endTimeCall_IDB_getCachedData2__Component__CRESingleMessageAdapter__AssemblyCtx____this_assemblyContextID____CallID___6YoLUGo2Ed631pecjlFspw_ = System.nanoTime();
	long resultCall_IDB_getCachedData2__Component__CRESingleMessageAdapter__AssemblyCtx____this_assemblyContextID____CallID___6YoLUGo2Ed631pecjlFspw_ = endTimeCall_IDB_getCachedData2__Component__CRESingleMessageAdapter__AssemblyCtx____this_assemblyContextID____CallID___6YoLUGo2Ed631pecjlFspw_ - startTimeCall_IDB_getCachedData2__Component__CRESingleMessageAdapter__AssemblyCtx____this_assemblyContextID____CallID___6YoLUGo2Ed631pecjlFspw_;
	System.out.println("Call_IDB_getCachedData2__Component__CRESingleMessageAdapter__AssemblyCtx____this_assemblyContextID____CallID___6YoLUGo2Ed631pecjlFspw_: "+resultCall_IDB_getCachedData2__Component__CRESingleMessageAdapter__AssemblyCtx____this_assemblyContextID____CallID___6YoLUGo2Ed631pecjlFspw_);
	

			

	 
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
	   
	
	
		

		
 

	