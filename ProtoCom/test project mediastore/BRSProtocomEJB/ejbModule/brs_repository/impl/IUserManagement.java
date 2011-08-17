
		package brs_repository.impl;
	      
		public interface IUserManagement {
			
 

	   		
	
   de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object>

      iUserMgmt_userLogin0
         (
	de.uka.ipd.sdq.simucomframework.variables.StackContext ctx
)
;
	
   de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object>

      iUserMgmt_userLogout1
         (
	de.uka.ipd.sdq.simucomframework.variables.StackContext ctx
)
;
	
   de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object>

      iUserMgmt_logUserActivity2
         (
	de.uka.ipd.sdq.simucomframework.variables.StackContext ctx
)
;
	   		

public brs_repository.IUserMgmt getPortProvided_IUserMgmt_UserManagement ();

	   		
	   			
	   				
   public void setContext(brs_repository.impl.contexts.IUserManagementContext myContext);

	   			
            
            
	   			
	   				
	
public void setComponentFrame(de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object> myComponentStackFrame);


	   			
            
	    }
	