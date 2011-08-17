
	  package defaultsystem.impl.ports;
      
	  // Port class for IAdmin_defaultSystem
	  public class IAdmin_defaultSystem implements brs_repository.IAdmin
	  {
		private static org.apache.log4j.Logger logger = 
			org.apache.log4j.Logger.getLogger(IAdmin_defaultSystem.class.getName());
	  
	     protected brs_repository.IAdmin myInnerPort = null;
	     
	     public IAdmin_defaultSystem(brs_repository.IAdmin myInnerPort){
	        this.myInnerPort = myInnerPort;
	     }
	 	 
	 	 

    
	     
	     
   public 
   
   de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object>

   maintain0
   ( 
	de.uka.ipd.sdq.simucomframework.variables.StackContext ctx
 )
 {
   	  
   
	//logger.debug("Entering port of composed structure defaultSystem");
	

	
   de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object>
 result = myInnerPort.maintain0(
	     
	ctx
);
	

	return result;


   }   

	  }

   