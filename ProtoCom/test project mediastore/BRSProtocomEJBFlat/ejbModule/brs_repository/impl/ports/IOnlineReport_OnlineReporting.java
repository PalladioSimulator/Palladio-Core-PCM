
	  package brs_repository.impl.ports;
      
	  // Port class for IOnlineReport_OnlineReporting
	  public class IOnlineReport_OnlineReporting implements brs_repository.IOnlineReport
	  {
	     protected brs_repository.impl.IOnlineReporting myComponent = null;
	     
	     public IOnlineReport_OnlineReporting(){}

	     public IOnlineReport_OnlineReporting(brs_repository.impl.IOnlineReporting myComponent){
	        this.myComponent = myComponent;
	     }
	     
	     


	     
   public 
   
   de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object>

   onlineReport0
   ( 
	de.uka.ipd.sdq.simucomframework.variables.StackContext ctx
 )
 {
   	  
   
	return myComponent.iOnlineReport_onlineReport0(
	     
	ctx
);


   }   

   public 
   
   de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object>

   viewOnline1
   ( 
	de.uka.ipd.sdq.simucomframework.variables.StackContext ctx
 )
 {
   	  
   
	return myComponent.iOnlineReport_viewOnline1(
	     
	ctx
);


   }   

	  }

   