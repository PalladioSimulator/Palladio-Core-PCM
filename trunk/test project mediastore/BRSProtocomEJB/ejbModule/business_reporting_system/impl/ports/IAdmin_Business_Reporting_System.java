
	  package business_reporting_system.impl.ports;
      
	  // Port class for IAdmin_Business_Reporting_System
	  public class IAdmin_Business_Reporting_System implements brs_repository.IAdmin
	  {
		private static org.apache.log4j.Logger logger = 
			org.apache.log4j.Logger.getLogger(IAdmin_Business_Reporting_System.class.getName());
	  
	     protected brs_repository.IAdmin myInnerPort = null;
	     
	     public IAdmin_Business_Reporting_System(brs_repository.IAdmin myInnerPort){
	        this.myInnerPort = myInnerPort;
	     }
	 	 
	 	 

    
	     
	     
   public 
   
   de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object>

   maintain0
   ( 
	de.uka.ipd.sdq.simucomframework.variables.StackContext ctx
 )
 {
   	  
   
	//logger.debug("Entering port of composed structure Business_Reporting_System");
	

	
   de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object>
 result = myInnerPort.maintain0(
	     
	ctx
);
	

	return result;


   }   

	  }

   