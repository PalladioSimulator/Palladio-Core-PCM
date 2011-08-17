
	   
	

	   package brs_repository.impl;
	      
	   
public class Database

	   

	   implements brs_repository.impl.IDatabase
	   {
	   	  
    

	//TODO: pass the assembly context id to here as it is done for the simulation. 
	String assemblyContextID = ""; 
	
	
	
  
  de.uka.ipd.sdq.sensorframework.entities.TimeSpanSensor tssSEFF_IDB_getSmallReport0__Component__Database__AssemblyCtx____this_assemblyContextID___;

  de.uka.ipd.sdq.sensorframework.entities.TimeSpanSensor tssSEFF_IDB_getBigReport1__Component__Database__AssemblyCtx____this_assemblyContextID___;

  de.uka.ipd.sdq.sensorframework.entities.TimeSpanSensor tssSEFF_IDB_getCachedData2__Component__Database__AssemblyCtx____this_assemblyContextID___;


	
	de.uka.ipd.sdq.sensorframework.entities.ExperimentRun expRun;
	
	public Database(){

		expRun = de.uka.ipd.sdq.prototype.framework.AbstractMain.getLatestExperimentRun();
		
		
		
		
  
        tssSEFF_IDB_getSmallReport0__Component__Database__AssemblyCtx____this_assemblyContextID___ 
            = de.uka.ipd.sdq.prototype.framework.AbstractMain.createAndAddTimeSpanSensor(
                "SEFF IDB.getSmallReport0 <Component: Database, AssemblyCtx: "+this.assemblyContextID+">"
            );

        tssSEFF_IDB_getBigReport1__Component__Database__AssemblyCtx____this_assemblyContextID___ 
            = de.uka.ipd.sdq.prototype.framework.AbstractMain.createAndAddTimeSpanSensor(
                "SEFF IDB.getBigReport1 <Component: Database, AssemblyCtx: "+this.assemblyContextID+">"
            );

        tssSEFF_IDB_getCachedData2__Component__Database__AssemblyCtx____this_assemblyContextID___ 
            = de.uka.ipd.sdq.prototype.framework.AbstractMain.createAndAddTimeSpanSensor(
                "SEFF IDB.getCachedData2 <Component: Database, AssemblyCtx: "+this.assemblyContextID+">"
            );


		
		//FIXME: quick fix to initialise component params as setComponentFrame is not called by system for ejbs.
		this.setComponentFrame(this.myComponentStackFrame);
		
	}


 
	      
	
    

   	
    protected brs_repository.impl.ports.IDB_Database m_portProvided_IDB_DB = new brs_repository.impl.ports.IDB_Database(this);

   	
   public brs_repository.IDB getPortProvided_IDB_DB () {
      return m_portProvided_IDB_DB;
   }


	      
   
   

   
   

   
   protected brs_repository.impl.contexts.IDatabaseContext myContext = null;

   
   public void setContext(brs_repository.impl.contexts.IDatabaseContext myContext) {
      this.myContext = myContext;
      
   }


	      
	
   public 
	
   de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object>

      iDB_getSmallReport0
         (
	de.uka.ipd.sdq.simucomframework.variables.StackContext ctx
)

   { 
      /*PROTECTED REGION ID(getSmallReport0__sQC2sNo4EdyCSNQKlT1LxA__bt-WENo5EdyCSNQKlT1LxA) START*/
   	  
   	  	
	      
   
    

 
  
   
    // measure time for SEFF  
    // Start a response time measurement
	long startTimeSEFF_IDB_getSmallReport0__Component__Database__AssemblyCtx____this_assemblyContextID___ = de.uka.ipd.sdq.prototype.framework.AbstractMain.takeStartTimeForInnerMeasurement();
   
  
 


	
	
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
      double demand = (Double) ctx.evaluate("DoublePDF[(0.01;0.05)(0.02;0.05)(0.03;0.9)] + 0.0000001 * Entries.NUMBER_OF_ELEMENTS*2",Double.class);
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




   
      
   
	
	
		
			
				resultStackFrame.addValue("RETURN.INNER.BYTESIZE",
					ctx.evaluate("smallItem.BYTESIZE"));
			
		
	
		
			
				resultStackFrame.addValue("RETURN.NUMBER_OF_ELEMENTS",
					ctx.evaluate("noOfEntries.VALUE"));
			
		
	


   
      
   
	

 
  
   
    de.uka.ipd.sdq.prototype.framework.AbstractMain.takeMeasurement(
      startTimeSEFF_IDB_getSmallReport0__Component__Database__AssemblyCtx____this_assemblyContextID___,
      expRun, 
      tssSEFF_IDB_getSmallReport0__Component__Database__AssemblyCtx____this_assemblyContextID___
    );
   
  
 


	
	
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
      /*PROTECTED REGION ID(getBigReport1__sQC2sNo4EdyCSNQKlT1LxA__bt-WENo5EdyCSNQKlT1LxA) START*/
   	  
   	  	
	      
   
    

 
  
   
    // measure time for SEFF  
    // Start a response time measurement
	long startTimeSEFF_IDB_getBigReport1__Component__Database__AssemblyCtx____this_assemblyContextID___ = de.uka.ipd.sdq.prototype.framework.AbstractMain.takeStartTimeForInnerMeasurement();
   
  
 


	
	
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
      double demand = (Double) ctx.evaluate("DoublePDF[(0.2;0.1)(0.3;0.6)(0.4;0.3)] + 0.000002 * Entries.NUMBER_OF_ELEMENTS *2  ",Double.class);
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




   
      
   
	
	
		
			
				resultStackFrame.addValue("RETURN.INNER.BYTESIZE",
					ctx.evaluate("bigItem.BYTESIZE"));
			
		
	
		
			
				resultStackFrame.addValue("RETURN.NUMBER_OF_ELEMENTS",
					ctx.evaluate("noOfEntries.VALUE"));
			
		
	


   
      
   
	

 
  
   
    de.uka.ipd.sdq.prototype.framework.AbstractMain.takeMeasurement(
      startTimeSEFF_IDB_getBigReport1__Component__Database__AssemblyCtx____this_assemblyContextID___,
      expRun, 
      tssSEFF_IDB_getBigReport1__Component__Database__AssemblyCtx____this_assemblyContextID___
    );
   
  
 


	
	
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
      /*PROTECTED REGION ID(getCachedData2__sQC2sNo4EdyCSNQKlT1LxA__bt-WENo5EdyCSNQKlT1LxA) START*/
   	  
   	  	
	      
   
    

 
  
   
    // measure time for SEFF  
    // Start a response time measurement
	long startTimeSEFF_IDB_getCachedData2__Component__Database__AssemblyCtx____this_assemblyContextID___ = de.uka.ipd.sdq.prototype.framework.AbstractMain.takeStartTimeForInnerMeasurement();
   
  
 


	
	
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
      double demand = (Double) ctx.evaluate("DoublePDF[(0.01;0.2)(0.02;0.6)(0.03;0.2)]*4*2    ",Double.class);
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




   
      
   
	
	
		
			
				resultStackFrame.addValue("RETURN.BYTESIZE",
					ctx.evaluate("smallItem.BYTESIZE"));
			
		
	


   
      
   
	

 
  
   
    de.uka.ipd.sdq.prototype.framework.AbstractMain.takeMeasurement(
      startTimeSEFF_IDB_getCachedData2__Component__Database__AssemblyCtx____this_assemblyContextID___,
      expRun, 
      tssSEFF_IDB_getCachedData2__Component__Database__AssemblyCtx____this_assemblyContextID___
    );
   
  
 


	
	
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
		
			
				
					this.myDefaultComponentStackFrame.addValue("smallItem.BYTESIZE",
					   	new de.uka.ipd.sdq.simucomframework.variables.EvaluationProxy("300",
					   	new de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object>()));
				
			
				
					this.myDefaultComponentStackFrame.addValue("bigItem.BYTESIZE",
					   	new de.uka.ipd.sdq.simucomframework.variables.EvaluationProxy("1000",
					   	new de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object>()));
				
							/* added manually */
					this.myDefaultComponentStackFrame.addValue("Entries.NUMBER_OF_ELEMENTS",
						   	new de.uka.ipd.sdq.simucomframework.variables.EvaluationProxy("100000.0",
						   	new de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object>()));
	
		
	}


	   }
	   
	
	
		

		
 

	