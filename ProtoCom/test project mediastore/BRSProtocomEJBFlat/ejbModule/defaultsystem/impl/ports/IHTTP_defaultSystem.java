
	  package defaultsystem.impl.ports;
      
	  // Port class for IHTTP_defaultSystem
	  public class IHTTP_defaultSystem implements brs_repository.IHTTP
	  {
		private static org.apache.log4j.Logger logger = 
			org.apache.log4j.Logger.getLogger(IHTTP_defaultSystem.class.getName());
	  
	     protected brs_repository.IHTTP myInnerPort = null;
	     
	     public IHTTP_defaultSystem(brs_repository.IHTTP myInnerPort){
	        this.myInnerPort = myInnerPort;
	     }
	 	 
	 	 

    
	     
	     
   public 
   
   de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object>

   processLoginLogout0
   ( 
	de.uka.ipd.sdq.simucomframework.variables.StackContext ctx
 )
 {
   	  
   
	//logger.debug("Entering port of composed structure defaultSystem");
	

	
   de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object>
 result = myInnerPort.processLoginLogout0(
	     
	ctx
);
	

	return result;


   }   

   public 
   
   de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object>

   processGraphicalReport1
   ( 
	de.uka.ipd.sdq.simucomframework.variables.StackContext ctx
 )
 {
   	  
   
	//logger.debug("Entering port of composed structure defaultSystem");
	

	
   de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object>
 result = myInnerPort.processGraphicalReport1(
	     
	ctx
);
	

	return result;


   }   

   public 
   
   de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object>

   processOnlineReport2
   ( 
	de.uka.ipd.sdq.simucomframework.variables.StackContext ctx
 )
 {
   	  
   
	//logger.debug("Entering port of composed structure defaultSystem");
	

	
   de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object>
 result = myInnerPort.processOnlineReport2(
	     
	ctx
);
	

	return result;


   }   

   public 
   
   de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object>

   processGraphicalView3
   ( 
	de.uka.ipd.sdq.simucomframework.variables.StackContext ctx
 )
 {
   	  
   
	//logger.debug("Entering port of composed structure defaultSystem");
	

	
   de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object>
 result = myInnerPort.processGraphicalView3(
	     
	ctx
);
	

	return result;


   }   

   public 
   
   de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object>

   processOnlineView4
   ( 
	de.uka.ipd.sdq.simucomframework.variables.StackContext ctx
 )
 {
   	  
   
	//logger.debug("Entering port of composed structure defaultSystem");
	

	
   de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object>
 result = myInnerPort.processOnlineView4(
	     
	ctx
);
	

	return result;


   }   

	  }

   