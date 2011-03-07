
	  package defaultsystem.impl.ports;
      
	  // Port class for IHTTP_defaultSystem
	  public class IHTTP_defaultSystem implements mediastorerepository.IHTTP
	  {
		private static org.apache.log4j.Logger logger = 
			org.apache.log4j.Logger.getLogger(IHTTP_defaultSystem.class.getName());
	  
	     protected mediastorerepository.IHTTP myInnerPort = null;
	     
	     public IHTTP_defaultSystem(mediastorerepository.IHTTP myInnerPort){
	        this.myInnerPort = myInnerPort;
	     }
	 	 
	 	 

    
	     
	     
   public 
   
   de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object>

   HTTPDownload0
   ( 
	de.uka.ipd.sdq.simucomframework.variables.StackContext ctx
 )
 {
   	  
   
	//logger.debug("Entering port of composed structure defaultSystem");
	

	
   de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object>
 result = myInnerPort.HTTPDownload0(
	     
	ctx
);
	

	return result;


   }   

   public 
   
   de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object>

   HTTPUpload1
   ( 
	de.uka.ipd.sdq.simucomframework.variables.StackContext ctx
 )
 {
   	  
   
	//logger.debug("Entering port of composed structure defaultSystem");
	

	
   de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object>
 result = myInnerPort.HTTPUpload1(
	     
	ctx
);
	

	return result;


   }   

	  }

   