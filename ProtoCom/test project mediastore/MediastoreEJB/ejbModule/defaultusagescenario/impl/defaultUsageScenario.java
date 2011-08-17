
		package defaultusagescenario.impl;

import javax.ejb.EJB;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class defaultUsageScenario implements java.lang.Runnable
		{
			
   @EJB protected mediastorerepository.IHTTP m_portProvided_IHTTP;


			public defaultUsageScenario()  {
				

				try {
					//get the default JNDI initial context
					Context context = new InitialContext();
					//get the bussiness interface
					Object obj=context.lookup(mediastorerepository.IHTTP.class.getName());
					//convert obj
					m_portProvided_IHTTP = (mediastorerepository.IHTTP)obj;
				} catch (NamingException e) {
					e.printStackTrace();
				}

				//Initialise Protocom environmnt
				//TODO: Move this someplace else as soon as ejbs are distributed
				
				// Create 1 System(s)
				defaultsystem.impl.defaultSystem mydefaultSystem = new defaultsystem.impl.defaultSystem();
				defaultsystem.impl.contexts.defaultSystemContext contextdefaultSystem = 
					new defaultsystem.impl.contexts.defaultSystemContext();
				mydefaultSystem.setContext(contextdefaultSystem);
				
				ctx.getStack().createAndPushNewStackFrame();
				//StoExCache.initialiseStoExCache(new de.uka.ipd.sdq.probfunction.math.impl.DefaultRandomGenerator());
				//new de.uka.ipd.sdq.simucomframework.SimuComDefaultRandomNumberGenerator(null);
				de.uka.ipd.sdq.simucomframework.variables.cache.StoExCache.initialiseStoExCache(new de.uka.ipd.sdq.probfunction.math.impl.DefaultRandomGenerator());
			}
			
			
	private de.uka.ipd.sdq.simucomframework.variables.StackContext ctx = new de.uka.ipd.sdq.simucomframework.variables.StackContext();
	
	@org.junit.Test public void scenarioRunner() {
	/*PROTECTED REGION ID(_TyV-MVBwEd6ActLj8Gdl_A) ENABLED START*/
		
	
	// Start a response time measurement
	long startTimedefaultUsageScenario = System.nanoTime();
	

		{
			
   

   
      
   
	
	{
		
			double u_cwT_wFBwEd6ActLj8Gdl_A = Math.random();
			double sum_cwT_wFBwEd6ActLj8Gdl_A = 0;
			
	if (sum_cwT_wFBwEd6ActLj8Gdl_A <= u_cwT_wFBwEd6ActLj8Gdl_A && u_cwT_wFBwEd6ActLj8Gdl_A < sum_cwT_wFBwEd6ActLj8Gdl_A + 0.2 )
	{
		
   

   
      
   
    
	
	
	
	// Start Simulate an external call
	try{
	de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object> currentFrame = ctx.getStack().currentStackFrame();
	// prepare stackframe
	de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object> stackframe = ctx.getStack().createAndPushNewStackFrame();
	
		
			
				
					stackframe.addValue("file.BYTESIZE",
					   	ctx.evaluate("IntPMF[ (500000;0.0) (1000000;0.051) (2000000;0.134) (3000000;0.193) (4000000;0.212) (5000000;0.224) (6000000;0.186) ]",currentFrame));
				
			
				
					stackframe.addValue("file.VALUE",
					   	ctx.evaluate("IntPMF[ (64;0.1) (128;0.5) (192;0.2) (320;0.2) ]",currentFrame));
				
			
				
					stackframe.addValue("file.TYPE",
					   	ctx.evaluate("EnumPMF[ (\"constant\";0.3) (\"variable\";0.7) ]",currentFrame));
				
			
		
	 

	
		
	
	// Start a response time measurement
	long startTimeCall_HTTPUpload1 = System.nanoTime();
	

			
	de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object> callResult =	


   	m_portProvided_IHTTP.HTTPUpload1 
	   	(
	ctx
);
	
	
	// Stop the time measurement
	
		
	
	// Stop the response time measurement
	long endTimeCall_HTTPUpload1 = System.nanoTime();
	long resultCall_HTTPUpload1 = endTimeCall_HTTPUpload1 - startTimeCall_HTTPUpload1;
	System.out.println("Call_HTTPUpload1: "+resultCall_HTTPUpload1);
	

			

	 
	}
	finally
	{
		
 	ctx.getStack().removeStackFrame();

	}
	// END Simulate an external call





   
      
   

   

   

   

	}
	sum_cwT_wFBwEd6ActLj8Gdl_A += 0.2;

	if (sum_cwT_wFBwEd6ActLj8Gdl_A <= u_cwT_wFBwEd6ActLj8Gdl_A && u_cwT_wFBwEd6ActLj8Gdl_A < sum_cwT_wFBwEd6ActLj8Gdl_A + 0.8 )
	{
		
   

   
      
   
    
	
	
	
	// Start Simulate an external call
	try{
	de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object> currentFrame = ctx.getStack().currentStackFrame();
	// prepare stackframe
	de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object> stackframe = ctx.getStack().createAndPushNewStackFrame();
	
		
			
				
					stackframe.addValue("request.requestedFiles.NUMBER_OF_ELEMENTS",
					   	ctx.evaluate("IntPMF[ (2;0.2) (5;0.2) (8;0.3) (11;0.3) ]",currentFrame));
				
			
		
	 

	
		
	
	// Start a response time measurement
	long startTimeCall_HTTPDownload0 = System.nanoTime();
	

			
	de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object> callResult =	


   	m_portProvided_IHTTP.HTTPDownload0 
	   	(
	ctx
);
	
	
	// Stop the time measurement
	
		
	
	// Stop the response time measurement
	long endTimeCall_HTTPDownload0 = System.nanoTime();
	long resultCall_HTTPDownload0 = endTimeCall_HTTPDownload0 - startTimeCall_HTTPDownload0;
	System.out.println("Call_HTTPDownload0: "+resultCall_HTTPDownload0);
	

	// Stop a response time measurement
	long stopTimedefaultUsageScenario = System.nanoTime();	
	long resultdefaultUsageScenario = stopTimedefaultUsageScenario - startTimedefaultUsageScenario;
	System.out.println("UsageScenario: "+resultdefaultUsageScenario);

	 
	} catch (Exception e){
		e.printStackTrace();
	}
	finally
	{
		
 	ctx.getStack().removeStackFrame();

	}
	// END Simulate an external call





   
      
   

   

   

   

	}
	sum_cwT_wFBwEd6ActLj8Gdl_A += 0.8;

		
	}


   
      
   

   

   

   

		}
		
	
	// Stop the response time measurement
	long endTimedefaultUsageScenario = System.nanoTime();
	long resultdefaultUsageScenario = endTimedefaultUsageScenario - startTimedefaultUsageScenario;
	//System.out.println("defaultUsageScenario: "+resultdefaultUsageScenario);
	

	/*PROTECTED REGION END*/
	}


			
			public void run() {
				scenarioRunner();
			}
		}
	