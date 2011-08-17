
	  package brs_repository.impl.ports;
      
	  // Port class for IBRSSystem_Scheduler
	  public class IBRSSystem_Scheduler implements brs_repository.IBRSSystem
	  {
	     protected brs_repository.impl.IScheduler myComponent = null;
	     
	     public IBRSSystem_Scheduler(){}

	     public IBRSSystem_Scheduler(brs_repository.impl.IScheduler myComponent){
	        this.myComponent = myComponent;
	     }
	     
	     


	     
   public 
   
   de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object>

   report0
   ( 
	de.uka.ipd.sdq.simucomframework.variables.StackContext ctx
 )
 {
   	  
   
	return myComponent.iBRSSystem_report0(
	     
	ctx
);


   }   

   public 
   
   de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object>

   view1
   ( 
	de.uka.ipd.sdq.simucomframework.variables.StackContext ctx
 )
 {
   	  
   
	return myComponent.iBRSSystem_view1(
	     
	ctx
);


   }   

   public 
   
   de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object>

   login2
   ( 
	de.uka.ipd.sdq.simucomframework.variables.StackContext ctx
 )
 {
   	  
   
	return myComponent.iBRSSystem_login2(
	     
	ctx
);


   }   

   public 
   
   de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object>

   logout3
   ( 
	de.uka.ipd.sdq.simucomframework.variables.StackContext ctx
 )
 {
   	  
   
	return myComponent.iBRSSystem_logout3(
	     
	ctx
);


   }   

	  }

   