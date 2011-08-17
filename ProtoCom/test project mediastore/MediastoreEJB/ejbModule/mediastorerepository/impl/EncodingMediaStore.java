
	   
	

	   package mediastorerepository.impl;
	      
	   
public class EncodingMediaStore

	   

	   implements mediastorerepository.impl.IEncodingMediaStore
	   {
	   	  
 
	      
	
    

   	
    protected mediastorerepository.impl.ports.IMediaStore_EncodingMediaStore m_portIMediaStore_Prov = new mediastorerepository.impl.ports.IMediaStore_EncodingMediaStore(this);

   	
   public mediastorerepository.IMediaStore getPortIMediaStore_Prov () {
      return m_portIMediaStore_Prov;
   }


	      
   
   

   
   

   
   protected mediastorerepository.impl.contexts.IEncodingMediaStoreContext myContext = null;

   
   public void setContext(mediastorerepository.impl.contexts.IEncodingMediaStoreContext myContext) {
      this.myContext = myContext;
      
   }


	      
	
   public 
	
   de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object>

      iMediaStore_download0
         (
	de.uka.ipd.sdq.simucomframework.variables.StackContext ctx
)

   { 
      /*PROTECTED REGION ID(download0__CERy4BwqEdyg5YJN38bxwQ__xSi60BpXEdyxqpPYxT_m3w) START*/
   	  
   	  	
	      
   
	
	
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
	
		
			
				
					stackframe.addValue("ids.NUMBER_OF_ELEMENTS",
					   	ctx.evaluate("ids.NUMBER_OF_ELEMENTS",currentFrame));
				
			
		
	 

	
		
	
	// Start a response time measurement
	long startTimeCall_IAudioDB_queryDB0__Component__EncodingMediaStore__AssemblyCtx____this_assemblyContextID____CallID___SQRWUFNrEd2DAaYH_ZsiCA_ = System.nanoTime();
	

			
	de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object> callResult =	


   	myContext.getRoleIAudioDB_Req().queryDB0 
	   	(
	ctx
);
	
	
	// Stop the time measurement
	
		
	
	// Stop the response time measurement
	long endTimeCall_IAudioDB_queryDB0__Component__EncodingMediaStore__AssemblyCtx____this_assemblyContextID____CallID___SQRWUFNrEd2DAaYH_ZsiCA_ = System.nanoTime();
	long resultCall_IAudioDB_queryDB0__Component__EncodingMediaStore__AssemblyCtx____this_assemblyContextID____CallID___SQRWUFNrEd2DAaYH_ZsiCA_ = endTimeCall_IAudioDB_queryDB0__Component__EncodingMediaStore__AssemblyCtx____this_assemblyContextID____CallID___SQRWUFNrEd2DAaYH_ZsiCA_ - startTimeCall_IAudioDB_queryDB0__Component__EncodingMediaStore__AssemblyCtx____this_assemblyContextID____CallID___SQRWUFNrEd2DAaYH_ZsiCA_;
	//System.out.println("Call_IAudioDB_queryDB0__Component__EncodingMediaStore__AssemblyCtx____this_assemblyContextID____CallID___SQRWUFNrEd2DAaYH_ZsiCA_: "+resultCall_IAudioDB_queryDB0__Component__EncodingMediaStore__AssemblyCtx____this_assemblyContextID____CallID___SQRWUFNrEd2DAaYH_ZsiCA_);
	

			

	
		
			// Copy out parameter fileSize to local stack frame
			
				
					methodBodyStackFrame.addValue("fileSize.BYTESIZE",
					   	ctx.evaluate("RETURN.INNER.BYTESIZE",callResult));
				
			
		
	
		
			// Copy out parameter fileList to local stack frame
			
				
					methodBodyStackFrame.addValue("fileList.NUMBER_OF_ELEMENTS",
					   	ctx.evaluate("RETURN.NUMBER_OF_ELEMENTS",callResult));
				
			
		
	 
	}
	finally
	{
		
 	ctx.getStack().removeStackFrame();

	}
	// END Simulate an external call




		    	
	}
/* ExternalCallAction - END */

   
      
   
	
   for (int iterationCount_V2fPEFNrEd2DAaYH_ZsiCA = 0, maxIterationCount_V2fPEFNrEd2DAaYH_ZsiCA = (Integer)ctx.evaluate("fileList.NUMBER_OF_ELEMENTS",Integer.class); 
            iterationCount_V2fPEFNrEd2DAaYH_ZsiCA < maxIterationCount_V2fPEFNrEd2DAaYH_ZsiCA; iterationCount_V2fPEFNrEd2DAaYH_ZsiCA++){
       
   
	
	


   
      
   
/* ExternalCallAction - START */
 	{ //this scope is needed if the same service is called multiple times in one SEFF. Otherwise there is a duplicate local variable definition.

		    
	
	
	
	// Start Simulate an external call
	try{
	de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object> currentFrame = ctx.getStack().currentStackFrame();
	// prepare stackframe
	de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object> stackframe = ctx.getStack().createAndPushNewStackFrame();
	
		
			
				
					stackframe.addValue("file.BYTESIZE",
					   	ctx.evaluate("fileSize.BYTESIZE",currentFrame));
				
			
		
	 

	
		
	
	// Start a response time measurement
	long startTimeCall_ISound_watermark0__Component__EncodingMediaStore__AssemblyCtx____this_assemblyContextID____CallID___XxbRwFNrEd2DAaYH_ZsiCA_ = System.nanoTime();
	

			
	de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object> callResult =	


   	myContext.getRoleRequired_ISound_EncodingMediaStore().watermark0 
	   	(
	ctx
);
	
	
	// Stop the time measurement
	
		
	
	// Stop the response time measurement
	long endTimeCall_ISound_watermark0__Component__EncodingMediaStore__AssemblyCtx____this_assemblyContextID____CallID___XxbRwFNrEd2DAaYH_ZsiCA_ = System.nanoTime();
	long resultCall_ISound_watermark0__Component__EncodingMediaStore__AssemblyCtx____this_assemblyContextID____CallID___XxbRwFNrEd2DAaYH_ZsiCA_ = endTimeCall_ISound_watermark0__Component__EncodingMediaStore__AssemblyCtx____this_assemblyContextID____CallID___XxbRwFNrEd2DAaYH_ZsiCA_ - startTimeCall_ISound_watermark0__Component__EncodingMediaStore__AssemblyCtx____this_assemblyContextID____CallID___XxbRwFNrEd2DAaYH_ZsiCA_;
	//System.out.println("Call_ISound_watermark0__Component__EncodingMediaStore__AssemblyCtx____this_assemblyContextID____CallID___XxbRwFNrEd2DAaYH_ZsiCA_: "+resultCall_ISound_watermark0__Component__EncodingMediaStore__AssemblyCtx____this_assemblyContextID____CallID___XxbRwFNrEd2DAaYH_ZsiCA_);
	

			

	 
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

      iMediaStore_upload1
         (
	de.uka.ipd.sdq.simucomframework.variables.StackContext ctx
)

   { 
      /*PROTECTED REGION ID(upload1__CERy4BwqEdyg5YJN38bxwQ__xSi60BpXEdyxqpPYxT_m3w) START*/
   	  
   	  	
	      
   
	
	
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
	
		
			
				
					stackframe.addValue("file.BYTESIZE",
					   	ctx.evaluate("file.BYTESIZE",currentFrame));
				
			
				
					stackframe.addValue("file.VALUE",
					   	ctx.evaluate("file.VALUE",currentFrame));
				
			
				
					stackframe.addValue("file.TYPE",
					   	ctx.evaluate("file.TYPE",currentFrame));
				
			
		
	 

	
		
	
	// Start a response time measurement
	long startTimeCall_IEncode_encode0__Component__EncodingMediaStore__AssemblyCtx____this_assemblyContextID____CallID___JafXgFNiEd2DAaYH_ZsiCA_ = System.nanoTime();
	

			
	de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object> callResult =	


   	myContext.getRoleIEncode_Req().encode0 
	   	(
	ctx
);
	
	
	// Stop the time measurement
	
		
	
	// Stop the response time measurement
	long endTimeCall_IEncode_encode0__Component__EncodingMediaStore__AssemblyCtx____this_assemblyContextID____CallID___JafXgFNiEd2DAaYH_ZsiCA_ = System.nanoTime();
	long resultCall_IEncode_encode0__Component__EncodingMediaStore__AssemblyCtx____this_assemblyContextID____CallID___JafXgFNiEd2DAaYH_ZsiCA_ = endTimeCall_IEncode_encode0__Component__EncodingMediaStore__AssemblyCtx____this_assemblyContextID____CallID___JafXgFNiEd2DAaYH_ZsiCA_ - startTimeCall_IEncode_encode0__Component__EncodingMediaStore__AssemblyCtx____this_assemblyContextID____CallID___JafXgFNiEd2DAaYH_ZsiCA_;
	//System.out.println("Call_IEncode_encode0__Component__EncodingMediaStore__AssemblyCtx____this_assemblyContextID____CallID___JafXgFNiEd2DAaYH_ZsiCA_: "+resultCall_IEncode_encode0__Component__EncodingMediaStore__AssemblyCtx____this_assemblyContextID____CallID___JafXgFNiEd2DAaYH_ZsiCA_);
	

			

	
		
			// Copy out parameter fileSize to local stack frame
			
				
					methodBodyStackFrame.addValue("fileSize.BYTESIZE",
					   	ctx.evaluate("RETURN.BYTESIZE",callResult));
				
			
				
					methodBodyStackFrame.addValue("fileSize.VALUE",
					   	ctx.evaluate("RETURN.VALUE",callResult));
				
			
		
	 
	}
	finally
	{
		
 	ctx.getStack().removeStackFrame();

	}
	// END Simulate an external call




		    	
	}
/* ExternalCallAction - END */

   
      
   
/* ExternalCallAction - START */
 	{ //this scope is needed if the same service is called multiple times in one SEFF. Otherwise there is a duplicate local variable definition.

		    
	
	
	
	// Start Simulate an external call
	try{
	de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object> currentFrame = ctx.getStack().currentStackFrame();
	// prepare stackframe
	de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object> stackframe = ctx.getStack().createAndPushNewStackFrame();
	
		
			
				
					stackframe.addValue("file.BYTESIZE",
					   	ctx.evaluate("fileSize.BYTESIZE",currentFrame));
				
			
		
	 

	
		
	
	// Start a response time measurement
	long startTimeCall_IAudioDB_addFile1__Component__EncodingMediaStore__AssemblyCtx____this_assemblyContextID____CallID___KDUSEFNiEd2DAaYH_ZsiCA_ = System.nanoTime();
	

			
	de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object> callResult =	


   	myContext.getRoleIAudioDB_Req().addFile1 
	   	(
	ctx
);
	
	
	// Stop the time measurement
	
		
	
	// Stop the response time measurement
	long endTimeCall_IAudioDB_addFile1__Component__EncodingMediaStore__AssemblyCtx____this_assemblyContextID____CallID___KDUSEFNiEd2DAaYH_ZsiCA_ = System.nanoTime();
	long resultCall_IAudioDB_addFile1__Component__EncodingMediaStore__AssemblyCtx____this_assemblyContextID____CallID___KDUSEFNiEd2DAaYH_ZsiCA_ = endTimeCall_IAudioDB_addFile1__Component__EncodingMediaStore__AssemblyCtx____this_assemblyContextID____CallID___KDUSEFNiEd2DAaYH_ZsiCA_ - startTimeCall_IAudioDB_addFile1__Component__EncodingMediaStore__AssemblyCtx____this_assemblyContextID____CallID___KDUSEFNiEd2DAaYH_ZsiCA_;
	//System.out.println("Call_IAudioDB_addFile1__Component__EncodingMediaStore__AssemblyCtx____this_assemblyContextID____CallID___KDUSEFNiEd2DAaYH_ZsiCA_: "+resultCall_IAudioDB_addFile1__Component__EncodingMediaStore__AssemblyCtx____this_assemblyContextID____CallID___KDUSEFNiEd2DAaYH_ZsiCA_);
	

			

	 
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
	   
	
	
		

		
 

	