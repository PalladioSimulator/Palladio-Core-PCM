
		package defaultusagescenario.impl;

import de.uka.ipd.sdq.sensorframework.entities.ExperimentRun;
import de.uka.ipd.sdq.sensorframework.entities.TimeSpanSensor;
		public class defaultUsageScenario implements java.lang.Runnable
		{
			
   protected defaultrepository.One m_portProvided_One = null;


	public defaultUsageScenario() {
		try{
		    javax.naming.Context context = new javax.naming.InitialContext();
	    
	    
/*			    javax.naming.InitialContext initial;
        try {
            initial = new javax.naming.InitialContext();
            javax.naming.Context context = (javax.naming.Context) initial.lookup("java:comp/env");
*/		        
            
/*m_portProvided_One = (defaultrepository.One)
javax.rmi.PortableRemoteObject.narrow(
	context.lookup("ejb/One"),defaultrepository.One.class);
*/

{
//get the business interface
Object obj=context.lookup(defaultrepository.One.class.getName());
//convert obj
m_portProvided_One = (defaultrepository.One)obj;
}


		} catch (javax.naming.NamingException e) {
            e.printStackTrace();
        }
		
		expRun = de.uka.ipd.sdq.prototype.framework.AbstractMain.getLatestExperimentRun();
		
		

		tssCall_serviceOne0__EntryLevelSystemCall_id___TorZMDgmEeCFP6TiQB0B7A__ 
            = de.uka.ipd.sdq.prototype.framework.AbstractMain.createAndAddTimeSpanSensor(
                "Call One.serviceOne0 <Component: CompOne, AssemblyCtx: , CallID: _qQ5YsDglEeCFP6TiQB0B7A>"
            );


		
		
  
		tssdefaultUsageScenario 
            = de.uka.ipd.sdq.prototype.framework.AbstractMain.createAndAddTimeSpanSensor(
                "usage scenario"
            );
		
		ctx.getStack().createAndPushNewStackFrame();
		de.uka.ipd.sdq.simucomframework.variables.cache.StoExCache
				.initialiseStoExCache(new de.uka.ipd.sdq.probfunction.math.impl.DefaultRandomGenerator());
		                
	}
			
			
	private de.uka.ipd.sdq.simucomframework.variables.StackContext ctx = new de.uka.ipd.sdq.simucomframework.variables.StackContext();
	private ExperimentRun expRun;
	private TimeSpanSensor tssCall_serviceOne0__EntryLevelSystemCall_id___TorZMDgmEeCFP6TiQB0B7A__;
	private TimeSpanSensor tssdefaultUsageScenario;
	
	@org.junit.Test public void scenarioRunner() {
	/*PROTECTED REGION ID(_R6jDcDgmEeCFP6TiQB0B7A) ENABLED START*/
		
	
	// Start a response time measurement
	long startTimedefaultUsageScenario 
	    = de.uka.ipd.sdq.prototype.framework.AbstractMain.takeStartTimeForInnerMeasurement();
	

		{
			
   

   
      
   
    
	
	
	
	// Start Simulate an external call
	try{
	de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object> currentFrame = ctx.getStack().currentStackFrame();
	// prepare stackframe
	de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object> stackframe = ctx.getStack().createAndPushNewStackFrame();
	 

	
		
	
	// Start a response time measurement
	long startTimeCall_serviceOne0__EntryLevelSystemCall_id___TorZMDgmEeCFP6TiQB0B7A__ 
	    = de.uka.ipd.sdq.prototype.framework.AbstractMain.takeStartTimeForInnerMeasurement();
	

			
	de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object> callResult =	


   	m_portProvided_One.serviceOne0 
	   	(
	ctx
);
	
	
	// Stop the time measurement
	
		
	
	// Stop the response time measurement
	de.uka.ipd.sdq.prototype.framework.AbstractMain.takeMeasurement(startTimeCall_serviceOne0__EntryLevelSystemCall_id___TorZMDgmEeCFP6TiQB0B7A__, expRun, tssCall_serviceOne0__EntryLevelSystemCall_id___TorZMDgmEeCFP6TiQB0B7A__);
	

			

	 
	}
	finally
	{
		
 	ctx.getStack().removeStackFrame();

	}
	// END Simulate an external call




   
      
   

   

   

   

		}
		
	
	// Stop the response time measurement
	de.uka.ipd.sdq.prototype.framework.AbstractMain.takeMeasurement(startTimedefaultUsageScenario, expRun, tssdefaultUsageScenario);
	

	/*PROTECTED REGION END*/
	}


			
			public void run() {
				scenarioRunner();
			}
		}
	