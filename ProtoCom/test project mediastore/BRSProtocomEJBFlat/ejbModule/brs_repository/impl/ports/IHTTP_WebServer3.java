
	  package brs_repository.impl.ports;
      
	  // Port class for IHTTP_WebServer3
	  public class IHTTP_WebServer3 implements brs_repository.IHTTP
	  {
	     protected brs_repository.impl.IWebServer3 myComponent = null;
	     
	     public IHTTP_WebServer3(){}

	     public IHTTP_WebServer3(brs_repository.impl.IWebServer3 myComponent){
	        this.myComponent = myComponent;
	     }
	     
	     


	     
   public 
   
   de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object>

   processLoginLogout0
   ( 
	de.uka.ipd.sdq.simucomframework.variables.StackContext ctx
 )
 {
   	  
   
	return myComponent.iHTTP_processLoginLogout0(
	     
	ctx
);


   }   

   public 
   
   de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object>

   processGraphicalReport1
   ( 
	de.uka.ipd.sdq.simucomframework.variables.StackContext ctx
 )
 {
   	  
   
	return myComponent.iHTTP_processGraphicalReport1(
	     
	ctx
);


   }   

   public 
   
   de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object>

   processOnlineReport2
   ( 
	de.uka.ipd.sdq.simucomframework.variables.StackContext ctx
 )
 {
   	  
   
	return myComponent.iHTTP_processOnlineReport2(
	     
	ctx
);


   }   

   public 
   
   de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object>

   processGraphicalView3
   ( 
	de.uka.ipd.sdq.simucomframework.variables.StackContext ctx
 )
 {
   	  
   
	return myComponent.iHTTP_processGraphicalView3(
	     
	ctx
);


   }   

   public 
   
   de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object>

   processOnlineView4
   ( 
	de.uka.ipd.sdq.simucomframework.variables.StackContext ctx
 )
 {
   	  
   
	return myComponent.iHTTP_processOnlineView4(
	     
	ctx
);


   }   

	  }

   