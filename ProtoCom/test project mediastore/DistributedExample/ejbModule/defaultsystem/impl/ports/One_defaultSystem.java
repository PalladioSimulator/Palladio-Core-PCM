
	  package defaultsystem.impl.ports;
      
	  // Port class for One_defaultSystem
	  public class One_defaultSystem implements defaultrepository.One
	  {
		private static org.apache.log4j.Logger logger = 
			org.apache.log4j.Logger.getLogger(One_defaultSystem.class.getName());
	  
	     protected defaultrepository.One myInnerPort = null;
	     
	     public One_defaultSystem(defaultrepository.One myInnerPort){
	        this.myInnerPort = myInnerPort;
	     }
	 	 
	 	 

    
	     
	     
   public 
   
   de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object>

   serviceOne0
   ( 
	de.uka.ipd.sdq.simucomframework.variables.StackContext ctx
 )
 {
   	  
   
	//logger.debug("Entering port of composed structure defaultSystem");
	

	
   de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object>
 result = myInnerPort.serviceOne0(
	     
	ctx
);
	

	return result;


   }   

	  }

   