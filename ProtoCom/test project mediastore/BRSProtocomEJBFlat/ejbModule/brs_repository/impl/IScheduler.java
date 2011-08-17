
		package brs_repository.impl;
	      
		public interface IScheduler {
			
 

	   		
	
   de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object>

      iBRSSystem_report0
         (
	de.uka.ipd.sdq.simucomframework.variables.StackContext ctx
)
;
	
   de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object>

      iBRSSystem_view1
         (
	de.uka.ipd.sdq.simucomframework.variables.StackContext ctx
)
;
	
   de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object>

      iBRSSystem_login2
         (
	de.uka.ipd.sdq.simucomframework.variables.StackContext ctx
)
;
	
   de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object>

      iBRSSystem_logout3
         (
	de.uka.ipd.sdq.simucomframework.variables.StackContext ctx
)
;
	   		

public brs_repository.IBRSSystem getPortProvided_IBRSSystem_Scheduler ();

	   		
	   			
	   				
   public void setContext(brs_repository.impl.contexts.ISchedulerContext myContext);

	   			
            
            
	   			
	   				
	
public void setComponentFrame(de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object> myComponentStackFrame);


	   			
            
	    }
	