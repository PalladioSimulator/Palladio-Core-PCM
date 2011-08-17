
	   
	

	   package brs_repository.impl;
	      
	   
public class InnerCoreReportingEngine

	   

	   implements brs_repository.impl.IInnerCoreReportingEngine
	   {
	   	  
 
	      
	
    

    

   	
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
	long startTimeCall_IDB_getBigReport1__Component__InnerCoreReportingEngine__AssemblyCtx____this_assemblyContextID____CallID___F113wPZqEdyw3N2eyRVO6Q_ = System.nanoTime();
	

			
	de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object> callResult =	


   	myContext.getRoleRequired_IDB_ReportingEngine().getBigReport1 
	   	(
	ctx
);
	
	
	// Stop the time measurement
	
		
	
	// Stop the response time measurement
	long endTimeCall_IDB_getBigReport1__Component__InnerCoreReportingEngine__AssemblyCtx____this_assemblyContextID____CallID___F113wPZqEdyw3N2eyRVO6Q_ = System.nanoTime();
	long resultCall_IDB_getBigReport1__Component__InnerCoreReportingEngine__AssemblyCtx____this_assemblyContextID____CallID___F113wPZqEdyw3N2eyRVO6Q_ = endTimeCall_IDB_getBigReport1__Component__InnerCoreReportingEngine__AssemblyCtx____this_assemblyContextID____CallID___F113wPZqEdyw3N2eyRVO6Q_ - startTimeCall_IDB_getBigReport1__Component__InnerCoreReportingEngine__AssemblyCtx____this_assemblyContextID____CallID___F113wPZqEdyw3N2eyRVO6Q_;
	System.out.println("Call_IDB_getBigReport1__Component__InnerCoreReportingEngine__AssemblyCtx____this_assemblyContextID____CallID___F113wPZqEdyw3N2eyRVO6Q_: "+resultCall_IDB_getBigReport1__Component__InnerCoreReportingEngine__AssemblyCtx____this_assemblyContextID____CallID___F113wPZqEdyw3N2eyRVO6Q_);
	

			

	 
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
	long endTimeCall_ICache_doCacheAccess0__Component__InnerCoreReportingEngine__AssemblyCtx____this_assemblyContextID____CallID___hxjsUNo9EdyxgfK4Hy_RFA_ = System.nanoTime();
	long resultCall_ICache_doCacheAccess0__Component__InnerCoreReportingEngine__AssemblyCtx____this_assemblyContextID____CallID___hxjsUNo9EdyxgfK4Hy_RFA_ = endTimeCall_ICache_doCacheAccess0__Component__InnerCoreReportingEngine__AssemblyCtx____this_assemblyContextID____CallID___hxjsUNo9EdyxgfK4Hy_RFA_ - startTimeCall_ICache_doCacheAccess0__Component__InnerCoreReportingEngine__AssemblyCtx____this_assemblyContextID____CallID___hxjsUNo9EdyxgfK4Hy_RFA_;
	System.out.println("Call_ICache_doCacheAccess0__Component__InnerCoreReportingEngine__AssemblyCtx____this_assemblyContextID____CallID___hxjsUNo9EdyxgfK4Hy_RFA_: "+resultCall_ICache_doCacheAccess0__Component__InnerCoreReportingEngine__AssemblyCtx____this_assemblyContextID____CallID___hxjsUNo9EdyxgfK4Hy_RFA_);
	

			

	 
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
	long startTimeCall_IDB_getSmallReport0__Component__InnerCoreReportingEngine__AssemblyCtx____this_assemblyContextID____CallID___C0EQMPZnEdySh74qedEhsw_ = System.nanoTime();
	

			
	de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object> callResult =	


   	myContext.getRoleRequired_IDB_ReportingEngine().getSmallReport0 
	   	(
	ctx
);
	
	
	// Stop the time measurement
	
		
	
	// Stop the response time measurement
	long endTimeCall_IDB_getSmallReport0__Component__InnerCoreReportingEngine__AssemblyCtx____this_assemblyContextID____CallID___C0EQMPZnEdySh74qedEhsw_ = System.nanoTime();
	long resultCall_IDB_getSmallReport0__Component__InnerCoreReportingEngine__AssemblyCtx____this_assemblyContextID____CallID___C0EQMPZnEdySh74qedEhsw_ = endTimeCall_IDB_getSmallReport0__Component__InnerCoreReportingEngine__AssemblyCtx____this_assemblyContextID____CallID___C0EQMPZnEdySh74qedEhsw_ - startTimeCall_IDB_getSmallReport0__Component__InnerCoreReportingEngine__AssemblyCtx____this_assemblyContextID____CallID___C0EQMPZnEdySh74qedEhsw_;
	System.out.println("Call_IDB_getSmallReport0__Component__InnerCoreReportingEngine__AssemblyCtx____this_assemblyContextID____CallID___C0EQMPZnEdySh74qedEhsw_: "+resultCall_IDB_getSmallReport0__Component__InnerCoreReportingEngine__AssemblyCtx____this_assemblyContextID____CallID___C0EQMPZnEdySh74qedEhsw_);
	

			

	 
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

      iReporting_getView1
         (
	de.uka.ipd.sdq.simucomframework.variables.StackContext ctx
)

   { 
      /*PROTECTED REGION ID(getView1__k7K64No4EdyCSNQKlT1LxA__Ebo4ANo5EdyCSNQKlT1LxA) START*/
   	  
   	  	
	      
   
	
	
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
	long endTimeCall_ICache_doCacheAccess0__Component__InnerCoreReportingEngine__AssemblyCtx____this_assemblyContextID____CallID___Lhg8QNo_EdyxgfK4Hy_RFA_ = System.nanoTime();
	long resultCall_ICache_doCacheAccess0__Component__InnerCoreReportingEngine__AssemblyCtx____this_assemblyContextID____CallID___Lhg8QNo_EdyxgfK4Hy_RFA_ = endTimeCall_ICache_doCacheAccess0__Component__InnerCoreReportingEngine__AssemblyCtx____this_assemblyContextID____CallID___Lhg8QNo_EdyxgfK4Hy_RFA_ - startTimeCall_ICache_doCacheAccess0__Component__InnerCoreReportingEngine__AssemblyCtx____this_assemblyContextID____CallID___Lhg8QNo_EdyxgfK4Hy_RFA_;
	System.out.println("Call_ICache_doCacheAccess0__Component__InnerCoreReportingEngine__AssemblyCtx____this_assemblyContextID____CallID___Lhg8QNo_EdyxgfK4Hy_RFA_: "+resultCall_ICache_doCacheAccess0__Component__InnerCoreReportingEngine__AssemblyCtx____this_assemblyContextID____CallID___Lhg8QNo_EdyxgfK4Hy_RFA_);
	

			

	 
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

      iReporting_prepareView2
         (
	de.uka.ipd.sdq.simucomframework.variables.StackContext ctx
)

   { 
      /*PROTECTED REGION ID(prepareView2__k7K64No4EdyCSNQKlT1LxA__Ebo4ANo5EdyCSNQKlT1LxA) START*/
   	  
   	  	
	      
   
	
	
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
	   
	
	
		

		
 

	