
	  package brs_repository.impl.ports;
      
	  // Port class for IReporting_CoreGraphicEngine
	  public class IReporting_CoreGraphicEngine implements brs_repository.IReporting
	  {
		private static org.apache.log4j.Logger logger = 
			org.apache.log4j.Logger.getLogger(IReporting_CoreGraphicEngine.class.getName());
	  
	     protected brs_repository.IReporting myInnerPort = null;
	     
	     public IReporting_CoreGraphicEngine(brs_repository.IReporting myInnerPort){
	        this.myInnerPort = myInnerPort;
	     }
	 	 
	 	 

    
	     
	     
   public 
   
   de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object>

   getReport0
   ( 
	de.uka.ipd.sdq.simucomframework.variables.StackContext ctx
 )
 {
   	  
   
	//logger.debug("Entering port of composed structure CoreGraphicEngine");
	

	
   de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object>
 result = myInnerPort.getReport0(
	     
	ctx
);
	

	return result;


   }   

   public 
   
   de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object>

   getView1
   ( 
	de.uka.ipd.sdq.simucomframework.variables.StackContext ctx
 )
 {
   	  
   
	//logger.debug("Entering port of composed structure CoreGraphicEngine");
	

	
   de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object>
 result = myInnerPort.getView1(
	     
	ctx
);
	

	return result;


   }   

   public 
   
   de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object>

   prepareView2
   ( 
	de.uka.ipd.sdq.simucomframework.variables.StackContext ctx
 )
 {
   	  
   
	//logger.debug("Entering port of composed structure CoreGraphicEngine");
	

	
   de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object>
 result = myInnerPort.prepareView2(
	     
	ctx
);
	

	return result;


   }   

   public 
   
   de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object>

   finishView3
   ( 
	de.uka.ipd.sdq.simucomframework.variables.StackContext ctx
 )
 {
   	  
   
	//logger.debug("Entering port of composed structure CoreGraphicEngine");
	

	
   de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object>
 result = myInnerPort.finishView3(
	     
	ctx
);
	

	return result;


   }   

	  }

   